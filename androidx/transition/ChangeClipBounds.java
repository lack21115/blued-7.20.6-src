package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ChangeClipBounds.class */
public class ChangeClipBounds extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f3421a = {"android:clipBounds:clip"};

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect clipBounds = ViewCompat.getClipBounds(view);
        transitionValues.values.put("android:clipBounds:clip", clipBounds);
        if (clipBounds == null) {
            transitionValues.values.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
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
        Rect rect;
        Rect rect2;
        ObjectAnimator objectAnimator = null;
        if (transitionValues != null) {
            objectAnimator = null;
            if (transitionValues2 != null) {
                objectAnimator = null;
                if (transitionValues.values.containsKey("android:clipBounds:clip")) {
                    if (!transitionValues2.values.containsKey("android:clipBounds:clip")) {
                        return null;
                    }
                    Rect rect3 = (Rect) transitionValues.values.get("android:clipBounds:clip");
                    Rect rect4 = (Rect) transitionValues2.values.get("android:clipBounds:clip");
                    boolean z = rect4 == null;
                    if (rect3 == null && rect4 == null) {
                        return null;
                    }
                    if (rect3 == null) {
                        rect = (Rect) transitionValues.values.get("android:clipBounds:bounds");
                        rect2 = rect4;
                    } else {
                        rect = rect3;
                        rect2 = rect4;
                        if (rect4 == null) {
                            rect2 = (Rect) transitionValues2.values.get("android:clipBounds:bounds");
                            rect = rect3;
                        }
                    }
                    if (rect.equals(rect2)) {
                        return null;
                    }
                    ViewCompat.setClipBounds(transitionValues2.view, rect);
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(transitionValues2.view, (Property<View, V>) ViewUtils.b, (TypeEvaluator) new RectEvaluator(new Rect()), (Object[]) new Rect[]{rect, rect2});
                    objectAnimator = ofObject;
                    if (z) {
                        final View view = transitionValues2.view;
                        ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeClipBounds.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                ViewCompat.setClipBounds(view, null);
                            }
                        });
                        objectAnimator = ofObject;
                    }
                }
            }
        }
        return objectAnimator;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f3421a;
    }
}
