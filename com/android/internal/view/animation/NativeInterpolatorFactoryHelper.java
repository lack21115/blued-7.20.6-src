package com.android.internal.view.animation;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/animation/NativeInterpolatorFactoryHelper.class */
public final class NativeInterpolatorFactoryHelper {
    private NativeInterpolatorFactoryHelper() {
    }

    public static native long createAccelerateDecelerateInterpolator();

    public static native long createAccelerateInterpolator(float f);

    public static native long createAnticipateInterpolator(float f);

    public static native long createAnticipateOvershootInterpolator(float f);

    public static native long createBounceInterpolator();

    public static native long createCycleInterpolator(float f);

    public static native long createDecelerateInterpolator(float f);

    public static native long createLinearInterpolator();

    public static native long createLutInterpolator(float[] fArr);

    public static native long createOvershootInterpolator(float f);
}
