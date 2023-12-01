package android.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/util/ArrayMap.class */
public final class ArrayMap<K, V> implements Map<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    public static final ArrayMap EMPTY = new ArrayMap(true);
    static final int[] EMPTY_IMMUTABLE_INTS = new int[0];
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    MapCollections<K, V> mCollections;
    int[] mHashes;
    int mSize;

    public ArrayMap() {
        this.mHashes = EmptyArray.INT;
        this.mArray = EmptyArray.OBJECT;
        this.mSize = 0;
    }

    public ArrayMap(int i) {
        if (i == 0) {
            this.mHashes = EmptyArray.INT;
            this.mArray = EmptyArray.OBJECT;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    public ArrayMap(ArrayMap arrayMap) {
        this();
        if (arrayMap != null) {
            putAll(arrayMap);
        }
    }

    private ArrayMap(boolean z) {
        this.mHashes = z ? EMPTY_IMMUTABLE_INTS : EmptyArray.INT;
        this.mArray = EmptyArray.OBJECT;
        this.mSize = 0;
    }

    private void allocArrays(int i) {
        if (this.mHashes == EMPTY_IMMUTABLE_INTS) {
            throw new UnsupportedOperationException("ArrayMap is immutable");
        }
        if (i == 8) {
            synchronized (ArrayMap.class) {
                try {
                    if (mTwiceBaseCache != null) {
                        Object[] objArr = mTwiceBaseCache;
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                try {
                    if (mBaseCache != null) {
                        Object[] objArr2 = mBaseCache;
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[i << 1];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                try {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr[0] = mTwiceBaseCache;
                        objArr[1] = iArr;
                        int i2 = i << 1;
                        while (true) {
                            int i3 = i2 - 1;
                            if (i3 < 2) {
                                break;
                            }
                            objArr[i3] = null;
                            i2 = i3;
                        }
                        mTwiceBaseCache = objArr;
                        mTwiceBaseCacheSize++;
                    }
                } finally {
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                try {
                    if (mBaseCacheSize < 10) {
                        objArr[0] = mBaseCache;
                        objArr[1] = iArr;
                        int i4 = i << 1;
                        while (true) {
                            int i5 = i4 - 1;
                            if (i5 < 2) {
                                break;
                            }
                            objArr[i5] = null;
                            i4 = i5;
                        }
                        mBaseCache = objArr;
                        mBaseCacheSize++;
                    }
                } finally {
                }
            }
        }
    }

    private MapCollections<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<K, V>() { // from class: android.util.ArrayMap.1
                @Override // android.util.MapCollections
                protected void colClear() {
                    ArrayMap.this.clear();
                }

                @Override // android.util.MapCollections
                protected Object colGetEntry(int i, int i2) {
                    return ArrayMap.this.mArray[(i << 1) + i2];
                }

                @Override // android.util.MapCollections
                protected Map<K, V> colGetMap() {
                    return ArrayMap.this;
                }

                @Override // android.util.MapCollections
                protected int colGetSize() {
                    return ArrayMap.this.mSize;
                }

                @Override // android.util.MapCollections
                protected int colIndexOfKey(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                @Override // android.util.MapCollections
                protected int colIndexOfValue(Object obj) {
                    return ArrayMap.this.indexOfValue(obj);
                }

                @Override // android.util.MapCollections
                protected void colPut(K k, V v) {
                    ArrayMap.this.put(k, v);
                }

                @Override // android.util.MapCollections
                protected void colRemoveAt(int i) {
                    ArrayMap.this.removeAt(i);
                }

                @Override // android.util.MapCollections
                protected V colSetValue(int i, V v) {
                    return (V) ArrayMap.this.setValueAt(i, v);
                }
            };
        }
        return this.mCollections;
    }

    public void append(K k, V v) {
        int i = this.mSize;
        int hashCode = k == null ? 0 : k.hashCode();
        if (i >= this.mHashes.length) {
            throw new IllegalStateException("Array is full");
        }
        if (i > 0 && this.mHashes[i - 1] > hashCode) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(TAG, "New hash " + hashCode + " is before end of array hash " + this.mHashes[i - 1] + " at index " + i + " key " + k, runtimeException);
            put(k, v);
            return;
        }
        this.mSize = i + 1;
        this.mHashes[i] = hashCode;
        int i2 = i << 1;
        this.mArray[i2] = k;
        this.mArray[i2 + 1] = v;
    }

    @Override // java.util.Map
    public void clear() {
        if (this.mSize > 0) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = EmptyArray.INT;
            this.mArray = EmptyArray.OBJECT;
            this.mSize = 0;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i) {
        if (this.mHashes.length < i) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize << 1);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return getCollection().getEntrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= this.mSize) {
                    return true;
                }
                K keyAt = keyAt(i2);
                V valueAt = valueAt(i2);
                Object obj2 = map.get(keyAt);
                if (valueAt == null) {
                    if (obj2 == null && map.containsKey(keyAt)) {
                    }
                    return false;
                } else if (!valueAt.equals(obj2)) {
                    return false;
                }
                i = i2 + 1;
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
    }

    public void erase() {
        if (this.mSize <= 0) {
            return;
        }
        int i = this.mSize;
        Object[] objArr = this.mArray;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= (i << 1)) {
                this.mSize = 0;
                return;
            } else {
                objArr[i3] = null;
                i2 = i3 + 1;
            }
        }
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return (V) this.mArray[(indexOfKey << 1) + 1];
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        int i4 = this.mSize;
        while (i2 < i4) {
            Object obj = objArr[i3];
            i += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i3 += 2;
        }
        return i;
    }

    int indexOf(Object obj, int i) {
        int i2;
        int i3;
        int i4 = this.mSize;
        if (i4 == 0) {
            i2 = -1;
        } else {
            int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i4, i);
            i2 = binarySearch;
            if (binarySearch >= 0) {
                i2 = binarySearch;
                if (!obj.equals(this.mArray[binarySearch << 1])) {
                    int i5 = binarySearch;
                    while (true) {
                        i3 = i5 + 1;
                        if (i3 >= i4 || this.mHashes[i3] != i) {
                            break;
                        } else if (obj.equals(this.mArray[i3 << 1])) {
                            return i3;
                        } else {
                            i5 = i3;
                        }
                    }
                    while (true) {
                        binarySearch--;
                        if (binarySearch < 0 || this.mHashes[binarySearch] != i) {
                            break;
                        } else if (obj.equals(this.mArray[binarySearch << 1])) {
                            return binarySearch;
                        }
                    }
                    return i3 ^ (-1);
                }
            }
        }
        return i2;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    int indexOfNull() {
        int i;
        int i2;
        int i3 = this.mSize;
        if (i3 == 0) {
            i = -1;
        } else {
            int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i3, 0);
            i = binarySearch;
            if (binarySearch >= 0) {
                i = binarySearch;
                if (this.mArray[binarySearch << 1] != null) {
                    int i4 = binarySearch;
                    while (true) {
                        i2 = i4 + 1;
                        if (i2 >= i3 || this.mHashes[i2] != 0) {
                            break;
                        } else if (this.mArray[i2 << 1] == null) {
                            return i2;
                        } else {
                            i4 = i2;
                        }
                    }
                    while (true) {
                        binarySearch--;
                        if (binarySearch < 0 || this.mHashes[binarySearch] != 0) {
                            break;
                        } else if (this.mArray[binarySearch << 1] == null) {
                            return binarySearch;
                        }
                    }
                    return i2 ^ (-1);
                }
            }
        }
        return i;
    }

    int indexOfValue(Object obj) {
        int i = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return -1;
                }
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
                i2 = i3 + 2;
            }
        } else {
            int i4 = 1;
            while (true) {
                int i5 = i4;
                if (i5 >= i) {
                    return -1;
                }
                if (obj.equals(objArr[i5])) {
                    return i5 >> 1;
                }
                i4 = i5 + 2;
            }
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public K keyAt(int i) {
        return (K) this.mArray[i << 1];
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return getCollection().getKeySet();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        int hashCode;
        int indexOf;
        int i;
        if (k == null) {
            hashCode = 0;
            indexOf = indexOfNull();
        } else {
            hashCode = k.hashCode();
            indexOf = indexOf(k, hashCode);
        }
        if (indexOf >= 0) {
            int i2 = (indexOf << 1) + 1;
            V v2 = (V) this.mArray[i2];
            this.mArray[i2] = v;
            return v2;
        }
        int i3 = indexOf ^ (-1);
        if (this.mSize >= this.mHashes.length) {
            if (this.mSize >= 8) {
                i = this.mSize + (this.mSize >> 1);
            } else {
                i = 8;
                if (this.mSize < 4) {
                    i = 4;
                }
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i);
            if (this.mHashes.length > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        if (i3 < this.mSize) {
            System.arraycopy(this.mHashes, i3, this.mHashes, i3 + 1, this.mSize - i3);
            System.arraycopy(this.mArray, i3 << 1, this.mArray, (i3 + 1) << 1, (this.mSize - i3) << 1);
        }
        this.mHashes[i3] = hashCode;
        this.mArray[i3 << 1] = k;
        this.mArray[(i3 << 1) + 1] = v;
        this.mSize++;
        return null;
    }

    public void putAll(ArrayMap<? extends K, ? extends V> arrayMap) {
        int i = arrayMap.mSize;
        ensureCapacity(this.mSize + i);
        if (this.mSize == 0) {
            if (i > 0) {
                System.arraycopy(arrayMap.mHashes, 0, this.mHashes, 0, i);
                System.arraycopy(arrayMap.mArray, 0, this.mArray, 0, i << 1);
                this.mSize = i;
                return;
            }
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            put(arrayMap.keyAt(i3), arrayMap.valueAt(i3));
            i2 = i3 + 1;
        }
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public V removeAt(int i) {
        int i2 = 8;
        V v = (V) this.mArray[(i << 1) + 1];
        if (this.mSize <= 1) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = EmptyArray.INT;
            this.mArray = EmptyArray.OBJECT;
            this.mSize = 0;
        } else if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
            this.mSize--;
            if (i < this.mSize) {
                System.arraycopy(this.mHashes, i + 1, this.mHashes, i, this.mSize - i);
                System.arraycopy(this.mArray, (i + 1) << 1, this.mArray, i << 1, (this.mSize - i) << 1);
            }
            this.mArray[this.mSize << 1] = null;
            this.mArray[(this.mSize << 1) + 1] = null;
            return v;
        } else {
            if (this.mSize > 8) {
                i2 = this.mSize + (this.mSize >> 1);
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i2);
            this.mSize--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i);
                System.arraycopy(objArr, 0, this.mArray, 0, i << 1);
            }
            if (i < this.mSize) {
                System.arraycopy(iArr, i + 1, this.mHashes, i, this.mSize - i);
                System.arraycopy(objArr, (i + 1) << 1, this.mArray, i << 1, (this.mSize - i) << 1);
                return v;
            }
        }
        return v;
    }

    public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = (V) this.mArray[i2];
        this.mArray[i2] = v;
        return v2;
    }

    @Override // java.util.Map
    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
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
            K keyAt = keyAt(i2);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x002f, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void validate() {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.util.ArrayMap.validate():void");
    }

    public V valueAt(int i) {
        return (V) this.mArray[(i << 1) + 1];
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return getCollection().getValues();
    }
}
