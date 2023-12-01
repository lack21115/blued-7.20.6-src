package com.blued.android.module.media.selector.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.view.ActionSheet;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ViewUtils.class */
public class ViewUtils {

    /* renamed from: com.blued.android.module.media.selector.utils.ViewUtils$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ViewUtils$1.class */
    class AnonymousClass1 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f15594a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f15594a;
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

    /* renamed from: com.blued.android.module.media.selector.utils.ViewUtils$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ViewUtils$3.class */
    class AnonymousClass3 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f15596a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f15596a;
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

    /* renamed from: com.blued.android.module.media.selector.utils.ViewUtils$9  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ViewUtils$9.class */
    class AnonymousClass9 implements ActionSheet.ActionSheetListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f15601a;

        @Override // com.blued.android.module.media.selector.view.ActionSheet.ActionSheetListener
        public void a(ActionSheet actionSheet, int i) {
            if (StringUtils.b(this.f15601a)) {
                return;
            }
            Tools.d(this.f15601a);
        }

        @Override // com.blued.android.module.media.selector.view.ActionSheet.ActionSheetListener
        public void a(ActionSheet actionSheet, boolean z) {
        }
    }

    public static void a(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.vr_anim_bottom_in));
    }

    public static void a(final View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(100L);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(50L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.media.selector.utils.ViewUtils.5
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
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.media.selector.utils.ViewUtils.6
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

    public static void b(Context context, final View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.vr_anim_bottom_out);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.media.selector.utils.ViewUtils.2
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

    public static void b(final View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5f, 1.1f, 0.5f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100L);
        final ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation3.setDuration(50L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.media.selector.utils.ViewUtils.7
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
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.media.selector.utils.ViewUtils.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View.this.startAnimation(scaleAnimation3);
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

    public static void c(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.vr_anim_top_in));
    }

    public static void d(Context context, final View view) {
        if (view == null || context == null) {
            return;
        }
        view.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.vr_anim_top_out);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.media.selector.utils.ViewUtils.4
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
}
