package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Limit.kt", c = {73}, d = "emitAbort$FlowKt__LimitKt", e = "kotlinx.coroutines.flow.FlowKt__LimitKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__LimitKt$emitAbort$1.class */
public final class FlowKt__LimitKt$emitAbort$1<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43213a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f43214c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__LimitKt$emitAbort$1(Continuation<? super FlowKt__LimitKt$emitAbort$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b;
        this.b = obj;
        this.f43214c |= Integer.MIN_VALUE;
        b = FlowKt__LimitKt.b(null, null, this);
        return b;
    }
}
