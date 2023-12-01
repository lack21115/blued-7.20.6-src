package com.blued.android.module.live_china.manager;

import android.app.Instrumentation;
import android.os.BatteryManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.common.ZegoMixStreamHelper;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.DefinedRankInfo;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.FunctionRedPModelJson;
import com.blued.android.module.live_china.model.HTMLNoticeModel;
import com.blued.android.module.live_china.model.LiveAnnounceModel;
import com.blued.android.module.live_china.model.LiveBunchLightModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGuideModel;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.LiveKickUserModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveMakeLoverModel;
import com.blued.android.module.live_china.model.LivePKDoubleModel;
import com.blued.android.module.live_china.model.LivePKPlayerModel;
import com.blued.android.module.live_china.model.LivePKPlusModel;
import com.blued.android.module.live_china.model.LivePKProgressModel;
import com.blued.android.module.live_china.model.LivePKProgressUserModel;
import com.blued.android.module.live_china.model.LivePKResultModel;
import com.blued.android.module.live_china.model.LivePkRoundModel;
import com.blued.android.module.live_china.model.LivePkTypeModel;
import com.blued.android.module.live_china.model.LiveRecordRecommendModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomTipsModel;
import com.blued.android.module.live_china.model.LiveShakeModel;
import com.blued.android.module.live_china.model.LiveWishCourtModel;
import com.blued.android.module.live_china.model.LiveWishItemModel;
import com.blued.android.module.live_china.model.LiveWishModel;
import com.blued.android.module.live_china.model.LiveWishingDrawModel;
import com.blued.android.module.live_china.msg.LiveMsgHandler;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveBunchLightView;
import com.blued.android.module.live_china.view.LivePKFirstPayView;
import com.blued.android.module.live_china.view.LivePKResult;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingMsgManager.class */
public class RecordingMsgManager extends LiveMsgHandler {

    /* renamed from: a  reason: collision with root package name */
    public long f13761a;
    private RecordingOnliveFragment b;

    /* renamed from: c  reason: collision with root package name */
    private RecordingOnliveManager f13762c;
    private List<LivePKProgressUserModel> f;
    private List<LivePKProgressUserModel> g;
    private List<LivePKPlayerModel> h;
    private boolean i;

