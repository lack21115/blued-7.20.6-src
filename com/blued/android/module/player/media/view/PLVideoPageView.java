package com.blued.android.module.player.media.view;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.Log;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.player.media.R;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.utils.Utils;
import com.blued.android.module.player.media.view.AbBaseVideoView;
import com.blued.android.module.player.media.view.PLVideoPageView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/PLVideoPageView.class */
public class PLVideoPageView extends AbsPlayerView {
    public static String m = "PLVideoPageView";
    private Runnable A;
    private AbBaseVideoView.OnVideoStatusListener B;
    Runnable n;
    private TextView o;
    private SeekBar p;
    private SeekBar q;
    private long r;
    private long s;
    private long t;
    private long u;
    private long v;
    private boolean w;
    private boolean x;
    private OnPLVideoListener y;
    private Handler z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.player.media.view.PLVideoPageView$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/PLVideoPageView$2.class */
    public class AnonymousClass2 implements AbBaseVideoView.OnVideoStatusListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            PLVideoPageView.this.v();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            if (PLVideoPageView.this.i()) {
                return;
            }
            if (PLVideoPageView.this.j != null && PLVideoPageView.this.j.l) {
                PLVideoPageView.this.j.l = false;
            } else if (PLVideoPageView.this.y != null) {
                PLVideoPageView.this.y.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g() {
            Log.c(PLVideoPageView.m, "onBufferStart ***");
            if (PLVideoPageView.this.j != null && PLVideoPageView.this.j.m) {
                PLVideoPageView.this.m();
            } else if (PLVideoPageView.this.j != null && PLVideoPageView.this.j.l) {
                PLVideoPageView.this.j.l = false;
            } else if (PLVideoPageView.this.y != null) {
                PLVideoPageView.this.y.a();
            }
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void a() {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLVideoPageView$2$v24oAdDvN7hPItfNEBttGWQOkaM
                @Override // java.lang.Runnable
                public final void run() {
                    PLVideoPageView.AnonymousClass2.this.g();
                }
            });
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void a(int i, int i2) {
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void b() {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLVideoPageView$2$mGt7s2OJTygs5fQkjupNzga55_k
                @Override // java.lang.Runnable
                public final void run() {
                    PLVideoPageView.AnonymousClass2.this.f();
                }
            });
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void c() {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.PLVideoPageView.2.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.c(PLVideoPageView.m, "onBufferEnd ***");
                    if (PLVideoPageView.this.j != null && PLVideoPageView.this.j.m) {
                        PLVideoPageView.this.m();
                        return;
                    }
                    PLVideoPageView.this.t();
                    PLVideoPageView.this.z.removeCallbacks(PLVideoPageView.this.A);
                    PLVideoPageView.this.z.post(PLVideoPageView.this.A);
                    if (PLVideoPageView.this.y != null) {
                        PLVideoPageView.this.y.b();
                    }
                }
            });
        }

        @Override // com.blued.android.module.player.media.view.AbBaseVideoView.OnVideoStatusListener
        public void d() {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLVideoPageView$2$Us-BsfVpYB8EC-cnc1BgxW7eJJw
                @Override // java.lang.Runnable
                public final void run() {
                    PLVideoPageView.AnonymousClass2.this.e();
                }
            });
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/PLVideoPageView$OnPLVideoListener.class */
    public interface OnPLVideoListener {
        void a();

        void a(int i);

        void a(long j, long j2);

        void b();

        void c();

        void d();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/PLVideoPageView$OnSeekListener.class */
    public interface OnSeekListener {
    }

    public PLVideoPageView(Context context) {
        this(context, null);
    }

    public PLVideoPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.w = false;
        this.z = new Handler();
        this.A = new Runnable() { // from class: com.blued.android.module.player.media.view.PLVideoPageView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PLVideoPageView.this.d == null || PLVideoPageView.this.i.getChildCount() <= 0) {
                    return;
                }
                PLVideoPageView.this.x();
                if (PLVideoPageView.this.a()) {
                    PLVideoPageView.this.z.postDelayed(PLVideoPageView.this.A, 100L);
                }
            }
        };
        this.B = new AnonymousClass2();
        this.n = new Runnable() { // from class: com.blued.android.module.player.media.view.PLVideoPageView.3
            @Override // java.lang.Runnable
            public void run() {
                PLVideoPageView.this.q.setVisibility(8);
            }
        };
        u();
    }

    private void a(long j) {
        synchronized (this) {
            try {
                if (this.t > j) {
                    StatisticsProxy.a().a(2, this.j.i, (int) (this.s / 1000));
                }
                this.t = j;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(View view, int i) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setDuration(i);
        view.setAnimation(alphaAnimation);
        alphaAnimation.start();
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        if (this.j == null || this.j.h == null) {
            return true;
        }
        this.j.h.onLongClick(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.j != null && this.j.j && this.j.k) {
            d();
        }
        if (this.j == null || this.j.g == null) {
            return;
        }
        this.j.g.onClick(view);
    }

    private void l() {
        if (this.d == null || this.j == null) {
            Log.d(m, "start mVideoView == null");
        } else if (!b()) {
            Log.d(m, "start mVideoRoot.getChildCount() == 0");
        } else {
            String str = m;
            Log.c(str, "startPlay: url = " + this.j.b);
            o();
            this.j.m = false;
            OnPLVideoListener onPLVideoListener = this.y;
            if (onPLVideoListener != null) {
                onPLVideoListener.c();
            }
            this.z.removeCallbacks(this.A);
            this.z.post(this.A);
            this.d.setOnVideoStatusListener(null);
            this.d.setOnVideoStatusListener(this.B);
            this.d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Log.c(m, "onPausePlay");
        n();
        p();
    }

    private void n() {
        if (this.j == null || this.j.m) {
            return;
        }
        this.z.removeCallbacks(this.A);
        if (this.i.getChildCount() == 0) {
            String str = m;
            Log.c(str, "onPausePlay mVideoRoot.getChildCount() == 0 id=" + this.i.getId());
            return;
        }
        String str2 = m;
        Log.c(str2, "pause url" + this.j.b);
        this.j.m = true;
        if (b()) {
            this.d.d();
        }
        OnPLVideoListener onPLVideoListener = this.y;
        if (onPLVideoListener != null) {
            onPLVideoListener.d();
        }
    }

    private void o() {
        t();
        if (this.j != null && !this.j.j && !a() && this.j.w) {
            this.h.setVisibility(0);
        }
        this.o.setVisibility(8);
        if (this.y == null || a()) {
            return;
        }
        this.y.a(0L, 0L);
        this.y.a();
    }

    private void p() {
        s();
        if (this.j != null && !this.j.j) {
            this.h.setVisibility(8);
        }
        OnPLVideoListener onPLVideoListener = this.y;
        if (onPLVideoListener != null) {
            onPLVideoListener.b();
        }
    }

    private AbBaseVideoView q() {
        Log.c(m, "initVideoView");
        return b(this.j.b);
    }

    private void r() {
        if (b()) {
            this.l.a(getPlayUrl(), this.d);
        } else {
            this.d = q();
        }
        if (this.i.getChildCount() == 0) {
            this.i.addView(this.d);
            String str = m;
            Log.c(str, "insetPlayTextureView new mVideoRoot URL = " + this.j.b);
        } else {
            Log.c(m, "insetPlayTextureView mVideoRoot.getChildCount() != 0");
        }
        this.d.a(this.j);
        this.d.a(true);
        post(new Runnable() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLVideoPageView$nn7OL-1Wzb_TPpOhGUCwuXB2Bm0
            @Override // java.lang.Runnable
            public final void run() {
                PLVideoPageView.this.y();
            }
        });
    }

    private void s() {
        if (this.j == null || !this.j.w) {
            return;
        }
        this.g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.g.setVisibility(8);
    }

    private void u() {
        this.f15662a = AppInfo.d();
        this.b = LayoutInflater.from(this.f15662a);
        this.f15663c = this.b.inflate(R.layout.pl_texture_video_view_new, this);
        this.i = (FrameLayout) this.f15663c.findViewById(R.id.video_root);
        this.p = (SeekBar) this.f15663c.findViewById(R.id.pl_seek_bar);
        this.o = (TextView) this.f15663c.findViewById(R.id.pl_tip);
        if (StatusBarHelper.a()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.topMargin += StatusBarHelper.a(this.f15662a);
            this.o.setLayoutParams(layoutParams);
        }
        this.q = (SeekBar) this.f15663c.findViewById(R.id.volume_bar);
        this.e = this.f15663c.findViewById(R.id.cover_view);
        this.e.setVisibility(0);
        this.f = (ImageView) this.f15663c.findViewById(R.id.preview);
        this.g = (ImageView) this.f15663c.findViewById(R.id.video_state_icon);
        this.h = this.f15663c.findViewById(R.id.LoadingView);
        this.p.setMax(1000);
        this.p.setPadding(0, 0, 0, 0);
        this.p.setVisibility(4);
        this.q.setMax(15);
        this.q.setProgress(10);
        this.q.setPadding(0, 0, 0, 0);
        this.q.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        String str = m;
        Log.c(str, "onRenderingStart mVideoPlayConfig.mIsPause " + this.j.m);
        if (this.j != null && this.j.m) {
            m();
            return;
        }
        t();
        if (this.f != null && this.f.getVisibility() == 0) {
            a(this.f, 300);
        }
        this.z.removeCallbacks(this.A);
        this.z.post(this.A);
        if (this.h != null && this.h.getVisibility() == 0) {
            this.h.setVisibility(8);
        }
        if (this.j != null && this.j.o) {
            k();
        }
        OnPLVideoListener onPLVideoListener = this.y;
        if (onPLVideoListener == null || this.x) {
            return;
        }
        this.x = true;
        onPLVideoListener.b();
        if (b()) {
            this.y.a((int) (this.d.getDuration() / 1000));
        }
    }

    private void w() {
        this.f.setVisibility(0);
        if (this.j != null && this.j.w) {
            this.g.setVisibility(0);
        }
        OnPLVideoListener onPLVideoListener = this.y;
        if (onPLVideoListener != null) {
            onPLVideoListener.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        SeekBar seekBar;
        if (a()) {
            long currentPosition = this.d.getCurrentPosition();
            long duration = this.d.getDuration();
            this.r = currentPosition;
            this.s = duration;
            a(currentPosition);
            if (this.j != null && this.j.j && (seekBar = this.p) != null && seekBar.getVisibility() == 0 && duration > 0) {
                long j = (((float) currentPosition) / ((float) duration)) * 1000.0f;
                long j2 = this.v;
                long j3 = j;
                if (j2 > j) {
                    j3 = j;
                    if (j2 != 1000) {
                        j3 = j;
                        if (j2 > 900) {
                            j3 = 1000;
                        }
                    }
                }
                this.p.setProgress((int) j3);
                this.v = j3;
            }
            OnPLVideoListener onPLVideoListener = this.y;
            if (onPLVideoListener != null) {
                onPLVideoListener.a(currentPosition, duration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        requestLayout();
    }

    public void a(long j, int i, OnSeekListener onSeekListener) {
        if (!b()) {
            Log.d(m, "seekTo discard, mVideoView = null");
            return;
        }
        String str = m;
        Log.c(str, "seekTo: time = " + j + ", duration = " + this.s);
        this.u = j;
        this.d.a(this.u);
        if (onSeekListener != null) {
            this.d.setSeekListener(onSeekListener);
        }
    }

    public void a(VideoPlayConfig videoPlayConfig, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        String str = m;
        Log.c(str, "loadVideoSource: url = " + videoPlayConfig.b);
        if (a(videoPlayConfig)) {
            this.f15663c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLVideoPageView$jz2Wb-owqo7i_s3Fgsj_pruhZ3c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PLVideoPageView.this.b(view);
                }
            });
            this.f15663c.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.player.media.view.-$$Lambda$PLVideoPageView$aeh22Jy6tESvagwyAzXbH9-teUg
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean a2;
                    a2 = PLVideoPageView.this.a(view);
                    return a2;
                }
            });
            if (this.j.j) {
                Utils.a(this.j);
            }
            this.o.setText(String.format(this.f15662a.getResources().getString(R.string.short_video_size_tip), String.format("%s", Long.valueOf(this.j.f15653c / 1024))));
            if (this.j.e != 0 && this.j.f != 0) {
                if (z) {
                    layoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
                    int[] a2 = Utils.a(this.j.e, this.j.f);
                    layoutParams.width = a2[0];
                    layoutParams.height = a2[1];
                } else {
                    layoutParams = new FrameLayout.LayoutParams(this.j.e, this.j.f);
                }
                layoutParams.gravity = 17;
                this.f.setLayoutParams(layoutParams);
            }
            if (TextUtils.isEmpty(this.j.f15652a)) {
                this.f.setVisibility(8);
                this.f.setImageResource(R.drawable.defaultpicture);
            } else {
                this.f.setVisibility(0);
                setCoverImageWithBlur(this.j.x);
            }
            if (this.j.m) {
                p();
            }
            this.x = false;
        }
    }

    public void a(boolean z) {
        Log.c(m, "onVisibleToUser");
        if (this.j != null && this.j.q) {
            if (z) {
                return;
            }
            g();
        } else if (z) {
            l();
        } else {
            j();
        }
    }

    public void b(VideoPlayConfig videoPlayConfig) {
        a(videoPlayConfig, false);
    }

    public void c() {
        if (this.j == null) {
            String str = m;
            Log.c(str, "startPlay discard, mPlayConfig = null + " + this);
        } else if (TextUtils.isEmpty(this.j.b)) {
            Log.e(m, "error: onStartPlay video url is empty");
        } else {
            String str2 = m;
            Log.c(str2, "startPlay() url = " + this.j.b);
            r();
            if (this.j.n) {
                this.p.setVisibility(0);
                this.p.setProgress(0);
            }
            l();
        }
    }

    public void d() {
        if (this.j == null) {
            return;
        }
        if (!this.j.m) {
            this.w = true;
            m();
            return;
        }
        this.w = false;
        if (this.d == null || this.i.getChildCount() == 0) {
            c();
        } else {
            l();
        }
    }

    public void e() {
        if (b()) {
            if (!TextUtils.isEmpty(this.j.i) && this.r >= m.ag) {
                try {
                    StatisticsProxy.a().a(2, this.j.i, (int) (this.r / 1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.r = 0L;
            this.s = 0L;
            this.t = 0L;
            this.x = false;
            this.d.f();
        }
    }

    public void f() {
        if (this.j == null) {
            return;
        }
        String str = m;
        Log.c(str, "onResume" + this.j.b);
        if (this.w || this.j.q || !this.j.m) {
            return;
        }
        if (!b()) {
            c();
            return;
        }
        l();
        this.h.setVisibility(8);
    }

    public void g() {
        if (this.j == null) {
            return;
        }
        if (this.j.q) {
            j();
            if (this.d != null) {
                this.d.c();
            }
            this.i.removeAllViews();
            Log.c(m, "onPauseDrop mVideoRoot.removeAllViews");
            return;
        }
        String str = m;
        Log.c(str, "onPause " + this.j.b);
        m();
    }

    public long getPlayTime() {
        return this.r;
    }

    public String getPlayUrl() {
        return this.j != null ? this.j.b : "";
    }

    public long getTotalTime() {
        return this.s;
    }

    public String getVideoUrl() {
        if (this.j != null) {
            return this.j.b;
        }
        return null;
    }

    public void h() {
        String str = m;
        Log.c(str, "onDestroy ##########:" + this);
        e();
        this.y = null;
        if (this.j != null) {
            if (this.j.g != null) {
                this.j.g = null;
            }
            if (this.j.h != null) {
                this.j.h = null;
            }
        }
        if (this.h != null) {
            this.h.setVisibility(8);
        }
        if (this.d != null) {
            this.d.c();
        }
        a(this.d);
    }

    public boolean i() {
        return this.g.getVisibility() == 0;
    }

    public void j() {
        Log.b(m, "resetLayout");
        m();
        w();
    }

    public void k() {
        if (this.j == null) {
            return;
        }
        if (!this.j.j) {
            j();
        } else if (this.j.o) {
            long duration = b() ? this.d.getDuration() : 0L;
            if (this.j.f15653c <= 0 || duration <= 16000) {
                Log.c(m, "video size is 0");
                return;
            }
            String str = m;
            Log.c(str, "video size is :" + this.j.f15653c + "  totalDuration:" + duration);
            if (this.j != null && this.j.w) {
                this.o.setVisibility(0);
            }
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.player.media.view.PLVideoPageView.4
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(PLVideoPageView.this.f15662a, R.anim.push_up_out);
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.player.media.view.PLVideoPageView.4.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            PLVideoPageView.this.o.setVisibility(8);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    PLVideoPageView.this.o.startAnimation(loadAnimation);
                }
            }, m.ag);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        String str = m;
        Log.c(str, "onAttachedToWindow: " + this);
        super.onAttachedToWindow();
        s();
        if (this.f != null) {
            this.f.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        String str = m;
        Log.c(str, "onDetachedFromWindow url = " + getPlayUrl() + ", " + this);
        if (b()) {
            this.d.f();
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setCoverImageWithBlur(boolean z) {
        if (this.j == null || TextUtils.isEmpty(this.j.f15652a) || this.f == null || this.f.getVisibility() != 0) {
            return;
        }
        ImageWrapper d = !this.j.f15652a.contains("http") ? ImageLoader.d(null, this.j.f15652a) : ImageLoader.a((IRequestHost) null, this.j.f15652a);
        if (z) {
            d.a(80);
        }
        d.b(R.drawable.defaultpicture).a(this.f);
    }

    public void setOnPLVideoListener(OnPLVideoListener onPLVideoListener) {
        this.y = onPLVideoListener;
    }

    @Deprecated
    public void setPauseDrop(boolean z) {
        if (this.j != null) {
            this.j.q = z;
        }
    }

    public void setVolumeProgress(int i) {
        this.q.setProgress(i);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setDuration(1000L);
        this.q.setAnimation(alphaAnimation);
        alphaAnimation.start();
        if (this.j != null && this.j.w) {
            this.q.setVisibility(0);
        }
        AppInfo.n().removeCallbacks(this.n);
        AppInfo.n().postDelayed(this.n, 1000L);
    }
}
