package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1.class */
public final class CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function2<CoroutineContext, Throwable, Unit> f42797a;

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        this.f42797a.invoke(coroutineContext, th);
    }
}
