package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/ThrowingCollector.class */
public final class ThrowingCollector implements FlowCollector<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f43441a;

    public ThrowingCollector(Throwable th) {
        this.f43441a = th;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation<? super Unit> continuation) {
        throw this.f43441a;
    }
}
