package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractSendChannel.class */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    protected final Function1<E, Unit> B_;
    private final LockFreeLinkedListHead b = new LockFreeLinkedListHead();
    private volatile /* synthetic */ Object onCloseHandler = null;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractSendChannel$SendBuffered.class */
    public static final class SendBuffered<E> extends Send {
        public final E a;

        public SendBuffered(E e) {
            this.a = e;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Object a() {
            return this.a;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Symbol a(LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol symbol = CancellableContinuationImplKt.a;
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

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendBuffered@" + DebugStringsKt.a(this) + '(' + this.a + ')';
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc.class */
    static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        public SendBufferedDesc(LockFreeLinkedListHead lockFreeLinkedListHead, E e) {
            super(lockFreeLinkedListHead, new SendBuffered(e));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                return AbstractChannelKt.c;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractSendChannel$SendSelect.class */
    public static final class SendSelect<E, R> extends Send implements DisposableHandle {
        public final AbstractSendChannel<E> a;
        public final SelectInstance<R> b;
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> c;
        private final E d;

        /* JADX WARN: Multi-variable type inference failed */
        public SendSelect(E e, AbstractSendChannel<E> abstractSendChannel, SelectInstance<? super R> selectInstance, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.d = e;
            this.a = abstractSendChannel;
            this.b = selectInstance;
            this.c = function2;
        }

        @Override // kotlinx.coroutines.channels.Send
        public E a() {
            return this.d;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Symbol a(LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.b.a(prepareOp);
        }

        @Override // kotlinx.coroutines.channels.Send
        public void a(Closed<?> closed) {
            if (this.b.g()) {
                this.b.a(closed.d());
            }
        }

        @Override // kotlinx.coroutines.channels.Send
        public void b() {
            CancellableKt.a(this.c, this.a, this.b.a(), null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.Send
        public void c() {
            Function1<E, Unit> function1 = this.a.B_;
            if (function1 == null) {
                return;
            }
            OnUndeliveredElementKt.a(function1, a(), this.b.a().getContext());
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (aB_()) {
                c();
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendSelect@" + DebugStringsKt.a(this) + '(' + a() + ")[" + this.a + ", " + this.b + ']';
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc.class */
    public static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        public final E a;

        public TryOfferDesc(E e, LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
            this.a = e;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object a(LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol a = ((ReceiveOrClosed) prepareOp.a).a(this.a, prepareOp);
            if (a == null) {
                return LockFreeLinkedList_commonKt.a;
            }
            if (a == AtomicKt.b) {
                return AtomicKt.b;
            }
            if (DebugKt.a()) {
                if (a == CancellableContinuationImplKt.a) {
                    return null;
                }
                throw new AssertionError();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                return null;
            }
            return AbstractChannelKt.c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractSendChannel(Function1<? super E, Unit> function1) {
        this.B_ = function1;
    }

    private final Throwable a(E e, Closed<?> closed) {
        UndeliveredElementException a;
        b(closed);
        Function1<E, Unit> function1 = this.B_;
        if (function1 == null || (a = OnUndeliveredElementKt.a(function1, e, null, 2, null)) == null) {
            return closed.d();
        }
        ExceptionsKt.a(a, closed.d());
        throw a;
    }

    private final Throwable a(Closed<?> closed) {
        b(closed);
        return closed.d();
    }

    private final void a(Throwable th) {
        Object obj = this.onCloseHandler;
        if (obj == null || obj == AbstractChannelKt.f || !c.compareAndSet(this, obj, AbstractChannelKt.f)) {
            return;
        }
        ((Function1) TypeIntrinsics.b(obj, 1)).invoke(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Continuation<?> continuation, E e, Closed<?> closed) {
        UndeliveredElementException a;
        b(closed);
        Throwable d = closed.d();
        Function1<E, Unit> function1 = this.B_;
        if (function1 == null || (a = OnUndeliveredElementKt.a(function1, e, null, 2, null)) == null) {
            Result.Companion companion = Result.a;
            continuation.resumeWith(Result.f(ResultKt.a(d)));
            return;
        }
        UndeliveredElementException undeliveredElementException = a;
        ExceptionsKt.a(undeliveredElementException, d);
        Result.Companion companion2 = Result.a;
        continuation.resumeWith(Result.f(ResultKt.a((Throwable) undeliveredElementException)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void a(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.f()) {
            if (a()) {
                SendSelect sendSelect = new SendSelect(e, this, selectInstance, function2);
                Object a = a((Send) sendSelect);
                if (a == null) {
                    selectInstance.a(sendSelect);
                    return;
                } else if (a instanceof Closed) {
                    throw StackTraceRecoveryKt.a(a((AbstractSendChannel<E>) e, (Closed) a));
                } else {
                    if (a != AbstractChannelKt.e && !(a instanceof Receive)) {
                        throw new IllegalStateException(("enqueueSend returned " + a + ' ').toString());
                    }
                }
            }
            Object a2 = a((AbstractSendChannel<E>) e, selectInstance);
            if (a2 == SelectKt.b()) {
                return;
            }
            if (a2 != AbstractChannelKt.c && a2 != AtomicKt.b) {
                if (a2 == AbstractChannelKt.b) {
                    UndispatchedKt.a((Function2<? super AbstractSendChannel<E>, ? super Continuation<? super T>, ? extends Object>) function2, this, (Continuation) selectInstance.a());
                    return;
                } else if (!(a2 instanceof Closed)) {
                    throw new IllegalStateException(Intrinsics.a("offerSelectInternal returned ", a2).toString());
                } else {
                    throw StackTraceRecoveryKt.a(a((AbstractSendChannel<E>) e, (Closed) a2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a() {
        return !(this.b.j() instanceof ReceiveOrClosed) && q();
    }

    private final Object b(E e, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl a = CancellableContinuationKt.a(IntrinsicsKt.a(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = a;
        while (true) {
            if (a()) {
                Function1<E, Unit> function1 = this.B_;
                Object sendElement = function1 == null ? new SendElement(e, cancellableContinuationImpl) : (SendElement) new SendElementWithUndeliveredHandler(e, cancellableContinuationImpl, function1);
                Object a2 = a((Send) ((Send) sendElement));
                if (a2 == null) {
                    CancellableContinuationKt.a(cancellableContinuationImpl, (LockFreeLinkedListNode) sendElement);
                    break;
                } else if (a2 instanceof Closed) {
                    a((Continuation<?>) cancellableContinuationImpl, (CancellableContinuationImpl) e, (Closed<?>) a2);
                    break;
                } else if (a2 != AbstractChannelKt.e && !(a2 instanceof Receive)) {
                    throw new IllegalStateException(Intrinsics.a("enqueueSend returned ", a2).toString());
                }
            }
            Object a3 = a((AbstractSendChannel<E>) e);
            if (a3 == AbstractChannelKt.b) {
                CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                Unit unit = Unit.a;
                Result.Companion companion = Result.a;
                cancellableContinuationImpl2.resumeWith(Result.f(unit));
                break;
            } else if (a3 != AbstractChannelKt.c) {
                if (!(a3 instanceof Closed)) {
                    throw new IllegalStateException(Intrinsics.a("offerInternal returned ", a3).toString());
                }
                a((Continuation<?>) cancellableContinuationImpl, (CancellableContinuationImpl) e, (Closed<?>) a3);
            }
        }
        Object h = a.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h == IntrinsicsKt.a() ? h : Unit.a;
    }

    private final String b() {
        LockFreeLinkedListNode j = this.b.j();
        if (j == this.b) {
            return "EmptyQueue";
        }
        String lockFreeLinkedListNode = j instanceof Closed ? j.toString() : j instanceof Receive ? "ReceiveQueued" : j instanceof Send ? "SendQueued" : Intrinsics.a("UNEXPECTED:", (Object) j);
        LockFreeLinkedListNode k = this.b.k();
        String str = lockFreeLinkedListNode;
        if (k != j) {
            String str2 = lockFreeLinkedListNode + ",queueSize=" + c();
            str = str2;
            if (k instanceof Closed) {
                str = str2 + ",closedForSend=" + k;
            }
        }
        return str;
    }

    private final void b(Closed<?> closed) {
        Object a = InlineList.a(null, 1, null);
        while (true) {
            LockFreeLinkedListNode k = closed.k();
            Receive receive = k instanceof Receive ? (Receive) k : null;
            if (receive == null) {
                break;
            } else if (receive.aB_()) {
                a = InlineList.a(a, receive);
            } else {
                receive.m();
            }
        }
        if (a != null) {
            if (!(a instanceof ArrayList)) {
                ((Receive) a).a(closed);
            } else if (a == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            } else {
                ArrayList arrayList = (ArrayList) a;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i = size - 1;
                        ((Receive) arrayList.get(size)).a(closed);
                        if (i < 0) {
                            break;
                        }
                        size = i;
                    }
                }
            }
        }
        a((LockFreeLinkedListNode) closed);
    }

    private final int c() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.b;
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.i();
        int i = 0;
        while (true) {
            int i2 = i;
            if (Intrinsics.a(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                return i2;
            }
            int i3 = i2;
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                i3 = i2 + 1;
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.j();
            i = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object a(E e) {
        ReceiveOrClosed<E> l;
        Symbol a;
        do {
            l = l();
            if (l == null) {
                return AbstractChannelKt.c;
            }
            a = l.a(e, null);
        } while (a == null);
        if (DebugKt.a()) {
            if (!(a == CancellableContinuationImplKt.a)) {
                throw new AssertionError();
            }
        }
        l.b(e);
        return l.h();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object a(E e, Continuation<? super Unit> continuation) {
        Object b;
        if (a((AbstractSendChannel<E>) e) != AbstractChannelKt.b && (b = b(e, continuation)) == IntrinsicsKt.a()) {
            return b;
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object a(E e, SelectInstance<?> selectInstance) {
        TryOfferDesc<E> e2 = e(e);
        Object a = selectInstance.a(e2);
        if (a != null) {
            return a;
        }
        ReceiveOrClosed<? super E> d = e2.d();
        d.b(e);
        return d.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
        if (r7 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0084, code lost:
        return kotlinx.coroutines.channels.AbstractChannelKt.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlinx.coroutines.channels.Send r6) {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.p()
            if (r0 == 0) goto L33
            r0 = r5
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r0.b
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r9 = r0
        L10:
            r0 = r9
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = r0.k()
            r10 = r0
            r0 = r10
            boolean r0 = r0 instanceof kotlinx.coroutines.channels.ReceiveOrClosed
            if (r0 == 0) goto L22
            r0 = r10
            return r0
        L22:
            r0 = r10
            r1 = r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = r9
            boolean r0 = r0.a(r1, r2)
            if (r0 == 0) goto L10
            goto L85
        L33:
            r0 = r5
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r0.b
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r9 = r0
            r0 = r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r6 = r0
            kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 r0 = new kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1
            r1 = r0
            r2 = r6
            r3 = r5
            r1.<init>(r3)
            kotlinx.coroutines.internal.LockFreeLinkedListNode$CondAddOp r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp) r0
            r10 = r0
        L4f:
            r0 = r9
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = r0.k()
            r11 = r0
            r0 = r11
            boolean r0 = r0 instanceof kotlinx.coroutines.channels.ReceiveOrClosed
            if (r0 == 0) goto L61
            r0 = r11
            return r0
        L61:
            r0 = r11
            r1 = r6
            r2 = r9
            r3 = r10
            int r0 = r0.a(r1, r2, r3)
            r8 = r0
            r0 = 1
            r7 = r0
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L7d
            r0 = r8
            r1 = 2
            if (r0 == r1) goto L7b
            goto L4f
        L7b:
            r0 = 0
            r7 = r0
        L7d:
            r0 = r7
            if (r0 != 0) goto L85
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.AbstractChannelKt.e
            return r0
        L85:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractSendChannel.a(kotlinx.coroutines.channels.Send):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void a(Function1<? super Throwable, Unit> function1) {
        if (!c.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj != AbstractChannelKt.f) {
                throw new IllegalStateException(Intrinsics.a("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        Closed<?> r = r();
        if (r == null || !c.compareAndSet(this, function1, AbstractChannelKt.f)) {
            return;
        }
        function1.invoke(r.a);
    }

    protected void a(LockFreeLinkedListNode lockFreeLinkedListNode) {
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object a_(E e) {
        Object a = a((AbstractSendChannel<E>) e);
        if (a == AbstractChannelKt.b) {
            return ChannelResult.a.a((ChannelResult.Companion) Unit.a);
        }
        if (a == AbstractChannelKt.c) {
            Closed<?> r = r();
            return r == null ? ChannelResult.a.a() : ChannelResult.a.a(a(r));
        } else if (a instanceof Closed) {
            return ChannelResult.a.a(a((Closed) a));
        } else {
            throw new IllegalStateException(Intrinsics.a("trySend returned ", a).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ReceiveOrClosed<?> b(E e) {
        LockFreeLinkedListNode k;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.b;
        SendBuffered sendBuffered = new SendBuffered(e);
        do {
            k = lockFreeLinkedListHead.k();
            if (k instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) k;
            }
        } while (!k.a(sendBuffered, lockFreeLinkedListHead));
        return null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean b_(Throwable th) {
        boolean z;
        Closed<?> closed = new Closed<>(th);
        LockFreeLinkedListHead lockFreeLinkedListHead = this.b;
        while (true) {
            LockFreeLinkedListNode k = lockFreeLinkedListHead.k();
            z = true;
            if (!(!(k instanceof Closed))) {
                z = false;
                break;
            } else if (k.a(closed, lockFreeLinkedListHead)) {
                break;
            }
        }
        if (!z) {
            closed = (Closed) this.b.k();
        }
        b(closed);
        if (z) {
            a(th);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LockFreeLinkedListNode.AddLastDesc<?> c(E e) {
        return new SendBufferedDesc(this.b, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TryOfferDesc<E> e(E e) {
        return new TryOfferDesc<>(e, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    public ReceiveOrClosed<E> l() {
        LockFreeLinkedListHead lockFreeLinkedListHead;
        LockFreeLinkedListNode l;
        LockFreeLinkedListHead lockFreeLinkedListHead2 = this.b;
        while (true) {
            lockFreeLinkedListHead = (LockFreeLinkedListNode) lockFreeLinkedListHead2.i();
            if (lockFreeLinkedListHead != lockFreeLinkedListHead2 && (lockFreeLinkedListHead instanceof ReceiveOrClosed)) {
                if (((((ReceiveOrClosed) lockFreeLinkedListHead) instanceof Closed) && !lockFreeLinkedListHead.aA_()) || (l = lockFreeLinkedListHead.l()) == null) {
                    break;
                }
                l.n();
            }
        }
        lockFreeLinkedListHead = null;
        return (ReceiveOrClosed) lockFreeLinkedListHead;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LockFreeLinkedListHead o() {
        return this.b;
    }

    protected abstract boolean p();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean q();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Closed<?> r() {
        LockFreeLinkedListNode k = this.b.k();
        Closed<?> closed = k instanceof Closed ? (Closed) k : null;
        if (closed == null) {
            return null;
        }
        b(closed);
        return closed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Closed<?> s() {
        LockFreeLinkedListNode j = this.b.j();
        Closed<?> closed = j instanceof Closed ? (Closed) j : null;
        if (closed == null) {
            return null;
        }
        b(closed);
        return closed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    public final Send t() {
        Send send;
        LockFreeLinkedListNode l;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.b;
        while (true) {
            send = (LockFreeLinkedListNode) lockFreeLinkedListHead.i();
            if (send != lockFreeLinkedListHead && (send instanceof Send)) {
                if (((send instanceof Closed) && !send.aA_()) || (l = send.l()) == null) {
                    break;
                }
                l.n();
            }
        }
        send = null;
        return send;
    }

    public String toString() {
        return DebugStringsKt.b(this) + '@' + DebugStringsKt.a(this) + '{' + b() + '}' + w();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean u() {
        return r() != null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2<E, SendChannel<E>> v() {
        return (SelectClause2) ((SelectClause2<E, SendChannel<? super E>>) new SelectClause2<E, SendChannel<? super E>>(this) { // from class: kotlinx.coroutines.channels.AbstractSendChannel$onSend$1
            final /* synthetic */ AbstractSendChannel<E> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause2
            public <R> void a(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
                this.a.a(selectInstance, (SelectInstance) e, (Function2<? super SendChannel<? super SelectInstance>, ? super Continuation<? super R>, ? extends Object>) function2);
            }
        });
    }

    protected String w() {
        return "";
    }
}
