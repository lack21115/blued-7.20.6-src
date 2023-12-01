package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineScopeKt.class */
public final class CoroutineScopeKt {
    public static final <R> Object a(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation.getContext(), continuation);
        Object a = UndispatchedKt.a(scopeCoroutine, scopeCoroutine, (Function2<? super ScopeCoroutine, ? super Continuation<? super T>, ? extends Object>) function2);
        if (a == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return a;
    }

    public static final CoroutineScope a() {
        CompletableJob a = SupervisorKt.a(null, 1, null);
        Dispatchers dispatchers = Dispatchers.a;
        return new ContextScope(a.plus(Dispatchers.b()));
    }

    public static final CoroutineScope a(CoroutineContext coroutineContext) {
        CompletableJob a;
        if (coroutineContext.get(Job.C_) == null) {
            a = JobKt__JobKt.a(null, 1, null);
            coroutineContext = coroutineContext.plus(a);
        }
        return new ContextScope(coroutineContext);
    }

    public static final void a(CoroutineScope coroutineScope) {
        JobKt.a(coroutineScope.getCoroutineContext());
    }

    public static final void a(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.C_);
        if (job == null) {
            throw new IllegalStateException(Intrinsics.a("Scope cannot be cancelled because it does not have a job: ", (Object) coroutineScope).toString());
        }
        job.a(cancellationException);
    }

    public static /* synthetic */ void a(CoroutineScope coroutineScope, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        a(coroutineScope, cancellationException);
    }
}
