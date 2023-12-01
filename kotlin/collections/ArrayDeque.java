package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArrayDeque.class */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Companion a = new Companion(null);
    private static final Object[] e = new Object[0];
    private int b;
    private Object[] c = e;
    private int d;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArrayDeque$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(int i, int i2) {
            int i3 = i + (i >> 1);
            int i4 = i3;
            if (i3 - i2 < 0) {
                i4 = i2;
            }
            int i5 = i4;
            if (i4 - 2147483639 > 0) {
                if (i2 > 2147483639) {
                    return Integer.MAX_VALUE;
                }
                i5 = 2147483639;
            }
            return i5;
        }
    }

    private final void a(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.c;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == e) {
            this.c = new Object[RangesKt.c(i, 10)];
        } else {
            b(a.a(objArr.length, i));
        }
    }

    private final void a(int i, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.c.length;
        while (i < length && it.hasNext()) {
            this.c[i] = it.next();
            i++;
        }
        int i2 = this.b;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.c[i3] = it.next();
        }
        this.d = size() + collection.size();
    }

    private final void b(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.c;
        ArraysKt.a(objArr2, objArr, 0, this.b, objArr2.length);
        Object[] objArr3 = this.c;
        int length = objArr3.length;
        int i2 = this.b;
        ArraysKt.a(objArr3, objArr, length - i2, 0, i2);
        this.b = 0;
        this.c = objArr;
    }

    private final int c(int i) {
        Object[] objArr = this.c;
        int i2 = i;
        if (i >= objArr.length) {
            i2 = i - objArr.length;
        }
        return i2;
    }

    private final int d(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = i + this.c.length;
        }
        return i2;
    }

    private final int e(int i) {
        if (i == ArraysKt.d(this.c)) {
            return 0;
        }
        return i + 1;
    }

    private final int f(int i) {
        return i == 0 ? ArraysKt.d(this.c) : i - 1;
    }

    public final E a() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.c;
        int i = this.b;
        E e2 = (E) objArr[i];
        objArr[i] = null;
        this.b = e(i);
        this.d = size() - 1;
        return e2;
    }

    public final void a(E e2) {
        a(size() + 1);
        int f = f(this.b);
        this.b = f;
        this.c[f] = e2;
        this.d = size() + 1;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, E e2) {
        AbstractList.Companion.b(i, size());
        if (i == size()) {
            b((ArrayDeque<E>) e2);
        } else if (i == 0) {
            a((ArrayDeque<E>) e2);
        } else {
            a(size() + 1);
            int c = c(this.b + i);
            if (i < ((size() + 1) >> 1)) {
                int f = f(c);
                int f2 = f(this.b);
                int i2 = this.b;
                if (f >= i2) {
                    Object[] objArr = this.c;
                    objArr[f2] = objArr[i2];
                    ArraysKt.a(objArr, objArr, i2, i2 + 1, f + 1);
                } else {
                    Object[] objArr2 = this.c;
                    ArraysKt.a(objArr2, objArr2, i2 - 1, i2, objArr2.length);
                    Object[] objArr3 = this.c;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt.a(objArr3, objArr3, 0, 1, f + 1);
                }
                this.c[f] = e2;
                this.b = f2;
            } else {
                int c2 = c(this.b + size());
                if (c < c2) {
                    Object[] objArr4 = this.c;
                    ArraysKt.a(objArr4, objArr4, c + 1, c, c2);
                } else {
                    Object[] objArr5 = this.c;
                    ArraysKt.a(objArr5, objArr5, 1, 0, c2);
                    Object[] objArr6 = this.c;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    ArraysKt.a(objArr6, objArr6, c + 1, c, objArr6.length - 1);
                }
                this.c[c] = e2;
            }
            this.d = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection
    public boolean add(E e2) {
        b((ArrayDeque<E>) e2);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> elements) {
        Intrinsics.e(elements, "elements");
        AbstractList.Companion.b(i, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(elements);
        }
        a(size() + elements.size());
        int c = c(this.b + size());
        int c2 = c(this.b + i);
        int size = elements.size();
        if (i >= ((size() + 1) >> 1)) {
            int i2 = c2 + size;
            if (c2 < c) {
                int i3 = size + c;
                Object[] objArr = this.c;
                if (i3 <= objArr.length) {
                    ArraysKt.a(objArr, objArr, i2, c2, c);
                } else if (i2 >= objArr.length) {
                    ArraysKt.a(objArr, objArr, i2 - objArr.length, c2, c);
                } else {
                    int length = c - (i3 - objArr.length);
                    ArraysKt.a(objArr, objArr, 0, length, c);
                    Object[] objArr2 = this.c;
                    ArraysKt.a(objArr2, objArr2, i2, c2, length);
                }
            } else {
                Object[] objArr3 = this.c;
                ArraysKt.a(objArr3, objArr3, size, 0, c);
                Object[] objArr4 = this.c;
                if (i2 >= objArr4.length) {
                    ArraysKt.a(objArr4, objArr4, i2 - objArr4.length, c2, objArr4.length);
                } else {
                    ArraysKt.a(objArr4, objArr4, 0, objArr4.length - size, objArr4.length);
                    Object[] objArr5 = this.c;
                    ArraysKt.a(objArr5, objArr5, i2, c2, objArr5.length - size);
                }
            }
            a(c2, elements);
            return true;
        }
        int i4 = this.b;
        int i5 = i4 - size;
        if (c2 < i4) {
            Object[] objArr6 = this.c;
            ArraysKt.a(objArr6, objArr6, i5, i4, objArr6.length);
            if (size >= c2) {
                Object[] objArr7 = this.c;
                ArraysKt.a(objArr7, objArr7, objArr7.length - size, 0, c2);
            } else {
                Object[] objArr8 = this.c;
                ArraysKt.a(objArr8, objArr8, objArr8.length - size, 0, size);
                Object[] objArr9 = this.c;
                ArraysKt.a(objArr9, objArr9, 0, size, c2);
            }
        } else if (i5 >= 0) {
            Object[] objArr10 = this.c;
            ArraysKt.a(objArr10, objArr10, i5, i4, c2);
        } else {
            Object[] objArr11 = this.c;
            i5 += objArr11.length;
            int length2 = objArr11.length - i5;
            if (length2 >= c2 - i4) {
                ArraysKt.a(objArr11, objArr11, i5, i4, c2);
            } else {
                ArraysKt.a(objArr11, objArr11, i5, i4, i4 + length2);
                Object[] objArr12 = this.c;
                ArraysKt.a(objArr12, objArr12, 0, this.b + length2, c2);
            }
        }
        this.b = i5;
        a(d(c2 - size), elements);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        a(size() + elements.size());
        a(c(this.b + size()), elements);
        return true;
    }

    public final E b() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int c = c(this.b + CollectionsKt.b((List) this));
        Object[] objArr = this.c;
        E e2 = (E) objArr[c];
        objArr[c] = null;
        this.d = size() - 1;
        return e2;
    }

    public final void b(E e2) {
        a(size() + 1);
        this.c[c(this.b + size())] = e2;
        this.d = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int c = c(this.b + size());
        int i = this.b;
        if (i < c) {
            ArraysKt.a(this.c, (Object) null, i, c);
        } else if (!isEmpty()) {
            Object[] objArr = this.c;
            ArraysKt.a(objArr, (Object) null, this.b, objArr.length);
            ArraysKt.a(this.c, (Object) null, 0, c);
        }
        this.b = 0;
        this.d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.a(i, size());
        return (E) this.c[c(this.b + i)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.d;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int c = c(this.b + size());
        int i2 = this.b;
        if (i2 < c) {
            while (i2 < c) {
                if (Intrinsics.a(obj, this.c[i2])) {
                    i = this.b;
                } else {
                    i2++;
                }
            }
            return -1;
        } else if (i2 < c) {
            return -1;
        } else {
            int length = this.c.length;
            while (true) {
                if (i2 >= length) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= c) {
                            return -1;
                        }
                        if (Intrinsics.a(obj, this.c[i4])) {
                            i2 = i4 + this.c.length;
                            i = this.b;
                            break;
                        }
                        i3 = i4 + 1;
                    }
                } else if (Intrinsics.a(obj, this.c[i2])) {
                    i = this.b;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int d;
        int i;
        int c = c(this.b + size());
        int i2 = this.b;
        if (i2 < c) {
            d = c - 1;
            if (i2 > d) {
                return -1;
            }
            while (!Intrinsics.a(obj, this.c[d])) {
                if (d == i2) {
                    return -1;
                }
                d--;
            }
            i = this.b;
        } else if (i2 <= c) {
            return -1;
        } else {
            while (true) {
                c--;
                if (-1 >= c) {
                    d = ArraysKt.d(this.c);
                    int i3 = this.b;
                    if (i3 > d) {
                        return -1;
                    }
                    while (!Intrinsics.a(obj, this.c[d])) {
                        if (d == i3) {
                            return -1;
                        }
                        d--;
                    }
                    i = this.b;
                } else if (Intrinsics.a(obj, this.c[c])) {
                    d = c + this.c.length;
                    i = this.b;
                    break;
                }
            }
        }
        return d - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        int c;
        Intrinsics.e(elements, "elements");
        boolean z = false;
        boolean z2 = false;
        if (!isEmpty()) {
            if (this.c.length == 0) {
                return false;
            }
            int c2 = c(this.b + size());
            int i = this.b;
            if (i >= c2) {
                int length = this.c.length;
                int i2 = i;
                z2 = false;
                while (i < length) {
                    Object[] objArr = this.c;
                    Object obj = objArr[i];
                    objArr[i] = null;
                    if (!elements.contains(obj)) {
                        this.c[i2] = obj;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                c = c(i2);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= c2) {
                        break;
                    }
                    Object[] objArr2 = this.c;
                    Object obj2 = objArr2[i4];
                    objArr2[i4] = null;
                    if (!elements.contains(obj2)) {
                        this.c[c] = obj2;
                        c = e(c);
                    } else {
                        z2 = true;
                    }
                    i3 = i4 + 1;
                }
            } else {
                int i5 = i;
                while (i < c2) {
                    Object obj3 = this.c[i];
                    if (!elements.contains(obj3)) {
                        this.c[i5] = obj3;
                        i5++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                ArraysKt.a(this.c, (Object) null, i5, c2);
                c = i5;
            }
            z = z2;
            if (z2) {
                this.d = d(c - this.b);
                z = z2;
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i) {
        AbstractList.Companion.a(i, size());
        ArrayDeque<E> arrayDeque = this;
        if (i == CollectionsKt.b((List) arrayDeque)) {
            return b();
        }
        if (i == 0) {
            return a();
        }
        int c = c(this.b + i);
        E e2 = (E) this.c[c];
        if (i < (size() >> 1)) {
            int i2 = this.b;
            if (c >= i2) {
                Object[] objArr = this.c;
                ArraysKt.a(objArr, objArr, i2 + 1, i2, c);
            } else {
                Object[] objArr2 = this.c;
                ArraysKt.a(objArr2, objArr2, 1, 0, c);
                Object[] objArr3 = this.c;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i3 = this.b;
                ArraysKt.a(objArr3, objArr3, i3 + 1, i3, objArr3.length - 1);
            }
            Object[] objArr4 = this.c;
            int i4 = this.b;
            objArr4[i4] = null;
            this.b = e(i4);
        } else {
            int c2 = c(this.b + CollectionsKt.b((List) arrayDeque));
            if (c <= c2) {
                Object[] objArr5 = this.c;
                ArraysKt.a(objArr5, objArr5, c, c + 1, c2 + 1);
            } else {
                Object[] objArr6 = this.c;
                ArraysKt.a(objArr6, objArr6, c, c + 1, objArr6.length);
                Object[] objArr7 = this.c;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt.a(objArr7, objArr7, 0, 1, c2 + 1);
            }
            this.c[c2] = null;
        }
        this.d = size() - 1;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        int c;
        Intrinsics.e(elements, "elements");
        boolean z = false;
        boolean z2 = false;
        if (!isEmpty()) {
            if (this.c.length == 0) {
                return false;
            }
            int c2 = c(this.b + size());
            int i = this.b;
            if (i >= c2) {
                int length = this.c.length;
                int i2 = i;
                z2 = false;
                while (i < length) {
                    Object[] objArr = this.c;
                    Object obj = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj)) {
                        this.c[i2] = obj;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                c = c(i2);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= c2) {
                        break;
                    }
                    Object[] objArr2 = this.c;
                    Object obj2 = objArr2[i4];
                    objArr2[i4] = null;
                    if (elements.contains(obj2)) {
                        this.c[c] = obj2;
                        c = e(c);
                    } else {
                        z2 = true;
                    }
                    i3 = i4 + 1;
                }
            } else {
                int i5 = i;
                while (i < c2) {
                    Object obj3 = this.c[i];
                    if (elements.contains(obj3)) {
                        this.c[i5] = obj3;
                        i5++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                ArraysKt.a(this.c, (Object) null, i5, c2);
                c = i5;
            }
            z = z2;
            if (z2) {
                this.d = d(c - this.b);
                z = z2;
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i, E e2) {
        AbstractList.Companion.a(i, size());
        int c = c(this.b + i);
        Object[] objArr = this.c;
        E e3 = (E) objArr[c];
        objArr[c] = e2;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.e(array, "array");
        if (array.length < size()) {
            array = ArraysKt.a(array, size());
        }
        int c = c(this.b + size());
        int i = this.b;
        if (i < c) {
            ArraysKt.a(this.c, array, 0, i, c, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.c;
            ArraysKt.a(objArr, array, 0, this.b, objArr.length);
            Object[] objArr2 = this.c;
            ArraysKt.a(objArr2, array, objArr2.length - this.b, 0, c);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }
}
