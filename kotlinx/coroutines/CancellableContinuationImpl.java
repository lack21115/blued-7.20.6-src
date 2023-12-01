package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CancellableContinuationImpl.class */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CoroutineStackFrame, CancellableContinuation<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
    private static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;
    private final Continuation<T> b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineContext f42785c;
    private DisposableHandle h;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int i) {
        super(i);
        this.b = continuation;
        if (DebugKt.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        this.f42785c = this.b.getContext();
        this._decision = 0;
        this._state = Active.f42775a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
        if (r15 != null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object a(kotlinx.coroutines.NotCompleted r11, java.lang.Object r12, int r13, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r14, java.lang.Object r15) {
        /*
            r10 = this;
            r0 = r12
            boolean r0 = r0 instanceof kotlinx.coroutines.CompletedExceptionally
            if (r0 == 0) goto L53
            boolean r0 = kotlinx.coroutines.DebugKt.a()
            r17 = r0
            r0 = 1
            r16 = r0
            r0 = r17
            if (r0 == 0) goto L2f
            r0 = r15
            if (r0 != 0) goto L1e
            r0 = 1
            r13 = r0
            goto L20
        L1e:
            r0 = 0
            r13 = r0
        L20:
            r0 = r13
            if (r0 == 0) goto L27
            goto L2f
        L27:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            r1.<init>()
            throw r0
        L2f:
            r0 = r12
            r18 = r0
            boolean r0 = kotlinx.coroutines.DebugKt.a()
            if (r0 == 0) goto La0
            r0 = r14
            if (r0 != 0) goto L43
            r0 = r16
            r13 = r0
            goto L45
        L43:
            r0 = 0
            r13 = r0
        L45:
            r0 = r13
            if (r0 == 0) goto L4b
            r0 = r12
            return r0
        L4b:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            r1.<init>()
            throw r0
        L53:
            r0 = r13
            boolean r0 = kotlinx.coroutines.DispatchedTaskKt.a(r0)
            if (r0 != 0) goto L61
            r0 = r15
            if (r0 != 0) goto L61
            r0 = r12
            return r0
        L61:
            r0 = r14
            if (r0 != 0) goto L7c
            r0 = r11
            boolean r0 = r0 instanceof kotlinx.coroutines.CancelHandler
            if (r0 == 0) goto L74
            r0 = r11
            boolean r0 = r0 instanceof kotlinx.coroutines.BeforeResumeCancelHandler
            if (r0 == 0) goto L7c
        L74:
            r0 = r12
            r18 = r0
            r0 = r15
            if (r0 == 0) goto La0
        L7c:
            r0 = r11
            boolean r0 = r0 instanceof kotlinx.coroutines.CancelHandler
            if (r0 == 0) goto L8b
            r0 = r11
            kotlinx.coroutines.CancelHandler r0 = (kotlinx.coroutines.CancelHandler) r0
            r11 = r0
            goto L8d
        L8b:
            r0 = 0
            r11 = r0
        L8d:
            kotlinx.coroutines.CompletedContinuation r0 = new kotlinx.coroutines.CompletedContinuation
            r1 = r0
            r2 = r12
            r3 = r11
            r4 = r14
            r5 = r15
            r6 = 0
            r7 = 16
            r8 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r18 = r0
        La0:
            r0 = r18
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CancellableContinuationImpl.a(kotlinx.coroutines.NotCompleted, java.lang.Object, int, kotlin.jvm.functions.Function1, java.lang.Object):java.lang.Object");
    }

    private final void a(int i) {
        if (n()) {
            return;
        }
        DispatchedTaskKt.a(this, i);
    }

    private final void a(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.a()) {
                        if (function1 == null) {
                            return;
                        }
                        a(function1, cancelledContinuation.f42791a);
                        return;
                    }
                }
                d(obj);
                throw new KotlinNothingValueException();
            }
        } while (!e.compareAndSet(this, obj2, a((NotCompleted) obj2, obj, i, function1, null)));
        q();
        a(i);
    }

    private final void a(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    static /* synthetic */ void a(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function1 function1, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        cancellableContinuationImpl.a(obj, i, function1);
    }

    private final CancelHandler b(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
    }

    private final Symbol b(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof NotCompleted)) {
                if (obj3 instanceof CompletedContinuation) {
                    if (obj2 != null) {
                        CompletedContinuation completedContinuation = (CompletedContinuation) obj3;
                        if (completedContinuation.d == obj2) {
                            if (!DebugKt.a() || Intrinsics.a(completedContinuation.f42789a, obj)) {
                                return CancellableContinuationImplKt.f42786a;
                            }
                            throw new AssertionError();
                        }
                    }
                    return null;
                }
                return null;
            }
        } while (!e.compareAndSet(this, obj3, a((NotCompleted) obj3, obj, this.f42808a, function1, obj2)));
        q();
        return CancellableContinuationImplKt.f42786a;
    }

    private final void b(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(getContext(), new CompletionHandlerException(Intrinsics.a("Exception in invokeOnCancellation handler for ", (Object) this), th2));
        }
    }

    private final Void d(Object obj) {
        throw new IllegalStateException(Intrinsics.a("Already resumed, but proposed with update ", obj).toString());
    }

    private final boolean d(Throwable th) {
        if (DispatchedTaskKt.b(this.f42808a) && l()) {
            return ((DispatchedContinuation) this.b).a(th);
        }
        return false;
    }

    private final String k() {
        Object c2 = c();
        return c2 instanceof NotCompleted ? "Active" : c2 instanceof CancelledContinuation ? "Cancelled" : "Completed";
    }

    private final boolean l() {
        Continuation<T> continuation = this.b;
        return (continuation instanceof DispatchedContinuation) && ((DispatchedContinuation) continuation).a((CancellableContinuationImpl<?>) this);
    }

    private final boolean m() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!d.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean n() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!d.compareAndSet(this, 0, 2));
        return true;
    }

    private final DisposableHandle o() {
        Job job = (Job) getContext().get(Job.C_);
        if (job == null) {
            return null;
        }
        DisposableHandle a2 = Job.DefaultImpls.a(job, true, false, new ChildContinuation(this), 2, null);
        this.h = a2;
        return a2;
    }

    private final void p() {
        Continuation<T> continuation = this.b;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        Throwable a2 = dispatchedContinuation == null ? null : dispatchedContinuation.a(this);
        if (a2 == null) {
            return;
        }
        i();
        b(a2);
    }

    private final void q() {
        if (l()) {
            return;
        }
        i();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object a(T t, Object obj) {
        return b(t, obj, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object a(T t, Object obj, Function1<? super Throwable, Unit> function1) {
        return b(t, obj, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object a(Throwable th) {
        return b(new CompletedExceptionally(th, false, 2, null), null, null);
    }

    public Throwable a(Job job) {
        return job.i();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void a(Object obj) {
        if (DebugKt.a()) {
            if (!(obj == CancellableContinuationImplKt.f42786a)) {
                throw new AssertionError();
            }
        }
        a(this.f42808a);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof CompletedExceptionally) {
                return;
            }
            if (obj2 instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                if (!(!completedContinuation.a())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (e.compareAndSet(this, obj2, CompletedContinuation.a(completedContinuation, null, null, null, null, th, 15, null))) {
                    completedContinuation.a(this, th);
                    return;
                }
            } else if (e.compareAndSet(this, obj2, new CompletedContinuation(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void a(T t, Function1<? super Throwable, Unit> function1) {
        a(t, this.f42808a, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void a(Function1<? super Throwable, Unit> function1) {
        CancelHandler b = b(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof Active) {
                if (e.compareAndSet(this, obj, b)) {
                    return;
                }
            } else if (obj instanceof CancelHandler) {
                a(function1, obj);
            } else {
                boolean z = obj instanceof CompletedExceptionally;
                if (z) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                    if (!completedExceptionally.c()) {
                        a(function1, obj);
                    }
                    if (obj instanceof CancelledContinuation) {
                        if (!z) {
                            completedExceptionally = null;
                        }
                        b(function1, completedExceptionally == null ? null : completedExceptionally.f42791a);
                        return;
                    }
                    return;
                } else if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.b != null) {
                        a(function1, obj);
                    }
                    if (b instanceof BeforeResumeCancelHandler) {
                        return;
                    }
                    if (completedContinuation.a()) {
                        b(function1, completedContinuation.e);
                        return;
                    } else {
                        if (e.compareAndSet(this, obj, CompletedContinuation.a(completedContinuation, null, b, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else if (b instanceof BeforeResumeCancelHandler) {
                    return;
                } else {
                    if (e.compareAndSet(this, obj, new CompletedContinuation(obj, b, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    public final void a(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(getContext(), new CompletionHandlerException(Intrinsics.a("Exception in resume onCancellation handler for ", (Object) this), th2));
        }
    }

    public final void a(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.a(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(getContext(), new CompletionHandlerException(Intrinsics.a("Exception in invokeOnCancellation handler for ", (Object) this), th2));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void a(CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.b;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        a(this, t, (dispatchedContinuation == null ? null : dispatchedContinuation.b) == coroutineDispatcher ? 4 : this.f42808a, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean a() {
        return c() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T b(Object obj) {
        Object obj2 = obj;
        if (obj instanceof CompletedContinuation) {
            obj2 = ((CompletedContinuation) obj).f42789a;
        }
        return (T) obj2;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> b() {
        return this.b;
    }

    public boolean b(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof CancelHandler;
        } while (!e.compareAndSet(this, obj, new CancelledContinuation(this, th, z)));
        CancelHandler cancelHandler = z ? (CancelHandler) obj : null;
        if (cancelHandler != null) {
            a(cancelHandler, th);
        }
        q();
        a(this.f42808a);
        return true;
    }

    public final Object c() {
        return this._state;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable c(Object obj) {
        Throwable c2 = super.c(obj);
        if (c2 == null) {
            return null;
        }
        Continuation<T> b = b();
        Throwable th = c2;
        if (DebugKt.c()) {
            if (!(b instanceof CoroutineStackFrame)) {
                return c2;
            }
            th = StackTraceRecoveryKt.a(c2, (CoroutineStackFrame) b);
        }
        return th;
    }

    public final void c(Throwable th) {
        if (d(th)) {
            return;
        }
        b(th);
        q();
    }

    public boolean d() {
        return !(c() instanceof NotCompleted);
    }

    public void e() {
        DisposableHandle o = o();
        if (o != null && d()) {
            o.dispose();
            this.h = NonDisposableHandle.f42847a;
        }
    }

    public final boolean f() {
        if (DebugKt.a()) {
            if (!(this.f42808a == 2)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.a()) {
            if (!(this.h != NonDisposableHandle.f42847a)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (!DebugKt.a() || (!(obj instanceof NotCompleted))) {
            if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).d != null) {
                i();
                return false;
            }
            this._decision = 0;
            this._state = Active.f42775a;
            return true;
        }
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object g() {
        return c();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.b;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f42785c;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.lang.Throwable] */
    public final Object h() {
        Job job;
        boolean l = l();
        if (m()) {
            if (this.h == null) {
                o();
            }
            if (l) {
                p();
            }
            return IntrinsicsKt.a();
        }
        if (l) {
            p();
        }
        Object c2 = c();
        if (c2 instanceof CompletedExceptionally) {
            Throwable th = ((CompletedExceptionally) c2).f42791a;
            Throwable th2 = th;
            if (DebugKt.c()) {
                CancellableContinuationImpl<T> cancellableContinuationImpl = this;
                th2 = !(cancellableContinuationImpl instanceof CoroutineStackFrame) ? th : StackTraceRecoveryKt.a(th, cancellableContinuationImpl);
            }
            throw th2;
        } else if (!DispatchedTaskKt.a(this.f42808a) || (job = (Job) getContext().get(Job.C_)) == null || job.a()) {
            return b(c2);
        } else {
            CancellationException i = job.i();
            a(c2, (Throwable) i);
            CancellationException cancellationException = i;
            if (DebugKt.c()) {
                CancellableContinuationImpl<T> cancellableContinuationImpl2 = this;
                cancellationException = !(cancellableContinuationImpl2 instanceof CoroutineStackFrame) ? i : StackTraceRecoveryKt.a(i, cancellableContinuationImpl2);
            }
            throw cancellationException;
        }
    }

    public final void i() {
        DisposableHandle disposableHandle = this.h;
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        this.h = NonDisposableHandle.f42847a;
    }

    protected String j() {
        return "CancellableContinuation";
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        a(this, CompletionStateKt.a(obj, (CancellableContinuation<?>) this), this.f42808a, null, 4, null);
    }

    public String toString() {
        return j() + '(' + DebugStringsKt.a((Continuation<?>) this.b) + "){" + k() + "}@" + DebugStringsKt.a((Object) this);
    }
}
