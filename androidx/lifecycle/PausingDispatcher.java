package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/PausingDispatcher.class */
public final class PausingDispatcher extends CoroutineDispatcher {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Intrinsics.e(coroutineContext, "context");
        Intrinsics.e(runnable, "block");
        this.dispatchQueue.dispatchAndEnqueue(coroutineContext, runnable);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        Intrinsics.e(coroutineContext, "context");
        if (Dispatchers.b().a().isDispatchNeeded(coroutineContext)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
