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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FlatteningSequence<T, R, E> f42630a;
    private final Iterator<T> b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<? extends E> f42631c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlatteningSequence$iterator$1(FlatteningSequence<T, R, E> flatteningSequence) {
        Sequence sequence;
        this.f42630a = flatteningSequence;
        sequence = ((FlatteningSequence) flatteningSequence).f42628a;
        this.b = sequence.iterator();
    }

    private final boolean a() {
        Function1 function1;
        Function1 function12;
        Iterator<? extends E> it = this.f42631c;
        if ((it == null || it.hasNext()) ? false : true) {
            this.f42631c = null;
        }
        while (this.f42631c == null) {
            if (!this.b.hasNext()) {
                return false;
            }
            Object next = this.b.next();
            function1 = ((FlatteningSequence) this.f42630a).f42629c;
            function12 = ((FlatteningSequence) this.f42630a).b;
            Iterator<? extends E> it2 = (Iterator) function1.invoke(function12.invoke(next));
            if (it2.hasNext()) {
                this.f42631c = it2;
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
            Iterator<? extends E> it = this.f42631c;
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
