package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/scheduling/WorkQueue.class */
public final class WorkQueue {
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f43588c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    private static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<Task> f43589a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    private final long a(WorkQueue workQueue, boolean z) {
        Task task;
        do {
            task = (Task) workQueue.lastScheduledTask;
            if (task == null) {
                return -2L;
            }
            if (z) {
                boolean z2 = true;
                if (task.g.b() != 1) {
                    z2 = false;
                }
                if (!z2) {
                    return -2L;
                }
            }
            long a2 = TasksKt.f.a() - task.f;
            if (a2 < TasksKt.f43586a) {
                return TasksKt.f43586a - a2;
            }
        } while (!b.compareAndSet(workQueue, task, null));
        a(this, task, false, 2, null);
        return -1L;
    }

    private final Task a(Task task) {
        boolean z = true;
        if (task.g.b() != 1) {
            z = false;
        }
        if (z) {
            e.incrementAndGet(this);
        }
        if (a() == 127) {
            return task;
        }
        int i = this.producerIndex & 127;
        while (this.f43589a.get(i) != null) {
            Thread.yield();
        }
        this.f43589a.lazySet(i, task);
        f43588c.incrementAndGet(this);
        return null;
    }

    public static /* synthetic */ Task a(WorkQueue workQueue, Task task, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return workQueue.a(task, z);
    }

    private final void b(Task task) {
        if (task != null) {
            if (task.g.b() == 1) {
                int decrementAndGet = e.decrementAndGet(this);
                if (DebugKt.a()) {
                    boolean z = false;
                    if (decrementAndGet >= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final boolean b(GlobalQueue globalQueue) {
        Task d2 = d();
        if (d2 == null) {
            return false;
        }
        globalQueue.a(d2);
        return true;
    }

    private final Task d() {
        Task andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.f43589a.getAndSet(i & 127, null)) != null) {
                b(andSet);
                return andSet;
            }
        }
    }

    public final int a() {
        return this.producerIndex - this.consumerIndex;
    }

    public final long a(WorkQueue workQueue) {
        if (DebugKt.a()) {
            if (!(a() == 0)) {
                throw new AssertionError();
            }
        }
        Task d2 = workQueue.d();
        if (d2 != null) {
            Task a2 = a(this, d2, false, 2, null);
            if (DebugKt.a()) {
                if (a2 == null) {
                    return -1L;
                }
                throw new AssertionError();
            }
            return -1L;
        }
        return a(workQueue, false);
    }

    public final Task a(Task task, boolean z) {
        if (z) {
            return a(task);
        }
        Task task2 = (Task) b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return a(task2);
    }

    public final void a(GlobalQueue globalQueue) {
        Task task = (Task) b.getAndSet(this, null);
        if (task != null) {
            globalQueue.a(task);
        }
        do {
        } while (b(globalQueue));
    }

    public final int b() {
        return this.lastScheduledTask != null ? a() + 1 : a();
    }

    public final long b(WorkQueue workQueue) {
        if (DebugKt.a()) {
            if (!(a() == 0)) {
                throw new AssertionError();
            }
        }
        int i = workQueue.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = workQueue.f43589a;
        for (int i2 = workQueue.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (workQueue.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i3);
            if (task != null) {
                if ((task.g.b() == 1) && atomicReferenceArray.compareAndSet(i3, task, null)) {
                    e.decrementAndGet(workQueue);
                    a(this, task, false, 2, null);
                    return -1L;
                }
            }
        }
        return a(workQueue, true);
    }

    public final Task c() {
        Task task = (Task) b.getAndSet(this, null);
        Task task2 = task;
        if (task == null) {
            task2 = d();
        }
        return task2;
    }
}
