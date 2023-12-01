package com.soft.blued.ui.photo.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.media.selector.utils.Tools;
import com.blued.android.module.player.media.fragment.VideoDetailFragment;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.player.media.view.ViewDragHelperLayout;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/AlbumVideoFragment.class */
public class AlbumVideoFragment extends BaseFragment {

    /* renamed from: c  reason: collision with root package name */
    private static final String f19358c = VideoDetailFragment.class.getSimpleName();
    private View d;
    private ViewDragHelperLayout e;
    private LinearLayout f;
    private PLVideoPageView g;
    private ViewGroup h;
    private LoadOptions i;
    private boolean j;
    private VideoPlayConfig l;
    private boolean k = false;

    /* renamed from: a  reason: collision with root package name */
    ViewDragHelperLayout.OnLayoutStateListener f19359a = new ViewDragHelperLayout.OnLayoutStateListener() { // from class: com.soft.blued.ui.photo.fragment.AlbumVideoFragment.1
        public void a() {
            if (AlbumVideoFragment.this.getActivity() != null) {
                AlbumVideoFragment.this.getActivity().finish();
                AlbumVideoFragment.this.getActivity().overridePendingTransition(0, 0);
            }
            EventCallbackObserver.a().b();
        }

        public void a(int i) {
            AlbumVideoFragment.this.g.g();
            EventCallbackObserver.a().a(i);
        }

        public void b() {
            if (!AlbumVideoFragment.this.g.i()) {
                AlbumVideoFragment.this.g.c();
            }
            EventCallbackObserver.a().c();
        }

        public void c() {
        }

        public void d() {
        }
    };
    View.OnLongClickListener b = new View.OnLongClickListener() { // from class: com.soft.blued.ui.photo.fragment.AlbumVideoFragment.2
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCallbackObserver.a().a(new Object[]{AlbumVideoFragment.this.l.b, AlbumVideoFragment.this.l.a, Integer.valueOf(AlbumVideoFragment.this.l.a()), Integer.valueOf(AlbumVideoFragment.this.l.b())});
            return false;
        }
    };

    private void c() {
        this.e = this.d.findViewById(2131373158);
        this.f = (LinearLayout) this.d.findViewById(2131373092);
        this.h = (ViewGroup) this.d.findViewById(2131370507);
        LayoutInflater.from(getActivity()).inflate(2131560860, this.h);
        this.g = this.h.findViewById(2131373091);
        this.e.setScrollDisable(this.l.r);
        if (this.l.r) {
            this.e.setOnLayoutStateListener(this.f19359a);
        }
    }

    private void d() {
        this.h.setVisibility(0);
        LoadOptions loadOptions = new LoadOptions();
        this.i = loadOptions;
        loadOptions.j = true;
        this.i.l = false;
        this.i.d = 2131099824;
        this.i.b = 2131099824;
        e();
    }

    private void e() {
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
            LogUtils.c(new Object[]{f19358c + " VideoDetailConfig is null || mConfigInfo.videoUrl == null"});
        } else if ("http".contains(this.l.b)) {
        } else {
            int[] c2 = Tools.c(this.l.b);
            this.l.a(c2[0]);
            this.l.b(c2[1]);
        }
    }

    public boolean b() {
        return true;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        d();
    }

    public boolean onBackPressed() {
        EventCallbackObserver.a().d();
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(2131559333, viewGroup, false);
            StatusBarHelper.a(getActivity());
            a();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        this.j = true;
        return this.d;
    }

    public void onDestroy() {
        super.onDestroy();
        PLVideoPageView pLVideoPageView = this.g;
        if (pLVideoPageView != null) {
            pLVideoPageView.h();
        }
    }

    public void onPause() {
        super.onPause();
        Log.v("drb", "onPause");
        this.g.g();
        if (!b() || this.k) {
            return;
        }
        AudioManagerUtils.a().a(true);
        this.k = true;
    }

    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            if (b()) {
                this.k = false;
                AudioManagerUtils.a().b();
            }
            this.g.f();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.j) {
            if (z) {
                if (b()) {
                    this.k = false;
                    AudioManagerUtils.a().b();
                }
                this.g.a(z);
                d();
                this.g.c();
                return;
            }
            this.g.a(z);
            if (!b() || this.k) {
                return;
            }
            AudioManagerUtils.a().a(true);
            this.k = true;
        }
    }
}
