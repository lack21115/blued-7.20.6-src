package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/collection/ArraySet.class */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;
    int mSize;

    public ArraySet() {
        this(0);
    }

    public ArraySet(int i) {
        if (i == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(ArraySet<E> arraySet) {
        this();
        if (arraySet != 0) {
            addAll((ArraySet) arraySet);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }

    private void allocArrays(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                try {
                    if (sTwiceBaseCache != null) {
                        Object[] objArr = sTwiceBaseCache;
                        this.mArray = objArr;
                        sTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        sTwiceBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                try {
                    if (sBaseCache != null) {
                        Object[] objArr2 = sBaseCache;
                        this.mArray = objArr2;
                        sBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        sBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[i];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                try {
                    if (sTwiceBaseCacheSize < 10) {
                        objArr[0] = sTwiceBaseCache;
                        objArr[1] = iArr;
                        while (true) {
                            i--;
                            if (i < 2) {
                                break;
                            }
                            objArr[i] = null;
                        }
                        sTwiceBaseCache = objArr;
                        sTwiceBaseCacheSize++;
                    }
                } finally {
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                try {
                    if (sBaseCacheSize < 10) {
                        objArr[0] = sBaseCache;
                        objArr[1] = iArr;
                        while (true) {
                            i--;
                            if (i < 2) {
                                break;
                            }
                            objArr[i] = null;
                        }
                        sBaseCache = objArr;
                        sBaseCacheSize++;
                    }
                } finally {
                }
            }
        }
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<E, E>() { // from class: androidx.collection.ArraySet.1
                @Override // androidx.collection.MapCollections
                protected int a() {
                    return ArraySet.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                protected int a(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected Object a(int i, int i2) {
                    return ArraySet.this.mArray[i];
                }

                @Override // androidx.collection.MapCollections
                protected E a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.collection.MapCollections
                protected void a(int i) {
                    ArraySet.this.removeAt(i);
                }

                @Override // androidx.collection.MapCollections
                protected void a(E e, E e2) {
                    ArraySet.this.add(e);
                }

                @Override // androidx.collection.MapCollections
                protected int b(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.collection.MapCollections
                protected void c() {
                    ArraySet.this.clear();
                }
            };
        }
        return this.mCollections;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int indexOf(java.lang.Object r5, int r6) {
        /*
            r4 = this;
            r0 = r4
            int r0 = r0.mSize
            r8 = r0
            r0 = r8
            if (r0 != 0) goto Ld
            r0 = -1
            return r0
        Ld:
            r0 = r4
            int[] r0 = r0.mHashes
            r1 = r8
            r2 = r6
            int r0 = androidx.collection.ContainerHelpers.a(r0, r1, r2)
            r9 = r0
            r0 = r9
            if (r0 >= 0) goto L21
            r0 = r9
            return r0
        L21:
            r0 = r5
            r1 = r4
            java.lang.Object[] r1 = r1.mArray
            r2 = r9
            r1 = r1[r2]
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L32
            r0 = r9
            return r0
        L32:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
        L37:
            r0 = r7
            r1 = r8
            if (r0 >= r1) goto L5d
            r0 = r4
            int[] r0 = r0.mHashes
            r1 = r7
            r0 = r0[r1]
            r1 = r6
            if (r0 != r1) goto L5d
            r0 = r5
            r1 = r4
            java.lang.Object[] r1 = r1.mArray
            r2 = r7
            r1 = r1[r2]
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L56
            r0 = r7
            return r0
        L56:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L37
        L5d:
            r0 = r9
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
        L63:
            r0 = r8
            if (r0 < 0) goto L8d
            r0 = r4
            int[] r0 = r0.mHashes
            r1 = r8
            r0 = r0[r1]
            r1 = r6
            if (r0 != r1) goto L8d
            r0 = r5
            r1 = r4
            java.lang.Object[] r1 = r1.mArray
            r2 = r8
            r1 = r1[r2]
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            r0 = r8
            return r0
        L84:
            r0 = r8
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
            goto L63
        L8d:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ArraySet.indexOf(java.lang.Object, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        if (r0 < 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r4.mHashes[r0] != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
        if (r4.mArray[r0] != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int indexOfNull() {
        /*
            r4 = this;
            r0 = r4
            int r0 = r0.mSize
            r6 = r0
            r0 = r6
            if (r0 != 0) goto Lb
            r0 = -1
            return r0
        Lb:
            r0 = r4
            int[] r0 = r0.mHashes
            r1 = r6
            r2 = 0
            int r0 = androidx.collection.ContainerHelpers.a(r0, r1, r2)
            r7 = r0
            r0 = r7
            if (r0 >= 0) goto L1b
            r0 = r7
            return r0
        L1b:
            r0 = r4
            java.lang.Object[] r0 = r0.mArray
            r1 = r7
            r0 = r0[r1]
            if (r0 != 0) goto L26
            r0 = r7
            return r0
        L26:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L2a:
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L4a
            r0 = r4
            int[] r0 = r0.mHashes
            r1 = r5
            r0 = r0[r1]
            if (r0 != 0) goto L4a
            r0 = r4
            java.lang.Object[] r0 = r0.mArray
            r1 = r5
            r0 = r0[r1]
            if (r0 != 0) goto L43
            r0 = r5
            return r0
        L43:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L2a
        L4a:
            r0 = r7
            r1 = 1
            int r0 = r0 - r1
            r6 = r0
        L4e:
            r0 = r6
            if (r0 < 0) goto L6d
            r0 = r4
            int[] r0 = r0.mHashes
            r1 = r6
            r0 = r0[r1]
            if (r0 != 0) goto L6d
            r0 = r4
            java.lang.Object[] r0 = r0.mArray
            r1 = r6
            r0 = r0[r1]
            if (r0 != 0) goto L66
            r0 = r6
            return r0
        L66:
            r0 = r6
            r1 = 1
            int r0 = r0 - r1
            r6 = r0
            goto L4e
        L6d:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ArraySet.indexOfNull():int");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int hashCode;
        int indexOf;
        if (e == null) {
            indexOf = indexOfNull();
            hashCode = 0;
        } else {
            hashCode = e.hashCode();
            indexOf = indexOf(e, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i = indexOf;
        int i2 = this.mSize;
        if (i2 >= this.mHashes.length) {
            int i3 = 4;
            if (i2 >= 8) {
                i3 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i3 = 8;
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i3);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        int i4 = this.mSize;
        if (i < i4) {
            int[] iArr3 = this.mHashes;
            int i5 = i + 1;
            System.arraycopy(iArr3, i, iArr3, i5, i4 - i);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i, objArr2, i5, this.mSize - i);
        }
        this.mHashes[i] = hashCode;
        this.mArray[i] = e;
        this.mSize++;
        return true;
    }

    public void addAll(ArraySet<? extends E> arraySet) {
        int i = arraySet.mSize;
        ensureCapacity(this.mSize + i);
        if (this.mSize != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                add(arraySet.valueAt(i2));
            }
        } else if (i > 0) {
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i);
            System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i);
            this.mSize = i;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = z2 | add(it.next());
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.mSize;
        if (i != 0) {
            freeArrays(this.mHashes, this.mArray, i);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i) {
        int[] iArr = this.mHashes;
        if (iArr.length < i) {
            Object[] objArr = this.mArray;
            allocArrays(i);
            int i2 = this.mSize;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i2);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= this.mSize) {
                    return true;
                }
                if (!set.contains(valueAt(i2))) {
                    return false;
                }
                i = i2 + 1;
            } catch (ClassCastException | NullPointerException e) {
                return false;
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.mHashes;
        int i = this.mSize;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public boolean removeAll(ArraySet<? extends E> arraySet) {
        int i = arraySet.mSize;
        int i2 = this.mSize;
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                break;
            }
            remove(arraySet.valueAt(i4));
            i3 = i4 + 1;
        }
        if (i2 != this.mSize) {
            z = true;
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = z2 | remove(it.next());
        }
    }

    public E removeAt(int i) {
        Object[] objArr = this.mArray;
        E e = (E) objArr[i];
        int i2 = this.mSize;
        if (i2 <= 1) {
            freeArrays(this.mHashes, objArr, i2);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
            return e;
        }
        int[] iArr = this.mHashes;
        int i3 = 8;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            int i4 = this.mSize - 1;
            this.mSize = i4;
            if (i < i4) {
                int[] iArr2 = this.mHashes;
                int i5 = i + 1;
                System.arraycopy(iArr2, i5, iArr2, i, i4 - i);
                Object[] objArr2 = this.mArray;
                System.arraycopy(objArr2, i5, objArr2, i, this.mSize - i);
            }
            this.mArray[this.mSize] = null;
        } else {
            if (i2 > 8) {
                i3 = i2 + (i2 >> 1);
            }
            int[] iArr3 = this.mHashes;
            Object[] objArr3 = this.mArray;
            allocArrays(i3);
            this.mSize--;
            if (i > 0) {
                System.arraycopy(iArr3, 0, this.mHashes, 0, i);
                System.arraycopy(objArr3, 0, this.mArray, 0, i);
            }
            int i6 = this.mSize;
            if (i < i6) {
                int i7 = i + 1;
                System.arraycopy(iArr3, i7, this.mHashes, i, i6 - i);
                System.arraycopy(objArr3, i7, this.mArray, i, this.mSize - i);
                return e;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.mSize - 1; i >= 0; i--) {
            if (!collection.contains(this.mArray[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.mSize;
        Object[] objArr = new Object[i];
        System.arraycopy(this.mArray, 0, objArr, 0, i);
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object[]] */
    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2 = tArr;
        if (tArr.length < this.mSize) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize);
        }
        System.arraycopy(this.mArray, 0, tArr2, 0, this.mSize);
        int length = tArr2.length;
        int i = this.mSize;
        if (length > i) {
            tArr2[i] = null;
        }
        return tArr2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
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
            E valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
            i = i2 + 1;
        }
    }

    public E valueAt(int i) {
        return (E) this.mArray[i];
    }
}
