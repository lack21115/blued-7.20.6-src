package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.alipay.sdk.util.i;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.http.QueueFileDownloader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.model.LiveDefaultGiftModel;
import com.blued.android.module.common.utils.AssetsUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live.base.view.animation.AnimationListenerAdapter;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.activity.PlayingOnliveActivity;
import com.blued.android.module.live_china.adapter.LiveModePagerAdapter;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.fragment.LiveFansGuestDialogFragment;
import com.blued.android.module.live_china.fragment.LiveKissDialogFragment;
import com.blued.android.module.live_china.fragment.LiveMakeLoverDialogFragment;
import com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment;
import com.blued.android.module.live_china.fragment.LiveRegularEventRanklistDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.manager.AudioManagerUtils;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveGiftManager;
import com.blued.android.module.live_china.manager.LiveGuideListManager;
import com.blued.android.module.live_china.manager.LiveGuideManager;
import com.blued.android.module.live_china.manager.LiveMakeLoverManager;
import com.blued.android.module.live_china.manager.LiveOperationManager;
import com.blued.android.module.live_china.manager.LivePlayExitTipManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.PlayingMakeFriendManager;
import com.blued.android.module.live_china.manager.PlayingMakeLoverManager;
import com.blued.android.module.live_china.manager.PlayingMultiConnectionManager;
import com.blued.android.module.live_china.manager.PlayingOnlineManager;
import com.blued.android.module.live_china.manager.PlayingRTCManager;
import com.blued.android.module.live_china.manager.PlayingScreenManager;
import com.blued.android.module.live_china.mine.LiveGiftFragment;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.ConstFunction;
import com.blued.android.module.live_china.model.DefinedRankInfo;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.HTMLNoticeModel;
import com.blued.android.module.live_china.model.LiveAnnounceInfoModel;
import com.blued.android.module.live_china.model.LiveAnnounceModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveCloakingTypeModel;
import com.blued.android.module.live_china.model.LiveCouponCountExtra;
import com.blued.android.module.live_china.model.LiveDotModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveInviteUpdateModel;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveNobleModel;
import com.blued.android.module.live_china.model.LiveOneKissModel;
import com.blued.android.module.live_china.model.LivePKPlayerModel;
import com.blued.android.module.live_china.model.LivePKPlusModel;
import com.blued.android.module.live_china.model.LivePKProgressModel;
import com.blued.android.module.live_china.model.LivePKResultModel;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.model.LivePkRoundModel;
import com.blued.android.module.live_china.model.LiveRoomCloseReason;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveRoomPkModel;
import com.blued.android.module.live_china.model.LiveShakeModel;
import com.blued.android.module.live_china.model.LiveWishItemModel;
import com.blued.android.module.live_china.model.LiveWishingDrawModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.model.MuteLiveAudioModel;
import com.blued.android.module.live_china.model.RelationInfo;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.PushGuideObserver;
import com.blued.android.module.live_china.observer.ZanRefreshObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.loadingIndicator.AVLoadingIndicatorView;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.model.DialogWith6PW;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BarrageViewMultiOneRow;
import com.blued.android.module.live_china.view.GrabBoxNumView;
import com.blued.android.module.live_china.view.LiveBunchLightView;
import com.blued.android.module.live_china.view.LiveDragViewLayout;
import com.blued.android.module.live_china.view.LiveMakeFriendListView;
import com.blued.android.module.live_china.view.LiveMakeFriendManageView;
import com.blued.android.module.live_china.view.LiveMakeFriendSettingView;
import com.blued.android.module.live_china.view.LiveMakeLoverManageGuestView;
import com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView;
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
import com.blued.android.module.live_china.view.LivePKRoundWaitView;
import com.blued.android.module.live_china.view.LivePKUserBanner;
import com.blued.android.module.live_china.view.LivePkRoundCountDownView;
import com.blued.android.module.live_china.view.LivePushGuideView;
import com.blued.android.module.live_china.view.LiveRechargeGiftBagView;
import com.blued.android.module.live_china.view.PKDoubleAnimView;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;
import com.blued.android.module.live_china.view.PopLiveCallView;
import com.blued.android.module.live_china.view.PopMultiPKRankView;
import com.blued.android.module.live_china.view.PopPKListView;
import com.blued.android.module.live_china.view.PopRankingListView;
import com.blued.android.module.live_china.view.WishingWellView;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveFragment.class */
public class PlayingOnliveFragment extends LiveBaseFragment implements View.OnClickListener, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone, LiveFansGuestDialogFragment.ILiveFansGuestDialog, LiveRankGuestDialogFragment.ILiveGuestDialog, LiveRefreshUIObserver.ILiveRefreshUIObserver, ZanRefreshObserver.IZanRefreshObserver {
    public static boolean aa = false;
    public static int cB = 0;
    public static boolean cv = true;
    public Context E;
    public ImageView F;
    public ImageView G;
    public ImageView H;
    public GrabBoxNumView I;
    public PlayingOnlineManager K;
    public PlayingRTCManager L;
    public String M;
    public FrameLayout N;
    public View O;
    public LiveAnimationView P;
    public LiveAnimationView Q;
    public KeyboardListenLinearLayout R;
    public View S;
    public TextView T;
    public String U;
    public String[] V;
    public String[] W;
    public String X;
    public int Y;
    public boolean Z;
    public ImageView aA;
    public ImageView aB;
    public TextView aC;
    public TextView aD;
    public TextView aE;
    public TextView aF;
    public FrameLayout aG;
    public FrameLayout aH;
    public FrameLayout aI;
    public FrameLayout aJ;
    public AVLoadingIndicatorView aK;
    public AVLoadingIndicatorView aL;
    public AVLoadingIndicatorView aM;
    public FrameLayout aN;
    public ViewPager aO;
    public LiveModePagerAdapter aP;
    public boolean aQ;
    public boolean aR;
    public FrameLayout aT;
    public LiveDragViewLayout aU;
    public int aY;
    public Dialog aZ;
    public boolean ab;
    public LiveRankGuestDialogFragment ac;
    public LiveRegularEventRanklistDialogFragment ad;
    public LiveFansGuestDialogFragment ae;
    public Dialog af;
    public FrameLayout ag;
    public TextureView ah;
    public FrameLayout ai;
    public FrameLayout aj;
    public FrameLayout ak;
    public FrameLayout al;
    public FrameLayout am;
    public FrameLayout an;
    public FrameLayout ao;
    public FrameLayout ap;
    public FrameLayout aq;
    public FrameLayout ar;
    public FrameLayout as;
    public FrameLayout at;
    public TextureView au;
    public TextureView av;
    public TextureView aw;
    public TextureView ax;
    public TextureView ay;
    public TextureView az;
    public FrameLayout bA;
    public FrameLayout bB;
    public FrameLayout bC;
    public FrameLayout bD;
    public FrameLayout bE;
    public ImageView bF;
    public ImageView bG;
    public ImageView bH;
    public ImageView bI;
    public ImageView bJ;
    public View bK;
    public View bL;
    public View bM;
    public ImageView bN;
    public ImageView bO;
    public ImageView bP;
    public View bQ;
    public View bR;
    public View bS;
    public TextView bT;
    public TextView bU;
    public TextView bV;
    public LiveMakeLoverRootGuestView bW;
    public LiveMakeLoverManageGuestView bX;
    public PlayingMakeLoverManager bY;
    public LiveMakeLoverDialogFragment bZ;
    public int ba;
    public LiveGuideManager bb;
    public LiveGuideListManager bc;
    public IScreenManager bd;
    public boolean be;
    public LinearLayout bf;
    public FrameLayout bg;
    public LivePKProgressView bh;
    public LivePKUserBanner bi;
    public LivePKResult bj;
    public LivePKPayMVPView bk;
    public LivePKPlusView bl;
    public LivePKRoundDotView bm;
    public LivePKRoundWaitView bn;
    public LivePKRoundStartView bo;
    public LivePKRoundTimeView bp;
    public LivePkRoundCountDownView bq;
    public LivePKBubbleLayout br;
    public LivePKBubbleLayout bs;
    public FrameLayout bt;
    public ImageView bu;
    public LivePKCountDownView bv;
    public LivePKFirstPayView bw;
    public LiveAnimationView bx;
    public PopLiveCallView by;
    public FrameLayout bz;
    private int cC;
    private PKDoubleAnimView cD;
    private ImageView cE;
    private PopRankingListView cF;
    private PopPKListView cG;
    private LiveHalfWebDialogFragment cH;
    private LiveShakeDialogFragment cI;
    private LiveKissDialogFragment cJ;
    private LiveRecommendDialogFragment cM;
    private CountDownTimer cN;
    private CountDownTimer cO;
    public LiveMakeFriendSettingView ca;
    public LiveMakeFriendListView cb;
    public View cc;
    public PlayingMakeFriendManager cd;
    public PlayingMultiConnectionManager ce;
    public PopLiveActivityWebView cf;
    public View cg;
    public ImageView ch;
    public LivePlayExitTipManager ci;
    public String cl;
    public int cm;

    /* renamed from: cn  reason: collision with root package name */
    public LiveOperationManager f49cn;
    public LivePushGuideView co;
    public boolean cq;
    public long cs;
    public boolean ct;
    public boolean cu;
    LiveGiftFragment cw;
    public AlertDialog cx;
    public long J = 0;
    public boolean aS = true;
    public boolean aV = true;
    public boolean aW = false;
    public int aX = -1;
    public int cj = 0;
    public String ck = "";
    private long cK = 0;
    private String cL = "";
    LiveDragViewLayout.OnLayoutStateListener cp = new LiveDragViewLayout.OnLayoutStateListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.14
        @Override // com.blued.android.module.live_china.view.LiveDragViewLayout.OnLayoutStateListener
        public void a() {
        }

        @Override // com.blued.android.module.live_china.view.LiveDragViewLayout.OnLayoutStateListener
        public void a(int i) {
            if (PlayingOnliveFragment.this.aQ) {
                if (PlayingOnliveFragment.this.aZ == null || !PlayingOnliveFragment.this.aZ.isShowing()) {
                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                    playingOnliveFragment.aZ = CommonAlertDialog.a(playingOnliveFragment.E, "", PlayingOnliveFragment.this.E.getString(R.string.live_rtc_model_tip), PlayingOnliveFragment.this.E.getString(R.string.biao_version_exit), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.14.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Tracker.onClick(dialogInterface, i2);
                            if (PlayingOnliveFragment.this.aB()) {
                                if (PlayingOnliveFragment.this.cd != null) {
                                    PlayingOnliveFragment.this.cd.f();
                                }
                            } else if (!PlayingOnliveFragment.this.aD()) {
                                PlayingOnliveFragment.this.h(true);
                            } else if (PlayingOnliveFragment.this.bY != null) {
                                PlayingOnliveFragment.this.bY.a(false);
                            }
                        }
                    }, PlayingOnliveFragment.this.E.getString(R.string.cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                }
            }
        }

        @Override // com.blued.android.module.live_china.view.LiveDragViewLayout.OnLayoutStateListener
        public void b() {
            if (LiveRoomManager.a().d() != PlayingOnliveFragment.this.t) {
                return;
            }
            InstantLog.a("live_room_slide");
            PlayingOnliveFragment.this.aT.setVisibility(8);
            LiveFloatManager.a().b(false);
            if (!LiveDataListManager.a().a(PlayingOnliveFragment.this.E, PlayingOnliveFragment.this.t, 1, PlayingOnliveFragment.this.X)) {
                LiveFloatManager.a().n();
            }
            PlayingOnliveFragment.this.T();
            PlayingOnliveFragment.this.getActivity().overridePendingTransition(0, 0);
        }

