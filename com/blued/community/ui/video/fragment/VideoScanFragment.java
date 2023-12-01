package com.blued.community.ui.video.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.AeroGlassUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.widget.emoji.view.EmoticonsIndicatorView;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.android.module.common.widget.emoticon.ui.IViewStateListener;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedUserInfoModel;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.video.adapter.VideoCommentAdapter;
import com.blued.community.ui.video.adapter.VideoScanAdapter;
import com.blued.community.ui.video.manager.ShineVideoDataManager;
import com.blued.community.ui.video.observer.IFeedDetailContract;
import com.blued.community.ui.video.presenter.FeedDetailOldPresenter;
import com.blued.community.utils.AtChooseUserHelper;
import com.blued.community.utils.StringUtils;
import com.blued.community.view.HorInterceptFrameLayout;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/fragment/VideoScanFragment.class */
public class VideoScanFragment extends KeyBoardFragment implements View.OnClickListener, ShineVideoDataManager.IShineVideoDataDownloadListner, IFeedDetailContract.IView, HorInterceptFrameLayout.OnHorScrollListener {
    private TextView A;
    private TextView B;
    private TextView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private View G;
    private HorInterceptFrameLayout H;
    private RenrenPullToRefreshListView I;
    private ListView J;
    private VideoCommentAdapter K;
    private EmoticonsPageView L;
    private EmoticonsIndicatorView M;
    private EmoticonsToolBarView N;
    private View O;
    private ViewGroup P;
    private TextView Q;
    private Emotion R;
    private AtChooseUserHelper S;
    private AudioManager T;
    private int U;
    private int V;
    private FeedDetailOldPresenter W;
    private int X;
    private View Y;
    private SeekBar Z;
    private SeekBar aa;
    private TextView ab;
    private PLVideoPageView ac;
    private int ad;
    private int ae;
    private String ag;
    private String ah;
    public KeyboardListenLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public View f20386c;
    public ImageView j;
    public EditText k;
    public Dialog l;
    private Activity r;
    private View s;
    private RecyclerView t;
    private VideoScanAdapter u;
    private View v;
    private View w;
    private View x;
    private View y;
    private View z;
    public BluedIngSelfFeed m = new BluedIngSelfFeed();
    private boolean af = false;
    private TextWatcher ai = new TextWatcher() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.9
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f20398c;
        private String d;
        private String e;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = VideoScanFragment.this.k.getSelectionStart();
            this.f20398c = VideoScanFragment.this.k.getSelectionEnd();
            VideoScanFragment.this.k.removeTextChangedListener(VideoScanFragment.this.ai);
            if (!VideoScanFragment.this.S.a(VideoScanFragment.this, this.d, this.e, editable, this.f20398c)) {
                VideoScanFragment.this.k.setSelection(this.b);
            }
            VideoScanFragment.this.k.addTextChangedListener(VideoScanFragment.this.ai);
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
    public boolean n = false;
    public long o = 0;
    public long p = 0;
    public boolean q = false;

    private int A() {
        return this.T.getStreamVolume(3);
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed) {
        ShineVideoDataManager.a().a(bluedIngSelfFeed);
        Bundle bundle = new Bundle();
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        TerminalActivity.d(context, VideoScanFragment.class, bundle);
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i) {
        ShineVideoDataManager.a().a(bluedIngSelfFeed, true, z);
        Bundle bundle = new Bundle();
        bundle.putInt("feedFrom", i);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        TerminalActivity.d(context, VideoScanFragment.class, bundle);
    }

    public static void a(Context context, String str) {
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        bluedIngSelfFeed.feed_id = str;
        a(context, bluedIngSelfFeed, false, -1);
    }

    private void e(int i) {
        this.T.setStreamVolume(3, i, 4);
    }

    private void f(int i) {
        int i2 = i + this.V;
        int i3 = this.U;
        int i4 = i2;
        if (i2 >= i3) {
            i4 = i3;
        }
        e(i4);
        this.u.b((int) (((i4 * 1.0f) / this.U) * 15.0f));
    }

