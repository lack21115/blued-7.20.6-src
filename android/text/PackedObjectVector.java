package android.text;

import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/text/PackedObjectVector.class */
class PackedObjectVector<E> {
    private int mColumns;
    private Object[] mValues = EmptyArray.OBJECT;
    private int mRows = 0;
    private int mRowGapStart = 0;
    private int mRowGapLength = this.mRows;

    public PackedObjectVector(int i) {
        this.mColumns = i;
    }

    private void growBuffer() {
        Object[] newUnpaddedObjectArray = ArrayUtils.newUnpaddedObjectArray(GrowingArrayUtils.growSize(size()) * this.mColumns);
        int length = newUnpaddedObjectArray.length / this.mColumns;
        int i = this.mRows - (this.mRowGapStart + this.mRowGapLength);
        System.arraycopy(this.mValues, 0, newUnpaddedObjectArray, 0, this.mColumns * this.mRowGapStart);
        System.arraycopy(this.mValues, (this.mRows - i) * this.mColumns, newUnpaddedObjectArray, (length - i) * this.mColumns, this.mColumns * i);
        this.mRowGapLength += length - this.mRows;
        this.mRows = length;
        this.mValues = newUnpaddedObjectArray;
    }

    private void moveRowGapTo(int i) {
        if (i == this.mRowGapStart) {
            return;
        }
        if (i <= this.mRowGapStart) {
            int i2 = this.mRowGapStart - i;
            int i3 = i + i2;
            while (true) {
                int i4 = i3 - 1;
                if (i4 < i) {
                    break;
                }
                int i5 = this.mRowGapStart;
                int i6 = this.mRowGapLength;
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 < this.mColumns) {
                        this.mValues[(this.mColumns * ((((i4 - i) + i5) + i6) - i2)) + i8] = this.mValues[(this.mColumns * i4) + i8];
                        i7 = i8 + 1;
                    }
                }
                i3 = i4;
            }
        } else {
            int i9 = this.mRowGapLength;
            int i10 = this.mRowGapStart;
            int i11 = this.mRowGapLength;
            int i12 = this.mRowGapStart;
            int i13 = this.mRowGapLength;
            while (true) {
                int i14 = i12 + i13;
                if (i14 >= this.mRowGapStart + this.mRowGapLength + ((i9 + i) - (i10 + i11))) {
                    break;
                }
                int i15 = this.mRowGapStart;
                int i16 = this.mRowGapLength;
                int i17 = this.mRowGapStart;
                int i18 = 0;
                while (true) {
                    int i19 = i18;
                    if (i19 < this.mColumns) {
                        this.mValues[(this.mColumns * ((i14 - (i15 + i16)) + i17)) + i19] = this.mValues[(this.mColumns * i14) + i19];
                        i18 = i19 + 1;
                    }
                }
                i12 = i14;
                i13 = 1;
            }
        }
        this.mRowGapStart = i;
    }

    public void deleteAt(int i, int i2) {
        moveRowGapTo(i + i2);
        this.mRowGapStart -= i2;
        this.mRowGapLength += i2;
        if (this.mRowGapLength > size() * 2) {
        }
    }

    public void dump() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mRows) {
                System.out.print("-----\n\n");
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mColumns) {
                    Object obj = this.mValues[(this.mColumns * i2) + i4];
                    if (i2 < this.mRowGapStart || i2 >= this.mRowGapStart + this.mRowGapLength) {
                        System.out.print(obj + " ");
                    } else {
                        System.out.print("(" + obj + ") ");
                    }
                    i3 = i4 + 1;
                }
            }
            System.out.print(" << \n");
            i = i2 + 1;
        }
    }

    public E getValue(int i, int i2) {
        int i3 = i;
        if (i >= this.mRowGapStart) {
            i3 = i + this.mRowGapLength;
        }
        return (E) this.mValues[(this.mColumns * i3) + i2];
    }

    public void insertAt(int i, E[] eArr) {
        moveRowGapTo(i);
        if (this.mRowGapLength == 0) {
            growBuffer();
        }
        this.mRowGapStart++;
        this.mRowGapLength--;
        if (eArr == null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mColumns) {
                    return;
                }
                setValue(i, i3, null);
                i2 = i3 + 1;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.mColumns) {
                    return;
                }
                setValue(i, i5, eArr[i5]);
                i4 = i5 + 1;
            }
        }
    }

    public void setValue(int i, int i2, E e) {
        int i3 = i;
        if (i >= this.mRowGapStart) {
            i3 = i + this.mRowGapLength;
        }
        this.mValues[(this.mColumns * i3) + i2] = e;
    }

    public int size() {
        return this.mRows - this.mRowGapLength;
    }

    public int width() {
        return this.mColumns;
    }
}
