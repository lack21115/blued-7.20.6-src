package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Count.kt", c = {39}, d = "count", e = "kotlinx.coroutines.flow.FlowKt__CountKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CountKt$count$3.class */
public final class FlowKt__CountKt$count$3<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43116a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f43117c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__CountKt$count$3(Continuation<? super FlowKt__CountKt$count$3> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.f43117c |= Integer.MIN_VALUE;
        return FlowKt.b(null, null, this);
    }
}
