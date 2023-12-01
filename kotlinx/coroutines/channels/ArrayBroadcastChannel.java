package kotlinx.coroutines.channels;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ArrayBroadcastChannel.class */
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private volatile /* synthetic */ long _head;
    private volatile /* synthetic */ int _size;
    private volatile /* synthetic */ long _tail;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final ReentrantLock f42890c;
    private final Object[] d;
    private final List<Subscriber<E>> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber.class */
    public static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        private volatile /* synthetic */ long _subHead;
        private final ArrayBroadcastChannel<E> b;

        /* renamed from: c  reason: collision with root package name */
        private final ReentrantLock f42891c;

        public Subscriber(ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            super(null);
            this.b = arrayBroadcastChannel;
            this.f42891c = new ReentrantLock();
            this._subHead = 0L;
        }

        private final Object A() {
            long x = x();
            Object s = this.b.s();
            if (x < this.b.d()) {
                Object c2 = this.b.c(x);
                Closed<?> s2 = s();
                return s2 != null ? s2 : c2;
            }
            Object obj = s;
            if (s == null) {
                Object s3 = s();
                obj = s3;
                if (s3 == null) {
                    obj = AbstractChannelKt.d;
                }
            }
            return obj;
        }

        private final boolean z() {
            if (s() != null) {
                return false;
            }
            return (b() && this.b.s() == null) ? false : true;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected Object a(SelectInstance<?> selectInstance) {
            Object obj;
            ReentrantLock reentrantLock = this.f42891c;
            reentrantLock.lock();
            try {
                Object A = A();
                boolean z = false;
                if (A instanceof Closed) {
                    obj = A;
                } else if (A == AbstractChannelKt.d) {
                    obj = A;
                } else if (selectInstance.g()) {
                    a(x() + 1);
                    z = true;
                    obj = A;
                } else {
                    obj = SelectKt.b();
                }
                reentrantLock.unlock();
                Closed closed = obj instanceof Closed ? (Closed) obj : null;
                if (closed != null) {
                    b_(closed.f42989a);
                }
                if (y()) {
                    z = true;
                }
                if (z) {
                    ArrayBroadcastChannel.a(this.b, null, null, 3, null);
                }
                return obj;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final void a(long j) {
            this._subHead = j;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected boolean a() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean b() {
            return x() >= this.b.d();
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
        public boolean b_(Throwable th) {
            boolean b_ = super.b_(th);
            if (b_) {
                ArrayBroadcastChannel.a(this.b, null, this, 1, null);
                ReentrantLock reentrantLock = this.f42891c;
                reentrantLock.lock();
                try {
                    a(this.b.d());
                    Unit unit = Unit.f42314a;
                    return b_;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return b_;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected java.lang.Object c() {
            /*
                r6 = this;
                r0 = r6
                java.util.concurrent.locks.ReentrantLock r0 = r0.f42891c
                java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
                r10 = r0
                r0 = r10
                r0.lock()
                r0 = r6
                java.lang.Object r0 = r0.A()     // Catch: java.lang.Throwable -> L88
                r11 = r0
                r0 = r11
                boolean r0 = r0 instanceof kotlinx.coroutines.channels.Closed     // Catch: java.lang.Throwable -> L88
                r9 = r0
                r0 = 1
                r8 = r0
                r0 = r9
                if (r0 == 0) goto L25
                goto L94
            L25:
                r0 = r11
                kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.AbstractChannelKt.d     // Catch: java.lang.Throwable -> L88
                if (r0 != r1) goto L30
                goto L94
            L30:
                r0 = r6
                r1 = r6
                long r1 = r1.x()     // Catch: java.lang.Throwable -> L88
                r2 = 1
                long r1 = r1 + r2
                r0.a(r1)     // Catch: java.lang.Throwable -> L88
                r0 = 1
                r7 = r0
            L3c:
                r0 = r10
                r0.unlock()
                r0 = r11
                boolean r0 = r0 instanceof kotlinx.coroutines.channels.Closed
                if (r0 == 0) goto L55
                r0 = r11
                kotlinx.coroutines.channels.Closed r0 = (kotlinx.coroutines.channels.Closed) r0
                r10 = r0
                goto L58
            L55:
                r0 = 0
                r10 = r0
            L58:
                r0 = r10
                if (r0 != 0) goto L60
                goto L6a
            L60:
                r0 = r6
                r1 = r10
                java.lang.Throwable r1 = r1.f42989a
                boolean r0 = r0.b_(r1)
            L6a:
                r0 = r6
                boolean r0 = r0.y()
                if (r0 == 0) goto L76
                r0 = r8
                r7 = r0
                goto L76
            L76:
                r0 = r7
                if (r0 == 0) goto L85
                r0 = r6
                kotlinx.coroutines.channels.ArrayBroadcastChannel<E> r0 = r0.b
                r1 = 0
                r2 = 0
                r3 = 3
                r4 = 0
                kotlinx.coroutines.channels.ArrayBroadcastChannel.a(r0, r1, r2, r3, r4)
            L85:
                r0 = r11
                return r0
            L88:
                r11 = move-exception
                r0 = r10
                r0.unlock()
                r0 = r11
                throw r0
            L94:
                r0 = 0
                r7 = r0
                goto L3c
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber.c():java.lang.Object");
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        protected boolean p() {
            throw new IllegalStateException("Should not be used".toString());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public boolean q() {
            throw new IllegalStateException("Should not be used".toString());
        }

        public final long x() {
            return this._subHead;
        }

        public final boolean y() {
            Closed closed;
            boolean z = false;
            while (true) {
                closed = null;
                if (!z()) {
                    break;
                } else if (!this.f42891c.tryLock()) {
                    closed = null;
                    break;
                } else {
                    try {
                        E e = (E) A();
                        if (e != AbstractChannelKt.d) {
                            if (e instanceof Closed) {
                                closed = (Closed) e;
                                break;
                            }
                            ReceiveOrClosed<E> l = l();
                            if (l == null) {
                                closed = null;
                                break;
                            } else if (l instanceof Closed) {
                                closed = null;
                                break;
                            } else {
                                Symbol a2 = l.a(e, null);
                                if (a2 != null) {
                                    if (DebugKt.a()) {
                                        if (!(a2 == CancellableContinuationImplKt.f42786a)) {
                                            throw new AssertionError();
                                        }
                                    }
                                    a(x() + 1);
                                    this.f42891c.unlock();
                                    l.b(e);
                                    z = true;
                                }
                            }
                        }
                    } finally {
                        this.f42891c.unlock();
                    }
                }
            }
            if (closed == null) {
                return z;
            }
            b_(closed.f42989a);
            return z;
        }
    }

    private final void a(int i) {
        this._size = i;
    }

    private final void a(long j) {
        this._head = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0137, code lost:
        throw new java.lang.AssertionError();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> r7, kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> r8) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.a(kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber, kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber):void");
    }

    static /* synthetic */ void a(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriber = null;
        }
        if ((i & 2) != 0) {
            subscriber2 = null;
        }
        arrayBroadcastChannel.a(subscriber, subscriber2);
    }

    private final boolean a(Throwable th) {
        boolean b_ = b_(th);
        for (Subscriber<E> subscriber : this.e) {
            subscriber.a(th);
        }
        return b_;
    }

    private final void b(long j) {
        this._tail = j;
    }

    private final long c() {
        return this._head;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E c(long j) {
        return (E) this.d[(int) (j % this.b)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long d() {
        return this._tail;
    }

    private final int e() {
        return this._size;
    }

    private final void f() {
        boolean z;
        Iterator<Subscriber<E>> it = this.e.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            z = z3;
            if (!it.hasNext()) {
                break;
            }
            if (it.next().y()) {
                z2 = true;
            }
            z3 = true;
        }
        if (z2 || !z) {
            a(this, null, null, 3, null);
        }
    }

    private final long g() {
        Iterator<Subscriber<E>> it = this.e.iterator();
        long j = Long.MAX_VALUE;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            j = RangesKt.b(j2, it.next().x());
        }
    }

    public final int a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(E e) {
        ReentrantLock reentrantLock = this.f42890c;
        reentrantLock.lock();
        try {
            Closed<?> r = r();
            if (r == null) {
                int e2 = e();
                if (e2 >= a()) {
                    return AbstractChannelKt.f42882c;
                }
                long d = d();
                this.d[(int) (d % a())] = e;
                a(e2 + 1);
                b(d + 1);
                Unit unit = Unit.f42314a;
                reentrantLock.unlock();
                f();
                return AbstractChannelKt.b;
            }
            return r;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object a(E e, SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.f42890c;
        reentrantLock.lock();
        try {
            Closed<?> r = r();
            if (r == null) {
                int e2 = e();
                if (e2 >= a()) {
                    return AbstractChannelKt.f42882c;
                }
                if (selectInstance.g()) {
                    long d = d();
                    this.d[(int) (d % a())] = e;
                    a(e2 + 1);
                    b(d + 1);
                    Unit unit = Unit.f42314a;
                    reentrantLock.unlock();
                    f();
                    return AbstractChannelKt.b;
                }
                return SelectKt.b();
            }
            return r;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void a(CancellationException cancellationException) {
        a((Throwable) cancellationException);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> az_() {
        Subscriber subscriber = new Subscriber(this);
        a(this, subscriber, null, 2, null);
        return subscriber;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public boolean b_(Throwable th) {
        if (super.b_(th)) {
            f();
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public boolean q() {
        return e() >= this.b;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String w() {
        return "(buffer:capacity=" + this.d.length + ",size=" + e() + ')';
    }
}
