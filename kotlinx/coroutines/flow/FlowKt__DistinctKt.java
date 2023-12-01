package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__DistinctKt.class */
public final /* synthetic */ class FlowKt__DistinctKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Function1<Object, Object> f43140a = new Function1<Object, Object>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return obj;
        }
    };
    private static final Function2<Object, Object, Boolean> b = new Function2<Object, Object, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
        public final boolean a(Object obj, Object obj2) {
            return Intrinsics.a(obj, obj2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(a(obj, obj2));
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> a(Flow<? extends T> flow) {
        return flow instanceof StateFlow ? flow : a(flow, f43140a, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Flow<T> a(Flow<? extends T> flow, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        if (flow instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) flow;
            if (distinctFlowImpl.f43049a == function1 && distinctFlowImpl.b == function2) {
                return flow;
            }
        }
        return new DistinctFlowImpl(flow, function1, function2);
    }
}
