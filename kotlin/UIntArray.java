package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/UIntArray.class */
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    private final int[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/UIntArray$Iterator.class */
    public static final class Iterator extends UIntIterator {
        private final int[] a;
        private int b;

        public Iterator(int[] array) {
            Intrinsics.e(array, "array");
            this.a = array;
        }

        @Override // kotlin.collections.UIntIterator
        public int a() {
            int i = this.b;
            int[] iArr = this.a;
            if (i < iArr.length) {
                this.b = i + 1;
                return UInt.c(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }
    }

    public static int a(int[] iArr) {
        return iArr.length;
    }

    public static final int a(int[] iArr, int i) {
        return UInt.c(iArr[i]);
    }

    public static boolean a(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.a(iArr, ((UIntArray) obj).b());
    }

    public static boolean a(int[] iArr, Collection<UInt> elements) {
        Intrinsics.e(elements, "elements");
        Collection<UInt> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (UInt uInt : collection) {
            if (!((uInt instanceof UInt) && ArraysKt.a(iArr, uInt.a()))) {
                return false;
            }
        }
        return true;
    }

    public static java.util.Iterator<UInt> b(int[] iArr) {
        return new Iterator(iArr);
    }

    public static boolean b(int[] iArr, int i) {
        return ArraysKt.a(iArr, i);
    }

    public static boolean c(int[] iArr) {
        return iArr.length == 0;
    }

    public static String d(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public static int e(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @Override // java.util.Collection
    /* renamed from: a */
    public int size() {
        return a(this.a);
    }

    public boolean a(int i) {
        return b(this.a, i);
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ int[] b() {
        return this.a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return a(((UInt) obj).a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        return a(this.a, (Collection<UInt>) elements);
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
    public java.util.Iterator<UInt> iterator() {
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
