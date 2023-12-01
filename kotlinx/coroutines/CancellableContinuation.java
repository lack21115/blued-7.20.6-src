package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CancellableContinuation.class */
public interface CancellableContinuation<T> extends Continuation<T> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CancellableContinuation$DefaultImpls.class */
    public static final class DefaultImpls {
        public static /* synthetic */ Object a(CancellableContinuation cancellableContinuation, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 2) != 0) {
                    obj2 = null;
                }
                return cancellableContinuation.a((CancellableContinuation) obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    Object a(T t, Object obj);

    Object a(T t, Object obj, Function1<? super Throwable, Unit> function1);

    Object a(Throwable th);

    void a(Object obj);

    void a(T t, Function1<? super Throwable, Unit> function1);

    void a(Function1<? super Throwable, Unit> function1);

    void a(CoroutineDispatcher coroutineDispatcher, T t);

    boolean a();
}
