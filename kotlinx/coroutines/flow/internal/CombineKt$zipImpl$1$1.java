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

    /* renamed from: a  reason: collision with root package name */
    int f43482a;
    final /* synthetic */ FlowCollector<R> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Flow<T2> f43483c;
    final /* synthetic */ Flow<T1> d;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> e;
    private /* synthetic */ Object f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "Combine.kt", c = {147}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2.class */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f43485a;
        final /* synthetic */ Flow<T1> b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CoroutineContext f43486c;
        final /* synthetic */ Object d;
        final /* synthetic */ ReceiveChannel<Object> e;
        final /* synthetic */ FlowCollector<R> f;
        final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Flow<? extends T1> flow, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.b = flow;
            this.f43486c = coroutineContext;
            this.d = obj;
            this.e = receiveChannel;
            this.f = flowCollector;
            this.g = function3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(unit, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.b, this.f43486c, this.d, this.e, this.f, this.g, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object a2 = IntrinsicsKt.a();
            int i = this.f43485a;
            if (i == 0) {
                ResultKt.a(obj);
                Flow<T1> flow = this.b;
                final CoroutineContext coroutineContext = this.f43486c;
                final Object obj2 = this.d;
                final ReceiveChannel<Object> receiveChannel = this.e;
                final FlowCollector<R> flowCollector = this.f;
                final Function3<T1, T2, Continuation<? super R>, Object> function3 = this.g;
                this.f43485a = 1;
                if (flow.a(new FlowCollector<T1>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(T1 t1, Continuation<? super Unit> continuation) {
                        Object a3 = ChannelFlowKt.a(CoroutineContext.this, Unit.f42314a, obj2, new CombineKt$zipImpl$1$1$2$1$1(receiveChannel, flowCollector, function3, t1, null), continuation);
                        return a3 == IntrinsicsKt.a() ? a3 : Unit.f42314a;
                    }
                }, this) == a2) {
                    return a2;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.a(obj);
            }
            return Unit.f42314a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(FlowCollector<? super R> flowCollector, Flow<? extends T2> flow, Flow<? extends T1> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.b = flowCollector;
        this.f43483c = flow;
        this.d = flow2;
        this.e = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.b, this.f43483c, this.d, this.e, continuation);
        combineKt$zipImpl$1$1.f = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel a2;
        final CompletableJob a3;
        ReceiveChannel receiveChannel;
        Throwable th;
        Object a4 = IntrinsicsKt.a();
        int i = this.f43482a;
        if (i == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f;
            a2 = ProduceKt.a(coroutineScope, null, 0, new CombineKt$zipImpl$1$1$second$1(this.f43483c, null), 3, null);
            a3 = JobKt__JobKt.a(null, 1, null);
            final FlowCollector<R> flowCollector = this.b;
            ((SendChannel) a2).a(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
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
                    return Unit.f42314a;
                }
            });
            try {
                CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                Object a5 = ThreadContextKt.a(coroutineContext);
                this.f = a2;
                this.f43482a = 1;
                if (ChannelFlowKt.a(coroutineScope.getCoroutineContext().plus(a3), Unit.f42314a, null, new AnonymousClass2(this.d, coroutineContext, a5, a2, this.b, this.e, null), this, 4, null) == a4) {
                    return a4;
                }
            } catch (AbortFlowException e) {
                e = e;
                receiveChannel = a2;
                FlowExceptions_commonKt.a(e, this.b);
                ReceiveChannel.DefaultImpls.a(a2, null, 1, null);
                return Unit.f42314a;
            } catch (Throwable th2) {
                receiveChannel = a2;
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
                    a2 = receiveChannel2;
                } catch (Throwable th3) {
                    th = th3;
                    ReceiveChannel.DefaultImpls.a(receiveChannel, null, 1, null);
                    throw th;
                }
            } catch (AbortFlowException e2) {
                e = e2;
                a2 = receiveChannel2;
                receiveChannel = a2;
                FlowExceptions_commonKt.a(e, this.b);
                ReceiveChannel.DefaultImpls.a(a2, null, 1, null);
                return Unit.f42314a;
            }
        }
        ReceiveChannel.DefaultImpls.a(a2, null, 1, null);
        return Unit.f42314a;
    }
}
