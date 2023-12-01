package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/Mutex.class */
public interface Mutex {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/Mutex$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    Object a(Object obj, Continuation<? super Unit> continuation);

    void a(Object obj);
}
