package com.huawei.openalliance.ad.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/bd.class */
public class bd {
    private static final int Code = 300;

    public static void Code(ViewGroup viewGroup) {
        boolean z;
        int i;
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i2 = i3 + 1;
        }
        if (z && viewGroup.getVisibility() != 0) {
            i = 0;
        } else if (z) {
            return;
        } else {
            i = 8;
            if (viewGroup.getVisibility() == 8) {
                return;
            }
        }
        viewGroup.setVisibility(i);
    }

    public static boolean Code(View view, int i) {
        return Code(view, i, 300, 0);
    }

    public static boolean Code(View view, int i, int i2, int i3) {
        boolean z = false;
        if (view == null || view.getVisibility() == i) {
            return false;
        }
        view.setVisibility(i);
        if (i == 0) {
            z = true;
        }
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setDuration(i2);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        if (i3 > 0) {
            alphaAnimation.setStartOffset(i3);
        }
        view.startAnimation(alphaAnimation);
        return true;
    }

    public static boolean Code(View view, boolean z) {
        int i = z ? 0 : 8;
        if (view == null || view.getVisibility() == i) {
            return false;
        }
        view.setVisibility(i);
        return true;
    }
}
