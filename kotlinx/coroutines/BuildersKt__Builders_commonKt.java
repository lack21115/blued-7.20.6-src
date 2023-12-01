package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/BuildersKt__Builders_commonKt.class */
public final /* synthetic */ class BuildersKt__Builders_commonKt {
    public static final <T> Object a(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object f;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        JobKt.a(plus);
        if (plus == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(plus, continuation);
            f = UndispatchedKt.a(scopeCoroutine, scopeCoroutine, (Function2<? super ScopeCoroutine, ? super Continuation<? super T>, ? extends Object>) function2);
        } else if (Intrinsics.a(plus.get(ContinuationInterceptor.f42453a), context.get(ContinuationInterceptor.f42453a))) {
            UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(plus, continuation);
            Object a2 = ThreadContextKt.a(plus, null);
            try {
                f = UndispatchedKt.a((ScopeCoroutine) undispatchedCoroutine, undispatchedCoroutine, (Function2<? super UndispatchedCoroutine, ? super Continuation<? super T>, ? extends Object>) function2);
            } finally {
                ThreadContextKt.b(plus, a2);
            }
        } else {
            DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(plus, continuation);
            CancellableKt.a(function2, dispatchedCoroutine, dispatchedCoroutine, null, 4, null);
            f = dispatchedCoroutine.f();
        }
        if (f == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return f;
    }

    public static final Job a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        CoroutineContext a2 = CoroutineContextKt.a(coroutineScope, coroutineContext);
        LazyStandaloneCoroutine lazyStandaloneCoroutine = coroutineStart.a() ? new LazyStandaloneCoroutine(a2, function2) : new StandaloneCoroutine(a2, true);
        lazyStandaloneCoroutine.a(coroutineStart, (CoroutineStart) lazyStandaloneCoroutine, (Function2<? super CoroutineStart, ? super Continuation<? super T>, ? extends Object>) function2);
        return lazyStandaloneCoroutine;
    }

    public static /* synthetic */ Job a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f42457a;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> Deferred<T> b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        CoroutineContext a2 = CoroutineContextKt.a(coroutineScope, coroutineContext);
        LazyDeferredCoroutine lazyDeferredCoroutine = coroutineStart.a() ? new LazyDeferredCoroutine(a2, function2) : new DeferredCoroutine(a2, true);
        lazyDeferredCoroutine.a(coroutineStart, (CoroutineStart) lazyDeferredCoroutine, (Function2<? super CoroutineStart, ? super Continuation<? super T>, ? extends Object>) function2);
        return lazyDeferredCoroutine;
    }

    public static /* synthetic */ Deferred b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f42457a;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.b(coroutineScope, coroutineContext, coroutineStart, function2);
    }
}
