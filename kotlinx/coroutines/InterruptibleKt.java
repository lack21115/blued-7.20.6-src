package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/InterruptibleKt.class */
public final class InterruptibleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T b(CoroutineContext coroutineContext, Function0<? extends T> function0) {
        try {
            ThreadState threadState = new ThreadState(JobKt.b(coroutineContext));
            threadState.a();
            T invoke = function0.invoke();
            threadState.b();
            return invoke;
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }
}
