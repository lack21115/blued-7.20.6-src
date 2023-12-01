package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/FilteringSequence$iterator$1.class */
public final class FilteringSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    final /* synthetic */ FilteringSequence<T> a;
    private final Iterator<T> b;
    private int c;
    private T d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilteringSequence$iterator$1(FilteringSequence<T> filteringSequence) {
        Sequence sequence;
        this.a = filteringSequence;
        sequence = ((FilteringSequence) filteringSequence).a;
        this.b = sequence.iterator();
        this.c = -1;
    }

    private final void a() {
        Function1 function1;
        boolean z;
        while (this.b.hasNext()) {
            T next = this.b.next();
            function1 = ((FilteringSequence) this.a).c;
            boolean booleanValue = ((Boolean) function1.invoke(next)).booleanValue();
            z = ((FilteringSequence) this.a).b;
            if (booleanValue == z) {
                this.d = next;
                this.c = 1;
                return;
            }
        }
        this.c = 0;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.c == -1) {
            a();
        }
        return this.c == 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.c == -1) {
            a();
        }
        if (this.c != 0) {
            T t = this.d;
            this.d = null;
            this.c = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
