package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@DebugMetadata(b = "Merge.kt", c = {101}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/ChannelFlowTransformLatest$flowCollect$3.class */
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43464a;
    final /* synthetic */ ChannelFlowTransformLatest<T, R> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FlowCollector<R> f43465c;
    private /* synthetic */ Object d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, Continuation<? super ChannelFlowTransformLatest$flowCollect$3> continuation) {
        super(2, continuation);
        this.b = channelFlowTransformLatest;
        this.f43465c = flowCollector;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.b, this.f43465c, continuation);
        channelFlowTransformLatest$flowCollect$3.d = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f43464a;
        if (i == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.d;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            this.f43464a = 1;
            if (this.b.d.a(new ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1(objectRef, coroutineScope, this.b, this.f43465c), this) == a2) {
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
