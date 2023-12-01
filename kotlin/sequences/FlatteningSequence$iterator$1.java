package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/FlatteningSequence$iterator$1.class */
public final class FlatteningSequence$iterator$1<E> implements Iterator<E>, KMappedMarker {
    final /* synthetic */ FlatteningSequence<T, R, E> a;
    private final Iterator<T> b;
    private Iterator<? extends E> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlatteningSequence$iterator$1(FlatteningSequence<T, R, E> flatteningSequence) {
        Sequence sequence;
        this.a = flatteningSequence;
        sequence = ((FlatteningSequence) flatteningSequence).a;
        this.b = sequence.iterator();
    }

    private final boolean a() {
        Function1 function1;
        Function1 function12;
        Iterator<? extends E> it = this.c;
        if ((it == null || it.hasNext()) ? false : true) {
            this.c = null;
        }
        while (this.c == null) {
            if (!this.b.hasNext()) {
                return false;
            }
            Object next = this.b.next();
            function1 = ((FlatteningSequence) this.a).c;
            function12 = ((FlatteningSequence) this.a).b;
            Iterator<? extends E> it2 = (Iterator) function1.invoke(function12.invoke(next));
            if (it2.hasNext()) {
                this.c = it2;
                return true;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return a();
    }

    @Override // java.util.Iterator
    public E next() {
        if (a()) {
            Iterator<? extends E> it = this.c;
            Intrinsics.a(it);
            return it.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