        @Override // com.blued.android.module.live_china.view.LiveDragViewLayout.OnLayoutStateListener
        public void c() {
            if (LiveRoomManager.a().d() != PlayingOnliveFragment.this.t) {
                return;
            }
            InstantLog.a("live_room_slide");
            PlayingOnliveFragment.this.aT.setVisibility(8);
            LiveFloatManager.a().b(false);
            if (!LiveDataListManager.a().a(PlayingOnliveFragment.this.E, PlayingOnliveFragment.this.t, 0, PlayingOnliveFragment.this.X)) {
                LiveFloatManager.a().n();
            }
            PlayingOnliveFragment.this.T();
            PlayingOnliveFragment.this.getActivity().overridePendingTransition(0, 0);
        }
    };
    ViewPager.OnPageChangeListener cr = new AnonymousClass18();
    int cy = 0;
    private boolean cP = false;
    private boolean cQ = false;
    private boolean cR = false;
    private boolean cS = false;
    private boolean cT = false;
    Runnable cz = new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$ziMHS9927MIzcjk7vsuueuYrtFk
        @Override // java.lang.Runnable
        public final void run() {
            PlayingOnliveFragment.this.bs();
        }
    };
    public int cA = 2;
    private boolean cU = true;
    private Runnable cV = new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$ZaExCVI5BdnqR6bCkrR7yxjSKqA
        @Override // java.lang.Runnable
        public final void run() {
            PlayingOnliveFragment.this.br();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.PlayingOnliveFragment$18  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveFragment$18.class */
    public class AnonymousClass18 implements ViewPager.OnPageChangeListener {
        int a = 0;
        int b = 0;
        boolean c = false;

        AnonymousClass18() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(DialogInterface dialogInterface) {
            PlayingOnliveFragment.this.cM = null;
        }

        public void onPageScrollStateChanged(int i) {
            this.c = false;
            this.b = 0;
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (PushGuideObserver.d().a()) {
                return;
            }
            boolean z = PlayingOnliveFragment.this.E.getResources().getConfiguration().orientation == 1;
            if (!this.c && this.a == PlayingOnliveFragment.this.aP.getCount() - 1 && z) {
                if (f != 1.0d && i2 != 0) {
                    this.c = true;
                    this.b = 0;
                    return;
                }
                int i3 = this.b + 1;
                this.b = i3;
                if (i3 >= 3) {
                    if (PlayingOnliveFragment.this.cM == null) {
                        PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                        playingOnliveFragment.cM = new LiveRecommendDialogFragment(playingOnliveFragment.E, PlayingOnliveFragment.this);
                        PlayingOnliveFragment.this.cM.show(PlayingOnliveFragment.this.getFragmentManager(), "recommendDialog");
                        PlayingOnliveFragment.this.cM.a(new DialogInterface.OnDismissListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$18$W3vjBK6IOdBjnGufnK2Idrs9pA0
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                PlayingOnliveFragment.AnonymousClass18.this.a(dialogInterface);
                            }
                        });
                    }
                    this.c = true;
                    this.b = 0;
                }
            }
        }

        public void onPageSelected(int i) {
            this.a = i;
            if (i == 0) {
                PlayingOnliveFragment.this.ab = true;
                PlayingOnliveFragment.cB = 0;
                LiveSetDataObserver.a().c(0);
                PlayingOnliveFragment.this.g_(8);
            } else if (i != 1) {
            } else {
                PlayingOnliveFragment.this.ab = false;
                PlayingOnliveFragment.cB = 1;
                LiveSetDataObserver.a().c(1);
                PlayingOnliveFragment.this.aC();
                if (PlayingOnliveFragment.this.m == null || !PlayingOnliveFragment.this.m.a()) {
                    return;
                }
                PlayingOnliveFragment.this.g_(0);
            }
        }
    }

    /* renamed from: com.blued.android.module.live_china.fragment.PlayingOnliveFragment$25  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveFragment$25.class */
    class AnonymousClass25 implements LiveRegularEventRanklistDialogFragment.ILiveHostDialog {
        final /* synthetic */ PlayingOnliveFragment a;

        @Override // com.blued.android.module.live_china.fragment.LiveRegularEventRanklistDialogFragment.ILiveHostDialog
        public void a() {
            this.a.bk();
        }

        @Override // com.blued.android.module.live_china.fragment.LiveRegularEventRanklistDialogFragment.ILiveHostDialog
        public void b() {
            this.a.bl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.PlayingOnliveFragment$43  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveFragment$43.class */
    public class AnonymousClass43 implements QueueFileDownloader.QueueFileListener {
        final /* synthetic */ LiveOneKissModel a;

        AnonymousClass43(LiveOneKissModel liveOneKissModel) {
            this.a = liveOneKissModel;
        }

        @Override // com.blued.android.core.net.http.QueueFileDownloader.QueueFileListener
        public void a(final int i, int i2, String str, String str2) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.43.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayingOnliveFragment.this.getFragmentActive() == null || !PlayingOnliveFragment.this.getFragmentActive().isActive()) {
                        Log.i("==ppp", "showLiveKissDialog 5");
                    } else if (PlayingOnliveFragment.this.x) {
                        Log.i("==ppp", "showLiveKissDialog mland return");
                    } else {
                        Log.i("==ppp", "showLiveKissDialog 6:" + i);
                        if (i >= 0) {
                            LiveOneKissModel liveOneKissModel = new LiveOneKissModel();
                            liveOneKissModel.animation = AnonymousClass43.this.a.animation;
                            liveOneKissModel.delay = AnonymousClass43.this.a.delay;
                            liveOneKissModel.duration = AnonymousClass43.this.a.duration;
                            liveOneKissModel.goods_id = AnonymousClass43.this.a.goods_id;
                            liveOneKissModel.goods_name = AnonymousClass43.this.a.goods_name;
                            liveOneKissModel.goods_icon = AnonymousClass43.this.a.goods_icon;
                            liveOneKissModel.pop = AnonymousClass43.this.a.pop;
                            liveOneKissModel.isChargeTo = AnonymousClass43.this.a.isChargeTo;
                            PlayingOnliveFragment.this.cJ = new LiveKissDialogFragment();
                            PlayingOnliveFragment.this.cJ.a(new LiveKissDialogFragment.EventCallBack() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.43.1.1
                                @Override // com.blued.android.module.live_china.fragment.LiveKissDialogFragment.EventCallBack
                                public void a() {
                                    if (LiveRoomManager.a().p() != null) {
                                        LiveRoomManager.a().p().liveOneKissModel = AnonymousClass43.this.a;
                                    }
                                    PlayingOnliveFragment.this.b(true);
                                }
                            });
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("kissModel", liveOneKissModel);
                            PlayingOnliveFragment.this.cJ.setArguments(bundle);
                            PlayingOnliveFragment.this.cJ.show(PlayingOnliveFragment.this.getFragmentManager(), "liveKissDialogFragment");
                            LiveRoomManager.a().p().liveOneKissModel = null;
                        }
                    }
                }
            });
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveFragment$TextOnClickListener.class */
    public interface TextOnClickListener {
        void a(String str);
    }

    public static void a(Context context, LiveRoomData liveRoomData) {
        synchronized (PlayingOnliveFragment.class) {
            try {
                a(context, liveRoomData, -1, new ArrayList());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, LiveRoomData liveRoomData, int i, List<LiveRoomData> list) {
        synchronized (PlayingOnliveFragment.class) {
            try {
                a(context, liveRoomData, i, list, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, LiveRoomData liveRoomData, int i, List<LiveRoomData> list, Bundle bundle) {
        boolean z;
        LiveRoomData liveRoomData2;
        synchronized (PlayingOnliveFragment.class) {
            try {
                if (!LiveFloatManager.a().z() || TextUtils.equals(liveRoomData.comeCode, "web")) {
                    if (list != null && list != LiveDataListManager.a().b()) {
                        LiveDataListManager.a().a(list);
                    }
                    LiveFloatManager.a().M();
                    AudioManagerUtils.a().b();
                    Bundle bundle2 = new Bundle();
                    if (liveRoomData.lid != LiveFloatManager.a().v() || LiveRoomManager.a().p() == null) {
                        z = false;
                        liveRoomData2 = liveRoomData;
                        if (liveRoomData.lid != LiveFloatManager.a().v()) {
                            z = false;
                            liveRoomData2 = liveRoomData;
                            if (LiveFloatManager.a().v() != -1) {
                                LiveFloatManager.a().n();
                                liveRoomData2 = liveRoomData;
                                z = false;
                            }
                        }
                    } else {
                        z = true;
                        liveRoomData2 = LiveRoomManager.a().p();
                    }
                    bundle2.putSerializable("live_anchor_model", liveRoomData2);
                    bundle2.putInt("live_list_position", i);
                    bundle2.putBoolean("live_window", z);
                    if (bundle != null) {
                        bundle2.putAll(bundle);
                    }
                    TerminalActivity.a(bundle2);
                    TerminalActivity.b(bundle2);
                    PlayingOnliveActivity.b(context, PlayingOnliveFragment.class, bundle2);
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveCloseReason liveCloseReason, LiveChatStatistics liveChatStatistics) {
        getActivity().setRequestedOrientation(1);
        aZ();
        KeyboardUtils.a((Activity) getActivity());
        if (liveCloseReason == LiveCloseReason.CLOSED_BY_MANAGER) {
            LiveRouteUtil.a(this, !TextUtils.isEmpty(liveChatStatistics.title) ? liveChatStatistics.title : getString(R.string.Live_applyHost_wormNotice), !TextUtils.isEmpty(liveChatStatistics.audience_message) ? liveChatStatistics.audience_message : null);
        } else {
            if (liveCloseReason == LiveCloseReason.CLOSED_BY_LIVER) {
                LiveMsgSendManager.a().d("收到主播关闭直播消息");
            }
            aw();
        }
        LiveSetDataObserver.a().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveChargeCouponModel liveChargeCouponModel) {
        a((Object) liveChargeCouponModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DefinedRankInfo definedRankInfo) {
        LiveGiftFragment liveGiftFragment = this.cw;
        if (liveGiftFragment == null || !liveGiftFragment.isAdded() || this.cw.isHidden()) {
            return;
        }
        this.cw.a(definedRankInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MuteLiveAudioModel muteLiveAudioModel, View view) {
        EventTrackLive.g(LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_CLICK, muteLiveAudioModel.source_lid, muteLiveAudioModel.source_uid, muteLiveAudioModel.target_uid, muteLiveAudioModel.target_lid);
        ToastUtils.a(this.E.getResources().getString(R.string.live_mute_audio_close_opposite_playing), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final MuteLiveAudioModel muteLiveAudioModel, boolean z) {
        boolean z2 = muteLiveAudioModel.target_status == 0;
        this.bu.setVisibility(z2 ? 0 : 8);
        if (z2) {
            EventTrackLive.g(LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_SHOW, muteLiveAudioModel.source_lid, muteLiveAudioModel.source_uid, muteLiveAudioModel.target_uid, muteLiveAudioModel.target_lid);
            this.bu.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$gQ7-Txzh5oXgyg4C5TMYzPndZpQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayingOnliveFragment.this.a(muteLiveAudioModel, view);
                }
            });
        }
        if (z) {
            ToastUtils.a(this.E.getResources().getString(z2 ? R.string.live_mute_audio_close_opposite_playing : R.string.live_mute_audio_open_opposite_playing), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        bf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, MuteLiveAudioModel muteLiveAudioModel) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && (muteLiveAudioModel.source_uid.equals(LiveRoomManager.a().g()) || muteLiveAudioModel.target_uid.equals(LiveRoomManager.a().g()))) {
            ToastUtils.a(str, 0);
        }
        LiveSetDataObserver a = LiveSetDataObserver.a();
        String str2 = muteLiveAudioModel.target_uid;
        if (muteLiveAudioModel.target_status == 0) {
            z = true;
        }
        a.a(str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Boolean bool) {
        bm();
    }

    private void be() {
        CountDownTimer countDownTimer = this.cN;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(10000L, 1000L) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveSetDataObserver.a().C();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        };
        this.cN = countDownTimer2;
        countDownTimer2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf() {
        CountDownTimer countDownTimer = this.cO;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        h();
    }

    private void bg() {
        LiveEventBus.get("live_show_dialog", Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.3
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    PlayingOnliveFragment.this.r_();
                } else {
                    PlayingOnliveFragment.this.s_();
                }
            }
        });
        LiveEventBus.get("live_ranking_dialog", Integer.class).observe(this, new Observer<Integer>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.4
            /* renamed from: a */
            public void onChanged(Integer num) {
                if (LiveRoomManager.a().p() == null) {
                    return;
                }
                if (PlayingOnliveFragment.this.cF != null) {
                    PlayingOnliveFragment.this.cF.b();
                    if (PlayingOnliveFragment.this.cF.a()) {
                        PlayingOnliveFragment.this.cF.c();
                    }
                }
                if (LiveRoomManager.a().Q() || LiveRoomManager.a().p().isShowHourRank) {
                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                    playingOnliveFragment.cF = new PopRankingListView(playingOnliveFragment);
                    PlayingOnliveFragment.this.cF.a(num.intValue());
                }
            }
        });
        LiveEventBus.get("live_pk_dialog", LivePkBannerModel.class).observe(this, new Observer<LivePkBannerModel>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.5
            /* renamed from: a */
            public void onChanged(LivePkBannerModel livePkBannerModel) {
                if (livePkBannerModel == null || LiveRoomManager.a().p() == null) {
                    return;
                }
                if (PlayingOnliveFragment.this.cG == null) {
                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                    playingOnliveFragment.cG = new PopPKListView(playingOnliveFragment);
                }
                livePkBannerModel.from = 0;
                PlayingOnliveFragment.this.cG.a(livePkBannerModel);
            }
        });
        LiveEventBus.get("live_half_web_close", Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.6
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                PlayingOnliveFragment.this.R();
            }
        });
        LiveEventBus.get("live_auto_scroll_next", Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.7
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (PlayingOnliveFragment.this.t != LiveRoomManager.a().d()) {
                    return;
                }
                if (bool.booleanValue()) {
                    PlayingOnliveFragment.this.cp.b();
                } else {
                    PlayingOnliveFragment.this.cp.c();
                }
            }
        });
        LiveEventBus.get(LiveEventBusUtil.v, Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$HampizH1-RH04qRKx5xjRW9zFS0
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.e((Boolean) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.t, Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$oeKgiDZcKQC9Hh8tOj_i03L8krQ
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.d((Boolean) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.y, String.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$cMuNPmiocMwgCKr3hcVkLzvYALI
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.i((String) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.A, DefinedRankInfo.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$cCu-dv-lmbV2-bJa2krHHs8tN_Y
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.a((DefinedRankInfo) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.B, String.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$WFfnfC7Bzq6dU9HCgac8Aoaz-LY
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.j((String) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.C, LiveRoomFunctionItemModel.class).observe(this, new $$Lambda$vp9O66ly_kNLGZHZsc8Knor7gPc(this));
        LiveEventBus.get("live_multi_pk_stop", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$Vsw9m84978fWYJBmumcpgQi3MqU
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.c(((Boolean) obj).booleanValue());
            }
        });
        LiveEventBus.get("live_multi_pk_rank", LivePkBannerModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$2DWjIpxNpsewUb7qDqlNrQuDIe4
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.a((LivePkBannerModel) obj);
            }
        });
        LiveEventBus.get("live_attention_relation_changed", RelationInfo.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$Mmz_vt40CgQLAtmRlHRcENo6Rt4
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.a((RelationInfo) obj);
            }
        });
        LiveEventBus.get("live_shout_card_success", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$eFXm8PnGz1o7OMqiqLQug1GLiGc
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.c((Boolean) obj);
            }
        });
        LiveEventBus.get("live_noble_update", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$HZhr-XX1QaNlyN02ub4kf4_CvH8
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.b((Boolean) obj);
            }
        });
        LiveEventBus.get("send_gift_success", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$aK6JIGzpmAfQBOFxfRis4-rzexs
            public final void onChanged(Object obj) {
                PlayingOnliveFragment.this.a((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bh */
    public void bv() {
        if (getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        LiveRoomHttpUtils.i(new BluedUIHttpResponse<BluedEntity<LiveChargeCouponModel, LiveCouponCountExtra>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.9
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveChargeCouponModel, LiveCouponCountExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData() || bluedEntity.getSingleData() == null) {
                    return;
                }
                LiveRouteUtil.a(PlayingOnliveFragment.this, bluedEntity.getSingleData());
                LiveRoomHttpUtils.b();
            }
        });
    }

    private void bi() {
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.10
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int height = PlayingOnliveFragment.this.b.getHeight();
                if (height != 0) {
                    PlayingOnliveFragment.this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    PlayingOnliveFragment.this.cj = height;
                    Log.i("==xpf", "realWindowHeight:" + PlayingOnliveFragment.this.cj);
                    if (PlayingOnliveFragment.this.aC() || PlayingOnliveFragment.this.aA() || PlayingOnliveFragment.this.r()) {
                        return;
                    }
                    LiveFloatManager.a().a(AppInfo.l, PlayingOnliveFragment.this.bc());
                }
            }
        });
        this.R = (KeyboardListenLinearLayout) this.b.findViewById(R.id.keyboardLinearLayout);
        this.ag = (FrameLayout) this.b.findViewById(R.id.cameraPreview_afl);
        this.ah = (TextureView) this.b.findViewById(R.id.cameraPreview_surfaceView);
        this.ai = (FrameLayout) this.b.findViewById(R.id.RemoteWindowA);
        this.aj = (FrameLayout) this.b.findViewById(R.id.RemoteWindowB);
        this.ak = (FrameLayout) this.b.findViewById(R.id.RemoteWindowC);
        this.al = (FrameLayout) this.b.findViewById(R.id.RemoteWindowD);
        this.am = (FrameLayout) this.b.findViewById(R.id.RemoteWindowE);
        this.an = (FrameLayout) this.b.findViewById(R.id.RemoteWindowF);
        this.bz = (FrameLayout) this.b.findViewById(R.id.live_window_layout_A);
        this.bA = (FrameLayout) this.b.findViewById(R.id.live_window_layout_B);
        this.bB = (FrameLayout) this.b.findViewById(R.id.live_window_layout_C);
        this.bC = (FrameLayout) this.b.findViewById(R.id.live_window_layout_D);
        this.bD = (FrameLayout) this.b.findViewById(R.id.live_window_layout_E);
        this.bE = (FrameLayout) this.b.findViewById(R.id.live_window_layout_F);
        this.ao = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewA);
        this.ap = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewB);
        this.aq = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewC);
        this.ar = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewD);
        this.as = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewE);
        this.at = (FrameLayout) this.b.findViewById(R.id.fl_RemoteGLSurfaceViewF);
        this.au = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewA);
        this.av = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewB);
        this.aw = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewC);
        this.ax = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewD);
        this.ay = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewE);
        this.az = (TextureView) this.b.findViewById(R.id.RemoteGLSurfaceViewF);
        this.bu = (ImageView) this.b.findViewById(R.id.iv_pk_voice_switchB);
        this.aA = (ImageView) this.b.findViewById(R.id.out_userA_btn);
        this.aB = (ImageView) this.b.findViewById(R.id.out_userB_btn);
        this.aC = (TextView) this.b.findViewById(R.id.remote_nameA);
        this.aD = (TextView) this.b.findViewById(R.id.remote_nameB);
        this.aE = (TextView) this.b.findViewById(R.id.remote_nameC);
        this.aF = (TextView) this.b.findViewById(R.id.remote_nameD);
        this.bF = (ImageView) this.b.findViewById(R.id.live_make_friend_num_B);
        this.bG = (ImageView) this.b.findViewById(R.id.live_make_friend_mic_A);
        this.bH = (ImageView) this.b.findViewById(R.id.live_make_friend_mic_B);
        this.bI = (ImageView) this.b.findViewById(R.id.live_make_friend_mic_C);
        this.bJ = (ImageView) this.b.findViewById(R.id.live_make_friend_mic_D);
        this.bK = this.b.findViewById(R.id.live_make_friend_free_A);
        this.bL = this.b.findViewById(R.id.live_make_friend_free_C);
        this.bM = this.b.findViewById(R.id.live_make_friend_free_D);
        this.bN = (ImageView) this.b.findViewById(R.id.live_make_friend_photo_A);
        this.bO = (ImageView) this.b.findViewById(R.id.live_make_friend_photo_C);
        this.bP = (ImageView) this.b.findViewById(R.id.live_make_friend_photo_D);
        this.aH = (FrameLayout) this.b.findViewById(R.id.remote_loading_layoutB);
        this.aI = (FrameLayout) this.b.findViewById(R.id.remote_loading_layoutC);
        this.aJ = (FrameLayout) this.b.findViewById(R.id.remote_loading_layoutD);
        this.aK = (AVLoadingIndicatorView) this.b.findViewById(R.id.remote_loading_viewB);
        this.aL = (AVLoadingIndicatorView) this.b.findViewById(R.id.remote_loading_viewC);
        this.aM = (AVLoadingIndicatorView) this.b.findViewById(R.id.remote_loading_viewD);
        this.aG = (FrameLayout) this.b.findViewById(R.id.WindowB_click_view);
        this.aN = (FrameLayout) this.b.findViewById(R.id.live_window_layout);
        this.cc = this.b.findViewById(R.id.live_make_friend_float_layout);
        this.bQ = this.b.findViewById(R.id.live_make_friend_windows_A);
        this.bR = this.b.findViewById(R.id.live_make_friend_windows_C);
        this.bS = this.b.findViewById(R.id.live_make_friend_windows_D);
        this.bT = (TextView) this.b.findViewById(R.id.live_make_friend_name_A);
        this.bU = (TextView) this.b.findViewById(R.id.live_make_friend_name_C);
        this.bV = (TextView) this.b.findViewById(R.id.live_make_friend_name_D);
        LiveMakeLoverRootGuestView liveMakeLoverRootGuestView = (LiveMakeLoverRootGuestView) this.b.findViewById(R.id.live_make_lover_root_view);
        this.bW = liveMakeLoverRootGuestView;
        liveMakeLoverRootGuestView.a(this);
        this.bX = (LiveMakeLoverManageGuestView) this.b.findViewById(R.id.live_lover_manage_guest_view);
        ImageView imageView = this.aA;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        if (this.aB != null) {
            Logger.a("drb", "mOutUserB setOnClickListener---------------");
            this.aB.setOnClickListener(this);
        }
        this.N = (FrameLayout) this.b.findViewById(R.id.aspectLayout);
        this.O = this.b.findViewById(R.id.view_dating_bg);
        k();
        if (this.x) {
            this.c.setShakeWidth(DensityUtils.a(this.E, 50.0f));
        }
        this.F = (ImageView) this.b.findViewById(R.id.img_header_bg);
        this.S = this.b.findViewById(R.id.live_loading_layout);
        this.T = (TextView) this.b.findViewById(R.id.live_loading_text);
        this.af = DialogUtils.a((Context) getActivity());
        this.G = (ImageView) this.b.findViewById(R.id.all_gif_view);
        this.H = (ImageView) this.b.findViewById(R.id.grab_box_gif_view);
        this.I = (GrabBoxNumView) this.b.findViewById(R.id.grab_box_num_view);
        this.aO = this.b.findViewById(R.id.live_view_pager);
        this.P = (LiveAnimationView) this.b.findViewById(R.id.live_animation_layou);
        this.Q = (LiveAnimationView) this.b.findViewById(R.id.live_universal_animation);
        this.bf = (LinearLayout) this.b.findViewById(R.id.live_pk_root_layout);
        this.bg = (FrameLayout) this.b.findViewById(R.id.live_pk_screen_layout);
        this.bh = (LivePKProgressView) this.b.findViewById(R.id.live_pk_progress);
        this.bi = (LivePKUserBanner) this.b.findViewById(R.id.live_pk_banner);
        LivePKCountDownView livePKCountDownView = (LivePKCountDownView) this.b.findViewById(R.id.live_pk_count_down_view);
        this.bv = livePKCountDownView;
        livePKCountDownView.setData(this);
        this.bw = (LivePKFirstPayView) this.b.findViewById(R.id.live_pk_first_pay);
        this.br = (LivePKBubbleLayout) this.b.findViewById(R.id.live_pk_my_bubble);
        this.bs = (LivePKBubbleLayout) this.b.findViewById(R.id.live_pk_your_bubble);
        this.bt = (FrameLayout) this.b.findViewById(R.id.live_pk_your_layout);
        this.bx = (LiveAnimationView) this.b.findViewById(R.id.live_pk_start_anim);
        PKDoubleAnimView pKDoubleAnimView = (PKDoubleAnimView) this.b.findViewById(R.id.pk_double_anim_view);
        this.cD = pKDoubleAnimView;
        pKDoubleAnimView.setVisibility(8);
        LivePKResult livePKResult = (LivePKResult) this.b.findViewById(R.id.pk_result);
        this.bj = livePKResult;
        livePKResult.setFragment(this);
        this.bk = (LivePKPayMVPView) this.b.findViewById(R.id.pk_pay_mvp);
        LivePKPlusView livePKPlusView = (LivePKPlusView) this.b.findViewById(R.id.pk_plus_view);
        this.bl = livePKPlusView;
        livePKPlusView.setFragment(this);
        this.bm = (LivePKRoundDotView) this.b.findViewById(R.id.pk_round_dot);
        this.bn = (LivePKRoundWaitView) this.b.findViewById(R.id.pk_round_wait);
        this.bo = (LivePKRoundStartView) this.b.findViewById(R.id.pk_round_start);
        this.bp = (LivePKRoundTimeView) this.b.findViewById(R.id.pk_round_time);
        this.bq = (LivePkRoundCountDownView) this.b.findViewById(R.id.pk_round_count);
        this.aU = (LiveDragViewLayout) this.b.findViewById(R.id.view_drag_layout);
        this.aT = (FrameLayout) this.b.findViewById(R.id.root_layout);
        LiveDragViewLayout liveDragViewLayout = this.aU;
        if (liveDragViewLayout != null) {
            liveDragViewLayout.setOnLayoutStateListener(this.cp);
        }
        this.by = new PopLiveCallView(this);
        this.ca = new LiveMakeFriendSettingView(this, this.t);
        LiveMakeFriendListView liveMakeFriendListView = (LiveMakeFriendListView) this.b.findViewById(R.id.live_make_friend_list_view);
        this.cb = liveMakeFriendListView;
        liveMakeFriendListView.a(1, new LiveMakeFriendListView.LiveSettingClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.11
            @Override // com.blued.android.module.live_china.view.LiveMakeFriendListView.LiveSettingClickListener
            public void a() {
                PlayingOnliveFragment.this.ca.a(0);
                PlayingOnliveFragment.this.ca.e();
            }
        }, this.t, this);
        this.k.a(false, new LiveMakeFriendManageView.LiveManageOnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.12
            @Override // com.blued.android.module.live_china.view.LiveMakeFriendManageView.LiveManageOnClickListener
            public void a() {
                int i = PlayingOnliveFragment.this.k.b;
                if (i == 0 || i == 1 || i == 2) {
                    PlayingOnliveFragment.this.cb.b(true);
                } else if (i != 3) {
                } else {
                    PlayingOnliveFragment.this.ca.a(1);
                    PlayingOnliveFragment.this.ca.e();
                }
            }
        }, this);
        this.bX.a(this, new LiveMakeLoverManageGuestView.LiveMakeLoverOnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.13
            @Override // com.blued.android.module.live_china.view.LiveMakeLoverManageGuestView.LiveMakeLoverOnClickListener
            public void a() {
                EventTrackLive.a(LiveProtos.Event.USER_CONNECT_APPLY_CLICK, String.valueOf(PlayingOnliveFragment.this.t), LiveRoomManager.a().g());
                PlayingOnliveFragment.this.N();
            }
        });
        PopLiveActivityWebView popLiveActivityWebView = (PopLiveActivityWebView) this.b.findViewById(R.id.live_activity_web_view);
        this.cf = popLiveActivityWebView;
        popLiveActivityWebView.a(this);
        this.cg = this.b.findViewById(R.id.live_my_header_layout);
        this.ch = (ImageView) this.b.findViewById(R.id.live_my_header_view);
        ImageLoader.a(getFragmentActive(), LiveRoomInfo.a().d()).a(this.ch);
        this.cE = (ImageView) this.b.findViewById(R.id.live_record_sticker_image);
        this.z = true;
        if (this.ab || !TextUtils.equals("guesslike_live", LiveRoomManager.a().p().note_type)) {
            return;
        }
        LivePushGuideView livePushGuideView = new LivePushGuideView(getContext());
        this.co = livePushGuideView;
        livePushGuideView.a(this.aT, this);
        LiveRoomManager.a().p().note_type = "";
    }

    private void bj() {
        this.bx.a(getFragmentActive(), "", RecyclingUtils.Scheme.FILE.b(AssetsUtils.a("live_multi_pk_start_anim.png", false)), "", "", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk() {
        if (this.x) {
            h(4);
        } else {
            g(4);
        }
        LiveSetDataObserver.a().e(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl() {
        if (this.x) {
            h(0);
        } else {
            g(0);
        }
        t();
        LiveSetDataObserver.a().e(0);
    }

    private void bm() {
        LiveRoomHttpUtils.k(new BluedUIHttpResponse<BluedEntity<LiveZanExtraModel, LiveZanExtraModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.45
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                PushGuideObserver.d().a((View) null);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveZanExtraModel, LiveZanExtraModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.getSingleData() == null) {
                    PushGuideObserver.d().a((View) null);
                    return;
                }
                if (bluedEntity.extra != null) {
                    bluedEntity.getSingleData().privilege_emoji = bluedEntity.extra.privilege_emoji;
                    bluedEntity.getSingleData().desc_url = bluedEntity.extra.desc_url;
                }
                LiveRoomManager.a().a(bluedEntity.getSingleData());
                LiveEventBusUtil.a(bluedEntity.getSingleData());
                if (bluedEntity.getSingleData().like_style == null) {
                    LiveRoomPreferences.a("");
                    ZanRefreshObserver.a().a((String[]) null);
                }
                if (bluedEntity.getSingleData().like_style == null || bluedEntity.getSingleData().like_style.random == null) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bluedEntity.getSingleData().like_style.random.length) {
                        LiveRoomPreferences.a(stringBuffer.toString());
                        ZanRefreshObserver.a().a(bluedEntity.getSingleData().like_style.random);
                        return;
                    }
                    stringBuffer.append(bluedEntity.getSingleData().like_style.random[i2]);
                    stringBuffer.append(i.b);
                    i = i2 + 1;
                }
            }
        });
    }

    private void bn() {
        LiveRoomHttpUtils.D(new BluedUIHttpResponse<BluedEntityA<LiveCloakingTypeModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.46
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveCloakingTypeModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveCloakingUtil.a = LiveCloakingUtil.a(bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        });
    }

    private void bo() {
        if (PushGuideObserver.d().a()) {
            return;
        }
        LiveRouteUtil.a();
        LiveRoomHttpUtils.a(1, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<MultiDialogModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.47
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MultiDialogModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    LiveRouteUtil.a(false);
                    return;
                }
                bluedEntityA.getSingleData().from_type = 1;
                LiveRouteUtil.a(PlayingOnliveFragment.this, bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveRouteUtil.a(false);
                return true;
            }
        });
    }

    private void bp() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$0m6JTT-2SiAK9vRQniiPUA8ZxZo
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveFragment.this.bq();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bq() {
        CommonAlertDialog.a(getActivity(), "充值满赠券使用成功！", "恭喜获得神秘礼包！奖励已发到您的账户中，具体内容请到站内信中查看哦！", "知道了", null, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void br() {
        LiveRoomHttpUtils.b(String.valueOf(this.t));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bt() {
        LiveGiftFragment liveGiftFragment = this.cw;
        if (liveGiftFragment != null) {
            liveGiftFragment.a((LiveDefaultGiftModel) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bu() {
        this.aO.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Boolean bool) {
        a(true, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(LiveGiftModel liveGiftModel) {
        this.Q.a(getFragmentActive(), liveGiftModel.images_gif, liveGiftModel.images_apng2, liveGiftModel.images_mp4, liveGiftModel.anim_code, new AnimationListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.40
            @Override // com.blued.android.module.live.base.view.animation.AnimationListenerAdapter, com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void b() {
                PlayingOnliveFragment.this.Q.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Boolean bool) {
        bp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final LiveGiftModel liveGiftModel) {
        LiveAnimationViewFactory.ScaleType scaleType = LiveAnimationViewFactory.ScaleType.CENTER_CROP;
        LiveAnimationViewFactory.ScaleType scaleType2 = this.x ? LiveAnimationViewFactory.ScaleType.FIT_CENTER : LiveAnimationViewFactory.ScaleType.FIT_BOTTOM;
        HashMap hashMap = null;
        if (!TextUtils.isEmpty(liveGiftModel.luck_bag_img)) {
            hashMap = new HashMap();
            hashMap.put("KEY_LUCKY_BAG_IMG_URL", liveGiftModel.images_static);
            hashMap.put("KEY_LUCKY_BAG_GIFT_IMG_URL", liveGiftModel.luck_bag_img);
        }
        this.P.a(getFragmentActive(), liveGiftModel.images_gif, liveGiftModel.images_apng2, liveGiftModel.images_mp4, liveGiftModel.anim_code, scaleType2, hashMap, new AnimationListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.39
            @Override // com.blued.android.module.live.base.view.animation.AnimationListenerAdapter, com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void b() {
                LiveSetDataObserver.a().a(liveGiftModel);
            }
        });
        if ("luckybag".equals(liveGiftModel.anim_code) || this.aT == null || liveGiftModel.bunchLightModel == null || liveGiftModel.bunchLightModel.getImage() == null || liveGiftModel.bunchLightModel.getImage().isEmpty()) {
            return;
        }
        if (this.A == null) {
            this.A = new LiveBunchLightView(this.E);
            this.A.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.aT.addView(this.A);
        }
        this.A.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$IrAvftvXjK8wrTrDwVvxtH-tMDc
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveFragment.this.f(liveGiftModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Boolean bool) {
        if (!PushGuideObserver.d().a() && bool.booleanValue()) {
            new LivePlaySettingDialogFragment(getContext(), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(LiveGiftModel liveGiftModel) {
        this.A.a(liveGiftModel.bunchLightModel.getImage(), liveGiftModel.bunchLightModel.getPlay_times());
    }

    private void i(List<LivePKPlayerModel> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (LivePKPlayerModel livePKPlayerModel : list) {
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
        this.bm.a(arrayList, arrayList2);
    }

    private void j(List<LivePKPlayerModel> list) {
        LivePKPlayerModel next;
        if (list == null) {
            return;
        }
        Iterator<LivePKPlayerModel> it = list.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.uid == LiveRoomManager.a().f()) {
                this.bh.setOurProgress(next.score);
            } else {
                this.bh.setOtherProgress(next.score);
            }
        }
    }

    public void A() {
        if (LiveRoomManager.a().p() != null) {
            this.ba = LiveRoomManager.a().p().live_type;
            LiveSetDataObserver.a().b(LiveRoomManager.a().p());
        }
    }

    public void B() {
        if (this.ba != 1) {
            if (this.bb == null) {
                this.bb = new LiveGuideManager(this);
            }
            if (this.bc == null) {
                this.bc = new LiveGuideListManager(this, false);
            }
        }
    }

    public void C() {
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        if (!LiveRoomManager.a().t()) {
            ImageLoader.a(getFragmentActive(), LiveRoomManager.a().p().profile.avatar).b(R.drawable.shape_live_bg).e().d().a(this.F);
        }
        Logger.a("rrrb", "使用请求网络封面");
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void D() {
    }

    public void E() {
        Context context = this.E;
        CommonAlertDialog.a(context, "", context.getString(R.string.live_make_friend_out_tips), this.E.getString(R.string.filter_off), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.20
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (PlayingOnliveFragment.this.cd != null) {
                    PlayingOnliveFragment.this.cd.f();
                }
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void F() {
        Context context = this.E;
        CommonAlertDialog.a(context, "", context.getString(R.string.live_make_lover_quit_tip), this.E.getString(R.string.live_make_lover_confirm), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.21
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (PlayingOnliveFragment.this.bY != null) {
                    PlayingOnliveFragment.this.bY.a(false);
                }
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void G() {
        Context context = this.E;
        CommonAlertDialog.a(context, "", context.getString(R.string.live_make_lover_quit_room_tip), this.E.getString(R.string.live_make_lover_confirm), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.22
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (PlayingOnliveFragment.this.bY != null) {
                    PlayingOnliveFragment.this.bY.a(true);
                }
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void H() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(LiveRoomManager.a().g());
        arrayList.add(String.valueOf(this.K.b));
        LiveRoomManager.a().a(arrayList);
        LiveRoomData liveRoomData = new LiveRoomData(this.bi.getOtherLid(), 0, this.X, String.valueOf(this.K.b), "", this.bi.getAvatar(), 0);
        liveRoomData.link_type = 1;
        LiveSetDataObserver.a().a(liveRoomData);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void I() {
        a(this.E, null, 20, getString(R.string.liveVideo_livingView_tips_reportReason), null, getString(R.string.liveVideo_livingView_label_reportButton), "", null, new TextOnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.23
            @Override // com.blued.android.module.live_china.fragment.PlayingOnliveFragment.TextOnClickListener
            public void a(String str) {
                if (PlayingOnliveFragment.this.K != null) {
                    PlayingOnliveFragment.this.K.b(str);
                }
            }
        }, null);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void I_() {
        this.cd.b();
        i("stop_make_friend");
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void J() {
        if (!LiveRoomManager.a().R() || LiveRoomManager.a().t()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("UID", LiveRoomManager.a().g());
        bundle.putLong(LiveRankGuestDialogFragment.a, this.t);
        bundle.putBoolean("isMakeLover", aC());
        LiveRankGuestDialogFragment liveRankGuestDialogFragment = new LiveRankGuestDialogFragment();
        this.ac = liveRankGuestDialogFragment;
        liveRankGuestDialogFragment.a(this);
        this.ac.setArguments(bundle);
        this.ac.show(getFragmentManager(), "EditNameDialog");
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void K() {
        a(false);
    }

    public void L() {
        LiveSetDataObserver.a().x();
    }

    public void M() {
        LiveSetDataObserver.a().a(LiveRoomManager.a().p().goods_wall);
    }

    public void N() {
        LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bZ;
        if (liveMakeLoverDialogFragment == null || !liveMakeLoverDialogFragment.isVisible()) {
            this.bZ = new LiveMakeLoverDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("lid", this.t);
            bundle.putString("uid", LiveRoomInfo.a().f());
            bundle.putInt("from", 0);
            this.bZ.setArguments(bundle);
            this.bZ.a(new LiveMakeLoverDialogFragment.ILiveMakeLoverDialog() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.24
                @Override // com.blued.android.module.live_china.fragment.LiveMakeLoverDialogFragment.ILiveMakeLoverDialog
                public void a() {
                    PlayingOnliveFragment.this.t();
                }
            });
            this.bZ.show(getFragmentManager(), "liveMakeLoverApplyDialog");
        }
    }

    public boolean O() {
        LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bZ;
        return liveMakeLoverDialogFragment != null && liveMakeLoverDialogFragment.isVisible();
    }

    public void P() {
        LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bZ;
        if (liveMakeLoverDialogFragment == null || !liveMakeLoverDialogFragment.isVisible()) {
            return;
        }
        this.bZ.dismiss();
    }

    public void Q() {
        if (this.l == null || !this.l.isVisible()) {
            return;
        }
        this.l.dismiss();
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void Q_() {
        DialogUtils.a(this.af);
    }

    public void R() {
        LiveHalfWebDialogFragment liveHalfWebDialogFragment = this.cH;
        if (liveHalfWebDialogFragment == null || !liveHalfWebDialogFragment.f()) {
            return;
        }
        this.cH.dismissAllowingStateLoss();
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void S() {
        aH();
    }

    public void T() {
        b(false);
    }

    public void U() {
        Logger.a("drb", "openConnectionMode");
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.26
            @Override // java.lang.Runnable
            public void run() {
                PlayingOnliveFragment.this.ag.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                PlayingOnliveFragment.this.ag.setVisibility(0);
                PlayingOnliveFragment.this.aN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                PlayingOnliveFragment.this.bA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                PlayingOnliveFragment.this.bA.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(PlayingOnliveFragment.this.E, 105.0f), DensityUtils.a(PlayingOnliveFragment.this.E, 187.0f));
                layoutParams.gravity = 85;
                layoutParams.setMargins(0, 0, 0, DensityUtils.a(PlayingOnliveFragment.this.E, 64.0f));
                PlayingOnliveFragment.this.aj.setLayoutParams(layoutParams);
                LiveFloatManager.a().b.setVisibility(8);
                LiveFloatManager.a().h();
                PlayingOnliveFragment.this.aQ = true;
                PlayingOnliveFragment.this.aU.setRTCModel(PlayingOnliveFragment.this.aQ);
                LiveSetDataObserver.a().h();
            }
        });
    }

    public void V() {
        this.ag.setVisibility(4);
        LiveFloatManager.a().b.setVisibility(0);
        LiveFloatManager.a().f();
        this.aQ = false;
        this.aU.setRTCModel(false);
        LiveSetDataObserver.a().i();
    }

    public void W() {
        if (this.aO == null || this.aP == null || this.x || this.aO.getCurrentItem() == 1) {
            return;
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$XkcucRs93b0Hk-RSHLiHDbdgYBo
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveFragment.this.bu();
            }
        }, 100L);
    }

    public void X() {
        this.cd.c();
    }

    public void Y() {
        this.ce.a();
        LiveSetDataObserver.a().a((List<LiveInviteUserModel>) null);
    }

    public void Z() {
        this.bY.f();
    }

    public void a(float f, float f2, String str, int i) {
        if (i == 0) {
            this.cE.setVisibility(8);
            this.cE.startAnimation(AnimationUtils.loadAnimation(this.E, R.anim.push_center_out));
            return;
        }
        this.cE.setVisibility(0);
        ImageLoader.a(getFragmentActive(), str).a(this.cE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(this.E, 90.0f), DensityUtils.a(this.E, 45.0f));
        layoutParams.leftMargin = (int) (f * AppInfo.l);
        layoutParams.topMargin = (int) (f2 * AppInfo.m);
        Log.v("pk", "changeSticker leftMargin:" + layoutParams.leftMargin + " == topMargin：" + layoutParams.topMargin);
        layoutParams.gravity = 51;
        this.cE.setLayoutParams(layoutParams);
    }

    public void a(int i, int i2) {
        LiveSetDataObserver.a().a(i, i2);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void a(int i, String str) {
        this.I.a(i, str);
    }

    public void a(final int i, final boolean z) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.19
            @Override // java.lang.Runnable
            public void run() {
                if (i == 0) {
                    if (PlayingOnliveFragment.this.K.a == 1) {
                        PlayingOnliveFragment.this.T.setText(R.string.live_anchor_leave);
                    } else {
                        PlayingOnliveFragment.this.T.setText(R.string.liveVideo_livingView_tips_isConnecting);
                    }
                    PlayingOnliveFragment.this.cs = System.currentTimeMillis();
                } else if (PlayingOnliveFragment.this.F.getVisibility() == 0) {
                    Log.e("xkz_er", "gone");
                    AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PlayingOnliveFragment.this.F.setVisibility(8);
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            alphaAnimation.setFillAfter(false);
                            alphaAnimation.setDuration(800L);
                            PlayingOnliveFragment.this.F.setAnimation(alphaAnimation);
                            alphaAnimation.start();
                        }
                    }, 200L);
                }
                if (i == 8 && z) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = PlayingOnliveFragment.this.cs;
                    if (PlayingOnliveFragment.this.K != null) {
                        long j2 = (currentTimeMillis - j) / 1000;
                        if (j2 > 2) {
                            PlayingOnliveFragment.this.K.a(j2);
                        }
                    }
                }
                PlayingOnliveFragment.this.S.setVisibility(i);
            }
        });
    }

    public void a(long j) {
        PKDoubleAnimView pKDoubleAnimView = this.cD;
        if (pKDoubleAnimView == null) {
            return;
        }
        if (j <= 0) {
            pKDoubleAnimView.a();
        } else {
            pKDoubleAnimView.a(getFragmentActive(), j);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void a(AlertDialog alertDialog) {
        this.cx = alertDialog;
    }

    public void a(Context context, String str, final int i, String str2, String str3, String str4, String str5, String str6, final TextOnClickListener textOnClickListener, DialogInterface.OnClickListener onClickListener) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(5, 20, 5, 20);
        final EditText editText = new EditText(context);
        editText.setText(str5);
        editText.setHint(str6);
        editText.setSelection(str5.length());
        editText.setLayoutParams(layoutParams);
        editText.requestFocus();
        editText.setSingleLine(true);
        final TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, 15, 0);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(5);
        textView.setTextColor(context.getResources().getColor(R.color.common_v4_blue_frame_font));
        linearLayout.addView(editText);
        linearLayout.addView(textView);
        int e = CommonStringUtils.e(str5);
        textView.setText(e + BridgeUtil.SPLIT_MARK + i);
        editText.setSelection(str5.length());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.37
            public int a;
            public int b;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    editText.removeTextChangedListener(this);
                    this.a = editText.getSelectionStart();
                    this.b = editText.getSelectionEnd();
                    while (CommonStringUtils.a(editable) > i) {
                        editable.delete(this.a - 1, this.b);
                        this.a--;
                        this.b--;
                    }
                    textView.setText(CommonStringUtils.a(editable) + BridgeUtil.SPLIT_MARK + i);
                    editText.setSelection(this.a);
                    editText.addTextChangedListener(this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    textView.setText("");
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog.Builder view = builder.setTitle(str).setView(linearLayout);
        String str7 = str4;
        if (TextUtils.isEmpty(str4)) {
            str7 = context.getResources().getString(R.string.biao_v4_ok);
        }
        view.setPositiveButton(str7, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.38
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                TextOnClickListener textOnClickListener2 = textOnClickListener;
                textOnClickListener2.a(((Object) editText.getText()) + "");
            }
        }).setCancelable(true).setOnCancelListener(null);
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        AlertDialog create = builder.create();
        this.cx = create;
        create.getWindow().setSoftInputMode(5);
        this.cx.setCanceledOnTouchOutside(true);
        this.cx.show();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void a(Bundle bundle) {
        super.a(bundle);
        bi();
        b(this.R);
        bd();
        bo();
        LiveRoomHttpUtils.b(getFragmentActive());
    }

    public void a(JoinLiveResult joinLiveResult, String str, String str2, String str3, String str4, int i) {
        if (this.L == null || this.x) {
            return;
        }
        this.L.a(joinLiveResult, str, str3, str4, i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void a(LiveDefaultGiftModel liveDefaultGiftModel) {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.anim_gift_bottom_in, R.anim.anim_gift_bottom_out);
        LiveGiftFragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("LiveGift");
        this.cw = findFragmentByTag;
        if (findFragmentByTag == null) {
            LiveGiftFragment liveGiftFragment = new LiveGiftFragment();
            this.cw = liveGiftFragment;
            liveGiftFragment.a((BaseFragment) this);
            beginTransaction.add(R.id.live_gift_container_layout_id, this.cw, "LiveGift");
        } else {
            beginTransaction.show(findFragmentByTag);
        }
        this.cw.a((Object) liveDefaultGiftModel);
        beginTransaction.commitAllowingStateLoss();
        i("gift_show");
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void a(GrabBoxModel grabBoxModel) {
        if (grabBoxModel == null) {
            return;
        }
        this.H.setVisibility(0);
        ImageLoader.a(getFragmentActive(), grabBoxModel.box_gif).a(new ImageLoadResult(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.42
            @Override // com.blued.android.core.image.ImageLoadResult
            public void a(int i, Exception exc) {
                PlayingOnliveFragment.this.H.setVisibility(8);
            }
        }).a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.41
            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void a() {
            }

            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void b() {
                PlayingOnliveFragment.this.H.setVisibility(8);
            }
        }).a(this.H);
    }

    public void a(HTMLNoticeModel hTMLNoticeModel) {
        if (hTMLNoticeModel == null || TextUtils.isEmpty(hTMLNoticeModel.html_msg)) {
            return;
        }
        PopLiveActivityWebView popLiveActivityWebView = this.cf;
        if (popLiveActivityWebView != null && popLiveActivityWebView.e()) {
            this.cf.setJsBridgeData(hTMLNoticeModel);
            return;
        }
        LiveHalfWebDialogFragment liveHalfWebDialogFragment = this.cH;
        if (liveHalfWebDialogFragment != null && liveHalfWebDialogFragment.isAdded() && this.cH.f()) {
            this.cH.a(hTMLNoticeModel);
        }
    }

    public void a(LiveFriendModel liveFriendModel) {
        if (LiveRoomManager.a().V()) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_EXPLAIN_BUBBLE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this.cK = System.currentTimeMillis();
        int i = AppInfo.l / 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, PlayingMakeFriendManager.b, 0, 0);
        this.bf.setLayoutParams(layoutParams);
        this.bg.setLayoutParams(new LinearLayout.LayoutParams(-1, (i / 3) * 4));
        this.bt.setVisibility(0);
        this.bh.setVisibility(0);
        this.bi.setVisibility(0);
        this.bv.setVisibility(0);
        if (liveFriendModel != null) {
            this.bh.b();
            this.bv.a(liveFriendModel.delay, false);
            this.bn.a((int) liveFriendModel.delay);
            LivePKPlayerModel livePKPlayerModel = null;
            if (liveFriendModel.records != null) {
                long j = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                livePKPlayerModel = null;
                for (LivePKPlayerModel livePKPlayerModel2 : liveFriendModel.records) {
                    if (livePKPlayerModel2 == null) {
                        return;
                    }
                    if (livePKPlayerModel2.uid == LiveRoomManager.a().f()) {
                        i2 = livePKPlayerModel2.win_streak;
                        i4 = livePKPlayerModel2.target_streak;
                        i6 = livePKPlayerModel2.target_beans;
                        i5 = livePKPlayerModel2.total_beans;
                        this.bh.setOurProgress(livePKPlayerModel2.score);
                    } else {
                        this.bh.setOtherProgress(livePKPlayerModel2.score);
                        this.K.b = livePKPlayerModel2.uid;
                        i3 = livePKPlayerModel2.win_streak;
                        j = livePKPlayerModel2.uid;
                        livePKPlayerModel = livePKPlayerModel2;
                    }
                }
                LivePKPlusModel livePKPlusModel = new LivePKPlusModel();
                livePKPlusModel.leftWinNum = i2;
                livePKPlusModel.rightWinNum = i3;
                livePKPlusModel.result = -1;
                livePKPlusModel.otherUid = j;
                livePKPlusModel.target_streak = i4;
                livePKPlusModel.total_beans = i5;
                livePKPlusModel.target_beans = i6;
                this.bl.setResult(livePKPlusModel);
                this.bl.setOtherLid(StringUtils.a(liveFriendModel.lid, 0L));
            }
            this.bi.a(liveFriendModel.lid, livePKPlayerModel);
            if (!TextUtils.isEmpty(liveFriendModel.first_kill_message)) {
                this.bw.setText(liveFriendModel.first_kill_message);
            }
            this.bw.setVisibility(this.K.o() ? 0 : 8);
        }
        this.bd.e();
        this.aG.setVisibility(0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(AppInfo.l / 2, ((AppInfo.l / 2) / 3) * 4);
        layoutParams2.topMargin = DensityUtils.a(this.E, 145.0f);
        layoutParams2.gravity = 53;
        this.aG.setLayoutParams(layoutParams2);
        this.aG.setClickable(false);
        LiveSetDataObserver.a().c();
        if (M_() != 1) {
            this.bu.setVisibility(8);
        }
        d_(1);
    }

    public void a(LiveInviteUserModel liveInviteUserModel) {
        this.ce.a(liveInviteUserModel);
    }

    public void a(LiveMakeLoverFansModel liveMakeLoverFansModel) {
        this.bY.a(liveMakeLoverFansModel);
    }

    public void a(LivePkBannerModel livePkBannerModel) {
        new PopMultiPKRankView().a(getContext(), livePkBannerModel, getFragmentActive());
    }

    public void a(LivePkRoundModel livePkRoundModel) {
        Log.i("==xpm", "onPkRoundStart");
        this.bw.setVisibility(this.K.o() ? 0 : 8);
        this.bi.b();
        this.bj.a();
        this.bk.a();
        this.bn.a();
        this.bo.a(livePkRoundModel.count);
        this.bp.a(livePkRoundModel.count);
        this.bi.setVsVisable(false);
        i(livePkRoundModel.records);
        this.bh.b();
        LiveFriendModel liveFriendModel = new LiveFriendModel();
        liveFriendModel.countdown = livePkRoundModel.countdown;
        this.bv.setPKCountDownCallback(new LivePKCountDownView.PKCountDownCallback() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.17
            @Override // com.blued.android.module.live_china.view.LivePKCountDownView.PKCountDownCallback
            public void a() {
                PlayingOnliveFragment.this.bq.a();
            }
        });
        this.bv.a(liveFriendModel.countdown, false);
    }

    public void a(final LiveRoomCloseReason liveRoomCloseReason) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.36
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (CommonTools.a(PlayingOnliveFragment.this)) {
                    KeyboardUtils.a((Activity) PlayingOnliveFragment.this.getActivity());
                    LiveRoomCloseReason liveRoomCloseReason2 = liveRoomCloseReason;
                    if (liveRoomCloseReason2 != null && liveRoomCloseReason2.errorCode == 400006) {
                        PlayingOnliveFragment.this.aw();
                        return;
                    }
                    String string = PlayingOnliveFragment.this.getString(R.string.liveVideo_livingView_tips_networkUnstable);
                    LiveRoomCloseReason liveRoomCloseReason3 = liveRoomCloseReason;
                    if (liveRoomCloseReason3 == null || TextUtils.isEmpty(liveRoomCloseReason3.errorMessage)) {
                        str = string;
                        if (PlayingOnliveFragment.this.K != null) {
                            PlayingOnliveFragment.this.K.n();
                            str = string;
                        }
                    } else {
                        str = liveRoomCloseReason.errorMessage;
                    }
                    if (liveRoomCloseReason != null) {
                        LogUtils.d("pLog", "直播间关闭0---- " + liveRoomCloseReason.errorCode + " ----- " + liveRoomCloseReason.errorMessage);
                    }
                    LiveRouteUtil.a(PlayingOnliveFragment.this, str);
                }
            }
        });
    }

    public void a(LiveRoomFunctionItemModel liveRoomFunctionItemModel) {
        if (liveRoomFunctionItemModel != null) {
            if (TextUtils.isEmpty(liveRoomFunctionItemModel.getLink()) && this.ab) {
                return;
            }
            LogUtils.d("==bLog", "onLiveRoomFunction ----- ");
            if (liveRoomFunctionItemModel.getLink_type() != 3) {
                if (liveRoomFunctionItemModel.getLink_type() == 2) {
                    j(liveRoomFunctionItemModel.getLink());
                    return;
                } else {
                    a(liveRoomFunctionItemModel.getLink(), 25);
                    return;
                }
            }
            String link = liveRoomFunctionItemModel.getLink();
            boolean z = true;
            int hashCode = link.hashCode();
            if (hashCode != -821598591) {
                if (hashCode == 758633892 && link.equals(ConstFunction.LIVE_ROOM_GOODS_WALL)) {
                    z = true;
                }
            } else if (link.equals(ConstFunction.LIVE_ROOM_GIFT)) {
                z = false;
            }
            if (!z) {
                aH();
            } else if (!z) {
            } else {
                LiveGoodsWallDialogFragment.a.a(getChildFragmentManager());
            }
        }
    }

    public void a(LiveShakeModel liveShakeModel) {
        if (liveShakeModel != null) {
            liveShakeModel.pageFrom = 0;
        }
        LiveShakeDialogFragment liveShakeDialogFragment = this.cI;
        if (liveShakeDialogFragment != null && liveShakeDialogFragment.e()) {
            this.cI.a(liveShakeModel);
            return;
        }
        LiveShakeDialogFragment liveShakeDialogFragment2 = this.cI;
        if (liveShakeDialogFragment2 != null) {
            liveShakeDialogFragment2.d();
        }
        this.cI = new LiveShakeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("shakeModel", liveShakeModel);
        this.cI.setArguments(bundle);
        this.cI.show(getChildFragmentManager(), "shakeDialogFragment");
    }

    public void a(LiveWishItemModel liveWishItemModel) {
        LiveSetDataObserver.a().a(liveWishItemModel);
    }

    public void a(LiveWishingDrawModel liveWishingDrawModel) {
        LiveSetDataObserver.a().a(liveWishingDrawModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void a(MuteLiveAudioModel muteLiveAudioModel, String str) {
        a(muteLiveAudioModel, true, str);
    }

    public void a(final MuteLiveAudioModel muteLiveAudioModel, final boolean z, final String str) {
        if (muteLiveAudioModel == null || muteLiveAudioModel.target_uid.equals(LiveRoomManager.a().g()) || !muteLiveAudioModel.source_uid.equals(LiveRoomManager.a().g())) {
            return;
        }
        if (s()) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$aBMpLJNYjPhm7HchAvrwXfm3Cp8
                @Override // java.lang.Runnable
                public final void run() {
                    PlayingOnliveFragment.a(String.this, muteLiveAudioModel);
                }
            });
        } else if (r()) {
            this.bA.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$T11wvQK4cSQUO-xmcDHqamyNGOU
                @Override // java.lang.Runnable
                public final void run() {
                    PlayingOnliveFragment.this.a(muteLiveAudioModel, z);
                }
            });
        }
    }

    public void a(RelationInfo relationInfo) {
        this.ce.a(relationInfo);
    }

    public void a(Object obj) {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.anim_gift_bottom_in, R.anim.anim_gift_bottom_out);
        LiveGiftFragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("LiveGift");
        this.cw = findFragmentByTag;
        if (findFragmentByTag == null) {
            LiveGiftFragment liveGiftFragment = new LiveGiftFragment();
            this.cw = liveGiftFragment;
            liveGiftFragment.a((BaseFragment) this);
            beginTransaction.add(R.id.live_gift_container_layout_id, this.cw, "LiveGift");
        } else {
            beginTransaction.show(findFragmentByTag);
        }
        this.cw.a(obj);
        beginTransaction.commitAllowingStateLoss();
        i("gift_show");
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void a(String str) {
    }

    public void a(String str, int i) {
        a(str, false, i);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void a(String str, String str2) {
        LiveSetDataObserver.a().a(str, str2);
    }

    public void a(String str, boolean z, int i) {
        LiveHalfWebDialogFragment liveHalfWebDialogFragment = this.cH;
        if (liveHalfWebDialogFragment != null && liveHalfWebDialogFragment.f()) {
            this.cH.dismissAllowingStateLoss();
        }
        this.cH = new LiveHalfWebDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putInt("webview_radius", i);
        bundle.putBoolean("fullScreen", z);
        this.cH.setArguments(bundle);
        this.cH.show(getFragmentManager(), "showLiveHalfWebDialog");
    }

    public void a(List<LiveInviteUserModel> list, LiveInviteUserModel liveInviteUserModel) {
        this.ce.a(list, liveInviteUserModel);
        LiveSetDataObserver.a().a(list);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void a(boolean z) {
        LiveFansGuestDialogFragment liveFansGuestDialogFragment = this.ae;
        if ((liveFansGuestDialogFragment == null || !liveFansGuestDialogFragment.isVisible()) && !LiveRoomManager.a().t()) {
            if (LiveRoomManager.a().p().profile != null) {
                EventTrackLive.a(LiveProtos.Event.LIVE_FANS_CLUB_BTN_CLICK, String.valueOf(this.t), LiveRoomManager.a().g());
            }
            Bundle bundle = new Bundle();
            bundle.putString("uid", LiveRoomManager.a().g());
            bundle.putLong("lid", this.t);
            bundle.putShort(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, this.s);
            bundle.putInt("level", LiveRoomManager.a().p().level);
            bundle.putBoolean("DefaultTagFansGroup", z);
            LiveFansGuestDialogFragment liveFansGuestDialogFragment2 = new LiveFansGuestDialogFragment();
            this.ae = liveFansGuestDialogFragment2;
            liveFansGuestDialogFragment2.a(this);
            this.ae.setArguments(bundle);
            this.ae.show(getFragmentManager(), "FansDialog");
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void a(boolean z, int i) {
        this.cd.a(z, i);
    }

    public void a(boolean z, String str) {
        if (this.o != null) {
            this.o.a(getFragmentActive(), z, str);
        }
    }

    @Override // com.blued.android.module.live_china.observer.ZanRefreshObserver.IZanRefreshObserver
    public void a(String[] strArr) {
        if (this.c != null) {
            this.c.a(strArr);
        }
    }

    public boolean aA() {
        return M_() == 5 || M_() == 6;
    }

    public boolean aB() {
        return M_() == 6;
    }

    public boolean aC() {
        return M_() == 8 || M_() == 9;
    }

    public boolean aD() {
        return M_() == 9;
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public boolean aE() {
        if (az()) {
            AppMethods.d(R.string.connecting);
            return false;
        } else if (aB()) {
            AppMethods.d(R.string.connecting);
            return false;
        } else if (aD()) {
            AppMethods.d(R.string.connecting);
            return false;
        } else if (this.k.a()) {
            AppMethods.d(R.string.live_make_friend_cancel_application);
            return false;
        } else if (LiveMakeLoverManager.b()) {
            AppMethods.d(R.string.live_make_lover_cancel_application);
            return false;
        } else {
            return true;
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void aF() {
        if (aE()) {
            LiveRoomInfo.a().a(this.E, 4);
            b(true);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void aG() {
        if (aE()) {
            LiveRoomInfo.a().a(this.E, getFragmentManager(), 9, this.cL);
            this.cL = "";
        }
    }

    public void aH() {
        a((LiveDefaultGiftModel) null);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void aI() {
        a((LiveDefaultGiftModel) null);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$JN4syNAER42caXOZGXyc6wEM74s
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveFragment.this.bt();
            }
        }, 200L);
    }

    public void aJ() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.anim_gift_bottom_in, R.anim.anim_gift_bottom_out);
        LiveGiftFragment liveGiftFragment = this.cw;
        if (liveGiftFragment != null) {
            beginTransaction.hide(liveGiftFragment).commitAllowingStateLoss();
        }
        t();
        f_(0);
    }

    public void aK() {
        if (this.cw != null) {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.anim_gift_bottom_in, R.anim.anim_gift_bottom_out);
            beginTransaction.remove(this.cw).commitAllowingStateLoss();
            this.cw = null;
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void aL() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void aM() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void aN() {
        j(!TextUtils.isEmpty(WishingWellView.a) ? WishingWellView.a : !TextUtils.isEmpty(LiveRoomManager.a().p().entrance_url) ? LiveRoomManager.a().p().entrance_url : LiveRoomInfo.a().j() ? "https://activity-test.blued.cn/hd/2021/wishing-well/star-site?blued_mode=hide_nav" : "https://activity.blued.cn/hd/2021/wishing-well/star-site?blued_mode=hide_nav");
        LiveEventBus.get("live_hide_wishing_welldot").post(true);
    }

    public void aO() {
        g(8);
        this.aG.setVisibility(8);
    }

    public void aP() {
        LiveGiftFragment liveGiftFragment = this.cw;
        if (liveGiftFragment == null || liveGiftFragment.isHidden() || this.x) {
            g(0);
        }
        LiveSetDataObserver.a().p();
        if (r() || ax() || ay() || az()) {
            this.aG.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void aQ() {
        if (this.by.c()) {
            this.by.a();
        }
        if (this.aQ) {
            if (aB()) {
                E();
            } else if (aD()) {
                G();
            } else {
                av();
            }
        }
        if (this.cf.e()) {
            this.cf.f();
        }
        LiveGiftFragment liveGiftFragment = this.cw;
        if (liveGiftFragment != null && liveGiftFragment.isActive() && this.cw.isAdded() && !this.cw.isHidden()) {
            this.cw.onBackPressed();
        }
        if (this.k.a()) {
            AppMethods.d(R.string.live_make_friend_cancel_application);
        }
        if (LiveMakeLoverManager.b()) {
            AppMethods.d(R.string.live_make_lover_cancel_application);
        }
        PopRankingListView popRankingListView = this.cF;
        if (popRankingListView != null && popRankingListView.a()) {
            this.cF.c();
        }
        b(true);
    }

    public void aR() {
        PlayingMakeLoverManager playingMakeLoverManager;
        if (this.aQ) {
            if (aB()) {
                PlayingMakeFriendManager playingMakeFriendManager = this.cd;
                if (playingMakeFriendManager != null) {
                    playingMakeFriendManager.f();
                }
            } else if (aD() && (playingMakeLoverManager = this.bY) != null) {
                playingMakeLoverManager.a(false);
            }
        }
        if (LiveMakeLoverManager.b()) {
            LiveRoomHttpUtils.w((BluedUIHttpResponse) null, String.valueOf(this.t));
        }
        Logger.a("ddrb", "onClickCloseBtn");
        LiveFloatManager.a().b(false);
        LiveFloatManager.a().n();
        T();
    }

    public void aS() {
        LiveFriendModel liveFriendModel;
        if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().link_type != 2 || (liveFriendModel = LiveRoomManager.a().p().friends_line) == null) {
            return;
        }
        c(liveFriendModel);
    }

    public void aT() {
        LiveRoomPkModel liveRoomPkModel;
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        int i = 1;
        if (LiveRoomManager.a().p().link_type == 1 && (liveRoomPkModel = LiveRoomManager.a().p().pk) != null) {
            Log.i("==xpm", "setPKData:" + liveRoomPkModel.toString());
            this.K.h(liveRoomPkModel.records);
            this.K.f(liveRoomPkModel.top);
            this.K.g(liveRoomPkModel.target_top);
            long j = 0;
            if (liveRoomPkModel.status == 4) {
                LivePKResultModel livePKResultModel = new LivePKResultModel();
                livePKResultModel.countdown = liveRoomPkModel.countdown;
                livePKResultModel.type = liveRoomPkModel.type;
                livePKResultModel.winner = liveRoomPkModel.winner;
                livePKResultModel.records = liveRoomPkModel.records;
                livePKResultModel.pk_type = liveRoomPkModel.pk_type;
                this.K.a(livePKResultModel);
                if (liveRoomPkModel.pk_type == 1) {
                    c(liveRoomPkModel.records);
                }
            } else {
                LiveFriendModel liveFriendModel = new LiveFriendModel();
                liveFriendModel.countdown = liveRoomPkModel.countdown;
                liveFriendModel.count = liveRoomPkModel.count;
                liveFriendModel.delay = liveRoomPkModel.delay;
                liveFriendModel.lid = String.valueOf(liveRoomPkModel.lid);
                liveFriendModel.uid = liveRoomPkModel.uid;
                liveFriendModel.records = liveRoomPkModel.records;
                liveFriendModel.first_kill_message = liveRoomPkModel.first_kill_message;
                a(liveFriendModel);
                if (liveFriendModel.delay <= 0) {
                    if (liveRoomPkModel.pk_type == 0) {
                        b(liveFriendModel);
                    } else if (liveRoomPkModel.pk_type == 1) {
                        LivePkRoundModel livePkRoundModel = new LivePkRoundModel();
                        livePkRoundModel.count = liveRoomPkModel.count;
                        livePkRoundModel.countdown = liveRoomPkModel.countdown;
                        livePkRoundModel.pk_status = liveRoomPkModel.pk_status;
                        livePkRoundModel.records = liveRoomPkModel.records;
                        if (livePkRoundModel.pk_status) {
                            c(livePkRoundModel);
                            b(livePkRoundModel);
                        } else {
                            a(livePkRoundModel);
                        }
                    }
                }
            }
            LivePKProgressModel livePKProgressModel = new LivePKProgressModel();
            livePKProgressModel.top = LiveRoomManager.a().p().pk.top;
            livePKProgressModel.target_top = LiveRoomManager.a().p().pk.target_top;
            int i2 = 2;
            int i3 = 0;
            if (LiveRoomManager.a().p().pk.winner == 0) {
                i = 0;
                i2 = 0;
            } else if (LiveRoomManager.a().p().pk.winner == LiveRoomManager.a().f()) {
                i2 = 1;
            } else {
                i = 2;
            }
            LivePKPlayerModel livePKPlayerModel = null;
            if (LiveRoomManager.a().p().pk.records != null) {
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                livePKPlayerModel = null;
                for (LivePKPlayerModel livePKPlayerModel2 : LiveRoomManager.a().p().pk.records) {
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
                LivePKPlusModel livePKPlusModel = new LivePKPlusModel();
                livePKPlusModel.leftWinNum = i3;
                livePKPlusModel.rightWinNum = i4;
                livePKPlusModel.result = i2;
                livePKPlusModel.otherUid = j;
                livePKPlusModel.target_streak = i5;
                livePKPlusModel.total_beans = i6;
                livePKPlusModel.target_beans = i7;
                this.bl.setResult(livePKPlusModel);
                this.bl.setOtherLid(LiveRoomManager.a().p().pk.lid);
            }
            j(LiveRoomManager.a().p().pk.records);
            this.bi.a(String.valueOf(LiveRoomManager.a().p().pk.lid), i, livePKProgressModel, livePKPlayerModel);
            a(LiveRoomManager.a().p().pk.buff_countdown);
        }
    }

    public void aU() {
        LiveInviteUpdateModel liveInviteUpdateModel;
        LiveInviteUserModel liveInviteUserModel;
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        if (LiveRoomManager.a().p().link_type == 5) {
            LiveInviteUpdateModel liveInviteUpdateModel2 = LiveRoomManager.a().p().link_multi_line;
            if (liveInviteUpdateModel2 == null || liveInviteUpdateModel2.users == null) {
                return;
            }
            for (LiveInviteUserModel liveInviteUserModel2 : liveInviteUpdateModel2.users) {
                if (liveInviteUserModel2 != null) {
                    liveInviteUserModel2.status = 0;
                }
            }
            d(liveInviteUpdateModel2.users);
        } else if ((LiveRoomManager.a().p().link_type == 7 || LiveRoomManager.a().p().link_type == 8) && (liveInviteUpdateModel = LiveRoomManager.a().p().multi_pk_info) != null && liveInviteUpdateModel.users != null) {
            d(liveInviteUpdateModel.users);
            if (liveInviteUpdateModel.users.size() > 0 && (liveInviteUserModel = liveInviteUpdateModel.users.get(0)) != null) {
                liveInviteUserModel.first_kill_message = liveInviteUpdateModel.first_kill_message;
                if (liveInviteUpdateModel.mvp != null) {
                    liveInviteUserModel.mvp_uid = liveInviteUpdateModel.mvp.uid;
                    liveInviteUserModel.mvp_name = liveInviteUpdateModel.mvp.name;
                    liveInviteUserModel.mvp_avatar = liveInviteUpdateModel.mvp.avatar;
                    liveInviteUserModel.mvp_hide = liveInviteUpdateModel.mvp.hide == 1;
                }
            }
            e(liveInviteUpdateModel.users);
            if (liveInviteUpdateModel.users.size() <= 0 || liveInviteUpdateModel.users.get(0).buff_remain_time <= 0) {
                return;
            }
            a(liveInviteUpdateModel.users.get(0).buff_remain_time);
        }
    }

    public void aV() {
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

    public void aW() {
        LiveNobleModel liveNobleModel = new LiveNobleModel();
        liveNobleModel.setCan_mute(LiveRoomManager.a().p().can_mute);
        liveNobleModel.setCan_kick(LiveRoomManager.a().p().can_kick);
        liveNobleModel.setNameplate_img(LiveRoomManager.a().p().nameplate_img);
        liveNobleModel.setNameplate_img_width(Integer.valueOf(LiveRoomManager.a().p().nameplate_img_width));
        liveNobleModel.setNameplate_img_height(Integer.valueOf(LiveRoomManager.a().p().nameplate_img_height));
        liveNobleModel.setNoble_join_text(LiveRoomManager.a().p().noble_join_text);
        liveNobleModel.setNoble_level(LiveRoomManager.a().p().noble_level);
        LiveRoomManager.a().a(liveNobleModel);
    }

    public void aX() {
        this.ca.c();
        this.L.l();
        this.cd.i();
    }

    public void aY() {
        this.ca.b();
        this.L.k();
        this.cd.h();
    }

    public void aZ() {
        Dialog dialog;
        Dialog dialog2;
        LiveRankGuestDialogFragment liveRankGuestDialogFragment = this.ac;
        if (liveRankGuestDialogFragment != null && (dialog2 = liveRankGuestDialogFragment.getDialog()) != null && dialog2.isShowing()) {
            this.ac.dismiss();
        }
        LiveRegularEventRanklistDialogFragment liveRegularEventRanklistDialogFragment = this.ad;
        if (liveRegularEventRanklistDialogFragment != null && (dialog = liveRegularEventRanklistDialogFragment.getDialog()) != null && dialog.isShowing()) {
            this.ad.dismiss();
        }
        PopRankingListView popRankingListView = this.cF;
        if (popRankingListView == null || !popRankingListView.a()) {
            return;
        }
        this.cF.c();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void a_(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null) {
            return;
        }
        this.K.a(liveChattingModel);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void a_(List<LiveFriendModel> list) {
        this.cd.a(list);
    }

    public void aa() {
        this.bY.g();
    }

    public void ab() {
        this.bY.l();
    }

    public void ac() {
        this.bY.m();
    }

    public void ad() {
        this.cd.k();
    }

    public void ae() {
        this.cd.l();
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void af() {
        F();
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void ag() {
        LiveMakeLoverFansModel a = this.bY.a(LiveRoomInfo.a().f());
        if (a == null || a.lamp != 1) {
            return;
        }
        this.bW.d();
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void ah() {
        if (this.bc == null) {
            this.bc = new LiveGuideListManager(this, false);
        }
        this.bc.b();
    }

    public void ai() {
        this.aj.setVisibility(0);
        this.av.setVisibility(0);
        g(true);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void aj() {
        synchronized (this) {
            if (PushGuideObserver.d().a()) {
                return;
            }
            LiveRechargeGiftBagView.a((BaseFragment) this, 1, true, 10020);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void ak() {
        d_(11);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void al() {
        d_(0);
    }

    public void am() {
        if (this.aj.getVisibility() == 0) {
            this.aj.setVisibility(4);
            an();
        }
        this.av.setVisibility(4);
        this.aB.setVisibility(8);
        this.aG.setVisibility(8);
        this.aD.setVisibility(8);
    }

    public void an() {
        Log.i("==record", "getTextureViewB");
        if (getContext() == null) {
            return;
        }
        this.av = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ap.removeAllViews();
        this.ap.addView(this.av, layoutParams);
    }

    public void ao() {
        Log.i("==record", "getTextureViewC");
        if (getContext() == null) {
            return;
        }
        this.aw = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aq.removeAllViews();
        this.aq.addView(this.aw, layoutParams);
    }

    public void ap() {
        Log.i("==record", "getTextureViewD");
        if (getContext() == null) {
            return;
        }
        this.ax = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ar.removeAllViews();
        this.ar.addView(this.ax, layoutParams);
    }

    public void aq() {
        if (getContext() == null) {
            return;
        }
        this.ay = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.as.removeAllViews();
        this.as.addView(this.ay, layoutParams);
    }

    public void ar() {
        if (getContext() == null) {
            return;
        }
        this.az = new TextureView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.at.removeAllViews();
        this.at.addView(this.az, layoutParams);
    }

    public void as() {
        this.aH.setVisibility(8);
    }

    public void at() {
        if (this.ct || this.aQ) {
            return;
        }
        this.ct = true;
        Context context = this.E;
        CommonAlertDialog.a(context, null, "", context.getString(R.string.invited_you_connect), this.E.getString(R.string.reject), this.E.getString(R.string.accept), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.28
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (PlayingOnliveFragment.this.L != null) {
                    if (PlayingOnliveFragment.this.x) {
                        PlayingOnliveFragment.this.getActivity().setRequestedOrientation(1);
                    }
                    AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.28.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PlayingOnliveFragment.this.L.a(PlayingOnliveFragment.this.s, PlayingOnliveFragment.this.t, 1);
                        }
                    }, 500L);
                    PlayingOnliveFragment.this.cu = false;
                }
                PlayingOnliveFragment.this.ct = false;
            }
        }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.29
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (PlayingOnliveFragment.this.L != null) {
                    PlayingOnliveFragment.this.L.a(PlayingOnliveFragment.this.s, PlayingOnliveFragment.this.t, 2);
                    PlayingOnliveFragment.this.cu = true;
                }
                PlayingOnliveFragment.this.ct = false;
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.30
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PlayingOnliveFragment.this.ct = false;
            }
        }, false, false);
    }

    public void au() {
        Context context = this.E;
        CommonAlertDialog.a(context, "", context.getString(R.string.close_current_connection), (String) null, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.31
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                PlayingOnliveFragment.this.h(true);
            }
        }, this.E.getString(R.string.filter_off), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void av() {
        Context context = this.E;
        CommonAlertDialog.a(context, null, "", context.getString(R.string.confirm_exit_from_live_stream), null, null, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.32
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LiveFloatManager.a().n();
                PlayingOnliveFragment.this.T();
            }
        }, null, null, false, false);
    }

    public void aw() {
        if (getContext() == null) {
            return;
        }
        P();
        Q();
        LiveRouteUtil.a(this);
    }

    public boolean ax() {
        return M_() == 2;
    }

    public boolean ay() {
        return M_() == 3;
    }

    public boolean az() {
        return M_() == 4;
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void b(long j) {
        this.J = j;
    }

    public void b(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        super.a(keyboardListenLinearLayout);
    }

    public void b(LiveFriendModel liveFriendModel) {
        if (r()) {
            this.bi.setVsVisable(true);
            bj();
            this.bn.a();
            this.bp.b();
            this.bv.setPKCountDownCallback(new LivePKCountDownView.PKCountDownCallback() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.16
                @Override // com.blued.android.module.live_china.view.LivePKCountDownView.PKCountDownCallback
                public void a() {
                    PlayingOnliveFragment.this.bq.a();
                }
            });
            this.bv.a(liveFriendModel.countdown, false);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void b(final LiveGiftModel liveGiftModel) {
        Logger.a("drb", "gift_pic_apng2 = ", liveGiftModel.images_apng2);
        Logger.a("drb", "gift_pic_url = ", liveGiftModel.images_static);
        Logger.a("drb", "anim_code = ", liveGiftModel.anim_code);
        Logger.a("drb", "gift_pic_gif = ", liveGiftModel.images_gif);
        Logger.a("drb", "gift_pic_mp4 = ", liveGiftModel.images_mp4);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$oFKGsGMScX8h3GtzZdvCuW9WuUM
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveFragment.this.e(liveGiftModel);
            }
        }, a_(liveGiftModel) ? 400L : 0L);
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
                this.K.a(j, livePkRoundModel.records, 1);
            }
            this.K.a(j, livePKPlayerModel);
            j(livePkRoundModel.records);
        }
        i(livePkRoundModel.records);
        this.bv.c();
        this.bv.e();
        if (livePkRoundModel.last) {
            this.bp.a();
        }
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void b(String str) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void b(String str, int i) {
        a(str, i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void b(String str, String str2) {
        if (LiveRoomManager.a().p() != null) {
            EventTrackLive.a(LiveProtos.Event.GUEST_PHOTO_UPLOAD, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        this.bW.a(str, str2);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void b(List<GrabBoxModel> list) {
        LiveSetDataObserver.a().e(list);
    }

    public void b(boolean z) {
        if (z) {
            if (this.aQ) {
                av();
                return;
            } else if (LiveFloatManager.a().A() && LiveRoomManager.a().G()) {
                LiveFloatManager.a().a(this.J, this.aX);
            } else {
                LiveFloatManager.a().n();
            }
        }
        if (this.S.getVisibility() == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.cs;
            PlayingOnlineManager playingOnlineManager = this.K;
            if (playingOnlineManager != null) {
                playingOnlineManager.a((currentTimeMillis - j) / 1000);
            }
        }
        if (r()) {
            int currentTimeMillis2 = (int) ((System.currentTimeMillis() - this.cK) / 1000);
            Log.i("===ppp", "destroy time:" + currentTimeMillis2);
            EventTrackLive.c(LiveProtos.Event.LIVE_PK_AUDIENCE_DURATION, String.valueOf(this.t), this.M, currentTimeMillis2);
        }
        LiveSetDataObserver.a().o();
        LiveListPositionObserver.a().a(this.aX, this.t);
        LiveFloatManager.a().a((PlayingOnliveFragment) null);
        PushGuideObserver.d().b();
        LiveGuideManager liveGuideManager = this.bb;
        if (liveGuideManager != null) {
            liveGuideManager.b();
        }
        LiveGuideListManager liveGuideListManager = this.bc;
        if (liveGuideListManager != null) {
            liveGuideListManager.a();
        }
        LiveRoomManager.a().z();
        LiveFloatManager.a().b(false);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void b(boolean z, int i) {
        this.bY.a(z, i);
    }

    /* renamed from: ba */
    public void bs() {
        if (PushGuideObserver.d().a()) {
            return;
        }
        AppInfo.n().removeCallbacks(this.cz);
        Log.i("==ppp", "showLiveKissDialog 0");
        if (getFragmentActive() == null || !getFragmentActive().isActive()) {
            Log.i("==ppp", "showLiveKissDialog 1");
            return;
        }
        LiveKissDialogFragment liveKissDialogFragment = this.cJ;
        if (liveKissDialogFragment != null && liveKissDialogFragment.isVisible()) {
            Log.i("==ppp", "showLiveKissDialog 2");
        } else if (LiveRoomManager.a().p() == null) {
            Log.i("==ppp", "showLiveKissDialog 3");
        } else {
            LiveOneKissModel liveOneKissModel = LiveRoomManager.a().p().liveOneKissModel;
            if (liveOneKissModel == null) {
                Log.i("==ppp", "showLiveKissDialog 4");
                return;
            }
            String str = liveOneKissModel.animation;
            String d = RecyclingUtils.d(liveOneKissModel.animation);
            QueueFileDownloader.a(new String[]{str}, new String[]{d}, new AnonymousClass43(liveOneKissModel), getFragmentActive(), true);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void bb() {
        if (this.c != null) {
            this.c.a(true, LiveRoomInfo.a().r());
        }
        LiveMsgSendManager.a().a(this.cU);
        if (this.cU) {
            this.cU = false;
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_LIKE_MSG_SEND, String.valueOf(this.t), LiveRoomManager.a().g());
            }
            InstantLog.a("live_first_like_msg_send");
        }
    }

    public int bc() {
        return Math.max(this.cj, AppInfo.m);
    }

    public void bd() {
        LiveOneKissModel liveOneKissModel;
        if (LiveRoomManager.a().p() == null || (liveOneKissModel = LiveRoomManager.a().p().liveOneKissModel) == null) {
            LiveRoomHttpUtils.f(String.valueOf(this.t), new BluedUIHttpResponse<BluedEntityA<LiveOneKissModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.44
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<LiveOneKissModel> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                        Log.i("==ppp", "from 4");
                        return;
                    }
                    Log.i("==ppp", "from 2");
                    if (bluedEntityA.getSingleData().pop == 1) {
                        Log.i("==ppp", "from 3");
                        if (LiveRoomManager.a().p() != null) {
                            LiveRoomManager.a().p().liveOneKissModel = bluedEntityA.getSingleData();
                        }
                        AppInfo.n().postDelayed(PlayingOnliveFragment.this.cz, bluedEntityA.getSingleData().delay * 1000);
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                }
            });
            return;
        }
        Log.i("==ppp", "from 1");
        liveOneKissModel.duration = 0;
        liveOneKissModel.isChargeTo = true;
        bs();
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void c() {
        DialogUtils.b(this.af);
    }

    public void c(LiveFriendModel liveFriendModel) {
        if (aA()) {
            return;
        }
        this.cd.a();
        i("start_make_friend");
        if (liveFriendModel.fans != null) {
            a_(liveFriendModel.fans);
        }
        this.k.c(liveFriendModel.count);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void c(final LiveGiftModel liveGiftModel) {
        LiveAnimationView liveAnimationView = this.Q;
        if (liveAnimationView == null) {
            return;
        }
        if (liveAnimationView.getVisibility() != 0) {
            this.Q.setVisibility(0);
        }
        this.Q.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$j4EugyaRoOEvAjHAL18saIGg6j4
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveFragment.this.d(liveGiftModel);
            }
        });
    }

    public void c(LivePkRoundModel livePkRoundModel) {
        this.bi.setVsVisable(false);
        this.bp.a(livePkRoundModel.count);
        i(livePkRoundModel.records);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    public void c(String str) {
        this.bW.a(str);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void c(String str, int i) {
        e(str);
    }

    public void c(List<LivePKPlayerModel> list) {
        this.bi.setVsVisable(false);
        this.bp.a();
        i(list);
    }

    public void c(boolean z) {
        this.ce.b();
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void d() {
    }

    public void d(LiveFriendModel liveFriendModel) {
        this.cd.a(liveFriendModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void d(String str, int i) {
        PopLiveActivityWebView popLiveActivityWebView = this.cf;
        if (popLiveActivityWebView != null) {
            popLiveActivityWebView.a(str, i);
        }
    }

    public void d(List<LiveInviteUserModel> list) {
        this.ce.a(list);
        LiveSetDataObserver.a().a(list);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void d(boolean z) {
        PlayingRTCManager playingRTCManager = this.L;
        if (playingRTCManager != null) {
            if (z) {
                playingRTCManager.c();
            } else {
                playingRTCManager.d();
            }
        }
    }

    public void e(String str) {
        j(str);
    }

    public void e(List<LiveInviteUserModel> list) {
        this.ce.b(list);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void e(boolean z) {
        this.aU.setDragEnable(z);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    /* renamed from: f */
    public void j(String str) {
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
        if (this.cf != null && !TextUtils.isEmpty(str2)) {
            LiveSetDataObserver.a().s();
            this.cf.b(str2, 0);
        }
        LiveEventBus.get("live_user_card_dismiss").post("");
    }

    public void f(List<LiveInviteUserModel> list) {
        this.ce.c(list);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void f(boolean z) {
        if (LiveRoomManager.a().V()) {
            if (z) {
                this.bi.c();
            } else {
                this.bi.d();
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    public void g(int i) {
        LiveSetDataObserver.a().b(i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void g(String str) {
        a(str, true, 0);
    }

    public void g(List<LiveInviteUserModel> list) {
        this.ce.d(list);
    }

    public void g(boolean z) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (z) {
            if (this.Y == 1) {
                layoutParams.width = DensityUtils.a(this.E, 105.0f);
                layoutParams.height = DensityUtils.a(this.E, 157.0f);
            } else {
                layoutParams.width = DensityUtils.a(this.E, 105.0f);
                layoutParams.height = DensityUtils.a(this.E, 187.0f);
            }
            layoutParams.bottomMargin = DensityUtils.a(this.E, 64.0f);
        } else {
            int i = this.cC;
            if (i == 2) {
                layoutParams.width = DensityUtils.a(this.E, 105.0f);
                layoutParams.height = DensityUtils.a(this.E, 187.0f);
                layoutParams.rightMargin = DensityUtils.a(this.E, 60.0f);
                layoutParams.bottomMargin = DensityUtils.a(this.E, 35.0f);
            } else if (i == 1) {
                layoutParams.width = DensityUtils.a(this.E, 105.0f);
                layoutParams.height = DensityUtils.a(this.E, 187.0f);
                layoutParams.bottomMargin = (AppInfo.m - DensityUtils.a(this.E, 120.0f)) - DensityUtils.a(this.E, 187.0f);
                layoutParams.rightMargin = DensityUtils.a(this.E, 30.0f);
            } else {
                layoutParams.width = DensityUtils.a(this.E, 105.0f);
                layoutParams.height = DensityUtils.a(this.E, 187.0f);
                layoutParams.bottomMargin = DensityUtils.a(this.E, 64.0f);
            }
        }
        layoutParams.gravity = 85;
        this.aG.setLayoutParams(layoutParams);
        this.aG.setVisibility(0);
        this.aG.setOnClickListener(this);
        this.aG.setClickable(true);
    }

    public void h() {
        long j = LiveRoomManager.a().p().dynamic_goods_icon_countdown;
        if (j <= 0) {
            return;
        }
        CountDownTimer countDownTimer = this.cO;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(j * 1000, 1000L) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveSetDataObserver.a().D();
                PlayingOnliveFragment.this.bf();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }
        };
        this.cO = countDownTimer2;
        countDownTimer2.start();
    }

    public void h(int i) {
        LiveSetDataObserver.a().b(i);
        if (this.ab) {
            BarrageViewMultiOneRow barrageViewMultiOneRow = (BarrageViewMultiOneRow) this.b.findViewById(R.id.multi_barrage);
            if (barrageViewMultiOneRow != null) {
                barrageViewMultiOneRow.setVisibility(8);
                return;
            }
            return;
        }
        BarrageViewMultiOneRow barrageViewMultiOneRow2 = (BarrageViewMultiOneRow) this.b.findViewById(R.id.multi_barrage);
        if (barrageViewMultiOneRow2 != null) {
            barrageViewMultiOneRow2.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void h(String str) {
        LiveGuideListManager liveGuideListManager = this.bc;
        if (liveGuideListManager != null) {
            liveGuideListManager.a(str);
        }
    }

    public void h(List<LiveMakeLoverFansModel> list) {
        this.bY.b(list);
    }

    public void h(boolean z) {
        PlayingRTCManager playingRTCManager = this.L;
        if (playingRTCManager != null) {
            playingRTCManager.h();
            if (z) {
                this.L.e();
            }
        }
        am();
        V();
    }

    public void i() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.15
            @Override // java.lang.Runnable
            public void run() {
                if (LiveRoomManager.a().p() != null) {
                    LiveRoomData p = LiveRoomManager.a().p();
                    int currentTimeMillis = (int) ((System.currentTimeMillis() - PlayingOnliveFragment.this.cK) / 1000);
                    Log.i("===ppp", "stopPK time:" + currentTimeMillis);
                    EventTrackLive.c(LiveProtos.Event.LIVE_PK_AUDIENCE_DURATION, String.valueOf(p.lid), LiveRoomManager.a().g(), currentTimeMillis);
                }
                PlayingOnliveFragment.this.bf.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                PlayingOnliveFragment.this.bg.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                LiveFloatManager.a().a(AppInfo.l, PlayingOnliveFragment.this.bc());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                PlayingOnliveFragment.this.N.setLayoutParams(layoutParams);
                PlayingOnliveFragment.this.bt.setVisibility(8);
                PlayingOnliveFragment.this.bh.setVisibility(8);
                if (PlayingOnliveFragment.this.cG != null && PlayingOnliveFragment.this.cG.a()) {
                    PlayingOnliveFragment.this.cG.b();
                }
                PlayingOnliveFragment.this.bv.setVisibility(8);
                PlayingOnliveFragment.this.w();
                PlayingOnliveFragment.this.N_();
                PlayingOnliveFragment.this.aG.setVisibility(8);
                PlayingOnliveFragment.this.bv.b();
                PlayingOnliveFragment.this.bv.setVisibility(8);
                PlayingOnliveFragment.this.bw.setVisibility(8);
                PlayingOnliveFragment.this.bu.setVisibility(8);
                LiveSetDataObserver.a().e();
                LiveRoomManager.a().P();
                PlayingOnliveFragment.this.bj.a();
                PlayingOnliveFragment.this.bi.a();
                PlayingOnliveFragment.this.bi.setVisibility(8);
                PlayingOnliveFragment.this.bl.a();
                PlayingOnliveFragment.this.bo.a();
                PlayingOnliveFragment.this.bq.b();
                PlayingOnliveFragment.this.bm.a();
                PlayingOnliveFragment.this.bp.b();
                PlayingOnliveFragment.this.bn.a();
                PlayingOnliveFragment.this.bk.a();
                PlayingOnliveFragment.this.d_(0);
            }
        }, 500L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
        if (r4 != 4) goto L10;
     */
    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i(int r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L32
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L28
            r0 = r4
            r1 = 3
            if (r0 == r1) goto L17
            r0 = r4
            r1 = 4
            if (r0 == r1) goto L1e
            goto L36
        L17:
            java.lang.String r0 = "SWITCH_MODEL.SIMPLE"
            int r0 = com.blued.android.framework.utils.LogUtils.c(r0)
        L1e:
            java.lang.String r0 = "SWITCH_MODEL.CLEAR"
            int r0 = com.blued.android.framework.utils.LogUtils.c(r0)
            goto L36
        L28:
            java.lang.String r0 = "SWITCH_MODEL.HORIZONTAL"
            int r0 = com.blued.android.framework.utils.LogUtils.c(r0)
            goto L36
        L32:
            r0 = r3
            r0.W()
        L36:
            r0 = r3
            r1 = r4
            r0.cC = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.i(int):void");
    }

    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LogUtils.c("setLiveActivityEvent: " + str);
        if ("gift_rank_hide".equalsIgnoreCase(str)) {
            this.cT = false;
        } else if ("gift_rank_show".equalsIgnoreCase(str)) {
            this.cT = true;
        }
        if ("gift_show".equalsIgnoreCase(str)) {
            this.cP = true;
            this.cQ = false;
        } else if ("gift_hide".equalsIgnoreCase(str)) {
            this.cP = false;
            this.cQ = false;
        } else if ("gift_info_show".equalsIgnoreCase(str) || "gift_banner".equalsIgnoreCase(str)) {
            this.cQ = true;
            this.cP = true;
        } else if ("pay_dlg_show".equalsIgnoreCase(str)) {
            this.cR = true;
        } else if ("pay_dlg_hide".equalsIgnoreCase(str)) {
            this.cR = false;
        } else if ("start_make_friend".equalsIgnoreCase(str)) {
            this.cS = true;
        } else if ("stop_make_friend".equalsIgnoreCase(str)) {
            this.cS = false;
        }
        if (!this.cQ) {
            if ((this.cP || this.cR) && LiveRoomManager.a().p().custom_rank != null) {
                TypeUtils.a((List<?>) LiveRoomManager.a().p().custom_rank.rank_info);
            }
        } else if ("gift_banner".equalsIgnoreCase(str)) {
            DisplayUtil.b(AppInfo.d(), (getActivity().getWindowManager().getDefaultDisplay().getWidth() * 76.0f) / 375.0f);
        } else if (LiveRoomManager.a().p().custom_rank != null) {
            TypeUtils.a((List<?>) LiveRoomManager.a().p().custom_rank.rank_info);
        }
    }

    public void i(boolean z) {
        LiveGiftFragment liveGiftFragment = this.cw;
        if (liveGiftFragment != null) {
            liveGiftFragment.b(z);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void j(int i) {
        this.bW.c();
        LiveMakeLoverFansModel a = this.bY.a(i);
        if (a == null || a.isEmpty()) {
            return;
        }
        if (LiveRoomManager.a().p() != null) {
            EventTrackLive.d(LiveProtos.Event.USER_MIKE_USER_PHOTO_DOUBLE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), a.uid);
        }
        String str = a.pic;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = a.avatar;
        }
        if (TextUtils.isEmpty(str2)) {
            Log.i("==makelover==", "photo is empty");
            return;
        }
        LivePictureFragment livePictureFragment = new LivePictureFragment();
        livePictureFragment.a(new LiveBaseDialogFragment.IDialogEvent() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.27
            @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment.IDialogEvent
            public void a() {
                PlayingOnliveFragment.this.t();
            }

            @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment.IDialogEvent
            public void a(Object obj) {
            }
        });
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("picture_url_list", arrayList);
        livePictureFragment.setArguments(bundle);
        livePictureFragment.show(getFragmentManager(), "see_picture");
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void j(boolean z) {
        b(z);
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        boolean z;
        if (cv) {
            LiveGiftPayTools.a();
            final DialogWith6PW dialogWith6PW = LiveGiftPayTools.b;
            if (i != -3) {
                if (i != -2) {
                    return;
                }
                Logger.a("drb", "隐藏键盘");
                aa = false;
                aP();
                postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.33
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveSetDataObserver.a().a(8);
                    }
                });
                LiveKissDialogFragment liveKissDialogFragment = this.cJ;
                if (liveKissDialogFragment != null && liveKissDialogFragment.isVisible()) {
                    this.cJ.e();
                }
                if (this.m == null || !this.m.a()) {
                    return;
                }
                g_(0);
                return;
            }
            Logger.a("drb", "显示键盘");
            aa = true;
            if (dialogWith6PW == null || dialogWith6PW.a == null || !dialogWith6PW.a.isShowing()) {
                AlertDialog alertDialog = this.cx;
                z = alertDialog == null || !alertDialog.isShowing();
            } else {
                z = false;
                if (this.x) {
                    z = false;
                    if (dialogWith6PW.e != null) {
                        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.34
                            @Override // java.lang.Runnable
                            public void run() {
                                dialogWith6PW.e.fullScroll(130);
                            }
                        }, 500L);
                        z = false;
                    }
                }
            }
            if (z) {
                postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.35
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveSetDataObserver.a().a(0);
                    }
                });
            }
            LiveSetDataObserver.a().d(8);
            aO();
            LiveSetDataObserver.a().c(!z);
            LiveKissDialogFragment liveKissDialogFragment2 = this.cJ;
            if (liveKissDialogFragment2 != null && liveKissDialogFragment2.isVisible()) {
                this.cJ.d();
            }
            g_(8);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void k(int i) {
        if (aE()) {
            LiveRoomInfo.a().a(this.E, 5);
            b(true);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void l() {
        super.l();
        this.E = getActivity();
        LiveRankGuestDialogFragment.e = 0;
        LiveFloatManager.a().a(this);
        LiveDataManager.a().b();
        LiveRoomData liveRoomData = (LiveRoomData) this.r.getSerializable("live_anchor_model");
        this.aW = this.r.getBoolean("live_window", false);
        int i = this.r.getInt("live_prop", 0);
        this.aY = i;
        liveRoomData.liveProp = i;
        LiveRoomManager.a().a(liveRoomData);
        this.t = liveRoomData.lid;
        this.X = liveRoomData.comeCode;
        this.cl = liveRoomData.liveFrom;
        this.ck = liveRoomData.liveFrom;
        this.cm = liveRoomData.livePosition;
        if (!TextUtils.isEmpty(liveRoomData.details)) {
            this.cL = liveRoomData.details;
        }
        if (TextUtils.equals(this.X, "two_floor_nearby") || TextUtils.equals(this.X, "two_floor_live")) {
            this.Z = true;
        } else {
            this.Z = false;
        }
        int i2 = liveRoomData.screen_pattern;
        this.Y = i2;
        Logger.a("rrrb", "mScreenPattern = ", Integer.valueOf(i2));
        this.aX = this.r.getInt("live_list_position", -1);
        this.U = liveRoomData.profile.avatar;
        this.aV = liveRoomData.hasTransition;
        Logger.a("rrb", "initData mLiveListPosition = ", Integer.valueOf(this.aX));
        Log.v("pk", "mSessionId:" + this.t + " -- uid:" + LiveRoomInfo.a().f());
        LiveRoomConstants.a = 32;
        if (!this.ab && !this.x) {
            LiveOperationManager liveOperationManager = new LiveOperationManager(this, false);
            this.f49cn = liveOperationManager;
            liveOperationManager.c();
        }
        be();
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void l(int i) {
        if (this.x) {
            h(i);
        } else {
            g(i);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void m() {
        super.m();
        ZanRefreshObserver.a().a(this);
        LiveRefreshUIObserver.a().a(this);
        if (this.Z) {
            LiveEventBus.get("live_back_to_two_level").post("");
        }
        bg();
        x();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected void n() {
        super.n();
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$xg0s6MQAyW6VDFgztavO9M_dZK0
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveFragment.this.bv();
            }
        }, 4000L);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 10111) {
            this.V = intent.getStringArrayExtra("CHOOSED_UID");
            String[] stringArrayExtra = intent.getStringArrayExtra("CHOOSED_TYPE");
            this.W = stringArrayExtra;
            String[] strArr = this.V;
            if (strArr != null && strArr.length > 0 && stringArrayExtra != null && stringArrayExtra.length > 0) {
                LiveMsgSendManager.a().a(this.t, this.V, this.W, "");
                AppMethods.a((CharSequence) getString(R.string.liveVideo_message_label_hadShare));
            }
        }
        if (i == 100017 && intent != null && aE()) {
            final LiveChargeCouponModel liveChargeCouponModel = (LiveChargeCouponModel) intent.getSerializableExtra("coupon_model");
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$2DMe9_ljuZ6aolxnRjr5_DEyODE
                @Override // java.lang.Runnable
                public final void run() {
                    PlayingOnliveFragment.this.a(liveChargeCouponModel);
                }
            }, 500L);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.by.c()) {
            this.by.a();
            return true;
        } else if (this.aQ) {
            if (aB()) {
                E();
                return true;
            } else if (aD()) {
                G();
                return true;
            } else {
                av();
                return true;
            }
        } else if (this.cf.e()) {
            this.cf.f();
            return true;
        } else {
            LiveGiftFragment liveGiftFragment = this.cw;
            if (liveGiftFragment != null && liveGiftFragment.isActive() && this.cw.isAdded() && !this.cw.isHidden() && this.cw.onBackPressed()) {
                return true;
            }
            if (this.k.a()) {
                AppMethods.d(R.string.live_make_friend_cancel_application);
                return true;
            } else if (LiveMakeLoverManager.b()) {
                AppMethods.d(R.string.live_make_lover_cancel_application);
                return true;
            } else {
                PopRankingListView popRankingListView = this.cF;
                if (popRankingListView == null || !popRankingListView.a()) {
                    b(true);
                    return false;
                }
                this.cF.c();
                return true;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_like_view) {
            if (this.c != null) {
                this.c.a(true, LiveRoomInfo.a().r());
            }
            LiveMsgSendManager.a().a(false);
        } else if (view.getId() == R.id.live_msg_send_emotion) {
            O_();
        } else if (view.getId() == R.id.rank_showing) {
            J();
        } else if (view.getId() == R.id.out_userA_btn) {
            au();
        } else if (view.getId() == R.id.out_userB_btn) {
            Logger.a("drb", "out_userB_btn");
            au();
        } else if (view.getId() == R.id.float_window_view) {
            b(true);
        } else if (view.getId() != R.id.WindowB_click_view) {
            if (view.getId() == R.id.reconnect_btn) {
                LiveFloatManager.a().e();
            }
        } else if (!ax()) {
            if (this.K.b == Long.valueOf(LiveRoomInfo.a().f()).longValue() && !LiveRoomManager.a().t()) {
                LiveSetDataObserver.a().e(LiveRoomManager.a().g());
                return;
            }
            LiveSetDataObserver.a().e(String.valueOf(this.K.b));
            InstantLog.a("live_connect_area_click");
        } else if (this.K.b == CommonStringUtils.c(LiveRoomInfo.a().f()) && !LiveRoomManager.a().t()) {
            LiveSetDataObserver.a().e(LiveRoomManager.a().g());
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(LiveRoomManager.a().g());
            arrayList.add(String.valueOf(this.K.b));
            LiveRoomManager.a().a(arrayList);
            LiveSetDataObserver.a().e(String.valueOf(this.K.b));
            InstantLog.a("live_connect_area_click");
        }
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onClose(final LiveCloseReason liveCloseReason, final LiveChatStatistics liveChatStatistics) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveFragment$_K8mP3lHKRZAQjNswv2v40XMKIg
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveFragment.this.a(liveCloseReason, liveChatStatistics);
            }
        });
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i == 1) {
            this.x = false;
            this.bd.b();
            aK();
        } else if (i == 2) {
            this.x = true;
            this.bd.a();
            aK();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(19);
        Logger.a("drb", "onCreate");
        aa = false;
        if (!this.aV || this.Z) {
            getActivity().overridePendingTransition(0, 0);
        }
        super.onCreate(bundle);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        LiveFloatManager.a().b(false);
        LiveFloatManager.a().b.setVisibility(0);
        LiveMsgSendManager.a().b(this.s, this.t, this);
        PlayingMakeLoverManager playingMakeLoverManager = this.bY;
        if (playingMakeLoverManager != null) {
            playingMakeLoverManager.k();
        }
        CountDownTimer countDownTimer = this.cN;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.cO;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        PlayingMakeFriendManager playingMakeFriendManager = this.cd;
        if (playingMakeFriendManager != null) {
            playingMakeFriendManager.j();
        }
        if (this.L != null && !this.x) {
            this.L.g();
        }
        LiveGuideManager liveGuideManager = this.bb;
        if (liveGuideManager != null) {
            liveGuideManager.b();
        }
        LiveGuideListManager liveGuideListManager = this.bc;
        if (liveGuideListManager != null) {
            liveGuideListManager.a();
        }
        PopRankingListView popRankingListView = this.cF;
        if (popRankingListView != null) {
            popRankingListView.b();
        }
        ZanRefreshObserver.a().b(this);
        LiveRefreshUIObserver.a().b(this);
        FrameLayout frameLayout = this.N;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        LivePlayExitTipManager livePlayExitTipManager = this.ci;
        if (livePlayExitTipManager != null) {
            livePlayExitTipManager.c();
        }
        LivePKCountDownView livePKCountDownView = this.bv;
        if (livePKCountDownView != null) {
            livePKCountDownView.f();
        }
        LivePKProgressView livePKProgressView = this.bh;
        if (livePKProgressView != null) {
            livePKProgressView.a();
        }
        AppInfo.n().removeCallbacks(this.cz);
        Logger.a("rrb", "onDestroy");
        LiveHalfWebDialogFragment liveHalfWebDialogFragment = this.cH;
        if (liveHalfWebDialogFragment != null && liveHalfWebDialogFragment.f()) {
            this.cH.dismissAllowingStateLoss();
        }
        AppInfo.n().removeCallbacks(this.cV);
        LiveEventBus.get(LiveEventBusUtil.C, LiveRoomFunctionItemModel.class).removeObserver(new $$Lambda$vp9O66ly_kNLGZHZsc8Knor7gPc(this));
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
        this.aR = false;
        LiveFloatManager.a().c(false);
        LiveFloatManager.a().b(false);
        this.K.g();
        LiveRankGuestDialogFragment liveRankGuestDialogFragment = this.ac;
        if (liveRankGuestDialogFragment != null && (dialog6 = liveRankGuestDialogFragment.getDialog()) != null && dialog6.isShowing()) {
            this.ac.dismiss();
        }
        LiveRegularEventRanklistDialogFragment liveRegularEventRanklistDialogFragment = this.ad;
        if (liveRegularEventRanklistDialogFragment != null && (dialog5 = liveRegularEventRanklistDialogFragment.getDialog()) != null && dialog5.isShowing()) {
            this.ad.dismiss();
        }
        LiveFansGuestDialogFragment liveFansGuestDialogFragment = this.ae;
        if (liveFansGuestDialogFragment != null && (dialog4 = liveFansGuestDialogFragment.getDialog()) != null && dialog4.isShowing()) {
            this.ae.dismiss();
        }
        LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bZ;
        if (liveMakeLoverDialogFragment != null && (dialog3 = liveMakeLoverDialogFragment.getDialog()) != null && dialog3.isShowing()) {
            this.bZ.dismiss();
        }
        if (this.l != null && (dialog2 = this.l.getDialog()) != null && dialog2.isShowing()) {
            this.l.dismiss();
        }
        LiveKissDialogFragment liveKissDialogFragment = this.cJ;
        if (liveKissDialogFragment != null && (dialog = liveKissDialogFragment.getDialog()) != null && dialog.isShowing()) {
            this.cJ.dismiss();
        }
        if (this.L != null && !this.x) {
            this.L.a = true;
        }
        Logger.a("drb", "onPause");
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onRecvNewMsg(ChattingModel chattingModel) {
        LiveEventBusUtil.a(LiveChattingModel.copy(chattingModel), false);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        this.aR = true;
        LiveFloatManager.a().c(true);
        int i = this.E.getResources().getConfiguration().orientation;
        if (LiveFloatManager.a().B() && i == 2) {
            Logger.a("drb", "onResume setRequestedOrientation");
            getActivity().setRequestedOrientation(1);
            return;
        }
        LiveSetDataObserver.a().d(0);
        this.K.f();
        if (this.L != null && !this.x) {
            this.L.a = false;
        }
        LiveFloatManager.a().f();
        if (this.aS) {
            this.aS = false;
            LiveFloatManager.a().g();
        }
        PopLiveActivityWebView popLiveActivityWebView = this.cf;
        if (popLiveActivityWebView != null) {
            popLiveActivityWebView.c();
        }
        Logger.a("drb", "onResume");
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStop() {
        super.onStop();
        if (!this.x) {
            this.cd.g();
            this.bY.j();
            if (az()) {
                h(true);
            }
        }
        LivePlayExitTipManager livePlayExitTipManager = this.ci;
        if (livePlayExitTipManager != null) {
            livePlayExitTipManager.a();
        }
        Logger.a("drb", "onStop");
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment, com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.af = DialogUtils.a((Context) getActivity());
        LiveModePagerAdapter liveModePagerAdapter = new LiveModePagerAdapter(getChildFragmentManager(), this);
        this.aP = liveModePagerAdapter;
        this.aO.setAdapter(liveModePagerAdapter);
        this.aO.setPageMargin(DensityUtils.a(AppInfo.d(), 20.0f));
        this.aO.addOnPageChangeListener(this.cr);
        this.aO.setCurrentItem(1);
        A();
        cB = 1;
        if (TextUtils.isEmpty(this.U)) {
            C();
        } else {
            ImageLoader.a(getFragmentActive(), this.U).b(R.drawable.shape_live_bg).e().d().a(this.F);
        }
        if (this.Y == 1) {
            this.bd.b();
        }
        Logger.a("pk", "mIsLandLayout--" + this.x);
        LiveRoomManager.a().z();
        LiveRoomManager.a().a(true);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveFragment.8
            @Override // java.lang.Runnable
            public void run() {
                if (PlayingOnliveFragment.this.t == LiveRoomManager.a().d()) {
                    PlayingOnlineManager.a(PlayingOnliveFragment.this.getFragmentActive(), PlayingOnliveFragment.this.t);
                }
            }
        }, 500L);
        LiveGiftManager.a().a(false);
        if (!LivePreferencesUtils.f() && TextUtils.equals(this.X, "nearby_mix_recommend")) {
            if (!LiveRoomManager.a().t()) {
                EventTrackLive.f(LiveProtos.Event.LIVE_SLIDE, LiveRoomManager.a().e(), LiveRoomManager.a().g(), LiveRoomManager.a().p().comeCode);
            }
            LiveRouteUtil.a(this, 2);
        }
        bm();
        bn();
        AppInfo.n().postDelayed(this.cV, 10000L);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected boolean p() {
        return (this.ab || this.cC == 4) ? false : true;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.ILiveGuestDialog
    public void r_() {
        bk();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment.ILiveGuestDialog
    public void s_() {
        bl();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveFansGuestDialogFragment.ILiveFansGuestDialog
    public void t_() {
        bk();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveFansGuestDialogFragment.ILiveFansGuestDialog
    public void u_() {
        bl();
    }

    public void w() {
        this.cD.clearAnimation();
        this.cD.setVisibility(8);
    }

    public void x() {
        this.cd = new PlayingMakeFriendManager(this);
        this.bY = new PlayingMakeLoverManager(this);
        this.bd = new PlayingScreenManager(this);
        this.K = new PlayingOnlineManager(this, this.aW, this.s, this.t, this.X, this.Y, this.N, this.U, this.aY);
        this.ce = new PlayingMultiConnectionManager(this);
        LiveMsgSendManager.a().a(this.t);
        LiveMsgSendManager.a().a(this.s, this.t, this);
        this.L = new PlayingRTCManager(this, this.ah);
        this.ci = new LivePlayExitTipManager();
    }

    @Override // com.blued.android.module.live_china.observer.LiveRefreshUIObserver.ILiveRefreshUIObserver
    public void y() {
        LiveGuideManager liveGuideManager = this.bb;
        if (liveGuideManager != null) {
            liveGuideManager.a();
        }
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseFragment
    protected int y_() {
        return R.layout.fragment_play_onlive;
    }

    public boolean z() {
        PKDoubleAnimView pKDoubleAnimView = this.cD;
        return pKDoubleAnimView != null && pKDoubleAnimView.getVisibility() == 0;
    }
}
