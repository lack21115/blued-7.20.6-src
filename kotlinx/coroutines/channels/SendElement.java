package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/SendElement.class */
public class SendElement<E> extends Send {
    public final CancellableContinuation<Unit> a;
    private final E b;

    /* JADX WARN: Multi-variable type inference failed */
    public SendElement(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.b = e;
        this.a = cancellableContinuation;
    }

    @Override // kotlinx.coroutines.channels.Send
    public E a() {
        return this.b;
    }

    @Override // kotlinx.coroutines.channels.Send
    public Symbol a(LockFreeLinkedListNode.PrepareOp prepareOp) {
        Object a = this.a.a((CancellableContinuation<Unit>) Unit.a, prepareOp == null ? null : prepareOp.c);
        if (a == null) {
            return null;
        }
        if (DebugKt.a()) {
            if (!(a == CancellableContinuationImplKt.a)) {
                throw new AssertionError();
            }
        }
        if (prepareOp != null) {
            prepareOp.a();
        }
        return CancellableContinuationImplKt.a;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void a(Closed<?> closed) {
        CancellableContinuation<Unit> cancellableContinuation = this.a;
        Throwable d = closed.d();
        Result.Companion companion = Result.a;
        cancellableContinuation.resumeWith(Result.f(ResultKt.a(d)));
    }

    @Override // kotlinx.coroutines.channels.Send
    public void b() {
        this.a.a(CancellableContinuationImplKt.a);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return DebugStringsKt.b(this) + '@' + DebugStringsKt.a(this) + '(' + a() + ')';
    }
}
