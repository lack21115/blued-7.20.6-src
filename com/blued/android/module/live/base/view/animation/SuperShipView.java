package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/SuperShipView.class */
public class SuperShipView extends BaseLiveAnimationView {
    private Context b;
    private LayoutInflater c;
    private View d;
    private FrameLayout e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private TranslateAnimation p;
    private Handler q = new Handler();
    private AnimationDrawable r;
    private AnimationDrawable s;
    private AnimationDrawable t;
    private AnimationDrawable u;

    public SuperShipView(Context context) {
        this.b = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageView imageView) {
        imageView.setVisibility(0);
        this.t = new AnimationDrawable();
        for (int i = 0; i <= 12; i++) {
            this.t.addFrame(this.b.getResources().getDrawable(this.b.getResources().getIdentifier("sea_wave1_" + i, "drawable", this.b.getPackageName())), 30);
        }
        imageView.setImageDrawable(this.t);
        this.t.start();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.5
            @Override // java.lang.Runnable
            public void run() {
                imageView.clearAnimation();
            }
        }, 4000L);
    }

    private void b() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = from;
        View inflate = from.inflate(R.layout.layout_sports_ship_anim, (ViewGroup) null);
        this.d = inflate;
        this.e = (FrameLayout) inflate.findViewById(R.id.ship_root_view);
        this.f = (ImageView) this.d.findViewById(R.id.sea_surface);
        this.g = (ImageView) this.d.findViewById(R.id.ship_smoke);
        this.h = (ImageView) this.d.findViewById(R.id.sea_wave1);
        this.i = (ImageView) this.d.findViewById(R.id.sea_wave1_1);
        this.j = (ImageView) this.d.findViewById(R.id.sea_wave1_2);
        this.k = (ImageView) this.d.findViewById(R.id.sea_wave1_3);
        this.l = (ImageView) this.d.findViewById(R.id.sea_wave2);
        this.m = (ImageView) this.d.findViewById(R.id.sea_wave2_1);
        this.n = (ImageView) this.d.findViewById(R.id.sea_wave2_2);
        this.o = (ImageView) this.d.findViewById(R.id.sea_wave2_3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final ImageView imageView) {
        imageView.setVisibility(0);
        this.u = new AnimationDrawable();
        for (int i = 0; i <= 8; i++) {
            this.u.addFrame(this.b.getResources().getDrawable(this.b.getResources().getIdentifier("sea_wave2_" + i, "drawable", this.b.getPackageName())), 100);
        }
        imageView.setImageDrawable(this.u);
        this.u.start();
        this.q.postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.6
            @Override // java.lang.Runnable
            public void run() {
                imageView.setVisibility(8);
                imageView.clearAnimation();
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        this.d.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SuperShipView.this.d.setVisibility(8);
                SuperShipView.this.q.removeCallbacksAndMessages(null);
                SuperShipView.this.r = null;
                SuperShipView.this.s = null;
                SuperShipView.this.t = null;
                SuperShipView.this.u = null;
                if (SuperShipView.this.a != null) {
                    SuperShipView.this.a.b();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f.setVisibility(0);
        this.r = new AnimationDrawable();
        for (int i = 0; i <= 9; i++) {
            this.r.addFrame(this.b.getResources().getDrawable(this.b.getResources().getIdentifier("sea_" + i, "drawable", this.b.getPackageName())), 300);
        }
        this.f.setBackgroundDrawable(this.r);
        this.r.start();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.3
            @Override // java.lang.Runnable
            public void run() {
                SuperShipView.this.f.clearAnimation();
            }
        }, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.g.setVisibility(0);
        this.s = new AnimationDrawable();
        for (int i = 0; i <= 14; i++) {
            this.s.addFrame(this.b.getResources().getDrawable(this.b.getResources().getIdentifier("ship_smoke_" + i, "drawable", this.b.getPackageName())), 150);
        }
        this.g.setImageDrawable(this.s);
        this.s.start();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.4
            @Override // java.lang.Runnable
            public void run() {
                SuperShipView.this.g.clearAnimation();
            }
        }, 4000L);
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public View a() {
        return this.d;
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(IRequestHost iRequestHost) {
        this.d.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1500L);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.4f, 2, -0.1f, 2, -0.1f, 2, 0.0f);
        this.p = translateAnimation;
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.p.setDuration(4000L);
        this.p.setFillAfter(true);
        this.e.startAnimation(this.p);
        this.d.startAnimation(alphaAnimation);
        this.p.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (SuperShipView.this.a != null) {
                    SuperShipView.this.a.a();
                }
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SuperShipView.this.c();
                    }
                }, 3000L);
                SuperShipView.this.d();
                SuperShipView.this.e();
                SuperShipView superShipView = SuperShipView.this;
                superShipView.a(superShipView.h);
                SuperShipView superShipView2 = SuperShipView.this;
                superShipView2.a(superShipView2.i);
                SuperShipView superShipView3 = SuperShipView.this;
                superShipView3.a(superShipView3.j);
                SuperShipView superShipView4 = SuperShipView.this;
                superShipView4.a(superShipView4.k);
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SuperShipView.this.b(SuperShipView.this.l);
                    }
                }, 700L);
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SuperShipView.this.b(SuperShipView.this.n);
                    }
                }, 1300L);
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SuperShipView.this.b(SuperShipView.this.m);
                    }
                }, 1800L);
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperShipView.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        SuperShipView.this.b(SuperShipView.this.o);
                    }
                }, 2000L);
            }
        });
    }
}
