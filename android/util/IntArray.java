package android.util;

import com.android.internal.util.ArrayUtils;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/util/IntArray.class */
public class IntArray implements Cloneable {
    private static final int MIN_CAPACITY_INCREMENT = 12;
    private int mSize;
    private int[] mValues;

    public IntArray() {
        this(10);
    }

    public IntArray(int i) {
        if (i == 0) {
            this.mValues = EmptyArray.INT;
        } else {
            this.mValues = ArrayUtils.newUnpaddedIntArray(i);
        }
        this.mSize = 0;
    }

    private void ensureCapacity(int i) {
        int i2 = this.mSize;
        int i3 = i2 + i;
        if (i3 >= this.mValues.length) {
            int i4 = i2 + (i2 < 6 ? 12 : i2 >> 1);
            if (i4 <= i3) {
                i4 = i3;
            }
            int[] newUnpaddedIntArray = ArrayUtils.newUnpaddedIntArray(i4);
            System.arraycopy(this.mValues, 0, newUnpaddedIntArray, 0, i2);
            this.mValues = newUnpaddedIntArray;
        }
    }

    public void add(int i) {
        add(this.mSize, i);
    }

    public void add(int i, int i2) {
        if (i < 0 || i > this.mSize) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(1);
        if (this.mSize - i != 0) {
            System.arraycopy(this.mValues, i, this.mValues, i + 1, this.mSize - i);
        }
        this.mValues[i] = i2;
        this.mSize++;
    }

    public void addAll(IntArray intArray) {
        int i = intArray.mSize;
        ensureCapacity(i);
        System.arraycopy(intArray.mValues, 0, this.mValues, this.mSize, i);
        this.mSize += i;
    }

    public void clear() {
        this.mSize = 0;
    }

    /* renamed from: clone */
    public IntArray m1010clone() throws CloneNotSupportedException {
        IntArray intArray = (IntArray) super.clone();
        intArray.mValues = (int[]) this.mValues.clone();
        return intArray;
    }

    public int get(int i) {
        if (i >= this.mSize) {
            throw new ArrayIndexOutOfBoundsException(this.mSize, i);
        }
        return this.mValues[i];
    }

    public int indexOf(int i) {
        int i2 = this.mSize;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return -1;
            }
            if (this.mValues[i4] == i) {
                return i4;
            }
            i3 = i4 + 1;
        }
    }

    public void remove(int i) {
        if (i >= this.mSize) {
            throw new ArrayIndexOutOfBoundsException(this.mSize, i);
        }
        System.arraycopy(this.mValues, i + 1, this.mValues, i, (this.mSize - i) - 1);
        this.mSize--;
    }

    public int size() {
        return this.mSize;
    }
}
