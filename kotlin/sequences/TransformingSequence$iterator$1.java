package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/TransformingSequence$iterator$1.class */
public final class TransformingSequence$iterator$1<R> implements Iterator<R>, KMappedMarker {
    final /* synthetic */ TransformingSequence<T, R> a;
    private final Iterator<T> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformingSequence$iterator$1(TransformingSequence<T, R> transformingSequence) {
        Sequence sequence;
        this.a = transformingSequence;
        sequence = ((TransformingSequence) transformingSequence).a;
        this.b = sequence.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public R next() {
        Function1 function1;
        function1 = ((TransformingSequence) this.a).b;
        return (R) function1.invoke(this.b.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
