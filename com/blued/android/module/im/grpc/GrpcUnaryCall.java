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

    /* renamed from: a  reason: collision with root package name */
    protected ChannelManager f11361a;
    protected IMThreadManager b;

    /* renamed from: c  reason: collision with root package name */
    private final ApmArguments f11362c;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/GrpcUnaryCall$ApmArguments.class */
    public static class ApmArguments {

        /* renamed from: a  reason: collision with root package name */
        public ApmProtos.GrpcRequestTypeProto.BUSINESS f11363a = ApmProtos.GrpcRequestTypeProto.BUSINESS.PRIVATE_CHAT;
        public String b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f11364c = "";
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/GrpcUnaryCall$OnFinishListener.class */
    public interface OnFinishListener {
        void onFinish(GeneratedMessageV3 generatedMessageV3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/GrpcUnaryCall$SendMessageRunnable.class */
    public class SendMessageRunnable extends NamedRunnable {
        private final AtomicBoolean b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicLong f11366c;
        private final OnFinishListener d;
        private final GeneratedMessageV3 e;
        private final ClientCall.Listener<GeneratedMessageV3> f;

        public SendMessageRunnable(GeneratedMessageV3 generatedMessageV3, OnFinishListener onFinishListener) {
            super(GrpcUnaryCall.this.c());
            this.b = new AtomicBoolean(false);
            this.f11366c = new AtomicLong();
            this.f = new ClientCall.Listener<GeneratedMessageV3>() { // from class: com.blued.android.module.im.grpc.GrpcUnaryCall.SendMessageRunnable.1
                @Override // io.grpc.ClientCall.Listener
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

                @Override // io.grpc.ClientCall.Listener
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
            BluedStatistics.b().a(GrpcUnaryCall.this.b().f11363a, GrpcUnaryCall.this.b().b, i, SystemClock.uptimeMillis() - this.f11366c.get(), GrpcUnaryCall.this.b().f11364c, exc, GrpcUnaryCall.this.f11361a.a(), GrpcUnaryCall.this.f11361a.b());
        }

        @Override // com.blued.android.statistics.util.NamedRunnable
        public void a() {
            if (IMConfig.b()) {
                Logger a2 = IMConfig.a();
                a2.b(">> SendMessageRunnable Request : " + this.e.toString());
            }
            this.f11366c.set(SystemClock.uptimeMillis());
            try {
                ClientCall newCall = GrpcUnaryCall.this.f11361a.d().newCall(GrpcUnaryCall.this.a(), CallOptions.DEFAULT.withDeadlineAfter(30L, TimeUnit.SECONDS));
                newCall.start(this.f, GrpcUnaryCall.this.f11361a.f());
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
        this.f11362c = new ApmArguments();
        this.f11361a = channelManager;
        this.b = iMThreadManager;
    }

    public GrpcUnaryCall(ChannelManager channelManager, IMThreadManager iMThreadManager, boolean z) {
        ApmArguments apmArguments = new ApmArguments();
        this.f11362c = apmArguments;
        this.f11361a = channelManager;
        this.b = iMThreadManager;
        apmArguments.f11363a = z ? ApmProtos.GrpcRequestTypeProto.BUSINESS.GROUP_CHAT : ApmProtos.GrpcRequestTypeProto.BUSINESS.PRIVATE_CHAT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        String str = this.f11362c.b;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = this.f11362c.f11363a.name();
        }
        return str2;
    }

    protected abstract MethodDescriptor a();

    public void a(GeneratedMessageV3 generatedMessageV3, OnFinishListener onFinishListener) {
        IMThreadManager iMThreadManager;
        if (this.f11361a == null || (iMThreadManager = this.b) == null) {
            return;
        }
        try {
            iMThreadManager.a(new SendMessageRunnable(generatedMessageV3, onFinishListener));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ApmArguments b() {
        return this.f11362c;
    }
}
