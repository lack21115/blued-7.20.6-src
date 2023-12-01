package kotlinx.coroutines.flow;

import com.android.ims.ImsReasonInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "Delay.kt", c = {ImsReasonInfo.CODE_SIP_SERVER_TIMEOUT}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2.class */
final class FlowKt__DelayKt$sample$2<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    Object a;
    Object b;
    int c;
    /* synthetic */ Object d;
    final /* synthetic */ long e;
    final /* synthetic */ Flow<T> f;
    private /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$sample$2(long j, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$sample$2> continuation) {
        super(3, continuation);
        this.e = j;
        this.f = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object a(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        return a(coroutineScope, (FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object a(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.e, this.f, continuation);
        flowKt__DelayKt$sample$2.g = coroutineScope;
        flowKt__DelayKt$sample$2.d = flowCollector;
        return flowKt__DelayKt$sample$2.invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        ReceiveChannel a;
        Ref.ObjectRef objectRef;
        ReceiveChannel a2;
        ReceiveChannel receiveChannel;
        Object a3 = IntrinsicsKt.a();
        int i = this.c;
        if (i == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.g;
            flowCollector = (FlowCollector) this.d;
            a = ProduceKt.a(coroutineScope, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.f, null), 1, null);
            objectRef = new Ref.ObjectRef();
            a2 = FlowKt__DelayKt.a(coroutineScope, this.e, 0L, 2, null);
            receiveChannel = a2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ReceiveChannel receiveChannel2 = (ReceiveChannel) this.b;
            objectRef = (Ref.ObjectRef) this.a;
            a = (ReceiveChannel) this.d;
            flowCollector = (FlowCollector) this.g;
            ResultKt.a(obj);
            receiveChannel = receiveChannel2;
        }
        while (objectRef.a != NullSurrogateKt.c) {
            this.g = flowCollector;
            this.d = a;
            this.a = objectRef;
            this.b = receiveChannel;
            this.c = 1;
            FlowKt__DelayKt$sample$2<T> flowKt__DelayKt$sample$2 = this;
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(flowKt__DelayKt$sample$2);
            try {
                SelectBuilderImpl selectBuilderImpl2 = selectBuilderImpl;
                selectBuilderImpl2.a(a.k(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannel, null));
                selectBuilderImpl2.a(receiveChannel.j(), new FlowKt__DelayKt$sample$2$1$2(objectRef, flowCollector, null));
            } catch (Throwable th) {
                selectBuilderImpl.b(th);
            }
            Object b = selectBuilderImpl.b();
            if (b == IntrinsicsKt.a()) {
                DebugProbesKt.c(flowKt__DelayKt$sample$2);
            }
            if (b == a3) {
                return a3;
            }
        }
        return Unit.a;
    }
}
