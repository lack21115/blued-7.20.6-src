package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/DropSequence$iterator$1.class */
public final class DropSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    private final Iterator<T> f42619a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropSequence$iterator$1(DropSequence<T> dropSequence) {
        Sequence sequence;
        int i;
        sequence = ((DropSequence) dropSequence).f42618a;
        this.f42619a = sequence.iterator();
        i = ((DropSequence) dropSequence).b;
        this.b = i;
    }

    private final void a() {
        while (this.b > 0 && this.f42619a.hasNext()) {
            this.f42619a.next();
            this.b--;
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        a();
        return this.f42619a.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        a();
        return this.f42619a.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
