package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/ListBuilder.class */
public final class ListBuilder<E> extends AbstractMutableList<E> implements Serializable, List<E>, RandomAccess, KMutableList {

    /* renamed from: a  reason: collision with root package name */
    private E[] f42401a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f42402c;
    private boolean d;
    private final ListBuilder<E> e;
    private final ListBuilder<E> f;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/ListBuilder$Itr.class */
    static final class Itr<E> implements ListIterator<E>, KMutableListIterator {

        /* renamed from: a  reason: collision with root package name */
        private final ListBuilder<E> f42403a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f42404c;

        public Itr(ListBuilder<E> list, int i) {
            Intrinsics.e(list, "list");
            this.f42403a = list;
            this.b = i;
            this.f42404c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            ListBuilder<E> listBuilder = this.f42403a;
            int i = this.b;
            this.b = i + 1;
            listBuilder.add(i, e);
            this.f42404c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < ((ListBuilder) this.f42403a).f42402c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.b < ((ListBuilder) this.f42403a).f42402c) {
                int i = this.b;
                this.b = i + 1;
                this.f42404c = i;
                return (E) ((ListBuilder) this.f42403a).f42401a[((ListBuilder) this.f42403a).b + this.f42404c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i = this.b;
            if (i > 0) {
                int i2 = i - 1;
                this.b = i2;
                this.f42404c = i2;
                return (E) ((ListBuilder) this.f42403a).f42401a[((ListBuilder) this.f42403a).b + this.f42404c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (!(this.f42404c != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f42403a.remove(this.f42404c);
            this.b = this.f42404c;
            this.f42404c = -1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            if (!(this.f42404c != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f42403a.set(this.f42404c, e);
        }
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(ListBuilderKt.a(i), 0, 0, false, null, null);
    }

    private ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.f42401a = eArr;
        this.b = i;
        this.f42402c = i2;
        this.d = z;
        this.e = listBuilder;
        this.f = listBuilder2;
    }

    private final int a(int i, int i2, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            int a2 = listBuilder.a(i, i2, collection, z);
            this.f42402c -= a2;
            return a2;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.f42401a[i5]) == z) {
                E[] eArr = this.f42401a;
                i3++;
                eArr[i4 + i] = eArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        E[] eArr2 = this.f42401a;
        ArraysKt.a(eArr2, eArr2, i + i4, i2 + i, this.f42402c);
        E[] eArr3 = this.f42401a;
        int i7 = this.f42402c;
        ListBuilderKt.a(eArr3, i7 - i6, i7);
        this.f42402c -= i6;
        return i6;
    }

    private final void a(int i) {
        if (this.e != null) {
            throw new IllegalStateException();
        }
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > this.f42401a.length) {
            this.f42401a = (E[]) ListBuilderKt.a(this.f42401a, ArrayDeque.f42334a.a(this.f42401a.length, i));
        }
    }

    private final void a(int i, int i2) {
        b(i2);
        E[] eArr = this.f42401a;
        ArraysKt.a(eArr, eArr, i + i2, i, this.b + this.f42402c);
        this.f42402c += i2;
    }

    private final void a(int i, E e) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder == null) {
            a(i, 1);
            this.f42401a[i] = e;
            return;
        }
        listBuilder.a(i, (int) e);
        this.f42401a = this.e.f42401a;
        this.f42402c++;
    }

    private final void a(int i, Collection<? extends E> collection, int i2) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            listBuilder.a(i, collection, i2);
            this.f42401a = this.e.f42401a;
            this.f42402c += i2;
            return;
        }
        a(i, i2);
        Iterator<? extends E> it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f42401a[i + i3] = it.next();
        }
    }

    private final boolean a(List<?> list) {
        boolean b;
        b = ListBuilderKt.b(this.f42401a, this.b, this.f42402c, list);
        return b;
    }

    private final void b() {
        if (c()) {
            throw new UnsupportedOperationException();
        }
    }

    private final void b(int i) {
        a(this.f42402c + i);
    }

    private final void b(int i, int i2) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            listBuilder.b(i, i2);
        } else {
            E[] eArr = this.f42401a;
            ArraysKt.a(eArr, eArr, i, i + i2, this.f42402c);
            E[] eArr2 = this.f42401a;
            int i3 = this.f42402c;
            ListBuilderKt.a(eArr2, i3 - i2, i3);
        }
        this.f42402c -= i2;
    }

    private final E c(int i) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            E c2 = listBuilder.c(i);
            this.f42402c--;
            return c2;
        }
        E[] eArr = this.f42401a;
        E e = eArr[i];
        ArraysKt.a(eArr, eArr, i, i + 1, this.b + this.f42402c);
        ListBuilderKt.b(this.f42401a, (this.b + this.f42402c) - 1);
        this.f42402c--;
        return e;
    }

    private final boolean c() {
        if (this.d) {
            return true;
        }
        ListBuilder<E> listBuilder = this.f;
        return listBuilder != null && listBuilder.d;
    }

    private final Object writeReplace() {
        if (c()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    public final List<E> a() {
        if (this.e == null) {
            b();
            this.d = true;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        b();
        AbstractList.Companion.b(i, this.f42402c);
        a(this.b + i, (int) e);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        b();
        a(this.b + this.f42402c, (int) e);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> elements) {
        Intrinsics.e(elements, "elements");
        b();
        AbstractList.Companion.b(i, this.f42402c);
        int size = elements.size();
        a(this.b + i, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.e(elements, "elements");
        b();
        int size = elements.size();
        a(this.b + this.f42402c, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        b();
        b(this.b, this.f42402c);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof List) && a((List) obj);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.a(i, this.f42402c);
        return this.f42401a[this.b + i];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.f42402c;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public int hashCode() {
        int e;
        e = ListBuilderKt.e(this.f42401a, this.b, this.f42402c);
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f42402c) {
                return -1;
            }
            if (Intrinsics.a(this.f42401a[this.b + i2], obj)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42402c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.f42402c;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return -1;
            }
            if (Intrinsics.a(this.f42401a[this.b + i2], obj)) {
                return i2;
            }
            i = i2;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        AbstractList.Companion.b(i, this.f42402c);
        return new Itr(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        b();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        b();
        boolean z = false;
        if (a(this.b, this.f42402c, elements, false) > 0) {
            z = true;
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i) {
        b();
        AbstractList.Companion.a(i, this.f42402c);
        return c(this.b + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        b();
        return a(this.b, this.f42402c, elements, true) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        b();
        AbstractList.Companion.a(i, this.f42402c);
        E[] eArr = this.f42401a;
        int i2 = this.b;
        E e2 = eArr[i2 + i];
        eArr[i2 + i] = e;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i, int i2) {
        AbstractList.Companion.a(i, i2, this.f42402c);
        E[] eArr = this.f42401a;
        int i3 = this.b;
        boolean z = this.d;
        ListBuilder<E> listBuilder = this.f;
        if (listBuilder == null) {
            listBuilder = this;
        }
        return new ListBuilder(eArr, i3 + i, i2 - i, z, this, listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        E[] eArr = this.f42401a;
        int i = this.b;
        return ArraysKt.a(eArr, i, this.f42402c + i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] destination) {
        Intrinsics.e(destination, "destination");
        int length = destination.length;
        int i = this.f42402c;
        if (length < i) {
            E[] eArr = this.f42401a;
            int i2 = this.b;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i2, i + i2, destination.getClass());
            Intrinsics.c(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.f42401a;
        int i3 = this.b;
        ArraysKt.a(eArr2, destination, 0, i3, i + i3);
        int length2 = destination.length;
        int i4 = this.f42402c;
        if (length2 > i4) {
            destination[i4] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String d;
        d = ListBuilderKt.d(this.f42401a, this.b, this.f42402c);
        return d;
    }
}
