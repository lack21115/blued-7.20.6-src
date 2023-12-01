package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ResumeUndispatchedRunnable.class */
final class ResumeUndispatchedRunnable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineDispatcher f42851a;
    private final CancellableContinuation<Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeUndispatchedRunnable(CoroutineDispatcher coroutineDispatcher, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f42851a = coroutineDispatcher;
        this.b = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f42851a, (CoroutineDispatcher) Unit.f42314a);
    }
}
