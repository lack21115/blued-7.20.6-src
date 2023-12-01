package com.blued.android.module.player.media.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.media.R;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.observer.LiveSysNetworkObserver;
import com.blued.android.module.player.media.view.AbBaseVideoView;
import com.blued.android.module.player.media.view.PLTextureVideoViewINT;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/PLTextureVideoViewINT.class */
public class PLTextureVideoViewINT extends AbsPlayerView implements LiveSysNetworkObserver.ILiveSysNetworkObserver {
    Handler m;
    Runnable n;
    private ImageView o;
    private ImageView p;
    private float q;
    private float r;
    private boolean s;
    private boolean t;
    private boolean u;
    private OnVideoSizeChangedListener v;
    private OnMuteListener w;
    private MediaControllerINT x;
    private final AbBaseVideoView.OnVideoStatusListener y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.player.media.view.PLTextureVideoViewINT$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/PLTextureVideoViewINT$2.class */
    public class AnonymousClass2 implements AbBaseVideoView.OnVideoStatusListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            PLTextureVideoViewINT.this.h.setVisibility(8);
            PLTextureVideoViewINT pLTextureVideoViewINT = PLTextureVideoViewINT.this;
            pLTextureVideoViewINT.a(pLTextureVideoViewINT.f);
            PLTextureVideoViewINT.this.g.setVisibility(8);
            PLTextureVideoViewINT.this.setVisible(0);
            PLTextureVideoViewINT.this.m.removeCallbacks(PLTextureVideoViewINT.this.n);
            PLTextureVideoViewINT.this.m.post(PLTextureVideoViewINT.this.n);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            PLTextureVideoViewINT.this.h.setVisibility(8);
            PLTextureVideoViewINT.this.g.setVisibility(8);
            PLTextureVideoViewINT.this.setVisible(0);
            PLTextureVideoViewINT.this.m.removeCallbacks(PLTextureVideoViewINT.this.n);
            PLTextureVideoViewINT.this.m.post(PLTextureVideoViewINT.this.n);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j() {
            if (PLTextureVideoViewINT.this.j != null && PLTextureVideoViewINT.this.j.l) {
                PLTextureVideoViewINT.this.j.l = false;
            } else if (PLTextureVideoViewINT.this.g.getVisibility() == 0 || !PLTextureVideoViewINT.this.a()) {
            } else {
                PLTextureVideoViewINT.this.h.setVisibility(0);
            }
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void a() {
            if (PLTextureVideoViewINT.this.j == null || !PLTextureVideoViewINT.this.j.m) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$2$JQhjrfpxXUR7GXiFUj4r0Jc13yU
                    @Override // java.lang.Runnable
                    public final void run() {
                        PLTextureVideoViewINT.AnonymousClass2.this.j();
                    }
                });
                return;
            }
            Log.c("PLTextureVideoViewINT", "MEDIA_INFO_BUFFERING_START pause==============");
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.PLTextureVideoViewINT.2.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.i();
                }
            });
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void a(int i, int i2) {
            if (PLTextureVideoViewINT.this.v != null) {
                PLTextureVideoViewINT.this.v.a(i, i2);
            }
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void b() {
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void c() {
            Log.c("PLTextureVideoViewINT", "MEDIA_INFO_BUFFERING_END");
            if (PLTextureVideoViewINT.this.j == null || !PLTextureVideoViewINT.this.j.m) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$2$wY19g5jqGuj63PhPeG5fJI8G0j8
                    @Override // java.lang.Runnable
                    public final void run() {
                        PLTextureVideoViewINT.AnonymousClass2.this.h();
                    }
                });
                return;
            }
            Log.c("PLTextureVideoViewINT", "MEDIA_INFO_BUFFERING_END pause==============");
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$2$F_D4EWX6IjKz5ubClT8djPTKcjs
                @Override // java.lang.Runnable
                public final void run() {
                    PLTextureVideoViewINT.AnonymousClass2.this.i();
                }
            });
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void d() {
            Log.c("PLTextureVideoViewINT", "MEDIA_INFO_VIDEO_RENDERING_START");
            if (PLTextureVideoViewINT.this.j == null || !PLTextureVideoViewINT.this.j.m) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$2$leKKl-trhDVbRL2tJE4U6IsaZ3s
                    @Override // java.lang.Runnable
                    public final void run() {
                        PLTextureVideoViewINT.AnonymousClass2.this.f();
                    }
                });
                return;
            }
            Log.c("PLTextureVideoViewINT", "MEDIA_INFO_VIDEO_RENDERING_START pause==============");
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$2$MS1Q0bCdZq9T-yYP_jHa-MKl1Os
                @Override // java.lang.Runnable
                public final void run() {
                    PLTextureVideoViewINT.AnonymousClass2.this.g();
                }
            });
        }

        /* renamed from: e */
        public void i() {
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/PLTextureVideoViewINT$OnVideoSizeChangedListener.class */
    public interface OnVideoSizeChangedListener {
        void a(int i, int i2);
    }

    public PLTextureVideoViewINT(Context context) {
        this(context, null);
    }

    public PLTextureVideoViewINT(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PLTextureVideoViewINT(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = false;
        this.t = false;
        this.u = false;
        this.m = new Handler();
        this.n = new Runnable() { // from class: com.blued.android.module.player.media.view.PLTextureVideoViewINT.1
            @Override // java.lang.Runnable
            public void run() {
                if (PLTextureVideoViewINT.this.d == null || PLTextureVideoViewINT.this.i.getChildCount() <= 0) {
                    return;
                }
                if (PLTextureVideoViewINT.this.d.e()) {
                    PLTextureVideoViewINT.this.x.a(PLTextureVideoViewINT.this.d.getCurrentPosition(), PLTextureVideoViewINT.this.d.getDuration());
                }
                if (PLTextureVideoViewINT.this.d.e()) {
                    PLTextureVideoViewINT.this.m.postDelayed(PLTextureVideoViewINT.this.n, 100L);
                }
            }
        };
        this.y = new AnonymousClass2();
        this.a = context;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setDuration(500L);
        view.setAnimation(alphaAnimation);
        alphaAnimation.start();
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(View view) {
        if (this.j == null || this.j.h == null) {
            return false;
        }
        this.j.h.onLongClick(view);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (this.j == null || this.j.g == null) {
            return;
        }
        this.j.g.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        if (this.j == null || this.j.g == null) {
            return;
        }
        this.j.g.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        if (this.q == 0.0f && this.r == 0.0f) {
            d();
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        l();
    }

    private AbBaseVideoView getVideoView() {
        AbBaseVideoView a = this.l.a(this.j.b);
        AbBaseVideoView abBaseVideoView = a;
        if (a == null) {
            abBaseVideoView = this.l.a(this.j.b, getContext());
        }
        if (abBaseVideoView != null) {
            ViewParent parent = abBaseVideoView.getParent();
            while (true) {
                ViewParent viewParent = parent;
                if (viewParent == null) {
                    break;
                } else if (viewParent instanceof PLTextureVideoViewINT) {
                    Log.c("PLTextureVideoViewINT", "insetPlayTextureView has old parent =" + this.j.b);
                    ((PLTextureVideoViewINT) viewParent).k();
                    a(abBaseVideoView);
                    break;
                } else {
                    parent = viewParent.getParent();
                }
            }
            if (this.i.getChildCount() == 0) {
                this.d = abBaseVideoView;
                this.d.a(this.j);
                this.i.addView(this.d);
                s();
                Log.c("PLTextureVideoViewINT", "insetPlayTextureView new mVideoRoot URL" + this.j.b);
            } else {
                Log.c("PLTextureVideoViewINT", "insetPlayTextureView mVideoRoot.getChildCount() != 0");
            }
            this.d.a(this.j);
        }
        return this.d;
    }

    private void m() {
        if (this.j == null) {
            Log.c("PLTextureVideoViewINT", "startPlay discard, mPlayConfig = null + " + this);
        } else if (!b()) {
            Log.d("PLTextureVideoViewINT", "start mVideoRoot.getChildCount() == 0");
        } else if (j()) {
            Log.c("PLTextureVideoViewINT", "start 3");
        } else {
            this.j.m = false;
            this.d.b();
            this.g.setVisibility(8);
            setVisible(0);
            Log.c("PLTextureVideoViewINT", "start:" + this.j.b);
        }
    }

    private void n() {
        Context context = getContext();
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        ((Activity) context).setRequestedOrientation(4);
    }

    private void o() {
        if (b()) {
            this.d.f();
        }
    }

    private void p() {
        this.g.setVisibility(8);
        setVisible(0);
        m();
    }

    private void q() {
        if (this.j == null) {
            return;
        }
        this.d = getVideoView();
        if (this.d == null) {
            return;
        }
        this.x.setAncherView(this.d);
        this.d.a(this.j);
        this.j.m = false;
        if (this.j.j) {
            this.q = 1.0f;
            this.r = 1.0f;
            this.d.a(1.0f, 1.0f);
        } else {
            this.q = 0.0f;
            this.r = 0.0f;
            this.d.a(0.0f, 0.0f);
        }
        this.d.b();
        this.m.removeCallbacks(this.n);
        this.m.post(this.n);
    }

    private void r() {
        this.b = LayoutInflater.from(this.a);
        this.c = this.b.inflate(R.layout.pl_texture_video_view_international, this);
        this.i = (FrameLayout) this.c.findViewById(R.id.video_root);
        this.e = this.c.findViewById(R.id.cover_view);
        this.e.setVisibility(0);
        this.f = (ImageView) this.c.findViewById(R.id.preview);
        this.g = (ImageView) this.c.findViewById(R.id.video_state_icon);
        this.o = (ImageView) this.c.findViewById(R.id.video_screent_icon);
        this.p = (ImageView) this.c.findViewById(R.id.video_voice_icon);
        this.h = this.c.findViewById(R.id.LoadingView);
        this.x = (MediaControllerINT) this.c.findViewById(R.id.seek_lay);
        LiveSysNetworkObserver.a().a(this);
        Log.c("PLTextureVideoViewINT", "init");
    }

    private void s() {
        if (this.j == null || !b()) {
            return;
        }
        this.d.a(true);
        this.d.setOnVideoStatusListener(null);
        this.d.setOnVideoStatusListener(this.y);
        this.q = 0.0f;
        this.r = 0.0f;
        if (this.j.j) {
            b(this.j.u);
        }
    }

    private void setCoverView(ImageView.ScaleType scaleType) {
        this.f.setVisibility(0);
        this.f.setScaleType(scaleType);
        ((TextUtils.isEmpty(this.j.a) || this.j.a.contains("http")) ? ImageLoader.a((IRequestHost) null, this.j.a) : ImageLoader.d(null, this.j.a)).b(R.drawable.video_international_default).a(this.f);
    }

    private void setVideoSize(VideoPlayConfig videoPlayConfig) {
        if (this.j == null) {
            return;
        }
        if (this.j.j) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            if (!this.j.t) {
                this.f.setVisibility(8);
                return;
            }
            this.f.setLayoutParams(layoutParams);
            setCoverView(ImageView.ScaleType.FIT_CENTER);
        } else if (this.j.a() == 0 || this.j.b() == 0) {
            this.j.e = 0;
            this.j.f = 0;
            this.j.a(0);
            this.j.b(0);
        } else {
            this.j.e = videoPlayConfig.e;
            this.j.f = videoPlayConfig.f;
            this.j.b(videoPlayConfig.b());
            this.j.a(videoPlayConfig.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(int i) {
        ImageView imageView;
        ImageView imageView2;
        if (i == 0) {
            if (this.s && (imageView2 = this.o) != null) {
                imageView2.setVisibility(i);
            }
            if (!this.s || (imageView = this.p) == null) {
                return;
            }
            imageView.setVisibility(i);
            return;
        }
        ImageView imageView3 = this.o;
        if (imageView3 != null) {
            imageView3.setVisibility(i);
        }
        ImageView imageView4 = this.p;
        if (imageView4 != null) {
            imageView4.setVisibility(i);
        }
    }

    private void t() {
        this.f.setVisibility(0);
        this.h.setVisibility(8);
        this.g.setVisibility(0);
        setVisible(8);
    }

    private void u() {
        if (this.g != null) {
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$9EAnpc21n-U0PFy-bedF8WZjRa4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PLTextureVideoViewINT.this.f(view);
                }
            });
        }
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$mbGX79NOmkDeuZJweS0bbynwPN8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PLTextureVideoViewINT.this.e(view);
                }
            });
        }
        ImageView imageView2 = this.o;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$zJNwlE4HjsbpVk2LuBXqdNxCpJ8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PLTextureVideoViewINT.this.d(view);
                }
            });
        }
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$wKJxSnmLzVQw04JelmLv7KRvbPo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PLTextureVideoViewINT.this.c(view);
            }
        });
        this.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLTextureVideoViewINT$yHp1Gr6ZyWxoDQLnIcvXjSfQsAo
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean b;
                b = PLTextureVideoViewINT.this.b(view);
                return b;
            }
        });
    }

    public void a(boolean z) {
        if (z) {
            l();
            Log.a("PLTextureVideoViewINT", "isVisibleToUser loadVideoWithPlay =  " + this.j.b);
            return;
        }
        k();
        Log.a("PLTextureVideoViewINT", "isVisibleToUser resetLayout =  " + this.j.b);
    }

    public void b(VideoPlayConfig videoPlayConfig) {
        if (a(videoPlayConfig) && this.j != null) {
            Log.c("PLTextureVideoViewINT", "loadVideo:" + this.j.a() + "  :" + this.j.b());
            setVideoSize(videoPlayConfig);
            if (videoPlayConfig.t) {
                setCoverView(ImageView.ScaleType.CENTER_CROP);
            } else {
                this.f.setVisibility(8);
            }
            k();
            u();
        }
    }

    public void b(boolean z) {
        if (this.j != null) {
            this.j.u = z;
        }
        if (this.d == null || z) {
            return;
        }
        if (!z) {
            this.x.setVisibility(0);
        }
        n();
    }

    public void c() {
        this.q = 0.0f;
        this.r = 0.0f;
        if (b()) {
            this.d.a(this.q, this.r);
        }
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.video_international_mute_icon);
        }
        OnMuteListener onMuteListener = this.w;
        if (onMuteListener != null) {
            onMuteListener.a(true);
        }
    }

    public void d() {
        this.q = 1.0f;
        this.r = 1.0f;
        if (b()) {
            this.d.a(this.q, this.r);
        }
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.video_international_unmute_icon);
        }
        OnMuteListener onMuteListener = this.w;
        if (onMuteListener != null) {
            onMuteListener.a(false);
        }
    }

    public void e() {
        if (b()) {
            this.g.setVisibility(0);
            setVisible(8);
            this.h.setVisibility(8);
            if (this.j != null) {
                this.j.m = true;
            }
            this.d.d();
            Log.c("PLTextureVideoViewINT", "pause :" + this.j.b);
        }
    }

    public void f() {
        if (!b()) {
            l();
        } else if (j()) {
            i();
        } else {
            m();
        }
    }

    public void g() {
        e();
    }

    public void h() {
        Log.c("PLTextureVideoViewINT", "onDestroy ##########:");
        o();
        if (this.j != null && this.j.g != null) {
            this.j.g = null;
        }
        if (this.j != null && this.j.h != null) {
            this.j.h = null;
        }
        if (this.h != null) {
            this.h.setVisibility(8);
        }
        if (this.w != null) {
            this.w = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        if (b()) {
            this.d.c();
            a(this.d);
        }
    }

    public void i() {
        if (!b()) {
            l();
        } else if (a()) {
            g();
        } else {
            p();
        }
    }

    public boolean j() {
        return this.g.getVisibility() == 0;
    }

    public void k() {
        e();
        t();
    }

    public void l() {
        this.h.setVisibility(0);
        this.g.setVisibility(8);
        setVisible(0);
        q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g.setVisibility(0);
        if (this.f != null) {
            this.f.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Log.c("PLTextureVideoViewINT", "onDetachedFromWindow");
        if (b()) {
            this.d.f();
        }
        LiveSysNetworkObserver.a().b(this);
        super.onDetachedFromWindow();
    }

    public void setConfigInfo(VideoPlayConfig videoPlayConfig) {
        if (videoPlayConfig != null) {
            this.j = videoPlayConfig;
            b(videoPlayConfig.s);
        }
    }

    public void setManageAudioFocus(boolean z) {
        this.u = z;
    }

    public void setOnMuteListener(OnMuteListener onMuteListener) {
        this.w = onMuteListener;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.v = onVideoSizeChangedListener;
    }

    public void setScreenIconVisible(boolean z) {
        this.s = z;
    }

    public void setVoiceVisible(boolean z) {
        this.t = z;
    }

    public void setVolumeProgress(int i) {
    }
}
