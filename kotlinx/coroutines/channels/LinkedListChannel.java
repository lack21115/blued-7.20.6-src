package kotlinx.coroutines.channels;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/LinkedListChannel.class */
public class LinkedListChannel<E> extends AbstractChannel<E> {
    public LinkedListChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(E e) {
        ReceiveOrClosed<?> b;
        do {
            Object a = super.a((LinkedListChannel<E>) e);
            if (a == AbstractChannelKt.b) {
                return AbstractChannelKt.b;
            }
            if (a != AbstractChannelKt.c) {
                if (a instanceof Closed) {
                    return a;
                }
                throw new IllegalStateException(Intrinsics.a("Invalid offerInternal result ", a).toString());
            }
            b = b((LinkedListChannel<E>) e);
            if (b == null) {
                return AbstractChannelKt.b;
            }
        } while (!(b instanceof Closed));
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(E e, SelectInstance<?> selectInstance) {
        Symbol symbol;
        while (true) {
            if (d()) {
                symbol = super.a((LinkedListChannel<E>) e, selectInstance);
            } else {
                Object a = selectInstance.a(c(e));
                symbol = a;
                if (a == null) {
                    symbol = AbstractChannelKt.b;
                }
            }
            if (symbol == SelectKt.b()) {
                return SelectKt.b();
            }
            if (symbol == AbstractChannelKt.b) {
                return AbstractChannelKt.b;
            }
            if (symbol != AbstractChannelKt.c && symbol != AtomicKt.b) {
                if (symbol instanceof Closed) {
                    return symbol;
                }
                throw new IllegalStateException(Intrinsics.a("Invalid result ", symbol).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void a(Object obj, Closed<?> closed) {
        UndeliveredElementException undeliveredElementException;
        if (obj == null) {
            undeliveredElementException = null;
        } else if (!(obj instanceof ArrayList)) {
            Send send = (Send) obj;
            if (send instanceof AbstractSendChannel.SendBuffered) {
                Function1<E, Unit> function1 = this.B_;
                undeliveredElementException = function1 == null ? null : OnUndeliveredElementKt.a(function1, ((AbstractSendChannel.SendBuffered) send).a, (UndeliveredElementException) null);
            } else {
                send.a(closed);
                undeliveredElementException = null;
            }
        } else if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        } else {
            ArrayList arrayList = (ArrayList) obj;
            int size = arrayList.size() - 1;
            undeliveredElementException = null;
            if (size >= 0) {
                undeliveredElementException = null;
                while (true) {
                    int i = size - 1;
                    Send send2 = (Send) arrayList.get(size);
                    if (send2 instanceof AbstractSendChannel.SendBuffered) {
                        Function1<E, Unit> function12 = this.B_;
                        undeliveredElementException = function12 == null ? null : OnUndeliveredElementKt.a(function12, ((AbstractSendChannel.SendBuffered) send2).a, undeliveredElementException);
                    } else {
                        send2.a(closed);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean b() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean q() {
        return false;
    }
}
