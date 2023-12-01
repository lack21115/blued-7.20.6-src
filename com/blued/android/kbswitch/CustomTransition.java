package com.blued.android.kbswitch;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.blued.android.kbswitch.utils.UtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/CustomTransition.class */
public final class CustomTransition extends Transition {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f10409a = new Companion(null);

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/CustomTransition$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final int a(int i, int i2, float f) {
        return i + ((int) (i2 * f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, Rect rect, int i, int i2, int i3, ValueAnimator valueAnimator) {
        Intrinsics.e(view, "$view");
        float animatedFraction = valueAnimator.getAnimatedFraction();
        int a2 = a(rect.left, i, animatedFraction);
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        view.setPaddingRelative(a2, ((Integer) animatedValue).intValue(), a(rect.right, i2, animatedFraction), a(rect.bottom, i3, animatedFraction));
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        Intrinsics.e(transitionValues, "transitionValues");
        Map<String, Object> map = transitionValues.values;
        Intrinsics.c(map, "transitionValues.values");
        View it = transitionValues.view;
        Intrinsics.c(it, "it");
        Rect a2 = UtilsKt.a(it, false, 1, (Object) null);
        Rect rect = a2;
        if (a2 == null) {
            rect = UtilsKt.a(it, 0, 0, 0, 0, 15, (Object) null);
        }
        map.put("com.blued.kbSwitch:transition:padding", rect);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        Intrinsics.e(transitionValues, "transitionValues");
        Map<String, Object> map = transitionValues.values;
        Intrinsics.c(map, "transitionValues.values");
        View view = transitionValues.view;
        Intrinsics.c(view, "transitionValues.view");
        map.put("com.blued.kbSwitch:transition:padding", UtilsKt.a(view, 0, 0, 0, 0, 15, (Object) null));
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Intrinsics.e(sceneRoot, "sceneRoot");
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        final View view = transitionValues2.view;
        Intrinsics.c(view, "endValues.view");
        final Rect rect = (Rect) transitionValues.values.get("com.blued.kbSwitch:transition:padding");
        final Rect rect2 = (Rect) transitionValues2.values.get("com.blued.kbSwitch:transition:padding");
        if (rect == null || rect2 == null || Intrinsics.a(rect, rect2)) {
            return null;
        }
        ValueAnimator animator = ValueAnimator.ofInt(rect.top, rect2.top);
        int i = rect2.left;
        int i2 = rect.left;
        int i3 = rect2.right;
        int i4 = rect.right;
        int i5 = rect2.bottom;
        int i6 = rect.bottom;
        Intrinsics.c(animator, "animator");
        ValueAnimator valueAnimator = animator;
        valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.kbswitch.CustomTransition$createAnimator$$inlined$doOnStart$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                Intrinsics.e(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Intrinsics.e(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                Intrinsics.e(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                Intrinsics.e(animator2, "animator");
                Rect rect3 = Rect.this;
                view.setPaddingRelative(rect3.left, rect3.top, rect3.right, rect3.bottom);
            }
        });
        final int i7 = i - i2;
        final int i8 = i3 - i4;
        final int i9 = i5 - i6;
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.kbswitch.-$$Lambda$CustomTransition$sY5Y4kC3wkAjZzAfZ2PKGnQIi20
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CustomTransition.a(View.this, rect, i7, i8, i9, valueAnimator2);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.kbswitch.CustomTransition$createAnimator$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                Intrinsics.e(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Intrinsics.e(animator2, "animator");
                Rect rect3 = Rect.this;
                view.setPaddingRelative(rect3.left, rect3.top, rect3.right, rect3.bottom);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                Intrinsics.e(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                Intrinsics.e(animator2, "animator");
            }
        });
        return valueAnimator;
    }
}
