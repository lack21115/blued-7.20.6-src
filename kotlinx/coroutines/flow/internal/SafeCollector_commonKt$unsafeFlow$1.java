package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1.class */
public final class SafeCollector_commonKt$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> a;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object invoke = this.a.invoke(flowCollector, continuation);
        return invoke == IntrinsicsKt.a() ? invoke : Unit.a;
    }
}
