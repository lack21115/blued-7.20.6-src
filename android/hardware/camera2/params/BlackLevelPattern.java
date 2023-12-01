package android.hardware.camera2.params;

import com.android.internal.util.Preconditions;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/params/BlackLevelPattern.class */
public final class BlackLevelPattern {
    public static final int COUNT = 4;
    private final int[] mCfaOffsets;

    public BlackLevelPattern(int[] iArr) {
        if (iArr == null) {
            throw new NullPointerException("Null offsets array passed to constructor");
        }
        if (iArr.length < 4) {
            throw new IllegalArgumentException("Invalid offsets array length");
        }
        this.mCfaOffsets = Arrays.copyOf(iArr, 4);
    }

    public void copyTo(int[] iArr, int i) {
        Preconditions.checkNotNull(iArr, "destination must not be null");
        if (i < 0) {
            throw new IllegalArgumentException("Null offset passed to copyTo");
        }
        if (iArr.length - i < 4) {
            throw new ArrayIndexOutOfBoundsException("destination too small to fit elements");
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return;
            }
            iArr[i + i3] = this.mCfaOffsets[i3];
            i2 = i3 + 1;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlackLevelPattern) {
            return Arrays.equals(((BlackLevelPattern) obj).mCfaOffsets, this.mCfaOffsets);
        }
        return false;
    }

    public int getOffsetForIndex(int i, int i2) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("column, row arguments must be positive");
        }
        return this.mCfaOffsets[((i2 & 1) << 1) | (i & 1)];
    }

    public int hashCode() {
        return Arrays.hashCode(this.mCfaOffsets);
    }
}