    public RecordingMsgManager(RecordingOnliveFragment recordingOnliveFragment, RecordingOnliveManager recordingOnliveManager) {
        super(recordingOnliveFragment);
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.b = recordingOnliveFragment;
        this.f13762c = recordingOnliveManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        if (this.b.cR != null) {
            this.b.cR.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveBunchLightModel liveBunchLightModel) {
        this.b.A.a(liveBunchLightModel.getImage(), liveBunchLightModel.getPlay_times());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveGuideModel liveGuideModel) {
        if (this.b.cR != null) {
            this.b.cR.a(liveGuideModel);
        }
    }

    public int a(long j, LivePKPlayerModel livePKPlayerModel) {
        if (j == 0) {
            this.b.bF.a(0, livePKPlayerModel);
            return 0;
        } else if (j == LiveRoomManager.a().f()) {
            this.b.bF.a(1, livePKPlayerModel);
            return 1;
        } else {
            this.b.bF.a(2, livePKPlayerModel);
            return 2;
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(int i, int i2, int i3, float f) {
        this.b.a(i, i2, i3, f);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(long j, int i) {
    }

    public void a(long j, List<LivePKPlayerModel> list) {
        int i = 0;
        int i2 = j == 0 ? 0 : j == LiveRoomManager.a().f() ? 1 : 2;
        if (list == null || !this.b.r()) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        long j2 = 0;
        for (LivePKPlayerModel livePKPlayerModel : list) {
            if (livePKPlayerModel == null) {
                return;
            }
            if (livePKPlayerModel.uid == LiveRoomManager.a().f()) {
                i = livePKPlayerModel.win_streak;
                i4 = livePKPlayerModel.target_streak;
                i6 = livePKPlayerModel.target_beans;
                i5 = livePKPlayerModel.total_beans;
            } else {
                i3 = livePKPlayerModel.win_streak;
                j2 = livePKPlayerModel.uid;
            }
        }
        LivePKPlusModel livePKPlusModel = new LivePKPlusModel();
        livePKPlusModel.leftWinNum = i;
        livePKPlusModel.rightWinNum = i3;
        livePKPlusModel.result = i2;
        livePKPlusModel.otherUid = j2;
        livePKPlusModel.target_streak = i4;
        livePKPlusModel.total_beans = i5;
        livePKPlusModel.target_beans = i6;
        this.b.cg.setResult(livePKPlusModel);
    }

    public void a(final long j, List<LivePKPlayerModel> list, int i) {
        int i2;
        if (this.b.r()) {
            int i3 = 0;
            if (list != null) {
                i2 = 0;
                for (LivePKPlayerModel livePKPlayerModel : list) {
                    if (livePKPlayerModel == null) {
                        return;
                    }
                    if (livePKPlayerModel.uid == LiveRoomManager.a().f()) {
                        i3 = livePKPlayerModel.score;
                    } else {
                        i2 = livePKPlayerModel.score;
                    }
                }
            } else {
                i3 = 0;
                i2 = 0;
            }
            this.b.ce.setEventCallback(new LivePKResult.EventCallBack() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.1
                @Override // com.blued.android.module.live_china.view.LivePKResult.EventCallBack
                public void a() {
                    if (j != LiveRoomManager.a().f() || RecordingMsgManager.this.f == null || RecordingMsgManager.this.f.size() <= 0) {
                        return;
                    }
                    RecordingMsgManager.this.b.cf.a(((LivePKProgressUserModel) RecordingMsgManager.this.f.get(0)).name, ((LivePKProgressUserModel) RecordingMsgManager.this.f.get(0)).avatar);
                }
            });
            this.b.ce.setResult(i3, i2, j, i);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(FunctionRedPModelJson functionRedPModelJson) {
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveAnnounceModel liveAnnounceModel) {
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(final LiveChattingModel liveChattingModel) {
        Map<String, Object> map;
        int intValue;
        Object obj;
        List<LiveBunchLightModel> listValue;
        super.a(liveChattingModel);
        switch (liveChattingModel.msgType) {
            case 37:
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordingMsgManager.this.b.a(liveChattingModel);
                    }
                });
                return;
            case 46:
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RecordingMsgManager.this.f13762c != null) {
                            RecordingMsgManager.this.b.L();
                        }
                    }
                });
                return;
            case 47:
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                        if (map2 != null) {
                            String stringValue = MsgPackHelper.getStringValue(map2, ReqAckPackage.REQ_RESPONSE_KEY.REQ_ERROR_CONTENTS);
                            if (TextUtils.isEmpty(stringValue)) {
                                AppMethods.d(R.string.connection_not_accepted);
                            } else {
                                AppMethods.a((CharSequence) stringValue);
                            }
                        } else {
                            AppMethods.d(R.string.connection_not_accepted);
                        }
                        RecordingMsgManager.this.b.aG();
                    }
                });
                return;
            case 94:
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.a("rrrb", "红包返还消息");
                        Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                        if (map2 != null) {
                            int intValue2 = MsgPackHelper.getIntValue(map2, "refund_beans");
                            String string = RecordingMsgManager.this.b.getContext().getString(R.string.live_reward_beans_back);
                            AppMethods.a((CharSequence) String.format(string, intValue2 + ""));
                        }
                    }
                });
                return;
            case 114:
                final LiveFriendModel liveFriendModel = (LiveFriendModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveFriendModel.class);
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.a("pk", "收到pk邀请消息");
                        if (liveFriendModel.type == 0) {
                            if (liveFriendModel.reset != 0) {
                                if (liveFriendModel.reset != 1 || RecordingMsgManager.this.b.cc == null) {
                                    return;
                                }
                                RecordingMsgManager.this.b.cc.b(liveFriendModel);
                            } else if (RecordingMsgManager.this.b.bB.r()) {
                            } else {
                                if (RecordingMsgManager.this.b.cV) {
                                    KeyboardUtils.a(RecordingMsgManager.this.b.getActivity());
                                }
                                liveFriendModel.model = 0;
                                if (RecordingMsgManager.this.b.cc != null) {
                                    RecordingMsgManager.this.b.cc.a(liveFriendModel);
                                }
                            }
                        }
                    }
                });
                return;
            case 119:
                final LiveFriendModel liveFriendModel2 = (LiveFriendModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveFriendModel.class);
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.7
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.a("pk", "好友、观众连线邀请");
                        LiveMsgSendManager.a().d("收到连麦邀请消息");
                        if (liveFriendModel2.type == 0) {
                            if (liveFriendModel2.reset != 0) {
                                if (liveFriendModel2.reset != 1 || RecordingMsgManager.this.b.cc == null) {
                                    return;
                                }
                                RecordingMsgManager.this.b.cc.b(liveFriendModel2);
                            } else if (RecordingMsgManager.this.b.bB.r() || RecordingMsgManager.this.b.bb()) {
                            } else {
                                if (RecordingMsgManager.this.b.cV) {
                                    KeyboardUtils.a(RecordingMsgManager.this.b.getActivity());
                                }
                                liveFriendModel2.model = 1;
                                if (RecordingMsgManager.this.b.cc != null) {
                                    RecordingMsgManager.this.b.cc.a(liveFriendModel2);
                                }
                            }
                        }
                    }
                });
                return;
            case 120:
                this.b.y = true;
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RecordingMsgManager.this.f13762c != null) {
                            LiveMsgSendManager.a().d("收到连麦开始消息");
                            Logger.a("pk", "开始连麦");
                            Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                            if (map2 != null) {
                                MsgPackHelper.getStringValue(map2, "conference_id");
                                MsgPackHelper.getStringValue(map2, "conference_token");
                                String stringValue = MsgPackHelper.getStringValue(map2, Instrumentation.REPORT_KEY_STREAMRESULT);
                                String stringValue2 = MsgPackHelper.getStringValue(map2, "target_stream");
                                Log.v("pk", "我的拉流id:" + stringValue2);
                                Log.v("pk", "我的推流id:" + stringValue);
                                MsgPackHelper.getStringValue(map2, "name");
                                long longValue = MsgPackHelper.getLongValue(map2, "uid");
                                int intValue2 = MsgPackHelper.getIntValue(map2, "type");
                                RecordingMsgManager.this.f13761a = longValue;
                                if (intValue2 == 0) {
                                    if (RecordingMsgManager.this.b.bB.r()) {
                                        AppMethods.d(R.string.live_other_anchor_agreed);
                                    } else {
                                        AppMethods.d(R.string.live_connection_to_begin);
                                    }
                                    RecordingMsgManager.this.b.bB.e();
                                    RecordingMsgManager.this.b.bB.o();
                                    RecordingMsgManager.this.b.d_(2);
                                } else {
                                    if (RecordingMsgManager.this.b.bB.r()) {
                                        AppMethods.d(R.string.live_other_anchor_agreed);
                                    } else {
                                        AppMethods.d(R.string.live_connection_to_begin);
                                    }
                                    RecordingMsgManager.this.b.ay();
                                    RecordingMsgManager.this.b.d_(3);
                                }
                                RecordingMsgManager.this.b.L();
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(LiveRoomManager.a().g());
                                arrayList.add(String.valueOf(RecordingMsgManager.this.f13761a));
                                ZegoMixStreamHelper.a().a(arrayList, new ArrayList());
                                RecordingMsgManager.this.f13762c.a(2, stringValue2);
                                RecordingMsgManager.this.b.g_(8);
                            }
                        }
                    }
                });
                return;
            case 121:
                Log.v("==record", "MT_LIVE_CONNECTION_END");
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RecordingMsgManager.this.f13762c != null) {
                            LiveMsgSendManager.a().d("收到连麦结束消息");
                            Logger.a("pk", "结束连麦");
                            Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                            long longValue = MsgPackHelper.getLongValue(map2, "closed_by");
                            MsgPackHelper.getIntValue(map2, "type");
                            if (RecordingMsgManager.this.b.aT() || RecordingMsgManager.this.b.aS()) {
                                String f = LiveRoomInfo.a().f();
                                if (!TextUtils.equals(f, longValue + "")) {
                                    AppMethods.d(R.string.live_connection_other_finish);
                                }
                            }
                            RecordingMsgManager.this.b.M();
                            RecordingMsgManager.this.b.d_(0);
                        }
                        RecordingMsgManager.this.b.y = false;
                        RecordingMsgManager.this.b.g_(0);
                    }
                });
                return;
            case 122:
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RecordingMsgManager.this.f13762c != null) {
                            LiveMsgSendManager.a().d("收到连麦拒绝消息");
                            Logger.a("pk", "拒绝连麦邀请");
                            RecordingMsgManager.this.b.bB.e();
                            RecordingMsgManager.this.b.bB.o();
                            RecordingMsgManager.this.b.ay();
                            AppMethods.d(R.string.live_pk_invite_him_next_time);
                        }
                    }
                });
                return;
            case 128:
                LiveMsgSendManager.a().d("主播邀请观众上麦");
                return;
            case 129:
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                        int intValue2 = MsgPackHelper.getIntValue(map2, "count");
                        long longValue = MsgPackHelper.getLongValue(map2, "uid");
                        LiveMsgSendManager a2 = LiveMsgSendManager.a();
                        a2.d("主播忽略观众申请 uid:" + longValue + " - count:" + intValue2);
                        String f = LiveRoomInfo.a().f();
                        if (TextUtils.equals(f, longValue + "") && RecordingMsgManager.this.b.cv.c()) {
                            RecordingMsgManager.this.b.cv.h();
                            RecordingMsgManager.this.b.cv.setState(0);
                        }
                        RecordingMsgManager.this.b.k.b(intValue2);
                    }
                });
                return;
            case 131:
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.13
                    @Override // java.lang.Runnable
                    public void run() {
                        long longValue = MsgPackHelper.getLongValue(liveChattingModel.msgMapExtra, "uid");
                        int intValue2 = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "enable");
                        LiveMsgSendManager a2 = LiveMsgSendManager.a();
                        a2.d("麦序管理 uid:" + longValue + " - enable:" + intValue2);
                        RecordingMsgManager.this.a(longValue, intValue2);
                    }
                });
                return;
            case 132:
                if (this.b.aU()) {
                    return;
                }
                LiveFriendModel liveFriendModel3 = (LiveFriendModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveFriendModel.class);
                if (liveFriendModel3 != null) {
                    if (liveFriendModel3.fans != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < liveFriendModel3.fans.size()) {
                                LiveMsgSendManager a2 = LiveMsgSendManager.a();
                                a2.d("进入交友模式:" + i2 + "号uid：" + liveFriendModel3.fans.get(i2).uid + "name:" + liveFriendModel3.fans.get(i2).name);
                                i = i2 + 1;
                            } else {
                                this.b.a_(liveFriendModel3.fans);
                            }
                        }
                    }
                    this.b.c(liveFriendModel3);
                    this.b.k.c(liveFriendModel3.count);
                    LiveMsgSendManager a3 = LiveMsgSendManager.a();
                    a3.d("进入交友模式 count:" + liveFriendModel3.count);
                }
                b(liveFriendModel3);
                return;
            case 134:
                final LiveFriendModel liveFriendModel4 = (LiveFriendModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveFriendModel.class);
                if (liveFriendModel4 != null) {
                    this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (liveFriendModel4.fans != null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(LiveRoomManager.a().g());
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= liveFriendModel4.fans.size()) {
                                        break;
                                    }
                                    arrayList.add(liveFriendModel4.fans.get(i4).uid);
                                    LiveMsgSendManager a4 = LiveMsgSendManager.a();
                                    a4.d("直播间上麦:" + i4 + "号uid：" + liveFriendModel4.fans.get(i4).uid + "name:" + liveFriendModel4.fans.get(i4).name);
                                    i3 = i4 + 1;
                                }
                                ZegoMixStreamHelper.a().a(arrayList, new ArrayList());
                                RecordingMsgManager.this.b.a_(liveFriendModel4.fans);
                                if (liveFriendModel4.fans.size() > liveFriendModel4.index - 1) {
                                    LiveFriendModel liveFriendModel5 = liveFriendModel4.fans.get(liveFriendModel4.index - 1);
                                    AppMethods.a((CharSequence) String.format(RecordingMsgManager.this.b.getContext().getString(R.string.live_make_friend_succeeded_entering), liveFriendModel5.name));
                                    Log.v("pk", "用户上麦  推流id：" + liveFriendModel4.stream + " -- 拉流id:" + liveFriendModel5.stream);
                                    RecordingMsgManager.this.b.ac.a(liveFriendModel4.stream, liveFriendModel5.stream, liveFriendModel4.index);
                                }
                            }
                            RecordingMsgManager.this.b.k.b(liveFriendModel4.count);
                            LiveMsgSendManager a5 = LiveMsgSendManager.a();
                            a5.d("直播间上麦 count:" + liveFriendModel4.count);
                        }
                    });
                    return;
                }
                return;
            case 155:
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.14
                    @Override // java.lang.Runnable
                    public void run() {
                        Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                        MsgPackHelper.getIntValue(map2, BatteryManager.EXTRA_LEVEL);
                        String stringValue = MsgPackHelper.getStringValue(map2, "resource");
                        LiveGiftModel liveGiftModel = new LiveGiftModel();
                        liveGiftModel.images_apng2 = stringValue;
                        RecordingMsgManager.this.b.dd.e(liveGiftModel);
                    }
                });
                return;
            case 165:
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.15
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "status") == 1) {
                            RecordingMsgManager.this.b.Z();
                        }
                    }
                });
                return;
            case 179:
                Log.i("==makelover==", "179(申请 取消 同步):" + liveChattingModel.getMsgExtra());
                final LiveMakeLoverModel liveMakeLoverModel = (LiveMakeLoverModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveMakeLoverModel.class);
                if (liveMakeLoverModel != null) {
                    this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.16
                        @Override // java.lang.Runnable
                        public void run() {
                            RecordingMsgManager.this.b.n(liveMakeLoverModel.chooser_count + liveMakeLoverModel.chosen_count);
                        }
                    });
                    return;
                }
                return;
            case 180:
                Log.i("==makelover==", "180（join）:" + liveChattingModel.getMsgExtra());
                final LiveMakeLoverModel liveMakeLoverModel2 = (LiveMakeLoverModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveMakeLoverModel.class);
                if (liveMakeLoverModel2 != null) {
                    this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.17
                        @Override // java.lang.Runnable
                        public void run() {
                            int i3;
                            if (liveMakeLoverModel2.fans != null) {
                                RecordingMsgManager.this.b.f(liveMakeLoverModel2.fans);
                                LiveMakeLoverFansModel liveMakeLoverFansModel = null;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(LiveRoomManager.a().g());
                                int i4 = 0;
                                int i5 = 0;
                                while (true) {
                                    i3 = i5;
                                    if (i4 >= liveMakeLoverModel2.fans.size()) {
                                        break;
                                    }
                                    LiveMakeLoverFansModel liveMakeLoverFansModel2 = liveMakeLoverModel2.fans.get(i4);
                                    LiveMakeLoverFansModel liveMakeLoverFansModel3 = liveMakeLoverFansModel;
                                    int i6 = i3;
                                    if (liveMakeLoverFansModel2 != null) {
                                        liveMakeLoverFansModel3 = liveMakeLoverFansModel;
                                        i6 = i3;
                                        if (TextUtils.equals(liveMakeLoverFansModel2.uid, liveMakeLoverModel2.uid)) {
                                            i6 = i4;
                                            liveMakeLoverFansModel3 = liveMakeLoverFansModel2;
                                        }
                                    }
                                    arrayList.add(liveMakeLoverFansModel2.uid);
                                    i4++;
                                    liveMakeLoverFansModel = liveMakeLoverFansModel3;
                                    i5 = i6;
                                }
                                ZegoMixStreamHelper.a().a(arrayList, new ArrayList());
                                if (liveMakeLoverFansModel != null) {
                                    AppMethods.a((CharSequence) String.format(RecordingMsgManager.this.b.getContext().getString(R.string.live_make_friend_succeeded_entering), liveMakeLoverFansModel.name));
                                    Log.v("pk", "用户相亲上麦  推流id：" + liveMakeLoverModel2.stream + " -- 拉流id:" + liveMakeLoverFansModel.stream);
                                    RecordingMsgManager.this.b.ac.b(liveMakeLoverModel2.stream, liveMakeLoverFansModel.stream, i3 + 1);
                                    LiveMsgSendManager.a().d("直播间相亲上麦:" + i3 + "号uid：" + liveMakeLoverFansModel.uid + "name:" + liveMakeLoverFansModel.name);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            case 181:
                Log.i("==makelover==", "181(下麦):" + liveChattingModel.getMsgExtra());
                final LiveMakeLoverModel liveMakeLoverModel3 = (LiveMakeLoverModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveMakeLoverModel.class);
                if (liveMakeLoverModel3 != null) {
                    this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.18
                        @Override // java.lang.Runnable
                        public void run() {
                            RecordingMsgManager.this.b.bm.d(liveMakeLoverModel3.uid);
                            LiveMsgSendManager a4 = LiveMsgSendManager.a();
                            a4.d("直播间下麦:" + liveMakeLoverModel3.index + "号uid：" + liveMakeLoverModel3.uid + "name:" + liveMakeLoverModel3.name);
                            ZegoCommonHelper.b().c().stopPlayingStream(liveMakeLoverModel3.stream);
                            ZegoMixStreamHelper.a().b(liveMakeLoverModel3.uid, "");
                            ZegoMixStreamHelper.a().a(liveMakeLoverModel3.stream, RecordingMsgManager.this.f13762c.f13795c);
                            AppMethods.a((CharSequence) String.format(RecordingMsgManager.this.b.getContext().getString(R.string.live_make_friend_has_left), liveMakeLoverModel3.name));
                        }
                    });
                    return;
                }
                return;
            case 184:
                Log.i("==makelover==", "184(重置灯):" + liveChattingModel.getMsgExtra());
                return;
            case 185:
                Log.i("==makelover==", "185(嘉宾爆照):" + liveChattingModel.getMsgExtra());
                final LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverFansModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveMakeLoverFansModel.class);
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.19
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordingMsgManager.this.b.bk.a(liveMakeLoverFansModel.uid, liveMakeLoverFansModel.pic);
                    }
                });
                return;
            case 186:
                Log.i("==makelover==", "186(主同意):" + liveChattingModel.getMsgExtra());
                LiveMsgSendManager.a().d("主播邀请观众相亲上麦");
                return;
            case 187:
                Log.i("==makelover==", "187(主拒绝):" + liveChattingModel.getMsgExtra());
                LiveMsgSendManager.a().d("主播忽略观众相亲上麦");
                return;
            case 188:
                Log.i("==makelover==", "188(客态主动下麦):" + liveChattingModel.getMsgExtra());
                return;
            case 189:
                Log.i("==makelover==", "189(主态踢客态下麦):" + liveChattingModel.getMsgExtra());
                return;
            case 190:
                Log.i("==makelover==", "190(客态开麦):" + liveChattingModel.getMsgExtra());
                return;
            case 191:
                Log.i("==makelover==", "191(客态闭麦):" + liveChattingModel.getMsgExtra());
                return;
            case 192:
                Log.i("==makelover==", "192(客拒绝):" + liveChattingModel.getMsgExtra());
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.20
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveMsgSendManager.a().d("观众拒绝主播相亲邀请");
                        AppMethods.d(R.string.live_make_friend_busy);
                    }
                });
                return;
            case 200:
                Log.i("==livetask==", "200(主态新主播任务):" + liveChattingModel.getMsgExtra());
                return;
            case 211:
                LiveRecordRecommendModel liveRecordRecommendModel = (LiveRecordRecommendModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveRecordRecommendModel.class);
                if (LiveRoomManager.a().p() != null) {
                    LiveRoomManager.a().p().recommend = liveRecordRecommendModel;
                }
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.21
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordingMsgManager.this.b.bl();
                    }
                });
                return;
            case 215:
                Log.i("==xpp", "215暴击时刻:" + liveChattingModel.getMsgExtra());
                final LivePKDoubleModel livePKDoubleModel = (LivePKDoubleModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LivePKDoubleModel.class);
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMsgManager.22
                    @Override // java.lang.Runnable
                    public void run() {
                        if (livePKDoubleModel != null) {
                            RecordingMsgManager.this.b.b(livePKDoubleModel.buff_countdown);
                        }
                    }
                });
                return;
            case 216:
                Log.i("==wish", "216:" + liveChattingModel.getMsgExtra());
                LiveWishItemModel liveWishItemModel = (LiveWishItemModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveWishItemModel.class);
                if (liveWishItemModel != null) {
                    this.b.a(liveWishItemModel);
                    return;
                }
                return;
            case 220:
                Log.i("==wish", "220:" + liveChattingModel.getMsgExtra());
                LiveWishModel liveWishModel = (LiveWishModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveWishModel.class);
                if (liveWishModel == null || LiveRoomManager.a().p() == null) {
                    return;
                }
                LiveRoomManager.a().p().wishList = liveWishModel.wish_list;
                this.b.J();
                return;
            case 226:
                if (liveChattingModel == null || liveChattingModel.msgMapExtra == null || (intValue = MsgPackHelper.getIntValue((map = liveChattingModel.msgMapExtra), "show_type")) == 2) {
                    return;
                }
                final LiveGuideModel liveGuideModel = new LiveGuideModel();
                liveGuideModel.id = MsgPackHelper.getIntValue(map, "id");
                liveGuideModel.type = MsgPackHelper.getIntValue(map, "type");
                liveGuideModel.sub_type = MsgPackHelper.getIntValue(map, "sub_type");
                liveGuideModel.content = MsgPackHelper.getStringValue(map, "content");
                liveGuideModel.url = MsgPackHelper.getStringValue(map, "url");
                liveGuideModel.strategy = MsgPackHelper.getIntValue(map, "strategy");
                liveGuideModel.frequency = MsgPackHelper.getIntValue(map, "frequency");
                liveGuideModel.count = MsgPackHelper.getIntValue(map, "count");
                liveGuideModel.countdown = MsgPackHelper.getIntValue(map, "countdown");
                liveGuideModel.show_type = intValue;
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$RecordingMsgManager$HwJ71nNoCSIRoFXmb4Koiy0CX80
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecordingMsgManager.this.a(liveGuideModel);
                    }
                });
                return;
            case 227:
                if (liveChattingModel == null || liveChattingModel.msgMapExtra == null || !liveChattingModel.msgMapExtra.containsKey("id") || !(liveChattingModel.msgMapExtra.get("id") instanceof Integer)) {
                    return;
                }
                final int intValue2 = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "id");
                this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$RecordingMsgManager$1-5W6L-A5IF91iI356n-K5XApMo
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecordingMsgManager.this.a(intValue2);
                    }
                });
                return;
            case 228:
                this.b.a(((Integer) liveChattingModel.msgMapExtra.get("rank")).intValue(), ((Integer) liveChattingModel.msgMapExtra.get("need_score")).intValue());
                return;
            case 234:
                Log.i("==xpm", "234:" + liveChattingModel.getMsgExtra());
                return;
            case 235:
                Log.i("==xpm", "235:" + liveChattingModel.getMsgExtra());
                LiveFriendModel liveFriendModel5 = (LiveFriendModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveFriendModel.class);
                if (liveFriendModel5 != null) {
                    if (liveFriendModel5.type == 0) {
                        this.b.cv.h();
                        if (this.b.bB.r() || this.b.bb()) {
                            return;
                        }
                        if (this.b.cV) {
                            KeyboardUtils.a(this.b.getActivity());
                        }
                        liveFriendModel5.model = 5;
                        if (this.b.cc != null) {
                            this.b.cc.a(liveFriendModel5);
                        }
                        this.b.bB.e();
                        this.b.bB.h();
                        this.b.bB.i();
                        this.b.bB.o();
                        this.b.bB.f();
                        this.b.bB.g();
                        return;
                    } else if (liveFriendModel5.type == 1) {
                        if (this.b.cc != null) {
                            this.b.cc.b(liveFriendModel5);
                            return;
                        }
                        return;
                    } else if (liveFriendModel5.type != 2 || this.f13762c == null) {
                        return;
                    } else {
                        this.b.bB.e();
                        this.b.bB.o();
                        if (TextUtils.isEmpty(liveFriendModel5.name)) {
                            return;
                        }
                        AppMethods.a((CharSequence) (liveFriendModel5.name + AppInfo.d().getString(R.string.live_invite_connecting_refuse_tip)));
                        return;
                    }
                }
                return;
            case 236:
                LiveWishingDrawModel liveWishingDrawModel = (LiveWishingDrawModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveWishingDrawModel.class);
                if (liveWishingDrawModel == null || LiveRoomManager.a().p() == null) {
                    return;
                }
                LiveRoomManager.a().p().wishing_well = liveWishingDrawModel;
                this.b.a(liveWishingDrawModel);
                return;
            case 247:
                if (!(liveChattingModel instanceof LiveChattingModel) || this.b.cm == null) {
                    return;
                }
                DefinedRankInfo definedRankInfo = (DefinedRankInfo) LiveChattingModel.copy(liveChattingModel).getObjExtra();
                this.b.cm.setData(definedRankInfo);
                LiveRoomManager.a().p().custom_rank = definedRankInfo;
                return;
            case 250:
                if (liveChattingModel instanceof LiveChattingModel) {
                    this.b.a((HTMLNoticeModel) LiveChattingModel.copy(liveChattingModel).getObjExtra());
                    return;
                }
                return;
            case 252:
                if (!(liveChattingModel instanceof LiveChattingModel) || this.b.co == null) {
                    return;
                }
                LiveWishCourtModel liveWishCourtModel = (LiveWishCourtModel) LiveChattingModel.copy(liveChattingModel).getObjExtra();
                this.b.co.a(EnumOperation.VIEW_TYPE_WISHING_CONTEST.getValue(), liveWishCourtModel);
                this.b.a(liveWishCourtModel);
                return;
            case 269:
                if (this.b.H == null || liveChattingModel.msgMapExtra == null || !liveChattingModel.msgMapExtra.containsKey("bunchLightModel") || (obj = liveChattingModel.msgMapExtra.get("bunchLightModel")) == null || !(obj instanceof LiveBunchLightModel)) {
                    return;
                }
                if (this.b.A == null) {
                    this.b.A = new LiveBunchLightView(this.b.E);
                    this.b.A.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    this.b.H.addView(this.b.A);
                }
                final LiveBunchLightModel liveBunchLightModel = (LiveBunchLightModel) obj;
                this.b.A.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$RecordingMsgManager$Ik5EUI0vbtHx3TtWFAAUpnhaSfg
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecordingMsgManager.this.a(liveBunchLightModel);
                    }
                });
                return;
            case 270:
                if (liveChattingModel.msgMapExtra == null || !liveChattingModel.msgMapExtra.containsKey("bunchLightList") || (listValue = MsgPackHelper.getListValue(liveChattingModel.msgMapExtra, "bunchLightList")) == null || listValue.isEmpty()) {
                    return;
                }
                this.b.af.b(listValue, MsgPackHelper.getLongValue(liveChattingModel.msgMapExtra, "timestamp", System.currentTimeMillis() / 1000) / 1000);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveFriendModel liveFriendModel) {
        if (liveFriendModel != null) {
            a(new ArrayList());
            f(new ArrayList());
            g(liveFriendModel.records);
        }
        this.b.a(liveFriendModel);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveHornModelNew liveHornModelNew, LiveGiftModel liveGiftModel) {
        LiveMsgSendManager.a().d("收到喇叭消息");
        this.b.a(liveHornModelNew, false);
        if (liveGiftModel != null) {
            this.b.b(liveGiftModel);
            this.b.b(liveGiftModel);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveInviteUserModel liveInviteUserModel) {
        this.b.bB.h();
        this.b.bB.i();
        this.b.a(liveInviteUserModel);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveKickUserModel liveKickUserModel) {
        if (liveKickUserModel != null) {
            LiveMsgSendManager.a().a(liveKickUserModel.uid, liveKickUserModel.name);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LivePKProgressModel livePKProgressModel) {
        Log.i("==xpm", "onPkProgress:" + livePKProgressModel.toString());
        if (livePKProgressModel == null) {
            return;
        }
        int i = 0;
        if (TextUtils.equals(livePKProgressModel.uid + "", LiveRoomInfo.a().f())) {
            this.b.bE.setOurProgress(livePKProgressModel.total);
            if (c() && livePKProgressModel.top != null && livePKProgressModel.top.size() > 0) {
                this.b.cf.a(0, livePKProgressModel.top.get(0).name, livePKProgressModel.top.get(0).avatar);
            }
        } else {
            this.b.bN.a(livePKProgressModel.score);
            this.b.bE.setOtherProgress(livePKProgressModel.total);
            if (c() && livePKProgressModel.target_top != null && livePKProgressModel.target_top.size() > 0) {
                this.b.cf.a(1, livePKProgressModel.target_top.get(0).name, livePKProgressModel.target_top.get(0).avatar);
            }
        }
        this.b.bF.setData(livePKProgressModel);
        a(livePKProgressModel.top);
        f(livePKProgressModel.target_top);
        LivePKFirstPayView livePKFirstPayView = this.b.bP;
        if (!c()) {
            i = 8;
        }
        livePKFirstPayView.setVisibility(i);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LivePKResultModel livePKResultModel) {
        Log.i("==xpm", "onPkEnd:" + livePKResultModel.toString());
        this.b.bP.setVisibility(8);
        this.b.bB.s();
        this.b.bO.c();
        LivePKPlayerModel livePKPlayerModel = null;
        LivePKPlayerModel livePKPlayerModel2 = null;
        if (livePKResultModel.records != null) {
            Iterator<LivePKPlayerModel> it = livePKResultModel.records.iterator();
            while (true) {
                livePKPlayerModel = livePKPlayerModel2;
                if (!it.hasNext()) {
                    break;
                }
                LivePKPlayerModel next = it.next();
                if (next == null) {
                    return;
                }
                if (next.uid != LiveRoomManager.a().f()) {
                    livePKPlayerModel2 = next;
                }
            }
        }
        if (livePKPlayerModel != null) {
            this.f13761a = livePKPlayerModel.uid;
        }
        if (livePKResultModel.winner != 0) {
            if (TextUtils.equals(livePKResultModel.winner + "", LiveRoomInfo.a().f())) {
                if (livePKResultModel.records != null) {
                    Iterator<LivePKPlayerModel> it2 = livePKResultModel.records.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        LivePKPlayerModel next2 = it2.next();
                        if (TextUtils.equals(next2.uid + "", LiveRoomInfo.a().f())) {
                            LiveGiftModel liveGiftModel = new LiveGiftModel();
                            liveGiftModel.anim_code = next2.anim_code;
                            liveGiftModel.resource_url = next2.ar_url;
                            this.b.dd.a(liveGiftModel);
                            break;
                        }
                    }
                }
            } else if (livePKResultModel.records != null) {
                Iterator<LivePKPlayerModel> it3 = livePKResultModel.records.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    LivePKPlayerModel next3 = it3.next();
                    if (TextUtils.equals(next3.uid + "", LiveRoomInfo.a().f())) {
                        LiveGiftModel liveGiftModel2 = new LiveGiftModel();
                        liveGiftModel2.anim_code = next3.anim_code;
                        liveGiftModel2.resource_url = next3.ar_url;
                        this.b.dd.a(liveGiftModel2);
                        break;
                    }
                }
            }
        } else if (livePKResultModel.records != null) {
            Iterator<LivePKPlayerModel> it4 = livePKResultModel.records.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                LivePKPlayerModel next4 = it4.next();
                if (TextUtils.equals(next4.uid + "", LiveRoomInfo.a().f())) {
                    LiveGiftModel liveGiftModel3 = new LiveGiftModel();
                    liveGiftModel3.anim_code = next4.anim_code;
                    liveGiftModel3.resource_url = next4.ar_url;
                    this.b.dd.a(liveGiftModel3);
                    break;
                }
            }
        }
        if (livePKResultModel.pk_type == 0) {
            a(livePKResultModel.winner, livePKPlayerModel);
        }
        a(livePKResultModel.winner, livePKResultModel.records);
        a(livePKResultModel.winner, livePKResultModel.records, livePKResultModel.pk_type);
        if (livePKResultModel.type == 1) {
            if (TextUtils.equals(livePKResultModel.winner + "", LiveRoomInfo.a().f())) {
                if (this.b.bO.a()) {
                    AppMethods.a((CharSequence) this.b.getString(R.string.live_pk_exit_from_each_other_time));
                } else {
                    AppMethods.a((CharSequence) this.b.getString(R.string.live_pk_exit_from_each_other));
                }
            }
        } else if (livePKResultModel.type == 3) {
            AppMethods.a((CharSequence) this.b.getString(R.string.live_pk_connect_fail_toast));
        }
        this.b.bO.a(livePKResultModel.countdown);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LivePkRoundModel livePkRoundModel) {
        if (this.b.r() && livePkRoundModel != null) {
            if (livePkRoundModel.pk_status) {
                this.b.b(livePkRoundModel);
                return;
            }
            a(new ArrayList());
            f(new ArrayList());
            this.b.a(livePkRoundModel);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LivePkTypeModel livePkTypeModel) {
        String str;
        String str2;
        String str3;
        if (this.b.r() && livePkTypeModel != null) {
            if (this.b.cS != null) {
                str3 = this.b.cS.f13097c;
                str2 = this.b.cS.d;
                str = this.b.cS.e;
            } else {
                str = "";
                str2 = "";
                str3 = "";
            }
            EventTrackLive.b(LiveProtos.Event.LIVE_PK_START, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str3, str2, str, livePkTypeModel.pk_type == 0 ? 1 : 3);
            if (livePkTypeModel.pk_type == 0) {
                LiveFriendModel liveFriendModel = new LiveFriendModel();
                liveFriendModel.countdown = livePkTypeModel.countdown;
                this.b.b(liveFriendModel);
            }
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveRewardModel liveRewardModel) {
        if (this.b.bw != null) {
            this.b.bw.a(liveRewardModel);
        }
        if (this.b.co != null) {
            this.b.co.a(EnumOperation.VIEW_TYPE_RED_BAG.getValue(), liveRewardModel);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveRoomTipsModel liveRoomTipsModel) {
        LiveSetDataObserver.a().a(liveRoomTipsModel);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveShakeModel liveShakeModel) {
        this.b.a(liveShakeModel);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(String str) {
        this.b.n(str);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(String str, String str2) {
        this.b.c(str, str2);
    }

    public void a(List<LivePKProgressUserModel> list) {
        this.f.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f.addAll(list);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(List<LiveInviteUserModel> list, LiveInviteUserModel liveInviteUserModel) {
        this.b.bB.e();
        this.b.bB.o();
        this.b.bB.h();
        this.b.bB.g();
        this.b.a(list, liveInviteUserModel);
        this.b.bB.a(list, liveInviteUserModel);
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean a() {
        return this.i;
    }

    public List<LivePKPlayerModel> b() {
        return this.h;
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void b(LiveFriendModel liveFriendModel) {
        super.b(liveFriendModel);
        boolean z = true;
        if (liveFriendModel.is_access_control != 1) {
            z = false;
        }
        this.i = z;
        RecordingOnliveFragment recordingOnliveFragment = this.b;
        if (recordingOnliveFragment == null || recordingOnliveFragment.bw == null || this.b.x) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.bw.getLayoutParams();
        layoutParams.topMargin = DisplayUtil.a(this.b.getContext(), 150.0f);
        this.b.bw.setLayoutParams(layoutParams);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void b(List<LiveInviteUserModel> list) {
        this.b.bB.e();
        this.b.bB.o();
        this.b.bB.f();
        this.b.g(list);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void c(LiveFriendModel liveFriendModel) {
        ZegoCommonHelper.b().c().stopPlayingStream(liveFriendModel.stream);
        ZegoMixStreamHelper.a().b(liveFriendModel.uid, "");
        ZegoMixStreamHelper.a().a(liveFriendModel.stream, this.f13762c.f13795c);
        AppMethods.a((CharSequence) String.format(this.b.getContext().getString(R.string.live_make_friend_has_left), liveFriendModel.name));
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void c(List<LiveInviteUserModel> list) {
        this.b.bB.e();
        this.b.bB.o();
        this.b.bB.f();
        this.b.bB.h();
        this.b.bB.j();
        this.b.h(list);
    }

    public boolean c() {
        return this.f.size() == 0 && this.g.size() == 0;
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void d(List<LiveInviteUserModel> list) {
        this.b.i(list);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void e(List<LiveInviteUserModel> list) {
        this.b.j(list);
    }

    public void f(List<LivePKProgressUserModel> list) {
        this.g.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g.addAll(list);
    }

    public void g(List<LivePKPlayerModel> list) {
        this.h.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.h.addAll(list);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void h() {
        super.h();
        RecordingOnliveFragment recordingOnliveFragment = this.b;
        if (recordingOnliveFragment == null || recordingOnliveFragment.bw == null || this.b.x) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.bw.getLayoutParams();
        layoutParams.topMargin = DisplayUtil.a(this.b.getContext(), 115.0f);
        this.b.bw.setLayoutParams(layoutParams);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void i() {
        this.b.ap.a();
        this.b.Y();
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void j() {
        this.b.bB.e();
        this.b.bB.o();
        this.b.bB.h();
        this.b.bB.i();
        this.b.bB.g();
        this.b.bf();
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void k() {
        this.b.y();
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void l() {
    }
}
