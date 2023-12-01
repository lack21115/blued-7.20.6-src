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
        super(coroutineContext.get(UndispatchedMarker.f42861a) == null ? coroutineContext.plus(UndispatchedMarker.f42861a) : coroutineContext, continuation);
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
        Object a2 = CompletionStateKt.a(obj, this.f43559c);
        Continuation<T> continuation = this.f43559c;
        CoroutineContext context = continuation.getContext();
        Object a3 = ThreadContextKt.a(context, null);
        UndispatchedCoroutine<?> a4 = a3 != ThreadContextKt.f43565a ? CoroutineContextKt.a(continuation, context, a3) : null;
        try {
            this.f43559c.resumeWith(a2);
            Unit unit = Unit.f42314a;
            if (a4 == null || a4.q()) {
                ThreadContextKt.b(context, a3);
            }
        } catch (Throwable th) {
            if (a4 == null || a4.q()) {
                ThreadContextKt.b(context, a3);
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
