package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
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
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel.class */
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$Itr.class */
    public static final class Itr<E> implements ChannelIterator<E> {
        public final AbstractChannel<E> a;
        private Object b = AbstractChannelKt.d;

        public Itr(AbstractChannel<E> abstractChannel) {
            this.a = abstractChannel;
        }

        private final boolean a(Object obj) {
            if (obj instanceof Closed) {
                Closed closed = (Closed) obj;
                if (closed.a == null) {
                    return false;
                }
                throw StackTraceRecoveryKt.a(closed.e());
            }
            return true;
        }

        private final Object b(Continuation<? super Boolean> continuation) {
            CancellableContinuationImpl a = CancellableContinuationKt.a(IntrinsicsKt.a(continuation));
            CancellableContinuationImpl cancellableContinuationImpl = a;
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, cancellableContinuationImpl);
            while (true) {
                ReceiveHasNext receiveHasNext2 = receiveHasNext;
                if (this.a.b((Receive) receiveHasNext2)) {
                    this.a.a(cancellableContinuationImpl, receiveHasNext2);
                    break;
                }
                Object c = this.a.c();
                setResult(c);
                if (c instanceof Closed) {
                    Closed closed = (Closed) c;
                    if (closed.a == null) {
                        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                        Boolean a2 = Boxing.a(false);
                        Result.Companion companion = Result.a;
                        cancellableContinuationImpl2.resumeWith(Result.f(a2));
                    } else {
                        CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl;
                        Throwable e = closed.e();
                        Result.Companion companion2 = Result.a;
                        cancellableContinuationImpl3.resumeWith(Result.f(ResultKt.a(e)));
                    }
                } else if (c != AbstractChannelKt.d) {
                    Boolean a3 = Boxing.a(true);
                    Function1<E, Unit> function1 = this.a.B_;
                    cancellableContinuationImpl.a((CancellableContinuationImpl) a3, (Function1<? super Throwable, Unit>) (function1 == null ? null : OnUndeliveredElementKt.b(function1, c, cancellableContinuationImpl.getContext())));
                }
            }
            Object h = a.h();
            if (h == IntrinsicsKt.a()) {
                DebugProbesKt.c(continuation);
            }
            return h;
        }

        public final Object a() {
            return this.b;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object a(Continuation<? super Boolean> continuation) {
            if (a() != AbstractChannelKt.d) {
                return Boxing.a(a(a()));
            }
            setResult(this.a.c());
            return a() != AbstractChannelKt.d ? Boxing.a(a(a())) : b(continuation);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E b() {
            E e = (E) this.b;
            if (e instanceof Closed) {
                throw StackTraceRecoveryKt.a(((Closed) e).e());
            }
            if (e != AbstractChannelKt.d) {
                this.b = AbstractChannelKt.d;
                return e;
            }
            throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
        }

        public final void setResult(Object obj) {
            this.b = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$ReceiveElement.class */
    public static class ReceiveElement<E> extends Receive<E> {
        public final CancellableContinuation<Object> a;
        public final int b;

        public ReceiveElement(CancellableContinuation<Object> cancellableContinuation, int i) {
            this.a = cancellableContinuation;
            this.b = i;
        }

        public final Object a(E e) {
            Object obj = e;
            if (this.b == 1) {
                obj = ChannelResult.h(ChannelResult.a.a((ChannelResult.Companion) e));
            }
            return obj;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol a(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
            Object a = this.a.a(a((ReceiveElement<E>) e), prepareOp == null ? null : prepareOp.c, c((ReceiveElement<E>) e));
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

        @Override // kotlinx.coroutines.channels.Receive
        public void a(Closed<?> closed) {
            if (this.b == 1) {
                CancellableContinuation<Object> cancellableContinuation = this.a;
                ChannelResult h = ChannelResult.h(ChannelResult.a.a(closed.a));
                Result.Companion companion = Result.a;
                cancellableContinuation.resumeWith(Result.f(h));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation2 = this.a;
            Throwable e = closed.e();
            Result.Companion companion2 = Result.a;
            cancellableContinuation2.resumeWith(Result.f(ResultKt.a(e)));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void b(E e) {
            this.a.a(CancellableContinuationImplKt.a);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveElement@" + DebugStringsKt.a(this) + "[receiveMode=" + this.b + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler.class */
    public static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {
        public final Function1<E, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElementWithUndeliveredHandler(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.c = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> c(E e) {
            return OnUndeliveredElementKt.b(this.c, e, this.a.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext.class */
    public static class ReceiveHasNext<E> extends Receive<E> {
        public final Itr<E> a;
        public final CancellableContinuation<Boolean> b;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(Itr<E> itr, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.a = itr;
            this.b = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol a(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
            boolean z = true;
            Object a = this.b.a(true, prepareOp == null ? null : prepareOp.c, c((ReceiveHasNext<E>) e));
            if (a == null) {
                return null;
            }
            if (DebugKt.a()) {
                if (a != CancellableContinuationImplKt.a) {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if (prepareOp != null) {
                prepareOp.a();
            }
            return CancellableContinuationImplKt.a;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void a(Closed<?> closed) {
            Object a = closed.a == null ? CancellableContinuation.DefaultImpls.a(this.b, false, null, 2, null) : this.b.a(closed.e());
            if (a != null) {
                this.a.setResult(closed);
                this.b.a(a);
            }
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void b(E e) {
            this.a.setResult(e);
            this.b.a(CancellableContinuationImplKt.a);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> c(E e) {
            Function1<E, Unit> function1 = this.a.a.B_;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.b(function1, e, this.b.getContext());
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return Intrinsics.a("ReceiveHasNext@", (Object) DebugStringsKt.a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$ReceiveSelect.class */
    public static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
        public final AbstractChannel<E> a;
        public final SelectInstance<R> b;
        public final Function2<Object, Continuation<? super R>, Object> c;
        public final int d;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(AbstractChannel<E> abstractChannel, SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
            this.a = abstractChannel;
            this.b = selectInstance;
            this.c = function2;
            this.d = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol a(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.b.a(prepareOp);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void a(Closed<?> closed) {
            if (this.b.g()) {
                int i = this.d;
                if (i == 0) {
                    this.b.a(closed.e());
                } else if (i != 1) {
                } else {
                    CancellableKt.a(this.c, ChannelResult.h(ChannelResult.a.a(closed.a)), this.b.a(), null, 4, null);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [kotlinx.coroutines.channels.ChannelResult] */
        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void b(E e) {
            CancellableKt.a(this.c, this.d == 1 ? ChannelResult.h(ChannelResult.a.a((ChannelResult.Companion) e)) : e, this.b.a(), c((ReceiveSelect<R, E>) e));
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> c(E e) {
            Function1<E, Unit> function1 = this.a.B_;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.b(function1, e, this.b.a().getContext());
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (aB_()) {
                this.a.n();
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveSelect@" + DebugStringsKt.a(this) + '[' + this.b + ",receiveMode=" + this.d + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel.class */
    public final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {
        private final Receive<?> b;

        public RemoveReceiveOnCancel(Receive<?> receive) {
            this.b = receive;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        public void a(Throwable th) {
            if (this.b.aB_()) {
                AbstractChannel.this.n();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.b + ']';
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$TryPollDesc.class */
    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public TryPollDesc(LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object a(LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol a = ((Send) prepareOp.a).a(prepareOp);
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
            if (lockFreeLinkedListNode instanceof Send) {
                return null;
            }
            return AbstractChannelKt.d;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void b(LockFreeLinkedListNode lockFreeLinkedListNode) {
            ((Send) lockFreeLinkedListNode).c();
        }
    }

    public AbstractChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [kotlinx.coroutines.channels.AbstractChannel$ReceiveElement] */
    private final <R> Object a(int i, Continuation<? super R> continuation) {
        CancellableContinuationImpl a = CancellableContinuationKt.a(IntrinsicsKt.a(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = a;
        ReceiveElementWithUndeliveredHandler receiveElement = this.B_ == null ? new ReceiveElement(cancellableContinuationImpl, i) : new ReceiveElementWithUndeliveredHandler(cancellableContinuationImpl, i, this.B_);
        while (true) {
            ReceiveElementWithUndeliveredHandler receiveElementWithUndeliveredHandler = receiveElement;
            if (!b((Receive) receiveElementWithUndeliveredHandler)) {
                Object c = c();
                if (!(c instanceof Closed)) {
                    if (c != AbstractChannelKt.d) {
                        cancellableContinuationImpl.a((CancellableContinuationImpl) receiveElement.a((ReceiveElementWithUndeliveredHandler) c), (Function1<? super Throwable, Unit>) receiveElement.c((ReceiveElementWithUndeliveredHandler) c));
                        break;
                    }
                } else {
                    receiveElement.a((Closed) c);
                    break;
                }
            } else {
                a(cancellableContinuationImpl, receiveElementWithUndeliveredHandler);
                break;
            }
        }
        Object h = a.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    private final <R> void a(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i, Object obj) {
        boolean z = obj instanceof Closed;
        if (!z) {
            if (i != 1) {
                UndispatchedKt.a(function2, obj, selectInstance.a());
                return;
            }
            ChannelResult.Companion companion = ChannelResult.a;
            UndispatchedKt.a(function2, ChannelResult.h(z ? companion.a(((Closed) obj).a) : companion.a((ChannelResult.Companion) obj)), selectInstance.a());
        } else if (i == 0) {
            throw StackTraceRecoveryKt.a(((Closed) obj).e());
        } else {
            if (i == 1 && selectInstance.g()) {
                UndispatchedKt.a(function2, ChannelResult.h(ChannelResult.a.a(((Closed) obj).a)), selectInstance.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.a((Function1<? super Throwable, Unit>) new RemoveReceiveOnCancel(receive));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void a(SelectInstance<? super R> selectInstance, int i, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.f()) {
            if (!f()) {
                Object a = a((SelectInstance<?>) selectInstance);
                if (a == SelectKt.b()) {
                    return;
                }
                if (a != AbstractChannelKt.d && a != AtomicKt.b) {
                    a(function2, selectInstance, i, a);
                }
            } else if (a(selectInstance, function2, i)) {
                return;
            }
        }
    }

    private final <R> boolean a(SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
        ReceiveSelect receiveSelect = new ReceiveSelect(this, selectInstance, function2, i);
        boolean b = b((Receive) receiveSelect);
        if (b) {
            selectInstance.a(receiveSelect);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(Receive<? super E> receive) {
        boolean a = a((Receive) receive);
        if (a) {
            m();
        }
        return a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r6) {
        /*
            r5 = this;
            r0 = r6
            boolean r0 = r0 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L26
            r0 = r6
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            r8 = r0
            r0 = r8
            int r0 = r0.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L26
            r0 = r8
            r1 = r8
            int r1 = r1.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.c = r1
            r0 = r8
            r6 = r0
            goto L30
        L26:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r1 = r0
            r2 = r5
            r3 = r6
            r1.<init>(r2, r3)
            r6 = r0
        L30:
            r0 = r6
            java.lang.Object r0 = r0.a
            r8 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r9 = r0
            r0 = r6
            int r0 = r0.c
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L5b
            r0 = r7
            r1 = 1
            if (r0 != r1) goto L51
            r0 = r8
            kotlin.ResultKt.a(r0)
            r0 = r8
            r6 = r0
            goto L9f
        L51:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L5b:
            r0 = r8
            kotlin.ResultKt.a(r0)
            r0 = r5
            java.lang.Object r0 = r0.c()
            r8 = r0
            r0 = r8
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.AbstractChannelKt.d
            if (r0 == r1) goto L88
            r0 = r8
            boolean r0 = r0 instanceof kotlinx.coroutines.channels.Closed
            if (r0 == 0) goto L80
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.a
            r1 = r8
            kotlinx.coroutines.channels.Closed r1 = (kotlinx.coroutines.channels.Closed) r1
            java.lang.Throwable r1 = r1.a
            java.lang.Object r0 = r0.a(r1)
            return r0
        L80:
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.a
            r1 = r8
            java.lang.Object r0 = r0.a(r1)
            return r0
        L88:
            r0 = r6
            r1 = 1
            r0.c = r1
            r0 = r5
            r1 = 1
            r2 = r6
            java.lang.Object r0 = r0.a(r1, r2)
            r8 = r0
            r0 = r8
            r6 = r0
            r0 = r8
            r1 = r9
            if (r0 != r1) goto L9f
            r0 = r9
            return r0
        L9f:
            r0 = r6
            kotlinx.coroutines.channels.ChannelResult r0 = (kotlinx.coroutines.channels.ChannelResult) r0
            java.lang.Object r0 = r0.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected Object a(SelectInstance<?> selectInstance) {
        TryPollDesc<E> i = i();
        Object a = selectInstance.a(i);
        if (a != null) {
            return a;
        }
        i.d().b();
        return i.d().a();
    }

    protected void a(Object obj, Closed<?> closed) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((Send) obj).a(closed);
        } else if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        } else {
            ArrayList arrayList = (ArrayList) obj;
            int size = arrayList.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i = size - 1;
                ((Send) arrayList.get(size)).a(closed);
                if (i < 0) {
                    return;
                }
                size = i;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void a(CancellationException cancellationException) {
        if (e()) {
            return;
        }
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException == null) {
            cancellationException2 = new CancellationException(Intrinsics.a(DebugStringsKt.b(this), (Object) " was cancelled"));
        }
        a((Throwable) cancellationException2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        Closed<?> r = r();
        if (r == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object a = InlineList.a(null, 1, null);
        while (true) {
            LockFreeLinkedListNode k = r.k();
            if (k instanceof LockFreeLinkedListHead) {
                a(a, r);
                return;
            } else if (DebugKt.a() && !(k instanceof Send)) {
                throw new AssertionError();
            } else {
                if (k.aB_()) {
                    a = InlineList.a(a, (Send) k);
                } else {
                    k.m();
                }
            }
        }
    }

    protected abstract boolean a();

    public final boolean a(Throwable th) {
        boolean b_ = b_(th);
        a(b_);
        return b_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Receive<? super E> receive) {
        int a;
        boolean z;
        LockFreeLinkedListNode k;
        if (!a()) {
            LockFreeLinkedListHead o = o();
            final Receive<? super E> receive2 = receive;
            LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1
                final /* synthetic */ AbstractChannel b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(LockFreeLinkedListNode.this);
                    this.b = this;
                }

                @Override // kotlinx.coroutines.internal.AtomicOp
                public Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
                    if (this.b.b()) {
                        return null;
                    }
                    return LockFreeLinkedListKt.a();
                }
            };
            do {
                LockFreeLinkedListNode k2 = o.k();
                if (!(!(k2 instanceof Send))) {
                    return false;
                }
                a = k2.a(receive2, o, condAddOp);
                if (a != 1) {
                    z = false;
                }
            } while (a != 2);
            return z;
        }
        LockFreeLinkedListHead o2 = o();
        do {
            k = o2.k();
            if (!(!(k instanceof Send))) {
                return false;
            }
        } while (!k.a(receive, o2));
        z = true;
        return z;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> av_() {
        return new Itr(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object aw_() {
        Object c = c();
        return c == AbstractChannelKt.d ? ChannelResult.a.a() : c instanceof Closed ? ChannelResult.a.a(((Closed) c).a) : ChannelResult.a.a((ChannelResult.Companion) c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean b();

    protected Object c() {
        while (true) {
            Send t = t();
            if (t == null) {
                return AbstractChannelKt.d;
            }
            Symbol a = t.a((LockFreeLinkedListNode.PrepareOp) null);
            if (a != null) {
                if (DebugKt.a()) {
                    if (!(a == CancellableContinuationImplKt.a)) {
                        throw new AssertionError();
                    }
                }
                t.b();
                return t.a();
            }
            t.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean d() {
        return o().j() instanceof ReceiveOrClosed;
    }

    public boolean e() {
        return s() != null && b();
    }

    protected final boolean f() {
        return !(o().j() instanceof Send) && b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TryPollDesc<E> i() {
        return new TryPollDesc<>(o());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<E> j() {
        return new SelectClause1<E>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceive$1
            final /* synthetic */ AbstractChannel<E> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void a(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
                this.a.a(selectInstance, 0, function2);
            }
        };
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<ChannelResult<E>> k() {
        return (SelectClause1) ((SelectClause1<ChannelResult<? extends E>>) new SelectClause1<ChannelResult<? extends E>>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveCatching$1
            final /* synthetic */ AbstractChannel<E> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void a(SelectInstance<? super R> selectInstance, Function2<? super ChannelResult<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
                this.a.a(selectInstance, 1, function2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public ReceiveOrClosed<E> l() {
        ReceiveOrClosed<E> l = super.l();
        if (l != null && !(l instanceof Closed)) {
            n();
        }
        return l;
    }

    protected void m() {
    }

    protected void n() {
    }
}
