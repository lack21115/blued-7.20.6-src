package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Flow.kt", c = {212}, d = "collect", e = "kotlinx.coroutines.flow.AbstractFlow")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/AbstractFlow$collect$1.class */
public final class AbstractFlow$collect$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43043a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AbstractFlow<T> f43044c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractFlow$collect$1(AbstractFlow<T> abstractFlow, Continuation<? super AbstractFlow$collect$1> continuation) {
        super(continuation);
        this.f43044c = abstractFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.f43044c.a(null, this);
    }
}
