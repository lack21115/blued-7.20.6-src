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

        /* renamed from: a  reason: collision with root package name */
        public final AbstractChannel<E> f42870a;
        private Object b = AbstractChannelKt.d;

        public Itr(AbstractChannel<E> abstractChannel) {
            this.f42870a = abstractChannel;
        }

        private final boolean a(Object obj) {
            if (obj instanceof Closed) {
                Closed closed = (Closed) obj;
                if (closed.f42989a == null) {
                    return false;
                }
                throw StackTraceRecoveryKt.a(closed.e());
            }
            return true;
        }

        private final Object b(Continuation<? super Boolean> continuation) {
            CancellableContinuationImpl a2 = CancellableContinuationKt.a(IntrinsicsKt.a(continuation));
            CancellableContinuationImpl cancellableContinuationImpl = a2;
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, cancellableContinuationImpl);
            while (true) {
                ReceiveHasNext receiveHasNext2 = receiveHasNext;
                if (this.f42870a.b((Receive) receiveHasNext2)) {
                    this.f42870a.a(cancellableContinuationImpl, receiveHasNext2);
                    break;
                }
                Object c2 = this.f42870a.c();
                setResult(c2);
                if (c2 instanceof Closed) {
                    Closed closed = (Closed) c2;
                    if (closed.f42989a == null) {
                        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                        Boolean a3 = Boxing.a(false);
                        Result.Companion companion = Result.f42293a;
                        cancellableContinuationImpl2.resumeWith(Result.f(a3));
                    } else {
                        CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl;
                        Throwable e = closed.e();
                        Result.Companion companion2 = Result.f42293a;
                        cancellableContinuationImpl3.resumeWith(Result.f(ResultKt.a(e)));
                    }
                } else if (c2 != AbstractChannelKt.d) {
                    Boolean a4 = Boxing.a(true);
                    Function1<E, Unit> function1 = this.f42870a.B_;
                    cancellableContinuationImpl.a((CancellableContinuationImpl) a4, (Function1<? super Throwable, Unit>) (function1 == null ? null : OnUndeliveredElementKt.b(function1, c2, cancellableContinuationImpl.getContext())));
                }
            }
            Object h = a2.h();
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
            setResult(this.f42870a.c());
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

        /* renamed from: a  reason: collision with root package name */
        public final CancellableContinuation<Object> f42871a;
        public final int b;

        public ReceiveElement(CancellableContinuation<Object> cancellableContinuation, int i) {
            this.f42871a = cancellableContinuation;
            this.b = i;
        }

        public final Object a(E e) {
            Object obj = e;
            if (this.b == 1) {
                obj = ChannelResult.h(ChannelResult.f42903a.a((ChannelResult.Companion) e));
            }
            return obj;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol a(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
            Object a2 = this.f42871a.a(a((ReceiveElement<E>) e), prepareOp == null ? null : prepareOp.f43542c, c((ReceiveElement<E>) e));
            if (a2 == null) {
                return null;
            }
            if (DebugKt.a()) {
                if (!(a2 == CancellableContinuationImplKt.f42786a)) {
                    throw new AssertionError();
                }
            }
            if (prepareOp != null) {
                prepareOp.a();
            }
            return CancellableContinuationImplKt.f42786a;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void a(Closed<?> closed) {
            if (this.b == 1) {
                CancellableContinuation<Object> cancellableContinuation = this.f42871a;
                ChannelResult h = ChannelResult.h(ChannelResult.f42903a.a(closed.f42989a));
                Result.Companion companion = Result.f42293a;
                cancellableContinuation.resumeWith(Result.f(h));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation2 = this.f42871a;
            Throwable e = closed.e();
            Result.Companion companion2 = Result.f42293a;
            cancellableContinuation2.resumeWith(Result.f(ResultKt.a(e)));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void b(E e) {
            this.f42871a.a(CancellableContinuationImplKt.f42786a);
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

        /* renamed from: c  reason: collision with root package name */
        public final Function1<E, Unit> f42872c;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElementWithUndeliveredHandler(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.f42872c = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> c(E e) {
            return OnUndeliveredElementKt.b(this.f42872c, e, this.f42871a.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext.class */
    public static class ReceiveHasNext<E> extends Receive<E> {

        /* renamed from: a  reason: collision with root package name */
        public final Itr<E> f42873a;
        public final CancellableContinuation<Boolean> b;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(Itr<E> itr, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f42873a = itr;
            this.b = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol a(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
            boolean z = true;
            Object a2 = this.b.a(true, prepareOp == null ? null : prepareOp.f43542c, c((ReceiveHasNext<E>) e));
            if (a2 == null) {
                return null;
            }
            if (DebugKt.a()) {
                if (a2 != CancellableContinuationImplKt.f42786a) {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if (prepareOp != null) {
                prepareOp.a();
            }
            return CancellableContinuationImplKt.f42786a;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void a(Closed<?> closed) {
            Object a2 = closed.f42989a == null ? CancellableContinuation.DefaultImpls.a(this.b, false, null, 2, null) : this.b.a(closed.e());
            if (a2 != null) {
                this.f42873a.setResult(closed);
                this.b.a(a2);
            }
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void b(E e) {
            this.f42873a.setResult(e);
            this.b.a(CancellableContinuationImplKt.f42786a);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> c(E e) {
            Function1<E, Unit> function1 = this.f42873a.f42870a.B_;
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

        /* renamed from: a  reason: collision with root package name */
        public final AbstractChannel<E> f42874a;
        public final SelectInstance<R> b;

        /* renamed from: c  reason: collision with root package name */
        public final Function2<Object, Continuation<? super R>, Object> f42875c;
        public final int d;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(AbstractChannel<E> abstractChannel, SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
            this.f42874a = abstractChannel;
            this.b = selectInstance;
            this.f42875c = function2;
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
                    CancellableKt.a(this.f42875c, ChannelResult.h(ChannelResult.f42903a.a(closed.f42989a)), this.b.a(), null, 4, null);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [kotlinx.coroutines.channels.ChannelResult] */
        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void b(E e) {
            CancellableKt.a(this.f42875c, this.d == 1 ? ChannelResult.h(ChannelResult.f42903a.a((ChannelResult.Companion) e)) : e, this.b.a(), c((ReceiveSelect<R, E>) e));
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> c(E e) {
            Function1<E, Unit> function1 = this.f42874a.B_;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.b(function1, e, this.b.a().getContext());
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (aB_()) {
                this.f42874a.n();
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
            return Unit.f42314a;
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
            Symbol a2 = ((Send) prepareOp.f43541a).a(prepareOp);
            if (a2 == null) {
                return LockFreeLinkedList_commonKt.f43546a;
            }
            if (a2 == AtomicKt.b) {
                return AtomicKt.b;
            }
            if (DebugKt.a()) {
                if (a2 == CancellableContinuationImplKt.f42786a) {
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
        CancellableContinuationImpl a2 = CancellableContinuationKt.a(IntrinsicsKt.a(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = a2;
        ReceiveElementWithUndeliveredHandler receiveElement = this.B_ == null ? new ReceiveElement(cancellableContinuationImpl, i) : new ReceiveElementWithUndeliveredHandler(cancellableContinuationImpl, i, this.B_);
        while (true) {
            ReceiveElementWithUndeliveredHandler receiveElementWithUndeliveredHandler = receiveElement;
            if (!b((Receive) receiveElementWithUndeliveredHandler)) {
                Object c2 = c();
                if (!(c2 instanceof Closed)) {
                    if (c2 != AbstractChannelKt.d) {
                        cancellableContinuationImpl.a((CancellableContinuationImpl) receiveElement.a((ReceiveElementWithUndeliveredHandler) c2), (Function1<? super Throwable, Unit>) receiveElement.c((ReceiveElementWithUndeliveredHandler) c2));
                        break;
                    }
                } else {
                    receiveElement.a((Closed) c2);
                    break;
                }
            } else {
                a(cancellableContinuationImpl, receiveElementWithUndeliveredHandler);
                break;
            }
        }
        Object h = a2.h();
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
            ChannelResult.Companion companion = ChannelResult.f42903a;
            UndispatchedKt.a(function2, ChannelResult.h(z ? companion.a(((Closed) obj).f42989a) : companion.a((ChannelResult.Companion) obj)), selectInstance.a());
        } else if (i == 0) {
            throw StackTraceRecoveryKt.a(((Closed) obj).e());
        } else {
            if (i == 1 && selectInstance.g()) {
                UndispatchedKt.a(function2, ChannelResult.h(ChannelResult.f42903a.a(((Closed) obj).f42989a)), selectInstance.a());
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
                Object a2 = a((SelectInstance<?>) selectInstance);
                if (a2 == SelectKt.b()) {
                    return;
                }
                if (a2 != AbstractChannelKt.d && a2 != AtomicKt.b) {
                    a(function2, selectInstance, i, a2);
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
        boolean a2 = a((Receive) receive);
        if (a2) {
            m();
        }
        return a2;
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
            int r0 = r0.f42880c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L26
            r0 = r8
            r1 = r8
            int r1 = r1.f42880c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.f42880c = r1
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
            java.lang.Object r0 = r0.f42879a
            r8 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r9 = r0
            r0 = r6
            int r0 = r0.f42880c
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
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.f42903a
            r1 = r8
            kotlinx.coroutines.channels.Closed r1 = (kotlinx.coroutines.channels.Closed) r1
            java.lang.Throwable r1 = r1.f42989a
            java.lang.Object r0 = r0.a(r1)
            return r0
        L80:
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.f42903a
            r1 = r8
            java.lang.Object r0 = r0.a(r1)
            return r0
        L88:
            r0 = r6
            r1 = 1
            r0.f42880c = r1
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
        Object a2 = selectInstance.a(i);
        if (a2 != null) {
            return a2;
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
        Object a2 = InlineList.a(null, 1, null);
        while (true) {
            LockFreeLinkedListNode k = r.k();
            if (k instanceof LockFreeLinkedListHead) {
                a(a2, r);
                return;
            } else if (DebugKt.a() && !(k instanceof Send)) {
                throw new AssertionError();
            } else {
                if (k.aB_()) {
                    a2 = InlineList.a(a2, (Send) k);
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
        int a2;
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
                a2 = k2.a(receive2, o, condAddOp);
                if (a2 != 1) {
                    z = false;
                }
            } while (a2 != 2);
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
        Object c2 = c();
        return c2 == AbstractChannelKt.d ? ChannelResult.f42903a.a() : c2 instanceof Closed ? ChannelResult.f42903a.a(((Closed) c2).f42989a) : ChannelResult.f42903a.a((ChannelResult.Companion) c2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean b();

    protected Object c() {
        while (true) {
            Send t = t();
            if (t == null) {
                return AbstractChannelKt.d;
            }
            Symbol a2 = t.a((LockFreeLinkedListNode.PrepareOp) null);
            if (a2 != null) {
                if (DebugKt.a()) {
                    if (!(a2 == CancellableContinuationImplKt.f42786a)) {
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

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AbstractChannel<E> f42877a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f42877a = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void a(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
                this.f42877a.a(selectInstance, 0, function2);
            }
        };
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<ChannelResult<E>> k() {
        return (SelectClause1) ((SelectClause1<ChannelResult<? extends E>>) new SelectClause1<ChannelResult<? extends E>>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveCatching$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AbstractChannel<E> f42878a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f42878a = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void a(SelectInstance<? super R> selectInstance, Function2<? super ChannelResult<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
                this.f42878a.a(selectInstance, 1, function2);
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
