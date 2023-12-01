package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/TakeSequence$iterator$1.class */
public final class TakeSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    private int a;
    private final Iterator<T> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TakeSequence$iterator$1(TakeSequence<T> takeSequence) {
        int i;
        Sequence sequence;
        i = ((TakeSequence) takeSequence).b;
        this.a = i;
        sequence = ((TakeSequence) takeSequence).a;
        this.b = sequence.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a > 0 && this.b.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.a;
        if (i != 0) {
            this.a = i - 1;
            return this.b.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
