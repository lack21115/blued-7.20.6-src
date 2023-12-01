package android.util;

import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/util/SparseIntArray.class */
public class SparseIntArray implements Cloneable {
    private int[] mKeys;
    private int mSize;
    private int[] mValues;

    public SparseIntArray() {
        this(10);
    }

    public SparseIntArray(int i) {
        if (i == 0) {
            this.mKeys = EmptyArray.INT;
            this.mValues = EmptyArray.INT;
        } else {
            this.mKeys = ArrayUtils.newUnpaddedIntArray(i);
            this.mValues = new int[this.mKeys.length];
        }
        this.mSize = 0;
    }

    public void append(int i, int i2) {
        if (this.mSize != 0 && i <= this.mKeys[this.mSize - 1]) {
            put(i, i2);
            return;
        }
        this.mKeys = GrowingArrayUtils.append(this.mKeys, this.mSize, i);
        this.mValues = GrowingArrayUtils.append(this.mValues, this.mSize, i2);
        this.mSize++;
    }

    public void clear() {
        this.mSize = 0;
    }

    /* renamed from: clone */
    public SparseIntArray m1027clone() {
        SparseIntArray sparseIntArray = null;
        try {
            SparseIntArray sparseIntArray2 = (SparseIntArray) super.clone();
            sparseIntArray2.mKeys = (int[]) this.mKeys.clone();
            sparseIntArray = sparseIntArray2;
            sparseIntArray2.mValues = (int[]) this.mValues.clone();
            return sparseIntArray2;
        } catch (CloneNotSupportedException e) {
            return sparseIntArray;
        }
    }

    public void delete(int i) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            removeAt(binarySearch);
        }
    }

    public int get(int i) {
        return get(i, 0);
    }

    public int get(int i, int i2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        return binarySearch < 0 ? i2 : this.mValues[binarySearch];
    }

    public int indexOfKey(int i) {
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
    }

    public int indexOfValue(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mSize) {
                return -1;
            }
            if (this.mValues[i3] == i) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public int keyAt(int i) {
        return this.mKeys[i];
    }

    public void put(int i, int i2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = i2;
            return;
        }
        int i3 = binarySearch ^ (-1);
        this.mKeys = GrowingArrayUtils.insert(this.mKeys, this.mSize, i3, i);
        this.mValues = GrowingArrayUtils.insert(this.mValues, this.mSize, i3, i2);
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

    public int valueAt(int i) {
        return this.mValues[i];
    }
}
