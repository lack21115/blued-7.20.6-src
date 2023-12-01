package com.blued.android.module.live_china.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.android.internal.inputmethod.InputMethodUtils;
import com.android.internal.util.cm.SpamFilter;
import com.anythink.core.common.l;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.ZegoMixStreamHelper;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.FunctionRedPModelJson;
import com.blued.android.module.live_china.model.HTMLNoticeModel;
import com.blued.android.module.live_china.model.LiveAnnounceModel;
import com.blued.android.module.live_china.model.LiveBunchLightModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveCommonSwitchExtraModel;
import com.blued.android.module.live_china.model.LiveCommonSwitchModel;
import com.blued.android.module.live_china.model.LiveEntranceData;
import com.blued.android.module.live_china.model.LiveFansLevelUpModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGuideModel;
import com.blued.android.module.live_china.model.LiveHistoryModel;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.LiveJoinRoomExtraModel;
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
import com.blued.android.module.live_china.model.LivePropCardModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomCloseReason;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomTipsModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveShakeModel;
import com.blued.android.module.live_china.model.LiveWishItemModel;
import com.blued.android.module.live_china.model.LiveWishModel;
import com.blued.android.module.live_china.model.LiveWishingDrawModel;
import com.blued.android.module.live_china.model.MuteLiveAudioModel;
import com.blued.android.module.live_china.model.RankingHourExtra;
import com.blued.android.module.live_china.msg.ILiveMsgSender;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgHandler;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveBunchLightView;
import com.blued.android.module.live_china.view.LiveMakeFriendStartView;
import com.blued.android.module.live_china.view.LivePKFirstPayView;
import com.blued.android.module.live_china.view.LivePKResult;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayingOnlineManager.class */
public class PlayingOnlineManager extends LiveMsgHandler implements LiveFloatManager.OnMediaPlayerConnectListener {
    public int a;
    public long b;
    public String c;
    private Activity f;
    private short g;
    private long h;
    private String i;
    private int j;
    private int k;
    private PlayingOnliveFragment l;
    private FrameLayout m;
    private List<LivePKProgressUserModel> n;
    private List<LivePKProgressUserModel> o;
    private List<LivePKPlayerModel> p;
    private boolean q;
    private boolean r;

