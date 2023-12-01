package android.util;

import com.android.internal.util.ArrayUtils;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/util/LongArray.class */
public class LongArray implements Cloneable {
    private static final int MIN_CAPACITY_INCREMENT = 12;
    private int mSize;
    private long[] mValues;

    public LongArray() {
        this(10);
    }

    public LongArray(int i) {
        if (i == 0) {
            this.mValues = EmptyArray.LONG;
        } else {
            this.mValues = ArrayUtils.newUnpaddedLongArray(i);
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
            long[] newUnpaddedLongArray = ArrayUtils.newUnpaddedLongArray(i4);
            System.arraycopy(this.mValues, 0, newUnpaddedLongArray, 0, i2);
            this.mValues = newUnpaddedLongArray;
        }
    }

    public void add(int i, long j) {
        if (i < 0 || i > this.mSize) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(1);
        if (this.mSize - i != 0) {
            System.arraycopy(this.mValues, i, this.mValues, i + 1, this.mSize - i);
        }
        this.mValues[i] = j;
        this.mSize++;
    }

    public void add(long j) {
        add(this.mSize, j);
    }

    public void addAll(LongArray longArray) {
        int i = longArray.mSize;
        ensureCapacity(i);
        System.arraycopy(longArray.mValues, 0, this.mValues, this.mSize, i);
        this.mSize += i;
    }

    public void clear() {
        this.mSize = 0;
    }

    /* renamed from: clone */
    public LongArray m1020clone() {
        LongArray longArray = null;
        try {
            LongArray longArray2 = (LongArray) super.clone();
            longArray = longArray2;
            longArray2.mValues = (long[]) this.mValues.clone();
            return longArray2;
        } catch (CloneNotSupportedException e) {
            return longArray;
        }
    }

    public long get(int i) {
        if (i >= this.mSize) {
            throw new ArrayIndexOutOfBoundsException(this.mSize, i);
        }
        return this.mValues[i];
    }

    public int indexOf(long j) {
        int i = this.mSize;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return -1;
            }
            if (this.mValues[i3] == j) {
                return i3;
            }
            i2 = i3 + 1;
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
