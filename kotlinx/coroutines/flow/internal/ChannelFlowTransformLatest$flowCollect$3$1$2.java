package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@DebugMetadata(b = "Merge.kt", c = {34}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/ChannelFlowTransformLatest$flowCollect$3$1$2.class */
final class ChannelFlowTransformLatest$flowCollect$3$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43466a;
    final /* synthetic */ ChannelFlowTransformLatest<T, R> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FlowCollector<R> f43467c;
    final /* synthetic */ T d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3$1$2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, T t, Continuation<? super ChannelFlowTransformLatest$flowCollect$3$1$2> continuation) {
        super(2, continuation);
        this.b = channelFlowTransformLatest;
        this.f43467c = flowCollector;
        this.d = t;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChannelFlowTransformLatest$flowCollect$3$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChannelFlowTransformLatest$flowCollect$3$1$2(this.b, this.f43467c, this.d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function3 function3;
        Object a2 = IntrinsicsKt.a();
        int i = this.f43466a;
        if (i == 0) {
            ResultKt.a(obj);
            function3 = ((ChannelFlowTransformLatest) this.b).e;
            Object obj2 = this.f43467c;
            T t = this.d;
            this.f43466a = 1;
            if (function3.a(obj2, t, this) == a2) {
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
