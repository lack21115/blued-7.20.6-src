package android.hardware.camera2.params;

import android.hardware.camera2.utils.HashCodeHelpers;
import com.android.internal.util.Preconditions;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/params/ReprocessFormatsMap.class */
public final class ReprocessFormatsMap {
    private final int[] mEntry;
    private final int mInputCount;

    public ReprocessFormatsMap(int[] iArr) {
        Preconditions.checkNotNull(iArr, "entry must not be null");
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i2 < iArr.length) {
            int checkArgumentFormatInternal = StreamConfigurationMap.checkArgumentFormatInternal(iArr[i2]);
            int i3 = length - 1;
            int i4 = i2 + 1;
            if (i3 < 1) {
                throw new IllegalArgumentException(String.format("Input %x had no output format length listed", Integer.valueOf(checkArgumentFormatInternal)));
            }
            int i5 = iArr[i4];
            int i6 = i3 - 1;
            int i7 = i4 + 1;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= i5) {
                    break;
                }
                StreamConfigurationMap.checkArgumentFormatInternal(iArr[i7 + i9]);
                i8 = i9 + 1;
            }
            i2 = i7;
            length = i6;
            if (i5 > 0) {
                if (i6 < i5) {
                    throw new IllegalArgumentException(String.format("Input %x had too few output formats listed (actual: %d, expected: %d)", Integer.valueOf(checkArgumentFormatInternal), Integer.valueOf(i6), Integer.valueOf(i5)));
                }
                i2 = i7 + i5;
                length = i6 - i5;
            }
            i++;
        }
        this.mEntry = iArr;
        this.mInputCount = i;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReprocessFormatsMap) {
            return Arrays.equals(this.mEntry, ((ReprocessFormatsMap) obj).mEntry);
        }
        return false;
    }

    public int[] getInputs() {
        int[] iArr = new int[this.mInputCount];
        int length = this.mEntry.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= this.mEntry.length) {
                return StreamConfigurationMap.imageFormatToPublic(iArr);
            }
            int i4 = this.mEntry[i];
            int i5 = length - 1;
            int i6 = i + 1;
            if (i5 < 1) {
                throw new AssertionError(String.format("Input %x had no output format length listed", Integer.valueOf(i4)));
            }
            int i7 = this.mEntry[i6];
            int i8 = i5 - 1;
            int i9 = i6 + 1;
            i = i9;
            length = i8;
            if (i7 > 0) {
                if (i8 < i7) {
                    throw new AssertionError(String.format("Input %x had too few output formats listed (actual: %d, expected: %d)", Integer.valueOf(i4), Integer.valueOf(i8), Integer.valueOf(i7)));
                }
                i = i9 + i7;
                length = i8 - i7;
            }
            iArr[i3] = i4;
            i2 = i3 + 1;
        }
    }

    public int[] getOutputs(int i) {
        int length = this.mEntry.length;
        int i2 = 0;
        while (i2 < this.mEntry.length) {
            int i3 = this.mEntry[i2];
            int i4 = length - 1;
            int i5 = i2 + 1;
            if (i4 < 1) {
                throw new AssertionError(String.format("Input %x had no output format length listed", Integer.valueOf(i)));
            }
            int i6 = this.mEntry[i5];
            int i7 = i4 - 1;
            int i8 = i5 + 1;
            if (i6 > 0 && i7 < i6) {
                throw new AssertionError(String.format("Input %x had too few output formats listed (actual: %d, expected: %d)", Integer.valueOf(i), Integer.valueOf(i7), Integer.valueOf(i6)));
            }
            if (i3 == i) {
                int[] iArr = new int[i6];
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= i6) {
                        return StreamConfigurationMap.imageFormatToPublic(iArr);
                    }
                    iArr[i10] = this.mEntry[i8 + i10];
                    i9 = i10 + 1;
                }
            } else {
                i2 = i8 + i6;
                length = i7 - i6;
            }
        }
        throw new IllegalArgumentException(String.format("Input format %x was not one in #getInputs", Integer.valueOf(i)));
    }

    public int hashCode() {
        return HashCodeHelpers.hashCode(this.mEntry);
    }
}
