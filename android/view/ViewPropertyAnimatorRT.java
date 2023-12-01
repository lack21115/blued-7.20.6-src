package android.view;

import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.internal.view.animation.FallbackLUTInterpolator;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:android/view/ViewPropertyAnimatorRT.class */
public class ViewPropertyAnimatorRT {
    private static final Interpolator sLinearInterpolator = new LinearInterpolator();
    private RenderNodeAnimator[] mAnimators = new RenderNodeAnimator[12];
    private final View mView;

    ViewPropertyAnimatorRT(View view) {
        this.mView = view;
    }

    private boolean canHandleAnimator(ViewPropertyAnimator viewPropertyAnimator) {
        return viewPropertyAnimator.getUpdateListener() == null && viewPropertyAnimator.getListener() == null && this.mView.isHardwareAccelerated() && !viewPropertyAnimator.hasActions();
    }

    private void cancelAnimators(ArrayList<ViewPropertyAnimator.NameValuesHolder> arrayList) {
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            int mapViewPropertyToRenderProperty = RenderNodeAnimator.mapViewPropertyToRenderProperty(arrayList.get(i2).mNameConstant);
            if (this.mAnimators[mapViewPropertyToRenderProperty] != null) {
                this.mAnimators[mapViewPropertyToRenderProperty].cancel();
                this.mAnimators[mapViewPropertyToRenderProperty] = null;
            }
            i = i2 + 1;
        }
    }

    private void doStartAnimation(ViewPropertyAnimator viewPropertyAnimator) {
        int size = viewPropertyAnimator.mPendingAnimations.size();
        long startDelay = viewPropertyAnimator.getStartDelay();
        long duration = viewPropertyAnimator.getDuration();
        TimeInterpolator interpolator = viewPropertyAnimator.getInterpolator();
        Interpolator interpolator2 = interpolator;
        if (interpolator == null) {
            interpolator2 = sLinearInterpolator;
        }
        FallbackLUTInterpolator fallbackLUTInterpolator = interpolator2;
        if (!RenderNodeAnimator.isNativeInterpolator(interpolator2)) {
            fallbackLUTInterpolator = new FallbackLUTInterpolator(interpolator2, duration);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                viewPropertyAnimator.mPendingAnimations.clear();
                return;
            }
            ViewPropertyAnimator.NameValuesHolder nameValuesHolder = viewPropertyAnimator.mPendingAnimations.get(i2);
            int mapViewPropertyToRenderProperty = RenderNodeAnimator.mapViewPropertyToRenderProperty(nameValuesHolder.mNameConstant);
            RenderNodeAnimator renderNodeAnimator = new RenderNodeAnimator(mapViewPropertyToRenderProperty, nameValuesHolder.mFromValue + nameValuesHolder.mDeltaValue);
            renderNodeAnimator.setStartDelay(startDelay);
            renderNodeAnimator.setDuration(duration);
            renderNodeAnimator.setInterpolator(fallbackLUTInterpolator);
            renderNodeAnimator.setTarget(this.mView);
            renderNodeAnimator.start();
            this.mAnimators[mapViewPropertyToRenderProperty] = renderNodeAnimator;
            i = i2 + 1;
        }
    }

    public void cancelAll() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mAnimators.length) {
                return;
            }
            if (this.mAnimators[i2] != null) {
                this.mAnimators[i2].cancel();
                this.mAnimators[i2] = null;
            }
            i = i2 + 1;
        }
    }

    public boolean startAnimation(ViewPropertyAnimator viewPropertyAnimator) {
        cancelAnimators(viewPropertyAnimator.mPendingAnimations);
        if (canHandleAnimator(viewPropertyAnimator)) {
            doStartAnimation(viewPropertyAnimator);
            return true;
        }
        return false;
    }
}
