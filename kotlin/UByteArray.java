package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.UByteIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/UByteArray.class */
public final class UByteArray implements Collection<UByte>, KMappedMarker {
    private final byte[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/UByteArray$Iterator.class */
    public static final class Iterator extends UByteIterator {
        private final byte[] a;
        private int b;

        public Iterator(byte[] array) {
            Intrinsics.e(array, "array");
            this.a = array;
        }

        @Override // kotlin.collections.UByteIterator
        public byte a() {
            int i = this.b;
            byte[] bArr = this.a;
            if (i < bArr.length) {
                this.b = i + 1;
                return UByte.c(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }
    }

    public static final byte a(byte[] bArr, int i) {
        return UByte.c(bArr[i]);
    }

    public static int a(byte[] bArr) {
        return bArr.length;
    }

    public static boolean a(byte[] bArr, byte b) {
        return ArraysKt.a(bArr, b);
    }

    public static boolean a(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.a(bArr, ((UByteArray) obj).b());
    }

    public static boolean a(byte[] bArr, Collection<UByte> elements) {
        Intrinsics.e(elements, "elements");
        Collection<UByte> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (UByte uByte : collection) {
            if (!((uByte instanceof UByte) && ArraysKt.a(bArr, uByte.a()))) {
                return false;
            }
        }
        return true;
    }

    public static java.util.Iterator<UByte> b(byte[] bArr) {
        return new Iterator(bArr);
    }

    public static boolean c(byte[] bArr) {
        return bArr.length == 0;
    }

    public static String d(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public static int e(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @Override // java.util.Collection
    /* renamed from: a */
    public int size() {
        return a(this.a);
    }

    public boolean a(byte b) {
        return a(this.a, b);
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ byte[] b() {
        return this.a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return a(((UByte) obj).a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.e(elements, "elements");
        return a(this.a, (Collection<UByte>) elements);
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
    public java.util.Iterator<UByte> iterator() {
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
