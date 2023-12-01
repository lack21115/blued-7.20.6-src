package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/TakeWhileSequence$iterator$1.class */
public final class TakeWhileSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    final /* synthetic */ TakeWhileSequence<T> a;
    private final Iterator<T> b;
    private int c;
    private T d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TakeWhileSequence$iterator$1(TakeWhileSequence<T> takeWhileSequence) {
        Sequence sequence;
        this.a = takeWhileSequence;
        sequence = ((TakeWhileSequence) takeWhileSequence).a;
        this.b = sequence.iterator();
        this.c = -1;
    }

    private final void a() {
        Function1 function1;
        if (this.b.hasNext()) {
            T next = this.b.next();
            function1 = ((TakeWhileSequence) this.a).b;
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                this.c = 1;
                this.d = next;
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
