package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Share.kt", c = {410, 414}, d = "onSubscription", e = "kotlinx.coroutines.flow.SubscribedFlowCollector")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SubscribedFlowCollector$onSubscription$1.class */
public final class SubscribedFlowCollector$onSubscription$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43438a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ Object f43439c;
    final /* synthetic */ SubscribedFlowCollector<T> d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscribedFlowCollector$onSubscription$1(SubscribedFlowCollector<T> subscribedFlowCollector, Continuation<? super SubscribedFlowCollector$onSubscription$1> continuation) {
        super(continuation);
        this.d = subscribedFlowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f43439c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(this);
    }
}
