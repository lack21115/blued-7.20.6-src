package com.blued.android.module.yy_china.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.BluedMarqueeTextView;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.BlackMusicListener;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.TrtcAudioFrameModel;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.live.base.utils.LiveSettingConfig;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.NotificationService;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.BaseConnectingAdapter;
import com.blued.android.module.yy_china.adapter.YYConnectingAdapter;
import com.blued.android.module.yy_china.adapter.YYConnectingGameAdapter;
import com.blued.android.module.yy_china.adapter.YYRobMusicAdapter;
import com.blued.android.module.yy_china.adapter.YYSeatCPWithVipAdapter;
import com.blued.android.module.yy_china.adapter.YYSeatEntertainmentAdapter;
import com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter;
import com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter;
import com.blued.android.module.yy_china.adapter.YYSeatSoloAdapter;
import com.blued.android.module.yy_china.manager.YYGiftAnimManager;
import com.blued.android.module.yy_china.manager.YYHostUpAnimManager;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYMountAnimManager;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.ClientSendMessTaskModel;
import com.blued.android.module.yy_china.model.ClientSendMessTaskNewModel;
import com.blued.android.module.yy_china.model.ConfessedIMMode;
import com.blued.android.module.yy_china.model.IMJsonContents109Model;
import com.blued.android.module.yy_china.model.YYBorImJsonMode;
import com.blued.android.module.yy_china.model.YYDailyTaskModel;
import com.blued.android.module.yy_china.model.YYFirstMeetMode;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYHeartModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYJoinRoomJumpInfoMode;
import com.blued.android.module.yy_china.model.YYKtvStageModel;
import com.blued.android.module.yy_china.model.YYMsgKickInfoExtra;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYMusicMode;
import com.blued.android.module.yy_china.model.YYPerFirstGiftModel;
import com.blued.android.module.yy_china.model.YYRetryRoomModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.trtc.TRTCSendLeaveMsg;
import com.blued.android.module.yy_china.model.trtc.TRTCSendLrcMsg;
import com.blued.android.module.yy_china.model.trtc.TRTCSendPKMicrophoneStatusMsg;
import com.blued.android.module.yy_china.model.trtc.TRTCSendPKMuteMsg;
import com.blued.android.module.yy_china.presenter.AbstractBasePresenter;
import com.blued.android.module.yy_china.presenter.YYCPPresenter;
import com.blued.android.module.yy_china.presenter.YYEntertainmentPresenter;
import com.blued.android.module.yy_china.presenter.YYGamePresenter;
import com.blued.android.module.yy_china.presenter.YYKtvPresenter;
import com.blued.android.module.yy_china.presenter.YYRobMusicPresenter;
import com.blued.android.module.yy_china.presenter.YYSalePresenter;
import com.blued.android.module.yy_china.presenter.YYSoloPresenter;
import com.blued.android.module.yy_china.presenter.YYTalkPresenter;
import com.blued.android.module.yy_china.trtc_audio.IAudioContract;
import com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.GenerateTestUserSig;
import com.blued.android.module.yy_china.trtc_audio.model.TrtcSongScoreModel;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.AudienceUserCardView;
import com.blued.android.module.yy_china.view.ClickOneGiftSendView;
import com.blued.android.module.yy_china.view.GiftBaseHitView;
import com.blued.android.module.yy_china.view.GiftTomicItemModeView;
import com.blued.android.module.yy_china.view.MarqueeTextImagesView;
import com.blued.android.module.yy_china.view.PopYyDialog;
import com.blued.android.module.yy_china.view.PopYyDialogGetView;
import com.blued.android.module.yy_china.view.RoomMemberListView;
import com.blued.android.module.yy_china.view.SeatUserCardView;
import com.blued.android.module.yy_china.view.TopicListDialog;
import com.blued.android.module.yy_china.view.WaitingListView;
import com.blued.android.module.yy_china.view.YYBackgroundView;
import com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment;
import com.blued.android.module.yy_china.view.YYBottomView;
import com.blued.android.module.yy_china.view.YYCardOptionView;
import com.blued.android.module.yy_china.view.YYConfessedRoomView;
import com.blued.android.module.yy_china.view.YYExplorationView;
import com.blued.android.module.yy_china.view.YYFloatVoteView;
import com.blued.android.module.yy_china.view.YYGameView;
import com.blued.android.module.yy_china.view.YYGoldListView;
import com.blued.android.module.yy_china.view.YYHolidayActivities;
import com.blued.android.module.yy_china.view.YYImListView;
import com.blued.android.module.yy_china.view.YYKtvNoticeTypeMess;
import com.blued.android.module.yy_china.view.YYMagicalBoxView;
import com.blued.android.module.yy_china.view.YYMusicFloatView;
import com.blued.android.module.yy_china.view.YYPKBoardViewNew;
import com.blued.android.module.yy_china.view.YYPeyPayBackGiftView;
import com.blued.android.module.yy_china.view.YYPkTimerView;
import com.blued.android.module.yy_china.view.YYRedPackageView;
import com.blued.android.module.yy_china.view.YYRelationShipInfoDialog;
import com.blued.android.module.yy_china.view.YYRelationshipListView;
import com.blued.android.module.yy_china.view.YYRenameView;
import com.blued.android.module.yy_china.view.YYRobMusicProgressBtnView;
import com.blued.android.module.yy_china.view.YYRobMusicRoomVIew;
import com.blued.android.module.yy_china.view.YYRoomAdBanner;
import com.blued.android.module.yy_china.view.YYRoomFullSvgaAniView;
import com.blued.android.module.yy_china.view.YYRoomFullSvgaMode;
import com.blued.android.module.yy_china.view.YYStudioTitleView;
import com.blued.android.module.yy_china.view.YYTypingDialog;
import com.blued.android.module.yy_china.view.YYUserCardView;
import com.blued.android.module.yy_china.view.YYWishViewPager;
import com.blued.android.module.yy_china.view.YyEntranceEffectLayout;
import com.blued.android.module.yy_china.view.YyFirstMeettingLayout;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.trtc.TRTCCloudDef;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/BaseYYStudioFragment.class */
public abstract class BaseYYStudioFragment extends KeyBoardFragment implements BlackMusicListener, ClientSendMessTaskModel.ClientTaskDataListener, YYBeansPrePayDialogFragment.YYBeansListener {
    public YYWishViewPager A;
    public ShapeLinearLayout B;
    public BluedMarqueeTextView C;
    public YYPKBoardViewNew D;
    public BaseConnectingAdapter E;
    public PopupWindow I;
    public YYMountAnimManager J;
    public YYHostUpAnimManager K;
    public YYRoomAdBanner L;
    public YYRedPackageView M;
    protected TextView N;
    public YYMagicalBoxView O;
    public FrameLayout P;
    public TextView Q;
    public RelativeLayout R;
    public FrameLayout S;
    public ConstraintLayout T;
    public ImageView U;
    public ImageView V;
    public ImageView W;
    public ImageView X;
    public ImageView Y;
    public ImageView Z;
    private YYGiftAnimManager aA;
    private YYRankFragment aB;
    private YYGiftListFragment aC;
    private ImageView aD;
    private YYBackgroundMusicDialog aE;
    public SVGAImageView aa;
    public YYRobMusicRoomVIew ab;
    public SVGAImageView ac;
    public YYHolidayActivities ad;
    public YYExplorationView ae;
    public YYConfessedRoomView af;
    YYBeansPrePayDialogFragment ag;
    public String ah;
    YYRobMusicProgressBtnView ai;
    private KeyboardListenLinearLayout aj;
    private RelativeLayout ak;
    private GiftBaseHitView al;
    private GiftBaseHitView am;
    private LiveAnimationView an;
    private SVGAImageView ao;
    private LiveAnimationView ap;
    private LiveAnimationView aq;
    private TextView ar;
    private ShapeTextView as;
    private YYFloatVoteView at;
    private YYPkTimerView au;
    private LinearLayout av;
    private AbstractBasePresenter aw;
    private int ax;
    private int ay;
    public Context b;
    public View c;
    public RecyclerView j;
    public FrameLayout k;
    public YYImListView l;
    public ConstraintLayout m;
    protected YYStudioTitleView n;
    protected YYBottomView o;
    public YYMusicFloatView p;
    public YYBackgroundView q;
    protected FrameLayout r;
    public YYGoldListView s;
    public MarqueeTextImagesView t;
    public YYGameView u;
    public YyEntranceEffectLayout v;
    public YyFirstMeettingLayout w;
    public GiftTomicItemModeView x;
    public YYRoomFullSvgaAniView y;
    public ClickOneGiftSendView z;
    private long az = 0;
    public boolean F = false;
    public boolean G = false;
    public boolean H = false;
    private BaseRoomHandler aF = new BaseRoomHandler(this);
    private boolean aG = false;
    private int aH = -1;
    private boolean aI = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/BaseYYStudioFragment$BaseRoomHandler.class */
    public static class BaseRoomHandler extends Handler {
        public WeakReference<BaseYYStudioFragment> a;

