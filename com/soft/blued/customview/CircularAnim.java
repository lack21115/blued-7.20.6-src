package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CircularAnim.class */
public class CircularAnim {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CircularAnim$FullActivityBuilder.class */
    public static class FullActivityBuilder {

        /* renamed from: a  reason: collision with root package name */
        private Activity f28378a;
        private View b;

        /* renamed from: c  reason: collision with root package name */
        private float f28379c;
        private OnAnimationEndListener d;
        private int e;
        private int f;

        /* renamed from: com.soft.blued.customview.CircularAnim$FullActivityBuilder$1  reason: invalid class name */
        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CircularAnim$FullActivityBuilder$1.class */
        class AnonymousClass1 extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ImageView f28380a;
            final /* synthetic */ int b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f28381c;
            final /* synthetic */ int d;
            final /* synthetic */ long e;
            final /* synthetic */ ViewGroup f;
            final /* synthetic */ FullActivityBuilder g;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.g.a();
                this.g.f28378a.overridePendingTransition(this.g.e, this.g.f);
                this.g.b.postDelayed(new Runnable() { // from class: com.soft.blued.customview.CircularAnim.FullActivityBuilder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass1.this.g.f28378a.isFinishing()) {
                            return;
                        }
                        try {
                            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(AnonymousClass1.this.f28380a, AnonymousClass1.this.b, AnonymousClass1.this.f28381c, AnonymousClass1.this.d, AnonymousClass1.this.g.f28379c);
                            createCircularReveal.setDuration(AnonymousClass1.this.e);
                            createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.customview.CircularAnim.FullActivityBuilder.1.1.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    super.onAnimationEnd(animator2);
                                    try {
                                        AnonymousClass1.this.f.removeView(AnonymousClass1.this.f28380a);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            createCircularReveal.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                            try {
                                AnonymousClass1.this.f.removeView(AnonymousClass1.this.f28380a);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }, 1000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.d.a();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CircularAnim$OnAnimationEndListener.class */
    public interface OnAnimationEndListener {
        void a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CircularAnim$VisibleBuilder.class */
    public static class VisibleBuilder {

        /* renamed from: a  reason: collision with root package name */
        private View f28384a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private OnAnimationEndListener f28385c;

        /* renamed from: com.soft.blued.customview.CircularAnim$VisibleBuilder$1  reason: invalid class name */
        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CircularAnim$VisibleBuilder$1.class */
        class AnonymousClass1 extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ VisibleBuilder f28386a;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.f28386a.a();
            }
        }

        /* renamed from: com.soft.blued.customview.CircularAnim$VisibleBuilder$2  reason: invalid class name */
        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CircularAnim$VisibleBuilder$2.class */
        class AnonymousClass2 extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ VisibleBuilder f28387a;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.f28387a.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.b) {
                this.f28384a.setVisibility(0);
            } else {
                this.f28384a.setVisibility(4);
            }
            OnAnimationEndListener onAnimationEndListener = this.f28385c;
            if (onAnimationEndListener != null) {
                onAnimationEndListener.a();
            }
        }
    }
}
