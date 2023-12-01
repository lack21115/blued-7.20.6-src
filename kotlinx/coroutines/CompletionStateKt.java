package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CompletionStateKt.class */
public final class CompletionStateKt {
    public static final <T> Object a(Object obj, Continuation<? super T> continuation) {
        Throwable b;
        if (!(obj instanceof CompletedExceptionally)) {
            Result.Companion companion = Result.a;
            return Result.f(obj);
        }
        Result.Companion companion2 = Result.a;
        Throwable th = ((CompletedExceptionally) obj).a;
        Throwable th2 = th;
        if (DebugKt.c()) {
            if (continuation instanceof CoroutineStackFrame) {
                b = StackTraceRecoveryKt.b(th, (CoroutineStackFrame) continuation);
                th2 = b;
            } else {
                th2 = th;
            }
        }
        return Result.f(ResultKt.a(th2));
    }

    public static final <T> Object a(Object obj, Function1<? super Throwable, Unit> function1) {
        CompletedExceptionally completedExceptionally;
        Throwable c = Result.c(obj);
        if (c == null) {
            completedExceptionally = obj;
            if (function1 != null) {
                return new CompletedWithCancellation(obj, function1);
            }
        } else {
            completedExceptionally = new CompletedExceptionally(c, false, 2, null);
        }
        return completedExceptionally;
    }

    public static /* synthetic */ Object a(Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return a(obj, function1);
    }

    public static final <T> Object a(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable b;
        Throwable c = Result.c(obj);
        if (c == null) {
            return obj;
        }
        Throwable th = c;
        if (DebugKt.c()) {
            CancellableContinuation<?> cancellableContinuation2 = cancellableContinuation;
            if (cancellableContinuation2 instanceof CoroutineStackFrame) {
                b = StackTraceRecoveryKt.b(c, (CoroutineStackFrame) cancellableContinuation2);
                th = b;
            } else {
                th = c;
            }
        }
        return new CompletedExceptionally(th, false, 2, null);
    }
}
