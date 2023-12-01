package kotlinx.coroutines.selects;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectBuilderImpl.class */
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements Continuation<R>, CoroutineStackFrame, SelectBuilder<R>, SelectInstance<R> {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
    private final Continuation<R> c;
    volatile /* synthetic */ Object _state = SelectKt.a();
    volatile /* synthetic */ Object _result = SelectKt.c();
    private volatile /* synthetic */ Object _parentHandle = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp.class */
    public static final class AtomicSelectOp extends AtomicOp<Object> {
        public final SelectBuilderImpl<?> a;
        public final AtomicDesc b;
        private final long c = SelectKt.e().a();

        public AtomicSelectOp(SelectBuilderImpl<?> selectBuilderImpl, AtomicDesc atomicDesc) {
            this.a = selectBuilderImpl;
            this.b = atomicDesc;
            this.b.a(this);
        }

        private final void d(Object obj) {
            boolean z = obj == null;
            if (SelectBuilderImpl.a.compareAndSet(this.a, this, z ? null : SelectKt.a()) && z) {
                this.a.q();
            }
        }

        private final Object e() {
            SelectBuilderImpl<?> selectBuilderImpl = this.a;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).c(this.a);
                } else if (obj != SelectKt.a()) {
                    return SelectKt.b();
                } else {
                    if (SelectBuilderImpl.a.compareAndSet(this.a, SelectKt.a(), this)) {
                        return null;
                    }
                }
            }
        }

        private final void f() {
            SelectBuilderImpl.a.compareAndSet(this.a, this, SelectKt.a());
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public Object a(Object obj) {
            Object e;
            if (obj != null || (e = e()) == null) {
                try {
                    return this.b.b(this);
                } catch (Throwable th) {
                    if (obj == null) {
                        f();
                    }
                    throw th;
                }
            }
            return e;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void a(Object obj, Object obj2) {
            d(obj2);
            this.b.a(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public long c() {
            return this.c;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return "AtomicSelectOp(sequence=" + c() + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode.class */
    public static final class DisposeNode extends LockFreeLinkedListNode {
        public final DisposableHandle a;

        public DisposeNode(DisposableHandle disposableHandle) {
            this.a = disposableHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp.class */
    public static final class PairSelectOp extends OpDescriptor {
        public final LockFreeLinkedListNode.PrepareOp a;

        public PairSelectOp(LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.a = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object c(Object obj) {
            if (obj != null) {
                SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) obj;
                this.a.a();
                Object b = this.a.d().b(null);
                SelectBuilderImpl.a.compareAndSet(selectBuilderImpl, this, b == null ? this.a.c : SelectKt.a());
                return b;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> d() {
            return this.a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling.class */
    public final class SelectOnCancelling extends JobCancellingNode {
        public SelectOnCancelling() {
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void a(Throwable th) {
            if (SelectBuilderImpl.this.g()) {
                SelectBuilderImpl.this.a(c().i());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(Continuation<? super R> continuation) {
        this.c = continuation;
    }

    private final void b(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    private final DisposableHandle h() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void p() {
        Job job = (Job) getContext().get(Job.C_);
        if (job == null) {
            return;
        }
        DisposableHandle a2 = Job.DefaultImpls.a(job, true, false, new SelectOnCancelling(), 2, null);
        b(a2);
        if (f()) {
            a2.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        DisposableHandle h = h();
        if (h != null) {
            h.dispose();
        }
        SelectBuilderImpl<R> selectBuilderImpl = this;
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) selectBuilderImpl.i();
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            if (Intrinsics.a(lockFreeLinkedListNode2, selectBuilderImpl)) {
                return;
            }
            if (lockFreeLinkedListNode2 instanceof DisposeNode) {
                ((DisposeNode) lockFreeLinkedListNode2).a.dispose();
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode2.j();
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Object a(AtomicDesc atomicDesc) {
        return new AtomicSelectOp(this, atomicDesc).c(null);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Object a(LockFreeLinkedListNode.PrepareOp prepareOp) {
        while (true) {
            Object obj = this._state;
            if (obj == SelectKt.a()) {
                if (prepareOp != null) {
                    PairSelectOp pairSelectOp = new PairSelectOp(prepareOp);
                    if (a.compareAndSet(this, SelectKt.a(), pairSelectOp)) {
                        Object c = pairSelectOp.c(this);
                        if (c != null) {
                            return c;
                        }
                    }
                } else if (a.compareAndSet(this, SelectKt.a(), null)) {
                    break;
                }
            } else if (!(obj instanceof OpDescriptor)) {
                if (prepareOp != null && obj == prepareOp.c) {
                    return CancellableContinuationImplKt.a;
                }
                return null;
            } else {
                if (prepareOp != null) {
                    AtomicOp<?> d = prepareOp.d();
                    if ((d instanceof AtomicSelectOp) && ((AtomicSelectOp) d).a == this) {
                        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    }
                    if (d.a((OpDescriptor) obj)) {
                        return AtomicKt.b;
                    }
                }
                ((OpDescriptor) obj).c(this);
            }
        }
        q();
        return CancellableContinuationImplKt.a;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Continuation<R> a() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void a(long j, final Function1<? super Continuation<? super R>, ? extends Object> function1) {
        if (j > 0) {
            a(DelayKt.a(getContext()).a(j, new Runnable() { // from class: kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (SelectBuilderImpl.this.g()) {
                        CancellableKt.a(function1, SelectBuilderImpl.this.a());
                    }
                }
            }, getContext()));
        } else if (g()) {
            UndispatchedKt.a(function1, a());
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void a(Throwable th) {
        if (DebugKt.a() && !f()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._result;
            if (obj == SelectKt.c()) {
                Continuation<R> continuation = this.c;
                if (b.compareAndSet(this, SelectKt.c(), new CompletedExceptionally((DebugKt.c() && (continuation instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.a(th, (CoroutineStackFrame) continuation) : th, false, 2, null))) {
                    return;
                }
            } else if (obj != IntrinsicsKt.a()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (b.compareAndSet(this, IntrinsicsKt.a(), SelectKt.d())) {
                    Continuation a2 = IntrinsicsKt.a(this.c);
                    Result.Companion companion = Result.a;
                    a2.resumeWith(Result.f(ResultKt.a(th)));
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void a(DisposableHandle disposableHandle) {
        DisposeNode disposeNode = new DisposeNode(disposableHandle);
        if (!f()) {
            b(disposeNode);
            if (!f()) {
                return;
            }
        }
        disposableHandle.dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void a(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.a(this, function2);
    }

    public final Object b() {
        if (!f()) {
            p();
        }
        Object obj = this._result;
        Object obj2 = obj;
        if (obj == SelectKt.c()) {
            if (b.compareAndSet(this, SelectKt.c(), IntrinsicsKt.a())) {
                return IntrinsicsKt.a();
            }
            obj2 = this._result;
        }
        if (obj2 != SelectKt.d()) {
            if (obj2 instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) obj2).a;
            }
            return obj2;
        }
        throw new IllegalStateException("Already resumed");
    }

    public final void b(Throwable th) {
        if (g()) {
            Result.Companion companion = Result.a;
            resumeWith(Result.f(ResultKt.a(th)));
        } else if (th instanceof CancellationException) {
        } else {
            Object b2 = b();
            if (b2 instanceof CompletedExceptionally) {
                Throwable th2 = ((CompletedExceptionally) b2).a;
                if (DebugKt.c()) {
                    th2 = StackTraceRecoveryKt.b(th2);
                }
                if (th2 == (!DebugKt.c() ? th : StackTraceRecoveryKt.b(th))) {
                    return;
                }
            }
            CoroutineExceptionHandlerKt.a(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean f() {
        while (true) {
            Object obj = this._state;
            if (obj == SelectKt.a()) {
                return false;
            }
            if (!(obj instanceof OpDescriptor)) {
                return true;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean g() {
        Object a2 = a((LockFreeLinkedListNode.PrepareOp) null);
        if (a2 == CancellableContinuationImplKt.a) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        throw new IllegalStateException(Intrinsics.a("Unexpected trySelectIdempotent result ", a2).toString());
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.c;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.c.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        if (DebugKt.a() && !f()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj2 = this._result;
            if (obj2 == SelectKt.c()) {
                if (b.compareAndSet(this, SelectKt.c(), CompletionStateKt.a(obj, null, 1, null))) {
                    return;
                }
            } else if (obj2 != IntrinsicsKt.a()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (b.compareAndSet(this, IntrinsicsKt.a(), SelectKt.d())) {
                    if (!Result.b(obj)) {
                        this.c.resumeWith(obj);
                        return;
                    }
                    Continuation<R> continuation = this.c;
                    Throwable c = Result.c(obj);
                    Intrinsics.a((Object) c);
                    Result.Companion companion = Result.a;
                    Throwable th = c;
                    if (DebugKt.c()) {
                        th = !(continuation instanceof CoroutineStackFrame) ? c : StackTraceRecoveryKt.a(c, (CoroutineStackFrame) continuation);
                    }
                    continuation.resumeWith(Result.f(ResultKt.a(th)));
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }
}
