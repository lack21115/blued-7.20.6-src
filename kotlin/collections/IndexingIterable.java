package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/IndexingIterable.class */
public final class IndexingIterable<T> implements Iterable<IndexedValue<? extends T>>, KMappedMarker {
    private final Function0<Iterator<T>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public IndexingIterable(Function0<? extends Iterator<? extends T>> iteratorFactory) {
        Intrinsics.e(iteratorFactory, "iteratorFactory");
        this.a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator<IndexedValue<T>> iterator() {
        return new IndexingIterator(this.a.invoke());
    }
}
