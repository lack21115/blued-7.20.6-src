package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/TransformingIndexedSequence$iterator$1.class */
public final class TransformingIndexedSequence$iterator$1<R> implements Iterator<R>, KMappedMarker {
    final /* synthetic */ TransformingIndexedSequence<T, R> a;
    private final Iterator<T> b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformingIndexedSequence$iterator$1(TransformingIndexedSequence<T, R> transformingIndexedSequence) {
        Sequence sequence;
        this.a = transformingIndexedSequence;
        sequence = ((TransformingIndexedSequence) transformingIndexedSequence).a;
        this.b = sequence.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public R next() {
        Function2 function2;
        function2 = ((TransformingIndexedSequence) this.a).b;
        int i = this.c;
        this.c = i + 1;
        if (i < 0) {
            CollectionsKt.c();
        }
        return (R) function2.invoke(Integer.valueOf(i), this.b.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
