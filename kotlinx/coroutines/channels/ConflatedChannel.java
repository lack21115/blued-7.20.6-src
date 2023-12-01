package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ConflatedChannel.class */
public class ConflatedChannel<E> extends AbstractChannel<E> {
    private final ReentrantLock b;
    private Object c;

    public ConflatedChannel(Function1<? super E, Unit> function1) {
        super(function1);
        this.b = new ReentrantLock();
        this.c = AbstractChannelKt.a;
    }

    private final UndeliveredElementException f(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.c;
        UndeliveredElementException undeliveredElementException = null;
        if (obj2 != AbstractChannelKt.a && (function1 = this.B_) != null) {
            undeliveredElementException = OnUndeliveredElementKt.a(function1, obj2, null, 2, null);
        }
        this.c = obj;
        return undeliveredElementException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(E e) {
        ReceiveOrClosed<E> l;
        Symbol a;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            Closed<?> r = r();
            if (r == null) {
                if (this.c == AbstractChannelKt.a) {
                    do {
                        l = l();
                        if (l != null) {
                            if (l instanceof Closed) {
                                return l;
                            }
                            a = l.a(e, null);
                        }
                    } while (a == null);
                    if (DebugKt.a()) {
                        if (!(a == CancellableContinuationImplKt.a)) {
                            throw new AssertionError();
                        }
                    }
                    Unit unit = Unit.a;
                    reentrantLock.unlock();
                    l.b(e);
                    return l.h();
                }
                UndeliveredElementException f = f(e);
                if (f == null) {
                    return AbstractChannelKt.b;
                }
                throw f;
            }
            return r;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(E e, SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            Closed<?> r = r();
            if (r == null) {
                if (this.c == AbstractChannelKt.a) {
                    while (true) {
                        AbstractSendChannel.TryOfferDesc<E> e2 = e(e);
                        Object a = selectInstance.a(e2);
                        if (a == null) {
                            ReceiveOrClosed<? super E> d = e2.d();
                            Unit unit = Unit.a;
                            reentrantLock.unlock();
                            Intrinsics.a(d);
                            ReceiveOrClosed<? super E> receiveOrClosed = d;
                            receiveOrClosed.b(e);
                            return receiveOrClosed.h();
                        } else if (a == AbstractChannelKt.c) {
                            break;
                        } else if (a != AtomicKt.b) {
                            if (a != SelectKt.b() && !(a instanceof Closed)) {
                                throw new IllegalStateException(Intrinsics.a("performAtomicTrySelect(describeTryOffer) returned ", a).toString());
                            }
                            return a;
                        }
                    }
                }
                if (selectInstance.g()) {
                    UndeliveredElementException f = f(e);
                    if (f == null) {
                        return AbstractChannelKt.b;
                    }
                    throw f;
                }
                return SelectKt.b();
            }
            return r;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object a(SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            if (this.c == AbstractChannelKt.a) {
                Object r = r();
                Object obj = r;
                if (r == null) {
                    obj = AbstractChannelKt.d;
                }
                reentrantLock.unlock();
                return obj;
            } else if (selectInstance.g()) {
                Object obj2 = this.c;
                this.c = AbstractChannelKt.a;
                Unit unit = Unit.a;
                return obj2;
            } else {
                return SelectKt.b();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void a(boolean z) {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            UndeliveredElementException f = f(AbstractChannelKt.a);
            Unit unit = Unit.a;
            reentrantLock.unlock();
            super.a(z);
            if (f != null) {
                throw f;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean a(Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            return super.a((Receive) receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean b() {
        return this.c == AbstractChannelKt.a;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object c() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            if (this.c != AbstractChannelKt.a) {
                Object obj = this.c;
                this.c = AbstractChannelKt.a;
                Unit unit = Unit.a;
                return obj;
            }
            Object r = r();
            Object obj2 = r;
            if (r == null) {
                obj2 = AbstractChannelKt.d;
            }
            reentrantLock.unlock();
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
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

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String w() {
        return "(value=" + this.c + ')';
    }
}
