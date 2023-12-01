package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobKt__FutureKt.class */
final /* synthetic */ class JobKt__FutureKt {
    public static final void a(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        cancellableContinuation.a((Function1<? super Throwable, Unit>) new CancelFutureOnCancel(future));
    }
}
