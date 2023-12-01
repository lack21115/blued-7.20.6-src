package com.blued.community.ui.feed.fragment;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.i;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.custom.SwitchPanelRelativeLayout;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.view.FollowStatusView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.EditTextHeightAnimHelper;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.view.ResizeLinearLayout;
import com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.emoji.view.EmojiEditText;
import com.blued.android.module.common.widget.emoji.view.EmoticonsIndicatorView;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.android.module.common.widget.emoticon.ui.IViewStateListener;
import com.blued.android.module.common.widget.menu.ActionSheetDefaultItem;
import com.blued.android.module.common.widget.menu.BluedActionSheet;
import com.blued.android.module.common.widget.pop.BluedPopupWindow;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.auto.ICommunityShowPageService;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedUserInfoModel;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.track.EventTrackSuperExpose;
import com.blued.community.track.EventTrackVote;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.event.adapter.EventMoreAdapter;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.feed.adapter.FeedDetailsLikeListAdapter;
import com.blued.community.ui.feed.adapter.FeedDetailsPhotoAdapter;
import com.blued.community.ui.feed.adapter.FeedDetailsRepostListAdapter;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.dialog.GuessLikeDialogConfirmAndCancelListener;
import com.blued.community.ui.feed.dialog.GuessLikeFeedPopWindow;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.observer.LikeListDataObserver;
import com.blued.community.ui.feed.presenter.FeedDetailsPresenter;
import com.blued.community.ui.send.model.FeedEventModel;
import com.blued.community.ui.square.fragment.HotFeedFragment;
import com.blued.community.ui.topic.fragment.SuperTopicDetailFragment;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.video.fragment.VideoScanFragment;
import com.blued.community.ui.video.fragment.VideoUserInfoFragment;
import com.blued.community.utils.AtChooseUserHelper;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.CommunityShareUtils;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.utils.ViewUtils;
import com.blued.community.view.PhotoGridView;
import com.blued.community.view.TextViewFixTouchForDynamic;
import com.blued.community.view.VerticalCenterImageSpan;
import com.blued.community.widget.vote.picture.FeedVoteGroup;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.vote.VoteProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.superexpose.SuperExposeProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/FeedDetailsFragment.class */
public class FeedDetailsFragment extends MvpKeyBoardFragment<FeedDetailsPresenter> {
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private TextView E;
    private ImageView F;
    private ImageView G;
    private TextView H;
    private ImageView I;
    private LinearLayout J;
    private ImageView K;
    private FollowStatusView L;
    private ImageView M;
    private TextView N;
    private ShapeLinearLayout O;
    private ImageView P;
    private LinearLayout Q;
    private TextView R;
    private TextView S;
    private ShapeFrameLayout T;
    private TextView U;
    private ShapeFrameLayout V;
    private TextView W;
    private ShapeFrameLayout X;
    private TextView Y;
    private LinearLayout Z;
    private EventMoreAdapter aA;
    private TextViewFixTouchForDynamic aB;
    private RelativeLayout aC;
    private TextViewFixTouchForDynamic aD;
    private ImageView aE;
    private ShapeTextView aF;
    private CardView aG;
    private PhotoGridView aH;
    private PhotoGridView aI;
    private PLVideoPageView aJ;
    private CardView aK;
    private ImageView aL;
    private LinearLayout aM;
    private ShapeTextView aN;
    private TextView aO;
    private TextView aP;
    private TextView aQ;
    private LinearLayout aR;
    private LinearLayout aS;
    private TextView aT;
    private ImageView aU;
    private TextView aV;
    private ShapeTextView aW;
    private ImageView aX;
    private CardView aY;
    private FeedVoteGroup aZ;
    private ConstraintLayout aa;
    private TextView ab;
    private View ac;
    private TextView ad;
    private ImageView ae;
    private View af;
    private TextView ag;
    private ImageView ah;
    private FlowLayout ai;
    private ShapeLinearLayout aj;
    private View ak;
    private ImageView al;
    private ImageView am;
    private ImageView an;
    private ImageView ao;
    private ImageView ap;
    private TextView aq;
    private View ar;
    private ImageView as;
    private TextView at;
    private ImageView au;
    private TextView av;
    private View aw;
    private View ax;
    private TextView ay;
    private RecyclerView az;
    private FrameLayout bA;
    private View bB;
    private RecyclerView bC;
    private FeedListAdapterForRecyclerView bD;
    private View bE;
    private TextView bF;
    private RecyclerView bG;
    private View bH;
    private ConsecutiveScrollerLayout bI;
    private SmartRefreshLayout bJ;
    private View bK;
    private ImageView bL;
    private View bM;
    private ImageView bN;
    private ImageView bO;
    private ImageView bP;
    private LinearLayout bQ;
    private EmojiEditText bR;
    private ShapeLinearLayout bS;
    private View bT;
    private ShapeRelativeLayout bU;
    private ImageView bV;
    private ImageView bW;
    private ImageView bX;
    private ShapeRelativeLayout bY;
    private LinearLayout bZ;
    private ShapeLinearLayout ba;
    private LinearLayout bb;
    private ImageView bc;
    private TextView bd;
    private ShapeLinearLayout be;
    private View bf;
    private ConstraintLayout bg;
    private ScrollView bh;
    private TextView bi;
    private TextView bj;
    private ShapeLinearLayout bk;
    private TextView bl;
    private TextView bm;
    private ShapeLinearLayout bn;
    private TextView bo;
    private TextView bp;
    private ShapeLinearLayout bq;
    private ShapeLinearLayout br;
    private FrameLayout bs;
    private LinearLayout bt;
    private ImageView bu;
    private TextView bv;
    private LinearLayout bw;
    private RecyclerView bx;
    private LinearLayout by;
    private View bz;
    private BluedPopupWindow cC;
    private ImageView ca;
    private ShapeTextView cb;
    private LinearLayout cc;
    private LinearLayout cd;
    private EmoticonsPageView ce;
    private EmoticonsIndicatorView cf;
    private TextView cg;
    private EmoticonsToolBarView ch;
    private LinearLayout ci;
    private SwitchPanelRelativeLayout cj;
    private ResizeLinearLayout ck;
    private Context cl;
    private View cm;

