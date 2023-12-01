package androidx.transition;

import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionPropagation.class */
public abstract class TransitionPropagation {
    public abstract void captureValues(TransitionValues transitionValues);

    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2);
}
