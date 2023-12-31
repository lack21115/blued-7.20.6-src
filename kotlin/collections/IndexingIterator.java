package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/IndexingIterator.class */
public final class IndexingIterator<T> implements Iterator<IndexedValue<? extends T>>, KMappedMarker {
    private final Iterator<T> a;
    private int b;

    /* JADX WARN: Multi-variable type inference failed */
    public IndexingIterator(Iterator<? extends T> iterator) {
        Intrinsics.e(iterator, "iterator");
        this.a = iterator;
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public final IndexedValue<T> next() {
        int i = this.b;
        this.b = i + 1;
        if (i < 0) {
            CollectionsKt.c();
        }
        return new IndexedValue<>(i, this.a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
