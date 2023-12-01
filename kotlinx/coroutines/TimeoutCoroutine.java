package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/TimeoutCoroutine.class */
final class TimeoutCoroutine<U, T extends U> extends ScopeCoroutine<T> implements Runnable {
    public final long b;

    public TimeoutCoroutine(long j, Continuation<? super U> continuation) {
        super(continuation.getContext(), continuation);
        this.b = j;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    public String c() {
        return super.c() + "(timeMillis=" + this.b + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        d((Throwable) TimeoutKt.a(this.b, this));
    }
}
