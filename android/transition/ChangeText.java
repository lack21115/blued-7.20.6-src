package android.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.text.Spanned;
import android.transition.Transition;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/transition/ChangeText.class */
public class ChangeText extends Transition {
    public static final int CHANGE_BEHAVIOR_IN = 2;
    public static final int CHANGE_BEHAVIOR_KEEP = 0;
    public static final int CHANGE_BEHAVIOR_OUT = 1;
    public static final int CHANGE_BEHAVIOR_OUT_IN = 3;
    private static final String LOG_TAG = "TextChange";
    private static final String PROPNAME_TEXT_COLOR = "android:textchange:textColor";
    private int mChangeBehavior = 0;
    private static final String PROPNAME_TEXT = "android:textchange:text";
    private static final String PROPNAME_TEXT_SELECTION_START = "android:textchange:textSelectionStart";
    private static final String PROPNAME_TEXT_SELECTION_END = "android:textchange:textSelectionEnd";
    private static final String[] sTransitionProperties = {PROPNAME_TEXT, PROPNAME_TEXT_SELECTION_START, PROPNAME_TEXT_SELECTION_END};

    private void captureValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof TextView) {
            TextView textView = (TextView) transitionValues.view;
            transitionValues.values.put(PROPNAME_TEXT, textView.getText());
            if (textView instanceof EditText) {
                transitionValues.values.put(PROPNAME_TEXT_SELECTION_START, Integer.valueOf(textView.getSelectionStart()));
                transitionValues.values.put(PROPNAME_TEXT_SELECTION_END, Integer.valueOf(textView.getSelectionEnd()));
            }
            if (this.mChangeBehavior > 0) {
                transitionValues.values.put(PROPNAME_TEXT_COLOR, Integer.valueOf(textView.getCurrentTextColor()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelection(EditText editText, int i, int i2) {
        if (i < 0 || i2 < 0) {
            return;
        }
        editText.setSelection(i, i2);
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int i2;
        int i3;
        int i4;
        final int intValue;
        AnimatorSet animatorSet;
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof TextView) || !(transitionValues2.view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) transitionValues2.view;
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        String str = map.get(PROPNAME_TEXT) != null ? (CharSequence) map.get(PROPNAME_TEXT) : "";
        String str2 = map2.get(PROPNAME_TEXT) != null ? (CharSequence) map2.get(PROPNAME_TEXT) : "";
        if (textView instanceof EditText) {
            i4 = map.get(PROPNAME_TEXT_SELECTION_START) != null ? ((Integer) map.get(PROPNAME_TEXT_SELECTION_START)).intValue() : -1;
            i3 = map.get(PROPNAME_TEXT_SELECTION_END) != null ? ((Integer) map.get(PROPNAME_TEXT_SELECTION_END)).intValue() : i4;
            i2 = map2.get(PROPNAME_TEXT_SELECTION_START) != null ? ((Integer) map2.get(PROPNAME_TEXT_SELECTION_START)).intValue() : -1;
            i = map2.get(PROPNAME_TEXT_SELECTION_END) != null ? ((Integer) map2.get(PROPNAME_TEXT_SELECTION_END)).intValue() : i2;
        } else {
            i = -1;
            i2 = -1;
            i3 = -1;
            i4 = -1;
        }
        if (str.equals(str2)) {
            return null;
        }
        if (this.mChangeBehavior != 2) {
            textView.setText(str);
            if (textView instanceof EditText) {
                setSelection((EditText) textView, i4, i3);
            }
        }
        if (this.mChangeBehavior == 0) {
            intValue = 0;
            animatorSet = ValueAnimator.ofFloat(0.0f, 1.0f);
            final CharSequence charSequence = str;
            final CharSequence charSequence2 = str2;
            final int i5 = i2;
            final int i6 = i;
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: android.transition.ChangeText.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (charSequence.equals(textView.getText())) {
                        textView.setText(charSequence2);
                        if (textView instanceof EditText) {
                            ChangeText.this.setSelection((EditText) textView, i5, i6);
                        }
                    }
                }
            });
        } else {
            final int intValue2 = ((Integer) map.get(PROPNAME_TEXT_COLOR)).intValue();
            intValue = ((Integer) map2.get(PROPNAME_TEXT_COLOR)).intValue();
            animatorSet = null;
            ValueAnimator valueAnimator = null;
            if (this.mChangeBehavior == 3 || this.mChangeBehavior == 1) {
                animatorSet = ValueAnimator.ofInt(255, 0);
                animatorSet.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.transition.ChangeText.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        textView.setTextColor((((Integer) valueAnimator2.getAnimatedValue()).intValue() << 24) | (intValue2 & Spanned.SPAN_PRIORITY) | (intValue2 & 65280) | (intValue2 & 255));
                    }
                });
                final CharSequence charSequence3 = str;
                final CharSequence charSequence4 = str2;
                final int i7 = i2;
                final int i8 = i;
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: android.transition.ChangeText.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (charSequence3.equals(textView.getText())) {
                            textView.setText(charSequence4);
                            if (textView instanceof EditText) {
                                ChangeText.this.setSelection((EditText) textView, i7, i8);
                            }
                        }
                        textView.setTextColor(intValue);
                    }
                });
            }
            if (this.mChangeBehavior == 3 || this.mChangeBehavior == 2) {
                valueAnimator = ValueAnimator.ofInt(0, 255);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.transition.ChangeText.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        textView.setTextColor((((Integer) valueAnimator2.getAnimatedValue()).intValue() << 24) | (Color.red(intValue) << 16) | (Color.green(intValue) << 8) | Color.red(intValue));
                    }
                });
                valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.transition.ChangeText.5
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        textView.setTextColor(intValue);
                    }
                });
            }
            if (animatorSet != null && valueAnimator != null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playSequentially(animatorSet, valueAnimator);
                animatorSet = animatorSet2;
            } else if (animatorSet == null) {
                animatorSet = valueAnimator;
            }
        }
        final CharSequence charSequence5 = str2;
        final int i9 = i2;
        final int i10 = i;
        final int i11 = intValue;
        final CharSequence charSequence6 = str;
        final int i12 = i4;
        final int i13 = i3;
        addListener(new Transition.TransitionListenerAdapter() { // from class: android.transition.ChangeText.6
            int mPausedColor = 0;

            @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                if (ChangeText.this.mChangeBehavior != 2) {
                    textView.setText(charSequence5);
                    if (textView instanceof EditText) {
                        ChangeText.this.setSelection((EditText) textView, i9, i10);
                    }
                }
                if (ChangeText.this.mChangeBehavior > 0) {
                    this.mPausedColor = textView.getCurrentTextColor();
                    textView.setTextColor(i11);
                }
            }

            @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                if (ChangeText.this.mChangeBehavior != 2) {
                    textView.setText(charSequence6);
                    if (textView instanceof EditText) {
                        ChangeText.this.setSelection((EditText) textView, i12, i13);
                    }
                }
                if (ChangeText.this.mChangeBehavior > 0) {
                    textView.setTextColor(this.mPausedColor);
                }
            }
        });
        return animatorSet;
    }

    public int getChangeBehavior() {
        return this.mChangeBehavior;
    }

    @Override // android.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public ChangeText setChangeBehavior(int i) {
        if (i >= 0 && i <= 3) {
            this.mChangeBehavior = i;
        }
        return this;
    }
}
