package android.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: source-9557208-dex2jar.jar:android/transition/Explode.class */
public class Explode extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final String TAG = "Explode";
    private int[] mTempLoc;
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();

    public Explode() {
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float f, float f2) {
        return FloatMath.sqrt((f * f) + (f2 * f2));
    }

    private static float calculateMaxDistance(View view, int i, int i2) {
        return calculateDistance(Math.max(i, view.getWidth() - i), Math.max(i2, view.getHeight() - i2));
    }

    private void calculateOut(View view, Rect rect, int[] iArr) {
        int centerX;
        int centerY;
        view.getLocationOnScreen(this.mTempLoc);
        int i = this.mTempLoc[0];
        int i2 = this.mTempLoc[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            centerX = (view.getWidth() / 2) + i + Math.round(view.getTranslationX());
            centerY = (view.getHeight() / 2) + i2 + Math.round(view.getTranslationY());
        } else {
            centerX = epicenter.centerX();
            centerY = epicenter.centerY();
        }
        float centerX2 = rect.centerX() - centerX;
        float centerY2 = rect.centerY() - centerY;
        float f = centerX2;
        float f2 = centerY2;
        if (centerX2 == 0.0f) {
            f = centerX2;
            f2 = centerY2;
            if (centerY2 == 0.0f) {
                f = ((float) (Math.random() * 2.0d)) - 1.0f;
                f2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            }
        }
        float calculateDistance = calculateDistance(f, f2);
        float f3 = f / calculateDistance;
        float f4 = f2 / calculateDistance;
        float calculateMaxDistance = calculateMaxDistance(view, centerX - i, centerY - i2);
        iArr[0] = Math.round(calculateMaxDistance * f3);
        iArr[1] = Math.round(calculateMaxDistance * f4);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.mTempLoc);
        int i = this.mTempLoc[0];
        int i2 = this.mTempLoc[1];
        transitionValues.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(i, i2, i + view.getWidth(), i2 + view.getHeight()));
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        calculateOut(viewGroup, rect, this.mTempLoc);
        return TranslationAnimationCreator.createAnimation(view, transitionValues2, rect.left, rect.top, translationX + this.mTempLoc[0], translationY + this.mTempLoc[1], translationX, translationY, sDecelerate);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(16908357);
        float f = translationX;
        float f2 = translationY;
        if (iArr != null) {
            f = translationX + (iArr[0] - rect.left);
            f2 = translationY + (iArr[1] - rect.top);
            rect.offsetTo(iArr[0], iArr[1]);
        }
        calculateOut(viewGroup, rect, this.mTempLoc);
        return TranslationAnimationCreator.createAnimation(view, transitionValues, i, i2, translationX, translationY, f + this.mTempLoc[0], f2 + this.mTempLoc[1], sAccelerate);
    }
}
