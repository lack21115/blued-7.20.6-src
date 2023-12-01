package com.blued.community.ui.feed.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.location.CoordinateConverter;
import com.anythink.core.api.ATAdInfo;
import com.anythink.expressad.video.module.a.a.m;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativeEventListener;
import com.blued.ad.NativeListHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageOptions;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.SafeUtils;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.NetworkUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.view.FollowStatusView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.view.GradientTextView;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.android.module.common.widget.refresh.RecommendLoadMoreView;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.auto.ICommunityShowPageService;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.model.LiveRecommendExtra;
import com.blued.community.track.ByteDanceEvent;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.track.EventTrackVote;
import com.blued.community.ui.circle.adapter.CircleListAdapter;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.fragment.CirclePostDetailsFragment;
import com.blued.community.ui.circle.fragment.CircleTypeListFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.observer.ICircleDataObserver;
import com.blued.community.ui.circle.view.CircleJoinView;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.fragment.SignFeedListFragment;
import com.blued.community.ui.feed.fragment.SignInteractiveListFragment;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.CircleListToDetailParams;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.model.RecommendFeedRefreshGuideModel;
import com.blued.community.ui.feed.observer.IFeedDataObserver;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.fragment.FeedPostSignBaseFragment;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.community.ui.square.adapter.FeedHorizontalRecommendAdapter;
import com.blued.community.ui.square.adapter.RecommendChatRoomAdapter;
import com.blued.community.ui.square.adapter.RecommendTopicAdapter;
import com.blued.community.ui.square.fragment.HotFeedFragment;
import com.blued.community.ui.square.fragment.NearbyFeedFragment;
import com.blued.community.ui.square.fragment.RecommendFeedFragment;
import com.blued.community.ui.square.model.FeedRecommendUser;
import com.blued.community.ui.subject.fragment.AutoPollRecyclerView;
import com.blued.community.ui.topic.fragment.SuperTopicDetailFragment;
import com.blued.community.ui.topic.fragment.SuperTopicFragment;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.video.fragment.VideoScanFragment;
import com.blued.community.ui.video.fragment.VideoUserInfoFragment;
import com.blued.community.utils.AtUserHelper;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.CommunityShareUtils;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.utils.ViewUtils;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.community.view.CommonViewHolder;
import com.blued.community.view.FeedItemSayHelloGuideView;
import com.blued.community.view.PhotoGridView;
import com.blued.community.view.TextViewFixTouchForDynamic;
import com.blued.community.view.VerticalCenterImageSpan;
import com.blued.community.widget.FeedGuidePop;
import com.blued.community.widget.vote.picture.FeedVoteGroup;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.vote.VoteProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.igexin.push.config.c;
import com.igexin.push.core.b;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView.class */
public class FeedListAdapterForRecyclerView extends BaseMultiItemQuickAdapter<BluedIngSelfFeed, BaseViewHolder> implements ICircleDataObserver, IFeedDataObserver {
    public CircleListAdapter A;
    private ImageOptions B;
    private final HashSet<String> C;
    private String D;
    private int E;
    private int F;
    private PLVideoPageView G;
    private NativeListHelper H;
    private FeedHandler I;
    private int J;
    private boolean K;
    private int L;
    private int M;
    private long N;
    private long O;
    private long P;

    /* renamed from: a  reason: collision with root package name */
    public Context f19617a;
    protected BaseFragment b;

    /* renamed from: c  reason: collision with root package name */
    public IRequestHost f19618c;
    public int d;
    public int e;
    public Dialog f;
    public int g;
    public int h;
    public boolean i;
    public String j;
    public int k;
    public boolean l;
    public int m;
    public String n;
    protected long o;
    public int p;
    public int q;
    public int r;
    public RecyclerView.OnScrollListener s;
    public String t;
    public String u;
    public String v;
    public int w;
    public FeedHorizontalRecommendAdapter x;
    public RecommendTopicAdapter y;
    public RecommendChatRoomAdapter z;

    /* renamed from: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView$6  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$6.class */
    class AnonymousClass6 implements ATNativeEventListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluedIngSelfFeed f19630a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FeedListAdapterForRecyclerView f19631c;

        @Override // com.anythink.nativead.api.ATNativeEventListener
        public void onAdClicked(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
            EventTrackFeed.a(FeedProtos.Event.CITY_AD_CLICK, this.f19630a, this.f19631c.d, this.b, false, this.f19631c.o, this.f19631c.f(this.b) - 1);
            CommunityHttpUtils.a(this.f19630a.click_url);
        }

        @Override // com.anythink.nativead.api.ATNativeEventListener
        public void onAdImpressed(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
            CommunityHttpUtils.a(this.f19630a.show_url);
        }

        @Override // com.anythink.nativead.api.ATNativeEventListener
        public void onAdVideoEnd(ATNativeAdView aTNativeAdView) {
        }

        @Override // com.anythink.nativead.api.ATNativeEventListener
        public void onAdVideoProgress(ATNativeAdView aTNativeAdView, int i) {
        }

        @Override // com.anythink.nativead.api.ATNativeEventListener
        public void onAdVideoStart(ATNativeAdView aTNativeAdView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$AdFeedViewHolder.class */
    public class AdFeedViewHolder implements View.OnClickListener {
        private BluedIngSelfFeed b;

        /* renamed from: c  reason: collision with root package name */
        private int f19639c;
        private ImageView d;
        private TextView e;
        private ImageView f;
        private TextView g;
        private ImageView h;
        private ImageView i;

        public AdFeedViewHolder(View view) {
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            this.d = (ImageView) view.findViewById(R.id.header_view);
            this.e = (TextView) view.findViewById(R.id.name_view);
            this.f = (ImageView) view.findViewById(R.id.ad_option);
            this.g = (TextView) view.findViewById(R.id.tv_ad_content);
            this.h = (ImageView) view.findViewById(R.id.img_ad);
            this.i = (ImageView) view.findViewById(R.id.img_ad_icon);
        }

        private void b() {
            if (this.b.can_close == 1) {
                this.f.setVisibility(0);
                this.f.setOnClickListener(new SingleClickProxy(this));
                return;
            }
            this.f.setVisibility(8);
            this.f.setOnClickListener(new SingleClickProxy(this));
        }

        private void c() {
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, AvatarUtils.a(0, this.b.user_avatar)).b(R.drawable.user_bg_round).c().a(this.d);
            this.e.setText(!TextUtils.isEmpty(this.b.note) ? this.b.note : this.b.user_name);
            if (TextUtils.isEmpty(this.b.target_url)) {
                this.d.setOnClickListener(null);
                this.e.setOnClickListener(null);
            } else {
                this.d.setOnClickListener(new SingleClickProxy(this));
                this.e.setOnClickListener(new SingleClickProxy(this));
            }
            if (TextUtils.isEmpty(this.b.feed_content)) {
                this.g.setVisibility(8);
            } else {
                this.g.setText(this.b.feed_content);
                this.g.setVisibility(0);
            }
            if (this.b.is_show_adm_icon == 1) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            try {
                if (this.b.feed_pics_width != null && this.b.feed_pics_width.length > 0) {
                    float parseFloat = Float.parseFloat(this.b.feed_pics_height[0]) / Float.parseFloat(this.b.feed_pics_width[0]);
                    ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
                    layoutParams.width = AppInfo.l - DensityUtils.a(FeedListAdapterForRecyclerView.this.f19617a, 20.0f);
                    layoutParams.height = (int) (layoutParams.width * parseFloat);
                    this.h.setLayoutParams(layoutParams);
                }
            } catch (Exception e) {
            }
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, AvatarUtils.a(this.b.feed_pics[0])).a(FeedListAdapterForRecyclerView.this.B).a(this.h);
            this.h.setOnClickListener(new SingleClickProxy(this));
        }

