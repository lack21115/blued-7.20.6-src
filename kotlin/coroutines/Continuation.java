package kotlin.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/Continuation.class */
public interface Continuation<T> {
    CoroutineContext getContext();

    void resumeWith(Object obj);
}
