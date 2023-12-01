package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/CircularPropagation.class */
public class CircularPropagation extends VisibilityPropagation {

    /* renamed from: a  reason: collision with root package name */
    private float f3436a = 3.0f;

    private static float a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int[] iArr;
        int round;
        int round2;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i = -1;
        } else {
            i = 1;
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
        float a2 = a(viewX, viewY, round, round2) / a(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long duration = transition.getDuration();
        long j = duration;
        if (duration < 0) {
            j = 300;
        }
        return Math.round((((float) (j * i)) / this.f3436a) * a2);
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.f3436a = f;
    }
}
