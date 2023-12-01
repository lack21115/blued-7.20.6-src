package com.tencent.tinker.android.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/utils/SparseBoolArray.class */
public class SparseBoolArray implements Cloneable {
    private int[] mKeys;
    private int mSize;
    private boolean[] mValues;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final boolean[] EMPTY_BOOL_ARRAY = new boolean[0];

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/utils/SparseBoolArray$KeyNotFoundException.class */
    public static class KeyNotFoundException extends Exception {
        public KeyNotFoundException() {
        }

        public KeyNotFoundException(String str) {
            super(str);
        }
    }

    public SparseBoolArray() {
        this(10);
    }

    public SparseBoolArray(int i) {
        if (i == 0) {
            this.mKeys = EMPTY_INT_ARRAY;
            this.mValues = EMPTY_BOOL_ARRAY;
        } else {
            this.mKeys = new int[i];
            this.mValues = new boolean[i];
        }
        this.mSize = 0;
    }

    private boolean[] appendElementIntoBoolArray(boolean[] zArr, int i, boolean z) {
        if (i <= zArr.length) {
            boolean[] zArr2 = zArr;
            if (i + 1 > zArr.length) {
                zArr2 = new boolean[growSize(i)];
                System.arraycopy(zArr, 0, zArr2, 0, i);
            }
            zArr2[i] = z;
            return zArr2;
        }
        throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i);
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

    private static int growSize(int i) {
        if (i <= 4) {
            return 8;
        }
        return i + (i >> 1);
    }

    private boolean[] insertElementIntoBoolArray(boolean[] zArr, int i, int i2, boolean z) {
        if (i > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i);
        } else if (i + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i - i2);
            zArr[i2] = z;
            return zArr;
        } else {
            boolean[] zArr2 = new boolean[growSize(i)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            zArr2[i2] = z;
            System.arraycopy(zArr, i2, zArr2, i2 + 1, zArr.length - i2);
            return zArr2;
        }
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

    public void append(int i, boolean z) {
        int i2 = this.mSize;
        if (i2 != 0 && i <= this.mKeys[i2 - 1]) {
            put(i, z);
            return;
        }
        this.mKeys = appendElementIntoIntArray(this.mKeys, this.mSize, i);
        this.mValues = appendElementIntoBoolArray(this.mValues, this.mSize, z);
        this.mSize++;
    }

    public void clear() {
        this.mSize = 0;
    }

    /* renamed from: clone */
    public SparseBoolArray m7877clone() {
        SparseBoolArray sparseBoolArray = null;
        try {
            SparseBoolArray sparseBoolArray2 = (SparseBoolArray) super.clone();
            try {
                sparseBoolArray2.mKeys = (int[]) this.mKeys.clone();
                sparseBoolArray2.mValues = (boolean[]) this.mValues.clone();
                return sparseBoolArray2;
            } catch (CloneNotSupportedException e) {
                sparseBoolArray = sparseBoolArray2;
                return sparseBoolArray;
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

    public boolean get(int i) throws KeyNotFoundException {
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            return this.mValues[binarySearch];
        }
        throw new KeyNotFoundException("" + i);
    }

    public int indexOfKey(int i) {
        return binarySearch(this.mKeys, this.mSize, i);
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
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = z;
            return;
        }
        this.mKeys = insertElementIntoIntArray(this.mKeys, this.mSize, binarySearch, i);
        this.mValues = insertElementIntoBoolArray(this.mValues, this.mSize, binarySearch, z);
        this.mSize++;
    }

    public void removeAt(int i) {
        int[] iArr = this.mKeys;
        int i2 = i + 1;
        System.arraycopy(iArr, i2, iArr, i, this.mSize - i2);
        boolean[] zArr = this.mValues;
        System.arraycopy(zArr, i2, zArr, i, this.mSize - i2);
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

    public boolean valueAt(int i) {
        return this.mValues[i];
    }
}
