package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.util.cm.PowerMenuConstants;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.AssetsUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.external_sense_library.contract.ISetStickerListener;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.utils.lisense_utils.STNewLicenseUtils;
import com.blued.android.module.live.base.event.LiveBeansChangeEvent;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.BlackMusicListener;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.TrtcMusicModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.live.base.utils.LiveSettingConfig;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live.base.view.animation.AnimationListenerAdapter;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.activity.PlayingOnliveActivity;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.common.ZegoMixStreamHelper;
import com.blued.android.module.live_china.fragment.LiveDesireDialogFragment;
import com.blued.android.module.live_china.fragment.LiveFansRecordDialogFragment;
import com.blued.android.module.live_china.fragment.LiveMakeLoverDialogFragment;
import com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment;
import com.blued.android.module.live_china.fragment.LiveRecordDialogFragment;
import com.blued.android.module.live_china.fragment.LiveRecordPostFragmentKL;
import com.blued.android.module.live_china.fragment.LiveRegularEventRanklistDialogFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.manager.GrabRewardPayManager;
import com.blued.android.module.live_china.manager.LiveBunchLightTaskManager;
import com.blued.android.module.live_china.manager.LiveGuideListManager;
import com.blued.android.module.live_china.manager.LiveOperationManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.PlayARObserver;
import com.blued.android.module.live_china.manager.PlayGifObserver;
import com.blued.android.module.live_china.manager.RecordingMakeFriendManager;
import com.blued.android.module.live_china.manager.RecordingMakeLoverManager;
import com.blued.android.module.live_china.manager.RecordingMsgManager;
import com.blued.android.module.live_china.manager.RecordingMultiConnectionManager;
import com.blued.android.module.live_china.manager.RecordingOnliveManager;
import com.blued.android.module.live_china.manager.RecordingPlayerManager;
import com.blued.android.module.live_china.manager.RecordingScreenManager;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.BluedLiveTopCard;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.FunctionRedPModelJson;
import com.blued.android.module.live_china.model.GrabBoxDetailModel;
import com.blued.android.module.live_china.model.GrabBoxListModel;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.HTMLNoticeModel;
import com.blued.android.module.live_china.model.LiveAnnounceInfoModel;
import com.blued.android.module.live_china.model.LiveAnnounceModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveDotModel;
import com.blued.android.module.live_china.model.LiveEntranceData;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGetPkStatusExtraModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftWallFloatModel;
import com.blued.android.module.live_china.model.LiveGroupPkUserModel;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LivePKPlayerModel;
import com.blued.android.module.live_china.model.LivePKPlusModel;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.model.LivePkRoundModel;
import com.blued.android.module.live_china.model.LiveRankingHourConfig;
import com.blued.android.module.live_china.model.LiveRecordLevelStickerModel;
import com.blued.android.module.live_china.model.LiveRecordRecommendModel;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.model.LiveRewardDescribe;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.model.LiveRoomTipsModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveShakeModel;
import com.blued.android.module.live_china.model.LiveShopStatusExtra;
import com.blued.android.module.live_china.model.LiveWishItemModel;
import com.blued.android.module.live_china.model.LiveWishingDrawModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.model.MuteLiveAudioModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.model.RankingExtra;
import com.blued.android.module.live_china.model.RankingHourExtra;
import com.blued.android.module.live_china.model.RelationInfo;
import com.blued.android.module.live_china.model.ShopStatusModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.msg.SendMsgListener;
import com.blued.android.module.live_china.observer.BeansRefreshObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.ZanRefreshObserver;
import com.blued.android.module.live_china.pop.LiveCommonPopTips;
import com.blued.android.module.live_china.pop.LiveOfficalRecommendPop;
import com.blued.android.module.live_china.pop.LiveWishTipPop;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.service.LiveScreenRecorderService;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BarrageHornView;
import com.blued.android.module.live_china.view.GrabRewardView;
import com.blued.android.module.live_china.view.HornViewNew;
import com.blued.android.module.live_china.view.LiveAnnouceView;
import com.blued.android.module.live_china.view.LiveBunchLightView;
import com.blued.android.module.live_china.view.LiveCommentTipView;
import com.blued.android.module.live_china.view.LiveConnectionInviteView;
import com.blued.android.module.live_china.view.LiveConnectionView;
import com.blued.android.module.live_china.view.LiveCountDownView;
import com.blued.android.module.live_china.view.LiveCueView;
import com.blued.android.module.live_china.view.LiveDefinedRankView;
import com.blued.android.module.live_china.view.LiveMakeFriendListView;
import com.blued.android.module.live_china.view.LiveMakeFriendManageView;
import com.blued.android.module.live_china.view.LiveMakeFriendSettingView;
import com.blued.android.module.live_china.view.LiveMakeLoverManagerRecordView;
import com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView;
import com.blued.android.module.live_china.view.LiveMultiFunctionView;
import com.blued.android.module.live_china.view.LiveMusicFloatView;
import com.blued.android.module.live_china.view.LiveOnlineUserTipsView;
import com.blued.android.module.live_china.view.LivePKBubbleLayout;
import com.blued.android.module.live_china.view.LivePKCountDownView;
import com.blued.android.module.live_china.view.LivePKFirstPayView;
import com.blued.android.module.live_china.view.LivePKPayMVPView;
import com.blued.android.module.live_china.view.LivePKPlusView;
import com.blued.android.module.live_china.view.LivePKProgressView;
import com.blued.android.module.live_china.view.LivePKResult;
import com.blued.android.module.live_china.view.LivePKRoundDotView;
import com.blued.android.module.live_china.view.LivePKRoundStartView;
import com.blued.android.module.live_china.view.LivePKRoundTimeView;
import com.blued.android.module.live_china.view.LivePKRoundToastView;
import com.blued.android.module.live_china.view.LivePKUserBanner;
import com.blued.android.module.live_china.view.LivePkRoundCountDownView;
import com.blued.android.module.live_china.view.LiveRankingButtonView;
import com.blued.android.module.live_china.view.LiveRecordLevelView;
import com.blued.android.module.live_china.view.LiveRecordStickerViewLayout;
import com.blued.android.module.live_china.view.LiveTitleView;
import com.blued.android.module.live_china.view.LiveViewerListView;
import com.blued.android.module.live_china.view.PKDoubleAnimView;
import com.blued.android.module.live_china.view.PopBeautyNewView;
import com.blued.android.module.live_china.view.PopGestureView;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;
import com.blued.android.module.live_china.view.PopLiveCallView;
import com.blued.android.module.live_china.view.PopMultiPKRankView;
import com.blued.android.module.live_china.view.PopPKListView;
import com.blued.android.module.live_china.view.PopRankingListView;
import com.blued.android.module.live_china.view.PopRecordLevelView;
import com.blued.android.module.live_china.view.PopRewardConfigView;
import com.blued.android.module.live_china.view.PopStickerView;
import com.blued.android.module.live_china.view.StartLiveView;
import com.blued.android.module.live_china.view.WishingWellView;
import com.blued.android.module.live_china.view.livegame.GameVideoView;
import com.blued.android.module.live_china.view.operation.LiveBottomOperationView;
import com.blued.android.module.live_china.view.operation.LiveOperationView;
import com.blued.android.module.live_china.view.pkdared.PkDaredView;
import com.blued.android.module.live_china.view.righttopfunction.LiveRightTopFunctionPlace;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;
import com.tencent.txcopyrightedmedia.TXCMAudioFrameInfo;
import com.tencent.txcopyrightedmedia.zego.ITXCMZegoAudioAux;
import com.tencent.txcopyrightedmedia.zego.ITXCMZegoAudioAuxCallbackEx;
import com.tencent.txcopyrightedmedia.zego.TXCMAuxDataEx;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/RecordingOnliveFragment.class */
public class RecordingOnliveFragment extends LiveBaseFragment implements View.OnClickListener, View.OnTouchListener, Chronometer.OnChronometerTickListener, BlackMusicListener, LiveFansRecordDialogFragment.ILiveFansRecordDialog, LiveRankGuestDialogFragment.ILiveGuestDialog, PlayARObserver.IPlayARObserver, PlayGifObserver.IPlayGifObserver, BeansRefreshObserver.IBeansRefreshObserver, LiveSetDataObserver.ILiveSetDataObserver, ZanRefreshObserver.IZanRefreshObserver {
    public int F;
    public PopupWindow G;
    public FrameLayout H;
    public FrameLayout I;
    public View J;
    public KeyboardListenLinearLayout K;
    public FrameLayout L;
    public FrameLayout M;
    public TextureView N;
    protected ImageView O;
    public ImageView P;
    public ImageView Q;
    public View R;
    public ImageView S;
    public View T;
    public ImageView U;
    public View W;
    public boolean Y;
    public ImageView Z;
    public LiveManagerDialogFragment aA;
    public View aB;
    public ImageView aC;
    public FrameLayout aD;
    public FrameLayout aE;
    public FrameLayout aF;
    public FrameLayout aG;
    public FrameLayout aH;
    public FrameLayout aI;
    public FrameLayout aJ;
    public FrameLayout aK;
    public FrameLayout aL;
    public FrameLayout aM;
    public FrameLayout aN;
    public FrameLayout aO;
    public TextureView aP;
    public TextureView aQ;
    public TextureView aR;
    public TextureView aS;
    public TextureView aT;
    public TextureView aU;
    public ImageView aV;
    public ImageView aW;
    public TextView aX;
    public TextView aY;
    public TextView aZ;
    public boolean aa;
    public boolean ab;
    public RecordingOnliveManager ac;
    public RecordingMsgManager ad;
    public PowerManager.WakeLock ae;
    public LiveBunchLightTaskManager af;
    public Chronometer ah;
    public View ai;
    public View aj;
    public RelativeLayout ak;
    public TextView al;
    public TextView am;
    public Button an;
    public TextView ao;
    public LiveViewerListView ap;
    public TextView aq;
    public double ar;
    public double as;
    public ProgressBar at;
    public PopBeautyNewView au;
    public HornViewNew av;
    public BarrageHornView aw;
    public LiveRankGuestDialogFragment ax;
    public LiveFansRecordDialogFragment ay;
    public LiveRegularEventRanklistDialogFragment az;
    public ImageView bA;
    public LiveConnectionView bB;
    public FrameLayout bC;
    public FrameLayout bD;
    public LivePKProgressView bE;
    public LivePKUserBanner bF;
    public LinearLayout bG;
    public ImageView bH;
    public TextView bI;
    public FrameLayout bJ;
    public LinearLayout bK;
    public ImageView bL;
    public LivePKBubbleLayout bM;
    public LivePKBubbleLayout bN;
    public LivePKCountDownView bO;
    public LivePKFirstPayView bP;
    public View bQ;
    public View bR;
    public View bS;
    public View bT;
    public View bU;
    public View bV;
    public View bW;
    public View bX;
    public TextView bY;
    public TextView bZ;
    public TextView ba;
    public FrameLayout bb;
    public FrameLayout bc;
    public FrameLayout bd;
    public ImageView be;
    public ImageView bf;
    public ImageView bg;
    public View bh;
    public View bi;
    public View bj;
    public LiveMakeLoverRootRecordView bk;
    public LiveMakeLoverManagerRecordView bl;
    public RecordingMakeLoverManager bm;
    public LiveMakeLoverDialogFragment bn;
    public RecordingMultiConnectionManager bo;
    public boolean bp;
    public boolean br;
    public LiveAnimationView bs;
    public LiveAnimationView bt;
    public ViewGroup bu;
    public View bv;
    public GrabRewardView bw;
    public FrameLayout bx;
    public IScreenManager by;
    public int bz;
    public String cA;
    public StartLiveView cB;
    public LiveMakeFriendSettingView cC;
    public View cD;
    public ImageView cE;
    public ImageView cF;
    public LiveTitleView cG;
    public LiveMultiFunctionView cH;
    public ImageView cI;
    public ShapeTextView cJ;
    public LiveRecordStickerViewLayout cK;
    public View cL;
    public LiveMusicFloatView cM;
    public View cN;
    public PopLiveActivityWebView cO;
    public LiveRightTopFunctionPlace cP;
    public PkDaredView cQ;
    public LiveGuideListManager cR;
    public LivePkRoundSelectDialogFragment cS;
    public LiveShakeDialogFragment cT;
    public ViewGroup cU;
    public boolean cV;
    public RecordingPlayerManager cW;
    public long cX;
    public CountDownTimer cY;
    public TextView ca;
    public ImageView cb;
    public PopLiveCallView cc;
    public LiveAnimationView cd;
    public LivePKResult ce;
    public LivePKPayMVPView cf;
    public LivePKPlusView cg;
    public LivePKRoundDotView ch;
    public LivePKRoundStartView ci;
    public LivePKRoundTimeView cj;
    public LivePkRoundCountDownView ck;
    public LivePKRoundToastView cl;
    public LiveDefinedRankView cm;

    /* renamed from: cn  reason: collision with root package name */
    public LiveOperationManager f50cn;
    public LiveOperationView co;
    public LiveBottomOperationView cp;
    public LiveAnnouceView cq;
    public LiveConnectionInviteView cr;
    public boolean cs;
    public boolean ct;
    public ImageView cu;
    public LiveMakeFriendListView cv;
    public ImageView cw;
    public int cx;
    public int cy;
    public int cz;
    private LiveHostFinishDialogFragment dA;
    private LiveHalfWebDialogFragment dB;
    private LiveRecordDialogFragment dC;
    private LiveRecordPostFragmentKL dD;
    private LiveAnnounceDialogFragment dE;
    private LiveOnlineUserTipsView dF;
    public PopStickerView db;
    public PopGestureView dc;
    public LiveMsgManager dd;
    LiveCommonPopTips dj;
    private LiveRankingButtonView dk;
    private GameVideoView dl;
    private PKDoubleAnimView dm;
    private RecordingMakeFriendManager dn;

