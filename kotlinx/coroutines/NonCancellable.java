package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/NonCancellable.class */
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {
    public static final NonCancellable b = new NonCancellable();

    private NonCancellable() {
        super(Job.C_);
    }

    @Override // kotlinx.coroutines.Job
    public ChildHandle a(ChildJob childJob) {
        return NonDisposableHandle.f42847a;
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle a(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        return NonDisposableHandle.f42847a;
    }

    @Override // kotlinx.coroutines.Job
    public void a(CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.Job
    public boolean a() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle a_(Function1<? super Throwable, Unit> function1) {
        return NonDisposableHandle.f42847a;
    }

    @Override // kotlinx.coroutines.Job
    public boolean ay_() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public Object b(Continuation<? super Unit> continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public boolean g() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public boolean h() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public CancellationException i() {
        throw new IllegalStateException("This job is always active");
    }

    public String toString() {
        return "NonCancellable";
    }
}
