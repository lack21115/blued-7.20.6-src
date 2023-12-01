package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@DebugMetadata(b = "Combine.kt", c = {147}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$second$1.class */
final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ Flow<T2> b;
    private /* synthetic */ Object c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$second$1(Flow<? extends T2> flow, Continuation<? super CombineKt$zipImpl$1$1$second$1> continuation) {
        super(2, continuation);
        this.b = flow;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(ProducerScope<Object> producerScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1$second$1) create(producerScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1$second$1 combineKt$zipImpl$1$1$second$1 = new CombineKt$zipImpl$1$1$second$1(this.b, continuation);
        combineKt$zipImpl$1$1$second$1.c = obj;
        return combineKt$zipImpl$1$1$second$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            final ProducerScope producerScope = (ProducerScope) this.c;
            this.a = 1;
            if (this.b.a(new FlowCollector<T2>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$invokeSuspend$$inlined$collect$1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v10, types: [kotlinx.coroutines.internal.Symbol] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(T2 t2, Continuation<? super Unit> continuation) {
                    SendChannel r = ProducerScope.this.r();
                    T2 t22 = t2;
                    if (t2 == null) {
                        t22 = NullSurrogateKt.a;
                    }
                    Object a2 = r.a(t22, continuation);
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
