package androidx.collection;

/* loaded from: source-8756600-dex2jar.jar:androidx/collection/SparseArrayCompat.class */
public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1964a = new Object();
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f1965c;
    private Object[] d;
    private int e;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.b = false;
        if (i == 0) {
            this.f1965c = ContainerHelpers.f1947a;
            this.d = ContainerHelpers.f1948c;
            return;
        }
        int idealIntArraySize = ContainerHelpers.idealIntArraySize(i);
        this.f1965c = new int[idealIntArraySize];
        this.d = new Object[idealIntArraySize];
    }

    private void a() {
        int i = this.e;
        int[] iArr = this.f1965c;
        Object[] objArr = this.d;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= i) {
                this.b = false;
                this.e = i4;
                return;
            }
            Object obj = objArr[i2];
            int i5 = i4;
            if (obj != f1964a) {
                if (i2 != i4) {
                    iArr[i4] = iArr[i2];
                    objArr[i4] = obj;
                    objArr[i2] = null;
                }
                i5 = i4 + 1;
            }
            i2++;
            i3 = i5;
        }
    }

    public void append(int i, E e) {
        int i2 = this.e;
        if (i2 != 0 && i <= this.f1965c[i2 - 1]) {
            put(i, e);
            return;
        }
        if (this.b && this.e >= this.f1965c.length) {
            a();
        }
        int i3 = this.e;
        if (i3 >= this.f1965c.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr = new Object[idealIntArraySize];
            int[] iArr2 = this.f1965c;
            System.arraycopy((Object) iArr2, 0, (Object) iArr, 0, iArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1965c = iArr;
            this.d = objArr;
        }
        this.f1965c[i3] = i;
        this.d[i3] = e;
        this.e = i3 + 1;
    }

    public void clear() {
        int i = this.e;
        Object[] objArr = this.d;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.e = 0;
                this.b = false;
                return;
            }
            objArr[i3] = null;
            i2 = i3 + 1;
        }
    }

    /* renamed from: clone */
    public SparseArrayCompat<E> m1275clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.f1965c = (int[]) this.f1965c.clone();
            sparseArrayCompat.d = (Object[]) this.d.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean containsKey(int i) {
        return indexOfKey(i) >= 0;
    }

    public boolean containsValue(E e) {
        return indexOfValue(e) >= 0;
    }

    @Deprecated
    public void delete(int i) {
        remove(i);
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        int a2 = ContainerHelpers.a(this.f1965c, this.e, i);
        if (a2 >= 0) {
            Object[] objArr = this.d;
            return objArr[a2] == f1964a ? e : (E) objArr[a2];
        }
        return e;
    }

    public int indexOfKey(int i) {
        if (this.b) {
            a();
        }
        return ContainerHelpers.a(this.f1965c, this.e, i);
    }

    public int indexOfValue(E e) {
        if (this.b) {
            a();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e) {
                return -1;
            }
            if (this.d[i2] == e) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int i) {
        if (this.b) {
            a();
        }
        return this.f1965c[i];
    }

    public void put(int i, E e) {
        int a2 = ContainerHelpers.a(this.f1965c, this.e, i);
        if (a2 >= 0) {
            this.d[a2] = e;
            return;
        }
        if (a2 < this.e) {
            Object[] objArr = this.d;
            if (objArr[a2] == f1964a) {
                this.f1965c[a2] = i;
                objArr[a2] = e;
                return;
            }
        }
        int i2 = a2;
        if (this.b) {
            i2 = a2;
            if (this.e >= this.f1965c.length) {
                a();
                i2 = ContainerHelpers.a(this.f1965c, this.e, i);
            }
        }
        int i3 = this.e;
        if (i3 >= this.f1965c.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = this.f1965c;
            System.arraycopy((Object) iArr2, 0, (Object) iArr, 0, iArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1965c = iArr;
            this.d = objArr2;
        }
        int i4 = this.e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f1965c;
            int i5 = i2 + 1;
            System.arraycopy((Object) iArr3, i2, (Object) iArr3, i5, i4 - i2);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.e - i2);
        }
        this.f1965c[i2] = i;
        this.d[i2] = e;
        this.e++;
    }

    public void putAll(SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            put(sparseArrayCompat.keyAt(i2), sparseArrayCompat.valueAt(i2));
            i = i2 + 1;
        }
    }

    public E putIfAbsent(int i, E e) {
        E e2 = get(i);
        if (e2 == null) {
            put(i, e);
        }
        return e2;
    }

    public void remove(int i) {
        int a2 = ContainerHelpers.a(this.f1965c, this.e, i);
        if (a2 >= 0) {
            Object[] objArr = this.d;
            Object obj = objArr[a2];
            Object obj2 = f1964a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.b = true;
            }
        }
    }

    public boolean remove(int i, Object obj) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey >= 0) {
            E valueAt = valueAt(indexOfKey);
            if (obj == valueAt || (obj != null && obj.equals(valueAt))) {
                removeAt(indexOfKey);
                return true;
            }
            return false;
        }
        return false;
    }

    public void removeAt(int i) {
        Object[] objArr = this.d;
        Object obj = objArr[i];
        Object obj2 = f1964a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.b = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.e, i2 + i);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    public E replace(int i, E e) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey >= 0) {
            Object[] objArr = this.d;
            E e2 = (E) objArr[indexOfKey];
            objArr[indexOfKey] = e;
            return e2;
        }
        return null;
    }

    public boolean replace(int i, E e, E e2) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey >= 0) {
            Object obj = this.d[indexOfKey];
            if (obj == e || (e != null && e.equals(obj))) {
                this.d[indexOfKey] = e2;
                return true;
            }
            return false;
        }
        return false;
    }

    public void setValueAt(int i, E e) {
        if (this.b) {
            a();
        }
        this.d[i] = e;
    }

    public int size() {
        if (this.b) {
            a();
        }
        return this.e;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e) {
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
        if (this.b) {
            a();
        }
        return (E) this.d[i];
    }
}
