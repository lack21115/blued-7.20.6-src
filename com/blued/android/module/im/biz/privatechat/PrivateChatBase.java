package com.blued.android.module.im.biz.privatechat;

import com.blued.android.module.im.biz.Common;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.apm.ApmProtos;
import com.blued.im.private_chat.MsgTypeOuterClass;
import com.blued.im.private_chat.PrivateChatOuterClass;
import com.google.protobuf.Any;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/privatechat/PrivateChatBase.class */
public abstract class PrivateChatBase {

    /* renamed from: a  reason: collision with root package name */
    protected ChannelManager f11340a;
    protected IMThreadManager b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/privatechat/PrivateChatBase$SendMessageRunnable.class */
    class SendMessageRunnable extends NamedRunnable {
        private PrivateChatOuterClass.Request b;

        /* renamed from: c  reason: collision with root package name */
        private OnPrivateChatResponseListener f11342c;

        public SendMessageRunnable(PrivateChatOuterClass.Request request, OnPrivateChatResponseListener onPrivateChatResponseListener) {
            super("private-chat");
            this.b = request;
            this.f11342c = onPrivateChatResponseListener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 14, insn: 0x02f2: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:86:0x02f2 */
        /* JADX WARN: Removed duplicated region for block: B:102:0x0392  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0399  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x03d0  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x030a  */
        @Override // com.blued.android.statistics.util.NamedRunnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 1002
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.im.biz.privatechat.PrivateChatBase.SendMessageRunnable.a():void");
        }
    }

    public PrivateChatBase(ChannelManager channelManager, IMThreadManager iMThreadManager) {
        this.f11340a = channelManager;
        this.b = iMThreadManager;
    }

    protected abstract ApmProtos.GrpcRequestTypeProto.BUSINESS a();

    protected abstract PrivateChatOuterClass.Response a(PrivateChatOuterClass.Request request);

    public void a(int i, int i2, int i3, int i4, Any any, OnPrivateChatResponseListener onPrivateChatResponseListener) {
        if (this.f11340a == null || this.b == null) {
            return;
        }
        try {
            this.b.a(new SendMessageRunnable(PrivateChatOuterClass.Request.newBuilder().setCommon(Common.a().b()).setTo(i3).setFrom(i4).setMsgType(MsgTypeOuterClass.MsgType.forNumber(i)).setLocalId(i2).setBody(any).build(), onPrivateChatResponseListener));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
