package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/Semaphore.class */
public interface Semaphore {
    Object a(Continuation<? super Unit> continuation);

    void a();
}
