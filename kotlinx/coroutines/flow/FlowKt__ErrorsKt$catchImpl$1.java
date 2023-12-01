package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Errors.kt", c = {227}, d = "catchImpl", e = "kotlinx.coroutines.flow.FlowKt__ErrorsKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ErrorsKt$catchImpl$1.class */
public final class FlowKt__ErrorsKt$catchImpl$1<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43175a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f43176c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ErrorsKt$catchImpl$1(Continuation<? super FlowKt__ErrorsKt$catchImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.f43176c |= Integer.MIN_VALUE;
        return FlowKt.a((Flow) null, (FlowCollector) null, this);
    }
}
