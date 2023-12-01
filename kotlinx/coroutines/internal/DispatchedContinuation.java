package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/DispatchedContinuation.class */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements Continuation<T>, CoroutineStackFrame {
    private static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;
    public final CoroutineDispatcher b;
    public final Continuation<T> c;
    public Object d;
    public final Object e;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.b = coroutineDispatcher;
        this.c = continuation;
        this.d = DispatchedContinuationKt.a();
        this.e = ThreadContextKt.a(getContext());
        this._reusableCancellableContinuation = null;
    }

    public final Throwable a(CancellableContinuation<?> cancellableContinuation) {
        do {
            Object obj = this._reusableCancellableContinuation;
            if (obj != DispatchedContinuationKt.a) {
                if (obj instanceof Throwable) {
                    if (h.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(Intrinsics.a("Inconsistent state ", obj).toString());
            }
        } while (!h.compareAndSet(this, DispatchedContinuationKt.a, cancellableContinuation));
        return null;
    }

    public final CancellableContinuationImpl<?> a() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void a(Object obj, Throwable th) {
        if (obj instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) obj).b.invoke(th);
        }
    }

    public final void a(CoroutineContext coroutineContext, T t) {
        this.d = t;
        this.a = 1;
        this.b.dispatchYield(coroutineContext, this);
    }

    public final boolean a(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (Intrinsics.a(obj, DispatchedContinuationKt.a)) {
                if (h.compareAndSet(this, DispatchedContinuationKt.a, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (h.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final boolean a(CancellableContinuationImpl<?> cancellableContinuationImpl) {
        Object obj = this._reusableCancellableContinuation;
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj instanceof CancellableContinuationImpl) {
            if (obj == cancellableContinuationImpl) {
                z = true;
            }
            return z;
        }
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Continuation<T> b() {
        return this;
    }

    public final void c() {
        do {
        } while (this._reusableCancellableContinuation == DispatchedContinuationKt.a);
    }

    public final void d() {
        c();
        CancellableContinuationImpl<?> a = a();
        if (a == null) {
            return;
        }
        a.i();
    }

    public final CancellableContinuationImpl<T> e() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = DispatchedContinuationKt.a;
                return null;
            } else if (obj instanceof CancellableContinuationImpl) {
                if (h.compareAndSet(this, obj, DispatchedContinuationKt.a)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != DispatchedContinuationKt.a && !(obj instanceof Throwable)) {
                throw new IllegalStateException(Intrinsics.a("Inconsistent state ", obj).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object g() {
        Object obj = this.d;
        if (DebugKt.a()) {
            if (!(obj != DispatchedContinuationKt.a())) {
                throw new AssertionError();
            }
        }
        this.d = DispatchedContinuationKt.a();
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.c;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.c.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context = this.c.getContext();
        Object a = CompletionStateKt.a(obj, null, 1, null);
        if (this.b.isDispatchNeeded(context)) {
            this.d = a;
            this.a = 0;
            this.b.dispatch(context, this);
            return;
        }
        DebugKt.a();
        EventLoop a2 = ThreadLocalEventLoop.a.a();
        if (a2.f()) {
            this.d = a;
            this.a = 0;
            a2.a(this);
            return;
        }
        DispatchedContinuation<T> dispatchedContinuation = this;
        a2.a(true);
        try {
            CoroutineContext context2 = getContext();
            Object a3 = ThreadContextKt.a(context2, this.e);
            this.c.resumeWith(obj);
            Unit unit = Unit.a;
            ThreadContextKt.b(context2, a3);
            do {
            } while (a2.e());
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.b + ", " + DebugStringsKt.a((Continuation<?>) this.c) + ']';
    }
}