        private void d() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(FeedListAdapterForRecyclerView.this.f19617a.getResources().getString(R.string.not_interest));
            CommonShowBottomWindow.a((FragmentActivity) FeedListAdapterForRecyclerView.this.f19617a, (String[]) arrayList.toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.AdFeedViewHolder.1
                @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                public void a(ActionSheet actionSheet, int i) {
                    if (!actionSheet.a(i).equals(FeedListAdapterForRecyclerView.this.f19617a.getResources().getString(R.string.not_interest))) {
                        return;
                    }
                    FeedListAdapterForRecyclerView.this.remove(AdFeedViewHolder.this.f19639c);
                    LiveEventBus.get("feed_delete").post(AdFeedViewHolder.this.b);
                    if (AdFeedViewHolder.this.b.hidden_url == null || AdFeedViewHolder.this.b.hidden_url.length <= 0) {
                        return;
                    }
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= AdFeedViewHolder.this.b.hidden_url.length) {
                            return;
                        }
                        CommunityHttpUtils.a(AdFeedViewHolder.this.b.hidden_url[i3]);
                        i2 = i3 + 1;
                    }
                }

                @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                public void a(ActionSheet actionSheet, boolean z) {
                }
            });
        }

        private void e() {
            CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, this.b.detail_url, CommunityConstants.WebShowType.AD);
            if (this.b.click_url != null && this.b.click_url.length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.b.click_url.length) {
                        break;
                    }
                    CommunityHttpUtils.a(this.b.click_url[i2]);
                    i = i2 + 1;
                }
            }
            a();
        }

        private void f() {
            CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, this.b.target_url, CommunityConstants.WebShowType.AD);
            if (this.b.click_url != null && this.b.click_url.length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.b.click_url.length) {
                        break;
                    }
                    CommunityHttpUtils.a(this.b.click_url[i2]);
                    i = i2 + 1;
                }
            }
            a();
        }

        protected void a() {
            EventTrackFeed.a(FeedProtos.Event.FEED_AD_CLICK, this.b, FeedListAdapterForRecyclerView.this.d, this.f19639c, false, FeedListAdapterForRecyclerView.this.o, FeedListAdapterForRecyclerView.this.f(this.f19639c) - 1);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.b = bluedIngSelfFeed;
            bluedIngSelfFeed.adPosition = i;
            this.f19639c = i;
            FeedListAdapterForRecyclerView.this.c(bluedIngSelfFeed, i);
            c();
            b();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            int id = view.getId();
            if (id == R.id.header_view || id == R.id.name_view) {
                f();
            } else if (id == R.id.img_ad) {
                e();
            } else if (id == R.id.ad_option) {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$BaseFeedViewHolder.class */
    public abstract class BaseFeedViewHolder implements View.OnClickListener {
        private TextView A;
        private ImageView B;
        private ImageView C;
        private View D;
        private TextView E;
        private View F;
        private ImageView G;
        private ImageView H;
        private ImageView I;
        private ImageView J;
        private TextView K;
        private ImageView L;
        private ImageView M;
        private ImageView N;
        private LinearLayout O;
        private TextView P;
        private ImageView Q;
        private FollowStatusView R;
        private LinearLayout S;
        private TextView T;
        private ImageView U;
        private LinearLayout V;
        private View W;
        private TextView X;
        private View Y;
        private TextView Z;

        /* renamed from: a  reason: collision with root package name */
        protected BluedIngSelfFeed f19641a;
        private View aA;
        private TextView aB;
        private TextView aC;
        private TextView aD;
        private LinearLayout aE;
        private View aF;
        private View aG;
        private ImageView aH;
        private ImageView aI;
        private View aa;
        private TextView ab;
        private TextView ac;
        private TextView ad;
        private TextView ae;
        private ImageView af;
        private TextView ag;
        private View ah;
        private FlowLayout ai;
        private View aj;
        private View ak;
        private ImageView al;
        private TextView am;
        private View an;
        private ImageView ao;
        private TextView ap;
        private TextView aq;

        /* renamed from: ar  reason: collision with root package name */
        private ImageView f19642ar;
        private FeedItemSayHelloGuideView as;
        private View at;
        private TextView au;
        private ImageView av;
        private TextView aw;
        private ImageView ax;
        private SVGAImageView ay;
        private ImageView az;
        protected String b;

        /* renamed from: c  reason: collision with root package name */
        protected View f19643c;
        public int d;
        public View e;
        protected View f;
        public ImageView g;
        public ShapeLinearLayout h;
        protected View i;
        protected View j;
        protected View k;
        protected View l;
        protected ImageView m;
        protected TextView n;
        protected View o;
        protected View p;
        protected ImageView q;
        protected View r;
        protected View s;
        protected LinearLayout t;
        protected ImageView u;
        protected TextView v;
        private View x;
        private View y;
        private ImageView z;

        public BaseFeedViewHolder(View view) {
            this.x = view;
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            View a2 = a(R.id.feed);
            this.y = a2;
            a2.setOnClickListener(new SingleClickProxy(this));
            this.e = a(R.id.feed_visible);
            this.z = (ImageView) a(R.id.iv_visible);
            this.A = (TextView) a(R.id.tv_visible);
            this.B = (ImageView) a(R.id.visible_menu_view);
            this.C = (ImageView) a(R.id.img_promotion_bubble);
            this.f = a(R.id.feed_top_layout_id);
            this.D = a(R.id.feed_interact);
            this.E = (TextView) a(R.id.tv_interact_desc);
            this.F = a(R.id.feed_user_info);
            this.G = (ImageView) a(R.id.header_view);
            this.H = (ImageView) a(R.id.img_live);
            this.I = (ImageView) a(R.id.img_verify);
            this.J = (ImageView) a(R.id.img_online);
            this.K = (TextView) a(R.id.name_view);
            this.L = (ImageView) a(R.id.img_anonymous);
            this.M = (ImageView) a(R.id.img_name_verify);
            this.N = (ImageView) a(R.id.img_blued_medal);
            this.O = (LinearLayout) view.findViewById(R.id.ll_ad_option);
            this.P = (TextView) view.findViewById(R.id.tv_feed_ad);
            this.Q = (ImageView) view.findViewById(R.id.img_feed_ad_arrow);
            this.g = (ImageView) a(R.id.menu_view);
            this.R = (FollowStatusView) a(R.id.follow_status_view);
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) a(R.id.ll_read);
            this.h = shapeLinearLayout;
            ShapeHelper.b(shapeLinearLayout, R.color.syc_x);
            this.S = (LinearLayout) a(R.id.ll_read_num);
            this.T = (TextView) a(R.id.tv_read_num);
            this.U = (ImageView) a(R.id.iv_read_extend);
            this.V = (LinearLayout) a(R.id.ll_distance_and_time);
            this.W = a(R.id.dot_icon_recommend);
            this.X = (TextView) a(R.id.distance_view);
            this.Y = a(R.id.dot_icon_distance);
            this.ab = (TextView) a(R.id.time_view);
            this.ac = (TextView) a(R.id.tv_feed_recommend_source);
            this.ad = (TextView) a(R.id.tv_feed_recommend_time);
            this.ae = (TextView) a(R.id.tv_user_kol);
            this.af = (ImageView) a(R.id.img_feed_sticky);
            this.aa = a(R.id.dot_age_height_weight);
            this.Z = (TextView) a(R.id.tv_age_height_weight);
            this.ag = (TextView) a(R.id.item_feed_sign_new_face);
            this.aj = a(R.id.feed_location);
            this.ak = a(R.id.location_layout);
            this.al = (ImageView) a(R.id.location_icon);
            this.am = (TextView) a(R.id.location_text);
            this.an = a(R.id.event_layout);
            this.ao = (ImageView) a(R.id.event_icon);
            this.ap = (TextView) a(R.id.event_text);
            this.i = a(R.id.feed_interact_layout);
            this.aq = (TextView) a(R.id.feed_interact_num_tv);
            this.f19642ar = (ImageView) a(R.id.feed_interact_iv_static);
            this.as = (FeedItemSayHelloGuideView) a(R.id.feed_say_hello_guide_ly);
            this.at = a(R.id.feed_mine_visit_num_layout);
            this.au = (TextView) a(R.id.feed_mine_visit_num_tv);
            this.av = (ImageView) a(R.id.feed_mine_visit_num_iv);
            this.ah = a(R.id.layout_super_topic);
            this.ai = (FlowLayout) a(R.id.flow_layout_topics_and_hot);
            this.j = a(R.id.feed_feed_info);
            this.k = a(R.id.ll_zan_view);
            this.l = a(R.id.ll_zan_content_view);
            this.m = (ImageView) a(R.id.icon_like);
            this.n = (TextView) a(R.id.zan_num_text);
            this.o = a(R.id.ll_details_comments);
            this.p = a(R.id.ll_details_comments_content);
            this.q = (ImageView) a(R.id.icon_comments);
            this.aw = (TextView) a(R.id.comment_num_text);
            this.r = a(R.id.ll_details_share);
            this.s = a(R.id.ll_details_share_content);
            this.t = (LinearLayout) a(R.id.ll_hello);
            this.u = (ImageView) a(R.id.icon_share);
            this.v = (TextView) a(R.id.tv_share);
            this.ay = (SVGAImageView) a(R.id.recommend_feed_guide_zan_anim);
            this.az = (ImageView) a(R.id.img_like_anim);
            this.aA = a(R.id.feed_comment);
            this.aB = (TextView) a(R.id.reply_view_one);
            this.aD = (TextView) a(R.id.tv_reply_more);
            this.aC = (TextView) a(R.id.reply_view_two);
            this.aE = (LinearLayout) a(R.id.reply_view_more);
            this.aF = a(R.id.feed_more_feed);
            this.aG = a(R.id.view_btm_line);
            this.aH = (ImageView) a(R.id.feed_dynamic_skin);
            this.aI = (ImageView) a(R.id.iv_avatar_widget);
            this.ax = (ImageView) a(R.id.img_live_new_icon);
        }

        private void A() {
            boolean z;
            if (this.ah == null) {
                return;
            }
            if (this.f19641a.is_super_topics == 1 && !TextUtils.isEmpty(this.f19641a.super_topics_name) && !TextUtils.isEmpty(this.f19641a.super_did)) {
                String[] split = this.f19641a.super_topics_name.split(",");
                String[] split2 = this.f19641a.super_did.split(",");
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
                        } else if (str.contains("&")) {
                            bluedTopic.is_anonym = 1;
                            bluedTopic.super_did = str.split("&")[0];
                        } else {
                            bluedTopic.is_anonym = 0;
                            bluedTopic.super_did = str;
                        }
                        arrayList.add(bluedTopic);
                        i = i2 + 1;
                    }
                    ViewUtils.a(FeedListAdapterForRecyclerView.this.f19617a, arrayList, this.ai, true, new ViewUtils.ITopicListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.6
                        @Override // com.blued.community.utils.ViewUtils.ITopicListener
                        public void a(View view) {
                        }

                        @Override // com.blued.community.utils.ViewUtils.ITopicListener
                        public void a(BluedTopic bluedTopic2) {
                            BaseFeedViewHolder.this.a(bluedTopic2);
                        }
                    }, true);
                    z = true;
                    ViewUtils.a(FeedListAdapterForRecyclerView.this.f19617a, this.ai, this.f19641a.is_top_hot, new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$BaseFeedViewHolder$SbLqtLMZXg9DHsB54deFjckYsZw
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            FeedListAdapterForRecyclerView.BaseFeedViewHolder.this.d(view);
                        }
                    });
                    if (this.f19641a.is_top_hot != 1 || z) {
                        this.ah.setVisibility(0);
                    } else {
                        this.ah.setVisibility(8);
                        return;
                    }
                }
            }
            z = false;
            ViewUtils.a(FeedListAdapterForRecyclerView.this.f19617a, this.ai, this.f19641a.is_top_hot, new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$BaseFeedViewHolder$SbLqtLMZXg9DHsB54deFjckYsZw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.BaseFeedViewHolder.this.d(view);
                }
            });
            if (this.f19641a.is_top_hot != 1) {
            }
            this.ah.setVisibility(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:113:0x030e  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x031e  */
        /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01ba  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01ef  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0207  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0213  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0218  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0224  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x022a  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0237  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x023d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void B() {
            /*
                Method dump skipped, instructions count: 833
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.B():void");
        }

        private boolean C() {
            if (this.f19641a.is_bubble_ticktock != 1 || i() || UserInfoHelper.a(this.f19641a.vbadge) || UserInfoHelper.b(this.f19641a.vbadge)) {
                return (!FeedListAdapterForRecyclerView.this.k() || i() || j() || UserInfoHelper.a(this.f19641a.vbadge) || UserInfoHelper.b(this.f19641a.vbadge)) ? false : true;
            }
            return true;
        }

        private void D() {
            if (this.S == null) {
                return;
            }
            if (!i() || this.f19641a.is_bubble_ticktock == 1) {
                this.S.setVisibility(8);
                return;
            }
            this.S.setVisibility(0);
            this.S.setOnClickListener(new SingleClickProxy(this));
            this.T.setText(m().getFeedFeedShow(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.feed_show));
            if (this.f19641a.can_promotion != 1) {
                this.U.setVisibility(8);
                return;
            }
            int i = this.f19641a.promotion_status;
            if (i == 1) {
                this.U.setImageResource(R.drawable.feed_icon_extend);
                this.U.setVisibility(0);
            } else if (i == 2) {
                this.U.setImageResource(R.drawable.feed_icon_wait_extend);
                this.U.setVisibility(0);
            } else if (i != 3) {
                this.U.setVisibility(8);
            } else {
                this.U.setImageResource(R.drawable.feed_icon_extended);
                this.U.setVisibility(0);
            }
        }

        private void E() {
            if (i()) {
                this.g.setVisibility(8);
                this.O.setVisibility(8);
            } else if (this.f19641a.is_recommend != 1) {
                this.g.setVisibility(0);
                this.g.setOnClickListener(new SingleClickProxy(this));
                this.g.setImageDrawable(FeedListAdapterForRecyclerView.this.f19617a.getResources().getDrawable(R.drawable.feed_list_icon_more));
                this.O.setVisibility(8);
            } else {
                this.g.setVisibility(8);
                this.O.setVisibility(0);
                this.O.setOnClickListener(new SingleClickProxy(this));
            }
            if (!FeedListAdapterForRecyclerView.this.g() && !FeedListAdapterForRecyclerView.this.h() && !i() && !FeedListAdapterForRecyclerView.this.k() && !j()) {
                this.R.setOnClickListener(new SingleClickProxy(this));
                this.R.setVisibility(0);
                this.R.setRelationShip("0");
            } else if (this.f19641a.forceShowFollowedStatus && j()) {
                this.R.setVisibility(0);
                this.R.setRelationShip(this.f19641a.relationship);
                this.R.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$BaseFeedViewHolder$ai5hvqff5SMIFmso6UauDERSXoE
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedListAdapterForRecyclerView.BaseFeedViewHolder.this.c(view);
                    }
                });
            } else {
                this.R.setVisibility(8);
            }
            if (l() || this.f19641a.is_bubble_ticktock == 1) {
                this.R.setVisibility(8);
            }
            if (i()) {
                this.af.setVisibility(8);
            } else if (FeedListAdapterForRecyclerView.this.g() && this.f19641a.feed_views == 1) {
                this.af.setVisibility(0);
            } else {
                this.af.setVisibility(8);
            }
        }

        private void F() {
            if (l()) {
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, AvatarUtils.a(0, this.f19641a.user_avatar)).b(R.drawable.user_bg_round).d().a(this.G);
                this.L.setVisibility(0);
            } else {
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, AvatarUtils.a(0, this.f19641a.user_avatar)).b(R.drawable.user_bg_round).a(this.G);
                this.L.setVisibility(8);
            }
            this.G.setOnClickListener(new SingleClickProxy(this));
            this.K.setText(!TextUtils.isEmpty(this.f19641a.note) ? this.f19641a.note : this.f19641a.user_name);
            FeedMethods.a(this.K, this.f19641a.feed_uid, l());
            this.K.setOnClickListener(new SingleClickProxy(this));
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = this.f19641a.vip_grade;
            userBasicModel.is_vip_annual = this.f19641a.is_vip_annual;
            userBasicModel.is_hide_vip_look = this.f19641a.is_hide_vip_look;
            userBasicModel.vip_exp_lvl = this.f19641a.vip_exp_lvl;
            userBasicModel.uid = this.f19641a.feed_id;
            UserInfoHelper.a(FeedListAdapterForRecyclerView.this.f19617a, this.K, userBasicModel);
            UserInfoHelper.a(this.N, userBasicModel, FeedListAdapterForRecyclerView.this.f19618c);
            ImageView imageView = this.ax;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (this.f19641a.getYYLiving()) {
                this.I.setVisibility(8);
                this.J.setVisibility(8);
                UserInfoHelper.a(this.ax, this.f19641a.feed_id, this.f19641a.getYYLiving(), FeedListAdapterForRecyclerView.this.f19618c);
            } else if (this.f19641a.is_bubble_ticktock == 1) {
                this.I.setVisibility(8);
                this.M.setVisibility(0);
                UserInfoHelper.a(this.M, this.f19641a.vbadge, 2, 8);
                this.H.setVisibility(8);
                this.J.setVisibility(0);
                if ((FeedListAdapterForRecyclerView.this.k() || FeedListAdapterForRecyclerView.this.d == 26) && this.f19641a.online_state == 1) {
                    this.J.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_user_online));
                } else {
                    this.J.setVisibility(8);
                }
            } else if (!FeedListAdapterForRecyclerView.this.k()) {
                this.J.setVisibility(8);
                this.M.setVisibility(8);
                if (this.f19641a.live <= 0) {
                    UserInfoHelper.a(this.I, this.f19641a.vbadge, 3);
                    this.H.setVisibility(4);
                    return;
                }
                this.I.setVisibility(8);
                this.H.setVisibility(0);
                ImageLoader.c(FeedListAdapterForRecyclerView.this.f19618c, "anim_feed_live_list.png").e(this.f19641a.hashCode()).g(-1).a(this.H);
            } else {
                this.I.setVisibility(8);
                this.J.setVisibility(0);
                this.M.setVisibility(0);
                this.H.setVisibility(4);
                UserInfoHelper.b(this.M, this.f19641a.vbadge, 2, 8);
                if (this.f19641a.live > 0) {
                    this.J.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.user_list_live_icon));
                } else if (this.f19641a.online_state == 1) {
                    this.J.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_user_online));
                } else {
                    this.J.setVisibility(8);
                }
            }
        }

        private void G() {
            if (this.D == null) {
                return;
            }
            if (!FeedListAdapterForRecyclerView.this.l() && !FeedListAdapterForRecyclerView.this.m()) {
                this.D.setVisibility(8);
                return;
            }
            this.D.setVisibility(0);
            if (this.f19641a.is_expression != 1 || this.f19641a.show_expression_id <= 0) {
                this.E.setText(this.f19641a.interact_desc);
                return;
            }
            String str = this.f19641a.interact_desc + FeedMethods.d(this.f19641a.show_expression_id) + " expression_emotion";
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            FeedMethods.a(spannableStringBuilder, str, "expression_emotion", FeedMethods.f(this.f19641a.show_expression_id), 18, 18);
            this.E.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }

        private void H() {
            if (!i() || FeedListAdapterForRecyclerView.this.d == 11 || FeedListAdapterForRecyclerView.this.d == 12) {
                View view = this.e;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            this.e.setVisibility(0);
            if (this.f19641a.feed_views == 1) {
                this.z.setImageResource(R.drawable.feed_visible_top);
                this.A.setText(FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.feed_top));
                this.A.setTextColor(FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.syc_f));
            } else if (l()) {
                this.C.setVisibility(8);
                this.z.setImageResource(R.drawable.feed_details_anonymous);
                this.A.setText(R.string.feed_anonymous);
                this.A.setTextColor(FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.syc_k));
            } else {
                this.A.setTextColor(FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.syc_j));
                FeedMethods.a(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.reading_scope, this.z, this.A);
            }
            if (TextUtils.isEmpty(this.f19641a.promotion_bubble)) {
                this.C.setVisibility(8);
            } else {
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, this.f19641a.promotion_bubble).f().a(this.C);
                this.C.setVisibility(0);
                this.C.setOnClickListener(new SingleClickProxy(this));
            }
            this.B.setOnClickListener(new SingleClickProxy(this));
        }

        private boolean I() {
            return this.f19641a.theme_id != 0;
        }

        private boolean J() {
            return this.f19641a.theme_pendant != 0;
        }

        private void K() {
            a(this.f19641a, false);
        }

        private void L() {
            a(this.f19641a, false);
            LogData logData = new LogData();
            logData.logService = "feed_comment_area_click";
            logData.id = this.f19641a.feed_id;
            logData.from = FeedMethods.b(FeedListAdapterForRecyclerView.this.d) + "";
            logData.type = this.f19641a.recommend_text;
            if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.this.j)) {
                logData.topic_id = FeedListAdapterForRecyclerView.this.j;
            }
            if (FeedListAdapterForRecyclerView.this.k != -1) {
                logData.topic_category = FeedListAdapterForRecyclerView.this.k + "";
            }
            CommunityServiceManager.d().a(logData);
        }

        private void M() {
            if (g()) {
                EventTrackFeed.d(FeedProtos.Event.PLAZA_RECOMMEND_NOTE_COMMENT_CLICK, this.f19641a.circle_id, this.f19641a.feed_id);
            } else {
                CommunityServiceManager.d().b(FeedMethods.b(FeedListAdapterForRecyclerView.this.d), this.f19641a, FeedListAdapterForRecyclerView.this.j, FeedListAdapterForRecyclerView.this.k);
            }
            if (CommunityServiceManager.a().b(FeedListAdapterForRecyclerView.this.f19617a)) {
                return;
            }
            BluedIngSelfFeed bluedIngSelfFeed = this.f19641a;
            a(bluedIngSelfFeed, bluedIngSelfFeed.anchor_comment_id);
        }

        private void N() {
            EventTrackFeed.a(FeedProtos.Event.HOT_FEED_ICON_CLICK, this.f19641a.feed_id, EventTrackFeed.d(FeedListAdapterForRecyclerView.this.d));
            HotFeedFragment.f20141a.a(FeedListAdapterForRecyclerView.this.f19617a);
        }

        private void O() {
            FeedListAdapterForRecyclerView.this.a(this.f19641a.activity_data.id, this.f19641a.activity_data.uid, FeedProtos.SourcePage.ACTIVITY_FEED, this.f19641a);
        }

        private void P() {
            if (Q()) {
                CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.location_lot, this.f19641a.location_lat, this.f19641a.location);
            }
        }

        private boolean Q() {
            new CoordinateConverter(FeedListAdapterForRecyclerView.this.f19617a);
            return !(TextUtils.isEmpty(this.f19641a.location_lot) && TextUtils.isEmpty(this.f19641a.location_lat)) && CoordinateConverter.isAMapDataAvailable(Double.parseDouble(this.f19641a.location_lat), Double.parseDouble(this.f19641a.location_lot));
        }

        private void R() {
            EventTrackFeed.b(FeedProtos.Event.FEED_VIEW_NUM_CLICK, this.f19641a, FeedListAdapterForRecyclerView.this.d);
            if (TextUtils.isEmpty(this.f19641a.promotion_url)) {
                return;
            }
            CommunityServiceManager.d().c("feed_read_count_click", FeedMethods.b(FeedListAdapterForRecyclerView.this.d));
            CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.promotion_url, CommunityConstants.WebShowType.HIDE_RIGHT);
        }

        private void a(View view) {
            if (this.j == null) {
                return;
            }
            LogUtils.c("推荐下滑 执行赞转评缩放动画， position:" + this.d);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "ScaleX", 1.0f, 1.08f, 1.0f, 1.08f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleY", 1.0f, 1.08f, 1.0f, 1.08f, 1.0f);
            ofFloat.setDuration(932L);
            ofFloat2.setDuration(932L);
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (BaseFeedViewHolder.this.ay == null || BaseFeedViewHolder.this.m == null) {
                        LogUtils.c("推荐下滑 执行点赞引导动画未执行");
                        return;
                    }
                    LogUtils.c("推荐下滑 执行点赞引导动画， position:" + BaseFeedViewHolder.this.d);
                    int[] iArr = new int[2];
                    BaseFeedViewHolder.this.m.getLocationInWindow(iArr);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) BaseFeedViewHolder.this.ay.getLayoutParams();
                    marginLayoutParams.leftMargin = iArr[0] - (FeedMethods.c(41) / 2);
                    BaseFeedViewHolder.this.ay.setLayoutParams(marginLayoutParams);
                    BaseFeedViewHolder.this.ay.setVisibility(0);
                    new SVGAPlayer.Builder().a("recommend_feed_refresh_guide_zan_anim.svga").a((Integer) 2).a(BaseFeedViewHolder.this.ay);
                    BaseFeedViewHolder.this.ay.setCallback(new SVGACallback() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.5.1
                        @Override // com.blued.android.module.svgaplayer.SVGACallback
                        public void onFinished() {
                            BaseFeedViewHolder.this.ay.setVisibility(8);
                            LogUtils.c("推荐下滑 点赞引导动画finish， position:" + BaseFeedViewHolder.this.d);
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
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            EventTrackFeed.e(FeedProtos.Event.FEED_RECOMMEND_LIKE_GUIDE_SHOW, this.f19641a.feed_id);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view, View view2) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            CommRouteUtil.a(FeedListAdapterForRecyclerView.this.b, iArr);
        }

        private void a(FeedDetailParams feedDetailParams, BluedIngSelfFeed bluedIngSelfFeed) {
            if (feedDetailParams == null || bluedIngSelfFeed == null) {
                return;
            }
            feedDetailParams.mode = "";
            feedDetailParams.tips = bluedIngSelfFeed.tips;
            feedDetailParams.strong_insert_data = bluedIngSelfFeed.strong_insert_data;
            feedDetailParams.is_new_face = bluedIngSelfFeed.is_new_face;
            feedDetailParams.tips_text = bluedIngSelfFeed.tips_text;
            feedDetailParams.recommend_time = bluedIngSelfFeed.recommend_time;
            feedDetailParams.is_top_feed = bluedIngSelfFeed.is_top_feed;
            feedDetailParams.is_subject_recommend_feed = bluedIngSelfFeed.is_op_recommend;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(BluedTopic bluedTopic) {
            EventTrackFeed.a(FeedProtos.Event.FEED_SUPER_TOPIC_ENTER_CLICK, this.f19641a.feed_id, this.f19641a.super_did, FeedProtos.FeedTopicPage.FEED_TOPIC_FEED_LIST);
            FeedConstants.b = EventTrackFeed.b(FeedListAdapterForRecyclerView.this.d);
            SuperTopicDetailFragment.a(FeedListAdapterForRecyclerView.this.f19617a, bluedTopic.super_did);
        }

        private void b(View view) {
            this.Q.setImageDrawable(FeedListAdapterForRecyclerView.this.f19617a.getResources().getDrawable(R.drawable.icon_feed_arrow_up));
            String str = this.f19641a.feed_id;
            View inflate = LayoutInflater.from(FeedListAdapterForRecyclerView.this.f19617a).inflate(R.layout.feed_ad_pop, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_adopt_msg);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_adopt_notinterested);
            if (TextUtils.isEmpty(this.f19641a.recommend_text)) {
                textView.setText(FeedListAdapterForRecyclerView.this.f19617a.getResources().getString(R.string.bigdata_message));
            } else {
                textView.setText(this.f19641a.recommend_text);
            }
            final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
            popupWindow.setTouchable(true);
            popupWindow.setBackgroundDrawable(FeedListAdapterForRecyclerView.this.f19617a.getResources().getDrawable(17170445));
            popupWindow.showAsDropDown(view);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.8
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    BaseFeedViewHolder.this.Q.setImageDrawable(FeedListAdapterForRecyclerView.this.f19617a.getResources().getDrawable(R.drawable.icon_feed_arrow_down));
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    BaseFeedViewHolder baseFeedViewHolder = BaseFeedViewHolder.this;
                    baseFeedViewHolder.a(baseFeedViewHolder.f19641a);
                    LiveEventBus.get("feed_delete").post(BaseFeedViewHolder.this.f19641a);
                    popupWindow.dismiss();
                    if (BaseFeedViewHolder.this.f19641a.hidden_url == null || BaseFeedViewHolder.this.f19641a.hidden_url.length <= 0) {
                        return;
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= BaseFeedViewHolder.this.f19641a.hidden_url.length) {
                            return;
                        }
                        CommunityHttpUtils.a(BaseFeedViewHolder.this.f19641a.hidden_url[i2]);
                        i = i2 + 1;
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            this.K.callOnClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            N();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(View view) {
            z();
        }

        private void q() {
            if (this.aI == null) {
                return;
            }
            if (!J()) {
                this.aI.setVisibility(8);
            } else if (this.f19641a.getYYLiving()) {
                this.aI.setVisibility(8);
            } else {
                this.aI.setVisibility(0);
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, CommunityServiceManager.e().d(this.f19641a.theme_pendant)).a(this.aI);
            }
        }

        private void r() {
            if (!I()) {
                this.aH.setVisibility(8);
                return;
            }
            this.aH.setVisibility(0);
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, CommunityServiceManager.e().c(this.f19641a.theme_id)).a(this.aH);
            this.aH.setOnClickListener(new SingleClickProxy(this));
        }

        private void s() {
            if (this.aG == null || !FeedListAdapterForRecyclerView.this.g()) {
                return;
            }
            if (this.d == FeedListAdapterForRecyclerView.this.mData.size() - 1) {
                this.aG.setVisibility(8);
            } else {
                this.aG.setVisibility(0);
            }
        }

        private void t() {
            if (this.aF == null) {
                return;
            }
            if (this.f19641a.show_hot_entry != 1) {
                this.aF.setVisibility(8);
                return;
            }
            this.aF.setVisibility(0);
            EventTrackFeed.c(FeedProtos.Event.FINE_HOT_MORE_GUIDE_SHOW);
            this.aF.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackFeed.c(FeedProtos.Event.FINE_HOT_MORE_GUIDE_CLICK);
                    HotFeedFragment.f20141a.a(FeedListAdapterForRecyclerView.this.f19617a);
                }
            });
        }

        private void u() {
            if (this.aA == null) {
                return;
            }
            List<CharSequence> commentList = m().getCommentList();
            if (commentList == null || commentList.size() <= 0) {
                this.aA.setVisibility(8);
            } else {
                this.aA.setVisibility(0);
                this.aB.setText(commentList.get(0));
                this.aB.setMovementMethod(LinkMovementClickMethod.a());
                this.aB.setOnClickListener(new SingleClickProxy(this));
                if (commentList.size() >= 2) {
                    this.aC.setVisibility(0);
                    this.aC.setText(commentList.get(1));
                    this.aC.setMovementMethod(LinkMovementClickMethod.a());
                    this.aC.setOnClickListener(new SingleClickProxy(this));
                } else {
                    this.aC.setVisibility(8);
                }
                if (this.f19641a.feed_comment > 2) {
                    if (this.f19641a.is_super_topics == 1) {
                        this.aD.setTextColor(FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.syc_j));
                    }
                    this.aE.setVisibility(0);
                } else {
                    this.aE.setVisibility(8);
                }
            }
            this.aA.setOnClickListener(new SingleClickProxy(this));
            this.aE.setOnClickListener(new SingleClickProxy(this));
        }

        private void v() {
            View view = this.k;
            if (view == null) {
                return;
            }
            view.setOnClickListener(new SingleClickProxy(this));
            if (this.f19641a.iliked == 0) {
                this.m.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_feed_like));
                this.n.setTextColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_h));
            } else {
                if (this.f19641a.isPlayLikeAnim) {
                    String g = FeedMethods.g();
                    if (!FeedListAdapterForRecyclerView.this.o() || TextUtils.isEmpty(g)) {
                        ImageLoader.c(FeedListAdapterForRecyclerView.this.f19618c, FeedMethods.f()).g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.3
                            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                            public void a() {
                            }

                            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                            public void b() {
                                BaseFeedViewHolder.this.az.setImageDrawable(null);
                            }
                        }).a(this.az);
                    } else {
                        ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, g).f().g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.2
                            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                            public void a() {
                            }

                            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                            public void b() {
                                BaseFeedViewHolder.this.az.setImageDrawable(null);
                            }
                        }).a(this.az);
                    }
                }
                if (FeedListAdapterForRecyclerView.this.o() && !TextUtils.isEmpty(FeedMethods.h())) {
                    ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, FeedMethods.h()).d(R.drawable.icon_feed_liked).a(this.m);
                } else if (this.f19641a.isPlayLikeAnim) {
                    ImageLoader.c(FeedListAdapterForRecyclerView.this.f19618c, FeedMethods.e()).g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.4
                        @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                        public void a() {
                        }

                        @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                        public void b() {
                            if (BaseFeedViewHolder.this.f19641a.iliked != 0) {
                                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, R.drawable.icon_feed_liked).a(BaseFeedViewHolder.this.m);
                            }
                        }
                    }).a(this.m);
                } else {
                    ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, R.drawable.icon_feed_liked).a(this.m);
                }
                this.f19641a.isPlayLikeAnim = false;
                this.n.setTextColor(FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.nafio_g));
            }
            this.n.setText(m().getFeedDig(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.feed_dig));
            this.o.setOnClickListener(new SingleClickProxy(this));
            this.aw.setText(m().getFeedComment(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.feed_comment));
            if (c()) {
                this.r.setVisibility(0);
                if (this.f19641a.isDeleted() || this.f19641a.isRepostAndDeleted() || this.f19641a.disallow_share == 1) {
                    this.u.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_feed_unshare));
                    this.v.setTextColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_k_50));
                    this.r.setEnabled(false);
                } else {
                    this.u.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_feed_share));
                    this.v.setTextColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_h));
                    this.r.setEnabled(true);
                    this.r.setOnClickListener(new SingleClickProxy(this));
                }
            } else {
                this.r.setVisibility(8);
            }
            if (d()) {
                this.t.setVisibility(0);
                this.t.setOnClickListener(new SingleClickProxy(this));
            } else {
                this.t.setVisibility(8);
            }
            if (this.f19641a.playAnimType == 8) {
                a(this.j);
                this.f19641a.playAnimType = 0;
            }
        }

        private void w() {
            this.b = b();
            this.f19643c = a();
        }

        private void x() {
            FeedItemSayHelloGuideView feedItemSayHelloGuideView = this.as;
            if (feedItemSayHelloGuideView == null) {
                return;
            }
            feedItemSayHelloGuideView.setFeedData(this.f19641a);
        }

        private void y() {
            if (this.i == null) {
                return;
            }
            if (CommunityManager.f19086a.a().s()) {
                this.f19642ar.setImageResource(R.drawable.feed_interact_static_dark);
            } else {
                this.f19642ar.setImageResource(R.drawable.feed_interact_static);
            }
            if (this.f19641a.is_expression != 1) {
                this.i.setVisibility(8);
                return;
            }
            this.i.setVisibility(0);
            if (this.f19641a.interaction_count > 0) {
                TextView textView = this.aq;
                textView.setText(this.f19641a.interaction_count + "人");
            } else {
                this.aq.setText(R.string.feed_interact);
            }
            if (this.f19641a.expression_id > 0) {
                this.aq.setTextColor(FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.syc_g));
            } else {
                this.aq.setTextColor(FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.syc_k));
            }
            if (this.f19641a.playAnimType == 1) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19642ar, "ScaleX", 1.0f, 1.14f, 1.0f, 1.14f, 1.0f);
                ofFloat.setDuration(800L);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f19642ar, "ScaleY", 1.0f, 1.14f, 1.0f, 1.14f, 1.0f);
                ofFloat2.setDuration(800L);
                ofFloat.start();
                ofFloat2.start();
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f19642ar, "ScaleX", 1.0f, 1.14f, 1.0f, 1.14f, 1.0f);
                ofFloat3.setDuration(800L);
                ofFloat3.setStartDelay(c.j);
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f19642ar, "ScaleY", 1.0f, 1.14f, 1.0f, 1.14f, 1.0f);
                ofFloat4.setDuration(800L);
                ofFloat4.setStartDelay(c.j);
                ofFloat3.start();
                ofFloat4.start();
                this.f19641a.playAnimType = 0;
            }
            this.i.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$BaseFeedViewHolder$konJSjiS6JCMkvg9A2nt-scH_2g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.BaseFeedViewHolder.this.e(view);
                }
            }));
        }

        private void z() {
            if (this.f19641a.iliked == 1 && this.f19641a.expression_id == 0) {
                this.f19641a.expression_id = 1;
            }
            CommRouteUtil.a(FeedListAdapterForRecyclerView.this.b, this.f19642ar, this.f19641a, FeedMethods.a(this.f19641a, FeedListAdapterForRecyclerView.this.d));
            EventTrackFeed.a(FeedProtos.Event.MORE_EMOJI_PANEL_SHOW, this.f19641a, FeedListAdapterForRecyclerView.this.d, false);
        }

        protected abstract View a();

        protected final <T extends View> T a(int i) {
            return (T) this.x.findViewById(i);
        }

        protected void a(BluedIngSelfFeed bluedIngSelfFeed) {
            FeedListAdapterForRecyclerView.this.remove(this.d);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.f19641a = bluedIngSelfFeed;
            this.d = i;
            w();
            h();
            H();
            f();
            G();
            F();
            E();
            D();
            B();
            A();
            e();
            v();
            u();
            t();
            s();
            r();
            q();
        }

        protected void a(BluedIngSelfFeed bluedIngSelfFeed, String str) {
            if (FeedListAdapterForRecyclerView.this.d == 6 && FeedMethods.a(bluedIngSelfFeed)) {
                bluedIngSelfFeed.is_top = bluedIngSelfFeed.is_top_new;
            }
            if (UserInfoHelper.a(bluedIngSelfFeed.relationship)) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                a(bluedIngSelfFeed, true);
            } else {
                FeedDetailParams feedDetailParams = new FeedDetailParams(0);
                feedDetailParams.commentID = str;
                a(feedDetailParams, bluedIngSelfFeed);
                FeedDetailsFragment.a(FeedListAdapterForRecyclerView.this.f19617a, bluedIngSelfFeed, 22, feedDetailParams);
                FeedListAdapterForRecyclerView.this.a(3, bluedIngSelfFeed);
            }
            NearbyFeedFragment.q = SystemClock.elapsedRealtime();
        }

        protected void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
            if (FeedListAdapterForRecyclerView.this.d == 6 && FeedMethods.a(bluedIngSelfFeed)) {
                bluedIngSelfFeed.is_top = bluedIngSelfFeed.is_top_new;
            }
            if (UserInfoHelper.a(bluedIngSelfFeed.relationship)) {
                return;
            }
            if (FeedListAdapterForRecyclerView.this.d == 6) {
                CommunityServiceManager.d().a("discovery_hot");
            } else {
                CommunityServiceManager.d().a("featured_all_to_detail");
            }
            LogData logData = new LogData();
            logData.logService = "recommend_to_detail";
            logData.id = bluedIngSelfFeed.feed_id;
            logData.type = bluedIngSelfFeed.recommend_text;
            logData.url = bluedIngSelfFeed.recommend_type;
            logData.is_new_face = bluedIngSelfFeed.is_new_face;
            logData.recommend_time = bluedIngSelfFeed.recommend_time;
            if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.this.j)) {
                logData.topic_id = FeedListAdapterForRecyclerView.this.j;
            }
            if (FeedListAdapterForRecyclerView.this.k != -1) {
                logData.topic_category = FeedListAdapterForRecyclerView.this.k + "";
            }
            logData.tips = bluedIngSelfFeed.tips;
            CommunityServiceManager.d().a(logData);
            bluedIngSelfFeed.recommendation = "";
            FeedDetailParams feedDetailParams = new FeedDetailParams(FeedListAdapterForRecyclerView.this.g);
            feedDetailParams.isFromComment = z;
            feedDetailParams.hasComment = bluedIngSelfFeed.feed_comment > 0;
            a(feedDetailParams, bluedIngSelfFeed);
            FeedDetailsFragment.a(FeedListAdapterForRecyclerView.this.f19617a, bluedIngSelfFeed, FeedListAdapterForRecyclerView.this.d, feedDetailParams);
            FeedListAdapterForRecyclerView.this.a(3, bluedIngSelfFeed);
        }

        protected void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z, String str, String str2) {
            if (UserInfoHelper.a(bluedIngSelfFeed.relationship)) {
                return;
            }
            LogData logData = new LogData();
            logData.logService = "square_video_click";
            logData.id = bluedIngSelfFeed.feed_id;
            logData.type = bluedIngSelfFeed.recommend_text;
            CommunityServiceManager.d().a(logData);
            BluedIngSelfFeed bluedIngSelfFeed2 = (BluedIngSelfFeed) bluedIngSelfFeed.clone();
            if (FeedListAdapterForRecyclerView.this.d != 1) {
                VideoScanFragment.a(FeedListAdapterForRecyclerView.this.f19617a, bluedIngSelfFeed2, z, FeedListAdapterForRecyclerView.this.d);
                return;
            }
            bluedIngSelfFeed2.feed_uid = str2;
            bluedIngSelfFeed2.feed_id = str;
            VideoUserInfoFragment.a(FeedListAdapterForRecyclerView.this.f19617a, bluedIngSelfFeed2);
        }

        protected void a(boolean z) {
            if (l()) {
                return;
            }
            EventTrackFeed.a(FeedProtos.Event.FEED_PHOTO_CLICK, this.f19641a.feed_id, this.f19641a.feed_uid);
            if (FeedListAdapterForRecyclerView.this.g()) {
                return;
            }
            String a2 = FeedMethods.a(FeedListAdapterForRecyclerView.this.d, this.f19641a.is_vote);
            UserBasicModel b = FeedMethods.b(this.f19641a);
            LogData logData = new LogData();
            logData.logService = "feed_avatar_click";
            logData.id = this.f19641a.feed_id;
            logData.type = this.f19641a.recommend_text;
            logData.target_uid = this.f19641a.feed_uid;
            logData.from = FeedMethods.b(FeedListAdapterForRecyclerView.this.d) + "";
            if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.this.j)) {
                logData.topic_id = FeedListAdapterForRecyclerView.this.j;
            }
            if (FeedListAdapterForRecyclerView.this.k != -1) {
                logData.topic_category = FeedListAdapterForRecyclerView.this.k + "";
            }
            CommunityServiceManager.d().a(logData);
            if (this.f19641a.live > 0 && z) {
                CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, b, this.f19641a.live, a2);
            } else if (!this.f19641a.getYYLiving()) {
                CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, b, this.f19641a, a2, false, (View) this.G, FeedMethods.a(this.f19641a, FeedListAdapterForRecyclerView.this.d, false, FeedListAdapterForRecyclerView.this.j, FeedListAdapterForRecyclerView.this.k), FeedMethods.b(FeedListAdapterForRecyclerView.this.d, this.f19641a.in_promotion));
                if (this.f19641a.click_url != null && this.f19641a.click_url.length > 0) {
                    for (int i = 0; i < this.f19641a.click_url.length; i++) {
                        CommunityHttpUtils.a(this.f19641a.click_url[i]);
                    }
                }
                NearbyFeedFragment.r = SystemClock.elapsedRealtime();
                if (FeedListAdapterForRecyclerView.this.b != null && (FeedListAdapterForRecyclerView.this.b instanceof RecommendFeedFragment)) {
                    ((RecommendFeedFragment) FeedListAdapterForRecyclerView.this.b).b(this.d);
                }
                if (z) {
                    FeedListAdapterForRecyclerView.this.a(1, this.f19641a);
                } else {
                    FeedListAdapterForRecyclerView.this.a(4, this.f19641a);
                }
            } else {
                EventTrackFeed.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, this.f19641a.chat_room.room_id + "", this.f19641a.chat_room.uid, FeedListAdapterForRecyclerView.this.d);
                if (FeedListAdapterForRecyclerView.this.d == 0) {
                    CommunityServiceManager.b().c(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.chat_room.room_id + "", "plaza_follow_yy_icon");
                } else if (FeedListAdapterForRecyclerView.this.d == 6) {
                    CommunityServiceManager.b().c(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.chat_room.room_id + "", "plaza_recommend_yy_icon");
                } else if (FeedListAdapterForRecyclerView.this.d == 19) {
                    CommunityServiceManager.b().c(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.chat_room.room_id + "", "city_time_yy_icon");
                } else {
                    CommunityServiceManager.b().c(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.chat_room.room_id + "", "");
                }
            }
        }

        protected abstract String b();

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
            if (l() != false) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected boolean c() {
            /*
                r2 = this;
                r0 = r2
                com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView r0 = com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.this
                boolean r0 = r0.k()
                r3 = r0
                r0 = 0
                r4 = r0
                r0 = r3
                if (r0 == 0) goto L17
                r0 = r2
                boolean r0 = r0.i()
                if (r0 == 0) goto L17
                r0 = 0
                return r0
            L17:
                r0 = r4
                r3 = r0
                r0 = r2
                com.blued.community.model.BluedIngSelfFeed r0 = r0.f19641a
                int r0 = r0.reading_scope
                if (r0 != 0) goto L38
                r0 = r2
                com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView r0 = com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.this
                boolean r0 = r0.k()
                if (r0 == 0) goto L36
                r0 = r4
                r3 = r0
                r0 = r2
                boolean r0 = r0.l()
                if (r0 == 0) goto L38
            L36:
                r0 = 1
                r3 = r0
            L38:
                r0 = r3
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.c():boolean");
        }

        protected boolean d() {
            return (!FeedListAdapterForRecyclerView.this.k() || i() || l()) ? false : true;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0116  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01ca  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01d3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void e() {
            /*
                Method dump skipped, instructions count: 477
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.e():void");
        }

        protected void f() {
            View view;
            if (this.f19641a.is_top_feed == 1 && (view = this.f) != null) {
                view.setVisibility(0);
                return;
            }
            View view2 = this.f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }

        protected abstract boolean g();

        protected void h() {
            FeedMethods.a(this.f19641a, FeedListAdapterForRecyclerView.this.d, this.d, FeedListAdapterForRecyclerView.this.j, FeedListAdapterForRecyclerView.this.k, "", FeedListAdapterForRecyclerView.this.o, this.f19641a.getYYLiving());
        }

        protected boolean i() {
            return FeedListAdapterForRecyclerView.this.d(this.f19641a.feed_uid);
        }

        protected boolean j() {
            return "1".equalsIgnoreCase(this.f19641a.relationship) || "3".equalsIgnoreCase(this.f19641a.relationship);
        }

        protected boolean k() {
            return this.f19641a.isRepost();
        }

        protected boolean l() {
            return this.f19641a.is_feed_anonym == 1;
        }

        protected FeedParse m() {
            if (this.f19641a.feedParse == null) {
                this.f19641a.feedParse = new FeedParse(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a, FeedListAdapterForRecyclerView.this.d, FeedListAdapterForRecyclerView.this.D);
            }
            return this.f19641a.feedParse;
        }

        protected void n() {
            a(this.f19641a, false);
        }

        protected void o() {
            EventTrackFeed.b(FeedProtos.Event.CITY_SAY_HI_CLICK, this.f19641a, FeedListAdapterForRecyclerView.this.d);
            if (this.f19641a.feed_uid == null || UserInfoHelper.a(this.f19641a.relationship)) {
                return;
            }
            LogData a2 = FeedMethods.a(this.f19641a, FeedListAdapterForRecyclerView.this.d);
            a2.from = FeedMethods.a(FeedListAdapterForRecyclerView.this.d, this.f19641a.is_vote);
            a2.userFrom = FeedMethods.a(FeedListAdapterForRecyclerView.this.d, this.f19641a.is_vote);
            Logger.e("logDataChat", "from=" + a2.from);
            a2.is_call = "1";
            CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a, false, 0, a2, FeedMethods.b(FeedListAdapterForRecyclerView.this.d, 0));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            int id = view.getId();
            if (FeedListAdapterForRecyclerView.this.b != null && (FeedListAdapterForRecyclerView.this.b instanceof RecommendFeedFragment)) {
                ((RecommendFeedFragment) FeedListAdapterForRecyclerView.this.b).a(this.d);
            }
            if (id == R.id.feed) {
                n();
            } else if (id == R.id.header_view) {
                a(true);
            } else if (id == R.id.name_view) {
                a(false);
            } else if (id == R.id.menu_view) {
                Context context = FeedListAdapterForRecyclerView.this.f19617a;
                FollowStatusView followStatusView = this.R;
                BluedIngSelfFeed bluedIngSelfFeed = this.f19641a;
                int i = FeedListAdapterForRecyclerView.this.d;
                FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = FeedListAdapterForRecyclerView.this;
                FeedMethods.a(context, followStatusView, bluedIngSelfFeed, i, feedListAdapterForRecyclerView, this.d, "", feedListAdapterForRecyclerView.f19618c);
            } else if (id == R.id.visible_menu_view) {
                Context context2 = FeedListAdapterForRecyclerView.this.f19617a;
                FollowStatusView followStatusView2 = this.R;
                BluedIngSelfFeed bluedIngSelfFeed2 = this.f19641a;
                int i2 = FeedListAdapterForRecyclerView.this.d;
                FeedListAdapterForRecyclerView feedListAdapterForRecyclerView2 = FeedListAdapterForRecyclerView.this;
                FeedMethods.a(context2, followStatusView2, bluedIngSelfFeed2, i2, feedListAdapterForRecyclerView2, this.d, "", feedListAdapterForRecyclerView2.f19618c);
            } else if (id == R.id.img_promotion_bubble || id == R.id.ll_read_num) {
                R();
            } else if (id == R.id.ll_ad_option) {
                b(view);
            } else if (id == R.id.follow_status_view) {
                FeedMethods.a(FeedListAdapterForRecyclerView.this.f19617a, this.R, this.f19641a, FeedListAdapterForRecyclerView.this.d, FeedListAdapterForRecyclerView.this.f19618c);
            } else if (id == R.id.location_layout) {
                P();
            } else if (id == R.id.event_layout) {
                O();
            } else if (id == R.id.ll_zan_view) {
                FeedListAdapterForRecyclerView.this.a(this.f19641a, g(), this.d);
            } else if (id == R.id.ll_details_comments) {
                M();
            } else if (id == R.id.ll_details_share) {
                p();
            } else if (id == R.id.ll_hello) {
                o();
            } else if (id == R.id.reply_view_one || id == R.id.reply_view_two || id == R.id.feed_comment) {
                L();
            } else if (id == R.id.reply_view_more) {
                K();
            } else if (id == R.id.feed_dynamic_skin && I()) {
                EventTrackFeed.a(FeedProtos.Event.FEED_DYNAMIC_SKIN_CLICK, this.f19641a.feed_id, this.f19641a.feed_uid, EventTrackFeed.f(FeedListAdapterForRecyclerView.this.d), 0);
                CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, 0, "dynamic_skin");
            }
        }

        protected void p() {
            String a2;
            if (g()) {
                EventTrackFeed.d(FeedProtos.Event.PLAZA_RECOMMEND_NOTE_SHARE_CLICK, this.f19641a.circle_id, this.f19641a.feed_id);
            } else {
                CommunityServiceManager.d().c(FeedMethods.b(FeedListAdapterForRecyclerView.this.d), this.f19641a, FeedListAdapterForRecyclerView.this.j, FeedListAdapterForRecyclerView.this.k);
            }
            if (UserInfoHelper.a(this.f19641a.relationship)) {
                return;
            }
            if (this.f19641a.feed_pics.length <= 0) {
                a2 = AvatarUtils.a(0, this.f19641a.user_avatar);
            } else if (this.f19641a.feed_pics.length != 1 || this.f19641a.is_ads == 1) {
                String str = this.b;
                a2 = str;
                if (str == null) {
                    a2 = "";
                }
            } else {
                int a3 = StringUtils.a(this.f19641a.feed_pics_width[0], 0);
                int a4 = StringUtils.a(this.f19641a.feed_pics_height[0], 0);
                int i = (int) (AppInfo.l * 0.77d);
                int i2 = (int) (i * 0.73d);
                a2 = AvatarUtils.a(this.f19641a.feed_pics[0], ImageUtils.a(a3, a4, i, i, i2, i2)[0]);
            }
            ImageFileLoader.a((IRequestHost) null).b(a2).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder.7
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public void onUIFinish(File file, Exception exc) {
                    Bitmap decodeFile = (file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath());
                    int i3 = FeedListAdapterForRecyclerView.this.d;
                    String str2 = i3 != 0 ? i3 != 6 ? "" : "discovery_square" : "discovery_attention";
                    if (FeedListAdapterForRecyclerView.this.d == 6 && FeedMethods.a(BaseFeedViewHolder.this.f19641a)) {
                        BaseFeedViewHolder.this.f19641a.is_top = BaseFeedViewHolder.this.f19641a.is_top_new;
                    }
                    CommunityShareUtils.b().a(FeedListAdapterForRecyclerView.this.f19617a, BaseFeedViewHolder.this.G, decodeFile, BaseFeedViewHolder.this.f19641a, str2, false, FeedMethods.b(FeedListAdapterForRecyclerView.this.d), FeedListAdapterForRecyclerView.this.j, FeedListAdapterForRecyclerView.this.k, FeedListAdapterForRecyclerView.this.d);
                }
            }).a();
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$BubblePostGuideViewHolder.class */
    public class BubblePostGuideViewHolder {
        private View b;

        /* renamed from: c  reason: collision with root package name */
        private BaseViewHolder f19655c;
        private RecyclerView d;
        private LinearLayoutManager e;
        private View f;
        private CommonMultiItemAdapter<FeedPostSignStateItem> g;
        private FeedPostSignStateItem h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView$BubblePostGuideViewHolder$1  reason: invalid class name */
        /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$BubblePostGuideViewHolder$1.class */
        public class AnonymousClass1 extends CommonMultiItemAdapter<FeedPostSignStateItem> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FeedListAdapterForRecyclerView f19656a;

            AnonymousClass1(FeedListAdapterForRecyclerView feedListAdapterForRecyclerView) {
                this.f19656a = feedListAdapterForRecyclerView;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(FeedPostSignStateItem feedPostSignStateItem, View view) {
                BubblePostGuideViewHolder.this.a(feedPostSignStateItem);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.community.view.CommonMultiItemAdapter
            /* renamed from: a */
            public void onConvert(CommonViewHolder commonViewHolder, final FeedPostSignStateItem feedPostSignStateItem, int i) {
                boolean z = BubblePostGuideViewHolder.this.h != null && feedPostSignStateItem.getBubble_state_id().contentEquals(BubblePostGuideViewHolder.this.h.getBubble_state_id());
                int i2 = z ? R.drawable.item_feed_bubble_iv_selected : CommunityManager.f19086a.a().s() ? R.drawable.item_feed_post_sign_state_iv_bg_black : R.drawable.item_feed_post_sign_state_iv_bg;
                int a2 = BluedSkinUtils.a(this.mContext, R.color.syc_k);
                if (z) {
                    a2 = BluedSkinUtils.a(this.mContext, R.color.syc_h);
                }
                commonViewHolder.setImageUrl(R.id.state_iv, feedPostSignStateItem.getIcon(), 25.0f).setText(R.id.state_tv, feedPostSignStateItem.getName()).setBackgroundRes(R.id.state_iv_layout, i2).setTextColor(R.id.state_tv, a2).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$BubblePostGuideViewHolder$1$RUtMGq4GmCfgz3OTg96Dd5Dpufk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedListAdapterForRecyclerView.BubblePostGuideViewHolder.AnonymousClass1.this.a(feedPostSignStateItem, view);
                    }
                });
            }

            @Override // com.blued.community.view.CommonMultiItemAdapter
            public void onAddItemType() {
                addItemType(0, R.layout.item_feed_bubble_post_guide);
            }
        }

        public BubblePostGuideViewHolder(BaseViewHolder baseViewHolder, View view) {
            this.b = view;
            this.f19655c = baseViewHolder;
            View view2 = baseViewHolder.getView(R.id.guide_content_layout_id);
            this.f = view2;
            view2.setVisibility(8);
            this.d = (RecyclerView) this.f19655c.getView(R.id.recycle_view);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FeedListAdapterForRecyclerView.this.f19617a, 0, false);
            this.e = linearLayoutManager;
            this.d.setLayoutManager(linearLayoutManager);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(FeedListAdapterForRecyclerView.this);
            this.g = anonymousClass1;
            this.d.setAdapter(anonymousClass1);
            this.f19655c.getView(R.id.send_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$BubblePostGuideViewHolder$tn-FH7y1aZYjMg0rpma_0kHG3RQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    FeedListAdapterForRecyclerView.BubblePostGuideViewHolder.this.a(view3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (intValue > FeedMethods.c(15)) {
                this.f.setVisibility(0);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
            marginLayoutParams.height = intValue;
            this.f.setLayoutParams(marginLayoutParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("selected_model", this.h);
            bundle.putInt("page_from", 3);
            FeedPostSignBaseFragment.a(FeedListAdapterForRecyclerView.this.f19617a, bundle);
            FeedProtos.Event event = FeedProtos.Event.FEED_PUNCH_LOOK_GUIDE_POP_YES_CLICK;
            FeedPostSignStateItem feedPostSignStateItem = this.h;
            EventTrackFeed.j(event, feedPostSignStateItem != null ? feedPostSignStateItem.getBubble_state_id() : "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(FeedPostSignStateItem feedPostSignStateItem) {
            this.h = feedPostSignStateItem;
            this.g.notifyDataSetChanged();
        }

        public void a(final BluedIngSelfFeed bluedIngSelfFeed, int i) {
            if (bluedIngSelfFeed == null || bluedIngSelfFeed.bubbleInsertGuideExtra == null) {
                return;
            }
            this.f19655c.setText(R.id.tv_title, bluedIngSelfFeed.bubbleInsertGuideExtra.getTitle()).setText(R.id.send_btn, bluedIngSelfFeed.bubbleInsertGuideExtra.getButton());
            if (this.h == null && !TypeUtils.a((List<?>) bluedIngSelfFeed.bubbleInsertGuideExtra.getState_data())) {
                if (bluedIngSelfFeed.bubbleInsertGuideExtra.getState_data().size() > 1) {
                    this.h = bluedIngSelfFeed.bubbleInsertGuideExtra.getState_data().get(1);
                } else {
                    this.h = bluedIngSelfFeed.bubbleInsertGuideExtra.getState_data().get(0);
                }
            }
            this.g.setDataAndNotify(bluedIngSelfFeed.bubbleInsertGuideExtra.getState_data());
            if (bluedIngSelfFeed.playAnimType == 5) {
                this.f.setVisibility(0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
                marginLayoutParams.height = FeedMethods.c(219);
                this.f.setLayoutParams(marginLayoutParams);
            } else {
                this.f.setVisibility(8);
                ValueAnimator ofInt = ValueAnimator.ofInt(0, FeedMethods.c(219));
                ofInt.setInterpolator(new AccelerateInterpolator());
                ofInt.setDuration(400L).start();
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$BubblePostGuideViewHolder$QGYIVFCkxSFzZ7C0ya0CSk_zj3w
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FeedListAdapterForRecyclerView.BubblePostGuideViewHolder.this.a(valueAnimator);
                    }
                });
                ofInt.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BubblePostGuideViewHolder.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        LogUtils.c("onAnimationEnd");
                        bluedIngSelfFeed.playAnimType = 0;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
            if (bluedIngSelfFeed.isShowUrlVisited) {
                return;
            }
            EventTrackFeed.c(FeedProtos.Event.FEED_PUNCH_LOOK_GUIDE_POP_SHOW);
            bluedIngSelfFeed.isShowUrlVisited = true;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$ChatRoomFeedViewHolder.class */
    public class ChatRoomFeedViewHolder implements View.OnClickListener {
        private BluedIngSelfFeed b;

        /* renamed from: c  reason: collision with root package name */
        private int f19659c;
        private LinearLayout d;
        private ImageView e;
        private TextView f;
        private ImageView g;
        private ImageView h;
        private TextView i;
        private TextView j;
        private TextView k;
        private FrameLayout l;
        private ImageView m;
        private ImageView n;
        private TextView o;
        private ShapeTextView p;

        public ChatRoomFeedViewHolder(View view) {
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            this.d = (LinearLayout) view.findViewById(R.id.root_view);
            this.e = (ImageView) view.findViewById(R.id.iv_header);
            this.f = (TextView) view.findViewById(R.id.tv_name);
            this.g = (ImageView) view.findViewById(R.id.img_name_verify);
            this.h = (ImageView) view.findViewById(R.id.img_blued_medal);
            this.i = (TextView) view.findViewById(R.id.tv_desc);
            this.j = (TextView) view.findViewById(R.id.tv_content);
            this.k = (TextView) view.findViewById(R.id.tv_room_owner);
            this.l = (FrameLayout) view.findViewById(R.id.fl_cover);
            this.m = (ImageView) view.findViewById(R.id.img_room_cover);
            this.n = (ImageView) view.findViewById(R.id.img_item_background);
            this.o = (TextView) view.findViewById(R.id.tv_count);
            this.p = (ShapeTextView) view.findViewById(R.id.tv_to_live);
        }

        private void a() {
            this.d.setOnClickListener(new SingleClickProxy(this));
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, AvatarUtils.a(0, this.b.user_avatar)).b(R.drawable.user_bg_round).c().a(this.e);
            this.f.setText(this.b.user_name);
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = this.b.vip_grade;
            userBasicModel.is_vip_annual = this.b.is_vip_annual;
            userBasicModel.is_hide_vip_look = this.b.is_hide_vip_look;
            userBasicModel.vip_exp_lvl = this.b.vip_exp_lvl;
            userBasicModel.uid = this.b.feed_id;
            UserInfoHelper.a(FeedListAdapterForRecyclerView.this.f19617a, this.f, userBasicModel);
            UserInfoHelper.a(this.h, userBasicModel, FeedListAdapterForRecyclerView.this.f19618c);
            UserInfoHelper.b(this.g, this.b.vbadge, 2, 8);
            this.e.setOnClickListener(new SingleClickProxy(this));
            this.f.setOnClickListener(new SingleClickProxy(this));
            if (TextUtils.isEmpty(this.b.distance)) {
                this.i.setText(R.string.feed_chatting);
            } else {
                this.i.setText(DistanceUtils.a(this.b.distance, BlueAppLocal.c(), false));
                DistanceUtils.a(FeedListAdapterForRecyclerView.this.f19617a, this.i, this.b.is_hide_distance, 0);
                TextView textView = this.i;
                textView.setText(this.i.getText().toString() + " " + FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.feed_living));
            }
            if (TextUtils.isEmpty(this.b.room_name)) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.j.setText(this.b.room_name);
            }
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, this.b.room_pic).a(this.m);
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, this.b.room_pic).d().a(this.n);
            this.n.setOnClickListener(new SingleClickProxy(this));
            TextView textView2 = this.o;
            textView2.setText(this.b.realtime_count + FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.feed_living_count));
            this.p.setOnClickListener(new SingleClickProxy(this));
            this.k.setText(this.b.user_name);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.b = bluedIngSelfFeed;
            this.f19659c = i;
            a();
            if (bluedIngSelfFeed == null || bluedIngSelfFeed.isShowUrlVisited) {
                return;
            }
            FeedProtos.FeedProto.Builder targetUid = EventTrackFeed.a(FeedProtos.Event.CITY_YY_USER_SHOW, bluedIngSelfFeed, FeedListAdapterForRecyclerView.this.d, i, FeedListAdapterForRecyclerView.this.o).setTargetUid(EventTrackFeed.a(bluedIngSelfFeed.uid));
            EventTrackFeed.a(targetUid.setLiveId(bluedIngSelfFeed.room_id + ""));
            bluedIngSelfFeed.isShowUrlVisited = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            int id = view.getId();
            if (id != R.id.iv_header && id != R.id.tv_name) {
                if ((id == R.id.root_view || id == R.id.iv_cover || id == R.id.tv_to_live || id == R.id.img_item_background) && this.b != null) {
                    EventTrackFeed.a(EventTrackFeed.a(FeedProtos.Event.CITY_YY_USER_CLICK, this.b, FeedListAdapterForRecyclerView.this.d, this.f19659c).setTargetUid(EventTrackFeed.a(this.b.uid)).setLiveId(this.b.room_id));
                    CommunityServiceManager.b().c(FeedListAdapterForRecyclerView.this.f19617a, this.b.room_id, "city_all_yy_insert");
                    return;
                }
                return;
            }
            String a2 = FeedMethods.a(FeedListAdapterForRecyclerView.this.d, this.b.is_vote);
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.uid = this.b.uid;
            userBasicModel.avatar = this.b.user_avatar;
            userBasicModel.name = this.b.user_name;
            userBasicModel.age = this.b.age + "";
            userBasicModel.height = this.b.height + "";
            userBasicModel.weight = this.b.weight + "";
            userBasicModel.role = this.b.role + "";
            userBasicModel.distance = this.b.distance;
            userBasicModel.vip_grade = this.b.vip_grade;
            userBasicModel.vbadge = this.b.vbadge;
            userBasicModel.is_hide_distance = this.b.is_hide_distance;
            userBasicModel.is_hide_last_operate = this.b.is_hide_last_operate;
            userBasicModel.is_show_vip_page = this.b.is_show_vip_page;
            userBasicModel.is_vip_annual = this.b.is_vip_annual;
            userBasicModel.vip_exp_lvl = this.b.vip_exp_lvl;
            MessageProtos.StrangerSource b = FeedMethods.b(FeedListAdapterForRecyclerView.this.d, this.b.in_promotion);
            LogData logData = new LogData();
            boolean z = true;
            if (this.b.in_promotion != 1) {
                z = false;
            }
            logData.is_feed_super_exposure = z;
            logData.feed_id = this.b.feed_id;
            logData.target_uid = this.b.feed_uid;
            logData.is_hot_feed = this.b.is_hot_feed;
            logData.listMode = "";
            logData.strong_insert_data = this.b.strong_insert_data;
            CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, userBasicModel, a2, false, (View) this.e, logData, b);
            CommunityHttpUtils.a(this.b.click_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$DeleteFeedViewHolder.class */
    public class DeleteFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
        private View A;
        private TextViewFixTouchForDynamic B;
        private ShapeLinearLayout C;
        private TextViewFixTouchForDynamic D;
        private RelativeLayout E;

        public DeleteFeedViewHolder(View view) {
            super(view);
            this.A = a(R.id.feed_comment);
            this.E = (RelativeLayout) a(R.id.repost_layout);
            this.B = (TextViewFixTouchForDynamic) a(R.id.repost_content_view);
            this.C = (ShapeLinearLayout) a(R.id.ll_content_all);
            this.D = (TextViewFixTouchForDynamic) a(R.id.content_view);
        }

        private void b(BluedIngSelfFeed bluedIngSelfFeed) {
            this.A.setVisibility(8);
            this.E.setVisibility(0);
            if (!bluedIngSelfFeed.isDeleted()) {
                v();
                return;
            }
            ShapeHelper.b(this.C, R.color.syc_x);
            int a2 = DensityUtils.a(FeedListAdapterForRecyclerView.this.f19617a, 10.0f);
            this.C.setPadding(a2, a2, a2, a2);
            if (TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
                this.B.setVisibility(8);
            } else {
                this.B.setVisibility(0);
                a(this.E, this.B, m().getFeedContent(), (String) null);
            }
            CharSequence a3 = StringUtils.a(StringUtils.a(w().feed_limit_desc, (int) this.D.getTextSize(), 0), true, new boolean[0]);
            this.D.setMaxLines(5);
            this.D.setExpandText(a3);
            this.D.setMovementMethod(LinkMovementClickMethod.a());
            this.D.setVisibility(0);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            b(bluedIngSelfFeed);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$EventCardViewHolder.class */
    public class EventCardViewHolder extends ShareEventViewHolder {
        private LinearLayout U;
        private ShapeTextView V;
        private int W;
        private ImageView X;
        private TextView Y;
        private TextView Z;
        private View aa;
        private View ab;

        public EventCardViewHolder(View view) {
            super(view);
            this.V = (ShapeTextView) a(R.id.tv_hello);
            this.X = (ImageView) a(R.id.imgEventGuideIcon);
            this.Y = (TextView) a(R.id.tvEventGuide);
            this.aa = a(R.id.areaEventGuide);
            this.ab = a(R.id.areaEventJoiners);
            this.U = (LinearLayout) a(R.id.container_stack_users);
            this.Z = (TextView) a(R.id.tv_event_numbers);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            FeedListAdapterForRecyclerView.this.a(w().activity_id, (String) null, FeedProtos.SourcePage.ACTIVITY_FEED, this.f19641a);
            EventTrackFeed.a(FeedProtos.Event.CITY_ACTIVITY_CARD_CLICK, w().activity_id, this.W, w().strong_insert_data, "", this.f19641a, FeedListAdapterForRecyclerView.this.d, FeedListAdapterForRecyclerView.this.o);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.ShareEventViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.W = i;
            super.a(bluedIngSelfFeed, i);
            this.e.setVisibility(8);
            if (bluedIngSelfFeed.isSelfFeed()) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
            }
            this.h.setVisibility(8);
            FeedMethods.a(FeedListAdapterForRecyclerView.this.f19617a, bluedIngSelfFeed, this.X, this.U, this.Y, this.Z, "", FeedListAdapterForRecyclerView.this.f19618c);
            if (this.Y.getVisibility() == 0) {
                this.aa.setVisibility(0);
            } else {
                this.aa.setVisibility(8);
            }
            if (this.Z.getVisibility() == 0) {
                this.ab.setVisibility(0);
            } else {
                this.ab.setVisibility(8);
            }
            if (StringUtils.d(bluedIngSelfFeed.activity_guide_tag)) {
                this.E.setVisibility(8);
            } else {
                this.E.setVisibility(0);
                this.E.setText(bluedIngSelfFeed.activity_guide_tag);
                ShapeHelper.a((ShapeHelper.ShapeView) this.E, R.color.syc_k);
                ShapeHelper.d(this.E, R.color.syc_k);
            }
            this.G.setVisibility(0);
            this.D.setVisibility(0);
            this.D.setText(bluedIngSelfFeed.activity_city + " · " + bluedIngSelfFeed.activity_location);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
            FeedListAdapterForRecyclerView.this.a(w().activity_id, (String) null, FeedProtos.SourcePage.ACTIVITY_FEED, bluedIngSelfFeed);
            EventTrackFeed.a(FeedProtos.Event.CITY_ACTIVITY_CARD_CLICK, w().activity_id, this.W, bluedIngSelfFeed.strong_insert_data, "", bluedIngSelfFeed, FeedListAdapterForRecyclerView.this.d, FeedListAdapterForRecyclerView.this.o);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void h() {
            FeedListAdapterForRecyclerView.this.e(this.f19641a, this.W);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.ShareEventViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder
        public void q() {
            super.q();
            this.E.setVisibility(8);
            this.k.setVisibility(4);
            this.r.setVisibility(8);
            this.o.setVisibility(4);
            this.t.setVisibility(0);
            this.V.setText(FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.view_detail));
            this.t.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.EventCardViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CommunityHttpUtils.a(EventCardViewHolder.this.f19641a.click_url);
                    FeedListAdapterForRecyclerView.this.a(EventCardViewHolder.this.w().activity_id, (String) null, FeedProtos.SourcePage.ACTIVITY_FEED, EventCardViewHolder.this.f19641a);
                    EventTrackFeed.a(FeedProtos.Event.CITY_ACTIVITY_GO_DETAIL_CLICK, EventCardViewHolder.this.w().activity_id, EventCardViewHolder.this.W, EventCardViewHolder.this.f19641a.strong_insert_data, "", EventCardViewHolder.this.f19641a, FeedListAdapterForRecyclerView.this.d, FeedListAdapterForRecyclerView.this.o);
                }
            });
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.ShareEventViewHolder
        protected long r() {
            return w().activity_date;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.ShareEventViewHolder
        protected int s() {
            return w().activity_mode_id;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.ShareEventViewHolder
        protected String t() {
            String str = w().activity_city + " · " + w().activity_location;
            if (w().activity_mode_id == 2) {
                str = w().activity_online_text;
            }
            return str;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.ShareEventViewHolder
        protected void u() {
            this.M.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$EventCardViewHolder$9xey157L41rr9pQGIBCvP1aZ6TI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.EventCardViewHolder.this.a(view);
                }
            });
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$FeedHandler.class */
    public class FeedHandler extends Handler {
        public FeedHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                FeedListAdapterForRecyclerView.this.r();
            } else if (i != 2) {
            } else {
                FeedListAdapterForRecyclerView.this.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$FeedOrCircleViewHolder.class */
    public abstract class FeedOrCircleViewHolder extends RepostAndTextFeedViewHolder implements View.OnClickListener {
        private View A;
        private View B;
        private ImageView C;
        private TextView D;
        private ImageView E;
        private TextView F;
        private ImageView G;
        private CircleJoinView H;
        private View x;

        private FeedOrCircleViewHolder(View view) {
            super(view);
            this.x = a(R.id.feed_visible);
            this.A = a(R.id.feed_user_info);
            this.B = a(R.id.feed_circle_info);
            this.C = (ImageView) a(R.id.circle_header_view);
            this.D = (TextView) a(R.id.circle_name_view);
            this.E = (ImageView) a(R.id.circle_anonymous);
            this.F = (TextView) a(R.id.circle_recommend);
            this.G = (ImageView) a(R.id.circle_menu_view);
            CircleJoinView circleJoinView = (CircleJoinView) a(R.id.cjv_join);
            this.H = circleJoinView;
            circleJoinView.setStyle(0);
            this.H.setOnClickListener(new SingleClickProxy(this));
        }

        private void b(BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
            CircleListToDetailParams circleListToDetailParams = new CircleListToDetailParams();
            circleListToDetailParams.setSource(EventTrackFeed.j(FeedListAdapterForRecyclerView.this.d));
            circleListToDetailParams.setShowCircleEntry(true);
            circleListToDetailParams.setMode("");
            CirclePostDetailsFragment.a(FeedListAdapterForRecyclerView.this.f19617a, bluedIngSelfFeed, circleListToDetailParams);
        }

        private void q() {
            this.A.setVisibility(0);
            this.B.setVisibility(8);
        }

        private void r() {
            this.x.setVisibility(8);
            this.A.setVisibility(4);
            this.B.setVisibility(0);
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, this.f19641a.cover).b(R.drawable.circle_header_default).a(5.0f).a(this.C);
            TextView textView = this.D;
            textView.setText(this.f19641a.circle_title + "圈子");
            this.E.setVisibility(this.f19641a.is_anonym == 1 ? 0 : 8);
            if (FeedListAdapterForRecyclerView.this.i() || FeedListAdapterForRecyclerView.this.j()) {
                if (this.f19641a.isNotMember()) {
                    this.F.setVisibility(0);
                    TextView textView2 = this.F;
                    textView2.setText(this.f19641a.members_num + FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.members_count));
                } else {
                    this.F.setVisibility(0);
                    this.F.setText(R.string.circle_joined_recommend);
                }
            }
            if (i()) {
                this.G.setVisibility(8);
            } else {
                this.G.setVisibility(0);
            }
            this.C.setOnClickListener(new SingleClickProxy(this));
            this.D.setOnClickListener(new SingleClickProxy(this));
            this.G.setOnClickListener(new SingleClickProxy(this));
            s();
        }

        private void s() {
            if (!this.f19641a.isNotMember() || (!FeedListAdapterForRecyclerView.this.i() && !FeedListAdapterForRecyclerView.this.j())) {
                this.H.setVisibility(8);
                return;
            }
            this.H.setVisibility(0);
            this.H.setJoinStatus(this.f19641a.getJoinState());
        }

        private void t() {
            CircleDetailsFragment.a(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.circle_id, FeedListAdapterForRecyclerView.this.d);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            if (g()) {
                r();
            } else {
                q();
            }
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
            if (g()) {
                b(bluedIngSelfFeed, z);
            } else {
                super.a(bluedIngSelfFeed, z);
            }
            if (FeedListAdapterForRecyclerView.this.b == null || !(FeedListAdapterForRecyclerView.this.b instanceof RecommendFeedFragment)) {
                return;
            }
            ((RecommendFeedFragment) FeedListAdapterForRecyclerView.this.b).v();
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected boolean c() {
            if (g()) {
                return true;
            }
            return super.c();
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected boolean d() {
            if (g()) {
                return false;
            }
            return super.d();
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected boolean g() {
            return CircleMethods.a(this.f19641a);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void h() {
            if (g()) {
                FeedListAdapterForRecyclerView.this.b(this.f19641a, this.d);
            } else {
                super.h();
            }
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            super.onClick(view);
            int id = view.getId();
            if (id == R.id.circle_header_view || id == R.id.circle_name_view) {
                t();
            } else if (id == R.id.circle_menu_view) {
                FeedMethods.a(FeedListAdapterForRecyclerView.this.f19617a, this.H, this.F, this.f19641a, FeedListAdapterForRecyclerView.this.d, FeedListAdapterForRecyclerView.this, this.d, "", FeedListAdapterForRecyclerView.this.f19618c);
            } else if (id == R.id.cjv_join) {
                FeedMethods.a(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a, FeedListAdapterForRecyclerView.this.d, this.H, this.F, "", FeedListAdapterForRecyclerView.this.f19618c);
            }
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void p() {
            if (!g() || this.f19641a.feed_status != 200) {
                super.p();
            } else if (UserInfoHelper.a(this.f19641a.relationship)) {
            } else {
                CommunityShareUtils.b().a(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a, FeedListAdapterForRecyclerView.this.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$ImageOneFeedViewHolder.class */
    public class ImageOneFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
        private TextViewFixTouchForDynamic A;
        private CardView B;
        private ImageView C;
        private ShapeTextView D;
        private String E;
        private String F;

        public ImageOneFeedViewHolder(View view) {
            super(view);
            this.A = (TextViewFixTouchForDynamic) a(R.id.content_view);
            this.B = (CardView) a(R.id.cv_image_one);
            this.C = (ImageView) a(R.id.image_one);
            this.D = (ShapeTextView) a(R.id.stv_long_pic_icon);
        }

        private void q() {
            BluedIngSelfFeed w = w();
            if (w.feed_pics == null || w.feed_pics.length <= 0) {
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                ((ViewGroup.MarginLayoutParams) this.A.getLayoutParams()).bottomMargin = DensityUtils.a(FeedListAdapterForRecyclerView.this.f19617a, 2.0f);
                return;
            }
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            ((ViewGroup.MarginLayoutParams) this.A.getLayoutParams()).bottomMargin = DensityUtils.a(FeedListAdapterForRecyclerView.this.f19617a, 10.0f);
            try {
                if (w.feed_pics_width.length == 0 || w.feed_pics_height.length == 0) {
                    w.feed_pics_width = new String[]{"480"};
                    w.feed_pics_height = new String[]{"480"};
                }
                int a2 = StringUtils.a(w.feed_pics_width[0], 0);
                int a3 = StringUtils.a(w.feed_pics_height[0], 0);
                int[] b = FeedMethods.b(FeedListAdapterForRecyclerView.this.f19617a, a2, a3, this.f19641a.isRepost());
                ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
                layoutParams.width = b[0];
                boolean z = true;
                layoutParams.height = b[1];
                this.C.setLayoutParams(layoutParams);
                this.E = w.feed_pics[0];
                String str = w.feed_pics[0];
                int i = layoutParams.width;
                if (a2 != a3) {
                    z = false;
                }
                this.F = AvatarUtils.a(str, i, z);
                if (a3 > a2 * 3) {
                    this.D.setVisibility(0);
                    this.F = w.feed_pics[0] + w.getImageMogr(false);
                } else {
                    this.D.setVisibility(8);
                }
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, this.F).a(FeedListAdapterForRecyclerView.this.B).a(this.C);
                this.C.setOnClickListener(new SingleClickProxy(this));
                this.b = w.feed_pics[0];
                if (Build.VERSION.SDK_INT >= 21) {
                    this.C.setTransitionName(w.feed_pics[0]);
                }
            } catch (Exception e) {
            }
        }

        private void r() {
            if (g()) {
                EventTrackFeed.a(FeedProtos.Event.NOTE_IMAGE_CLICK, this.f19641a.circle_id, this.f19641a.feed_id, EventTrackFeed.j(FeedListAdapterForRecyclerView.this.d), "");
            }
            if (UserInfoHelper.a(w().relationship)) {
                return;
            }
            if (w().isCirclePost()) {
                CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, new String[]{this.E}, 0, FeedListAdapterForRecyclerView.this.g, (LoadOptions) null, w().user_name, this.C, this.E);
            } else {
                CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, w(), 0, FeedListAdapterForRecyclerView.this.g, (LoadOptions) null, w().user_name, FeedListAdapterForRecyclerView.this.d);
            }
            NearbyFeedFragment.q = SystemClock.elapsedRealtime();
            if (FeedListAdapterForRecyclerView.this.b != null && (FeedListAdapterForRecyclerView.this.b instanceof RecommendFeedFragment)) {
                ((RecommendFeedFragment) FeedListAdapterForRecyclerView.this.b).c(this.d);
            }
            FeedListAdapterForRecyclerView.this.a(2, this.f19641a);
            LogData logData = new LogData();
            logData.id = w().feed_id;
            logData.from = FeedListAdapterForRecyclerView.this.e + "";
            logData.logService = "feed_pic_click";
            logData.type = w().recommend_text;
            if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.this.j)) {
                logData.topic_id = FeedListAdapterForRecyclerView.this.j;
            }
            if (FeedListAdapterForRecyclerView.this.k != -1) {
                logData.topic_category = FeedListAdapterForRecyclerView.this.k + "";
            }
            CommunityServiceManager.d().a(logData);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            q();
            this.C.setOnClickListener(new SingleClickProxy(this));
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            super.onClick(view);
            if (view.getId() == R.id.image_one) {
                r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$ImageOtherFeedViewHolder.class */
    public class ImageOtherFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
        private PhotoGridView A;

        public ImageOtherFeedViewHolder(View view) {
            super(view);
            this.A = (PhotoGridView) a(R.id.image_other);
        }

        private void q() {
            this.A.setAdapter((ListAdapter) new PhotoAdapter(w()));
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            q();
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$ImageTwoFourFeedViewHolder.class */
    public class ImageTwoFourFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
        private PhotoGridView A;

        public ImageTwoFourFeedViewHolder(View view) {
            super(view);
            this.A = (PhotoGridView) a(R.id.image_two_four);
        }

        private void q() {
            this.A.setAdapter((ListAdapter) new PhotoAdapter(w()));
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            q();
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            super.onClick(view);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$LiveFeedViewHolder.class */
    public class LiveFeedViewHolder implements View.OnClickListener {
        private BluedIngSelfFeed b;

        /* renamed from: c  reason: collision with root package name */
        private int f19663c;
        private LinearLayout d;
        private ImageView e;
        private TextView f;
        private ImageView g;
        private ImageView h;
        private TextView i;
        private TextView j;
        private FrameLayout k;
        private ImageView l;
        private ImageView m;
        private TextView n;
        private ShapeTextView o;

        public LiveFeedViewHolder(View view) {
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            this.d = (LinearLayout) view.findViewById(R.id.root_view);
            this.e = (ImageView) view.findViewById(R.id.iv_header);
            this.f = (TextView) view.findViewById(R.id.tv_name);
            this.g = (ImageView) view.findViewById(R.id.img_name_verify);
            this.h = (ImageView) view.findViewById(R.id.img_blued_medal);
            this.i = (TextView) view.findViewById(R.id.tv_desc);
            this.j = (TextView) view.findViewById(R.id.tv_content);
            this.k = (FrameLayout) view.findViewById(R.id.fl_cover);
            this.l = (ImageView) view.findViewById(R.id.iv_cover);
            this.m = (ImageView) view.findViewById(R.id.iv_live);
            this.n = (TextView) view.findViewById(R.id.tv_count);
            this.o = (ShapeTextView) view.findViewById(R.id.tv_to_live);
        }

        private void a() {
            this.d.setOnClickListener(new SingleClickProxy(this));
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, AvatarUtils.a(0, this.b.user_avatar)).b(R.drawable.user_bg_round).c().a(this.e);
            this.f.setText(this.b.user_name);
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = this.b.vip_grade;
            userBasicModel.is_vip_annual = this.b.is_vip_annual;
            userBasicModel.is_hide_vip_look = this.b.is_hide_vip_look;
            userBasicModel.vip_exp_lvl = this.b.vip_exp_lvl;
            userBasicModel.uid = this.b.feed_id;
            UserInfoHelper.a(FeedListAdapterForRecyclerView.this.f19617a, this.f, userBasicModel);
            UserInfoHelper.a(this.h, userBasicModel, FeedListAdapterForRecyclerView.this.f19618c);
            UserInfoHelper.b(this.g, this.b.vbadge, 2, 8);
            this.e.setOnClickListener(new SingleClickProxy(this));
            this.f.setOnClickListener(new SingleClickProxy(this));
            if (TextUtils.isEmpty(this.b.distance)) {
                this.i.setText(R.string.feed_living);
            } else {
                this.i.setText(DistanceUtils.a(this.b.distance, BlueAppLocal.c(), false));
                DistanceUtils.a(FeedListAdapterForRecyclerView.this.f19617a, this.i, this.b.is_hide_distance, 0);
                TextView textView = this.i;
                textView.setText(this.i.getText().toString() + " " + FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.feed_living));
            }
            if (TextUtils.isEmpty(this.b.feed_content)) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.j.setText(this.b.feed_content);
            }
            if (this.b.feed_pics == null || this.b.feed_pics.length <= 0) {
                this.k.setVisibility(8);
                this.l.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                this.l.setVisibility(0);
                this.l.setOnClickListener(new SingleClickProxy(this));
                try {
                    if (this.b.feed_pics_width.length == 0 || this.b.feed_pics_height.length == 0) {
                        this.b.feed_pics_width = new String[]{"480"};
                        this.b.feed_pics_height = new String[]{"480"};
                    }
                    int[] a2 = FeedMethods.a(FeedListAdapterForRecyclerView.this.f19617a, StringUtils.a(this.b.feed_pics_width[0], 0), StringUtils.a(this.b.feed_pics_height[0], 0), false);
                    ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
                    layoutParams.width = a2[0];
                    layoutParams.height = a2[1];
                    ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, AvatarUtils.a(this.b.feed_pics[0], layoutParams.width)).a(FeedListAdapterForRecyclerView.this.B).a(this.l);
                    this.l.setOnClickListener(new SingleClickProxy(this));
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.l.setTransitionName(this.b.feed_pics[0]);
                    }
                } catch (Exception e) {
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                }
            }
            this.m.setImageResource(CommunityServiceManager.e().f(this.b.link_type));
            TextView textView2 = this.n;
            textView2.setText(this.b.realtime_count + FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.feed_living_count));
            this.o.setOnClickListener(new SingleClickProxy(this));
            FeedListAdapterForRecyclerView.this.f(this.b, this.f19663c);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.b = bluedIngSelfFeed;
            this.f19663c = i;
            a();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            int id = view.getId();
            if (id != R.id.iv_header && id != R.id.tv_name) {
                if (id == R.id.root_view || id == R.id.iv_cover || id == R.id.tv_to_live) {
                    FeedListAdapterForRecyclerView.this.g(this.b, this.f19663c);
                    return;
                }
                return;
            }
            String a2 = FeedMethods.a(FeedListAdapterForRecyclerView.this.d, this.b.is_vote);
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.uid = this.b.uid;
            userBasicModel.avatar = this.b.user_avatar;
            userBasicModel.name = this.b.user_name;
            userBasicModel.age = this.b.age + "";
            userBasicModel.height = this.b.height + "";
            userBasicModel.weight = this.b.weight + "";
            userBasicModel.role = this.b.role + "";
            userBasicModel.distance = this.b.distance;
            userBasicModel.vip_grade = this.b.vip_grade;
            userBasicModel.vbadge = this.b.vbadge;
            userBasicModel.is_hide_distance = this.b.is_hide_distance;
            userBasicModel.is_hide_last_operate = this.b.is_hide_last_operate;
            userBasicModel.is_show_vip_page = this.b.is_show_vip_page;
            userBasicModel.is_vip_annual = this.b.is_vip_annual;
            userBasicModel.vip_exp_lvl = this.b.vip_exp_lvl;
            MessageProtos.StrangerSource b = FeedMethods.b(FeedListAdapterForRecyclerView.this.d, this.b.in_promotion);
            LogData logData = new LogData();
            boolean z = true;
            if (this.b.in_promotion != 1) {
                z = false;
            }
            logData.is_feed_super_exposure = z;
            logData.feed_id = this.b.feed_id;
            logData.target_uid = this.b.feed_uid;
            logData.is_hot_feed = this.b.is_hot_feed;
            logData.listMode = "";
            logData.strong_insert_data = this.b.strong_insert_data;
            CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, userBasicModel, a2, false, (View) this.e, logData, b);
            NearbyFeedFragment.r = SystemClock.elapsedRealtime();
            CommunityHttpUtils.a(this.b.click_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$NoneFeedViewHolder.class */
    public class NoneFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
        private View A;
        private TextViewFixTouchForDynamic B;
        private ShapeLinearLayout C;
        private TextViewFixTouchForDynamic D;
        private RelativeLayout E;

        public NoneFeedViewHolder(View view) {
            super(view);
            this.A = a(R.id.feed_comment);
            this.B = (TextViewFixTouchForDynamic) a(R.id.repost_content_view);
            this.E = (RelativeLayout) a(R.id.repost_layout);
            this.C = (ShapeLinearLayout) a(R.id.ll_content_all);
            this.D = (TextViewFixTouchForDynamic) a(R.id.content_view);
        }

        private void b(BluedIngSelfFeed bluedIngSelfFeed) {
            this.j.setVisibility(8);
            this.A.setVisibility(8);
            this.B.setVisibility(8);
            this.E.setVisibility(0);
            ShapeHelper.b(this.C, R.color.syc_x);
            int a2 = DensityUtils.a(FeedListAdapterForRecyclerView.this.f19617a, 10.0f);
            this.C.setPadding(a2, a2, a2, a2);
            CharSequence a3 = StringUtils.a(StringUtils.a(bluedIngSelfFeed.see_limit_desc, (int) this.D.getTextSize(), 0), true, new boolean[0]);
            this.D.setMaxLines(5);
            this.D.setExpandText(a3);
            this.D.setMovementMethod(LinkMovementClickMethod.a());
            this.D.setVisibility(0);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            b(bluedIngSelfFeed);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z, String str, String str2) {
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$PhotoAdapter.class */
    public class PhotoAdapter extends BaseAdapter {
        private BluedIngSelfFeed b;

        /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$PhotoAdapter$ViewHolder.class */
        class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            ImageView f19667a;
            ShapeTextView b;

            private ViewHolder() {
            }
        }

        public PhotoAdapter(BluedIngSelfFeed bluedIngSelfFeed) {
            this.b = bluedIngSelfFeed;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            BluedIngSelfFeed bluedIngSelfFeed = this.b;
            if (bluedIngSelfFeed == null || bluedIngSelfFeed.feed_pics == null) {
                return 0;
            }
            return this.b.feed_pics.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            int i2;
            int i3;
            float f;
            if (view == null) {
                view = LayoutInflater.from(FeedListAdapterForRecyclerView.this.f19617a).inflate(R.layout.fragment_feed_grid_item, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.f19667a = (ImageView) view.findViewById(R.id.photo_view);
                viewHolder.b = (ShapeTextView) view.findViewById(R.id.stv_long_pic_icon);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final String str = this.b.feed_pics[i];
            String str2 = this.b.feed_pics[i];
            if (this.b.feed_pics_width == null || this.b.feed_pics_width.length <= i || this.b.feed_pics_height == null || this.b.feed_pics_height.length <= i) {
                i2 = 0;
                i3 = 0;
            } else {
                i2 = SafeUtils.a(this.b.feed_pics_width[i]);
                i3 = SafeUtils.a(this.b.feed_pics_height[i]);
            }
            if (i3 > i2 * 3) {
                viewHolder.b.setVisibility(0);
                str2 = str2 + this.b.getImageMogr(true, i);
            } else {
                viewHolder.b.setVisibility(8);
            }
            float f2 = -1.0f;
            if (this.b.face_point != null && this.b.face_point.length > i) {
                String[] split = this.b.face_point[i].split(",");
                if (split.length == 2) {
                    f2 = Float.valueOf(split[0]).floatValue();
                    f = Float.valueOf(split[1]).floatValue();
                    ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, str2).b(R.color.default_place_color).a(6.0f).a(f2, f).a(viewHolder.f19667a);
                    final ViewHolder viewHolder2 = viewHolder;
                    viewHolder.f19667a.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.PhotoAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            int i4;
                            Tracker.onClick(view2);
                            if (CircleMethods.a(PhotoAdapter.this.b)) {
                                EventTrackFeed.a(FeedProtos.Event.NOTE_IMAGE_CLICK, PhotoAdapter.this.b.circle_id, PhotoAdapter.this.b.feed_id, EventTrackFeed.j(FeedListAdapterForRecyclerView.this.d), "");
                            } else {
                                EventTrackFeed.b(FeedProtos.Event.FEED_MULTI_IMAGE_CLICK, PhotoAdapter.this.b.feed_id);
                            }
                            if (UserInfoHelper.a(PhotoAdapter.this.b.relationship)) {
                                return;
                            }
                            LogData logData = new LogData();
                            logData.id = PhotoAdapter.this.b.feed_id;
                            logData.from = FeedListAdapterForRecyclerView.this.e + "";
                            logData.logService = "feed_pic_click";
                            if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.this.j)) {
                                logData.topic_id = FeedListAdapterForRecyclerView.this.j;
                            }
                            if (FeedListAdapterForRecyclerView.this.k != -1) {
                                logData.topic_category = FeedListAdapterForRecyclerView.this.k + "";
                            }
                            logData.type = PhotoAdapter.this.b.recommend_text;
                            CommunityServiceManager.d().a(logData);
                            if (PhotoAdapter.this.b.isCirclePost()) {
                                CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, PhotoAdapter.this.b.feed_pics, i, FeedListAdapterForRecyclerView.this.g, (LoadOptions) null, PhotoAdapter.this.b.user_name, viewHolder2.f19667a, str);
                            } else {
                                CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, PhotoAdapter.this.b, i, FeedListAdapterForRecyclerView.this.g, (LoadOptions) null, PhotoAdapter.this.b.user_name, FeedListAdapterForRecyclerView.this.d);
                            }
                            NearbyFeedFragment.q = SystemClock.elapsedRealtime();
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                i4 = -1;
                                if (i6 >= FeedListAdapterForRecyclerView.this.getData().size()) {
                                    break;
                                } else if (TextUtils.equals(((BluedIngSelfFeed) FeedListAdapterForRecyclerView.this.getData().get(i6)).feed_id, PhotoAdapter.this.b.feed_id)) {
                                    i4 = i6;
                                    break;
                                } else {
                                    i5 = i6 + 1;
                                }
                            }
                            if (FeedListAdapterForRecyclerView.this.b != null && (FeedListAdapterForRecyclerView.this.b instanceof RecommendFeedFragment)) {
                                ((RecommendFeedFragment) FeedListAdapterForRecyclerView.this.b).c(i4);
                            }
                            FeedListAdapterForRecyclerView.this.a(2, PhotoAdapter.this.b);
                        }
                    }));
                    viewHolder.f19667a.setTransitionName(str);
                    return view;
                }
            }
            f = -1.0f;
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, str2).b(R.color.default_place_color).a(6.0f).a(f2, f).a(viewHolder.f19667a);
            final ViewHolder viewHolder22 = viewHolder;
            viewHolder.f19667a.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.PhotoAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    int i4;
                    Tracker.onClick(view2);
                    if (CircleMethods.a(PhotoAdapter.this.b)) {
                        EventTrackFeed.a(FeedProtos.Event.NOTE_IMAGE_CLICK, PhotoAdapter.this.b.circle_id, PhotoAdapter.this.b.feed_id, EventTrackFeed.j(FeedListAdapterForRecyclerView.this.d), "");
                    } else {
                        EventTrackFeed.b(FeedProtos.Event.FEED_MULTI_IMAGE_CLICK, PhotoAdapter.this.b.feed_id);
                    }
                    if (UserInfoHelper.a(PhotoAdapter.this.b.relationship)) {
                        return;
                    }
                    LogData logData = new LogData();
                    logData.id = PhotoAdapter.this.b.feed_id;
                    logData.from = FeedListAdapterForRecyclerView.this.e + "";
                    logData.logService = "feed_pic_click";
                    if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.this.j)) {
                        logData.topic_id = FeedListAdapterForRecyclerView.this.j;
                    }
                    if (FeedListAdapterForRecyclerView.this.k != -1) {
                        logData.topic_category = FeedListAdapterForRecyclerView.this.k + "";
                    }
                    logData.type = PhotoAdapter.this.b.recommend_text;
                    CommunityServiceManager.d().a(logData);
                    if (PhotoAdapter.this.b.isCirclePost()) {
                        CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, PhotoAdapter.this.b.feed_pics, i, FeedListAdapterForRecyclerView.this.g, (LoadOptions) null, PhotoAdapter.this.b.user_name, viewHolder22.f19667a, str);
                    } else {
                        CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, PhotoAdapter.this.b, i, FeedListAdapterForRecyclerView.this.g, (LoadOptions) null, PhotoAdapter.this.b.user_name, FeedListAdapterForRecyclerView.this.d);
                    }
                    NearbyFeedFragment.q = SystemClock.elapsedRealtime();
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        i4 = -1;
                        if (i6 >= FeedListAdapterForRecyclerView.this.getData().size()) {
                            break;
                        } else if (TextUtils.equals(((BluedIngSelfFeed) FeedListAdapterForRecyclerView.this.getData().get(i6)).feed_id, PhotoAdapter.this.b.feed_id)) {
                            i4 = i6;
                            break;
                        } else {
                            i5 = i6 + 1;
                        }
                    }
                    if (FeedListAdapterForRecyclerView.this.b != null && (FeedListAdapterForRecyclerView.this.b instanceof RecommendFeedFragment)) {
                        ((RecommendFeedFragment) FeedListAdapterForRecyclerView.this.b).c(i4);
                    }
                    FeedListAdapterForRecyclerView.this.a(2, PhotoAdapter.this.b);
                }
            }));
            viewHolder.f19667a.setTransitionName(str);
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$RecommendChatRoomViewHolder.class */
    public class RecommendChatRoomViewHolder {
        private BluedIngSelfFeed b;

        /* renamed from: c  reason: collision with root package name */
        private int f19670c;
        private TextView d;
        private ImageView e;
        private RecyclerView f;

        public RecommendChatRoomViewHolder(View view) {
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            this.d = (TextView) view.findViewById(R.id.tv_more);
            this.e = (ImageView) view.findViewById(R.id.iv_more);
            this.f = (RecyclerView) view.findViewById(R.id.recycler_view);
            this.f.setLayoutManager(new LinearLayoutManager(FeedListAdapterForRecyclerView.this.f19617a));
        }

        private void a() {
            SingleClickProxy singleClickProxy = new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RecommendChatRoomViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CommunityServiceManager.b().c(FeedListAdapterForRecyclerView.this.f19617a, "plaza_recommend_yy_more");
                }
            });
            this.d.setOnClickListener(singleClickProxy);
            this.e.setOnClickListener(singleClickProxy);
        }

        private void b() {
            if (this.f.getAdapter() != null || FeedListAdapterForRecyclerView.this.z == null) {
                return;
            }
            this.f.setAdapter(FeedListAdapterForRecyclerView.this.z);
            FeedListAdapterForRecyclerView.this.z.notifyDataSetChanged();
            FeedListAdapterForRecyclerView.this.z.setEnableLoadMore(false);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.b = bluedIngSelfFeed;
            this.f19670c = i;
            a();
            if (FeedListAdapterForRecyclerView.this.z != null) {
                FeedListAdapterForRecyclerView.this.z.a(i);
                FeedListAdapterForRecyclerView.this.z.a(FeedListAdapterForRecyclerView.this.o);
            }
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$RecommendCircleViewHolder.class */
    public class RecommendCircleViewHolder {
        private BluedIngSelfFeed b;

        /* renamed from: c  reason: collision with root package name */
        private int f19673c;
        private TextView d;
        private ImageView e;
        private RecyclerView f;

        public RecommendCircleViewHolder(View view) {
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            this.d = (TextView) view.findViewById(R.id.tv_more);
            this.e = (ImageView) view.findViewById(R.id.iv_more);
            this.f = (RecyclerView) view.findViewById(R.id.recycler_view);
            this.f.setLayoutManager(new LinearLayoutManager(FeedListAdapterForRecyclerView.this.f19617a) { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RecommendCircleViewHolder.1
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean canScrollVertically() {
                    return false;
                }
            });
        }

        private void a() {
            SingleClickProxy singleClickProxy = new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RecommendCircleViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackFeed.a(FeedProtos.Event.CIRCLE_FIND_PAGE_SHOW, FeedProtos.CircleSource.PLAZA_RECOMMEND_CIRCLE);
                    CircleTypeListFragment.f19307a.a(FeedListAdapterForRecyclerView.this.f19617a, FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND_MORE);
                }
            });
            this.d.setOnClickListener(singleClickProxy);
            this.e.setOnClickListener(singleClickProxy);
        }

        private void b() {
            if (this.f.getAdapter() != null || FeedListAdapterForRecyclerView.this.A == null) {
                return;
            }
            this.f.setAdapter(FeedListAdapterForRecyclerView.this.A);
            FeedListAdapterForRecyclerView.this.A.notifyDataSetChanged();
            FeedListAdapterForRecyclerView.this.A.setEnableLoadMore(false);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.b = bluedIngSelfFeed;
            this.f19673c = i;
            a();
            b();
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$RecommendRefreshGuideViewHolder.class */
    public class RecommendRefreshGuideViewHolder {
        private View b;

        /* renamed from: c  reason: collision with root package name */
        private BaseViewHolder f19677c;
        private View d;
        private SVGAImageView e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView$RecommendRefreshGuideViewHolder$1  reason: invalid class name */
        /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$RecommendRefreshGuideViewHolder$1.class */
        public class AnonymousClass1 implements SVGACallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f19678a;

            AnonymousClass1(int i) {
                this.f19678a = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(int i) {
                if (FeedListAdapterForRecyclerView.this.f19618c == null || !FeedListAdapterForRecyclerView.this.f19618c.isActive() || FeedListAdapterForRecyclerView.this.getData().size() <= i) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = FeedListAdapterForRecyclerView.this.getData().iterator();
                int i2 = 0;
                while (it.hasNext() && i2 < 3) {
                    BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) it.next();
                    if (bluedIngSelfFeed.feed_type == 31) {
                        it.remove();
                        LogUtils.c("推荐下滑 移除推荐提示条与骨架屏占位item");
                    } else if (!bluedIngSelfFeed.isShowUrlVisited) {
                        it.remove();
                        arrayList.add(bluedIngSelfFeed);
                        i2++;
                        LogUtils.c("推荐下滑 添加动态到临时列表");
                    }
                }
                if (arrayList.size() > 0) {
                    FeedListAdapterForRecyclerView.this.getData().addAll(i, arrayList);
                    FeedListAdapterForRecyclerView.this.notifyDataSetChanged();
                    LogUtils.c("推荐下滑 " + arrayList.size() + "个动态移动到位置：" + i);
                }
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onFinished() {
                if (FeedListAdapterForRecyclerView.this.f19618c == null || !FeedListAdapterForRecyclerView.this.f19618c.isActive()) {
                    LogUtils.c("推荐下滑 页面已关闭");
                    return;
                }
                LogUtils.c("推荐下滑 推荐提示条与骨架屏占位动画finish， position:" + this.f19678a);
                Handler n = AppInfo.n();
                final int i = this.f19678a;
                n.postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$RecommendRefreshGuideViewHolder$1$NlHthMNJjmC2XNEhRg4CtosMIJI
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedListAdapterForRecyclerView.RecommendRefreshGuideViewHolder.AnonymousClass1.this.a(i);
                    }
                }, 1000L);
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
        }

        public RecommendRefreshGuideViewHolder(BaseViewHolder baseViewHolder, View view) {
            this.b = view;
            this.f19677c = baseViewHolder;
            this.d = baseViewHolder.getView(R.id.recommend_refresh_guide_content);
            this.e = (SVGAImageView) this.f19677c.getView(R.id.recommend_refresh_guide_arrow_iv);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            marginLayoutParams.topMargin = intValue;
            this.d.setLayoutParams(marginLayoutParams);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            if (bluedIngSelfFeed == null) {
                return;
            }
            new SVGAPlayer.Builder().a(CommunityManager.f19086a.a().s() ? "recommend_refresh_guide_arrow_dark.svga" : "recommend_refresh_guide_arrow.svga").a((Integer) 1).a(this.e);
            this.e.setCallback(new AnonymousClass1(i));
            if (bluedIngSelfFeed.playAnimType == 7) {
                LogUtils.c("推荐下滑 执行推荐提示条与骨架屏占位动画， position:" + i);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams.topMargin = FeedMethods.c(-56);
                this.d.setLayoutParams(marginLayoutParams);
                ValueAnimator ofInt = ValueAnimator.ofInt(FeedMethods.c(-56), 0);
                ofInt.setInterpolator(new AccelerateInterpolator());
                ofInt.setDuration(200L).start();
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$RecommendRefreshGuideViewHolder$ryOJLP--b19JoyrySc6OuJfNFOI
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FeedListAdapterForRecyclerView.RecommendRefreshGuideViewHolder.this.a(valueAnimator);
                    }
                });
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams2.topMargin = 0;
                this.d.setLayoutParams(marginLayoutParams2);
            }
            if (bluedIngSelfFeed.isShowUrlVisited) {
                return;
            }
            EventTrackFeed.a(FeedProtos.Event.FEED_RECOMMEND_GLIDE_GUIDE_SHOW);
            bluedIngSelfFeed.isShowUrlVisited = true;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$RecommendSubjectViewHolder.class */
    public class RecommendSubjectViewHolder {
        private View b;

        /* renamed from: c  reason: collision with root package name */
        private BaseViewHolder f19680c;
        private int d;
        private ImageView e;
        private RecyclerView f;
        private RecyclerView.LayoutManager g;
        private CommonRecycleAdapter<String> h;
        private BluedIngSelfFeed i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView$RecommendSubjectViewHolder$1  reason: invalid class name */
        /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$RecommendSubjectViewHolder$1.class */
        public class AnonymousClass1 extends CommonRecycleAdapter<String> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FeedListAdapterForRecyclerView f19681a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Context context, FeedListAdapterForRecyclerView feedListAdapterForRecyclerView) {
                super(context);
                this.f19681a = feedListAdapterForRecyclerView;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(View view) {
                if (RecommendSubjectViewHolder.this.i == null || RecommendSubjectViewHolder.this.i.super_insert_floor == null) {
                    return;
                }
                CommRouteUtil.a(this.mContext, RecommendSubjectViewHolder.this.i.super_insert_floor.super_did, (String) null, RecommendSubjectViewHolder.this.i.super_insert_floor.tt_ids);
                EventTrackFeed.a(EventTrackFeed.a(FeedProtos.Event.FIND_PLAZA_RECOMMEND_TOPIC_CLICK, RecommendSubjectViewHolder.this.i, FeedListAdapterForRecyclerView.this.d, false, FeedListAdapterForRecyclerView.this.o).setTopicId(EventTrackFeed.a(RecommendSubjectViewHolder.this.i.super_insert_floor.super_did)));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
            /* renamed from: a */
            public void onBindViewHolderData(String str, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
                ImageView imageView = (ImageView) commonAdapterHolder.a(R.id.item_recommend_subject_pic);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.width = RecommendSubjectViewHolder.this.d;
                marginLayoutParams.height = RecommendSubjectViewHolder.this.d;
                imageView.setLayoutParams(marginLayoutParams);
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, str).d(R.drawable.defaultpicture).a(4.0f).a(imageView);
                commonAdapterHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$RecommendSubjectViewHolder$1$zJpMP_57esDV_IX7R1CLIcSniIk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedListAdapterForRecyclerView.RecommendSubjectViewHolder.AnonymousClass1.this.a(view);
                    }
                });
            }

            @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
            public int getLayoutId(int i) {
                return R.layout.item_recommend_subject_layout;
            }
        }

        public RecommendSubjectViewHolder(BaseViewHolder baseViewHolder, View view) {
            this.b = view;
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                this.b.setLayoutParams(marginLayoutParams);
            }
            this.f19680c = baseViewHolder;
            this.d = ((AppInfo.l - ((FeedListAdapterForRecyclerView.this.J > 0 ? FeedListAdapterForRecyclerView.this.J : FeedMethods.c(12)) * 2)) - FeedMethods.c(8)) / 3;
            this.e = (ImageView) this.f19680c.getView(R.id.iv_avatar);
            if (CommunityManager.f19086a.a().s()) {
                this.f19680c.setImageResource(R.id.iv_icon, R.drawable.feed_post_subject_icon);
            } else {
                this.f19680c.setImageResource(R.id.iv_icon, R.drawable.feed_post_subject_icon_dark);
            }
            this.f = (RecyclerView) this.f19680c.getView(R.id.rv_subject);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
            this.g = linearLayoutManager;
            this.f.setLayoutManager(linearLayoutManager);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(view.getContext(), FeedListAdapterForRecyclerView.this);
            this.h = anonymousClass1;
            this.f.setAdapter(anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BluedIngSelfFeed bluedIngSelfFeed, View view) {
            CommRouteUtil.a(FeedListAdapterForRecyclerView.this.f19617a, bluedIngSelfFeed.super_insert_floor.super_did, (String) null, bluedIngSelfFeed.super_insert_floor.tt_ids);
        }

        public void a(final BluedIngSelfFeed bluedIngSelfFeed, int i) {
            if (bluedIngSelfFeed == null || bluedIngSelfFeed.super_insert_floor == null) {
                return;
            }
            this.i = bluedIngSelfFeed;
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, bluedIngSelfFeed.super_insert_floor.avatar).a(9.0f).a(this.e);
            this.f19680c.setText(R.id.tv_name, bluedIngSelfFeed.super_insert_floor.name);
            this.f19680c.setText(R.id.tv_desc, CommonStringUtils.b(bluedIngSelfFeed.super_insert_floor.visited_total) + FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.recommend_subject_visit_count));
            if (bluedIngSelfFeed.super_insert_floor.tt_image != null) {
                if (bluedIngSelfFeed.super_insert_floor.tt_image.size() > 3) {
                    this.h.setDataAndNotify(bluedIngSelfFeed.super_insert_floor.tt_image.subList(0, 3));
                } else {
                    this.h.setDataAndNotify(bluedIngSelfFeed.super_insert_floor.tt_image);
                }
            }
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$RecommendSubjectViewHolder$P1lBf3icQJzfN1ii6U5We__qv2g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.RecommendSubjectViewHolder.this.a(bluedIngSelfFeed, view);
                }
            });
            if (bluedIngSelfFeed.isShowUrlVisited) {
                return;
            }
            EventTrackFeed.a(EventTrackFeed.a(FeedProtos.Event.FIND_PLAZA_RECOMMEND_TOPIC_DRAW, bluedIngSelfFeed, FeedListAdapterForRecyclerView.this.d, false, FeedListAdapterForRecyclerView.this.o).setTopicId(EventTrackFeed.a(bluedIngSelfFeed.super_insert_floor.super_did)));
            bluedIngSelfFeed.isShowUrlVisited = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$RecommendTopicViewHolder.class */
    public class RecommendTopicViewHolder {
        private BluedIngSelfFeed b;

        /* renamed from: c  reason: collision with root package name */
        private int f19683c;
        private TextView d;
        private ImageView e;
        private RecyclerView f;

        public RecommendTopicViewHolder(View view) {
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            this.d = (TextView) view.findViewById(R.id.tv_more);
            this.e = (ImageView) view.findViewById(R.id.iv_more);
            this.f = (RecyclerView) view.findViewById(R.id.recycler_view);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FeedListAdapterForRecyclerView.this.f19617a);
            linearLayoutManager.setOrientation(0);
            this.f.setLayoutManager(linearLayoutManager);
        }

        private void a() {
            SingleClickProxy singleClickProxy = new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RecommendTopicViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackFeed.a(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK);
                    SuperTopicFragment.a(FeedListAdapterForRecyclerView.this.f19617a);
                }
            });
            this.d.setOnClickListener(singleClickProxy);
            this.e.setOnClickListener(singleClickProxy);
        }

        private void b() {
            if (this.f.getAdapter() != null || FeedListAdapterForRecyclerView.this.y == null) {
                return;
            }
            this.f.setAdapter(FeedListAdapterForRecyclerView.this.y);
            FeedListAdapterForRecyclerView.this.y.notifyDataSetChanged();
            FeedListAdapterForRecyclerView.this.y.setEnableLoadMore(false);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.b = bluedIngSelfFeed;
            this.f19683c = i;
            a();
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$RecommendUserFeedViewHolder.class */
    public class RecommendUserFeedViewHolder {
        private BluedIngSelfFeed b;

        /* renamed from: c  reason: collision with root package name */
        private int f19686c;
        private RecyclerView d;

        public RecommendUserFeedViewHolder(View view) {
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            this.d = (RecyclerView) view.findViewById(R.id.recycler_view);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FeedListAdapterForRecyclerView.this.f19617a);
            linearLayoutManager.setOrientation(0);
            this.d.setLayoutManager(linearLayoutManager);
        }

        private void a() {
            if (this.d.getAdapter() == null) {
                this.d.setAdapter(FeedListAdapterForRecyclerView.this.x);
                FeedListAdapterForRecyclerView.this.x.notifyDataSetChanged();
                FeedListAdapterForRecyclerView.this.x.setLoadMoreView(new RecommendLoadMoreView());
                FeedListAdapterForRecyclerView.this.x.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RecommendUserFeedViewHolder.1
                    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
                    public void onLoadMoreRequested() {
                        if (FeedListAdapterForRecyclerView.this.w == 1) {
                            RecommendUserFeedViewHolder recommendUserFeedViewHolder = RecommendUserFeedViewHolder.this;
                            recommendUserFeedViewHolder.a(recommendUserFeedViewHolder.b);
                        }
                    }
                }, this.d);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(final BluedIngSelfFeed bluedIngSelfFeed) {
            FeedHttpUtils.a(FeedListAdapterForRecyclerView.this.t, FeedListAdapterForRecyclerView.this.u, FeedListAdapterForRecyclerView.this.v, FeedListAdapterForRecyclerView.this.n, FeedListAdapterForRecyclerView.this.f19618c, new BluedUIHttpResponse<BluedEntity<FeedRecommendUser, LiveRecommendExtra>>() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RecommendUserFeedViewHolder.2
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    FeedListAdapterForRecyclerView.this.x.loadMoreComplete();
                    if (FeedListAdapterForRecyclerView.this.w != 1) {
                        FeedListAdapterForRecyclerView.this.x.loadMoreEnd(true);
                        FeedListAdapterForRecyclerView.this.x.setEnableLoadMore(false);
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<FeedRecommendUser, LiveRecommendExtra> bluedEntity) {
                    if (bluedEntity == null || bluedEntity.extra == null) {
                        return;
                    }
                    FeedListAdapterForRecyclerView.this.x.addData((Collection) bluedEntity.data);
                    FeedListAdapterForRecyclerView.this.x.notifyDataSetChanged();
                    FeedListAdapterForRecyclerView.this.w = bluedEntity.extra.hasmore;
                    FeedListAdapterForRecyclerView.this.t = bluedEntity.extra.last_lid;
                    FeedListAdapterForRecyclerView.this.u = bluedEntity.extra.ai_last_uid;
                    FeedListAdapterForRecyclerView.this.v = bluedEntity.extra.recommend_char;
                    if (FeedListAdapterForRecyclerView.this.x.getItemCount() <= 3) {
                        FeedListAdapterForRecyclerView.this.mData.remove(bluedIngSelfFeed);
                        FeedListAdapterForRecyclerView.this.notifyDataSetChanged();
                    }
                }
            });
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.b = bluedIngSelfFeed;
            this.f19686c = i;
            if (FeedListAdapterForRecyclerView.this.x != null) {
                FeedListAdapterForRecyclerView.this.x.a(i);
                FeedListAdapterForRecyclerView.this.x.a(FeedListAdapterForRecyclerView.this.o);
            }
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$RepostAndTextFeedViewHolder.class */
    public abstract class RepostAndTextFeedViewHolder extends BaseFeedViewHolder implements View.OnClickListener {
        private ShapeLinearLayout A;
        private TextViewFixTouchForDynamic B;
        private RelativeLayout C;
        private LinearLayout x;
        private TextViewFixTouchForDynamic y;

        private RepostAndTextFeedViewHolder(View view) {
            super(view);
            this.x = (LinearLayout) a(R.id.feed_info);
            this.y = (TextViewFixTouchForDynamic) a(R.id.repost_content_view);
            this.C = (RelativeLayout) a(R.id.repost_layout);
            this.A = (ShapeLinearLayout) a(R.id.ll_content_all);
            this.B = (TextViewFixTouchForDynamic) a(R.id.content_view);
            if (FeedListAdapterForRecyclerView.this.d == 5 || FeedListAdapterForRecyclerView.this.d == 29 || FeedListAdapterForRecyclerView.this.d == 30) {
                this.B.setMoeTextColor(FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.syc_h));
                this.y.setMoeTextColor(FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.syc_h));
            }
            this.C.setOnClickListener(new SingleClickProxy(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(TextViewFixTouchForDynamic textViewFixTouchForDynamic, CharSequence charSequence, String str, File file, Exception exc) {
            if (file == null || !file.exists()) {
                textViewFixTouchForDynamic.setExpandText(charSequence);
                return;
            }
            Bitmap a2 = com.blued.android.framework.utils.ImageUtils.a(file, FeedMethods.c(36), FeedMethods.c(16));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("%subject_widget% " + ((Object) charSequence));
            if (a2 == null || !TextUtils.equals(str, (String) textViewFixTouchForDynamic.getTag(FeedConstants.f19821a))) {
                textViewFixTouchForDynamic.setExpandText(charSequence);
                return;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(a2);
            bitmapDrawable.setBounds(0, 0, FeedMethods.c(36), FeedMethods.c(16));
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), 0, 16, 33);
            textViewFixTouchForDynamic.setExpandText(spannableStringBuilder);
        }

        private void q() {
            this.y.setOnClickListener(new SingleClickProxy(this));
            this.A.setOnClickListener(new SingleClickProxy(this));
        }

        private void r() {
            if (k()) {
                this.C.setVisibility(0);
                ShapeHelper.b(this.A, R.color.syc_x);
                int a2 = DensityUtils.a(FeedListAdapterForRecyclerView.this.f19617a, 10.0f);
                this.A.setPadding(a2, a2, a2, a2);
                return;
            }
            ShapeHelper.b(this.A, R.color.transparent);
            this.C.setVisibility(8);
            ShapeHelper.b(this.A, R.color.transparent);
            this.A.setPadding(0, 0, 0, 0);
        }

        private void s() {
            if (k() && this.f19641a.isRepostAndDeleted()) {
                this.f19641a.repost.feed_pics = new String[0];
                this.f19641a.repost.is_videos = "0";
                this.f19641a.repost.relationship = this.f19641a.relationship;
                this.f19641a.repost.recommend_type = this.f19641a.recommend_type;
            }
        }

        private void t() {
            if (this.f19641a.isRepostAndDeleted()) {
                return;
            }
            a(w(), false);
        }

        private void u() {
            a(this.f19641a, false);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected View a() {
            return null;
        }

        protected void a(View view, final TextViewFixTouchForDynamic textViewFixTouchForDynamic, final CharSequence charSequence, final String str) {
            if (charSequence == null) {
                return;
            }
            textViewFixTouchForDynamic.setMoeTextColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_h), false);
            textViewFixTouchForDynamic.setMaxLines(5);
            textViewFixTouchForDynamic.setMovementMethod(LinkMovementClickMethod.a());
            if (TextUtils.isEmpty(str)) {
                textViewFixTouchForDynamic.setExpandText(charSequence);
            } else {
                textViewFixTouchForDynamic.setTag(FeedConstants.f19821a, str);
                ImageFileLoader.a(FeedListAdapterForRecyclerView.this.f19618c).a(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$RepostAndTextFeedViewHolder$GI1sd_y-cuSSpiyBvBsI_-ctPYU
                    @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                    public final void onUIFinish(File file, Exception exc) {
                        FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder.a(TextViewFixTouchForDynamic.this, charSequence, str, file, exc);
                    }
                }).a();
            }
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    String charSequence2 = textViewFixTouchForDynamic.getText().toString();
                    if (Build.VERSION.SDK_INT != 18) {
                        try {
                            ((ClipboardManager) FeedListAdapterForRecyclerView.this.f19617a.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(charSequence2)));
                        } catch (Exception e) {
                        }
                    } else {
                        ((android.text.ClipboardManager) FeedListAdapterForRecyclerView.this.f19617a.getSystemService(Context.CLIPBOARD_SERVICE)).setText(RegExpUtils.a(charSequence2));
                    }
                    AppMethods.a((CharSequence) FeedListAdapterForRecyclerView.this.f19617a.getResources().getString(R.string.copy));
                    return true;
                }
            });
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            s();
            r();
            v();
            q();
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected String b() {
            if (w().feed_pics == null || w().feed_pics.length <= 0) {
                return null;
            }
            return w().feed_pics[0];
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            super.onClick(view);
            int id = view.getId();
            if (id == R.id.repost_layout) {
                u();
            } else if (id == R.id.ll_content_all) {
                t();
            }
        }

        protected void v() {
            int i = AppInfo.l;
            CharSequence charSequence = "";
            if (k()) {
                this.y.setMaxWidth(i - DensityUtils.a(FeedListAdapterForRecyclerView.this.f19617a, 20.0f));
                CharSequence feedRepostContent = m().getFeedRepostContent();
                if (TextUtils.isEmpty(this.f19641a.super_tag_image) || !TextUtils.isEmpty(feedRepostContent)) {
                    charSequence = feedRepostContent;
                }
                a(this.C, this.y, charSequence, this.f19641a.super_tag_image);
                this.B.setMaxWidth(i - DensityUtils.a(FeedListAdapterForRecyclerView.this.f19617a, 40.0f));
                this.B.setVisibility(0);
                a(this.A, this.B, m().getFeedContent(), (String) null);
                return;
            }
            this.B.setMaxWidth(i - DensityUtils.a(FeedListAdapterForRecyclerView.this.f19617a, 20.0f));
            if (TextUtils.isEmpty(w().feed_content) && TextUtils.isEmpty(this.f19641a.super_tag_image)) {
                this.B.setVisibility(8);
                return;
            }
            CharSequence feedContent = m().getFeedContent();
            if (TextUtils.isEmpty(this.f19641a.super_tag_image) || !TextUtils.isEmpty(feedContent)) {
                charSequence = feedContent;
            }
            a(this.A, this.B, charSequence, this.f19641a.super_tag_image);
            this.B.setVisibility(0);
        }

        protected BluedIngSelfFeed w() {
            return k() ? this.f19641a.repost : this.f19641a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$ShareCircleFeedViewHolder.class */
    public class ShareCircleFeedViewHolder extends WebFeedViewHolder {
        private ShareCircleFeedViewHolder(View view) {
            super(view);
            this.P.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, b(), CommunityConstants.WebShowType.DEFAULT);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            if (k()) {
                this.M.setCardBackgroundColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_y));
            } else {
                this.M.setCardBackgroundColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_x));
            }
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, bluedIngSelfFeed.getContentData().share_circle_posting_pic).b(R.drawable.defaultpicture).d(R.drawable.circle_default_icon).a(this.N);
            TextView textView = this.Q;
            textView.setText(bluedIngSelfFeed.getContentData().share_circle_title + "圈子");
            this.Q.setVisibility(0);
            if (TextUtils.isEmpty(bluedIngSelfFeed.getContentData().share_circle_posting_content)) {
                this.S.setText(FeedListAdapterForRecyclerView.this.f19617a.getResources().getString(R.string.circle_post_share_default));
            } else {
                this.S.setText(MarkDownLinkHelper.a(FeedListAdapterForRecyclerView.this.f19617a, bluedIngSelfFeed.getContentData().share_circle_posting_content, true, R.color.syc_m));
            }
            this.S.setVisibility(0);
            this.M.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$ShareCircleFeedViewHolder$EkvBZFSh95pUHEV3snixQ9ABM5U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.ShareCircleFeedViewHolder.this.a(view);
                }
            });
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected String b() {
            return "http://native.blued.cn/?action=base_post_detail&post_id=" + this.f19641a.getContentData().share_circle_posting_id;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected boolean g() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$ShareCircleViewHolder.class */
    public class ShareCircleViewHolder extends WebFeedViewHolder {
        public ShareCircleViewHolder(View view) {
            super(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            FeedListAdapterForRecyclerView.this.f(this.f19641a);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            View a2 = a(R.id.view_share_corner);
            if (w().is_share_circle == 1) {
                a2.setVisibility(0);
                ((ImageView) a2.findViewById(R.id.icon)).setImageResource(R.drawable.icon_share_circle_corner);
                ((TextView) a2.findViewById(R.id.tv)).setText(R.string.base);
            } else {
                a2.setVisibility(8);
            }
            this.Q.setVisibility(0);
            this.S.setVisibility(0);
            this.R.setVisibility(0);
            this.Q.setText(w().join_circle_title);
            this.S.setText(w().join_circle_description);
            this.P.setVisibility(8);
            if (!FeedListAdapterForRecyclerView.this.e(bluedIngSelfFeed)) {
                this.R.setVisibility(8);
                return;
            }
            this.R.setVisibility(0);
            TextView textView = this.R;
            textView.setText(w().members_num + FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.members_count));
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder
        public void q() {
            super.q();
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, FeedListAdapterForRecyclerView.this.d(this.f19641a)).b(R.drawable.defaultpicture).a(this.N);
            this.M.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$ShareCircleViewHolder$hAizld_WBjvgKXNWj_TJNOj4Y1I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.ShareCircleViewHolder.this.a(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$ShareEventViewHolder.class */
    public class ShareEventViewHolder extends WebFeedViewHolder {
        protected LinearLayout A;
        protected TextView B;
        protected ImageView C;
        protected TextView D;
        protected ShapeTextView E;
        protected ImageView F;
        protected TextView G;
        protected ImageView H;
        protected TextView I;
        protected LinearLayout y;

        public ShareEventViewHolder(View view) {
            super(view);
            this.y = (LinearLayout) a(R.id.layout_forward_bg);
            this.A = (LinearLayout) a(R.id.forward_event);
            this.B = (TextView) a(R.id.forward_event_time);
            this.C = (ImageView) a(R.id.iv_event_address);
            this.D = (TextView) a(R.id.forward_event_location);
            this.E = (ShapeTextView) a(R.id.stv_event_state);
            this.F = (ImageView) a(R.id.img_event_icon);
            this.G = (TextView) a(R.id.tv_event_card_split);
            this.H = (ImageView) a(R.id.imgEventGuideIcon);
            this.I = (TextView) a(R.id.tvEventGuide);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            FeedListAdapterForRecyclerView.this.a(w().share_activity_id, (String) null, FeedMethods.a(FeedListAdapterForRecyclerView.this.d), this.f19641a);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            this.S.setVisibility(8);
            this.A.setVisibility(0);
            this.F.setVisibility(0);
            View a2 = a(R.id.view_share_corner);
            a2.setVisibility(0);
            ((ImageView) a2.findViewById(R.id.icon)).setImageResource(R.drawable.icon_online_event_address_white);
            ((TextView) a2.findViewById(R.id.tv)).setText(R.string.event_events);
            this.G.setVisibility(8);
            this.D.setVisibility(8);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder
        public void q() {
            super.q();
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, FeedListAdapterForRecyclerView.this.h(this.f19641a)).b(R.drawable.event_avatar_square).d(R.drawable.event_avatar_square).a(this.N);
            this.Q.setText(FeedListAdapterForRecyclerView.this.i(this.f19641a));
            this.B.setText(TimeAndDateUtils.e(TimeAndDateUtils.j(r())));
            this.H.setVisibility(0);
            this.C.setVisibility(0);
            if (s() == 1) {
                this.H.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_eventcard_location));
            } else {
                this.H.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_eventcard_link));
            }
            this.C.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_eventcard_clock));
            this.I.setVisibility(0);
            this.I.setText(t());
            this.E.setVisibility(8);
            if (w().share_activity_status == 3) {
                this.E.setVisibility(0);
                this.E.setText(R.string.event_ended);
                ShapeHelper.a((ShapeHelper.ShapeView) this.E, R.color.syc_k);
                ShapeHelper.d(this.E, R.color.syc_k_50);
            } else if (w().share_activity_apply_status == 1) {
                this.E.setVisibility(0);
                this.E.setText(R.string.event_signuped);
                ShapeHelper.a((ShapeHelper.ShapeView) this.E, R.color.syc_e);
                ShapeHelper.d(this.E, R.color.syc_e_50);
            } else if (w().share_activity_is_all == 1) {
                this.E.setVisibility(0);
                this.E.setText(R.string.event_full_complement);
                ShapeHelper.a((ShapeHelper.ShapeView) this.E, R.color.syc_k);
                ShapeHelper.d(this.E, R.color.syc_k_50);
            }
            u();
        }

        protected long r() {
            return w().share_activity_time;
        }

        protected int s() {
            return w().share_activity_mode_id;
        }

        protected String t() {
            return w().share_activity_address;
        }

        protected void u() {
            this.M.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$ShareEventViewHolder$DxzViCWbtX36eVXUr9lY3Wnn4Lg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.ShareEventViewHolder.this.a(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$ShareTopicFeedViewHolder.class */
    public class ShareTopicFeedViewHolder extends WebFeedViewHolder {
        public ShareTopicFeedViewHolder(View view) {
            super(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, b(), CommunityConstants.WebShowType.DEFAULT);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            View a2 = a(R.id.view_share_corner);
            ImageView imageView = (ImageView) a2.findViewById(R.id.icon);
            if (CommunityServiceManager.a().D() == 1) {
                imageView.setImageResource(R.drawable.feed_post_subject_icon_corner);
            } else {
                imageView.setImageResource(R.drawable.icon_share_topic_corner);
            }
            ((TextView) a2.findViewById(R.id.tv)).setText(R.string.super_topic);
            a2.setVisibility(0);
            this.S.setVisibility(0);
            String str = null;
            if (bluedIngSelfFeed.isRepost() && bluedIngSelfFeed.repost.is_share_super_topics == 1) {
                str = bluedIngSelfFeed.repost.share_s_t_des;
            } else if (!TextUtils.isEmpty(bluedIngSelfFeed.share_s_t_des)) {
                str = bluedIngSelfFeed.share_s_t_des;
            }
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = FeedListAdapterForRecyclerView.this.f19617a.getResources().getString(R.string.share_topic_to_you);
            }
            this.S.setText(MarkDownLinkHelper.a(FeedListAdapterForRecyclerView.this.f19617a, str2, true, R.color.syc_m));
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected String b() {
            return FeedListAdapterForRecyclerView.this.g(this.f19641a);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.WebFeedViewHolder
        public void q() {
            String str;
            super.q();
            if (this.f19641a.isRepost() && this.f19641a.repost.is_share_super_topics == 1) {
                this.Q.setText(this.f19641a.getContentData().share_s_t_name);
                str = this.f19641a.getContentData().share_s_t_avatar;
            } else {
                this.Q.setText(this.f19641a.share_s_t_name);
                str = this.f19641a.share_s_t_avatar;
            }
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, str).b(R.drawable.defaultpicture).a(this.N);
            this.M.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$ShareTopicFeedViewHolder$RLdT8cNrVHdfoLqfmC0gZTBPFiA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.ShareTopicFeedViewHolder.this.a(view);
                }
            });
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$SignStateSetViewHolder.class */
    public class SignStateSetViewHolder {
        private BaseViewHolder b;

        private SignStateSetViewHolder(BaseViewHolder baseViewHolder, View view) {
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            this.b = baseViewHolder;
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            FeedListAdapterForRecyclerView.this.a(this.b, bluedIngSelfFeed, i);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$SignStateSetViewHolderV2.class */
    public class SignStateSetViewHolderV2 {
        private BaseViewHolder b;

        /* renamed from: c  reason: collision with root package name */
        private CommonMultiItemAdapter<BluedIngSelfFeed> f19692c;
        private AutoPollRecyclerView d;

        private SignStateSetViewHolderV2(BaseViewHolder baseViewHolder, View view) {
            if (FeedListAdapterForRecyclerView.this.J > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = FeedListAdapterForRecyclerView.this.J;
                marginLayoutParams.rightMargin = FeedListAdapterForRecyclerView.this.J;
                view.setLayoutParams(marginLayoutParams);
            }
            this.b = baseViewHolder;
            this.d = (AutoPollRecyclerView) baseViewHolder.getView(R.id.item_feed_sign_set_arv);
            CommonMultiItemAdapter<BluedIngSelfFeed> commonMultiItemAdapter = new CommonMultiItemAdapter<BluedIngSelfFeed>() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.SignStateSetViewHolderV2.1
                @Override // com.chad.library.adapter.base.BaseQuickAdapter
                /* renamed from: a */
                public BluedIngSelfFeed getItem(int i) {
                    if (getData().size() > 0) {
                        return (BluedIngSelfFeed) getData().get(i % getData().size());
                    }
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.community.view.CommonMultiItemAdapter
                /* renamed from: a */
                public void onConvert(CommonViewHolder commonViewHolder, BluedIngSelfFeed bluedIngSelfFeed, int i) {
                    int i2 = CommunityManager.f19086a.a().s() ? R.drawable.feed_sign_set_new_item_bg_dark : R.drawable.feed_sign_set_new_item_bg;
                    String k = FeedListAdapterForRecyclerView.this.k(bluedIngSelfFeed);
                    String str = k;
                    if (TextUtils.isEmpty(k)) {
                        str = "25/180/70";
                    }
                    CommonViewHolder text = commonViewHolder.setImageCircleUrl(R.id.item_feed_sign_set_avatar, bluedIngSelfFeed.user_avatar, R.drawable.user_bg_round).setText(R.id.item_feed_sign_set_user_name, bluedIngSelfFeed.user_name).setImageUrl(R.id.item_feed_sign_set_state_iv, bluedIngSelfFeed.bubble_state_icon).setText(R.id.item_feed_sign_set_user_info_tv, str).setText(R.id.item_feed_sign_set_state_tv, bluedIngSelfFeed.bubble_state_name);
                    int i3 = R.id.item_feed_sign_set_content_tv;
                    text.setText(i3, "| " + bluedIngSelfFeed.feed_content).setBackgroundRes(R.id.item_feed_sign_content_bg, i2);
                }

                @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
                public int getItemCount() {
                    return Integer.MAX_VALUE;
                }

                @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
                public int getItemViewType(int i) {
                    int i2 = i;
                    if (getData().size() > 0) {
                        i2 = i % getData().size();
                    }
                    return super.getItemViewType(i2);
                }

                @Override // com.blued.community.view.CommonMultiItemAdapter
                public void onAddItemType() {
                    addItemType(0, R.layout.item_feed_sign_set_flipper_layout);
                    addItemType(24, R.layout.item_feed_sign_set_flipper_v2_layout);
                }
            };
            this.f19692c = commonMultiItemAdapter;
            this.d.setAdapter(commonMultiItemAdapter);
            this.d.setLayoutManager(new LinearLayoutManager(FeedListAdapterForRecyclerView.this.f19617a, 0, false));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BluedIngSelfFeed bluedIngSelfFeed, View view) {
            FeedListAdapterForRecyclerView.this.a(bluedIngSelfFeed, true);
        }

        public void a(final BluedIngSelfFeed bluedIngSelfFeed, int i) {
            ImageView imageView = (ImageView) this.b.getView(R.id.item_feed_sign_set_title);
            if (CommunityManager.f19086a.a().s()) {
                this.b.setBackgroundRes(R.id.item_feed_sign_set_content_bg, R.drawable.item_feed_sign_set_content_bg_new_dark);
                this.b.setTextColor(R.id.item_feed_sign_set_time, Color.parseColor("#857C94"));
                imageView.setImageResource(R.drawable.item_feed_sign_set_title_dark);
            } else {
                this.b.setBackgroundRes(R.id.item_feed_sign_set_content_bg, R.drawable.item_feed_sign_set_content_bg_new);
                this.b.setTextColor(R.id.item_feed_sign_set_time, Color.parseColor("#9E94B2"));
                imageView.setImageResource(R.drawable.item_feed_sign_set_title);
            }
            View view = this.b.getView(R.id.item_feed_sign_set_fake);
            if (bluedIngSelfFeed.signStateList.size() > 1) {
                this.b.setText(R.id.item_feed_sign_set_time, TimeAndDateUtils.a(bluedIngSelfFeed.feed_timestamp, true));
                this.d.setVisibility(0);
                view.setVisibility(8);
                this.f19692c.setDataAndNotify(bluedIngSelfFeed.signStateList);
                this.d.setItemCount(bluedIngSelfFeed.signStateList.size());
                this.d.a(2000);
            } else if (bluedIngSelfFeed.signStateList.size() == 1) {
                this.b.setText(R.id.item_feed_sign_set_time, "");
                view.setVisibility(0);
                this.d.setVisibility(8);
                View view2 = this.b.getView(R.id.item_feed_sign_content_bg);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                marginLayoutParams.width = -1;
                marginLayoutParams.rightMargin = FeedMethods.c(12);
                view2.setLayoutParams(marginLayoutParams);
                int i2 = CommunityManager.f19086a.a().s() ? R.drawable.feed_sign_set_new_item_bg_dark : R.drawable.feed_sign_set_new_item_bg;
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, bluedIngSelfFeed.signStateList.get(0).user_avatar).c().a((ImageView) this.b.getView(R.id.item_feed_sign_set_avatar));
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, bluedIngSelfFeed.signStateList.get(0).bubble_state_icon).c().a((ImageView) this.b.getView(R.id.item_feed_sign_set_state_iv));
                TextView textView = (TextView) this.b.getView(R.id.item_feed_sign_set_state_tv);
                textView.setMaxWidth(FeedMethods.c(75));
                textView.setText(bluedIngSelfFeed.signStateList.get(0).bubble_state_name);
                TextView textView2 = (TextView) this.b.getView(R.id.item_feed_sign_set_content_tv);
                textView2.setMaxWidth(FeedMethods.c(140));
                textView2.setText("| " + bluedIngSelfFeed.signStateList.get(0).feed_content);
                this.b.setText(R.id.item_feed_sign_set_user_name, bluedIngSelfFeed.signStateList.get(0).user_name).setBackgroundRes(R.id.item_feed_sign_content_bg, i2);
            }
            this.b.setOnClickListener(R.id.item_feed_sign_set_click_view_id, new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SignStateSetViewHolderV2$CoDPSdtUcuMAKx1HIpzs29xAqJg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    FeedListAdapterForRecyclerView.SignStateSetViewHolderV2.this.a(bluedIngSelfFeed, view3);
                }
            });
            if (bluedIngSelfFeed.playAnimType == 4) {
                LogUtils.c("judgeSendBubbleV2Guide.playAnimType.showAnim");
                final View view3 = this.b.getView(R.id.item_feed_sign_set_guide_id);
                view3.setVisibility(0);
                ImageView imageView2 = (ImageView) this.b.getView(R.id.item_feed_sign_set_guide_hand_id);
                final FeedGuidePop feedGuidePop = new FeedGuidePop(FeedListAdapterForRecyclerView.this.f19617a, FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.feed_bubble_set_see_all), NinePatchUtils.GuideArrowPosition.CENTER, true, 0, null, 0, 0, 0);
                FeedGuidePop.t.c(feedGuidePop, new SimpleCallback(), this.b.getView(R.id.item_feed_sign_set_guide_at_id), 0L);
                ImageLoader.c(FeedListAdapterForRecyclerView.this.f19618c, "sign_feed_guide_poke_hand.png").g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.SignStateSetViewHolderV2.2
                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void a() {
                    }

                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void b() {
                        feedGuidePop.p();
                        view3.setVisibility(8);
                    }
                }).a(imageView2);
                bluedIngSelfFeed.playAnimType = 0;
            }
            if (bluedIngSelfFeed.isShowUrlVisited) {
                return;
            }
            EventTrackFeed.a(FeedProtos.Event.CITY_PUNCH_FEED_ENTER_SHOW, bluedIngSelfFeed, FeedListAdapterForRecyclerView.this.d, false, FeedListAdapterForRecyclerView.this.o, i);
            bluedIngSelfFeed.isShowUrlVisited = true;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$SignStateViewHolder.class */
    public class SignStateViewHolder extends BaseFeedViewHolder implements View.OnClickListener {
        private BaseViewHolder A;
        private View B;
        private View C;
        private TextView y;
        private TextView z;

        private SignStateViewHolder(BaseViewHolder baseViewHolder, View view) {
            super(view);
            this.A = baseViewHolder;
            this.y = (TextView) a(R.id.item_feed_sign_state_tv);
            this.z = (TextView) a(R.id.item_feed_sign_poke_me_tv);
            this.B = a(R.id.header_view);
            this.C = a(R.id.name_view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            if (this.f19641a != null) {
                SignInteractiveListFragment.g.a(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.feed_id, this.f19641a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(TextView textView, String str, String str2, String str3, int i, File file, Exception exc) {
            if (file == null || !file.exists()) {
                textView.setText(str);
                return;
            }
            Bitmap a2 = com.blued.android.framework.utils.ImageUtils.a(file, FeedMethods.c(16), FeedMethods.c(16));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            if (a2 == null || !TextUtils.equals(this.f19641a.bubble_state_icon, (String) textView.getTag(str3.hashCode()))) {
                textView.setText(str);
                return;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(a2);
            bitmapDrawable.setBounds(0, 0, FeedMethods.c(16), FeedMethods.c(16));
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(bitmapDrawable, 2), i, str3.length() + i, 33);
            int indexOf = str2.indexOf(this.f19641a.bubble_state_name);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_h)), indexOf, this.f19641a.bubble_state_name.length() + indexOf, 33);
            textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BluedIngSelfFeed bluedIngSelfFeed, View view) {
            if (this.f19641a != null) {
                SignFeedListFragment.b.a(FeedListAdapterForRecyclerView.this.f19617a, this.f19641a.bubble_state_tt_id, 9, this.f19641a);
                EventTrackFeed.b(FeedProtos.Event.PUNCH_FEED_MORE_USER_CLICK, bluedIngSelfFeed, FeedListAdapterForRecyclerView.this.d);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BaseViewHolder baseViewHolder, BluedIngSelfFeed bluedIngSelfFeed, int i, View view) {
            FeedListAdapterForRecyclerView.this.a(baseViewHolder, bluedIngSelfFeed, i, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BaseViewHolder baseViewHolder, BluedIngSelfFeed bluedIngSelfFeed, View view) {
            FeedListAdapterForRecyclerView.this.b(baseViewHolder, bluedIngSelfFeed);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            a(false);
        }

        private void b(final BluedIngSelfFeed bluedIngSelfFeed) {
            View a2 = a(R.id.item_feed_sign_classify_layout);
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SignStateViewHolder$injipZuJy7Icsh5LQiE-xiq0opU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.SignStateViewHolder.this.a(bluedIngSelfFeed, view);
                }
            });
            if (this.f19641a.bubble_state_avatars == null || this.f19641a.bubble_state_avatars.size() <= 0) {
                this.A.setGone(R.id.item_feed_sign_classify_avatar_1, false);
                this.A.setGone(R.id.item_feed_sign_classify_more_iv, false);
            } else {
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, this.f19641a.bubble_state_avatars.get(0).avatar).c().b(R.drawable.user_bg_round).a((ImageView) this.A.getView(R.id.item_feed_sign_classify_avatar_1));
                this.A.setGone(R.id.item_feed_sign_classify_avatar_1, true);
                this.A.setGone(R.id.item_feed_sign_classify_more_iv, true);
            }
            final TextView textView = (TextView) a(R.id.item_feed_sign_classify_tv);
            String string = FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.feed_list_bubble_sign_guide);
            String str = this.f19641a.bubble_state_count;
            final String format = String.format(string, str, "[bubble_pic]" + this.f19641a.bubble_state_name);
            final String format2 = String.format(FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.feed_list_bubble_sign_guide), this.f19641a.bubble_state_count, this.f19641a.bubble_state_name);
            final int indexOf = format.indexOf("[bubble_pic]");
            if (TextUtils.isEmpty(this.f19641a.bubble_state_icon) || indexOf < 0 || TextUtils.isEmpty(this.f19641a.bubble_state_name)) {
                textView.setText(format2);
            } else {
                textView.setTag(-359512917, this.f19641a.bubble_state_icon);
                ImageFileLoader.a(FeedListAdapterForRecyclerView.this.f19618c).a(this.f19641a.bubble_state_icon).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SignStateViewHolder$iNX93LtQ-cp_WyZuSf9iUQ8CMTA
                    @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                    public final void onUIFinish(File file, Exception exc) {
                        FeedListAdapterForRecyclerView.SignStateViewHolder.this.a(textView, format2, format, r8, indexOf, file, exc);
                    }
                }).a();
            }
            a2.setVisibility(0);
            this.A.setGone(R.id.item_feed_sign_go_list, false);
            this.A.setGone(R.id.item_feed_sign_poke_me_layout, false);
            EventTrackFeed.b(FeedProtos.Event.PUNCH_FEED_MORE_USER_SHOW, bluedIngSelfFeed, FeedListAdapterForRecyclerView.this.d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(BluedIngSelfFeed bluedIngSelfFeed, View view) {
            FeedListAdapterForRecyclerView.this.a(bluedIngSelfFeed, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            a(true);
        }

        private void q() {
            View a2 = a(R.id.item_feed_sign_poke_me_layout);
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SignStateViewHolder$Xk-a5hbpSd5Uv7XQDgCc7y8nvE0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.SignStateViewHolder.this.a(view);
                }
            });
            this.A.setGone(R.id.item_feed_sign_poke_me_avatar_1, false).setGone(R.id.item_feed_sign_poke_me_avatar_2, false).setGone(R.id.item_feed_sign_poke_me_avatar_3, false).setGone(R.id.item_feed_sign_poke_me_more_iv, false);
            if (this.f19641a.bubble_tt_click_uid_info.size() > 0) {
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, this.f19641a.bubble_tt_click_uid_info.get(0).avatar).c().b(R.drawable.user_bg_round).a((ImageView) this.A.getView(R.id.item_feed_sign_poke_me_avatar_1));
                this.A.setVisible(R.id.item_feed_sign_poke_me_avatar_1, true);
            }
            if (this.f19641a.bubble_tt_click_uid_info.size() > 1) {
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, this.f19641a.bubble_tt_click_uid_info.get(1).avatar).c().b(R.drawable.user_bg_round).a((ImageView) this.A.getView(R.id.item_feed_sign_poke_me_avatar_2));
                this.A.setVisible(R.id.item_feed_sign_poke_me_avatar_2, true);
            }
            if (this.f19641a.bubble_tt_click_uid_info.size() > 2) {
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, this.f19641a.bubble_tt_click_uid_info.get(2).avatar).c().b(R.drawable.user_bg_round).a((ImageView) this.A.getView(R.id.item_feed_sign_poke_me_avatar_3));
                this.A.setVisible(R.id.item_feed_sign_poke_me_avatar_3, true);
            }
            if (this.f19641a.bubble_tt_click_count > 3) {
                this.A.setVisible(R.id.item_feed_sign_poke_me_more_iv, true);
            }
            TextView textView = this.z;
            String string = FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.sign_feed_poke_me_num_str);
            textView.setText(String.format(string, this.f19641a.bubble_tt_click_count + ""));
            a2.setVisibility(0);
            this.A.setGone(R.id.item_feed_sign_go_list, false);
            this.A.setGone(R.id.item_feed_sign_classify_layout, false);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected View a() {
            return null;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            a(this.A, bluedIngSelfFeed, i);
            this.A.setGone(R.id.time_view, false);
            this.A.setGone(R.id.dot_icon_recommend, false);
            this.A.setGone(R.id.dot_icon_distance, false);
            if (i()) {
                this.A.setGone(R.id.dot_age_height_weight, false);
            } else {
                this.A.setGone(R.id.dot_age_height_weight, true);
            }
            String str = bluedIngSelfFeed.bubble_state_name;
            String a2 = TimeAndDateUtils.a(bluedIngSelfFeed.feed_timestamp, false);
            if (!TextUtils.isEmpty(a2)) {
                str = bluedIngSelfFeed.bubble_state_name + " · " + a2;
            }
            this.y.setText(str);
            this.B.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SignStateViewHolder$PbBJpJFH6u72l1Do4sCOFC5_Mzo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.SignStateViewHolder.this.c(view);
                }
            });
            this.C.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SignStateViewHolder$AvUrfGNfPRgfT7eQWPY-rbFTRp0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.SignStateViewHolder.this.b(view);
                }
            });
        }

        protected void a(final BaseViewHolder baseViewHolder, final BluedIngSelfFeed bluedIngSelfFeed, final int i) {
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.item_feed_sign_bg_corner_id);
            if (CommunityManager.f19086a.a().s()) {
                imageView.setImageResource(R.drawable.item_feed_sign_bg_corner_dark);
            } else {
                imageView.setImageResource(R.drawable.item_feed_sign_bg_corner);
            }
            final ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.feed_bubble_nearby_guide_anim_iv);
            final ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.feed_bubble_nearby_guide_up_anim_iv);
            final ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.feed_bubble_nearby_guide_btn_anim_iv);
            if (bluedIngSelfFeed.playAnimType == 6) {
                LogUtils.c("冒泡插入: 执行引导动画");
                bluedIngSelfFeed.playAnimType = 0;
                imageView2.setVisibility(0);
                imageView3.setVisibility(0);
                imageView4.setVisibility(0);
                ImageLoader.c(FeedListAdapterForRecyclerView.this.f19618c, CommunityManager.f19086a.a().s() ? "feed_bubble_nearby_guide_anim_dark.png" : "feed_bubble_nearby_guide_anim.png").g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.SignStateViewHolder.1
                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void a() {
                        LogUtils.c("冒泡插入: 引导动画onAnimationStart");
                    }

                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void b() {
                        imageView2.setVisibility(8);
                        LogUtils.c("冒泡插入: 引导动画onAnimationEnd");
                    }
                }).a(imageView2);
                ImageLoader.c(FeedListAdapterForRecyclerView.this.f19618c, "feed_bubble_nearby_guide_btn_anim.png").g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.SignStateViewHolder.2
                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void a() {
                    }

                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void b() {
                        imageView3.setVisibility(8);
                    }
                }).a(imageView3);
                ImageLoader.c(FeedListAdapterForRecyclerView.this.f19618c, "feed_bubble_nearby_guide_btn_light.png").g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.SignStateViewHolder.3
                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void a() {
                    }

                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void b() {
                        imageView4.setVisibility(8);
                    }
                }).a(imageView4);
                EventTrackFeed.e(FeedProtos.Event.CITY_PUNCH_GUIDE_FEED_SHOW, bluedIngSelfFeed.feed_id);
            }
            ((TextView) baseViewHolder.getView(R.id.item_feed_sign_new_face)).setVisibility(bluedIngSelfFeed.is_new_face == 1 ? 0 : 8);
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, bluedIngSelfFeed.bubble_state_icon).b(R.drawable.defaultpicture).a((ImageView) baseViewHolder.getView(R.id.item_feed_sign_state_iv));
            baseViewHolder.setText(R.id.item_feed_sign_content_tv, bluedIngSelfFeed.feed_content);
            GradientTextView gradientTextView = (GradientTextView) baseViewHolder.getView(R.id.item_feed_sign_go_list_tv);
            if (FeedListAdapterForRecyclerView.this.d(bluedIngSelfFeed.feed_uid)) {
                baseViewHolder.setGone(R.id.item_feed_sign_say_hi_btn, false);
                baseViewHolder.setGone(R.id.sign_feed_guide_poke_hand_iv, false);
                baseViewHolder.setGone(R.id.feed_sign_avatar_mask, false);
            } else {
                baseViewHolder.setVisible(R.id.item_feed_sign_say_hi_btn, true);
                if (bluedIngSelfFeed.is_bubble_tt_click == 0) {
                    baseViewHolder.setBackgroundRes(R.id.item_feed_sign_say_hi_btn, R.drawable.gradient_feed_sign_poke_btn_bg).setVisible(R.id.item_feed_sign_say_hi_iv, true).setTextColor(R.id.item_feed_sign_say_hi_tv, -1).setText(R.id.item_feed_sign_say_hi_tv, R.string.feed_list_item_click_sign);
                } else {
                    baseViewHolder.setBackgroundRes(R.id.item_feed_sign_say_hi_btn, R.drawable.item_feed_sign_say_hi_bg).setGone(R.id.item_feed_sign_say_hi_iv, false).setTextColor(R.id.item_feed_sign_say_hi_tv, FeedListAdapterForRecyclerView.this.f19617a.getResources().getColor(R.color.syc_2B72FF));
                    if (bluedIngSelfFeed.is_say_hello == 1) {
                        baseViewHolder.setText(R.id.item_feed_sign_say_hi_tv, R.string.continue_chat);
                    } else {
                        baseViewHolder.setText(R.id.item_feed_sign_say_hi_tv, R.string.feed_list_item_say_hi);
                    }
                }
                baseViewHolder.setGone(R.id.feed_sign_avatar_mask, bluedIngSelfFeed.is_bubble_tt_click == 0);
            }
            if (bluedIngSelfFeed.playAnimType == 2) {
                FeedListAdapterForRecyclerView.this.a(baseViewHolder);
                bluedIngSelfFeed.playAnimType = 0;
            }
            ImageView imageView5 = (ImageView) baseViewHolder.getView(R.id.item_feed_sign_complete_style_iv);
            if (TextUtils.isEmpty(bluedIngSelfFeed.complete_style)) {
                imageView5.setVisibility(8);
            } else {
                imageView5.setVisibility(0);
                ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, bluedIngSelfFeed.complete_style).a(imageView5);
            }
            baseViewHolder.setOnClickListener(R.id.item_feed_sign_go_list, new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SignStateViewHolder$tGyrSJYx6LdZ2zzfNodDX1p-skk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.SignStateViewHolder.this.b(bluedIngSelfFeed, view);
                }
            });
            if (bluedIngSelfFeed.is_bubble_tt_click == 1 || bluedIngSelfFeed.is_say_hello == 1) {
                baseViewHolder.getView(R.id.item_feed_sign_say_hi_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SignStateViewHolder$uH5amkSyUExLvxr6ScyxgQDdbsU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedListAdapterForRecyclerView.SignStateViewHolder.this.a(baseViewHolder, bluedIngSelfFeed, view);
                    }
                });
            } else {
                baseViewHolder.getView(R.id.item_feed_sign_say_hi_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SignStateViewHolder$1IIG_0gxx9oddAu3ciKEMRNTmW0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedListAdapterForRecyclerView.SignStateViewHolder.this.a(baseViewHolder, bluedIngSelfFeed, i, view);
                    }
                });
            }
            baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.SignStateViewHolder.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (bluedIngSelfFeed.is_bubble_tt_click != 0 || bluedIngSelfFeed.isMyFeed()) {
                        return;
                    }
                    FeedListAdapterForRecyclerView.this.a(baseViewHolder, bluedIngSelfFeed, i, 1);
                }
            });
            if (!bluedIngSelfFeed.isShowUrlVisited) {
                FeedMethods.a(bluedIngSelfFeed, FeedListAdapterForRecyclerView.this.d, i, "", 0, "", FeedListAdapterForRecyclerView.this.o, bluedIngSelfFeed.getYYLiving());
                bluedIngSelfFeed.isShowUrlVisited = true;
            }
            if (AppInfo.m()) {
                StringBuilder sb = new StringBuilder();
                sb.append("isBubbleSignGroup: ");
                sb.append(CommunityServiceManager.a().P());
                sb.append(", feedFrom:");
                sb.append(FeedListAdapterForRecyclerView.this.d);
                sb.append(", bubble_state_count:");
                sb.append(bluedIngSelfFeed.bubble_state_count);
                sb.append(", bubble_tt_click_uid_info:");
                sb.append(bluedIngSelfFeed.bubble_tt_click_uid_info != null ? Integer.valueOf(bluedIngSelfFeed.bubble_tt_click_uid_info.size()) : b.l);
                LogUtils.c(sb.toString());
            }
            if (CommunityServiceManager.a().P()) {
                gradientTextView.setText("去看看更多打卡内容");
                gradientTextView.a(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_k), BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_k));
            } else {
                gradientTextView.setText(R.string.feed_list_item_enter_sign);
                gradientTextView.a(Color.parseColor("#7056FF"), Color.parseColor("#3071FE"));
            }
            if (CommunityServiceManager.a().P() && ((FeedListAdapterForRecyclerView.this.d == 0 || FeedListAdapterForRecyclerView.this.d == 4 || FeedListAdapterForRecyclerView.this.d == 19 || FeedListAdapterForRecyclerView.this.d == 1 || FeedListAdapterForRecyclerView.this.d == 11) && CommonStringUtils.a(bluedIngSelfFeed.bubble_state_count) > 0)) {
                b(bluedIngSelfFeed);
            } else if ((FeedListAdapterForRecyclerView.this.d == 26 || FeedListAdapterForRecyclerView.this.d == 1 || FeedListAdapterForRecyclerView.this.d == 11) && i() && bluedIngSelfFeed.bubble_tt_click_uid_info != null && bluedIngSelfFeed.bubble_tt_click_uid_info.size() > 0) {
                q();
            } else {
                baseViewHolder.setGone(R.id.item_feed_sign_poke_me_layout, false);
                baseViewHolder.setGone(R.id.item_feed_sign_classify_layout, false);
                if (FeedListAdapterForRecyclerView.this.d == 26) {
                    baseViewHolder.setGone(R.id.item_feed_sign_go_list, false);
                } else if ((FeedListAdapterForRecyclerView.this.d == 11 || FeedListAdapterForRecyclerView.this.d == 1) && FeedListAdapterForRecyclerView.this.d(bluedIngSelfFeed.feed_uid)) {
                    baseViewHolder.setGone(R.id.item_feed_sign_go_list, false);
                } else {
                    baseViewHolder.setGone(R.id.item_feed_sign_go_list, true);
                }
            }
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void a(boolean z) {
            if (this.f19641a.is_bubble_tt_click != 1 && !i()) {
                if (z) {
                    FeedListAdapterForRecyclerView.this.b(this.A, this.f19641a, this.d);
                    return;
                }
                return;
            }
            super.a(z);
            if (this.f19641a.is_bubble_tt_click == 1) {
                EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_PHOTO_CLICK, this.f19641a.feed_id, this.f19641a.feed_uid, FeedListAdapterForRecyclerView.this.q(), this.f19641a.is_new_face == 1, this.f19641a.strong_insert_data, true, false);
            }
            LogUtils.c("onClickHeaderName: toProfilePage");
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected String b() {
            return null;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected boolean g() {
            return false;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void n() {
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            Tracker.onClick(view);
            super.onClick(view);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$SubjectPostGuideViewHolder.class */
    public class SubjectPostGuideViewHolder {
        private View b;

        /* renamed from: c  reason: collision with root package name */
        private BaseViewHolder f19702c;

        public SubjectPostGuideViewHolder(BaseViewHolder baseViewHolder, View view) {
            this.b = view;
            this.f19702c = baseViewHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, BluedIngSelfFeed bluedIngSelfFeed, View view) {
            FeedListAdapterForRecyclerView.this.remove(i);
            FeedListAdapterForRecyclerView.this.notifyDataSetChanged();
            CommunityPreferences.a(FeedListAdapterForRecyclerView.this.d, 5);
            CommunityPreferences.b(FeedListAdapterForRecyclerView.this.d, TimeAndDateUtils.a());
            FeedAddPostFragment.a(FeedListAdapterForRecyclerView.this.f19617a, bluedIngSelfFeed.insertSubjectPostGuide);
            EventTrackFeed.a(FeedProtos.Event.TOPIC_GUIDE_CLICK, bluedIngSelfFeed.insertSubjectPostGuide.super_did, i, FeedListAdapterForRecyclerView.this.o, FeedListAdapterForRecyclerView.this.d);
        }

        public void a(final BluedIngSelfFeed bluedIngSelfFeed, final int i) {
            if (bluedIngSelfFeed == null || bluedIngSelfFeed.insertSubjectPostGuide == null) {
                return;
            }
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, bluedIngSelfFeed.insertSubjectPostGuide.avatar).a(9.0f).a((ImageView) this.f19702c.getView(R.id.iv_avatar));
            this.f19702c.setText(R.id.tv_name, bluedIngSelfFeed.insertSubjectPostGuide.name);
            if (TextUtils.isEmpty(bluedIngSelfFeed.insertSubjectPostGuide.description)) {
                this.f19702c.setGone(R.id.tv_desc, false);
            } else {
                this.f19702c.setText(R.id.tv_desc, bluedIngSelfFeed.insertSubjectPostGuide.description);
                this.f19702c.setGone(R.id.tv_desc, true);
            }
            this.f19702c.getView(R.id.btn_post_feed).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$SubjectPostGuideViewHolder$sjQ6LSCtx_N4eML227hgtZEDvFI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedListAdapterForRecyclerView.SubjectPostGuideViewHolder.this.a(i, bluedIngSelfFeed, view);
                }
            });
            if (bluedIngSelfFeed.isShowUrlVisited) {
                return;
            }
            EventTrackFeed.a(FeedProtos.Event.TOPIC_GUIDE_SHOW, bluedIngSelfFeed.insertSubjectPostGuide.super_did, i, FeedListAdapterForRecyclerView.this.o, FeedListAdapterForRecyclerView.this.d);
            bluedIngSelfFeed.isShowUrlVisited = true;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$ThirdAdFeedViewHolder.class */
    public class ThirdAdFeedViewHolder {
        private BluedIngSelfFeed b;

        /* renamed from: c  reason: collision with root package name */
        private int f19704c;

        public ThirdAdFeedViewHolder(View view) {
        }

        private void a() {
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            this.b = bluedIngSelfFeed;
            bluedIngSelfFeed.adPosition = i;
            this.f19704c = i;
            FeedListAdapterForRecyclerView.this.d(bluedIngSelfFeed, i);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$VideoFeedViewHolder.class */
    public class VideoFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
        private CardView A;
        private PLVideoPageView B;

        public VideoFeedViewHolder(View view) {
            super(view);
            this.A = (CardView) a(R.id.card);
            this.B = (PLVideoPageView) a(R.id.video_view);
        }

        private void q() {
            if (w().feed_videos.length >= 2) {
                if (w().feed_videos_height == null) {
                    w().feed_videos_height = new String[0];
                }
                if (w().feed_videos_width == null) {
                    w().feed_videos_width = new String[0];
                }
                if (w().feed_videos_width.length == 0 || w().feed_videos_height.length == 0) {
                    w().feed_videos_width = new String[]{"480"};
                    w().feed_videos_height = new String[]{"480"};
                }
                int i = 480;
                int a2 = StringUtils.a(w().feed_videos_width[0], 480);
                int a3 = StringUtils.a(w().feed_videos_height[0], 480);
                if (a2 == 0 || a3 == 0) {
                    a3 = 480;
                } else {
                    i = a2;
                }
                int[] a4 = FeedMethods.a(FeedListAdapterForRecyclerView.this.f19617a, i, a3, this.f19641a.isRepost());
                int i2 = a4[0];
                int i3 = a4[1];
                ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
                layoutParams.width = i2;
                layoutParams.height = i3;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.B.getLayoutParams();
                marginLayoutParams.width = i2;
                marginLayoutParams.height = (marginLayoutParams.width * a3) / i;
                marginLayoutParams.setMargins(0, (layoutParams.height - marginLayoutParams.height) / 2, 0, 0);
                ViewGroup.LayoutParams layoutParams2 = this.B.getLayoutParams();
                final String[] strArr = w().feed_videos;
                final String str = w().feed_video_size;
                VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
                videoPlayConfig.f15652a = w().feed_videos[0];
                videoPlayConfig.b = w().feed_videos[1];
                videoPlayConfig.e = layoutParams2.width;
                videoPlayConfig.f = layoutParams2.height;
                videoPlayConfig.a(i);
                videoPlayConfig.b(a3);
                try {
                    videoPlayConfig.f15653c = Integer.parseInt(w().feed_video_size);
                } catch (Exception e) {
                    Logger.b(FeedListAdapterForRecyclerView.class.getSimpleName(), " initVideo Integer.parseInt(getContentData().feed_video_size) Exception");
                }
                videoPlayConfig.g = new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.VideoFeedViewHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (CommunityServiceManager.a().k()) {
                            return;
                        }
                        if (VideoFeedViewHolder.this.g()) {
                            EventTrackFeed.a(FeedProtos.Event.NOTE_VIDEO_CLICK, VideoFeedViewHolder.this.f19641a.circle_id, VideoFeedViewHolder.this.f19641a.feed_id, EventTrackFeed.j(FeedListAdapterForRecyclerView.this.d), "");
                        }
                        String[] strArr2 = strArr;
                        if (strArr2 == null || strArr2.length < 2) {
                            return;
                        }
                        float f = 0.0f;
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                f = Float.parseFloat(str);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                f = 0.0f;
                            }
                        }
                        CommunityServiceManager.d().c("feed_video_play", 1);
                        ICommunityShowPageService b = CommunityServiceManager.b();
                        Context context = FeedListAdapterForRecyclerView.this.f19617a;
                        String[] strArr3 = strArr;
                        b.a(context, strArr3[0], strArr3[1], VideoFeedViewHolder.this.w().feed_id, FeedListAdapterForRecyclerView.this.h, f);
                        NearbyFeedFragment.q = SystemClock.elapsedRealtime();
                        if (FeedListAdapterForRecyclerView.this.b != null && (FeedListAdapterForRecyclerView.this.b instanceof RecommendFeedFragment)) {
                            ((RecommendFeedFragment) FeedListAdapterForRecyclerView.this.b).c(VideoFeedViewHolder.this.d);
                        }
                        FeedListAdapterForRecyclerView.this.a(2, VideoFeedViewHolder.this.f19641a);
                    }
                });
                this.B.b(videoPlayConfig);
            }
        }

        private void r() {
            if (g()) {
                t();
            } else {
                s();
            }
            NearbyFeedFragment.q = SystemClock.elapsedRealtime();
        }

        private void s() {
            if (CommunityServiceManager.a().k()) {
                return;
            }
            if (this.f19641a.isRepostAndDeleted()) {
                a(this.f19641a, false);
            } else if (FeedListAdapterForRecyclerView.this.d == 1 || FeedListAdapterForRecyclerView.this.d == 5 || FeedListAdapterForRecyclerView.this.d == 29 || FeedListAdapterForRecyclerView.this.d == 30) {
                a(w(), true, this.f19641a.feed_id, this.f19641a.feed_uid);
            } else {
                a(w(), false, this.f19641a.feed_id, this.f19641a.feed_uid);
            }
        }

        private void t() {
            EventTrackFeed.a(FeedProtos.Event.NOTE_VIDEO_CLICK, this.f19641a.circle_id, this.f19641a.feed_id, EventTrackFeed.j(FeedListAdapterForRecyclerView.this.d), "");
            if (CommunityServiceManager.a().k()) {
                return;
            }
            String[] strArr = w().feed_videos;
            String str = w().feed_video_size;
            if (strArr == null || strArr.length < 2) {
                return;
            }
            float f = 0.0f;
            if (!TextUtils.isEmpty(str)) {
                try {
                    f = Float.parseFloat(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    f = 0.0f;
                }
            }
            CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, strArr[0], strArr[1], this.f19641a.feed_id, 7, f);
            NearbyFeedFragment.q = SystemClock.elapsedRealtime();
            if (FeedListAdapterForRecyclerView.this.b != null && (FeedListAdapterForRecyclerView.this.b instanceof RecommendFeedFragment)) {
                ((RecommendFeedFragment) FeedListAdapterForRecyclerView.this.b).c(this.d);
            }
            FeedListAdapterForRecyclerView.this.a(2, this.f19641a);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected View a() {
            return this.B;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            q();
            this.B.setOnClickListener(new SingleClickProxy(this));
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.FeedOrCircleViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            super.onClick(view);
            if (view.getId() == R.id.video_view) {
                r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$VoteFeedViewHolder.class */
    public class VoteFeedViewHolder extends RepostAndTextFeedViewHolder implements View.OnClickListener {
        private FeedVoteGroup y;

        public VoteFeedViewHolder(View view) {
            super(view);
            this.y = (FeedVoteGroup) a(R.id.feed_vote);
        }

        private void b(BluedIngSelfFeed bluedIngSelfFeed) {
            this.k.setVisibility(8);
            this.r.setVisibility(0);
            this.r.setOnClickListener(new SingleClickProxy(this));
            if (TextUtils.isEmpty(bluedIngSelfFeed.feed_id) || bluedIngSelfFeed.feed_status != 200) {
                this.u.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_feed_unshare));
                this.v.setTextColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_k_50));
                this.r.setEnabled(false);
                return;
            }
            this.u.setImageDrawable(BluedSkinUtils.b(FeedListAdapterForRecyclerView.this.f19617a, R.drawable.icon_feed_share));
            this.v.setTextColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_h));
            this.r.setEnabled(true);
        }

        private void q() {
            if (w().feed_pics == null || w().feed_pics.length <= 1) {
                this.y.setVisibility(8);
                return;
            }
            this.y.setVisibility(0);
            final String str = w().feed_pics[0];
            final String str2 = w().feed_pics[1];
            this.y.a(FeedListAdapterForRecyclerView.this.f19618c, AvatarUtils.a(str), AvatarUtils.a(str2));
            this.y.a(w().ivoted, w().a_vote_count, w().vote_count, this.f19641a.isRepost());
            this.y.setOnViewClickListener(new FeedVoteGroup.OnViewClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.VoteFeedViewHolder.1
                @Override // com.blued.community.widget.vote.picture.FeedVoteGroup.OnViewClickListener
                public void a(boolean z) {
                    if (VoteFeedViewHolder.this.f19641a.isRepost()) {
                        VoteFeedViewHolder voteFeedViewHolder = VoteFeedViewHolder.this;
                        voteFeedViewHolder.a(voteFeedViewHolder.f19641a.repost, false);
                        return;
                    }
                    FeedHttpUtils.a((BluedUIHttpResponse) null, VoteFeedViewHolder.this.f19641a.feed_id, UserInfoUtils.c(), z, FeedListAdapterForRecyclerView.this.f19618c);
                    VoteFeedViewHolder.this.f19641a.is_vote = 1;
                    VoteFeedViewHolder.this.f19641a.vote_count++;
                    if (z) {
                        VoteFeedViewHolder.this.f19641a.a_vote_count++;
                        VoteFeedViewHolder.this.f19641a.ivoted = 1;
                    } else {
                        VoteFeedViewHolder.this.f19641a.b_vote_count++;
                        VoteFeedViewHolder.this.f19641a.ivoted = 2;
                    }
                    VoteFeedViewHolder.this.y.a(VoteFeedViewHolder.this.f19641a.ivoted, VoteFeedViewHolder.this.f19641a.a_vote_count, VoteFeedViewHolder.this.f19641a.vote_count, VoteFeedViewHolder.this.f19641a.isRepost());
                    LiveEventBus.get("feed_vote_change").post(VoteFeedViewHolder.this.f19641a);
                    EventTrackVote.a(VoteProtos.Event.VOTE_FEED_CHOOSE_PHOTO_CLICK, VoteFeedViewHolder.this.f19641a, z ? VoteProtos.PhotoOption.PHOTO_A : VoteProtos.PhotoOption.PHOTO_B, FeedListAdapterForRecyclerView.this.d);
                }

                @Override // com.blued.community.widget.vote.picture.FeedVoteGroup.OnViewClickListener
                public void b(boolean z) {
                    if (VoteFeedViewHolder.this.f19641a.isRepost()) {
                        VoteFeedViewHolder voteFeedViewHolder = VoteFeedViewHolder.this;
                        voteFeedViewHolder.a(voteFeedViewHolder.f19641a.repost, false);
                        return;
                    }
                    if (VoteFeedViewHolder.this.f19641a.isCirclePost()) {
                        CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, new String[]{str, str2}, !z ? 1 : 0, FeedListAdapterForRecyclerView.this.g, (LoadOptions) null, VoteFeedViewHolder.this.f19641a.user_name, (View) null, "");
                    } else {
                        CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, VoteFeedViewHolder.this.w(), 0, FeedListAdapterForRecyclerView.this.g, (LoadOptions) null, VoteFeedViewHolder.this.w().user_name, FeedListAdapterForRecyclerView.this.d);
                    }
                    NearbyFeedFragment.q = SystemClock.elapsedRealtime();
                    if (FeedListAdapterForRecyclerView.this.b != null && (FeedListAdapterForRecyclerView.this.b instanceof RecommendFeedFragment)) {
                        ((RecommendFeedFragment) FeedListAdapterForRecyclerView.this.b).c(VoteFeedViewHolder.this.d);
                    }
                    FeedListAdapterForRecyclerView.this.a(2, VoteFeedViewHolder.this.f19641a);
                    EventTrackVote.a(VoteProtos.Event.VOTE_FEED_ENLARGE_PHOTO_CLICK, VoteFeedViewHolder.this.f19641a.feed_uid, VoteFeedViewHolder.this.f19641a.feed_id);
                }
            });
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            if (!bluedIngSelfFeed.isRepost() && TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
                bluedIngSelfFeed.feed_content = FeedListAdapterForRecyclerView.this.f19617a.getString(R.string.feed_vote_content_default);
            }
            super.a(bluedIngSelfFeed, i);
            b(bluedIngSelfFeed);
            q();
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void e() {
            super.e();
            if (this.i != null) {
                this.i.setVisibility(8);
            }
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected boolean g() {
            return false;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            super.onClick(view);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected void p() {
            if (this.f19641a.reading_scope == 0) {
                super.p();
            } else {
                AppMethods.d(R.string.feed_votes_not_share);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedListAdapterForRecyclerView$WebFeedViewHolder.class */
    public class WebFeedViewHolder extends RepostAndTextFeedViewHolder implements View.OnClickListener {
        protected LinearLayout K;
        protected TextView L;
        protected CardView M;
        protected ImageView N;
        protected View O;
        protected ShapeTextView P;
        protected TextView Q;
        protected TextView R;
        protected TextView S;

        public WebFeedViewHolder(View view) {
            super(view);
            this.K = (LinearLayout) a(R.id.feed_info);
            this.L = (TextView) a(R.id.content_view);
            this.M = (CardView) a(R.id.cv_web_share);
            this.N = (ImageView) a(R.id.img_web_share);
            this.O = a(R.id.view_share_corner);
            this.P = (ShapeTextView) a(R.id.view_circle_corner);
            this.Q = (TextView) a(R.id.tv_web_share_content);
            this.R = (TextView) a(R.id.tv_web_share_title_right);
            this.S = (TextView) a(R.id.tv_web_share_desc);
        }

        private void r() {
            if (k()) {
                this.M.setCardBackgroundColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_y));
            } else {
                this.M.setCardBackgroundColor(BluedSkinUtils.a(FeedListAdapterForRecyclerView.this.f19617a, R.color.syc_x));
            }
        }

        private void s() {
            CommunityServiceManager.d().a("feed_web_card_click", 1);
            if (w().feed_extras != null) {
                CommunityServiceManager.b().a(FeedListAdapterForRecyclerView.this.f19617a, w().feed_extras.url, CommunityConstants.WebShowType.DEFAULT);
            }
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            super.a(bluedIngSelfFeed, i);
            r();
            q();
            this.O.setVisibility(8);
            this.P.setVisibility(8);
            this.S.setVisibility(8);
            this.R.setVisibility(8);
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected String b() {
            if (w().feed_extras == null || w().feed_extras.thumb == null || w().feed_extras.thumb.size() <= 0) {
                if (this.f19641a.feed_extras == null || this.f19641a.feed_extras.thumb == null || this.f19641a.feed_extras.thumb.size() <= 0) {
                    return null;
                }
                return this.f19641a.feed_extras.thumb.get(0).replace(";", "");
            }
            return w().feed_extras.thumb.get(0).replace(";", "");
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder
        protected boolean g() {
            return false;
        }

        @Override // com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.RepostAndTextFeedViewHolder, com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.BaseFeedViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            super.onClick(view);
            if (view.getId() == R.id.cv_web_share) {
                s();
            }
        }

        public void q() {
            this.M.setOnClickListener(new SingleClickProxy(this));
            if (w().feed_extras != null) {
                this.Q.setText(w().feed_extras.title);
            }
            ImageLoader.a(FeedListAdapterForRecyclerView.this.f19618c, b()).b(R.drawable.defaultpicture).a(this.N);
        }
    }

    public FeedListAdapterForRecyclerView(Context context, BaseFragment baseFragment, RecyclerView recyclerView, int i) {
        super(new ArrayList());
        this.C = new HashSet<>();
        this.D = null;
        this.k = -1;
        this.l = false;
        this.m = 0;
        this.n = "recommend";
        this.o = 0L;
        this.J = 0;
        this.K = false;
        this.M = 0;
        this.s = new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(final RecyclerView recyclerView2, int i2) {
                super.onScrollStateChanged(recyclerView2, i2);
                FeedListAdapterForRecyclerView.this.m = i2;
                FeedListAdapterForRecyclerView.this.l = false;
                if (i2 != 0) {
                    return;
                }
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FeedListAdapterForRecyclerView.this.m == 0) {
                            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = FeedListAdapterForRecyclerView.this;
                            RecyclerView recyclerView3 = recyclerView2;
                            feedListAdapterForRecyclerView.b(recyclerView3, recyclerView3.getChildCount());
                        }
                    }
                }, 300L);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i2, int i3) {
                super.onScrolled(recyclerView2, i2, i3);
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    FeedListAdapterForRecyclerView.this.E = linearLayoutManager.findFirstVisibleItemPosition();
                    FeedListAdapterForRecyclerView.this.F = linearLayoutManager.findLastVisibleItemPosition();
                }
            }
        };
        this.N = 0L;
        this.O = 0L;
        this.P = 0L;
        this.f19617a = context;
        this.b = baseFragment;
        this.f19618c = baseFragment.getFragmentActive();
        this.d = i;
        this.H = new NativeListHelper(0);
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            if (getRecyclerView() == null) {
                bindToRecyclerView(recyclerView);
            }
        }
        this.K = CommunityServiceManager.a().M();
        a();
        b();
        this.I = new FeedHandler();
        t();
    }

    private List<BluedIngSelfFeed> a(Collection<? extends BluedIngSelfFeed> collection) {
        ArrayList arrayList = new ArrayList();
        for (BluedIngSelfFeed bluedIngSelfFeed : collection) {
            if (bluedIngSelfFeed.is_third_ads == 1) {
                arrayList.add(bluedIngSelfFeed);
            } else {
                String str = bluedIngSelfFeed.feed_id + bluedIngSelfFeed.is_ads + bluedIngSelfFeed.ads_id + bluedIngSelfFeed.lid + bluedIngSelfFeed.dataType + bluedIngSelfFeed.activity_id;
                String str2 = str;
                if (bluedIngSelfFeed.super_insert_floor != null) {
                    str2 = str + bluedIngSelfFeed.super_insert_floor.super_did;
                }
                if (!this.C.contains(str2)) {
                    arrayList.add(bluedIngSelfFeed);
                    this.C.add(str2);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null || bluedIngSelfFeed.is_bubble_ticktock == 1) {
            return;
        }
        if (i == 2 && bluedIngSelfFeed.isFeedClickPhotoTracked) {
            return;
        }
        bluedIngSelfFeed.isFeedClickPhotoTracked = true;
        FeedHttpUtils.a(String.valueOf(i), bluedIngSelfFeed.feed_id, bluedIngSelfFeed.feed_uid, (BluedUIHttpResponse) null, this.f19618c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        BaseFragment baseFragment = this.b;
        if (baseFragment != null) {
            if (baseFragment instanceof SignFeedListFragment) {
                ((SignFeedListFragment) baseFragment).a(recyclerView, i, i2);
            } else if (baseFragment instanceof RecommendFeedFragment) {
                ((RecommendFeedFragment) baseFragment).a(recyclerView, i, i2);
            }
        }
    }

    private void a(BluedIngSelfFeed bluedIngSelfFeed, int i, int i2) {
        int i3;
        if (i == 0 || i == 1) {
            bluedIngSelfFeed.iliked = i;
            try {
                int i4 = bluedIngSelfFeed.feed_dig;
                if (i == 1) {
                    int i5 = i4 + 1;
                    if (this.i) {
                        bluedIngSelfFeed.isPlayLikeAnim = true;
                        this.i = false;
                    }
                    i3 = i5;
                    if (bluedIngSelfFeed.is_expression == 1) {
                        bluedIngSelfFeed.interaction_count++;
                        i3 = i5;
                    }
                } else {
                    int i6 = i4 - 1;
                    i3 = i6;
                    if (bluedIngSelfFeed.is_expression == 1) {
                        bluedIngSelfFeed.interaction_count = Math.max(bluedIngSelfFeed.interaction_count - 1, 0);
                        i3 = i6;
                    }
                }
                if (i3 < 0) {
                    i3 = 0;
                }
            } catch (Exception e) {
                i3 = 0;
            }
            bluedIngSelfFeed.feed_dig = i3;
        }
        notifyItemChanged(i2 + getHeaderLayoutCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        a(bluedIngSelfFeed, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseViewHolder baseViewHolder) {
        if (baseViewHolder == null) {
            return;
        }
        View view = baseViewHolder.getView(R.id.item_feed_sign_say_hi_btn);
        if (view != null) {
            Context context = this.f19617a;
            FeedGuidePop.t.a(new FeedGuidePop(context, context.getString(R.string.feed_list_item_double_click_sign), NinePatchUtils.GuideArrowPosition.CENTER, true, 0, null, 0, 0, 0), new SimpleCallback(), view, 0L);
        }
        final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.sign_feed_guide_poke_hand_iv);
        if (imageView != null) {
            imageView.setVisibility(0);
            ImageLoader.c(this.f19618c, "sign_feed_guide_poke_hand.png").g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.3
                @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                public void a() {
                }

                @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                public void b() {
                    imageView.setVisibility(8);
                }
            }).a(imageView);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.4
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setVisibility(8);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BaseViewHolder baseViewHolder, final BluedIngSelfFeed bluedIngSelfFeed, final int i, int i2) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.N;
        if (j <= 0) {
            this.N = elapsedRealtime;
            return;
        }
        if (elapsedRealtime - j < 1000) {
            final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.feed_sign_avatar_mask);
            imageView.setVisibility(0);
            final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
            animationDrawable.stop();
            animationDrawable.start();
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.8
                @Override // java.lang.Runnable
                public void run() {
                    animationDrawable.stop();
                    imageView.setVisibility(8);
                    FeedListAdapterForRecyclerView.this.c(baseViewHolder, bluedIngSelfFeed, i);
                }
            }, 2000L);
            if (CommunityPreferences.k(false)) {
                ToastUtils.a("已戳破泡泡，对方会收到通知");
                CommunityPreferences.l(false);
            }
            CommunityPreferences.i(false);
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_POKE_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.feed_uid, q(), bluedIngSelfFeed.is_new_face == 1, bluedIngSelfFeed.strong_insert_data, false, true);
            if (i2 == 1) {
                EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_TXT_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.feed_uid, q(), bluedIngSelfFeed.is_new_face == 1, bluedIngSelfFeed.strong_insert_data, false, true);
            }
        } else {
            Context context = this.f19617a;
            FeedGuidePop.t.a(new FeedGuidePop(context, context.getString(R.string.feed_list_item_double_click_sign), NinePatchUtils.GuideArrowPosition.CENTER, true, 0, null, 0, 0, 0), new SimpleCallback(), baseViewHolder.getView(R.id.item_feed_sign_say_hi_btn), 0L);
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_POKE_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.feed_uid, q(), bluedIngSelfFeed.is_new_face == 1, bluedIngSelfFeed.strong_insert_data, false, false);
        }
        this.N = 0L;
    }

    private boolean a(RecyclerView recyclerView, VideoFeedViewHolder videoFeedViewHolder) {
        if (recyclerView == null || videoFeedViewHolder.A == null || videoFeedViewHolder.A.getVisibility() != 0) {
            return false;
        }
        Rect rect = new Rect();
        videoFeedViewHolder.A.getLocalVisibleRect(rect);
        int height = videoFeedViewHolder.A.getHeight();
        if (rect.top != 0 || rect.bottom < height * 0.9d) {
            if (rect.top != 0 || rect.top != 0 || rect.bottom < height * 0.9d) {
            }
            return false;
        }
        return true;
    }

    private boolean a(PLVideoPageView pLVideoPageView) {
        if (pLVideoPageView != null) {
            if (!pLVideoPageView.a() && !NetworkUtils.a()) {
                PLVideoPageView pLVideoPageView2 = this.G;
                if (pLVideoPageView2 != null) {
                    pLVideoPageView2.g();
                }
                pLVideoPageView.c();
                Logger.b("PLVideoPageView", pLVideoPageView.getVideoUrl());
            }
            this.G = pLVideoPageView;
            LogData logData = new LogData();
            logData.logService = "feed_video_play";
            logData.from = "0";
            if (!TextUtils.isEmpty(this.j)) {
                logData.topic_id = this.j;
            }
            if (this.k != -1) {
                logData.topic_category = this.k + "";
            }
            CommunityServiceManager.d().a(logData);
            return true;
        }
        return false;
    }

    private void b(BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i) {
        this.i = true;
        a(bluedIngSelfFeed, 1, i);
        if (z) {
            CircleHttpUtils.a((BluedUIHttpResponse) null, UserInfoUtils.c(), bluedIngSelfFeed.feed_id, bluedIngSelfFeed.liked_url, this.f19618c);
        } else {
            FeedHttpUtils.a(this.f19617a, (BluedUIHttpResponse) null, UserInfoUtils.c(), bluedIngSelfFeed.feed_id, bluedIngSelfFeed.is_ads, bluedIngSelfFeed.liked_url, this.f19618c);
        }
    }

    private List<BluedIngSelfFeed> c(List<BluedIngSelfFeed> list) {
        ArrayList arrayList = new ArrayList();
        for (BluedIngSelfFeed bluedIngSelfFeed : list) {
            arrayList.add(j(bluedIngSelfFeed));
        }
        return arrayList;
    }

    private void c(BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i) {
        bluedIngSelfFeed.iliked = 0;
        a(bluedIngSelfFeed, 0, i);
        if (z) {
            CircleHttpUtils.a((BluedUIHttpResponse) null, UserInfoUtils.c(), bluedIngSelfFeed.feed_id, this.f19618c);
        } else {
            FeedHttpUtils.a(this.f19617a, (BluedUIHttpResponse) null, UserInfoUtils.c(), bluedIngSelfFeed.feed_id, bluedIngSelfFeed.is_ads, this.f19618c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return;
            }
            if (str.equalsIgnoreCase(((BluedIngSelfFeed) this.mData.get(i2)).feed_id)) {
                ((BluedIngSelfFeed) this.mData.get(i2)).is_say_hello = 1;
                notifyItemChanged(i2 + getHeaderLayoutCount());
                return;
            }
            i = i2 + 1;
        }
    }

    private BluedIngSelfFeed j(BluedIngSelfFeed bluedIngSelfFeed) {
        return bluedIngSelfFeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null) {
            return "";
        }
        if (bluedIngSelfFeed.age > 0 || bluedIngSelfFeed.height > 0 || bluedIngSelfFeed.weight > 0) {
            StringBuilder sb = new StringBuilder();
            if (bluedIngSelfFeed.age > 0) {
                sb.append(bluedIngSelfFeed.age);
            } else {
                sb.append(Constants.WAVE_SEPARATOR);
            }
            sb.append(this.f19617a.getString(R.string.cut_point));
            if (bluedIngSelfFeed.height > 0) {
                sb.append(bluedIngSelfFeed.height);
            } else {
                sb.append(Constants.WAVE_SEPARATOR);
            }
            sb.append(this.f19617a.getString(R.string.cut_point));
            if (bluedIngSelfFeed.weight > 0) {
                sb.append(bluedIngSelfFeed.weight);
            } else {
                sb.append(Constants.WAVE_SEPARATOR);
            }
            return sb.toString();
        }
        return "";
    }

    private void t() {
        if (this.b != null) {
            LiveEventBus.get("FEED_BUBBLE_SAY_HELLO", String.class).observe(this.b, new Observer() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$ycG265fQOLKTzZhLDn1gYc11DqM
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FeedListAdapterForRecyclerView.this.e((String) obj);
                }
            });
        }
    }

    private void u() {
        if (this.P <= 0 || SystemClock.elapsedRealtime() - this.P >= 4100) {
            this.I.removeMessages(2);
            this.P = 0L;
            return;
        }
        this.I.removeMessages(2);
        this.I.sendEmptyMessageDelayed(2, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i >= getData().size()) {
                i = -1;
                break;
            }
            BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) getData().get(i);
            if (bluedIngSelfFeed != null && bluedIngSelfFeed.getItemType() == 25) {
                break;
            }
            i4 = i + 1;
        }
        LogUtils.c("judgeSendBubbleV2Guide.SIGN_STATE_SET index:" + i + ", allSize: " + getData().size());
        a(getRecyclerView());
        if (this.M != 0 || i < 0 || i < (i3 = this.p) || i >= this.L) {
            if (i >= 0 && getData().size() > i) {
                if (i != this.L || getData().size() <= (i2 = i + 1)) {
                    getRecyclerView().scrollToPosition(i);
                } else {
                    getRecyclerView().scrollToPosition(i2);
                }
            }
            u();
            return;
        }
        int i5 = i3 < 0 ? 0 : i3;
        LogUtils.c("judgeSendBubbleV2Guide.first:" + i5 + ", lastVisPosition:" + this.r);
        while (i5 < Math.min(this.r, getData().size())) {
            BluedIngSelfFeed bluedIngSelfFeed2 = (BluedIngSelfFeed) getData().get(i5);
            if (bluedIngSelfFeed2 != null && bluedIngSelfFeed2.getItemType() == 25) {
                this.I.removeMessages(2);
                this.P = 0L;
                bluedIngSelfFeed2.playAnimType = 4;
                LogUtils.c("judgeSendBubbleV2Guide.playAnimType:" + (getHeaderLayoutCount() + i5));
                notifyItemChanged(i5 + getHeaderLayoutCount());
                return;
            }
            i5++;
        }
    }

    public RecommendFeedRefreshGuideModel a(int i, int i2) {
        if (getRecyclerView() == null) {
            return null;
        }
        int headerLayoutCount = i + getHeaderLayoutCount();
        LogUtils.c("推荐下滑 realIndex.init: " + headerLayoutCount);
        View view = null;
        while (headerLayoutCount < getData().size()) {
            View childAt = getRecyclerView().getChildAt(headerLayoutCount);
            if (childAt != null) {
                if (i2 == 1) {
                    view = childAt.findViewById(R.id.feed_feed_info);
                } else if (i2 == 2) {
                    view = childAt.findViewById(R.id.content_view);
                }
                if (view != null) {
                    LogUtils.c("推荐下滑 realIndex: " + headerLayoutCount);
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    RecommendFeedRefreshGuideModel recommendFeedRefreshGuideModel = new RecommendFeedRefreshGuideModel();
                    recommendFeedRefreshGuideModel.setIndex(headerLayoutCount);
                    recommendFeedRefreshGuideModel.setLocY(iArr[1]);
                    return recommendFeedRefreshGuideModel;
                }
            }
            headerLayoutCount++;
        }
        return null;
    }

    protected void a() {
        this.mLayoutInflater = LayoutInflater.from(this.f19617a);
        this.f = DialogUtils.a(this.f19617a);
        ImageOptions imageOptions = new ImageOptions();
        this.B = imageOptions;
        imageOptions.f9508c = R.drawable.defaultpicture;
        this.B.f9507a = R.drawable.defaultpicture;
        if (this.d != 1) {
            this.g = 0;
            this.h = 7;
        } else {
            this.g = 1;
            this.h = 1;
        }
        this.e = FeedMethods.b(this.d);
    }

    public void a(int i) {
        this.J = i;
    }

    public void a(long j) {
        this.o = j;
        LogUtils.c("FEED_DRAW.refreshDataTime:" + this.o);
        FeedHorizontalRecommendAdapter feedHorizontalRecommendAdapter = this.x;
        if (feedHorizontalRecommendAdapter != null) {
            feedHorizontalRecommendAdapter.a(this.o);
        }
        RecommendChatRoomAdapter recommendChatRoomAdapter = this.z;
        if (recommendChatRoomAdapter != null) {
            recommendChatRoomAdapter.a(this.o);
        }
    }

    protected void a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.q = linearLayoutManager.findFirstVisibleItemPosition();
            this.p = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            this.L = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            this.r = linearLayoutManager.findLastVisibleItemPosition();
        }
        LogUtils.c("firstCompleteVisPosition: " + this.p);
        LogUtils.c("lastCompleteVisPosition: " + this.L);
        LogUtils.c("firstVisPosition: " + this.q);
        LogUtils.c("lastVisPosition: " + this.r);
    }

    protected void a(RecyclerView recyclerView, int i) {
        this.M = i;
        if (i == 0) {
            a(recyclerView);
            b(recyclerView);
            f();
            this.I.removeMessages(1);
            this.I.sendEmptyMessageDelayed(1, m.ag);
        }
        BaseFragment baseFragment = this.b;
        if (baseFragment != null) {
            if (baseFragment instanceof SignFeedListFragment) {
                ((SignFeedListFragment) baseFragment).a(recyclerView, i);
            } else if (baseFragment instanceof RecommendFeedFragment) {
                ((RecommendFeedFragment) baseFragment).a(recyclerView, i);
            }
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        String str = bluedIngSelfFeed.feed_id + bluedIngSelfFeed.ads_id + bluedIngSelfFeed.aid + bluedIngSelfFeed.adPosition;
        if (TextUtils.isEmpty(str) || this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return;
            }
            BluedIngSelfFeed bluedIngSelfFeed2 = (BluedIngSelfFeed) this.mData.get(i2);
            if (str.equals(bluedIngSelfFeed2.feed_id + bluedIngSelfFeed2.ads_id + bluedIngSelfFeed2.aid + bluedIngSelfFeed2.adPosition)) {
                this.mData.remove(i2);
                notifyDataSetChanged();
                return;
            }
            i = i2 + 1;
        }
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        if (bluedIngSelfFeed == null || bluedIngSelfFeed.isShowAdVisited) {
            return;
        }
        bluedIngSelfFeed.isShowAdVisited = true;
    }

    protected void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            int i2 = this.d;
            i = i2 == 0 ? 6 : i2 == 19 ? 7 : (i2 == 11 || i2 == 1) ? 2 : 0;
        }
        StringBuilder sb = new StringBuilder("");
        String str = "";
        if (bluedIngSelfFeed != null) {
            str = "";
            if (bluedIngSelfFeed.signStateList != null) {
                for (BluedIngSelfFeed bluedIngSelfFeed2 : bluedIngSelfFeed.signStateList) {
                    if (!TextUtils.isEmpty(bluedIngSelfFeed2.feed_id)) {
                        sb.append(bluedIngSelfFeed2.feed_id);
                        sb.append(",");
                    }
                }
                String sb2 = sb.toString();
                str = sb2;
                if (sb2.endsWith(",")) {
                    str = sb2.substring(0, sb2.length() - 1);
                }
            }
        }
        SignFeedListFragment.b.a(AppInfo.d(), str, i, bluedIngSelfFeed);
        NearbyFeedFragment.r = SystemClock.elapsedRealtime();
    }

    protected void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i) {
        if (z) {
            EventTrackFeed.a(bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, "", bluedIngSelfFeed.iliked == 0, AtUserHelper.a(bluedIngSelfFeed.feed_content), EventTrackFeed.b(bluedIngSelfFeed), EventTrackFeed.c(bluedIngSelfFeed), bluedIngSelfFeed.is_anonym == 1, false, EventTrackFeed.j(this.d), "");
        } else {
            if (o()) {
                FeedMethods.d();
            }
            if (this.d == 6 && FeedMethods.a(bluedIngSelfFeed)) {
                bluedIngSelfFeed.is_top = bluedIngSelfFeed.is_top_new;
            }
            EventTrackFeed.a(bluedIngSelfFeed, this.d, false);
        }
        if (UserInfoHelper.a(bluedIngSelfFeed.relationship)) {
            return;
        }
        if (bluedIngSelfFeed.iliked != 0) {
            bluedIngSelfFeed.iliked = 0;
            c(bluedIngSelfFeed, z, i);
            return;
        }
        bluedIngSelfFeed.iliked = 1;
        CommunityServiceManager.d().a(FeedMethods.b(this.d), bluedIngSelfFeed, this.j, this.k);
        b(bluedIngSelfFeed, z, i);
        if (bluedIngSelfFeed.isRecommendRefreshGuideFeed) {
            bluedIngSelfFeed.isRecommendRefreshGuideFeed = false;
            e(i);
            EventTrackFeed.e(FeedProtos.Event.FEED_RECOMMEND_LIKE_GUIDE_CLICK, bluedIngSelfFeed.feed_id);
        }
    }

    @Override // com.blued.community.ui.circle.observer.ICircleDataObserver
    public void a(CircleJoinState circleJoinState) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                notifyDataSetChanged();
                return;
            }
            if (((BluedIngSelfFeed) this.mData.get(i2)).isCirclePost() && !TextUtils.isEmpty(((BluedIngSelfFeed) this.mData.get(i2)).circle_id) && ((BluedIngSelfFeed) this.mData.get(i2)).circle_id.equals(circleJoinState.circle_id)) {
                ((BluedIngSelfFeed) this.mData.get(i2)).setJoinState(circleJoinState);
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(FeedComment feedComment) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return;
            }
            BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) this.mData.get(i2);
            if (((BluedIngSelfFeed) this.mData.get(i2)).isFeed() && bluedIngSelfFeed.feed_id != null && bluedIngSelfFeed.feed_id.equals(feedComment.feed_id)) {
                bluedIngSelfFeed.feed_comment++;
                bluedIngSelfFeed.comments.add(0, feedComment);
                notifyDataSetChanged();
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(BusFeedInteractModel busFeedInteractModel) {
        if (busFeedInteractModel == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return;
            }
            BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) this.mData.get(i2);
            if (bluedIngSelfFeed.isFeed() && bluedIngSelfFeed.feed_id != null && bluedIngSelfFeed.feed_id.equals(busFeedInteractModel.getFeedId())) {
                bluedIngSelfFeed.interaction_count = busFeedInteractModel.getInteraction_count();
                bluedIngSelfFeed.interaction_id = busFeedInteractModel.getInteraction_id();
                if (busFeedInteractModel.isAdd()) {
                    bluedIngSelfFeed.expression_id = busFeedInteractModel.getExpression_id();
                } else {
                    bluedIngSelfFeed.expression_id = 0;
                }
                notifyItemChanged(getHeaderLayoutCount() + i2);
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(FeedRepost feedRepost) {
        if (TextUtils.isEmpty(feedRepost.feed_id) || this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return;
            }
            if (((BluedIngSelfFeed) this.mData.get(i2)).isFeed() && feedRepost.feed_id.equals(((BluedIngSelfFeed) this.mData.get(i2)).feed_id)) {
                ((BluedIngSelfFeed) this.mData.get(i2)).repost_count++;
                notifyDataSetChanged();
                return;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedIngSelfFeed bluedIngSelfFeed) {
        a(bluedIngSelfFeed, baseViewHolder.getAdapterPosition() - getHeaderLayoutCount());
        if (baseViewHolder != null) {
            int adapterPosition = baseViewHolder.getAdapterPosition() - getHeaderLayoutCount();
            View convertView = baseViewHolder.getConvertView();
            convertView.setTag(R.id.feed, Integer.valueOf(adapterPosition));
            switch (baseViewHolder.getItemViewType()) {
                case -1:
                    new NoneFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 0:
                case 28:
                    new ImageOneFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 1:
                    new ImageTwoFourFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 2:
                    new ImageOtherFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 3:
                    VideoFeedViewHolder videoFeedViewHolder = new VideoFeedViewHolder(convertView);
                    videoFeedViewHolder.a(bluedIngSelfFeed, adapterPosition);
                    convertView.setTag(videoFeedViewHolder);
                    AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = FeedListAdapterForRecyclerView.this;
                            feedListAdapterForRecyclerView.b(feedListAdapterForRecyclerView.getRecyclerView(), FeedListAdapterForRecyclerView.this.getRecyclerView().getChildCount());
                        }
                    }, 1000L);
                    return;
                case 4:
                    new WebFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 5:
                    new AdFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 6:
                    new RecommendUserFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 7:
                case 11:
                case 12:
                case 13:
                case 18:
                case 19:
                default:
                    new DeleteFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 8:
                    new VoteFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 9:
                    new RecommendTopicViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 10:
                    new ShareTopicFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 14:
                    new RecommendCircleViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 15:
                    new ShareCircleFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 16:
                    new LiveFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 17:
                    new ShareCircleViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 20:
                    new ShareEventViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 21:
                    new ThirdAdFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 22:
                    new RecommendChatRoomViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 23:
                    new EventCardViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 24:
                    SignStateViewHolder signStateViewHolder = new SignStateViewHolder(baseViewHolder, convertView);
                    signStateViewHolder.a(bluedIngSelfFeed, adapterPosition);
                    convertView.setTag(signStateViewHolder);
                    return;
                case 25:
                    if (this.K) {
                        SignStateSetViewHolderV2 signStateSetViewHolderV2 = new SignStateSetViewHolderV2(baseViewHolder, convertView);
                        signStateSetViewHolderV2.a(bluedIngSelfFeed, adapterPosition);
                        convertView.setTag(signStateSetViewHolderV2);
                        return;
                    }
                    SignStateSetViewHolder signStateSetViewHolder = new SignStateSetViewHolder(baseViewHolder, convertView);
                    signStateSetViewHolder.a(bluedIngSelfFeed, adapterPosition);
                    convertView.setTag(signStateSetViewHolder);
                    return;
                case 26:
                    new ChatRoomFeedViewHolder(convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 27:
                    new RecommendSubjectViewHolder(baseViewHolder, convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 29:
                    new SubjectPostGuideViewHolder(baseViewHolder, convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 30:
                    new BubblePostGuideViewHolder(baseViewHolder, convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
                case 31:
                    new RecommendRefreshGuideViewHolder(baseViewHolder, convertView).a(bluedIngSelfFeed, adapterPosition);
                    return;
            }
        }
    }

    protected void a(BaseViewHolder baseViewHolder, final BluedIngSelfFeed bluedIngSelfFeed, int i) {
        final ViewFlipper viewFlipper;
        if (CommunityManager.f19086a.a().s()) {
            baseViewHolder.setAlpha(R.id.item_feed_sign_set_bg_corner_id, 0.08f);
            ((CardView) baseViewHolder.getView(R.id.item_feed_sign_set_bg_id)).setCardBackgroundColor(this.f19617a.getResources().getColor(R.color.trans_white_nine));
            baseViewHolder.setBackgroundRes(R.id.item_feed_sign_set_content_bg, R.drawable.gradient_feed_sign_set_bg);
        } else {
            baseViewHolder.setAlpha(R.id.item_feed_sign_set_bg_corner_id, 1.0f);
            ((CardView) baseViewHolder.getView(R.id.item_feed_sign_set_bg_id)).setCardBackgroundColor(this.f19617a.getResources().getColor(R.color.white));
            baseViewHolder.setBackgroundRes(R.id.item_feed_sign_set_content_bg, R.drawable.gradient_feed_sign_set_bg_dark);
        }
        baseViewHolder.setText(R.id.item_feed_sign_set_time, TimeAndDateUtils.a(bluedIngSelfFeed.feed_timestamp, true));
        if (!bluedIngSelfFeed.signStateList.isEmpty() && (viewFlipper = (ViewFlipper) baseViewHolder.getView(R.id.item_feed_sign_set_vf)) != null) {
            int i2 = R.layout.item_feed_sign_set_flipper_layout;
            viewFlipper.removeAllViews();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= bluedIngSelfFeed.signStateList.size()) {
                    break;
                }
                BluedIngSelfFeed bluedIngSelfFeed2 = bluedIngSelfFeed.signStateList.get(i4);
                View inflate = this.mLayoutInflater.inflate(i2, (ViewGroup) null);
                ImageLoader.a(this.f19618c, bluedIngSelfFeed2.user_avatar).c().a((ImageView) inflate.findViewById(R.id.item_feed_sign_set_avatar));
                ((TextView) inflate.findViewById(R.id.item_feed_sign_set_user_name)).setText(bluedIngSelfFeed2.user_name);
                ImageLoader.a(this.f19618c, bluedIngSelfFeed2.bubble_state_icon).b(R.drawable.defaultpicture).a((ImageView) inflate.findViewById(R.id.item_feed_sign_set_state_iv));
                TextView textView = (TextView) inflate.findViewById(R.id.item_feed_sign_set_state_tv);
                textView.setText(bluedIngSelfFeed2.bubble_state_name + " | " + bluedIngSelfFeed2.feed_content);
                viewFlipper.addView(inflate);
                i3 = i4 + 1;
            }
            viewFlipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.7
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (bluedIngSelfFeed.signStateList.size() <= 1) {
                        viewFlipper.stopFlipping();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            if (bluedIngSelfFeed.signStateList.size() > 1) {
                viewFlipper.startFlipping();
            } else {
                viewFlipper.stopFlipping();
            }
        }
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.-$$Lambda$FeedListAdapterForRecyclerView$4JB_bhLB12nByZhonvuXZSCEZWk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedListAdapterForRecyclerView.this.a(bluedIngSelfFeed, view);
            }
        });
        if (bluedIngSelfFeed.playAnimType == 3) {
            a(baseViewHolder);
            bluedIngSelfFeed.playAnimType = 0;
        }
        if (bluedIngSelfFeed.isShowUrlVisited) {
            return;
        }
        EventTrackFeed.a(FeedProtos.Event.CITY_PUNCH_FEED_ENTER_SHOW, bluedIngSelfFeed, this.d, false, this.o, i);
        bluedIngSelfFeed.isShowUrlVisited = true;
    }

    public void a(String str) {
        this.n = str;
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(String str, int i) {
        if (TextUtils.isEmpty(str) || this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mData.size()) {
                return;
            }
            if (((BluedIngSelfFeed) this.mData.get(i3)).isFeed() && str.equals(((BluedIngSelfFeed) this.mData.get(i3)).feed_id)) {
                ((BluedIngSelfFeed) this.mData.get(i3)).allow_comments = i;
                notifyDataSetChanged();
                return;
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return;
            }
            if (((BluedIngSelfFeed) this.mData.get(i2)).isFeed() && str.equals(((BluedIngSelfFeed) this.mData.get(i2)).feed_id)) {
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) this.mData.get(i2);
                if (bluedIngSelfFeed == null || bluedIngSelfFeed.comments == null || bluedIngSelfFeed.comments.size() <= 0) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= bluedIngSelfFeed.comments.size()) {
                        break;
                    } else if (str2.equals(bluedIngSelfFeed.comments.get(i4).comment_id)) {
                        bluedIngSelfFeed.comments.remove(i4);
                        try {
                            int i5 = bluedIngSelfFeed.feed_comment;
                            int i6 = i5;
                            if (i5 > 0) {
                                i6 = i5 - 1;
                            }
                            bluedIngSelfFeed.feed_comment = i6;
                        } catch (Exception e) {
                            bluedIngSelfFeed.feed_comment = 0;
                        }
                    } else {
                        i3 = i4 + 1;
                    }
                }
                notifyDataSetChanged();
                return;
            }
            i = i2 + 1;
        }
    }

    public void a(String str, String str2, FeedProtos.SourcePage sourcePage, BluedIngSelfFeed bluedIngSelfFeed) {
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(str);
        eventLogData.setEventManagerUid(str2);
        eventLogData.setSourcePage(sourcePage);
        if (bluedIngSelfFeed != null) {
            eventLogData.strong_insert_data = bluedIngSelfFeed.strong_insert_data;
        }
        eventLogData.isStagger = false;
        eventLogData.mode = "";
        EventDetailsFragment.f19534a.a(this.f19617a, str, eventLogData);
    }

    public void a(List<BluedIngSelfFeed> list) {
        if (list != null) {
            setNewData(c(list));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(Collection<? extends BluedIngSelfFeed> collection) {
        super.addData((Collection) a(collection));
        notifyDataSetChanged();
    }

    public void b() {
        addItemType(-2, R.layout.item_feed_delete);
        addItemType(-1, R.layout.item_feed_none);
        addItemType(0, R.layout.item_feed_image_one);
        addItemType(1, R.layout.item_feed_image_two_four);
        addItemType(2, R.layout.item_feed_image_other);
        addItemType(3, R.layout.item_feed_video);
        addItemType(4, R.layout.item_feed_web);
        addItemType(8, R.layout.item_feed_vote);
        addItemType(16, R.layout.item_feed_live);
        addItemType(5, R.layout.item_feed_ad);
        addItemType(21, R.layout.item_feed_topon_ad_view);
        addItemType(6, R.layout.item_feed_recommend_user);
        addItemType(9, R.layout.item_feed_recommend_topic);
        addItemType(14, R.layout.item_feed_recommend_circle);
        addItemType(22, R.layout.item_feed_recommend_chat_room);
        addItemType(10, R.layout.item_feed_web);
        addItemType(15, R.layout.item_feed_web);
        addItemType(17, R.layout.item_feed_web);
        addItemType(20, R.layout.item_feed_web);
        addItemType(23, R.layout.item_feed_web);
        addItemType(24, R.layout.item_feed_sign);
        if (this.K) {
            addItemType(25, R.layout.item_feed_sign_set_v2);
        } else {
            addItemType(25, R.layout.item_feed_sign_set);
        }
        addItemType(26, R.layout.item_feed_chat_room);
        addItemType(27, R.layout.item_feed_recommend_subject);
        addItemType(28, R.layout.item_feed_image_one);
        addItemType(29, R.layout.item_feed_post_subject_guide);
        addItemType(30, R.layout.item_feed_bubble_post_guide_in_feed_list);
        addItemType(31, R.layout.item_feed_recommend_refresh_more_guide);
    }

    public void b(int i) {
        this.d = i;
    }

    protected void b(RecyclerView recyclerView) {
        if (this.p < 0 || this.L < 0 || !CommunityPreferences.m(false)) {
            return;
        }
        int i = this.p;
        while (true) {
            int i2 = i;
            if (i2 >= this.L) {
                return;
            }
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null && (childAt.getTag() instanceof SignStateSetViewHolder)) {
                CommunityPreferences.n(false);
                SignStateSetViewHolder signStateSetViewHolder = (SignStateSetViewHolder) childAt.getTag();
                Context context = this.f19617a;
                FeedGuidePop.t.a(new FeedGuidePop(context, context.getString(R.string.sign_feed_set_guide_enter), NinePatchUtils.GuideArrowPosition.RIGHT, true, R.drawable.defaultpicture, "sign_feed_set_guide_update_hand.png", 18, 30, 0), new SimpleCallback(), signStateSetViewHolder.b.getView(R.id.item_feed_sign_set_time_arrow), 0L);
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                notifyDataSetChanged();
                return;
            }
            if (((BluedIngSelfFeed) this.mData.get(i2)).isFeed() && !TextUtils.isEmpty(((BluedIngSelfFeed) this.mData.get(i2)).feed_id) && ((BluedIngSelfFeed) this.mData.get(i2)).feed_id.equals(bluedIngSelfFeed.feed_id)) {
                ((BluedIngSelfFeed) this.mData.get(i2)).is_vote = bluedIngSelfFeed.is_vote;
                ((BluedIngSelfFeed) this.mData.get(i2)).a_vote_count = bluedIngSelfFeed.a_vote_count;
                ((BluedIngSelfFeed) this.mData.get(i2)).b_vote_count = bluedIngSelfFeed.b_vote_count;
                ((BluedIngSelfFeed) this.mData.get(i2)).vote_count = bluedIngSelfFeed.vote_count;
                ((BluedIngSelfFeed) this.mData.get(i2)).ivoted = bluedIngSelfFeed.ivoted;
            }
            i = i2 + 1;
        }
    }

    protected void b(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        if (bluedIngSelfFeed.isShowUrlVisited) {
            return;
        }
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_DRAW, bluedIngSelfFeed, EventTrackFeed.j(this.d), false, i, this.o);
        bluedIngSelfFeed.isShowUrlVisited = true;
    }

    protected void b(BaseViewHolder baseViewHolder, BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null || bluedIngSelfFeed.feed_uid == null) {
            return;
        }
        LogUtils.c("onClickChat: toChattingPage");
        if (!UserInfoHelper.a(bluedIngSelfFeed.relationship)) {
            LogData logData = new LogData();
            logData.from = FeedMethods.a(this.d, bluedIngSelfFeed.is_vote);
            logData.userFrom = FeedMethods.a(this.d, bluedIngSelfFeed.is_vote);
            logData.target_uid = bluedIngSelfFeed.feed_uid;
            logData.feed_id = bluedIngSelfFeed.feed_id;
            logData.is_call = "1";
            CommunityServiceManager.b().b(this.f19617a, bluedIngSelfFeed, false, 0, logData, FeedMethods.b(this.d, 0));
        }
        EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_HI_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.feed_uid, q(), bluedIngSelfFeed.is_new_face == 1, bluedIngSelfFeed.strong_insert_data, false, false);
        BaseFragment baseFragment = this.b;
        if (baseFragment == null || !(baseFragment instanceof SignFeedListFragment)) {
            return;
        }
        ((SignFeedListFragment) baseFragment).E();
    }

    protected void b(final BaseViewHolder baseViewHolder, final BluedIngSelfFeed bluedIngSelfFeed, final int i) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        LogUtils.c("lastClickBubbleTime: " + this.O + ", curTime: " + elapsedRealtime + ", diff: " + (elapsedRealtime - this.O));
        long j = this.O;
        if (j <= 0) {
            this.O = elapsedRealtime;
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_PHOTO_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.feed_uid, q(), bluedIngSelfFeed.is_new_face == 1, bluedIngSelfFeed.strong_insert_data, bluedIngSelfFeed.is_bubble_tt_click == 1, false);
            return;
        }
        if (elapsedRealtime - j < 1000) {
            LogUtils.c("双击戳破泡泡");
            final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.feed_sign_avatar_mask);
            imageView.setVisibility(0);
            final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
            animationDrawable.stop();
            animationDrawable.start();
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.9
                @Override // java.lang.Runnable
                public void run() {
                    animationDrawable.stop();
                    imageView.setVisibility(8);
                    FeedListAdapterForRecyclerView.this.c(baseViewHolder, bluedIngSelfFeed, i);
                }
            }, 2000L);
            if (CommunityPreferences.k(false)) {
                ToastUtils.a("已戳破泡泡，对方会收到通知");
                CommunityPreferences.l(false);
            }
            CommunityPreferences.i(false);
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_PHOTO_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.feed_uid, q(), bluedIngSelfFeed.is_new_face == 1, bluedIngSelfFeed.strong_insert_data, bluedIngSelfFeed.is_bubble_tt_click == 1, true);
        } else if (!d(bluedIngSelfFeed.feed_uid)) {
            if (CommunityPreferences.d(false)) {
                CommunityPreferences.e(false);
                final ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.feed_sign_guide_avatar_hand);
                imageView2.setVisibility(0);
                ImageLoader.c(this.f19618c, "sign_feed_guide_poke_hand.png").g().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.10
                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void a() {
                    }

                    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                    public void b() {
                        imageView2.setVisibility(8);
                    }
                }).a(imageView2);
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.11
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView2.setVisibility(8);
                        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = FeedListAdapterForRecyclerView.this;
                        feedListAdapterForRecyclerView.notifyItemChanged(i + feedListAdapterForRecyclerView.getHeaderLayoutCount());
                    }
                }, 2000L);
            }
            int i2 = R.string.feed_list_item_double_click_to_profile;
            if (this.d == 1) {
                i2 = R.string.feed_list_item_double_click_poke_him;
            }
            Context context = this.f19617a;
            FeedGuidePop feedGuidePop = new FeedGuidePop(context, context.getString(i2), NinePatchUtils.GuideArrowPosition.LEFT, true, 0, "sign_feed_set_guide_update_hand.png", 18, 30, 0);
            feedGuidePop.setOffsetX(FeedMethods.c(-10));
            feedGuidePop.setHorizonTriangleMargin(FeedMethods.c(22));
            View view = baseViewHolder.getView(R.id.header_view);
            if (view != null) {
                FeedGuidePop.t.a(feedGuidePop, new SimpleCallback(), view, 0L);
            }
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_PHOTO_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.feed_uid, q(), bluedIngSelfFeed.is_new_face == 1, bluedIngSelfFeed.strong_insert_data, bluedIngSelfFeed.is_bubble_tt_click == 1, false);
        }
        this.O = 0L;
    }

    public void b(String str) {
        if (this.mData == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (BluedIngSelfFeed bluedIngSelfFeed : this.mData) {
            if (CircleMethods.a(bluedIngSelfFeed) && str.equals(bluedIngSelfFeed.feed_id)) {
                this.mData.remove(bluedIngSelfFeed);
                notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(String str, int i) {
        if (TextUtils.isEmpty(str) || this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mData.size()) {
                return;
            }
            if (((BluedIngSelfFeed) this.mData.get(i3)).isFeed() && str.equals(((BluedIngSelfFeed) this.mData.get(i3)).feed_id)) {
                ((BluedIngSelfFeed) this.mData.get(i3)).reading_scope = i;
                notifyDataSetChanged();
                return;
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(String str, String str2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return;
            }
            if (((BluedIngSelfFeed) this.mData.get(i2)).isFeed() && !TextUtils.isEmpty(((BluedIngSelfFeed) this.mData.get(i2)).feed_uid) && ((BluedIngSelfFeed) this.mData.get(i2)).feed_uid.equals(str)) {
                ((BluedIngSelfFeed) this.mData.get(i2)).relationship = str2;
                int headerLayoutCount = getHeaderLayoutCount() + i2;
                if (headerLayoutCount >= this.E && headerLayoutCount <= this.F) {
                    notifyItemChanged(headerLayoutCount + getHeaderLayoutCount());
                }
            }
            i = i2 + 1;
        }
    }

    public void b(List<BluedIngSelfFeed> list) {
        if (list != null) {
            addData((Collection<? extends BluedIngSelfFeed>) c(list));
        }
    }

    public boolean b(RecyclerView recyclerView, int i) {
        VideoFeedViewHolder videoFeedViewHolder;
        if (recyclerView == null) {
            return false;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return false;
            }
            View childAt = recyclerView.getChildAt(i3);
            if (childAt != null && (childAt.getTag() instanceof VideoFeedViewHolder) && (videoFeedViewHolder = (VideoFeedViewHolder) childAt.getTag()) != null && videoFeedViewHolder.B != null && a(recyclerView, videoFeedViewHolder)) {
                return a(videoFeedViewHolder.B);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindToRecyclerView(RecyclerView recyclerView) {
        super.bindToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                super.onScrollStateChanged(recyclerView2, i);
                FeedListAdapterForRecyclerView.this.a(recyclerView2, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                super.onScrolled(recyclerView2, i, i2);
                FeedListAdapterForRecyclerView.this.a(recyclerView2, i, i2);
            }
        });
    }

    protected BluedIngSelfFeed c(BluedIngSelfFeed bluedIngSelfFeed) {
        BluedIngSelfFeed bluedIngSelfFeed2 = bluedIngSelfFeed;
        if (bluedIngSelfFeed.isRepost()) {
            bluedIngSelfFeed2 = bluedIngSelfFeed.repost;
        }
        return bluedIngSelfFeed2;
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mData != null && this.mData.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mData.size()) {
                    break;
                }
                if (((BluedIngSelfFeed) this.mData.get(i2)).is_ads == 1 || ((BluedIngSelfFeed) this.mData.get(i2)).is_ads == 2) {
                    if (TextUtils.isEmpty(stringBuffer.toString())) {
                        stringBuffer.append(((BluedIngSelfFeed) this.mData.get(i2)).exclude_id);
                    } else {
                        stringBuffer.append("," + ((BluedIngSelfFeed) this.mData.get(i2)).exclude_id);
                    }
                }
                i = i2 + 1;
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(int i) {
        if (i != -1) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mData.size()) {
                    break;
                }
                if (((BluedIngSelfFeed) this.mData.get(i3)).isFeed() && TextUtils.equals(((BluedIngSelfFeed) this.mData.get(i3)).feed_uid, UserInfoUtils.c())) {
                    ((BluedIngSelfFeed) this.mData.get(i3)).theme_id = i;
                }
                i2 = i3 + 1;
            }
        }
        notifyDataSetChanged();
    }

    protected void c(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        if (bluedIngSelfFeed.isShowUrlVisited) {
            return;
        }
        int i2 = this.d;
        if ((i2 == 5 || i2 == 29 || i2 == 30) && this.k >= 0) {
            CommunityServiceManager.d().a(bluedIngSelfFeed.feed_id, this.j, this.k, bluedIngSelfFeed.feed_uid);
        } else {
            CommunityServiceManager.d().a(FeedMethods.b(this.d), bluedIngSelfFeed.feed_id, bluedIngSelfFeed.recommend_text, bluedIngSelfFeed.feed_uid);
        }
        if (bluedIngSelfFeed.show_url != null && bluedIngSelfFeed.show_url.length > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= bluedIngSelfFeed.show_url.length) {
                    break;
                }
                CommunityHttpUtils.a(bluedIngSelfFeed.show_url[i4]);
                i3 = i4 + 1;
            }
        }
        bluedIngSelfFeed.isShowUrlVisited = true;
        EventTrackFeed.a(FeedProtos.Event.FEED_AD_SHOW, bluedIngSelfFeed, this.d, i, false, this.o, f(i) - 1);
    }

    protected void c(final BaseViewHolder baseViewHolder, final BluedIngSelfFeed bluedIngSelfFeed, final int i) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        FeedHttpUtils.i(new BluedUIHttpResponse<BluedEntityA<String>>(this.f19618c) { // from class: com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView.12
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<String> bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                bluedIngSelfFeed.is_bubble_tt_click = 1;
                FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = FeedListAdapterForRecyclerView.this;
                feedListAdapterForRecyclerView.notifyItemChanged(i + feedListAdapterForRecyclerView.getHeaderLayoutCount());
                View view = baseViewHolder.getView(R.id.item_feed_sign_say_hi_btn);
                if (CommunityServiceManager.a().N() && view != null && !TypeUtils.a((List<?>) CommunityServiceManager.a().O())) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    CommRouteUtil.a(FeedListAdapterForRecyclerView.this.b, bluedIngSelfFeed, iArr);
                }
                if (FeedListAdapterForRecyclerView.this.b == null || !(FeedListAdapterForRecyclerView.this.b instanceof SignFeedListFragment)) {
                    return;
                }
                ((SignFeedListFragment) FeedListAdapterForRecyclerView.this.b).D();
            }
        }, bluedIngSelfFeed.feed_id, this.f19618c);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(String str) {
        if (TextUtils.isEmpty(str) || this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return;
            }
            if (((BluedIngSelfFeed) this.mData.get(i2)).isFeed() && str.equals(((BluedIngSelfFeed) this.mData.get(i2)).feed_id)) {
                int i3 = ((BluedIngSelfFeed) this.mData.get(i2)).repost_count - 1;
                ((BluedIngSelfFeed) this.mData.get(i2)).repost_count = i3 < 0 ? 0 : i3;
                notifyDataSetChanged();
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(String str, int i) {
        int i2;
        if (TextUtils.isEmpty(str) || this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mData.size()) {
                return;
            }
            if (((BluedIngSelfFeed) this.mData.get(i4)).isFeed() && str.equals(((BluedIngSelfFeed) this.mData.get(i4)).feed_id)) {
                if (i == 0 || i == 1) {
                    ((BluedIngSelfFeed) this.mData.get(i4)).iliked = i;
                    try {
                        int i5 = ((BluedIngSelfFeed) this.mData.get(i4)).feed_dig;
                        if (i == 1) {
                            int i6 = i5 + 1;
                            if (this.i) {
                                ((BluedIngSelfFeed) this.mData.get(i4)).isPlayLikeAnim = true;
                                this.i = false;
                            } else if (this.b != null && (this.b instanceof RecommendFeedFragment)) {
                                ((RecommendFeedFragment) this.b).e();
                            }
                            i2 = i6;
                            if (((BluedIngSelfFeed) this.mData.get(i4)).is_expression == 1) {
                                ((BluedIngSelfFeed) this.mData.get(i4)).interaction_count++;
                                i2 = i6;
                            }
                        } else {
                            int i7 = i5 - 1;
                            i2 = i7;
                            if (((BluedIngSelfFeed) this.mData.get(i4)).is_expression == 1) {
                                ((BluedIngSelfFeed) this.mData.get(i4)).interaction_count = Math.max(((BluedIngSelfFeed) this.mData.get(i4)).interaction_count - 1, 0);
                                i2 = i7;
                            }
                        }
                        if (i2 < 0) {
                            i2 = 0;
                        }
                    } catch (Exception e) {
                        i2 = 0;
                    }
                    ((BluedIngSelfFeed) this.mData.get(i4)).feed_dig = i2;
                }
                notifyDataSetChanged();
                return;
            }
            i3 = i4 + 1;
        }
    }

    protected String d(BluedIngSelfFeed bluedIngSelfFeed) {
        return c(bluedIngSelfFeed).join_circle_pic;
    }

    public void d() {
        if (this.G != null && !NetworkUtils.a()) {
            this.G.f();
        }
        s();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void d(int i) {
        if (i != -1) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mData.size()) {
                    break;
                }
                if (((BluedIngSelfFeed) this.mData.get(i3)).isFeed() && TextUtils.equals(((BluedIngSelfFeed) this.mData.get(i3)).feed_uid, UserInfoUtils.c())) {
                    ((BluedIngSelfFeed) this.mData.get(i3)).theme_pendant = i;
                }
                i2 = i3 + 1;
            }
        }
        notifyDataSetChanged();
    }

    protected void d(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        if (bluedIngSelfFeed.isShowUrlVisited) {
            return;
        }
        bluedIngSelfFeed.isShowUrlVisited = true;
        EventTrackFeed.a(FeedProtos.Event.CITY_AD_SHOW, bluedIngSelfFeed, this.d, i, false, this.o, f(i) - 1);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void d(String str, int i) {
        if (!g() || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mData.size()) {
                notifyDataSetChanged();
                return;
            }
            if (TextUtils.equals(str, ((BluedIngSelfFeed) this.mData.get(i3)).feed_id)) {
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) this.mData.get(i3);
                bluedIngSelfFeed.feed_views = i;
                if (i == 1) {
                    this.mData.remove(bluedIngSelfFeed);
                    this.mData.add(0, bluedIngSelfFeed);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= this.mData.size()) {
                            break;
                        } else if (TimeAndDateUtils.c(((BluedIngSelfFeed) this.mData.get(i5)).feed_timestamp) < TimeAndDateUtils.c(bluedIngSelfFeed.feed_timestamp)) {
                            this.mData.remove(bluedIngSelfFeed);
                            this.mData.add(i5, bluedIngSelfFeed);
                            break;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                }
            } else {
                ((BluedIngSelfFeed) this.mData.get(i3)).feed_views = 0;
            }
            i2 = i3 + 1;
        }
    }

    protected boolean d(String str) {
        return TextUtils.equals(UserInfoUtils.c(), str);
    }

    public void e() {
        PLVideoPageView pLVideoPageView = this.G;
        if (pLVideoPageView != null && pLVideoPageView.a()) {
            this.G.g();
        }
        FeedHorizontalRecommendAdapter feedHorizontalRecommendAdapter = this.x;
        if (feedHorizontalRecommendAdapter != null) {
            feedHorizontalRecommendAdapter.a();
        }
    }

    public void e(int i) {
        LogUtils.c("推荐下滑 点赞后设置推荐提示条与骨架屏占位动画， position:" + i);
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        bluedIngSelfFeed.feed_type = 31;
        bluedIngSelfFeed.playAnimType = 7;
        int i2 = i + 1;
        int i3 = i2;
        while (true) {
            int i4 = i3;
            if (i4 >= getData().size()) {
                break;
            }
            ((BluedIngSelfFeed) getData().get(i4)).isAfterRecommendRefreshGuide = true;
            i3 = i4 + 1;
        }
        BaseFragment baseFragment = this.b;
        if (baseFragment != null && (baseFragment instanceof RecommendFeedFragment)) {
            ((RecommendFeedFragment) baseFragment).b = true;
        }
        getData().add(i2, bluedIngSelfFeed);
        notifyDataSetChanged();
    }

    public void e(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        if (bluedIngSelfFeed.isShowUrlVisited) {
            return;
        }
        CommunityHttpUtils.a(bluedIngSelfFeed.show_url);
        EventTrackFeed.a(FeedProtos.Event.CITY_ACTIVITY_SHOW, bluedIngSelfFeed.activity_id, i, bluedIngSelfFeed.strong_insert_data, "", bluedIngSelfFeed, this.d, this.o);
        bluedIngSelfFeed.isShowUrlVisited = true;
    }

    protected boolean e(BluedIngSelfFeed bluedIngSelfFeed) {
        return c(bluedIngSelfFeed).is_join_circle == 1;
    }

    public int f(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 > i) {
                return i4;
            }
            int i5 = i4;
            if (this.mData.size() > i2) {
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) this.mData.get(i2);
                if (bluedIngSelfFeed.getItemType() != 5) {
                    i5 = i4;
                    if (bluedIngSelfFeed.getItemType() != 21) {
                    }
                }
                i5 = i4 + 1;
            }
            i2++;
            i3 = i5;
        }
    }

    protected void f() {
        if (this.p < 0 || this.r < 0 || this.M != 0) {
            return;
        }
        int i = this.d;
        if ((i != 4 && i != 19) || !CommunityPreferences.f(false)) {
            return;
        }
        int i2 = this.p;
        while (true) {
            int i3 = i2;
            if (i3 >= Math.min(this.r, getData().size())) {
                return;
            }
            BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) getData().get(i3);
            if (bluedIngSelfFeed != null && !d(bluedIngSelfFeed.feed_uid) && bluedIngSelfFeed.is_bubble_ticktock == 1 && bluedIngSelfFeed.is_bubble_tt_click == 0) {
                if (bluedIngSelfFeed.signStateList != null) {
                    bluedIngSelfFeed.playAnimType = 3;
                } else {
                    bluedIngSelfFeed.playAnimType = 2;
                }
                notifyItemChanged(getHeaderLayoutCount() + i3);
                CommunityPreferences.g(false);
                LogUtils.c("judgeSignFeedGuidePop: " + bluedIngSelfFeed.playAnimType + " at position:" + (i3 + getHeaderLayoutCount()));
                return;
            }
            i2 = i3 + 1;
        }
    }

    protected void f(BluedIngSelfFeed bluedIngSelfFeed) {
        CircleConstants.CIRCLE_FROM_PAGE circle_from_page = null;
        if (!e(bluedIngSelfFeed)) {
            CircleDetailsFragment.a(this.f19617a, c(bluedIngSelfFeed).join_circle_id, (CircleConstants.CIRCLE_FROM_PAGE) null);
            return;
        }
        int i = this.d;
        if (i == 0) {
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_FEED_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.join_circle_id + "", FeedProtos.FeedPage.PLAZA_FOLLOW);
        } else if (i == 1) {
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_FEED_CLICK, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.join_circle_id + "", FeedProtos.FeedPage.PERSONAL_FEED);
        }
        if (k()) {
            circle_from_page = CircleConstants.CIRCLE_FROM_PAGE.CITY_JOIN_CIRCLE_FEED;
        } else if (i()) {
            circle_from_page = CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_JOIN_CIRCLE_FEED;
        } else if (j()) {
            circle_from_page = CircleConstants.CIRCLE_FROM_PAGE.HOT_JOIN_CIRCLE_FEED;
        } else if (g()) {
            circle_from_page = CircleConstants.CIRCLE_FROM_PAGE.USER_INFO_JOIN_CIRCLE_FEED;
        }
        CircleDetailsFragment.a(this.f19617a, c(bluedIngSelfFeed).join_circle_id, circle_from_page);
    }

    protected void f(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        if (bluedIngSelfFeed == null || bluedIngSelfFeed.isShowUrlVisited) {
            return;
        }
        EventTrackFeed.a(EventTrackFeed.a(FeedProtos.Event.CITY_LIVE_USER_SHOW, bluedIngSelfFeed, this.d, i, this.o).setTargetUid(EventTrackFeed.a(bluedIngSelfFeed.uid)));
        ByteDanceEvent.a(FeedProtos.Event.CITY_LIVE_USER_SHOW.name(), EventTrackFeed.d(this.d));
        bluedIngSelfFeed.isShowUrlVisited = true;
    }

    protected String g(BluedIngSelfFeed bluedIngSelfFeed) {
        FeedConstants.b = EventTrackFeed.b(this.d);
        if (bluedIngSelfFeed.isRepost() && bluedIngSelfFeed.repost.is_share_super_topics == 1) {
            return "https://native.blued.cn?action=topic&id=" + bluedIngSelfFeed.getContentData().share_s_t_did + "&from=feed";
        }
        return "https://native.blued.cn?action=topic&id=" + bluedIngSelfFeed.share_s_t_did + "&from=feed";
    }

    protected void g(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        EventTrackFeed.a(EventTrackFeed.a(FeedProtos.Event.CITY_LIVE_USER_CLICK, bluedIngSelfFeed, this.d, i).setTargetUid(EventTrackFeed.a(bluedIngSelfFeed.uid)));
        ByteDanceEvent.a(FeedProtos.Event.CITY_LIVE_USER_CLICK.name(), EventTrackFeed.d(this.d));
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.name = bluedIngSelfFeed.user_name;
        userBasicModel.uid = bluedIngSelfFeed.feed_uid;
        userBasicModel.avatar = bluedIngSelfFeed.user_avatar;
        userBasicModel.is_vip_annual = bluedIngSelfFeed.is_vip_annual;
        userBasicModel.is_show_vip_page = bluedIngSelfFeed.is_show_vip_page;
        CommunityServiceManager.b().a(this.f19617a, userBasicModel, CommonStringUtils.c(bluedIngSelfFeed.lid));
    }

    protected boolean g() {
        return this.d == 1;
    }

    protected String h(BluedIngSelfFeed bluedIngSelfFeed) {
        return bluedIngSelfFeed.feed_type == 23 ? c(bluedIngSelfFeed).activity_pic : c(bluedIngSelfFeed).share_activity_pic;
    }

    protected boolean h() {
        return this.d == 0;
    }

    protected String i(BluedIngSelfFeed bluedIngSelfFeed) {
        return bluedIngSelfFeed.feed_type == 23 ? c(bluedIngSelfFeed).activity_name : c(bluedIngSelfFeed).share_activity_title;
    }

    protected boolean i() {
        return this.d == 6;
    }

    protected boolean j() {
        return this.d == 18;
    }

    protected boolean k() {
        int i = this.d;
        return i == 4 || i == 19;
    }

    protected boolean l() {
        return this.d == 23;
    }

    protected boolean m() {
        return this.d == 24;
    }

    protected boolean n() {
        int i = this.d;
        return i == 0 || i == 6 || i == 18 || i == 10 || i == 4 || i == 19 || i == 14;
    }

    protected boolean o() {
        return k() || i() || h();
    }

    public void p() {
        NativeListHelper nativeListHelper = this.H;
        if (nativeListHelper != null) {
            nativeListHelper.a();
        }
    }

    protected FeedProtos.FeedPage q() {
        int i = this.d;
        return (i == 11 || i == 1) ? FeedProtos.FeedPage.PERSONAL_FEED : i == 0 ? FeedProtos.FeedPage.PLAZA_FOLLOW : i == 26 ? FeedProtos.FeedPage.PUNCH_FEED_ALL : i == 19 ? FeedProtos.FeedPage.CITY_TIME : FeedProtos.FeedPage.PLAZA_NEARBY;
    }

    protected void r() {
        int i = this.p;
        if (i < 0 || this.r < 0 || this.M != 0) {
            return;
        }
        while (i < Math.min(this.r, getData().size())) {
            BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) getData().get(i);
            if (bluedIngSelfFeed != null && bluedIngSelfFeed.is_expression == 1 && bluedIngSelfFeed.expression_id < 1) {
                bluedIngSelfFeed.playAnimType = 1;
                notifyItemChanged(i + getHeaderLayoutCount());
                return;
            }
            i++;
        }
    }

    public void s() {
        if (this.K && this.d == 4 && CommunityPreferences.X() < 2 && FeedConstants.f19822c == 1) {
            this.P = SystemClock.elapsedRealtime();
            FeedConstants.f19822c = 0;
            u();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<BluedIngSelfFeed> list) {
        this.l = true;
        this.C.clear();
        if (this.mData == null || this.mData.size() <= 0) {
            this.mData = new ArrayList();
        } else {
            this.mData.clear();
        }
        if (list != null) {
            this.mData.addAll(a((Collection<? extends BluedIngSelfFeed>) list));
        }
        notifyDataSetChanged();
    }
}
