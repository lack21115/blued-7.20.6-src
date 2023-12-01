package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionInterpolator.class */
public abstract class MotionInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float f);

    public abstract float getVelocity();
}
