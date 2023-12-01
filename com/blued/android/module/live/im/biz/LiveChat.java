package com.blued.android.module.live.im.biz;

import android.os.SystemClock;
import cn.irisgw.live.LiveChatGrpc;
import cn.irisgw.live.LiveChatOuterClass;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.module.live.im.LiveIM;
import com.blued.android.module.live.im.LiveIMConfig;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.apm.ApmProtos;
import java.util.concurrent.TimeUnit;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/biz/LiveChat.class */
public final class LiveChat {

    /* renamed from: a  reason: collision with root package name */
    private ChannelManager f11585a;
    private IMThreadManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/biz/LiveChat$SendLikeRunnable.class */
    public class SendLikeRunnable extends NamedRunnable {
        private LiveChatOuterClass.LiveLikeRequest b;

        /* renamed from: c  reason: collision with root package name */
        private LiveIM.OnSendLikeFinishListener f11587c;

        public SendLikeRunnable(LiveChatOuterClass.LiveLikeRequest liveLikeRequest, LiveIM.OnSendLikeFinishListener onSendLikeFinishListener) {
            super(LiveIMConfig.a("send-like"));
            this.b = liveLikeRequest;
            this.f11587c = onSendLikeFinishListener;
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
        @Override // com.blued.android.statistics.util.NamedRunnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 325
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live.im.biz.LiveChat.SendLikeRunnable.a():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/biz/LiveChat$SendMessageRunnable.class */
    public class SendMessageRunnable extends NamedRunnable {
        private LiveChatOuterClass.LiveMsgRequest b;

        /* renamed from: c  reason: collision with root package name */
        private LiveIM.OnSendMessageFinishListener f11589c;

        public SendMessageRunnable(LiveChatOuterClass.LiveMsgRequest liveMsgRequest, LiveIM.OnSendMessageFinishListener onSendMessageFinishListener) {
            super(LiveIMConfig.a("send-message"));
            this.b = liveMsgRequest;
            this.f11589c = onSendMessageFinishListener;
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x016b  */
        @Override // com.blued.android.statistics.util.NamedRunnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 390
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live.im.biz.LiveChat.SendMessageRunnable.a():void");
        }
    }

    public LiveChat(ChannelManager channelManager, IMThreadManager iMThreadManager) {
        this.f11585a = channelManager;
        this.b = iMThreadManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LiveChatGrpc.LiveChatBlockingStub a() {
        return (LiveChatGrpc.LiveChatBlockingStub) ((LiveChatGrpc.LiveChatBlockingStub) ((LiveChatGrpc.LiveChatBlockingStub) this.f11585a.a((ChannelManager) LiveChatGrpc.newBlockingStub(this.f11585a.d()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, int i, long j2, Exception exc) {
        long uptimeMillis = SystemClock.uptimeMillis() - j;
        BluedStatistics.b().a(ApmProtos.GrpcRequestTypeProto.BUSINESS.LIVE_CHAT, str, i, uptimeMillis, j2 == 0 ? "" : String.valueOf(j2), exc, this.f11585a.a(), this.f11585a.b());
        if (LiveIMConfig.b()) {
            LiveIMConfig.a().a(">>send spendTime=", Long.valueOf(uptimeMillis));
        }
    }

    public void a(LiveChatOuterClass.LiveLikeRequest liveLikeRequest, LiveIM.OnSendLikeFinishListener onSendLikeFinishListener) {
        IMThreadManager iMThreadManager;
        if (this.f11585a == null || (iMThreadManager = this.b) == null || liveLikeRequest == null) {
            return;
        }
        iMThreadManager.a(new SendLikeRunnable(liveLikeRequest, onSendLikeFinishListener));
    }

    public void a(LiveChatOuterClass.LiveMsgRequest liveMsgRequest, LiveIM.OnSendMessageFinishListener onSendMessageFinishListener) {
        IMThreadManager iMThreadManager;
        if (this.f11585a == null || (iMThreadManager = this.b) == null || liveMsgRequest == null) {
            return;
        }
        iMThreadManager.a(new SendMessageRunnable(liveMsgRequest, onSendMessageFinishListener));
    }
}