    public PlayingOnlineManager(PlayingOnliveFragment playingOnliveFragment, boolean z, short s, long j, String str, int i, FrameLayout frameLayout, String str2, int i2) {
        super(playingOnliveFragment);
        this.g = (short) 4;
        this.a = 0;
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = false;
        this.r = false;
        this.f = playingOnliveFragment.getActivity();
        this.g = s;
        this.h = j;
        this.l = playingOnliveFragment;
        this.i = str;
        this.j = i;
        this.m = frameLayout;
        this.k = i2;
        LiveFloatManager.a().a(this);
        if (!z) {
            String str3 = this.l.cl;
            EventTrackLive.a(LiveProtos.Event.LIVE_ENTER_SUCCESS, LiveRoomManager.a().e(), LiveRoomManager.a().g(), TextUtils.isEmpty(str3) ? this.l.X : str3, this.l.ck, this.l.cm);
            this.l.a(0, true);
            this.l.F.setVisibility(0);
            LiveFloatManager.a().a(this.g, this.h, this.i, this.j, str2, i2);
            Logger.a("rb", "mSessionId = ", Long.valueOf(this.h), "--", Long.valueOf(LiveFloatManager.a().v()));
            LiveFloatManager.a().a(this.g, this.h, this.i, i2);
            LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveJoinRoomExtraModel>>() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<LiveJoinRoomExtraModel> bluedEntityA) {
                    if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || bluedEntityA.data.get(0).getRed_dot() == null) {
                        return;
                    }
                    LiveRoomManager.a().d = bluedEntityA.data.get(0);
                    LiveEventBus.get("live_function_red_dot", LiveJoinRoomExtraModel.class).post(bluedEntityA.data.get(0));
                }
            }, this.h, this.i, 1, i2);
            return;
        }
        if (LiveFloatManager.a().t()) {
            this.l.F.setVisibility(0);
            this.l.a(8, false);
        } else {
            if (LiveFloatManager.a().u()) {
                LiveFloatManager.a().c();
            }
            this.l.a(0, true);
            this.l.F.setVisibility(0);
        }
        if (LiveFloatManager.a().g == null) {
            a(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        LiveRoomData p;
        Log.i("==xpm", "setLiveData enterType:" + i + "  newData:" + z);
        if (z && (p = LiveRoomManager.a().p()) != null) {
            this.l.M = LiveRoomManager.a().g();
            LiveSetDataObserver.a().a(p.level, p.next_level, (int) p.percent, CommonStringUtils.b(p.gap_exp));
            if (p.watermark != null) {
                if (LiveRoomManager.a().p() != null) {
                    LiveRoomManager.a().p().watermark = p.watermark;
                }
                this.l.a(p.watermark.proportion_x, p.watermark.proportion_y, p.watermark.image, 1);
            }
            if (p.link_type == 4 && p.matchmaking != null && p.matchmaking.fans != null) {
                this.l.h(p.matchmaking.fans);
            }
            this.l.N_();
            this.l.L();
            this.l.M();
            this.l.aT();
            this.l.aS();
            this.l.aU();
            this.l.aV();
            this.l.aW();
            this.l.h();
            if (p.shout_card_audit_status) {
                this.l.a(true, "");
            }
            if (p.pk != null && p.pk.pk_voice_operate != null && !p.pk.pk_voice_operate.isEmpty()) {
                for (MuteLiveAudioModel muteLiveAudioModel : p.pk.pk_voice_operate) {
                    this.l.a(muteLiveAudioModel, false, "");
                }
            }
            k();
            LiveEventBus.get("live_luck_turning_btn").post(Boolean.valueOf(p.entrance_status == 1));
        }
    }

    public static void a(IRequestHost iRequestHost, final long j) {
        LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveHistoryModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.33
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveHistoryModel> bluedEntityA) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveRoomManager.a().a(j);
                LiveRefreshUIObserver.a().u();
                return super.onUIFailure(i, str);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveBunchLightModel liveBunchLightModel) {
        this.l.A.a(liveBunchLightModel.getImage(), liveBunchLightModel.getPlay_times());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveFriendModel liveFriendModel, int i) {
        if (this.l.L != null) {
            this.l.L.a(liveFriendModel.stream);
            if (i == 0) {
                if (liveFriendModel.fans.size() > 1) {
                    this.l.L.a(liveFriendModel.fans.get(1).stream, 1);
                }
                if (liveFriendModel.fans.size() > 2) {
                    this.l.L.a(liveFriendModel.fans.get(2).stream, 2);
                }
            } else if (i == 1) {
                if (liveFriendModel.fans.size() > 1) {
                    this.l.L.a(liveFriendModel.fans.get(0).stream, 1);
                }
                if (liveFriendModel.fans.size() > 2) {
                    this.l.L.a(liveFriendModel.fans.get(2).stream, 2);
                }
            } else if (i == 2) {
                if (liveFriendModel.fans.size() > 1) {
                    this.l.L.a(liveFriendModel.fans.get(0).stream, 1);
                }
                if (liveFriendModel.fans.size() > 2) {
                    this.l.L.a(liveFriendModel.fans.get(1).stream, 2);
                }
            }
        }
        if (this.l.L != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(LiveRoomManager.a().g());
            if (liveFriendModel.fans != null) {
                for (LiveFriendModel liveFriendModel2 : liveFriendModel.fans) {
                    if (liveFriendModel2 != null) {
                        arrayList.add(liveFriendModel2.uid);
                    }
                }
            }
            arrayList2.add(LiveRoomManager.a().e());
            ZegoMixStreamHelper.a().a(arrayList, arrayList2);
            this.l.L.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveGuideModel liveGuideModel) {
        if (this.l.bc != null) {
            this.l.bc.a(liveGuideModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveMakeLoverModel liveMakeLoverModel, int i) {
        if (this.l.L != null) {
            this.l.L.a(liveMakeLoverModel.stream);
            int i2 = 0;
            for (int i3 = 0; i3 < liveMakeLoverModel.fans.size(); i3++) {
                int i4 = i2 + 1;
                if (i3 == i) {
                    i2 = i4 - 1;
                } else {
                    i2 = i4;
                    if (!TextUtils.isEmpty(liveMakeLoverModel.fans.get(i3).uid)) {
                        Log.i("==makelover", "startZegoPlayForMakeLover:" + i4 + " : " + liveMakeLoverModel.fans.get(i3).stream);
                        this.l.L.a(liveMakeLoverModel.fans.get(i3).stream, i4);
                        i2 = i4;
                    }
                }
            }
        }
        if (this.l.L != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(LiveRoomManager.a().g());
            if (liveMakeLoverModel.fans != null) {
                for (LiveMakeLoverFansModel liveMakeLoverFansModel : liveMakeLoverModel.fans) {
                    if (liveMakeLoverFansModel != null) {
                        arrayList.add(liveMakeLoverFansModel.uid);
                    }
                }
            }
            arrayList2.add(LiveRoomManager.a().e());
            ZegoMixStreamHelper.a().a(arrayList, arrayList2);
            this.l.L.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i) {
        if (this.l.bc != null) {
            this.l.bc.a(i);
        }
    }

    public int a(long j, LivePKPlayerModel livePKPlayerModel) {
        if (j == 0) {
            this.l.bi.a(0, livePKPlayerModel);
            return 0;
        } else if (j == LiveRoomManager.a().f()) {
            this.l.bi.a(1, livePKPlayerModel);
            return 1;
        } else {
            this.l.bi.a(2, livePKPlayerModel);
            return 2;
        }
    }

    @Override // com.blued.android.module.live_china.manager.LiveFloatManager.OnMediaPlayerConnectListener
    public void a() {
        Log.v("==record", "onMediaBufferStart");
        this.l.a(0, true);
    }

    public void a(final int i) {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveRoomData>>() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.34
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomData> bluedEntityA) {
                LiveRoomData singleData = bluedEntityA.getSingleData();
                if (singleData != null) {
                    singleData.lid = PlayingOnlineManager.this.h;
                    singleData.comeCode = PlayingOnlineManager.this.i;
                    LiveRoomManager.a().a(singleData);
                    PlayingOnlineManager.this.a(i, true);
                }
            }
        }, this.h, this.i, i, this.k);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(int i, int i2, int i3, float f) {
        LiveSetDataObserver.a().a(i, i2, i3, f);
    }

    public void a(long j) {
        EventTrackLive.a(LiveProtos.Event.LIVE_LOADING, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        Map<String, String> a = BluedHttpTools.a();
        a.put("loading_time", String.valueOf(j));
        a.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, String.valueOf(this.h));
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = "live_loading";
        instantLogBody.event = 10001;
        InstantLog.a(instantLogBody, a);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(long j, int i) {
        if (TextUtils.equals(j + "", LiveRoomInfo.a().f())) {
            if (i == 0) {
                this.l.L.c();
                this.l.L.b();
                return;
            }
            this.l.L.d();
            this.l.L.a();
        }
    }

    public void a(long j, List<LivePKPlayerModel> list) {
        int i = 0;
        int i2 = j == 0 ? 0 : j == LiveRoomManager.a().f() ? 1 : 2;
        if (list == null || !this.l.r()) {
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
        this.l.bl.setResult(livePKPlusModel);
    }

    public void a(final long j, List<LivePKPlayerModel> list, int i) {
        int i2;
        if (this.l.r()) {
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
            this.l.bj.setEventCallback(new LivePKResult.EventCallBack() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.2
                @Override // com.blued.android.module.live_china.view.LivePKResult.EventCallBack
                public void a() {
                    if (j != LiveRoomManager.a().f() || PlayingOnlineManager.this.n == null || PlayingOnlineManager.this.n.size() <= 0) {
                        return;
                    }
                    PlayingOnlineManager.this.l.bk.a(((LivePKProgressUserModel) PlayingOnlineManager.this.n.get(0)).name, ((LivePKProgressUserModel) PlayingOnlineManager.this.n.get(0)).avatar);
                }
            });
            this.l.bj.setResult(i3, i2, j, i);
        }
    }

    public void a(Context context, final String str, short s, long j, IRequestHost iRequestHost) {
        Logger.a("drb", "getUserInfoFollow");
        if (this.r) {
            return;
        }
        this.r = true;
        LiveRoomHttpUtils.a(context, new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.32
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                LiveRoomUserModel liveRoomUserModel;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (liveRoomUserModel = bluedEntityA.data.get(0)) == null || TextUtils.isEmpty(liveRoomUserModel.relationship)) {
                    return;
                }
                LiveRelationshipObserver.a().a(liveRoomUserModel.relationship, str);
            }
        }, str, "", Long.valueOf(j), Short.valueOf(s), iRequestHost);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(FunctionRedPModelJson functionRedPModelJson) {
        LiveSetDataObserver.a().a(functionRedPModelJson);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveAnnounceModel liveAnnounceModel) {
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(final LiveChattingModel liveChattingModel) {
        Object obj;
        Map<String, Object> map;
        int intValue;
        super.a(liveChattingModel);
        short s = liveChattingModel.msgType;
        if (s == 106) {
            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.9
                @Override // java.lang.Runnable
                public void run() {
                    Logger.a("rrb", "被设置为场控消息");
                    LiveFloatManager.a().a(true);
                }
            });
        } else if (s == 107) {
            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.10
                @Override // java.lang.Runnable
                public void run() {
                    Logger.a("rrb", "被解除场控消息");
                    LiveFloatManager.a().a(false);
                }
            });
        } else if (s == 128) {
            LiveMsgSendManager.a().d("主播邀请观众上麦");
            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.14
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayingOnlineManager.this.l.cb.c()) {
                        PlayingOnlineManager.this.l.cb.h();
                    }
                    if (PlayingOnlineManager.this.l.ca != null) {
                        PlayingOnlineManager.this.l.ca.f();
                    }
                    new LiveMakeFriendStartView(PlayingOnlineManager.this.l).d();
                }
            });
        } else if (s == 129) {
            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.15
                @Override // java.lang.Runnable
                public void run() {
                    Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                    int intValue2 = MsgPackHelper.getIntValue(map2, SpamFilter.SpamContract.NotificationTable.COUNT);
                    long longValue = MsgPackHelper.getLongValue(map2, "uid");
                    LiveMsgSendManager a = LiveMsgSendManager.a();
                    a.d("主播忽略观众申请 uid:" + longValue + " - count:" + intValue2);
                    String f = LiveRoomInfo.a().f();
                    if (TextUtils.equals(f, longValue + "")) {
                        if (PlayingOnlineManager.this.l.cb.c()) {
                            PlayingOnlineManager.this.l.cb.h();
                        }
                        PlayingOnlineManager.this.l.cb.setState(0);
                        PlayingOnlineManager.this.l.k.a(1);
                        AppMethods.d(R.string.live_make_friend_rejected);
                    }
                    PlayingOnlineManager.this.l.k.b(intValue2);
                }
            });
        } else if (s == 131) {
            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.5
                @Override // java.lang.Runnable
                public void run() {
                    long longValue = MsgPackHelper.getLongValue(liveChattingModel.msgMapExtra, "uid");
                    int intValue2 = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, InputMethodUtils.SUBTYPE_MODE_VOICE);
                    LiveMsgSendManager a = LiveMsgSendManager.a();
                    a.d("麦序管理 uid:" + longValue + " - voice:" + intValue2);
                    PlayingOnlineManager.this.a(longValue, intValue2);
                }
            });
        } else if (s == 132) {
            LiveFriendModel liveFriendModel = (LiveFriendModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveFriendModel.class);
            if (liveFriendModel != null) {
                LiveRoomManager.a().p().friends_line = liveFriendModel;
                this.l.c(liveFriendModel);
                b(liveFriendModel);
            }
        } else if (s == 180) {
            Log.i("==makelover==", "180(join):" + liveChattingModel.getMsgExtra());
            final LiveMakeLoverModel liveMakeLoverModel = (LiveMakeLoverModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveMakeLoverModel.class);
            if (liveMakeLoverModel != null) {
                this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.19
                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        int i2;
                        PlayingOnlineManager.this.l.h(liveMakeLoverModel.fans);
                        int i3 = 0;
                        if (!TextUtils.equals(liveMakeLoverModel.uid, LiveRoomInfo.a().f())) {
                            if (PlayingOnlineManager.this.l.aD()) {
                                int i4 = 0;
                                while (true) {
                                    int i5 = i4;
                                    i = 0;
                                    if (i5 >= liveMakeLoverModel.fans.size()) {
                                        break;
                                    } else if (TextUtils.equals(liveMakeLoverModel.fans.get(i5).uid, LiveRoomInfo.a().f())) {
                                        i = i5;
                                        break;
                                    } else {
                                        i4 = i5 + 1;
                                    }
                                }
                                PlayingOnlineManager.this.a(liveMakeLoverModel, i);
                                return;
                            }
                            return;
                        }
                        LiveMakeLoverFansModel liveMakeLoverFansModel = null;
                        int i6 = 0;
                        while (true) {
                            i2 = i6;
                            if (i3 >= liveMakeLoverModel.fans.size()) {
                                break;
                            }
                            LiveMakeLoverFansModel liveMakeLoverFansModel2 = liveMakeLoverModel.fans.get(i3);
                            LiveMakeLoverFansModel liveMakeLoverFansModel3 = liveMakeLoverFansModel;
                            int i7 = i2;
                            if (liveMakeLoverFansModel2 != null) {
                                liveMakeLoverFansModel3 = liveMakeLoverFansModel;
                                i7 = i2;
                                if (TextUtils.equals(liveMakeLoverFansModel2.uid, liveMakeLoverModel.uid)) {
                                    i7 = i3;
                                    liveMakeLoverFansModel3 = liveMakeLoverFansModel2;
                                }
                            }
                            if (liveMakeLoverFansModel2 != null) {
                                liveMakeLoverFansModel2.isEmpty();
                            }
                            i3++;
                            liveMakeLoverFansModel = liveMakeLoverFansModel3;
                            i6 = i7;
                        }
                        LiveMsgSendManager.a().d("相亲上麦我的位置：" + i2);
                        if (liveMakeLoverFansModel != null) {
                            liveMakeLoverFansModel.index = i2 + 1;
                            liveMakeLoverFansModel.conference_id = liveMakeLoverModel.conference_id;
                            PlayingOnlineManager.this.l.a(liveMakeLoverFansModel);
                        }
                        PlayingOnlineManager.this.a(liveMakeLoverModel, i2);
                    }
                });
            }
        } else if (s == 181) {
            Log.i("==makelover==", "181(下麦):" + liveChattingModel.getMsgExtra());
            final LiveMakeLoverModel liveMakeLoverModel2 = (LiveMakeLoverModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveMakeLoverModel.class);
            if (liveMakeLoverModel2 != null) {
                this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.20
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveMsgSendManager a = LiveMsgSendManager.a();
                        a.d("直播间相亲下麦:" + liveMakeLoverModel2.index + "号uid：" + liveMakeLoverModel2.uid + "name:" + liveMakeLoverModel2.name);
                        PlayingOnlineManager.this.l.bY.d(liveMakeLoverModel2.uid);
                        if (TextUtils.equals(liveMakeLoverModel2.uid, LiveRoomInfo.a().f())) {
                            PlayingOnlineManager.this.l.aa();
                        } else if (PlayingOnlineManager.this.l.L != null) {
                            PlayingOnlineManager.this.l.L.a(liveMakeLoverModel2.stream, liveMakeLoverModel2.uid);
                        }
                    }
                });
            }
        } else if (s == 215) {
            Log.i("==xpp", "215暴击时刻:" + liveChattingModel.getMsgExtra());
            final LivePKDoubleModel livePKDoubleModel = (LivePKDoubleModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LivePKDoubleModel.class);
            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.26
                @Override // java.lang.Runnable
                public void run() {
                    if (livePKDoubleModel != null) {
                        if (PlayingOnlineManager.this.l.r() || PlayingOnlineManager.this.l.s()) {
                            PlayingOnlineManager.this.l.a(livePKDoubleModel.buff_countdown);
                        }
                    }
                }
            });
        } else if (s == 216) {
            Log.i("==wish", "216:" + liveChattingModel.getMsgExtra());
            LiveWishItemModel liveWishItemModel = (LiveWishItemModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveWishItemModel.class);
            if (liveWishItemModel != null) {
                this.l.a(liveWishItemModel);
            }
        } else {
            switch (s) {
                case 37:
                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.3
                        @Override // java.lang.Runnable
                        public void run() {
                            LiveSetDataObserver.a().b(liveChattingModel);
                        }
                    });
                    return;
                case 44:
                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.4
                        @Override // java.lang.Runnable
                        public void run() {
                            PlayingOnlineManager.this.l.at();
                        }
                    });
                    return;
                case 93:
                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.6
                        @Override // java.lang.Runnable
                        public void run() {
                            Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                            if (map2 != null) {
                                PlayingOnlineManager.this.a = MsgPackHelper.getIntValue(map2, "live_status");
                            }
                        }
                    });
                    return;
                case 102:
                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.7
                        @Override // java.lang.Runnable
                        public void run() {
                            Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                            if (map2 != null) {
                                String stringValue = MsgPackHelper.getStringValue(map2, "gift_apng");
                                String stringValue2 = MsgPackHelper.getStringValue(map2, "gift_mp4");
                                Logger.a("rrb", "财富等级提升消息 gift_apng:", stringValue + " gift_mp4：" + stringValue2);
                                if (liveChattingModel.fromId == Integer.valueOf(LiveRoomInfo.a().f()).intValue()) {
                                    if (!TextUtils.isEmpty(stringValue) || !TextUtils.isEmpty(stringValue2)) {
                                        LiveGiftModel liveGiftModel = new LiveGiftModel();
                                        if (!TextUtils.isEmpty(stringValue)) {
                                            if (stringValue.endsWith(".gif")) {
                                                liveGiftModel.images_gif = stringValue;
                                            } else {
                                                liveGiftModel.images_apng2 = stringValue;
                                            }
                                        }
                                        if (!TextUtils.isEmpty(stringValue2)) {
                                            liveGiftModel.images_mp4 = stringValue2;
                                        }
                                        LiveSetDataObserver.a().b(liveGiftModel);
                                    }
                                    LiveRefreshUIObserver.a().r();
                                }
                            }
                        }
                    });
                    return;
                case 134:
                    final LiveFriendModel liveFriendModel2 = (LiveFriendModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveFriendModel.class);
                    if (liveFriendModel2 != null) {
                        this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.16
                            @Override // java.lang.Runnable
                            public void run() {
                                int i;
                                if (liveFriendModel2.fans != null) {
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i2;
                                        if (i3 >= liveFriendModel2.fans.size()) {
                                            break;
                                        }
                                        LiveMsgSendManager.a().d("直播间上麦:" + i3 + "号uid：" + liveFriendModel2.fans.get(i3).uid + "name:" + liveFriendModel2.fans.get(i3).name);
                                        i2 = i3 + 1;
                                    }
                                    PlayingOnlineManager.this.l.a_(liveFriendModel2.fans);
                                }
                                if (TextUtils.equals(liveFriendModel2.uid, LiveRoomInfo.a().f())) {
                                    LiveMsgSendManager.a().d("直播间上麦我的位置：" + liveFriendModel2.index);
                                    if (liveFriendModel2.fans.size() > liveFriendModel2.index - 1) {
                                        LiveFriendModel liveFriendModel3 = liveFriendModel2.fans.get(liveFriendModel2.index - 1);
                                        Log.v("pk", "用户上麦  我的推流id：" + liveFriendModel3.stream);
                                        liveFriendModel3.index = liveFriendModel2.index;
                                        liveFriendModel3.conference_id = liveFriendModel2.conference_id;
                                        liveFriendModel3.conference_token = liveFriendModel2.conference_token;
                                        Log.v("pk", "用户上麦  index：" + liveFriendModel3.index);
                                        PlayingOnlineManager.this.l.d(liveFriendModel3);
                                    }
                                    if (PlayingOnlineManager.this.l.L != null) {
                                        Log.v("pk", "用户上麦  拉取主播流id：" + liveFriendModel2.stream);
                                        PlayingOnlineManager.this.l.L.a(liveFriendModel2.stream);
                                        PlayingOnlineManager.this.l.L.c();
                                        PlayingOnlineManager.this.l.L.b();
                                    }
                                    PlayingOnlineManager playingOnlineManager = PlayingOnlineManager.this;
                                    LiveFriendModel liveFriendModel4 = liveFriendModel2;
                                    playingOnlineManager.a(liveFriendModel4, liveFriendModel4.index - 1);
                                } else if (PlayingOnlineManager.this.l.aB()) {
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        i = 0;
                                        if (i5 >= liveFriendModel2.fans.size()) {
                                            break;
                                        } else if (TextUtils.equals(liveFriendModel2.fans.get(i5).uid, LiveRoomInfo.a().f())) {
                                            i = i5;
                                            break;
                                        } else {
                                            i4 = i5 + 1;
                                        }
                                    }
                                    PlayingOnlineManager.this.a(liveFriendModel2, i);
                                }
                                PlayingOnlineManager.this.l.k.b(liveFriendModel2.count);
                            }
                        });
                        return;
                    }
                    return;
                case 155:
                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.17
                        @Override // java.lang.Runnable
                        public void run() {
                            Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                            MsgPackHelper.getIntValue(map2, "level");
                            String stringValue = MsgPackHelper.getStringValue(map2, "resource");
                            LiveGiftModel liveGiftModel = new LiveGiftModel();
                            liveGiftModel.images_apng2 = stringValue;
                            LiveSetDataObserver.a().b(liveGiftModel);
                        }
                    });
                    return;
                case 157:
                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.18
                        @Override // java.lang.Runnable
                        public void run() {
                            Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                            PlayingOnlineManager.this.l.a(MsgPackHelper.getFloatValue(map2, "proportion_x"), MsgPackHelper.getFloatValue(map2, "proportion_y"), MsgPackHelper.getStringValue(map2, "image"), MsgPackHelper.getIntValue(map2, "add"));
                        }
                    });
                    return;
                case 173:
                    Logger.a("rrb", "收到粉丝等级提升消息");
                    LiveFansLevelUpModel liveFansLevelUpModel = null;
                    try {
                        if (!TextUtils.isEmpty(liveChattingModel.getMsgExtra())) {
                            liveFansLevelUpModel = (LiveFansLevelUpModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveFansLevelUpModel.class);
                        }
                        if (liveFansLevelUpModel != null) {
                            final LiveFansLevelUpModel liveFansLevelUpModel2 = liveFansLevelUpModel;
                            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    LiveFansObserver.a().a(liveFansLevelUpModel2.level);
                                }
                            });
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 200:
                    Log.i("==livetask==", "200(主态新主播任务):" + liveChattingModel.getMsgExtra());
                    return;
                case 220:
                    Log.i("==wish", "220:" + liveChattingModel.getMsgExtra());
                    LiveWishModel liveWishModel = (LiveWishModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveWishModel.class);
                    if (liveWishModel == null || LiveRoomManager.a().p() == null) {
                        return;
                    }
                    LiveRoomManager.a().p().wishList = liveWishModel.wish_list;
                    this.l.L();
                    return;
                case 236:
                    LiveWishingDrawModel liveWishingDrawModel = (LiveWishingDrawModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveWishingDrawModel.class);
                    if (liveWishingDrawModel == null || LiveRoomManager.a().p() == null) {
                        return;
                    }
                    LiveRoomManager.a().p().wishing_well = liveWishingDrawModel;
                    this.l.a(liveWishingDrawModel);
                    return;
                case 250:
                    if (liveChattingModel instanceof LiveChattingModel) {
                        this.l.a((HTMLNoticeModel) LiveChattingModel.copy(liveChattingModel).getObjExtra());
                        return;
                    }
                    return;
                case 266:
                    LiveCommonSwitchModel liveCommonSwitchModel = (LiveCommonSwitchModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveCommonSwitchModel.class);
                    if (liveCommonSwitchModel.getId() == 1) {
                        this.l.a(false, liveCommonSwitchModel.getContent());
                        if (liveCommonSwitchModel.getStatus() == 1) {
                            LiveMsgSendManager.a().c(((LiveCommonSwitchExtraModel) AppInfo.f().fromJson(liveCommonSwitchModel.getExtra(), LiveCommonSwitchExtraModel.class)).getOther());
                            return;
                        }
                        return;
                    }
                    return;
                case 269:
                    if (this.l.aT == null || liveChattingModel.msgMapExtra == null || !liveChattingModel.msgMapExtra.containsKey("bunchLightModel") || (obj = liveChattingModel.msgMapExtra.get("bunchLightModel")) == null || !(obj instanceof LiveBunchLightModel)) {
                        return;
                    }
                    if (this.l.A == null) {
                        this.l.A = new LiveBunchLightView(this.f);
                        this.l.A.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        this.l.aT.addView(this.l.A);
                    }
                    final LiveBunchLightModel liveBunchLightModel = (LiveBunchLightModel) obj;
                    this.l.A.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$PlayingOnlineManager$0Nnd3ClveSfopHN7aYhOaQ4A9SM
                        @Override // java.lang.Runnable
                        public final void run() {
                            PlayingOnlineManager.this.a(liveBunchLightModel);
                        }
                    });
                    return;
                default:
                    switch (s) {
                        case 119:
                            final LiveFriendModel liveFriendModel3 = (LiveFriendModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveFriendModel.class);
                            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.11
                                @Override // java.lang.Runnable
                                public void run() {
                                    Logger.a("pk", "好友、观众连线邀请");
                                    LiveMsgSendManager.a().d("收到连麦邀请消息");
                                    if (liveFriendModel3.type == 1) {
                                        if (liveFriendModel3.reset != 0) {
                                            if (liveFriendModel3.reset == 1) {
                                                PlayingOnlineManager.this.l.by.b(liveFriendModel3);
                                                AppMethods.d(R.string.live_connection_anchor_cancel);
                                            }
                                        } else if (PlayingOnlineManager.this.l.r() || PlayingOnlineManager.this.l.aQ) {
                                        } else {
                                            liveFriendModel3.model = 2;
                                            PlayingOnlineManager.this.l.by.a(liveFriendModel3);
                                        }
                                    }
                                }
                            });
                            return;
                        case 120:
                            this.l.y = true;
                            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.12
                                @Override // java.lang.Runnable
                                public void run() {
                                    Logger.a("pk", "开始连麦");
                                    Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                                    if (map2 != null) {
                                        String stringValue = MsgPackHelper.getStringValue(map2, "conference_id");
                                        MsgPackHelper.getStringValue(map2, "conference_token");
                                        String stringValue2 = MsgPackHelper.getStringValue(map2, "target_token");
                                        String stringValue3 = MsgPackHelper.getStringValue(map2, "name");
                                        long longValue = MsgPackHelper.getLongValue(map2, "uid");
                                        int intValue2 = MsgPackHelper.getIntValue(map2, "type");
                                        String stringValue4 = MsgPackHelper.getStringValue(map2, "stream");
                                        String stringValue5 = MsgPackHelper.getStringValue(map2, "target_stream");
                                        LiveMsgSendManager a = LiveMsgSendManager.a();
                                        a.d("收到连麦开始消息,当前连麦uid:" + longValue);
                                        if (intValue2 == 0) {
                                            PlayingOnlineManager.this.b = longValue;
                                            PlayingOnlineManager.this.c = stringValue3;
                                            PlayingOnlineManager.this.l.g(false);
                                            Logger.a("pk", "111");
                                            PlayingOnlineManager.this.l.cq = true;
                                            PlayingOnlineManager.this.l.d_(2);
                                        } else {
                                            if (TextUtils.equals(String.valueOf(longValue), LiveRoomInfo.a().f())) {
                                                PlayingOnlineManager.this.b = LiveRoomManager.a().f();
                                                PlayingOnlineManager.this.l.a(JoinLiveResult.SUCCESS, stringValue, stringValue2, stringValue4, stringValue5, 0);
                                                PlayingOnlineManager.this.l.g(true);
                                                AppMethods.d(R.string.live_connection_to_begin);
                                                PlayingOnlineManager.this.l.d_(4);
                                            } else {
                                                PlayingOnlineManager.this.b = longValue;
                                                PlayingOnlineManager.this.c = stringValue3;
                                                PlayingOnlineManager.this.l.g(false);
                                                Logger.a("pk", "222");
                                                PlayingOnlineManager.this.l.d_(3);
                                            }
                                            PlayingOnlineManager.this.l.cq = false;
                                        }
                                        PlayingOnlineManager.this.l.g_(8);
                                    }
                                }
                            });
                            return;
                        case 121:
                            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.13
                                @Override // java.lang.Runnable
                                public void run() {
                                    LiveMsgSendManager.a().d("收到连麦结束消息");
                                    Logger.a("pk", "结束连麦");
                                    Map<String, Object> map2 = liveChattingModel.msgMapExtra;
                                    MsgPackHelper.getLongValue(map2, "closed_by");
                                    if (MsgPackHelper.getIntValue(map2, "type") == 1) {
                                        if (PlayingOnlineManager.this.l.aQ) {
                                            PlayingOnlineManager.this.l.h(false);
                                        } else {
                                            PlayingOnlineManager.this.l.am();
                                        }
                                    }
                                    PlayingOnlineManager.this.l.cq = false;
                                    PlayingOnlineManager.this.l.d_(0);
                                    PlayingOnlineManager.this.l.y = false;
                                    PlayingOnlineManager.this.l.g_(0);
                                }
                            });
                            return;
                        case 122:
                            LiveMsgSendManager.a().d("收到拒绝连麦邀请");
                            return;
                        default:
                            switch (s) {
                                case 184:
                                    Log.i("==makelover==", "184(重置灯):" + liveChattingModel.getMsgExtra());
                                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.21
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            PlayingOnlineManager.this.l.bW.b();
                                        }
                                    });
                                    return;
                                case 185:
                                    Log.i("==makelover==", "185(爆照):" + liveChattingModel.getMsgExtra());
                                    final LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverFansModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveMakeLoverFansModel.class);
                                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.22
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            PlayingOnlineManager.this.l.bY.a(liveMakeLoverFansModel.uid, liveMakeLoverFansModel.pic);
                                        }
                                    });
                                    return;
                                case 186:
                                    Log.i("==makelover==", "186(主同意):" + liveChattingModel.getMsgExtra());
                                    LiveMsgSendManager.a().d("主播邀请观众相亲上麦");
                                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.23
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (PlayingOnlineManager.this.l.O()) {
                                                PlayingOnlineManager.this.l.P();
                                            }
                                            LiveMakeLoverManager.a(3);
                                            PlayingOnlineManager.this.l.N();
                                        }
                                    });
                                    return;
                                case 187:
                                    Log.i("==makelover==", "187(主拒绝):" + liveChattingModel.getMsgExtra());
                                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.24
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            long longValue = MsgPackHelper.getLongValue(liveChattingModel.msgMapExtra, "uid");
                                            LiveMsgSendManager a = LiveMsgSendManager.a();
                                            a.d("主播忽略观众相亲申请 uid:" + longValue);
                                            String f = LiveRoomInfo.a().f();
                                            if (TextUtils.equals(f, longValue + "")) {
                                                if (PlayingOnlineManager.this.l.O()) {
                                                    PlayingOnlineManager.this.l.P();
                                                }
                                                LiveMakeLoverManager.a(1);
                                                AppMethods.d(R.string.live_make_friend_rejected);
                                            }
                                        }
                                    });
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
                                    this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.25
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            long longValue = MsgPackHelper.getLongValue(liveChattingModel.msgMapExtra, "uid");
                                            LiveMsgSendManager.a().d("观众拒绝主播相亲邀请");
                                            String f = LiveRoomInfo.a().f();
                                            if (TextUtils.equals(f, longValue + "")) {
                                                if (PlayingOnlineManager.this.l.O()) {
                                                    PlayingOnlineManager.this.l.P();
                                                }
                                                LiveMakeLoverManager.a(1);
                                            }
                                        }
                                    });
                                    return;
                                default:
                                    switch (s) {
                                        case 226:
                                            if (liveChattingModel == null || liveChattingModel.msgMapExtra == null || (intValue = MsgPackHelper.getIntValue((map = liveChattingModel.msgMapExtra), "show_type")) == 1) {
                                                return;
                                            }
                                            final LiveGuideModel liveGuideModel = new LiveGuideModel();
                                            liveGuideModel.id = MsgPackHelper.getIntValue(map, "id");
                                            liveGuideModel.type = MsgPackHelper.getIntValue(map, "type");
                                            liveGuideModel.sub_type = MsgPackHelper.getIntValue(map, "sub_type");
                                            liveGuideModel.content = MsgPackHelper.getStringValue(map, l.y);
                                            liveGuideModel.url = MsgPackHelper.getStringValue(map, "url");
                                            liveGuideModel.strategy = MsgPackHelper.getIntValue(map, "strategy");
                                            liveGuideModel.frequency = MsgPackHelper.getIntValue(map, "frequency");
                                            liveGuideModel.count = MsgPackHelper.getIntValue(map, SpamFilter.SpamContract.NotificationTable.COUNT);
                                            liveGuideModel.countdown = MsgPackHelper.getIntValue(map, "countdown");
                                            liveGuideModel.show_type = intValue;
                                            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$PlayingOnlineManager$FxGODyjdtuMr5bWHh-QYKZjVOKU
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    PlayingOnlineManager.this.a(liveGuideModel);
                                                }
                                            });
                                            return;
                                        case 227:
                                            if (liveChattingModel == null || liveChattingModel.msgMapExtra == null) {
                                                return;
                                            }
                                            final int intValue2 = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "id");
                                            this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$PlayingOnlineManager$o0faCB1amHxr_I8z2-5OobHtMz4
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    PlayingOnlineManager.this.b(intValue2);
                                                }
                                            });
                                            return;
                                        case 228:
                                            RankingHourExtra rankingHourExtra = (RankingHourExtra) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), RankingHourExtra.class);
                                            this.l.a(rankingHourExtra.rank, rankingHourExtra.need_score);
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
            }
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveFriendModel liveFriendModel) {
        Logger.a("pk", "收到PK开始消息--startPK");
        if (liveFriendModel != null) {
            f(new ArrayList());
            g(new ArrayList());
            h(liveFriendModel.records);
        }
        this.l.a(liveFriendModel);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveHornModelNew liveHornModelNew, LiveGiftModel liveGiftModel) {
        LiveSetDataObserver.a().a(liveHornModelNew, false);
        if (liveGiftModel != null) {
            LiveSetDataObserver.a().b(liveGiftModel);
            LiveSetDataObserver.a().b(liveGiftModel);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveInviteUserModel liveInviteUserModel) {
        this.l.a(liveInviteUserModel);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveKickUserModel liveKickUserModel) {
        if (liveKickUserModel != null) {
            if (!TextUtils.equals(String.valueOf(liveKickUserModel.uid), LiveRoomInfo.a().f())) {
                LiveMsgSendManager.a().a(liveKickUserModel.uid, liveKickUserModel.name);
                return;
            }
            this.l.aR();
            AppMethods.d(R.string.live_kickd);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LivePKProgressModel livePKProgressModel) {
        if (livePKProgressModel == null) {
            return;
        }
        int i = 0;
        if (livePKProgressModel.uid == LiveRoomManager.a().f()) {
            this.l.bh.setOurProgress(livePKProgressModel.total);
            if (o() && livePKProgressModel.top != null && livePKProgressModel.top.size() > 0) {
                this.l.bk.a(0, livePKProgressModel.top.get(0).name, livePKProgressModel.top.get(0).avatar);
            }
        } else {
            this.l.bs.a(livePKProgressModel.score);
            this.l.bh.setOtherProgress(livePKProgressModel.total);
            if (o() && livePKProgressModel.target_top != null && livePKProgressModel.target_top.size() > 0) {
                this.l.bk.a(1, livePKProgressModel.target_top.get(0).name, livePKProgressModel.target_top.get(0).avatar);
            }
        }
        this.l.bi.setData(livePKProgressModel);
        f(livePKProgressModel.top);
        g(livePKProgressModel.target_top);
        LivePKFirstPayView livePKFirstPayView = this.l.bw;
        if (!o()) {
            i = 8;
        }
        livePKFirstPayView.setVisibility(i);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LivePKResultModel livePKResultModel) {
        Log.i("==xpm", "onPkEnd:" + livePKResultModel.toString());
        LivePKPlayerModel livePKPlayerModel = null;
        LivePKPlayerModel livePKPlayerModel2 = null;
        this.l.a((LiveFriendModel) null);
        this.l.bw.setVisibility(8);
        this.l.bv.c();
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
                    this.b = next.uid;
                    livePKPlayerModel2 = next;
                }
            }
        }
        if (livePKResultModel.pk_type == 0) {
            a(livePKResultModel.winner, livePKPlayerModel);
        }
        a(livePKResultModel.winner, livePKResultModel.records);
        a(livePKResultModel.winner, livePKResultModel.records, livePKResultModel.pk_type);
        a(livePKResultModel.records);
        this.l.bv.a(livePKResultModel.countdown);
        this.l.i(false);
        if (livePKResultModel.type == 3) {
            AppMethods.a((CharSequence) this.l.getString(R.string.live_pk_connect_fail_toast));
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LivePkRoundModel livePkRoundModel) {
        if (this.l.r() && livePkRoundModel != null) {
            if (livePkRoundModel.pk_status) {
                this.l.b(livePkRoundModel);
                return;
            }
            f(new ArrayList());
            g(new ArrayList());
            this.l.a(livePkRoundModel);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LivePkTypeModel livePkTypeModel) {
        if (this.l.r() && livePkTypeModel != null && livePkTypeModel.pk_type == 0) {
            LiveFriendModel liveFriendModel = new LiveFriendModel();
            liveFriendModel.countdown = livePkTypeModel.countdown;
            this.l.b(liveFriendModel);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveRewardModel liveRewardModel) {
        LiveSetDataObserver.a().a(liveRewardModel);
    }

    @Override // com.blued.android.module.live_china.manager.LiveFloatManager.OnMediaPlayerConnectListener
    public void a(final LiveRoomCloseReason liveRoomCloseReason) {
        this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.29
            @Override // java.lang.Runnable
            public void run() {
                PlayingOnlineManager.this.f.setRequestedOrientation(1);
                PlayingOnlineManager.this.l.a(8, false);
                PlayingOnlineManager.this.l.a(liveRoomCloseReason);
            }
        });
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveRoomTipsModel liveRoomTipsModel) {
        LiveSetDataObserver.a().a(liveRoomTipsModel);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(LiveShakeModel liveShakeModel) {
        if (liveShakeModel == null) {
            return;
        }
        this.l.a(liveShakeModel);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(String str) {
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(String str, String str2) {
    }

    public void a(List<LivePKPlayerModel> list) {
        LivePKPlayerModel next;
        if (list == null || !this.l.r()) {
            return;
        }
        Iterator<LivePKPlayerModel> it = list.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.uid != LiveRoomManager.a().f()) {
                this.b = next.uid;
            }
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void a(List<LiveInviteUserModel> list, LiveInviteUserModel liveInviteUserModel) {
        this.l.a(list, liveInviteUserModel);
    }

    @Override // com.blued.android.module.live_china.manager.LiveFloatManager.OnMediaPlayerConnectListener
    public void a(final boolean z) {
        if (this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.30
            @Override // java.lang.Runnable
            public void run() {
                if (LiveRoomManager.a().t()) {
                    return;
                }
                if (PlayingOnlineManager.this.l == null || PlayingOnlineManager.this.l.getFragmentActive() == null || !PlayingOnlineManager.this.l.getFragmentActive().isActive()) {
                    LiveFloatManager.a().e(true);
                } else if (PlayingOnlineManager.this.l == null || PlayingOnlineManager.this.l.t != LiveRoomManager.a().d()) {
                } else {
                    PlayingOnlineManager playingOnlineManager = PlayingOnlineManager.this;
                    playingOnlineManager.a(playingOnlineManager.f, LiveRoomManager.a().g(), PlayingOnlineManager.this.g, PlayingOnlineManager.this.h, PlayingOnlineManager.this.l.getFragmentActive());
                    LiveRoomUtils.a(PlayingOnlineManager.this.l.getFragmentActive(), "1");
                    PlayingOnlineManager.this.a(1, z);
                    if (LiveRoomManager.a().p() == null || TextUtils.isEmpty(LiveRoomManager.a().p().live_url)) {
                        return;
                    }
                    PlayingOnlineManager.this.l.be = LiveRoomManager.a().p().is_manager == 1;
                    Logger.a("rrb", "enterLiveSuccess isLiveManager 111111111= ", Boolean.valueOf(PlayingOnlineManager.this.l.be));
                    final LiveRoomData p = LiveRoomManager.a().p();
                    if (p.screen_pattern == 1) {
                        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.30.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LiveFloatManager.a().e(true);
                                PlayingOnlineManager.this.l.bd.b();
                            }
                        });
                    }
                    if (z || LiveFloatManager.a().G()) {
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.30.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (p.effects == null || (TextUtils.isEmpty(p.effects.contents) && TextUtils.isEmpty(p.effects.url) && TextUtils.isEmpty(p.effects.medium_image) && TextUtils.isEmpty(p.effects.background_color) && TextUtils.isEmpty(p.effects.gift_apng) && TextUtils.isEmpty(p.effects.entrance_gif) && TextUtils.isEmpty(p.effects.entrance_apng) && TextUtils.isEmpty(p.effects.entrance_mp4))) {
                                    PlayingOnlineManager.this.m();
                                } else {
                                    LiveEntranceData liveEntranceData = new LiveEntranceData();
                                    liveEntranceData.entranceContents = p.effects.contents;
                                    liveEntranceData.entranceImage = p.effects.url;
                                    liveEntranceData.entranceColor = p.effects.background_color;
                                    liveEntranceData.entranceGif = p.effects.entrance_gif;
                                    liveEntranceData.entranceApng = p.effects.entrance_apng;
                                    liveEntranceData.entranceAnim = p.effects.gift_apng;
                                    liveEntranceData.entranceMp4 = p.effects.entrance_mp4;
                                    liveEntranceData.medium_image = p.effects.medium_image;
                                    liveEntranceData.avatar_frame = p.avatar_frame;
                                    liveEntranceData.userData = new ProfileData();
                                    liveEntranceData.userData.isLiveManager = PlayingOnlineManager.this.l.be;
                                    liveEntranceData.userData.uid = StringUtils.a(LiveRoomInfo.a().f(), 0L);
                                    liveEntranceData.userData.name = LiveRoomInfo.a().c();
                                    liveEntranceData.userData.richLevel = LiveRoomInfo.a().r();
                                    liveEntranceData.userData.avatar = LiveRoomInfo.a().d();
                                    liveEntranceData.userData.liangType = p.liang_type;
                                    liveEntranceData.userData.liangId = p.liang_id;
                                    LiveEventBusUtil.a(liveEntranceData);
                                    if (!TextUtils.isEmpty(liveEntranceData.entranceApng) || !TextUtils.isEmpty(liveEntranceData.entranceGif) || !TextUtils.isEmpty(liveEntranceData.entranceMp4)) {
                                        LiveGiftModel liveGiftModel = new LiveGiftModel();
                                        liveGiftModel.images_gif = liveEntranceData.entranceGif;
                                        liveGiftModel.images_apng2 = liveEntranceData.entranceApng;
                                        liveGiftModel.images_mp4 = liveEntranceData.entranceMp4;
                                        liveGiftModel.userId = LiveRoomInfo.a().g();
                                        liveGiftModel.enterAnimLocal = true;
                                        LiveSetDataObserver.a().b(liveGiftModel);
                                    }
                                    PlayingOnlineManager.this.m();
                                }
                                LiveFloatManager.a().e(false);
                            }
                        }, 1500L);
                    }
                    PlayingOnlineManager.this.l.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.30.3
                        @Override // java.lang.Runnable
                        public void run() {
                            LiveSetDataObserver.a().a(p.elapse_time);
                            LiveSetDataObserver.a().u();
                        }
                    }, 2000L);
                    if (PlayingOnlineManager.this.l.getArguments() != null && PlayingOnlineManager.this.l.getArguments().getBoolean("is_open_fans", false)) {
                        PlayingOnlineManager.this.l.K();
                    }
                    PlayingOnlineManager.this.l.A();
                    PlayingOnlineManager.this.l.B();
                    LiveFloatManager.a().a(PlayingOnlineManager.this.l.be);
                    if (PlayingOnlineManager.this.l.ci != null) {
                        PlayingOnlineManager.this.l.ci.b();
                    }
                    if (p.link_type == 4) {
                        PlayingOnlineManager.this.l.Z();
                    }
                    LiveRoomPreferences.i(LiveRoomPreferences.M() + 1);
                    LiveRoomHttpUtils.a(PlayingOnlineManager.this.l.getFragmentActive());
                }
            }
        })) {
            return;
        }
        LiveFloatManager.a().e(true);
    }

    @Override // com.blued.android.module.live_china.manager.LiveFloatManager.OnMediaPlayerConnectListener
    public void b() {
        Log.v("==record", "onMediaBufferEnd");
        this.l.a(8, true);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void b(LiveFriendModel liveFriendModel) {
        super.b(liveFriendModel);
    }

    @Override // com.blued.android.module.live_china.manager.LiveFloatManager.OnMediaPlayerConnectListener
    public void b(LiveRoomCloseReason liveRoomCloseReason) {
        PlayingOnliveFragment playingOnliveFragment = this.l;
        if (playingOnliveFragment == null || playingOnliveFragment.getFragmentActive() == null || !this.l.getFragmentActive().isActive()) {
        }
    }

    public void b(String str) {
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.31
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                AppMethods.a((CharSequence) AppInfo.d().getString(R.string.liveVideo_livingView_tips_reportSuccess));
            }
        }, String.valueOf(this.h), str);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void b(List<LiveInviteUserModel> list) {
        this.l.d(list);
    }

    @Override // com.blued.android.module.live_china.manager.LiveFloatManager.OnMediaPlayerConnectListener
    public void c() {
        this.l.a(8, true);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void c(LiveFriendModel liveFriendModel) {
        if (TextUtils.equals(liveFriendModel.uid, LiveRoomInfo.a().f())) {
            this.l.X();
        } else if (this.l.L != null) {
            this.l.L.a(liveFriendModel.stream, liveFriendModel.uid);
        }
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void c(List<LiveInviteUserModel> list) {
        this.l.e(list);
    }

    @Override // com.blued.android.module.live_china.manager.LiveFloatManager.OnMediaPlayerConnectListener
    public void d() {
        this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.27
            @Override // java.lang.Runnable
            public void run() {
                Log.v("==record", "retryConnect");
                PlayingOnlineManager.this.l.a(0, true);
            }
        });
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void d(List<LiveInviteUserModel> list) {
        this.l.f(list);
    }

    @Override // com.blued.android.module.live_china.manager.LiveFloatManager.OnMediaPlayerConnectListener
    public void e() {
        this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.PlayingOnlineManager.28
            @Override // java.lang.Runnable
            public void run() {
                PlayingOnlineManager.this.l.a(8, false);
                PlayingOnlineManager.this.l.a((LiveRoomCloseReason) null);
            }
        });
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void e(List<LiveInviteUserModel> list) {
        this.l.g(list);
    }

    public void f() {
        if (LiveFloatManager.a().A()) {
            LiveRoomUtils.a(this.l.getFragmentActive(), "1");
        }
    }

    public void f(List<LivePKProgressUserModel> list) {
        this.n.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.n.addAll(list);
    }

    public void g() {
    }

    public void g(List<LivePKProgressUserModel> list) {
        this.o.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.o.addAll(list);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void h() {
        this.l.cb.setState(0);
        this.l.k.a(1);
    }

    public void h(List<LivePKPlayerModel> list) {
        this.p.clear();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.p.addAll(list);
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void i() {
        LiveSetDataObserver.a().r();
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void j() {
        this.l.Y();
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void k() {
        LiveSetDataObserver.a().B();
    }

    @Override // com.blued.android.module.live_china.msg.LiveMsgHandler
    public void l() {
    }

    public void m() {
        LiveChattingModel copy = LiveChattingModel.copy(ChatHelper.getChattingModelForSendmsg(LiveRoomManager.a().p().lid, (short) 27, this.f.getString(R.string.live_coming), null, "", (short) 4));
        copy.fromId = LiveRoomInfo.a().g();
        ILiveMsgSender.c(copy);
        copy.fromAvatar = LiveRoomInfo.a().d();
        copy.fromNickName = LiveCloakingUtil.a(LiveRoomInfo.a().c(), LiveCloakingUtil.a);
        if (LiveRoomManager.a().N() == null || TextUtils.isEmpty(LiveRoomManager.a().N().getNoble_join_text())) {
            copy.msgContent = this.f.getString(R.string.live_coming);
        } else {
            copy.msgContent = LiveRoomManager.a().N().getNoble_join_text();
        }
        LivePropCardModel livePropCardModel = LiveRoomManager.a().p().recommend_prop_info;
        if (livePropCardModel != null) {
            if (copy.msgMapExtra == null) {
                copy.msgMapExtra = new HashMap();
            }
            MsgPackHelper.putMapValue(copy.msgMapExtra, "anchor_pocket_traffic_card", livePropCardModel.getAnchor_pocket_traffic_card());
            MsgPackHelper.putMapValue(copy.msgMapExtra, "anchor_pocket_traffic_card_name", livePropCardModel.getAnchor_pocket_traffic_card_name());
        }
        if (this.l.be) {
            copy.fromLiveManager = 1;
        }
        Logger.a("rrb", "自己进场普通动效 12= ", Integer.valueOf(copy.fromLiveManager));
        if (LiveRoomManager.a().A()) {
            LiveRoomManager.a().b(copy);
        } else {
            LiveSetDataObserver.a().c(copy);
        }
    }

    public void n() {
        EventTrackLive.a(LiveProtos.Event.LIVE_INTERRUPT, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        Map<String, String> a = BluedHttpTools.a();
        a.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, String.valueOf(this.h));
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = "live_interrupt";
        instantLogBody.event = 20001;
        InstantLog.a(instantLogBody, a);
    }

    public boolean o() {
        return this.n.size() == 0 && this.o.size() == 0;
    }
}