        public BaseRoomHandler(BaseYYStudioFragment baseYYStudioFragment) {
            this.a = new WeakReference<>(baseYYStudioFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseYYStudioFragment> weakReference;
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2 || (weakReference = this.a) == null || weakReference.get() == null) {
                    return;
                }
                this.a.get().T();
                return;
            }
            WeakReference<BaseYYStudioFragment> weakReference2 = this.a;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            this.a.get().U();
        }
    }

    private void V() {
        this.aA = new YYGiftAnimManager(this, this.al, this.am, this.an, this.ao);
        this.J = new YYMountAnimManager(this, this.ap, this.ar);
        this.K = new YYHostUpAnimManager(this, this.aq);
        LiveLogUtils.a("BaseYYStudioFragment --> initManager --> init");
    }

    private void W() {
        this.R = (RelativeLayout) this.c.findViewById(R.id.root_layout);
        this.S = (FrameLayout) this.c.findViewById(R.id.fra_add_view_layout);
        final FrameLayout frameLayout = (FrameLayout) this.c.findViewById(R.id.yy_container);
        final ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int height = BaseYYStudioFragment.this.c.getHeight();
                if (height != 0) {
                    BaseYYStudioFragment.this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    layoutParams.height = height;
                    Logger.b("==xpf", "params.height:" + layoutParams.height);
                    frameLayout.setLayoutParams(layoutParams);
                }
            }
        });
        MarqueeTextImagesView marqueeTextImagesView = (MarqueeTextImagesView) this.c.findViewById(R.id.tv_marq);
        this.t = marqueeTextImagesView;
        marqueeTextImagesView.a(getFragmentActive());
        YYStudioTitleView yYStudioTitleView = (YYStudioTitleView) this.c.findViewById(R.id.ll_title_view);
        this.n = yYStudioTitleView;
        yYStudioTitleView.a(this);
        this.N = (TextView) this.n.findViewById(R.id.tv_host_open_time);
        YYMagicalBoxView yYMagicalBoxView = (YYMagicalBoxView) this.c.findViewById(R.id.magical_box);
        this.O = yYMagicalBoxView;
        yYMagicalBoxView.a(this);
        this.P = (FrameLayout) this.c.findViewById(R.id.fl_magical_box_msg);
        this.Q = (TextView) this.c.findViewById(R.id.tv_notice_text);
        YYBottomView yYBottomView = (YYBottomView) this.c.findViewById(R.id.ll_bottom);
        this.o = yYBottomView;
        yYBottomView.a(this, this.F);
        if (YYRoomInfoManager.e().b() != null) {
            YYRoomInfoManager.e().b().clientSendMessTask = ClientSendMessTaskNewModel.Companion.a(this, getFragmentActive());
        }
        YYImListView yYImListView = (YYImListView) this.c.findViewById(R.id.rv_im_list_view);
        this.l = yYImListView;
        yYImListView.a(this);
        YYFloatVoteView yYFloatVoteView = (YYFloatVoteView) this.c.findViewById(R.id.vote_time);
        this.at = yYFloatVoteView;
        yYFloatVoteView.a(this);
        YyEntranceEffectLayout yyEntranceEffectLayout = (YyEntranceEffectLayout) this.c.findViewById(R.id.yy_entras);
        this.v = yyEntranceEffectLayout;
        yyEntranceEffectLayout.a(this);
        YyFirstMeettingLayout yyFirstMeettingLayout = (YyFirstMeettingLayout) this.c.findViewById(R.id.yy_first_meet);
        this.w = yyFirstMeettingLayout;
        yyFirstMeettingLayout.a(this);
        this.x = (GiftTomicItemModeView) this.c.findViewById(R.id.fra_gift_to_mic_layout);
        this.y = (YYRoomFullSvgaAniView) this.c.findViewById(R.id.full_svga_ani);
        ClickOneGiftSendView clickOneGiftSendView = (ClickOneGiftSendView) this.c.findViewById(R.id.one_send_gift);
        this.z = clickOneGiftSendView;
        if (this instanceof PlayingStudioFragment) {
            clickOneGiftSendView.a(this, (IMJsonContents109Model) null);
        }
        YYRedPackageView yYRedPackageView = (YYRedPackageView) this.c.findViewById(R.id.iv_yy_red_envelope);
        this.M = yYRedPackageView;
        yYRedPackageView.a(this);
        this.r = (FrameLayout) this.c.findViewById(R.id.ll_gift_layout);
        YYRoomAdBanner yYRoomAdBanner = (YYRoomAdBanner) this.c.findViewById(R.id.banner_adv);
        this.L = yYRoomAdBanner;
        yYRoomAdBanner.a(this);
        YYPkTimerView yYPkTimerView = (YYPkTimerView) this.c.findViewById(R.id.pk_timer_view);
        this.au = yYPkTimerView;
        yYPkTimerView.a(this);
        YYWishViewPager yYWishViewPager = (YYWishViewPager) this.c.findViewById(R.id.wish_task_view);
        this.A = yYWishViewPager;
        yYWishViewPager.a(this);
        this.B = (ShapeLinearLayout) this.c.findViewById(R.id.ll_topic);
        this.C = (BluedMarqueeTextView) this.c.findViewById(R.id.tv_marr_topic);
        j();
        YYPKBoardViewNew yYPKBoardViewNew = (YYPKBoardViewNew) this.c.findViewById(R.id.room_pk_view);
        this.D = yYPKBoardViewNew;
        yYPKBoardViewNew.a(this);
        this.j = this.c.findViewById(R.id.rv_chatting_list_view);
        this.k = (FrameLayout) this.c.findViewById(R.id.fl_room_content);
        this.aj = (KeyboardListenLinearLayout) this.c.findViewById(R.id.keyboard_linear_layout);
        this.an = (LiveAnimationView) this.c.findViewById(R.id.live_animation_layout);
        this.ao = (SVGAImageView) this.c.findViewById(R.id.live_animation_svga_layout);
        this.ap = (LiveAnimationView) this.c.findViewById(R.id.yy_mount_animation_layout);
        this.aq = (LiveAnimationView) this.c.findViewById(R.id.yy_up_animation_layout);
        this.ar = (TextView) this.c.findViewById(R.id.tv_mount_marq);
        this.q = (YYBackgroundView) this.c.findViewById(R.id.yy_backgroud);
        this.m = this.c.findViewById(R.id.con_room);
        this.q.setFragment(this);
        this.ak = (RelativeLayout) this.c.findViewById(R.id.ll_hit_view);
        this.al = (GiftBaseHitView) this.c.findViewById(R.id.hitView1);
        this.am = (GiftBaseHitView) this.c.findViewById(R.id.hitView2);
        this.s = (YYGoldListView) this.c.findViewById(R.id.ll_rank);
        this.as = (ShapeTextView) this.c.findViewById(R.id.tv_broadcast);
        this.u = (YYGameView) this.c.findViewById(R.id.yy_game_layout);
        this.p = (YYMusicFloatView) this.c.findViewById(R.id.music_float);
        this.av = (LinearLayout) this.c.findViewById(R.id.ll_cp_guide);
        this.aD = (ImageView) this.c.findViewById(R.id.img_ktv_background);
        this.U = (ImageView) this.c.findViewById(R.id.img_ktv_twinkle);
        ImageView imageView = (ImageView) this.c.findViewById(R.id.img_ktv_top_lights);
        this.V = imageView;
        imageView.setTag("");
        ImageView imageView2 = (ImageView) this.c.findViewById(R.id.img_ktv_bottom_lights);
        this.W = imageView2;
        imageView2.setTag("");
        this.T = this.c.findViewById(R.id.fl_ktv_background);
        this.X = (ImageView) this.c.findViewById(R.id.img_ktv_twinkle_arrow);
        this.Y = (ImageView) this.c.findViewById(R.id.img_ktv_background_highlight);
        this.Z = (ImageView) this.c.findViewById(R.id.img_bottom_cover);
        this.aa = (SVGAImageView) this.c.findViewById(R.id.img_room_pk_sgva);
        this.ab = (YYRobMusicRoomVIew) this.c.findViewById(R.id.img_rob_svga_background);
        this.ac = (SVGAImageView) this.c.findViewById(R.id.img_room_rob_sgva);
        YYHolidayActivities yYHolidayActivities = (YYHolidayActivities) this.c.findViewById(R.id.ll_activities);
        this.ad = yYHolidayActivities;
        yYHolidayActivities.a(this);
        YYExplorationView yYExplorationView = (YYExplorationView) this.c.findViewById(R.id.ll_exploration_time);
        this.ae = yYExplorationView;
        yYExplorationView.a(this);
        this.af = (YYConfessedRoomView) this.c.findViewById(R.id.confessed_view);
        X();
        Y();
        D();
        this.q.a();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            if (b.isSaleChannel() || b.isKTVChannel() || b.isRolChannel() || TextUtils.equals(b.chat_type, "8") || TextUtils.equals(b.chat_type, "9") || TextUtils.equals(b.chat_type, "11")) {
                this.av.setVisibility(0);
            } else {
                this.av.setVisibility(8);
            }
            if (StringUtils.b(b.music_info)) {
                this.p.setVisibility(8);
            } else {
                YYMusicMode yYMusicMode = (YYMusicMode) AppInfo.f().fromJson(b.music_info, YYMusicMode.class);
                if (yYMusicMode == null) {
                    return;
                }
                if (yYMusicMode.type == 0) {
                    a(yYMusicMode);
                }
            }
        }
        LiveEventBus.get("notify_close_jump_room").post("");
        LiveLogUtils.a("BaseYYStudioFragment --> 进入直播间 initView completed ... ");
    }

    private void X() {
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_LIST_CLICK, b.room_id, b.uid);
                }
                BaseYYStudioFragment.this.aB = YYRankFragment.f();
                BaseYYStudioFragment.this.aB.show(BaseYYStudioFragment.this.getFragmentManager(), "RankListDialog");
            }
        });
        this.as.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_NOTICE_CLICK, b.room_id, b.uid);
                }
                BaseYYStudioFragment.this.H();
            }
        });
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYRoomInfoManager.e().y()) {
                    new TopicListDialog().show(BaseYYStudioFragment.this.getChildFragmentManager(), "TopicListDialog");
                }
            }
        });
        this.av.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveEventBus.get("show_blind_guide").post("");
            }
        });
    }

    private void Y() {
        LiveLogUtils.a("BaseYYStudioFragment --> initConnectingLayout --> 进入直播间 初始化麦位布局 ... ");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        LiveLogUtils.a("BaseYYStudioFragment --> initConnectingLayout --> 进入直播间 直播间种类 ... " + b.chat_type);
        String str = b.chat_type;
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != 56) {
            if (hashCode != 57) {
                if (hashCode != 1567) {
                    if (hashCode != 1568) {
                        switch (hashCode) {
                            case 51:
                                if (str.equals("3")) {
                                    z = false;
                                    break;
                                }
                                break;
                            case 52:
                                if (str.equals("4")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 53:
                                if (str.equals("5")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 54:
                                if (str.equals(ATAdConst.ATDevFrameworkType.FLUTTER)) {
                                    z = true;
                                    break;
                                }
                                break;
                        }
                    } else if (str.equals("11")) {
                        z = true;
                    }
                } else if (str.equals("10")) {
                    z = true;
                }
            } else if (str.equals("9")) {
                z = true;
            }
        } else if (str.equals("8")) {
            z = true;
        }
        switch (z) {
            case false:
                this.aw = new YYGamePresenter(this);
                this.u.setVisibility(0);
                this.u.a(this);
                this.j.setLayoutManager(new GridLayoutManager(getContext(), 7));
                YYConnectingGameAdapter yYConnectingGameAdapter = new YYConnectingGameAdapter(getContext(), this);
                this.E = yYConnectingGameAdapter;
                this.j.setAdapter(yYConnectingGameAdapter);
                this.E.bindToRecyclerView(this.j);
                break;
            case true:
                this.aw = new YYSalePresenter(this);
                final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
                this.j.setLayoutManager(gridLayoutManager);
                YYSeatSaleAdapter yYSeatSaleAdapter = new YYSeatSaleAdapter(getContext(), this);
                this.E = yYSeatSaleAdapter;
                this.j.setAdapter(yYSeatSaleAdapter);
                this.E.bindToRecyclerView(this.j);
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.9
                    public int getSpanSize(int i) {
                        int i2 = 1;
                        if (i == 0 || i == 1) {
                            i2 = gridLayoutManager.getSpanCount();
                        }
                        return i2;
                    }
                });
                this.j.setBackgroundResource(R.drawable.shape_raduis_18dp_tran50_000000);
                ConstraintLayout.LayoutParams layoutParams = this.k.getLayoutParams();
                layoutParams.topMargin = DensityUtils.a(getContext(), 10.0f);
                layoutParams.leftMargin = DensityUtils.a(getContext(), 10.0f);
                layoutParams.rightMargin = DensityUtils.a(getContext(), 10.0f);
                break;
            case true:
                this.aw = new YYSoloPresenter(this);
                this.j.setLayoutManager(new LinearLayoutManager(getContext()));
                YYSeatSoloAdapter yYSeatSoloAdapter = new YYSeatSoloAdapter(getContext(), this);
                this.E = yYSeatSoloAdapter;
                this.j.setAdapter(yYSeatSoloAdapter);
                this.E.bindToRecyclerView(this.j);
                break;
            case true:
                YYMusicManager.a.c();
                this.aw = new YYKtvPresenter(this);
                if (b.stage_info != null && b.stage_info.status == 1) {
                    this.T.setVisibility(0);
                }
                this.j.setLayoutManager(new LinearLayoutManager(getContext()));
                YYSeatKTVAdapter yYSeatKTVAdapter = new YYSeatKTVAdapter(getContext(), this);
                this.E = yYSeatKTVAdapter;
                this.j.setAdapter(yYSeatKTVAdapter);
                this.E.bindToRecyclerView(this.j);
                break;
            case true:
            case true:
                this.aw = new YYCPPresenter(this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(1);
                this.j.setLayoutManager(linearLayoutManager);
                YYSeatCPWithVipAdapter yYSeatCPWithVipAdapter = new YYSeatCPWithVipAdapter(this);
                this.E = yYSeatCPWithVipAdapter;
                this.j.setAdapter(yYSeatCPWithVipAdapter);
                this.E.bindToRecyclerView(this.j);
                break;
            case true:
                this.aw = new YYEntertainmentPresenter(this);
                LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
                linearLayoutManager2.setOrientation(1);
                this.j.setLayoutManager(linearLayoutManager2);
                YYSeatEntertainmentAdapter yYSeatEntertainmentAdapter = new YYSeatEntertainmentAdapter(getContext(), this);
                this.E = yYSeatEntertainmentAdapter;
                this.j.setAdapter(yYSeatEntertainmentAdapter);
                this.E.bindToRecyclerView(this.j);
                break;
            case true:
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(this.m);
                constraintSet.clear(R.id.fl_room_content, 3);
                constraintSet.connect(R.id.fl_room_content, 3, 0, 3);
                constraintSet.applyTo(this.m);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.D.getLayoutParams();
                layoutParams2.topMargin = AppInfo.d().getResources().getDimensionPixelSize(R.dimen.dp_150);
                this.D.setLayoutParams(layoutParams2);
                this.aw = new YYRobMusicPresenter(this);
                LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext());
                linearLayoutManager3.setOrientation(1);
                this.j.setLayoutManager(linearLayoutManager3);
                YYRobMusicAdapter yYRobMusicAdapter = new YYRobMusicAdapter(getContext(), this);
                this.E = yYRobMusicAdapter;
                this.j.setAdapter(yYRobMusicAdapter);
                this.E.bindToRecyclerView(this.j);
                break;
            default:
                this.aw = new YYTalkPresenter(this);
                this.j.setLayoutManager(new GridLayoutManager(getContext(), 4));
                YYConnectingAdapter yYConnectingAdapter = new YYConnectingAdapter(getContext(), this);
                this.E = yYConnectingAdapter;
                this.j.setAdapter(yYConnectingAdapter);
                this.E.bindToRecyclerView(this.j);
                break;
        }
        a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.p(b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYRetryRoomModel>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRetryRoomModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                if (LiveSettingConfig.a().c()) {
                    LiveLogUtils.a("retryConnect() ---> " + bluedEntityA.toString(), LiveLogUtils.a());
                }
                YYRetryRoomModel singleData = bluedEntityA.getSingleData();
                if (singleData.room_name != null && !TextUtils.equals(b.room_name, singleData.room_name) && BaseYYStudioFragment.this.n != null) {
                    b.room_name = singleData.room_name;
                    BaseYYStudioFragment.this.n.a();
                }
                if (!TextUtils.isEmpty(b.relationship) && !TextUtils.equals(b.relationship, singleData.relationship) && BaseYYStudioFragment.this.n != null) {
                    BaseYYStudioFragment.this.n.a_(YYRoomInfoManager.e().k(), singleData.relationship);
                }
                List<YYSeatMemberModel> list = singleData.mics;
                if (TextUtils.equals(b.chat_type, "4")) {
                    list.get(0).itemType = 2;
                    list.get(1).itemType = 3;
                }
                b.setSeatList(list);
                YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
                if (yYUserInfo == null) {
                    return;
                }
                yYUserInfo.push_url = singleData.publish_url;
                if (!TextUtils.equals(yYUserInfo.chat_anchor, singleData.chat_anchor)) {
                    yYUserInfo.chat_anchor = singleData.chat_anchor;
                }
                if (yYUserInfo.is_open_mic != singleData.is_open_mic) {
                    if (singleData.is_open_mic == 0) {
                        AudioChannelManager.j().a(true);
                    } else {
                        AudioChannelManager.j().a(false);
                    }
                    YYObserverManager.a().c(singleData.is_open_mic);
                }
                if (!TextUtils.equals(yYUserInfo.is_mic, singleData.is_mic)) {
                    if (TextUtils.equals(singleData.is_mic, "1")) {
                        YYObserverManager.a().a("1");
                        BaseYYStudioFragment.this.e(singleData.publish_url);
                    } else {
                        YYObserverManager.a().a(yYUserInfo.chat_anchor);
                    }
                    yYUserInfo.is_mic = singleData.is_mic;
                }
                yYUserInfo.captain = singleData.game_captain;
                yYUserInfo.mute = singleData.mute;
                if (singleData.isPking() && !TextUtils.isEmpty(YYRoomInfoManager.e().D())) {
                    YYRoomInfoManager.e().w();
                }
                if (YYRoomInfoManager.e().b() != null) {
                    YYRoomInfoManager.e().b().topic_set_info = singleData.topic_set_info;
                    BaseYYStudioFragment.this.j();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (LiveSettingConfig.a().c()) {
                    LiveLogUtils.a("retryConnect() ---> onUIFailure() errorCode:" + i, LiveLogUtils.a());
                }
                if (i == 40380002) {
                    ToastUtils.a("房间已关闭", 0);
                    if (YYRoomInfoManager.e().b() == null || !TextUtils.equals(YYRoomInfoManager.e().b().uid, YYRoomInfoManager.e().k())) {
                        BaseYYStudioFragment.this.G();
                    } else {
                        BaseYYStudioFragment.this.d(b.room_id);
                    }
                } else if (i == 40380030) {
                    ToastUtils.a("你已被房主移出了房间", 0);
                    YYRoomInfoManager.e().x();
                    BaseYYStudioFragment.this.getActivity().finish();
                } else if (i == 40380022) {
                    YYRoomInfoManager.e().x();
                    BaseYYStudioFragment.this.getActivity().finish();
                }
                return super.onUIFailure(i, str);
            }
        }, (IRequestHost) getFragmentActive());
    }

    public static void a(Context context) {
        if (YYRoomInfoManager.e().a == null || TextUtils.isEmpty(YYRoomInfoManager.e().a.chat_anchor)) {
            LiveLogUtils.a("BaseYYStudioFragment --> 小窗进入直播间 --> me == null 或者 chat_anchor = null");
            return;
        }
        LiveLogUtils.a("BaseYYStudioFragment --> 小窗进入直播间 --> " + AppInfo.f().toJson(YYRoomInfoManager.e().a));
        if (YYRoomInfoManager.e().a.chat_anchor.equals("1")) {
            a(context, true);
        } else {
            b(context, true);
        }
    }

    private static void a(Context context, Class cls, Bundle bundle) {
        AudioManagerUtils.a().b();
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        TerminalActivity.d(context, cls, bundle);
    }

    public static void a(Context context, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("from_float", z);
        a(context, RecordingStudioFragment.class, bundle);
    }

    private void a(final BaseConnectingAdapter baseConnectingAdapter) {
        baseConnectingAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.10
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYSeatMemberModel yYSeatMemberModel = (YYSeatMemberModel) baseConnectingAdapter.getData().get(i);
                BaseYYStudioFragment.this.a(view, yYSeatMemberModel, yYSeatMemberModel.mic_position);
            }
        });
        if (YYRoomInfoManager.e().b() != null) {
            baseConnectingAdapter.setNewData(YYRoomInfoManager.e().b().mics);
            this.j.scrollToPosition(baseConnectingAdapter.getItemCount() - 1);
        }
    }

    private void a(YYRoomModel yYRoomModel) {
        YYJoinRoomJumpInfoMode g;
        if (yYRoomModel == null || (g = YYRoomInfoManager.e().g()) == null || g.getData() == null) {
            return;
        }
        LiveLogUtils.a("BaseYYStudioFragment --> onActivityCreated --> otherJumpSwitch --> 打开内部dialog ");
        if (g.getType() == YYJoinRoomJumpInfoMode.Companion.a()) {
            if (g.getData() instanceof String) {
                String str = (String) g.getData();
                if (!StringUtils.b(str)) {
                    LiveEventBus.get("show_inner_dialog").post(str);
                }
            }
        } else if (g.getType() == YYJoinRoomJumpInfoMode.Companion.b() && (g.getData() instanceof String)) {
            l().a(yYRoomModel.room_id, (String) g.getData());
        }
        YYRoomInfoManager.e().a((YYJoinRoomJumpInfoMode) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final YYUserInfo yYUserInfo) {
        if (this.az <= 0) {
            this.az = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.az;
        if (j <= 0 || currentTimeMillis - j < 120000) {
            return;
        }
        YYRoomHttpUtils.r(str, new BluedUIHttpResponse<BluedEntityA<YYHeartModel>>(null) { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYHeartModel> bluedEntityA) {
                YYHeartModel singleData;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                if (LiveSettingConfig.a().c()) {
                    LiveLogUtils.a("checkSelfMicStatus() ---> " + singleData.toString(), LiveLogUtils.a());
                }
                if (singleData.in_room != 1) {
                    BaseYYStudioFragment.this.d(singleData.room_id);
                }
                if (singleData.is_mics != 1) {
                    yYUserInfo.is_mic = "0";
                    yYUserInfo.is_open_mic = 0;
                    YYObserverManager.a().a("0");
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                BaseYYStudioFragment.this.az = System.currentTimeMillis();
            }
        }, (IRequestHost) null);
    }

    private void a(String str, String str2, String str3) {
        LiveEventBus.get(LiveEventBusConstant.d).post("");
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        this.aC = getChildFragmentManager().findFragmentByTag("LiveGift");
        Bundle bundle = new Bundle();
        bundle.putString("from", str);
        bundle.putString("target_uid", str3);
        bundle.putString("goods_id", str2);
        YYGiftListFragment yYGiftListFragment = this.aC;
        if (yYGiftListFragment == null) {
            YYGiftListFragment yYGiftListFragment2 = new YYGiftListFragment();
            this.aC = yYGiftListFragment2;
            yYGiftListFragment2.setArguments(bundle);
            beginTransaction.add(R.id.ll_gift_layout, this.aC, "LiveGift");
        } else {
            yYGiftListFragment.setArguments(bundle);
            beginTransaction.show(this.aC);
        }
        this.aG = true;
        beginTransaction.commitNowAllowingStateLoss();
    }

    public static void b(Context context, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("from_float", z);
        a(context, PlayingStudioFragment.class, bundle);
    }

    public abstract void A();

    public abstract void B();

    public abstract void C();

    public abstract void D();

    protected abstract void E();

    public abstract int F();

    public abstract void G();

    public abstract void H();

    protected abstract boolean I();

    public abstract void J();

    public void K() {
        LiveLogUtils.a("BaseYYStudioFragment --> leaveAndDestroyChannel --> 失去媒体音频焦点，断开连接trtc");
        AudioManagerUtils.a().a(false);
        AudioChannelManager.j().c();
        YYMusicManager.a.c().f();
        this.b.stopService(new Intent(this.b, NotificationService.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IAudioContract.IAudioCallback L() {
        return new IAudioContract.IAudioCallback() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.15
            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a() {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(int i) {
                Logger.e("sdk", "用户切换身份 ==> errorCode : " + i);
                LiveLogUtils.a("BaseYYStudioFragment --> onSwitchRole --> 用户切换身份 ... errorCode: " + i);
                if (i != 0) {
                    return;
                }
                if (!YYRoomInfoManager.e().i()) {
                    Logger.e("sdk", "onSwitchRole stop cdnStream url ... ");
                    AudioChannelManager.j().d();
                    LiveLogUtils.a("BaseYYStudioFragment --> onSwitchRole --> 用户停止推流 ... uid: " + YYRoomInfoManager.e().k());
                } else if (YYRoomInfoManager.e().y()) {
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b == null) {
                        return;
                    }
                    Logger.e("sdk", "onSwitchRole publish url: " + b.publish_url);
                    BaseYYStudioFragment.this.e(b.publish_url);
                    LiveLogUtils.a("BaseYYStudioFragment --> onSwitchRole -->  主播开始推流 ... publish url: " + b.publish_url);
                } else {
                    YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
                    if (yYUserInfo == null) {
                        return;
                    }
                    Logger.e("sdk", "onSwitchRole publish cdnStream url: " + yYUserInfo.push_url);
                    BaseYYStudioFragment.this.e(yYUserInfo.push_url);
                    LiveLogUtils.a("BaseYYStudioFragment --> onSwitchRole --> 麦上用户开始推流 ... userInfo: " + AppInfo.f().toJson(yYUserInfo));
                }
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(int i, String str) {
                Logger.e("cdn_stream", "onStartPublishCDNStream call back errCode: " + i + "; errMsg: " + str);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                YYRoomHttpUtils.a(b.room_id);
                LiveLogUtils.a("BaseYYStudioFragment --> onStartPublishCDNStream --> 用户推流成功 上报接口 ... room id: " + b.room_id);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(long j) {
                Logger.e("sdk", "onSelfJoined ... l: " + j);
                LiveLogUtils.a("BaseYYStudioFragment --> onSelfJoined -->  用户进入直播间 ... uid: " + j);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(TrtcAudioFrameModel trtcAudioFrameModel) {
                if (BaseYYStudioFragment.this.aw instanceof YYKtvPresenter) {
                    if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().music == null) {
                        return;
                    }
                    YYMusicManager.a.c().a(trtcAudioFrameModel, StringUtils.a(YYRoomInfoManager.e().b().music.uid, YYRoomInfoManager.e().k()));
                } else if (!(BaseYYStudioFragment.this.aw instanceof YYRobMusicPresenter) || YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().robMus == null) {
                } else {
                    YYMusicManager.a.c().a(trtcAudioFrameModel, StringUtils.a(YYRoomInfoManager.e().b().robMus.getUid(), YYRoomInfoManager.e().k()));
                }
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(final TRTCCloudDef.TRTCQuality tRTCQuality) {
                BaseYYStudioFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BaseYYStudioFragment.this.n != null) {
                            BaseYYStudioFragment.this.n.a(tRTCQuality);
                        }
                    }
                });
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(String str) {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(String str, int i, int i2, String str2) {
                YYAudioConfig yYAudioConfig;
                Logger.e("sdk", "收到TRTC信令 userId：" + str + "；cmdID：" + i);
                LiveLogUtils.a("BaseYYStudioFragment --> onRecvCustomCmdMsg --> userId：" + str + "；cmdID：" + i);
                if (YYRoomInfoManager.e().b() != null && TextUtils.equals(str, YYRoomInfoManager.e().b().uid)) {
                    if (i == 1) {
                        if (TextUtils.isEmpty(str2) || (yYAudioConfig = (YYAudioConfig) AppInfo.f().fromJson(str2, YYAudioConfig.class)) == null) {
                            return;
                        }
                        AudioChannelManager.j().a(yYAudioConfig.b, yYAudioConfig.a);
                    } else if (i == 2) {
                        AudioChannelManager.j().l();
                    } else if (i == 3) {
                        LiveLogUtils.a("BaseYYStudioFragment --> onRecvCustomCmdMsg --> EXIT_ROOM ... 用户被踢出房间 uid：" + YYRoomInfoManager.e().k());
                        Logger.e("BaseYYStudioFragment", "EXIT_ROOM of the TRTC message: " + str2);
                        YYAudioConfig yYAudioConfig2 = (YYAudioConfig) AppInfo.f().fromJson(str2, YYAudioConfig.class);
                        if (yYAudioConfig2 != null && TextUtils.equals(YYRoomInfoManager.e().k(), yYAudioConfig2.c)) {
                            ToastUtils.a("你被房主移出了房间", 0);
                            YYRoomInfoManager.e().x();
                            BaseYYStudioFragment.this.getActivity().finish();
                        }
                    } else if (i != 5) {
                    } else {
                        Logger.e("BaseYYStudioFragment", "LEAVE_MIC of the TRTC message: " + str2);
                        LiveLogUtils.a("BaseYYStudioFragment --> onRecvCustomCmdMsg --> LEAVE_MIC ... 麦上用户被抱下麦 uid：" + YYRoomInfoManager.e().k());
                        YYAudioConfig yYAudioConfig3 = (YYAudioConfig) AppInfo.f().fromJson(str2, YYAudioConfig.class);
                        if (yYAudioConfig3 != null && TextUtils.equals(yYAudioConfig3.c, YYRoomInfoManager.e().k())) {
                            if (YYRoomInfoManager.e().a != null) {
                                YYRoomInfoManager.e().a.is_mic = "0";
                                YYRoomInfoManager.e().a.is_open_mic = 0;
                            }
                            YYObserverManager.a().a("0");
                        }
                    }
                }
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(String str, int i, String str2) {
                TRTCSendPKMuteMsg tRTCSendPKMuteMsg;
                TRTCSendLrcMsg tRTCSendLrcMsg;
                TrtcSongScoreModel trtcSongScoreModel;
                TRTCSendLrcMsg tRTCSendLrcMsg2;
                switch (i) {
                    case 1:
                        if (TextUtils.isEmpty(str2) || (tRTCSendPKMuteMsg = (TRTCSendPKMuteMsg) AppInfo.f().fromJson(str2, TRTCSendPKMuteMsg.class)) == null) {
                            return;
                        }
                        if (YYRoomInfoManager.e().b() == null || !YYRoomInfoManager.e().b().pk_has_connected) {
                            LiveLogUtils.a("BaseYYStudioFragment --> onRecvSEIMsg --> 房间pk拉流 connectOtherRoom");
                            AudioChannelManager.j().a(tRTCSendPKMuteMsg.roomId, tRTCSendPKMuteMsg.userSig);
                            return;
                        }
                        return;
                    case 2:
                        LiveLogUtils.a("BaseYYStudioFragment --> onRecvSEIMsg --> 房间pk拉流 disconnectOtherRoom");
                        AudioChannelManager.j().l();
                        return;
                    case 3:
                        Logger.e("BaseYYStudioFragment", "EXIT_ROOM of the TRTC message: " + str2);
                        LiveLogUtils.a("BaseYYStudioFragment --> onRecvSEIMsg --> EXIT_ROOM ... 用户被踢出房间 uid：" + YYRoomInfoManager.e().k());
                        TRTCSendLeaveMsg tRTCSendLeaveMsg = (TRTCSendLeaveMsg) AppInfo.f().fromJson(str2, TRTCSendLeaveMsg.class);
                        if (tRTCSendLeaveMsg != null && TextUtils.equals(YYRoomInfoManager.e().k(), tRTCSendLeaveMsg.uid)) {
                            ToastUtils.a("你被房主移出了房间", 0);
                            YYRoomModel b = YYRoomInfoManager.e().b();
                            if (b != null && b.music != null && TextUtils.equals(YYRoomInfoManager.e().k(), b.music.uid)) {
                                AudioChannelManager.j().d(4443);
                                AudioChannelManager.j().d(4444);
                            }
                            YYRoomInfoManager.e().x();
                            BaseYYStudioFragment.this.getActivity().finish();
                            return;
                        }
                        return;
                    case 4:
                        if (BaseYYStudioFragment.this.E == null || !(BaseYYStudioFragment.this.E instanceof YYSeatKTVAdapter) || TextUtils.isEmpty(str2) || (tRTCSendLrcMsg = (TRTCSendLrcMsg) AppInfo.f().fromJson(str2, TRTCSendLrcMsg.class)) == null) {
                            return;
                        }
                        ((YYSeatKTVAdapter) BaseYYStudioFragment.this.E).a(StringUtils.a(tRTCSendLrcMsg.progressMs, 0));
                        return;
                    case 5:
                        Logger.e("BaseYYStudioFragment", "LEAVE_MIC of the SEI message: " + str2);
                        LiveLogUtils.a("BaseYYStudioFragment --> onRecvSEIMsg --> LEAVE_MIC ... 麦上用户被抱下麦 uid：" + YYRoomInfoManager.e().k());
                        TRTCSendLeaveMsg tRTCSendLeaveMsg2 = (TRTCSendLeaveMsg) AppInfo.f().fromJson(str2, TRTCSendLeaveMsg.class);
                        if (tRTCSendLeaveMsg2 != null && TextUtils.equals(tRTCSendLeaveMsg2.uid, YYRoomInfoManager.e().k())) {
                            if (YYRoomInfoManager.e().a != null) {
                                YYRoomInfoManager.e().a.is_mic = "0";
                                YYRoomInfoManager.e().a.is_open_mic = 0;
                            }
                            YYRoomModel b2 = YYRoomInfoManager.e().b();
                            if (b2 != null && b2.music != null && TextUtils.equals(YYRoomInfoManager.e().k(), b2.music.uid)) {
                                AudioChannelManager.j().d(4443);
                                AudioChannelManager.j().d(4444);
                            }
                            YYObserverManager.a().a("0");
                            return;
                        }
                        return;
                    case 6:
                        LogUtils.d("ktv", "KTV_SONG_SCORE: user_id: " + str);
                        if (!(BaseYYStudioFragment.this.E instanceof YYSeatKTVAdapter) || (trtcSongScoreModel = (TrtcSongScoreModel) AppInfo.f().fromJson(str2, TrtcSongScoreModel.class)) == null) {
                            return;
                        }
                        LogUtils.d("ktv", "Studio KTV_SONG_SCORE: " + str2);
                        if (YYRoomInfoManager.e().b() != null) {
                            YYMsgKtvMusic yYMsgKtvMusic = YYRoomInfoManager.e().b().music;
                            if (yYMsgKtvMusic != null) {
                                yYMsgKtvMusic.hitCount = trtcSongScoreModel.hitCount;
                            }
                            YYKtvStageModel yYKtvStageModel = YYRoomInfoManager.e().b().stage_info;
                            if (yYKtvStageModel == null) {
                                return;
                            }
                            yYKtvStageModel.score = trtcSongScoreModel.gotTotalScore + "";
                            if (StringUtils.a(yYKtvStageModel.total_score, 0.0f) <= 0.0f) {
                                yYKtvStageModel.total_score = (trtcSongScoreModel.totalScore / (StringUtils.a(yYKtvStageModel.lowest_score, 0) / 100.0d)) + "";
                                ((YYSeatKTVAdapter) BaseYYStudioFragment.this.E).a(trtcSongScoreModel.totalScore);
                                ((YYSeatKTVAdapter) BaseYYStudioFragment.this.E).b(trtcSongScoreModel.gotTotalScore);
                                ((YYSeatKTVAdapter) BaseYYStudioFragment.this.E).c(trtcSongScoreModel.currentScore);
                            } else {
                                ((YYSeatKTVAdapter) BaseYYStudioFragment.this.E).c(trtcSongScoreModel.currentScore);
                            }
                            ((YYSeatKTVAdapter) BaseYYStudioFragment.this.E).d(trtcSongScoreModel.averageScore);
                            return;
                        }
                        return;
                    case 7:
                        Logger.e("BaseYYStudioFragment", "收到TRTC信令 userId：" + str + "；cmdID：" + i);
                        BaseYYStudioFragment.this.M();
                        return;
                    case 8:
                        TRTCSendPKMicrophoneStatusMsg tRTCSendPKMicrophoneStatusMsg = (TRTCSendPKMicrophoneStatusMsg) AppInfo.f().fromJson(str2, TRTCSendPKMicrophoneStatusMsg.class);
                        if (tRTCSendPKMicrophoneStatusMsg != null && YYRoomInfoManager.e().i()) {
                            YYRoomModel b3 = YYRoomInfoManager.e().b();
                            if (b3 != null) {
                                b3.updateMicStatus(YYRoomInfoManager.e().k(), tRTCSendPKMicrophoneStatusMsg.status);
                            }
                            if (tRTCSendPKMicrophoneStatusMsg.status == 0) {
                                AudioChannelManager.j().a(true);
                            } else {
                                AudioChannelManager.j().a(false);
                            }
                            YYObserverManager.a().c(tRTCSendPKMicrophoneStatusMsg.status);
                            return;
                        }
                        return;
                    case 9:
                        TRTCSendPKMicrophoneStatusMsg tRTCSendPKMicrophoneStatusMsg2 = (TRTCSendPKMicrophoneStatusMsg) AppInfo.f().fromJson(str2, TRTCSendPKMicrophoneStatusMsg.class);
                        if (tRTCSendPKMicrophoneStatusMsg2 != null && YYRoomInfoManager.e().i() && TextUtils.equals(tRTCSendPKMicrophoneStatusMsg2.userId, YYRoomInfoManager.e().k())) {
                            LiveLogUtils.a("BaseYYStudioFragment --> onRecvSEIMsg --> MICROPHONE_ENABLE --> 房主禁、解 麦上用户麦克风状态：" + str2);
                            if (tRTCSendPKMicrophoneStatusMsg2.status == 0) {
                                AudioChannelManager.j().a(true);
                                return;
                            } else {
                                AudioChannelManager.j().a(false);
                                return;
                            }
                        }
                        return;
                    case 10:
                        if (BaseYYStudioFragment.this.E == null || !(BaseYYStudioFragment.this.E instanceof YYRobMusicAdapter) || TextUtils.isEmpty(str2) || (tRTCSendLrcMsg2 = (TRTCSendLrcMsg) AppInfo.f().fromJson(str2, TRTCSendLrcMsg.class)) == null || YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().robMus == null || !StringUtils.a(tRTCSendLrcMsg2.musicId, YYRoomInfoManager.e().b().robMus.getMusicId())) {
                            return;
                        }
                        if (tRTCSendLrcMsg2.type == 1) {
                            ((YYRobMusicAdapter) BaseYYStudioFragment.this.E).a(StringUtils.a(tRTCSendLrcMsg2.progressMs, 0));
                            return;
                        } else {
                            ((YYRobMusicAdapter) BaseYYStudioFragment.this.E).b(StringUtils.a(tRTCSendLrcMsg2.progressMs, 0));
                            return;
                        }
                    default:
                        return;
                }
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(String str, boolean z) {
                Logger.e("sdk", "麦克风状态 ==> uid : " + str + " --- mic : " + z);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void a(Set<String> set, boolean z) {
                YYRoomModel b;
                if (set == null || (b = YYRoomInfoManager.e().b()) == null) {
                    return;
                }
                Set<String> talkingUserIds = b.getTalkingUserIds();
                boolean z2 = true;
                if (set.size() == talkingUserIds.size()) {
                    z2 = true ^ talkingUserIds.equals(set);
                }
                if (z2) {
                    BaseYYStudioFragment.this.E.a(set);
                }
                if (BaseYYStudioFragment.this.D.getVisibility() == 0 && set != null) {
                    BaseYYStudioFragment.this.D.a(set, z);
                }
                YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
                if (YYRoomInfoManager.e().i()) {
                    BaseYYStudioFragment.this.a(b.room_id, yYUserInfo);
                }
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void b() {
                Logger.e("sdk", "onConnectionRecovery ... ");
                if (LiveSettingConfig.a().c()) {
                    LiveLogUtils.a("onConnectionRecovery() ---> retryConnect()", LiveLogUtils.a());
                }
                LiveLogUtils.a("BaseYYStudioFragment --> onConnectionRecovery -->retryConnect");
                BaseYYStudioFragment.this.Z();
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void b(final int i) {
                BaseYYStudioFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.15.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BaseYYStudioFragment.this.n != null) {
                            BaseYYStudioFragment.this.n.a(i);
                        }
                    }
                });
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void b(int i, String str) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                LiveLogUtils.a("BaseYYStudioFragment --> onStopPublishCDNStream --> 停止推流回调 ... room_id: " + b.room_id);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void b(String str) {
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void c() {
                Logger.e("sdk", "onSendFirstLocalAudioFrame ... ");
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null || TextUtils.isEmpty(b.publish_url)) {
                    return;
                }
                LiveLogUtils.a("BaseYYStudioFragment --> onSendFirstLocalAudioFrame --> 用户开始推流 ... publish url: " + b.publish_url);
                BaseYYStudioFragment.this.e(b.publish_url);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioCallback
            public void c(String str) {
            }
        };
    }

    public void M() {
        YYMusicManager.a.c().a((LiveMusicModel) null);
        K_();
        LiveEventBus.get("live_music_changed").post("");
        LiveEventBus.get("live_music_exit").post("");
    }

    public void N() {
        if (getActivity() instanceof BaseFragmentActivity) {
            getActivity().a((BaseFragmentActivity.IOnBackPressedListener) this);
        }
    }

    public YYImListView O() {
        return this.l;
    }

    public void P() {
        YYKtvNoticeTypeMess yYKtvNoticeTypeMess = new YYKtvNoticeTypeMess();
        yYKtvNoticeTypeMess.a(false, this, "", "");
        yYKtvNoticeTypeMess.show(getChildFragmentManager(), "showKtvUpNotice");
    }

    public void Q() {
        if (this.S != null) {
            if (this.ai != null) {
                R();
            }
            this.ai = new YYRobMusicProgressBtnView(getContext());
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp_112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.dp_90);
            layoutParams.gravity = 81;
            this.S.addView(this.ai, layoutParams);
            this.ai.a(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if ((BaseYYStudioFragment.this.aw instanceof YYRobMusicPresenter) && YYRoomInfoManager.e().i()) {
                        ((YYRobMusicPresenter) BaseYYStudioFragment.this.aw).i();
                    } else {
                        ToastUtils.a("上麦才可以抢唱，快去上麦吧", 0);
                    }
                }
            }, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    BaseYYStudioFragment.this.R();
                }
            });
        }
    }

    public void R() {
        YYRobMusicProgressBtnView yYRobMusicProgressBtnView;
        if (this.S == null || (yYRobMusicProgressBtnView = this.ai) == null) {
            return;
        }
        yYRobMusicProgressBtnView.a();
        this.S.removeView(this.ai);
        this.ai = null;
    }

    public void S() {
        this.w.a();
    }

    public void T() {
        BaseRoomHandler baseRoomHandler = this.aF;
        if (baseRoomHandler == null) {
            return;
        }
        baseRoomHandler.removeMessages(2);
        YYConfessedRoomView yYConfessedRoomView = this.af;
        if (yYConfessedRoomView == null || !yYConfessedRoomView.a()) {
            return;
        }
        this.aF.sendEmptyMessageDelayed(2, 1000L);
    }

    public void U() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        BaseRoomHandler baseRoomHandler = this.aF;
        if (baseRoomHandler == null || this.o == null) {
            return;
        }
        baseRoomHandler.removeMessages(1);
        if (b != null && b.round_end_time > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (b.round_end_time > currentTimeMillis) {
                this.o.a((b.round_end_time - currentTimeMillis) / 1000);
                this.aF.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
            b.round_end_time = 0L;
        }
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().yyPerFirstGiftModel == null || YYRoomInfoManager.e().b().yyPerFirstGiftModel.getType() != 1) {
            this.o.b();
        } else {
            this.o.a();
        }
    }

    public void a(View view, int i) {
        a(view, i, 80, true);
    }

    public void a(View view, int i, int i2, int i3, boolean z) {
        if (this.H) {
            return;
        }
        PopupWindow popupWindow = this.I;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.I.dismiss();
        }
        if (view == null) {
            return;
        }
        this.I = new PopupwindowFactory.Builder(getContext()).a(view).a(i3).c(i2).b(i).d(R.color.syc_66000000).a(z).h();
    }

    public void a(View view, int i, int i2, boolean z) {
        a(view, AppInfo.l, i, i2, z);
    }

    public void a(View view, int i, boolean z) {
        a(view, i, 80, z);
    }

    public abstract void a(View view, YYSeatMemberModel yYSeatMemberModel, int i);

    public void a(ConfessedIMMode confessedIMMode) {
        YYConfessedRoomView yYConfessedRoomView = this.af;
        if (yYConfessedRoomView != null) {
            yYConfessedRoomView.a(this, confessedIMMode);
            T();
        }
    }

    public void a(YYBorImJsonMode yYBorImJsonMode) {
        if (yYBorImJsonMode == null || yYBorImJsonMode.getBody() == null || StringUtils.b(yYBorImJsonMode.getBody().getLight_svga()) || this.aI) {
            return;
        }
        this.aI = true;
        this.ac.setVisibility(0);
        this.ac.setCallback(new SVGACallback() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.20
            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onFinished() {
                BaseYYStudioFragment.this.aI = false;
                BaseYYStudioFragment.this.aa.setScaleType(ImageView.ScaleType.FIT_CENTER);
                BaseYYStudioFragment.this.ac.setVisibility(8);
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onPause() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onRepeat() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onStep(int i, double d) {
            }
        });
        new SVGAPlayer.Builder(yYBorImJsonMode.getBody().getLight_svga()).a((Integer) 1).a(SVGAImageView.FillMode.Clear).a(this.ac);
    }

    @Override // com.blued.android.module.yy_china.model.ClientSendMessTaskModel.ClientTaskDataListener
    public void a(YYDailyTaskModel yYDailyTaskModel) {
        if (YYRoomInfoManager.e().y() || YYRoomInfoManager.e().k() == null) {
            return;
        }
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().yyPerFirstGiftModel != null) {
            q();
        } else {
            YYRoomHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<YYPerFirstGiftModel>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.17
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYPerFirstGiftModel> bluedEntityA) {
                    if (YYRoomInfoManager.e().b() == null || bluedEntityA.getSingleData() == null) {
                        return;
                    }
                    YYRoomInfoManager.e().b().yyPerFirstGiftModel = bluedEntityA.getSingleData();
                    BaseYYStudioFragment.this.q();
                }
            }, getFragmentActive());
        }
    }

    public void a(YYFirstMeetMode yYFirstMeetMode) {
        this.w.a(yYFirstMeetMode);
    }

    public void a(YYMusicMode yYMusicMode) {
        if (!StringUtils.b(yYMusicMode.music_cover)) {
            LiveMusicModel liveMusicModel = new LiveMusicModel();
            liveMusicModel.cover = yYMusicMode.music_cover;
            this.p.setVisibility(0);
            this.p.setData(liveMusicModel);
        }
        if (yYMusicMode.state == 0) {
            this.p.a();
        } else if (yYMusicMode.state == 1) {
        } else {
            if (yYMusicMode.state == 2) {
                this.p.setPlaying(false);
            } else if (yYMusicMode.state == 3) {
                this.p.setPlaying(true);
            } else {
                this.p.setVisibility(8);
            }
        }
    }

    @Override // com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.YYBeansListener
    public void a(YYPerFirstGiftModel yYPerFirstGiftModel, View.OnClickListener onClickListener) {
        c("2");
    }

    public void a(final YYUserInfo yYUserInfo) {
        final PopYyDialog popYyDialog = new PopYyDialog();
        popYyDialog.a(new PopYyDialogGetView() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.12
            @Override // com.blued.android.module.yy_china.view.PopYyDialogGetView
            public View a() {
                YYCardOptionView yYCardOptionView = new YYCardOptionView(BaseYYStudioFragment.this.getContext());
                yYCardOptionView.a = popYyDialog;
                yYCardOptionView.a(BaseYYStudioFragment.this, yYUserInfo);
                return yYCardOptionView;
            }

            @Override // com.blued.android.module.yy_china.view.PopYyDialogGetView
            public FrameLayout.LayoutParams b() {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                return layoutParams;
            }
        });
        popYyDialog.show(getChildFragmentManager(), "YYCardOptionView");
    }

    public void a(YYRoomFullSvgaMode yYRoomFullSvgaMode) {
        YYRoomFullSvgaAniView yYRoomFullSvgaAniView = this.y;
        if (yYRoomFullSvgaAniView != null) {
            yYRoomFullSvgaAniView.a(yYRoomFullSvgaMode);
        }
    }

    public void a(String str, String str2) {
        YYTypingDialog yYTypingDialog = new YYTypingDialog();
        yYTypingDialog.a(this);
        yYTypingDialog.a(str);
        yYTypingDialog.b(str2);
        yYTypingDialog.show(getChildFragmentManager(), "YYTypingDialog");
    }

    public void a(String str, String str2, YYImModel yYImModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        List<YYSeatMemberModel> list = b.mics;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = list.get(i2);
            if (TextUtils.equals(yYSeatMemberModel.getUid(), str)) {
                yYSeatMemberModel.apngUrl = str2;
                yYSeatMemberModel.emojiModel = yYImModel;
                this.E.a(i2, str, str2, yYImModel);
                if (this.D.getVisibility() == 0) {
                    this.D.a(i2, str, str2, yYImModel);
                    return;
                }
                return;
            }
            i = i2 + 1;
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        YYRelationshipListView yYRelationshipListView = new YYRelationshipListView(getContext());
        yYRelationshipListView.a(this, str, str2, str3, str4, str5, z, str6);
        a(yYRelationshipListView, -2);
    }

    public void a(final String str, final String str2, final String str3, final String str4, final boolean z) {
        final PopYyDialog popYyDialog = new PopYyDialog();
        popYyDialog.a(new PopYyDialogGetView() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.11
            @Override // com.blued.android.module.yy_china.view.PopYyDialogGetView
            public View a() {
                YYUserCardView seatUserCardView = z ? new SeatUserCardView(BaseYYStudioFragment.this.getContext()) : new AudienceUserCardView(BaseYYStudioFragment.this.getContext());
                seatUserCardView.setMPopYyDialog(popYyDialog);
                seatUserCardView.a(BaseYYStudioFragment.this, str, str2, str3, str4);
                return seatUserCardView;
            }

            @Override // com.blued.android.module.yy_china.view.PopYyDialogGetView
            public FrameLayout.LayoutParams b() {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                return layoutParams;
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        popYyDialog.show(childFragmentManager, "YYUserCardView" + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, boolean z, YYMsgKickInfoExtra yYMsgKickInfoExtra) {
        FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
        beginTransaction.add(R.id.root_view, new YYRoomEndCloseFragment().b(I()).c(str).c(z).a(yYMsgKickInfoExtra));
        beginTransaction.remove(this);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(boolean z) {
        RelativeLayout relativeLayout = this.ak;
        if (relativeLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (z) {
                layoutParams.topMargin -= this.aH;
            } else {
                int[] iArr = new int[2];
                this.l.getLocationOnScreen(iArr);
                Logger.e("BaseYYStudioFragment", "x1: " + iArr[0] + "; y: " + iArr[1]);
                if (iArr[1] != 0) {
                    layoutParams.topMargin = iArr[1];
                } else {
                    layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.dp_276);
                }
            }
            this.ak.setLayoutParams(layoutParams);
            this.ak.setVisibility(0);
        }
    }

    public void a(boolean z, String str, String str2) {
        a(z, str, "", str2);
    }

    public void a(boolean z, String str, String str2, String str3) {
        ClickOneGiftSendView clickOneGiftSendView = this.z;
        if (clickOneGiftSendView != null) {
            clickOneGiftSendView.b();
        }
        if (this.H) {
            return;
        }
        this.ak.setVisibility(8);
        if (!z) {
            n();
            return;
        }
        if (x()) {
            y();
        }
        m();
        a(str, str2, str3);
    }

    public void b(int i) {
        this.ab.setVisibility(0);
        this.ab.a(i, this);
    }

    public void b(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        super.a(keyboardListenLinearLayout);
    }

    @Override // com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.YYBeansListener
    public void b(YYPerFirstGiftModel yYPerFirstGiftModel, View.OnClickListener onClickListener) {
        YYPeyPayBackGiftView.b.a(getContext(), yYPerFirstGiftModel, onClickListener, this);
    }

    public void b(String str, String str2) {
        YYKtvNoticeTypeMess yYKtvNoticeTypeMess = new YYKtvNoticeTypeMess();
        yYKtvNoticeTypeMess.a(true, this, str, str2);
        yYKtvNoticeTypeMess.show(getChildFragmentManager(), "showKtvGiftUpNotice");
    }

    public void c(int i) {
        RoomMemberListView roomMemberListView = new RoomMemberListView(getContext());
        roomMemberListView.setPosition(i);
        roomMemberListView.a(this, F());
        a(roomMemberListView, (int) (AppInfo.m * 0.6d));
    }

    public void c(String str) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
        yYWebViewDialogFragment.a(this, YYRoomInfoManager.e().c().a(10) + "?from=" + str + "&room_id=" + b.room_id + "&room_uid=" + EncryptTool.b(b.uid)).show(getChildFragmentManager(), "FirstChagerDialog");
    }

    public abstract void d(int i);

    public abstract void d(String str);

    public void e(String str) {
        Logger.e("cdn_stream", "start ... " + str);
        if (this.F || TextUtils.isEmpty(str)) {
            return;
        }
        Logger.e("cdn_stream", "pushCdnStream url: " + str);
        TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam = new TRTCCloudDef.TRTCPublishCDNParam();
        tRTCPublishCDNParam.appId = GenerateTestUserSig.a();
        tRTCPublishCDNParam.bizId = GenerateTestUserSig.c();
        tRTCPublishCDNParam.url = str;
        AudioChannelManager.j().a(tRTCPublishCDNParam);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public void j() {
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().topic_set_info == null || StringUtils.b(YYRoomInfoManager.e().b().topic_set_info.getTopic())) {
            return;
        }
        if (TextUtils.equals(YYRoomInfoManager.e().b().chat_type, "5")) {
            this.B.setVisibility(8);
        } else {
            this.B.setVisibility(0);
        }
        this.C.setText(YYRoomInfoManager.e().b().topic_set_info.getTopic());
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        super.j_(i);
    }

    public void k() {
        new YYRenameView().show(getChildFragmentManager(), "YYRenameView");
    }

    public AbstractBasePresenter l() {
        return this.aw;
    }

    public void m() {
        int measuredHeight = this.aj.getMeasuredHeight();
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp_440);
        int[] iArr = new int[2];
        this.ak.getLocationInWindow(iArr);
        this.aH = (iArr[1] - (measuredHeight - dimensionPixelOffset)) + getResources().getDimensionPixelOffset(R.dimen.dp_105);
        a(true);
    }

    public void n() {
        try {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            if (this.aC != null) {
                beginTransaction.hide(this.aC).commitNowAllowingStateLoss();
            }
            N();
        } catch (Exception e) {
        }
        a(false);
        this.aG = false;
    }

    public void o() {
        try {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            if (this.aC != null) {
                beginTransaction.remove(this.aC).commitNowAllowingStateLoss();
                this.aC = null;
            }
            N();
        } catch (Exception e) {
        }
    }

    public void onActivityCreated(Bundle bundle) {
        AbstractBasePresenter abstractBasePresenter;
        super.onActivityCreated(bundle);
        LiveLogUtils.a("BaseYYStudioFragment --> onActivityCreated ...");
        AbstractBasePresenter abstractBasePresenter2 = this.aw;
        if (abstractBasePresenter2 != null) {
            abstractBasePresenter2.a((LifecycleOwner) this);
        }
        this.l.post(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseYYStudioFragment.this.getActivity() == null || BaseYYStudioFragment.this.ak == null || BaseYYStudioFragment.this.l == null) {
                    return;
                }
                int[] iArr = new int[2];
                BaseYYStudioFragment.this.l.getLocationOnScreen(iArr);
                Logger.e("BaseYYStudioFragment", "x: " + iArr[0] + "; y: " + iArr[1]);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) BaseYYStudioFragment.this.ak.getLayoutParams();
                layoutParams.topMargin = iArr[1];
                BaseYYStudioFragment.this.ak.setLayoutParams(layoutParams);
            }
        });
        if (this.G) {
            G();
        }
        if (this.F) {
            LiveLogUtils.a("BaseYYStudioFragment --> onActivityCreated --> 小窗进入 --> retryConnect");
            Z();
        } else {
            v();
            if (!this.F && (abstractBasePresenter = this.aw) != null) {
                abstractBasePresenter.d();
            }
        }
        AbstractBasePresenter abstractBasePresenter3 = this.aw;
        if (abstractBasePresenter3 != null) {
            abstractBasePresenter3.a(this instanceof RecordingStudioFragment);
            this.aw.a();
            LiveLogUtils.a("BaseYYStudioFragment --> onActivityCreated --> presenter init");
        }
        a(YYRoomInfoManager.e().b());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AbstractBasePresenter abstractBasePresenter;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 4221005 || i == 4221004) && intent != null) {
                YYGiftModel yYGiftModel = (YYGiftModel) intent.getSerializableExtra("selected_model");
                String stringExtra = intent.getStringExtra("password");
                boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
                int intExtra = intent.getIntExtra("gift_count", 1);
                if (!TextUtils.isEmpty(stringExtra) && yYGiftModel != null && (abstractBasePresenter = this.aw) != null) {
                    abstractBasePresenter.a(yYGiftModel, intExtra, stringExtra, booleanExtra);
                }
                KeyboardUtils.a((Activity) getActivity());
            } else if (i != 4221002 || intent == null) {
            } else {
                YYGiftModel yYGiftModel2 = (YYGiftModel) intent.getSerializableExtra("selected_model");
                int intExtra2 = intent.getIntExtra("gift_count", 1);
                boolean booleanExtra2 = intent.getBooleanExtra("remember_me", false);
                String stringExtra2 = intent.getStringExtra("password");
                AbstractBasePresenter abstractBasePresenter2 = this.aw;
                if (abstractBasePresenter2 != null) {
                    abstractBasePresenter2.a(yYGiftModel2, intExtra2, stringExtra2, booleanExtra2);
                }
                KeyboardUtils.a((Activity) getActivity());
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        AudioChannelManager.j().a = true;
        return super.onBackPressed();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AudioFloatWindow.a++;
        Logger.e("BaseYYStudioFragment", "onCreate ... ");
        if (bundle != null && !PermissionHelper.a("android.permission.RECORD_AUDIO")) {
            String string = bundle.getString("yy_unexpectedly_exit");
            Logger.e("BaseYYStudioFragment", "onCreate ... roomId: " + string);
            d(string);
            return;
        }
        this.F = getArguments().getBoolean("from_float", false);
        this.G = getArguments().getBoolean("from_float_close", false);
        LiveLogUtils.a("BaseYYStudioFragment --> onCreate --> fromFloat：" + this.F);
        A();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Logger.e("BaseYYStudioFragment", "onCreateView ... ");
        LiveLogUtils.a("BaseYYStudioFragment --> onCreateView ...");
        getActivity().getWindow().setSoftInputMode(16);
        View view = this.c;
        if (view == null) {
            LiveLogUtils.a("BaseYYStudioFragment --> onCreateView --> (mRootView == null)");
            this.b = getContext();
            this.c = layoutInflater.inflate(R.layout.fragment_base_yy_studio_layout, viewGroup, false);
            this.ax = DensityUtils.a(getContext(), 10.0f);
            this.ay = ((AppInfo.l - (DensityUtils.a(getContext(), 60.0f) * 4)) - (this.ax * 2)) / 3;
            Logger.e("BaseYYStudioFragment", "rightDistance = " + this.ay);
            W();
            V();
            b(this.aj);
            E();
        } else if (view.getParent() != null) {
            LiveLogUtils.a("BaseYYStudioFragment --> onCreateView --> (mRootView.getParent() != null)");
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        J();
        AudioChannelManager.j().a(new IAudioContract.AppHandoverListener() { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.1
            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.AppHandoverListener
            public void a() {
                LiveLogUtils.a("BaseYYStudioFragment --> setHandoverListener --> 直播间进入 后台 ... ");
                NotificationService.a(BaseYYStudioFragment.this.b, YYRoomInfoManager.e().a);
            }

            @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.AppHandoverListener
            public void b() {
                LiveLogUtils.a("BaseYYStudioFragment --> setHandoverListener --> 直播间恢复 前台 ... ");
                if (LiveSettingConfig.a().c()) {
                    LiveLogUtils.a("onAppFore() ---> retryConnect()", LiveLogUtils.a());
                }
                BaseYYStudioFragment.this.Z();
                NotificationService.a(BaseYYStudioFragment.this.b);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.2
            public void handleOnBackPressed() {
                if (BaseYYStudioFragment.this.aG) {
                    BaseYYStudioFragment.this.n();
                    return;
                }
                AudioChannelManager.j().a = true;
                BaseYYStudioFragment.this.getActivity().finish();
            }
        });
        return this.c;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        LiveLogUtils.a("BaseYYStudioFragment --> onDestroy ... ");
        AudioFloatWindow.a--;
        Logger.e("BaseYYStudioFragment", "onDestroy ... ");
        YYObserverManager.a().b();
        YYImMsgManager.a().f();
        YYRoomInfoManager.e().K();
        AudioChannelManager.j().a((IAudioContract.AppHandoverListener) null);
        AudioChannelManager.j().a(getContext());
        YYGiftAnimManager yYGiftAnimManager = this.aA;
        if (yYGiftAnimManager != null) {
            yYGiftAnimManager.a();
        }
        YYMountAnimManager yYMountAnimManager = this.J;
        if (yYMountAnimManager != null) {
            yYMountAnimManager.g();
        }
        YYHostUpAnimManager yYHostUpAnimManager = this.K;
        if (yYHostUpAnimManager != null) {
            yYHostUpAnimManager.c();
        }
        this.F = false;
        AbstractBasePresenter abstractBasePresenter = this.aw;
        if (abstractBasePresenter != null) {
            abstractBasePresenter.e();
        }
        MarqueeTextImagesView marqueeTextImagesView = this.t;
        if (marqueeTextImagesView != null) {
            marqueeTextImagesView.a();
        }
        GiftTomicItemModeView giftTomicItemModeView = this.x;
        if (giftTomicItemModeView != null) {
            giftTomicItemModeView.a();
        }
        YYRankFragment yYRankFragment = this.aB;
        if (yYRankFragment != null) {
            yYRankFragment.dismissAllowingStateLoss();
        }
        YYBackgroundMusicDialog yYBackgroundMusicDialog = this.aE;
        if (yYBackgroundMusicDialog != null) {
            yYBackgroundMusicDialog.dismissAllowingStateLoss();
            this.aE = null;
        }
        ClientSendMessTaskNewModel.Companion.a(null);
        if (!StringUtils.b(this.ah)) {
            LiveLogUtils.a("BaseYYStudioFragment --> onDestroy --> 用户切换房间 new room id：" + this.ah);
            AudioChannelManager.j().a(this.ah);
            AudioChannelManager.j().k();
        }
        BaseRoomHandler baseRoomHandler = this.aF;
        if (baseRoomHandler != null) {
            baseRoomHandler.removeCallbacksAndMessages(null);
        }
        Logger.e("BaseYYStudioFragment", "onDestroy ... 1");
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        BaseConnectingAdapter baseConnectingAdapter = this.E;
        if (baseConnectingAdapter instanceof YYSeatKTVAdapter) {
            ((YYSeatKTVAdapter) baseConnectingAdapter).i();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        BaseConnectingAdapter baseConnectingAdapter = this.E;
        if (baseConnectingAdapter instanceof YYSeatKTVAdapter) {
            ((YYSeatKTVAdapter) baseConnectingAdapter).h();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Logger.e("BaseYYStudioFragment", "onSaveInstanceState ...  ");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            Logger.e("BaseYYStudioFragment", "onSaveInstanceState ... roomId: " + b.room_id);
            bundle.putSerializable("yy_unexpectedly_exit", b.room_id);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStop() {
        super.onStop();
        o();
    }

    public void p() {
        if (this instanceof RecordingStudioFragment) {
            YYBackgroundMusicDialog yYBackgroundMusicDialog = new YYBackgroundMusicDialog();
            this.aE = yYBackgroundMusicDialog;
            yYBackgroundMusicDialog.a(this);
        } else if (this instanceof PlayingStudioFragment) {
            YYBackgroundMusicDialog yYBackgroundMusicDialog2 = new YYBackgroundMusicDialog();
            this.aE = yYBackgroundMusicDialog2;
            yYBackgroundMusicDialog2.a(this);
        }
        YYBackgroundMusicDialog yYBackgroundMusicDialog3 = this.aE;
        if (yYBackgroundMusicDialog3 != null) {
            yYBackgroundMusicDialog3.show(getChildFragmentManager(), "YYBackgroundMusicDialog");
        }
    }

    public void q() {
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().yyPerFirstGiftModel == null) {
            this.o.b();
        } else if (YYRoomInfoManager.e().b().yyPerFirstGiftModel.getType() == 1) {
            this.o.a();
        } else {
            this.o.a((FrameLayout) this.c.findViewById(R.id.fra_add_view_layout), this.F);
        }
    }

    public void r() {
        this.o.b();
        YYGiftListFragment yYGiftListFragment = this.aC;
        if (yYGiftListFragment != null) {
            yYGiftListFragment.s();
        }
    }

    @Override // com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.YYBeansListener
    public void s() {
    }

    public void t() {
        YYBeansPrePayDialogFragment yYBeansPrePayDialogFragment = this.ag;
        if (yYBeansPrePayDialogFragment != null) {
            yYBeansPrePayDialogFragment.dismiss();
        }
        YYBeansPrePayDialogFragment yYBeansPrePayDialogFragment2 = new YYBeansPrePayDialogFragment();
        this.ag = yYBeansPrePayDialogFragment2;
        yYBeansPrePayDialogFragment2.a(getContext(), this, 0).a(this).show(getChildFragmentManager(), "YYBeansPrePayDialogFragment");
    }

    public void u() {
        WaitingListView waitingListView = new WaitingListView(getContext());
        waitingListView.a(this);
        a(waitingListView, (int) (AppInfo.m * 0.6d));
    }

    public void v() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        LiveLogUtils.a("BaseYYStudioFragment --> loadLiveInfo --> 进入直播间 request subInfo ... ");
        YYRoomHttpUtils.y(b.room_id, new BluedUIHttpResponse(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.BaseYYStudioFragment.13
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, (IRequestHost) getFragmentActive());
    }

    public void w() {
        new YYRelationShipInfoDialog().show(getChildFragmentManager(), "YYRelationShipInfoDialog");
    }

    public boolean x() {
        PopupWindow popupWindow = this.I;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public void y() {
        PopupWindow popupWindow = this.I;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.I.dismiss();
    }

    public void z() {
        LiveEventBus.get("live_pwd_fragment_close").post("");
        LiveEventBus.get(LiveEventBusConstant.d).post("");
        y();
        n();
        YYRankFragment yYRankFragment = this.aB;
        if (yYRankFragment != null) {
            yYRankFragment.dismiss();
        }
        KeyboardUtils.a((Activity) getActivity());
    }
}
