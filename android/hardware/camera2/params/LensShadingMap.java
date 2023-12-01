package android.hardware.camera2.params;

import android.hardware.camera2.utils.HashCodeHelpers;
import com.android.internal.util.Preconditions;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/params/LensShadingMap.class */
public final class LensShadingMap {
    public static final float MINIMUM_GAIN_FACTOR = 1.0f;
    private final int mColumns;
    private final float[] mElements;
    private final int mRows;

    public LensShadingMap(float[] fArr, int i, int i2) {
        this.mRows = Preconditions.checkArgumentPositive(i, "rows must be positive");
        this.mColumns = Preconditions.checkArgumentPositive(i2, "columns must be positive");
        this.mElements = (float[]) Preconditions.checkNotNull(fArr, "elements must not be null");
        if (fArr.length != getGainFactorCount()) {
            throw new IllegalArgumentException("elements must be " + getGainFactorCount() + " length, received " + fArr.length);
        }
        Preconditions.checkArrayElementsInRange(fArr, 1.0f, Float.MAX_VALUE, "elements");
    }

    public void copyGainFactors(float[] fArr, int i) {
        Preconditions.checkArgumentNonnegative(i, "offset must not be negative");
        Preconditions.checkNotNull(fArr, "destination must not be null");
        if (fArr.length + i < getGainFactorCount()) {
            throw new ArrayIndexOutOfBoundsException("destination too small to fit elements");
        }
        System.arraycopy(this.mElements, 0, fArr, i, getGainFactorCount());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof LensShadingMap) {
            LensShadingMap lensShadingMap = (LensShadingMap) obj;
            if (this.mRows != lensShadingMap.mRows || this.mColumns != lensShadingMap.mColumns || !Arrays.equals(this.mElements, lensShadingMap.mElements)) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int getColumnCount() {
        return this.mColumns;
    }

    public float getGainFactor(int i, int i2, int i3) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("colorChannel out of range");
        }
        if (i2 < 0 || i2 >= this.mColumns) {
            throw new IllegalArgumentException("column out of range");
        }
        if (i3 < 0 || i3 >= this.mRows) {
            throw new IllegalArgumentException("row out of range");
        }
        return this.mElements[(((this.mColumns * i3) + i2) * 4) + i];
    }

    public int getGainFactorCount() {
        return this.mRows * this.mColumns * 4;
    }

    public RggbChannelVector getGainFactorVector(int i, int i2) {
        if (i < 0 || i >= this.mColumns) {
            throw new IllegalArgumentException("column out of range");
        }
        if (i2 < 0 || i2 >= this.mRows) {
            throw new IllegalArgumentException("row out of range");
        }
        int i3 = ((this.mColumns * i2) + i) * 4;
        return new RggbChannelVector(this.mElements[i3 + 0], this.mElements[i3 + 1], this.mElements[i3 + 2], this.mElements[i3 + 3]);
    }

    public int getRowCount() {
        return this.mRows;
    }

    public int hashCode() {
        return HashCodeHelpers.hashCode(this.mRows, this.mColumns, HashCodeHelpers.hashCode(this.mElements));
    }
}
