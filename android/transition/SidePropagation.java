package android.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-9557208-dex2jar.jar:android/transition/SidePropagation.class */
public class SidePropagation extends VisibilityPropagation {
    private static final String TAG = "SlidePropagation";
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    private int distance(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        if (this.mSide == 8388611) {
            i9 = view.getLayoutDirection() == 1 ? 5 : 3;
        } else if (this.mSide == 8388613) {
            i9 = view.getLayoutDirection() == 1 ? 3 : 5;
        } else {
            i9 = this.mSide;
        }
        switch (i9) {
            case 3:
                return (i7 - i) + Math.abs(i4 - i2);
            case 5:
                return (i - i5) + Math.abs(i4 - i2);
            case 48:
                return (i8 - i2) + Math.abs(i3 - i);
            case 80:
                return (i2 - i6) + Math.abs(i3 - i);
            default:
                return 0;
        }
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        switch (this.mSide) {
            case 3:
            case 5:
            case 8388611:
            case 8388613:
                return viewGroup.getWidth();
            default:
                return viewGroup.getHeight();
        }
    }

    @Override // android.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int i2;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        int i3 = 1;
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i3 = -1;
        } else {
            transitionValues = transitionValues2;
        }
        int viewX = getViewX(transitionValues);
        int viewY = getViewY(transitionValues);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (epicenter != null) {
            i = epicenter.centerX();
            i2 = epicenter.centerY();
        } else {
            i = (round + width) / 2;
            i2 = (round2 + height) / 2;
        }
        float distance = distance(viewGroup, viewX, viewY, i, i2, round, round2, width, height) / getMaxDistance(viewGroup);
        long duration = transition.getDuration();
        long j = duration;
        if (duration < 0) {
            j = 300;
        }
        return Math.round((((float) (i3 * j)) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f;
    }

    public void setSide(int i) {
        this.mSide = i;
    }
}
