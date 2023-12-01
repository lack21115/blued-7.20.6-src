package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/UndispatchedCoroutine.class */
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private CoroutineContext b;
    private Object d;

    public UndispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext.get(UndispatchedMarker.a) == null ? coroutineContext.plus(UndispatchedMarker.a) : coroutineContext, continuation);
    }

    public final void a(CoroutineContext coroutineContext, Object obj) {
        this.b = coroutineContext;
        this.d = obj;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    public void c(Object obj) {
        CoroutineContext coroutineContext = this.b;
        if (coroutineContext != null) {
            ThreadContextKt.b(coroutineContext, this.d);
            this.b = null;
            this.d = null;
        }
        Object a = CompletionStateKt.a(obj, this.c);
        Continuation<T> continuation = this.c;
        CoroutineContext context = continuation.getContext();
        Object a2 = ThreadContextKt.a(context, null);
        UndispatchedCoroutine<?> a3 = a2 != ThreadContextKt.a ? CoroutineContextKt.a(continuation, context, a2) : null;
        try {
            this.c.resumeWith(a);
            Unit unit = Unit.a;
            if (a3 == null || a3.q()) {
                ThreadContextKt.b(context, a2);
            }
        } catch (Throwable th) {
            if (a3 == null || a3.q()) {
                ThreadContextKt.b(context, a2);
            }
            throw th;
        }
    }

    public final boolean q() {
        if (this.b == null) {
            return false;
        }
        this.b = null;
        this.d = null;
        return true;
    }
}
