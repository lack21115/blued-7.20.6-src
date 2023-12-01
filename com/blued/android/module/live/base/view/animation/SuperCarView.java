package com.blued.android.module.live.base.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/SuperCarView.class */
public class SuperCarView extends BaseLiveAnimationView {
    private Context b;
    private LayoutInflater c;
    private View d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private TranslateAnimation m;
    private TranslateAnimation n;
    private AnimationDrawable o;

    public SuperCarView(Context context) {
        this.b = context;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Interpolator interpolator, long j) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -1080.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(j);
        rotateAnimation.setInterpolator(interpolator);
        this.f.startAnimation(rotateAnimation);
        this.g.startAnimation(rotateAnimation);
    }

    private void e() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = from;
        View inflate = from.inflate(R.layout.layout_sports_car_anim, (ViewGroup) null);
        this.d = inflate;
        this.e = (ImageView) inflate.findViewById(R.id.super_car);
        this.f = (ImageView) this.d.findViewById(R.id.super_wheel1);
        this.g = (ImageView) this.d.findViewById(R.id.super_wheel2);
        this.h = (ImageView) this.d.findViewById(R.id.car_flash_light);
        this.i = (ImageView) this.d.findViewById(R.id.car_lightning);
        this.j = (ImageView) this.d.findViewById(R.id.automative_lighting);
        this.l = (ImageView) this.d.findViewById(R.id.car_right_door);
        this.k = (ImageView) this.d.findViewById(R.id.car_left_door);
        this.h.setVisibility(8);
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -1.0f, 0, 0.0f, 0, 0.0f);
        this.n = translateAnimation;
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        this.n.setDuration(1000L);
        this.d.startAnimation(this.n);
        this.n.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperCarView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SuperCarView.this.d.setVisibility(8);
                if (SuperCarView.this.a != null) {
                    SuperCarView.this.a.b();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                SuperCarView.this.a(new AccelerateInterpolator(), 1000L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.h.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.h, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.h, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live.base.view.animation.SuperCarView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SuperCarView.this.h.setVisibility(8);
            }
        });
        animatorSet.setDuration(800L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.i.setVisibility(0);
        this.o = new AnimationDrawable();
        for (int i = 0; i <= 36; i++) {
            this.o.addFrame(this.b.getResources().getDrawable(this.b.getResources().getIdentifier("lightning_" + i, "drawable", this.b.getPackageName())), 50);
        }
        this.o.setOneShot(true);
        this.i.setImageDrawable(this.o);
        this.o.start();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperCarView.7
            @Override // java.lang.Runnable
            public void run() {
                SuperCarView.this.i.setVisibility(8);
                SuperCarView.this.i.clearAnimation();
                SuperCarView.this.o = null;
            }
        }, 1800L);
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public View a() {
        return this.d;
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(IRequestHost iRequestHost) {
        this.d.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 0, 0.0f, 0, 0.0f);
        this.m = translateAnimation;
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        this.m.setDuration(1000L);
        this.m.setFillAfter(true);
        this.d.startAnimation(this.m);
        this.m.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperCarView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SuperCarView.this.g();
                SuperCarView.this.c();
                SuperCarView.this.h();
                SuperCarView.this.b();
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.SuperCarView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SuperCarView.this.d();
                    }
                }, 2000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (SuperCarView.this.a != null) {
                    SuperCarView.this.a.a();
                }
                SuperCarView.this.a(new DecelerateInterpolator(), 1000L);
            }
        });
    }

    public void b() {
        this.j.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.j, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.j, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.j, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.j, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live.base.view.animation.SuperCarView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SuperCarView.this.j.setVisibility(8);
            }
        });
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    public void c() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -35.0f, 1, 0.0f, 1, 0.4f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        this.k.startAnimation(rotateAnimation);
        this.l.startAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperCarView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void d() {
        RotateAnimation rotateAnimation = new RotateAnimation(-35.0f, 0.0f, 1, 0.0f, 1, 0.4f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        this.k.startAnimation(rotateAnimation);
        this.l.startAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.view.animation.SuperCarView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SuperCarView.this.f();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }
}
