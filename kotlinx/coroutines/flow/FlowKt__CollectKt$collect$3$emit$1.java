package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1.class */
public final class FlowKt__CollectKt$collect$3$emit$1 extends ContinuationImpl {
    /* synthetic */ Object a;
    final /* synthetic */ FlowKt__CollectKt$collect$3 b;
    int c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.emit(null, this);
    }
}