    private void g(int i) {
        int i2 = i - this.V;
        int i3 = i2;
        if (i2 <= 0) {
            i3 = 0;
        }
        e(i3);
        this.u.b((int) (((i3 * 1.0f) / this.U) * 15.0f));
    }

    private void v() {
        if (ShineVideoDataManager.a().c() != null) {
            this.m = ShineVideoDataManager.a().c();
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.X = arguments.getInt("feedFrom", -1);
        }
        ShineVideoDataManager.a().d();
        BluedIngSelfFeed bluedIngSelfFeed = this.m;
        if (bluedIngSelfFeed != null) {
            String str = bluedIngSelfFeed.super_did != null ? this.m.super_did : "";
            if (this.m.live > 0) {
                FeedProtos.Event event = FeedProtos.Event.FLASH_PLAY_PAGE_SHOW;
                String str2 = this.m.feed_id;
                EventTrackFeed.a(event, str2, str, this.m.live + "", EventTrackFeed.f(this.X));
            } else {
                EventTrackFeed.a(FeedProtos.Event.FLASH_PLAY_PAGE_SHOW, this.m.feed_id, str, "", EventTrackFeed.f(this.X));
            }
            EventTrackFeed.a(PersonalProfileProtos.Event.PERSONAL_PHOTO_PAGE_PHOTO_SHOW, this.m, true, EventTrackFeed.e(this.X));
        }
    }

    private void w() {
        FeedDetailOldPresenter feedDetailOldPresenter = new FeedDetailOldPresenter(this.r, this, this.m, -1, getFragmentActive());
        this.W = feedDetailOldPresenter;
        feedDetailOldPresenter.a(false);
    }

