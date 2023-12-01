package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Limit.kt", c = {138}, d = "collectWhile", e = "kotlinx.coroutines.flow.FlowKt__LimitKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$1.class */
public final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43208a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f43209c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__LimitKt$collectWhile$1(Continuation<? super FlowKt__LimitKt$collectWhile$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.f43209c |= Integer.MIN_VALUE;
        return FlowKt__LimitKt.a((Flow) null, (Function2) null, this);
    }
}
