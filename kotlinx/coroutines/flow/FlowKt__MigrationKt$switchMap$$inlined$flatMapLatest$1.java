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
@DebugMetadata(b = "Migration.kt", c = {193, 193}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.class */
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> {
    int a;
    /* synthetic */ Object b;
    final /* synthetic */ Function2 c;
    private /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.c = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2, Continuation<? super Unit> continuation) {
        return a((FlowCollector) ((FlowCollector) obj), (FlowCollector<? super R>) obj2, continuation);
    }

    public final Object a(FlowCollector<? super R> flowCollector, T t, Continuation<? super Unit> continuation) {
        FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 = new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(this.c, continuation);
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.d = flowCollector;
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.b = t;
        return flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object a = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            flowCollector = (FlowCollector) this.d;
            Object obj2 = this.b;
            Function2 function2 = this.c;
            this.d = flowCollector;
            this.a = 1;
            Object invoke = function2.invoke(obj2, this);
            obj = invoke;
            if (invoke == a) {
                return a;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.a(obj);
                return Unit.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.d;
            ResultKt.a(obj);
        }
        this.d = null;
        this.a = 2;
        if (FlowKt.a(flowCollector, (Flow) obj, this) == a) {
            return a;
        }
        return Unit.a;
    }
}
