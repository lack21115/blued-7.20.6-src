package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/IndexingSequence$iterator$1.class */
public final class IndexingSequence$iterator$1<T> implements Iterator<IndexedValue<? extends T>>, KMappedMarker {
    private final Iterator<T> a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IndexingSequence$iterator$1(IndexingSequence<T> indexingSequence) {
        Sequence sequence;
        sequence = ((IndexingSequence) indexingSequence).a;
        this.a = sequence.iterator();
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public IndexedValue<T> next() {
        int i = this.b;
        this.b = i + 1;
        if (i < 0) {
            CollectionsKt.c();
        }
        return new IndexedValue<>(i, this.a.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
