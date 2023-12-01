package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata
@DebugMetadata(b = "Delay.kt", c = {}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1.class */
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43134a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef<Object> f43135c;
    final /* synthetic */ ReceiveChannel<Unit> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> objectRef, ReceiveChannel<Unit> receiveChannel, Continuation<? super FlowKt__DelayKt$sample$2$1$1> continuation) {
        super(2, continuation);
        this.f43135c = objectRef;
        this.d = receiveChannel;
    }

    public final Object a(Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(ChannelResult.h(obj), continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.f43135c, this.d, continuation);
        flowKt__DelayKt$sample$2$1$1.b = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(ChannelResult<? extends Object> channelResult, Continuation<? super Unit> continuation) {
        return a(channelResult.a(), continuation);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f43134a == 0) {
            ResultKt.a(obj);
            ?? a2 = ((ChannelResult) this.b).a();
            Ref.ObjectRef<Object> objectRef = this.f43135c;
            boolean z = a2 instanceof ChannelResult.Failed;
            if (!z) {
                objectRef.f42545a = a2;
            }
            ReceiveChannel<Unit> receiveChannel = this.d;
            Ref.ObjectRef<Object> objectRef2 = this.f43135c;
            if (z) {
                Throwable d = ChannelResult.d(a2);
                if (d != null) {
                    throw d;
                }
                receiveChannel.a(new ChildCancelledException());
                objectRef2.f42545a = NullSurrogateKt.f43499c;
            }
            return Unit.f42314a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
