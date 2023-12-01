package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/BlockingCoroutine.class */
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    private final Thread b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public void d(Object obj) {
        if (Intrinsics.a(Thread.currentThread(), this.b)) {
            return;
        }
        Thread thread = this.b;
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 == null) {
            LockSupport.unpark(thread);
        } else {
            a2.a(thread);
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean d() {
        return true;
    }
}
