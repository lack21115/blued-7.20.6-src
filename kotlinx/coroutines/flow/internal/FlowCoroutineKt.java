package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/FlowCoroutineKt.class */
public final class FlowCoroutineKt {
    public static final <R> Object a(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        FlowCoroutine flowCoroutine = new FlowCoroutine(continuation.getContext(), continuation);
        Object a2 = UndispatchedKt.a((ScopeCoroutine) flowCoroutine, flowCoroutine, (Function2<? super FlowCoroutine, ? super Continuation<? super T>, ? extends Object>) function2);
        if (a2 == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return a2;
    }

    public static final <T> ReceiveChannel<T> a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowProduceCoroutine flowProduceCoroutine = new FlowProduceCoroutine(CoroutineContextKt.a(coroutineScope, coroutineContext), ChannelKt.a(i, null, null, 6, null));
        flowProduceCoroutine.a(CoroutineStart.ATOMIC, (CoroutineStart) flowProduceCoroutine, (Function2<? super CoroutineStart, ? super Continuation<? super T>, ? extends Object>) function2);
        return flowProduceCoroutine;
    }
}
