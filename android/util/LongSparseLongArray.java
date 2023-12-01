package android.util;

import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/util/LongSparseLongArray.class */
public class LongSparseLongArray implements Cloneable {
    private long[] mKeys;
    private int mSize;
    private long[] mValues;

    public LongSparseLongArray() {
        this(10);
    }

    public LongSparseLongArray(int i) {
        if (i == 0) {
            this.mKeys = EmptyArray.LONG;
            this.mValues = EmptyArray.LONG;
        } else {
            this.mKeys = ArrayUtils.newUnpaddedLongArray(i);
            this.mValues = new long[this.mKeys.length];
        }
        this.mSize = 0;
    }

    public void append(long j, long j2) {
        if (this.mSize != 0 && j <= this.mKeys[this.mSize - 1]) {
            put(j, j2);
            return;
        }
        this.mKeys = GrowingArrayUtils.append(this.mKeys, this.mSize, j);
        this.mValues = GrowingArrayUtils.append(this.mValues, this.mSize, j2);
        this.mSize++;
    }

    public void clear() {
        this.mSize = 0;
    }

    /* renamed from: clone */
    public LongSparseLongArray m1019clone() {
        LongSparseLongArray longSparseLongArray = null;
        try {
            LongSparseLongArray longSparseLongArray2 = (LongSparseLongArray) super.clone();
            longSparseLongArray2.mKeys = (long[]) this.mKeys.clone();
            longSparseLongArray = longSparseLongArray2;
            longSparseLongArray2.mValues = (long[]) this.mValues.clone();
            return longSparseLongArray2;
        } catch (CloneNotSupportedException e) {
            return longSparseLongArray;
        }
    }

    public void delete(long j) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0) {
            removeAt(binarySearch);
        }
    }

    public long get(long j) {
        return get(j, 0L);
    }

    public long get(long j, long j2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        return binarySearch < 0 ? j2 : this.mValues[binarySearch];
    }

    public int indexOfKey(long j) {
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
    }

    public int indexOfValue(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSize) {
                return -1;
            }
            if (this.mValues[i2] == j) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public long keyAt(int i) {
        return this.mKeys[i];
    }

    public void put(long j, long j2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = j2;
            return;
        }
        int i = binarySearch ^ (-1);
        this.mKeys = GrowingArrayUtils.insert(this.mKeys, this.mSize, i, j);
        this.mValues = GrowingArrayUtils.insert(this.mValues, this.mSize, i, j2);
        this.mSize++;
    }

    public void removeAt(int i) {
        System.arraycopy(this.mKeys, i + 1, this.mKeys, i, this.mSize - (i + 1));
        System.arraycopy(this.mValues, i + 1, this.mValues, i, this.mSize - (i + 1));
        this.mSize--;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSize) {
                sb.append('}');
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i2));
            sb.append('=');
            sb.append(valueAt(i2));
            i = i2 + 1;
        }
    }

    public long valueAt(int i) {
        return this.mValues[i];
    }
}
