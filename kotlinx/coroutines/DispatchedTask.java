package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DispatchedTask.class */
public abstract class DispatchedTask<T> extends Task {
    public int a;

    public DispatchedTask(int i) {
        this.a = i;
    }

    public void a(Object obj, Throwable th) {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.ExceptionsKt.a(th, th2);
        }
        Throwable th3 = th;
        if (th == null) {
            th3 = th2;
        }
        Intrinsics.a((Object) th3);
        CoroutineExceptionHandlerKt.a(b().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T b(Object obj) {
        return obj;
    }

    public abstract Continuation<T> b();

    public Throwable c(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally == null) {
            return null;
        }
        return completedExceptionally.a;
    }

    public abstract Object g();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v74, types: [java.lang.Throwable] */
    @Override // java.lang.Runnable
    public final void run() {
        Object f;
        Object f2;
        CancellationException cancellationException;
        if (DebugKt.a()) {
            if (!(this.a != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.g;
        try {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) b();
            Continuation<T> continuation = dispatchedContinuation.c;
            Object obj = dispatchedContinuation.e;
            CoroutineContext context = continuation.getContext();
            Object a = ThreadContextKt.a(context, obj);
            UndispatchedCoroutine<?> a2 = a != ThreadContextKt.a ? CoroutineContextKt.a(continuation, context, a) : null;
            CoroutineContext context2 = continuation.getContext();
            Object g = g();
            Throwable c = c(g);
            Job job = (c == null && DispatchedTaskKt.a(this.a)) ? (Job) context2.get(Job.C_) : null;
            if (job != null && !job.a()) {
                CancellationException i = job.i();
                a(g, i);
                Result.Companion companion = Result.a;
                if (DebugKt.c() && (continuation instanceof CoroutineStackFrame)) {
                    cancellationException = StackTraceRecoveryKt.a(i, (CoroutineStackFrame) continuation);
                    continuation.resumeWith(Result.f(ResultKt.a((Throwable) cancellationException)));
                }
                cancellationException = i;
                continuation.resumeWith(Result.f(ResultKt.a((Throwable) cancellationException)));
            } else if (c != null) {
                Result.Companion companion2 = Result.a;
                continuation.resumeWith(Result.f(ResultKt.a(c)));
            } else {
                T b = b(g);
                Result.Companion companion3 = Result.a;
                continuation.resumeWith(Result.f(b));
            }
            Unit unit = Unit.a;
            if (a2 == null || a2.q()) {
                ThreadContextKt.b(context, a);
            }
            try {
                Result.Companion companion4 = Result.a;
                DispatchedTask<T> dispatchedTask = this;
                taskContext.c();
                f2 = Result.f(Unit.a);
            } catch (Throwable th) {
                Result.Companion companion5 = Result.a;
                f2 = Result.f(ResultKt.a(th));
            }
            a((Throwable) null, Result.c(f2));
        } catch (Throwable th2) {
            try {
                Result.Companion companion6 = Result.a;
                DispatchedTask<T> dispatchedTask2 = this;
                taskContext.c();
                f = Result.f(Unit.a);
            } catch (Throwable th3) {
                Result.Companion companion7 = Result.a;
                f = Result.f(ResultKt.a(th3));
            }
            a(th2, Result.c(f));
        }
    }
}
