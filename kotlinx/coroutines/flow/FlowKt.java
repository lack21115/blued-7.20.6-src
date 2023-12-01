package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt.class */
public final class FlowKt {
    public static final <T, C extends Collection<? super T>> Object a(Flow<? extends T> flow, C c2, Continuation<? super C> continuation) {
        return FlowKt__CollectionKt.a(flow, c2, continuation);
    }

    public static final Object a(Flow<?> flow, Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.a(flow, continuation);
    }

    public static final <T> Object a(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.a(flow, function2, continuation);
    }

    public static final <S, T extends S> Object a(Flow<? extends T> flow, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, Continuation<? super S> continuation) {
        return FlowKt__ReduceKt.a(flow, function3, continuation);
    }

    public static final <T> Object a(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.a(flow, flowCollector, continuation);
    }

    public static final <T> Object a(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        return FlowKt__ChannelsKt.a(flowCollector, receiveChannel, continuation);
    }

    public static final <T> Object a(FlowCollector<? super T> flowCollector, Flow<? extends T> flow, Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.a(flowCollector, flow, continuation);
    }

    public static final ReceiveChannel<Unit> a(CoroutineScope coroutineScope, long j, long j2) {
        return FlowKt__DelayKt.a(coroutineScope, j, j2);
    }

    public static final <T> Flow<T> a(Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.a((Iterable) iterable);
    }

    public static final <T> Flow<T> a(T t) {
        return FlowKt__BuildersKt.a(t);
    }

    public static final <T> Flow<T> a(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.a((Function2) function2);
    }

    public static final <T> Flow<T> a(Flow<? extends T> flow) {
        return FlowKt__ContextKt.a(flow);
    }

    public static final <T> Flow<T> a(Flow<? extends T> flow, int i, BufferOverflow bufferOverflow) {
        return FlowKt__ContextKt.a(flow, i, bufferOverflow);
    }

    public static final <T> Flow<T> a(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        return FlowKt__ContextKt.a(flow, coroutineContext);
    }

    public static final <T> Flow<T> a(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.a(flow, function2);
    }

    public static final <T, R> Flow<R> a(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__MergeKt.a(flow, function3);
    }

    public static final <T1, T2, R> Flow<R> a(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.a(flow, flow2, function3);
    }

    public static final void a(FlowCollector<?> flowCollector) {
        FlowKt__EmittersKt.a(flowCollector);
    }

    public static final <T> Object b(Flow<? extends T> flow, Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.a(flow, continuation);
    }

    public static final <T> Object b(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.a(flow, function2, continuation);
    }

    public static final <T> Flow<T> b(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.b(function2);
    }

    public static final <T> Flow<T> b(Flow<? extends T> flow) {
        return FlowKt__DistinctKt.a(flow);
    }

    public static final <T, R> Flow<R> b(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.a(flow, function2);
    }

    public static final <T> Object c(Flow<? extends T> flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.a(flow, continuation);
    }

    public static final <T> Object c(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.a(flow, function2, continuation);
    }

    public static final <T> Object d(Flow<? extends T> flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.b(flow, continuation);
    }

    public static final <T> Object d(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.b(flow, function2, continuation);
    }

    public static final <T> Object e(Flow<? extends T> flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.c(flow, continuation);
    }

    public static final <T> Object f(Flow<? extends T> flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.d(flow, continuation);
    }

    public static final <T> Object g(Flow<? extends T> flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.e(flow, continuation);
    }

    public static final <T> Object h(Flow<? extends T> flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.f(flow, continuation);
    }
}