    private void x() {
        RecyclerView recyclerView = (RecyclerView) this.s.findViewById(R.id.video_recycle_View);
        this.t = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        View findViewById = this.s.findViewById(R.id.empty_view);
        this.v = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = this.s.findViewById(R.id.des_empty_view);
        this.w = findViewById2;
        findViewById2.setOnClickListener(this);
        ImageView imageView = (ImageView) this.s.findViewById(R.id.img_comment_close);
        this.D = imageView;
        imageView.setOnClickListener(this);
        this.A = (TextView) this.s.findViewById(R.id.tv_comment_in);
        this.C = (TextView) this.s.findViewById(R.id.tv_comment_num);
        ImageView imageView2 = (ImageView) this.s.findViewById(R.id.img_des_close);
        this.E = imageView2;
        imageView2.setOnClickListener(this);
        this.B = (TextView) this.s.findViewById(R.id.tv_des);
        this.x = this.s.findViewById(R.id.lv_lay);
        this.y = this.s.findViewById(R.id.des_lay);
        this.x.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.P = (ViewGroup) this.s.findViewById(R.id.input_layout_up);
        this.k = (EditText) this.s.findViewById(R.id.edit_view);
        this.Q = (TextView) this.s.findViewById(R.id.send_btn);
        this.b = (KeyboardListenLinearLayout) this.s.findViewById(R.id.keyboardRelativeLayout);
        this.k = (EditText) this.s.findViewById(R.id.edit_view);
        this.j = (ImageView) this.s.findViewById(R.id.expression_btn);
        this.f20386c = this.s.findViewById(R.id.emoticon_layout);
        this.O = this.s.findViewById(R.id.keyboard_view);
        this.l = DialogUtils.a(this.r);
        View findViewById3 = this.s.findViewById(R.id.no_data_view);
        this.G = findViewById3;
        findViewById3.setVisibility(8);
        this.Y = this.s.findViewById(R.id.seek_bg);
        this.Z = (SeekBar) this.s.findViewById(R.id.seek_progress_bar);
        this.aa = (SeekBar) this.s.findViewById(R.id.seek_time_bar);
        this.ab = (TextView) this.s.findViewById(R.id.tv_time);
        this.Z.setMax(1000);
        this.Z.setPadding(0, 0, 0, 0);
        this.aa.setMax(1000);
        this.aa.setPadding(0, 0, 0, 0);
        y();
        z();
        this.Q.setOnClickListener(this);
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                VideoScanFragment.this.O_();
            }
        });
        this.k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(256)});
        this.k.addTextChangedListener(this.ai);
        this.R = new Emotion(this.r);
        ArrayList arrayList = new ArrayList();
        arrayList.add(EmotionManager.g());
        this.L = (EmoticonsPageView) this.f20386c.findViewById(R.id.view_epv);
        this.M = (EmoticonsIndicatorView) this.f20386c.findViewById(R.id.view_eiv);
        EmoticonsToolBarView emoticonsToolBarView = (EmoticonsToolBarView) this.f20386c.findViewById(R.id.view_etv);
        this.N = emoticonsToolBarView;
        emoticonsToolBarView.setModel(true);
        this.N.a(getFragmentActive(), arrayList);
        this.L.a(getFragmentActive(), arrayList);
        this.L.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.2
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i) {
                VideoScanFragment.this.M.a(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void a(int i, int i2) {
                VideoScanFragment.this.M.a(i, i2);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void b(int i) {
                VideoScanFragment.this.M.setIndicatorCount(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.OnEmoticonsPageViewListener
            public void c(int i) {
                VideoScanFragment.this.M.b(i);
            }
        });
        this.L.setIViewListener(new IViewStateListener() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.3
            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(int i) {
                VideoScanFragment.this.N.setToolBtnSelect(i);
            }

            @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
            public void a(EmoticonModel emoticonModel) {
                if (VideoScanFragment.this.k != null) {
                    VideoScanFragment.this.k.setFocusable(true);
                    VideoScanFragment.this.k.setFocusableInTouchMode(true);
                    VideoScanFragment.this.k.requestFocus();
                    if (emoticonModel.eventType == 1) {
                        VideoScanFragment.this.k.onKeyDown(67, new KeyEvent(0, 67));
                    } else if (emoticonModel.eventType == 2) {
                    } else {
                        if (emoticonModel.emoji != null) {
                            VideoScanFragment.this.k.append(emoticonModel.emoji.a());
                            return;
                        }
                        VideoScanFragment.this.k.getText().insert(VideoScanFragment.this.k.getSelectionStart(), VideoScanFragment.this.R.a(emoticonModel.code));
                    }
                }
            }
        });
        this.N.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.4
            @Override // com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                VideoScanFragment.this.L.setPageSelect(i);
            }
        });
    }

    private void y() {
        HorInterceptFrameLayout horInterceptFrameLayout = (HorInterceptFrameLayout) this.s.findViewById(R.id.hor_frame);
        this.H = horInterceptFrameLayout;
        horInterceptFrameLayout.setOnHorScrollListener(this);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.s.findViewById(R.id.lv_comment);
        this.I = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        ListView listView = (ListView) this.I.getRefreshableView();
        this.J = listView;
        listView.setClipToPadding(false);
        this.J.setScrollBarStyle(33554432);
        this.J.setHeaderDividersEnabled(false);
        this.J.setDividerHeight(0);
        this.I.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.5
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                VideoScanFragment.this.W.f().e = 1;
                VideoScanFragment.this.W.f().b = true;
                VideoScanFragment.this.W.c();
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                VideoScanFragment.this.W.d();
            }
        });
        this.F = (ImageView) this.s.findViewById(R.id.comment_bg);
        this.z = this.s.findViewById(R.id.des_bg);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.r.getResources(), R.drawable.show_video_comment_cover);
        if (decodeResource == null) {
            Logger.b("VideoScanFragment", "2 null");
            return;
        }
        try {
            Bitmap a2 = AeroGlassUtils.a(AppInfo.d(), decodeResource, 20);
            this.F.setImageBitmap(a2);
            this.z.setBackground(new BitmapDrawable(getResources(), a2));
        } catch (Exception | OutOfMemoryError e) {
        }
    }

    private void z() {
        VideoCommentAdapter videoCommentAdapter = new VideoCommentAdapter(this.r, getFragmentActive(), this.m, new VideoCommentAdapter.FeedCommentListner() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.6
            @Override // com.blued.community.ui.video.adapter.VideoCommentAdapter.FeedCommentListner
            public void a(FeedComment feedComment) {
                VideoScanFragment.this.af = false;
                VideoScanFragment.this.ag = feedComment.comment_id;
                String string = VideoScanFragment.this.r.getResources().getString(R.string.reply);
                EditText editText = VideoScanFragment.this.k;
                editText.setHint(string + feedComment.user_name + ":");
                VideoScanFragment.this.k.requestFocus();
                KeyboardUtils.c(VideoScanFragment.this.getActivity());
                VideoScanFragment.this.ah = feedComment.user_name;
            }
        }, true);
        this.K = videoCommentAdapter;
        this.I.setAdapter(videoCommentAdapter);
        VideoScanAdapter videoScanAdapter = new VideoScanAdapter(this.r, getFragmentActive(), this, this.t, this.X);
        this.u = videoScanAdapter;
        videoScanAdapter.a(new VideoScanAdapter.PageChangeListener() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.7
            @Override // com.blued.community.ui.video.adapter.VideoScanAdapter.PageChangeListener
            public void a(PLVideoPageView pLVideoPageView) {
                VideoScanFragment.this.ac = pLVideoPageView;
                if (VideoScanFragment.this.ac == null || VideoScanFragment.this.ac.getTag(R.id.model) == null) {
                    return;
                }
                VideoScanFragment videoScanFragment = VideoScanFragment.this;
                videoScanFragment.m = (BluedIngSelfFeed) videoScanFragment.ac.getTag(R.id.model);
                VideoScanFragment.this.W.c(VideoScanFragment.this.m);
                VideoScanFragment.this.K.a(VideoScanFragment.this.m);
                VideoScanFragment.this.G.setVisibility(8);
            }
        });
        this.t.setAdapter(this.u);
        if (ShineVideoDataManager.a().j() != -1) {
            this.t.scrollToPosition(ShineVideoDataManager.a().j());
        }
        this.W.c(this.m);
        this.K.a(this.m);
        if (this.m.feed_videos == null || ShineVideoDataManager.a().e()) {
            this.W.c();
            this.m.recommend_text = "";
        }
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        this.u.a(bluedIngSelfFeed);
        this.m = bluedIngSelfFeed;
        String a2 = DistanceUtils.a(this.r, Integer.toString(bluedIngSelfFeed.feed_comment));
        TextView textView = this.C;
        textView.setText(a2 + getResources().getString(R.string.short_video_comment_num));
        if (this.m.feed_comment == 0) {
            this.G.setVisibility(0);
        } else {
            this.G.setVisibility(8);
        }
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void a(List<FeedUserInfoModel> list) {
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void a(List<BluedIngSelfFeed> list, int i, boolean z) {
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void a(boolean z) {
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void a(boolean z, List<BluedIngSelfFeed> list) {
        Log.v("drb", "onSuccess Hasmore:" + z);
        this.u.a(list);
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void b(int i) {
        FeedDetailOldPresenter.DataStatus f = this.W.f();
        this.I.q();
        this.I.j();
        int i2 = f.e;
        if (i2 == 0) {
            this.K.a(new ArrayList());
            o();
        } else if (i2 == 1) {
            if (f.b) {
                p();
            } else {
                q();
            }
        } else if (i2 != 2) {
        } else {
            this.K.a(new ArrayList());
            this.I.p();
            c(0);
        }
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
        this.u.b(bluedIngSelfFeed);
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void b(List<BluedIngSelfFeed> list) {
    }

    public void c(int i) {
        this.I.p();
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void c(BluedIngSelfFeed bluedIngSelfFeed) {
        Logger.b("VideoScanFragment", "setDataToView");
        if (!ShineVideoDataManager.a().e() || ShineVideoDataManager.a().c().feed_videos != null) {
            ShineVideoDataManager.a().c(bluedIngSelfFeed);
            return;
        }
        this.m = bluedIngSelfFeed;
        ShineVideoDataManager.a().b(bluedIngSelfFeed);
        this.u.a();
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void c(List<BluedIngSelfFeed> list) {
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void d(int i) {
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void d(List<FeedUserInfoModel> list) {
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void e(List<FeedComment> list) {
        this.K.a(list);
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void f(List<FeedComment> list) {
        this.K.b(list);
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void g(List<FeedRepost> list) {
    }

    public void h() {
        ShineVideoDataManager.a().c(this);
        getActivity().finish();
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void h(List<FeedRepost> list) {
    }

    @Override // com.blued.community.view.HorInterceptFrameLayout.OnHorScrollListener
    public void horScrolling(int i, float f) {
        if (this.u.b) {
            this.Y.setVisibility(8);
            this.q = true;
            return;
        }
        PLVideoPageView pLVideoPageView = this.ac;
        if (pLVideoPageView == null) {
            return;
        }
        long totalTime = pLVideoPageView.getTotalTime();
        this.o = totalTime;
        if (totalTime <= 60000) {
            return;
        }
        if (!this.n) {
            this.n = true;
            this.o = this.ac.getTotalTime();
            this.p = this.ac.getPlayTime();
            if (this.o > 0) {
                this.ae = (int) (this.ad * (this.u.b() / 1000.0f));
            }
            this.Y.setVisibility(4);
        }
        Logger.b("VideoScanFragment", "barCurrentLength:", Integer.valueOf(this.ae));
        int i2 = (int) (this.ae + (2.0f * f));
        this.ae = i2;
        Logger.b("VideoScanFragment", "barCurrentLength 1:", Integer.valueOf(i2));
        int i3 = this.ae;
        int i4 = this.ad;
        if (i3 > i4) {
            this.ae = i4;
        }
        if (this.ae < 0) {
            this.ae = 0;
        }
        Logger.b("VideoScanFragment", "barCurrentLength 1:", Integer.valueOf(this.ae));
        Logger.b("VideoScanFragment", "barCurrentLength 1:", Integer.valueOf(this.ad));
        int i5 = (int) ((this.ae / this.ad) * 1000.0f);
        Logger.b("VideoScanFragment", "progress:", Integer.valueOf(i5));
        long j = this.o;
        long j2 = ((float) j) * (this.ae / this.ad);
        this.p = j2;
        this.u.a(j2, j, i5);
        if (1 == i || 3 == i) {
            this.Y.setVisibility(8);
            if (!this.q) {
                this.u.b(this.p, this.o, i5);
            }
            this.o = 0L;
            this.q = false;
            this.n = false;
        }
    }

    public void i() {
        this.af = true;
        this.k.setHint("");
        this.ag = "";
        this.k.requestFocus();
        this.P.setVisibility(0);
        KeyboardUtils.c(getActivity());
    }

    public void j() {
        Logger.b("VideoScanFragment", "showComment");
        if (this.K.a()) {
            this.K.b();
            this.I.k();
        }
        String a2 = DistanceUtils.a(this.r, Integer.toString(this.m.feed_comment));
        TextView textView = this.C;
        textView.setText(a2 + getResources().getString(R.string.short_video_comment_num));
        this.x.setVisibility(0);
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        if (i == -3) {
            this.P.setVisibility(0);
            this.k.requestFocus();
            this.O.setVisibility(0);
            this.O.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    KeyboardUtils.a(VideoScanFragment.this.getActivity());
                    if (VideoScanFragment.this.f20386c.getVisibility() == 0) {
                        VideoScanFragment.this.f20386c.setVisibility(8);
                        VideoScanFragment.this.P.setVisibility(8);
                        VideoScanFragment.this.O.setVisibility(8);
                    }
                }
            });
            this.f20386c.setVisibility(8);
        } else if (i != -2) {
        } else {
            this.P.setVisibility(8);
            if (this.f20386c.getVisibility() != 0) {
                this.O.setVisibility(8);
            } else {
                this.P.setVisibility(0);
            }
        }
    }

    public void k() {
        CommunityServiceManager.d().a("shine_video_text_area_expand");
        this.x.setVisibility(8);
        this.y.setVisibility(0);
        StringUtils.a(this.B, this.m.feed_content, 1, "");
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void l() {
        this.af = true;
        this.k.setHint("");
        this.k.setText("");
        this.f20386c.setVisibility(8);
        KeyboardUtils.a(getActivity());
        this.P.setVisibility(8);
        this.O.setVisibility(8);
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void m() {
        DialogUtils.a(this.l);
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void n() {
        DialogUtils.b(this.l);
    }

    public void o() {
        this.I.p();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 9090) {
                this.S.a(this.k, intent, this.ai);
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoScanFragment.this.P.setVisibility(0);
                        VideoScanFragment.this.k.requestFocus();
                        KeyboardUtils.c(VideoScanFragment.this.getActivity());
                    }
                }, 300L);
            }
        } else if (i == 9090) {
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.video.fragment.VideoScanFragment.11
                @Override // java.lang.Runnable
                public void run() {
                    VideoScanFragment.this.P.setVisibility(0);
                    VideoScanFragment.this.k.requestFocus();
                    KeyboardUtils.c(VideoScanFragment.this.getActivity());
                }
            }, 300L);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        h();
        return super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.empty_view || id == R.id.img_comment_close || id == R.id.des_empty_view || id == R.id.img_des_close) {
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            return;
        }
        if (id == R.id.tv_comment_in) {
            if (CommunityServiceManager.a().b(this.r)) {
                return;
            }
            CommunityServiceManager.d().b(5, this.m, "", -1);
            i();
        } else if (id == R.id.send_btn) {
            EventTrackFeed.a(this.W.g(), this.X, this.W.g().super_did != null ? this.W.g().super_did : "");
            if (this.x.getVisibility() != 0) {
                CommunityServiceManager.d().b("shine_video_comment_send_click", 0);
            } else {
                CommunityServiceManager.d().b("shine_video_comment_send_click", 1);
            }
            String obj = this.k.getText().toString();
            if (TextUtils.isEmpty(obj.trim())) {
                AppMethods.d(R.string.feed_null);
            } else {
                this.W.a(this.S.b(obj), this.ah, this.ag, this.af);
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.r = getActivity();
        AudioManager audioManager = (AudioManager) getActivity().getSystemService("audio");
        this.T = audioManager;
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        this.U = streamMaxVolume;
        this.V = streamMaxVolume / 15;
        this.ad = DensityUtils.a(getActivity(), 300.0f);
        v();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(16);
        getActivity().getWindow().addFlags(128);
        this.S = new AtChooseUserHelper(this.r);
        View view = this.s;
        if (view == null) {
            this.s = layoutInflater.inflate(R.layout.fragment_video_turn_layout, (ViewGroup) null);
            w();
            x();
            FeedMethods.a(getActivity(), this.W);
            ShineVideoDataManager.a().a(this);
            super.a(this.f20386c, this.b, this.k);
        } else {
            ((ViewGroup) view.getParent()).removeView(this.s);
        }
        return this.s;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VideoScanAdapter videoScanAdapter = this.u;
        if (videoScanAdapter != null) {
            videoScanAdapter.e();
        }
        getActivity().getWindow().clearFlags(128);
        ShineVideoDataManager.a().b(this);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnKeyListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            f(A());
            return true;
        } else if (i != 25) {
            return super.onKeyDown(i, keyEvent);
        } else {
            g(A());
            return true;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CommunityServiceManager.d().a(1);
        VideoScanAdapter videoScanAdapter = this.u;
        if (videoScanAdapter != null) {
            videoScanAdapter.d();
        }
        AudioManagerUtils.a().a(true);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AudioManagerUtils.a().b();
        CommunityServiceManager.d().b();
        VideoScanAdapter videoScanAdapter = this.u;
        if (videoScanAdapter != null) {
            videoScanAdapter.c();
        }
        super.onResume();
    }

    public void p() {
        this.I.o();
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void q() {
        o();
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void r() {
        this.I.j();
        this.I.q();
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void s() {
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void t() {
    }

    @Override // com.blued.community.ui.video.observer.IFeedDetailContract.IView
    public void u() {
        this.K.notifyDataSetChanged();
    }
}
