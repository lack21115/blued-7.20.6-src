package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/intrinsics/UndispatchedKt.class */
public final class UndispatchedKt {
    public static final <T, R> Object a(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        Object g;
        try {
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (function2 != null) {
            completedExceptionally = ((Function2) TypeIntrinsics.b(function2, 2)).invoke(r, scopeCoroutine);
            if (completedExceptionally != IntrinsicsKt.a() && (g = scopeCoroutine.g(completedExceptionally)) != JobSupportKt.a) {
                if (g instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) g;
                    Throwable th2 = completedExceptionally2.a;
                    Throwable th3 = completedExceptionally2.a;
                    Continuation<? super T> continuation = scopeCoroutine.c;
                    Throwable th4 = th3;
                    if (DebugKt.c()) {
                        th4 = !(continuation instanceof CoroutineStackFrame) ? th3 : StackTraceRecoveryKt.a(th3, (CoroutineStackFrame) continuation);
                    }
                    throw th4;
                }
                return JobSupportKt.b(g);
            }
            return IntrinsicsKt.a();
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    public static final <T> void a(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Continuation a = DebugProbesKt.a(continuation);
        try {
            if (function1 == null) {
                throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            Object invoke = ((Function1) TypeIntrinsics.b(function1, 1)).invoke(a);
            if (invoke != IntrinsicsKt.a()) {
                Result.Companion companion = Result.a;
                a.resumeWith(Result.f(invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            a.resumeWith(Result.f(ResultKt.a(th)));
        }
    }

    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Continuation a = DebugProbesKt.a(continuation);
        try {
            if (function2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            Object invoke = ((Function2) TypeIntrinsics.b(function2, 2)).invoke(r, a);
            if (invoke != IntrinsicsKt.a()) {
                Result.Companion companion = Result.a;
                a.resumeWith(Result.f(invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            a.resumeWith(Result.f(ResultKt.a(th)));
        }
    }

    public static final <T, R> Object b(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        Object g;
        Object b;
        boolean z = false;
        try {
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (function2 != null) {
            completedExceptionally = ((Function2) TypeIntrinsics.b(function2, 2)).invoke(r, scopeCoroutine);
            if (completedExceptionally != IntrinsicsKt.a() && (g = scopeCoroutine.g(completedExceptionally)) != JobSupportKt.a) {
                if (g instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) g;
                    Throwable th2 = completedExceptionally2.a;
                    if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).a != scopeCoroutine) {
                        z = true;
                    }
                    if (z) {
                        Throwable th3 = completedExceptionally2.a;
                        Continuation<? super T> continuation = scopeCoroutine.c;
                        Throwable th4 = th3;
                        if (DebugKt.c()) {
                            th4 = !(continuation instanceof CoroutineStackFrame) ? th3 : StackTraceRecoveryKt.a(th3, (CoroutineStackFrame) continuation);
                        }
                        throw th4;
                    }
                    b = completedExceptionally;
                    if (completedExceptionally instanceof CompletedExceptionally) {
                        Throwable th5 = ((CompletedExceptionally) completedExceptionally).a;
                        Continuation<? super T> continuation2 = scopeCoroutine.c;
                        Throwable th6 = th5;
                        if (DebugKt.c()) {
                            th6 = !(continuation2 instanceof CoroutineStackFrame) ? th5 : StackTraceRecoveryKt.a(th5, (CoroutineStackFrame) continuation2);
                        }
                        throw th6;
                    }
                } else {
                    b = JobSupportKt.b(g);
                }
                return b;
            }
            return IntrinsicsKt.a();
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    public static final <R, T> void b(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Continuation a = DebugProbesKt.a(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object a2 = ThreadContextKt.a(context, null);
            if (function2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            Object invoke = ((Function2) TypeIntrinsics.b(function2, 2)).invoke(r, a);
            ThreadContextKt.b(context, a2);
            if (invoke != IntrinsicsKt.a()) {
                Result.Companion companion = Result.a;
                a.resumeWith(Result.f(invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            a.resumeWith(Result.f(ResultKt.a(th)));
        }
    }
}
