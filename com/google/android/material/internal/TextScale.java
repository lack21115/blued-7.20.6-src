package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/internal/TextScale.class */
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof TextView) {
            transitionValues.values.put(PROPNAME_SCALE, Float.valueOf(((TextView) transitionValues.view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ValueAnimator valueAnimator = null;
        if (transitionValues != null) {
            valueAnimator = null;
            if (transitionValues2 != null) {
                valueAnimator = null;
                if (transitionValues.view instanceof TextView) {
                    if (!(transitionValues2.view instanceof TextView)) {
                        return null;
                    }
                    final TextView textView = (TextView) transitionValues2.view;
                    Map<String, Object> map = transitionValues.values;
                    Map<String, Object> map2 = transitionValues2.values;
                    float f = 1.0f;
                    float floatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
                    if (map2.get(PROPNAME_SCALE) != null) {
                        f = ((Float) map2.get(PROPNAME_SCALE)).floatValue();
                    }
                    if (floatValue == f) {
                        return null;
                    }
                    valueAnimator = ValueAnimator.ofFloat(floatValue, f);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            float floatValue2 = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                            textView.setScaleX(floatValue2);
                            textView.setScaleY(floatValue2);
                        }
                    });
                }
            }
        }
        return valueAnimator;
    }
}
