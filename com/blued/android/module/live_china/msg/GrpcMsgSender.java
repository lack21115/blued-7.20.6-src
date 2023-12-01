package com.blued.android.module.live_china.msg;

import android.app.Instrumentation;
import android.graphics.Point;
import android.text.TextUtils;
import cn.irisgw.live.Animation;
import cn.irisgw.live.ChallengeEggResult;
import cn.irisgw.live.ChallengeEnd;
import cn.irisgw.live.ChallengeKill;
import cn.irisgw.live.ChallengeMatch;
import cn.irisgw.live.ChallengeProp;
import cn.irisgw.live.ChallengeSync;
import cn.irisgw.live.ChallengeUpdate;
import cn.irisgw.live.CustomRank;
import cn.irisgw.live.DrawGoods;
import cn.irisgw.live.GiftExtra;
import cn.irisgw.live.GoodsLuckBag;
import cn.irisgw.live.LiveChatOuterClass;
import cn.irisgw.live.LoveFan;
import cn.irisgw.live.Prop;
import cn.irisgw.live.UserProp;
import cn.irisgw.live.WinningPrize;
import cn.irisgw.live.WishingContest;
import cn.irisgw.live.WishingContestText;
import com.android.internal.inputmethod.InputMethodUtils;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.blued.android.module.live.base.event.LiveBeansChangeEvent;
import com.blued.android.module.live.im.LiveIM;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.DefinedRankInfo;
import com.blued.android.module.live_china.model.LiveBubbleBgModel;
import com.blued.android.module.live_china.model.LiveDefinedRankModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlTransModel;
import com.blued.android.module.live_china.model.LiveGiftWallFloatModel;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.model.LiveWishContestContentModel;
import com.blued.android.module.live_china.model.LiveWishCourtModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.model.MuteLiveAudioModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.PkDaredObserver;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.EventTrackUtils;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/GrpcMsgSender.class */
public class GrpcMsgSender extends ILiveMsgSender {

    /* renamed from: c  reason: collision with root package name */
    private String f13933c;
    private String d;
    private String e;

    /* renamed from: a  reason: collision with root package name */
    private final String f13932a = "GrpcMsgSender";
    private boolean b = false;
    private long f = 0;
    private long g = 0;
    private final Map<String, Set<LiveChatInfoListener>> h = new HashMap();
    private OnConnectStateListener i = new OnConnectStateListener() { // from class: com.blued.android.module.live_china.msg.GrpcMsgSender.2
        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onConnected() {
            LogUtils.c("GrpcMsgSender", "connect onConnected");
            if (LiveRoomManager.a().d() > 0) {
                LiveRoomHttpUtils.a((BluedUIHttpResponse) null, LiveRoomManager.a().d(), LiveRoomManager.a().p().comeCode, 1, LiveRoomManager.a().p().liveProp);
                LiveRoomHttpUtils.a((BluedUIHttpResponse) null, (IRequestHost) null, LiveRoomManager.a().e(), "1");
            }
            GrpcMsgSender.this.p();
        }

        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onConnecting() {
        }

        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onDisconnected() {
            GrpcMsgSender.this.b = false;
            LogUtils.d("GrpcMsgSender", "connect onClose");
        }

        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onReceive(Any any) {
            try {
                GrpcMsgSender.this.a(any);
            } catch (Exception e) {
                GrpcMsgSender grpcMsgSender = GrpcMsgSender.this;
                grpcMsgSender.c("解析错误？ " + e.toString());
                e.printStackTrace();
            }
        }
    };

    /* renamed from: com.blued.android.module.live_china.msg.GrpcMsgSender$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/GrpcMsgSender$3.class */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveGiftModel f13936a;

