package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequenceBuilderIterator.class */
final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    private int f42641a;
    private T b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<? extends T> f42642c;
    private Continuation<? super Unit> d;

    private final T a() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    private final Throwable b() {
        int i = this.f42641a;
        if (i != 4) {
            if (i != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f42641a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    @Override // kotlin.sequences.SequenceScope
    public Object a(T t, Continuation<? super Unit> continuation) {
        this.b = t;
        this.f42641a = 3;
        this.d = continuation;
        Object a2 = IntrinsicsKt.a();
        if (a2 == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }

    @Override // kotlin.sequences.SequenceScope
    public Object a(Iterator<? extends T> it, Continuation<? super Unit> continuation) {
        if (it.hasNext()) {
            this.f42642c = it;
            this.f42641a = 2;
            this.d = continuation;
            Object a2 = IntrinsicsKt.a();
            if (a2 == IntrinsicsKt.a()) {
                DebugProbesKt.c(continuation);
            }
            return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
        }
        return Unit.f42314a;
    }

    public final void a(Continuation<? super Unit> continuation) {
        this.d = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f42457a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i = this.f42641a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator<? extends T> it = this.f42642c;
                Intrinsics.a(it);
                if (it.hasNext()) {
                    this.f42641a = 2;
                    return true;
                }
                this.f42642c = null;
            }
            this.f42641a = 5;
            Continuation<? super Unit> continuation = this.d;
            Intrinsics.a(continuation);
            this.d = null;
            Result.Companion companion = Result.f42293a;
            continuation.resumeWith(Result.f(Unit.f42314a));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.f42641a;
        if (i == 0 || i == 1) {
            return a();
        }
        if (i == 2) {
            this.f42641a = 1;
            Iterator<? extends T> it = this.f42642c;
            Intrinsics.a(it);
            return it.next();
        } else if (i == 3) {
            this.f42641a = 0;
            T t = this.b;
            this.b = null;
            return t;
        } else {
            throw b();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        ResultKt.a(obj);
        this.f42641a = 4;
    }
}
