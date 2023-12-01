package com.blued.android.module.live_china.msg;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.anythink.core.common.g.g;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/ILiveMsgSender.class */
public abstract class ILiveMsgSender {
    private void b(LiveGiftModel liveGiftModel) {
        if (liveGiftModel == null || liveGiftModel.selectNumModel == null || TextUtils.isEmpty(liveGiftModel.selectNumModel.gift_pic_mp4)) {
            return;
        }
        liveGiftModel.images_mp4 = liveGiftModel.selectNumModel.gift_pic_mp4;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void c(LiveChattingModel liveChattingModel) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static SessionProfileModel e() {
        SessionProfileModel sessionProfileModel = new SessionProfileModel();
        sessionProfileModel.nickname = LiveRoomInfo.a().c();
        sessionProfileModel.avatar = LiveRoomInfo.a().d();
        sessionProfileModel.vBadge = LiveRoomInfo.a().u();
        return sessionProfileModel;
    }

    public LiveChattingModel a(int i) {
        return a(i, "");
    }

    public LiveChattingModel a(int i, String str) {
        return a(i, str, "");
    }

    public LiveChattingModel a(int i, String str, String str2) {
        return a(LiveRoomManager.a().d(), LiveRoomManager.a().j(), i, str, str2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public LiveChattingModel a(long j, short s, int i, String str, String str2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public abstract void a();

    public abstract void a(long j);

    public void a(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SessionProfileModel sessionProfileModel = new SessionProfileModel();
        sessionProfileModel.nickname = str;
        LiveChattingModel copy = LiveChattingModel.copy(ChatHelper.getChattingModelForSendmsg(LiveRoomManager.a().d(), (short) 232, AppInfo.d().getString(R.string.live_kick_user), sessionProfileModel, "", LiveRoomManager.a().j()));
        copy.fromId = j;
        copy.fromNickName = str;
        a(copy);
    }

    public void a(ProfileData profileData) {
        if (profileData == null) {
            return;
        }
        LiveChattingModel a = a(109, "解禁");
        ArrayMap arrayMap = new ArrayMap();
        MsgPackHelper.putMapValue((Map<String, Object>) arrayMap, "uid", profileData.uid);
        MsgPackHelper.putMapValue((Map<String, Object>) arrayMap, "name", profileData.name);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("mute_profile", arrayMap);
        a.fromRichLevel = LiveRoomInfo.a().r();
        if (LiveFloatManager.a().w()) {
            a.fromLiveManager = 1;
        }
        a.msgMapExtra = arrayMap2;
        a(a);
        LogUtils.a("聊天场控解禁");
    }

    public void a(LiveChattingModel liveChattingModel) {
        a(liveChattingModel, true);
    }

    public void a(LiveChattingModel liveChattingModel, boolean z) {
        if (liveChattingModel == null) {
            return;
        }
        if (z) {
            c(liveChattingModel);
        }
        LiveEventBusUtil.a(liveChattingModel);
    }

    public void a(LiveGiftModel liveGiftModel) {
        LiveChattingModel a = a(33, "LiveGift");
        a.fromId = LiveRoomInfo.a().g();
        a.msgMapExtra = new HashMap();
        b(liveGiftModel);
        liveGiftModel.extraModel = LiveRoomManager.a().M();
        a.msgMapExtra.put("gift_model", liveGiftModel);
        a.fromRichLevel = LiveRoomInfo.a().r();
        a(a);
    }

    public void a(String str) {
        a(a(1, str));
    }

    public abstract void a(String str, boolean z, LiveZanExtraModel.EmojiModel emojiModel, SendMsgListener sendMsgListener);

    public abstract void a(short s, long j, LiveChatInfoListener liveChatInfoListener);

    public abstract void a(boolean z);

    public abstract void b();

    public void b(int i, String str) {
        a(a((int) ((short) i), str));
    }

    public void b(ProfileData profileData) {
        if (profileData == null) {
            return;
        }
        LiveChattingModel a = a(104, "禁言");
        ArrayMap arrayMap = new ArrayMap();
        MsgPackHelper.putMapValue((Map<String, Object>) arrayMap, "uid", profileData.uid);
        MsgPackHelper.putMapValue((Map<String, Object>) arrayMap, "name", profileData.name);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("mute_profile", arrayMap);
        a.fromRichLevel = LiveRoomInfo.a().r();
        if (LiveFloatManager.a().w()) {
            a.fromLiveManager = 1;
        }
        a.msgMapExtra = arrayMap2;
        a(a);
        LogUtils.a("聊天场控禁言");
    }

    public void b(LiveChattingModel liveChattingModel) {
        a(liveChattingModel);
    }

    public void b(String str) {
        LiveChattingModel a = a(1, str);
        a.fromNickName = "测试";
        a(a);
    }

    public abstract void b(short s, long j, LiveChatInfoListener liveChatInfoListener);

    public abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public LiveChattingModel f() {
        return a(31, "LiveLike");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LiveChattingModel g() {
        return a(51, "LiveLike");
    }

    public void h() {
        a(a(50, AppInfo.d().getString(R.string.live_shared)));
        LogUtils.a("分享了主播");
    }

    public void i() {
        a(a(g.j));
    }

    public void j() {
        a(a(-10000));
    }

    public void k() {
        a(a(103, AppInfo.d().getString(R.string.live_attention_remind)));
    }

    public void l() {
        a(a(104, AppInfo.d().getString(R.string.live_chat_remind)));
    }

    public void m() {
        a(a(49, AppInfo.d().getString(R.string.live_following)));
    }

    public void n() {
        EventTrackLive.a(LiveProtos.Event.LIVE_SUPPORT_ANCHOR_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        Log.i("xpm", "sendLocalSayHelloRemindMsg");
        a(a(104, AppInfo.d().getString(R.string.live_say_hello)));
    }
}
