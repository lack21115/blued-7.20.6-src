package android.util;

import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/util/SparseBooleanArray.class */
public class SparseBooleanArray implements Cloneable {
    private int[] mKeys;
    private int mSize;
    private boolean[] mValues;

    public SparseBooleanArray() {
        this(10);
    }

    public SparseBooleanArray(int i) {
        if (i == 0) {
            this.mKeys = EmptyArray.INT;
            this.mValues = EmptyArray.BOOLEAN;
        } else {
            this.mKeys = ArrayUtils.newUnpaddedIntArray(i);
            this.mValues = new boolean[this.mKeys.length];
        }
        this.mSize = 0;
    }

    public void append(int i, boolean z) {
        if (this.mSize != 0 && i <= this.mKeys[this.mSize - 1]) {
            put(i, z);
            return;
        }
        this.mKeys = GrowingArrayUtils.append(this.mKeys, this.mSize, i);
        this.mValues = GrowingArrayUtils.append(this.mValues, this.mSize, z);
        this.mSize++;
    }

    public void clear() {
        this.mSize = 0;
    }

    /* renamed from: clone */
    public SparseBooleanArray m1026clone() {
        SparseBooleanArray sparseBooleanArray = null;
        try {
            SparseBooleanArray sparseBooleanArray2 = (SparseBooleanArray) super.clone();
            sparseBooleanArray2.mKeys = (int[]) this.mKeys.clone();
            sparseBooleanArray = sparseBooleanArray2;
            sparseBooleanArray2.mValues = (boolean[]) this.mValues.clone();
            return sparseBooleanArray2;
        } catch (CloneNotSupportedException e) {
            return sparseBooleanArray;
        }
    }

    public void delete(int i) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            System.arraycopy(this.mKeys, binarySearch + 1, this.mKeys, binarySearch, this.mSize - (binarySearch + 1));
            System.arraycopy(this.mValues, binarySearch + 1, this.mValues, binarySearch, this.mSize - (binarySearch + 1));
            this.mSize--;
        }
    }

    public boolean get(int i) {
        return get(i, false);
    }

    public boolean get(int i, boolean z) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        return binarySearch < 0 ? z : this.mValues[binarySearch];
    }

    public int indexOfKey(int i) {
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
    }

    public int indexOfValue(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSize) {
                return -1;
            }
            if (this.mValues[i2] == z) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public int keyAt(int i) {
        return this.mKeys[i];
    }

    public void put(int i, boolean z) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = z;
            return;
        }
        int i2 = binarySearch ^ (-1);
        this.mKeys = GrowingArrayUtils.insert(this.mKeys, this.mSize, i2, i);
        this.mValues = GrowingArrayUtils.insert(this.mValues, this.mSize, i2, z);
        this.mSize++;
    }

    public void removeAt(int i) {
        System.arraycopy(this.mKeys, i + 1, this.mKeys, i, this.mSize - (i + 1));
        System.arraycopy(this.mValues, i + 1, this.mValues, i, this.mSize - (i + 1));
        this.mSize--;
    }

    public void setValueAt(int i, boolean z) {
        this.mValues[i] = z;
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

    public boolean valueAt(int i) {
        return this.mValues[i];
    }
}
