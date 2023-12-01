package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/GeneratorSequence$iterator$1.class */
public final class GeneratorSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    final /* synthetic */ GeneratorSequence<T> a;
    private T b;
    private int c = -2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneratorSequence$iterator$1(GeneratorSequence<T> generatorSequence) {
        this.a = generatorSequence;
    }

    private final void a() {
        Function1 function1;
        Object invoke;
        Function0 function0;
        if (this.c == -2) {
            function0 = ((GeneratorSequence) this.a).a;
            invoke = function0.invoke();
        } else {
            function1 = ((GeneratorSequence) this.a).b;
            T t = this.b;
            Intrinsics.a(t);
            invoke = function1.invoke(t);
        }
        this.b = (T) invoke;
        this.c = invoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.c < 0) {
            a();
        }
        return this.c == 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.c < 0) {
            a();
        }
        if (this.c != 0) {
            T t = this.b;
            if (t != null) {
                this.c = -1;
                return t;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
