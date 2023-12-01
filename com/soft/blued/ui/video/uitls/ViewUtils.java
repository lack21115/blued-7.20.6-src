package com.soft.blued.ui.video.uitls;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import java.lang.reflect.Method;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/uitls/ViewUtils.class */
public class ViewUtils {

    /* renamed from: com.soft.blued.ui.video.uitls.ViewUtils$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/uitls/ViewUtils$1.class */
    class AnonymousClass1 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20778a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f20778a;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.soft.blued.ui.video.uitls.ViewUtils$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/uitls/ViewUtils$2.class */
    class AnonymousClass2 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20779a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f20779a;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.soft.blued.ui.video.uitls.ViewUtils$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/uitls/ViewUtils$3.class */
    class AnonymousClass3 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20780a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f20780a;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.soft.blued.ui.video.uitls.ViewUtils$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/uitls/ViewUtils$4.class */
    class AnonymousClass4 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20781a;
        final /* synthetic */ ScaleAnimation b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f20781a.startAnimation(this.b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.soft.blued.ui.video.uitls.ViewUtils$5  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/uitls/ViewUtils$5.class */
    class AnonymousClass5 implements Animation.AnimationListener {
        AnonymousClass5() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static int a(View view) {
        try {
            String name = view.getClass().getPackage().getName();
            Method declaredMethod = (TextUtils.isEmpty(name) || !name.startsWith("skin.support")) ? view.getClass().getDeclaredMethod("onMeasure", Integer.TYPE, Integer.TYPE) : view.getClass().getSuperclass().getDeclaredMethod("onMeasure", Integer.TYPE, Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(view, Integer.valueOf(View.MeasureSpec.makeMeasureSpec(((View) view.getParent()).getMeasuredWidth(), Integer.MIN_VALUE)), Integer.valueOf(View.MeasureSpec.makeMeasureSpec(0, 0)));
        } catch (Exception e) {
        }
        return view.getMeasuredHeight();
    }
}
