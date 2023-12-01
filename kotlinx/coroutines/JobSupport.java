package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;

@Deprecated
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobSupport.class */
public class JobSupport implements ChildJob, Job, ParentJob, SelectClause0 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobSupport$AwaitContinuation.class */
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport b;

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.b = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable a(Job job) {
            Throwable d;
            Object l = this.b.l();
            return (!(l instanceof Finishing) || (d = ((Finishing) l).d()) == null) ? l instanceof CompletedExceptionally ? ((CompletedExceptionally) l).a : job.i() : d;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String j() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobSupport$ChildCompletion.class */
    public static final class ChildCompletion extends JobNode {
        private final JobSupport a;
        private final Finishing b;
        private final ChildHandleNode d;
        private final Object g;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.a = jobSupport;
            this.b = finishing;
            this.d = childHandleNode;
            this.g = obj;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void a(Throwable th) {
            this.a.b(this.b, this.d, this.g);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobSupport$Finishing.class */
    public static final class Finishing implements Incomplete {
        private volatile /* synthetic */ Object _exceptionsHolder;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;
        private final NodeList a;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public Finishing(NodeList nodeList, boolean z, Throwable th) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        private final void a(Object obj) {
            this._exceptionsHolder = obj;
        }

        private final Object g() {
            return this._exceptionsHolder;
        }

        private final ArrayList<Throwable> h() {
            return new ArrayList<>(4);
        }

        public final void a(Throwable th) {
            this._rootCause = th;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public final void a(boolean z) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean as_() {
            return d() == null;
        }

        @Override // kotlinx.coroutines.Incomplete
        public NodeList at_() {
            return this.a;
        }

        public final List<Throwable> b(Throwable th) {
            ArrayList<Throwable> arrayList;
            Object g = g();
            if (g == null) {
                arrayList = h();
            } else if (g instanceof Throwable) {
                arrayList = h();
                arrayList.add(g);
            } else if (!(g instanceof ArrayList)) {
                throw new IllegalStateException(Intrinsics.a("State is ", g).toString());
            } else {
                arrayList = (ArrayList) g;
            }
            Throwable d = d();
            if (d != null) {
                arrayList.add(0, d);
            }
            if (th != null && !Intrinsics.a(th, d)) {
                arrayList.add(th);
            }
            a(JobSupportKt.f());
            return arrayList;
        }

        public final void c(Throwable th) {
            Throwable d = d();
            if (d == null) {
                a(th);
            } else if (th == d) {
            } else {
                Object g = g();
                if (g == null) {
                    a((Object) th);
                } else if (!(g instanceof Throwable)) {
                    if (!(g instanceof ArrayList)) {
                        throw new IllegalStateException(Intrinsics.a("State is ", g).toString());
                    }
                    ((ArrayList) g).add(th);
                } else if (th == g) {
                } else {
                    ArrayList<Throwable> h = h();
                    h.add(g);
                    h.add(th);
                    Unit unit = Unit.a;
                    a(h);
                }
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public final boolean c() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        public final Throwable d() {
            return (Throwable) this._rootCause;
        }

        public final boolean e() {
            return g() == JobSupportKt.f();
        }

        public final boolean f() {
            return d() != null;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + c() + ", rootCause=" + d() + ", exceptions=" + g() + ", list=" + at_() + ']';
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.a() : JobSupportKt.b();
        this._parentHandle = null;
    }

    private final int a(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).as_()) {
                return 0;
            }
            if (b.compareAndSet(this, obj, JobSupportKt.a())) {
                m();
                return 1;
            }
            return -1;
        } else if (obj instanceof InactiveNodeList) {
            if (b.compareAndSet(this, obj, ((InactiveNodeList) obj).at_())) {
                m();
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }

    private final Object a(Object obj, Object obj2) {
        return !(obj instanceof Incomplete) ? JobSupportKt.c() : ((!(obj instanceof Empty) && !(obj instanceof JobNode)) || (obj instanceof ChildHandleNode) || (obj2 instanceof CompletedExceptionally)) ? c((Incomplete) obj, obj2) : a((Incomplete) obj, obj2) ? obj2 : JobSupportKt.e();
    }

    private final Object a(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        CancellableContinuationKt.a(cancellableContinuationImpl2, a_(new ResumeOnCompletion(cancellableContinuationImpl2)));
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h == IntrinsicsKt.a() ? h : Unit.a;
    }

    private final Object a(Finishing finishing, Object obj) {
        boolean f;
        Throwable a;
        if (DebugKt.a()) {
            if (!(l() == finishing)) {
                throw new AssertionError();
            }
        }
        if (!DebugKt.a() || (!finishing.e())) {
            if (!DebugKt.a() || finishing.c()) {
                CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
                Throwable th = completedExceptionally == null ? null : completedExceptionally.a;
                synchronized (finishing) {
                    f = finishing.f();
                    List<Throwable> b2 = finishing.b(th);
                    a = a(finishing, (List<? extends Throwable>) b2);
                    if (a != null) {
                        a(a, (List<? extends Throwable>) b2);
                    }
                }
                if (a != null && a != th) {
                    obj = new CompletedExceptionally(a, false, 2, null);
                }
                if (a != null) {
                    boolean z = true;
                    if (!g(a)) {
                        z = f(a);
                    }
                    if (z) {
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                        }
                        ((CompletedExceptionally) obj).c();
                    }
                }
                if (!f) {
                    e(a);
                }
                b(obj);
                boolean compareAndSet = b.compareAndSet(this, finishing, JobSupportKt.a(obj));
                if (!DebugKt.a() || compareAndSet) {
                    b(finishing, obj);
                    return obj;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final Throwable a(Finishing finishing, List<? extends Throwable> list) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        if (list.isEmpty()) {
            if (finishing.f()) {
                return new JobCancellationException(b(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list2 = list;
        Iterator<? extends Throwable> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                th = null;
                break;
            }
            th = it.next();
            if (!(th instanceof CancellationException)) {
                break;
            }
        }
        Throwable th4 = th;
        if (th4 != null) {
            return th4;
        }
        Throwable th5 = list.get(0);
        if (th5 instanceof TimeoutCancellationException) {
            Iterator<? extends Throwable> it2 = list2.iterator();
            do {
                th2 = null;
                if (!it2.hasNext()) {
                    break;
                }
                th2 = it2.next();
                th3 = th2;
            } while (!(th3 != th5 && (th3 instanceof TimeoutCancellationException)));
            Throwable th6 = th2;
            if (th6 != null) {
                return th6;
            }
        }
        return th5;
    }

    public static /* synthetic */ CancellationException a(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return jobSupport.a(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final ChildHandleNode a(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        while (true) {
            lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            if (!lockFreeLinkedListNode.aA_()) {
                break;
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.k();
        }
        while (true) {
            LockFreeLinkedListNode j = lockFreeLinkedListNode2.j();
            if (j.aA_()) {
                lockFreeLinkedListNode2 = j;
            } else if (j instanceof ChildHandleNode) {
                return (ChildHandleNode) j;
            } else {
                lockFreeLinkedListNode2 = j;
                if (j instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    private final JobNode a(Function1<? super Throwable, Unit> function1, boolean z) {
        JobNode jobNode;
        JobNode jobNode2 = null;
        if (z) {
            if (function1 instanceof JobCancellingNode) {
                jobNode2 = (JobCancellingNode) function1;
            }
            JobNode jobNode3 = jobNode2;
            if (jobNode2 == null) {
                jobNode3 = (JobCancellingNode) new InvokeOnCancelling(function1);
            }
            jobNode = jobNode3;
        } else {
            JobNode jobNode4 = function1 instanceof JobNode ? (JobNode) function1 : null;
            if (jobNode4 == null) {
                jobNode4 = null;
            } else if (DebugKt.a() && !(!(jobNode4 instanceof JobCancellingNode))) {
                throw new AssertionError();
            }
            jobNode = jobNode4;
            if (jobNode4 == null) {
                jobNode = new InvokeOnCompletion(function1);
            }
        }
        jobNode.a(this);
        return jobNode;
    }

    private final NodeList a(Incomplete incomplete) {
        NodeList at_ = incomplete.at_();
        if (at_ == null) {
            if (incomplete instanceof Empty) {
                return new NodeList();
            }
            if (incomplete instanceof JobNode) {
                b((JobNode) incomplete);
                return null;
            }
            throw new IllegalStateException(Intrinsics.a("State should have list: ", (Object) incomplete).toString());
        }
        return at_;
    }

    private final void a(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable b2 = !DebugKt.c() ? th : StackTraceRecoveryKt.b(th);
        Iterator<? extends Throwable> it = list.iterator();
        while (it.hasNext()) {
            Throwable next = it.next();
            if (DebugKt.c()) {
                next = StackTraceRecoveryKt.b(next);
            }
            if (next != th && next != b2 && !(next instanceof CancellationException) && newSetFromMap.add(next)) {
                kotlin.ExceptionsKt.a(th, next);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [kotlinx.coroutines.Incomplete] */
    private final void a(Empty empty) {
        NodeList nodeList = new NodeList();
        b.compareAndSet(this, empty, empty.as_() ? nodeList : new InactiveNodeList(nodeList));
    }

    private final void a(NodeList nodeList, Throwable th) {
        CompletionHandlerException completionHandlerException;
        e(th);
        NodeList nodeList2 = nodeList;
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList2.i();
        CompletionHandlerException completionHandlerException2 = null;
        while (true) {
            completionHandlerException = completionHandlerException2;
            if (Intrinsics.a(lockFreeLinkedListNode, nodeList2)) {
                break;
            }
            CompletionHandlerException completionHandlerException3 = completionHandlerException;
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.a(th);
                    completionHandlerException3 = completionHandlerException;
                } catch (Throwable th2) {
                    Throwable th3 = completionHandlerException;
                    if (th3 == null) {
                        th3 = null;
                    } else {
                        kotlin.ExceptionsKt.a(th3, th2);
                    }
                    completionHandlerException3 = completionHandlerException;
                    if (th3 == null) {
                        completionHandlerException3 = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                    }
                }
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.j();
            completionHandlerException2 = completionHandlerException3;
        }
        CompletionHandlerException completionHandlerException4 = completionHandlerException;
        if (completionHandlerException4 != null) {
            a_(completionHandlerException4);
        }
        g(th);
    }

    private final boolean a(final Object obj, NodeList nodeList, JobNode jobNode) {
        boolean z;
        NodeList nodeList2 = nodeList;
        final JobNode jobNode2 = jobNode;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(this, obj) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
            final /* synthetic */ JobSupport b;
            final /* synthetic */ Object c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(LockFreeLinkedListNode.this);
                this.b = this;
                this.c = obj;
            }

            @Override // kotlinx.coroutines.internal.AtomicOp
            public Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
                if (this.b.l() == this.c) {
                    return null;
                }
                return LockFreeLinkedListKt.a();
            }
        };
        while (true) {
            int a = nodeList2.k().a(jobNode2, nodeList2, condAddOp);
            z = true;
            if (a != 1) {
                if (a == 2) {
                    z = false;
                    break;
                }
            } else {
                break;
            }
        }
        return z;
    }

    private final boolean a(Incomplete incomplete, Object obj) {
        if (DebugKt.a()) {
            if (!((incomplete instanceof Empty) || (incomplete instanceof JobNode))) {
                throw new AssertionError();
            }
        }
        if (!DebugKt.a() || (!(obj instanceof CompletedExceptionally))) {
            if (b.compareAndSet(this, incomplete, JobSupportKt.a(obj))) {
                e((Throwable) null);
                b(obj);
                b(incomplete, obj);
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    private final boolean a(Incomplete incomplete, Throwable th) {
        if (!DebugKt.a() || (!(incomplete instanceof Finishing))) {
            if (!DebugKt.a() || incomplete.as_()) {
                NodeList a = a(incomplete);
                if (a == null) {
                    return false;
                }
                if (b.compareAndSet(this, incomplete, new Finishing(a, false, th))) {
                    a(a, th);
                    return true;
                }
                return false;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final boolean a(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (Job.DefaultImpls.a(childHandleNode.a, false, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1, null) == NonDisposableHandle.a) {
            ChildHandleNode a = a((LockFreeLinkedListNode) childHandleNode);
            childHandleNode = a;
            if (a == null) {
                return false;
            }
        }
        return true;
    }

    private final ChildHandleNode b(Incomplete incomplete) {
        ChildHandleNode childHandleNode = incomplete instanceof ChildHandleNode ? (ChildHandleNode) incomplete : null;
        if (childHandleNode == null) {
            NodeList at_ = incomplete.at_();
            if (at_ == null) {
                return null;
            }
            return a((LockFreeLinkedListNode) at_);
        }
        return childHandleNode;
    }

    private final void b(Incomplete incomplete, Object obj) {
        ChildHandle ax_ = ax_();
        if (ax_ != null) {
            ax_.dispose();
            a((ChildHandle) NonDisposableHandle.a);
        }
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally == null ? null : completedExceptionally.a;
        if (!(incomplete instanceof JobNode)) {
            NodeList at_ = incomplete.at_();
            if (at_ == null) {
                return;
            }
            b(at_, th);
            return;
        }
        try {
            ((JobNode) incomplete).a(th);
        } catch (Throwable th2) {
            a_(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
        }
    }

    private final void b(JobNode jobNode) {
        jobNode.a(new NodeList());
        b.compareAndSet(this, jobNode, jobNode.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        if (DebugKt.a()) {
            if (!(l() == finishing)) {
                throw new AssertionError();
            }
        }
        ChildHandleNode a = a((LockFreeLinkedListNode) childHandleNode);
        if (a == null || !a(finishing, a, obj)) {
            d(a(finishing, obj));
        }
    }

    private final void b(NodeList nodeList, Throwable th) {
        CompletionHandlerException completionHandlerException;
        NodeList nodeList2 = nodeList;
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList2.i();
        CompletionHandlerException completionHandlerException2 = null;
        while (true) {
            completionHandlerException = completionHandlerException2;
            if (Intrinsics.a(lockFreeLinkedListNode, nodeList2)) {
                break;
            }
            CompletionHandlerException completionHandlerException3 = completionHandlerException;
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.a(th);
                    completionHandlerException3 = completionHandlerException;
                } catch (Throwable th2) {
                    Throwable th3 = completionHandlerException;
                    if (th3 == null) {
                        th3 = null;
                    } else {
                        kotlin.ExceptionsKt.a(th3, th2);
                    }
                    completionHandlerException3 = completionHandlerException;
                    if (th3 == null) {
                        completionHandlerException3 = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                    }
                }
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.j();
            completionHandlerException2 = completionHandlerException3;
        }
        CompletionHandlerException completionHandlerException4 = completionHandlerException;
        if (completionHandlerException4 == null) {
            return;
        }
        a_(completionHandlerException4);
    }

    private final Object c(Object obj) {
        Object a;
        do {
            Object l = l();
            if (!(l instanceof Incomplete) || ((l instanceof Finishing) && ((Finishing) l).c())) {
                return JobSupportKt.c();
            }
            a = a(l, new CompletedExceptionally(h(obj), false, 2, null));
        } while (a == JobSupportKt.e());
        return a;
    }

    private final Object c(Incomplete incomplete, Object obj) {
        NodeList a = a(incomplete);
        if (a == null) {
            return JobSupportKt.e();
        }
        Incomplete incomplete2 = incomplete instanceof Finishing ? (Finishing) incomplete : null;
        Incomplete incomplete3 = incomplete2;
        if (incomplete2 == null) {
            incomplete3 = new Finishing(a, false, null);
        }
        synchronized (incomplete3) {
            try {
                if (incomplete3.c()) {
                    return JobSupportKt.c();
                }
                incomplete3.a(true);
                if (incomplete3 != incomplete && !b.compareAndSet(this, incomplete, incomplete3)) {
                    return JobSupportKt.e();
                }
                if (DebugKt.a() && !(!incomplete3.e())) {
                    throw new AssertionError();
                }
                boolean f = incomplete3.f();
                CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
                if (completedExceptionally != null) {
                    incomplete3.c(completedExceptionally.a);
                }
                Throwable d = incomplete3.d();
                Throwable th = null;
                if (true ^ f) {
                    th = d;
                }
                Unit unit = Unit.a;
                if (incomplete3 != null) {
                    a(a, incomplete3);
                }
                ChildHandleNode b2 = b(incomplete);
                return (b2 == null || !a((Finishing) incomplete3, b2, obj)) ? a((Finishing) incomplete3, obj) : JobSupportKt.a;
            } finally {
                Incomplete incomplete4 = incomplete3;
            }
        }
    }

    private final Object d(Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.a(continuation), this);
        awaitContinuation.e();
        CancellableContinuationKt.a(awaitContinuation, a_(new ResumeAwaitOnCompletion(awaitContinuation)));
        Object h = awaitContinuation.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    private final boolean g(Throwable th) {
        boolean z = true;
        if (d()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        ChildHandle ax_ = ax_();
        if (ax_ != null && ax_ != NonDisposableHandle.a) {
            if (!ax_.b(th)) {
                if (z2) {
                    return true;
                }
                z = false;
            }
            return z;
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Throwable] */
    private final Throwable h(Object obj) {
        CancellationException n;
        if (obj == null ? true : obj instanceof Throwable) {
            ?? r0 = (Throwable) obj;
            n = r0;
            if (r0 == 0) {
                return new JobCancellationException(b(), null, this);
            }
        } else if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        } else {
            n = ((ParentJob) obj).n();
        }
        return n;
    }

    private final Object i(Object obj) {
        Throwable th = null;
        while (true) {
            Object l = l();
            if (l instanceof Finishing) {
                synchronized (l) {
                    if (((Finishing) l).e()) {
                        return JobSupportKt.d();
                    }
                    boolean f = ((Finishing) l).f();
                    if (obj != null || !f) {
                        Throwable th2 = th;
                        if (th == null) {
                            th2 = h(obj);
                        }
                        ((Finishing) l).c(th2);
                    }
                    Throwable d = ((Finishing) l).d();
                    Throwable th3 = null;
                    if (!f) {
                        th3 = d;
                    }
                    if (th3 != null) {
                        a(((Finishing) l).at_(), th3);
                    }
                    return JobSupportKt.c();
                }
            } else if (!(l instanceof Incomplete)) {
                return JobSupportKt.d();
            } else {
                Throwable th4 = th;
                if (th == null) {
                    th4 = h(obj);
                }
                Incomplete incomplete = (Incomplete) l;
                if (incomplete.as_()) {
                    th = th4;
                    if (a(incomplete, th4)) {
                        return JobSupportKt.c();
                    }
                } else {
                    Object a = a(l, new CompletedExceptionally(th4, false, 2, null));
                    if (a == JobSupportKt.c()) {
                        throw new IllegalStateException(Intrinsics.a("Cannot happen in ", l).toString());
                    }
                    if (a != JobSupportKt.e()) {
                        return a;
                    }
                    th = th4;
                }
            }
        }
    }

    private final Throwable j(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally == null) {
            return null;
        }
        return completedExceptionally.a;
    }

    private final String k(Object obj) {
        String str;
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.f()) {
                return "Cancelling";
            }
            str = "Active";
            if (finishing.c()) {
                return "Completing";
            }
        } else if (obj instanceof Incomplete) {
            return ((Incomplete) obj).as_() ? "Active" : "New";
        } else if (obj instanceof CompletedExceptionally) {
            return "Cancelled";
        } else {
            str = "Completed";
        }
        return str;
    }

    private final boolean q() {
        Object l;
        do {
            l = l();
            if (!(l instanceof Incomplete)) {
                return false;
            }
        } while (a(l) < 0);
        return true;
    }

    protected final CancellationException a(Throwable th, String str) {
        JobCancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        JobCancellationException jobCancellationException2 = jobCancellationException;
        if (jobCancellationException == null) {
            String str2 = str;
            if (str == null) {
                str2 = b();
            }
            jobCancellationException2 = new JobCancellationException(str2, th, this);
        }
        return jobCancellationException2;
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle a(ChildJob childJob) {
        return (ChildHandle) Job.DefaultImpls.a(this, true, false, new ChildHandleNode(childJob), 2, null);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle a(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        JobNode a = a(function1, z);
        while (true) {
            Object l = l();
            if (l instanceof Empty) {
                Empty empty = (Empty) l;
                if (!empty.as_()) {
                    a(empty);
                } else if (b.compareAndSet(this, l, a)) {
                    return a;
                }
            } else if (!(l instanceof Incomplete)) {
                if (z2) {
                    CompletedExceptionally completedExceptionally = l instanceof CompletedExceptionally ? (CompletedExceptionally) l : null;
                    function1.invoke(completedExceptionally == null ? null : completedExceptionally.a);
                }
                return NonDisposableHandle.a;
            } else {
                NodeList at_ = ((Incomplete) l).at_();
                if (at_ != null) {
                    DisposableHandle disposableHandle = NonDisposableHandle.a;
                    Throwable th = null;
                    DisposableHandle disposableHandle2 = disposableHandle;
                    if (z) {
                        th = null;
                        disposableHandle2 = disposableHandle;
                        if (l instanceof Finishing) {
                            synchronized (l) {
                                th = ((Finishing) l).d();
                                if (th != null) {
                                    disposableHandle2 = disposableHandle;
                                    if (function1 instanceof ChildHandleNode) {
                                        disposableHandle2 = disposableHandle;
                                        if (((Finishing) l).c()) {
                                        }
                                    }
                                    Unit unit = Unit.a;
                                }
                                if (a(l, at_, a)) {
                                    if (th == null) {
                                        return a;
                                    }
                                    disposableHandle2 = a;
                                    Unit unit2 = Unit.a;
                                }
                            }
                        }
                    }
                    if (th != null) {
                        if (z2) {
                            function1.invoke(th);
                        }
                        return disposableHandle2;
                    } else if (a(l, at_, a)) {
                        return a;
                    }
                } else if (l == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                } else {
                    b((JobNode) l);
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public void a(CancellationException cancellationException) {
        JobCancellationException jobCancellationException = cancellationException;
        if (cancellationException == null) {
            jobCancellationException = new JobCancellationException(b(), null, this);
        }
        b((Throwable) jobCancellationException);
    }

    public final void a(ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Job job) {
        if (DebugKt.a()) {
            if (!(ax_() == null)) {
                throw new AssertionError();
            }
        }
        if (job == null) {
            a((ChildHandle) NonDisposableHandle.a);
            return;
        }
        job.ay_();
        ChildHandle a = job.a(this);
        a(a);
        if (g()) {
            a.dispose();
            a((ChildHandle) NonDisposableHandle.a);
        }
    }

    public final void a(JobNode jobNode) {
        Object l;
        do {
            l = l();
            if (!(l instanceof JobNode)) {
                if (!(l instanceof Incomplete) || ((Incomplete) l).at_() == null) {
                    return;
                }
                jobNode.aB_();
                return;
            } else if (l != jobNode) {
                return;
            }
        } while (!b.compareAndSet(this, l, JobSupportKt.a()));
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void a(ParentJob parentJob) {
        e(parentJob);
    }

    @Override // kotlinx.coroutines.selects.SelectClause0
    public final <R> void a(SelectInstance<? super R> selectInstance, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Object l;
        do {
            l = l();
            if (selectInstance.f()) {
                return;
            }
            if (!(l instanceof Incomplete)) {
                if (selectInstance.g()) {
                    UndispatchedKt.a(function1, selectInstance.a());
                    return;
                }
                return;
            }
        } while (a(l) != 0);
        selectInstance.a(a_(new SelectJoinOnCompletion(selectInstance, function1)));
    }

    @Override // kotlinx.coroutines.Job
    public boolean a() {
        Object l = l();
        return (l instanceof Incomplete) && ((Incomplete) l).as_();
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle a_(Function1<? super Throwable, Unit> function1) {
        return a(false, true, function1);
    }

    public void a_(Throwable th) {
        throw th;
    }

    public boolean au_() {
        return true;
    }

    public final ChildHandle ax_() {
        return (ChildHandle) this._parentHandle;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean ay_() {
        int a;
        do {
            a = a(l());
            if (a == 0) {
                return false;
            }
        } while (a != 1);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final Object b(Continuation<? super Unit> continuation) {
        if (q()) {
            Object a = a(continuation);
            return a == IntrinsicsKt.a() ? a : Unit.a;
        }
        JobKt.a(continuation.getContext());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        return "Job was cancelled";
    }

    protected void b(Object obj) {
    }

    public void b(Throwable th) {
        e((Object) th);
    }

    public final <T, R> void b(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object l;
        do {
            l = l();
            if (selectInstance.f()) {
                return;
            }
            if (!(l instanceof Incomplete)) {
                if (selectInstance.g()) {
                    if (l instanceof CompletedExceptionally) {
                        selectInstance.a(((CompletedExceptionally) l).a);
                        return;
                    } else {
                        UndispatchedKt.a(function2, JobSupportKt.b(l), selectInstance.a());
                        return;
                    }
                }
                return;
            }
        } while (a(l) != 0);
        selectInstance.a(a_(new SelectAwaitOnCompletion(selectInstance, function2)));
    }

    public final Object c(Continuation<Object> continuation) {
        Object l;
        do {
            l = l();
            if (!(l instanceof Incomplete)) {
                if (l instanceof CompletedExceptionally) {
                    Throwable th = ((CompletedExceptionally) l).a;
                    if (DebugKt.c()) {
                        if (continuation instanceof CoroutineStackFrame) {
                            throw StackTraceRecoveryKt.a(th, (CoroutineStackFrame) continuation);
                        }
                        throw th;
                    }
                    throw th;
                }
                return JobSupportKt.b(l);
            }
        } while (a(l) < 0);
        return d(continuation);
    }

    public String c() {
        return DebugStringsKt.b(this);
    }

    public final <T, R> void c(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object l = l();
        if (l instanceof CompletedExceptionally) {
            selectInstance.a(((CompletedExceptionally) l).a);
        } else {
            CancellableKt.a(function2, JobSupportKt.b(l), selectInstance.a(), null, 4, null);
        }
    }

    public boolean c(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return e((Object) th) && au_();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Object obj) {
    }

    protected boolean d() {
        return false;
    }

    public final boolean d(Throwable th) {
        return e((Object) th);
    }

    protected void e(Throwable th) {
    }

    public boolean e() {
        return false;
    }

    public final boolean e(Object obj) {
        Symbol c = JobSupportKt.c();
        if (e()) {
            Object c2 = c(obj);
            c = c2;
            if (c2 == JobSupportKt.a) {
                return true;
            }
        }
        Object obj2 = c;
        if (c == JobSupportKt.c()) {
            obj2 = i(obj);
        }
        if (obj2 == JobSupportKt.c() || obj2 == JobSupportKt.a) {
            return true;
        }
        if (obj2 == JobSupportKt.d()) {
            return false;
        }
        d(obj2);
        return true;
    }

    public final boolean f(Object obj) {
        Object a;
        do {
            a = a(l(), obj);
            if (a == JobSupportKt.c()) {
                return false;
            }
            if (a == JobSupportKt.a) {
                return true;
            }
        } while (a == JobSupportKt.e());
        d(a);
        return true;
    }

    protected boolean f(Throwable th) {
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.DefaultImpls.a(this, r, function2);
    }

    public final Object g(Object obj) {
        Object a;
        do {
            a = a(l(), obj);
            if (a == JobSupportKt.c()) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, j(obj));
            }
        } while (a == JobSupportKt.e());
        return a;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean g() {
        return !(l() instanceof Incomplete);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) Job.DefaultImpls.a(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.C_;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean h() {
        Object l = l();
        if (l instanceof CompletedExceptionally) {
            return true;
        }
        return (l instanceof Finishing) && ((Finishing) l).f();
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException i() {
        Object l = l();
        if (!(l instanceof Finishing)) {
            if (l instanceof Incomplete) {
                throw new IllegalStateException(Intrinsics.a("Job is still new or active: ", (Object) this).toString());
            }
            return l instanceof CompletedExceptionally ? a(this, ((CompletedExceptionally) l).a, null, 1, null) : new JobCancellationException(Intrinsics.a(DebugStringsKt.b(this), (Object) " has completed normally"), null, this);
        }
        Throwable d = ((Finishing) l).d();
        if (d != null) {
            return a(d, Intrinsics.a(DebugStringsKt.b(this), (Object) " is cancelling"));
        }
        throw new IllegalStateException(Intrinsics.a("Job is still new or active: ", (Object) this).toString());
    }

    public final Object l() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    protected void m() {
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.b(this, key);
    }

    @Override // kotlinx.coroutines.ParentJob
    public CancellationException n() {
        CancellationException cancellationException;
        Object l = l();
        JobCancellationException jobCancellationException = null;
        if (l instanceof Finishing) {
            cancellationException = ((Finishing) l).d();
        } else if (l instanceof CompletedExceptionally) {
            cancellationException = ((CompletedExceptionally) l).a;
        } else if (l instanceof Incomplete) {
            throw new IllegalStateException(Intrinsics.a("Cannot be cancelling child in this state: ", l).toString());
        } else {
            cancellationException = null;
        }
        if (cancellationException instanceof CancellationException) {
            jobCancellationException = cancellationException;
        }
        JobCancellationException jobCancellationException2 = jobCancellationException;
        if (jobCancellationException == null) {
            jobCancellationException2 = new JobCancellationException(Intrinsics.a("Parent job is ", (Object) k(l)), cancellationException, this);
        }
        return jobCancellationException2;
    }

    public final String o() {
        return c() + '{' + k(l()) + '}';
    }

    public final Object p() {
        Object l = l();
        if (!(l instanceof Incomplete)) {
            if (l instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) l).a;
            }
            return JobSupportKt.b(l);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.DefaultImpls.a(this, coroutineContext);
    }

    public String toString() {
        return o() + '@' + DebugStringsKt.a(this);
    }
}
