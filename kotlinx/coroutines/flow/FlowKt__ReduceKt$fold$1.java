package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Reduce.kt", c = {173}, d = "fold", e = "kotlinx.coroutines.flow.FlowKt__ReduceKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ReduceKt$fold$1.class */
public final class FlowKt__ReduceKt$fold$1<T, R> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43265a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f43266c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ReduceKt$fold$1(Continuation<? super FlowKt__ReduceKt$fold$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.f43266c |= Integer.MIN_VALUE;
        return FlowKt__ReduceKt.a(null, null, null, this);
    }
}