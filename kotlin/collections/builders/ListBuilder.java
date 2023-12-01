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
    private E[] a;
    private int b;
    private int c;
    private boolean d;
    private final ListBuilder<E> e;
    private final ListBuilder<E> f;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/ListBuilder$Itr.class */
    static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private final ListBuilder<E> a;
        private int b;
        private int c;

        public Itr(ListBuilder<E> list, int i) {
            Intrinsics.e(list, "list");
            this.a = list;
            this.b = i;
            this.c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            ListBuilder<E> listBuilder = this.a;
            int i = this.b;
            this.b = i + 1;
            listBuilder.add(i, e);
            this.c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < ((ListBuilder) this.a).c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.b < ((ListBuilder) this.a).c) {
                int i = this.b;
                this.b = i + 1;
                this.c = i;
                return (E) ((ListBuilder) this.a).a[((ListBuilder) this.a).b + this.c];
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
                this.c = i2;
                return (E) ((ListBuilder) this.a).a[((ListBuilder) this.a).b + this.c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (!(this.c != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.a.remove(this.c);
            this.b = this.c;
            this.c = -1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            if (!(this.c != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.a.set(this.c, e);
        }
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(ListBuilderKt.a(i), 0, 0, false, null, null);
    }

    private ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.a = eArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = listBuilder;
        this.f = listBuilder2;
    }

    private final int a(int i, int i2, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            int a = listBuilder.a(i, i2, collection, z);
            this.c -= a;
            return a;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.a[i5]) == z) {
                E[] eArr = this.a;
                i3++;
                eArr[i4 + i] = eArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        E[] eArr2 = this.a;
        ArraysKt.a(eArr2, eArr2, i + i4, i2 + i, this.c);
        E[] eArr3 = this.a;
        int i7 = this.c;
        ListBuilderKt.a(eArr3, i7 - i6, i7);
        this.c -= i6;
        return i6;
    }

    private final void a(int i) {
        if (this.e != null) {
            throw new IllegalStateException();
        }
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > this.a.length) {
            this.a = (E[]) ListBuilderKt.a(this.a, ArrayDeque.a.a(this.a.length, i));
        }
    }

    private final void a(int i, int i2) {
        b(i2);
        E[] eArr = this.a;
        ArraysKt.a(eArr, eArr, i + i2, i, this.b + this.c);
        this.c += i2;
    }

    private final void a(int i, E e) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder == null) {
            a(i, 1);
            this.a[i] = e;
            return;
        }
        listBuilder.a(i, (int) e);
        this.a = this.e.a;
        this.c++;
    }

    private final void a(int i, Collection<? extends E> collection, int i2) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            listBuilder.a(i, collection, i2);
            this.a = this.e.a;
            this.c += i2;
            return;
        }
        a(i, i2);
        Iterator<? extends E> it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.a[i + i3] = it.next();
        }
    }

    private final boolean a(List<?> list) {
        boolean b;
        b = ListBuilderKt.b(this.a, this.b, this.c, list);
        return b;
    }

    private final void b() {
        if (c()) {
            throw new UnsupportedOperationException();
        }
    }

    private final void b(int i) {
        a(this.c + i);
    }

    private final void b(int i, int i2) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            listBuilder.b(i, i2);
        } else {
            E[] eArr = this.a;
            ArraysKt.a(eArr, eArr, i, i + i2, this.c);
            E[] eArr2 = this.a;
            int i3 = this.c;
            ListBuilderKt.a(eArr2, i3 - i2, i3);
        }
        this.c -= i2;
    }

    private final E c(int i) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            E c = listBuilder.c(i);
            this.c--;
            return c;
        }
        E[] eArr = this.a;
        E e = eArr[i];
        ArraysKt.a(eArr, eArr, i, i + 1, this.b + this.c);
        ListBuilderKt.b(this.a, (this.b + this.c) - 1);
        this.c--;
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
        AbstractList.Companion.b(i, this.c);
        a(this.b + i, (int) e);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        b();
        a(this.b + this.c, (int) e);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> elements) {
        Intrinsics.e(elements, "elements");
        b();
        AbstractList.Companion.b(i, this.c);
        int size = elements.size();
        a(this.b + i, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.e(elements, "elements");
        b();
        int size = elements.size();
        a(this.b + this.c, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        b();
        b(this.b, this.c);
    }

    @Override // java.util.AbstractList, java.util.Collection
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof List) && a((List) obj);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.a(i, this.c);
        return this.a[this.b + i];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.Collection
    public int hashCode() {
        int e;
        e = ListBuilderKt.e(this.a, this.b, this.c);
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c) {
                return -1;
            }
            if (Intrinsics.a(this.a[this.b + i2], obj)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.c;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return -1;
            }
            if (Intrinsics.a(this.a[this.b + i2], obj)) {
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
        AbstractList.Companion.b(i, this.c);
        return new Itr(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        b();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        b();
        boolean z = false;
        if (a(this.b, this.c, elements, false) > 0) {
            z = true;
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i) {
        b();
        AbstractList.Companion.a(i, this.c);
        return c(this.b + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        b();
        return a(this.b, this.c, elements, true) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        b();
        AbstractList.Companion.a(i, this.c);
        E[] eArr = this.a;
        int i2 = this.b;
        E e2 = eArr[i2 + i];
        eArr[i2 + i] = e;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i, int i2) {
        AbstractList.Companion.a(i, i2, this.c);
        E[] eArr = this.a;
        int i3 = this.b;
        boolean z = this.d;
        ListBuilder<E> listBuilder = this.f;
        if (listBuilder == null) {
            listBuilder = this;
        }
        return new ListBuilder(eArr, i3 + i, i2 - i, z, this, listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        E[] eArr = this.a;
        int i = this.b;
        return ArraysKt.a(eArr, i, this.c + i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] destination) {
        Intrinsics.e(destination, "destination");
        int length = destination.length;
        int i = this.c;
        if (length < i) {
            E[] eArr = this.a;
            int i2 = this.b;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i2, i + i2, destination.getClass());
            Intrinsics.c(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.a;
        int i3 = this.b;
        ArraysKt.a(eArr2, destination, 0, i3, i + i3);
        int length2 = destination.length;
        int i4 = this.c;
        if (length2 > i4) {
            destination[i4] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String d;
        d = ListBuilderKt.d(this.a, this.b, this.c);
        return d;
    }
}
