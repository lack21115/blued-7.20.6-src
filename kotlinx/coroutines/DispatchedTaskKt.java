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
        EventLoop a = ThreadLocalEventLoop.a.a();
        if (a.f()) {
            a.a(dispatchedTask);
            return;
        }
        a.a(true);
        try {
            a(dispatchedTask, dispatchedTask.b(), true);
            do {
            } while (a.e());
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
        if (z || !(b instanceof DispatchedContinuation) || a(i) != a(dispatchedTask.a)) {
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
        Throwable c = dispatchedTask.c(g);
        if (c != null) {
            Result.Companion companion = Result.a;
            b = ResultKt.a(c);
        } else {
            Result.Companion companion2 = Result.a;
            b = dispatchedTask.b(g);
        }
        Object f = Result.f(b);
        if (!z) {
            continuation.resumeWith(f);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Continuation<T> continuation2 = dispatchedContinuation.c;
        Object obj = dispatchedContinuation.e;
        CoroutineContext context = continuation2.getContext();
        Object a = ThreadContextKt.a(context, obj);
        UndispatchedCoroutine<?> a2 = a != ThreadContextKt.a ? CoroutineContextKt.a(continuation2, context, a) : null;
        try {
            dispatchedContinuation.c.resumeWith(f);
            Unit unit = Unit.a;
            if (a2 == null || a2.q()) {
                ThreadContextKt.b(context, a);
            }
        } catch (Throwable th) {
            if (a2 == null || a2.q()) {
                ThreadContextKt.b(context, a);
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
