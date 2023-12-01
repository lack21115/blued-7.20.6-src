package android.text;

import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;

/* loaded from: source-9557208-dex2jar.jar:android/text/PackedIntVector.class */
class PackedIntVector {
    private final int mColumns;
    private int[] mValueGap;
    private int mRows = 0;
    private int mRowGapStart = 0;
    private int mRowGapLength = this.mRows;
    private int[] mValues = null;

    public PackedIntVector(int i) {
        this.mColumns = i;
        this.mValueGap = new int[i * 2];
    }

    private final void growBuffer() {
        int i = this.mColumns;
        int[] newUnpaddedIntArray = ArrayUtils.newUnpaddedIntArray(GrowingArrayUtils.growSize(size()) * i);
        int length = newUnpaddedIntArray.length / i;
        int[] iArr = this.mValueGap;
        int i2 = this.mRowGapStart;
        int i3 = this.mRows - (this.mRowGapLength + i2);
        if (this.mValues != null) {
            System.arraycopy(this.mValues, 0, newUnpaddedIntArray, 0, i * i2);
            System.arraycopy(this.mValues, (this.mRows - i3) * i, newUnpaddedIntArray, (length - i3) * i, i3 * i);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i) {
                this.mRowGapLength += length - this.mRows;
                this.mRows = length;
                this.mValues = newUnpaddedIntArray;
                return;
            }
            if (iArr[i5] >= i2) {
                iArr[i5] = iArr[i5] + (length - this.mRows);
                if (iArr[i5] < i2) {
                    iArr[i5] = i2;
                }
            }
            i4 = i5 + 1;
        }
    }

    private final void moveRowGapTo(int i) {
        if (i == this.mRowGapStart) {
            return;
        }
        if (i <= this.mRowGapStart) {
            int i2 = this.mRowGapStart - i;
            int i3 = this.mColumns;
            int[] iArr = this.mValueGap;
            int[] iArr2 = this.mValues;
            int i4 = this.mRowGapStart;
            int i5 = this.mRowGapLength;
            int i6 = i + i2;
            while (true) {
                int i7 = i6 - 1;
                if (i7 < i) {
                    break;
                }
                int i8 = ((i7 - i) + (i4 + i5)) - i2;
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < i3) {
                        int i11 = iArr2[(i7 * i3) + i10];
                        int i12 = i11;
                        if (i7 >= iArr[i10]) {
                            i12 = i11 + iArr[i10 + i3];
                        }
                        int i13 = i12;
                        if (i8 >= iArr[i10]) {
                            i13 = i12 - iArr[i10 + i3];
                        }
                        iArr2[(i8 * i3) + i10] = i13;
                        i9 = i10 + 1;
                    }
                }
                i6 = i7;
            }
        } else {
            int i14 = this.mRowGapLength;
            int i15 = this.mRowGapStart;
            int i16 = this.mRowGapLength;
            int i17 = this.mColumns;
            int[] iArr3 = this.mValueGap;
            int[] iArr4 = this.mValues;
            int i18 = this.mRowGapStart + this.mRowGapLength;
            int i19 = i18;
            while (true) {
                int i20 = i19;
                if (i20 >= i18 + ((i14 + i) - (i15 + i16))) {
                    break;
                }
                int i21 = (i20 - i18) + this.mRowGapStart;
                int i22 = 0;
                while (true) {
                    int i23 = i22;
                    if (i23 < i17) {
                        int i24 = iArr4[(i20 * i17) + i23];
                        int i25 = i24;
                        if (i20 >= iArr3[i23]) {
                            i25 = i24 + iArr3[i23 + i17];
                        }
                        int i26 = i25;
                        if (i21 >= iArr3[i23]) {
                            i26 = i25 - iArr3[i23 + i17];
                        }
                        iArr4[(i21 * i17) + i23] = i26;
                        i22 = i23 + 1;
                    }
                }
                i19 = i20 + 1;
            }
        }
        this.mRowGapStart = i;
    }

    private final void moveValueGapTo(int i, int i2) {
        int[] iArr = this.mValueGap;
        int[] iArr2 = this.mValues;
        int i3 = this.mColumns;
        if (i2 == iArr[i]) {
            return;
        }
        if (i2 <= iArr[i]) {
            int i4 = i2;
            while (true) {
                int i5 = i4;
                if (i5 >= iArr[i]) {
                    break;
                }
                int i6 = (i5 * i3) + i;
                iArr2[i6] = iArr2[i6] - iArr[i + i3];
                i4 = i5 + 1;
            }
        } else {
            int i7 = iArr[i];
            while (true) {
                int i8 = i7;
                if (i8 >= i2) {
                    break;
                }
                int i9 = (i8 * i3) + i;
                iArr2[i9] = iArr2[i9] + iArr[i + i3];
                i7 = i8 + 1;
            }
        }
        iArr[i] = i2;
    }

    private void setValueInternal(int i, int i2, int i3) {
        int i4 = i;
        if (i >= this.mRowGapStart) {
            i4 = i + this.mRowGapLength;
        }
        int[] iArr = this.mValueGap;
        int i5 = i3;
        if (i4 >= iArr[i2]) {
            i5 = i3 - iArr[this.mColumns + i2];
        }
        this.mValues[(this.mColumns * i4) + i2] = i5;
    }

    public void adjustValuesBelow(int i, int i2, int i3) {
        if ((i | i2) < 0 || i > size() || i2 >= width()) {
            throw new IndexOutOfBoundsException(i + ", " + i2);
        }
        int i4 = i;
        if (i >= this.mRowGapStart) {
            i4 = i + this.mRowGapLength;
        }
        moveValueGapTo(i2, i4);
        int[] iArr = this.mValueGap;
        int i5 = this.mColumns + i2;
        iArr[i5] = iArr[i5] + i3;
    }

    public void deleteAt(int i, int i2) {
        if ((i | i2) < 0 || i + i2 > size()) {
            throw new IndexOutOfBoundsException(i + ", " + i2);
        }
        moveRowGapTo(i + i2);
        this.mRowGapStart -= i2;
        this.mRowGapLength += i2;
    }

    public int getValue(int i, int i2) {
        int i3 = this.mColumns;
        if ((i | i2) < 0 || i >= size() || i2 >= i3) {
            throw new IndexOutOfBoundsException(i + ", " + i2);
        }
        int i4 = i;
        if (i >= this.mRowGapStart) {
            i4 = i + this.mRowGapLength;
        }
        int i5 = this.mValues[(i4 * i3) + i2];
        int[] iArr = this.mValueGap;
        int i6 = i5;
        if (i4 >= iArr[i2]) {
            i6 = i5 + iArr[i2 + i3];
        }
        return i6;
    }

    public void insertAt(int i, int[] iArr) {
        if (i < 0 || i > size()) {
            throw new IndexOutOfBoundsException("row " + i);
        }
        if (iArr != null && iArr.length < width()) {
            throw new IndexOutOfBoundsException("value count " + iArr.length);
        }
        moveRowGapTo(i);
        if (this.mRowGapLength == 0) {
            growBuffer();
        }
        this.mRowGapStart++;
        this.mRowGapLength--;
        if (iArr == null) {
            int i2 = this.mColumns;
            while (true) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    return;
                }
                setValueInternal(i, i3, 0);
                i2 = i3;
            }
        } else {
            int i4 = this.mColumns;
            while (true) {
                int i5 = i4 - 1;
                if (i5 < 0) {
                    return;
                }
                setValueInternal(i, i5, iArr[i5]);
                i4 = i5;
            }
        }
    }

    public void setValue(int i, int i2, int i3) {
        if ((i | i2) < 0 || i >= size() || i2 >= this.mColumns) {
            throw new IndexOutOfBoundsException(i + ", " + i2);
        }
        int i4 = i;
        if (i >= this.mRowGapStart) {
            i4 = i + this.mRowGapLength;
        }
        int[] iArr = this.mValueGap;
        int i5 = i3;
        if (i4 >= iArr[i2]) {
            i5 = i3 - iArr[this.mColumns + i2];
        }
        this.mValues[(this.mColumns * i4) + i2] = i5;
    }

    public int size() {
        return this.mRows - this.mRowGapLength;
    }

    public int width() {
        return this.mColumns;
    }
}
