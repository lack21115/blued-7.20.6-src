package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/SafeCollectorKt$emitFun$1.class */
final /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements SuspendFunction, Function3<FlowCollector<? super Object>, Object, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final SafeCollectorKt$emitFun$1 f43504a = new SafeCollectorKt$emitFun$1();

    SafeCollectorKt$emitFun$1() {
        super(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object a(FlowCollector<Object> flowCollector, Object obj, Continuation<? super Unit> continuation) {
        return flowCollector.emit(obj, continuation);
    }
}
