package com.android.internal.transition;

import android.transition.ChangeBounds;
import android.transition.ChangeText;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/transition/ActionBarTransition.class */
public class ActionBarTransition {
    private static boolean TRANSITIONS_ENABLED = false;
    private static final int TRANSITION_DURATION = 120;
    private static final Transition sTransition;

    static {
        if (!TRANSITIONS_ENABLED) {
            sTransition = null;
            return;
        }
        Transition changeText = new ChangeText();
        changeText.setChangeBehavior(3);
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(changeText).addTransition(new ChangeBounds());
        TransitionSet transitionSet2 = new TransitionSet();
        transitionSet2.addTransition(new Fade(2)).addTransition(transitionSet).addTransition(new Fade(1));
        transitionSet2.setOrdering(1);
        transitionSet2.setDuration(120L);
        sTransition = transitionSet2;
    }

    public static void beginDelayedTransition(ViewGroup viewGroup) {
        if (TRANSITIONS_ENABLED) {
            TransitionManager.beginDelayedTransition(viewGroup, sTransition);
        }
    }
}
