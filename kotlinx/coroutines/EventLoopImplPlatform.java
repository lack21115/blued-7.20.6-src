package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlinx.coroutines.EventLoopImplBase;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/EventLoopImplPlatform.class */
public abstract class EventLoopImplPlatform extends EventLoop {
    protected abstract Thread a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(long j, EventLoopImplBase.DelayedTask delayedTask) {
        if (DebugKt.a()) {
            if (!(this != DefaultExecutor.b)) {
                throw new AssertionError();
            }
        }
        DefaultExecutor.b.a(j, delayedTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        Thread a2 = a();
        if (Thread.currentThread() != a2) {
            AbstractTimeSource a3 = AbstractTimeSourceKt.a();
            if (a3 == null) {
                LockSupport.unpark(a2);
            } else {
                a3.a(a2);
            }
        }
    }
}
