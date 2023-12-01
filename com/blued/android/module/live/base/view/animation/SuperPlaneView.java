package com.blued.android.module.live.base.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/SuperPlaneView.class */
public class SuperPlaneView extends BaseLiveAnimationView {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f11532c;
    private View d;
    private View e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private FrameLayout i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private TranslateAnimation m;
    private TranslateAnimation n;

    public SuperPlaneView(Context context) {
        this.b = context;
        e();
    }

    private void e() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f11532c = from;
        View inflate = from.inflate(R.layout.layout_sports_plane_anim, (ViewGroup) null);
        this.d = inflate;
        this.e = inflate.findViewById(R.id.plane_root_view);
        this.f = (ImageView) this.d.findViewById(R.id.plane_back_propeller);
        this.g = (ImageView) this.d.findViewById(R.id.super_plane);
        this.h = (ImageView) this.d.findViewById(R.id.plane_propeller);
        this.i = (FrameLayout) this.d.findViewById(R.id.cloud_layout);
        this.j = (ImageView) this.d.findViewById(R.id.cloud1);
        this.k = (ImageView) this.d.findViewById(R.id.cloud2);
        this.l = (ImageView) this.d.findViewById(R.id.cloud3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        this.i.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperPlaneView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SuperPlaneView.this.i.setVisibility(8);
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
    public void g() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.3f);
        this.n = translateAnimation;
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        this.n.setDuration(1000L);
        this.e.startAnimation(this.n);
        this.n.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperPlaneView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SuperPlaneView.this.f11493a != null) {
                    SuperPlaneView.this.f11493a.b();
                }
                SuperPlaneView.this.e.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                SuperPlaneView.this.f();
            }
        });
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public View a() {
        return this.d;
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(IRequestHost iRequestHost) {
        this.e.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, -0.3f, 2, 0.0f);
        this.m = translateAnimation;
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        this.m.setDuration(1000L);
        this.m.setFillAfter(true);
        this.e.startAnimation(this.m);
        this.m.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperPlaneView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SuperPlaneView.this.c();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (SuperPlaneView.this.f11493a != null) {
                    SuperPlaneView.this.f11493a.a();
                }
                SuperPlaneView.this.d();
                SuperPlaneView.this.b();
            }
        });
    }

    public void b() {
        this.i.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(2000L);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, 1.0f, 2, 0.5f, 2, -0.3f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(5500L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setFillAfter(true);
        this.l.startAnimation(animationSet);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, -0.3f, 2, 1.0f, 2, 0.2f, 2, -0.3f);
        translateAnimation2.setInterpolator(new LinearInterpolator());
        translateAnimation2.setDuration(7000L);
        AnimationSet animationSet2 = new AnimationSet(false);
        animationSet2.addAnimation(alphaAnimation);
        animationSet2.addAnimation(translateAnimation2);
        animationSet2.setFillAfter(true);
        this.j.startAnimation(animationSet2);
        TranslateAnimation translateAnimation3 = new TranslateAnimation(2, -0.8f, 2, 1.0f, 2, 0.4f, 2, -0.3f);
        translateAnimation3.setInterpolator(new LinearInterpolator());
        translateAnimation3.setDuration(12000L);
        AnimationSet animationSet3 = new AnimationSet(false);
        animationSet3.addAnimation(alphaAnimation);
        animationSet3.addAnimation(translateAnimation3);
        animationSet3.setFillAfter(true);
        this.k.startAnimation(animationSet3);
    }

    public void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e, "translationX", 0.0f, 30.0f, -30.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.e, "translationY", 0.0f, -30.0f, -30.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(2000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration(2000L);
        ofFloat.start();
        ofFloat2.start();
        ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live.base.view.animation.SuperPlaneView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SuperPlaneView.this.g();
            }
        });
    }

    public void d() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 1080.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(700L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.f.startAnimation(rotateAnimation);
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 3600.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation2.setDuration(5000L);
        rotateAnimation2.setRepeatCount(-1);
        rotateAnimation2.setInterpolator(new LinearInterpolator());
        this.h.startAnimation(rotateAnimation2);
    }
}
