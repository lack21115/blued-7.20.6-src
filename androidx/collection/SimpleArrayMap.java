package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:androidx/collection/SimpleArrayMap.class */
public class SimpleArrayMap<K, V> {
    static Object[] b;

    /* renamed from: c  reason: collision with root package name */
    static int f1915c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public SimpleArrayMap() {
        this.f = ContainerHelpers.f1899a;
        this.g = ContainerHelpers.f1900c;
        this.h = 0;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f = ContainerHelpers.f1899a;
            this.g = ContainerHelpers.f1900c;
        } else {
            a(i);
        }
        this.h = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }

    private static int a(int[] iArr, int i, int i2) {
        try {
            return ContainerHelpers.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ConcurrentModificationException();
        }
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (d != null) {
                        Object[] objArr = d;
                        this.g = objArr;
                        d = (Object[]) objArr[0];
                        this.f = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        e--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (b != null) {
                        Object[] objArr2 = b;
                        this.g = objArr2;
                        b = (Object[]) objArr2[0];
                        this.f = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f1915c--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[i << 1];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (e < 10) {
                        objArr[0] = d;
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
                        d = objArr;
                        e++;
                    }
                } finally {
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (f1915c < 10) {
                        objArr[0] = b;
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
                        b = objArr;
                        f1915c++;
                    }
                } finally {
                }
            }
        }
    }

    int a() {
        int i;
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f, i2, 0);
        if (a2 >= 0 && this.g[a2 << 1] != null) {
            int i3 = a2;
            while (true) {
                i = i3 + 1;
                if (i >= i2 || this.f[i] != 0) {
                    break;
                } else if (this.g[i << 1] == null) {
                    return i;
                } else {
                    i3 = i;
                }
            }
            int i4 = a2;
            while (true) {
                int i5 = i4 - 1;
                if (i5 < 0 || this.f[i5] != 0) {
                    break;
                } else if (this.g[i5 << 1] == null) {
                    return i5;
                } else {
                    i4 = i5;
                }
            }
            return i;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Object obj) {
        int i = this.h * 2;
        Object[] objArr = this.g;
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

    int a(Object obj, int i) {
        int i2;
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int a2 = a(this.f, i3, i);
        if (a2 >= 0 && !obj.equals(this.g[a2 << 1])) {
            int i4 = a2;
            while (true) {
                i2 = i4 + 1;
                if (i2 >= i3 || this.f[i2] != i) {
                    break;
                } else if (obj.equals(this.g[i2 << 1])) {
                    return i2;
                } else {
                    i4 = i2;
                }
            }
            int i5 = a2;
            while (true) {
                int i6 = i5 - 1;
                if (i6 < 0 || this.f[i6] != i) {
                    break;
                } else if (obj.equals(this.g[i6 << 1])) {
                    return i6;
                } else {
                    i5 = i6;
                }
            }
            return i2;
        }
        return a2;
    }

    public void clear() {
        int i = this.h;
        if (i > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            this.f = ContainerHelpers.f1899a;
            this.g = ContainerHelpers.f1900c;
            this.h = 0;
            a(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public void ensureCapacity(int i) {
        int i2 = this.h;
        int[] iArr = this.f;
        if (iArr.length < i) {
            Object[] objArr = this.g;
            a(i);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= this.h) {
                        return true;
                    }
                    K keyAt = keyAt(i2);
                    V valueAt = valueAt(i2);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                    i = i2 + 1;
                } catch (ClassCastException | NullPointerException e2) {
                    return false;
                }
            }
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i3 = 0;
            while (true) {
                try {
                    int i4 = i3;
                    if (i4 >= this.h) {
                        return true;
                    }
                    K keyAt2 = keyAt(i4);
                    V valueAt2 = valueAt(i4);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                    i3 = i4 + 1;
                } catch (ClassCastException | NullPointerException e3) {
                    return false;
                }
            }
        }
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public V getOrDefault(Object obj, V v) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            v = this.g[(indexOfKey << 1) + 1];
        }
        return v;
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i = this.h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public K keyAt(int i) {
        return (K) this.g[i << 1];
    }

    public V put(K k, V v) {
        int hashCode;
        int a2;
        int i = this.h;
        if (k == null) {
            a2 = a();
            hashCode = 0;
        } else {
            hashCode = k.hashCode();
            a2 = a(k, hashCode);
        }
        if (a2 >= 0) {
            int i2 = (a2 << 1) + 1;
            Object[] objArr = this.g;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
        int i3 = a2;
        if (i >= this.f.length) {
            int i4 = 4;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i >= 4) {
                i4 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr2 = this.g;
            a(i4);
            if (i != this.h) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.g, 0, objArr2.length);
            }
            a(iArr, objArr2, i);
        }
        if (i3 < i) {
            int[] iArr3 = this.f;
            int i5 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i5, i - i3);
            Object[] objArr3 = this.g;
            System.arraycopy(objArr3, i3 << 1, objArr3, i5 << 1, (this.h - i3) << 1);
        }
        int i6 = this.h;
        if (i == i6) {
            int[] iArr4 = this.f;
            if (i3 < iArr4.length) {
                iArr4[i3] = hashCode;
                Object[] objArr4 = this.g;
                int i7 = i3 << 1;
                objArr4[i7] = k;
                objArr4[i7 + 1] = v;
                this.h = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.h;
        ensureCapacity(this.h + i);
        if (this.h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.f, 0, this.f, 0, i);
            System.arraycopy(simpleArrayMap.g, 0, this.g, 0, i << 1);
            this.h = i;
        }
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        V v3 = v2;
        if (v2 == null) {
            v3 = put(k, v);
        }
        return v3;
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            V valueAt = valueAt(indexOfKey);
            if (obj2 == valueAt || (obj2 != null && obj2.equals(valueAt))) {
                removeAt(indexOfKey);
                return true;
            }
            return false;
        }
        return false;
    }

    public V removeAt(int i) {
        int i2;
        Object[] objArr = this.g;
        int i3 = i << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.h;
        if (i4 <= 1) {
            a(this.f, objArr, i4);
            this.f = ContainerHelpers.f1899a;
            this.g = ContainerHelpers.f1900c;
            i2 = 0;
        } else {
            int i5 = i4 - 1;
            int[] iArr = this.f;
            int i6 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i < i5) {
                    int[] iArr2 = this.f;
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(iArr2, i7, iArr2, i, i8);
                    Object[] objArr2 = this.g;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.g;
                int i9 = i5 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                if (i4 > 8) {
                    i6 = i4 + (i4 >> 1);
                }
                int[] iArr3 = this.f;
                Object[] objArr4 = this.g;
                a(i6);
                if (i4 != this.h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.f, 0, i);
                    System.arraycopy(objArr4, 0, this.g, 0, i3);
                }
                if (i < i5) {
                    int i10 = i + 1;
                    int i11 = i5 - i;
                    System.arraycopy(iArr3, i10, this.f, i, i11);
                    System.arraycopy(objArr4, i10 << 1, this.g, i3, i11 << 1);
                }
            }
            i2 = i5;
        }
        if (i4 == this.h) {
            this.h = i2;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V replace(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            V valueAt = valueAt(indexOfKey);
            if (valueAt == v || (v != null && v.equals(valueAt))) {
                setValueAt(indexOfKey, v2);
                return true;
            }
            return false;
        }
        return false;
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.g;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h) {
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

    public V valueAt(int i) {
        return (V) this.g[(i << 1) + 1];
    }
}
