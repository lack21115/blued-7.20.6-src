package android.util;

import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/util/SparseArray.class */
public class SparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArray() {
        this(10);
    }

    public SparseArray(int i) {
        this.mGarbage = false;
        if (i == 0) {
            this.mKeys = EmptyArray.INT;
            this.mValues = EmptyArray.OBJECT;
        } else {
            this.mValues = ArrayUtils.newUnpaddedObjectArray(i);
            this.mKeys = new int[this.mValues.length];
        }
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int i2 = 0;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i3 = 0;
        while (i3 < i) {
            Object obj = objArr[i3];
            int i4 = i2;
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i4 = i2 + 1;
            }
            i3++;
            i2 = i4;
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void append(int i, E e) {
        if (this.mSize != 0 && i <= this.mKeys[this.mSize - 1]) {
            put(i, e);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc();
        }
        this.mKeys = GrowingArrayUtils.append(this.mKeys, this.mSize, i);
        this.mValues = GrowingArrayUtils.append((E[]) this.mValues, this.mSize, e);
        this.mSize++;
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.mSize = 0;
                this.mGarbage = false;
                return;
            }
            objArr[i3] = null;
            i2 = i3 + 1;
        }
    }

    /* renamed from: clone */
    public SparseArray<E> m1029clone() {
        SparseArray<E> sparseArray = null;
        try {
            SparseArray<E> sparseArray2 = (SparseArray) super.clone();
            sparseArray2.mKeys = (int[]) this.mKeys.clone();
            sparseArray = sparseArray2;
            sparseArray2.mValues = (Object[]) this.mValues.clone();
            return sparseArray2;
        } catch (CloneNotSupportedException e) {
            return sparseArray;
        }
    }

    public void delete(int i) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch < 0 || this.mValues[binarySearch] == DELETED) {
            return;
        }
        this.mValues[binarySearch] = DELETED;
        this.mGarbage = true;
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        return (binarySearch < 0 || this.mValues[binarySearch] == DELETED) ? e : (E) this.mValues[binarySearch];
    }

    public int indexOfKey(int i) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
    }

    public int indexOfValue(E e) {
        if (this.mGarbage) {
            gc();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSize) {
                return -1;
            }
            if (this.mValues[i2] == e) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public int keyAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i];
    }

    public void put(int i, E e) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e;
            return;
        }
        int i2 = binarySearch ^ (-1);
        if (i2 < this.mSize && this.mValues[i2] == DELETED) {
            this.mKeys[i2] = i;
            this.mValues[i2] = e;
            return;
        }
        int i3 = i2;
        if (this.mGarbage) {
            i3 = i2;
            if (this.mSize >= this.mKeys.length) {
                gc();
                i3 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i) ^ (-1);
            }
        }
        this.mKeys = GrowingArrayUtils.insert(this.mKeys, this.mSize, i3, i);
        this.mValues = GrowingArrayUtils.insert((E[]) this.mValues, this.mSize, i3, e);
        this.mSize++;
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if (this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.mSize, i + i2);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    public void setValueAt(int i, E e) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i] = e;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
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
            E valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
            i = i2 + 1;
        }
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i];
    }
}
