package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/DispatchedContinuationKt.class */
public final class DispatchedContinuationKt {
    private static final Symbol b = new Symbol("UNDEFINED");

    /* renamed from: a */
    public static final Symbol f43524a = new Symbol("REUSABLE_CLAIMED");

    public static final <T> void a(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        boolean z;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(obj);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Object a2 = CompletionStateKt.a(obj, function1);
        if (dispatchedContinuation.b.isDispatchNeeded(dispatchedContinuation.getContext())) {
            dispatchedContinuation.d = a2;
            dispatchedContinuation.f42808a = 1;
            dispatchedContinuation.b.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
            return;
        }
        DebugKt.a();
        EventLoop a3 = ThreadLocalEventLoop.f42855a.a();
        if (a3.f()) {
            dispatchedContinuation.d = a2;
            dispatchedContinuation.f42808a = 1;
            a3.a(dispatchedContinuation);
            return;
        }
        DispatchedContinuation dispatchedContinuation2 = dispatchedContinuation;
        a3.a(true);
        try {
            Job job = (Job) dispatchedContinuation.getContext().get(Job.C_);
            if (job == null || job.a()) {
                z = false;
            } else {
                CancellationException i = job.i();
                dispatchedContinuation.a(a2, i);
                DispatchedContinuation dispatchedContinuation3 = dispatchedContinuation;
                Result.Companion companion = Result.f42293a;
                dispatchedContinuation3.resumeWith(Result.f(ResultKt.a((Throwable) i)));
                z = true;
            }
            if (!z) {
                Continuation<T> continuation2 = dispatchedContinuation.f43523c;
                Object obj2 = dispatchedContinuation.e;
                CoroutineContext context = continuation2.getContext();
                Object a4 = ThreadContextKt.a(context, obj2);
                UndispatchedCoroutine<?> a5 = a4 != ThreadContextKt.f43565a ? CoroutineContextKt.a(continuation2, context, a4) : null;
                dispatchedContinuation.f43523c.resumeWith(obj);
                Unit unit = Unit.f42314a;
                if (a5 == null || a5.q()) {
                    ThreadContextKt.b(context, a4);
                }
            }
            do {
            } while (a3.e());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void a(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        a(continuation, obj, function1);
    }

    public static final boolean a(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.f42314a;
        DebugKt.a();
        EventLoop a2 = ThreadLocalEventLoop.f42855a.a();
        if (a2.g()) {
            return false;
        }
        if (a2.f()) {
            dispatchedContinuation.d = unit;
            dispatchedContinuation.f42808a = 1;
            a2.a(dispatchedContinuation);
            return true;
        }
        DispatchedContinuation<? super Unit> dispatchedContinuation2 = dispatchedContinuation;
        a2.a(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (a2.e());
        } finally {
            try {
                a2.b(true);
                return false;
            } catch (Throwable th) {
            }
        }
        a2.b(true);
        return false;
    }
}
