package com.blued.community.ui.video.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.android.module.player.audio.IAudioPlayer;
import com.blued.android.module.player.audio.TXVodAudioPlayer;
import com.blued.android.module.shortvideo.view.CustomProgressDialog;
import com.blued.android.module.shortvideo.widget.SpacesItemDecoration;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.video.adapter.MusicVideoCollectAdapter;
import com.blued.community.ui.video.manager.MusicManager;
import com.blued.community.ui.video.model.VideoScanMusic;
import com.blued.community.ui.video.presenter.MusicVideoCollectPresent;
import com.blued.community.view.FloatFooterView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/fragment/MusicVideoCollectFragment.class */
public class MusicVideoCollectFragment extends MvpFragment<MusicVideoCollectPresent> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private CommonTopTitleNoTrans f20364a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f20365c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private TextView k;
    private ShapeLinearLayout l;
    private FrameLayout m;
    private AppBarLayout n;
    private RecyclerView o;
    private CoordinatorLayout p;
    private SmartRefreshLayout q;
    private FloatFooterView r;
    private IAudioPlayer s;
    private MusicVideoCollectAdapter t;
    private NoDataAndLoadFailView u;
    private ProgressDialog v;
    private boolean w = false;
    private int x;

    public static void a(Context context, VideoScanMusic videoScanMusic) {
        if (videoScanMusic == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("video_scan_music", videoScanMusic);
        TerminalActivity.d(context, MusicVideoCollectFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppBarLayout appBarLayout, int i) {
        int abs = Math.abs(this.x - i);
        if (this.x < i && abs > 10) {
            this.r.startBtmBtnShow();
        } else if (this.x > i && abs > 10) {
            this.r.startBtmBtnHide();
        }
        this.x = i;
    }

    private void b() {
        this.f20364a = (CommonTopTitleNoTrans) this.i.findViewById(R.id.top_title);
        this.q = (SmartRefreshLayout) this.i.findViewById(R.id.refresh_layout);
        this.p = (CoordinatorLayout) this.i.findViewById(R.id.coordinator);
        this.n = (AppBarLayout) this.i.findViewById(R.id.appbar);
        this.m = (FrameLayout) this.i.findViewById(R.id.layout_music);
        ImageView imageView = (ImageView) this.i.findViewById(R.id.iv_music_bg);
        this.b = imageView;
        imageView.setOnClickListener(this);
        this.f20365c = (ImageView) this.i.findViewById(R.id.iv_music_play);
        this.d = (TextView) this.i.findViewById(R.id.tv_music_name);
        TextView textView = (TextView) this.i.findViewById(R.id.tv_music_author);
        this.e = textView;
        textView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.i.findViewById(R.id.iv_music_author);
        this.f = imageView2;
        imageView2.setOnClickListener(this);
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) this.i.findViewById(R.id.sll_collection);
        this.l = shapeLinearLayout;
        shapeLinearLayout.setOnClickListener(this);
        this.g = (ImageView) this.i.findViewById(R.id.iv_collection);
        this.k = (TextView) this.i.findViewById(R.id.tv_collection);
        this.o = (RecyclerView) this.i.findViewById(R.id.recycler_view);
        this.r = (FloatFooterView) this.i.findViewById(R.id.ll_feed_post);
    }

    private void b(boolean z) {
        this.q.j();
        if (z) {
            this.t.loadMoreComplete();
        } else {
            this.t.loadMoreFail();
        }
        if (this.t.getData().size() <= 0) {
            if (z) {
                this.u.a();
            } else {
                this.u.b();
            }
        }
    }

    private void c() {
        if (this.w) {
            e();
        } else {
            d();
        }
    }

    private void d() {
        this.f20365c.setImageResource(R.drawable.video_scan_music_pause_icon);
        MusicManager.a(this.s, j().p().music_url, j().p().music_id);
        this.w = true;
    }

    private void e() {
        this.f20365c.setImageResource(R.drawable.video_scan_music_play_icon);
        MusicManager.a(this.s);
        this.w = false;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
        this.s = new TXVodAudioPlayer();
        CustomProgressDialog customProgressDialog = new CustomProgressDialog(getContext());
        this.v = customProgressDialog;
        customProgressDialog.setCanceledOnTouchOutside(true);
        this.f20364a.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.fragment.MusicVideoCollectFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MusicVideoCollectFragment.this.t();
            }
        });
        this.o.setLayoutManager(new GridLayoutManager(getContext(), 3));
        MusicVideoCollectAdapter musicVideoCollectAdapter = new MusicVideoCollectAdapter(getContext(), getFragmentActive());
        this.t = musicVideoCollectAdapter;
        this.o.setAdapter(musicVideoCollectAdapter);
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), 1.5f));
        spacesItemDecoration.a(5);
        spacesItemDecoration.a(true, true, true, true);
        spacesItemDecoration.a(0, 0, 0, 0);
        this.o.addItemDecoration(spacesItemDecoration);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.u = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_data_posted);
        this.u.setNoDataStr(R.string.no_content_for_now);
        this.t.setEmptyView(this.u);
        this.r.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.video.fragment.MusicVideoCollectFragment.2
            @Override // com.blued.community.view.FloatFooterView.OnBtnClickListener
            public void onPostFeedClick() {
                ProgressDialog progressDialog = MusicVideoCollectFragment.this.v;
                MusicVideoCollectFragment musicVideoCollectFragment = MusicVideoCollectFragment.this;
                MusicManager.a(progressDialog, musicVideoCollectFragment, musicVideoCollectFragment.j().p().music_url, MusicVideoCollectFragment.this.j().p().music_id, new MusicManager.ICallBack() { // from class: com.blued.community.ui.video.fragment.MusicVideoCollectFragment.2.1
                    @Override // com.blued.community.ui.video.manager.MusicManager.ICallBack
                    public void a(String str) {
                        ShortVideoProxy.e().a(MusicVideoCollectFragment.this, 6, str, MusicVideoCollectFragment.this.j().p().music_name, 209);
                    }
                });
            }
        });
        this.r.setBtnWidthAndHeight(DensityUtils.a(getContext(), 155.0f), DensityUtils.a(getContext(), 40.0f));
        this.r.setBtnBackgroundColor(R.color.flash_video_yellow);
        this.r.setBtnIconImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.music_video_collect_camera_icon));
        this.r.setBtnText(R.string.music_use_sound);
        this.q.l(false);
        this.q.a(new OnRefreshListener() { // from class: com.blued.community.ui.video.fragment.MusicVideoCollectFragment.3
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                MusicVideoCollectFragment.this.j().e();
            }
        });
        this.t.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.t.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.video.fragment.MusicVideoCollectFragment.4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                MusicVideoCollectFragment.this.j().f();
            }
        }, this.o);
        this.n.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.blued.community.ui.video.fragment.-$$Lambda$MusicVideoCollectFragment$t0T9Vl-if9AEftmN8AsfygguUR8
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                MusicVideoCollectFragment.this.a(appBarLayout, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(VideoScanMusic videoScanMusic) {
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(3, videoScanMusic.music_cover)).b(R.drawable.user_bg_round).a(6.0f).a(this.b);
        this.d.setText(videoScanMusic.music_name);
        this.e.setText(videoScanMusic.music_singer);
        if (videoScanMusic.i_star == 1) {
            ShapeHelper.b(this.l, R.color.syc_a);
            this.g.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_collected));
            this.k.setTextColor(getContext().getResources().getColor(R.color.syc_dark_b));
        } else {
            ShapeHelper.b(this.l, R.color.syc_dark_c);
            this.g.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_collection));
            this.k.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_dark_h));
        }
        this.t.a(videoScanMusic.main_tid);
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
            b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<BluedIngSelfFeed> list) {
        this.t.setNewData(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.u = null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_music_video_collect;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        this.q.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        StvResultModel stvResultModel;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 209 && intent != null && (stvResultModel = (StvResultModel) intent.getSerializableExtra("result_model")) != null && stvResultModel.a()) {
            FeedAddPostFragment.a(getContext(), stvResultModel);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.iv_music_bg) {
            c();
        } else if (id == R.id.tv_music_author || id == R.id.iv_music_author) {
            CommunityServiceManager.b().a(getContext(), j().p().music_uid, "PAGE_MUSIC_VIDEO_COLLECT");
        } else if (id == R.id.sll_collection) {
            j().m();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IAudioPlayer iAudioPlayer = this.s;
        if (iAudioPlayer != null) {
            iAudioPlayer.b();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.s != null) {
            e();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.t.setEnableLoadMore(false);
    }
}
