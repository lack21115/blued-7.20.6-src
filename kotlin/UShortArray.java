package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.UShortIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/UShortArray.class */
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    private final short[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/UShortArray$Iterator.class */
    public static final class Iterator extends UShortIterator {
        private final short[] a;
        private int b;

        public Iterator(short[] array) {
            Intrinsics.e(array, "array");
            this.a = array;
        }

        @Override // kotlin.collections.UShortIterator
        public short a() {
            int i = this.b;
            short[] sArr = this.a;
            if (i < sArr.length) {
                this.b = i + 1;
                return UShort.c(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }
    }

    public static int a(short[] sArr) {
        return sArr.length;
    }

    public static final short a(short[] sArr, int i) {
        return UShort.c(sArr[i]);
    }

    public static boolean a(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.a(sArr, ((UShortArray) obj).b());
    }

    public static boolean a(short[] sArr, Collection<UShort> elements) {
        Intrinsics.e(elements, "elements");
        Collection<UShort> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (UShort uShort : collection) {
            if (!((uShort instanceof UShort) && ArraysKt.a(sArr, uShort.a()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(short[] sArr, short s) {
        return ArraysKt.a(sArr, s);
    }

    public static java.util.Iterator<UShort> b(short[] sArr) {
        return new Iterator(sArr);
    }

    public static boolean c(short[] sArr) {
        return sArr.length == 0;
    }

    public static String d(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public static int e(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @Override // java.util.Collection
    /* renamed from: a */
    public int size() {
        return a(this.a);
    }

    public boolean a(short s) {
        return a(this.a, s);
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ short[] b() {
        return this.a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return a(((UShort) obj).a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        return a(this.a, (Collection<UShort>) elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return a(this.a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return e(this.a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return c(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UShort> iterator() {
        return b(this.a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.e(array, "array");
        return (T[]) CollectionToArray.a(this, array);
    }

    public String toString() {
        return d(this.a);
    }
}
