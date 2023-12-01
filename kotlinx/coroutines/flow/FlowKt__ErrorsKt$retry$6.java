package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "Errors.kt", c = {}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ErrorsKt$retry$6.class */
final class FlowKt__ErrorsKt$retry$6<T> extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43184a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ long f43185c;
    final /* synthetic */ Function1<Throwable, Boolean> d;
    final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ErrorsKt$retry$6(Function1<? super Throwable, Boolean> function1, int i, Continuation<? super FlowKt__ErrorsKt$retry$6> continuation) {
        super(4, continuation);
        this.d = function1;
        this.e = i;
    }

    public final Object a(FlowCollector<? super T> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
        FlowKt__ErrorsKt$retry$6 flowKt__ErrorsKt$retry$6 = new FlowKt__ErrorsKt$retry$6(this.d, this.e, continuation);
        flowKt__ErrorsKt$retry$6.b = th;
        flowKt__ErrorsKt$retry$6.f43185c = j;
        return flowKt__ErrorsKt$retry$6.invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* synthetic */ Object invoke(Object obj, Throwable th, Long l, Continuation<? super Boolean> continuation) {
        return a((FlowCollector) obj, th, l.longValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f43184a == 0) {
            ResultKt.a(obj);
            return Boxing.a(this.d.invoke((Throwable) this.b).booleanValue() && this.f43185c < ((long) this.e));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
