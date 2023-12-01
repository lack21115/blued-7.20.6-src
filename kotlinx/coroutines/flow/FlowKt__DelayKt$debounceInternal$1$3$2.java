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
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@DebugMetadata(b = "Delay.kt", c = {245}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2.class */
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f43126a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ Object f43127c;
    final /* synthetic */ Ref.ObjectRef<Object> d;
    final /* synthetic */ FlowCollector<T> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> objectRef, FlowCollector<? super T> flowCollector, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.d = objectRef;
        this.e = flowCollector;
    }

    public final Object a(Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(ChannelResult.h(obj), continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.d, this.e, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.f43127c = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(ChannelResult<? extends Object> channelResult, Continuation<? super Unit> continuation) {
        return a(channelResult.a(), continuation);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef<Object> objectRef;
        Ref.ObjectRef<Object> objectRef2;
        Object a2 = IntrinsicsKt.a();
        int i = this.b;
        if (i == 0) {
            ResultKt.a(obj);
            ?? a3 = ((ChannelResult) this.f43127c).a();
            Ref.ObjectRef<Object> objectRef3 = this.d;
            boolean z = a3 instanceof ChannelResult.Failed;
            if (!z) {
                objectRef3.f42545a = a3;
            }
            objectRef = this.d;
            FlowCollector<T> flowCollector = this.e;
            if (z) {
                Throwable d = ChannelResult.d(a3);
                if (d != null) {
                    throw d;
                }
                objectRef2 = objectRef;
                if (objectRef.f42545a != null) {
                    Symbol symbol = NullSurrogateKt.f43498a;
                    Object obj2 = objectRef.f42545a;
                    Object obj3 = obj2;
                    if (obj2 == symbol) {
                        obj3 = null;
                    }
                    this.f43127c = a3;
                    this.f43126a = objectRef;
                    this.b = 1;
                    if (flowCollector.emit(obj3, this) == a2) {
                        return a2;
                    }
                }
                objectRef2.f42545a = NullSurrogateKt.f43499c;
            }
            return Unit.f42314a;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
            objectRef = (Ref.ObjectRef) this.f43126a;
        }
        objectRef2 = objectRef;
        objectRef2.f42545a = NullSurrogateKt.f43499c;
        return Unit.f42314a;
    }
}
