package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineExceptionHandler.class */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    public static final Key b = Key.f42795a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineExceptionHandler$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineExceptionHandler$Key.class */
    public static final class Key implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Key f42795a = new Key();

        private Key() {
        }
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
