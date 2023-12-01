package com.opos.mobad.n.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/n.class */
public class n {
    public static Animator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 0.0f);
        ofFloat.setDuration(250L);
        float y = view.getY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("y", (view.getHeight() / 2) + y, y));
        ofPropertyValuesHolder.setDuration(267L);
        ofPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofPropertyValuesHolder);
        return animatorSet;
    }

    public static Animator a(RelativeLayout relativeLayout) {
        relativeLayout.removeAllViews();
        Context context = relativeLayout.getContext();
        int a2 = com.opos.cmn.an.h.f.a.a(context, 141.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, -1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.opos_mobad_btn_splash);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setAlpha(0.0f);
        relativeLayout.addView(imageView, layoutParams);
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("x", a2 * (-1), relativeLayout.getWidth()), PropertyValuesHolder.ofFloat("alpha", 1.0f, 1.0f));
        ofPropertyValuesHolder.setDuration(1217L);
        ofPropertyValuesHolder.setInterpolator(create);
        ofPropertyValuesHolder.setStartDelay(217L);
        ofPropertyValuesHolder.setRepeatCount(-1);
        return ofPropertyValuesHolder;
    }

    public static Animator a(final com.opos.mobad.n.c.e eVar) {
        Context context = eVar.getContext();
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar, "alpha", 1.0f, 1.0f);
        c cVar = new c();
        cVar.a(new j(create, 0.5f, 1.0f), 450L);
        cVar.a(new j(create, 1.0f, 0.0f), 400L);
        cVar.a(new j(create, 0.0f, 0.0f), 70L);
        ofFloat.setEvaluator(cVar);
        ofFloat.setDuration(920L);
        ofFloat.setRepeatCount(-1);
        float a2 = com.opos.cmn.an.h.f.a.a(context, 30.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(a2, a2);
        c cVar2 = new c();
        cVar2.a(new j(create, a2, 0.0f), 450L);
        cVar2.a(new j(create, 0.0f, 0.0f), 400L);
        cVar2.a(new j(create, a2, a2), 70L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.n.a.n.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                com.opos.mobad.n.c.e.this.a(((Float) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofFloat2.setEvaluator(cVar2);
        ofFloat2.setDuration(920L);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public static Animator b(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 0.0f);
        ofFloat.setDuration(250L);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        ofPropertyValuesHolder.setDuration(267L);
        ofPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofPropertyValuesHolder);
        return animatorSet;
    }

    public static Animator b(final com.opos.mobad.n.c.e eVar) {
        int a2 = com.opos.cmn.an.h.f.a.a(eVar.getContext(), 28.0f);
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ValueAnimator ofInt = ValueAnimator.ofInt(a2, 0);
        ofInt.setDuration(333L);
        ofInt.setInterpolator(create);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.n.a.n.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                com.opos.mobad.n.c.e.this.setAlpha(1.0f);
                com.opos.mobad.n.c.e.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, 0);
        ofInt2.setDuration(83L);
        ofInt2.setInterpolator(create);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(a2, 0);
        ofInt3.setDuration(333L);
        ofInt3.setInterpolator(create);
        ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.n.a.n.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                com.opos.mobad.n.c.e.this.setAlpha(1.0f);
                com.opos.mobad.n.c.e.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(eVar, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(167L);
        ofFloat2.setInterpolator(create);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofInt, ofFloat, ofInt2, ofInt3, ofFloat2);
        return animatorSet;
    }

    public static Animator c(View view) {
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        int a2 = com.opos.cmn.an.h.f.a.a(view.getContext(), 10.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(view.getContext(), 5.0f);
        int a4 = com.opos.cmn.an.h.f.a.a(view.getContext(), 3.0f);
        float x = view.getX();
        float f = a2;
        float f2 = f + x;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "x", x, f2);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(create);
        float f3 = x - f;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "x", f2, f3);
        ofFloat2.setDuration(133L);
        ofFloat2.setInterpolator(create);
        float f4 = a3 + x;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "x", f3, f4);
        ofFloat3.setDuration(100L);
        ofFloat3.setInterpolator(create);
        float f5 = x - a4;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "x", f4, f5);
        ofFloat4.setDuration(83L);
        ofFloat4.setInterpolator(create);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "x", f5, x);
        ofFloat5.setDuration(67L);
        ofFloat5.setInterpolator(create);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        return animatorSet;
    }

    public static Animator d(View view) {
        Context context = view.getContext();
        view.setPivotX(com.opos.cmn.an.h.f.a.a(context, 60.0f));
        view.setPivotY(com.opos.cmn.an.h.f.a.a(context, 60.0f));
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 0.0f);
        c cVar = new c();
        cVar.a(new j(create, 0.0f, 30.0f), 250L);
        cVar.a(new j(create, 30.0f, -25.0f), 217L);
        cVar.a(new j(create, -25.0f, 15.0f), 167L);
        cVar.a(new j(create, 15.0f, -10.0f), 167L);
        cVar.a(new j(create, -10.0f, 5.0f), 133L);
        cVar.a(new j(create, 5.0f, 0.0f), 117L);
        cVar.a(new j(create, 0.0f, 0.0f), 617L);
        ofFloat.setEvaluator(cVar);
        ofFloat.setDuration(cVar.a());
        ofFloat.setRepeatCount(-1);
        return ofFloat;
    }
}
