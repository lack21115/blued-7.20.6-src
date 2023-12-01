package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "Builders.kt", c = {216}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowViaChannel$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__BuildersKt$flowViaChannel$1.class */
final class FlowKt__BuildersKt$flowViaChannel$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43088a;
    final /* synthetic */ Function2<CoroutineScope, SendChannel<? super T>, Unit> b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ Object f43089c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__BuildersKt$flowViaChannel$1(Function2<? super CoroutineScope, ? super SendChannel<? super T>, Unit> function2, Continuation<? super FlowKt__BuildersKt$flowViaChannel$1> continuation) {
        super(2, continuation);
        this.b = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((FlowKt__BuildersKt$flowViaChannel$1) create(producerScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__BuildersKt$flowViaChannel$1 flowKt__BuildersKt$flowViaChannel$1 = new FlowKt__BuildersKt$flowViaChannel$1(this.b, continuation);
        flowKt__BuildersKt$flowViaChannel$1.f43089c = obj;
        return flowKt__BuildersKt$flowViaChannel$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f43088a;
        if (i == 0) {
            ResultKt.a(obj);
            ProducerScope producerScope = (ProducerScope) this.f43089c;
            this.b.invoke(producerScope, producerScope.r());
            this.f43088a = 1;
            if (ProduceKt.a(producerScope, null, this, 1, null) == a2) {
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
