package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/jvm/internal/RunSuspend.class */
final class RunSuspend implements Continuation<Unit> {

    /* renamed from: a  reason: collision with root package name */
    private Result<Unit> f42475a;

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f42457a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        synchronized (this) {
            this.f42475a = Result.g(obj);
            notifyAll();
            Unit unit = Unit.f42314a;
        }
    }

    public final void setResult(Result<Unit> result) {
        this.f42475a = result;
    }
}
