package java.util.concurrent;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ScheduledThreadPoolExecutor.class */
public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService {
    private static final AtomicLong sequencer = new AtomicLong();
    private volatile boolean continueExistingPeriodicTasksAfterShutdown;
    private volatile boolean executeExistingDelayedTasksAfterShutdown;
    private volatile boolean removeOnCancel;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ScheduledThreadPoolExecutor$DelayedWorkQueue.class */
    static class DelayedWorkQueue extends AbstractQueue<Runnable> implements BlockingQueue<Runnable> {
        private static final int INITIAL_CAPACITY = 16;
        private RunnableScheduledFuture<?>[] queue = new RunnableScheduledFuture[16];
        private final ReentrantLock lock = new ReentrantLock();
        private int size = 0;
        private Thread leader = null;
        private final Condition available = this.lock.newCondition();

        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ScheduledThreadPoolExecutor$DelayedWorkQueue$Itr.class */
        private class Itr implements Iterator<Runnable> {
            final RunnableScheduledFuture[] array;
            int cursor = 0;
            int lastRet = -1;

            Itr(RunnableScheduledFuture[] runnableScheduledFutureArr) {
                this.array = runnableScheduledFutureArr;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.cursor < this.array.length;
            }

            @Override // java.util.Iterator
            public Runnable next() {
                if (this.cursor >= this.array.length) {
                    throw new NoSuchElementException();
                }
                this.lastRet = this.cursor;
                RunnableScheduledFuture[] runnableScheduledFutureArr = this.array;
                int i = this.cursor;
                this.cursor = i + 1;
                return runnableScheduledFutureArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.lastRet < 0) {
                    throw new IllegalStateException();
                }
                DelayedWorkQueue.this.remove(this.array[this.lastRet]);
                this.lastRet = -1;
            }
        }

        DelayedWorkQueue() {
        }

        private RunnableScheduledFuture<?> finishPoll(RunnableScheduledFuture<?> runnableScheduledFuture) {
            int i = this.size - 1;
            this.size = i;
            RunnableScheduledFuture<?> runnableScheduledFuture2 = this.queue[i];
            this.queue[i] = null;
            if (i != 0) {
                siftDown(0, runnableScheduledFuture2);
            }
            setIndex(runnableScheduledFuture, -1);
            return runnableScheduledFuture;
        }

        private void grow() {
            int length = this.queue.length;
            int i = length + (length >> 1);
            int i2 = i;
            if (i < 0) {
                i2 = Integer.MAX_VALUE;
            }
            this.queue = (RunnableScheduledFuture[]) Arrays.copyOf(this.queue, i2);
        }

        private int indexOf(Object obj) {
            int i;
            if (obj != null) {
                if (obj instanceof ScheduledFutureTask) {
                    i = ((ScheduledFutureTask) obj).heapIndex;
                    if (i < 0 || i >= this.size || this.queue[i] != obj) {
                        return -1;
                    }
                } else {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= this.size) {
                            return -1;
                        }
                        i = i3;
                        if (obj.equals(this.queue[i3])) {
                            break;
                        }
                        i2 = i3 + 1;
                    }
                }
                return i;
            }
            return -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
            if (r0.getDelay(java.util.concurrent.TimeUnit.NANOSECONDS) > 0) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.util.concurrent.RunnableScheduledFuture<?> peekExpired() {
            /*
                r5 = this;
                r0 = r5
                java.util.concurrent.RunnableScheduledFuture<?>[] r0 = r0.queue
                r1 = 0
                r0 = r0[r1]
                r7 = r0
                r0 = r7
                if (r0 == 0) goto L1b
                r0 = r7
                r6 = r0
                r0 = r7
                java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
                long r0 = r0.getDelay(r1)
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L1d
            L1b:
                r0 = 0
                r6 = r0
            L1d:
                r0 = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ScheduledThreadPoolExecutor.DelayedWorkQueue.peekExpired():java.util.concurrent.RunnableScheduledFuture");
        }

        private void setIndex(RunnableScheduledFuture<?> runnableScheduledFuture, int i) {
            if (runnableScheduledFuture instanceof ScheduledFutureTask) {
                ((ScheduledFutureTask) runnableScheduledFuture).heapIndex = i;
            }
        }

        private void siftDown(int i, RunnableScheduledFuture<?> runnableScheduledFuture) {
            int i2;
            int i3 = this.size;
            while (true) {
                i2 = i;
                if (i2 >= (i3 >>> 1)) {
                    break;
                }
                int i4 = (i2 << 1) + 1;
                RunnableScheduledFuture<?> runnableScheduledFuture2 = this.queue[i4];
                int i5 = i4 + 1;
                RunnableScheduledFuture<?> runnableScheduledFuture3 = runnableScheduledFuture2;
                i = i4;
                if (i5 < this.size) {
                    runnableScheduledFuture3 = runnableScheduledFuture2;
                    i = i4;
                    if (runnableScheduledFuture2.compareTo(this.queue[i5]) > 0) {
                        i = i5;
                        runnableScheduledFuture3 = this.queue[i5];
                    }
                }
                if (runnableScheduledFuture.compareTo(runnableScheduledFuture3) <= 0) {
                    break;
                }
                this.queue[i2] = runnableScheduledFuture3;
                setIndex(runnableScheduledFuture3, i2);
            }
            this.queue[i2] = runnableScheduledFuture;
            setIndex(runnableScheduledFuture, i2);
        }

        private void siftUp(int i, RunnableScheduledFuture<?> runnableScheduledFuture) {
            while (i > 0) {
                int i2 = (i - 1) >>> 1;
                RunnableScheduledFuture<?> runnableScheduledFuture2 = this.queue[i2];
                if (runnableScheduledFuture.compareTo(runnableScheduledFuture2) >= 0) {
                    break;
                }
                this.queue[i] = runnableScheduledFuture2;
                setIndex(runnableScheduledFuture2, i);
                i = i2;
            }
            this.queue[i] = runnableScheduledFuture;
            setIndex(runnableScheduledFuture, i);
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public boolean add(Runnable runnable) {
            return offer(runnable);
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= this.size) {
                        this.size = 0;
                        return;
                    }
                    RunnableScheduledFuture<?> runnableScheduledFuture = this.queue[i2];
                    if (runnableScheduledFuture != null) {
                        this.queue[i2] = null;
                        setIndex(runnableScheduledFuture, -1);
                    }
                    i = i2 + 1;
                } finally {
                    reentrantLock.unlock();
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                boolean z = indexOf(obj) != -1;
                reentrantLock.unlock();
                return z;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Override // java.util.concurrent.BlockingQueue
        public int drainTo(Collection<? super Runnable> collection) {
            if (collection == null) {
                throw new NullPointerException();
            }
            if (collection == this) {
                throw new IllegalArgumentException();
            }
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    RunnableScheduledFuture<?> peekExpired = peekExpired();
                    if (peekExpired == null) {
                        return i2;
                    }
                    collection.add(peekExpired);
                    finishPoll(peekExpired);
                    i = i2 + 1;
                } finally {
                    reentrantLock.unlock();
                }
            }
        }

        @Override // java.util.concurrent.BlockingQueue
        public int drainTo(Collection<? super Runnable> collection, int i) {
            int i2;
            if (collection == null) {
                throw new NullPointerException();
            }
            if (collection == this) {
                throw new IllegalArgumentException();
            }
            if (i <= 0) {
                return 0;
            }
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= i) {
                    break;
                }
                try {
                    RunnableScheduledFuture<?> peekExpired = peekExpired();
                    if (peekExpired == null) {
                        break;
                    }
                    collection.add(peekExpired);
                    finishPoll(peekExpired);
                    i3 = i2 + 1;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Runnable> iterator() {
            return new Itr((RunnableScheduledFuture[]) Arrays.copyOf(this.queue, this.size));
        }

        @Override // java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            RunnableScheduledFuture<?> runnableScheduledFuture = (RunnableScheduledFuture) runnable;
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int i = this.size;
                if (i >= this.queue.length) {
                    grow();
                }
                this.size = i + 1;
                if (i == 0) {
                    this.queue[0] = runnableScheduledFuture;
                    setIndex(runnableScheduledFuture, 0);
                } else {
                    siftUp(i, runnableScheduledFuture);
                }
                if (this.queue[0] == runnableScheduledFuture) {
                    this.leader = null;
                    this.available.signal();
                }
                reentrantLock.unlock();
                return true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Override // java.util.concurrent.BlockingQueue
        public boolean offer(Runnable runnable, long j, TimeUnit timeUnit) {
            return offer(runnable);
        }

        @Override // java.util.Queue
        public RunnableScheduledFuture<?> peek() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return this.queue[0];
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Queue
        public RunnableScheduledFuture<?> poll() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                RunnableScheduledFuture<?> runnableScheduledFuture = this.queue[0];
                if (runnableScheduledFuture == null || runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS) > 0) {
                    reentrantLock.unlock();
                    return null;
                }
                return finishPoll(runnableScheduledFuture);
            } finally {
                reentrantLock.unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
            r0 = finishPoll(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
            if (r7.leader != null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
            if (r7.queue[0] == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
            r7.available.signal();
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
            r0.unlock();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
            return r0;
         */
        /* JADX WARN: Finally extract failed */
        @Override // java.util.concurrent.BlockingQueue
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Runnable poll(long r8, java.util.concurrent.TimeUnit r10) throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 312
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ScheduledThreadPoolExecutor.DelayedWorkQueue.poll(long, java.util.concurrent.TimeUnit):java.util.concurrent.RunnableScheduledFuture");
        }

        @Override // java.util.concurrent.BlockingQueue
        public void put(Runnable runnable) {
            offer(runnable);
        }

        @Override // java.util.concurrent.BlockingQueue
        public int remainingCapacity() {
            return Integer.MAX_VALUE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int indexOf = indexOf(obj);
                if (indexOf < 0) {
                    reentrantLock.unlock();
                    return false;
                }
                setIndex(this.queue[indexOf], -1);
                int i = this.size - 1;
                this.size = i;
                RunnableScheduledFuture<?> runnableScheduledFuture = this.queue[i];
                this.queue[i] = null;
                if (i != indexOf) {
                    siftDown(indexOf, runnableScheduledFuture);
                    if (this.queue[indexOf] == runnableScheduledFuture) {
                        siftUp(indexOf, runnableScheduledFuture);
                    }
                }
                reentrantLock.unlock();
                return true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return this.size;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.concurrent.BlockingQueue
        public Runnable take() throws InterruptedException {
            RunnableScheduledFuture<?> runnableScheduledFuture;
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    runnableScheduledFuture = this.queue[0];
                    if (runnableScheduledFuture == null) {
                        this.available.await();
                    } else {
                        long delay = runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS);
                        if (delay <= 0) {
                            break;
                        } else if (this.leader != null) {
                            this.available.await();
                        } else {
                            Thread currentThread = Thread.currentThread();
                            this.leader = currentThread;
                            this.available.awaitNanos(delay);
                            if (this.leader == currentThread) {
                                this.leader = null;
                            }
                        }
                    }
                } finally {
                    if (this.leader == null && this.queue[(char) 0] != null) {
                        this.available.signal();
                    }
                    reentrantLock.unlock();
                }
            }
            return finishPoll(runnableScheduledFuture);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return Arrays.copyOf(this.queue, this.size, Object[].class);
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (tArr.length < this.size) {
                    return (T[]) Arrays.copyOf(this.queue, this.size, tArr.getClass());
                }
                System.arraycopy(this.queue, 0, tArr, 0, this.size);
                if (tArr.length > this.size) {
                    tArr[this.size] = null;
                }
                return tArr;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ScheduledThreadPoolExecutor$ScheduledFutureTask.class */
    public class ScheduledFutureTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
        int heapIndex;
        RunnableScheduledFuture<V> outerTask;
        private final long period;
        private final long sequenceNumber;
        private long time;

        ScheduledFutureTask(Runnable runnable, V v, long j) {
            super(runnable, v);
            this.outerTask = this;
            this.time = j;
            this.period = 0L;
            this.sequenceNumber = ScheduledThreadPoolExecutor.sequencer.getAndIncrement();
        }

        ScheduledFutureTask(Runnable runnable, V v, long j, long j2) {
            super(runnable, v);
            this.outerTask = this;
            this.time = j;
            this.period = j2;
            this.sequenceNumber = ScheduledThreadPoolExecutor.sequencer.getAndIncrement();
        }

        ScheduledFutureTask(Callable<V> callable, long j) {
            super(callable);
            this.outerTask = this;
            this.time = j;
            this.period = 0L;
            this.sequenceNumber = ScheduledThreadPoolExecutor.sequencer.getAndIncrement();
        }

        private void setNextRunTime() {
            long j = this.period;
            if (j > 0) {
                this.time += j;
            } else {
                this.time = ScheduledThreadPoolExecutor.this.triggerTime(-j);
            }
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            boolean cancel = super.cancel(z);
            if (cancel && ScheduledThreadPoolExecutor.this.removeOnCancel && this.heapIndex >= 0) {
                ScheduledThreadPoolExecutor.this.remove(this);
            }
            return cancel;
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            int i;
            if (delayed == this) {
                i = 0;
            } else if (delayed instanceof ScheduledFutureTask) {
                ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask) delayed;
                long j = this.time - scheduledFutureTask.time;
                i = -1;
                if (j >= 0) {
                    if (j > 0) {
                        return 1;
                    }
                    i = -1;
                    if (this.sequenceNumber >= scheduledFutureTask.sequenceNumber) {
                        return 1;
                    }
                }
            } else {
                long delay = getDelay(TimeUnit.NANOSECONDS) - delayed.getDelay(TimeUnit.NANOSECONDS);
                i = -1;
                if (delay >= 0) {
                    return delay > 0 ? 1 : 0;
                }
            }
            return i;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.time - ScheduledThreadPoolExecutor.this.now(), TimeUnit.NANOSECONDS);
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return this.period != 0;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            boolean isPeriodic = isPeriodic();
            if (!ScheduledThreadPoolExecutor.this.canRunInCurrentRunState(isPeriodic)) {
                cancel(false);
            } else if (!isPeriodic) {
                super.run();
            } else if (super.runAndReset()) {
                setNextRunTime();
                ScheduledThreadPoolExecutor.this.reExecutePeriodic(this.outerTask);
            }
        }
    }

    public ScheduledThreadPoolExecutor(int i) {
        super(i, Integer.MAX_VALUE, 0L, TimeUnit.NANOSECONDS, new DelayedWorkQueue());
        this.executeExistingDelayedTasksAfterShutdown = true;
        this.removeOnCancel = false;
    }

    public ScheduledThreadPoolExecutor(int i, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, Integer.MAX_VALUE, 0L, TimeUnit.NANOSECONDS, new DelayedWorkQueue(), rejectedExecutionHandler);
        this.executeExistingDelayedTasksAfterShutdown = true;
        this.removeOnCancel = false;
    }

    public ScheduledThreadPoolExecutor(int i, ThreadFactory threadFactory) {
        super(i, Integer.MAX_VALUE, 0L, TimeUnit.NANOSECONDS, new DelayedWorkQueue(), threadFactory);
        this.executeExistingDelayedTasksAfterShutdown = true;
        this.removeOnCancel = false;
    }

    public ScheduledThreadPoolExecutor(int i, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, Integer.MAX_VALUE, 0L, TimeUnit.NANOSECONDS, new DelayedWorkQueue(), threadFactory, rejectedExecutionHandler);
        this.executeExistingDelayedTasksAfterShutdown = true;
        this.removeOnCancel = false;
    }

    private void delayedExecute(RunnableScheduledFuture<?> runnableScheduledFuture) {
        if (isShutdown()) {
            reject(runnableScheduledFuture);
            return;
        }
        super.getQueue().add(runnableScheduledFuture);
        if (isShutdown() && !canRunInCurrentRunState(runnableScheduledFuture.isPeriodic()) && remove(runnableScheduledFuture)) {
            runnableScheduledFuture.cancel(false);
        } else {
            ensurePrestart();
        }
    }

    private long overflowFree(long j) {
        Delayed delayed = (Delayed) super.getQueue().peek();
        long j2 = j;
        if (delayed != null) {
            long delay = delayed.getDelay(TimeUnit.NANOSECONDS);
            j2 = j;
            if (delay < 0) {
                j2 = j;
                if (j - delay < 0) {
                    j2 = Long.MAX_VALUE + delay;
                }
            }
        }
        return j2;
    }

    private long triggerTime(long j, TimeUnit timeUnit) {
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        return triggerTime(timeUnit.toNanos(j2));
    }

    boolean canRunInCurrentRunState(boolean z) {
        return isRunningOrShutdown(z ? this.continueExistingPeriodicTasksAfterShutdown : this.executeExistingDelayedTasksAfterShutdown);
    }

    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return runnableScheduledFuture;
    }

    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return runnableScheduledFuture;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() {
        return this.continueExistingPeriodicTasksAfterShutdown;
    }

    public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() {
        return this.executeExistingDelayedTasksAfterShutdown;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public BlockingQueue<Runnable> getQueue() {
        return super.getQueue();
    }

    public boolean getRemoveOnCancelPolicy() {
        return this.removeOnCancel;
    }

    final long now() {
        return System.nanoTime();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    void onShutdown() {
        BlockingQueue<Runnable> queue = super.getQueue();
        boolean executeExistingDelayedTasksAfterShutdownPolicy = getExecuteExistingDelayedTasksAfterShutdownPolicy();
        boolean continueExistingPeriodicTasksAfterShutdownPolicy = getContinueExistingPeriodicTasksAfterShutdownPolicy();
        if (executeExistingDelayedTasksAfterShutdownPolicy || continueExistingPeriodicTasksAfterShutdownPolicy) {
            Object[] array = queue.toArray();
            int length = array.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Object obj = array[i2];
                if (obj instanceof RunnableScheduledFuture) {
                    RunnableScheduledFuture runnableScheduledFuture = (RunnableScheduledFuture) obj;
                    if (!runnableScheduledFuture.isPeriodic() ? executeExistingDelayedTasksAfterShutdownPolicy : continueExistingPeriodicTasksAfterShutdownPolicy) {
                        if (!runnableScheduledFuture.isCancelled()) {
                        }
                    }
                    if (queue.remove(runnableScheduledFuture)) {
                        runnableScheduledFuture.cancel(false);
                    }
                }
                i = i2 + 1;
            }
        } else {
            Object[] array2 = queue.toArray();
            int length2 = array2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                Object obj2 = array2[i4];
                if (obj2 instanceof RunnableScheduledFuture) {
                    ((RunnableScheduledFuture) obj2).cancel(false);
                }
                i3 = i4 + 1;
            }
            queue.clear();
        }
        tryTerminate();
    }

    void reExecutePeriodic(RunnableScheduledFuture<?> runnableScheduledFuture) {
        if (canRunInCurrentRunState(true)) {
            super.getQueue().add(runnableScheduledFuture);
            if (canRunInCurrentRunState(true) || !remove(runnableScheduledFuture)) {
                ensurePrestart();
            } else {
                runnableScheduledFuture.cancel(false);
            }
        }
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        RunnableScheduledFuture<?> decorateTask = decorateTask(runnable, new ScheduledFutureTask(runnable, null, triggerTime(j, timeUnit)));
        delayedExecute(decorateTask);
        return decorateTask;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        if (callable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        RunnableScheduledFuture<V> decorateTask = decorateTask(callable, new ScheduledFutureTask(callable, triggerTime(j, timeUnit)));
        delayedExecute(decorateTask);
        return decorateTask;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (runnable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException();
        }
        ScheduledFutureTask scheduledFutureTask = new ScheduledFutureTask(runnable, null, triggerTime(j, timeUnit), timeUnit.toNanos(j2));
        RunnableScheduledFuture<V> decorateTask = decorateTask(runnable, scheduledFutureTask);
        scheduledFutureTask.outerTask = decorateTask;
        delayedExecute(decorateTask);
        return decorateTask;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (runnable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException();
        }
        ScheduledFutureTask scheduledFutureTask = new ScheduledFutureTask(runnable, null, triggerTime(j, timeUnit), timeUnit.toNanos(-j2));
        RunnableScheduledFuture<V> decorateTask = decorateTask(runnable, scheduledFutureTask);
        scheduledFutureTask.outerTask = decorateTask;
        delayedExecute(decorateTask);
        return decorateTask;
    }

    public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean z) {
        this.continueExistingPeriodicTasksAfterShutdown = z;
        if (z || !isShutdown()) {
            return;
        }
        onShutdown();
    }

    public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean z) {
        this.executeExistingDelayedTasksAfterShutdown = z;
        if (z || !isShutdown()) {
            return;
        }
        onShutdown();
    }

    public void setRemoveOnCancelPolicy(boolean z) {
        this.removeOnCancel = z;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return schedule(Executors.callable(runnable, t), 0L, TimeUnit.NANOSECONDS);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return schedule(callable, 0L, TimeUnit.NANOSECONDS);
    }

    long triggerTime(long j) {
        long now = now();
        if (j >= 4611686018427387903L) {
            j = overflowFree(j);
        }
        return now + j;
    }
}
