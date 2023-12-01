package kotlinx.coroutines.test;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/test/TestCoroutineContext$special$$inlined$CoroutineExceptionHandler$1.class */
public final class TestCoroutineContext$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TestCoroutineContext f43645a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestCoroutineContext$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, TestCoroutineContext testCoroutineContext) {
        super(key);
        this.f43645a = testCoroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        List list;
        list = this.f43645a.b;
        list.add(th);
    }
}
