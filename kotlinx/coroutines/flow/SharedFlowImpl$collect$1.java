package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "SharedFlow.kt", c = {341, 348, 351}, d = "collect", e = "kotlinx.coroutines.flow.SharedFlowImpl")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharedFlowImpl$collect$1.class */
public final class SharedFlowImpl$collect$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43414a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    Object f43415c;
    Object d;
    /* synthetic */ Object e;
    final /* synthetic */ SharedFlowImpl<T> f;
    int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedFlowImpl$collect$1(SharedFlowImpl<T> sharedFlowImpl, Continuation<? super SharedFlowImpl$collect$1> continuation) {
        super(continuation);
        this.f = sharedFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(null, this);
    }
}
