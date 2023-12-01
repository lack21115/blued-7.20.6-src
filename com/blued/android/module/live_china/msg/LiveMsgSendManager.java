package com.blued.android.module.live_china.msg;

import android.os.SystemClock;
import android.text.TextUtils;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlTransModel;
import com.blued.android.module.live_china.model.LiveGuideType;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/LiveMsgSendManager.class */
public class LiveMsgSendManager {
    private static volatile LiveMsgSendManager a;
    private ILiveMsgSender b;
    private final AtomicLong c = new AtomicLong(0);

    private LiveMsgSendManager() {
    }

    public static LiveMsgSendManager a() {
        synchronized (LiveMsgSendManager.class) {
            try {
                if (a == null) {
                    a = new LiveMsgSendManager();
                    a.l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, short s) {
        LiveChattingModel a2 = this.b.a(j, s, 32, AppInfo.d().getResources().getString(R.string.liveVideo_message_label_shareLivePart), str);
        if (a2 != null) {
            a2.setMsgExtra(str);
        }
        LiveRoomInfo.a().a(a2, false);
    }

    private void l() {
        this.b = new GrpcMsgSender();
    }

    public void a(int i, String str) {
        this.b.b(i, str);
    }

    public void a(long j) {
        this.b.a(j);
    }

    public void a(long j, String str) {
        this.b.a(j, str);
    }

    public void a(long j, final String[] strArr, final String[] strArr2, final String str) {
        LiveRoomHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<LiveMsgShareEntity>>() { // from class: com.blued.android.module.live_china.msg.LiveMsgSendManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveMsgShareEntity> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                LiveMsgShareEntity liveMsgShareEntity = bluedEntityA.data.get(0);
                if (liveMsgShareEntity != null) {
                    try {
                        liveMsgShareEntity.copywriting = str;
                        String json = AppInfo.f().toJson(liveMsgShareEntity);
                        if (strArr.length != strArr2.length || strArr.length <= 0) {
                            return;
                        }
                        for (int i = 0; i < strArr.length; i++) {
                            LiveMsgSendManager.a().a(json, CommonStringUtils.c(strArr[i]), (short) CommonStringUtils.a(strArr2[i]));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, String.valueOf(j), (IRequestHost) null);
    }

    public void a(ProfileData profileData) {
        this.b.a(profileData);
    }

    public void a(LiveChattingModel liveChattingModel) {
        this.b.b(liveChattingModel);
    }

    public void a(LiveGiftModel liveGiftModel) {
        if (liveGiftModel == null) {
            return;
        }
        LiveGiftModel liveGiftModel2 = new LiveGiftModel();
        ReflectionUtils.a(liveGiftModel, liveGiftModel2);
        this.b.a(liveGiftModel2);
        if (liveGiftModel.bonus > 0.0d) {
            LiveRefreshUIObserver.a().c(LiveGuideType.GUIDE_TYPE_BEG_GIFT);
        }
    }

    public void a(LiveGiftScrawlTransModel liveGiftScrawlTransModel) {
        if (liveGiftScrawlTransModel == null) {
            return;
        }
        LiveChattingModel liveChattingModel = new LiveChattingModel(this.b.a(221, ""));
        liveChattingModel.fromId = LiveRoomInfo.a().g();
        liveChattingModel.fromNickName = LiveRoomInfo.a().c();
        liveChattingModel.fromAvatar = LiveRoomInfo.a().d();
        liveGiftScrawlTransModel.extraModel = LiveRoomManager.a().M();
        liveChattingModel.setObjExtra(liveGiftScrawlTransModel);
        this.b.a(liveChattingModel);
    }

    public void a(LiveZanExtraModel.EmojiModel emojiModel, SendMsgListener sendMsgListener) {
        a(emojiModel.text, true, emojiModel, sendMsgListener);
    }

    public void a(String str) {
        a(str, false, (LiveZanExtraModel.EmojiModel) null, (SendMsgListener) null);
    }

    public void a(String str, boolean z, LiveZanExtraModel.EmojiModel emojiModel, SendMsgListener sendMsgListener) {
        if (TextUtils.isEmpty(str) && emojiModel == null) {
            AppMethods.d(R.string.chat_send_alert);
            return;
        }
        this.b.a(str, z, emojiModel, sendMsgListener);
        if (sendMsgListener != null) {
            sendMsgListener.a();
        }
        LiveRefreshUIObserver.a().i();
        LogUtils.c(str);
    }

    public void a(String str, boolean z, SendMsgListener sendMsgListener) {
        a(str, z, (LiveZanExtraModel.EmojiModel) null, sendMsgListener);
    }

    public void a(short s, long j, LiveChatInfoListener liveChatInfoListener) {
        this.b.a(s, j, liveChatInfoListener);
    }

    public void a(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.c.get() == 0 || ((float) (elapsedRealtime - this.c.get())) / 1000.0f >= 0.5d || (elapsedRealtime - this.c.get()) / 1000 < 0) {
            this.c.set(elapsedRealtime);
            this.b.a(z);
        }
    }

    public void b() {
        this.b.a();
    }

    public void b(ProfileData profileData) {
        this.b.b(profileData);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveGiftModel liveGiftModel = new LiveGiftModel();
        if (str.endsWith(".mp4")) {
            liveGiftModel.images_mp4 = str;
        } else if (str.endsWith(".gif")) {
            liveGiftModel.images_gif = str;
        } else {
            liveGiftModel.images_apng2 = str;
        }
        liveGiftModel.animation = 1;
        liveGiftModel.onlyPlayScreen = true;
        BasePayRemaining e = LiveDataManager.a().e();
        if (e != null) {
            liveGiftModel.beans_count = e.beans_count;
            liveGiftModel.beans_current_count = e.beans_current;
            liveGiftModel.beans = e.beans;
            liveGiftModel.bonus = e.bonus;
        }
        LiveChattingModel a2 = this.b.a(33, "LiveGift");
        a2.msgMapExtra = new HashMap();
        a2.msgMapExtra.put("gift_model", liveGiftModel);
        LiveSetDataObserver.a().a(a2);
    }

    public void b(short s, long j, LiveChatInfoListener liveChatInfoListener) {
        this.b.b(s, j, liveChatInfoListener);
    }

    public void c() {
        this.b.b();
    }

    public void c(String str) {
        this.b.a(str);
    }

    public void d() {
        this.b.c();
    }

    public void d(String str) {
        if (AppInfo.m()) {
            this.b.b(str);
        }
    }

    public void e() {
        this.b.h();
    }

    public void f() {
        this.b.i();
    }

    public void g() {
        this.b.j();
    }

    public void h() {
        this.b.k();
    }

    public void i() {
        this.b.l();
    }

    public void j() {
        this.b.n();
    }

    public void k() {
        this.b.m();
    }
}
