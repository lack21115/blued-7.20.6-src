package skin.support.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:skin/support/collection/SimpleArrayMap.class */
public class SimpleArrayMap<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f = ContainerHelpers.a;
    Object[] g = ContainerHelpers.c;
    int h = 0;

    private static int a(int[] iArr, int i, int i2) {
        try {
            return ContainerHelpers.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ConcurrentModificationException();
        }
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
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
            synchronized (ArrayMap.class) {
                try {
                    if (c < 10) {
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
                        c++;
                    }
                } finally {
                }
            }
        }
    }

    private void e(int i) {
        if (i == 8) {
            synchronized (ArrayMap.class) {
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
            synchronized (ArrayMap.class) {
                try {
                    if (b != null) {
                        Object[] objArr2 = b;
                        this.g = objArr2;
                        b = (Object[]) objArr2[0];
                        this.f = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        c--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[i << 1];
    }

    int a() {
        int i;
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a = a(this.f, i2, 0);
        if (a >= 0 && this.g[a << 1] != null) {
            int i3 = a;
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
            int i4 = a;
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
        return a;
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    int a(Object obj, int i) {
        int i2;
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int a = a(this.f, i3, i);
        if (a >= 0 && !obj.equals(this.g[a << 1])) {
            int i4 = a;
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
            int i5 = a;
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
        return a;
    }

    public V a(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.g;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public void a(int i) {
        int i2 = this.h;
        int[] iArr = this.f;
        if (iArr.length < i) {
            Object[] objArr = this.g;
            e(i);
            if (this.h > 0) {
                System.arraycopy((Object) iArr, 0, (Object) this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(Object obj) {
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

    public K b(int i) {
        return (K) this.g[i << 1];
    }

    public V c(int i) {
        return (V) this.g[(i << 1) + 1];
    }

    public void clear() {
        int i = this.h;
        if (i > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            this.f = ContainerHelpers.a;
            this.g = ContainerHelpers.c;
            this.h = 0;
            a(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i) {
        int i2;
        Object[] objArr = this.g;
        int i3 = i << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.h;
        if (i4 <= 1) {
            a(this.f, objArr, i4);
            this.f = ContainerHelpers.a;
            this.g = ContainerHelpers.c;
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
                    System.arraycopy((Object) iArr2, i7, (Object) iArr2, i, i8);
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
                e(i6);
                if (i4 != this.h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy((Object) iArr3, 0, (Object) this.f, 0, i);
                    System.arraycopy(objArr4, 0, this.g, 0, i3);
                }
                if (i < i5) {
                    int i10 = i + 1;
                    int i11 = i5 - i;
                    System.arraycopy((Object) iArr3, i10, (Object) this.f, i, i11);
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
                    K b2 = b(i2);
                    V c2 = c(i2);
                    Object obj2 = simpleArrayMap.get(b2);
                    if (c2 == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj2)) {
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
                    K b3 = b(i4);
                    V c3 = c(i4);
                    Object obj3 = map.get(b3);
                    if (c3 == null) {
                        if (obj3 != null || !map.containsKey(b3)) {
                            return false;
                        }
                    } else if (!c3.equals(obj3)) {
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
        int a = a(obj);
        if (a >= 0) {
            return (V) this.g[(a << 1) + 1];
        }
        return null;
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

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int hashCode;
        int a;
        int i = this.h;
        if (k == null) {
            a = a();
            hashCode = 0;
        } else {
            hashCode = k.hashCode();
            a = a(k, hashCode);
        }
        if (a >= 0) {
            int i2 = (a << 1) + 1;
            Object[] objArr = this.g;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
        int i3 = a;
        if (i >= this.f.length) {
            int i4 = 4;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i >= 4) {
                i4 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr2 = this.g;
            e(i4);
            if (i != this.h) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f;
            if (iArr2.length > 0) {
                System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.g, 0, objArr2.length);
            }
            a(iArr, objArr2, i);
        }
        if (i3 < i) {
            int[] iArr3 = this.f;
            int i5 = i3 + 1;
            System.arraycopy((Object) iArr3, i3, (Object) iArr3, i5, i - i3);
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

    public V remove(Object obj) {
        int a = a(obj);
        if (a >= 0) {
            return d(a);
        }
        return null;
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
            K b2 = b(i2);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
            i = i2 + 1;
        }
    }
}
