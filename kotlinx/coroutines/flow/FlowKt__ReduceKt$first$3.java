package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Reduce.kt", c = {183}, d = "first", e = "kotlinx.coroutines.flow.FlowKt__ReduceKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ReduceKt$first$3.class */
public final class FlowKt__ReduceKt$first$3<T> extends ContinuationImpl {
    Object a;
    Object b;
    Object c;
    /* synthetic */ Object d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ReduceKt$first$3(Continuation<? super FlowKt__ReduceKt$first$3> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.e |= Integer.MIN_VALUE;
        return FlowKt.c(null, null, this);
    }
}
