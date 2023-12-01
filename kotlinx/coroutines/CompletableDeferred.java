package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CompletableDeferred.class */
public interface CompletableDeferred<T> extends Deferred<T> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CompletableDeferred$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    boolean a(T t);

    boolean a(Throwable th);
}
