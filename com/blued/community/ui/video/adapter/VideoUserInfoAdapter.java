package com.blued.community.ui.video.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.location.CoordinateConverter;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.square.fragment.HotFeedFragment;
import com.blued.community.ui.video.fragment.MusicVideoCollectFragment;
import com.blued.community.ui.video.fragment.VideoUserInfoFragment;
import com.blued.community.ui.video.manager.UserInfoVideoDataManager;
import com.blued.community.utils.CommunityShareUtils;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.view.EllipSizeText;
import com.blued.community.view.VideoLoadingView;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/VideoUserInfoAdapter.class */
public class VideoUserInfoAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    PagerSnapHelper f6738a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public int f6739c;
    private Context e;
    private IRequestHost f;
    private RecyclerView h;
    private VideoUserInfoFragment j;
    private PageChangeListener k;
    private View l;
    private GestureDetector m;
    private boolean n;
    private int o;
    private boolean p;
    private List<BluedIngSelfFeed> g = new ArrayList();
    private boolean i = false;
    private boolean q = false;
    private final SimpleDateFormat r = new SimpleDateFormat("mm:ss");
    RecyclerView.OnScrollListener d = new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            VideoUserInfoAdapter.this.p = true;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                boolean f = UserInfoVideoDataManager.a().f();
                if (!f) {
                    Logger.b("VideoScanAdapter", new Object[]{"no more data"});
                    return;
                } else if ((layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() > VideoUserInfoAdapter.this.g.size() - 5 && f) {
                    Logger.b("VideoScanAdapter", new Object[]{"get more data check"});
                    if (UserInfoVideoDataManager.a().e()) {
                        Logger.b("VideoScanAdapter", new Object[]{"get more data"});
                        Log.v("drb", "满足列表下载条件");
                        CommunityServiceManager.d().a(1, 1);
                        UserInfoVideoDataManager.a().b((IRequestHost) VideoUserInfoAdapter.this.j.getFragmentActive());
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            VideoUserInfoAdapter.this.p = false;
            if (layoutManager == null) {
                return;
            }
            View findSnapView = VideoUserInfoAdapter.this.f6738a.findSnapView(layoutManager);
            if (VideoUserInfoAdapter.this.l == null) {
                VideoUserInfoAdapter.this.l = findSnapView;
            }
            if (VideoUserInfoAdapter.this.l == null || findSnapView == null) {
                return;
            }
            ViewHolder viewHolder = (ViewHolder) VideoUserInfoAdapter.this.h.getChildViewHolder(VideoUserInfoAdapter.this.l);
            ViewHolder viewHolder2 = (ViewHolder) VideoUserInfoAdapter.this.h.getChildViewHolder(findSnapView);
            PLVideoPageView pLVideoPageView = viewHolder.f;
            PLVideoPageView pLVideoPageView2 = viewHolder2.f;
            if (TextUtils.equals(pLVideoPageView.getVideoUrl(), pLVideoPageView2.getVideoUrl()) && VideoUserInfoAdapter.this.l == findSnapView) {
                return;
            }
            Logger.b("VideoScanAdapter", new Object[]{"onPageChange"});
            CommunityServiceManager.d().a("shine_video_detail_show");
            pLVideoPageView.j();
            viewHolder.G.setVisibility(8);
            VideoUserInfoAdapter.this.b = false;
            VideoUserInfoAdapter.this.l = findSnapView;
            VideoUserInfoAdapter.this.o = ((Integer) pLVideoPageView2.getTag(R.id.position)).intValue();
            UserInfoVideoDataManager.a().a(VideoUserInfoAdapter.this.o);
            pLVideoPageView2.setOnPLVideoListener(viewHolder2);
            pLVideoPageView2.c();
            if (VideoUserInfoAdapter.this.k != null) {
                VideoUserInfoAdapter.this.k.a(pLVideoPageView2);
            }
        }
    };

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/VideoUserInfoAdapter$PageChangeListener.class */
    public interface PageChangeListener {
        void a(PLVideoPageView pLVideoPageView);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/VideoUserInfoAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PLVideoPageView.OnPLVideoListener {
        private View A;
        private View B;
        private View C;
        private View D;
        private View E;
        private View F;
        private View G;
        private View H;
        private LinearLayout I;
        private TextView J;
        private FrameLayout K;
        private FrameLayout L;
        private ImageView M;
        private ImageView N;
        private ImageView O;
        private ShapeLinearLayout P;
        private LoadOptions Q;
        private boolean R;
        private VideoLoadingView S;
        private View T;
        private TextView U;
        private TextView V;
        private SeekBar W;
        private long X;
        private BluedIngSelfFeed Y;
        private View.OnClickListener Z;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f6743a;
        private long aa;
        Runnable b;

        /* renamed from: c  reason: collision with root package name */
        SeekBar.OnSeekBarChangeListener f6744c;
        private final View e;
        private final PLVideoPageView f;
        private ImageView g;
        private ImageView h;
        private ImageView i;
        private TextView j;
        private TextView k;
        private TextView l;
        private TextView m;
        private TextView n;
        private TextView o;
        private TextView p;
        private TextView q;
        private TextView r;
        private EllipSizeText s;
        private ImageView t;
        private ImageView u;
        private ImageView v;
        private ImageView w;
        private ImageView x;
        private ImageView y;
        private ImageView z;

        public ViewHolder(View view) {
            super(view);
            this.X = 0L;
            this.Y = new BluedIngSelfFeed();
            this.Z = new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (ViewHolder.this.f.getTotalTime() <= 60000) {
                        return;
                    }
                    AppInfo.n().removeCallbacks(ViewHolder.this.b);
                    if (ViewHolder.this.f.a()) {
                        ViewHolder.this.U.setVisibility(8);
                        ViewHolder.this.V.setVisibility(8);
                        ViewHolder.this.W.setThumb(null);
                        ViewHolder.this.W.setOnSeekBarChangeListener(null);
                        return;
                    }
                    ViewHolder.this.U.setVisibility(0);
                    ViewHolder.this.V.setVisibility(0);
                    ViewHolder.this.W.setThumb(VideoUserInfoAdapter.this.e.getResources().getDrawable(R.drawable.shape_video_oval_anim));
                    ViewHolder.this.W.setThumbOffset(0);
                    ViewHolder.this.W.setOnSeekBarChangeListener(ViewHolder.this.f6744c);
                    if (ViewHolder.this.W.getThumb() instanceof AnimationDrawable) {
                        ((AnimationDrawable) ViewHolder.this.W.getThumb()).start();
                    }
                    ViewHolder.this.f();
                }
            };
            this.aa = -1L;
            this.b = new Runnable() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.4
                @Override // java.lang.Runnable
                public void run() {
                    ViewHolder.this.U.setVisibility(8);
                    ViewHolder.this.V.setVisibility(8);
                    ViewHolder.this.W.setThumb(null);
                    ViewHolder.this.W.setOnSeekBarChangeListener(null);
                }
            };
            this.f6744c = new SeekBar.OnSeekBarChangeListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.5
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (z) {
                        ViewHolder.this.c(seekBar.getProgress());
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                    Logger.c("VideoScanAdapter", new Object[]{"onStartTrackingTouch"});
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                    Tracker.onStopTrackingTouch(seekBar);
                    Logger.c("VideoScanAdapter", new Object[]{"onStopTrackingTouch"});
                    ViewHolder.this.d(seekBar.getProgress());
                }
            };
            this.e = view;
            this.f = view.findViewById(R.id.video_view);
            this.t = (ImageView) view.findViewById(R.id.img_verify);
            this.v = (ImageView) view.findViewById(R.id.img_back);
            this.w = (ImageView) view.findViewById(R.id.img_share_vr);
            this.F = view.findViewById(R.id.lay_title_space);
            this.g = (ImageView) view.findViewById(R.id.header_view);
            this.h = (ImageView) view.findViewById(R.id.img_living);
            this.i = (ImageView) view.findViewById(R.id.img_living_anim);
            this.j = (TextView) view.findViewById(R.id.tv_name);
            this.s = (EllipSizeText) view.findViewById(R.id.tv_des);
            this.k = (TextView) view.findViewById(R.id.tv_select);
            this.l = (TextView) view.findViewById(R.id.tv_long_video);
            this.p = (TextView) view.findViewById(R.id.tv_location);
            this.y = (ImageView) view.findViewById(R.id.img_location);
            this.r = (TextView) view.findViewById(R.id.tv_user_kol);
            this.f6743a = (ImageView) view.findViewById(R.id.video_animation);
            this.m = (TextView) view.findViewById(R.id.tv_like_num);
            this.n = (TextView) view.findViewById(R.id.tv_comment_num);
            this.o = (TextView) view.findViewById(R.id.tv_forward_num);
            this.u = (ImageView) view.findViewById(R.id.img_like);
            this.A = view.findViewById(R.id.lay_like);
            this.B = view.findViewById(R.id.lay_comment);
            this.C = view.findViewById(R.id.lay_forward);
            this.D = view.findViewById(R.id.lay_more);
            this.E = view.findViewById(R.id.lay_location);
            this.q = (TextView) view.findViewById(R.id.tv_comment);
            ImageView imageView = (ImageView) view.findViewById(R.id.img_attention_view);
            this.x = imageView;
            imageView.setOnClickListener(this);
            this.z = (ImageView) view.findViewById(R.id.img_vip_icon);
            this.H = view.findViewById(R.id.lay_no_interesting);
            this.G = view.findViewById(R.id.lay_no_interesting_bg);
            this.S = (VideoLoadingView) view.findViewById(R.id.loading_view);
            this.T = view.findViewById(R.id.seek_lay);
            this.U = (TextView) view.findViewById(R.id.tv_seek_cur);
            this.V = (TextView) view.findViewById(R.id.tv_seek_total);
            this.W = (SeekBar) view.findViewById(R.id.seek_bar_view);
            this.U.setVisibility(8);
            this.V.setVisibility(8);
            this.W.setMax(1000);
            this.W.setPadding(0, 0, 0, 0);
            this.W.setThumb(null);
            this.P = view.findViewById(R.id.sll_top_hot);
            int a2 = StatusBarHelper.a(VideoUserInfoAdapter.this.e);
            this.v.setOnClickListener(this);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.v.getLayoutParams();
            layoutParams.topMargin += a2;
            this.v.setLayoutParams(layoutParams);
            this.w.setOnClickListener(this);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.w.getLayoutParams();
            layoutParams2.topMargin = a2 + layoutParams2.topMargin;
            this.w.setLayoutParams(layoutParams2);
            this.A.setOnClickListener(this);
            this.B.setOnClickListener(this);
            this.C.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.G.setOnClickListener(this);
            this.H.setOnClickListener(this);
            LoadOptions loadOptions = new LoadOptions();
            this.Q = loadOptions;
            loadOptions.b = R.drawable.user_bg_round;
            this.Q.d = R.drawable.user_bg_round;
            this.f.setOnPLVideoListener(this);
            this.I = (LinearLayout) view.findViewById(R.id.lay_music);
            this.J = (TextView) view.findViewById(R.id.tv_music);
            this.K = (FrameLayout) view.findViewById(R.id.lay_music_cd);
            this.L = (FrameLayout) view.findViewById(R.id.lay_music_cd_anim);
            this.M = (ImageView) view.findViewById(R.id.img_music_cd);
            this.N = (ImageView) view.findViewById(R.id.img_music_cd_pic);
            this.O = (ImageView) view.findViewById(R.id.img_music_anim);
            this.I.setOnClickListener(this);
            this.K.setOnClickListener(this);
        }

        private void a(TextView textView, String str) {
            StringUtils.a(textView, str, 1, "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            EventTrackFeed.a(this.Y, 8, false);
            if (UserInfoHelper.a(this.Y.relationship)) {
                return;
            }
            if (this.Y.iliked == 0) {
                this.Y.iliked = 1;
                this.u.setImageResource(R.drawable.show_video_liked);
                CommunityServiceManager.d().a(5, this.Y, "", -1);
                i();
                g();
            } else if (!z) {
                g();
            } else {
                this.Y.iliked = 0;
                this.u.setImageResource(R.drawable.show_video_unlike);
                j();
            }
        }

        private void c(BluedIngSelfFeed bluedIngSelfFeed) {
            if (bluedIngSelfFeed == null) {
                return;
            }
            ImageLoader.a(VideoUserInfoAdapter.this.j == null ? null : VideoUserInfoAdapter.this.j.getFragmentActive(), bluedIngSelfFeed.user_avatar).b(R.drawable.user_bg_round).c().a(this.g);
            UserInfoHelper.a(this.t, bluedIngSelfFeed.vbadge, 3);
            if (bluedIngSelfFeed.live > 0) {
                this.t.setVisibility(8);
                this.h.setVisibility(0);
                this.i.setVisibility(0);
                Animation loadAnimation = AnimationUtils.loadAnimation(VideoUserInfoAdapter.this.e, R.anim.anim_feed_list_living);
                loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                this.i.startAnimation(loadAnimation);
            } else {
                this.h.setVisibility(8);
                this.i.setVisibility(8);
                this.i.clearAnimation();
            }
            this.j.setText(bluedIngSelfFeed.user_name);
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = bluedIngSelfFeed.vip_grade;
            userBasicModel.is_vip_annual = bluedIngSelfFeed.is_vip_annual;
            userBasicModel.is_hide_vip_look = bluedIngSelfFeed.is_hide_vip_look;
            userBasicModel.vip_exp_lvl = bluedIngSelfFeed.vip_exp_lvl;
            UserInfoHelper.a(VideoUserInfoAdapter.this.e, this.j, userBasicModel, R.color.nafio_b);
            UserInfoHelper.a(this.z, userBasicModel);
            if (TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
                this.s.setVisibility(8);
            } else {
                a(this.s, bluedIngSelfFeed.feed_content);
                this.s.setVisibility(0);
            }
            this.m.setText(DistanceUtils.a(VideoUserInfoAdapter.this.e, Integer.toString(bluedIngSelfFeed.feed_dig)));
            this.n.setText(DistanceUtils.a(VideoUserInfoAdapter.this.e, Integer.toString(bluedIngSelfFeed.feed_comment)));
            this.o.setText(DistanceUtils.a(VideoUserInfoAdapter.this.e, Integer.toString(bluedIngSelfFeed.repost_count)));
            if ("1".equalsIgnoreCase(bluedIngSelfFeed.relationship) || "3".equalsIgnoreCase(bluedIngSelfFeed.relationship) || TextUtils.equals(UserInfoUtils.c(), bluedIngSelfFeed.feed_uid)) {
                this.x.setVisibility(8);
            } else {
                this.x.setImageResource(R.drawable.show_video_attention);
                this.x.setVisibility(0);
            }
            if (bluedIngSelfFeed.iliked == 0) {
                this.u.setImageResource(R.drawable.show_video_unlike);
            } else {
                this.u.setImageResource(R.drawable.show_video_liked);
            }
            if (TextUtils.isEmpty(bluedIngSelfFeed.kol_name)) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                this.r.setText(bluedIngSelfFeed.kol_name);
            }
            if (TextUtils.isEmpty(bluedIngSelfFeed.location)) {
                this.E.setVisibility(8);
            } else {
                this.p.setText(bluedIngSelfFeed.location);
                this.E.setVisibility(0);
            }
            if (b(bluedIngSelfFeed)) {
                this.y.setImageResource(R.drawable.show_video_location);
            } else {
                this.y.setImageResource(R.drawable.show_video_location_gary);
            }
            if (!d(bluedIngSelfFeed)) {
                this.I.setVisibility(8);
                this.K.setVisibility(8);
                return;
            }
            this.I.setVisibility(0);
            this.K.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            if (bluedIngSelfFeed.music.music_name != null) {
                sb.append(bluedIngSelfFeed.music.music_name);
                for (int i = 0; i < 10; i++) {
                    sb.append(" ");
                    sb.append(bluedIngSelfFeed.music.music_name);
                }
            }
            this.J.setText(sb.toString());
            ImageLoader.a(VideoUserInfoAdapter.this.j == null ? null : VideoUserInfoAdapter.this.j.getFragmentActive(), AvatarUtils.a(1, bluedIngSelfFeed.music.music_cover)).b(R.drawable.user_bg_round).c().a(this.N);
        }

        private boolean d(BluedIngSelfFeed bluedIngSelfFeed) {
            return (bluedIngSelfFeed == null || bluedIngSelfFeed.music == null || TextUtils.isEmpty(bluedIngSelfFeed.music.music_id) || Long.valueOf(bluedIngSelfFeed.music.music_id).longValue() <= 0 || TextUtils.isEmpty(bluedIngSelfFeed.music.music_name)) ? false : true;
        }

        private void e() {
            if (this.S.getVisibility() == 0) {
                return;
            }
            this.T.setVisibility(4);
            this.S.setVisibility(0);
            this.S.startAnim();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            this.W.setProgress(this.W.getProgress());
            if (this.T.getVisibility() == 0) {
                return;
            }
            this.T.setVisibility(0);
            this.S.cancelAnim();
            this.S.setVisibility(4);
            VideoUserInfoAdapter.this.q = false;
        }

        private void g() {
            this.f6743a.setVisibility(0);
            ImageLoader.c(VideoUserInfoAdapter.this.f, "video_like.png").e(VideoUserInfoAdapter.this.f6738a.hashCode()).g(1).a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.6
                public void a() {
                }

                public void b() {
                    ViewHolder.this.f6743a.setVisibility(8);
                }
            }).a(this.f6743a);
        }

        private void h() {
            CommunityServiceManager.d().a("shine_video_feed_detail_btn_click");
            if (UserInfoHelper.a(this.Y.relationship)) {
                return;
            }
            if (!this.R) {
                this.R = true;
                LogData logData = new LogData();
                logData.logService = "recommend_to_detail";
                logData.id = this.Y.feed_id;
                logData.type = this.Y.recommend_text;
                logData.url = this.Y.recommend_type;
                CommunityServiceManager.d().a(logData);
                FeedDetailsFragment.a(VideoUserInfoAdapter.this.e, this.Y, 8, new FeedDetailParams(7));
            }
            this.e.postDelayed(new Runnable() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.7
                @Override // java.lang.Runnable
                public void run() {
                    ViewHolder.this.R = false;
                }
            }, 500L);
        }

        private void i() {
            FeedHttpUtils.a(VideoUserInfoAdapter.this.e, new BluedUIHttpResponse<BluedEntity>() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.8
                public void onFailure(Throwable th, int i, String str) {
                    Pair a2 = BluedHttpUtils.a(th, i, str);
                    if (a2 == null || ((Integer) a2.first).intValue() != 404100) {
                        super.onFailure(th, i, str);
                    } else {
                        AppMethods.d(R.string.shine_video_has_delete);
                    }
                }

                public void onUIUpdate(BluedEntity bluedEntity) {
                    ViewHolder.this.Y.iliked = 1;
                    LiveEventBus.get("feed_like_change").post(ViewHolder.this.Y);
                }
            }, UserInfoUtils.c(), this.Y.feed_id, 0, "", VideoUserInfoAdapter.this.j.getFragmentActive());
        }

        private void j() {
            FeedHttpUtils.a(VideoUserInfoAdapter.this.e, new BluedUIHttpResponse<BluedEntity>() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.9
                public void onFailure(Throwable th, int i, String str) {
                    Pair a2 = BluedHttpUtils.a(th, i, str);
                    if (a2 == null || ((Integer) a2.first).intValue() != 404100) {
                        super.onFailure(th, i, str);
                    } else {
                        AppMethods.d(R.string.shine_video_has_delete);
                    }
                }

                public void onUIUpdate(BluedEntity bluedEntity) {
                    ViewHolder.this.Y.iliked = 0;
                    LiveEventBus.get("feed_like_change").post(ViewHolder.this.Y);
                }
            }, UserInfoUtils.c(), this.Y.feed_id, this.Y.is_ads, VideoUserInfoAdapter.this.j.getFragmentActive());
        }

        private void k() {
            synchronized (this) {
                CommunityServiceManager.d().a(1, this.Y.feed_uid);
                CommunityHttpUtils.b(VideoUserInfoAdapter.this.e, new CommunityHttpUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.10
                    public void a() {
                        DialogUtils.a(VideoUserInfoAdapter.this.j.l);
                    }

                    public void a(String str) {
                        if ("1".equalsIgnoreCase(str) || "3".equalsIgnoreCase(str)) {
                            ViewHolder.this.x.setImageResource(R.drawable.show_video_attentioned);
                            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ViewHolder.this.x.setVisibility(8);
                                }
                            }, 1000L);
                        } else {
                            ViewHolder.this.x.setImageResource(R.drawable.show_video_attention);
                        }
                        ViewHolder.this.Y.relationship = str;
                        UserInfoVideoDataManager.a().a(ViewHolder.this.Y.feed_id, ViewHolder.this.Y.relationship);
                    }

                    public void b() {
                        DialogUtils.b(VideoUserInfoAdapter.this.j.l);
                    }

                    public void b(String str) {
                    }

                    public void c() {
                        DialogUtils.b(VideoUserInfoAdapter.this.j.l);
                    }
                }, this.Y.feed_uid, "", VideoUserInfoAdapter.this.j.getFragmentActive());
                FeedProtos.FollowLocation followLocation = FeedProtos.FollowLocation.FOLLOW_PLAZA_FLASH_DETAIL;
                "0".equals(this.Y.relationship);
                EventTrackFeed.a(this.Y.feed_uid, this.Y.feed_id, this.Y.super_did, followLocation, true, this.Y.live > 0, this.Y.in_promotion == 1, this.Y.strong_insert_data);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l() {
            VideoUserInfoAdapter.this.b = true;
            this.G.setVisibility(0);
            this.G.setAlpha(1.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(1000L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.11
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewHolder.this.G.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat.start();
        }

        private void m() {
            CommunityServiceManager.d().c(5, this.Y, "", -1);
            ImageFileLoader.a((IRequestHost) null).b(this.Y.user_avatar).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.12
                public void onUIFinish(File file, Exception exc) {
                    CommunityShareUtils.b().a(VideoUserInfoAdapter.this.e, null, (file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath()), ViewHolder.this.Y, "shine_video_list_detail", false, 5, "", -1, 8);
                }
            }).a();
        }

        public void a() {
            e();
        }

        public void a(int i) {
        }

        public void a(long j, long j2) {
            if (VideoUserInfoAdapter.this.q) {
                return;
            }
            long j3 = j2 > 0 ? (((float) j) / ((float) j2)) * 1000.0f : 0L;
            long j4 = j;
            if (j < 0) {
                j4 = 0;
            }
            if (this.aa == j3) {
                return;
            }
            this.W.setProgress((int) j3);
            this.aa = j3;
            if (this.W.getThumb() instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) this.W.getThumb();
                if (animationDrawable != null && animationDrawable.isRunning()) {
                    animationDrawable.stop();
                }
                VideoLoadingView videoLoadingView = this.S;
                if (videoLoadingView != null && videoLoadingView.getVisibility() == 0) {
                    f();
                }
                this.W.setThumb(VideoUserInfoAdapter.this.e.getResources().getDrawable(R.drawable.shape_video_oval_two_write));
                this.W.setThumbOffset(0);
                this.W.setOnSeekBarChangeListener(this.f6744c);
                Logger.b("xpf", new Object[]{"---------------------"});
            }
            this.U.setText(VideoUserInfoAdapter.this.r.format(new Date(j4)));
            this.V.setText(VideoUserInfoAdapter.this.r.format(new Date(j2)));
            if (j2 <= 60000) {
                this.l.setVisibility(8);
            } else if (this.l.getVisibility() == 8) {
                this.l.setVisibility(0);
                this.l.setText(VideoUserInfoAdapter.this.e.getResources().getString(R.string.short_video_long));
            }
        }

        public void a(long j, long j2, int i) {
            if (this.f.getTotalTime() <= 60000) {
                return;
            }
            VideoUserInfoAdapter.this.q = true;
            AppInfo.n().removeCallbacks(this.b);
            this.U.setText(VideoUserInfoAdapter.this.r.format(new Date(j)));
            this.V.setText(VideoUserInfoAdapter.this.r.format(new Date(j2)));
            if (this.U.getVisibility() != 0) {
                this.U.setVisibility(0);
            }
            if (this.V.getVisibility() != 0) {
                this.V.setVisibility(0);
            }
            if (this.W.getThumb() == null) {
                this.W.setThumb(VideoUserInfoAdapter.this.e.getResources().getDrawable(R.drawable.shape_video_oval_two_write));
                this.W.setThumbOffset(0);
                this.W.setOnSeekBarChangeListener(this.f6744c);
            } else if (this.W.getThumb() instanceof AnimationDrawable) {
                ((AnimationDrawable) this.W.getThumb()).stop();
            }
            this.W.setProgress(i);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed) {
            Logger.b("VideoScanAdapter", new Object[]{"onBindView:", bluedIngSelfFeed.feed_id});
            this.Y.feed_dig = bluedIngSelfFeed.feed_dig;
            this.Y.feed_comment = bluedIngSelfFeed.feed_comment;
            this.Y.repost_count = bluedIngSelfFeed.repost_count;
            this.Y.is_followed = bluedIngSelfFeed.is_followed;
            this.Y.user_avatar = bluedIngSelfFeed.user_avatar;
            this.Y.user_name = bluedIngSelfFeed.user_name;
            this.Y.feed_content = bluedIngSelfFeed.feed_content;
            this.Y.vip_grade = bluedIngSelfFeed.vip_grade;
            this.Y.is_vip_annual = bluedIngSelfFeed.is_vip_annual;
            this.Y.relationship = bluedIngSelfFeed.relationship;
            this.Y.iliked = bluedIngSelfFeed.iliked;
            this.Y.vbadge = bluedIngSelfFeed.vbadge;
            this.Y.location = bluedIngSelfFeed.location;
            this.Y.location_lat = bluedIngSelfFeed.location_lat;
            this.Y.location_lot = bluedIngSelfFeed.location_lot;
            c(this.Y);
        }

        public void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
            if (bluedIngSelfFeed != null) {
                this.Y = bluedIngSelfFeed;
            }
            VideoUserInfoAdapter.this.a(this.Y, this.f, this.Z);
            this.f.setTag(R.id.position, Integer.valueOf(i));
            this.f.setTag(R.id.model, this.Y);
            if (this.Y.feed_videos != null) {
                if (VideoUserInfoAdapter.this.l == null) {
                    if (UserInfoVideoDataManager.a().g() == i) {
                        CommunityServiceManager.d().a("shine_video_detail_show");
                        this.f.c();
                        VideoUserInfoAdapter.this.l = this.e;
                        VideoUserInfoAdapter.this.o = i;
                        if (VideoUserInfoAdapter.this.k != null) {
                            VideoUserInfoAdapter.this.k.a(this.f);
                        }
                        String b = b(i);
                        if (!TextUtils.isEmpty(b)) {
                            Logger.c("pre_video", new Object[]{b});
                            this.f.a(b);
                        }
                    }
                } else if (VideoUserInfoAdapter.this.l == this.e) {
                    this.f.c();
                    if (VideoUserInfoAdapter.this.k != null) {
                        VideoUserInfoAdapter.this.k.a(this.f);
                    }
                }
            }
            c(bluedIngSelfFeed);
            if (this.Y.is_recommend_ticktocks == 0 || TextUtils.isEmpty(this.Y.recommend_text)) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                this.k.setText(this.Y.recommend_text);
            }
            if (this.Y.feed_videos_duration * 1000.0d > 60000.0d) {
                this.l.setVisibility(0);
                this.l.setText(VideoUserInfoAdapter.this.e.getResources().getString(R.string.short_video_long));
            } else {
                this.l.setVisibility(8);
            }
            this.E.setOnClickListener(this);
            this.g.setOnClickListener(this);
            if (StatusBarHelper.a()) {
                this.F.setVisibility(0);
            } else {
                this.F.setVisibility(8);
            }
            if (this.Y.is_top_hot == 1) {
                this.P.setVisibility(0);
                this.P.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        EventTrackFeed.a(FeedProtos.Event.HOT_FEED_ICON_CLICK, ViewHolder.this.Y.feed_id, FeedProtos.FeedPage.FLASH_DETAIL);
                        HotFeedFragment.a.a(VideoUserInfoAdapter.this.e);
                    }
                });
            } else {
                this.P.setVisibility(8);
            }
            if (this.Y.isShowUrlVisited) {
                return;
            }
            CommunityServiceManager.d().a(6, this.Y.feed_id, this.Y.recommend_text, this.Y.feed_uid);
            CommunityHttpUtils.a(this.Y.show_url);
            this.Y.isShowUrlVisited = true;
            EventTrackFeed.a(FeedProtos.Event.FEED_DRAW, this.Y, TextUtils.isEmpty(this.Y.super_did) ? "" : this.Y.super_did, FeedProtos.FeedClass.FEED_VIDEO, FeedProtos.FeedPage.FLASH_DETAIL);
        }

        public String b(int i) {
            BluedIngSelfFeed bluedIngSelfFeed;
            int i2 = i + 1;
            return (i2 >= UserInfoVideoDataManager.a().b().size() || (bluedIngSelfFeed = UserInfoVideoDataManager.a().b().get(i2)) == null || bluedIngSelfFeed.feed_videos == null || bluedIngSelfFeed.feed_videos.length < 2) ? "" : bluedIngSelfFeed.feed_videos[1];
        }

        public void b() {
            f();
        }

        public void b(long j, long j2, int i) {
            if (this.f.getTotalTime() <= 60000) {
                return;
            }
            VideoUserInfoAdapter.this.q = false;
            Logger.b("VideoScanAdapter", new Object[]{"seekTime_________________:", Long.valueOf(j)});
            AppInfo.n().removeCallbacks(this.b);
            this.f.a(j, i, new PLVideoPageView.OnSeekListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.ViewHolder.3
            });
            this.U.setText(VideoUserInfoAdapter.this.r.format(new Date(j)));
            this.V.setText(VideoUserInfoAdapter.this.r.format(new Date(j2)));
            AppInfo.n().postDelayed(this.b, m.ag);
        }

        public boolean b(BluedIngSelfFeed bluedIngSelfFeed) {
            boolean z;
            try {
                z = CoordinateConverter.isAMapDataAvailable(Double.parseDouble(bluedIngSelfFeed.location_lat), Double.parseDouble(bluedIngSelfFeed.location_lot));
            } catch (Exception e) {
                e.printStackTrace();
                z = true;
            }
            return (TextUtils.isEmpty(this.Y.location_lot) || TextUtils.isEmpty(this.Y.location_lat) || !z) ? false : true;
        }

        public void c() {
            if (this.K == null || !d(this.Y)) {
                return;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(VideoUserInfoAdapter.this.e, R.anim.anim_music_cover_rotate_repeat);
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.L.startAnimation(loadAnimation);
            this.O.setVisibility(0);
            ImageLoader.c(VideoUserInfoAdapter.this.f, "video_scan_music_anim.png").g(-1).f().a(this.O);
            this.J.setLines(1);
            this.J.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            this.J.setSingleLine(true);
            this.J.setSelected(true);
            this.J.setFocusable(true);
            this.J.setFocusableInTouchMode(true);
        }

        public void c(int i) {
            long totalTime = this.f.getTotalTime();
            a(((float) totalTime) * (i / 1000.0f), totalTime, i);
        }

        public void d() {
            if (this.K != null) {
                this.L.clearAnimation();
                this.O.setVisibility(8);
                this.J.setEllipsize(null);
                this.J.setFocusable(false);
                this.J.setFocusableInTouchMode(false);
            }
        }

        public void d(int i) {
            long totalTime = this.f.getTotalTime();
            b(((float) totalTime) * (i / 1000.0f), totalTime, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            VideoUserInfoAdapter.this.n = true;
            int id = view.getId();
            if (id == R.id.lay_like) {
                a(true);
            } else if (id == R.id.lay_comment) {
                VideoUserInfoAdapter.this.j.j();
            } else if (id == R.id.lay_forward) {
                m();
            } else if (id == R.id.lay_more) {
                h();
            } else if (id == R.id.img_back) {
                VideoUserInfoAdapter.this.j.h();
            } else {
                if (id == R.id.img_share_vr) {
                    CommunityServiceManager.d().a("feed_post_btn_click", 4);
                    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_FLASH_DETAIL, false, "");
                    FeedAddPostFragment.a(VideoUserInfoAdapter.this.e);
                } else if (id == R.id.tv_comment) {
                    CommunityServiceManager.d().b(5, this.Y, "", -1);
                    VideoUserInfoAdapter.this.j.i();
                } else if (id == R.id.tv_des) {
                    if (!this.s.isAppendEllipSize() || LinkMovementClickMethod.a().b()) {
                        return;
                    }
                    VideoUserInfoAdapter.this.j.k();
                } else if (id == R.id.header_view) {
                    UserBasicModel userBasicModel = new UserBasicModel();
                    userBasicModel.name = this.Y.user_name;
                    userBasicModel.uid = this.Y.feed_uid;
                    userBasicModel.avatar = this.Y.user_avatar;
                    userBasicModel.is_vip_annual = this.Y.is_vip_annual;
                    userBasicModel.is_show_vip_page = this.Y.is_show_vip_page;
                    if (this.Y.live > 0) {
                        CommunityServiceManager.b().a(VideoUserInfoAdapter.this.e, userBasicModel, this.Y.live);
                    } else {
                        CommunityServiceManager.b().a(VideoUserInfoAdapter.this.e, userBasicModel, "shine_video_detail", false, this.g, (LogData) null, MessageProtos.StrangerSource.FIND_PLAZA_FLASH_DETAIL);
                    }
                    LogData logData = new LogData();
                    logData.logService = "shine_video_detail_to_profile";
                    logData.target_uid = this.Y.feed_uid;
                    logData.id = this.Y.feed_id;
                    if (!TextUtils.isEmpty(this.Y.recommend_text)) {
                        logData.db_id = this.Y.recommend_text;
                    }
                    CommunityServiceManager.d().a(logData);
                    EventTrackFeed.c(FeedProtos.Event.FLASH_VIDEO_USER_LIVE_PHOTO_CLICK, this.Y.feed_uid, this.Y.live > 0 ? String.valueOf(this.Y.live) : "");
                } else if (id == R.id.img_attention_view) {
                    k();
                } else if (id == R.id.lay_no_interesting_bg) {
                    this.G.setVisibility(8);
                    VideoUserInfoAdapter.this.b = false;
                } else if (id == R.id.lay_no_interesting) {
                    this.G.setVisibility(8);
                    VideoUserInfoAdapter.this.b = false;
                    if (this.Y.unliked_url != null && this.Y.unliked_url.length > 0) {
                        CommunityHttpUtils.a(this.Y.unliked_url);
                    }
                    UserInfoVideoDataManager.a().c(this.Y);
                } else if (id == R.id.lay_location) {
                    CommunityServiceManager.d().a("shine_video_position_area_click");
                    if (b(this.Y)) {
                        CommunityServiceManager.b().a(VideoUserInfoAdapter.this.e, this.Y.location_lot, this.Y.location_lat, this.Y.location);
                    }
                } else if (id == R.id.lay_music || id == R.id.lay_music_cd) {
                    MusicVideoCollectFragment.a(VideoUserInfoAdapter.this.e, this.Y.music);
                }
            }
        }
    }

    public VideoUserInfoAdapter(Context context, IRequestHost iRequestHost, VideoUserInfoFragment videoUserInfoFragment, RecyclerView recyclerView, int i) {
        this.h = null;
        this.f6738a = null;
        this.e = context;
        this.f = iRequestHost;
        this.f6739c = i;
        this.j = videoUserInfoFragment;
        this.h = recyclerView;
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.f6738a = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this.h);
        f();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedIngSelfFeed bluedIngSelfFeed, PLVideoPageView pLVideoPageView, View.OnClickListener onClickListener) {
        if (bluedIngSelfFeed.is_repost != 1 || bluedIngSelfFeed.repost == null) {
            b(bluedIngSelfFeed, pLVideoPageView, onClickListener);
        } else {
            b(bluedIngSelfFeed.repost, pLVideoPageView, onClickListener);
        }
    }

    private void b(BluedIngSelfFeed bluedIngSelfFeed, PLVideoPageView pLVideoPageView, View.OnClickListener onClickListener) {
        int i;
        int i2;
        if (bluedIngSelfFeed.feed_videos_width == null || bluedIngSelfFeed.feed_videos_width.length <= 0 || bluedIngSelfFeed.feed_videos_height == null || bluedIngSelfFeed.feed_videos_height.length <= 0) {
            i = 0;
            i2 = 0;
        } else {
            i = com.blued.android.framework.utils.StringUtils.a(bluedIngSelfFeed.feed_videos_width[0], 480);
            i2 = com.blued.android.framework.utils.StringUtils.a(bluedIngSelfFeed.feed_videos_height[0], 480);
        }
        float f = 0.0f;
        if (!TextUtils.isEmpty(bluedIngSelfFeed.feed_video_size)) {
            try {
                f = Float.parseFloat(bluedIngSelfFeed.feed_video_size);
            } catch (Exception e) {
                e.printStackTrace();
                f = 0.0f;
            }
        }
        long j = f;
        VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
        videoPlayConfig.i = bluedIngSelfFeed.feed_id;
        if (bluedIngSelfFeed.feed_videos != null && bluedIngSelfFeed.feed_videos.length >= 2) {
            videoPlayConfig.a = bluedIngSelfFeed.feed_videos[0];
            videoPlayConfig.b = bluedIngSelfFeed.feed_videos[1];
        }
        videoPlayConfig.j = true;
        videoPlayConfig.a(i);
        videoPlayConfig.b(i2);
        videoPlayConfig.c = j;
        videoPlayConfig.g = onClickListener;
        videoPlayConfig.k = false;
        pLVideoPageView.b(videoPlayConfig);
    }

    private void f() {
        this.h.addOnScrollListener(this.d);
        this.h.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.1
            @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                return VideoUserInfoAdapter.this.m.onTouchEvent(motionEvent);
            }
        });
        this.m = new GestureDetector(this.e, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.community.ui.video.adapter.VideoUserInfoAdapter.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (VideoUserInfoAdapter.this.l == null || VideoUserInfoAdapter.this.n) {
                    return false;
                }
                ((ViewHolder) VideoUserInfoAdapter.this.h.getChildViewHolder(VideoUserInfoAdapter.this.l)).a(false);
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                VideoUserInfoAdapter.this.n = false;
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                Logger.b("VideoScanAdapter", new Object[]{"onLongPress"});
                if (VideoUserInfoAdapter.this.l != null && !VideoUserInfoAdapter.this.n && !VideoUserInfoAdapter.this.j.n) {
                    ((ViewHolder) VideoUserInfoAdapter.this.h.getChildViewHolder(VideoUserInfoAdapter.this.l)).l();
                }
                super.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                Logger.b("VideoScanAdapter", new Object[]{"onSingleTapConfirmed"});
                if (VideoUserInfoAdapter.this.l == null || VideoUserInfoAdapter.this.n) {
                    return false;
                }
                ((ViewHolder) VideoUserInfoAdapter.this.h.getChildViewHolder(VideoUserInfoAdapter.this.l)).f.d();
                return false;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_turn_item, viewGroup, false));
    }

    public void a() {
        List<BluedIngSelfFeed> b = UserInfoVideoDataManager.a().b();
        if (b == null) {
            return;
        }
        synchronized (this.g) {
            Logger.b("VideoScanAdapter", new Object[]{"setDatas:", Integer.valueOf(b.size())});
            this.g.clear();
            this.g.addAll(b);
            notifyDataSetChanged();
        }
    }

    public void a(int i) {
        View view = this.l;
        if (view != null) {
            ((ViewHolder) this.h.getChildViewHolder(view)).f.setVolumeProgress(i);
        }
    }

    public void a(long j, long j2, int i) {
        View view = this.l;
        if (view != null) {
            ((ViewHolder) this.h.getChildViewHolder(view)).a(j, j2, i);
        }
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        Logger.b("VideoScanAdapter", new Object[]{"updateData:", bluedIngSelfFeed.feed_id});
        View view = this.l;
        if (view != null) {
            ViewHolder viewHolder = (ViewHolder) this.h.getChildViewHolder(view);
            if (TextUtils.equals(bluedIngSelfFeed.feed_id, viewHolder.Y.feed_id)) {
                viewHolder.a(bluedIngSelfFeed);
            }
        }
    }

    public void a(PageChangeListener pageChangeListener) {
        this.k = pageChangeListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int i2 = i;
        if (i >= this.g.size()) {
            i2 = i;
            if (i != 0) {
                i2 = this.g.size() - 1;
            }
        }
        if (this.g.size() == 0) {
            return;
        }
        Logger.b("VideoScanAdapter", new Object[]{"position:", Integer.valueOf(i2)});
        viewHolder.a(this.g.get(i2), i2);
    }

    public void a(List<BluedIngSelfFeed> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this.g) {
            this.g.addAll(list);
            notifyItemInserted(this.g.size());
        }
    }

    public int b() {
        View view = this.l;
        if (view != null) {
            return ((ViewHolder) this.h.getChildViewHolder(view)).W.getProgress();
        }
        return 0;
    }

    public void b(long j, long j2, int i) {
        View view = this.l;
        if (view != null) {
            ((ViewHolder) this.h.getChildViewHolder(view)).b(j, j2, i);
        }
    }

    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        Logger.b("VideoScanAdapter", new Object[]{"removeData:", bluedIngSelfFeed.feed_id});
        a();
    }

    public void c() {
        Logger.b("VideoScanAdapter", new Object[]{"resume"});
        View view = this.l;
        if (view != null) {
            ((ViewHolder) this.h.getChildViewHolder(view)).f.f();
        }
    }

    public void d() {
        Logger.b("VideoScanAdapter", new Object[]{c.cb});
        View view = this.l;
        if (view != null) {
            ((ViewHolder) this.h.getChildViewHolder(view)).f.g();
        }
    }

    public void e() {
        if (this.h == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.getChildCount()) {
                return;
            }
            View childAt = this.h.getChildAt(i2);
            childAt.findViewById(R.id.video_view).h();
            VideoLoadingView videoLoadingView = (VideoLoadingView) childAt.findViewById(R.id.loading_view);
            if (videoLoadingView != null) {
                videoLoadingView.cancelAnim();
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.g.size();
    }
}
