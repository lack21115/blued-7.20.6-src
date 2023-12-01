package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/ULongArray.class */
public final class ULongArray implements Collection<ULong>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f42308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/ULongArray$Iterator.class */
    public static final class Iterator extends ULongIterator {

        /* renamed from: a  reason: collision with root package name */
        private final long[] f42309a;
        private int b;

        public Iterator(long[] array) {
            Intrinsics.e(array, "array");
            this.f42309a = array;
        }

        @Override // kotlin.collections.ULongIterator
        public long a() {
            int i = this.b;
            long[] jArr = this.f42309a;
            if (i < jArr.length) {
                this.b = i + 1;
                return ULong.c(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.f42309a.length;
        }
    }

    public static int a(long[] jArr) {
        return jArr.length;
    }

    public static final long a(long[] jArr, int i) {
        return ULong.c(jArr[i]);
    }

    public static boolean a(long[] jArr, long j) {
        return ArraysKt.a(jArr, j);
    }

    public static boolean a(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.a(jArr, ((ULongArray) obj).b());
    }

    public static boolean a(long[] jArr, Collection<ULong> elements) {
        Intrinsics.e(elements, "elements");
        Collection<ULong> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (ULong uLong : collection) {
            if (!((uLong instanceof ULong) && ArraysKt.a(jArr, uLong.a()))) {
                return false;
            }
        }
        return true;
    }

    public static java.util.Iterator<ULong> b(long[] jArr) {
        return new Iterator(jArr);
    }

    public static boolean c(long[] jArr) {
        return jArr.length == 0;
    }

    public static String d(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public static int e(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @Override // java.util.Collection, java.util.List
    /* renamed from: a */
    public int size() {
        return a(this.f42308a);
    }

    public boolean a(long j) {
        return a(this.f42308a, j);
    }

    @Override // java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ long[] b() {
        return this.f42308a;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return a(((ULong) obj).a());
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        return a(this.f42308a, (Collection<ULong>) elements);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return a(this.f42308a, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return e(this.f42308a);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return c(this.f42308a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<ULong> iterator() {
        return b(this.f42308a);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] array) {
        Intrinsics.e(array, "array");
        return (T[]) CollectionToArray.a(this, array);
    }

    public String toString() {
        return d(this.f42308a);
    }
}
