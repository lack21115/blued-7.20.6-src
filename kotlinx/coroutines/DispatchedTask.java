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

    /* renamed from: a  reason: collision with root package name */
    public int f42808a;

    public DispatchedTask(int i) {
        this.f42808a = i;
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
        return completedExceptionally.f42791a;
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
            if (!(this.f42808a != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.g;
        try {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) b();
            Continuation<T> continuation = dispatchedContinuation.f43523c;
            Object obj = dispatchedContinuation.e;
            CoroutineContext context = continuation.getContext();
            Object a2 = ThreadContextKt.a(context, obj);
            UndispatchedCoroutine<?> a3 = a2 != ThreadContextKt.f43565a ? CoroutineContextKt.a(continuation, context, a2) : null;
            CoroutineContext context2 = continuation.getContext();
            Object g = g();
            Throwable c2 = c(g);
            Job job = (c2 == null && DispatchedTaskKt.a(this.f42808a)) ? (Job) context2.get(Job.C_) : null;
            if (job != null && !job.a()) {
                CancellationException i = job.i();
                a(g, i);
                Result.Companion companion = Result.f42293a;
                if (DebugKt.c() && (continuation instanceof CoroutineStackFrame)) {
                    cancellationException = StackTraceRecoveryKt.a(i, (CoroutineStackFrame) continuation);
                    continuation.resumeWith(Result.f(ResultKt.a((Throwable) cancellationException)));
                }
                cancellationException = i;
                continuation.resumeWith(Result.f(ResultKt.a((Throwable) cancellationException)));
            } else if (c2 != null) {
                Result.Companion companion2 = Result.f42293a;
                continuation.resumeWith(Result.f(ResultKt.a(c2)));
            } else {
                T b = b(g);
                Result.Companion companion3 = Result.f42293a;
                continuation.resumeWith(Result.f(b));
            }
            Unit unit = Unit.f42314a;
            if (a3 == null || a3.q()) {
                ThreadContextKt.b(context, a2);
            }
            try {
                Result.Companion companion4 = Result.f42293a;
                DispatchedTask<T> dispatchedTask = this;
                taskContext.c();
                f2 = Result.f(Unit.f42314a);
            } catch (Throwable th) {
                Result.Companion companion5 = Result.f42293a;
                f2 = Result.f(ResultKt.a(th));
            }
            a((Throwable) null, Result.c(f2));
        } catch (Throwable th2) {
            try {
                Result.Companion companion6 = Result.f42293a;
                DispatchedTask<T> dispatchedTask2 = this;
                taskContext.c();
                f = Result.f(Unit.f42314a);
            } catch (Throwable th3) {
                Result.Companion companion7 = Result.f42293a;
                f = Result.f(ResultKt.a(th3));
            }
            a(th2, Result.c(f));
        }
    }
}
