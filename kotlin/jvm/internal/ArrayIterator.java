package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/ArrayIterator.class */
final class ArrayIterator<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f42521a;
    private int b;

    public ArrayIterator(T[] array) {
        Intrinsics.e(array, "array");
        this.f42521a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f42521a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f42521a;
            int i = this.b;
            this.b = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
