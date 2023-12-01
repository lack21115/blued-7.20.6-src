package com.blued.android.module.shortvideo.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import com.blued.android.module.shortvideo.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvViewUtils.class */
public class StvViewUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Animation f15863a;

    /* renamed from: com.blued.android.module.shortvideo.utils.StvViewUtils$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvViewUtils$1.class */
    class AnonymousClass1 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f15864a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f15864a;
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

    /* renamed from: com.blued.android.module.shortvideo.utils.StvViewUtils$7  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvViewUtils$7.class */
    class AnonymousClass7 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f15869a;
        final /* synthetic */ ScaleAnimation b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f15869a.startAnimation(this.b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.blued.android.module.shortvideo.utils.StvViewUtils$8  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvViewUtils$8.class */
    class AnonymousClass8 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f15870a;
        final /* synthetic */ ScaleAnimation b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f15870a.startAnimation(this.b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static void a(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.stv_anim_bottom_in));
    }

    public static void a(final View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(100L);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(50L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.shortvideo.utils.StvViewUtils.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View.this.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.shortvideo.utils.StvViewUtils.6
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
        view.startAnimation(scaleAnimation);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i, i2, i3, i4);
            view.requestLayout();
        }
    }

    public static void a(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setAlpha(1.0f);
        } else {
            view.setAlpha(0.6f);
        }
        view.setEnabled(z);
    }

    public static void b(Context context, final View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.stv_anim_bottom_out);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.shortvideo.utils.StvViewUtils.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view2 = View.this;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.setAnimation(loadAnimation);
    }

    public static void c(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.stv_anim_right_in));
    }

    public static void d(Context context, final View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.stv_anim_right_out);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.shortvideo.utils.StvViewUtils.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view2 = View.this;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.setAnimation(loadAnimation);
    }

    public static void e(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.stv_anim_top_in));
    }

    public static void f(Context context, final View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.stv_anim_top_out);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.shortvideo.utils.StvViewUtils.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view2 = View.this;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.setAnimation(loadAnimation);
    }

    public static void g(Context context, View view) {
        if (f15863a == null) {
            f15863a = AnimationUtils.loadAnimation(context, R.anim.stv_button_shake_anim);
        }
        view.startAnimation(f15863a);
    }
}
