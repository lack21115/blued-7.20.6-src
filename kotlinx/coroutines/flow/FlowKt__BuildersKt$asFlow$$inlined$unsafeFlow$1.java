package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1.class */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function0 a;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object emit = flowCollector.emit((Object) this.a.invoke(), continuation);
        return emit == IntrinsicsKt.a() ? emit : Unit.a;
    }
}
