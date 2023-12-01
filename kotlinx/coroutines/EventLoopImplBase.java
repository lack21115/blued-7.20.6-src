package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/EventLoopImplBase.class */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f42817c = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/EventLoopImplBase$DelayedResumeTask.class */
    final class DelayedResumeTask extends DelayedTask {

        /* renamed from: c  reason: collision with root package name */
        private final CancellableContinuation<Unit> f42819c;

        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j);
            this.f42819c = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42819c.a((CoroutineDispatcher) EventLoopImplBase.this, (EventLoopImplBase) Unit.f42314a);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return Intrinsics.a(super.toString(), (Object) this.f42819c);
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask.class */
    static final class DelayedRunnableTask extends DelayedTask {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f42820a;

        public DelayedRunnableTask(long j, Runnable runnable) {
            super(j);
            this.f42820a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42820a.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return Intrinsics.a(super.toString(), (Object) this.f42820a);
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/EventLoopImplBase$DelayedTask.class */
    public static abstract class DelayedTask implements Comparable<DelayedTask>, Runnable, DisposableHandle, ThreadSafeHeapNode {

        /* renamed from: a  reason: collision with root package name */
        private Object f42821a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        private int f42822c = -1;

        public DelayedTask(long j) {
            this.b = j;
        }

        public final int a(long j, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            synchronized (this) {
                if (this.f42821a == EventLoop_commonKt.b()) {
                    return 2;
                }
                DelayedTaskQueue delayedTaskQueue2 = delayedTaskQueue;
                synchronized (delayedTaskQueue2) {
                    DelayedTask e = delayedTaskQueue2.e();
                    if (eventLoopImplBase.k()) {
                        return 1;
                    }
                    if (e == null) {
                        delayedTaskQueue.f42823a = j;
                    } else {
                        long j2 = e.b;
                        if (j2 - j < 0) {
                            j = j2;
                        }
                        if (j - delayedTaskQueue.f42823a > 0) {
                            delayedTaskQueue.f42823a = j;
                        }
                    }
                    if (this.b - delayedTaskQueue.f42823a < 0) {
                        this.b = delayedTaskQueue.f42823a;
                    }
                    delayedTaskQueue2.c((DelayedTaskQueue) this);
                    return 0;
                }
            }
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(DelayedTask delayedTask) {
            int i = ((this.b - delayedTask.b) > 0L ? 1 : ((this.b - delayedTask.b) == 0L ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap<?> a() {
            Object obj = this.f42821a;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void a(int i) {
            this.f42822c = i;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void a(ThreadSafeHeap<?> threadSafeHeap) {
            if (!(this.f42821a != EventLoop_commonKt.b())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f42821a = threadSafeHeap;
        }

        public final boolean a(long j) {
            return j - this.b >= 0;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int b() {
            return this.f42822c;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            synchronized (this) {
                Object obj = this.f42821a;
                if (obj == EventLoop_commonKt.b()) {
                    return;
                }
                DelayedTaskQueue delayedTaskQueue = obj instanceof DelayedTaskQueue ? (DelayedTaskQueue) obj : null;
                if (delayedTaskQueue != null) {
                    delayedTaskQueue.b((DelayedTaskQueue) this);
                }
                this.f42821a = EventLoop_commonKt.b();
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.b + ']';
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue.class */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {

        /* renamed from: a  reason: collision with root package name */
        public long f42823a;

        public DelayedTaskQueue(long j) {
            this.f42823a = j;
        }
    }

    private final boolean a(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        return (delayedTaskQueue == null ? null : delayedTaskQueue.c()) == delayedTask;
    }

    private final boolean b(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (k()) {
                return false;
            }
            if (obj == null) {
                if (b.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int a2 = lockFreeTaskQueueCore.a((LockFreeTaskQueueCore) runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    b.compareAndSet(this, obj, lockFreeTaskQueueCore.e());
                } else if (a2 == 2) {
                    return false;
                }
            } else if (obj == EventLoop_commonKt.a()) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                }
                lockFreeTaskQueueCore2.a((LockFreeTaskQueueCore) ((Runnable) obj));
                lockFreeTaskQueueCore2.a((LockFreeTaskQueueCore) runnable);
                if (b.compareAndSet(this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    private final int c(long j, DelayedTask delayedTask) {
        if (k()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        DelayedTaskQueue delayedTaskQueue2 = delayedTaskQueue;
        if (delayedTaskQueue == null) {
            EventLoopImplBase eventLoopImplBase = this;
            f42817c.compareAndSet(eventLoopImplBase, null, new DelayedTaskQueue(j));
            delayedTaskQueue2 = (DelayedTaskQueue) eventLoopImplBase._delayed;
            Intrinsics.a(delayedTaskQueue2);
        }
        return delayedTask.a(j, delayedTaskQueue2, this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private final void c(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final boolean k() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final Runnable l() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeTaskQueueCore) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object d = lockFreeTaskQueueCore.d();
                if (d != LockFreeTaskQueueCore.b) {
                    return (Runnable) d;
                }
                b.compareAndSet(this, obj, lockFreeTaskQueueCore.e());
            } else if (obj == EventLoop_commonKt.a()) {
                return null;
            } else {
                if (b.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                }
            }
        }
    }

    private final void m() {
        if (DebugKt.a() && !k()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (b.compareAndSet(this, null, EventLoop_commonKt.a())) {
                    return;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore) obj).c();
                return;
            } else if (obj == EventLoop_commonKt.a()) {
                return;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                }
                lockFreeTaskQueueCore.a((LockFreeTaskQueueCore) ((Runnable) obj));
                if (b.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            }
        }
    }

    private final void n() {
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        long nanoTime = a2 == null ? System.nanoTime() : a2.a();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            DelayedTask d = delayedTaskQueue == null ? null : delayedTaskQueue.d();
            if (d == null) {
                return;
            }
            b(nanoTime, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DisposableHandle a(long j, Runnable runnable) {
        long a2 = EventLoop_commonKt.a(j);
        if (a2 < 4611686018427387903L) {
            AbstractTimeSource a3 = AbstractTimeSourceKt.a();
            long nanoTime = a3 == null ? System.nanoTime() : a3.a();
            DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(a2 + nanoTime, runnable);
            a(nanoTime, (DelayedTask) delayedRunnableTask);
            return delayedRunnableTask;
        }
        return NonDisposableHandle.f42847a;
    }

    public DisposableHandle a(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.a(this, j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    public void a(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        long a2 = EventLoop_commonKt.a(j);
        if (a2 < 4611686018427387903L) {
            AbstractTimeSource a3 = AbstractTimeSourceKt.a();
            long nanoTime = a3 == null ? System.nanoTime() : a3.a();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(a2 + nanoTime, cancellableContinuation);
            CancellableContinuationKt.a(cancellableContinuation, delayedResumeTask);
            a(nanoTime, (DelayedTask) delayedResumeTask);
        }
    }

    public final void a(long j, DelayedTask delayedTask) {
        int c2 = c(j, delayedTask);
        if (c2 == 0) {
            if (a(delayedTask)) {
                j();
            }
        } else if (c2 == 1) {
            b(j, delayedTask);
        } else if (c2 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final void a(Runnable runnable) {
        if (b(runnable)) {
            j();
        } else {
            DefaultExecutor.b.a(runnable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
    @Override // kotlinx.coroutines.EventLoop
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long b() {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.e()
            if (r0 == 0) goto L9
            r0 = 0
            return r0
        L9:
            r0 = r4
            java.lang.Object r0 = r0._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L9d
            r0 = r9
            boolean r0 = r0.b()
            if (r0 != 0) goto L9d
            kotlinx.coroutines.AbstractTimeSource r0 = kotlinx.coroutines.AbstractTimeSourceKt.a()
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L30
            long r0 = java.lang.System.nanoTime()
            r5 = r0
            goto L36
        L30:
            r0 = r8
            long r0 = r0.a()
            r5 = r0
        L36:
            r0 = r9
            kotlinx.coroutines.internal.ThreadSafeHeap r0 = (kotlinx.coroutines.internal.ThreadSafeHeap) r0
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = r10
            kotlinx.coroutines.internal.ThreadSafeHeapNode r0 = r0.e()     // Catch: java.lang.Throwable -> L95
            r11 = r0
            r0 = 0
            r8 = r0
            r0 = r11
            if (r0 != 0) goto L55
            r0 = r10
            monitor-exit(r0)
            goto L8a
        L55:
            r0 = r11
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r0     // Catch: java.lang.Throwable -> L95
            r8 = r0
            r0 = r8
            r1 = r5
            boolean r0 = r0.a(r1)     // Catch: java.lang.Throwable -> L95
            if (r0 == 0) goto Lb6
            r0 = r4
            r1 = r8
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch: java.lang.Throwable -> L95
            boolean r0 = r0.b(r1)     // Catch: java.lang.Throwable -> L95
            r7 = r0
            goto L72
        L72:
            r0 = r7
            if (r0 == 0) goto L81
            r0 = r10
            r1 = 0
            kotlinx.coroutines.internal.ThreadSafeHeapNode r0 = r0.a(r1)     // Catch: java.lang.Throwable -> L95
            r8 = r0
            goto L87
        L81:
            r0 = 0
            kotlinx.coroutines.internal.ThreadSafeHeapNode r0 = (kotlinx.coroutines.internal.ThreadSafeHeapNode) r0     // Catch: java.lang.Throwable -> L95
            r8 = r0
        L87:
            r0 = r10
            monitor-exit(r0)
        L8a:
            r0 = r8
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r0
            if (r0 != 0) goto L36
            goto L9d
        L95:
            r8 = move-exception
            r0 = r10
            monitor-exit(r0)
            r0 = r8
            throw r0
        L9d:
            r0 = r4
            java.lang.Runnable r0 = r0.l()
            r8 = r0
            r0 = r8
            if (r0 == 0) goto Lb1
            r0 = r8
            r0.run()
            r0 = 0
            return r0
        Lb1:
            r0 = r4
            long r0 = r0.d()
            return r0
        Lb6:
            r0 = 0
            r7 = r0
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.b():long");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.EventLoop
    public boolean c() {
        if (g()) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue == null || delayedTaskQueue.b()) {
                Object obj = this._queue;
                if (obj == null) {
                    return true;
                }
                return obj instanceof LockFreeTaskQueueCore ? ((LockFreeTaskQueueCore) obj).a() : obj == EventLoop_commonKt.a();
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.EventLoop
    public long d() {
        if (super.d() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                return obj == EventLoop_commonKt.a() ? Long.MAX_VALUE : 0L;
            } else if (!((LockFreeTaskQueueCore) obj).a()) {
                return 0L;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        DelayedTask c2 = delayedTaskQueue == null ? null : delayedTaskQueue.c();
        if (c2 == null) {
            return Long.MAX_VALUE;
        }
        long j = c2.b;
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        return RangesKt.a(j - (a2 == null ? System.nanoTime() : a2.a()), 0L);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        a(runnable);
    }

    @Override // kotlinx.coroutines.EventLoop
    protected void h() {
        ThreadLocalEventLoop.f42855a.b();
        c(true);
        m();
        do {
        } while (b() <= 0);
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        this._queue = null;
        this._delayed = null;
    }
}
