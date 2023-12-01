package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DispatchedTaskKt.class */
public final class DispatchedTaskKt {
    private static final void a(DispatchedTask<?> dispatchedTask) {
        EventLoop a2 = ThreadLocalEventLoop.f42855a.a();
        if (a2.f()) {
            a2.a(dispatchedTask);
            return;
        }
        a2.a(true);
        try {
            a(dispatchedTask, dispatchedTask.b(), true);
            do {
            } while (a2.e());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final <T> void a(DispatchedTask<? super T> dispatchedTask, int i) {
        boolean z = true;
        if (DebugKt.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        Continuation<? super T> b = dispatchedTask.b();
        if (i != 4) {
            z = false;
        }
        if (z || !(b instanceof DispatchedContinuation) || a(i) != a(dispatchedTask.f42808a)) {
            a(dispatchedTask, b, z);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) b).b;
        CoroutineContext context = b.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, dispatchedTask);
        } else {
            a(dispatchedTask);
        }
    }

    public static final <T> void a(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z) {
        Object b;
        Object g = dispatchedTask.g();
        Throwable c2 = dispatchedTask.c(g);
        if (c2 != null) {
            Result.Companion companion = Result.f42293a;
            b = ResultKt.a(c2);
        } else {
            Result.Companion companion2 = Result.f42293a;
            b = dispatchedTask.b(g);
        }
        Object f = Result.f(b);
        if (!z) {
            continuation.resumeWith(f);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Continuation<T> continuation2 = dispatchedContinuation.f43523c;
        Object obj = dispatchedContinuation.e;
        CoroutineContext context = continuation2.getContext();
        Object a2 = ThreadContextKt.a(context, obj);
        UndispatchedCoroutine<?> a3 = a2 != ThreadContextKt.f43565a ? CoroutineContextKt.a(continuation2, context, a2) : null;
        try {
            dispatchedContinuation.f43523c.resumeWith(f);
            Unit unit = Unit.f42314a;
            if (a3 == null || a3.q()) {
                ThreadContextKt.b(context, a2);
            }
        } catch (Throwable th) {
            if (a3 == null || a3.q()) {
                ThreadContextKt.b(context, a2);
            }
            throw th;
        }
    }

    public static final boolean a(int i) {
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public static final boolean b(int i) {
        return i == 2;
    }
}
