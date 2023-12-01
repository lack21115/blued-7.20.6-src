package android.hardware.camera2.params;

import android.hardware.camera2.utils.HashCodeHelpers;
import android.util.Rational;
import com.android.internal.util.Preconditions;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/params/ColorSpaceTransform.class */
public final class ColorSpaceTransform {
    private static final int COLUMNS = 3;
    private static final int COUNT = 9;
    private static final int COUNT_INT = 18;
    private static final int OFFSET_DENOMINATOR = 1;
    private static final int OFFSET_NUMERATOR = 0;
    private static final int RATIONAL_SIZE = 2;
    private static final int ROWS = 3;
    private final int[] mElements;

    public ColorSpaceTransform(int[] iArr) {
        Preconditions.checkNotNull(iArr, "elements must not be null");
        if (iArr.length != 18) {
            throw new IllegalArgumentException("elements must be 18 length");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                this.mElements = Arrays.copyOf(iArr, iArr.length);
                return;
            } else {
                Preconditions.checkNotNull(iArr, "element " + i2 + " must not be null");
                i = i2 + 1;
            }
        }
    }

    public ColorSpaceTransform(Rational[] rationalArr) {
        Preconditions.checkNotNull(rationalArr, "elements must not be null");
        if (rationalArr.length != 9) {
            throw new IllegalArgumentException("elements must be 9 length");
        }
        this.mElements = new int[18];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rationalArr.length) {
                return;
            }
            Preconditions.checkNotNull(rationalArr, "element[" + i2 + "] must not be null");
            this.mElements[(i2 * 2) + 0] = rationalArr[i2].getNumerator();
            this.mElements[(i2 * 2) + 1] = rationalArr[i2].getDenominator();
            i = i2 + 1;
        }
    }

    private String toShortString() {
        StringBuilder sb = new StringBuilder("(");
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            sb.append("[");
            int i3 = 0;
            while (i3 < 3) {
                int i4 = this.mElements[i + 0];
                int i5 = this.mElements[i + 1];
                sb.append(i4);
                sb.append(BridgeUtil.SPLIT_MARK);
                sb.append(i5);
                if (i3 < 2) {
                    sb.append(", ");
                }
                i3++;
                i += 2;
            }
            sb.append("]");
            if (i2 < 2) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void copyElements(int[] iArr, int i) {
        Preconditions.checkArgumentNonnegative(i, "offset must not be negative");
        Preconditions.checkNotNull(iArr, "destination must not be null");
        if (iArr.length - i < 18) {
            throw new ArrayIndexOutOfBoundsException("destination too small to fit elements");
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 18) {
                return;
            }
            iArr[i3 + i] = this.mElements[i3];
            i2 = i3 + 1;
        }
    }

    public void copyElements(Rational[] rationalArr, int i) {
        Preconditions.checkArgumentNonnegative(i, "offset must not be negative");
        Preconditions.checkNotNull(rationalArr, "destination must not be null");
        if (rationalArr.length - i < 9) {
            throw new ArrayIndexOutOfBoundsException("destination too small to fit elements");
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= 9) {
                return;
            }
            rationalArr[i2 + i] = new Rational(this.mElements[i4 + 0], this.mElements[i4 + 1]);
            i2++;
            i3 = i4 + 2;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorSpaceTransform)) {
            return false;
        }
        ColorSpaceTransform colorSpaceTransform = (ColorSpaceTransform) obj;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= 9) {
                return true;
            }
            if (!new Rational(this.mElements[i3 + 0], this.mElements[i3 + 1]).equals((Object) new Rational(colorSpaceTransform.mElements[i3 + 0], colorSpaceTransform.mElements[i3 + 1]))) {
                return false;
            }
            i++;
            i2 = i3 + 2;
        }
    }

    public Rational getElement(int i, int i2) {
        if (i < 0 || i >= 3) {
            throw new IllegalArgumentException("column out of range");
        }
        if (i2 < 0 || i2 >= 3) {
            throw new IllegalArgumentException("row out of range");
        }
        return new Rational(this.mElements[(((i2 * 3) + i) * 2) + 0], this.mElements[(((i2 * 3) + i) * 2) + 1]);
    }

    public int hashCode() {
        return HashCodeHelpers.hashCode(this.mElements);
    }

    public String toString() {
        return String.format("ColorSpaceTransform%s", toShortString());
    }
}
