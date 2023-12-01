package com.tencent.tinker.android.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/utils/SparseIntArray.class */
public class SparseIntArray implements Cloneable {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private int[] mKeys;
    private int mSize;
    private int[] mValues;

    public SparseIntArray() {
        this(10);
    }

    public SparseIntArray(int i) {
        if (i == 0) {
            int[] iArr = EMPTY_INT_ARRAY;
            this.mKeys = iArr;
            this.mValues = iArr;
        } else {
            int[] iArr2 = new int[i];
            this.mKeys = iArr2;
            this.mValues = new int[iArr2.length];
        }
        this.mSize = 0;
    }

    private int[] appendElementIntoIntArray(int[] iArr, int i, int i2) {
        if (i <= iArr.length) {
            int[] iArr2 = iArr;
            if (i + 1 > iArr.length) {
                iArr2 = new int[growSize(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
            }
            iArr2[i] = i2;
            return iArr2;
        }
        throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
    }

    private int binarySearch(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4;
    }

    public static int growSize(int i) {
        if (i <= 4) {
            return 8;
        }
        return i + (i >> 1);
    }

    private int[] insertElementIntoIntArray(int[] iArr, int i, int i2, int i3) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        } else if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        } else {
            int[] iArr2 = new int[growSize(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr2[i2] = i3;
            System.arraycopy(iArr, i2, iArr2, i2 + 1, iArr.length - i2);
            return iArr2;
        }
    }

    public void append(int i, int i2) {
        int i3 = this.mSize;
        if (i3 != 0 && i <= this.mKeys[i3 - 1]) {
            put(i, i2);
            return;
        }
        this.mKeys = appendElementIntoIntArray(this.mKeys, this.mSize, i);
        this.mValues = appendElementIntoIntArray(this.mValues, this.mSize, i2);
        this.mSize++;
    }

    public void clear() {
        this.mSize = 0;
    }

    /* renamed from: clone */
    public SparseIntArray m7879clone() {
        SparseIntArray sparseIntArray = null;
        try {
            SparseIntArray sparseIntArray2 = (SparseIntArray) super.clone();
            try {
                sparseIntArray2.mKeys = (int[]) this.mKeys.clone();
                sparseIntArray2.mValues = (int[]) this.mValues.clone();
                return sparseIntArray2;
            } catch (CloneNotSupportedException e) {
                sparseIntArray = sparseIntArray2;
                return sparseIntArray;
            }
        } catch (CloneNotSupportedException e2) {
        }
    }

    public boolean containsKey(int i) {
        return indexOfKey(i) >= 0;
    }

    public void delete(int i) {
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            removeAt(binarySearch);
        }
    }

    public int get(int i) {
        return get(i, 0);
    }

    public int get(int i, int i2) {
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        return binarySearch < 0 ? i2 : this.mValues[binarySearch];
    }

    public int indexOfKey(int i) {
        return binarySearch(this.mKeys, this.mSize, i);
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
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = i2;
            return;
        }
        this.mKeys = insertElementIntoIntArray(this.mKeys, this.mSize, binarySearch, i);
        this.mValues = insertElementIntoIntArray(this.mValues, this.mSize, binarySearch, i2);
        this.mSize++;
    }

    public void removeAt(int i) {
        int[] iArr = this.mKeys;
        int i2 = i + 1;
        System.arraycopy(iArr, i2, iArr, i, this.mSize - i2);
        int[] iArr2 = this.mValues;
        System.arraycopy(iArr2, i2, iArr2, i, this.mSize - i2);
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