    /* renamed from: do  reason: not valid java name */
    private LinearLayout f46do;
    private ImageView dp;
    private LiveRecordLevelView dq;
    private RecyclerView dr;
    private LiveCountDownView ds;
    private PopRankingListView dt;
    private PopPKListView du;
    private LiveBackgroundMusicFragment dv;
    private PopRewardConfigView dw;
    private boolean dx;
    private LiveLiangWebDialogFragment dy;
    private LiveDesireDialogFragment dz;
    public boolean V = false;
    public boolean X = false;
    public long ag = 0;
    public boolean bq = false;
    private boolean dG = false;
    public long cZ = 6000;
    public Context E;
    GestureDetector da = new GestureDetector(this.E, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.31
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Logger.a("drb", "双击事件");
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Logger.a("drb", "单击事件");
            return super.onSingleTapConfirmed(motionEvent);
        }
    });

    /* renamed from: de  reason: collision with root package name */
    LiveOfficalRecommendPop f51de = null;
    private boolean dH = false;
    String df = "";
    String dg = "";
    long dh = 0;
    boolean di = false;

    /* renamed from: com.blued.android.module.live_china.fragment.RecordingOnliveFragment$11  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/RecordingOnliveFragment$11.class */
    class AnonymousClass11 implements LiveRegularEventRanklistDialogFragment.ILiveHostDialog {
        final /* synthetic */ RecordingOnliveFragment a;

        @Override // com.blued.android.module.live_china.fragment.LiveRegularEventRanklistDialogFragment.ILiveHostDialog
        public void a() {
            if (this.a.x) {
                this.a.i(4);
            } else {
                this.a.h(4);
            }
            this.a.dd.a(4);
        }

        @Override // com.blued.android.module.live_china.fragment.LiveRegularEventRanklistDialogFragment.ILiveHostDialog
        public void b() {
            if (this.a.x) {
                this.a.i(0);
            } else {
                this.a.h(0);
            }
            this.a.dd.a(0);
            this.a.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.RecordingOnliveFragment$30  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/RecordingOnliveFragment$30.class */
    public class AnonymousClass30 implements ISetStickerListener {
        final /* synthetic */ LiveGiftModel a;

        AnonymousClass30(LiveGiftModel liveGiftModel) {
            this.a = liveGiftModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.fragment.RecordingOnliveFragment$30$1] */
        public /* synthetic */ void a(final LiveGiftModel liveGiftModel) {
            RecordingOnliveFragment.this.cY = new CountDownTimer(RecordingOnliveFragment.this.cZ, 500L) { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.30.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Log.v("pk", "onFinish");
                    RecordingOnliveFragment.this.d(liveGiftModel);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                }
            }.start();
        }

        @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
        public void onFailed(ErrorCode.PlayStickerCode playStickerCode, String str) {
            String str2;
            try {
                if (("onFailed() | playStickerCode:" + playStickerCode) != null) {
                    str2 = String.valueOf(playStickerCode.a());
                } else {
                    str2 = "" + str;
                }
                Log.v("pk", str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LiveMsgSendManager.a().d("贴纸失败：" + str);
            RecordingOnliveFragment.this.d(this.a);
        }

        @Override // com.blued.android.module.external_sense_library.contract.ISetStickerListener
        public void onSetSticker() {
            Log.v("pk", "onSetSticker");
            LiveMsgSendManager.a().d("贴纸开始播放");
            RecordingOnliveFragment recordingOnliveFragment = RecordingOnliveFragment.this;
            final LiveGiftModel liveGiftModel = this.a;
            recordingOnliveFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$30$Tly7P3XEFzM3pD3jWQKQveub0y8
                @Override // java.lang.Runnable
                public final void run() {
                    RecordingOnliveFragment.AnonymousClass30.this.a(liveGiftModel);
                }
            });
        }
    }

    /* renamed from: com.blued.android.module.live_china.fragment.RecordingOnliveFragment$42  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/RecordingOnliveFragment$42.class */
    class AnonymousClass42 extends BluedUIHttpResponse<BluedEntity<LiveFriendModel, GrabBoxDetailModel>> {
        final /* synthetic */ RecordingOnliveFragment a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<LiveFriendModel, GrabBoxDetailModel> bluedEntity) {
            if (bluedEntity == null || !bluedEntity.hasData()) {
                return;
            }
            LiveFriendModel liveFriendModel = bluedEntity.data.get(0);
            if (!this.a.r() || TextUtils.isEmpty(liveFriendModel.letter)) {
                this.a.bG.setVisibility(8);
                return;
            }
            this.a.bG.setVisibility(0);
            this.a.bI.setText(liveFriendModel.letter);
        }
    }

    /* renamed from: com.blued.android.module.live_china.fragment.RecordingOnliveFragment$49  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/RecordingOnliveFragment$49.class */
    class AnonymousClass49 implements ImageFileLoader.OnLoadFileListener {
        final /* synthetic */ RecordingOnliveFragment a;

        @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
        public void onUIFinish(File file, Exception exc) {
            LiveRoomInfo.a().a((file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath()), this.a.t, this.a.E, this.a.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final String str) {
        View inflate = LayoutInflater.from(this.E).inflate(R.layout.pop_top_card, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_receive);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_card_count);
        String string = this.E.getResources().getString(R.string.live_title_topcard);
        String str2 = string;
        if (i > 0) {
            str2 = string + "x" + i;
        }
        textView2.setText(str2);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.43
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RecordingOnliveFragment.this.o(str);
            }
        });
        ((ImageView) inflate.findViewById(R.id.live_iv_close)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.44
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RecordingOnliveFragment.this.G.dismiss();
            }
        });
        if (this.G == null) {
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1);
            this.G = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.G.setOutsideTouchable(true);
            this.G.setFocusable(true);
        }
        this.G.showAtLocation(getActivity().getWindow().getDecorView(), 17, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j, LiveFriendModel liveFriendModel, String str, View view) {
        boolean booleanValue = ((this.cb.getTag() == null || !(this.cb.getTag() instanceof Boolean)) ? 0 : ((Boolean) this.cb.getTag()).booleanValue()) ^ 1;
        EventTrackLive.q(booleanValue ? LiveProtos.Event.LIVE_PK_VOICE_ICON_CLOSE : LiveProtos.Event.LIVE_PK_VOICE_ICON_OPEN, LiveRoomManager.a().e(), String.valueOf(j), liveFriendModel.lid);
        MuteLiveAudioModel muteLiveAudioModel = new MuteLiveAudioModel(LiveRoomManager.a().e(), LiveRoomInfo.a().f(), liveFriendModel.lid, String.valueOf(str), !booleanValue, liveFriendModel.stream, liveFriendModel.target_stream);
        LiveRoomManager.a().a(muteLiveAudioModel, "");
        LiveRoomHttpUtils.a(muteLiveAudioModel);
    }

    public static void a(final Context context, final int i) {
        LiveRoomInfo.a().a(new PermissionCallbacks() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                RecordingOnliveFragment.d(context, i);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
    }

    public static void a(final Context context, final int i, final int i2, final String str, final int i3, final String str2, final int i4) {
        LiveRoomInfo.a().a(new PermissionCallbacks() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.2
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                RecordingOnliveFragment.d(context, i, i2, str, i3, str2, i4);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveCloseReason liveCloseReason, LiveChatStatistics liveChatStatistics) {
        aD();
        if (liveCloseReason == LiveCloseReason.CLOSED_BY_SELF || liveCloseReason == LiveCloseReason.CLOSED_BY_LIVER) {
            f(false);
            if (this.ac != null) {
                Log.v("==record", "onClose by self");
                this.ac.t();
            }
        } else if (liveCloseReason == LiveCloseReason.CLOSED_BY_MANAGER) {
            if (this.ac != null) {
                Log.v("==record", "onClose by manager");
                this.ac.t();
            }
            a(liveChatStatistics);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBeansChangeEvent liveBeansChangeEvent) {
        if (liveBeansChangeEvent == null) {
            return;
        }
        a(liveBeansChangeEvent.totalScore, liveBeansChangeEvent.currentScore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveEntranceData liveEntranceData) {
        this.dd.a(liveEntranceData);
    }

    private void a(final LiveFriendModel liveFriendModel, final long j, String str) {
        EventTrackLive.q(LiveProtos.Event.LIVE_PK_VOICE_ICON_SHOW, LiveRoomManager.a().e(), String.valueOf(j), liveFriendModel.lid);
        this.cb.setTag(false);
        this.cb.setImageResource(R.drawable.live_icon_pk_voice_open);
        this.ac.b(liveFriendModel.target_stream, false);
        ImageView imageView = this.cb;
        final String valueOf = String.valueOf(j);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$H4wCQ3rrTlPHnGHEYhAVYSooY3w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordingOnliveFragment.this.a(j, liveFriendModel, valueOf, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveRewardConfigModel liveRewardConfigModel) {
        GrabRewardPayManager.a().a(this.E, getFragmentManager(), getFragmentActive(), liveRewardConfigModel, String.valueOf(this.t), LiveRoomInfo.a().f(), true, "", new GrabRewardPayManager.BackGiftStatusListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.6
            @Override // com.blued.android.module.live_china.manager.GrabRewardPayManager.BackGiftStatusListener
            public void a() {
            }

            @Override // com.blued.android.module.live_china.manager.GrabRewardPayManager.BackGiftStatusListener
            public void a(PayRemaining payRemaining, LiveRewardDescribe liveRewardDescribe, LiveRewardConfigModel liveRewardConfigModel2) {
                if (payRemaining.sendGiftStatus != 3) {
                    if (payRemaining.sendGiftStatus == 2) {
                        LiveRoomHttpUtils.a();
                        return;
                    }
                    return;
                }
                com.blued.android.framework.utils.Logger.a("drb", "支付成功");
                LiveRewardModel liveRewardModel = new LiveRewardModel(payRemaining.hongbao_id, payRemaining.start_second, payRemaining.end_second, payRemaining.is_anim, liveRewardConfigModel2 != null ? liveRewardConfigModel2.condition : "");
                if (RecordingOnliveFragment.this.bw != null) {
                    RecordingOnliveFragment.this.bw.a(liveRewardModel);
                }
                if (RecordingOnliveFragment.this.co != null) {
                    RecordingOnliveFragment.this.co.a(EnumOperation.VIEW_TYPE_RED_BAG.getValue(), liveRewardModel);
                }
                if (payRemaining.is_anim == 1) {
                    LiveGiftModel liveGiftModel = new LiveGiftModel();
                    liveGiftModel.anim_code = "hongbao";
                    RecordingOnliveFragment.this.dd.e(liveGiftModel);
                    if (TextUtils.equals(liveRewardConfigModel2.size, "L")) {
                        LiveGiftModel liveGiftModel2 = new LiveGiftModel();
                        liveGiftModel2.anim_code = payRemaining.ar_name;
                        liveGiftModel2.resource_url = payRemaining.resource_url;
                        RecordingOnliveFragment.this.dd.a(liveGiftModel2);
                    }
                }
                if (liveRewardDescribe == null || liveRewardDescribe.m_hb_activity == null) {
                    return;
                }
                if (liveRewardDescribe.m_hb_activity.stage == 1) {
                    RecordingOnliveFragment recordingOnliveFragment = RecordingOnliveFragment.this;
                    String string = recordingOnliveFragment.E.getString(R.string.live_reward_special);
                    recordingOnliveFragment.i(String.format(string, liveRewardDescribe.m_hb_activity.need_count + "", CommonStringUtils.d(Double.toString(liveRewardDescribe.m_hb_activity.beans))));
                } else if (liveRewardDescribe.m_hb_activity.stage == 2) {
                    RecordingOnliveFragment recordingOnliveFragment2 = RecordingOnliveFragment.this;
                    String string2 = recordingOnliveFragment2.E.getString(R.string.live_reward_horn);
                    recordingOnliveFragment2.i(String.format(string2, liveRewardDescribe.m_hb_activity.need_count + "", CommonStringUtils.d(Double.toString(liveRewardDescribe.m_hb_activity.beans))));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(RankingExtra rankingExtra) {
        LiveRankingButtonView liveRankingButtonView = this.dk;
        if (liveRankingButtonView == null) {
            return;
        }
        liveRankingButtonView.setValue(rankingExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(RankingHourExtra rankingHourExtra) {
        LiveRankingButtonView liveRankingButtonView = this.dk;
        if (liveRankingButtonView == null || rankingHourExtra == null) {
            return;
        }
        liveRankingButtonView.setHourCountView(rankingHourExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        if (this.x) {
            return;
        }
        LiveMultiFunctionView liveMultiFunctionView = this.cH;
        if (liveMultiFunctionView != null) {
            liveMultiFunctionView.c();
        }
        ShapeTextView shapeTextView = this.cJ;
        if (shapeTextView != null) {
            shapeTextView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        this.R.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(RankingHourExtra rankingHourExtra) {
        LiveRankingButtonView liveRankingButtonView = this.dk;
        if (liveRankingButtonView == null || rankingHourExtra == null) {
            return;
        }
        liveRankingButtonView.a(rankingHourExtra.rank, rankingHourExtra.need_score);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Boolean bool) {
        if (this.x) {
            return;
        }
        this.bB.a(true, 1);
        bu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Integer num) {
        LiveMsgManager liveMsgManager = this.dd;
        if (liveMsgManager != null) {
            liveMsgManager.f(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA() {
        LiveRouteUtil.a();
        LiveRoomHttpUtils.a(2, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<MultiDialogModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.48
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MultiDialogModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    LiveRouteUtil.a(false);
                    return;
                }
                bluedEntityA.getSingleData().from_type = 2;
                LiveRouteUtil.a(RecordingOnliveFragment.this, bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveRouteUtil.a(false);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bB() {
        if (this.aa) {
            return;
        }
        aE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bC() {
        if (this.k == null || !this.k.c) {
            return;
        }
        this.k.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bD() {
        long v = LiveRoomManager.a().v();
        if (v >= 0) {
            this.ao.setText(CommonStringUtils.a(v));
        }
    }

    private void bo() {
        LiveEventBus.get("live_luck_turning_btn", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$qGBayKk7NuNd82AVmdD22M2m7I8
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.e((Boolean) obj);
            }
        });
        LiveEventBus.get("live_show_dialog", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$vzjtY0AkInU-eUJAHZhB6pXH7mE
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.d((Boolean) obj);
            }
        });
        LiveEventBus.get("live_ranking_msg", RankingExtra.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$uLmS4PBEs3m9hU5YMmTZ3Pynwcw
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.a((RankingExtra) obj);
            }
        });
        LiveEventBus.get("live_ranking_hour_msg", RankingHourExtra.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$gZFNDJPLFet2f35BQlwFZAx5cIc
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.b((RankingHourExtra) obj);
            }
        });
        LiveEventBus.get("live_ranking_hour_count_msg", RankingHourExtra.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$PGu9yY6a5XPs7N1-1M6x0TJ0U9A
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.a((RankingHourExtra) obj);
            }
        });
        LiveEventBus.get("live_ranking_dialog", Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$GKoC006lKTLsKYxXg66DDLrCk94
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.d((Integer) obj);
            }
        });
        LiveEventBus.get("live_pk_dialog", LivePkBannerModel.class).observe(this, new Observer<LivePkBannerModel>() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.5
            /* renamed from: a */
            public void onChanged(LivePkBannerModel livePkBannerModel) {
                if (livePkBannerModel == null || LiveRoomManager.a().p() == null || !LiveRoomManager.a().V()) {
                    return;
                }
                if (RecordingOnliveFragment.this.du == null) {
                    RecordingOnliveFragment recordingOnliveFragment = RecordingOnliveFragment.this;
                    recordingOnliveFragment.du = new PopPKListView(recordingOnliveFragment);
                }
                livePkBannerModel.from = 1;
                RecordingOnliveFragment.this.du.a(livePkBannerModel);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.b, LiveChattingModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$Hh-q6d23ylmKOtT5QsmD5UoQPro
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.d((LiveChattingModel) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.c, LiveEntranceData.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$PYKxEh-oGkKSRpAHSR5XPOcst7Y
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.a((LiveEntranceData) obj);
            }
        });
        LiveEventBus.get("live_beans_change", LiveBeansChangeEvent.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$JN_mAOEuDoAYifUGcLh8W1VGc1I
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.a((LiveBeansChangeEvent) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.o, String.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$dKfZO_NvyEij6pl5UFqg3do04tw
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.q((String) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.q, LiveAnnounceModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$7aZfeqrnhjAkXmzv_oLt9b6tn2k
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.b((LiveAnnounceModel) obj);
            }
        });
        LiveEventBus.get("live_center", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$9SVb6sL6mMzYxo5P5uo6JKcnfGI
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.c((Boolean) obj);
            }
        });
        LiveEventBus.get("live_center_multi_con_friends_pop", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$uEdRexfFXUg9mfHeiz6CspRnAs8
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.b((Boolean) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.B, String.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$W8AHEfn0cM7eRfHWg09JvLklQuY
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.p((String) obj);
            }
        });
        LiveEventBus.get("live_utils", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$8yMqp-z_F2Szx3cm_vRM2I2zwGs
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.a((Boolean) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.C, LiveRoomFunctionItemModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$8tTeBdd-OR5RSZ_FBFb3hXCH3sw
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.a((LiveRoomFunctionItemModel) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.k, Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$w7e1VWD7RBq2x5-WRTIJKvYJgXg
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.c((Integer) obj);
            }
        });
        LiveEventBus.get("live_tab_aaa", LiveShakeModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$hDpmMjK2FuCItoBnptZjd2vqwAw
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.b((LiveShakeModel) obj);
            }
        });
        LiveEventBus.get("live_reward", LiveRewardConfigModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$P7gXVzB5QSKQ-5BpUB21DRdZMAY
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.a((LiveRewardConfigModel) obj);
            }
        });
        LiveEventBus.get("live_multi_pk_stop", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$6zEkua5V-90Li4WCOdQj80eCYA4
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.h(((Boolean) obj).booleanValue());
            }
        });
        LiveEventBus.get("live_multi_pk_rank", LivePkBannerModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$_1xjy_OTtDlpBuyLxf3IpYUSID4
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.a((LivePkBannerModel) obj);
            }
        });
        LiveEventBus.get("live_attention_relation_changed", RelationInfo.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$I6L1f8Ehz0CyTfSeApdCbsv37ww
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.b((RelationInfo) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.g, Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$KB3bVr87YNRj5my27fLx7bO7gsU
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.b((Integer) obj);
            }
        });
    }

    private void bp() {
        LiveRoomData p = LiveRoomManager.a().p();
        LiveBottomOperationView liveBottomOperationView = this.cp;
        if (liveBottomOperationView != null || liveBottomOperationView.getWishingWellView() == null || p == null) {
            return;
        }
        if (this.x) {
            this.cp.getWishingWellView().setVisibility(8);
        } else if (p.entrance_status == 0) {
            this.cp.getWishingWellView().setVisibility(8);
        } else {
            this.cp.getWishingWellView().setVisibility(0);
            this.cp.getWishingWellView().setIcon(p.entrance_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq() {
        this.bB.a(this);
        this.cr.a(this);
        this.cv.a(0, null, this.t, this);
        this.k.a(true, new LiveMakeFriendManageView.LiveManageOnClickListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.9
            @Override // com.blued.android.module.live_china.view.LiveMakeFriendManageView.LiveManageOnClickListener
            public void a() {
                RecordingOnliveFragment.this.cv.b(true);
            }
        });
        LiveMakeLoverManagerRecordView liveMakeLoverManagerRecordView = this.bl;
        if (liveMakeLoverManagerRecordView != null) {
            liveMakeLoverManagerRecordView.a(true, new LiveMakeLoverManagerRecordView.LiveMakeLoverOnClickListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.10
                @Override // com.blued.android.module.live_china.view.LiveMakeLoverManagerRecordView.LiveMakeLoverOnClickListener
                public void a() {
                    EventTrackLive.b(LiveProtos.Event.ANCHOR_MIKE_MANAGE_CLICK, String.valueOf(RecordingOnliveFragment.this.t));
                    RecordingOnliveFragment.this.am();
                }
            });
        }
        GrabRewardView grabRewardView = this.bw;
        if (grabRewardView != null) {
            grabRewardView.a(this);
        }
        this.cc = new PopLiveCallView(this);
        PopStickerView popStickerView = new PopStickerView(this, this.ac);
        this.db = popStickerView;
        popStickerView.a();
        PopGestureView popGestureView = new PopGestureView(this, this.ac);
        this.dc = popGestureView;
        popGestureView.a();
        if (this.cR == null) {
            this.cR = new LiveGuideListManager(this, true);
        }
    }

    private void br() {
        if (this.x) {
            i(4);
        } else {
            h(4);
        }
        this.dd.a(4);
    }

    private void bs() {
        if (this.x) {
            i(0);
        } else {
            h(0);
        }
        this.dd.a(0);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt() {
        if (this.R == null || !LiveRoomPreferences.Q()) {
            return;
        }
        this.R.setVisibility(0);
        LiveEventBus.get(LiveEventBusUtil.D, Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$BbU05FRHX4AjLtfSNdpuztYJJsM
            public final void onChanged(Object obj) {
                RecordingOnliveFragment.this.a((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        LiveRoomPreferences.c(1);
        this.Q.setVisibility(8);
    }

    private void bv() {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<ShopStatusModel, LiveShopStatusExtra>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.17
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<ShopStatusModel, LiveShopStatusExtra> bluedEntity) {
                if (bluedEntity.getSingleData() != null && RecordingOnliveFragment.this.cH != null) {
                    LiveMultiFunctionView liveMultiFunctionView = RecordingOnliveFragment.this.cH;
                    boolean z = true;
                    if (bluedEntity.getSingleData().status != 1) {
                        z = false;
                    }
                    liveMultiFunctionView.a(z);
                }
                LiveShopStatusExtra liveShopStatusExtra = bluedEntity.extra;
                if (liveShopStatusExtra == null || RecordingOnliveFragment.this.cH == null) {
                    return;
                }
                RecordingOnliveFragment.this.cH.a(liveShopStatusExtra.top_card_count);
            }
        }, getFragmentActive());
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.18
            @Override // java.lang.Runnable
            public void run() {
                RecordingOnliveFragment.this.bh();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw() {
        LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntity<Object, LiveRankingHourConfig>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.25
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<Object, LiveRankingHourConfig> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                LiveRoomData p = LiveRoomManager.a().p();
                boolean z = true;
                if (bluedEntity.extra.config != 1) {
                    z = false;
                }
                p.isShowHourRank = z;
                if (RecordingOnliveFragment.this.dk != null) {
                    RecordingOnliveFragment.this.dk.a(LiveRoomManager.a().p().isShowHourRank);
                }
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx() {
        if (this.dA != null) {
            return;
        }
        this.dA = LiveHostFinishDialogFragment.a.a(getChildFragmentManager());
        if (LiveSettingConfig.a().b()) {
            LiveSettingConfig.a().a(LiveRoomHttpUtils.g(), LiveRoomHttpUtils.h(), ZegoCommonHelper.b().n());
        }
    }

    private void by() {
        this.cd.a(getFragmentActive(), "", RecyclingUtils.Scheme.FILE.b(AssetsUtils.a("live_multi_pk_start_anim.png", false)), "", "", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz() {
        LiveMultiFunctionView liveMultiFunctionView = this.cH;
        if (liveMultiFunctionView != null) {
            liveMultiFunctionView.f();
        }
        ShapeTextView shapeTextView = this.cJ;
        if (shapeTextView != null) {
            shapeTextView.setVisibility(0);
        }
    }

    private void c(LivePkRoundModel livePkRoundModel) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (LivePKPlayerModel livePKPlayerModel : livePkRoundModel.records) {
            if (livePKPlayerModel == null) {
                return;
            }
            if (livePKPlayerModel.uid == LiveRoomManager.a().f()) {
                if (livePKPlayerModel.pk_result != null) {
                    for (int i = 0; i < livePKPlayerModel.pk_result.size(); i++) {
                        LiveDotModel liveDotModel = new LiveDotModel();
                        liveDotModel.win = livePKPlayerModel.pk_result.get(i).intValue();
                        arrayList.add(liveDotModel);
                    }
                }
            } else if (livePKPlayerModel.pk_result != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < livePKPlayerModel.pk_result.size()) {
                        LiveDotModel liveDotModel2 = new LiveDotModel();
                        liveDotModel2.win = livePKPlayerModel.pk_result.get(i3).intValue();
                        arrayList2.add(liveDotModel2);
                        i2 = i3 + 1;
                    }
                }
            }
        }
        this.ch.a(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Boolean bool) {
        if (this.x) {
            return;
        }
        this.bB.a(true);
        bu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Integer num) {
        LiveOperationView liveOperationView = this.co;
        if (liveOperationView != null) {
            liveOperationView.a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(final Context context, final int i) {
        if (LiveSettingConfig.a().b()) {
            PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.3
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    RecordingOnliveFragment.e(context, i);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                }
            });
        } else {
            e(context, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(final Context context, final int i, final int i2, final String str, final int i3, final String str2, final int i4) {
        if (LiveSettingConfig.a().b()) {
            PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.4
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    RecordingOnliveFragment.e(context, i, i2, str, i3, str2, i4);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                }
            });
        } else {
            e(context, i, i2, str, i3, str2, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(LiveChattingModel liveChattingModel) {
        LiveMsgManager liveMsgManager = this.dd;
        if (liveMsgManager != null) {
            liveMsgManager.g(liveChattingModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Boolean bool) {
        if (bool.booleanValue()) {
            r_();
        } else {
            s_();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Integer num) {
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        PopRankingListView popRankingListView = this.dt;
        if (popRankingListView != null) {
            popRankingListView.b();
            if (this.dt.a()) {
                this.dt.c();
            }
        }
        if (LiveRoomManager.a().Q() || LiveRoomManager.a().p().isShowHourRank) {
            PopRankingListView popRankingListView2 = new PopRankingListView(this);
            this.dt = popRankingListView2;
            popRankingListView2.a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("official", i);
        TerminalActivity.a(bundle);
        PlayingOnliveActivity.b(context, RecordingOnliveFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context, int i, int i2, String str, int i3, String str2, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("live_type", i);
        bundle.putInt("LIVE_OUTER_RECORD_TYPE", i4);
        bundle.putInt("live_screen_orientation", i2);
        bundle.putInt("live_countdown", i3);
        bundle.putString("live_from_source", str2);
        TerminalActivity.a(bundle);
        PlayingOnliveActivity.b(context, RecordingOnliveFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Boolean bool) {
        bp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(LiveGiftModel liveGiftModel) {
        this.bt.a(getFragmentActive(), liveGiftModel.images_gif, liveGiftModel.images_apng2, liveGiftModel.images_mp4, liveGiftModel.anim_code, new AnimationListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.36
            @Override // com.blued.android.module.live.base.view.animation.AnimationListenerAdapter, com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void b() {
                RecordingOnliveFragment.this.bt.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(final LiveGiftModel liveGiftModel) {
        LiveAnimationViewFactory.ScaleType scaleType = LiveAnimationViewFactory.ScaleType.CENTER_CROP;
        LiveAnimationViewFactory.ScaleType scaleType2 = this.x ? LiveAnimationViewFactory.ScaleType.FIT_CENTER : LiveAnimationViewFactory.ScaleType.FIT_BOTTOM;
        HashMap hashMap = null;
        if (!TextUtils.isEmpty(liveGiftModel.luck_bag_img)) {
            hashMap = new HashMap();
            hashMap.put("KEY_LUCKY_BAG_IMG_URL", liveGiftModel.images_static);
            hashMap.put("KEY_LUCKY_BAG_GIFT_IMG_URL", liveGiftModel.luck_bag_img);
        }
        this.bs.a(getFragmentActive(), liveGiftModel.images_gif, liveGiftModel.images_apng2, liveGiftModel.images_mp4, liveGiftModel.anim_code, scaleType2, hashMap, new AnimationListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.35
            @Override // com.blued.android.module.live.base.view.animation.AnimationListenerAdapter, com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void b() {
                RecordingOnliveFragment.this.f(liveGiftModel);
                if (!liveGiftModel.is_opponent || TextUtils.isEmpty(liveGiftModel.resource_url)) {
                    return;
                }
                RecordingOnliveFragment.this.dd.b(liveGiftModel);
            }
        });
        if ("luckybag".equals(liveGiftModel.anim_code) || this.H == null || liveGiftModel.bunchLightModel == null || liveGiftModel.bunchLightModel.getImage() == null || liveGiftModel.bunchLightModel.getImage().isEmpty()) {
            return;
        }
        if (this.A == null) {
            this.A = new LiveBunchLightView(this.E);
            this.A.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.H.addView(this.A);
        }
        this.A.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$72Fd2pJVXewi-tk-GkzxZ5lS6OU
            @Override // java.lang.Runnable
            public final void run() {
                RecordingOnliveFragment.this.i(liveGiftModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(LiveGiftModel liveGiftModel) {
        this.A.a(liveGiftModel.bunchLightModel.getImage(), liveGiftModel.bunchLightModel.getPlay_times());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(LiveGiftModel liveGiftModel) {
        this.ab = false;
        Log.v("pk", "isPlayAR false ------- ");
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.a((LiveGiftModel) null, (ISetStickerListener) null);
        }
        this.dd.d(liveGiftModel);
        ax();
    }

    private void k(List<LivePKPlayerModel> list) {
        LivePKPlayerModel next;
        if (list == null) {
            return;
        }
        Iterator<LivePKPlayerModel> it = list.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.uid == LiveRoomManager.a().f()) {
                this.bE.setOurProgress(next.score);
            } else {
                this.bE.setOtherProgress(next.score);
            }
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void A() {
    }

    @Override // com.blued.android.module.live_china.fragment.LiveFansRecordDialogFragment.ILiveFansRecordDialog
    public void A_() {
        bs();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void B() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.16
            @Override // java.lang.Runnable
            public void run() {
                RecordingOnliveFragment.this.ap.a();
                RecordingOnliveFragment.this.Y();
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void B_() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void C() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$nWs_MpCGsB_DQSNJyGH8x7WVaR4
            @Override // java.lang.Runnable
            public final void run() {
                RecordingOnliveFragment.this.bD();
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void C_() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void D() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void D_() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void E() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void E_() {
    }

    @Override // com.blued.android.module.live_china.manager.PlayGifObserver.IPlayGifObserver
    public void F() {
        Logger.a("drb", "notifyPlayGif isPlayFullScreen = ", Boolean.valueOf(this.aa));
        if (this.aa) {
            return;
        }
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$Hfp0O0dwTI9gsFDDoL3OJ6kjLZg
            @Override // java.lang.Runnable
            public final void run() {
                RecordingOnliveFragment.this.bB();
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void F_() {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.20
            @Override // java.lang.Runnable
            public void run() {
                RecordingOnliveFragment.this.ah.start();
            }
        });
    }

    public void G() {
        this.br = true;
        au();
        this.at.setVisibility(0);
        if (this.ai.getVisibility() == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.cX;
            RecordingOnliveManager recordingOnliveManager = this.ac;
            if (recordingOnliveManager != null) {
                recordingOnliveManager.b((currentTimeMillis - j) / 1000);
            }
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void G_() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.21
            @Override // java.lang.Runnable
            public void run() {
                RecordingOnliveFragment.this.ah.stop();
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void H() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void H_() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void I() {
        String str;
        if (TextUtils.isEmpty(WishingWellView.a)) {
            str = !TextUtils.isEmpty(LiveRoomManager.a().p().entrance_url) ? LiveRoomManager.a().p().entrance_url : LiveRoomInfo.a().j() ? "https://activity-test.blued.cn/hd/2021/wishing-well/star-site?blued_mode=hide_nav" : "https://activity.blued.cn/hd/2021/wishing-well/star-site?blued_mode=hide_nav";
        } else {
            EventTrackLive.a(LiveProtos.Event.LIVE_HITS_ENTER_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            str = WishingWellView.a;
        }
        p(str);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void I_() {
        this.dn.a();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void J() {
        LiveRightTopFunctionPlace liveRightTopFunctionPlace = this.cP;
        if (liveRightTopFunctionPlace != null) {
            liveRightTopFunctionPlace.setDataToWish(LiveRoomManager.a().p().wishList);
        }
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void J_() {
        this.cM.a();
        ZegoCommonHelper.b().l();
        bk();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void K() {
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void K_() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void L() {
        this.bQ.setVisibility(0);
        aH();
        aF();
        if (this.x) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(this.E, 157.0f), DensityUtils.a(this.E, 280.0f));
            layoutParams.gravity = 85;
            layoutParams.setMargins(0, 0, DensityUtils.a(this.E, 50.0f), DensityUtils.a(this.E, 10.0f));
            this.bQ.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DensityUtils.a(this.E, 105.0f), DensityUtils.a(this.E, 187.0f));
            layoutParams2.gravity = 85;
            layoutParams2.setMargins(0, 0, 0, DensityUtils.a(this.E, 64.0f));
            this.bQ.setLayoutParams(layoutParams2);
        }
        this.bB.q();
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void L_() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void M() {
        Log.v("==record", "stopRTCModel");
        this.bQ.setVisibility(8);
        aG();
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.h();
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void N() {
    }

    public void O() {
        this.cB.e();
    }

    public void P() {
        this.cB.f();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void Q() {
    }

    public void R() {
        if (this.x) {
            getActivity().setRequestedOrientation(0);
        }
        this.bx.setVisibility(0);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.8
            @Override // java.lang.Runnable
            public void run() {
                RecordingOnliveFragment.this.N_();
                RecordingOnliveFragment.this.J();
                RecordingOnliveFragment.this.a(LiveRoomManager.a().p().beans_count, LiveRoomManager.a().p().beans_current_count);
                LiveMsgSendManager a = LiveMsgSendManager.a();
                a.d("勋章数据：" + LiveRoomManager.a().p().badges.size());
                LiveMsgSendManager a2 = LiveMsgSendManager.a();
                a2.d("活动排行：" + LiveRoomManager.a().p().rank);
                LiveMsgSendManager a3 = LiveMsgSendManager.a();
                a3.d("活动图标：" + LiveRoomManager.a().p().icon);
                RecordingOnliveFragment.this.a(LiveRoomManager.a().p().elapse_time);
                RecordingOnliveFragment.this.F_();
                RecordingOnliveFragment.this.cW.a(LiveRoomManager.a().p().live_url);
                RecordingOnliveFragment.this.bq();
                RecordingOnliveFragment.this.ac();
                RecordingOnliveFragment.this.dd.q();
            }
        }, 1000L);
    }

    public void S() {
        if (LiveRoomManager.a().p().goods_wall != null) {
            LiveSetDataObserver.a().a(LiveRoomManager.a().p().goods_wall);
        }
    }

    public void T() {
        Bundle bundle = new Bundle();
        bundle.putLong("KEY_LID", this.t);
        LiveManagerDialogFragment liveManagerDialogFragment = new LiveManagerDialogFragment();
        this.aA = liveManagerDialogFragment;
        liveManagerDialogFragment.a(new LiveRankGuestDialogFragment.ILiveGuestDialog() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.12
            @Override // com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.ILiveGuestDialog
            public void r_() {
                RecordingOnliveFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordingOnliveFragment.this.r_();
                    }
                }, 500L);
            }

            @Override // com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.ILiveGuestDialog
            public void s_() {
                RecordingOnliveFragment.this.s_();
            }
        });
        this.aA.setArguments(bundle);
        this.aA.show(getFragmentManager(), "managerListDialog");
    }

    public void U() {
        this.I = (FrameLayout) this.b.findViewById(R.id.live_host_content_fl);
        this.J = this.b.findViewById(R.id.view_dating_bg);
        this.K = (KeyboardListenLinearLayout) this.b.findViewById(R.id.keyboardLinearLayout);
        this.L = (FrameLayout) this.b.findViewById(R.id.cameraPreview_afl);
        this.M = (FrameLayout) this.b.findViewById(R.id.camera_preview_container);
        this.N = (TextureView) this.b.findViewById(R.id.cameraPreview_surfaceView);
        this.dl = (GameVideoView) this.b.findViewById(R.id.VideoView);
        this.bx = (FrameLayout) this.b.findViewById(R.id.switch_orientation_layout);
        if (StatusBarHelper.a()) {
            this.bx.setPadding(0, StatusBarHelper.a((Context) getActivity()), 0, 0);
        }
        StatusBarHelper.a((Activity) getActivity(), false);
        this.ai = this.b.findViewById(R.id.live_loading_layout);
        View findViewById = this.b.findViewById(R.id.live_interrupt_layout);
        this.aj = findViewById;
        this.al = (TextView) findViewById.findViewById(R.id.error_tips_title);
        this.am = (TextView) this.aj.findViewById(R.id.error_tips_message);
        this.an = (Button) this.aj.findViewById(R.id.error_tips_btn);
        this.aD = (FrameLayout) this.b.findViewById(R.id.RemoteWindowA);
        this.aE = (FrameLayout) this.b.findViewById(R.id.RemoteWindowB);
        this.aF = (FrameLayout) this.b.findViewById(R.id.RemoteWindowC);
        this.aG = (FrameLayout) this.b.findViewById(R.id.RemoteWindowD);
        this.aH = (FrameLayout) this.b.findViewById(R.id.RemoteWindowE);
        this.aI = (FrameLayout) this.b.findViewById(R.id.RemoteWindowF);
        this.aJ = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewA);
        this.aK = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewB);
        this.aL = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewC);
        this.aM = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewD);
        this.aN = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewE);
        this.aO = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewF);
        this.aP = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewA);
        this.aQ = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewB);
        this.aR = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewC);
        this.aS = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewD);
        this.aT = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewE);
        this.aU = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewF);
        this.aV = (ImageView) this.b.findViewById(R.id.out_userA_btn);
        this.aW = (ImageView) this.b.findViewById(R.id.out_userB_btn);
        this.aX = (TextView) this.b.findViewById(R.id.remote_nameA);
        this.aY = (TextView) this.b.findViewById(R.id.remote_nameB);
        this.aZ = (TextView) this.b.findViewById(R.id.remote_nameC);
        this.ba = (TextView) this.b.findViewById(R.id.remote_nameD);
        this.bb = (FrameLayout) this.b.findViewById(R.id.remote_loading_layoutB);
        this.bc = (FrameLayout) this.b.findViewById(R.id.remote_loading_layoutC);
        this.bd = (FrameLayout) this.b.findViewById(R.id.remote_loading_layoutD);
        this.be = (ImageView) this.b.findViewById(R.id.live_make_friend_mic_B);
        this.bf = (ImageView) this.b.findViewById(R.id.live_make_friend_mic_C);
        this.bg = (ImageView) this.b.findViewById(R.id.live_make_friend_mic_D);
        this.bh = this.b.findViewById(R.id.live_make_friend_free_B);
        this.bi = this.b.findViewById(R.id.live_make_friend_free_C);
        this.bj = this.b.findViewById(R.id.live_make_friend_free_D);
        this.cw = (ImageView) this.b.findViewById(R.id.live_make_friend_num_host);
        this.cu = (ImageView) this.b.findViewById(R.id.live_make_friends_close_btn);
        this.cF = (ImageView) this.b.findViewById(R.id.live_make_friend_photo_A);
        this.bA = (ImageView) this.b.findViewById(R.id.live_switch_screen);
        this.bC = (FrameLayout) this.b.findViewById(R.id.live_window_root_layout);
        this.bD = (FrameLayout) this.b.findViewById(R.id.live_window_layout);
        this.bE = (LivePKProgressView) this.b.findViewById(R.id.live_pk_progress);
        this.bJ = (FrameLayout) this.b.findViewById(R.id.fl_multi_connection);
        this.bF = (LivePKUserBanner) this.b.findViewById(R.id.live_pk_banner);
        this.bG = (LinearLayout) this.b.findViewById(R.id.live_pk_operate_layout);
        this.bH = (ImageView) this.b.findViewById(R.id.live_pk_operate_close);
        this.bI = (TextView) this.b.findViewById(R.id.live_pk_operate_text);
        this.bM = (LivePKBubbleLayout) this.b.findViewById(R.id.live_pk_my_bubble);
        this.bN = (LivePKBubbleLayout) this.b.findViewById(R.id.live_pk_your_bubble);
        this.cd = (LiveAnimationView) this.b.findViewById(R.id.live_pk_start_anim);
        PKDoubleAnimView pKDoubleAnimView = (PKDoubleAnimView) this.b.findViewById(R.id.pk_double_anim_view);
        this.dm = pKDoubleAnimView;
        pKDoubleAnimView.setVisibility(8);
        LivePKResult livePKResult = (LivePKResult) this.b.findViewById(R.id.pk_result);
        this.ce = livePKResult;
        livePKResult.setFragment(this);
        this.cf = (LivePKPayMVPView) this.b.findViewById(R.id.pk_pay_mvp);
        LivePKPlusView livePKPlusView = (LivePKPlusView) this.b.findViewById(R.id.pk_plus_view);
        this.cg = livePKPlusView;
        livePKPlusView.setFragment(this);
        this.ch = (LivePKRoundDotView) this.b.findViewById(R.id.pk_round_dot);
        this.ci = (LivePKRoundStartView) this.b.findViewById(R.id.pk_round_start);
        this.cj = (LivePKRoundTimeView) this.b.findViewById(R.id.pk_round_time);
        this.ck = (LivePkRoundCountDownView) this.b.findViewById(R.id.pk_round_count);
        this.cl = (LivePKRoundToastView) this.b.findViewById(R.id.pk_round_toast_view);
        LivePKCountDownView livePKCountDownView = (LivePKCountDownView) this.b.findViewById(R.id.live_pk_count_down_view);
        this.bO = livePKCountDownView;
        livePKCountDownView.setData(this);
        this.bP = (LivePKFirstPayView) this.b.findViewById(R.id.live_pk_first_pay);
        this.bQ = this.b.findViewById(R.id.live_window_layout_B);
        this.bR = this.b.findViewById(R.id.live_window_layoutC);
        this.bS = this.b.findViewById(R.id.live_window_layoutD);
        this.bT = this.b.findViewById(R.id.live_window_layoutE);
        this.bU = this.b.findViewById(R.id.live_window_layoutF);
        this.bV = this.b.findViewById(R.id.live_make_friend_windows_B);
        this.bW = this.b.findViewById(R.id.live_make_friend_windows_C);
        this.bX = this.b.findViewById(R.id.live_make_friend_windows_D);
        this.bY = (TextView) this.b.findViewById(R.id.live_make_friend_name_B);
        this.bZ = (TextView) this.b.findViewById(R.id.live_make_friend_name_C);
        this.ca = (TextView) this.b.findViewById(R.id.live_make_friend_name_D);
        this.cb = (ImageView) this.b.findViewById(R.id.iv_pk_voice_switchB);
        LiveMakeLoverRootRecordView liveMakeLoverRootRecordView = (LiveMakeLoverRootRecordView) this.b.findViewById(R.id.live_make_lover_record_root_view);
        this.bk = liveMakeLoverRootRecordView;
        liveMakeLoverRootRecordView.a(this);
        this.bB = (LiveConnectionView) this.b.findViewById(R.id.live_connection_view);
        this.cr = (LiveConnectionInviteView) this.b.findViewById(R.id.live_connection_invite_view);
        this.cv = (LiveMakeFriendListView) this.b.findViewById(R.id.live_make_friend_list_view);
        StartLiveView startLiveView = (StartLiveView) this.b.findViewById(R.id.start_live_view);
        this.cB = startLiveView;
        startLiveView.a(this);
        this.bx.setVisibility(8);
        this.cD = this.b.findViewById(R.id.live_my_header_layout);
        this.cE = (ImageView) this.b.findViewById(R.id.live_my_header_view);
        ImageLoader.a(getFragmentActive(), LiveRoomInfo.a().d()).a(this.cE);
        this.cK = (LiveRecordStickerViewLayout) this.b.findViewById(R.id.live_record_sticker_layout);
        this.cL = this.b.findViewById(R.id.live_record_sticker_bottom_view);
        this.cK.a(this);
        this.an.setOnClickListener(this);
        this.aj.setOnClickListener(this);
        this.aV.setOnClickListener(this);
        this.aW.setOnClickListener(this);
        this.bA.setOnTouchListener(this);
        this.bH.setOnClickListener(this);
        this.cu.setOnClickListener(this);
        this.bV.setOnClickListener(this);
        this.bW.setOnClickListener(this);
        this.bX.setOnClickListener(this);
        this.L.setOnClickListener(this);
    }

    public void V() {
        final View findViewById = this.b.findViewById(R.id.live_container);
        final ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        final View findViewById2 = this.b.findViewById(R.id.live_music);
        final ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.13
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int height = RecordingOnliveFragment.this.b.getHeight();
                if (height != 0) {
                    RecordingOnliveFragment.this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    layoutParams.height = height;
                    Log.i("==xpf", "params.height:" + layoutParams.height);
                    findViewById.setLayoutParams(layoutParams);
                    layoutParams2.height = height;
                    findViewById2.setLayoutParams(layoutParams2);
                }
            }
        });
        k();
        this.H = (FrameLayout) this.b.findViewById(R.id.fl_root);
        PopLiveActivityWebView popLiveActivityWebView = (PopLiveActivityWebView) this.b.findViewById(R.id.live_activity_web_view);
        this.cO = popLiveActivityWebView;
        if (popLiveActivityWebView != null) {
            popLiveActivityWebView.a(this);
        }
        Logger.a("drb", "reInitView LiveBeautyBtn");
        this.aB = this.b.findViewById(R.id.live_like_view_root);
        this.aC = (ImageView) this.b.findViewById(R.id.live_like_view);
        this.S = (ImageView) this.b.findViewById(R.id.live_bottom_icon_more);
        this.T = this.b.findViewById(R.id.tv_dot);
        this.U = (ImageView) this.b.findViewById(R.id.live_wish_enter);
        this.P = (ImageView) this.b.findViewById(R.id.live_reward_view);
        this.Q = (ImageView) this.b.findViewById(R.id.live_pk_new);
        this.R = this.b.findViewById(R.id.view_pk_dot);
        this.W = this.b.findViewById(R.id.close_btn);
        this.O = (ImageView) this.b.findViewById(R.id.header_view);
        PkDaredView pkDaredView = this.cQ;
        if (pkDaredView != null) {
            pkDaredView.d();
        }
        PkDaredView pkDaredView2 = (PkDaredView) this.b.findViewById(R.id.pdv_pk_dared);
        this.cQ = pkDaredView2;
        if (pkDaredView2 != null) {
            pkDaredView2.a(getFragmentActive());
            this.cQ.setStartPKAnimRootView(this.H);
        }
        this.cU = (ViewGroup) this.b.findViewById(R.id.ll_btm_right);
        this.cM = (LiveMusicFloatView) this.b.findViewById(R.id.music_float_view);
        this.cq = (LiveAnnouceView) this.b.findViewById(R.id.live_annoce);
        this.at = (ProgressBar) this.b.findViewById(R.id.loading_view);
        this.Z = (ImageView) this.b.findViewById(R.id.all_gif_view);
        this.ao = (TextView) this.b.findViewById(R.id.onlive_all_count);
        this.aq = (TextView) this.b.findViewById(R.id.onlive_current_beans);
        this.ak = (RelativeLayout) this.b.findViewById(R.id.live_bottom_root);
        this.ah = (Chronometer) this.b.findViewById(R.id.chronometer);
        LiveViewerListView liveViewerListView = (LiveViewerListView) this.b.findViewById(R.id.live_viewer);
        this.ap = liveViewerListView;
        liveViewerListView.a(getChildFragmentManager(), this.x);
        this.bs = (LiveAnimationView) this.b.findViewById(R.id.live_animation_layou);
        this.bt = (LiveAnimationView) this.b.findViewById(R.id.live_universal_animation);
        this.bu = (ViewGroup) this.b.findViewById(R.id.live_beans_btn_root);
        this.bv = this.b.findViewById(R.id.live_guest_beans_arrow);
        this.dk = (LiveRankingButtonView) this.b.findViewById(R.id.ranking_button_view);
        this.av = (HornViewNew) this.b.findViewById(R.id.horn_view);
        this.aw = (BarrageHornView) this.b.findViewById(R.id.barrage_horn_view);
        this.bK = (LinearLayout) this.b.findViewById(R.id.live_pk_rank_layout);
        this.bL = (ImageView) this.b.findViewById(R.id.live_pk_rank_icon);
        this.bw = (GrabRewardView) this.b.findViewById(R.id.grab_reward_view);
        LiveTitleView liveTitleView = (LiveTitleView) this.b.findViewById(R.id.live_title_view);
        this.cG = liveTitleView;
        liveTitleView.a(this.x, this);
        LiveMultiFunctionView liveMultiFunctionView = (LiveMultiFunctionView) this.b.findViewById(R.id.live_multi_function_view);
        this.cH = liveMultiFunctionView;
        if (liveMultiFunctionView != null) {
            liveMultiFunctionView.setLiveEventListener(new LiveMultiFunctionView.LiveEventListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$RtqE_PJH6vymtaTWmFBhCBur1Ec
                @Override // com.blued.android.module.live_china.view.LiveMultiFunctionView.LiveEventListener
                public final void onClose() {
                    RecordingOnliveFragment.this.bC();
                }
            });
            this.cH.a(this.x, this);
        }
        this.cI = (ImageView) this.b.findViewById(R.id.live_multi_function_btn);
        this.cJ = (ShapeTextView) this.b.findViewById(R.id.live_multi_function_dot);
        this.f46do = (LinearLayout) this.b.findViewById(R.id.live_anchor_layout);
        this.dp = (ImageView) this.b.findViewById(R.id.header_level_bg);
        this.dF = (LiveOnlineUserTipsView) this.b.findViewById(R.id.view_live_online_user_tips);
        LiveRecordLevelView liveRecordLevelView = (LiveRecordLevelView) this.b.findViewById(R.id.live_record_relevel_view);
        this.dq = liveRecordLevelView;
        liveRecordLevelView.setEventCallback(new LiveRecordLevelView.EventCallback() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.14
            @Override // com.blued.android.module.live_china.view.LiveRecordLevelView.EventCallback
            public void a() {
                new PopRecordLevelView(RecordingOnliveFragment.this).a();
                EventTrackLive.a(LiveProtos.Event.LIVE_EXPERIENCE_BAR_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
        });
        LiveDefinedRankView liveDefinedRankView = (LiveDefinedRankView) this.b.findViewById(R.id.live_defined_rank_layout_id);
        this.cm = liveDefinedRankView;
        if (liveDefinedRankView != null) {
            liveDefinedRankView.setFragment(this);
        }
        if (!this.x) {
            this.f50cn = new LiveOperationManager(this, true);
            LiveOperationView liveOperationView = (LiveOperationView) this.b.findViewById(R.id.live_operation_view);
            this.co = liveOperationView;
            if (liveOperationView != null) {
                liveOperationView.a((BaseFragment) this, true);
                this.f50cn.a(this.co);
            }
            LiveBottomOperationView liveBottomOperationView = (LiveBottomOperationView) this.b.findViewById(R.id.live_bottom_operation);
            this.cp = liveBottomOperationView;
            if (liveBottomOperationView != null) {
                liveBottomOperationView.a(this, true);
                this.f50cn.a(this.cp);
            }
        }
        LiveRightTopFunctionPlace liveRightTopFunctionPlace = (LiveRightTopFunctionPlace) this.b.findViewById(R.id.live_right_top_function);
        this.cP = liveRightTopFunctionPlace;
        if (liveRightTopFunctionPlace != null) {
            liveRightTopFunctionPlace.setBaseFragment(this);
        }
        LiveCountDownView liveCountDownView = (LiveCountDownView) this.b.findViewById(R.id.live_record_view);
        this.ds = liveCountDownView;
        liveCountDownView.setEventCallBack(new LiveCountDownView.EventCallBack() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.15
            @Override // com.blued.android.module.live_china.view.LiveCountDownView.EventCallBack
            public void a() {
                LiveEventBus.get(LiveEventBusUtil.m).post(true);
            }

            @Override // com.blued.android.module.live_china.view.LiveCountDownView.EventCallBack
            public void a(boolean z) {
                LiveEventBus.get(LiveEventBusUtil.n).post(Boolean.valueOf(z));
            }

            @Override // com.blued.android.module.live_china.view.LiveCountDownView.EventCallBack
            public void b() {
                RecordingOnliveFragment.this.G();
            }
        });
        this.dr = this.b.findViewById(R.id.live_msg_content_pullrefresh);
        this.cN = this.b.findViewById(R.id.fl_live_fans);
        this.bl = (LiveMakeLoverManagerRecordView) this.b.findViewById(R.id.live_lover_manage_record_view);
        if (this.x) {
            g_(8);
        }
        ImageView imageView = this.cI;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.ah.setOnChronometerTickListener(this);
        this.aC.setOnClickListener(this);
        this.W.setOnClickListener(this);
        ImageView imageView2 = this.S;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        this.U.setOnClickListener(this);
        ImageView imageView3 = this.P;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        this.bu.setOnClickListener(this);
        View view = this.cN;
        if (view != null) {
            view.setOnClickListener(this);
        }
        this.cM.setOnClickListener(this);
        this.O.setOnClickListener(this);
        ImageLoader.a(getFragmentActive(), LiveRoomInfo.a().d()).c().b(R.drawable.user_bg_round).a(this.O);
        this.z = true;
    }

    public void W() {
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        a(LiveRoomManager.a().p().level, LiveRoomManager.a().p().next_level, (int) LiveRoomManager.a().p().percent, CommonStringUtils.b(LiveRoomManager.a().p().gap_exp));
    }

    public void X() {
        boolean z = this.x;
    }

    public void Y() {
        LiveOnlineUserTipsView liveOnlineUserTipsView;
        if ((LiveRoomManager.a().x().size() <= 0 && LiveRoomManager.a().w().size() <= 0) || (liveOnlineUserTipsView = this.dF) == null || this.dG) {
            return;
        }
        this.dG = true;
        liveOnlineUserTipsView.a(5, "recordingLive", getChildFragmentManager());
    }

    public void Z() {
        LiveMultiFunctionView liveMultiFunctionView;
        if (aV() || (liveMultiFunctionView = this.cH) == null) {
            return;
        }
        liveMultiFunctionView.e();
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a() {
        if (YYMusicManager.a.c().a() != null) {
            this.cM.setPlaying(true);
            ZegoCommonHelper.b().j();
        }
    }

    @Override // com.blued.android.module.live_china.observer.BeansRefreshObserver.IBeansRefreshObserver
    public void a(double d, double d2) {
        Logger.a("rrrb", "notifyUpdateBeans beans = ", Double.valueOf(d), " -- beans_current_count = ", Double.valueOf(d2));
        if (d < 0.0d) {
            return;
        }
        LiveRoomManager.a().a(d, d2);
        this.ar = d;
        this.as = d2;
        this.aq.setText(CommonStringUtils.d(String.valueOf(d2)));
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(int i, int i2) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(int i, int i2, int i3, float f) {
        this.cz = i;
        this.dq.a(i, i2, i3, f);
        j(i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(int i, int i2, int i3, int i4) {
    }

    public void a(int i, int i2, String str) {
        this.bB.a(i, i2, str, this.bo.c());
    }

    public void a(int i, int i2, String str, List<LiveGroupPkUserModel> list) {
        this.bB.a(i, i2, str, this.bo.c(), list);
    }

    public void a(int i, int i2, boolean z, int i3) {
        RecordingPlayerManager recordingPlayerManager = this.cW;
        if (recordingPlayerManager != null) {
            recordingPlayerManager.a(i, i2, z, i3);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(long j) {
        this.ag = j;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void a(Bundle bundle) {
        super.a(bundle);
        this.E = getActivity();
        if (!STNewLicenseUtils.a(getContext())) {
            AppMethods.d(R.string.sense_license_is_overdue);
        }
        this.ae = ((PowerManager) getActivity().getSystemService(PowerMenuConstants.GLOBAL_ACTION_KEY_POWER)).newWakeLock(536870938, "RecordingOnliveFragment");
        this.by = new RecordingScreenManager(this);
        LiveRoomManager.a().b(true);
        b(this.K);
        if (bundle != null && bundle.getBoolean("unexpectedly_exit")) {
            f(true);
        }
        bv();
    }

    public void a(View view, final LiveRoomTipsModel liveRoomTipsModel) {
        if (this.E == null || getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        LiveCommonPopTips liveCommonPopTips = this.dj;
        if (liveCommonPopTips == null || !liveCommonPopTips.z()) {
            LiveCommonPopTips liveCommonPopTips2 = new LiveCommonPopTips(this.E, liveRoomTipsModel);
            this.dj = liveCommonPopTips2;
            liveCommonPopTips2.a(view, new XPopupCallback() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.51
                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void a(BasePopupView basePopupView) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void a(BasePopupView basePopupView, int i) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void a(BasePopupView basePopupView, int i, float f, boolean z) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void b(BasePopupView basePopupView) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void c(BasePopupView basePopupView) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void d(BasePopupView basePopupView) {
                    String g = LiveRoomManager.a().g();
                    LiveRoomHttpUtils.a(g, liveRoomTipsModel.getId() + "", RecordingOnliveFragment.this.getFragmentActive());
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void e(BasePopupView basePopupView) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public boolean f(BasePopupView basePopupView) {
                    String g = LiveRoomManager.a().g();
                    LiveRoomHttpUtils.a(g, liveRoomTipsModel.getId() + "", RecordingOnliveFragment.this.getFragmentActive());
                    return false;
                }
            });
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(EditText editText, boolean z, SendMsgListener sendMsgListener) {
    }

    public void a(final LiveChatStatistics liveChatStatistics) {
        this.bp = true;
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.34
            @Override // java.lang.Runnable
            public void run() {
                Logger.d("RecordingOnliveFragment", "中断直播 ... ");
                RecordingOnliveFragment.this.aP();
                RecordingOnliveFragment.this.G();
                if (TextUtils.isEmpty(liveChatStatistics.title)) {
                    RecordingOnliveFragment.this.al.setText(R.string.Live_applyHost_wormNotice);
                } else {
                    RecordingOnliveFragment.this.al.setText(liveChatStatistics.title);
                }
                if (TextUtils.isEmpty(liveChatStatistics.message)) {
                    RecordingOnliveFragment.this.am.setText(RecordingOnliveFragment.this.getString(R.string.liveVideo_livingView_tips_interrupted));
                } else {
                    RecordingOnliveFragment.this.am.setText(liveChatStatistics.message);
                }
                RecordingOnliveFragment.this.aj.setVisibility(0);
                AnimationUtils.a(RecordingOnliveFragment.this.aj);
            }
        });
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(LiveMusicModel liveMusicModel) {
        if (liveMusicModel == null) {
            return;
        }
        if (!this.dx) {
            this.dx = true;
            AppMethods.d(R.string.live_music_volume);
        }
        this.cM.setVisibility(0);
        this.cM.setData(liveMusicModel);
        this.df = liveMusicModel.music_id;
        this.dg = liveMusicModel.sheet_id;
        this.dh = liveMusicModel.curDuration;
        ZegoCommonHelper.b().m();
        ZegoCommonHelper.b().j();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(FunctionRedPModelJson functionRedPModelJson) {
    }

    public void a(HTMLNoticeModel hTMLNoticeModel) {
        if (hTMLNoticeModel == null || TextUtils.isEmpty(hTMLNoticeModel.html_msg)) {
            return;
        }
        PopLiveActivityWebView popLiveActivityWebView = this.cO;
        if (popLiveActivityWebView != null && popLiveActivityWebView.e()) {
            this.cO.setJsBridgeData(hTMLNoticeModel);
            return;
        }
        LiveHalfWebDialogFragment liveHalfWebDialogFragment = this.dB;
        if (liveHalfWebDialogFragment != null && liveHalfWebDialogFragment.isAdded() && this.dB.f()) {
            this.dB.a(hTMLNoticeModel);
        }
    }

    /* renamed from: a */
    public void b(LiveAnnounceModel liveAnnounceModel) {
        if (liveAnnounceModel == null) {
            this.cq.b();
            return;
        }
        LiveAnnouceView liveAnnouceView = this.cq;
        if (liveAnnouceView != null) {
            liveAnnouceView.a(liveAnnounceModel.notice_content);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveChattingModel liveChattingModel) {
        this.dd.c(liveChattingModel);
    }

    public void a(LiveFriendModel liveFriendModel) {
        this.aC.setImageResource(R.drawable.live_multi_pk_state);
        String str = this.bB.n() ? "all" : "friend";
        this.bB.d();
        this.bB.e();
        d_(7);
        if (this.ac != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(LiveRoomManager.a().g());
            arrayList.add(liveFriendModel.uid);
            arrayList2.add(liveFriendModel.lid);
            arrayList2.add(LiveRoomManager.a().e());
            ZegoMixStreamHelper.a().a(arrayList, arrayList2);
            this.ac.a(0, liveFriendModel.target_stream);
        }
        a(liveFriendModel, str);
    }

    public void a(LiveFriendModel liveFriendModel, String str) {
        long j;
        d_(1);
        if (LiveRoomManager.a().V()) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.d();
        }
        int i = AppInfo.l / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, DensityUtils.a(this.E, 148), 0, 0);
        this.bC.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bD.getLayoutParams();
        layoutParams2.width = -1;
        int i2 = (i / 3) * 4;
        layoutParams2.height = i2;
        this.bD.setLayoutParams(layoutParams2);
        this.L.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, i2);
        layoutParams3.gravity = 5;
        this.bQ.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.bG.getLayoutParams();
        layoutParams4.topMargin = (DensityUtils.a(this.E, 170.0f) + i2) - DensityUtils.a(this.E, 25.0f);
        this.bG.setLayoutParams(layoutParams4);
        this.bE.setVisibility(0);
        this.bE.b();
        RecordingOnliveManager recordingOnliveManager2 = this.ac;
        if (recordingOnliveManager2 != null) {
            recordingOnliveManager2.k();
        }
        this.bO.setVisibility(0);
        this.bO.a(liveFriendModel.delay, true);
        if (!TextUtils.isEmpty(liveFriendModel.first_kill_message)) {
            this.bP.setText(liveFriendModel.first_kill_message);
        }
        this.bP.setVisibility(this.ad.c() ? 0 : 8);
        LivePKPlayerModel livePKPlayerModel = null;
        if (liveFriendModel == null || liveFriendModel.records == null) {
            j = 0;
            livePKPlayerModel = null;
        } else {
            int i3 = 0;
            j = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (LivePKPlayerModel livePKPlayerModel2 : liveFriendModel.records) {
                if (livePKPlayerModel2 == null) {
                    return;
                }
                if (livePKPlayerModel2.uid == LiveRoomManager.a().f()) {
                    i3 = livePKPlayerModel2.win_streak;
                    i5 = livePKPlayerModel2.target_streak;
                    i7 = livePKPlayerModel2.target_beans;
                    i6 = livePKPlayerModel2.total_beans;
                } else {
                    i4 = livePKPlayerModel2.win_streak;
                    j = livePKPlayerModel2.uid;
                    livePKPlayerModel = livePKPlayerModel2;
                }
            }
            this.ad.a = j;
            LivePKPlusModel livePKPlusModel = new LivePKPlusModel();
            livePKPlusModel.leftWinNum = i3;
            livePKPlusModel.rightWinNum = i4;
            livePKPlusModel.result = -1;
            livePKPlusModel.otherUid = j;
            livePKPlusModel.target_streak = i5;
            livePKPlusModel.total_beans = i6;
            livePKPlusModel.target_beans = i7;
            this.cg.setResult(livePKPlusModel);
            this.cg.setOtherLid(StringUtils.a(liveFriendModel.lid, 0L));
        }
        if (liveFriendModel != null) {
            this.bF.a(liveFriendModel.lid, livePKPlayerModel);
        }
        this.bF.setVisibility(0);
        this.bQ.setVisibility(0);
        m("");
        this.aW.setVisibility(8);
        this.bB.q();
        a(liveFriendModel, String.valueOf(j), str);
        a(liveFriendModel, j, "");
    }

    public void a(LiveFriendModel liveFriendModel, String str, String str2) {
        this.cS = new LivePkRoundSelectDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("delay", liveFriendModel.delay);
        bundle.putString("lid", liveFriendModel.lid);
        bundle.putString("uid", str);
        bundle.putString("type", str2);
        this.cS.setArguments(bundle);
        this.cS.show(getChildFragmentManager(), "pkRoundDialogFragment");
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(final LiveGiftModel liveGiftModel) {
        LiveAnimationView liveAnimationView = this.bt;
        if (liveAnimationView == null) {
            return;
        }
        if (liveAnimationView.getVisibility() != 0) {
            this.bt.setVisibility(0);
        }
        this.bt.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$Hm4EYajqDf5ZAW0dOwWEkWEOLlw
            @Override // java.lang.Runnable
            public final void run() {
                RecordingOnliveFragment.this.g(liveGiftModel);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveGiftWallFloatModel liveGiftWallFloatModel) {
        LiveRightTopFunctionPlace liveRightTopFunctionPlace = this.cP;
        if (liveRightTopFunctionPlace != null) {
            liveRightTopFunctionPlace.setDataToGoodsWall(liveGiftWallFloatModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveHornModelNew liveHornModelNew, boolean z) {
        if (liveHornModelNew == null) {
            return;
        }
        if (liveHornModelNew.position == 1) {
            if (this.av == null) {
                this.av = (HornViewNew) this.b.findViewById(R.id.horn_view);
            }
            HornViewNew hornViewNew = this.av;
            if (hornViewNew != null) {
                hornViewNew.a(liveHornModelNew, z);
            }
        } else if (liveHornModelNew.position == 2) {
            if (this.aw == null) {
                this.aw = (BarrageHornView) this.b.findViewById(R.id.barrage_horn_view);
            }
            BarrageHornView barrageHornView = this.aw;
            if (barrageHornView != null) {
                barrageHornView.a(liveHornModelNew);
            }
        }
    }

    public void a(LiveInviteUserModel liveInviteUserModel) {
        this.bo.a(liveInviteUserModel);
        this.bB.a(this.bo.c(), liveInviteUserModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveMakeLoverFansModel liveMakeLoverFansModel) {
    }

    public void a(LivePkBannerModel livePkBannerModel) {
        new PopMultiPKRankView().a(getContext(), livePkBannerModel, getFragmentActive());
    }

    public void a(LivePkRoundModel livePkRoundModel) {
        Log.i("==xpm", "onPkRoundStart：" + livePkRoundModel.toString());
        this.bP.setVisibility(this.ad.c() ? 0 : 8);
        ag();
        this.bF.setVsVisable(false);
        this.bF.b();
        this.ce.a();
        this.cl.a();
        this.bE.b();
        this.ci.a(livePkRoundModel.count);
        this.cj.a(livePkRoundModel.count);
        c(livePkRoundModel);
        LiveFriendModel liveFriendModel = new LiveFriendModel();
        liveFriendModel.countdown = livePkRoundModel.countdown;
        this.bO.setPKCountDownCallback(new LivePKCountDownView.PKCountDownCallback() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.41
            @Override // com.blued.android.module.live_china.view.LivePKCountDownView.PKCountDownCallback
            public void a() {
                RecordingOnliveFragment.this.ck.a();
            }
        });
        this.bO.a(liveFriendModel.countdown, true);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cb.getLayoutParams();
        marginLayoutParams.topMargin = DensityUtils.a(this.E, 24.0f);
        this.cb.setLayoutParams(marginLayoutParams);
    }

    public void a(LiveRecordLevelStickerModel liveRecordLevelStickerModel) {
        PopStickerView popStickerView = this.db;
        if (popStickerView != null) {
            popStickerView.a(liveRecordLevelStickerModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRewardModel liveRewardModel) {
        LiveOperationView liveOperationView = this.co;
        if (liveOperationView != null) {
            liveOperationView.a(EnumOperation.VIEW_TYPE_RED_BAG.getValue(), liveRewardModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomData liveRoomData) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0160, code lost:
        if (r0.equals(com.blued.android.module.live_china.model.ConstFunction.LIVE_ROOM_BEAUTY) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.module.live_china.model.LiveRoomFunctionItemModel r5) {
        /*
            Method dump skipped, instructions count: 1041
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.a(com.blued.android.module.live_china.model.LiveRoomFunctionItemModel):void");
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomOperationModel liveRoomOperationModel) {
        LiveOperationView liveOperationView = this.co;
        if (liveOperationView != null) {
            liveOperationView.a(liveRoomOperationModel.getTools_type(), (Object) liveRoomOperationModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomTipsModel liveRoomTipsModel) {
        if (liveRoomTipsModel == null) {
            return;
        }
        int location = liveRoomTipsModel.getLocation();
        if (location == 10) {
            a(this.S, liveRoomTipsModel);
            return;
        }
        switch (location) {
            case 20:
                a(this.aB, liveRoomTipsModel);
                return;
            case 21:
                a(this.U, liveRoomTipsModel);
                return;
            case 22:
                if (this.cp.getViewList().size() <= 0 || this.cp.getViewList().get(0) == null) {
                    return;
                }
                a(this.cp.getViewList().get(0), liveRoomTipsModel);
                return;
            case 23:
                if (this.cp.getViewList().size() <= 1 || this.cp.getViewList().get(1) == null) {
                    return;
                }
                a(this.cp.getViewList().get(1), liveRoomTipsModel);
                return;
            case 24:
                if (this.cp.getViewList().size() <= 2 || this.cp.getViewList().get(2) == null) {
                    return;
                }
                a(this.cp.getViewList().get(2), liveRoomTipsModel);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomUserModel liveRoomUserModel) {
        this.dd.a(liveRoomUserModel);
    }

    public void a(LiveShakeModel liveShakeModel) {
        if (liveShakeModel != null) {
            liveShakeModel.pageFrom = 1;
        }
        LiveShakeDialogFragment liveShakeDialogFragment = this.cT;
        if (liveShakeDialogFragment != null && liveShakeDialogFragment.e()) {
            this.cT.a(liveShakeModel);
            return;
        }
        LiveShakeDialogFragment liveShakeDialogFragment2 = this.cT;
        if (liveShakeDialogFragment2 != null) {
            liveShakeDialogFragment2.d();
        }
        this.cT = new LiveShakeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("shakeModel", liveShakeModel);
        this.cT.setArguments(bundle);
        this.cT.show(getChildFragmentManager(), "shakeDialogFragment");
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveWishItemModel liveWishItemModel) {
        LiveRightTopFunctionPlace liveRightTopFunctionPlace = this.cP;
        if (liveRightTopFunctionPlace == null || liveWishItemModel == null) {
            return;
        }
        liveRightTopFunctionPlace.a(liveWishItemModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveWishingDrawModel liveWishingDrawModel) {
        LiveOperationView liveOperationView = this.co;
        if (liveOperationView != null) {
            liveOperationView.a(EnumOperation.VIEW_TYPE_WISHING_KNOCKING.getValue(), liveWishingDrawModel);
        }
        LiveBottomOperationView liveBottomOperationView = this.cp;
        if (liveBottomOperationView != null) {
            liveBottomOperationView.getWishingWellView().a(liveWishingDrawModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(MultiDialogModel multiDialogModel) {
        if (multiDialogModel != null) {
            multiDialogModel.from_type = 2;
            LiveMultiDialogFragment.a(getChildFragmentManager(), multiDialogModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(MuteLiveAudioModel muteLiveAudioModel, String str) {
        if (aX() || aY()) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (muteLiveAudioModel.source_uid.equals(LiveRoomManager.a().g()) || muteLiveAudioModel.target_uid.equals(LiveRoomManager.a().g())) {
                ToastUtils.a(str, 0);
            }
        } else if (muteLiveAudioModel.target_uid.equals(LiveRoomManager.a().g())) {
            ToastUtils.a(this.E.getResources().getString(muteLiveAudioModel.target_status == 0 ? R.string.live_mute_audio_passive_opposite_close : R.string.live_mute_audio_passive_opposite_open), 0);
        } else if (this.dn == null || !muteLiveAudioModel.source_uid.equals(LiveRoomManager.a().g())) {
        } else {
            boolean z = muteLiveAudioModel.target_status == 0;
            if (TextUtils.isEmpty(muteLiveAudioModel.stream) || TextUtils.isEmpty(muteLiveAudioModel.target_stream)) {
                return;
            }
            this.ac.b(muteLiveAudioModel.target_stream, z);
            ZegoCommonHelper.b().c().activateAudioPlayStream(muteLiveAudioModel.target_stream, !z);
            ZegoMixStreamHelper.a().a(muteLiveAudioModel.target_stream, muteLiveAudioModel.stream, z);
            this.cb.setImageResource(z ? R.drawable.live_icon_pk_voice_close : R.drawable.live_icon_pk_voice_open);
            this.cb.setTag(Boolean.valueOf(z));
            ToastUtils.a(this.E.getResources().getString(z ? R.string.live_mute_audio_close_opposite : R.string.live_mute_audio_open_opposite), 0);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(RelationInfo relationInfo) {
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2) {
        EventTrackLive.c(event2, str, str2);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2, String str3) {
        EventTrackLive.g(event2, str, str3, str2);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2, String str3, int i) {
        EventTrackLive.b(event2, str, str3, str2, i / 1000);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(final ITXCMMusicTrack iTXCMMusicTrack) {
        if (iTXCMMusicTrack == null) {
            return;
        }
        ITXCMZegoAudioAux iTXCMZegoAudioAux = (ITXCMZegoAudioAux) iTXCMMusicTrack.getProxy(ZegoCommonHelper.b().f());
        ZegoCommonHelper.b().a(iTXCMZegoAudioAux);
        if (iTXCMZegoAudioAux != null) {
            final TXCMAudioFrameInfo tXCMAudioFrameInfo = new TXCMAudioFrameInfo();
            iTXCMZegoAudioAux.setZegoAuxCallbackEx(new ITXCMZegoAudioAuxCallbackEx() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.50
                public TXCMAuxDataEx onAuxCallback() {
                    LiveMusicModel a = YYMusicManager.a.c().a();
                    YYKtvMusicModel b = YYMusicManager.a.c().b();
                    if (iTXCMMusicTrack.readAudioFrame(tXCMAudioFrameInfo) == -1) {
                        if (RecordingOnliveFragment.this.di) {
                            return null;
                        }
                        RecordingOnliveFragment.this.di = true;
                        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.50.1
                            @Override // java.lang.Runnable
                            public void run() {
                                RecordingOnliveFragment.this.c();
                            }
                        });
                        return null;
                    } else if (a == null || b == null || !TextUtils.equals(a.music_id, b.musicId)) {
                        return null;
                    } else {
                        TXCMAuxDataEx tXCMAuxDataEx = new TXCMAuxDataEx();
                        if (iTXCMMusicTrack.getDuration() > 0) {
                            TrtcMusicModel trtcMusicModel = new TrtcMusicModel();
                            trtcMusicModel.curPtsMS = tXCMAudioFrameInfo.timestamp;
                            LiveEventBus.get("live_music_play_progress").post(trtcMusicModel);
                            RecordingOnliveFragment.this.di = false;
                        }
                        tXCMAuxDataEx.auxDataInfo = tXCMAudioFrameInfo;
                        tXCMAuxDataEx.packet = false;
                        return tXCMAuxDataEx;
                    }
                }
            });
        }
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void a(String str) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(String str, int i) {
        d(str, i);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void a(String str, final String str2) {
        if (this.bK == null) {
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.bK.setVisibility(8);
            return;
        }
        this.bK.setVisibility(0);
        ImageLoader.a(getFragmentActive(), str).a(this.bL);
        this.bK.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.39
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveBottomWebDialogFragment.a(RecordingOnliveFragment.this.getActivity(), RecordingOnliveFragment.this.getFragmentManager(), str2);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(String str, boolean z) {
    }

    public void a(String str, boolean z, int i) {
        LiveHalfWebDialogFragment liveHalfWebDialogFragment = this.dB;
        if (liveHalfWebDialogFragment != null && liveHalfWebDialogFragment.f()) {
            this.dB.dismissAllowingStateLoss();
            return;
        }
        this.dB = new LiveHalfWebDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putInt("webview_radius", i);
        bundle.putBoolean("fullScreen", z);
        this.dB.setArguments(bundle);
        this.dB.show(getFragmentManager(), "liveActivityWebDialogFragment");
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(List<LiveInviteUserModel> list) {
    }

    public void a(List<LiveInviteUserModel> list, LiveInviteUserModel liveInviteUserModel) {
        this.bo.a(list, liveInviteUserModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(boolean z) {
    }

    public void a(final boolean z, String str) {
        F_();
        if (z) {
            View view = this.aB;
            if (view != null) {
                view.setVisibility(8);
            }
            LiveMakeLoverManagerRecordView liveMakeLoverManagerRecordView = this.bl;
            if (liveMakeLoverManagerRecordView != null) {
                liveMakeLoverManagerRecordView.setVisibility(0);
            }
            ImageView imageView = this.P;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ShapeTextView shapeTextView = this.cJ;
            if (shapeTextView != null) {
                shapeTextView.setVisibility(8);
            }
            bd();
        } else {
            d_(0);
            ShapeTextView shapeTextView2 = this.cJ;
            if (shapeTextView2 != null) {
                shapeTextView2.setVisibility(0);
            }
        }
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.a(LiveRoomManager.a().p().stream, z);
        }
        if (this.x) {
            this.c.setShakeWidth(DensityUtils.a(this.E, 50.0f));
        } else {
            this.c.setShakeWidth(DensityUtils.a(this.E, 65.0f));
        }
        this.cG.a(str);
        this.bx.setVisibility(0);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.7
            @Override // java.lang.Runnable
            public void run() {
                if (LiveRoomManager.a().p() == null) {
                    return;
                }
                RecordingOnliveFragment.this.N_();
                RecordingOnliveFragment.this.J();
                RecordingOnliveFragment.this.S();
                RecordingOnliveFragment.this.ak();
                RecordingOnliveFragment.this.bw();
                Log.v(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, "setLiveData :" + LiveRoomManager.a().p().beans_count);
                RecordingOnliveFragment.this.a(LiveRoomManager.a().p().beans_count, LiveRoomManager.a().p().beans_current_count);
                if (RecordingOnliveFragment.this.ag != 0) {
                    RecordingOnliveFragment recordingOnliveFragment = RecordingOnliveFragment.this;
                    recordingOnliveFragment.a(recordingOnliveFragment.ag);
                    RecordingOnliveFragment.this.F_();
                } else {
                    RecordingOnliveFragment.this.ah.setText("00:00:00");
                }
                RecordingOnliveFragment.this.X();
                if (!z) {
                    RecordingOnliveFragment.this.bt();
                }
                RecordingOnliveFragment.this.bq();
                RecordingOnliveFragment recordingOnliveFragment2 = RecordingOnliveFragment.this;
                recordingOnliveFragment2.cC = new LiveMakeFriendSettingView(recordingOnliveFragment2, recordingOnliveFragment2.t);
                RecordingOnliveFragment.this.cC.a(2);
                RecordingOnliveFragment.this.ac();
                RecordingOnliveFragment.this.dd.q();
                RecordingOnliveFragment.this.dr.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.7.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int height = RecordingOnliveFragment.this.dr.getHeight();
                        Log.v("pk", "height = " + height);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) RecordingOnliveFragment.this.cL.getLayoutParams();
                        layoutParams.height = height + DensityUtils.a(RecordingOnliveFragment.this.E, 55.0f);
                        RecordingOnliveFragment.this.cL.setLayoutParams(layoutParams);
                        RecordingOnliveFragment.this.dr.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
                RecordingOnliveFragment.this.bl();
                RecordingOnliveFragment.this.bm();
                if (RecordingOnliveFragment.this.cR != null) {
                    RecordingOnliveFragment.this.cR.b();
                }
                RecordingOnliveFragment.this.bA();
                RecordingOnliveFragment.this.y();
            }
        }, 1000L);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(boolean z, boolean z2) {
    }

    @Override // com.blued.android.module.live_china.observer.ZanRefreshObserver.IZanRefreshObserver
    public void a(String[] strArr) {
        if (this.c != null) {
            this.c.a(strArr);
        }
    }

    public void aA() {
        this.cC.b();
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.g();
        }
        this.cF.setVisibility(8);
    }

    public void aB() {
        if (this.dc == null) {
            this.dc = new PopGestureView(this, this.ac);
        }
        this.dc.b();
    }

    public void aC() {
        if (this.db == null) {
            this.db = new PopStickerView(this, this.ac);
        }
        this.db.b();
    }

    public void aD() {
        Dialog dialog;
        LiveRegularEventRanklistDialogFragment liveRegularEventRanklistDialogFragment = this.az;
        if (liveRegularEventRanklistDialogFragment != null && (dialog = liveRegularEventRanklistDialogFragment.getDialog()) != null && dialog.isShowing()) {
            this.az.dismiss();
        }
        PopRankingListView popRankingListView = this.dt;
        if (popRankingListView == null || !popRankingListView.a()) {
            return;
        }
        this.dt.c();
    }

    public void aE() {
        List<LiveGiftModel> j = this.dd.j();
        if (j.size() > 0) {
            this.aa = true;
            LiveGiftModel liveGiftModel = j.get(0);
            if (liveGiftModel.enterAnimLocal) {
                this.dd.f(liveGiftModel);
            } else {
                e(liveGiftModel);
            }
        }
    }

    public void aF() {
        this.aE.setVisibility(0);
        this.aQ.setVisibility(0);
    }

    public void aG() {
        this.aE.setVisibility(8);
        this.aQ.setVisibility(8);
        this.aY.setVisibility(8);
    }

    public void aH() {
        if (aU() || aV() || aW() || aX() || aY()) {
            Log.i("drb", "showRTCLoading ignore when make friend or make lover");
        } else {
            this.bb.setVisibility(0);
        }
    }

    public void aI() {
        this.bb.setVisibility(8);
    }

    public TextureView aJ() {
        this.N = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.M.removeAllViews();
        this.M.addView(this.N, layoutParams);
        return this.N;
    }

    public void aK() {
        this.aQ = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aK.removeAllViews();
        this.aK.addView(this.aQ, layoutParams);
    }

    public void aL() {
        this.aR = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aL.removeAllViews();
        this.aL.addView(this.aR, layoutParams);
    }

    public void aM() {
        this.aS = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aM.removeAllViews();
        this.aM.addView(this.aS, layoutParams);
    }

    public void aN() {
        this.aT = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aN.removeAllViews();
        this.aN.addView(this.aT, layoutParams);
    }

    public void aO() {
        this.aU = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aO.removeAllViews();
        this.aO.addView(this.aU, layoutParams);
    }

    public void aP() {
        Logger.a("drb", "setScreenOrientation = ");
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.38
            @Override // java.lang.Runnable
            public void run() {
                if (RecordingOnliveFragment.this.getActivity() == null || RecordingOnliveFragment.this.getActivity().getResources() == null) {
                    return;
                }
                Logger.a("drb", "setScreenOrientation = 111");
                Configuration configuration = RecordingOnliveFragment.this.getActivity().getResources().getConfiguration();
                if (configuration != null) {
                    if (configuration.orientation == 2 || RecordingOnliveFragment.this.x) {
                        RecordingOnliveFragment.this.getActivity().setRequestedOrientation(1);
                    }
                }
            }
        });
    }

    public void aQ() {
        this.dm.clearAnimation();
        this.dm.setVisibility(8);
    }

    public boolean aR() {
        return M_() == 7;
    }

    public boolean aS() {
        return M_() == 2;
    }

    public boolean aT() {
        return M_() == 3;
    }

    public boolean aU() {
        return M_() == 5;
    }

    public boolean aV() {
        return M_() == 8;
    }

    public boolean aW() {
        return M_() == 10;
    }

    public boolean aX() {
        return M_() == 12;
    }

    public boolean aY() {
        return M_() == 13;
    }

    public boolean aZ() {
        return M_() == 11;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void a_(LiveChattingModel liveChattingModel) {
        this.ad.a(liveChattingModel);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void a_(List<LiveFriendModel> list) {
        this.dn.a(list);
    }

    public void aa() {
        LiveMultiFunctionView liveMultiFunctionView = this.cH;
        if (liveMultiFunctionView != null) {
            liveMultiFunctionView.d();
        }
    }

    public void ab() {
        if (LiveRoomManager.a().I() == 1) {
            this.N.setVisibility(8);
            LiveRoomInfo.a().x();
            VideoPlayConfig.c(1);
            this.cW = new RecordingPlayerManager(this.dl, this.ai);
        } else {
            this.ac = new RecordingOnliveManager(this, this.x);
        }
        this.dn = new RecordingMakeFriendManager(this);
        this.ad = new RecordingMsgManager(this, this.ac);
        this.bm = new RecordingMakeLoverManager(this);
        this.bo = new RecordingMultiConnectionManager(this);
        this.af = new LiveBunchLightTaskManager(this);
    }

    public void ac() {
        LiveMsgSendManager.a().a(this.s, this.t, this);
        LiveRoomUtils.a(getFragmentActive(), "1");
    }

    public void ad() {
        LiveMsgSendManager.a().b(this.s, this.t, this);
    }

    public void ae() {
        LiveRecordPostFragmentKL liveRecordPostFragmentKL = this.dD;
        if (liveRecordPostFragmentKL == null || !liveRecordPostFragmentKL.isAdded()) {
            return;
        }
        getChildFragmentManager().beginTransaction().remove(this.dD).commitNowAllowingStateLoss();
        this.dD = null;
    }

    public void af() {
        if (r()) {
            if (this.x) {
                AppMethods.d(R.string.no_landscape_mode);
            } else {
                this.bB.c(this.ad.b());
            }
        } else if (aW()) {
            if (this.x) {
                AppMethods.d(R.string.no_landscape_mode);
            } else {
                this.bB.a(this.bo.c());
            }
        } else if (aX() || aY()) {
            if (this.x) {
                AppMethods.d(R.string.no_landscape_mode);
            } else if (this.bo.c() == null || this.bo.c().isEmpty() || !this.bo.c().get(0).isGroup()) {
                this.bB.a(this.bo.c());
            } else {
                this.bB.b(this.bo.c());
            }
        } else if (aZ()) {
            AppMethods.d(R.string.live_pk_unavailable);
        } else if (d(false)) {
            if (this.x) {
                AppMethods.d(R.string.no_landscape_mode);
            } else {
                LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntity<BluedEntityBaseExtra, LiveGetPkStatusExtraModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.24
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public boolean onUIFailure(int i, String str) {
                        AppMethods.a((CharSequence) str);
                        return true;
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIUpdate(BluedEntity<BluedEntityBaseExtra, LiveGetPkStatusExtraModel> bluedEntity) {
                        if (bluedEntity == null || bluedEntity.extra == null) {
                            AppMethods.d(R.string.live_pk_unavailable);
                        } else if (bluedEntity.extra.link_type == 0) {
                            RecordingOnliveFragment.this.bB.a(true);
                            RecordingOnliveFragment.this.bu();
                        } else if (TextUtils.isEmpty(bluedEntity.extra.click_message)) {
                            AppMethods.d(R.string.live_pk_unavailable);
                        } else {
                            AppMethods.a((CharSequence) bluedEntity.extra.click_message);
                        }
                    }
                }, LiveRoomManager.a().e(), getFragmentActive());
            }
        }
    }

    public void ag() {
        Dialog dialog;
        LivePkRoundSelectDialogFragment livePkRoundSelectDialogFragment = this.cS;
        if (livePkRoundSelectDialogFragment == null || (dialog = livePkRoundSelectDialogFragment.getDialog()) == null || !dialog.isShowing()) {
            return;
        }
        this.cS.dismissAllowingStateLoss();
    }

    public void ah() {
        LiveShakeDialogFragment liveShakeDialogFragment = this.cT;
        if (liveShakeDialogFragment != null) {
            liveShakeDialogFragment.d();
        }
    }

    public void ai() {
        this.dE = new LiveAnnounceDialogFragment();
        this.dE.setArguments(new Bundle());
        this.dE.show(getChildFragmentManager(), "announceDialogFragment");
    }

    public void aj() {
        Dialog dialog;
        LiveAnnounceDialogFragment liveAnnounceDialogFragment = this.dE;
        if (liveAnnounceDialogFragment == null || (dialog = liveAnnounceDialogFragment.getDialog()) == null || !dialog.isShowing()) {
            return;
        }
        this.dE.dismissAllowingStateLoss();
    }

    public void ak() {
        if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().link_type != 1 || LiveRoomManager.a().p().pk == null) {
            return;
        }
        b(LiveRoomManager.a().p().pk.buff_countdown);
    }

    public void al() {
        LiveFansRecordDialogFragment liveFansRecordDialogFragment = this.ay;
        if (liveFansRecordDialogFragment == null || !liveFansRecordDialogFragment.isVisible()) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FANS_ENTER_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            if (LiveRoomManager.a().p().profile != null) {
                EventTrackLive.a(LiveProtos.Event.LIVE_FANS_CLUB_BTN_CLICK, String.valueOf(this.t), LiveRoomManager.a().g());
            }
            if (!LiveRoomManager.a().s()) {
                AppMethods.d(R.string.live_fans_open_level_tip);
                return;
            }
            this.ay = new LiveFansRecordDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("lid", this.t);
            bundle.putString("uid", LiveRoomInfo.a().f());
            this.ay.setArguments(bundle);
            this.ay.a(this);
            this.ay.show(getFragmentManager(), "liveFansDialog");
        }
    }

    public void am() {
        LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bn;
        if (liveMakeLoverDialogFragment == null || !liveMakeLoverDialogFragment.isVisible()) {
            this.bn = new LiveMakeLoverDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("lid", this.t);
            bundle.putString("uid", LiveRoomInfo.a().f());
            bundle.putInt("from", 1);
            this.bn.setArguments(bundle);
            this.bn.a(new LiveMakeLoverDialogFragment.ILiveMakeLoverDialog() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.26
                @Override // com.blued.android.module.live_china.fragment.LiveMakeLoverDialogFragment.ILiveMakeLoverDialog
                public void a() {
                    RecordingOnliveFragment.this.t();
                }
            });
            this.bn.show(getFragmentManager(), "liveMakeLoverApplyDialog");
        }
    }

    public void an() {
        LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bn;
        if (liveMakeLoverDialogFragment == null || !liveMakeLoverDialogFragment.isVisible()) {
            return;
        }
        this.bn.dismiss();
    }

    public void ao() {
        Context context = this.E;
        CommonAlertDialog.a(context, "", context.getString(R.string.live_connection_close), (String) null, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.27
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (RecordingOnliveFragment.this.ac != null) {
                    RecordingOnliveFragment.this.ac.b(R.id.RemoteGLSurfaceViewB);
                    RecordingOnliveFragment.this.aG();
                    Log.v("pk", "showCloseConnection");
                    RecordingOnliveFragment.this.ac.h();
                    RecordingOnliveFragment.this.ac.i();
                    AppMethods.d(R.string.live_connection_over);
                }
            }
        }, this.E.getString(R.string.filter_off), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void ap() {
        getActivity().finish();
        aq();
    }

    public void aq() {
        if (LiveRoomManager.a().J()) {
            LiveRoomInfo.a().a(this.E);
        }
    }

    public void ar() {
        if (LiveRoomManager.a().J()) {
            AppMethods.d(R.string.live_game_tips);
        }
        if (!this.Y) {
            InstantLog.a("beauty_view");
            this.Y = true;
        }
        PopBeautyNewView popBeautyNewView = this.au;
        if (popBeautyNewView != null) {
            popBeautyNewView.a();
        }
    }

    public void as() {
        if (LiveRoomManager.a().J()) {
            AppMethods.d(R.string.live_game_tips);
            return;
        }
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null && recordingOnliveManager.l()) {
            AppMethods.a((CharSequence) "自拍模式无法打开闪光灯");
        } else if (this.X) {
            RecordingOnliveManager recordingOnliveManager2 = this.ac;
            if (recordingOnliveManager2 != null) {
                recordingOnliveManager2.y();
            }
            this.X = false;
            LiveMultiFunctionView liveMultiFunctionView = this.cH;
            if (liveMultiFunctionView != null) {
                liveMultiFunctionView.setFlashLightBtnState(false);
            }
        } else {
            RecordingOnliveManager recordingOnliveManager3 = this.ac;
            if (recordingOnliveManager3 != null) {
                recordingOnliveManager3.x();
            }
            this.X = true;
            LiveMultiFunctionView liveMultiFunctionView2 = this.cH;
            if (liveMultiFunctionView2 != null) {
                liveMultiFunctionView2.setFlashLightBtnState(true);
            }
        }
    }

    public void at() {
        if (LiveRoomManager.a().J()) {
            AppMethods.d(R.string.live_game_tips);
        }
        if (this.ac == null) {
            return;
        }
        boolean z = !this.V;
        this.V = z;
        if (z) {
            InstantLog.a("live_mirror_image", 1);
            LiveMultiFunctionView liveMultiFunctionView = this.cH;
            if (liveMultiFunctionView != null) {
                liveMultiFunctionView.setMirrorBtnState(true);
            }
            AppMethods.d(R.string.live_mirror_open);
        } else {
            InstantLog.a("live_mirror_image", 0);
            LiveMultiFunctionView liveMultiFunctionView2 = this.cH;
            if (liveMultiFunctionView2 != null) {
                liveMultiFunctionView2.setMirrorBtnState(false);
            }
            AppMethods.d(R.string.live_mirror_close);
        }
        this.ac.b(this.V);
    }

    public void au() {
        Log.v("==record", "stopOnlive");
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.t();
        }
        f(false);
        if (this.au != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.au.e(), LiveProtos.Status.END);
        }
        LiveGuideListManager liveGuideListManager = this.cR;
        if (liveGuideListManager != null) {
            liveGuideListManager.a();
        }
        LiveBunchLightTaskManager liveBunchLightTaskManager = this.af;
        if (liveBunchLightTaskManager != null) {
            liveBunchLightTaskManager.a();
        }
        LiveMsgManager liveMsgManager = this.dd;
        if (liveMsgManager == null || liveMsgManager.k == null) {
            return;
        }
        this.dd.k.d();
    }

    @Override // com.blued.android.module.live_china.manager.PlayARObserver.IPlayARObserver
    public void av() {
        if (this.ab) {
            return;
        }
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.29
            @Override // java.lang.Runnable
            public void run() {
                if (RecordingOnliveFragment.this.dc != null) {
                    RecordingOnliveFragment.this.dc.e();
                }
                RecordingOnliveFragment.this.ax();
            }
        });
    }

    public void aw() {
        CountDownTimer countDownTimer = this.cY;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void ax() {
        if (this.bq) {
            List<LiveGiftModel> k = this.dd.k();
            if (k.size() <= 0) {
                PopGestureView popGestureView = this.dc;
                if (popGestureView != null) {
                    popGestureView.f();
                    return;
                }
                return;
            }
            LiveGiftModel liveGiftModel = k.get(0);
            if (this.ac != null) {
                this.ab = true;
                Log.v("pk", "isPlayAR true ------- ");
                this.ac.a(liveGiftModel, new AnonymousClass30(liveGiftModel));
            }
        }
    }

    public void ay() {
        this.cr.a();
    }

    public void az() {
        this.cC.c();
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.g();
        }
        this.cF.setVisibility(0);
        ImageLoader.a(getFragmentActive(), LiveRoomInfo.a().d()).a(this.cF);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(int i) {
    }

    public void b(long j) {
        PKDoubleAnimView pKDoubleAnimView = this.dm;
        if (pKDoubleAnimView == null) {
            return;
        }
        if (j <= 0) {
            pKDoubleAnimView.a();
        } else {
            pKDoubleAnimView.a(getFragmentActive(), j);
        }
    }

    public void b(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        super.a(keyboardListenLinearLayout);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveChattingModel liveChattingModel) {
    }

    public void b(LiveFriendModel liveFriendModel) {
        if (r()) {
            ag();
            this.bF.setVsVisable(true);
            by();
            this.cl.a();
            this.cj.b();
            this.bO.setPKCountDownCallback(new LivePKCountDownView.PKCountDownCallback() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.40
                @Override // com.blued.android.module.live_china.view.LivePKCountDownView.PKCountDownCallback
                public void a() {
                    RecordingOnliveFragment.this.ck.a();
                }
            });
            this.bO.a(liveFriendModel.countdown, true);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cb.getLayoutParams();
            marginLayoutParams.topMargin = DensityUtils.a(this.E, 8.0f);
            this.cb.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveGiftModel liveGiftModel) {
        this.dd.e(liveGiftModel);
    }

    public void b(LivePkRoundModel livePkRoundModel) {
        Log.i("==xpm", "onPkRoundEnd:" + livePkRoundModel.toString());
        if (livePkRoundModel.records != null) {
            long j = 0;
            LivePKPlayerModel livePKPlayerModel = null;
            for (LivePKPlayerModel livePKPlayerModel2 : livePkRoundModel.records) {
                if (livePKPlayerModel2 == null) {
                    return;
                }
                int i = livePkRoundModel.count - 1;
                long j2 = j;
                if (livePKPlayerModel2.pk_result != null) {
                    j2 = j;
                    if (i < livePKPlayerModel2.pk_result.size()) {
                        j2 = j;
                        if (livePKPlayerModel2.pk_result.get(i).intValue() == 1) {
                            j2 = livePKPlayerModel2.uid;
                        }
                    }
                }
                j = j2;
                if (livePKPlayerModel2.uid != LiveRoomManager.a().f()) {
                    livePKPlayerModel = livePKPlayerModel2;
                    j = j2;
                }
            }
            if (!livePkRoundModel.last) {
                this.ad.a(j, livePkRoundModel.records, 1);
            }
            this.ad.a(j, livePKPlayerModel);
            k(livePkRoundModel.records);
        }
        c(livePkRoundModel);
        this.bO.c();
        this.bO.e();
        if (livePkRoundModel.last) {
            this.cj.a();
        }
    }

    public void b(LiveRecordLevelStickerModel liveRecordLevelStickerModel) {
        LiveRecordStickerViewLayout liveRecordStickerViewLayout = this.cK;
        if (liveRecordStickerViewLayout != null) {
            liveRecordStickerViewLayout.a(liveRecordLevelStickerModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveRoomData liveRoomData) {
        LiveMsgManager liveMsgManager = this.dd;
        if (liveMsgManager != null) {
            liveMsgManager.a(liveRoomData);
        }
    }

    public void b(LiveShakeModel liveShakeModel) {
        a(liveShakeModel);
    }

    public void b(RelationInfo relationInfo) {
        if (LiveRoomManager.a().m() == 12 || LiveRoomManager.a().m() == 13 || LiveRoomManager.a().m() == 10) {
            this.bo.a(relationInfo);
        }
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void b(String str) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(String str, int i) {
        e(str, i);
    }

    public void b(String str, String str2) {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        LiveRecordPostFragmentKL liveRecordPostFragmentKL = new LiveRecordPostFragmentKL();
        this.dD = liveRecordPostFragmentKL;
        liveRecordPostFragmentKL.a(new LiveRecordPostFragmentKL.EventCallback() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.23
            @Override // com.blued.android.module.live_china.fragment.LiveRecordPostFragmentKL.EventCallback
            public void a(EditText editText, String str3, String str4) {
                LiveRoomInfo.a().a(editText, str3, str4);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("videopath", str);
        bundle.putString("coverpath", str2);
        this.dD.setArguments(bundle);
        beginTransaction.add(R.id.live_record_post_layout_id, this.dD, "recordPostFragment");
        beginTransaction.commitNowAllowingStateLoss();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void b(List<GrabBoxModel> list) {
        if (this.co != null) {
            GrabBoxListModel grabBoxListModel = new GrabBoxListModel();
            grabBoxListModel.setList(new ArrayList<>());
            grabBoxListModel.getList().addAll(list);
            this.co.a(EnumOperation.VIEW_TYPE_TREASURE_BOX.getValue(), grabBoxListModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(boolean z) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b_(String str) {
        this.dd.b(str);
    }

    public boolean ba() {
        return M_() == 0;
    }

    public boolean bb() {
        return r() || aR() || aS() || aT() || aU() || aV() || aW() || aZ() || aX() || aY();
    }

    public void bc() {
        if (r()) {
            d_(0);
            this.aC.setImageResource(R.drawable.live_pk_start_btn);
            RecordingOnliveManager recordingOnliveManager = this.ac;
            if (recordingOnliveManager != null) {
                recordingOnliveManager.d();
            }
            PopPKListView popPKListView = this.du;
            if (popPKListView != null && popPKListView.a()) {
                this.du.b();
            }
            this.bC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bD.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.bD.setLayoutParams(layoutParams);
            this.L.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.bE.setVisibility(8);
            N_();
            this.bG.setVisibility(8);
            this.bO.b();
            this.bO.setVisibility(8);
            this.bP.setVisibility(8);
            this.ce.a();
            this.bF.a();
            this.bF.setVisibility(8);
            this.cg.a();
            this.ci.a();
            this.ck.b();
            this.ch.a();
            this.cj.b();
            this.cl.a();
            LiveRoomManager.a().P();
            aQ();
            Log.v("pk", "stopPK");
            RecordingOnliveManager recordingOnliveManager2 = this.ac;
            if (recordingOnliveManager2 != null) {
                recordingOnliveManager2.h();
            }
            this.bQ.setVisibility(8);
            aG();
            LiveMsgManager liveMsgManager = this.dd;
            if (liveMsgManager != null) {
                liveMsgManager.a();
            }
        }
    }

    public void bd() {
        this.bm.f();
    }

    public void be() {
        this.bm.g();
    }

    public void bf() {
        this.aC.setImageResource(R.drawable.live_pk_start_btn);
        this.bo.b();
        this.bB.k();
    }

    public void bg() {
        if (this.dd == null) {
            this.dd = new LiveMsgManager(this);
            if (this.x) {
                return;
            }
            this.dd.c();
        }
    }

    public void bh() {
        LiveRoomHttpUtils.n(new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.45
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveTopCard> bluedEntityA) {
                Logger.d("RecordingOnliveFragment", "onUIUpdate is token ... ");
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.isEmpty()) {
                    return;
                }
                BluedLiveTopCard bluedLiveTopCard = bluedEntityA.data.get(0);
                if (bluedLiveTopCard.token_status == 0) {
                    RecordingOnliveFragment.this.a(bluedLiveTopCard.count, bluedLiveTopCard.task_id);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                Logger.d("RecordingOnliveFragment", "onUIFailure is token ... ");
                return super.onUIFailure(i, str);
            }
        }, getFragmentActive());
    }

    public void bi() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.anim_gift_bottom_in, R.anim.anim_gift_bottom_out);
        LiveBackgroundMusicFragment liveBackgroundMusicFragment = (LiveBackgroundMusicFragment) getChildFragmentManager().findFragmentByTag("LiveMusic");
        this.dv = liveBackgroundMusicFragment;
        if (liveBackgroundMusicFragment == null) {
            this.dv = new LiveBackgroundMusicFragment(this);
            beginTransaction.add(R.id.live_music_id, this.dv, "LiveMusic");
        } else {
            beginTransaction.show(liveBackgroundMusicFragment);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public void bj() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.anim_gift_bottom_in, R.anim.anim_gift_bottom_out);
        LiveBackgroundMusicFragment liveBackgroundMusicFragment = this.dv;
        if (liveBackgroundMusicFragment != null) {
            beginTransaction.hide(liveBackgroundMusicFragment).commitAllowingStateLoss();
        }
        t();
    }

    public void bk() {
        if (this.dv != null) {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.anim_gift_bottom_in, R.anim.anim_gift_bottom_out);
            beginTransaction.remove(this.dv).commitAllowingStateLoss();
            this.dv = null;
        }
    }

    public void bl() {
        LiveRecordRecommendModel liveRecordRecommendModel = LiveRoomManager.a().p().recommend;
        if (liveRecordRecommendModel == null || !liveRecordRecommendModel.icon_show) {
            this.dq.setVisibility(0);
            return;
        }
        LiveOfficalRecommendPop.a(this.E, 0);
        this.dq.setVisibility(8);
    }

    public void bm() {
        LiveAnnounceInfoModel liveAnnounceInfoModel = LiveRoomManager.a().p().live_notice;
        if (liveAnnounceInfoModel == null || liveAnnounceInfoModel.controller != 1 || liveAnnounceInfoModel.notice_controller != 1 || TextUtils.isEmpty(liveAnnounceInfoModel.notice)) {
            return;
        }
        LiveAnnounceModel liveAnnounceModel = new LiveAnnounceModel();
        liveAnnounceModel.controller = liveAnnounceInfoModel.controller;
        liveAnnounceModel.notice_controller = liveAnnounceInfoModel.notice_controller;
        liveAnnounceModel.notice_content = liveAnnounceInfoModel.notice;
        liveAnnounceModel.live_time_controller = liveAnnounceInfoModel.live_time_controller;
        liveAnnounceModel.live_week_time = liveAnnounceInfoModel.live_week_time;
        liveAnnounceModel.live_time = liveAnnounceInfoModel.live_time;
        LiveEventBus.get(LiveEventBusUtil.q).post(liveAnnounceModel);
    }

    public void bn() {
        startActivityForResult(((MediaProjectionManager) this.E.getSystemService("media_projection")).createScreenCaptureIntent(), 1314);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void c() {
        LiveMusicModel a = YYMusicManager.a.c().a();
        if (a != null) {
            a.playStatus = 3;
            EventTrackLive.b(LiveProtos.Event.LIVE_MUSIC_DONE, LiveRoomManager.a().e(), a.music_id, a.sheet_id, (int) (a.curDuration / 1000));
        }
        this.cM.b();
        ZegoCommonHelper.b().k();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(int i) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(LiveChattingModel liveChattingModel) {
        LiveMsgManager liveMsgManager = this.dd;
        if (liveMsgManager != null) {
            liveMsgManager.a(liveChattingModel);
        }
    }

    public void c(LiveFriendModel liveFriendModel) {
        this.dn.a(liveFriendModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(LiveGiftModel liveGiftModel) {
        f(liveGiftModel);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void c(String str) {
        this.bk.a(str);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(String str, int i) {
        this.dd.a(str, i);
    }

    public void c(String str, String str2) {
        LiveCommentTipView liveCommentTipView = (LiveCommentTipView) this.b.findViewById(R.id.live_comment);
        liveCommentTipView.a(str, str2);
        liveCommentTipView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.47
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(List<LiveInviteUserModel> list) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(boolean z) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c_(String str) {
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void d() {
        if (YYMusicManager.a.c().a() != null) {
            this.cM.setPlaying(false);
            ZegoCommonHelper.b().k();
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void d(int i) {
        this.dd.b(i);
        if (i == 0) {
            this.J.setVisibility(8);
        }
    }

    public void d(final LiveGiftModel liveGiftModel) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$ZQi-8HUlXfnpuGoyVlpiYCU7IXA
            @Override // java.lang.Runnable
            public final void run() {
                RecordingOnliveFragment.this.j(liveGiftModel);
            }
        });
    }

    public void d(String str, int i) {
        a(str, false, i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void d(List<LiveInviteUserModel> list) {
    }

    public boolean d(boolean z) {
        if (r()) {
            AppMethods.d(R.string.live_pk_unavailable);
            return false;
        } else if (aS() || aT() || this.bB.r()) {
            AppMethods.d(R.string.connecting);
            return false;
        } else if (aU()) {
            AppMethods.d(R.string.live_make_friend_unavailable);
            return false;
        } else if (aV()) {
            AppMethods.d(R.string.live_make_lover_unavailable);
            return false;
        } else if (aW() || aX() || aY()) {
            AppMethods.d(R.string.live_make_lover_unavailable);
            return false;
        } else if (z || !aZ()) {
            return true;
        } else {
            AppMethods.d(R.string.live_pk_unavailable);
            return false;
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void e(int i) {
    }

    public void e(final LiveGiftModel liveGiftModel) {
        Logger.a("drb", "gift_pic_apng2 = ", liveGiftModel.images_apng2);
        Logger.a("drb", "gift_pic_url = ", liveGiftModel.images_static);
        Logger.a("drb", "anim_code = ", liveGiftModel.anim_code);
        Logger.a("drb", "gift_pic_gif = ", liveGiftModel.images_gif);
        Logger.a("drb", "gift_pic_mp4 = ", liveGiftModel.images_mp4);
        Logger.a("drb", "resource_url = ", liveGiftModel.resource_url);
        Logger.a("drb", "is_opponent = ", Boolean.valueOf(liveGiftModel.is_opponent));
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$UFy3f2A7yemRAqpPCUkAqWROwoo
            @Override // java.lang.Runnable
            public final void run() {
                RecordingOnliveFragment.this.h(liveGiftModel);
            }
        }, a_(liveGiftModel) ? 400L : 0L);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    /* renamed from: e */
    public void p(String str) {
        LogUtils.c("showLiveWebView: " + str);
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
            if (!str.contains("blued_mode=hide_nav")) {
                if (str.contains("?")) {
                    str2 = str + "&blued_mode=hide_nav";
                } else {
                    str2 = str + "?blued_mode=hide_nav";
                }
            }
        }
        if (this.cO != null && !TextUtils.isEmpty(str2)) {
            LiveSetDataObserver.a().s();
            this.cO.b(str2, 0);
        }
        LiveEventBus.get("live_user_card_dismiss").post("");
    }

    public void e(String str, int i) {
        p(str);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void e(List<LiveInviteUserModel> list) {
    }

    public void e(final boolean z) {
        String string = z ? this.E.getString(R.string.live_make_friend_out_exit_tips) : this.E.getString(R.string.live_make_friend_out_tips);
        Context context = this.E;
        CommonAlertDialog.a(context, "", string, context.getString(R.string.filter_off), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.28
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (RecordingOnliveFragment.this.dn != null) {
                    RecordingOnliveFragment.this.dn.a(z);
                }
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public String f() {
        return LiveRoomManager.a().e();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void f(int i) {
    }

    public void f(final LiveGiftModel liveGiftModel) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.37
            @Override // java.lang.Runnable
            public void run() {
                RecordingOnliveFragment.this.aa = false;
                RecordingOnliveFragment.this.dd.c(liveGiftModel);
                RecordingOnliveFragment.this.aE();
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void f(String str) {
        a(str, true, 0);
    }

    public void f(List<LiveMakeLoverFansModel> list) {
        this.bm.b(list);
    }

    public void f(final boolean z) {
        this.bp = true;
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.33
            @Override // java.lang.Runnable
            public void run() {
                if (RecordingOnliveFragment.this.getFragmentActive() == null || !RecordingOnliveFragment.this.getFragmentActive().isActive()) {
                    return;
                }
                RecordingOnliveFragment.this.aP();
                if (RecordingOnliveFragment.this.cB.getVisibility() == 0) {
                    return;
                }
                if (z) {
                    LiveRouteUtil.b(RecordingOnliveFragment.this);
                    return;
                }
                RecordingOnliveFragment.this.at.setVisibility(8);
                RecordingOnliveFragment.this.bx();
            }
        });
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void g() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void g(int i) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void g(String str) {
    }

    public void g(List<LiveInviteUserModel> list) {
        this.aC.setImageResource(R.drawable.live_multi_connection_icon);
        this.bo.a(list);
    }

    public void g(boolean z) {
        this.ad.a(z);
    }

    @Override // com.blued.android.module.live.base.music.BlackMusicListener
    public void h() {
    }

    public void h(int i) {
        this.ak.setVisibility(i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void h(String str) {
    }

    public void h(List<LiveInviteUserModel> list) {
        this.aC.setImageResource(R.drawable.live_multi_pk_state);
        this.bo.b(list);
    }

    public void h(boolean z) {
        this.bB.h();
        this.bB.k();
        this.aC.setImageResource(R.drawable.live_multi_connection_icon);
        this.bo.a();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void i() {
    }

    public void i(int i) {
        this.b.findViewById(R.id.gift_lay).setVisibility(i);
        this.b.findViewById(R.id.multi_barrage).setVisibility(i);
    }

    public void i(String str) {
        LiveCueView.a(this.E, str);
    }

    public void i(List<LiveInviteUserModel> list) {
        this.aC.setImageResource(R.drawable.live_multi_pk_state);
        this.bo.c(list);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void j() {
    }

    public void j(int i) {
        LiveRoomAnchorModel liveRoomAnchorModel = LiveRoomManager.a().p().profile;
        if (liveRoomAnchorModel != null && !TextUtils.isEmpty(liveRoomAnchorModel.avatar_frame)) {
            if (liveRoomAnchorModel.avatar_frame_type == 1) {
                ImageLoader.a(getFragmentActive(), liveRoomAnchorModel.avatar_frame).f(this.dp.hashCode()).g(-1).a(this.dp);
            } else if (liveRoomAnchorModel.avatar_frame_type == 2) {
                ImageLoader.a(getFragmentActive(), liveRoomAnchorModel.avatar_frame).e(this.dp.hashCode()).g(-1).a(this.dp);
            } else {
                ImageLoader.a(getFragmentActive(), liveRoomAnchorModel.avatar_frame).a(this.dp);
            }
            this.dp.setVisibility(0);
        } else if (i < 30) {
        } else {
            if (i >= 90) {
                this.dp.setImageResource(R.drawable.live_anchor_head_bg_90);
            } else if (i >= 60) {
                this.dp.setImageResource(R.drawable.live_anchor_head_bg_60);
            } else if (i >= 30) {
                this.dp.setImageResource(R.drawable.live_anchor_head_bg_30);
            }
            this.dp.setVisibility(0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f46do.getLayoutParams();
            marginLayoutParams.leftMargin = DensityUtils.a(this.E, 6.0f);
            this.f46do.setLayoutParams(marginLayoutParams);
        }
    }

    /* renamed from: j */
    public void q(String str) {
        LiveMultiFunctionView liveMultiFunctionView = this.cH;
        if (liveMultiFunctionView != null) {
            liveMultiFunctionView.setRecording(false);
        }
        this.dH = false;
        LiveRecordDialogFragment liveRecordDialogFragment = this.dC;
        if (liveRecordDialogFragment == null || !liveRecordDialogFragment.isVisible()) {
            this.dC = new LiveRecordDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("videopath", str);
            this.dC.setArguments(bundle);
            this.dC.a(new LiveRecordDialogFragment.EventCallback() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.22
                @Override // com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.EventCallback
                public void a(String str2, String str3) {
                    RecordingOnliveFragment.this.b(str2, str3);
                }

                @Override // com.blued.android.module.live_china.fragment.LiveRecordDialogFragment.EventCallback
                public void a(String str2, String str3, String str4) {
                    LiveRoomInfo.a().a(str2, str3, str4);
                }
            });
            this.dC.show(getFragmentManager(), "recordDialogFragment");
        }
    }

    public void j(List<LiveInviteUserModel> list) {
        this.bo.d(list);
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        if (i == -3) {
            this.cV = true;
            PopRewardConfigView popRewardConfigView = this.dw;
            if (popRewardConfigView != null) {
                popRewardConfigView.j();
            }
        } else if (i == -2) {
            this.cV = false;
            PopRewardConfigView popRewardConfigView2 = this.dw;
            if (popRewardConfigView2 != null) {
                popRewardConfigView2.k();
            }
        }
        this.cB.a(i);
        this.cG.a(i);
    }

    public void k(final int i) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.19
            @Override // java.lang.Runnable
            public void run() {
                if (i == 0) {
                    RecordingOnliveFragment.this.cX = System.currentTimeMillis();
                }
                if (i == 8) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = RecordingOnliveFragment.this.cX;
                    if (RecordingOnliveFragment.this.ac != null) {
                        RecordingOnliveFragment.this.ac.b((currentTimeMillis - j) / 1000);
                    }
                }
                RecordingOnliveFragment.this.ai.setVisibility(i);
            }
        });
    }

    public void k(String str) {
        this.cr.a(str);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void l() {
        super.l();
        LiveRankGuestDialogFragment.e = 0;
        this.cx = this.r.getInt("official", 0);
        LiveRoomManager.a().b(this.r.getInt("live_type", 0));
        this.cy = this.r.getInt("live_countdown", 0);
        boolean z = true;
        if (this.r.getInt("live_screen_orientation", 0) != 1) {
            z = false;
        }
        this.x = z;
        this.cA = this.r.getString("live_from_source");
        this.F = this.r.getInt("LIVE_OUTER_RECORD_TYPE", 0);
    }

    public void l(int i) {
        LiveMultiFunctionView liveMultiFunctionView = this.cH;
        if (liveMultiFunctionView != null) {
            liveMultiFunctionView.setFlashLightVisibility(i);
        }
    }

    public void l(String str) {
        LiveRoomHttpUtils.e(str, new BluedUIHttpResponse(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.32
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        });
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void m() {
        super.m();
        ZanRefreshObserver.a().a(this);
        PlayGifObserver.a().a(this);
        PlayARObserver.a().a(this);
        BeansRefreshObserver.a().a(this);
        LiveSetDataObserver.a().a(this);
        bo();
    }

    public void m(int i) {
        this.dn.a(i);
    }

    public void m(String str) {
        this.aE.setVisibility(0);
        this.aQ.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.aY.setText("");
        } else {
            this.aY.setText(str);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void n() {
        super.n();
        LiveRoomHttpUtils.a(getFragmentActive());
    }

    public void n(int i) {
        LiveMakeLoverManagerRecordView liveMakeLoverManagerRecordView = this.bl;
        if (liveMakeLoverManagerRecordView != null) {
            liveMakeLoverManagerRecordView.a(i);
        }
    }

    public void n(String str) {
        Log.i("==xpm", "showPkRoundToast");
        this.cl.a(str);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void o() {
    }

    public void o(String str) {
        LiveRoomHttpUtils.h(str, new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.RecordingOnliveFragment.46
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveTopCard> bluedEntityA) {
                if (RecordingOnliveFragment.this.G != null) {
                    RecordingOnliveFragment.this.G.dismiss();
                }
                ToastUtils.a(RecordingOnliveFragment.this.E.getResources().getString(R.string.live_take_topcard_ok), 0);
                if (RecordingOnliveFragment.this.cH != null && bluedEntityA != null && bluedEntityA.data != null && !bluedEntityA.data.isEmpty()) {
                    RecordingOnliveFragment.this.cH.a(bluedEntityA.data.get(0).count);
                }
                RecordingOnliveFragment.this.bz();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                if (RecordingOnliveFragment.this.G != null) {
                    RecordingOnliveFragment.this.G.dismiss();
                }
                return super.onUIFailure(i, str2);
            }
        }, getFragmentActive());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.cB.a(i, i2, intent);
        super.onActivityResult(i, i2, intent);
        if (i == 100014) {
            G();
        } else if (i == 1314) {
            if (i2 != -1) {
                this.dH = false;
                LiveMultiFunctionView liveMultiFunctionView = this.cH;
                if (liveMultiFunctionView != null) {
                    liveMultiFunctionView.setRecording(false);
                    return;
                }
                return;
            }
            Intent intent2 = new Intent(this.E, LiveScreenRecorderService.class);
            intent2.putExtra("data", intent);
            intent2.putExtra("resultCode", i2);
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    this.E.startForegroundService(intent2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                this.E.startService(intent2);
            }
            this.ds.a();
            this.dH = true;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        LiveBackgroundMusicFragment liveBackgroundMusicFragment = this.dv;
        if (liveBackgroundMusicFragment != null && liveBackgroundMusicFragment.b()) {
            this.dv.onBackPressed();
            return true;
        } else if (this.aj.getVisibility() == 0) {
            this.an.performClick();
            return true;
        } else if (this.at.getVisibility() == 0) {
            return false;
        } else {
            if (this.ds.getVisibility() == 0) {
                this.ds.a(getContext());
                return true;
            } else if (this.bB.p()) {
                this.bB.q();
                return true;
            } else {
                PopLiveCallView popLiveCallView = this.cc;
                if (popLiveCallView != null && popLiveCallView.c()) {
                    this.cc.a();
                    return true;
                } else if (M_() == 1) {
                    this.bO.a(true);
                    return true;
                } else {
                    LiveMakeFriendListView liveMakeFriendListView = this.cv;
                    if (liveMakeFriendListView != null && liveMakeFriendListView.c()) {
                        this.cv.b();
                        return true;
                    } else if (aU()) {
                        e(true);
                        return true;
                    } else if (this.cB.c()) {
                        return true;
                    } else {
                        LiveMultiFunctionView liveMultiFunctionView = this.cH;
                        if (liveMultiFunctionView != null && liveMultiFunctionView.b()) {
                            this.cH.a();
                            return true;
                        }
                        LiveTitleView liveTitleView = this.cG;
                        if (liveTitleView != null && liveTitleView.b()) {
                            this.cG.a();
                            return true;
                        }
                        PopLiveActivityWebView popLiveActivityWebView = this.cO;
                        if (popLiveActivityWebView != null && popLiveActivityWebView.e()) {
                            this.cO.f();
                            return true;
                        }
                        PopRankingListView popRankingListView = this.dt;
                        if (popRankingListView != null && popRankingListView.a()) {
                            this.dt.c();
                            return true;
                        }
                        LiveHostFinishDialogFragment liveHostFinishDialogFragment = this.dA;
                        if (liveHostFinishDialogFragment == null || !liveHostFinishDialogFragment.onBackPressed()) {
                            if (aW() || aX()) {
                                this.bB.l();
                                return true;
                            } else if (aY()) {
                                this.bB.m();
                                return true;
                            } else {
                                LiveRouteUtil.a((BaseFragment) this);
                                return true;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    @Override // android.widget.Chronometer.OnChronometerTickListener
    public void onChronometerTick(Chronometer chronometer) {
        long j = this.ag + 1;
        this.ag = j;
        chronometer.setText(LiveTimeAndDateUtils.a(j, true));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveMakeFriendSettingView liveMakeFriendSettingView;
        Tracker.onClick(view);
        if (ClickUtils.a(view.getId(), 1000L)) {
            return;
        }
        if (view.getId() == R.id.live_like_view) {
            af();
        } else if (view.getId() == R.id.live_beans_btn_root) {
            if (LiveRoomManager.a().R()) {
                EventTrackLive.a(LiveProtos.Event.LIVE_WANDOU_NUM_CLICK, String.valueOf(this.t), LiveRoomInfo.a().f());
                Bundle bundle = new Bundle();
                bundle.putLong(LiveRankGuestDialogFragment.a, this.t);
                bundle.putString("UID", LiveRoomInfo.a().f());
                bundle.putBoolean(LiveRankGuestDialogFragment.d, true);
                bundle.putBoolean("isMakeLover", aV());
                LiveRankGuestDialogFragment liveRankGuestDialogFragment = new LiveRankGuestDialogFragment();
                this.ax = liveRankGuestDialogFragment;
                liveRankGuestDialogFragment.a(this);
                this.ax.setArguments(bundle);
                this.ax.show(getFragmentManager(), "liveShowDialog");
            }
        } else if (view.getId() == R.id.close_btn) {
            if (this.ds.getVisibility() == 0) {
                this.ds.a(getContext());
            } else if (r()) {
                this.bO.a(true);
            } else if (aU()) {
                e(true);
            } else if (aW() || aX()) {
                this.bB.l();
            } else if (aY()) {
                this.bB.m();
            } else {
                LiveRouteUtil.a((BaseFragment) this);
            }
        } else if (view.getId() == R.id.error_tips_btn) {
            this.aj.setVisibility(8);
        } else if (view.getId() == R.id.out_userA_btn) {
            RecordingOnliveManager recordingOnliveManager = this.ac;
            if (recordingOnliveManager != null) {
                recordingOnliveManager.b(R.id.RemoteGLSurfaceViewA);
            }
        } else if (view.getId() == R.id.out_userB_btn) {
            ao();
        } else if (view.getId() == R.id.live_reward_view) {
            if (this.ds.getVisibility() == 0) {
                AppMethods.d(R.string.live_recording_tip1);
            } else {
                this.dw = PopRewardConfigView.a(this);
            }
        } else if (view.getId() == R.id.live_pk_operate_close) {
            this.bG.setVisibility(8);
        } else if (view.getId() == R.id.live_make_friends_close_btn) {
            e(false);
        } else if (view.getId() == R.id.cameraPreview_afl) {
            if (aU() && this.ad.a() && (liveMakeFriendSettingView = this.cC) != null) {
                liveMakeFriendSettingView.e();
            }
        } else if (view.getId() == R.id.live_make_friend_windows_B) {
            m(0);
        } else if (view.getId() == R.id.live_make_friend_windows_C) {
            m(1);
        } else if (view.getId() == R.id.live_make_friend_windows_D) {
            m(2);
        } else if (view.getId() == R.id.live_multi_function_btn) {
            EventTrackLive.b(LiveProtos.Event.ANCHOR_FEATURE_CLICK, String.valueOf(this.t));
            if (LiveRoomManager.a().J()) {
                AppMethods.d(R.string.no_landscape_mode);
                return;
            }
            if (this.k != null && this.k.c) {
                this.k.setVisibility(8);
            }
            LiveMultiFunctionView liveMultiFunctionView = this.cH;
            if (liveMultiFunctionView != null) {
                liveMultiFunctionView.c();
            }
            ShapeTextView shapeTextView = this.cJ;
            if (shapeTextView != null) {
                shapeTextView.setVisibility(8);
            }
        } else if (view.getId() == R.id.fl_live_fans) {
            al();
        } else if (view.getId() == R.id.music_float_view) {
            bi();
        } else if (view.getId() == R.id.live_bottom_icon_more) {
            EventTrackLive.a(LiveProtos.Event.LIVE_DOWN_COLLECTION_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            LiveRoomFunctionDlgFragment.a.a(getFragmentManager(), true);
        } else if (view.getId() != R.id.live_wish_enter) {
            if (view.getId() != R.id.header_view || LiveRoomManager.a().t()) {
                return;
            }
            this.dd.a(LiveRoomManager.a().g());
        } else {
            if (this.U.getTag() != null && (this.U.getTag() instanceof LiveWishTipPop)) {
                LiveWishTipPop liveWishTipPop = (LiveWishTipPop) this.U.getTag();
                if (!liveWishTipPop.t()) {
                    liveWishTipPop.p();
                }
                this.U.setTag(null);
            }
            LiveDesireDialogFragment liveDesireDialogFragment = this.dz;
            if (liveDesireDialogFragment == null || !liveDesireDialogFragment.isVisible()) {
                EventTrackLive.b(LiveProtos.Event.LIVE_WISH_ENTER_CLICK, LiveRoomManager.a().e());
                LiveDesireDialogFragment liveDesireDialogFragment2 = new LiveDesireDialogFragment(this.E, LiveDesireDialogFragment.FormType.TYPE_RECORDING_CONFIG);
                this.dz = liveDesireDialogFragment2;
                liveDesireDialogFragment2.show(getFragmentManager(), "desireDialog");
            }
        }
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onClose(final LiveCloseReason liveCloseReason, final LiveChatStatistics liveChatStatistics) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$RecordingOnliveFragment$c3XsmJ_YXyOjDS3lrjDhVEQiADw
            @Override // java.lang.Runnable
            public final void run() {
                RecordingOnliveFragment.this.a(liveCloseReason, liveChatStatistics);
            }
        });
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i == 1) {
            Logger.a("drb", "切换为竖屏");
            this.x = false;
            this.by.b();
        } else if (i == 2) {
            Logger.a("drb", "切换为横屏");
            this.x = true;
            this.by.a();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        this.bq = true;
        this.u = true;
        LiveRoomManager.a().c(true);
        getActivity().getWindow().setSoftInputMode(16);
        super.onCreate(bundle);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        Dialog dialog;
        super.onDestroy();
        YYMusicManager.a.c().a(false, "", "");
        LiveRoomManager.a().c(false);
        InstantLog.a(LiveRoomPreferences.l(), LiveRoomPreferences.m(), LiveRoomPreferences.n());
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.u();
            this.ac.s();
        }
        RecordingPlayerManager recordingPlayerManager = this.cW;
        if (recordingPlayerManager != null) {
            recordingPlayerManager.c();
        }
        ad();
        this.dd.d();
        aw();
        this.cB.b();
        ZanRefreshObserver.a().b(this);
        PlayGifObserver.a().b(this);
        BeansRefreshObserver.a().b(this);
        PlayARObserver.a().b(this);
        LiveSetDataObserver.a().b(this);
        PkDaredView pkDaredView = this.cQ;
        if (pkDaredView != null) {
            pkDaredView.d();
        }
        if (LiveRoomManager.a().d() == this.t) {
            LiveRoomManager.a().o();
        }
        LiveMultiFunctionView liveMultiFunctionView = this.cH;
        if (liveMultiFunctionView != null) {
            liveMultiFunctionView.h();
        }
        LiveRecordLevelView liveRecordLevelView = this.dq;
        if (liveRecordLevelView != null) {
            liveRecordLevelView.a();
        }
        LiveLiangWebDialogFragment liveLiangWebDialogFragment = this.dy;
        if (liveLiangWebDialogFragment != null && (dialog = liveLiangWebDialogFragment.getDialog()) != null && dialog.isShowing()) {
            this.dy.dismissAllowingStateLoss();
        }
        LiveHalfWebDialogFragment liveHalfWebDialogFragment = this.dB;
        if (liveHalfWebDialogFragment != null && liveHalfWebDialogFragment.f()) {
            this.dB.dismissAllowingStateLoss();
        }
        aj();
        ah();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        Dialog dialog4;
        Dialog dialog5;
        Dialog dialog6;
        super.onPause();
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.r();
        }
        RecordingPlayerManager recordingPlayerManager = this.cW;
        if (recordingPlayerManager != null) {
            recordingPlayerManager.b();
        }
        LiveRankGuestDialogFragment liveRankGuestDialogFragment = this.ax;
        if (liveRankGuestDialogFragment != null && (dialog6 = liveRankGuestDialogFragment.getDialog()) != null && dialog6.isShowing()) {
            this.ax.dismiss();
        }
        LiveFansRecordDialogFragment liveFansRecordDialogFragment = this.ay;
        if (liveFansRecordDialogFragment != null && (dialog5 = liveFansRecordDialogFragment.getDialog()) != null && dialog5.isShowing()) {
            this.ay.dismiss();
        }
        LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bn;
        if (liveMakeLoverDialogFragment != null && (dialog4 = liveMakeLoverDialogFragment.getDialog()) != null && dialog4.isShowing()) {
            this.bn.dismiss();
        }
        if (this.l != null && (dialog3 = this.l.getDialog()) != null && dialog3.isShowing()) {
            this.l.dismiss();
        }
        LiveRegularEventRanklistDialogFragment liveRegularEventRanklistDialogFragment = this.az;
        if (liveRegularEventRanklistDialogFragment != null && (dialog2 = liveRegularEventRanklistDialogFragment.getDialog()) != null && dialog2.isShowing()) {
            this.az.dismiss();
        }
        LiveManagerDialogFragment liveManagerDialogFragment = this.aA;
        if (liveManagerDialogFragment != null && (dialog = liveManagerDialogFragment.getDialog()) != null && dialog.isShowing()) {
            this.aA.dismiss();
        }
        ag();
        this.bq = false;
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onRecvNewMsg(ChattingModel chattingModel) {
        LiveEventBusUtil.a(LiveChattingModel.copy(chattingModel), false);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        Configuration configuration = getActivity().getResources().getConfiguration();
        if (this.bp && configuration != null && configuration.orientation == 2) {
            getActivity().setRequestedOrientation(1);
        }
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.q();
        }
        RecordingPlayerManager recordingPlayerManager = this.cW;
        if (recordingPlayerManager != null) {
            recordingPlayerManager.a();
        }
        LiveMsgManager liveMsgManager = this.dd;
        if (liveMsgManager != null) {
            liveMsgManager.d(0);
        }
        if (this.au != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.au.e(), LiveProtos.Status.START);
        }
        this.cB.a();
        this.ab = false;
        this.bq = true;
        av();
        PopLiveActivityWebView popLiveActivityWebView = this.cO;
        if (popLiveActivityWebView != null) {
            popLiveActivityWebView.c();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("unexpectedly_exit", true);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStart() {
        super.onStart();
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            recordingOnliveManager.u();
            this.ac.o();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStop() {
        super.onStop();
        if (this.ac != null) {
            if (this.cB.getVisibility() != 0) {
                this.ac.a(15000L);
            }
            this.ac.p();
        }
        if (!aV()) {
            RecordingOnliveManager recordingOnliveManager = this.ac;
            if (recordingOnliveManager != null) {
                recordingOnliveManager.h();
                if (aS() || aT()) {
                    this.ac.i();
                }
            }
            this.dn.b();
            LiveConnectionView liveConnectionView = this.bB;
            if (liveConnectionView != null) {
                liveConnectionView.u();
            }
            LivePKCountDownView livePKCountDownView = this.bO;
            if (livePKCountDownView != null) {
                livePKCountDownView.f();
            }
        }
        PopBeautyNewView popBeautyNewView = this.au;
        if (popBeautyNewView != null && !popBeautyNewView.d()) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.au.e(), LiveProtos.Status.END);
        }
        Log.v("pk", "isPlayAR onStop false ------- ");
        this.ab = false;
        this.bq = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.da.onTouchEvent(motionEvent);
        return true;
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void q() {
    }

    @Override // com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.ILiveGuestDialog
    public void r_() {
        br();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.ILiveGuestDialog
    public void s_() {
        bs();
    }

    public void switchCamera(View view) {
        if (LiveRoomManager.a().J()) {
            AppMethods.d(R.string.live_game_tips);
        }
        RecordingOnliveManager recordingOnliveManager = this.ac;
        if (recordingOnliveManager != null) {
            if (view == null) {
                recordingOnliveManager.w();
            } else if (ClickUtils.a(view.getId(), 1500L)) {
            } else {
                this.ac.w();
            }
        }
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void u() {
        super.u();
        this.bk.d();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void v() {
        d_(11);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void w() {
        d_(0);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void x() {
        al();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void y() {
        if (LiveRoomManager.a().Y()) {
            View view = this.T;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.T;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected int y_() {
        return R.layout.fragment_recording_onlive;
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void z() {
    }

    @Override // com.blued.android.module.live_china.fragment.LiveFansRecordDialogFragment.ILiveFansRecordDialog
    public void z_() {
        br();
    }
}
