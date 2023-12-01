package android.view;

import android.util.Pools;

/* loaded from: source-9557208-dex2jar.jar:android/view/VelocityTracker.class */
public final class VelocityTracker {
    private static final int ACTIVE_POINTER_ID = -1;
    private static final Pools.SynchronizedPool<VelocityTracker> sPool = new Pools.SynchronizedPool<>(2);
    private long mPtr;
    private final String mStrategy;

    /* loaded from: source-9557208-dex2jar.jar:android/view/VelocityTracker$Estimator.class */
    public static final class Estimator {
        private static final int MAX_DEGREE = 4;
        public float confidence;
        public int degree;
        public final float[] xCoeff = new float[5];
        public final float[] yCoeff = new float[5];

        private float estimate(float f, float[] fArr) {
            float f2 = 0.0f;
            float f3 = 1.0f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 > this.degree) {
                    return f2;
                }
                f2 += fArr[i2] * f3;
                f3 *= f;
                i = i2 + 1;
            }
        }

        public float estimateX(float f) {
            return estimate(f, this.xCoeff);
        }

        public float estimateY(float f) {
            return estimate(f, this.yCoeff);
        }

        public float getXCoeff(int i) {
            if (i <= this.degree) {
                return this.xCoeff[i];
            }
            return 0.0f;
        }

        public float getYCoeff(int i) {
            if (i <= this.degree) {
                return this.yCoeff[i];
            }
            return 0.0f;
        }
    }

    private VelocityTracker(String str) {
        this.mPtr = nativeInitialize(str);
        this.mStrategy = str;
    }

    private static native void nativeAddMovement(long j, MotionEvent motionEvent);

    private static native void nativeClear(long j);

    private static native void nativeComputeCurrentVelocity(long j, int i, float f);

    private static native void nativeDispose(long j);

    private static native boolean nativeGetEstimator(long j, int i, Estimator estimator);

    private static native float nativeGetXVelocity(long j, int i);

    private static native float nativeGetYVelocity(long j, int i);

    private static native long nativeInitialize(String str);

    public static VelocityTracker obtain() {
        VelocityTracker acquire = sPool.acquire();
        return acquire != null ? acquire : new VelocityTracker(null);
    }

    public static VelocityTracker obtain(String str) {
        return str == null ? obtain() : new VelocityTracker(str);
    }

    public void addMovement(MotionEvent motionEvent) {
        if (motionEvent == null) {
            throw new IllegalArgumentException("event must not be null");
        }
        nativeAddMovement(this.mPtr, motionEvent);
    }

    public void clear() {
        nativeClear(this.mPtr);
    }

    public void computeCurrentVelocity(int i) {
        nativeComputeCurrentVelocity(this.mPtr, i, Float.MAX_VALUE);
    }

    public void computeCurrentVelocity(int i, float f) {
        nativeComputeCurrentVelocity(this.mPtr, i, f);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mPtr != 0) {
                nativeDispose(this.mPtr);
                this.mPtr = 0L;
            }
        } finally {
            super.finalize();
        }
    }

    public boolean getEstimator(int i, Estimator estimator) {
        if (estimator == null) {
            throw new IllegalArgumentException("outEstimator must not be null");
        }
        return nativeGetEstimator(this.mPtr, i, estimator);
    }

    public float getXVelocity() {
        return nativeGetXVelocity(this.mPtr, -1);
    }

    public float getXVelocity(int i) {
        return nativeGetXVelocity(this.mPtr, i);
    }

    public float getYVelocity() {
        return nativeGetYVelocity(this.mPtr, -1);
    }

    public float getYVelocity(int i) {
        return nativeGetYVelocity(this.mPtr, i);
    }

    public void recycle() {
        if (this.mStrategy == null) {
            clear();
            sPool.release(this);
        }
    }
}
