package android.transition;

import android.graphics.Rect;
import android.util.FloatMath;
import android.view.ViewGroup;

/* loaded from: source-9557208-dex2jar.jar:android/transition/CircularPropagation.class */
public class CircularPropagation extends VisibilityPropagation {
    private static final String TAG = "CircularPropagation";
    private float mPropagationSpeed = 3.0f;

    private static float distance(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return FloatMath.sqrt((f5 * f5) + (f6 * f6));
    }

    @Override // android.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int[] iArr;
        int round;
        int round2;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        int i = 1;
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i = -1;
        } else {
            transitionValues = transitionValues2;
        }
        int viewX = getViewX(transitionValues);
        int viewY = getViewY(transitionValues);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            round = epicenter.centerX();
            round2 = epicenter.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            round = Math.round(iArr[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            round2 = Math.round(iArr[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
        }
        float distance = distance(viewX, viewY, round, round2) / distance(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long duration = transition.getDuration();
        long j = duration;
        if (duration < 0) {
            j = 300;
        }
        return Math.round((((float) (i * j)) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f;
    }
}
