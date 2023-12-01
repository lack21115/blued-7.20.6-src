package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ChangeScroll.class */
public class ChangeScroll extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f3378a = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(TransitionValues transitionValues) {
        transitionValues.values.put("android:changeScroll:x", Integer.valueOf(transitionValues.view.getScrollX()));
        transitionValues.values.put("android:changeScroll:y", Integer.valueOf(transitionValues.view.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator;
        Animator animator = null;
        if (transitionValues != null) {
            if (transitionValues2 == null) {
                return null;
            }
            View view = transitionValues2.view;
            int intValue = ((Integer) transitionValues.values.get("android:changeScroll:x")).intValue();
            int intValue2 = ((Integer) transitionValues2.values.get("android:changeScroll:x")).intValue();
            int intValue3 = ((Integer) transitionValues.values.get("android:changeScroll:y")).intValue();
            int intValue4 = ((Integer) transitionValues2.values.get("android:changeScroll:y")).intValue();
            if (intValue != intValue2) {
                view.setScrollX(intValue);
                objectAnimator = ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
            } else {
                objectAnimator = null;
            }
            ObjectAnimator objectAnimator2 = null;
            if (intValue3 != intValue4) {
                view.setScrollY(intValue3);
                objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
            }
            animator = TransitionUtils.a(objectAnimator, objectAnimator2);
        }
        return animator;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f3378a;
    }
}
