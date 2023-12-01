package com.blued.android.module.im.grpc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.blued.android.module.im.IMConfig;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.util.Logger;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.android.statistics.util.Utils;
import com.blued.das.apm.ApmProtos;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/GrpcUnaryCall.class */
public abstract class GrpcUnaryCall {
    protected ChannelManager a;
    protected IMThreadManager b;
    private final ApmArguments c;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/GrpcUnaryCall$ApmArguments.class */
    public static class ApmArguments {
        public ApmProtos.GrpcRequestTypeProto.BUSINESS a = ApmProtos.GrpcRequestTypeProto.BUSINESS.PRIVATE_CHAT;
        public String b = "";
        public String c = "";
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/GrpcUnaryCall$OnFinishListener.class */
    public interface OnFinishListener {
        void onFinish(GeneratedMessageV3 generatedMessageV3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/GrpcUnaryCall$SendMessageRunnable.class */
    public class SendMessageRunnable extends NamedRunnable {
        private final AtomicBoolean b;
        private final AtomicLong c;
        private final OnFinishListener d;
        private final GeneratedMessageV3 e;
        private final ClientCall.Listener<GeneratedMessageV3> f;

        public SendMessageRunnable(GeneratedMessageV3 generatedMessageV3, OnFinishListener onFinishListener) {
            super(GrpcUnaryCall.this.c());
            this.b = new AtomicBoolean(false);
            this.c = new AtomicLong();
            this.f = new ClientCall.Listener<GeneratedMessageV3>() { // from class: com.blued.android.module.im.grpc.GrpcUnaryCall.SendMessageRunnable.1
                /* renamed from: a */
                public void onMessage(final GeneratedMessageV3 generatedMessageV32) {
                    if (IMConfig.b()) {
                        IMConfig.a().d(" << onMessage @", Thread.currentThread().getName(), " : ", generatedMessageV32);
                    }
                    SendMessageRunnable.this.b.set(true);
                    Utils.a(new Runnable() { // from class: com.blued.android.module.im.grpc.GrpcUnaryCall.SendMessageRunnable.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SendMessageRunnable.this.a(200, null);
                            if (SendMessageRunnable.this.d != null) {
                                SendMessageRunnable.this.d.onFinish(generatedMessageV32);
                            }
                        }
                    });
                }

                public void onClose(final Status status, Metadata metadata) {
                    if (IMConfig.b()) {
                        IMConfig.a().e(" << onClose : @", Thread.currentThread().getName(), " ", status == null ? "status is null!" : status.toString(), "\n", metadata == null ? "trailers is null!" : metadata.toString());
                    }
                    if (SendMessageRunnable.this.b.get()) {
                        return;
                    }
                    Utils.a(new Runnable() { // from class: com.blued.android.module.im.grpc.GrpcUnaryCall.SendMessageRunnable.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Status status2 = status;
                            if (status2 != null) {
                                StatusException asException = status2.asException();
                                SendMessageRunnable.this.a(status.getCode().value(), asException);
                            }
                            if (SendMessageRunnable.this.d != null) {
                                SendMessageRunnable.this.d.onFinish(null);
                            }
                        }
                    });
                }
            };
            this.e = generatedMessageV3;
            this.d = onFinishListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Exception exc) {
            BluedStatistics.b().a(GrpcUnaryCall.this.b().a, GrpcUnaryCall.this.b().b, i, SystemClock.uptimeMillis() - this.c.get(), GrpcUnaryCall.this.b().c, exc, GrpcUnaryCall.this.a.a(), GrpcUnaryCall.this.a.b());
        }

        @Override // com.blued.android.statistics.util.NamedRunnable
        public void a() {
            if (IMConfig.b()) {
                Logger a = IMConfig.a();
                a.b(">> SendMessageRunnable Request : " + this.e.toString());
            }
            this.c.set(SystemClock.uptimeMillis());
            try {
                ClientCall newCall = GrpcUnaryCall.this.a.d().newCall(GrpcUnaryCall.this.a(), CallOptions.DEFAULT.withDeadlineAfter(30L, TimeUnit.SECONDS));
                newCall.start(this.f, GrpcUnaryCall.this.a.f());
                newCall.sendMessage(this.e);
                newCall.halfClose();
                newCall.request(1);
            } catch (Exception e) {
                a(100, e);
                if (IMConfig.b()) {
                    IMConfig.a().d(">> SendMessageRunnable Exception : \n", e);
                }
            }
        }
    }

    public GrpcUnaryCall(ChannelManager channelManager, IMThreadManager iMThreadManager) {
        this.c = new ApmArguments();
        this.a = channelManager;
        this.b = iMThreadManager;
    }

    public GrpcUnaryCall(ChannelManager channelManager, IMThreadManager iMThreadManager, boolean z) {
        ApmArguments apmArguments = new ApmArguments();
        this.c = apmArguments;
        this.a = channelManager;
        this.b = iMThreadManager;
        apmArguments.a = z ? ApmProtos.GrpcRequestTypeProto.BUSINESS.GROUP_CHAT : ApmProtos.GrpcRequestTypeProto.BUSINESS.PRIVATE_CHAT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        String str = this.c.b;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = this.c.a.name();
        }
        return str2;
    }

    protected abstract MethodDescriptor a();

    public void a(GeneratedMessageV3 generatedMessageV3, OnFinishListener onFinishListener) {
        IMThreadManager iMThreadManager;
        if (this.a == null || (iMThreadManager = this.b) == null) {
            return;
        }
        try {
            iMThreadManager.a(new SendMessageRunnable(generatedMessageV3, onFinishListener));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ApmArguments b() {
        return this.c;
    }
}
