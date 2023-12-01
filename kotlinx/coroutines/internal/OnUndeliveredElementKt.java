package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/OnUndeliveredElementKt.class */
public final class OnUndeliveredElementKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException a(Function1<? super E, Unit> function1, E e, UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e);
            return undeliveredElementException;
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException(Intrinsics.a("Exception in undelivered element handler for ", (Object) e), th);
            }
            ExceptionsKt.a(undeliveredElementException, th);
            return undeliveredElementException;
        }
    }

    public static /* synthetic */ UndeliveredElementException a(Function1 function1, Object obj, UndeliveredElementException undeliveredElementException, int i, Object obj2) {
        if ((i & 2) != 0) {
            undeliveredElementException = null;
        }
        return a(function1, obj, undeliveredElementException);
    }

    public static final <E> void a(Function1<? super E, Unit> function1, E e, CoroutineContext coroutineContext) {
        UndeliveredElementException a2 = a(function1, e, (UndeliveredElementException) null);
        if (a2 == null) {
            return;
        }
        CoroutineExceptionHandlerKt.a(coroutineContext, a2);
    }

    public static final <E> Function1<Throwable, Unit> b(final Function1<? super E, Unit> function1, final E e, final CoroutineContext coroutineContext) {
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.internal.OnUndeliveredElementKt$bindCancellationFun$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void a(Throwable th) {
                OnUndeliveredElementKt.a(function1, e, coroutineContext);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Throwable th) {
                a(th);
                return Unit.f42314a;
            }
        };
    }
}
