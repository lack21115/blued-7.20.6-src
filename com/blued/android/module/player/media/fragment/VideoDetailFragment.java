package com.blued.android.module.player.media.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.module.player.media.R;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.blued.android.module.player.media.utils.Utils;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.player.media.view.ViewDragHelperLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/fragment/VideoDetailFragment.class */
public class VideoDetailFragment extends BaseFragment {
    private static final String c = VideoDetailFragment.class.getSimpleName();
    private View d;
    private ViewDragHelperLayout e;
    private LinearLayout f;
    private PLVideoPageView g;
    private ViewGroup h;
    private LoadOptions i;
    private boolean j;
    private VideoPlayConfig l;
    private boolean k = false;
    ViewDragHelperLayout.OnLayoutStateListener a = new ViewDragHelperLayout.OnLayoutStateListener() { // from class: com.blued.android.module.player.media.fragment.VideoDetailFragment.1
        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void a() {
            if (VideoDetailFragment.this.getActivity() != null) {
                VideoDetailFragment.this.getActivity().finish();
                VideoDetailFragment.this.getActivity().overridePendingTransition(0, 0);
            }
            EventCallbackObserver.a().b();
        }

        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void a(int i) {
            VideoDetailFragment.this.g.g();
            EventCallbackObserver.a().a(i);
        }

        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void b() {
            if (!VideoDetailFragment.this.g.i()) {
                VideoDetailFragment.this.g.c();
            }
            EventCallbackObserver.a().c();
        }

        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void c() {
        }

        @Override // com.blued.android.module.player.media.view.ViewDragHelperLayout.OnLayoutStateListener
        public void d() {
        }
    };
    View.OnLongClickListener b = new View.OnLongClickListener() { // from class: com.blued.android.module.player.media.fragment.VideoDetailFragment.2
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCallbackObserver.a().a(VideoDetailFragment.this.l.b, VideoDetailFragment.this.l.a, Integer.valueOf(VideoDetailFragment.this.l.a()), Integer.valueOf(VideoDetailFragment.this.l.b()));
            return false;
        }
    };

    public static VideoDetailFragment a(VideoPlayConfig videoPlayConfig) {
        if (videoPlayConfig == null) {
            Log.b(c, " VideoDetailConfig is null");
            return null;
        }
        VideoDetailFragment videoDetailFragment = new VideoDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("video_config_data", videoPlayConfig);
        videoDetailFragment.setArguments(bundle);
        return videoDetailFragment;
    }

    private void d() {
        this.e = (ViewDragHelperLayout) this.d.findViewById(R.id.view_drag_layout);
        this.f = (LinearLayout) this.d.findViewById(R.id.video_view_layout);
        this.h = (ViewGroup) this.d.findViewById(R.id.surface_view);
        LayoutInflater.from(getActivity()).inflate(R.layout.pl_media_video_layout_new, this.h);
        this.g = (PLVideoPageView) this.h.findViewById(R.id.video_view);
        this.e.setScrollDisable(this.l.r);
        if (this.l.r) {
            this.e.setOnLayoutStateListener(this.a);
        }
    }

    private void e() {
        this.h.setVisibility(0);
        LoadOptions loadOptions = new LoadOptions();
        this.i = loadOptions;
        loadOptions.j = true;
        this.i.l = false;
        this.i.d = R.color.black;
        this.i.b = R.color.black;
        f();
    }

    private void f() {
        VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
        videoPlayConfig.a(this.l);
        videoPlayConfig.h = this.b;
        videoPlayConfig.j = true;
        videoPlayConfig.n = true;
        VideoPlayConfig videoPlayConfig2 = this.l;
        if (videoPlayConfig2 != null) {
            videoPlayConfig.t = videoPlayConfig2.s;
        }
        this.g.b(videoPlayConfig);
    }

    public void a() {
        VideoPlayConfig serializable = getArguments() != null ? getArguments().getSerializable("video_config_data") : null;
        this.l = serializable;
        if (serializable == null || TextUtils.isEmpty(serializable.b)) {
            Log.b(c, " VideoDetailConfig is null || mConfigInfo.videoUrl == null");
        } else if ("http".contains(this.l.b)) {
        } else {
            int[] a = Utils.a(this.l.b);
            this.l.a(a[0]);
            this.l.b(a[1]);
        }
    }

    public PLVideoPageView b() {
        return this.g;
    }

    public boolean c() {
        return true;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e();
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        EventCallbackObserver.a().d();
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_video_detail, viewGroup, false);
            StatusBarHelper.a((Activity) getActivity());
            a();
            d();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        this.j = true;
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        PLVideoPageView pLVideoPageView = this.g;
        if (pLVideoPageView != null) {
            pLVideoPageView.h();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        this.g.g();
        if (!c() || this.k) {
            return;
        }
        AudioManagerUtils.a().a(true);
        this.k = true;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            if (c()) {
                this.k = false;
                AudioManagerUtils.a().b();
            }
            this.g.f();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.j) {
            if (z) {
                if (c()) {
                    this.k = false;
                    AudioManagerUtils.a().b();
                }
                this.g.a(z);
                return;
            }
            this.g.a(z);
            if (!c() || this.k) {
                return;
            }
            AudioManagerUtils.a().a(true);
            this.k = true;
        }
    }
}
