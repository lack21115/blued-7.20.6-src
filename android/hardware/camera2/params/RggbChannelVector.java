package android.hardware.camera2.params;

import com.android.internal.util.Preconditions;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/params/RggbChannelVector.class */
public final class RggbChannelVector {
    public static final int BLUE = 3;
    public static final int COUNT = 4;
    public static final int GREEN_EVEN = 1;
    public static final int GREEN_ODD = 2;
    public static final int RED = 0;
    private final float mBlue;
    private final float mGreenEven;
    private final float mGreenOdd;
    private final float mRed;

    public RggbChannelVector(float f, float f2, float f3, float f4) {
        this.mRed = Preconditions.checkArgumentFinite(f, "red");
        this.mGreenEven = Preconditions.checkArgumentFinite(f2, "greenEven");
        this.mGreenOdd = Preconditions.checkArgumentFinite(f3, "greenOdd");
        this.mBlue = Preconditions.checkArgumentFinite(f4, "blue");
    }

    private String toShortString() {
        return String.format("{R:%f, G_even:%f, G_odd:%f, B:%f}", Float.valueOf(this.mRed), Float.valueOf(this.mGreenEven), Float.valueOf(this.mGreenOdd), Float.valueOf(this.mBlue));
    }

    public void copyTo(float[] fArr, int i) {
        Preconditions.checkNotNull(fArr, "destination must not be null");
        if (fArr.length - i < 4) {
            throw new ArrayIndexOutOfBoundsException("destination too small to fit elements");
        }
        fArr[i + 0] = this.mRed;
        fArr[i + 1] = this.mGreenEven;
        fArr[i + 2] = this.mGreenOdd;
        fArr[i + 3] = this.mBlue;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof RggbChannelVector) {
            RggbChannelVector rggbChannelVector = (RggbChannelVector) obj;
            if (this.mRed != rggbChannelVector.mRed || this.mGreenEven != rggbChannelVector.mGreenEven || this.mGreenOdd != rggbChannelVector.mGreenOdd || this.mBlue != rggbChannelVector.mBlue) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public float getBlue() {
        return this.mBlue;
    }

    public float getComponent(int i) {
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("Color channel out of range");
        }
        switch (i) {
            case 0:
                return this.mRed;
            case 1:
                return this.mGreenEven;
            case 2:
                return this.mGreenOdd;
            case 3:
                return this.mBlue;
            default:
                throw new AssertionError("Unhandled case " + i);
        }
    }

    public float getGreenEven() {
        return this.mGreenEven;
    }

    public float getGreenOdd() {
        return this.mGreenOdd;
    }

    public final float getRed() {
        return this.mRed;
    }

    public int hashCode() {
        return ((Float.floatToIntBits(this.mRed) ^ Float.floatToIntBits(this.mGreenEven)) ^ Float.floatToIntBits(this.mGreenOdd)) ^ Float.floatToIntBits(this.mBlue);
    }

    public String toString() {
        return String.format("RggbChannelVector%s", toShortString());
    }
}
