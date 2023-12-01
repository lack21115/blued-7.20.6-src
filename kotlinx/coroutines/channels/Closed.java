package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/Closed.class */
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f42989a;

    public Closed(Throwable th) {
        this.f42989a = th;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Symbol a(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.f42786a;
        if (prepareOp == null) {
            return symbol;
        }
        prepareOp.a();
        return symbol;
    }

    @Override // kotlinx.coroutines.channels.Send
    public Symbol a(LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.f42786a;
        if (prepareOp == null) {
            return symbol;
        }
        prepareOp.a();
        return symbol;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void a(Closed<?> closed) {
        if (DebugKt.a()) {
            throw new AssertionError();
        }
    }

    @Override // kotlinx.coroutines.channels.Send
    public void b() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public void b(E e) {
    }

    public final Throwable d() {
        Throwable th = this.f42989a;
        ClosedSendChannelException closedSendChannelException = th;
        if (th == null) {
            closedSendChannelException = new ClosedSendChannelException("Channel was closed");
        }
        return closedSendChannelException;
    }

    public final Throwable e() {
        Throwable th = this.f42989a;
        ClosedReceiveChannelException closedReceiveChannelException = th;
        if (th == null) {
            closedReceiveChannelException = new ClosedReceiveChannelException("Channel was closed");
        }
        return closedReceiveChannelException;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    /* renamed from: f */
    public Closed<E> h() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.Send
    /* renamed from: g */
    public Closed<E> a() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "Closed@" + DebugStringsKt.a(this) + '[' + this.f42989a + ']';
    }
}
