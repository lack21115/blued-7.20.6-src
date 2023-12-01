package com.blued.android.module.yy_china.manager;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live.base.view.LiveCircleProgressView;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYJumpLoadingFragment;
import com.blued.android.module.yy_china.fragment.YYStudioErrorFragment;
import com.blued.android.module.yy_china.listener.YYIVIPBuyResultObserver;
import com.blued.android.module.yy_china.model.ClientSendMessTaskNewModel;
import com.blued.android.module.yy_china.model.YYDouZiPayRequestModel;
import com.blued.android.module.yy_china.model.YYExRoomModel;
import com.blued.android.module.yy_china.model.YYGameTimerEvent;
import com.blued.android.module.yy_china.model.YYGlobalMsgModel;
import com.blued.android.module.yy_china.model.YYJoinRoomJumpInfoMode;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYRoomPKTimerEvent;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.TrtcSongScoreModel;
import com.blued.android.module.yy_china.utils.NoDoubleClickUtils;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.web.modelloader.model.WebBuyBeansModel;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRoomInfoManager.class */
public class YYRoomInfoManager {
    private long A;
    private String B;
    private String C;
    private YYJoinRoomJumpInfoMode D;
    private int[] E;
    private int[] F;
    private int[] G;
    private int[] H;
    private int I;

    /* renamed from: a  reason: collision with root package name */
    public YYUserInfo f17578a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public int f17579c;
    public long d;
    public long e;
    public String f;
    public ArrayList<Integer> g;
    public RoomManagerController h;
    public int i;
    public int j;
    private final YYHandler k;
    private String l;
    private YYRoomModel m;
    private IYYRoomInfoCallback n;
    private LiveCircleProgressView o;
    private CountDownTimer p;
    private CountDownTimer q;
    private CountDownTimer r;
    private CountDownTimer s;
    private CountDownTimer t;
    private CountDownTimer u;
    private boolean v;
    private boolean w;
    private boolean x;
    private String y;
    private String z;

