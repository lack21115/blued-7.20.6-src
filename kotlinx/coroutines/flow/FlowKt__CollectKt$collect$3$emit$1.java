package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1.class */
public final class FlowKt__CollectKt$collect$3$emit$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ Object f43098a;
    final /* synthetic */ FlowKt__CollectKt$collect$3 b;

    /* renamed from: c  reason: collision with root package name */
    int f43099c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f43098a = obj;
        this.f43099c |= Integer.MIN_VALUE;
        return this.b.emit(null, this);
    }
}
