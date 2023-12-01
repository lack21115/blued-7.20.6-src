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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TakeWhileSequence<T> f42702a;
    private final Iterator<T> b;

    /* renamed from: c  reason: collision with root package name */
    private int f42703c;
    private T d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TakeWhileSequence$iterator$1(TakeWhileSequence<T> takeWhileSequence) {
        Sequence sequence;
        this.f42702a = takeWhileSequence;
        sequence = ((TakeWhileSequence) takeWhileSequence).f42701a;
        this.b = sequence.iterator();
        this.f42703c = -1;
    }

    private final void a() {
        Function1 function1;
        if (this.b.hasNext()) {
            T next = this.b.next();
            function1 = ((TakeWhileSequence) this.f42702a).b;
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                this.f42703c = 1;
                this.d = next;
                return;
            }
        }
        this.f42703c = 0;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f42703c == -1) {
            a();
        }
        return this.f42703c == 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f42703c == -1) {
            a();
        }
        if (this.f42703c != 0) {
            T t = this.d;
            this.d = null;
            this.f42703c = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