        AnonymousClass3(LiveGiftModel liveGiftModel) {
            this.f13936a = liveGiftModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            LiveSetDataObserver.a().b(this.f13936a);
        }
    }

    public GrpcMsgSender() {
        if (AppInfo.m()) {
            LiveIM.a(true);
        }
    }

    private DefinedRankInfo a(CustomRank customRank) {
        if (customRank == null) {
            return null;
        }
        DefinedRankInfo definedRankInfo = new DefinedRankInfo();
        definedRankInfo.rank_info = new ArrayList();
        for (CustomRank.RankInfo rankInfo : customRank.getRankInfoList()) {
            LiveDefinedRankModel liveDefinedRankModel = new LiveDefinedRankModel();
            liveDefinedRankModel.title = rankInfo.getTitle();
            liveDefinedRankModel.score = rankInfo.getScore();
            liveDefinedRankModel.image = rankInfo.getImage();
            definedRankInfo.rank_info.add(liveDefinedRankModel);
        }
        definedRankInfo.start_time = customRank.getStartTime();
        definedRankInfo.end_time = customRank.getEndTime();
        LogUtils.c(AppInfo.f().toJson(definedRankInfo));
        return definedRankInfo;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private LiveGiftModel a(GiftExtra giftExtra) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private LiveGiftModel a(GoodsLuckBag goodsLuckBag, GoodsLuckBag.Goods goods) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private LiveGiftModel a(WinningPrize winningPrize) {
        if (winningPrize == null) {
            return null;
        }
        LiveGiftModel liveGiftModel = new LiveGiftModel();
        liveGiftModel.displayCount = winningPrize.getCount();
        liveGiftModel.goods_id = String.valueOf(winningPrize.getGoodsId());
        liveGiftModel.name = winningPrize.getGoodsName();
        liveGiftModel.images_static = winningPrize.getGoodsIcon();
        liveGiftModel.source = winningPrize.getSource();
        liveGiftModel.sourceEvent = winningPrize.getEvent();
        liveGiftModel.extraModel = new LiveBubbleBgModel(null, winningPrize.getChatFrameIcon(), 0, winningPrize.getChatFrameFrameColorList(), winningPrize.getChatFrameBorderColorList());
        return liveGiftModel;
    }

    private LiveGiftScrawlTransModel a(DrawGoods drawGoods) {
        LiveGiftScrawlTransModel liveGiftScrawlTransModel = new LiveGiftScrawlTransModel();
        liveGiftScrawlTransModel.width = drawGoods.getWidth();
        liveGiftScrawlTransModel.height = drawGoods.getHeight();
        liveGiftScrawlTransModel.pay_token = drawGoods.getPayToken();
        liveGiftScrawlTransModel.pay_code = drawGoods.getPayCode();
        liveGiftScrawlTransModel.discount_id = drawGoods.getDiscountId();
        liveGiftScrawlTransModel.remember_me = drawGoods.getRememberMe();
        liveGiftScrawlTransModel.from = LiveRoomManager.a().p().comeCode;
        liveGiftScrawlTransModel.beans_current_count = drawGoods.getBeansCurrentCount();
        liveGiftScrawlTransModel.extraModel = new LiveBubbleBgModel(drawGoods.getChatFrame(), drawGoods.getChatFrameIcon(), drawGoods.getChatFrameGradientType(), drawGoods.getChatFrameFrameColorList(), drawGoods.getChatFrameBorderColorList());
        if (drawGoods.getBeansCurrentCount() > 0) {
            LiveEventBus.get("live_beans_change").post(new LiveBeansChangeEvent(LiveRoomManager.a().e(), drawGoods.getBeansCurrentCount(), (long) LiveRoomManager.a().u()));
        }
        liveGiftScrawlTransModel.goods = new ArrayList();
        if (drawGoods.getGoodsList() != null) {
            for (DrawGoods.Goods goods : drawGoods.getGoodsList()) {
                if (goods != null) {
                    LiveGiftScrawlModel liveGiftScrawlModel = new LiveGiftScrawlModel();
                    liveGiftScrawlModel.goods_id = String.valueOf(goods.getGoodsId());
                    liveGiftScrawlModel.hit_id = goods.getHitId();
                    liveGiftScrawlModel.contents = goods.getContents();
                    liveGiftScrawlModel.images_static = goods.getImagesStatic();
                    liveGiftScrawlModel.pic = goods.getImagesStatic();
                    if (goods.getPathList() != null) {
                        for (DrawGoods.Goods.Path path : goods.getPathList()) {
                            if (path != null) {
                                liveGiftScrawlModel.addPath(new Point(path.getX(), path.getY()));
                            }
                        }
                    }
                    liveGiftScrawlTransModel.goods.add(liveGiftScrawlModel);
                }
            }
        }
        return liveGiftScrawlTransModel;
    }

    private LiveWishContestContentModel a(WishingContestText wishingContestText) {
        if (wishingContestText == null) {
            return null;
        }
        LiveWishContestContentModel liveWishContestContentModel = new LiveWishContestContentModel();
        liveWishContestContentModel.event = wishingContestText.getEvent();
        liveWishContestContentModel.url = wishingContestText.getUrl();
        liveWishContestContentModel.screenType = wishingContestText.getScreenType();
        liveWishContestContentModel.userId = wishingContestText.getUid();
        liveWishContestContentModel.userName = wishingContestText.getUserName();
        liveWishContestContentModel.anchorId = wishingContestText.getAnchor();
        liveWishContestContentModel.anchorName = wishingContestText.getAnchorName();
        liveWishContestContentModel.roomId = wishingContestText.getLid();
        liveWishContestContentModel.giftId = wishingContestText.getGoodsId();
        liveWishContestContentModel.giftCount = wishingContestText.getGoodsCount();
        liveWishContestContentModel.giftName = wishingContestText.getGoodsName();
        liveWishContestContentModel.giftImage = wishingContestText.getGoodsUrl();
        liveWishContestContentModel.isHide = wishingContestText.getHide();
        liveWishContestContentModel.beans = wishingContestText.getAnchorBeans();
        liveWishContestContentModel.type = wishingContestText.getType();
        liveWishContestContentModel.bubbleBgModel = new LiveBubbleBgModel(null, wishingContestText.getChatFrameIcon(), 0, wishingContestText.getChatFrameFrameColorList(), wishingContestText.getChatFrameBorderColorList());
        LogUtils.c("parseWishCourtContent:" + AppInfo.f().toJson(liveWishContestContentModel));
        return liveWishContestContentModel;
    }

    private LiveWishCourtModel a(WishingContest wishingContest) {
        if (wishingContest == null) {
            return null;
        }
        LiveWishCourtModel liveWishCourtModel = new LiveWishCourtModel();
        liveWishCourtModel.status = wishingContest.getStatus();
        liveWishCourtModel.goods_id = wishingContest.getGoodsId();
        liveWishCourtModel.tools_title = wishingContest.getToolsTitle();
        liveWishCourtModel.goods_name = wishingContest.getGoodsName();
        liveWishCourtModel.goods_icon = wishingContest.getGoodsIcon();
        liveWishCourtModel.goods_count = wishingContest.getGoodsCount();
        liveWishCourtModel.countdown = wishingContest.getCountdown();
        liveWishCourtModel.url = wishingContest.getUrl();
        liveWishCourtModel.html_msg = wishingContest.getHtmlMsg();
        liveWishCourtModel.html_href = wishingContest.getHtmlHref();
        liveWishCourtModel.pushTime = wishingContest.getPushMillisecond();
        LogUtils.c("parseWishCourtModel:" + AppInfo.f().toJson(liveWishCourtModel));
        return liveWishCourtModel;
    }

    private Map<String, Object> a(LoveFan loveFan) {
        HashMap hashMap = new HashMap();
        MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "uid", loveFan.getUid());
        MsgPackHelper.putMapValue(hashMap, "name", loveFan.getName());
        MsgPackHelper.putMapValue(hashMap, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, loveFan.getAvatar());
        MsgPackHelper.putMapValue((Map<String, Object>) hashMap, InputMethodUtils.SUBTYPE_MODE_VOICE, loveFan.getVoice() ? 1L : 0L);
        MsgPackHelper.putMapValue(hashMap, "pic", loveFan.getPic());
        MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "lamp", loveFan.getLamp() ? 1L : 0L);
        MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "is_followed", loveFan.getIsFollowed() ? 1L : 0L);
        MsgPackHelper.putMapValue(hashMap, Instrumentation.REPORT_KEY_STREAMRESULT, loveFan.getStream());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Animation animation, LiveGiftModel liveGiftModel) {
        if (animation.getPriority()) {
            LiveSetDataObserver.a().b(liveGiftModel);
        } else {
            LiveSetDataObserver.a().c(liveGiftModel);
        }
    }

    private void a(ChallengeEggResult challengeEggResult) {
        if (challengeEggResult == null) {
            return;
        }
        int propResultDisplayCountdown = challengeEggResult.getPropResultDisplayCountdown();
        if (challengeEggResult.getType() == ChallengeEggResult.ChallengeEggResultType.None) {
            PkDaredObserver.a().a(3, "", 0, "", "", propResultDisplayCountdown);
        } else {
            String name = challengeEggResult.getName();
            String propName = challengeEggResult.getPropName();
            String propIcon = challengeEggResult.getPropIcon();
            if (challengeEggResult.getType() == ChallengeEggResult.ChallengeEggResultType.Target) {
                PkDaredObserver.a().a(2, "", 0, propName, propIcon, propResultDisplayCountdown);
            } else if (challengeEggResult.getType() == ChallengeEggResult.ChallengeEggResultType.Self) {
                boolean hide = challengeEggResult.getHide();
                PkDaredObserver.a().a(1, LiveCloakingUtil.a(name, hide), hide ? 0 : challengeEggResult.getUid(), propName, propIcon, propResultDisplayCountdown);
            }
        }
        int killAlertDelay = challengeEggResult.getKillAlertDelay();
        PkDaredObserver.a().d(killAlertDelay, challengeEggResult.getKillDelay() - killAlertDelay);
    }

    private void a(ChallengeEnd challengeEnd) {
        if (challengeEnd == null || challengeEnd.getRecordsCount() < 1) {
            return;
        }
        int typeValue = challengeEnd.getRecords(0).getTypeValue();
        int i = 2;
        if (typeValue == 0) {
            i = 3;
        } else if (typeValue == 1) {
            i = 1;
        } else if (typeValue != 2) {
            i = 0;
        }
        PkDaredObserver.a().a(i, challengeEnd.getKill(), LiveCloakingUtil.a(challengeEnd.getRecords(0).getMvpName(), challengeEnd.getRecords(0).getHide()), challengeEnd.getRecords(0).getScore(), challengeEnd.getRecords(0).getMvpAvatar(), challengeEnd.getKillDisplayCountdown(), challengeEnd.getResultDisplayCountdown(), challengeEnd.getMvpDisplayCountdown(), challengeEnd.getAgainDisplay());
    }

    private void a(ChallengeKill challengeKill) {
        if (challengeKill == null) {
            return;
        }
        ChallengeKill.ChallengeKillType type = challengeKill.getType();
        int greaterScore = challengeKill.getGreaterScore();
        if (type != ChallengeKill.ChallengeKillType.Open) {
            if (type == ChallengeKill.ChallengeKillType.Default || type == ChallengeKill.ChallengeKillType.Close) {
                PkDaredObserver.a().d(greaterScore);
                return;
            }
            return;
        }
        int countdown = challengeKill.getCountdown();
        ChallengeKill.ChallengeKillActiveType activeType = challengeKill.getActiveType();
        if (activeType == ChallengeKill.ChallengeKillActiveType.KillTarget) {
            PkDaredObserver.a().e(countdown);
        } else if (activeType == ChallengeKill.ChallengeKillActiveType.KillSelf) {
            PkDaredObserver.a().e(countdown, greaterScore);
        } else {
            PkDaredObserver.a().d(greaterScore);
        }
    }

    private void a(ChallengeMatch challengeMatch) {
        if (challengeMatch == null || challengeMatch.getChallengeInfoCount() < 2) {
            return;
        }
        PkDaredObserver.a().a(challengeMatch.getChallengeInfo(1).getName(), challengeMatch.getChallengeInfo(1).getAvatar(), challengeMatch.getChallengeInfo(1).getUid(), challengeMatch.getChallengeInfo(1).getLid(), challengeMatch.getCountdown(), challengeMatch.getFullCountdown(), challengeMatch.getEggAlertDelay(), challengeMatch.getEggDelay() - challengeMatch.getEggAlertDelay(), challengeMatch.getTargetEggScore(), challengeMatch.getMaxEggCountdown(), challengeMatch.getDescContents(), challengeMatch.getDescLink(), true);
    }

    private void a(ChallengeProp challengeProp) {
        String str;
        String str2;
        if (challengeProp == null) {
            return;
        }
        String propIcon = challengeProp.getUserProp().getPropIcon();
        String propName = challengeProp.getUserProp().getPropName();
        ProtocolStringList propDescList = challengeProp.getUserProp().getPropDescList();
        boolean z = false;
        if (propDescList != null) {
            String propDesc = propDescList.size() >= 2 ? challengeProp.getUserProp().getPropDesc(1) : "";
            str2 = propDescList.size() >= 1 ? challengeProp.getUserProp().getPropDesc(0) : "";
            str = propDesc;
        } else {
            str = "";
            str2 = "";
        }
        PkDaredObserver.a().a(challengeProp.getIsSelf(), propIcon, propName, str2, str, challengeProp.getUserProp().getCountdown(), challengeProp.getUserProp().getMaxCountdown(), true, challengeProp.getUserProp().getPropCountdown());
        if (challengeProp.getUserProp().getProp() == Prop.FOG) {
            if (!challengeProp.getIsSelf() || (LiveRoomInfo.a().g() != challengeProp.getUserProp().getUid() && LiveRoomInfo.a().g() != LiveRoomManager.a().f())) {
                z = true;
            }
            if (z) {
                PkDaredObserver.a().a(challengeProp.getIsSelf(), challengeProp.getUserProp().getCountdown());
            }
        }
    }

    private void a(ChallengeSync challengeSync) {
        if (challengeSync == null || challengeSync.getChallengeInfoCount() < 2) {
            return;
        }
        PkDaredObserver.a().a(challengeSync.getChallengeInfo(1).getName(), challengeSync.getChallengeInfo(1).getAvatar(), challengeSync.getChallengeInfo(1).getUid(), challengeSync.getChallengeInfo(1).getLid(), challengeSync.getCountdown(), challengeSync.getFullCountdown(), 0, 0, challengeSync.getTargetEggScore(), challengeSync.getMaxEggCountdown(), challengeSync.getDescContents(), challengeSync.getDescLink(), false);
        b(challengeSync);
        a(challengeSync, 0);
        a(challengeSync, 1);
    }

    private void a(ChallengeSync challengeSync, int i) {
        String str;
        String str2;
        if (challengeSync == null || challengeSync.getChallengeInfoCount() <= i || challengeSync.getChallengeInfo(i).getUserPropCount() == 0) {
            return;
        }
        for (UserProp userProp : challengeSync.getChallengeInfo(i).getUserPropList()) {
            String propIcon = userProp.getPropIcon();
            String propName = userProp.getPropName();
            ProtocolStringList propDescList = userProp.getPropDescList();
            if (propDescList != null) {
                String propDesc = propDescList.size() >= 2 ? userProp.getPropDesc(1) : "";
                if (propDescList.size() >= 1) {
                    str2 = propDesc;
                    str = userProp.getPropDesc(0);
                } else {
                    str2 = propDesc;
                    str = "";
                }
            } else {
                str = "";
                str2 = str;
            }
            int countdown = userProp.getCountdown();
            PkDaredObserver.a().a(i == 0, propIcon, propName, str, str2, countdown, userProp.getMaxCountdown(), false, userProp.getPropCountdown());
            if (userProp.getProp() == Prop.FOG) {
                if ((i == 0 && (LiveRoomInfo.a().g() == ((long) userProp.getUid()) || LiveRoomInfo.a().g() == LiveRoomManager.a().f())) ? false : true) {
                    PkDaredObserver.a().a(i == 0, countdown);
                }
            }
        }
    }

    private void a(ChallengeUpdate challengeUpdate) {
        if (challengeUpdate == null || challengeUpdate.getRecordsCount() < 2) {
            return;
        }
        PkDaredObserver.a().a(challengeUpdate.getRecords(0).getScore(), challengeUpdate.getRecords(1).getScore());
        if (challengeUpdate.getIsEgg()) {
            PkDaredObserver.a().b(challengeUpdate.getRecords(0).getEggScore(), challengeUpdate.getRecords(1).getEggScore());
        }
        if (challengeUpdate.getRecords(0).getIsFirstBlood()) {
            String firstBloodUserName = challengeUpdate.getRecords(0).getFirstBloodUserName();
            boolean hide = challengeUpdate.getRecords(0).getHide();
            PkDaredObserver.a().a(true, LiveCloakingUtil.a(firstBloodUserName, hide), challengeUpdate.getRecords(0).getFirstBloodDesc(), challengeUpdate.getRecords(0).getFirstBloodDisplayCountdown());
        } else if (challengeUpdate.getRecords(1).getIsFirstBlood()) {
            PkDaredObserver.a().a(false, "", challengeUpdate.getRecords(1).getFirstBloodDesc(), challengeUpdate.getRecords(1).getFirstBloodDisplayCountdown());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveChatOuterClass.LiveLikeResponse liveLikeResponse) {
        if (liveLikeResponse != null) {
            LogUtils.d("GrpcMsgSender", "sendFirstLike response: " + liveLikeResponse.toString());
        }
    }

    private void a(LiveCloseReason liveCloseReason, LiveChatStatistics liveChatStatistics) {
        synchronized (this.h) {
            Set<LiveChatInfoListener> set = this.h.get(LiveRoomManager.a().e());
            if (set != null) {
                Iterator<LiveChatInfoListener> it = set.iterator();
                while (it.hasNext()) {
                    it.remove();
                    it.next().onClose(liveCloseReason, liveChatStatistics);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(LiveGiftWallFloatModel liveGiftWallFloatModel) {
        LiveSetDataObserver.a().a(liveGiftWallFloatModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(LiveRoomOperationModel liveRoomOperationModel) {
        LiveSetDataObserver.a().a(liveRoomOperationModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(MultiDialogModel multiDialogModel) {
        LiveSetDataObserver.a().a(multiDialogModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(MuteLiveAudioModel muteLiveAudioModel, String str) {
        LiveRoomManager.a().a(muteLiveAudioModel, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SendMsgListener sendMsgListener, Runnable runnable, LiveChatOuterClass.LiveMsgResponse liveMsgResponse) {
        if (liveMsgResponse != null) {
            LogUtils.d("GrpcMsgSender", "sendMessage response: " + liveMsgResponse.toString());
            if (liveMsgResponse.getCodeValue() == 200) {
                if (sendMsgListener != null) {
                    sendMsgListener.a(runnable);
                    return;
                } else {
                    runnable.run();
                    return;
                }
            }
            if (!TextUtils.isEmpty(liveMsgResponse.getMessage())) {
                AppMethods.a((CharSequence) liveMsgResponse.getMessage());
            }
            if (sendMsgListener != null) {
                sendMsgListener.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(Any any) throws InvalidProtocolBufferException {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public /* synthetic */ void a(String str, boolean z, LiveZanExtraModel.EmojiModel emojiModel) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void b(ChallengeSync challengeSync) {
        int score = (int) challengeSync.getChallengeInfo(0).getScore();
        int score2 = (int) challengeSync.getChallengeInfo(1).getScore();
        PkDaredObserver.a().a(score, score2);
        switch (challengeSync.getStage()) {
            case 1:
                PkDaredObserver.a().c(challengeSync.getEggAlertDelay(), challengeSync.getEggDelay() - challengeSync.getEggAlertDelay());
                return;
            case 2:
                PkDaredObserver.a().b(challengeSync.getEggAlertCountdown());
                return;
            case 3:
                PkDaredObserver.a().a(challengeSync.getChallengeInfo(0).getEggScore(), challengeSync.getChallengeInfo(1).getEggScore(), challengeSync.getTargetEggScore(), challengeSync.getEggCountdown(), challengeSync.getMaxEggCountdown());
                return;
            case 4:
                int killAlertDelay = challengeSync.getKillAlertDelay();
                PkDaredObserver.a().d(killAlertDelay, challengeSync.getKillDelay() - killAlertDelay);
                return;
            case 5:
                PkDaredObserver.a().c(challengeSync.getKillAlertCountdown());
                return;
            case 6:
                int killCountdown = challengeSync.getKillCountdown();
                if (score > score2) {
                    PkDaredObserver.a().e(killCountdown);
                    return;
                } else if (score < score2) {
                    PkDaredObserver.a().e(killCountdown, challengeSync.getGreaterScore());
                    return;
                } else {
                    PkDaredObserver.a().d(challengeSync.getGreaterScore());
                    return;
                }
            case 7:
                PkDaredObserver.a().d(challengeSync.getGreaterScore());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(LiveChatOuterClass.LiveLikeResponse liveLikeResponse) {
        if (liveLikeResponse != null) {
            LogUtils.c("GrpcMsgSender", "sendLike response: " + liveLikeResponse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void o() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = LocaleUtils.b();
        }
        LiveIM.a(AppInfo.g, "android_china", this.e, AppInfo.f9487c);
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a() {
        this.f13933c = LiveRoomInfo.a().l();
        this.d = LiveRoomInfo.a().q();
        LogUtils.c("GrpcMsgSender", "init: mLiveImHost=" + this.f13933c + "\nmAccessToken=" + this.d);
        LiveIM.a(AppInfo.d(), this.f13933c, HappyDnsUtils.d());
        LiveIM.b(this.i);
        LiveIM.a(this.i);
        LiveIM.a(this.d);
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a(long j) {
        if (this.b) {
            return;
        }
        b();
    }

    public void a(long j, LiveChatInfoListener liveChatInfoListener) {
        synchronized (this.h) {
            Set<LiveChatInfoListener> set = this.h.get(String.valueOf(j));
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                this.h.put(String.valueOf(j), hashSet);
            }
            hashSet.add(liveChatInfoListener);
        }
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a(String str, final boolean z, final LiveZanExtraModel.EmojiModel emojiModel, final SendMsgListener sendMsgListener) {
        final String a2 = EventTrackUtils.a(str);
        final Runnable runnable = new Runnable() { // from class: com.blued.android.module.live_china.msg.-$$Lambda$GrpcMsgSender$-HWAh-mV2IGJDREPajS3FnAjvro
            @Override // java.lang.Runnable
            public final void run() {
                GrpcMsgSender.this.a(a2, z, emojiModel);
            }
        };
        LiveChatOuterClass.LiveMsgRequest.Builder contents = LiveChatOuterClass.LiveMsgRequest.newBuilder().setLiveId(LiveRoomManager.a().e()).setContents(a2);
        int i = 0;
        if (emojiModel != null) {
            i = StringUtils.a(emojiModel.id, 0);
        }
        LiveIM.a(contents.setEmojiId(i).build(), new LiveIM.OnSendMessageFinishListener() { // from class: com.blued.android.module.live_china.msg.-$$Lambda$GrpcMsgSender$18Mtc6nnVl85c1HH9QPSvqHnVWg
            @Override // com.blued.android.module.live.im.LiveIM.OnSendMessageFinishListener
            public final void onFinish(LiveChatOuterClass.LiveMsgResponse liveMsgResponse) {
                GrpcMsgSender.this.a(sendMsgListener, runnable, liveMsgResponse);
            }
        });
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a(short s, long j, LiveChatInfoListener liveChatInfoListener) {
        a(j, liveChatInfoListener);
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void a(boolean z) {
        LiveIM.a(LiveChatOuterClass.LiveLikeRequest.newBuilder().setLiveId(LiveRoomManager.a().e()).setCount(1).setHasFirstLike(z).build(), new LiveIM.OnSendLikeFinishListener() { // from class: com.blued.android.module.live_china.msg.-$$Lambda$GrpcMsgSender$_aqvHetsiuhYMaWMZohyMhXKlok
            @Override // com.blued.android.module.live.im.LiveIM.OnSendLikeFinishListener
            public final void onFinish(LiveChatOuterClass.LiveLikeResponse liveLikeResponse) {
                GrpcMsgSender.this.b(liveLikeResponse);
            }
        });
        if (z) {
            o();
        }
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void b() {
        if (this.b) {
            if (!TextUtils.equals(this.f13933c, LiveRoomInfo.a().l()) || !TextUtils.equals(this.d, LiveRoomInfo.a().q())) {
                c();
            }
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.msg.GrpcMsgSender.1
                @Override // java.lang.Runnable
                public void run() {
                    GrpcMsgSender.this.d();
                }
            }, 100L);
        } else {
            d();
        }
        if (!this.b || TextUtils.equals(this.e, LocaleUtils.b())) {
            return;
        }
        p();
    }

    public void b(long j, LiveChatInfoListener liveChatInfoListener) {
        synchronized (this.h) {
            Set<LiveChatInfoListener> set = this.h.get(String.valueOf(j));
            if (set != null) {
                set.remove(liveChatInfoListener);
            }
        }
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void b(short s, long j, LiveChatInfoListener liveChatInfoListener) {
        b(j, liveChatInfoListener);
    }

    @Override // com.blued.android.module.live_china.msg.ILiveMsgSender
    public void c() {
        if (this.b) {
            LiveIM.c();
        }
    }

    public void d() {
        if (this.b) {
            return;
        }
        this.b = true;
        LogUtils.c("GrpcMsgSender", "connect live im @" + Thread.currentThread().getName());
        this.f13933c = LiveRoomInfo.a().l();
        this.d = LiveRoomInfo.a().q();
        if (!LiveIM.a()) {
            LiveIM.a(AppInfo.d(), this.f13933c, HappyDnsUtils.d());
            LiveIM.a(false);
            LiveIM.a(this.i);
        }
        LiveIM.a(this.d);
        LiveIM.b();
    }
}
