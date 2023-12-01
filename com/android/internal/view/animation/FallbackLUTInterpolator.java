package com.android.internal.view.animation;

import android.animation.TimeInterpolator;
import android.view.Choreographer;

@HasNativeInterpolator
/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/animation/FallbackLUTInterpolator.class */
public class FallbackLUTInterpolator implements NativeInterpolatorFactory, TimeInterpolator {
    private final float[] mLut;
    private TimeInterpolator mSourceInterpolator;

    public FallbackLUTInterpolator(TimeInterpolator timeInterpolator, long j) {
        this.mSourceInterpolator = timeInterpolator;
        this.mLut = createLUT(timeInterpolator, j);
    }

    private static float[] createLUT(TimeInterpolator timeInterpolator, long j) {
        int ceil = (int) Math.ceil(j / ((int) (Choreographer.getInstance().getFrameIntervalNanos() / 1000000)));
        float[] fArr = new float[ceil];
        float f = ceil - 1;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ceil) {
                return fArr;
            }
            fArr[i2] = timeInterpolator.getInterpolation(i2 / f);
            i = i2 + 1;
        }
    }

    public static long createNativeInterpolator(TimeInterpolator timeInterpolator, long j) {
        return NativeInterpolatorFactoryHelper.createLutInterpolator(createLUT(timeInterpolator, j));
    }

    @Override // com.android.internal.view.animation.NativeInterpolatorFactory
    public long createNativeInterpolator() {
        return NativeInterpolatorFactoryHelper.createLutInterpolator(this.mLut);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.mSourceInterpolator.getInterpolation(f);
    }
}
