package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "StateFlow.kt", c = {336, 348, 353}, d = "collect", e = "kotlinx.coroutines.flow.StateFlowImpl")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/StateFlowImpl$collect$1.class */
public final class StateFlowImpl$collect$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43433a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    Object f43434c;
    Object d;
    Object e;
    /* synthetic */ Object f;
    final /* synthetic */ StateFlowImpl<T> g;
    int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateFlowImpl$collect$1(StateFlowImpl<T> stateFlowImpl, Continuation<? super StateFlowImpl$collect$1> continuation) {
        super(continuation);
        this.g = stateFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.a(null, this);
    }
}