    /* renamed from: cn  reason: collision with root package name */
    private AtChooseUserHelper f59cn;
    private FeedListAdapterForRecyclerView co;
    private FeedDetailsCommentListAdapter cp;
    private FeedDetailsLikeListAdapter cq;
    private FeedDetailsRepostListAdapter cr;
    private LoadOptions cs;
    private int ct;
    private int cu;
    private int cv;
    private int cw;
    private View k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private FollowStatusView o;
    private ImageView p;
    private TextView q;
    private ConstraintLayout r;
    private ImageView s;
    private TextView t;
    private ImageView u;
    private ImageView v;
    private ConstraintLayout w;
    private ImageView x;
    private ImageView y;
    private ImageView z;
    private boolean cx = true;
    private boolean cy = true;
    private boolean cz = true;
    private RecyclerView.OnScrollListener cA = new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.8
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FeedDetailsFragment.this.co == null || FeedDetailsFragment.this.co.s == null) {
                return;
            }
            FeedDetailsFragment.this.co.s.onScrollStateChanged(recyclerView, i);
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FeedDetailsFragment.this.co == null || FeedDetailsFragment.this.co.s == null) {
                return;
            }
            FeedDetailsFragment.this.co.s.onScrolled(recyclerView, i, i2);
        }
    };
    private TextWatcher cB = new TextWatcher() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.13
        private int b;
        private int c;
        private String d;
        private String e;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = FeedDetailsFragment.this.bR.getSelectionStart();
            this.c = FeedDetailsFragment.this.bR.getSelectionEnd();
            FeedDetailsFragment.this.bR.removeTextChangedListener(FeedDetailsFragment.this.cB);
            if (!FeedDetailsFragment.this.f59cn.a(FeedDetailsFragment.this, this.d, this.e, editable, this.c)) {
                FeedDetailsFragment.this.bR.setSelection(this.b);
            }
            FeedDetailsFragment.this.bR.addTextChangedListener(FeedDetailsFragment.this.cB);
            FeedDetailsFragment.this.J();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.d = ((Object) charSequence) + "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.e = ((Object) charSequence) + "";
        }
    };
    private LikeGuideRunnable cD = new LikeGuideRunnable();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/FeedDetailsFragment$LikeGuideRunnable.class */
    public class LikeGuideRunnable implements Runnable {
        private LikeGuideRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedDetailsFragment.this.Z();
        }
    }

    private void A() {
        this.k = this.i.findViewById(R.id.top_bar);
        this.l = (ImageView) this.i.findViewById(R.id.bar_back);
        this.m = (ImageView) this.i.findViewById(R.id.bar_header);
        this.n = (TextView) this.i.findViewById(R.id.bar_name);
        this.o = (FollowStatusView) this.i.findViewById(R.id.bar_follow);
        this.p = (ImageView) this.i.findViewById(R.id.bar_more);
        this.q = (TextView) this.i.findViewById(R.id.bar_title);
        this.r = this.i.findViewById(R.id.title_bar);
        this.s = (ImageView) this.i.findViewById(R.id.iv_visible);
        this.t = (TextView) this.i.findViewById(R.id.tv_visible);
        this.u = (ImageView) this.i.findViewById(R.id.visible_menu_view);
        this.v = (ImageView) this.i.findViewById(R.id.img_promotion_bubble);
        this.w = this.i.findViewById(R.id.feed_visible);
        this.x = (ImageView) this.i.findViewById(R.id.feed_dynamic_skin);
        this.y = (ImageView) this.i.findViewById(R.id.header_view);
        this.z = (ImageView) this.i.findViewById(R.id.img_live);
        this.A = (ImageView) this.i.findViewById(R.id.img_anonymous);
        this.B = (ImageView) this.i.findViewById(R.id.img_verify);
        this.C = (ImageView) this.i.findViewById(R.id.img_online);
        this.D = (ImageView) this.i.findViewById(R.id.iv_avatar_widget);
        this.E = (TextView) this.i.findViewById(R.id.name_view);
        this.F = (ImageView) this.i.findViewById(R.id.img_name_verify);
        this.G = (ImageView) this.i.findViewById(R.id.img_blued_medal);
        this.H = (TextView) this.i.findViewById(R.id.tv_feed_ad);
        this.I = (ImageView) this.i.findViewById(R.id.img_feed_ad_arrow);
        this.J = (LinearLayout) this.i.findViewById(R.id.ll_ad_option);
        this.K = (ImageView) this.i.findViewById(R.id.menu_view);
        this.L = (FollowStatusView) this.i.findViewById(R.id.follow_status_view);
        this.M = (ImageView) this.i.findViewById(R.id.img_feed_sticky);
        this.N = (TextView) this.i.findViewById(R.id.tv_read_num);
        this.O = (ShapeLinearLayout) this.i.findViewById(R.id.ll_read);
        this.P = (ImageView) this.i.findViewById(R.id.iv_read_extend);
        this.Q = (LinearLayout) this.i.findViewById(R.id.ll_read_num);
        this.R = (TextView) this.i.findViewById(R.id.tv_feed_recommend_source);
        this.S = (TextView) this.i.findViewById(R.id.tv_user_kol);
        this.T = (ShapeFrameLayout) this.i.findViewById(R.id.dot_icon_recommend);
        this.U = (TextView) this.i.findViewById(R.id.distance_view);
        this.V = (ShapeFrameLayout) this.i.findViewById(R.id.dot_icon_distance);
        this.W = (TextView) this.i.findViewById(R.id.time_view);
        this.X = (ShapeFrameLayout) this.i.findViewById(R.id.dot_age_height_weight);
        this.Y = (TextView) this.i.findViewById(R.id.tv_age_height_weight);
        this.Z = (LinearLayout) this.i.findViewById(R.id.ll_distance_and_time);
        this.aa = this.i.findViewById(R.id.feed_user_info);
        this.ab = (TextView) this.i.findViewById(R.id.feed_detail_user_ip_location);
        this.ac = this.i.findViewById(R.id.feed_interact_layout);
        this.ad = (TextView) this.i.findViewById(R.id.feed_interact_num_tv);
        this.ae = (ImageView) this.i.findViewById(R.id.feed_interact_iv_static);
        this.af = this.i.findViewById(R.id.feed_mine_visit_num_layout);
        this.ag = (TextView) this.i.findViewById(R.id.feed_mine_visit_num_tv);
        this.ah = (ImageView) this.i.findViewById(R.id.feed_mine_visit_num_iv);
        this.ai = (FlowLayout) this.i.findViewById(R.id.flow_layout_topics_and_hot);
        this.aj = (ShapeLinearLayout) this.i.findViewById(R.id.layout_super_topic);
        this.ak = this.i.findViewById(R.id.layout_event_score);
        this.al = (ImageView) this.i.findViewById(R.id.iv_score_1);
        this.am = (ImageView) this.i.findViewById(R.id.iv_score_2);
        this.an = (ImageView) this.i.findViewById(R.id.iv_score_3);
        this.ao = (ImageView) this.i.findViewById(R.id.iv_score_4);
        this.ap = (ImageView) this.i.findViewById(R.id.iv_score_5);
        this.aq = (TextView) this.i.findViewById(R.id.tv_event_evaluate);
        this.ar = this.i.findViewById(R.id.layout_feed_event_card);
        this.as = (ImageView) this.i.findViewById(R.id.iv_event_card_avatar);
        this.at = (TextView) this.i.findViewById(R.id.tv_event_card_name);
        this.au = (ImageView) this.i.findViewById(R.id.iv_event_card_owner);
        this.av = (TextView) this.i.findViewById(R.id.tv_event_card_owner);
        this.aw = this.i.findViewById(R.id.layout_sub_owner_event);
        this.ax = this.i.findViewById(R.id.layout_more_event);
        this.ay = (TextView) this.i.findViewById(R.id.tv_more_event);
        RecyclerView findViewById = this.i.findViewById(R.id.rv_more_event);
        this.az = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.cl, 0, false));
        EventMoreAdapter eventMoreAdapter = new EventMoreAdapter(getFragmentActive());
        this.aA = eventMoreAdapter;
        eventMoreAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.1
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EventDetailsModel eventDetailsModel = (EventDetailsModel) baseQuickAdapter.getItem(i);
                FeedDetailsFragment.this.c(eventDetailsModel.id);
                EventTrackFeed.b(FeedProtos.Event.ACTIVITY_FEED_DETAIL_SAME_ACTIVITY_CLICK, eventDetailsModel.id, i + 1);
            }
        });
        this.az.setAdapter(this.aA);
        this.aB = this.i.findViewById(R.id.repost_content_view);
        this.aC = (RelativeLayout) this.i.findViewById(R.id.repost_layout);
        this.aD = this.i.findViewById(R.id.content_view);
        this.aE = (ImageView) this.i.findViewById(R.id.image_one);
        this.aF = (ShapeTextView) this.i.findViewById(R.id.stv_long_pic_icon);
        this.aG = this.i.findViewById(R.id.cv_image_one);
        this.aH = this.i.findViewById(R.id.image_two_four);
        this.aI = this.i.findViewById(R.id.image_other);
        this.aJ = (PLVideoPageView) this.i.findViewById(R.id.video_view);
        this.aK = this.i.findViewById(R.id.card_video);
        this.aL = (ImageView) this.i.findViewById(R.id.img_web_share);
        this.aM = (LinearLayout) this.i.findViewById(R.id.view_share_corner);
        this.aN = (ShapeTextView) this.i.findViewById(R.id.view_circle_corner);
        this.aO = (TextView) this.i.findViewById(R.id.tv_web_share_content);
        this.aP = (TextView) this.i.findViewById(R.id.tv_web_share_title_right);
        this.aQ = (TextView) this.i.findViewById(R.id.tv_web_share_desc);
        this.aR = (LinearLayout) this.i.findViewById(R.id.layout_forward_bg);
        this.aS = (LinearLayout) this.i.findViewById(R.id.forward_event);
        this.aT = (TextView) this.i.findViewById(R.id.forward_event_time);
        this.aU = (ImageView) this.i.findViewById(R.id.iv_event_address);
        this.aV = (TextView) this.i.findViewById(R.id.forward_event_location);
        this.aW = (ShapeTextView) this.i.findViewById(R.id.stv_event_state);
        this.aX = (ImageView) this.i.findViewById(R.id.img_event_icon);
        this.aY = this.i.findViewById(R.id.cv_web_share);
        this.aZ = this.i.findViewById(R.id.feed_vote);
        this.ba = (ShapeLinearLayout) this.i.findViewById(R.id.ll_content_all);
        this.bb = (LinearLayout) this.i.findViewById(R.id.feed_info);
        this.bc = (ImageView) this.i.findViewById(R.id.location_icon);
        this.bd = (TextView) this.i.findViewById(R.id.location_text);
        this.be = (ShapeLinearLayout) this.i.findViewById(R.id.location_layout);
        this.bf = this.i.findViewById(R.id.feed_location);
        this.bg = this.i.findViewById(R.id.feed);
        this.bh = (ScrollView) this.i.findViewById(R.id.sv_header);
        this.bi = (TextView) this.i.findViewById(R.id.zan_text);
        this.bj = (TextView) this.i.findViewById(R.id.zan_num_text);
        this.bk = (ShapeLinearLayout) this.i.findViewById(R.id.ll_like);
        this.bl = (TextView) this.i.findViewById(R.id.comment_text);
        this.bm = (TextView) this.i.findViewById(R.id.comment_num_text);
        this.bn = (ShapeLinearLayout) this.i.findViewById(R.id.ll_comment);
        this.bo = (TextView) this.i.findViewById(R.id.repost_text);
        this.bp = (TextView) this.i.findViewById(R.id.repost_num_text);
        this.bq = (ShapeLinearLayout) this.i.findViewById(R.id.ll_repost);
        this.br = (ShapeLinearLayout) this.i.findViewById(R.id.ll_tab);
        this.bs = (FrameLayout) this.i.findViewById(R.id.layout_tab);
        this.bt = (LinearLayout) this.i.findViewById(R.id.ll_refresh);
        this.bu = (ImageView) this.i.findViewById(R.id.iv_no_data);
        this.bv = (TextView) this.i.findViewById(R.id.tv_no_data);
        this.bw = (LinearLayout) this.i.findViewById(R.id.ll_no_data);
        this.bx = this.i.findViewById(R.id.recycler_view);
        this.by = (LinearLayout) this.i.findViewById(R.id.ll_more_comment);
        this.bz = this.i.findViewById(R.id.banner_line);
        this.bA = (FrameLayout) this.i.findViewById(R.id.fl_ad);
        this.bB = this.i.findViewById(R.id.similar_feed_layout);
        this.bC = this.i.findViewById(R.id.similar_feed_rv);
        this.bC.setLayoutManager(new LinearLayoutManager(getContext()));
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = new FeedListAdapterForRecyclerView(getContext(), this, this.bC, 14);
        this.bD = feedListAdapterForRecyclerView;
        feedListAdapterForRecyclerView.setEnableLoadMore(false);
        this.bC.setAdapter(this.bD);
        this.bE = this.i.findViewById(R.id.recommend_feed_layout);
        this.bF = (TextView) this.i.findViewById(R.id.tv_recommend);
        this.bG = this.i.findViewById(R.id.rv_feed);
        this.bH = this.i.findViewById(R.id.view_place);
        this.bI = (ConsecutiveScrollerLayout) this.i.findViewById(R.id.csl_view);
        this.bJ = this.i.findViewById(R.id.refresh_layout);
        this.bK = this.i.findViewById(R.id.keyboard_view);
        this.bL = (ImageView) this.i.findViewById(R.id.feed_comment_input_avatar);
        this.bM = this.i.findViewById(R.id.feed_comment_input_emotion_lo);
        this.bN = (ImageView) this.i.findViewById(R.id.feed_comment_input_emotion_0);
        this.bO = (ImageView) this.i.findViewById(R.id.feed_comment_input_emotion_1);
        this.bP = (ImageView) this.i.findViewById(R.id.feed_comment_input_emotion_2);
        this.bQ = (LinearLayout) this.i.findViewById(R.id.feed_comment_quick_emotions_lo);
        this.bR = (EmojiEditText) this.i.findViewById(R.id.edit_view);
        this.bS = (ShapeLinearLayout) this.i.findViewById(R.id.edit_layout);
        this.bW = (ImageView) this.i.findViewById(R.id.feed_detail_like_guide_iv);
        this.bV = (ImageView) this.i.findViewById(R.id.icon_like);
        this.bT = this.i.findViewById(R.id.feed_like_parent_layout);
        this.bU = (ShapeRelativeLayout) this.i.findViewById(R.id.feed_like_layout);
        this.bX = (ImageView) this.i.findViewById(R.id.icon_share);
        this.bY = (ShapeRelativeLayout) this.i.findViewById(R.id.ll_details_share);
        this.bZ = (LinearLayout) this.i.findViewById(R.id.layout_like_share);
        this.ca = (ImageView) this.i.findViewById(R.id.expression_btn);
        this.cb = (ShapeTextView) this.i.findViewById(R.id.send_btn);
        this.cc = (LinearLayout) this.i.findViewById(R.id.layout_comment);
        this.cd = (LinearLayout) this.i.findViewById(R.id.input_layout_up);
        this.ce = (EmoticonsPageView) this.i.findViewById(R.id.view_epv);
        this.cf = (EmoticonsIndicatorView) this.i.findViewById(R.id.view_eiv);
        this.cg = (TextView) this.i.findViewById(R.id.line);
        this.ch = (EmoticonsToolBarView) this.i.findViewById(R.id.view_etv);
        this.ci = (LinearLayout) this.i.findViewById(R.id.emoticon_layout);
        this.cj = (SwitchPanelRelativeLayout) this.i.findViewById(R.id.emoticon_layout_root);
        this.ck = (ResizeLinearLayout) this.i.findViewById(R.id.keyboardRelativeLayout);
    }

    private void A(BluedIngSelfFeed bluedIngSelfFeed) {
        if (!D(bluedIngSelfFeed)) {
            this.x.setVisibility(8);
            return;
        }
        this.x.setVisibility(0);
        ImageLoader.a(getFragmentActive(), CommunityServiceManager.e().c(bluedIngSelfFeed.theme_id)).a(this.x);
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$AEgQVm_mxR9LS6AyL-RUjo7zJ7w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.c(view);
            }
        });
    }

    private void B() {
        View a = CommunityServiceManager.e().a(getContext());
        this.cm = a;
        if (a != null) {
            a.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.bA.addView(this.cm);
        }
    }

    private void B(BluedIngSelfFeed bluedIngSelfFeed) {
        if (!C(bluedIngSelfFeed)) {
            this.D.setVisibility(8);
            return;
        }
        this.D.setVisibility(0);
        ImageLoader.a(getFragmentActive(), CommunityServiceManager.e().d(bluedIngSelfFeed.theme_pendant)).a(this.D);
    }

    private void C() {
        this.bI.setOnVerticalScrollChangeListener(new ConsecutiveScrollerLayout.OnScrollChangeListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.3
            @Override // com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout.OnScrollChangeListener
            public void a(View view, int i, int i2, int i3) {
                Logger.c("cslView", "onScrollChange: view = " + view.getClass() + "  scrollY = " + i + "  oldScrollY = " + i2 + "  scrollState = " + i3);
                if (FeedDetailsFragment.this.w == null || FeedDetailsFragment.this.aa == null) {
                    return;
                }
                float height = (FeedDetailsFragment.this.w.getHeight() + FeedDetailsFragment.this.aa.getHeight()) / 2.0f;
                if (height == 0.0f) {
                    return;
                }
                float f = i;
                if (f < height) {
                    FeedDetailsFragment.this.q.setAlpha(1.0f - (f / height));
                    FeedDetailsFragment.this.m.setAlpha(0.0f);
                    FeedDetailsFragment.this.n.setAlpha(0.0f);
                    FeedDetailsFragment.this.o.setAlpha(0.0f);
                } else if (f < height || f >= 2.0f * height) {
                    FeedDetailsFragment.this.q.setAlpha(0.0f);
                    FeedDetailsFragment.this.m.setAlpha(1.0f);
                    FeedDetailsFragment.this.n.setAlpha(1.0f);
                    FeedDetailsFragment.this.o.setAlpha(1.0f);
                } else {
                    float f2 = (f - height) / height;
                    FeedDetailsFragment.this.q.setAlpha(0.0f);
                    FeedDetailsFragment.this.m.setAlpha(f2);
                    FeedDetailsFragment.this.n.setAlpha(f2);
                    FeedDetailsFragment.this.o.setAlpha(f2);
                }
            }
        });
    }

    private boolean C(BluedIngSelfFeed bluedIngSelfFeed) {
        return bluedIngSelfFeed.theme_pendant != 0;
    }

    private void D() {
        ShapeHelper.b(this.bS, R.color.syc_x);
        ShapeHelper.b(this.bU, R.color.syc_x);
        ShapeHelper.b(this.bY, R.color.syc_x);
        this.t.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_i));
        ShapeHelper.b(this.O, R.color.syc_x);
        ShapeHelper.b(this.br, R.color.syc_x);
        ShapeHelper.b(this.bk, R.color.syc_x);
        ShapeHelper.b(this.bn, R.color.syc_y);
        ShapeHelper.b(this.bq, R.color.syc_x);
        this.bJ.setBackgroundColor(BluedSkinUtils.a(this.cl, R.color.syc_b));
        this.u.setVisibility(8);
        this.bg.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                KeyboardUtils.a((Activity) FeedDetailsFragment.this.getActivity());
            }
        });
        final List<EmoticonModel> e = EmotionManager.e();
        if (e.size() > 2) {
            int identifier = getResources().getIdentifier(e.get(2).original, "drawable", this.cl.getPackageName());
            if (identifier != 0) {
                this.bP.setImageResource(identifier);
                this.bP.setVisibility(0);
                this.bP.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$-SdrghIfMoiXINDPal7RLMhfK4I
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedDetailsFragment.this.c(e, view);
                    }
                });
            }
        } else {
            this.bP.setVisibility(8);
        }
        if (e.size() > 1) {
            int identifier2 = getResources().getIdentifier(e.get(1).original, "drawable", this.cl.getPackageName());
            if (identifier2 != 0) {
                this.bO.setImageResource(identifier2);
                this.bO.setVisibility(0);
                this.bO.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$bzSz2kKVWV9k-BS5bTiSdP6i55A
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedDetailsFragment.this.b(e, view);
                    }
                });
            }
        } else {
            this.bO.setVisibility(8);
        }
        if (e.size() > 0) {
            int identifier3 = getResources().getIdentifier(e.get(0).original, "drawable", this.cl.getPackageName());
            if (identifier3 != 0) {
                this.bN.setImageResource(identifier3);
                this.bN.setVisibility(0);
                this.bN.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$2Q6wcssWX2Ylr1arPhzuEXsoOMk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedDetailsFragment.this.a(e, view);
                    }
                });
            }
        } else {
            this.bN.setVisibility(8);
        }
        if (e.size() > 0) {
            this.bM.setVisibility(0);
        } else {
            this.bM.setVisibility(8);
        }
        int c = (AppInfo.l - FeedMethods.c(206)) / 5;
        int c2 = FeedMethods.c(27);
        this.bQ.removeAllViews();
        int min = Math.min(6, e.size());
        for (int i = 0; i < min; i++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c2, c2);
            if (i != min - 1) {
                layoutParams.rightMargin = c;
            }
            final EmoticonModel emoticonModel = e.get(i);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$KYH1qJFUnaDG8eQbKbPnXYmTVdg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedDetailsFragment.this.a(emoticonModel, view);
                }
            });
            int identifier4 = getResources().getIdentifier(emoticonModel.original, "drawable", this.cl.getPackageName());
            if (identifier4 != 0) {
                imageView.setImageResource(identifier4);
            }
            this.bQ.addView(imageView, layoutParams);
        }
        if (CommunityManager.a.a().s()) {
            this.ae.setImageResource(R.drawable.feed_interact_static_dark);
        } else {
            this.ae.setImageResource(R.drawable.feed_interact_static);
        }
        this.bL.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$Qp7RcY6NB69nujIOcTD6pSUNAzQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.g(view);
            }
        });
        this.bT.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$RcP1Kk9XLjVyo8UoPRiqzDmoipM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.f(view);
            }
        });
    }

    private boolean D(BluedIngSelfFeed bluedIngSelfFeed) {
        Log.v("drb", "hasDynamicSkin feed.theme_id:" + bluedIngSelfFeed.theme_id);
        return bluedIngSelfFeed.theme_id != 0;
    }

    private void E() {
        this.bJ.setBackgroundColor(BluedSkinUtils.a(this.cl, R.color.syc_c));
        this.bJ.c(true);
        this.bJ.b(true);
        this.bu.setImageResource(R.drawable.icon_no_data_comment);
        this.bv.setText(R.string.load_more_loading);
        this.bw.setVisibility(8);
        this.bt.setVisibility(0);
        this.bJ.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.5
            public void onLoadMore(RefreshLayout refreshLayout) {
                ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).e();
            }
        });
        this.bx.setLayoutManager(new LinearLayoutManager(getContext()));
        if (this.cq == null) {
            this.cq = new FeedDetailsLikeListAdapter(this.cl, getFragmentActive(), "feed_detail");
        }
        this.cq.setEnableLoadMore(false);
        if (this.cr == null) {
            this.cr = new FeedDetailsRepostListAdapter(this.cl, getFragmentActive(), "feed_detail");
        }
        this.cr.setEnableLoadMore(false);
        FeedDetailsCommentListAdapter feedDetailsCommentListAdapter = new FeedDetailsCommentListAdapter(this.cl, getFragmentActive(), "feed_detail");
        this.cp = feedDetailsCommentListAdapter;
        feedDetailsCommentListAdapter.bindToRecyclerView(this.bx);
        this.cp.a(new FeedDetailsCommentListAdapter.FeedCommentListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.6
            @Override // com.blued.community.ui.comment.adapter.FeedDetailsCommentListAdapter.FeedCommentListener
            public void a(FeedComment feedComment) {
                ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).d(false);
                ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).g(feedComment.comment_id);
                ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).f(feedComment.user_name);
                String string = FeedDetailsFragment.this.cl.getResources().getString(R.string.reply);
                EmojiEditText emojiEditText = FeedDetailsFragment.this.bR;
                emojiEditText.setHint(string + feedComment.user_name + ":");
                FeedDetailsFragment.this.cd.setVisibility(0);
                FeedDetailsFragment.this.bR.requestFocus();
                KeyboardUtils.c(FeedDetailsFragment.this.getActivity());
            }
        });
        this.cp.setEnableLoadMore(false);
        this.bx.setAdapter(this.cp);
        if (this.co == null) {
            this.co = new FeedListAdapterForRecyclerView(getContext(), this, this.bG, 14);
        }
        this.co.setEnableLoadMore(false);
        this.by.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.b(FeedProtos.Event.FEED_DETAIL_COMMENT_MORE_CLICK, ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).p().feed_id);
                ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).a(true);
                ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).f();
            }
        }));
        this.bG.setLayoutManager(new LinearLayoutManager(getContext()));
        this.bG.setAdapter(this.co);
        this.bG.addOnScrollListener(this.cA);
    }

    private void E(BluedIngSelfFeed bluedIngSelfFeed) {
        if (TextUtils.isEmpty(bluedIngSelfFeed.kol_name)) {
            this.S.setVisibility(8);
        } else {
            this.S.setVisibility(0);
            this.S.setText(bluedIngSelfFeed.kol_name);
        }
        boolean z = true;
        if (bluedIngSelfFeed.feed_bubble_type > 0) {
            this.U.setVisibility(0);
            this.U.setText(bluedIngSelfFeed.getFeedBubbleStringID());
        } else if (bluedIngSelfFeed.is_recommend_ticktocks != 1 || TextUtils.isEmpty(bluedIngSelfFeed.recommend_text)) {
            this.R.setVisibility(8);
            if (UserInfoUtils.c().equals(bluedIngSelfFeed.feed_uid)) {
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
                String distance = bluedIngSelfFeed.getFeedParse(this.cl, ((FeedDetailsPresenter) j()).w()).getDistance();
                if (TextUtils.isEmpty(distance)) {
                    this.U.setText("");
                    this.U.setVisibility(8);
                } else {
                    this.U.setText(distance);
                }
                DistanceUtils.a(this.cl, this.U, bluedIngSelfFeed.is_hide_distance, 0, false);
            }
        } else {
            this.U.setVisibility(8);
            this.R.setVisibility(0);
            this.R.setText(bluedIngSelfFeed.recommend_text);
        }
        if (TextUtils.isEmpty(bluedIngSelfFeed.feed_timestamp)) {
            this.W.setText("");
        } else {
            String e = TimeAndDateUtils.e(this.cl, TimeAndDateUtils.c(bluedIngSelfFeed.feed_timestamp));
            if (TextUtils.isEmpty(e)) {
                this.W.setText("");
            } else {
                this.W.setText(e);
            }
        }
        if (TextUtils.isEmpty(((Object) this.W.getText()) + "")) {
            this.W.setVisibility(4);
        } else {
            this.W.setVisibility(0);
        }
        boolean z2 = this.R.getVisibility() == 0;
        boolean z3 = this.U.getVisibility() == 0;
        if (this.W.getVisibility() != 0) {
            z = false;
        }
        if (z2 && ((z3 || z) && bluedIngSelfFeed.feed_bubble_type == 0)) {
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
        }
        if (z3 && z) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
        if (this.U.getVisibility() == 0 || this.W.getVisibility() == 0) {
            this.Z.setVisibility(0);
        } else {
            this.Z.setVisibility(8);
        }
    }

    private void F() {
        a(this.cj, this.ck, (EditText) this.bR, this.ci);
        this.bY.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedDetailsFragment.this.I();
            }
        });
        this.cb.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedDetailsFragment.this.G();
            }
        }));
        this.ca.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$cHx0sz_nYLYcyiOtew6F1NPzTvM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.e(view);
            }
        });
        this.bR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(256)});
        this.bR.addTextChangedListener(this.cB);
        EditTextHeightAnimHelper.a(this.bR, 1.0f, 3.5f);
        w();
        this.bR.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (!z || ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).p() == null) {
                    return;
                }
                EventTrackFeed.a(FeedProtos.Event.FEED_COMMENT_BOX_CLICK, ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).p().feed_id, FeedProtos.Location.FEED_DETAIL);
            }
        });
        J();
    }

    private void F(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed.feed_is_delete == 1) {
            H(bluedIngSelfFeed);
        } else {
            G(bluedIngSelfFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (((FeedDetailsPresenter) j()).w() == 6 && FeedMethods.a(((FeedDetailsPresenter) j()).p())) {
            ((FeedDetailsPresenter) j()).p().is_top = ((FeedDetailsPresenter) j()).j;
        }
        EventTrackFeed.a(((FeedDetailsPresenter) j()).p(), ((FeedDetailsPresenter) j()).w(), ((FeedDetailsPresenter) j()).p().super_did != null ? ((FeedDetailsPresenter) j()).p().super_did : "");
        String obj = this.bR.getText().toString();
        if (TextUtils.isEmpty(obj.trim())) {
            AppMethods.d(R.string.feed_null);
            return;
        }
        if (((FeedDetailsPresenter) j()).p() != null) {
            EventTrackFeed.a(FeedProtos.Event.FEED_INTERACTIVE, ((FeedDetailsPresenter) j()).p().feed_id, FeedProtos.InteractiveType.COMMENT, FeedProtos.Location.FEED_DETAIL, ((FeedDetailsPresenter) j()).C(), ((FeedDetailsPresenter) j()).p().feed_uid);
        }
        ((FeedDetailsPresenter) j()).d(this.f59cn.b(obj));
        AppInfo.n().removeCallbacks(this.cD);
    }

    private void G(BluedIngSelfFeed bluedIngSelfFeed) {
        if (((FeedDetailsPresenter) j()).t()) {
            this.aC.setVisibility(0);
            ShapeHelper.b(this.ba, R.color.syc_x);
            int a = DensityUtils.a(this.cl, 10.0f);
            this.ba.setPadding(a, a, a, a);
        } else {
            this.aC.setVisibility(8);
            ShapeHelper.b(this.ba, R.color.transparent);
            this.ba.setPadding(0, 0, 0, 0);
        }
        CharSequence charSequence = "";
        if (((FeedDetailsPresenter) j()).t()) {
            CharSequence feedRepostContent = ((FeedDetailsPresenter) j()).r().getFeedRepostContent();
            if (TextUtils.isEmpty(((FeedDetailsPresenter) j()).p().super_tag_image) || !TextUtils.isEmpty(feedRepostContent)) {
                charSequence = feedRepostContent;
            }
            a(this.aC, this.aB, charSequence, ((FeedDetailsPresenter) j()).p().super_tag_image);
            this.aD.setVisibility(0);
            a(this.ba, this.aD, ((FeedDetailsPresenter) j()).r().getFeedContent(), (String) null);
            this.ba.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.52
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FeedDetailsFragment.a(FeedDetailsFragment.this.cl, ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).u(), -1, new FeedDetailParams(((FeedDetailsPresenter) FeedDetailsFragment.this.j()).y()));
                }
            });
        } else if (TextUtils.isEmpty(((FeedDetailsPresenter) j()).u().feed_content) && TextUtils.isEmpty(((FeedDetailsPresenter) j()).p().super_tag_image)) {
            this.aD.setVisibility(8);
        } else {
            CharSequence feedContent = ((FeedDetailsPresenter) j()).r().getFeedContent();
            if (TextUtils.isEmpty(((FeedDetailsPresenter) j()).p().super_tag_image) || !TextUtils.isEmpty(feedContent)) {
                charSequence = feedContent;
            }
            a(this.ba, this.aD, charSequence, ((FeedDetailsPresenter) j()).p().super_tag_image);
            this.aD.setVisibility(0);
        }
    }

    private void H() {
        if (((FeedDetailsPresenter) j()).w() == 6 && FeedMethods.a(((FeedDetailsPresenter) j()).p())) {
            ((FeedDetailsPresenter) j()).p().is_top = ((FeedDetailsPresenter) j()).j;
        }
        EventTrackFeed.a(((FeedDetailsPresenter) j()).p(), EventTrackFeed.h(((FeedDetailsPresenter) j()).w()), ((FeedDetailsPresenter) j()).m);
        if (1 == ((FeedDetailsPresenter) j()).p().iliked) {
            y();
            return;
        }
        x();
        CommunityServiceManager.d().a(((FeedDetailsPresenter) j()).x(), ((FeedDetailsPresenter) j()).p(), "", -1);
    }

    private void H(BluedIngSelfFeed bluedIngSelfFeed) {
        ShapeHelper.b(this.ba, R.color.syc_x);
        int a = DensityUtils.a(this.cl, 10.0f);
        this.ba.setPadding(a, a, a, a);
        this.ba.setVisibility(0);
        if (TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
            this.aC.setVisibility(8);
        } else {
            this.aC.setVisibility(0);
            a(this.aC, this.aB, ((FeedDetailsPresenter) j()).r().getFeedContent(), (String) null);
        }
        CharSequence a2 = StringUtils.a(StringUtils.a(((FeedDetailsPresenter) j()).u().feed_limit_desc, (int) this.aD.getTextSize(), 0), true, new boolean[0]);
        this.aD.setMaxLines(5);
        this.aD.setExpandText(a2);
        this.aD.setMovementMethod(LinkMovementClickMethod.a());
        this.aD.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (((FeedDetailsPresenter) j()).p().reading_scope != 0 && ((FeedDetailsPresenter) j()).p().is_vote == 1) {
            AppMethods.d(R.string.feed_votes_not_share);
            return;
        }
        CommunityServiceManager.d().c(((FeedDetailsPresenter) j()).x(), ((FeedDetailsPresenter) j()).p(), "", -1);
        if (this.bY.getTag() != null) {
            ImageFileLoader.a(getFragmentActive()).b(this.bY.getTag() != null ? (String) this.bY.getTag() : "").a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.12
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public void onUIFinish(File file, Exception exc) {
                    FeedDetailsFragment.this.a((file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath()));
                }
            }).a();
        } else {
            a((Bitmap) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (TextUtils.isEmpty(this.bR.getText())) {
            this.cb.setAlpha(0.3f);
        } else {
            this.cb.setAlpha(1.0f);
        }
    }

    private void K() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(EmotionManager.g());
        this.ch.setModel(true);
        this.ch.a(getFragmentActive(), arrayList);
        this.ce.a(getFragmentActive(), arrayList);
        this.ce.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.14
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i) {
                FeedDetailsFragment.this.cf.a(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i, int i2) {
                FeedDetailsFragment.this.cf.a(i, i2);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void b(int i) {
                FeedDetailsFragment.this.cf.setIndicatorCount(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void c(int i) {
                FeedDetailsFragment.this.cf.b(i);
            }
        });
        this.ce.setIViewListener(new IViewStateListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.15
            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(int i) {
                FeedDetailsFragment.this.ch.setToolBtnSelect(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(EmoticonModel emoticonModel) {
                FeedDetailsFragment.this.a(emoticonModel, false);
            }
        });
        this.ch.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.16
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                FeedDetailsFragment.this.ce.setPageSelect(i);
            }
        });
    }

    private void L() {
        e();
    }

    private void M() {
        this.bn.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedDetailsFragment.this.c(1);
            }
        });
        this.bk.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedDetailsFragment.this.c(0);
            }
        });
        this.bq.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedDetailsFragment.this.c(2);
            }
        });
    }

    private void N() {
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.height = StatusBarHelper.a(getContext());
        this.k.setLayoutParams(layoutParams);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedDetailsFragment.this.z();
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedDetailsFragment.this.O();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        BluedActionSheet.Builder builder = new BluedActionSheet.Builder(this.cl);
        if (UserInfoUtils.c().equals(((FeedDetailsPresenter) j()).p().feed_uid)) {
            builder.a(ActionSheetDefaultItem.a().a(this.cl.getString(R.string.feed_visible)).a(((FeedDetailsPresenter) j()).p().is_feed_anonym != 1).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$80hV2TuElPjKJQ1BUCmevH8gRhA
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedDetailsFragment.this.i(bluedActionSheet);
                }
            }));
            if (((FeedDetailsPresenter) j()).p().can_promotion == 1) {
                builder.a(ActionSheetDefaultItem.a().a(this.cl.getString(R.string.feed_super_exposure_post)).b(R.drawable.icon_feed_super_exposure_post).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$LVOFbblJ4qqY5vIAj1WNshyLIls
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedDetailsFragment.this.h(bluedActionSheet);
                    }
                }));
            }
            builder.a(this.cl.getString(R.string.comment_setting), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$a6DP00RoMluY7cafappENLsDqvo
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedDetailsFragment.this.g(bluedActionSheet);
                }
            });
            builder.a(ActionSheetDefaultItem.a().a(this.cl.getString(R.string.dynamic_skin_setting)).b(R.drawable.common_icon_vip).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$TViSyHpMOq3j-h1gFLMWTmucH8g
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedDetailsFragment.this.f(bluedActionSheet);
                }
            }));
            builder.a(this.cl.getString(R.string.delete), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$vi9XtJIYY7Q74AqAUC_W20uJ5I4
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedDetailsFragment.this.e(bluedActionSheet);
                }
            });
        } else {
            if (D(((FeedDetailsPresenter) j()).p())) {
                builder.a(ActionSheetDefaultItem.a().a(this.cl.getString(R.string.dynamic_skin_look)).b(R.drawable.common_icon_vip).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$e90Q66qtETHcErPcgFWJtGHT2pY
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedDetailsFragment.this.d(bluedActionSheet);
                    }
                }));
            }
            if (((FeedDetailsPresenter) j()).p().unliked_users_url != null && ((FeedDetailsPresenter) j()).p().unliked_users_url.length > 0) {
                builder.a(this.cl.getString(R.string.dont_like_this_person_feed), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$5zEGEm2E5vsZukV9DBrlhcLafzE
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedDetailsFragment.this.c(bluedActionSheet);
                    }
                });
            }
            if (((FeedDetailsPresenter) j()).p().unliked_url != null && ((FeedDetailsPresenter) j()).p().unliked_url.length > 0) {
                builder.a(this.cl.getString(R.string.dont_like_this_post_feed), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$wV26OjxvfVZ6WID84y7aZ30IdR8
                    @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                    public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                        FeedDetailsFragment.this.b(bluedActionSheet);
                    }
                });
            }
            builder.a(this.cl.getString(R.string.report), new BluedActionSheet.OnClickActionSheetListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$u3KKL7OUNWHnk5nSdpZSOQAQ75s
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    FeedDetailsFragment.this.a(bluedActionSheet);
                }
            });
        }
        builder.d();
    }

    private void P() {
        int i = this.cl.getResources().getDisplayMetrics().widthPixels;
        LoadOptions loadOptions = new LoadOptions();
        this.cs = loadOptions;
        loadOptions.d = R.drawable.defaultpicture;
        this.cs.b = R.drawable.defaultpicture;
        int i2 = i >> 1;
        this.cs.a(i2, i2);
        int a = AppInfo.l - (DensityUtils.a(this.cl, 10.0f) * 2);
        this.ct = a;
        this.cu = (int) (a * 1.5d);
        this.cv = a;
        this.cw = (int) (a * 0.73d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        a(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.32
            @Override // java.lang.Runnable
            public void run() {
                FeedDetailsFragment.this.bR.setFocusable(true);
                FeedDetailsFragment.this.bR.setFocusableInTouchMode(true);
                KeyboardUtils.c(FeedDetailsFragment.this.getActivity());
            }
        }, 200L);
    }

    private void R() {
        b(1);
        if (this.cp.c() > 0) {
            this.bI.scrollTo(0, this.bg.getHeight() + this.bs.getHeight() + 2);
            ViewUtils.a(this.bx, this.cp.c(), DensityUtils.a(this.cl, 55.0f));
        } else {
            this.bI.scrollTo(0, this.bg.getHeight());
        }
        a(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.33
            @Override // java.lang.Runnable
            public void run() {
                FeedDetailsFragment.this.cp.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        T();
        a(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.34
            @Override // java.lang.Runnable
            public void run() {
                FeedDetailsFragment.this.bI.scrollTo(0, FeedDetailsFragment.this.bg.getHeight());
            }
        }, 100L);
    }

    private void T() {
        a(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.35
            @Override // java.lang.Runnable
            public void run() {
                int height = ((((((((AppInfo.m - FeedDetailsFragment.this.bx.getHeight()) - FeedDetailsFragment.this.bA.getHeight()) - FeedDetailsFragment.this.ax.getHeight()) - FeedDetailsFragment.this.bB.getHeight()) - FeedDetailsFragment.this.bC.getHeight()) - FeedDetailsFragment.this.bE.getHeight()) - FeedDetailsFragment.this.bG.getHeight()) - FeedDetailsFragment.this.br.getHeight()) - FeedDetailsFragment.this.r.getHeight();
                if (height <= 0) {
                    FeedDetailsFragment.this.bH.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = FeedDetailsFragment.this.bH.getLayoutParams();
                layoutParams.height = height;
                FeedDetailsFragment.this.bH.setLayoutParams(layoutParams);
                FeedDetailsFragment.this.bH.setVisibility(0);
            }
        });
    }

    private void U() {
        a(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.36
            @Override // java.lang.Runnable
            public void run() {
                FeedDetailsFragment.this.bI.a(FeedDetailsFragment.this.bh, (FeedDetailsFragment.this.bJ.getHeight() / 2) - FeedDetailsFragment.this.bg.getHeight());
                FeedDetailsFragment.this.a(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.36.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedDetailsFragment.this.cp.a();
                    }
                }, 100L);
            }
        }, 300L);
    }

    private void V() {
        ImageLoader.a(getFragmentActive(), UserInfoUtils.e()).b(R.drawable.user_bg_round).c().a(this.bL);
    }

    private void W() {
        this.aw.setVisibility(8);
        AppMethods.d(R.string.event_sub_owner_event_success);
    }

    private void X() {
        GuessLikeFeedPopWindow guessLikeFeedPopWindow = new GuessLikeFeedPopWindow(this.cl, getFragmentActive());
        guessLikeFeedPopWindow.setClickListener(new GuessLikeDialogConfirmAndCancelListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.57
            @Override // com.blued.community.ui.feed.dialog.GuessLikeDialogConfirmAndCancelListener
            public void a() {
                FeedDetailsFragment.this.getActivity().finish();
            }

            @Override // com.blued.community.ui.feed.dialog.GuessLikeDialogConfirmAndCancelListener
            public void a(BluedIngSelfFeed bluedIngSelfFeed) {
                FeedDetailsFragment.a(FeedDetailsFragment.this.cl, bluedIngSelfFeed, -1, new FeedDetailParams(0));
                FeedDetailsFragment.this.getActivity().finish();
            }
        });
        new XPopup.Builder(this.cl).a(PopupAnimation.ScaleAlphaFromCenter).c((Boolean) false).d((Boolean) true).a((BasePopupView) guessLikeFeedPopWindow).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        ((FeedDetailsPresenter) j()).d(true);
        ((FeedDetailsPresenter) j()).g("");
        ((FeedDetailsPresenter) j()).f("");
        this.bR.setText("");
        w();
        this.cc.setVisibility(8);
        this.bK.setVisibility(8);
        if (this.cj.getVisibility() != 8) {
            this.cj.setVisibility(8);
        }
        this.bZ.setVisibility(0);
        KeyboardUtils.a((Activity) getActivity());
        this.bR.clearFocus();
        this.bM.setVisibility(0);
        this.bL.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        LogUtils.c("showLikeGuide");
        AppInfo.n().removeCallbacks(this.cD);
        ImageLoader.c(getFragmentActive(), CommunityManager.a.a().s() ? "feed_detail_like_guide_dark.png" : "feed_detail_like_guide.png").g().g(2).a(this.bW);
        this.bW.setVisibility(0);
        this.bU.setVisibility(8);
        CommunityPreferences.r();
        CommunityPreferences.u();
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, int i, FeedDetailParams feedDetailParams) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("feed_data", bluedIngSelfFeed);
        bundle.putString("feed_comment_id", feedDetailParams.commentID);
        bundle.putInt("show_photo", feedDetailParams.comeCode);
        bundle.putInt("from", i);
        bundle.putInt("feed_is_ads", bluedIngSelfFeed.is_ads);
        bundle.putString("feed_aid", bluedIngSelfFeed.aid);
        bundle.putBoolean("if_from_comment", feedDetailParams.isFromComment);
        bundle.putBoolean("has_comment", feedDetailParams.hasComment);
        bundle.putSerializable("FEED_LIST_PARAMS", feedDetailParams);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, FeedDetailsFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        int w = ((FeedDetailsPresenter) j()).w();
        String str = w != 0 ? w != 6 ? "" : "discovery_square_detail" : "discovery_attention_detail";
        BluedIngSelfFeed p = ((FeedDetailsPresenter) j()).p();
        if (((FeedDetailsPresenter) j()).w() == 6 && FeedMethods.a(p)) {
            p.is_top = ((FeedDetailsPresenter) j()).j;
        }
        CommunityShareUtils.b().a(this.cl, this.y, bitmap, p, str, false, ((FeedDetailsPresenter) j()).x(), "", -1, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        CommRouteUtil.a(this, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final BluedIngSelfFeed bluedIngSelfFeed) {
        this.L.setRelationShip("1");
        this.o.setRelationShip("1");
        CommunityHttpUtils.b(this.cl, new CommunityHttpUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.43
            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void a() {
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
                AppMethods.d(R.string.community_follow_success);
                bluedIngSelfFeed.relationship = "1";
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void b() {
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void c() {
                FeedDetailsFragment.this.L.setRelationShip("0");
                FeedDetailsFragment.this.o.setRelationShip("0");
            }
        }, bluedIngSelfFeed.feed_uid, "shine_video_list", getFragmentActive());
        FeedDetailParams feedDetailParams = (FeedDetailParams) getArguments().getSerializable("FEED_LIST_PARAMS");
        FeedProtos.FollowLocation followLocation = view.getId() == R.id.bar_follow ? FeedProtos.FollowLocation.FOLLOW_FEED_DETAIL_TOP : FeedProtos.FollowLocation.FOLLOW_PLAZA_FEED_DETAIL;
        String str = bluedIngSelfFeed.feed_uid;
        String str2 = bluedIngSelfFeed.feed_id;
        String str3 = bluedIngSelfFeed.super_did;
        boolean z = true;
        boolean z2 = bluedIngSelfFeed.live > 0;
        if (bluedIngSelfFeed.in_promotion != 1) {
            z = false;
        }
        EventTrackFeed.a(str, str2, str3, followLocation, true, z2, z, feedDetailParams == null ? "" : feedDetailParams.strong_insert_data);
    }

    private void a(View view, final TextViewFixTouchForDynamic textViewFixTouchForDynamic, final CharSequence charSequence, final String str) {
        if (TextUtils.isEmpty(str)) {
            textViewFixTouchForDynamic.setText(charSequence);
        } else {
            textViewFixTouchForDynamic.setTag(FeedConstants.a, str);
            ImageFileLoader.a(getFragmentActive()).a(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$gNoVXoW6PpfTerLGGm0NEzKhoo0
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc) {
                    FeedDetailsFragment.a(textViewFixTouchForDynamic, charSequence, str, file, exc);
                }
            }).a();
        }
        textViewFixTouchForDynamic.setMovementMethod(LinkMovementClickMethod.a());
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.53
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                String charSequence2 = textViewFixTouchForDynamic.getText().toString();
                if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
                    ((ClipboardManager) FeedDetailsFragment.this.cl.getSystemService("clipboard")).setText(RegExpUtils.a(charSequence2));
                } else {
                    try {
                        ((android.content.ClipboardManager) FeedDetailsFragment.this.cl.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(charSequence2)));
                    } catch (Exception e) {
                    }
                }
                AppMethods.a((CharSequence) FeedDetailsFragment.this.cl.getResources().getString(R.string.copy));
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(EmoticonModel emoticonModel, View view) {
        a(emoticonModel, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EmoticonModel emoticonModel, boolean z) {
        EmojiEditText emojiEditText;
        if (emoticonModel == null || (emojiEditText = this.bR) == null) {
            return;
        }
        emojiEditText.setFocusable(true);
        this.bR.setFocusableInTouchMode(true);
        this.bR.requestFocus();
        if (emoticonModel.eventType == 1) {
            this.bR.onKeyDown(67, new KeyEvent(0, 67));
        } else if (emoticonModel.eventType == 2) {
        } else {
            if (emoticonModel.emoji == null) {
                this.bR.getText().insert(this.bR.getSelectionStart(), Emotion.a(emoticonModel.code, 12));
            } else {
                this.bR.append(emoticonModel.emoji.a());
            }
            if (z) {
                Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluedActionSheet bluedActionSheet) {
        CommunityServiceManager.b().a(getContext(), CommunityConstants.ReportType.FEED, this.E.getText().toString(), ((FeedDetailsPresenter) j()).o(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        c(bluedIngSelfFeed.activity_data.id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        this.cp.a(((FeedDetailsPresenter) j()).w());
        this.cp.a(bluedIngSelfFeed);
        this.cq.a(bluedIngSelfFeed);
        this.cr.a(bluedIngSelfFeed);
        this.co.c(bluedIngSelfFeed.theme_id);
        this.co.d(bluedIngSelfFeed.theme_pendant);
        v(bluedIngSelfFeed);
        z(bluedIngSelfFeed);
        E(bluedIngSelfFeed);
        F(bluedIngSelfFeed);
        y(bluedIngSelfFeed);
        u(bluedIngSelfFeed);
        t(bluedIngSelfFeed);
        q(bluedIngSelfFeed);
        p(bluedIngSelfFeed);
        o(bluedIngSelfFeed);
        b(bluedIngSelfFeed);
        if (((FeedDetailsPresenter) j()).s()) {
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.37
                @Override // java.lang.Runnable
                public void run() {
                    ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).c(false);
                }
            }, 3000L);
        }
        V();
        if (z && x(bluedIngSelfFeed)) {
            AppInfo.n().removeCallbacks(this.cD);
            AppInfo.n().postDelayed(this.cD, 5000L);
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(FeedEventModel feedEventModel, View view) {
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_SUBSCRIBE_BTN_CLICK, feedEventModel.id, feedEventModel.uid, FeedProtos.SourcePage.FEED_DETAIL_PAGE);
        ((FeedDetailsPresenter) j()).e(feedEventModel.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(TextViewFixTouchForDynamic textViewFixTouchForDynamic, CharSequence charSequence, String str, File file, Exception exc) {
        if (file == null || !file.exists()) {
            textViewFixTouchForDynamic.setText(charSequence);
            return;
        }
        Bitmap a = ImageUtils.a(file, FeedMethods.c(36), FeedMethods.c(16));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("%subject_widget% " + ((Object) charSequence));
        if (a == null || !TextUtils.equals(str, (String) textViewFixTouchForDynamic.getTag(FeedConstants.a))) {
            textViewFixTouchForDynamic.setText(charSequence);
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(a);
        bitmapDrawable.setBounds(0, 0, FeedMethods.c(36), FeedMethods.c(16));
        spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), 0, 16, 33);
        textViewFixTouchForDynamic.setText(spannableStringBuilder);
    }

    private void a(String str, FeedProtos.SourcePage sourcePage) {
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(str);
        eventLogData.setSourcePage(sourcePage);
        EventDetailsFragment.a.a(this.cl, str, eventLogData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<BluedIngSelfFeed> list) {
        this.co.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, View view) {
        a((EmoticonModel) list.get(0), true);
    }

    private void b(int i) {
        if (((FeedDetailsPresenter) j()).n() != i) {
            c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BluedActionSheet bluedActionSheet) {
        CommunityHttpUtils.a(((FeedDetailsPresenter) j()).p().unliked_url);
    }

    private void b(BluedIngSelfFeed bluedIngSelfFeed) {
        this.aG.setVisibility(8);
        this.aH.setVisibility(8);
        this.aI.setVisibility(8);
        this.aK.setVisibility(8);
        this.aY.setVisibility(8);
        this.aZ.setVisibility(8);
        int itemType = bluedIngSelfFeed.getItemType();
        if (itemType != 0) {
            if (itemType == 1) {
                i(bluedIngSelfFeed.getContentData());
                return;
            } else if (itemType == 2) {
                h(bluedIngSelfFeed.getContentData());
                return;
            } else if (itemType == 3) {
                l(bluedIngSelfFeed.getContentData());
                return;
            } else if (itemType == 4) {
                n(bluedIngSelfFeed.getContentData());
                return;
            } else if (itemType == 8) {
                m(bluedIngSelfFeed);
                return;
            } else if (itemType == 10) {
                e(bluedIngSelfFeed.getContentData());
                return;
            } else if (itemType == 15) {
                g(bluedIngSelfFeed.getContentData());
                return;
            } else if (itemType == 17) {
                f(bluedIngSelfFeed.getContentData());
                return;
            } else if (itemType == 20) {
                d(bluedIngSelfFeed.getContentData());
                return;
            } else if (itemType != 28) {
                c(bluedIngSelfFeed.getContentData());
                return;
            }
        }
        j(bluedIngSelfFeed.getContentData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        s(bluedIngSelfFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(FeedEventModel feedEventModel, View view) {
        a(feedEventModel.id, FeedProtos.SourcePage.ACTIVITY_FEED_DETAIL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<FeedComment> list) {
        this.cp.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list, View view) {
        a((EmoticonModel) list.get(1), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        ((FeedDetailsPresenter) j()).a(i);
        if (i == 0) {
            ShapeHelper.b(this.bk, R.color.syc_y);
            ShapeHelper.b(this.bn, R.color.syc_x);
            ShapeHelper.b(this.bq, R.color.syc_x);
            this.bi.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_h));
            this.bj.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_h));
            this.bl.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bm.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bo.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bp.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bx.setAdapter(this.cq);
            this.cq.notifyDataSetChanged();
            if (this.cq.getData().size() <= 0 || !((FeedDetailsPresenter) j()).A().a) {
                p();
            } else {
                o();
            }
            this.by.setVisibility(8);
            this.bz.setVisibility(8);
            this.ax.setVisibility(8);
            this.bB.setVisibility(8);
            this.bC.setVisibility(8);
            this.bE.setVisibility(8);
            this.bG.setVisibility(8);
        } else if (i == 1) {
            ShapeHelper.b(this.bk, R.color.syc_x);
            ShapeHelper.b(this.bn, R.color.syc_y);
            ShapeHelper.b(this.bq, R.color.syc_x);
            this.bi.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bj.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bl.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_h));
            this.bm.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_h));
            this.bo.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bp.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bx.setAdapter(this.cp);
            this.cp.notifyDataSetChanged();
            if (((FeedDetailsPresenter) j()).v()) {
                if (this.co.getData().size() <= 0 || !((FeedDetailsPresenter) j()).A().d) {
                    p();
                } else {
                    o();
                }
            } else if (this.cp.getData().size() <= 0 || !((FeedDetailsPresenter) j()).A().b) {
                p();
            } else {
                o();
            }
            if (this.cp.getData().size() <= 0 || !(((FeedDetailsPresenter) j()).A().b || ((FeedDetailsPresenter) j()).B())) {
                this.by.setVisibility(8);
            } else {
                EventTrackFeed.b(FeedProtos.Event.FEED_DETAIL_COMMENT_MORE_SHOW, ((FeedDetailsPresenter) j()).p().feed_id);
                this.by.setVisibility(0);
            }
            this.bz.setVisibility(0);
            if (this.aA.getData().size() > 0) {
                this.ax.setVisibility(0);
            } else {
                this.ax.setVisibility(8);
            }
            if (this.bD.getData().size() > 0) {
                this.bB.setVisibility(0);
                this.bC.setVisibility(0);
            } else {
                this.bB.setVisibility(8);
                this.bC.setVisibility(8);
            }
            if (this.cp.getData().size() > 0) {
                this.bF.setText(R.string.more_similar_feeds);
            } else {
                this.bF.setText(R.string.feed_details_feed_more_no_comment);
            }
            if (this.co.getData().size() > 0) {
                this.bE.setVisibility(0);
                this.bG.setVisibility(0);
            } else {
                this.bE.setVisibility(8);
                this.bG.setVisibility(8);
            }
        } else if (i == 2) {
            ShapeHelper.b(this.bk, R.color.syc_x);
            ShapeHelper.b(this.bn, R.color.syc_x);
            ShapeHelper.b(this.bq, R.color.syc_y);
            this.bi.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bj.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bl.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bm.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
            this.bo.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_h));
            this.bp.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_h));
            this.bx.setAdapter(this.cr);
            this.cr.notifyDataSetChanged();
            if (this.cr.getData().size() <= 0 || !((FeedDetailsPresenter) j()).A().c) {
                p();
            } else {
                o();
            }
            this.by.setVisibility(8);
            this.bz.setVisibility(8);
            this.ax.setVisibility(8);
            this.bB.setVisibility(8);
            this.bC.setVisibility(8);
            this.bE.setVisibility(8);
            this.bG.setVisibility(8);
        }
        d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        CommunityServiceManager.b().a(this.cl, 0, "dynamic_skin");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(BluedActionSheet bluedActionSheet) {
        CommunityHttpUtils.a(((FeedDetailsPresenter) j()).p().unliked_users_url);
    }

    private void c(BluedIngSelfFeed bluedIngSelfFeed) {
        this.aG.setVisibility(8);
        this.aE.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) this.aD.getLayoutParams()).bottomMargin = DensityUtils.a(this.cl, 2.0f);
        this.aD.setTextColor(BluedSkinUtils.a(this.cl, R.color.syc_j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        CommunityServiceManager.b().a(this.cl, bluedIngSelfFeed.location_lot, bluedIngSelfFeed.location_lat, bluedIngSelfFeed.location);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        a(str, FeedProtos.SourcePage.FEED_DETAIL_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<FeedUserInfoModel> list) {
        this.cq.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(List list, View view) {
        a((EmoticonModel) list.get(2), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (((FeedDetailsPresenter) j()).n() == i) {
            if (i == 0) {
                if (this.cq.getData().size() > 0) {
                    this.bt.setVisibility(8);
                    this.bw.setVisibility(8);
                    return;
                }
                if (((FeedDetailsPresenter) j()).A().e) {
                    this.bu.setImageResource(R.drawable.icon_no_data_load_failed);
                    this.bv.setText(R.string.connecting_failed);
                } else {
                    this.bu.setImageResource(R.drawable.icon_no_data_like);
                    this.bv.setText(R.string.no_content_for_now);
                }
                this.bw.setVisibility(0);
                if (!((FeedDetailsPresenter) j()).A().a) {
                    this.bt.setVisibility(8);
                    return;
                }
                this.bt.setVisibility(0);
                this.bw.setVisibility(8);
            } else if (i == 1) {
                if (this.cp.getData().size() > 0) {
                    this.bt.setVisibility(8);
                    this.bw.setVisibility(8);
                    return;
                }
                if (((FeedDetailsPresenter) j()).A().f) {
                    this.bu.setImageResource(R.drawable.icon_no_data_load_failed);
                    this.bv.setText(R.string.connecting_failed);
                } else {
                    this.bu.setImageResource(R.drawable.icon_no_data_comment);
                    this.bv.setText(R.string.no_content_for_now);
                }
                this.bw.setVisibility(0);
                if (!((FeedDetailsPresenter) j()).A().b) {
                    this.bt.setVisibility(8);
                    return;
                }
                this.bw.setVisibility(8);
                this.bt.setVisibility(0);
            } else if (i != 2) {
            } else {
                if (this.cr.getData().size() > 0) {
                    this.bt.setVisibility(8);
                    this.bw.setVisibility(8);
                    return;
                }
                if (((FeedDetailsPresenter) j()).A().g) {
                    this.bu.setImageResource(R.drawable.icon_no_data_load_failed);
                    this.bv.setText(R.string.connecting_failed);
                } else {
                    this.bu.setImageResource(R.drawable.icon_no_data_share);
                    this.bv.setText(R.string.no_content_for_now);
                }
                this.bw.setVisibility(0);
                if (!((FeedDetailsPresenter) j()).A().c) {
                    this.bt.setVisibility(8);
                    return;
                }
                this.bt.setVisibility(0);
                this.bw.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        EventTrackFeed.a(FeedProtos.Event.HOT_FEED_ICON_CLICK, ((FeedDetailsPresenter) j()).p().feed_id, FeedProtos.FeedPage.HOT_FEED_DETAIL);
        HotFeedFragment.a.a(this.cl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(BluedActionSheet bluedActionSheet) {
        EventTrackFeed.b(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK, ((FeedDetailsPresenter) j()).p().feed_id);
        CommunityServiceManager.b().a(this.cl, 0, "feed_dynamic_skin_look_guest");
    }

    private void d(final BluedIngSelfFeed bluedIngSelfFeed) {
        this.aY.setVisibility(0);
        this.aO.setTextSize(17.0f);
        this.aQ.setVisibility(8);
        this.aS.setVisibility(0);
        this.aX.setVisibility(0);
        this.aM.setVisibility(0);
        ((ImageView) this.aM.findViewById(R.id.icon)).setImageResource(R.drawable.icon_online_event_address_white);
        ((TextView) this.aM.findViewById(R.id.tv)).setText(R.string.event_events);
        ImageLoader.a(getFragmentActive(), bluedIngSelfFeed.share_activity_pic).b(R.drawable.event_avatar_square).d(R.drawable.event_avatar_square).a(this.aL);
        this.aO.setText(bluedIngSelfFeed.share_activity_title);
        this.aT.setText(TimeAndDateUtils.e(TimeAndDateUtils.j(bluedIngSelfFeed.share_activity_time)));
        this.aV.setText(bluedIngSelfFeed.share_activity_address);
        if (bluedIngSelfFeed.share_activity_mode_id == 1) {
            this.aU.setImageDrawable(BluedSkinUtils.b(this.cl, R.drawable.icon_eventcard_location));
        } else {
            this.aU.setImageDrawable(BluedSkinUtils.b(this.cl, R.drawable.icon_share_event_icon));
        }
        this.aW.setVisibility(8);
        if (bluedIngSelfFeed.share_activity_status == 3) {
            this.aW.setVisibility(0);
            this.aW.setText(R.string.event_ended);
            ShapeHelper.a((ShapeHelper.ShapeView) this.aW, R.color.syc_k);
            ShapeHelper.d(this.aW, R.color.syc_k_50);
        } else if (bluedIngSelfFeed.share_activity_is_all == 1) {
            this.aW.setVisibility(0);
            this.aW.setText(R.string.event_full_complement);
            ShapeHelper.a((ShapeHelper.ShapeView) this.aW, R.color.syc_k);
            ShapeHelper.d(this.aW, R.color.syc_k_50);
        } else if (bluedIngSelfFeed.share_activity_apply_status == 1) {
            this.aW.setVisibility(0);
            this.aW.setText(R.string.event_signuped);
            ShapeHelper.a((ShapeHelper.ShapeView) this.aW, R.color.syc_e);
            ShapeHelper.d(this.aW, R.color.syc_e_50);
        }
        this.aY.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$ik4ASIZNVWBxlYh8CVdpjhpyucc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.i(bluedIngSelfFeed, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        if (TextUtils.isEmpty(bluedIngSelfFeed.repost.feed_extras.url)) {
            return;
        }
        CommunityServiceManager.d().a("feed_web_card_click", 2);
        CommunityServiceManager.b().a(this.cl, bluedIngSelfFeed.feed_extras.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<FeedRepost> list) {
        this.cr.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(BluedActionSheet bluedActionSheet) {
        Context context = this.cl;
        CommonAlertDialog.a(context, context.getResources().getString(R.string.community_notice), this.cl.getResources().getString(R.string.feed_confirm_delete_hint), this.cl.getResources().getString(R.string.feed_confirm_delete), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.22
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).m();
            }
        }, this.cl.getResources().getString(R.string.feed_wait_edit), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private void e(final BluedIngSelfFeed bluedIngSelfFeed) {
        this.aY.setVisibility(0);
        this.aY.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$04CN9kXsjCxF3t_z3U1emH5k7uU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.h(bluedIngSelfFeed, view);
            }
        });
        ImageLoader.a(getFragmentActive(), bluedIngSelfFeed.share_s_t_avatar).b(R.drawable.defaultpicture).a(this.aL);
        this.bY.setTag(bluedIngSelfFeed.share_s_t_avatar);
        this.aO.setText(bluedIngSelfFeed.share_s_t_name);
        this.aM.setVisibility(0);
        ImageView imageView = (ImageView) this.aM.findViewById(R.id.icon);
        if (CommunityServiceManager.a().D() == 1) {
            imageView.setImageResource(R.drawable.feed_post_subject_icon_corner);
        } else {
            imageView.setImageResource(R.drawable.icon_share_topic_corner);
        }
        ((TextView) this.aM.findViewById(R.id.tv)).setText(R.string.super_topic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        if (TextUtils.isEmpty(bluedIngSelfFeed.feed_extras.url)) {
            return;
        }
        CommunityServiceManager.d().a("feed_web_card_click", 2);
        CommunityServiceManager.b().a(this.cl, bluedIngSelfFeed.feed_extras.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<EventDetailsModel> list) {
        if (list == null || list.size() <= 0) {
            this.ax.setVisibility(8);
            return;
        }
        this.ax.setVisibility(0);
        this.aA.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(BluedActionSheet bluedActionSheet) {
        EventTrackFeed.b(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK, ((FeedDetailsPresenter) j()).p().feed_id);
        CommunityServiceManager.b().a(this.cl, 0, "feed_dynamic_skin_setting_main");
    }

    private void f(final BluedIngSelfFeed bluedIngSelfFeed) {
        this.aY.setVisibility(0);
        if (((FeedDetailsPresenter) j()).t()) {
            this.aY.setCardBackgroundColor(BluedSkinUtils.a(this.cl, R.color.syc_y));
        } else {
            this.aY.setCardBackgroundColor(BluedSkinUtils.a(this.cl, R.color.syc_x));
        }
        ImageLoader.a(getFragmentActive(), bluedIngSelfFeed.join_circle_pic).b(R.drawable.defaultpicture).d(R.drawable.circle_default_icon).a(this.aL);
        this.aO.setText(bluedIngSelfFeed.join_circle_title);
        this.aQ.setText(bluedIngSelfFeed.join_circle_description);
        if (bluedIngSelfFeed.is_share_circle == 1) {
            this.aM.setVisibility(0);
            ((ImageView) this.aM.findViewById(R.id.icon)).setImageResource(R.drawable.icon_share_circle_corner);
            ((TextView) this.aM.findViewById(R.id.tv)).setText(R.string.base);
        }
        this.aN.setVisibility(8);
        if (bluedIngSelfFeed.is_join_circle == 1) {
            this.aP.setVisibility(0);
            TextView textView = this.aP;
            textView.setText(bluedIngSelfFeed.members_num + this.cl.getString(R.string.members_count));
        } else {
            this.aP.setVisibility(8);
        }
        this.aY.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$f37nWLyZFduDM9qWU5MI3V_HpFE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.g(bluedIngSelfFeed, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        ICommunityShowPageService b = CommunityServiceManager.b();
        Context context = this.cl;
        b.a(context, "http://native.blued.cn/?action=base_post_detail&post_id=" + bluedIngSelfFeed.share_circle_posting_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(BluedActionSheet bluedActionSheet) {
        FeedMethods.b(this.cl, ((FeedDetailsPresenter) j()).p(), getFragmentActive());
    }

    private void g(final BluedIngSelfFeed bluedIngSelfFeed) {
        this.aY.setVisibility(0);
        this.aN.setVisibility(8);
        if (((FeedDetailsPresenter) j()).t()) {
            this.aY.setCardBackgroundColor(BluedSkinUtils.a(this.cl, R.color.syc_y));
        } else {
            this.aY.setCardBackgroundColor(BluedSkinUtils.a(this.cl, R.color.syc_x));
        }
        ImageLoader.a(getFragmentActive(), bluedIngSelfFeed.share_circle_posting_pic).b(R.drawable.defaultpicture).d(R.drawable.circle_default_icon).a(this.aL);
        TextView textView = this.aO;
        textView.setText(bluedIngSelfFeed.share_circle_title + "圈子");
        if (TextUtils.isEmpty(bluedIngSelfFeed.share_circle_posting_content)) {
            this.aQ.setText(this.cl.getResources().getString(R.string.circle_post_share_default));
        } else {
            this.aQ.setText(bluedIngSelfFeed.share_circle_posting_content);
        }
        this.aY.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$eO2oZSTLfX24OMcUGe_Nukzx8Bk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.f(bluedIngSelfFeed, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        Context context = this.cl;
        CircleDetailsFragment.a(context, bluedIngSelfFeed.join_circle_id + "", CircleConstants.CIRCLE_FROM_PAGE.FEED_DETAIL_JOIN_CIRCLE_FEED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(BluedActionSheet bluedActionSheet) {
        CommunityServiceManager.b().a(this.cl, ((FeedDetailsPresenter) j()).p().promotion_url, CommunityConstants.WebShowType.HIDE_RIGHT);
    }

    private void h(BluedIngSelfFeed bluedIngSelfFeed) {
        this.aI.setVisibility(0);
        this.aI.setAdapter(new FeedDetailsPhotoAdapter(this, getFragmentActive(), bluedIngSelfFeed, this.cs, this.bY, ((FeedDetailsPresenter) j()).z()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        if (CommunityServiceManager.a().m()) {
            return;
        }
        FeedConstants.b = FeedProtos.DetailFrom.FEED_DETAIL_TOPIC;
        SuperTopicDetailFragment.a(this.cl, bluedIngSelfFeed.share_s_t_did);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(BluedActionSheet bluedActionSheet) {
        FeedMethods.a(this.cl, ((FeedDetailsPresenter) j()).p(), getFragmentActive());
    }

    private void i(BluedIngSelfFeed bluedIngSelfFeed) {
        this.aH.setVisibility(0);
        this.aH.setAdapter(new FeedDetailsPhotoAdapter(this, getFragmentActive(), bluedIngSelfFeed, this.cs, this.bY, ((FeedDetailsPresenter) j()).z()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        c(bluedIngSelfFeed.share_activity_id);
    }

    private void j(final BluedIngSelfFeed bluedIngSelfFeed) {
        int i;
        int i2;
        if (bluedIngSelfFeed.feed_pics == null || bluedIngSelfFeed.feed_pics.length <= 0) {
            this.aG.setVisibility(8);
            this.aE.setVisibility(8);
            ((ViewGroup.MarginLayoutParams) this.aD.getLayoutParams()).bottomMargin = DensityUtils.a(this.cl, 2.0f);
            return;
        }
        this.aG.setVisibility(0);
        this.aE.setVisibility(0);
        ((ViewGroup.MarginLayoutParams) this.aD.getLayoutParams()).bottomMargin = DensityUtils.a(this.cl, 10.0f);
        if (bluedIngSelfFeed.feed_pics_width == null || bluedIngSelfFeed.feed_pics_width.length <= 0 || bluedIngSelfFeed.feed_pics_height == null || bluedIngSelfFeed.feed_pics_height.length <= 0) {
            i = 0;
            i2 = 0;
        } else {
            i = StringUtils.a(bluedIngSelfFeed.feed_pics_width[0], 0);
            i2 = StringUtils.a(bluedIngSelfFeed.feed_pics_height[0], 0);
        }
        int[] a = com.blued.android.module.common.utils.ImageUtils.a(i, i2, this.ct, this.cu, this.cv, this.cw);
        ViewGroup.LayoutParams layoutParams = this.aE.getLayoutParams();
        layoutParams.width = a[0];
        boolean z = true;
        layoutParams.height = a[1];
        this.aE.setLayoutParams(layoutParams);
        String str = bluedIngSelfFeed.feed_pics[0];
        int i3 = layoutParams.width;
        if (i != i2) {
            z = false;
        }
        String a2 = AvatarUtils.a(str, i3, z);
        if (i2 > i * 3) {
            this.aF.setVisibility(0);
            a2 = bluedIngSelfFeed.feed_pics[0] + bluedIngSelfFeed.getImageMogr(false);
        } else {
            this.aF.setVisibility(8);
        }
        ImageLoader.a(getFragmentActive(), a2).b(R.drawable.defaultpicture).b(R.drawable.defaultpicture).a(this.aE);
        this.bY.setTag(bluedIngSelfFeed.feed_pics[0]);
        this.aE.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedDetailsFragment.this.k(bluedIngSelfFeed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(BluedIngSelfFeed bluedIngSelfFeed) {
        LogData logData = new LogData();
        logData.id = bluedIngSelfFeed.feed_id;
        logData.from = "5";
        logData.logService = "feed_pic_click";
        logData.type = bluedIngSelfFeed.recommend_text;
        CommunityServiceManager.d().a(logData);
        if (bluedIngSelfFeed.feed_pics == null || bluedIngSelfFeed.feed_pics.length <= 0) {
            return;
        }
        CommunityServiceManager.b().a(this, bluedIngSelfFeed, 0, 16, (LoadOptions) null, ((FeedDetailsPresenter) j()).z(), 9091, 2);
    }

    private void l(final BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed.feed_videos.length >= 2) {
            this.aK.setVisibility(0);
            if (bluedIngSelfFeed.feed_videos_width == null || bluedIngSelfFeed.feed_videos_height == null) {
                bluedIngSelfFeed.feed_videos_width = new String[]{"480"};
                bluedIngSelfFeed.feed_videos_height = new String[]{"480"};
            }
            if (bluedIngSelfFeed.feed_videos_width.length == 0 || bluedIngSelfFeed.feed_videos_height.length == 0) {
                bluedIngSelfFeed.feed_videos_width = new String[]{"480"};
                bluedIngSelfFeed.feed_videos_height = new String[]{"480"};
            }
            int i = 480;
            int a = StringUtils.a(bluedIngSelfFeed.feed_videos_width[0], 480);
            int a2 = StringUtils.a(bluedIngSelfFeed.feed_videos_height[0], 480);
            if (a == 0 || a2 == 0) {
                a2 = 480;
            } else {
                i = a;
            }
            int a3 = AppInfo.l - AppMethods.a(18);
            int i2 = (int) (a3 / (i / a2));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a3, i2);
            layoutParams.gravity = 1;
            this.aJ.setLayoutParams(layoutParams);
            final String[] strArr = bluedIngSelfFeed.feed_videos;
            final String str = bluedIngSelfFeed.feed_video_size;
            VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
            videoPlayConfig.a = bluedIngSelfFeed.feed_videos[0];
            videoPlayConfig.b = bluedIngSelfFeed.feed_videos[1];
            videoPlayConfig.e = a3;
            videoPlayConfig.f = i2;
            videoPlayConfig.a(i);
            videoPlayConfig.b(a2);
            try {
                videoPlayConfig.c = Integer.parseInt(bluedIngSelfFeed.feed_video_size);
            } catch (Exception e) {
                Logger.b(FeedDetailsFragment.class.getSimpleName(), "setContentView() Integer.parseInt(feed.feed_video_size) Exception");
            }
            videoPlayConfig.g = new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    String[] strArr2 = strArr;
                    if (strArr2 == null || strArr2.length < 2 || CommunityServiceManager.a().k()) {
                        return;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            Float.parseFloat(str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    CommunityServiceManager.d().c("feed_video_play", 1);
                    BluedIngSelfFeed bluedIngSelfFeed2 = (BluedIngSelfFeed) bluedIngSelfFeed.clone();
                    if (((FeedDetailsPresenter) FeedDetailsFragment.this.j()).w() == 1) {
                        bluedIngSelfFeed2.feed_uid = ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).p().feed_uid;
                        bluedIngSelfFeed2.feed_id = ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).p().feed_id;
                        VideoUserInfoFragment.a(FeedDetailsFragment.this.cl, bluedIngSelfFeed2);
                        return;
                    }
                    boolean z = true;
                    if (((FeedDetailsPresenter) FeedDetailsFragment.this.j()).w() != 5) {
                        z = true;
                        if (((FeedDetailsPresenter) FeedDetailsFragment.this.j()).w() != 29) {
                            z = ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).w() == 30;
                        }
                    }
                    VideoScanFragment.a(FeedDetailsFragment.this.cl, bluedIngSelfFeed2, z, 2);
                }
            };
            this.aJ.b(videoPlayConfig);
            a(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.40
                @Override // java.lang.Runnable
                public void run() {
                    if (FeedDetailsFragment.this.aJ != null) {
                        FeedDetailsFragment.this.aJ.c();
                    }
                }
            });
        }
    }

    private void m(final BluedIngSelfFeed bluedIngSelfFeed) {
        final BluedIngSelfFeed contentData = bluedIngSelfFeed.getContentData();
        if (contentData.feed_pics == null || contentData.feed_pics.length <= 1) {
            this.aZ.setVisibility(8);
            return;
        }
        this.aZ.setVisibility(0);
        String str = contentData.feed_pics[0];
        this.aZ.a(getFragmentActive(), AvatarUtils.a(str), AvatarUtils.a(contentData.feed_pics[1]));
        this.aZ.a(contentData.ivoted, contentData.a_vote_count, contentData.vote_count, bluedIngSelfFeed.isRepost());
        this.aZ.setOnViewClickListener(new FeedVoteGroup.OnViewClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.41
            public void a(boolean z) {
                contentData.is_vote = 1;
                contentData.vote_count++;
                if (z) {
                    contentData.a_vote_count++;
                    contentData.ivoted = 1;
                } else {
                    contentData.b_vote_count++;
                    contentData.ivoted = 2;
                }
                FeedDetailsFragment.this.aZ.a(contentData.ivoted, contentData.a_vote_count, contentData.vote_count, bluedIngSelfFeed.isRepost());
                ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).b(z);
                EventTrackVote.a(VoteProtos.Event.VOTE_FEED_CHOOSE_PHOTO_CLICK, contentData, z ? VoteProtos.PhotoOption.PHOTO_A : VoteProtos.PhotoOption.PHOTO_B, 2);
            }

            public void b(boolean z) {
                EventTrackVote.a(VoteProtos.Event.VOTE_FEED_ENLARGE_PHOTO_CLICK, contentData.feed_uid, contentData.feed_id);
                ICommunityShowPageService b = CommunityServiceManager.b();
                FeedDetailsFragment feedDetailsFragment = FeedDetailsFragment.this;
                b.a(feedDetailsFragment, contentData, 0, 16, feedDetailsFragment.cs, ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).z(), 9091, 2);
            }
        });
        this.bY.setTag(str);
        this.aZ.setVisibility(0);
        this.ac.setVisibility(8);
    }

    private void n(final BluedIngSelfFeed bluedIngSelfFeed) {
        this.aY.setVisibility(0);
        if (((FeedDetailsPresenter) j()).t()) {
            this.aY.setCardBackgroundColor(BluedSkinUtils.a(this.cl, R.color.syc_y));
        } else {
            this.aY.setCardBackgroundColor(BluedSkinUtils.a(this.cl, R.color.syc_x));
        }
        if (bluedIngSelfFeed != null && bluedIngSelfFeed.is_url == 1 && bluedIngSelfFeed.feed_extras != null) {
            if (bluedIngSelfFeed.feed_extras.thumb != null && bluedIngSelfFeed.feed_extras.thumb.size() > 0) {
                ImageLoader.a(getFragmentActive(), bluedIngSelfFeed.feed_extras.thumb.get(0).replace(i.b, "")).b(R.drawable.defaultpicture).a(this.aL);
                this.bY.setTag(bluedIngSelfFeed.feed_extras.thumb.get(0).replace(i.b, ""));
            }
            if (!TextUtils.isEmpty(bluedIngSelfFeed.feed_extras.title)) {
                this.aO.setText(bluedIngSelfFeed.feed_extras.title);
            }
            this.aY.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$-lN6E7_W4Dw5p_CqApsgM7Q3q3I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedDetailsFragment.this.e(bluedIngSelfFeed, view);
                }
            });
        } else if (bluedIngSelfFeed == null || bluedIngSelfFeed.repost == null || bluedIngSelfFeed.repost.is_url != 1) {
            this.aY.setVisibility(8);
        } else {
            this.aY.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$cmUuB563UpjvZZl6akyV1TLlbrY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedDetailsFragment.this.d(bluedIngSelfFeed, view);
                }
            });
            if (bluedIngSelfFeed.repost.feed_extras.thumb != null && bluedIngSelfFeed.repost.feed_extras.thumb.size() > 0) {
                ImageLoader.a(getFragmentActive(), bluedIngSelfFeed.repost.feed_extras.thumb.get(0).replace(i.b, "")).b(R.drawable.defaultpicture).a(this.aL);
                this.bY.setTag(bluedIngSelfFeed.repost.feed_extras.thumb.get(0).replace(i.b, ""));
            }
            if (!TextUtils.isEmpty(bluedIngSelfFeed.repost.feed_extras.title)) {
                this.aO.setText(bluedIngSelfFeed.repost.feed_extras.title);
            }
            this.aY.setVisibility(0);
        }
    }

    private void o(final BluedIngSelfFeed bluedIngSelfFeed) {
        if (UserInfoUtils.c().equals(bluedIngSelfFeed.feed_uid) || "1".equalsIgnoreCase(bluedIngSelfFeed.relationship) || "3".equalsIgnoreCase(bluedIngSelfFeed.relationship)) {
            this.L.setVisibility(8);
            this.o.setVisibility(8);
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.L.getLayoutParams();
            marginLayoutParams.rightMargin = DensityUtils.a(this.cl, 10.0f);
            this.L.setLayoutParams(marginLayoutParams);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.42
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (TextUtils.equals(bluedIngSelfFeed.relationship, "1")) {
                        FeedDetailsFragment.this.E.callOnClick();
                    } else {
                        FeedDetailsFragment.this.a(view, bluedIngSelfFeed);
                    }
                }
            };
            this.L.setOnClickListener(onClickListener);
            this.L.setVisibility(0);
            this.L.setRelationShip("0");
            this.o.setOnClickListener(onClickListener);
            this.o.setVisibility(0);
            this.o.setRelationShip("0");
        }
        if (bluedIngSelfFeed.is_feed_anonym == 1) {
            this.L.setVisibility(8);
            this.o.setVisibility(8);
        }
    }

    private void p(final BluedIngSelfFeed bluedIngSelfFeed) {
        if (!UserInfoUtils.c().equals(bluedIngSelfFeed.feed_uid)) {
            this.Q.setVisibility(8);
            return;
        }
        this.Q.setVisibility(0);
        this.N.setText(StringUtils.a(String.valueOf(bluedIngSelfFeed.feed_show)));
        this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.44
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (!TextUtils.isEmpty(bluedIngSelfFeed.promotion_url)) {
                    CommunityServiceManager.d().c("feed_read_count_click", 5);
                }
                CommunityServiceManager.b().a(FeedDetailsFragment.this.cl, bluedIngSelfFeed.promotion_url);
            }
        });
        if (bluedIngSelfFeed.can_promotion == 1) {
            this.P.setVisibility(0);
        } else {
            this.P.setVisibility(8);
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.45
            @Override // java.lang.Runnable
            public void run() {
                FeedDetailsFragment.this.a(bluedIngSelfFeed);
            }
        }, 300L);
    }

    private void q(final BluedIngSelfFeed bluedIngSelfFeed) {
        boolean z;
        if (!TextUtils.isEmpty(bluedIngSelfFeed.location) || bluedIngSelfFeed.is_expression == 1) {
            if (TextUtils.isEmpty(bluedIngSelfFeed.location)) {
                this.be.setVisibility(8);
            } else {
                this.be.setVisibility(0);
                this.bd.setText(bluedIngSelfFeed.location);
                this.be.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$5CF3kPQzM7cdVfqZrtBVAX3RTpI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedDetailsFragment.this.c(bluedIngSelfFeed, view);
                    }
                });
            }
            if (bluedIngSelfFeed.is_expression == 1) {
                r(bluedIngSelfFeed);
            } else {
                this.ac.setVisibility(8);
            }
            z = true;
        } else {
            this.be.setVisibility(8);
            z = false;
        }
        if (!CommunityManager.a.a().c(bluedIngSelfFeed.feed_uid) || bluedIngSelfFeed.is_bubble_ticktock == 1 || CommonStringUtils.a(bluedIngSelfFeed.tt_click_sum) <= 0) {
            this.af.setVisibility(8);
        } else {
            this.ag.setText(String.format(this.cl.getString(R.string.feed_mine_visit_num), DistanceUtils.a(this.cl, bluedIngSelfFeed.tt_click_sum)));
            if (CommunityManager.a.a().s()) {
                this.ah.setImageResource(R.drawable.feed_mine_visit_icon_dark);
            } else {
                this.ah.setImageResource(R.drawable.feed_mine_visit_icon);
            }
            this.af.setVisibility(0);
            final View findViewById = this.i.findViewById(R.id.feed_mine_visit_num_tips);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$Mqu05OeJBxpvalg8PmpBYxsrqnk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedDetailsFragment.this.a(findViewById, view);
                }
            });
            z = true;
        }
        if (z) {
            this.bf.setVisibility(0);
        } else {
            this.bf.setVisibility(8);
        }
        if (TextUtils.isEmpty(bluedIngSelfFeed.ip_location)) {
            this.ab.setVisibility(8);
            return;
        }
        this.ab.setText(String.format(getString(R.string.feed_ip_location), bluedIngSelfFeed.ip_location));
        this.ab.setVisibility(0);
    }

    private void r(final BluedIngSelfFeed bluedIngSelfFeed) {
        this.ac.setVisibility(0);
        if (bluedIngSelfFeed.interaction_count > 0) {
            TextView textView = this.ad;
            textView.setText(bluedIngSelfFeed.interaction_count + "人");
        } else {
            this.ad.setText(R.string.feed_interact);
        }
        if (bluedIngSelfFeed.expression_id > 0) {
            this.ad.setTextColor(this.cl.getResources().getColor(R.color.syc_g));
        } else {
            this.ad.setTextColor(this.cl.getResources().getColor(R.color.syc_k));
        }
        this.ac.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$gsJRe7eTpAeGEN08-kdWpKEih6w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.b(bluedIngSelfFeed, view);
            }
        }));
    }

    private void s(BluedIngSelfFeed bluedIngSelfFeed) {
        LogData a = FeedMethods.a(bluedIngSelfFeed, 0);
        a.isFromFeedDetail = true;
        CommRouteUtil.a(this, this.ae, bluedIngSelfFeed, a);
        EventTrackFeed.b(FeedProtos.Event.MORE_EMOJI_PANEL_SHOW, bluedIngSelfFeed, FeedProtos.SourcePage.FEED_DETAIL_PAGE);
    }

    private void t(final BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed.activity_data == null) {
            this.ak.setVisibility(8);
            this.ar.setVisibility(8);
            return;
        }
        if (bluedIngSelfFeed.activity_data.activity_score > 0) {
            this.ak.setVisibility(0);
        } else {
            this.ak.setVisibility(8);
        }
        if (bluedIngSelfFeed.activity_data.activity_score >= 1) {
            this.al.setVisibility(0);
        }
        if (bluedIngSelfFeed.activity_data.activity_score >= 2) {
            this.am.setVisibility(0);
        }
        if (bluedIngSelfFeed.activity_data.activity_score >= 3) {
            this.an.setVisibility(0);
        }
        if (bluedIngSelfFeed.activity_data.activity_score >= 4) {
            this.ao.setVisibility(0);
        }
        if (bluedIngSelfFeed.activity_data.activity_score >= 5) {
            this.ap.setVisibility(0);
        }
        if (TextUtils.isEmpty(bluedIngSelfFeed.activity_data.activity_evaluate)) {
            this.aq.setVisibility(8);
        } else {
            this.aq.setVisibility(0);
            TextView textView = this.aq;
            textView.setText(this.cl.getString(R.string.feed_post_event_evaluate) + bluedIngSelfFeed.activity_data.activity_evaluate);
        }
        final FeedEventModel feedEventModel = bluedIngSelfFeed.activity_data;
        this.ar.setVisibility(0);
        this.ar.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$LrTBPT3wu5vaTvgf1qthxtP2Egc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.b(feedEventModel, view);
            }
        });
        ImageLoader.a(getFragmentActive(), feedEventModel.pic).b(R.drawable.defaultpicture).d(R.drawable.defaultpicture).a(4.0f).a(this.as);
        this.at.setText(feedEventModel.name);
        ImageLoader.a(getFragmentActive(), feedEventModel.user_avatar).b(R.drawable.user_bg_round).d(R.drawable.user_bg_round).c().a(this.au);
        this.av.setText(feedEventModel.user_name);
        this.au.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$f9JE-yvogergP-TbbC0hNGSQp4k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.a(bluedIngSelfFeed, view);
            }
        });
        if (feedEventModel.is_subscribe == 1 || feedEventModel.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
            this.aw.setVisibility(8);
            return;
        }
        this.aw.setVisibility(0);
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_SUBSCRIBE_BTN_SHOW, feedEventModel.id, feedEventModel.uid, FeedProtos.SourcePage.FEED_DETAIL_PAGE);
        this.aw.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$3L6Y4diSl2yQxe0vMNLhP-ZKfyg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.a(feedEventModel, view);
            }
        });
    }

    private void u(final BluedIngSelfFeed bluedIngSelfFeed) {
        boolean z;
        if (bluedIngSelfFeed.is_super_topics == 1 && !TextUtils.isEmpty(bluedIngSelfFeed.super_topics_name) && !TextUtils.isEmpty(bluedIngSelfFeed.super_did)) {
            String[] split = bluedIngSelfFeed.super_topics_name.split(",");
            String[] split2 = bluedIngSelfFeed.super_did.split(",");
            if (split2.length > 0 && split.length == split2.length) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= split.length) {
                        break;
                    }
                    BluedTopic bluedTopic = new BluedTopic();
                    bluedTopic.name = split[i2];
                    String str = split2[i2];
                    if (str.endsWith("@")) {
                        bluedTopic.topicType = 1;
                        bluedTopic.super_did = str.split("@")[0];
                    } else if (str.contains(a.b)) {
                        bluedTopic.is_anonym = 1;
                        bluedTopic.super_did = str.split(a.b)[0];
                    } else {
                        bluedTopic.is_anonym = 0;
                        bluedTopic.super_did = str;
                    }
                    arrayList.add(bluedTopic);
                    i = i2 + 1;
                }
                ViewUtils.a(this.cl, arrayList, this.ai, true, new ViewUtils.ITopicListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.46
                    public void a(View view) {
                    }

                    public void a(BluedTopic bluedTopic2) {
                        EventTrackFeed.a(FeedProtos.Event.FEED_SUPER_TOPIC_ENTER_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.super_did, FeedProtos.FeedTopicPage.FEED_TOPIC_FEED_DETAIL);
                        if (bluedIngSelfFeed.super_topics_status == 0 && bluedTopic2.topicType != 1) {
                            AppMethods.d(R.string.super_topic_under_review);
                            return;
                        }
                        FeedConstants.b = FeedProtos.DetailFrom.FEED_DETAIL_TOPIC;
                        SuperTopicDetailFragment.a(FeedDetailsFragment.this.cl, bluedTopic2.super_did);
                    }
                }, true);
                z = true;
                ViewUtils.a(this.cl, this.ai, bluedIngSelfFeed.is_top_hot, new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$1zL8sXiYKi7oXBTDIAlWm4UuGqY
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedDetailsFragment.this.d(view);
                    }
                });
                if (bluedIngSelfFeed.is_top_hot != 1 || z) {
                    this.aj.setVisibility(0);
                } else {
                    this.aj.setVisibility(8);
                    return;
                }
            }
        }
        z = false;
        ViewUtils.a(this.cl, this.ai, bluedIngSelfFeed.is_top_hot, new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$FeedDetailsFragment$1zL8sXiYKi7oXBTDIAlWm4UuGqY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailsFragment.this.d(view);
            }
        });
        if (bluedIngSelfFeed.is_top_hot != 1) {
        }
        this.aj.setVisibility(0);
    }

    private void v(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed.is_vote == 1) {
            this.bk.setVisibility(8);
            this.bT.setVisibility(8);
        } else {
            this.bk.setVisibility(0);
            this.bT.setVisibility(0);
        }
        if (bluedIngSelfFeed.feed_is_delete == 1 || ((bluedIngSelfFeed.isRepost() && bluedIngSelfFeed.repost.feed_is_delete == 1) || bluedIngSelfFeed.disallow_share == 1)) {
            this.bX.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_feed_unshare));
            this.bY.setEnabled(false);
        } else {
            this.bX.setImageDrawable(BluedSkinUtils.b(this.cl, R.drawable.icon_feed_share));
            this.bY.setEnabled(true);
        }
        if (bluedIngSelfFeed.reading_scope == 0 || bluedIngSelfFeed.is_vote == 1) {
            this.bY.setVisibility(0);
        } else {
            this.bY.setVisibility(8);
        }
        w(bluedIngSelfFeed);
    }

    private void w(BluedIngSelfFeed bluedIngSelfFeed) {
        int i = bluedIngSelfFeed.iliked;
        boolean z = bluedIngSelfFeed.isPlayLikeAnim;
        if (i == 0) {
            this.bV.setTag(null);
            this.bV.setImageDrawable(BluedSkinUtils.b(this.cl, R.drawable.icon_feed_like));
            if (!this.cz) {
                this.bU.setVisibility(0);
                this.bW.setVisibility(8);
            }
        } else if (1 == i) {
            this.cz = false;
            this.bU.setVisibility(0);
            this.bW.setVisibility(8);
            if (z) {
                this.bV.setTag("anim");
                ImageLoader.c(getFragmentActive(), FeedMethods.e()).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.50
                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void a() {
                    }

                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void b() {
                        if (FeedDetailsFragment.this.bV == null || FeedDetailsFragment.this.bV.getTag() == null) {
                            return;
                        }
                        ImageLoader.a(FeedDetailsFragment.this.getFragmentActive(), R.drawable.icon_feed_liked).a(FeedDetailsFragment.this.bV);
                    }
                }).a(this.bV);
            } else {
                this.bV.setTag(null);
                ImageLoader.a(getFragmentActive(), R.drawable.icon_feed_liked).a(this.bV);
            }
        }
        this.cq.notifyDataSetChanged();
    }

    private boolean x(BluedIngSelfFeed bluedIngSelfFeed) {
        boolean z = bluedIngSelfFeed != null && !((FeedDetailsPresenter) j()).h && !CommunityManager.a.a().c(bluedIngSelfFeed.uid) && bluedIngSelfFeed.iliked == 0 && TimeAndDateUtils.a() >= CommunityPreferences.q() && CommunityPreferences.s() < 4;
        if (this.cx) {
            ((FeedDetailsPresenter) j()).m = z;
        }
        LogUtils.c("showLikeGuide:" + z);
        return z;
    }

    private void y(BluedIngSelfFeed bluedIngSelfFeed) {
        int i = bluedIngSelfFeed.feed_comment;
        if (i > 0) {
            this.bm.setVisibility(0);
            this.bm.setText(DistanceUtils.a(this.cl, Integer.toString(i)));
        } else {
            this.bm.setVisibility(8);
        }
        int i2 = bluedIngSelfFeed.feed_dig;
        if (i2 > 0) {
            this.bj.setText(DistanceUtils.a(this.cl, Integer.toString(i2)));
            this.bj.setVisibility(0);
        } else {
            this.bj.setVisibility(8);
        }
        int i3 = bluedIngSelfFeed.repost_count;
        if (i3 <= 0) {
            this.bp.setVisibility(8);
            return;
        }
        this.bp.setText(DistanceUtils.a(this.cl, Integer.toString(i3)));
        this.bp.setVisibility(0);
    }

    private void z(final BluedIngSelfFeed bluedIngSelfFeed) {
        this.K.setVisibility(8);
        this.K.setEnabled(false);
        boolean z = true;
        if (TextUtils.isEmpty(bluedIngSelfFeed.feed_uid) || !bluedIngSelfFeed.feed_uid.equals(UserInfoUtils.c())) {
            this.w.setVisibility(8);
        } else {
            this.w.setVisibility(0);
            if (bluedIngSelfFeed.is_feed_anonym == 1) {
                this.v.setVisibility(8);
                this.s.setImageResource(R.drawable.feed_details_anonymous);
                this.t.setText(R.string.feed_anonymous);
                this.t.setTextColor(this.cl.getResources().getColor(R.color.syc_k));
            } else {
                FeedMethods.a(this.cl, bluedIngSelfFeed.reading_scope, this.s, this.t);
            }
        }
        if (bluedIngSelfFeed.is_feed_anonym == 1) {
            ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, bluedIngSelfFeed.user_avatar)).b(R.drawable.user_bg_round).d().a(this.y);
            ImageLoader.a(getFragmentActive(), AvatarUtils.a(1, bluedIngSelfFeed.user_avatar)).b(R.drawable.user_bg_round).c().d().a(this.m);
            this.A.setVisibility(0);
        } else {
            ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, bluedIngSelfFeed.user_avatar)).b(R.drawable.user_bg_round).a(this.y);
            ImageLoader.a(getFragmentActive(), AvatarUtils.a(1, bluedIngSelfFeed.user_avatar)).b(R.drawable.user_bg_round).c().a(this.m);
            this.A.setVisibility(8);
        }
        UserInfoHelper.a(this.B, bluedIngSelfFeed.vbadge, 3);
        if (TextUtils.isEmpty(bluedIngSelfFeed.user_name)) {
            this.E.setText("");
        } else if (TextUtils.isEmpty(bluedIngSelfFeed.note)) {
            this.E.setText(bluedIngSelfFeed.user_name);
        } else {
            this.E.setText(StringUtils.a(bluedIngSelfFeed.note, bluedIngSelfFeed.user_name));
        }
        TextView textView = this.E;
        String str = bluedIngSelfFeed.feed_uid;
        if (bluedIngSelfFeed.is_feed_anonym != 1) {
            z = false;
        }
        FeedMethods.a(textView, str, z);
        this.n.setText(this.E.getText());
        if (bluedIngSelfFeed.live > 0) {
            this.B.setVisibility(8);
            this.z.setVisibility(0);
            ImageLoader.c(getFragmentActive(), "anim_live_list.png").e(bluedIngSelfFeed.hashCode()).g(-1).a(this.z);
        } else {
            UserInfoHelper.a(this.B, bluedIngSelfFeed.vbadge, 3);
            this.z.setVisibility(4);
        }
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = bluedIngSelfFeed.vip_grade;
        userBasicModel.is_vip_annual = bluedIngSelfFeed.is_vip_annual;
        userBasicModel.is_hide_vip_look = bluedIngSelfFeed.is_hide_vip_look;
        userBasicModel.vip_exp_lvl = bluedIngSelfFeed.vip_exp_lvl;
        userBasicModel.uid = bluedIngSelfFeed.feed_uid;
        UserInfoHelper.a(this.cl, this.E, userBasicModel);
        UserInfoHelper.a(this.cl, this.n, userBasicModel);
        UserInfoHelper.a(this.G, userBasicModel, getFragmentActive());
        final String a = FeedMethods.a(((FeedDetailsPresenter) j()).w(), bluedIngSelfFeed.is_vote);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.51
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (bluedIngSelfFeed.is_feed_anonym == 1) {
                    return;
                }
                UserBasicModel userBasicModel2 = new UserBasicModel();
                userBasicModel2.uid = bluedIngSelfFeed.feed_uid;
                userBasicModel2.name = bluedIngSelfFeed.user_name;
                userBasicModel2.avatar = bluedIngSelfFeed.user_avatar;
                userBasicModel2.is_show_vip_page = bluedIngSelfFeed.is_show_vip_page;
                if (bluedIngSelfFeed.live > 0) {
                    CommunityServiceManager.b().a(FeedDetailsFragment.this.cl, userBasicModel2, bluedIngSelfFeed.live, a);
                    return;
                }
                EncryptTool.b(bluedIngSelfFeed.feed_id);
                MessageProtos.StrangerSource strangerSource = bluedIngSelfFeed.in_promotion == 1 ? MessageProtos.StrangerSource.APPRECIATE_SUPER_EXPOSURE : MessageProtos.StrangerSource.FEED_DETAIL;
                LogData a2 = FeedMethods.a(bluedIngSelfFeed, ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).w());
                a2.listMode = ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).q().mode;
                a2.strong_insert_data = ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).q().strong_insert_data;
                int id = view.getId();
                CommunityServiceManager.b().a(FeedDetailsFragment.this.cl, userBasicModel2, a, false, (View) ((id == R.id.header_view || id == R.id.name_view) ? FeedDetailsFragment.this.y : (id == R.id.bar_header || id == R.id.bar_name) ? FeedDetailsFragment.this.m : null), a2, strangerSource);
                if (bluedIngSelfFeed.click_url == null || bluedIngSelfFeed.click_url.length <= 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bluedIngSelfFeed.click_url.length) {
                        return;
                    }
                    CommunityHttpUtils.a(bluedIngSelfFeed.click_url[i2]);
                    i = i2 + 1;
                }
            }
        };
        this.E.setOnClickListener(onClickListener);
        this.y.setOnClickListener(onClickListener);
        this.n.setOnClickListener(onClickListener);
        this.m.setOnClickListener(onClickListener);
        A(bluedIngSelfFeed);
        B(bluedIngSelfFeed);
    }

    @Override // com.blued.android.framework.ui.custom.MvpKeyBoardFragment
    public void a(int i) {
        if (i == -3) {
            this.cc.setVisibility(0);
            this.bZ.setVisibility(8);
            this.bM.setVisibility(8);
            this.bQ.setVisibility(0);
            this.bL.setVisibility(8);
            this.bK.setVisibility(0);
            this.bK.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.54
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    FeedDetailsFragment.this.Y();
                    FeedDetailsFragment.this.bK.setOnTouchListener(null);
                    return true;
                }
            });
            this.bR.setFocusable(true);
            this.bR.setFocusableInTouchMode(true);
            this.bR.requestFocus();
        } else if (i != -2) {
        } else {
            if (this.cj.getVisibility() != 0) {
                this.cc.setVisibility(0);
                this.bZ.setVisibility(8);
                this.bQ.setVisibility(0);
            } else {
                if (!this.bR.isFocusable()) {
                    this.bK.setVisibility(8);
                }
                this.bQ.setVisibility(8);
            }
            if (this.bZ.getVisibility() != 0) {
                this.bM.setVisibility(8);
                this.bL.setVisibility(8);
                return;
            }
            if (TextUtils.isEmpty(this.bR.getText().toString())) {
                this.bM.setVisibility(0);
            } else {
                this.bM.setVisibility(8);
            }
            this.bL.setVisibility(0);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        Context context = getContext();
        this.cl = context;
        this.f59cn = new AtChooseUserHelper(context);
        A();
        P();
        N();
        M();
        K();
        F();
        E();
        D();
        B();
        C();
        this.cq.a();
        this.cp.e();
        this.cr.a();
        ((FeedDetailsPresenter) j()).e();
        if (TimeAndDateUtils.a() > CommunityPreferences.q()) {
            CommunityPreferences.t();
        }
    }

    public void a(BluedADExtra bluedADExtra) {
        this.bz.setVisibility(0);
        CommunityServiceManager.e().a(getFragmentActive(), bluedADExtra, this.cm, this.bz);
    }

    public void a(final BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null || TextUtils.isEmpty(bluedIngSelfFeed.recommendation) || this.cC != null) {
            return;
        }
        View inflate = View.inflate(getContext(), R.layout.pop_super_exposure_guide, null);
        ((TextView) inflate.findViewById(R.id.tv_super_exposure_tips)).setText(bluedIngSelfFeed.recommendation);
        BluedPopupWindow a = BluedPopupWindow.Builder.a((Activity) getContext(), inflate).a(true).a();
        this.cC = a;
        a.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.47
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                FeedDetailsFragment.this.cC = null;
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.48
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackSuperExpose.a(SuperExposeProtos.Event.EXPOSE_FEED_DETAIL_POP_CLICK, bluedIngSelfFeed.feed_id);
                CommunityServiceManager.b().a(FeedDetailsFragment.this.cl, bluedIngSelfFeed.promotion_url, CommunityConstants.WebShowType.HIDE_RIGHT);
                FeedDetailsFragment.this.cC.dismiss();
            }
        });
        this.cC.a(this.Q, 1, 4, 0, -DensityUtils.a(getContext(), 9.0f));
        EventTrackSuperExpose.a(SuperExposeProtos.Event.EXPOSE_FEED_DETAIL_POP_SHOW, bluedIngSelfFeed.feed_id);
        inflate.postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.49
            @Override // java.lang.Runnable
            public void run() {
                if (FeedDetailsFragment.this.cC == null || !FeedDetailsFragment.this.cC.isShowing()) {
                    return;
                }
                FeedDetailsFragment.this.cC.dismiss();
            }
        }, 5000L);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List list) {
        super.a(str, list);
        if (str == null) {
            return;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -1893701289:
                if (str.equals("recommend_event")) {
                    z = true;
                    break;
                }
                break;
            case -1644259925:
                if (str.equals("feed_data")) {
                    z = false;
                    break;
                }
                break;
            case -1644013921:
                if (str.equals("feed_list")) {
                    z = true;
                    break;
                }
                break;
            case -1417184065:
                if (str.equals("scroll_to_mark_comment")) {
                    z = true;
                    break;
                }
                break;
            case -973639025:
                if (str.equals("sub_owner_event")) {
                    z = true;
                    break;
                }
                break;
            case -864760547:
                if (str.equals("feed_no_data_tab")) {
                    z = true;
                    break;
                }
                break;
            case -363475363:
                if (str.equals("scroll_to_comment_show_mark")) {
                    z = true;
                    break;
                }
                break;
            case -258118695:
                if (str.equals("init_edit")) {
                    z = true;
                    break;
                }
                break;
            case -191572620:
                if (str.equals("feed_tab")) {
                    z = true;
                    break;
                }
                break;
            case -163848122:
                if (str.equals("like_list")) {
                    z = true;
                    break;
                }
                break;
            case 2264690:
                if (str.equals("similar_list")) {
                    z = true;
                    break;
                }
                break;
            case 278373262:
                if (str.equals("change_place_height")) {
                    z = true;
                    break;
                }
                break;
            case 640708618:
                if (str.equals("repost_list")) {
                    z = true;
                    break;
                }
                break;
            case 795385470:
                if (str.equals("comment_list")) {
                    z = true;
                    break;
                }
                break;
            case 2067290277:
                if (str.equals("show_ad")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.23
                    private void b(BluedIngSelfFeed bluedIngSelfFeed) {
                        bluedIngSelfFeed.getItemType();
                        FeedDetailsFragment feedDetailsFragment = FeedDetailsFragment.this;
                        feedDetailsFragment.a(bluedIngSelfFeed, feedDetailsFragment.cx);
                        if (FeedDetailsFragment.this.cx && ((FeedDetailsPresenter) FeedDetailsFragment.this.j()).h && !CommunityManager.a.a().c(bluedIngSelfFeed.uid)) {
                            FeedDetailsFragment.this.cx = false;
                            if (((FeedDetailsPresenter) FeedDetailsFragment.this.j()).i) {
                                FeedDetailsFragment.this.S();
                            } else {
                                FeedDetailsFragment.this.Q();
                            }
                        }
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                        b(((FeedDetailsPresenter) FeedDetailsFragment.this.j()).p());
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
                        b(bluedIngSelfFeed);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, Integer.class, new MvpUtils.DataHandler<Integer>() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.24
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(Integer num) {
                        FeedDetailsFragment.this.c(num.intValue());
                    }
                });
                return;
            case true:
                MvpUtils.a(list, Integer.class, new MvpUtils.DataHandler<Integer>() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.25
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(Integer num) {
                        FeedDetailsFragment.this.d(num.intValue());
                    }
                });
                return;
            case true:
                Y();
                return;
            case true:
                R();
                return;
            case true:
                U();
                return;
            case true:
                this.bD.setNewData(list);
                this.bB.setVisibility(0);
                this.bC.setVisibility(0);
                return;
            case true:
                MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.26
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<BluedIngSelfFeed> list2) {
                        FeedDetailsFragment.this.a(list2);
                    }
                });
                return;
            case true:
                T();
                return;
            case true:
                MvpUtils.a(list, FeedComment.class, new MvpUtils.DataListHandler<FeedComment>() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.27
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<FeedComment> list2) {
                        FeedDetailsFragment.this.b(list2);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, FeedUserInfoModel.class, new MvpUtils.DataListHandler<FeedUserInfoModel>() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.28
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<FeedUserInfoModel> list2) {
                        FeedDetailsFragment.this.c(list2);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, FeedRepost.class, new MvpUtils.DataListHandler<FeedRepost>() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.29
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<FeedRepost> list2) {
                        FeedDetailsFragment.this.d(list2);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, BluedADExtra.class, new MvpUtils.DataHandler<BluedADExtra>() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.30
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                        if (FeedDetailsFragment.this.cm != null) {
                            FeedDetailsFragment.this.cm.setVisibility(8);
                        }
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(BluedADExtra bluedADExtra) {
                        FeedDetailsFragment.this.a(bluedADExtra);
                    }
                });
                return;
            case true:
                W();
                return;
            case true:
                MvpUtils.a(list, EventDetailsModel.class, new MvpUtils.DataListHandler<EventDetailsModel>() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.31
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        FeedDetailsFragment.this.e((List<EventDetailsModel>) null);
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<EventDetailsModel> list2) {
                        FeedDetailsFragment.this.e(list2);
                    }
                });
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        boolean z2 = true;
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
        } else if (str.equals("_load_type_refresh_")) {
            z2 = false;
        }
        if (!z2 || z2) {
            this.bJ.g();
            this.bJ.h();
        }
        if (str.equals("_load_type_refresh_")) {
            c(((FeedDetailsPresenter) j()).n());
        }
        if (((FeedDetailsPresenter) j()).n() != 1 || this.cp.getData().size() <= 0 || (!((FeedDetailsPresenter) j()).A().b && !((FeedDetailsPresenter) j()).B())) {
            this.by.setVisibility(8);
            return;
        }
        EventTrackFeed.b(FeedProtos.Event.FEED_DETAIL_COMMENT_MORE_SHOW, ((FeedDetailsPresenter) j()).p().feed_id);
        this.by.setVisibility(0);
    }

    @Override // com.blued.android.framework.ui.custom.MvpKeyBoardFragment, com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.cq.b();
        this.cp.f();
        this.cr.b();
        this.bA.removeAllViews();
        this.cm = null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void f() {
        super.f();
        getActivity().getWindow().setSoftInputMode(16);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_feed_details;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.bJ.b(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (((FeedDetailsPresenter) j()).y() == 18) {
            postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    FeedDetailsFragment.this.I();
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ShapeRelativeLayout shapeRelativeLayout;
        if (i2 == -1) {
            if (i != 100) {
                if (i == 9090) {
                    this.f59cn.a(this.bR, intent, this.cB);
                    a(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.55
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedDetailsFragment.this.bR.requestFocus();
                            KeyboardUtils.c(FeedDetailsFragment.this.getActivity());
                        }
                    }, 300L);
                } else if (i == 9091 && (shapeRelativeLayout = this.bY) != null) {
                    shapeRelativeLayout.performClick();
                }
            } else if (intent != null && !TextUtils.isEmpty("string_edit")) {
                ((FeedDetailsPresenter) j()).c(intent.getStringExtra("feed_id"), intent.getStringExtra("string_edit"));
            }
        } else if (i == 9090) {
            a(new Runnable() { // from class: com.blued.community.ui.feed.fragment.FeedDetailsFragment.56
                @Override // java.lang.Runnable
                public void run() {
                    FeedDetailsFragment.this.bR.requestFocus();
                    KeyboardUtils.c(FeedDetailsFragment.this.getActivity());
                }
            }, 300L);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.cj.getVisibility() == 0) {
            Y();
            return true;
        } else if (((FeedDetailsPresenter) j()).s()) {
            X();
            return true;
        } else {
            return false;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        AppInfo.n().removeCallbacks(this.cD);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        PLVideoPageView pLVideoPageView;
        super.onPause();
        if (((FeedDetailsPresenter) j()).p().getItemType() == 3 && (pLVideoPageView = this.aJ) != null) {
            pLVideoPageView.g();
        }
        this.co.e();
        this.cp.d();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        PLVideoPageView pLVideoPageView;
        super.onResume();
        if (((FeedDetailsPresenter) j()).p().getItemType() == 3 && (pLVideoPageView = this.aJ) != null) {
            pLVideoPageView.f();
        }
        this.co.d();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.bJ.b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    /* renamed from: v */
    public FeedDetailsPresenter i() {
        FeedDetailsPresenter feedDetailsPresenter = (FeedDetailsPresenter) super.i();
        feedDetailsPresenter.a(this);
        return feedDetailsPresenter;
    }

    public void w() {
        if (CommunityManager.a.a().c(((FeedDetailsPresenter) j()).p().feed_uid)) {
            this.bR.setHint("");
        } else if (((FeedDetailsPresenter) j()).i) {
            this.bR.setHint(FeedMethods.a(this.cl));
        } else {
            this.bR.setHint(R.string.feed_detail_comment_guide_hint);
        }
    }

    public void x() {
        if (UserInfoHelper.a(((FeedDetailsPresenter) j()).p().relationship)) {
            return;
        }
        ((FeedDetailsPresenter) j()).p().iliked = 1;
        ((FeedDetailsPresenter) j()).p().isPlayLikeAnim = true;
        LikeListDataObserver.a().a(UserInfoUtils.c(), ((FeedDetailsPresenter) j()).p().iliked);
        AppInfo.n().removeCallbacks(this.cD);
        LiveEventBus.get("feed_like_change").post(((FeedDetailsPresenter) j()).p());
        FeedHttpUtils.a(getContext(), (BluedUIHttpResponse) null, UserInfoUtils.c(), ((FeedDetailsPresenter) j()).o(), ((FeedDetailsPresenter) j()).p().is_ads, ((FeedDetailsPresenter) j()).p().liked_url, getFragmentActive());
    }

    public void y() {
        if (UserInfoHelper.a(((FeedDetailsPresenter) j()).p().relationship)) {
            return;
        }
        ((FeedDetailsPresenter) j()).p().iliked = 0;
        LikeListDataObserver.a().a(UserInfoUtils.c(), ((FeedDetailsPresenter) j()).p().iliked);
        LiveEventBus.get("feed_like_change").post(((FeedDetailsPresenter) j()).p());
        FeedHttpUtils.a(getContext(), (BluedUIHttpResponse) null, UserInfoUtils.c(), ((FeedDetailsPresenter) j()).o(), ((FeedDetailsPresenter) j()).p().is_ads, getFragmentActive());
    }

    public void z() {
        if (((FeedDetailsPresenter) j()).s()) {
            X();
        } else {
            getActivity().finish();
        }
    }
}
