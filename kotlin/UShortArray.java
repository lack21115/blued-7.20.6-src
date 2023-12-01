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

    /* renamed from: a  reason: collision with root package name */
    private final short[] f42312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/UShortArray$Iterator.class */
    public static final class Iterator extends UShortIterator {

        /* renamed from: a  reason: collision with root package name */
        private final short[] f42313a;
        private int b;

        public Iterator(short[] array) {
            Intrinsics.e(array, "array");
            this.f42313a = array;
        }

        @Override // kotlin.collections.UShortIterator
        public short a() {
            int i = this.b;
            short[] sArr = this.f42313a;
            if (i < sArr.length) {
                this.b = i + 1;
                return UShort.c(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.f42313a.length;
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

    @Override // java.util.Collection, java.util.List
    /* renamed from: a */
    public int size() {
        return a(this.f42312a);
    }

    public boolean a(short s) {
        return a(this.f42312a, s);
    }

    @Override // java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ short[] b() {
        return this.f42312a;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return a(((UShort) obj).a());
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        return a(this.f42312a, (Collection<UShort>) elements);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return a(this.f42312a, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return e(this.f42312a);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return c(this.f42312a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UShort> iterator() {
        return b(this.f42312a);
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
        return d(this.f42312a);
    }
}
