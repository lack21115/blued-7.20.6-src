package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ArrayChannel.class */
public class ArrayChannel<E> extends AbstractChannel<E> {
    private final int b;
    private final BufferOverflow c;
    private final ReentrantLock d;
    private Object[] e;
    private int f;
    private volatile /* synthetic */ int size;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ArrayChannel$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BufferOverflow.valuesCustom().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            a = iArr;
        }
    }

    public ArrayChannel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(function1);
        this.b = i;
        this.c = bufferOverflow;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + this.b + " was specified").toString());
        }
        this.d = new ReentrantLock();
        Object[] objArr = new Object[Math.min(this.b, 8)];
        ArraysKt.a(objArr, AbstractChannelKt.a, 0, 0, 6, null);
        Unit unit = Unit.a;
        this.e = objArr;
        this.size = 0;
    }

    private final Symbol a(int i) {
        if (i < this.b) {
            this.size = i + 1;
            return null;
        }
        int i2 = WhenMappings.a[this.c.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return AbstractChannelKt.b;
        }
        return AbstractChannelKt.c;
    }

    private final void a(int i, E e) {
        if (i < this.b) {
            b(i);
            Object[] objArr = this.e;
            objArr[(this.f + i) % objArr.length] = e;
            return;
        }
        if (DebugKt.a()) {
            if (!(this.c == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.e;
        int i2 = this.f;
        objArr2[i2 % objArr2.length] = null;
        objArr2[(i + i2) % objArr2.length] = e;
        this.f = (i2 + 1) % objArr2.length;
    }

    private final void b(int i) {
        Object[] objArr = this.e;
        if (i >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.b);
            Object[] objArr2 = new Object[min];
            if (i > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    int i4 = i3 + 1;
                    Object[] objArr3 = this.e;
                    objArr2[i3] = objArr3[(this.f + i3) % objArr3.length];
                    if (i4 >= i) {
                        break;
                    }
                    i2 = i4;
                }
            }
            ArraysKt.a((Symbol[]) objArr2, AbstractChannelKt.a, i, min);
            this.e = objArr2;
            this.f = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(E e) {
        ReceiveOrClosed<E> l;
        Symbol a;
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            int i = this.size;
            Closed<?> r = r();
            if (r == null) {
                Symbol a2 = a(i);
                if (a2 == null) {
                    if (i == 0) {
                        do {
                            l = l();
                            if (l != null) {
                                if (l instanceof Closed) {
                                    this.size = i;
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
                        this.size = i;
                        Unit unit = Unit.a;
                        reentrantLock.unlock();
                        l.b(e);
                        return l.h();
                    }
                    a(i, (int) e);
                    return AbstractChannelKt.b;
                }
                return a2;
            }
            return r;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(E e, SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            int i = this.size;
            Closed<?> r = r();
            if (r == null) {
                Symbol a = a(i);
                if (a == null) {
                    if (i == 0) {
                        while (true) {
                            AbstractSendChannel.TryOfferDesc<E> e2 = e(e);
                            Object a2 = selectInstance.a(e2);
                            if (a2 == null) {
                                this.size = i;
                                ReceiveOrClosed<? super E> d = e2.d();
                                Unit unit = Unit.a;
                                reentrantLock.unlock();
                                Intrinsics.a(d);
                                ReceiveOrClosed<? super E> receiveOrClosed = d;
                                receiveOrClosed.b(e);
                                return receiveOrClosed.h();
                            } else if (a2 == AbstractChannelKt.c) {
                                break;
                            } else if (a2 != AtomicKt.b) {
                                if (a2 != SelectKt.b() && !(a2 instanceof Closed)) {
                                    throw new IllegalStateException(Intrinsics.a("performAtomicTrySelect(describeTryOffer) returned ", a2).toString());
                                }
                                this.size = i;
                                return a2;
                            }
                        }
                    }
                    if (selectInstance.g()) {
                        a(i, (int) e);
                        return AbstractChannelKt.b;
                    }
                    this.size = i;
                    return SelectKt.b();
                }
                return a;
            }
            return r;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(Send send) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return super.a(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0181, code lost:
        r7 = true;
     */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object a(kotlinx.coroutines.selects.SelectInstance<?> r6) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.a(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void a(boolean z) {
        Function1<E, Unit> function1 = this.B_;
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementException = null;
            int i2 = 0;
            while (i2 < i) {
                Object obj = this.e[this.f];
                UndeliveredElementException undeliveredElementException2 = undeliveredElementException;
                if (function1 != null) {
                    undeliveredElementException2 = undeliveredElementException;
                    if (obj != AbstractChannelKt.a) {
                        undeliveredElementException2 = OnUndeliveredElementKt.a((Function1<? super Object, Unit>) function1, obj, undeliveredElementException);
                    }
                }
                this.e[this.f] = AbstractChannelKt.a;
                this.f = (this.f + 1) % this.e.length;
                i2++;
                undeliveredElementException = undeliveredElementException2;
            }
            this.size = 0;
            Unit unit = Unit.a;
            reentrantLock.unlock();
            super.a(z);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
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
        ReentrantLock reentrantLock = this.d;
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
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object c() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object r = r();
                Object obj = r;
                if (r == null) {
                    obj = AbstractChannelKt.d;
                }
                reentrantLock.unlock();
                return obj;
            }
            Object obj2 = this.e[this.f];
            Send send = null;
            this.e[this.f] = null;
            this.size = i - 1;
            Symbol symbol = AbstractChannelKt.d;
            Symbol symbol2 = symbol;
            boolean z = false;
            if (i == this.b) {
                Send send2 = null;
                while (true) {
                    send = send2;
                    Send t = t();
                    if (t == null) {
                        symbol2 = symbol;
                        z = false;
                        break;
                    }
                    Symbol a = t.a((LockFreeLinkedListNode.PrepareOp) null);
                    if (a != null) {
                        if (DebugKt.a()) {
                            boolean z2 = false;
                            if (a == CancellableContinuationImplKt.a) {
                                z2 = true;
                            }
                            if (!z2) {
                                throw new AssertionError();
                            }
                        }
                        send = t;
                        z = true;
                        symbol2 = t.a();
                    } else {
                        t.c();
                        send2 = t;
                    }
                }
            }
            if (symbol2 != AbstractChannelKt.d && !(symbol2 instanceof Closed)) {
                this.size = i;
                this.e[(this.f + i) % this.e.length] = symbol2;
            }
            this.f = (this.f + 1) % this.e.length;
            Unit unit = Unit.a;
            reentrantLock.unlock();
            if (z) {
                Intrinsics.a(send);
                send.b();
            }
            return obj2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean e() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return super.e();
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
        return this.size == this.b && this.c == BufferOverflow.SUSPEND;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String w() {
        return "(buffer:capacity=" + this.b + ",size=" + this.size + ')';
    }
}
