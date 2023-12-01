package android.util;

import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/util/SparseLongArray.class */
public class SparseLongArray implements Cloneable {
    private int[] mKeys;
    private int mSize;
    private long[] mValues;

    public SparseLongArray() {
        this(10);
    }

    public SparseLongArray(int i) {
        if (i == 0) {
            this.mKeys = EmptyArray.INT;
            this.mValues = EmptyArray.LONG;
        } else {
            this.mValues = ArrayUtils.newUnpaddedLongArray(i);
            this.mKeys = new int[this.mValues.length];
        }
        this.mSize = 0;
    }

    public void append(int i, long j) {
        if (this.mSize != 0 && i <= this.mKeys[this.mSize - 1]) {
            put(i, j);
            return;
        }
        this.mKeys = GrowingArrayUtils.append(this.mKeys, this.mSize, i);
        this.mValues = GrowingArrayUtils.append(this.mValues, this.mSize, j);
        this.mSize++;
    }

    public void clear() {
        this.mSize = 0;
    }

    /* renamed from: clone */
    public SparseLongArray m1028clone() {
        SparseLongArray sparseLongArray = null;
        try {
            SparseLongArray sparseLongArray2 = (SparseLongArray) super.clone();
            sparseLongArray2.mKeys = (int[]) this.mKeys.clone();
            sparseLongArray = sparseLongArray2;
            sparseLongArray2.mValues = (long[]) this.mValues.clone();
            return sparseLongArray2;
        } catch (CloneNotSupportedException e) {
            return sparseLongArray;
        }
    }

    public void delete(int i) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            removeAt(binarySearch);
        }
    }

    public long get(int i) {
        return get(i, 0L);
    }

    public long get(int i, long j) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        return binarySearch < 0 ? j : this.mValues[binarySearch];
    }

    public int indexOfKey(int i) {
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
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

    public int keyAt(int i) {
        return this.mKeys[i];
    }

    public void put(int i, long j) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = j;
            return;
        }
        int i2 = binarySearch ^ (-1);
        this.mKeys = GrowingArrayUtils.insert(this.mKeys, this.mSize, i2, i);
        this.mValues = GrowingArrayUtils.insert(this.mValues, this.mSize, i2, j);
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
