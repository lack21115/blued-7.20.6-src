package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/DropWhileSequence$iterator$1.class */
public final class DropWhileSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    final /* synthetic */ DropWhileSequence<T> a;
    private final Iterator<T> b;
    private int c;
    private T d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropWhileSequence$iterator$1(DropWhileSequence<T> dropWhileSequence) {
        Sequence sequence;
        this.a = dropWhileSequence;
        sequence = ((DropWhileSequence) dropWhileSequence).a;
        this.b = sequence.iterator();
        this.c = -1;
    }

    private final void a() {
        Function1 function1;
        while (this.b.hasNext()) {
            T next = this.b.next();
            function1 = ((DropWhileSequence) this.a).b;
            if (!((Boolean) function1.invoke(next)).booleanValue()) {
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
        boolean z = true;
        if (this.c != 1) {
            if (this.b.hasNext()) {
                return true;
            }
            z = false;
        }
        return z;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.c == -1) {
            a();
        }
        if (this.c == 1) {
            T t = this.d;
            this.d = null;
            this.c = 0;
            return t;
        }
        return this.b.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
