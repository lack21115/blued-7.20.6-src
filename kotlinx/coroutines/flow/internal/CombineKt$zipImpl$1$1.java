package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
@DebugMetadata(b = "Combine.kt", c = {129}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1.class */
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ FlowCollector<R> b;
    final /* synthetic */ Flow<T2> c;
    final /* synthetic */ Flow<T1> d;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> e;
    private /* synthetic */ Object f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "Combine.kt", c = {147}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2.class */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Flow<T1> b;
        final /* synthetic */ CoroutineContext c;
        final /* synthetic */ Object d;
        final /* synthetic */ ReceiveChannel<Object> e;
        final /* synthetic */ FlowCollector<R> f;
        final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Flow<? extends T1> flow, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.b = flow;
            this.c = coroutineContext;
            this.d = obj;
            this.e = receiveChannel;
            this.f = flowCollector;
            this.g = function3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(unit, continuation)).invokeSuspend(Unit.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.b, this.c, this.d, this.e, this.f, this.g, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object a = IntrinsicsKt.a();
            int i = this.a;
            if (i == 0) {
                ResultKt.a(obj);
                Flow<T1> flow = this.b;
                final CoroutineContext coroutineContext = this.c;
                final Object obj2 = this.d;
                final ReceiveChannel<Object> receiveChannel = this.e;
                final FlowCollector<R> flowCollector = this.f;
                final Function3<T1, T2, Continuation<? super R>, Object> function3 = this.g;
                this.a = 1;
                if (flow.a(new FlowCollector<T1>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(T1 t1, Continuation<? super Unit> continuation) {
                        Object a2 = ChannelFlowKt.a(CoroutineContext.this, Unit.a, obj2, new CombineKt$zipImpl$1$1$2$1$1(receiveChannel, flowCollector, function3, t1, null), continuation);
                        return a2 == IntrinsicsKt.a() ? a2 : Unit.a;
                    }
                }, this) == a) {
                    return a;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.a(obj);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(FlowCollector<? super R> flowCollector, Flow<? extends T2> flow, Flow<? extends T1> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.b = flowCollector;
        this.c = flow;
        this.d = flow2;
        this.e = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.b, this.c, this.d, this.e, continuation);
        combineKt$zipImpl$1$1.f = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel a;
        final CompletableJob a2;
        ReceiveChannel receiveChannel;
        Throwable th;
        Object a3 = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f;
            a = ProduceKt.a(coroutineScope, null, 0, new CombineKt$zipImpl$1$1$second$1(this.c, null), 3, null);
            a2 = JobKt__JobKt.a(null, 1, null);
            final FlowCollector<R> flowCollector = this.b;
            ((SendChannel) a).a(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public final void a(Throwable th2) {
                    if (CompletableJob.this.a()) {
                        CompletableJob.this.a(new AbortFlowException(flowCollector));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(Throwable th2) {
                    a(th2);
                    return Unit.a;
                }
            });
            try {
                CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                Object a4 = ThreadContextKt.a(coroutineContext);
                this.f = a;
                this.a = 1;
                if (ChannelFlowKt.a(coroutineScope.getCoroutineContext().plus(a2), Unit.a, null, new AnonymousClass2(this.d, coroutineContext, a4, a, this.b, this.e, null), this, 4, null) == a3) {
                    return a3;
                }
            } catch (AbortFlowException e) {
                e = e;
                receiveChannel = a;
                FlowExceptions_commonKt.a(e, this.b);
                ReceiveChannel.DefaultImpls.a(a, null, 1, null);
                return Unit.a;
            } catch (Throwable th2) {
                receiveChannel = a;
                th = th2;
                ReceiveChannel.DefaultImpls.a(receiveChannel, null, 1, null);
                throw th;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ReceiveChannel receiveChannel2 = (ReceiveChannel) this.f;
            receiveChannel = receiveChannel2;
            try {
                try {
                    ResultKt.a(obj);
                    a = receiveChannel2;
                } catch (Throwable th3) {
                    th = th3;
                    ReceiveChannel.DefaultImpls.a(receiveChannel, null, 1, null);
                    throw th;
                }
            } catch (AbortFlowException e2) {
                e = e2;
                a = receiveChannel2;
                receiveChannel = a;
                FlowExceptions_commonKt.a(e, this.b);
                ReceiveChannel.DefaultImpls.a(a, null, 1, null);
                return Unit.a;
            }
        }
        ReceiveChannel.DefaultImpls.a(a, null, 1, null);
        return Unit.a;
    }
}
