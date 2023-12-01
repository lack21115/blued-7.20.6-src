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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TransformingIndexedSequence<T, R> f42705a;
    private final Iterator<T> b;

    /* renamed from: c  reason: collision with root package name */
    private int f42706c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformingIndexedSequence$iterator$1(TransformingIndexedSequence<T, R> transformingIndexedSequence) {
        Sequence sequence;
        this.f42705a = transformingIndexedSequence;
        sequence = ((TransformingIndexedSequence) transformingIndexedSequence).f42704a;
        this.b = sequence.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public R next() {
        Function2 function2;
        function2 = ((TransformingIndexedSequence) this.f42705a).b;
        int i = this.f42706c;
        this.f42706c = i + 1;
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
