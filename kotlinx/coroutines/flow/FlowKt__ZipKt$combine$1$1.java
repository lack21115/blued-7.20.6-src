package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
@DebugMetadata(b = "Zip.kt", c = {33, 33}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combine$1$1.class */
final class FlowKt__ZipKt$combine$1$1<R> extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43380a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> f43381c;
    private /* synthetic */ Object d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$1$1(Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combine$1$1> continuation) {
        super(3, continuation);
        this.f43381c = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object a(Object obj, Object[] objArr, Continuation<? super Unit> continuation) {
        return a((FlowCollector) ((FlowCollector) obj), objArr, continuation);
    }

    public final Object a(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super Unit> continuation) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.f43381c, continuation);
        flowKt__ZipKt$combine$1$1.d = flowCollector;
        flowKt__ZipKt$combine$1$1.b = objArr;
        return flowKt__ZipKt$combine$1$1.invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object a2 = IntrinsicsKt.a();
        int i = this.f43380a;
        if (i == 0) {
            ResultKt.a(obj);
            flowCollector = (FlowCollector) this.d;
            Object[] objArr = (Object[]) this.b;
            Function3<T1, T2, Continuation<? super R>, Object> function3 = this.f43381c;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            this.d = flowCollector;
            this.f43380a = 1;
            Object a3 = function3.a(obj2, obj3, this);
            obj = a3;
            if (a3 == a2) {
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
        this.f43380a = 2;
        if (flowCollector.emit(obj, this) == a2) {
            return a2;
        }
        return Unit.f42314a;
    }
}
