package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@DebugMetadata(b = "Delay.kt", c = {235}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1.class */
final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43124a;
    final /* synthetic */ FlowCollector<T> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef<Object> f43125c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$1(FlowCollector<? super T> flowCollector, Ref.ObjectRef<Object> objectRef, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$1> continuation) {
        super(1, continuation);
        this.b = flowCollector;
        this.f43125c = objectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) create(continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.b, this.f43125c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f43124a;
        if (i == 0) {
            ResultKt.a(obj);
            FlowCollector<T> flowCollector = this.b;
            Symbol symbol = NullSurrogateKt.f43498a;
            Object obj2 = this.f43125c.f42545a;
            Object obj3 = obj2;
            if (obj2 == symbol) {
                obj3 = null;
            }
            this.f43124a = 1;
            if (flowCollector.emit(obj3, this) == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        this.f43125c.f42545a = null;
        return Unit.f42314a;
    }
}
