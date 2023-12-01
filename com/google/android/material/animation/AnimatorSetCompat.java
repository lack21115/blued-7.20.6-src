package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/animation/AnimatorSetCompat.class */
public class AnimatorSetCompat {
    public static void playTogether(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
                ofInt.setDuration(j);
                list.add(0, ofInt);
                animatorSet.playTogether(list);
                return;
            }
            Animator animator = list.get(i2);
            j = Math.max(j, animator.getStartDelay() + animator.getDuration());
            i = i2 + 1;
        }
    }
}
