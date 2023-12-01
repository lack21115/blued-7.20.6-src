package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ThreadContextElement.class */
public interface ThreadContextElement<S> extends CoroutineContext.Element {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ThreadContextElement$DefaultImpls.class */
    public static final class DefaultImpls {
        public static <S, R> R a(ThreadContextElement<S> threadContextElement, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.a(threadContextElement, r, function2);
        }

        public static <S> CoroutineContext a(ThreadContextElement<S> threadContextElement, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.a(threadContextElement, coroutineContext);
        }
    }

    void a(CoroutineContext coroutineContext, S s);

    S b(CoroutineContext coroutineContext);
}