    /* renamed from: com.blued.android.module.yy_china.manager.YYRoomInfoManager$12  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRoomInfoManager$12.class */
    static /* synthetic */ class AnonymousClass12 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17583a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[YYConstants.AnchormanPKStatus.values().length];
            f17583a = iArr;
            try {
                iArr[YYConstants.AnchormanPKStatus.Punish.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17583a[YYConstants.AnchormanPKStatus.Fighting.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: com.blued.android.module.yy_china.manager.YYRoomInfoManager$2  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRoomInfoManager$2.class */
    class AnonymousClass2 extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        YYRoomModel f17584a;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.e("timer", "onFinish ... ");
            YYRoomModel yYRoomModel = this.f17584a;
            if (yYRoomModel != null) {
                yYRoomModel.setTimerFinished(true);
            }
            YYRoomInfoManager.e().b("0豆");
            LiveEventBus.get("gift_free_time").post(100);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            int i = (int) (j / 1000);
            YYRoomModel yYRoomModel = this.f17584a;
            if (yYRoomModel != null) {
                yYRoomModel.setTimerFinished(false);
            }
            YYRoomInfoManager e = YYRoomInfoManager.e();
            e.b(i + "s");
            LiveEventBus.get("gift_free_time").post(Integer.valueOf(i));
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRoomInfoManager$Manager.class */
    public static class Manager {

        /* renamed from: a  reason: collision with root package name */
        public static YYRoomInfoManager f17595a = new YYRoomInfoManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRoomInfoManager$YYHandler.class */
    public static class YYHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<YYRoomInfoManager> f17596a;

        public YYHandler(YYRoomInfoManager yYRoomInfoManager) {
            this.f17596a = new WeakReference<>(yYRoomInfoManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                removeMessages(1);
                Message obtain = Message.obtain();
                obtain.what = 1;
                if (this.f17596a.get() == null || !this.f17596a.get().N()) {
                    return;
                }
                removeMessages(1);
                sendMessageDelayed(obtain, 1000L);
            } else if (message.what == 2) {
                if (this.f17596a.get() != null) {
                    LiveEventBus.get("event_ktv_up_to_mic_song").post("");
                }
            } else if (message.what != 3 || this.f17596a.get() == null) {
            } else {
                this.f17596a.get().a(true);
            }
        }
    }

    private YYRoomInfoManager() {
        this.f17579c = 1;
        this.A = 0L;
        this.B = "";
        this.f = "";
        this.C = "";
        this.g = new ArrayList<>();
        this.E = new int[]{R.drawable.chat_anchor_level_1, R.drawable.chat_anchor_level_2, R.drawable.chat_anchor_level_3, R.drawable.chat_anchor_level_4, R.drawable.chat_anchor_level_5, R.drawable.chat_anchor_level_6, R.drawable.chat_anchor_level_7, R.drawable.chat_anchor_level_8, R.drawable.chat_anchor_level_9, R.drawable.chat_anchor_level_10, R.drawable.chat_anchor_level_11, R.drawable.chat_anchor_level_12, R.drawable.chat_anchor_level_13, R.drawable.chat_anchor_level_14, R.drawable.chat_anchor_level_15};
        this.F = new int[]{R.drawable.yy_live_1, R.drawable.yy_live_2, R.drawable.yy_live_3, R.drawable.yy_live_4, R.drawable.yy_live_5, R.drawable.yy_live_6, R.drawable.yy_live_7, R.drawable.yy_live_8, R.drawable.yy_live_9, R.drawable.yy_live_10, R.drawable.yy_live_11, R.drawable.yy_live_12, R.drawable.yy_live_13, R.drawable.yy_live_14, R.drawable.yy_live_15, R.drawable.yy_live_16, R.drawable.yy_live_17, R.drawable.yy_live_18, R.drawable.yy_live_19, R.drawable.yy_live_20, R.drawable.yy_live_21, R.drawable.yy_live_22, R.drawable.yy_live_23, R.drawable.yy_live_24, R.drawable.yy_live_25, R.drawable.yy_live_26, R.drawable.yy_live_27, R.drawable.yy_live_28, R.drawable.yy_live_29, R.drawable.yy_live_30, R.drawable.yy_live_31, R.drawable.yy_live_32, R.drawable.yy_live_33, R.drawable.yy_live_34, R.drawable.yy_live_35, R.drawable.yy_live_36, R.drawable.yy_live_37, R.drawable.yy_live_38, R.drawable.yy_live_39, R.drawable.yy_live_40};
        this.G = new int[]{R.drawable.yy_bubble_lv_20, R.drawable.yy_bubble_lv_31, R.drawable.yy_bubble_lv_36, R.drawable.yy_bubble_lv_41, R.drawable.yy_bubble_lv_46};
        this.H = new int[]{R.drawable.yy_decorate_lv_20, R.drawable.yy_decorate_lv_31, R.drawable.yy_decorate_lv_36, R.drawable.yy_decorate_lv_41, R.drawable.yy_decorate_lv_46};
        this.I = 0;
        this.i = 0;
        this.j = 60;
        this.k = new YYHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N() {
        long j = this.e;
        if (j > -1) {
            this.e = j + 1;
            LiveEventBus.get("EVENT_EVEN_HOST_CREATE_TIME").post(String.format("%02d:%02d:%02d", Long.valueOf(this.e / b.P), Long.valueOf((this.e / 60) % 60), Long.valueOf(this.e % 60)));
            return true;
        }
        return false;
    }

    private void b(final BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        YYRoomHttpUtils.c(str, str2, new BluedUIHttpResponse<BluedEntity<YYRoomModel, YYExRoomModel>>(null) { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.8

            /* renamed from: a  reason: collision with root package name */
            Dialog f17592a = null;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str3) {
                DialogUtils.b(this.f17592a);
                YYStudioErrorFragment.a(baseFragmentActivity, str3);
                LiveEventBus.get("notify_close_jump_room").post("");
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                DialogUtils.b(this.f17592a);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                Dialog a2 = DialogUtils.a(baseFragmentActivity);
                this.f17592a = a2;
                DialogUtils.a(a2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYRoomModel, YYExRoomModel> bluedEntity) {
                YYRoomModel singleData = bluedEntity.getSingleData();
                YYExRoomModel yYExRoomModel = bluedEntity.extra;
                if (singleData != null) {
                    if (singleData.mics != null && singleData.mics.size() > 0) {
                        if (TextUtils.equals(singleData.chat_type, "4")) {
                            singleData.mics.get(0).itemType = 2;
                            singleData.mics.get(1).itemType = 3;
                        } else if (TextUtils.equals(singleData.chat_type, "8") || TextUtils.equals(singleData.chat_type, "11")) {
                            singleData.mics.get(singleData.mics.size() - 1).isVip = true;
                        }
                    }
                    if (yYExRoomModel != null) {
                        singleData.chat_room_list_stealth = yYExRoomModel.getChat_room_list_stealth();
                    }
                    YYRoomInfoManager.this.a(singleData);
                    YYRoomInfoManager.this.c(baseFragmentActivity);
                    YYRoomInfoManager.this.d = System.currentTimeMillis();
                }
            }
        }, (IRequestHost) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        if (TextUtils.equals(this.m.chat_type, "9") && y()) {
            a(context);
            YYSeatMemberModel seatMember = this.m.getSeatMember(k());
            if (seatMember != null) {
                this.f17578a.is_mic = "1";
                this.f17578a.is_open_mic = seatMember.is_open_mic;
                return;
            }
            this.f17578a.is_open_mic = 0;
            this.f17578a.is_mic = "0";
            this.f17578a.mute = this.m.mute;
            return;
        }
        BaseYYStudioFragment.b(context, false);
        YYUserInfo yYUserInfo = new YYUserInfo();
        this.f17578a = yYUserInfo;
        yYUserInfo.setUid(k());
        this.f17578a.setName(l());
        this.f17578a.setAvatar(m());
        this.f17578a.is_open_mic = 0;
        this.f17578a.is_mic = "0";
        this.f17578a.chat_anchor = this.m.chat_anchor;
        this.f17578a.mute = this.m.mute;
    }

    public static YYRoomInfoManager e() {
        return Manager.f17595a;
    }

    private LiveUserRelationshipUtils.IAddOrRemoveAttentionDone i(final String str) {
        return new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.1
            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void Q_() {
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str2) {
                YYObserverManager.a().a(str, str2);
                LiveEventBus.get("notify_follow_user").post(str);
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str2) {
                YYObserverManager.a().a(str, str2);
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void d() {
            }
        };
    }

    private BluedUIHttpResponse j(final String str) {
        return new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                String str2 = YYRoomInfoManager.this.b() != null ? YYRoomInfoManager.this.b().room_id : "";
                LiveLogUtils.a("YYRoomInfoManager --> request --> leaveRoom is OK --> room id：" + str2 + "; new_room_id：" + str);
                YYRoomInfoManager.this.x();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                LiveEventBus.get("into_new_yy_room").post(str);
            }
        };
    }

    public boolean A() {
        YYRoomModel yYRoomModel = this.m;
        if (yYRoomModel == null || yYRoomModel.mics == null) {
            return false;
        }
        boolean z = true;
        for (YYSeatMemberModel yYSeatMemberModel : this.m.mics) {
            if (yYSeatMemberModel == null || StringUtils.a(yYSeatMemberModel.getUid(), 0) <= 0) {
                z = false;
            }
        }
        return z;
    }

    public void B() {
        this.e = 0L;
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.k.sendMessage(obtain);
    }

    public void C() {
        this.e = -2L;
    }

    public String D() {
        return this.y;
    }

    public String E() {
        return this.z;
    }

    public boolean F() {
        return System.currentTimeMillis() - this.A > 1000;
    }

    public void G() {
        if (y()) {
            return;
        }
        this.k.removeMessages(2);
        this.k.sendEmptyMessageDelayed(2, 30000L);
    }

    public void H() {
        this.k.removeMessages(2);
    }

    public int I() {
        YYRoomModel yYRoomModel = this.m;
        if (yYRoomModel == null || yYRoomModel.music == null || this.m.stage_info == null) {
            return 0;
        }
        LogUtils.d("YYRoomInfoManager", "音乐理论总分：" + this.m.stage_info.total_score + "； 配置的等级分数：" + this.m.stage_info.lowest_score);
        return (int) ((StringUtils.a(this.m.stage_info.total_score, 0.0f) * StringUtils.a(this.m.stage_info.lowest_score, 0)) / 100.0f);
    }

    public boolean J() {
        YYRoomModel yYRoomModel = this.m;
        if (yYRoomModel == null) {
            return false;
        }
        return TextUtils.equals(yYRoomModel.chat_type, "11");
    }

    public void K() {
        YYRoomModel yYRoomModel = this.m;
        if (yYRoomModel != null) {
            yYRoomModel.cleanTimerUserList();
        }
    }

    public YYRobMusicManager L() {
        RoomManagerController roomManagerController = this.h;
        if (roomManagerController != null && (roomManagerController instanceof YYRobMusicManager)) {
            return (YYRobMusicManager) roomManagerController;
        }
        return null;
    }

    public YYKtvMusicManager M() {
        RoomManagerController roomManagerController = this.h;
        if (roomManagerController != null && (roomManagerController instanceof YYKtvMusicManager)) {
            return (YYKtvMusicManager) roomManagerController;
        }
        return null;
    }

    public int a(int i) {
        int i2 = i;
        if (i == 0) {
            i2 = 1;
        }
        int[] iArr = this.F;
        int i3 = i2;
        if (i2 > iArr.length) {
            i3 = iArr.length;
        }
        return this.F[i3 - 1];
    }

    public Object a(YYIVIPBuyResultObserver yYIVIPBuyResultObserver) {
        IYYRoomInfoCallback iYYRoomInfoCallback = this.n;
        if (iYYRoomInfoCallback != null) {
            return iYYRoomInfoCallback.a(yYIVIPBuyResultObserver);
        }
        return null;
    }

    public String a(String str, String str2) {
        return (!J() || g(str)) ? str2 : AppInfo.d().getString(R.string.masked_user_name);
    }

    public void a(int i, int i2, Intent intent, BaseFragment baseFragment) {
        YYPayUtils.a(i, i2, intent, baseFragment);
    }

    public void a(long j) {
        if (j > 0 && !this.v) {
            this.v = true;
            final StringBuilder sb = new StringBuilder();
            long j2 = j;
            if (j < 1000) {
                j2 = j * 1000;
            }
            this.q = new CountDownTimer(j2, 1000L) { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.3
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    YYRoomInfoManager.this.v = false;
                    LiveEventBus.get("show_vote_time").post("");
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    String valueOf;
                    String valueOf2;
                    long j4 = j3 / 1000;
                    int i = (int) (j4 / 60);
                    int i2 = (int) (j4 % 60);
                    StringBuilder sb2 = sb;
                    sb2.delete(0, sb2.length());
                    StringBuilder sb3 = sb;
                    if (i < 10) {
                        valueOf = "0" + i;
                    } else {
                        valueOf = Integer.valueOf(i);
                    }
                    sb3.append(valueOf);
                    sb.append(":");
                    StringBuilder sb4 = sb;
                    if (i2 < 10) {
                        valueOf2 = "0" + i2;
                    } else {
                        valueOf2 = Integer.valueOf(i2);
                    }
                    sb4.append(valueOf2);
                    LiveEventBus.get("show_vote_time").post(sb.toString());
                }
            }.start();
        }
    }

    public void a(long j, int i) {
        if (j <= 0) {
            return;
        }
        if (this.I != i && this.x) {
            this.s.cancel();
            this.x = false;
        }
        if (this.x) {
            return;
        }
        this.x = true;
        final StringBuilder sb = new StringBuilder();
        long j2 = j;
        if (j < 1000) {
            j2 = j * 1000;
        }
        final YYGameTimerEvent yYGameTimerEvent = new YYGameTimerEvent();
        yYGameTimerEvent.timerType = i;
        this.s = new CountDownTimer(j2, 1000L) { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.5
            @Override // android.os.CountDownTimer
            public void onFinish() {
                YYRoomInfoManager.this.x = false;
                yYGameTimerEvent.content = "";
                LiveEventBus.get("show_game_time").post(yYGameTimerEvent);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                int i2 = (int) (j3 / 1000);
                StringBuilder sb2 = sb;
                sb2.delete(0, sb2.length());
                StringBuilder sb3 = sb;
                sb3.append(i2 + "s");
                yYGameTimerEvent.content = i2 <= 0 ? "" : sb.toString();
                LiveEventBus.get("show_game_time").post(yYGameTimerEvent);
            }
        }.start();
    }

    public void a(long j, final YYConstants.AnchormanPKStatus anchormanPKStatus) {
        if (j <= 0) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final YYRoomPKTimerEvent yYRoomPKTimerEvent = new YYRoomPKTimerEvent();
        yYRoomPKTimerEvent.timerType = anchormanPKStatus;
        this.t = new CountDownTimer(j * 1000, 1000L) { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (anchormanPKStatus == YYConstants.AnchormanPKStatus.Fighting) {
                    yYRoomPKTimerEvent.content = "PK  00:00";
                } else {
                    YYRoomInfoManager.this.v();
                    yYRoomPKTimerEvent.content = "";
                }
                LiveEventBus.get("show_anchorman_pk_time").post(yYRoomPKTimerEvent);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                String format = TimeAndDateUtils.k.get().format(Long.valueOf(j2));
                StringBuilder sb2 = sb;
                sb2.delete(0, sb2.length());
                int i = AnonymousClass12.f17583a[anchormanPKStatus.ordinal()];
                if (i == 1) {
                    sb.append("互动  ");
                } else if (i == 2) {
                    sb.append("PK  ");
                }
                sb.append(format);
                yYRoomPKTimerEvent.content = sb.toString();
                LiveEventBus.get("show_anchorman_pk_time").post(yYRoomPKTimerEvent);
            }
        }.start();
    }

    public void a(Context context) {
        BaseYYStudioFragment.a(context, false);
        YYUserInfo yYUserInfo = new YYUserInfo();
        this.f17578a = yYUserInfo;
        yYUserInfo.setUid(k());
        this.f17578a.setName(l());
        this.f17578a.setAvatar(m());
        this.f17578a.is_open_mic = 1;
        this.f17578a.is_mic = "1";
        this.f17578a.chat_anchor = "1";
    }

    public void a(Context context, String str, String str2, IRequestHost iRequestHost) {
        IYYRoomInfoCallback iYYRoomInfoCallback = this.n;
        if (iYYRoomInfoCallback == null) {
            return;
        }
        iYYRoomInfoCallback.b(context, str, str2, i(str), iRequestHost);
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        IYYRoomInfoCallback iYYRoomInfoCallback = this.n;
        if (iYYRoomInfoCallback != null) {
            iYYRoomInfoCallback.a(context, str, str2, str3, str4, str5, str6, i);
        }
    }

    public void a(IRequestHost iRequestHost, ImageView imageView, String str, String str2) {
        if (!J() || g(str)) {
            ImageLoader.a(iRequestHost, str2).c().b(R.drawable.user_bg_round).a(imageView);
        } else {
            imageView.setImageResource(R.drawable.icon_user_mask_without_text);
        }
    }

    public void a(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        a(baseFragmentActivity, str, str2, false);
    }

    public void a(BaseFragmentActivity baseFragmentActivity, String str, String str2, boolean z) {
        a(baseFragmentActivity, str, str2, z, "");
    }

    public void a(BaseFragmentActivity baseFragmentActivity, String str, String str2, boolean z, String str3) {
        a(baseFragmentActivity, str, str2, z, "", null);
    }

    public void a(BaseFragmentActivity baseFragmentActivity, String str, String str2, boolean z, String str3, YYJoinRoomJumpInfoMode yYJoinRoomJumpInfoMode) {
        if (baseFragmentActivity == null || StringUtils.a("0", str)) {
            return;
        }
        a(str3);
        if (yYJoinRoomJumpInfoMode != null) {
            a(yYJoinRoomJumpInfoMode);
        }
        boolean a2 = NoDoubleClickUtils.a();
        if (z || !a2) {
            YYRoomModel b = e().b();
            if (b == null) {
                LiveLogUtils.a("YYRoomInfoManager --> intoRoomBySource --> 进入直播间 room_id：" + str);
                this.B = str2;
                b(baseFragmentActivity, str, str2);
            } else if (TextUtils.equals(b.room_id, str)) {
                LiveLogUtils.a("YYRoomInfoManager --> intoRoomBySource --> 进入相同直播间 room_id：" + str);
                this.B = str2;
                if (AudioChannelManager.j().n()) {
                    AudioChannelManager.j().k();
                    e().b(baseFragmentActivity);
                    return;
                }
                Fragment findFragmentByTag = baseFragmentActivity.getSupportFragmentManager().findFragmentByTag("init_fragment");
                if (findFragmentByTag == null || !(findFragmentByTag instanceof BaseYYStudioFragment)) {
                    if (!TextUtils.equals(baseFragmentActivity.getClass().getName(), "com.soft.blued.ui.home.HomeActivity")) {
                        baseFragmentActivity.finish();
                    }
                    e().b(baseFragmentActivity);
                }
            } else if (TextUtils.equals(b.uid, e().k())) {
                LiveLogUtils.a("YYRoomInfoManager --> intoRoomBySource --> 主播自己切换直播间 失败：");
                AppMethods.a((CharSequence) baseFragmentActivity.getString(R.string.yy_in_room_toast));
                a((YYJoinRoomJumpInfoMode) null);
                a((String) null);
            } else {
                this.f = str2;
                LiveLogUtils.a("YYRoomInfoManager --> intoRoomBySource --> 切换直播间 room_id：" + str);
                Fragment findFragmentByTag2 = baseFragmentActivity.getSupportFragmentManager().findFragmentByTag("init_fragment");
                if (findFragmentByTag2 == null || !(findFragmentByTag2 instanceof BaseYYStudioFragment)) {
                    AudioChannelManager.j().a(str);
                    AudioChannelManager.j().k();
                    return;
                }
                if (TextUtils.equals(str2, "broadcast_cp_vip")) {
                    YYJumpLoadingFragment.a(baseFragmentActivity);
                }
                ((BaseYYStudioFragment) findFragmentByTag2).ah = str;
                baseFragmentActivity.finish();
            }
        }
    }

    public void a(IYYRoomInfoCallback iYYRoomInfoCallback) {
        this.n = iYYRoomInfoCallback;
    }

    public void a(YYJoinRoomJumpInfoMode yYJoinRoomJumpInfoMode) {
        this.D = yYJoinRoomJumpInfoMode;
    }

    public void a(YYRoomModel yYRoomModel) {
        this.m = yYRoomModel;
        yYRoomModel.initMicsMap();
    }

    public void a(TrtcSongScoreModel trtcSongScoreModel) {
        YYRoomModel yYRoomModel = this.m;
        if (yYRoomModel == null || yYRoomModel.music == null) {
            return;
        }
        this.m.music.lrcCount++;
        this.m.music.hitCount = trtcSongScoreModel.hitCount;
        int i = 0;
        if (this.m.stage_info != null) {
            this.m.stage_info.score = trtcSongScoreModel.gotTotalScore + "";
            i = StringUtils.a(this.m.stage_info.lowest_score, 0);
        }
        trtcSongScoreModel.totalScore = I();
        if (trtcSongScoreModel.gotTotalScore > trtcSongScoreModel.totalScore) {
            trtcSongScoreModel.averageScore = d(trtcSongScoreModel.gotTotalScore);
        } else {
            trtcSongScoreModel.averageScore = i;
        }
        AudioChannelManager.j().a(trtcSongScoreModel);
    }

    public void a(WebBuyBeansModel webBuyBeansModel, BaseFragment baseFragment) {
        if (ClickUtils.a()) {
            return;
        }
        YYPayUtils.a(new YYDouZiPayRequestModel(webBuyBeansModel.prop_id, webBuyBeansModel.day, "", "", false), baseFragment, baseFragment.getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.10
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String str) {
                ToastUtils.a("支付失败" + str);
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel yYPayGoodsModel) {
                ToastUtils.a("购买成功，快去佩戴吧");
            }
        });
    }

    public void a(Object obj) {
        IYYRoomInfoCallback iYYRoomInfoCallback = this.n;
        if (iYYRoomInfoCallback != null) {
            iYYRoomInfoCallback.a(obj);
        }
    }

    public void a(String str) {
        this.C = str;
    }

    public void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        YYRoomModel b = b();
        if (b != null) {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_EXIT_ROOM, str, b.uid, b.type_id, (int) ((System.currentTimeMillis() - this.d) / 1000), this.B);
        }
        LiveLogUtils.a("YYRoomInfoManager --> request --> leaveRoom --> room id：" + str);
        YYRoomHttpUtils.e(str, this.B, bluedUIHttpResponse, iRequestHost);
    }

    public void a(boolean z) {
        YYRoomModel yYRoomModel;
        this.k.removeMessages(3);
        if (z) {
            int i = this.i - 1;
            this.i = i;
            if ((i < 0 && i > -99) || (yYRoomModel = this.m) == null) {
                return;
            }
            YYRoomHttpUtils.o(yYRoomModel.room_id, new BluedUIHttpResponse() { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.11
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                }
            }, (IRequestHost) null);
        }
        this.k.sendEmptyMessageDelayed(3, this.j * 1000);
    }

    public boolean a() {
        return e().n != null;
    }

    public int b(int i) {
        int i2 = i;
        if (i == 0) {
            i2 = 1;
        }
        int[] iArr = this.E;
        int i3 = i2;
        if (i2 > iArr.length) {
            i3 = iArr.length;
        }
        return this.E[i3 - 1];
    }

    public YYRoomModel b() {
        return this.m;
    }

    public void b(long j) {
        if (j > 0 && !this.w) {
            this.w = true;
            final StringBuilder sb = new StringBuilder();
            long j2 = j;
            if (j < 1000) {
                j2 = j * 1000;
            }
            this.r = new CountDownTimer(j2, 1000L) { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.4
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    YYRoomInfoManager.this.w = false;
                    LiveEventBus.get("show_gift_pk_time").post("");
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    String valueOf;
                    String valueOf2;
                    long j4 = j3 / 1000;
                    int i = (int) (j4 / 60);
                    int i2 = (int) (j4 % 60);
                    StringBuilder sb2 = sb;
                    sb2.delete(0, sb2.length());
                    StringBuilder sb3 = sb;
                    if (i < 10) {
                        valueOf = "0" + i;
                    } else {
                        valueOf = Integer.valueOf(i);
                    }
                    sb3.append(valueOf);
                    sb.append(":");
                    StringBuilder sb4 = sb;
                    if (i2 < 10) {
                        valueOf2 = "0" + i2;
                    } else {
                        valueOf2 = Integer.valueOf(i2);
                    }
                    sb4.append(valueOf2);
                    LiveEventBus.get("show_gift_pk_time").post(sb.toString());
                }
            }.start();
        }
    }

    public void b(Context context) {
        BaseYYStudioFragment.a(context);
    }

    public void b(Context context, String str, String str2, IRequestHost iRequestHost) {
        IYYRoomInfoCallback iYYRoomInfoCallback = this.n;
        if (iYYRoomInfoCallback == null) {
            return;
        }
        iYYRoomInfoCallback.a(context, str, str2, i(str), iRequestHost);
    }

    public void b(IRequestHost iRequestHost, ImageView imageView, String str, String str2) {
        if (!J() || g(str)) {
            ImageLoader.a(iRequestHost, str2).c().b(R.drawable.user_bg_round).a(imageView);
        } else {
            imageView.setImageResource(R.drawable.icon_user_mask_with_text);
        }
    }

    public void b(String str) {
        this.l = str;
    }

    public IYYRoomInfoCallback c() {
        return this.n;
    }

    public String c(int i) {
        IYYRoomInfoCallback iYYRoomInfoCallback = this.n;
        return iYYRoomInfoCallback == null ? "" : iYYRoomInfoCallback.a(i);
    }

    public void c(long j) {
        if (j <= 0) {
            return;
        }
        long j2 = j;
        if (j < 1000) {
            j2 = j * 1000;
        }
        CountDownTimer countDownTimer = this.u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.u = new CountDownTimer(j2, 1000L) { // from class: com.blued.android.module.yy_china.manager.YYRoomInfoManager.7
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveEventBus.get("show_room_pk_connecting_time").post("");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                LiveEventBus.get("show_room_pk_connecting_time").post("正在连线中（" + (j3 / 1000) + "s）...");
            }
        }.start();
    }

    public boolean c(String str) {
        YYRoomModel yYRoomModel = this.m;
        if (yYRoomModel == null) {
            return false;
        }
        return yYRoomModel.isExistById(str);
    }

    public int d(int i) {
        YYRoomModel yYRoomModel = this.m;
        if (yYRoomModel == null || yYRoomModel.stage_info == null) {
            return 0;
        }
        float a2 = StringUtils.a(this.m.stage_info.total_score, 0.0f);
        double d = i;
        if (d >= (90.0f * a2) / 100.0d) {
            return 90;
        }
        if (d >= (80.0f * a2) / 100.0d) {
            return 80;
        }
        if (d >= (70.0f * a2) / 100.0d) {
            return 70;
        }
        if (d >= (60.0f * a2) / 100.0d) {
            return 60;
        }
        return d >= ((double) (a2 * 50.0f)) / 100.0d ? 50 : 40;
    }

    public Application d() {
        return this.n.g();
    }

    public void d(String str) {
        YYRoomModel b = b();
        if (b == null) {
            return;
        }
        if (!y()) {
            a(b.room_id, j(str), (IRequestHost) null);
            return;
        }
        e().C();
        if (TextUtils.equals(b.chat_type, "9")) {
            a(b.room_id, j(str), (IRequestHost) null);
        } else {
            YYRoomHttpUtils.m(b.room_id, j(str), (IRequestHost) null);
        }
    }

    public void e(String str) {
        this.y = str;
    }

    public String f() {
        return this.C;
    }

    public void f(String str) {
        this.z = str;
    }

    public YYJoinRoomJumpInfoMode g() {
        return this.D;
    }

    public boolean g(String str) {
        if (this.m == null) {
            return false;
        }
        return StringUtils.a("0", str) || TextUtils.equals(k(), str) || TextUtils.equals(str, this.m.uid) || this.m.isUnmasked(str);
    }

    public boolean h() {
        if (b() != null) {
            YYSeatMemberModel seatMember = b().getSeatMember(k());
            return seatMember != null && seatMember.mic_position == ((!TextUtils.equals(this.m.chat_type, "6") && !TextUtils.equals(this.m.chat_type, "2") && !TextUtils.equals(this.m.chat_type, "3") && !TextUtils.equals(this.m.chat_type, "4") && !TextUtils.equals(this.m.chat_type, "5") && !TextUtils.equals(this.m.chat_type, "10")) ? 0 : 1);
        }
        return false;
    }

    public boolean h(String str) {
        return J() && this.m.hasTimerMaskedUser(str);
    }

    public boolean i() {
        YYUserInfo yYUserInfo = this.f17578a;
        if (yYUserInfo == null) {
            return false;
        }
        return TextUtils.equals(yYUserInfo.is_mic, "1");
    }

    public boolean j() {
        YYUserInfo yYUserInfo = this.f17578a;
        if (yYUserInfo == null) {
            return false;
        }
        return TextUtils.equals(yYUserInfo.chat_anchor, "2");
    }

    public String k() {
        IYYRoomInfoCallback iYYRoomInfoCallback = this.n;
        return iYYRoomInfoCallback == null ? "" : iYYRoomInfoCallback.c();
    }

    public String l() {
        IYYRoomInfoCallback iYYRoomInfoCallback = this.n;
        return iYYRoomInfoCallback == null ? "" : iYYRoomInfoCallback.a();
    }

    public String m() {
        IYYRoomInfoCallback iYYRoomInfoCallback = this.n;
        return iYYRoomInfoCallback == null ? "" : iYYRoomInfoCallback.b();
    }

    public String n() {
        return this.l;
    }

    public HashMap<String, YYSeatMemberModel> o() {
        YYRoomModel yYRoomModel = this.m;
        return (yYRoomModel == null || yYRoomModel.getMicsMap() == null) ? new HashMap<>() : this.m.getMicsMap();
    }

    public boolean p() {
        return this.v;
    }

    public boolean q() {
        return this.w;
    }

    public void r() {
        CountDownTimer countDownTimer = this.q;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
        this.v = false;
        LiveEventBus.get("show_vote_time").post("");
    }

    public void s() {
        CountDownTimer countDownTimer = this.r;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
        this.w = false;
        LiveEventBus.get("show_gift_pk_time").post("");
    }

    public void t() {
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void u() {
        CountDownTimer countDownTimer = this.u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void v() {
        e().e("");
        if (y()) {
            AudioChannelManager.j().l();
        }
    }

    public void w() {
        e().f("");
        e().t();
        e().v();
        LiveEventBus.get("EVENT_ROOM_PK_CLOSE_VIEW").post("");
        YYGlobalMsgModel yYGlobalMsgModel = new YYGlobalMsgModel();
        yYGlobalMsgModel.type = 7;
        LiveEventBus.get("room_pk_message").post(yYGlobalMsgModel);
    }

    public void x() {
        ClientSendMessTaskNewModel.Companion.a(null);
        this.m = null;
        this.f17578a = null;
        if (YYMusicManager.f11418a.c().a() != null) {
            AudioChannelManager.j().d(StringUtils.a(YYMusicManager.f11418a.c().a().music_id, 0));
        }
        YYMusicManager.f11418a.c().a((LiveMusicModel) null);
        YYMusicManager.f11418a.c().a((YYKtvMusicModel) null);
        YYMusicManager.f11418a.c().a((List<? extends YYKtvMusicModel>) null);
        YYVipNotifyManager.f17597a.a().a();
        CountDownTimer countDownTimer = this.p;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.p = null;
        }
        CountDownTimer countDownTimer2 = this.q;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.q = null;
            this.v = false;
        }
        CountDownTimer countDownTimer3 = this.r;
        if (countDownTimer3 != null) {
            countDownTimer3.cancel();
            this.r = null;
            this.w = false;
        }
        CountDownTimer countDownTimer4 = this.s;
        if (countDownTimer4 != null) {
            countDownTimer4.cancel();
            this.s = null;
            this.x = false;
        }
        CountDownTimer countDownTimer5 = this.t;
        if (countDownTimer5 != null) {
            countDownTimer5.cancel();
            this.t = null;
        }
        CountDownTimer countDownTimer6 = this.u;
        if (countDownTimer6 != null) {
            countDownTimer6.cancel();
            this.u = null;
        }
        v();
        RoomManagerController roomManagerController = this.h;
        if (roomManagerController != null) {
            roomManagerController.a();
            this.h = null;
        }
        YYHandler yYHandler = this.k;
        if (yYHandler != null) {
            yYHandler.removeCallbacksAndMessages(null);
        }
        this.b = false;
        this.o = null;
        a("");
    }

    public boolean y() {
        YYRoomModel yYRoomModel = this.m;
        return yYRoomModel != null && TextUtils.equals(yYRoomModel.uid, k());
    }

    public boolean z() {
        YYRoomModel yYRoomModel = this.m;
        if (yYRoomModel == null || !TextUtils.equals(yYRoomModel.chat_type, "9") || this.m.getHasPeopleMics().isEmpty()) {
            return false;
        }
        return TextUtils.equals(this.m.getHasPeopleMics().get(0).getUid(), k());
    }
}
