package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DispatchedCoroutine.class */
public final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public DispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
        this._decision = 0;
    }

    private final boolean q() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!b.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean s() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!b.compareAndSet(this, 0, 2));
        return true;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    public void c(Object obj) {
        if (s()) {
            return;
        }
        DispatchedContinuationKt.a(IntrinsicsKt.a(this.f43559c), CompletionStateKt.a(obj, this.f43559c), null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public void d(Object obj) {
        c(obj);
    }

    public final Object f() {
        if (q()) {
            return IntrinsicsKt.a();
        }
        Object b2 = JobSupportKt.b(l());
        if (b2 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) b2).f42791a;
        }
        return b2;
    }
}
