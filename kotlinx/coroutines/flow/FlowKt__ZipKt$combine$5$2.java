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

/* JADX INFO: Add missing generic type declarations: [R, T] */
@Metadata
@DebugMetadata(b = "Zip.kt", c = {238, 238}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$5$2")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2.class */
public final class FlowKt__ZipKt$combine$5$2<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43383a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function2<T[], Continuation<? super R>, Object> f43384c;
    private /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$2(Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super FlowKt__ZipKt$combine$5$2> continuation) {
        super(3, continuation);
        this.f43384c = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object a(FlowCollector<? super R> flowCollector, T[] tArr, Continuation<? super Unit> continuation) {
        FlowKt__ZipKt$combine$5$2 flowKt__ZipKt$combine$5$2 = new FlowKt__ZipKt$combine$5$2(this.f43384c, continuation);
        flowKt__ZipKt$combine$5$2.d = flowCollector;
        flowKt__ZipKt$combine$5$2.b = tArr;
        return flowKt__ZipKt$combine$5$2.invokeSuspend(Unit.f42314a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object a2 = IntrinsicsKt.a();
        int i = this.f43383a;
        if (i == 0) {
            ResultKt.a(obj);
            flowCollector = (FlowCollector) this.d;
            Object[] objArr = (Object[]) this.b;
            this.d = flowCollector;
            this.f43383a = 1;
            Object invoke = this.f43384c.invoke(objArr, this);
            obj = invoke;
            if (invoke == a2) {
                return a2;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.a(obj);
                return Unit.f42314a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.d;
            ResultKt.a(obj);
        }
        this.d = null;
        this.f43383a = 2;
        if (flowCollector.emit(obj, this) == a2) {
            return a2;
        }
        return Unit.f42314a;
    }
}
