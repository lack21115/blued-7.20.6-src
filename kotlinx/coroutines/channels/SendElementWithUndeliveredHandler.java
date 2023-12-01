package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/SendElementWithUndeliveredHandler.class */
public final class SendElementWithUndeliveredHandler<E> extends SendElement<E> {
    public final Function1<E, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public SendElementWithUndeliveredHandler(E e, CancellableContinuation<? super Unit> cancellableContinuation, Function1<? super E, Unit> function1) {
        super(e, cancellableContinuation);
        this.b = function1;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean aB_() {
        if (super.aB_()) {
            c();
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void c() {
        OnUndeliveredElementKt.a(this.b, a(), this.f43004a.getContext());
    }
}
