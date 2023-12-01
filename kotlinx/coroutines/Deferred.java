package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Deferred.class */
public interface Deferred<T> extends Job {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Deferred$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    Object a(Continuation<? super T> continuation);

    T f();
}
