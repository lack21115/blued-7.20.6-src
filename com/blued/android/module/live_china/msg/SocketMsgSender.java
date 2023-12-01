package com.blued.android.module.live_china.msg;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveZanExtraModel;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/SocketMsgSender.class */
public class SocketMsgSender extends ILiveMsgSender {
    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a() {
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a(long j) {
        ChatManager.getInstance().initLiveChatInfo(LiveRoomManager.a().j(), j, true);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a(String str, boolean z, LiveZanExtraModel.EmojiModel emojiModel, SendMsgListener sendMsgListener) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a(short s, long j, LiveChatInfoListener liveChatInfoListener) {
        ChatManager.getInstance().registerLiveChatListener(s, j, liveChatInfoListener);
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a(boolean z) {
        LiveRoomInfo.a().a(f(), false);
        if (z) {
            d();
        }
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void b() {
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void b(short s, long j, LiveChatInfoListener liveChatInfoListener) {
        ChatManager.getInstance().unregisterLiveChatListener(s, j, liveChatInfoListener);
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void c() {
    }

    public void d() {
        LiveRoomInfo.a().a(g(), false);
    }
}
