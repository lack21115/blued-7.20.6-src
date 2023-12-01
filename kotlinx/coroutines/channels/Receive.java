package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/Receive.class */
public abstract class Receive<E> extends LockFreeLinkedListNode implements ReceiveOrClosed<E> {
    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    /* renamed from: a */
    public Symbol h() {
        return AbstractChannelKt.b;
    }

    public abstract void a(Closed<?> closed);

    public Function1<Throwable, Unit> c(E e) {
        return null;
    }
}
