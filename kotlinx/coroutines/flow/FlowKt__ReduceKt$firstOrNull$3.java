package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Reduce.kt", c = {183}, d = "firstOrNull", e = "kotlinx.coroutines.flow.FlowKt__ReduceKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ReduceKt$firstOrNull$3.class */
public final class FlowKt__ReduceKt$firstOrNull$3<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43263a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ Object f43264c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ReduceKt$firstOrNull$3(Continuation<? super FlowKt__ReduceKt$firstOrNull$3> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f43264c = obj;
        this.d |= Integer.MIN_VALUE;
        return FlowKt.d(null, null, this);
    }
}
