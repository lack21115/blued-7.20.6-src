package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/CoroutineScheduler.class */
public final class CoroutineScheduler implements Closeable, Executor {
    private volatile /* synthetic */ int _isTerminated;
    public final int b;
    public final int c;
    volatile /* synthetic */ long controlState;
    public final long d;
    public final String e;
    public final GlobalQueue f;
    public final GlobalQueue g;
    public final AtomicReferenceArray<Worker> h;
    private volatile /* synthetic */ long parkedWorkersStack;
    public static final Companion a = new Companion(null);
    public static final Symbol j = new Symbol("NOT_IN_STACK");
    private static final /* synthetic */ AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    private static final /* synthetic */ AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/CoroutineScheduler$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/CoroutineScheduler$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WorkerState.valuesCustom().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            a = iArr;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/CoroutineScheduler$Worker.class */
    public final class Worker extends Thread {
        static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        public final WorkQueue a;
        public WorkerState b;
        public boolean d;
        private long f;
        private long g;
        private int h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private Worker() {
            setDaemon(true);
            this.a = new WorkQueue();
            this.b = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.j;
            this.h = Random.a.b();
        }

        public Worker(int i) {
            this();
            a(i);
        }

        private final void a(Task task) {
            int b = task.g.b();
            e(b);
            c(b);
            CoroutineScheduler.this.a(task);
            d(b);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
            if (r0 == null) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlinx.coroutines.scheduling.Task b(boolean r5) {
            /*
                r4 = this;
                r0 = r5
                if (r0 == 0) goto L4d
                r0 = r4
                r1 = r4
                kotlinx.coroutines.scheduling.CoroutineScheduler r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                int r1 = r1.b
                r2 = 2
                int r1 = r1 * r2
                int r0 = r0.b(r1)
                if (r0 != 0) goto L19
                r0 = 1
                r6 = r0
                goto L1b
            L19:
                r0 = 0
                r6 = r0
            L1b:
                r0 = r6
                if (r0 == 0) goto L2d
                r0 = r4
                kotlinx.coroutines.scheduling.Task r0 = r0.i()
                r7 = r0
                r0 = r7
                if (r0 != 0) goto L2b
                goto L2d
            L2b:
                r0 = r7
                return r0
            L2d:
                r0 = r4
                kotlinx.coroutines.scheduling.WorkQueue r0 = r0.a
                kotlinx.coroutines.scheduling.Task r0 = r0.c()
                r7 = r0
                r0 = r7
                if (r0 != 0) goto L4b
                r0 = r6
                if (r0 != 0) goto L5b
                r0 = r4
                kotlinx.coroutines.scheduling.Task r0 = r0.i()
                r7 = r0
                r0 = r7
                if (r0 != 0) goto L49
                goto L5b
            L49:
                r0 = r7
                return r0
            L4b:
                r0 = r7
                return r0
            L4d:
                r0 = r4
                kotlinx.coroutines.scheduling.Task r0 = r0.i()
                r8 = r0
                r0 = r8
                r7 = r0
                r0 = r8
                if (r0 != 0) goto L61
            L5b:
                r0 = r4
                r1 = 0
                kotlinx.coroutines.scheduling.Task r0 = r0.c(r1)
                r7 = r0
            L61:
                r0 = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.b(boolean):kotlinx.coroutines.scheduling.Task");
        }

        private final Task c(boolean z) {
            if (DebugKt.a()) {
                if (!(this.a.b() == 0)) {
                    throw new AssertionError();
                }
            }
            int i = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int b = b(i);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j = Long.MAX_VALUE;
            int i2 = 0;
            while (i2 < i) {
                int i3 = b + 1;
                b = i3;
                if (i3 > i) {
                    b = 1;
                }
                Worker worker = coroutineScheduler.h.get(b);
                long j2 = j;
                if (worker != null) {
                    j2 = j;
                    if (worker == this) {
                        continue;
                    } else {
                        if (DebugKt.a()) {
                            if (!(this.a.b() == 0)) {
                                throw new AssertionError();
                            }
                        }
                        long b2 = z ? this.a.b(worker.a) : this.a.a(worker.a);
                        if (b2 == -1) {
                            return this.a.c();
                        }
                        j2 = j;
                        if (b2 > 0) {
                            j2 = Math.min(j, b2);
                        }
                    }
                }
                i2++;
                j = j2;
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.g = j;
            return null;
        }

        private final void c(int i) {
            if (i != 0 && a(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.b();
            }
        }

        private final boolean c() {
            boolean z;
            if (this.b == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            while (true) {
                long j = coroutineScheduler.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
                    if (CoroutineScheduler.i.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.b = WorkerState.CPU_ACQUIRED;
                return true;
            }
            return false;
        }

        private final void d() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.a() && this.b != WorkerState.TERMINATED) {
                    Task a = a(this.d);
                    if (a != null) {
                        this.g = 0L;
                        a(a);
                    } else {
                        this.d = false;
                        if (this.g == 0) {
                            e();
                        } else if (z) {
                            a(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.g);
                            this.g = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            a(WorkerState.TERMINATED);
        }

        private final void d(int i) {
            if (i == 0) {
                return;
            }
            CoroutineScheduler.i.addAndGet(CoroutineScheduler.this, -2097152L);
            WorkerState workerState = this.b;
            if (workerState != WorkerState.TERMINATED) {
                if (DebugKt.a()) {
                    if (!(workerState == WorkerState.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.b = WorkerState.DORMANT;
            }
        }

        private final void e() {
            if (!f()) {
                CoroutineScheduler.this.a(this);
                return;
            }
            if (DebugKt.a()) {
                if (!(this.a.b() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (f() && this.workerCtl == -1 && !CoroutineScheduler.this.a() && this.b != WorkerState.TERMINATED) {
                a(WorkerState.PARKING);
                Thread.interrupted();
                g();
            }
        }

        private final void e(int i) {
            this.f = 0L;
            if (this.b == WorkerState.PARKING) {
                if (DebugKt.a()) {
                    if (!(i == 1)) {
                        throw new AssertionError();
                    }
                }
                this.b = WorkerState.BLOCKING;
            }
        }

        private final boolean f() {
            return this.nextParkedWorker != CoroutineScheduler.j;
        }

        private final void g() {
            if (this.f == 0) {
                this.f = System.nanoTime() + CoroutineScheduler.this.d;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.d);
            if (System.nanoTime() - this.f >= 0) {
                this.f = 0L;
                h();
            }
        }

        private final void h() {
            AtomicReferenceArray<Worker> atomicReferenceArray = CoroutineScheduler.this.h;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (atomicReferenceArray) {
                if (coroutineScheduler.a()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & 2097151)) <= coroutineScheduler.b) {
                    return;
                }
                if (c.compareAndSet(this, -1, 1)) {
                    int a = a();
                    a(0);
                    coroutineScheduler.a(this, a, 0);
                    int andDecrement = (int) (CoroutineScheduler.i.getAndDecrement(coroutineScheduler) & 2097151);
                    if (andDecrement != a) {
                        Worker worker = coroutineScheduler.h.get(andDecrement);
                        Intrinsics.a(worker);
                        coroutineScheduler.h.set(a, worker);
                        worker.a(a);
                        coroutineScheduler.a(worker, andDecrement, a);
                    }
                    coroutineScheduler.h.set(andDecrement, null);
                    Unit unit = Unit.a;
                    this.b = WorkerState.TERMINATED;
                }
            }
        }

        private final Task i() {
            if (b(2) == 0) {
                Task c2 = CoroutineScheduler.this.f.c();
                Task task = c2;
                if (c2 == null) {
                    task = CoroutineScheduler.this.g.c();
                }
                return task;
            }
            Task c3 = CoroutineScheduler.this.g.c();
            Task task2 = c3;
            if (c3 == null) {
                task2 = CoroutineScheduler.this.f.c();
            }
            return task2;
        }

        public final int a() {
            return this.indexInArray;
        }

        public final Task a(boolean z) {
            Task c2;
            if (c()) {
                return b(z);
            }
            if (z) {
                Task c3 = this.a.c();
                c2 = c3;
                if (c3 == null) {
                    c2 = CoroutineScheduler.this.g.c();
                }
            } else {
                c2 = CoroutineScheduler.this.g.c();
            }
            Task task = c2;
            if (c2 == null) {
                task = c(true);
            }
            return task;
        }

        public final void a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.e);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void a(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean a(WorkerState workerState) {
            WorkerState workerState2 = this.b;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.i.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.b = workerState;
            }
            return z;
        }

        public final int b(int i) {
            int i2 = this.h;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.h = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final Object b() {
            return this.nextParkedWorker;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState.class */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static WorkerState[] valuesCustom() {
            WorkerState[] valuesCustom = values();
            return (WorkerState[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    public CoroutineScheduler(int i2, int i3, long j2, String str) {
        this.b = i2;
        this.c = i3;
        this.d = j2;
        this.e = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + this.b + " should be at least 1").toString());
        }
        if (!(this.c >= this.b)) {
            throw new IllegalArgumentException(("Max pool size " + this.c + " should be greater than or equals to core pool size " + this.b).toString());
        }
        if (!(this.c <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + this.c + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(this.d > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + this.d + " must be positive").toString());
        }
        this.f = new GlobalQueue();
        this.g = new GlobalQueue();
        this.parkedWorkersStack = 0L;
        this.h = new AtomicReferenceArray<>(this.c + 1);
        this.controlState = this.b << 42;
        this._isTerminated = 0;
    }

    private final Task a(Worker worker, Task task, boolean z) {
        if (worker != null && worker.b != WorkerState.TERMINATED) {
            if (task.g.b() == 0 && worker.b == WorkerState.BLOCKING) {
                return task;
            }
            worker.d = true;
            return worker.a.a(task, z);
        }
        return task;
    }

    public static /* synthetic */ void a(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            taskContext = NonBlockingContext.a;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.a(runnable, taskContext, z);
    }

    private final void a(boolean z) {
        long addAndGet = i.addAndGet(this, 2097152L);
        if (z || d() || b(addAndGet)) {
            return;
        }
        d();
    }

    static /* synthetic */ boolean a(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.b(j2);
    }

    private final int b(Worker worker) {
        Object b = worker.b();
        while (true) {
            Object obj = b;
            if (obj == j) {
                return -1;
            }
            if (obj == null) {
                return 0;
            }
            Worker worker2 = (Worker) obj;
            int a2 = worker2.a();
            if (a2 != 0) {
                return a2;
            }
            b = worker2.b();
        }
    }

    private final boolean b(long j2) {
        if (RangesKt.c(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.b) {
            int e = e();
            if (e == 1 && this.b > 1) {
                e();
            }
            return e > 0;
        }
        return false;
    }

    private final boolean b(Task task) {
        boolean z = true;
        if (task.g.b() != 1) {
            z = false;
        }
        return z ? this.g.a(task) : this.f.a(task);
    }

    private final Worker c() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            Worker worker = this.h.get((int) (2097151 & j2));
            if (worker == null) {
                return null;
            }
            int b = b(worker);
            if (b >= 0 && k.compareAndSet(this, j2, b | ((2097152 + j2) & (-2097152)))) {
                worker.a(j);
                return worker;
            }
        }
    }

    private final boolean d() {
        Worker c;
        do {
            c = c();
            if (c == null) {
                return false;
            }
        } while (!Worker.c.compareAndSet(c, -1, 0));
        LockSupport.unpark(c);
        return true;
    }

    private final int e() {
        synchronized (this.h) {
            if (a()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int c = RangesKt.c(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (c >= this.b) {
                return 0;
            }
            if (i2 >= this.c) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 > 0 && this.h.get(i3) == null) {
                Worker worker = new Worker(i3);
                this.h.set(i3, worker);
                boolean z = false;
                if (i3 == ((int) (2097151 & i.incrementAndGet(this)))) {
                    z = true;
                }
                if (z) {
                    worker.start();
                    return c + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final Worker f() {
        Thread currentThread = Thread.currentThread();
        Worker worker = null;
        Worker worker2 = currentThread instanceof Worker ? (Worker) currentThread : null;
        if (worker2 == null) {
            return null;
        }
        if (Intrinsics.a(CoroutineScheduler.this, this)) {
            worker = worker2;
        }
        return worker;
    }

    public final Task a(Runnable runnable, TaskContext taskContext) {
        long a2 = TasksKt.f.a();
        if (runnable instanceof Task) {
            Task task = (Task) runnable;
            task.f = a2;
            task.g = taskContext;
            return task;
        }
        return new TaskImpl(runnable, a2, taskContext);
    }

    public final void a(long j2) {
        int i2;
        if (l.compareAndSet(this, 0, 1)) {
            Worker f = f();
            synchronized (this.h) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3;
                    Worker worker = this.h.get(i4);
                    Intrinsics.a(worker);
                    if (worker != f) {
                        while (worker.isAlive()) {
                            LockSupport.unpark(worker);
                            worker.join(j2);
                        }
                        WorkerState workerState = worker.b;
                        if (DebugKt.a()) {
                            if (!(workerState == WorkerState.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        worker.a.a(this.g);
                    }
                    if (i4 == i2) {
                        break;
                    }
                    i3 = i4 + 1;
                }
            }
            this.g.b();
            this.f.b();
            while (true) {
                Task a2 = f == null ? null : f.a(true);
                Task task = a2;
                if (a2 == null) {
                    task = this.f.c();
                }
                Task task2 = task;
                if (task == null) {
                    Task c = this.g.c();
                    task2 = c;
                    if (c == null) {
                        break;
                    }
                }
                a(task2);
            }
            if (f != null) {
                f.a(WorkerState.TERMINATED);
            }
            if (DebugKt.a()) {
                boolean z = false;
                if (((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.b) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void a(Runnable runnable, TaskContext taskContext, boolean z) {
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 != null) {
            a2.b();
        }
        Task a3 = a(runnable, taskContext);
        Worker f = f();
        Task a4 = a(f, a3, z);
        if (a4 != null && !b(a4)) {
            throw new RejectedExecutionException(Intrinsics.a(this.e, (Object) " was terminated"));
        }
        boolean z2 = z && f != null;
        if (a3.g.b() != 0) {
            a(z2);
        } else if (z2) {
        } else {
            b();
        }
    }

    public final void a(Worker worker, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            int i5 = i4;
            if (i4 == i2) {
                i5 = i3 == 0 ? b(worker) : i3;
            }
            if (i5 >= 0 && k.compareAndSet(this, j2, ((2097152 + j2) & (-2097152)) | i5)) {
                return;
            }
        }
    }

    public final void a(Task task) {
        AbstractTimeSource a2;
        AbstractTimeSource abstractTimeSource;
        try {
            task.run();
            abstractTimeSource = a2;
            if (a2 == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                AbstractTimeSource a3 = AbstractTimeSourceKt.a();
                abstractTimeSource = a3;
                if (a3 == null) {
                    return;
                }
            } finally {
                a2 = AbstractTimeSourceKt.a();
                if (a2 != null) {
                    a2.c();
                }
            }
        }
        abstractTimeSource.c();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final boolean a() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final boolean a(Worker worker) {
        long j2;
        int a2;
        if (worker.b() != j) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            a2 = worker.a();
            if (DebugKt.a()) {
                if (!(a2 != 0)) {
                    throw new AssertionError();
                }
            }
            worker.a(this.h.get(i2));
        } while (!k.compareAndSet(this, j2, a2 | ((2097152 + j2) & (-2097152))));
        return true;
    }

    public final void b() {
        if (d() || a(this, 0L, 1, null)) {
            return;
        }
        d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        a(this, runnable, null, false, 6, null);
    }

    public String toString() {
        int i2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        int length = this.h.length();
        int i6 = 0;
        int i7 = 0;
        if (1 < length) {
            int i8 = 0;
            int i9 = 0;
            i4 = 0;
            int i10 = 0;
            int i11 = 1;
            while (true) {
                int i12 = i11;
                int i13 = i12 + 1;
                Worker worker = this.h.get(i12);
                if (worker == null) {
                    i2 = i7;
                    i3 = i8;
                    i6 = i9;
                    i5 = i10;
                } else {
                    int b = worker.a.b();
                    int i14 = WhenMappings.a[worker.b.ordinal()];
                    if (i14 == 1) {
                        i2 = i7 + 1;
                        i5 = i10;
                        i6 = i9;
                        i3 = i8;
                    } else if (i14 == 2) {
                        i3 = i8 + 1;
                        ArrayList arrayList2 = arrayList;
                        StringBuilder sb = new StringBuilder();
                        sb.append(b);
                        sb.append('b');
                        arrayList2.add(sb.toString());
                        i2 = i7;
                        i6 = i9;
                        i5 = i10;
                    } else if (i14 == 3) {
                        i6 = i9 + 1;
                        ArrayList arrayList3 = arrayList;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(b);
                        sb2.append('c');
                        arrayList3.add(sb2.toString());
                        i2 = i7;
                        i3 = i8;
                        i5 = i10;
                    } else if (i14 == 4) {
                        int i15 = i4 + 1;
                        i2 = i7;
                        i3 = i8;
                        i6 = i9;
                        i4 = i15;
                        i5 = i10;
                        if (b > 0) {
                            ArrayList arrayList4 = arrayList;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(b);
                            sb3.append('d');
                            arrayList4.add(sb3.toString());
                            i2 = i7;
                            i3 = i8;
                            i6 = i9;
                            i4 = i15;
                            i5 = i10;
                        }
                    } else if (i14 != 5) {
                        i2 = i7;
                        i3 = i8;
                        i6 = i9;
                        i5 = i10;
                    } else {
                        i5 = i10 + 1;
                        i2 = i7;
                        i3 = i8;
                        i6 = i9;
                    }
                }
                if (i13 >= length) {
                    break;
                }
                i7 = i2;
                i8 = i3;
                i9 = i6;
                i10 = i5;
                i11 = i13;
            }
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        long j2 = this.controlState;
        return this.e + '@' + DebugStringsKt.a(this) + "[Pool Size {core = " + this.b + ", max = " + this.c + "}, Worker States {CPU = " + i6 + ", blocking = " + i3 + ", parked = " + i2 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f.a() + ", global blocking queue size = " + this.g.a() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.b - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}
