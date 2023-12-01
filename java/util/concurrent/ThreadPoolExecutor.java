package java.util.concurrent;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ThreadPoolExecutor.class */
public class ThreadPoolExecutor extends AbstractExecutorService {
    private static final int CAPACITY = 536870911;
    private static final int COUNT_BITS = 29;
    private static final boolean ONLY_ONE = true;
    private static final int RUNNING = -536870912;
    private static final int SHUTDOWN = 0;
    private static final int STOP = 536870912;
    private static final int TERMINATED = 1610612736;
    private static final int TIDYING = 1073741824;
    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();
    private static final RuntimePermission shutdownPerm = new RuntimePermission("modifyThread");
    private volatile boolean allowCoreThreadTimeOut;
    private long completedTaskCount;
    private volatile int corePoolSize;
    private final AtomicInteger ctl;
    private volatile RejectedExecutionHandler handler;
    private volatile long keepAliveTime;
    private int largestPoolSize;
    private final ReentrantLock mainLock;
    private volatile int maximumPoolSize;
    private final Condition termination;
    private volatile ThreadFactory threadFactory;
    private final BlockingQueue<Runnable> workQueue;
    private final HashSet<Worker> workers;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ThreadPoolExecutor$AbortPolicy.class */
    public static class AbortPolicy implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + threadPoolExecutor.toString());
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ThreadPoolExecutor$CallerRunsPolicy.class */
    public static class CallerRunsPolicy implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            runnable.run();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ThreadPoolExecutor$DiscardOldestPolicy.class */
    public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            threadPoolExecutor.getQueue().poll();
            threadPoolExecutor.execute(runnable);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ThreadPoolExecutor$DiscardPolicy.class */
    public static class DiscardPolicy implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ThreadPoolExecutor$Worker.class */
    public final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        private static final long serialVersionUID = 6138294804551838833L;
        volatile long completedTasks;
        Runnable firstTask;
        final Thread thread;

        Worker(Runnable runnable) {
            setState(-1);
            this.firstTask = runnable;
            this.thread = ThreadPoolExecutor.this.getThreadFactory().newThread(this);
        }

        void interruptIfStarted() {
            Thread thread;
            if (getState() < 0 || (thread = this.thread) == null || thread.isInterrupted()) {
                return;
            }
            try {
                thread.interrupt();
            } catch (SecurityException e) {
            }
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean isHeldExclusively() {
            return getState() != 0;
        }

        public boolean isLocked() {
            return isHeldExclusively();
        }

        public void lock() {
            acquire(1);
        }

        @Override // java.lang.Runnable
        public void run() {
            ThreadPoolExecutor.this.runWorker(this);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryAcquire(int i) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        public boolean tryLock() {
            return tryAcquire(1);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryRelease(int i) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        public void unlock() {
            release(1);
        }
    }

    public ThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        this(i, i2, j, timeUnit, blockingQueue, Executors.defaultThreadFactory(), defaultHandler);
    }

    public ThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        this(i, i2, j, timeUnit, blockingQueue, Executors.defaultThreadFactory(), rejectedExecutionHandler);
    }

    public ThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, defaultHandler);
    }

    public ThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        this.ctl = new AtomicInteger(ctlOf(RUNNING, 0));
        this.mainLock = new ReentrantLock();
        this.workers = new HashSet<>();
        this.termination = this.mainLock.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw new NullPointerException();
        }
        this.corePoolSize = i;
        this.maximumPoolSize = i2;
        this.workQueue = blockingQueue;
        this.keepAliveTime = timeUnit.toNanos(j);
        this.threadFactory = threadFactory;
        this.handler = rejectedExecutionHandler;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bb, code lost:
        if (r6 == null) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013a A[Catch: all -> 0x00d6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00d6, blocks: (B:26:0x0086, B:29:0x0093, B:60:0x012e, B:63:0x013a, B:31:0x009f, B:37:0x00be, B:39:0x00c6, B:40:0x00cd, B:55:0x010d, B:57:0x0127), top: B:71:0x0086 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean addWorker(java.lang.Runnable r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ThreadPoolExecutor.addWorker(java.lang.Runnable, boolean):boolean");
    }

    private void addWorkerFailed(Worker worker) {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        if (worker != null) {
            try {
                this.workers.remove(worker);
            } finally {
                reentrantLock.unlock();
            }
        }
        decrementWorkerCount();
        tryTerminate();
    }

    private void advanceRunState(int i) {
        int i2;
        do {
            i2 = this.ctl.get();
            if (runStateAtLeast(i2, i)) {
                return;
            }
        } while (!this.ctl.compareAndSet(i2, ctlOf(i, workerCountOf(i2))));
    }

    private void checkShutdownAccess() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(shutdownPerm);
            ReentrantLock reentrantLock = this.mainLock;
            reentrantLock.lock();
            try {
                Iterator<Worker> it = this.workers.iterator();
                while (it.hasNext()) {
                    securityManager.checkAccess(it.next().thread);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private boolean compareAndDecrementWorkerCount(int i) {
        return this.ctl.compareAndSet(i, i - 1);
    }

    private boolean compareAndIncrementWorkerCount(int i) {
        return this.ctl.compareAndSet(i, i + 1);
    }

    private static int ctlOf(int i, int i2) {
        return i | i2;
    }

    private void decrementWorkerCount() {
        do {
        } while (!compareAndDecrementWorkerCount(this.ctl.get()));
    }

    private List<Runnable> drainQueue() {
        BlockingQueue<Runnable> blockingQueue = this.workQueue;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            Runnable[] runnableArr = (Runnable[]) blockingQueue.toArray(new Runnable[0]);
            int length = runnableArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Runnable runnable = runnableArr[i2];
                if (blockingQueue.remove(runnable)) {
                    arrayList.add(runnable);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        decrementWorkerCount();
        r11 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Runnable getTask() {
        /*
            r5 = this;
            r0 = 0
            r6 = r0
        L2:
            r0 = r5
            java.util.concurrent.atomic.AtomicInteger r0 = r0.ctl
            int r0 = r0.get()
            r8 = r0
            r0 = r8
            int r0 = runStateOf(r0)
            r7 = r0
            r0 = r7
            if (r0 < 0) goto L2f
            r0 = r7
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            if (r0 >= r1) goto L25
            r0 = r5
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r0 = r0.workQueue
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L2f
        L25:
            r0 = r5
            r0.decrementWorkerCount()
            r0 = 0
            r11 = r0
        L2c:
            r0 = r11
            return r0
        L2f:
            r0 = r8
            int r0 = workerCountOf(r0)
            r9 = r0
            r0 = r5
            boolean r0 = r0.allowCoreThreadTimeOut
            if (r0 != 0) goto L45
            r0 = r9
            r1 = r5
            int r1 = r1.corePoolSize
            if (r0 <= r1) goto L74
        L45:
            r0 = 1
            r7 = r0
        L47:
            r0 = r9
            r1 = r5
            int r1 = r1.maximumPoolSize
            if (r0 > r1) goto L58
            r0 = r7
            if (r0 == 0) goto L79
            r0 = r6
            if (r0 == 0) goto L79
        L58:
            r0 = r9
            r1 = 1
            if (r0 > r1) goto L6a
            r0 = r5
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r0 = r0.workQueue
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L79
        L6a:
            r0 = r5
            r1 = r8
            boolean r0 = r0.compareAndDecrementWorkerCount(r1)
            if (r0 == 0) goto L2
            r0 = 0
            return r0
        L74:
            r0 = 0
            r7 = r0
            goto L47
        L79:
            r0 = r7
            if (r0 == 0) goto L95
            r0 = r5
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r0 = r0.workQueue     // Catch: java.lang.InterruptedException -> La6
            r1 = r5
            long r1 = r1.keepAliveTime     // Catch: java.lang.InterruptedException -> La6
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.InterruptedException -> La6
            java.lang.Object r0 = r0.poll(r1, r2)     // Catch: java.lang.InterruptedException -> La6
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch: java.lang.InterruptedException -> La6
            r10 = r0
            goto Lad
        L95:
            r0 = r5
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r0 = r0.workQueue     // Catch: java.lang.InterruptedException -> La6
            java.lang.Object r0 = r0.take()     // Catch: java.lang.InterruptedException -> La6
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch: java.lang.InterruptedException -> La6
            r10 = r0
            goto Lad
        La6:
            r10 = move-exception
            r0 = 0
            r6 = r0
            goto L2
        Lad:
            r0 = r10
            r11 = r0
            r0 = r10
            if (r0 != 0) goto L2c
            r0 = 1
            r6 = r0
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ThreadPoolExecutor.getTask():java.lang.Runnable");
    }

    private void interruptIdleWorkers() {
        interruptIdleWorkers(false);
    }

    private void interruptIdleWorkers(boolean z) {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            Iterator<Worker> it = this.workers.iterator();
            do {
                if (!it.hasNext()) {
                    break;
                }
                Worker next = it.next();
                Thread thread = next.thread;
                if (!thread.isInterrupted() && next.tryLock()) {
                    try {
                        thread.interrupt();
                        next.unlock();
                    } catch (SecurityException e) {
                        next.unlock();
                    } catch (Throwable th) {
                        next.unlock();
                        throw th;
                    }
                }
            } while (!z);
        } finally {
            reentrantLock.unlock();
        }
    }

    private void interruptWorkers() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            Iterator<Worker> it = this.workers.iterator();
            while (it.hasNext()) {
                it.next().interruptIfStarted();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private static boolean isRunning(int i) {
        return i < 0;
    }

    private void processWorkerExit(Worker worker, boolean z) {
        if (z) {
            decrementWorkerCount();
        }
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            this.completedTaskCount += worker.completedTasks;
            this.workers.remove(worker);
            reentrantLock.unlock();
            tryTerminate();
            int i = this.ctl.get();
            if (runStateLessThan(i, 536870912)) {
                if (!z) {
                    int i2 = this.allowCoreThreadTimeOut ? 0 : this.corePoolSize;
                    int i3 = i2;
                    if (i2 == 0) {
                        i3 = i2;
                        if (!this.workQueue.isEmpty()) {
                            i3 = 1;
                        }
                    }
                    if (workerCountOf(i) >= i3) {
                        return;
                    }
                }
                addWorker(null, false);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private static boolean runStateAtLeast(int i, int i2) {
        return i >= i2;
    }

    private static boolean runStateLessThan(int i, int i2) {
        return i < i2;
    }

    private static int runStateOf(int i) {
        return RUNNING & i;
    }

    private static int workerCountOf(int i) {
        return 536870911 & i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
    }

    public void allowCoreThreadTimeOut(boolean z) {
        if (z && this.keepAliveTime <= 0) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        if (z != this.allowCoreThreadTimeOut) {
            this.allowCoreThreadTimeOut = z;
            if (z) {
                interruptIdleWorkers();
            }
        }
    }

    public boolean allowsCoreThreadTimeOut() {
        return this.allowCoreThreadTimeOut;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        while (!runStateAtLeast(this.ctl.get(), TERMINATED)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.termination.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensurePrestart() {
        int workerCountOf = workerCountOf(this.ctl.get());
        if (workerCountOf < this.corePoolSize) {
            addWorker(null, true);
        } else if (workerCountOf == 0) {
            addWorker(null, false);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        int i = this.ctl.get();
        int i2 = i;
        if (workerCountOf(i) < this.corePoolSize) {
            if (addWorker(runnable, true)) {
                return;
            }
            i2 = this.ctl.get();
        }
        if (!isRunning(i2) || !this.workQueue.offer(runnable)) {
            if (addWorker(runnable, false)) {
                return;
            }
            reject(runnable);
            return;
        }
        int i3 = this.ctl.get();
        if (!isRunning(i3) && remove(runnable)) {
            reject(runnable);
        } else if (workerCountOf(i3) == 0) {
            addWorker(null, false);
        }
    }

    protected void finalize() {
        shutdown();
    }

    public int getActiveCount() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        int i = 0;
        try {
            Iterator<Worker> it = this.workers.iterator();
            while (it.hasNext()) {
                if (it.next().isLocked()) {
                    i++;
                }
            }
            reentrantLock.unlock();
            return i;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public long getCompletedTaskCount() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            long j = this.completedTaskCount;
            Iterator<Worker> it = this.workers.iterator();
            while (it.hasNext()) {
                j += it.next().completedTasks;
            }
            reentrantLock.unlock();
            return j;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.keepAliveTime, TimeUnit.NANOSECONDS);
    }

    public int getLargestPoolSize() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            return this.largestPoolSize;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    public int getPoolSize() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            int size = runStateAtLeast(this.ctl.get(), 1073741824) ? 0 : this.workers.size();
            reentrantLock.unlock();
            return size;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public BlockingQueue<Runnable> getQueue() {
        return this.workQueue;
    }

    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.handler;
    }

    /* JADX WARN: Finally extract failed */
    public long getTaskCount() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            long j = this.completedTaskCount;
            Iterator<Worker> it = this.workers.iterator();
            while (it.hasNext()) {
                Worker next = it.next();
                long j2 = j + next.completedTasks;
                j = j2;
                if (next.isLocked()) {
                    j = j2 + 1;
                }
            }
            long size = this.workQueue.size();
            reentrantLock.unlock();
            return size + j;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public ThreadFactory getThreadFactory() {
        return this.threadFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isRunningOrShutdown(boolean z) {
        int runStateOf = runStateOf(this.ctl.get());
        if (runStateOf != RUNNING) {
            return runStateOf == 0 && z;
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !isRunning(this.ctl.get());
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return runStateAtLeast(this.ctl.get(), TERMINATED);
    }

    public boolean isTerminating() {
        int i = this.ctl.get();
        return !isRunning(i) && runStateLessThan(i, TERMINATED);
    }

    void onShutdown() {
    }

    public int prestartAllCoreThreads() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (!addWorker(null, true)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public boolean prestartCoreThread() {
        return workerCountOf(this.ctl.get()) < this.corePoolSize && addWorker(null, true);
    }

    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.workQueue;
        try {
            Iterator<Runnable> it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable next = it.next();
                if ((next instanceof Future) && ((Future) next).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException e) {
            Object[] array = blockingQueue.toArray();
            int length = array.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Object obj = array[i2];
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
                i = i2 + 1;
            }
        }
        tryTerminate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void reject(Runnable runnable) {
        this.handler.rejectedExecution(runnable, this);
    }

    public boolean remove(Runnable runnable) {
        boolean remove = this.workQueue.remove(runnable);
        tryTerminate();
        return remove;
    }

    final void runWorker(Worker worker) {
        Thread currentThread = Thread.currentThread();
        Runnable runnable = worker.firstTask;
        worker.firstTask = null;
        worker.unlock();
        while (true) {
            Runnable runnable2 = runnable;
            if (runnable == null) {
                try {
                    runnable2 = getTask();
                    if (runnable2 == null) {
                        processWorkerExit(worker, false);
                        return;
                    }
                } catch (Throwable th) {
                    processWorkerExit(worker, true);
                    throw th;
                }
            }
            worker.lock();
            if ((runStateAtLeast(this.ctl.get(), 536870912) || (Thread.interrupted() && runStateAtLeast(this.ctl.get(), 536870912))) && !currentThread.isInterrupted()) {
                currentThread.interrupt();
            }
            beforeExecute(currentThread, runnable2);
            try {
                try {
                    runnable2.run();
                    afterExecute(runnable2, null);
                    runnable = null;
                    worker.completedTasks++;
                    worker.unlock();
                } catch (Error e) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            }
        }
    }

    public void setCorePoolSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int i2 = i - this.corePoolSize;
        this.corePoolSize = i;
        if (workerCountOf(this.ctl.get()) > i) {
            interruptIdleWorkers();
        } else if (i2 <= 0) {
        } else {
            int min = Math.min(i2, this.workQueue.size());
            while (true) {
                int i3 = min;
                if (i3 <= 0 || !addWorker(null, true) || this.workQueue.isEmpty()) {
                    return;
                }
                min = i3 - 1;
            }
        }
    }

    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        long nanos = timeUnit.toNanos(j);
        long j2 = this.keepAliveTime;
        this.keepAliveTime = nanos;
        if (nanos - j2 < 0) {
            interruptIdleWorkers();
        }
    }

    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < this.corePoolSize) {
            throw new IllegalArgumentException();
        }
        this.maximumPoolSize = i;
        if (workerCountOf(this.ctl.get()) > i) {
            interruptIdleWorkers();
        }
    }

    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        if (rejectedExecutionHandler == null) {
            throw new NullPointerException();
        }
        this.handler = rejectedExecutionHandler;
    }

    public void setThreadFactory(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException();
        }
        this.threadFactory = threadFactory;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            checkShutdownAccess();
            advanceRunState(0);
            interruptIdleWorkers();
            onShutdown();
            reentrantLock.unlock();
            tryTerminate();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            checkShutdownAccess();
            advanceRunState(536870912);
            interruptWorkers();
            List<Runnable> drainQueue = drainQueue();
            reentrantLock.unlock();
            tryTerminate();
            return drainQueue;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    protected void terminated() {
    }

    public String toString() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            long j = this.completedTaskCount;
            int i = 0;
            int size = this.workers.size();
            Iterator<Worker> it = this.workers.iterator();
            while (it.hasNext()) {
                Worker next = it.next();
                long j2 = j + next.completedTasks;
                j = j2;
                if (next.isLocked()) {
                    i++;
                    j = j2;
                }
            }
            reentrantLock.unlock();
            int i2 = this.ctl.get();
            return super.toString() + "[" + (runStateLessThan(i2, 0) ? "Running" : runStateAtLeast(i2, TERMINATED) ? "Terminated" : "Shutting down") + ", pool size = " + size + ", active threads = " + i + ", queued tasks = " + this.workQueue.size() + ", completed tasks = " + j + "]";
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void tryTerminate() {
        while (true) {
            int i = this.ctl.get();
            if (isRunning(i) || runStateAtLeast(i, 1073741824)) {
                return;
            }
            if (runStateOf(i) == 0 && !this.workQueue.isEmpty()) {
                return;
            }
            if (workerCountOf(i) != 0) {
                interruptIdleWorkers(true);
                return;
            }
            ReentrantLock reentrantLock = this.mainLock;
            reentrantLock.lock();
            try {
                if (this.ctl.compareAndSet(i, ctlOf(1073741824, 0))) {
                    terminated();
                    this.ctl.set(ctlOf(TERMINATED, 0));
                    this.termination.signalAll();
                    return;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
