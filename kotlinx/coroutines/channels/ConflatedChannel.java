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

    /* renamed from: c  reason: collision with root package name */
    private Object f42995c;

    public ConflatedChannel(Function1<? super E, Unit> function1) {
        super(function1);
        this.b = new ReentrantLock();
        this.f42995c = AbstractChannelKt.f42881a;
    }

    private final UndeliveredElementException f(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.f42995c;
        UndeliveredElementException undeliveredElementException = null;
        if (obj2 != AbstractChannelKt.f42881a && (function1 = this.B_) != null) {
            undeliveredElementException = OnUndeliveredElementKt.a(function1, obj2, null, 2, null);
        }
        this.f42995c = obj;
        return undeliveredElementException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(E e) {
        ReceiveOrClosed<E> l;
        Symbol a2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            Closed<?> r = r();
            if (r == null) {
                if (this.f42995c == AbstractChannelKt.f42881a) {
                    do {
                        l = l();
                        if (l != null) {
                            if (l instanceof Closed) {
                                return l;
                            }
                            a2 = l.a(e, null);
                        }
                    } while (a2 == null);
                    if (DebugKt.a()) {
                        if (!(a2 == CancellableContinuationImplKt.f42786a)) {
                            throw new AssertionError();
                        }
                    }
                    Unit unit = Unit.f42314a;
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
                if (this.f42995c == AbstractChannelKt.f42881a) {
                    while (true) {
                        AbstractSendChannel.TryOfferDesc<E> e2 = e(e);
                        Object a2 = selectInstance.a(e2);
                        if (a2 == null) {
                            ReceiveOrClosed<? super E> d = e2.d();
                            Unit unit = Unit.f42314a;
                            reentrantLock.unlock();
                            Intrinsics.a(d);
                            ReceiveOrClosed<? super E> receiveOrClosed = d;
                            receiveOrClosed.b(e);
                            return receiveOrClosed.h();
                        } else if (a2 == AbstractChannelKt.f42882c) {
                            break;
                        } else if (a2 != AtomicKt.b) {
                            if (a2 != SelectKt.b() && !(a2 instanceof Closed)) {
                                throw new IllegalStateException(Intrinsics.a("performAtomicTrySelect(describeTryOffer) returned ", a2).toString());
                            }
                            return a2;
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
            if (this.f42995c == AbstractChannelKt.f42881a) {
                Object r = r();
                Object obj = r;
                if (r == null) {
                    obj = AbstractChannelKt.d;
                }
                reentrantLock.unlock();
                return obj;
            } else if (selectInstance.g()) {
                Object obj2 = this.f42995c;
                this.f42995c = AbstractChannelKt.f42881a;
                Unit unit = Unit.f42314a;
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
            UndeliveredElementException f = f(AbstractChannelKt.f42881a);
            Unit unit = Unit.f42314a;
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
        return this.f42995c == AbstractChannelKt.f42881a;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object c() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            if (this.f42995c != AbstractChannelKt.f42881a) {
                Object obj = this.f42995c;
                this.f42995c = AbstractChannelKt.f42881a;
                Unit unit = Unit.f42314a;
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
        return "(value=" + this.f42995c + ')';
    }
}
