package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
@DebugMetadata(b = "Emitters.kt", c = {223}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1.class */
public final class FlowKt__EmittersKt$transform$1<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43164a;
    final /* synthetic */ Flow<T> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> f43165c;
    private /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$transform$1(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__EmittersKt$transform$1> continuation) {
        super(2, continuation);
        this.b = flow;
        this.f43165c = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        return ((FlowKt__EmittersKt$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.b, this.f43165c, continuation);
        flowKt__EmittersKt$transform$1.d = obj;
        return flowKt__EmittersKt$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f43164a;
        if (i == 0) {
            ResultKt.a(obj);
            FlowCollector flowCollector = (FlowCollector) this.d;
            this.f43164a = 1;
            if (this.b.a(new FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(this.f43165c, flowCollector), this) == a2) {
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
