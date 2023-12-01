package android.graphics;

import android.os.SystemClock;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Interpolator.class */
public class Interpolator {
    private int mFrameCount;
    private int mValueCount;
    private final long native_instance;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Interpolator$Result.class */
    public enum Result {
        NORMAL,
        FREEZE_START,
        FREEZE_END
    }

    public Interpolator(int i) {
        this.mValueCount = i;
        this.mFrameCount = 2;
        this.native_instance = nativeConstructor(i, 2);
    }

    public Interpolator(int i, int i2) {
        this.mValueCount = i;
        this.mFrameCount = i2;
        this.native_instance = nativeConstructor(i, i2);
    }

    private static native long nativeConstructor(int i, int i2);

    private static native void nativeDestructor(long j);

    private static native void nativeReset(long j, int i, int i2);

    private static native void nativeSetKeyFrame(long j, int i, int i2, float[] fArr, float[] fArr2);

    private static native void nativeSetRepeatMirror(long j, float f, boolean z);

    private static native int nativeTimeToValues(long j, int i, float[] fArr);

    protected void finalize() throws Throwable {
        nativeDestructor(this.native_instance);
    }

    public final int getKeyFrameCount() {
        return this.mFrameCount;
    }

    public final int getValueCount() {
        return this.mValueCount;
    }

    public void reset(int i) {
        reset(i, 2);
    }

    public void reset(int i, int i2) {
        this.mValueCount = i;
        this.mFrameCount = i2;
        nativeReset(this.native_instance, i, i2);
    }

    public void setKeyFrame(int i, int i2, float[] fArr) {
        setKeyFrame(i, i2, fArr, null);
    }

    public void setKeyFrame(int i, int i2, float[] fArr, float[] fArr2) {
        if (i < 0 || i >= this.mFrameCount) {
            throw new IndexOutOfBoundsException();
        }
        if (fArr.length < this.mValueCount) {
            throw new ArrayStoreException();
        }
        if (fArr2 != null && fArr2.length < 4) {
            throw new ArrayStoreException();
        }
        nativeSetKeyFrame(this.native_instance, i, i2, fArr, fArr2);
    }

    public void setRepeatMirror(float f, boolean z) {
        if (f >= 0.0f) {
            nativeSetRepeatMirror(this.native_instance, f, z);
        }
    }

    public Result timeToValues(int i, float[] fArr) {
        if (fArr == null || fArr.length >= this.mValueCount) {
            switch (nativeTimeToValues(this.native_instance, i, fArr)) {
                case 0:
                    return Result.NORMAL;
                case 1:
                    return Result.FREEZE_START;
                default:
                    return Result.FREEZE_END;
            }
        }
        throw new ArrayStoreException();
    }

    public Result timeToValues(float[] fArr) {
        return timeToValues((int) SystemClock.uptimeMillis(), fArr);
    }
}
