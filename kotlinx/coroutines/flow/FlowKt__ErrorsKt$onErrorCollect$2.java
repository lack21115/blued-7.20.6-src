package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "Errors.kt", c = {89}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$2")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ErrorsKt$onErrorCollect$2.class */
final class FlowKt__ErrorsKt$onErrorCollect$2<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43178a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function1<Throwable, Boolean> f43179c;
    final /* synthetic */ Flow<T> d;
    private /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ErrorsKt$onErrorCollect$2(Function1<? super Throwable, Boolean> function1, Flow<? extends T> flow, Continuation<? super FlowKt__ErrorsKt$onErrorCollect$2> continuation) {
        super(3, continuation);
        this.f43179c = function1;
        this.d = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object a(Object obj, Throwable th, Continuation<? super Unit> continuation) {
        return a((FlowCollector) ((FlowCollector) obj), th, continuation);
    }

    public final Object a(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        FlowKt__ErrorsKt$onErrorCollect$2 flowKt__ErrorsKt$onErrorCollect$2 = new FlowKt__ErrorsKt$onErrorCollect$2(this.f43179c, this.d, continuation);
        flowKt__ErrorsKt$onErrorCollect$2.e = flowCollector;
        flowKt__ErrorsKt$onErrorCollect$2.b = th;
        return flowKt__ErrorsKt$onErrorCollect$2.invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f43178a;
        if (i == 0) {
            ResultKt.a(obj);
            FlowCollector flowCollector = (FlowCollector) this.e;
            Throwable th = (Throwable) this.b;
            if (!this.f43179c.invoke(th).booleanValue()) {
                throw th;
            }
            this.e = null;
            this.f43178a = 1;
            if (FlowKt.a(flowCollector, this.d, this) == a2) {
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
