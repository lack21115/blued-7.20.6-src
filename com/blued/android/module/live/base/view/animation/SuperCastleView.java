package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/SuperCastleView.class */
public class SuperCastleView extends BaseLiveAnimationView {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f11522c;
    private View d;
    private FrameLayout e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private FrameLayout i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private AnimationDrawable q;
    private AnimationDrawable r;

    public SuperCastleView(Context context) {
        this.b = context;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageView imageView) {
        imageView.setVisibility(0);
        this.r = new AnimationDrawable();
        for (int i = 0; i <= 20; i++) {
            this.r.addFrame(this.b.getResources().getDrawable(this.b.getResources().getIdentifier("fireworks_" + i, i.f7952c, this.b.getPackageName())), 50);
        }
        this.r.setOneShot(true);
        imageView.setImageDrawable(this.r);
        this.r.start();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperCastleView.9
            @Override // java.lang.Runnable
            public void run() {
                imageView.setVisibility(8);
                imageView.clearAnimation();
                SuperCastleView.this.r = null;
            }
        }, 1050L);
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f11522c = from;
        View inflate = from.inflate(R.layout.layout_sports_castle_anim, (ViewGroup) null);
        this.d = inflate;
        this.e = (FrameLayout) inflate.findViewById(R.id.cloud_layout);
        this.f = (ImageView) this.d.findViewById(R.id.cloud1);
        this.g = (ImageView) this.d.findViewById(R.id.cloud2);
        this.h = (ImageView) this.d.findViewById(R.id.cloud3);
        this.i = (FrameLayout) this.d.findViewById(R.id.castle_root);
        this.j = (ImageView) this.d.findViewById(R.id.super_castle);
        this.k = (ImageView) this.d.findViewById(R.id.castle_flag);
        this.l = (ImageView) this.d.findViewById(R.id.fireworks1);
        this.m = (ImageView) this.d.findViewById(R.id.fireworks2);
        this.n = (ImageView) this.d.findViewById(R.id.fireworks3);
        this.o = (ImageView) this.d.findViewById(R.id.fireworks4);
        this.p = (ImageView) this.d.findViewById(R.id.fireworks5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        this.d.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperCastleView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SuperCastleView.this.d.setVisibility(8);
                SuperCastleView.this.e.setVisibility(8);
                if (SuperCastleView.this.f11493a != null) {
                    SuperCastleView.this.f11493a.b();
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
    public void e() {
        this.k.setVisibility(0);
        this.q = new AnimationDrawable();
        for (int i = 0; i <= 23; i++) {
            this.q.addFrame(this.b.getResources().getDrawable(this.b.getResources().getIdentifier("castle_flag_" + i, i.f7952c, this.b.getPackageName())), 50);
        }
        this.k.setImageDrawable(this.q);
        this.q.start();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperCastleView.8
            @Override // java.lang.Runnable
            public void run() {
                SuperCastleView.this.k.clearAnimation();
                SuperCastleView.this.q = null;
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
        alphaAnimation.setDuration(1000L);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(m.ag);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(true);
        this.i.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperCastleView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SuperCastleView.this.d();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (SuperCastleView.this.f11493a != null) {
                    SuperCastleView.this.f11493a.a();
                }
                SuperCastleView.this.e();
                SuperCastleView.this.b();
            }
        });
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperCastleView.2
            @Override // java.lang.Runnable
            public void run() {
                SuperCastleView superCastleView = SuperCastleView.this;
                superCastleView.a(superCastleView.l);
            }
        }, 400L);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperCastleView.3
            @Override // java.lang.Runnable
            public void run() {
                SuperCastleView superCastleView = SuperCastleView.this;
                superCastleView.a(superCastleView.m);
            }
        }, 1100L);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperCastleView.4
            @Override // java.lang.Runnable
            public void run() {
                SuperCastleView superCastleView = SuperCastleView.this;
                superCastleView.a(superCastleView.n);
            }
        }, 1700L);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperCastleView.5
            @Override // java.lang.Runnable
            public void run() {
                SuperCastleView superCastleView = SuperCastleView.this;
                superCastleView.a(superCastleView.o);
            }
        }, 2300L);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperCastleView.6
            @Override // java.lang.Runnable
            public void run() {
                SuperCastleView superCastleView = SuperCastleView.this;
                superCastleView.a(superCastleView.p);
            }
        }, 2700L);
    }

    public void b() {
        this.e.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -0.4f, 2, 0.1f, 2, -0.2f, 2, -0.2f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(18000L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.h.startAnimation(animationSet);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.3f, 2, 0.4f, 2, -0.3f, 2, -0.3f);
        translateAnimation2.setInterpolator(new LinearInterpolator());
        translateAnimation2.setDuration(10000L);
        AnimationSet animationSet2 = new AnimationSet(false);
        animationSet2.addAnimation(alphaAnimation);
        animationSet2.addAnimation(translateAnimation2);
        this.f.startAnimation(animationSet2);
        TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.2f, 2, 0.3f, 2, -0.12f, 2, -0.12f);
        translateAnimation3.setInterpolator(new LinearInterpolator());
        translateAnimation3.setDuration(10000L);
        AnimationSet animationSet3 = new AnimationSet(false);
        animationSet3.addAnimation(alphaAnimation);
        animationSet3.addAnimation(translateAnimation3);
        this.g.startAnimation(animationSet3);
    }
}
