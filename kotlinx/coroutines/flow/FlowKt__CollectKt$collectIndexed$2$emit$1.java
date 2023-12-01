package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2$emit$1.class */
public final class FlowKt__CollectKt$collectIndexed$2$emit$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ Object f43101a;
    final /* synthetic */ FlowKt__CollectKt$collectIndexed$2 b;

    /* renamed from: c  reason: collision with root package name */
    int f43102c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f43101a = obj;
        this.f43102c |= Integer.MIN_VALUE;
        return this.b.emit(null, this);
    }
}
