package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Builders.kt", c = {355}, d = "collectTo", e = "kotlinx.coroutines.flow.CallbackFlowBuilder")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/CallbackFlowBuilder$collectTo$1.class */
public final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43045a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ CallbackFlowBuilder<T> f43046c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder<T> callbackFlowBuilder, Continuation<? super CallbackFlowBuilder$collectTo$1> continuation) {
        super(continuation);
        this.f43046c = callbackFlowBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.f43046c.a((ProducerScope) null, this);
    }
}
