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

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f43590a = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");

    /* renamed from: c  reason: collision with root package name */
    private final Continuation<R> f43591c;
    volatile /* synthetic */ Object _state = SelectKt.a();
    volatile /* synthetic */ Object _result = SelectKt.c();
    private volatile /* synthetic */ Object _parentHandle = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp.class */
    public static final class AtomicSelectOp extends AtomicOp<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final SelectBuilderImpl<?> f43593a;
        public final AtomicDesc b;

        /* renamed from: c  reason: collision with root package name */
        private final long f43594c = SelectKt.e().a();

        public AtomicSelectOp(SelectBuilderImpl<?> selectBuilderImpl, AtomicDesc atomicDesc) {
            this.f43593a = selectBuilderImpl;
            this.b = atomicDesc;
            this.b.a(this);
        }

        private final void d(Object obj) {
            boolean z = obj == null;
            if (SelectBuilderImpl.f43590a.compareAndSet(this.f43593a, this, z ? null : SelectKt.a()) && z) {
                this.f43593a.q();
            }
        }

        private final Object e() {
            SelectBuilderImpl<?> selectBuilderImpl = this.f43593a;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).c(this.f43593a);
                } else if (obj != SelectKt.a()) {
                    return SelectKt.b();
                } else {
                    if (SelectBuilderImpl.f43590a.compareAndSet(this.f43593a, SelectKt.a(), this)) {
                        return null;
                    }
                }
            }
        }

        private final void f() {
            SelectBuilderImpl.f43590a.compareAndSet(this.f43593a, this, SelectKt.a());
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
            return this.f43594c;
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

        /* renamed from: a  reason: collision with root package name */
        public final DisposableHandle f43595a;

        public DisposeNode(DisposableHandle disposableHandle) {
            this.f43595a = disposableHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp.class */
    public static final class PairSelectOp extends OpDescriptor {

        /* renamed from: a  reason: collision with root package name */
        public final LockFreeLinkedListNode.PrepareOp f43596a;

        public PairSelectOp(LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.f43596a = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object c(Object obj) {
            if (obj != null) {
                SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) obj;
                this.f43596a.a();
                Object b = this.f43596a.d().b(null);
                SelectBuilderImpl.f43590a.compareAndSet(selectBuilderImpl, this, b == null ? this.f43596a.f43542c : SelectKt.a());
                return b;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> d() {
            return this.f43596a.d();
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
            return Unit.f42314a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(Continuation<? super R> continuation) {
        this.f43591c = continuation;
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
                ((DisposeNode) lockFreeLinkedListNode2).f43595a.dispose();
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
                    if (f43590a.compareAndSet(this, SelectKt.a(), pairSelectOp)) {
                        Object c2 = pairSelectOp.c(this);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                } else if (f43590a.compareAndSet(this, SelectKt.a(), null)) {
                    break;
                }
            } else if (!(obj instanceof OpDescriptor)) {
                if (prepareOp != null && obj == prepareOp.f43542c) {
                    return CancellableContinuationImplKt.f42786a;
                }
                return null;
            } else {
                if (prepareOp != null) {
                    AtomicOp<?> d = prepareOp.d();
                    if ((d instanceof AtomicSelectOp) && ((AtomicSelectOp) d).f43593a == this) {
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
        return CancellableContinuationImplKt.f42786a;
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
                Continuation<R> continuation = this.f43591c;
                if (b.compareAndSet(this, SelectKt.c(), new CompletedExceptionally((DebugKt.c() && (continuation instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.a(th, (CoroutineStackFrame) continuation) : th, false, 2, null))) {
                    return;
                }
            } else if (obj != IntrinsicsKt.a()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (b.compareAndSet(this, IntrinsicsKt.a(), SelectKt.d())) {
                    Continuation a2 = IntrinsicsKt.a(this.f43591c);
                    Result.Companion companion = Result.f42293a;
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
                throw ((CompletedExceptionally) obj2).f42791a;
            }
            return obj2;
        }
        throw new IllegalStateException("Already resumed");
    }

    public final void b(Throwable th) {
        if (g()) {
            Result.Companion companion = Result.f42293a;
            resumeWith(Result.f(ResultKt.a(th)));
        } else if (th instanceof CancellationException) {
        } else {
            Object b2 = b();
            if (b2 instanceof CompletedExceptionally) {
                Throwable th2 = ((CompletedExceptionally) b2).f42791a;
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
        if (a2 == CancellableContinuationImplKt.f42786a) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        throw new IllegalStateException(Intrinsics.a("Unexpected trySelectIdempotent result ", a2).toString());
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.f43591c;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f43591c.getContext();
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
                        this.f43591c.resumeWith(obj);
                        return;
                    }
                    Continuation<R> continuation = this.f43591c;
                    Throwable c2 = Result.c(obj);
                    Intrinsics.a((Object) c2);
                    Result.Companion companion = Result.f42293a;
                    Throwable th = c2;
                    if (DebugKt.c()) {
                        th = !(continuation instanceof CoroutineStackFrame) ? c2 : StackTraceRecoveryKt.a(c2, (CoroutineStackFrame) continuation);
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
