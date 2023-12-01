package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [V] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/MergingSequence$iterator$1.class */
public final class MergingSequence$iterator$1<V> implements Iterator<V>, KMappedMarker {
    final /* synthetic */ MergingSequence<T1, T2, V> a;
    private final Iterator<T1> b;
    private final Iterator<T2> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MergingSequence$iterator$1(MergingSequence<T1, T2, V> mergingSequence) {
        Sequence sequence;
        Sequence sequence2;
        this.a = mergingSequence;
        sequence = ((MergingSequence) mergingSequence).a;
        this.b = sequence.iterator();
        sequence2 = ((MergingSequence) mergingSequence).b;
        this.c = sequence2.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b.hasNext() && this.c.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        Function2 function2;
        function2 = ((MergingSequence) this.a).c;
        return (V) function2.invoke(this.b.next(), this.c.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
