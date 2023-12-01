package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/SendingCollector.class */
public final class SendingCollector<T> implements FlowCollector<T> {

    /* renamed from: a  reason: collision with root package name */
    private final SendChannel<T> f43509a;

    /* JADX WARN: Multi-variable type inference failed */
    public SendingCollector(SendChannel<? super T> sendChannel) {
        this.f43509a = sendChannel;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object a2 = this.f43509a.a(t, continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
