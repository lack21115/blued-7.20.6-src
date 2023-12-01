package java.util.concurrent.locks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantReadWriteLock.class */
public class ReentrantReadWriteLock implements ReadWriteLock, Serializable {
    private static final long serialVersionUID = -6992448646407690164L;
    private final ReadLock readerLock;
    final Sync sync;
    private final WriteLock writerLock;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantReadWriteLock$FairSync.class */
    static final class FairSync extends Sync {
        private static final long serialVersionUID = -2274990926593161451L;

        FairSync() {
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.Sync
        final boolean readerShouldBlock() {
            return hasQueuedPredecessors();
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.Sync
        final boolean writerShouldBlock() {
            return hasQueuedPredecessors();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantReadWriteLock$NonfairSync.class */
    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = -8159625535654395037L;

        NonfairSync() {
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.Sync
        final boolean readerShouldBlock() {
            return apparentlyFirstQueuedIsExclusive();
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.Sync
        final boolean writerShouldBlock() {
            return false;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.class */
    public static class ReadLock implements Lock, Serializable {
        private static final long serialVersionUID = -5992448646407690164L;
        private final Sync sync;

        /* JADX INFO: Access modifiers changed from: protected */
        public ReadLock(ReentrantReadWriteLock reentrantReadWriteLock) {
            this.sync = reentrantReadWriteLock.sync;
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
            this.sync.acquireShared(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            this.sync.acquireSharedInterruptibly(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return super.toString() + "[Read locks = " + this.sync.getReadLockCount() + "]";
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return this.sync.tryReadLock();
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.sync.tryAcquireSharedNanos(1, timeUnit.toNanos(j));
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
            this.sync.releaseShared(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantReadWriteLock$Sync.class */
    public static abstract class Sync extends AbstractQueuedSynchronizer {
        static final int EXCLUSIVE_MASK = 65535;
        static final int MAX_COUNT = 65535;
        static final int SHARED_SHIFT = 16;
        static final int SHARED_UNIT = 65536;
        private static final long serialVersionUID = 6317671515068378041L;
        private transient HoldCounter cachedHoldCounter;
        private transient int firstReaderHoldCount;
        private transient Thread firstReader = null;
        private transient ThreadLocalHoldCounter readHolds = new ThreadLocalHoldCounter();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantReadWriteLock$Sync$HoldCounter.class */
        public static final class HoldCounter {
            int count = 0;
            final long tid = Thread.currentThread().getId();

            HoldCounter() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantReadWriteLock$Sync$ThreadLocalHoldCounter.class */
        public static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            ThreadLocalHoldCounter() {
            }

            @Override // java.lang.ThreadLocal
            public HoldCounter initialValue() {
                return new HoldCounter();
            }
        }

        Sync() {
            setState(getState());
        }

        static int exclusiveCount(int i) {
            return 65535 & i;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.readHolds = new ThreadLocalHoldCounter();
            setState(0);
        }

        static int sharedCount(int i) {
            return i >>> 16;
        }

        private IllegalMonitorStateException unmatchedUnlockException() {
            return new IllegalMonitorStateException("attempt to unlock read lock, not locked by current thread");
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
            if (r0.tid != r6.getId()) goto L49;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int fullTryAcquireShared(java.lang.Thread r6) {
            /*
                Method dump skipped, instructions count: 287
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.ReentrantReadWriteLock.Sync.fullTryAcquireShared(java.lang.Thread):int");
        }

        final int getCount() {
            return getState();
        }

        final Thread getOwner() {
            if (exclusiveCount(getState()) == 0) {
                return null;
            }
            return getExclusiveOwnerThread();
        }

        final int getReadHoldCount() {
            int i;
            if (getReadLockCount() == 0) {
                i = 0;
            } else {
                Thread currentThread = Thread.currentThread();
                if (this.firstReader == currentThread) {
                    return this.firstReaderHoldCount;
                }
                HoldCounter holdCounter = this.cachedHoldCounter;
                if (holdCounter != null && holdCounter.tid == currentThread.getId()) {
                    return holdCounter.count;
                }
                int i2 = this.readHolds.get().count;
                i = i2;
                if (i2 == 0) {
                    this.readHolds.remove();
                    return i2;
                }
            }
            return i;
        }

        final int getReadLockCount() {
            return sharedCount(getState());
        }

        final int getWriteHoldCount() {
            if (isHeldExclusively()) {
                return exclusiveCount(getState());
            }
            return 0;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        final boolean isWriteLocked() {
            return exclusiveCount(getState()) != 0;
        }

        final AbstractQueuedSynchronizer.ConditionObject newCondition() {
            return new AbstractQueuedSynchronizer.ConditionObject();
        }

        abstract boolean readerShouldBlock();

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryAcquire(int i) {
            Thread currentThread = Thread.currentThread();
            int state = getState();
            int exclusiveCount = exclusiveCount(state);
            if (state == 0) {
                if (writerShouldBlock() || !compareAndSetState(state, state + i)) {
                    return false;
                }
                setExclusiveOwnerThread(currentThread);
                return true;
            } else if (exclusiveCount == 0 || currentThread != getExclusiveOwnerThread()) {
                return false;
            } else {
                if (exclusiveCount(i) + exclusiveCount > 65535) {
                    throw new Error("Maximum lock count exceeded");
                }
                setState(state + i);
                return true;
            }
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final int tryAcquireShared(int i) {
            HoldCounter holdCounter;
            Thread currentThread = Thread.currentThread();
            int state = getState();
            if (exclusiveCount(state) == 0 || getExclusiveOwnerThread() == currentThread) {
                int sharedCount = sharedCount(state);
                if (readerShouldBlock() || sharedCount >= 65535 || !compareAndSetState(state, 65536 + state)) {
                    return fullTryAcquireShared(currentThread);
                }
                if (sharedCount == 0) {
                    this.firstReader = currentThread;
                    this.firstReaderHoldCount = 1;
                    return 1;
                } else if (this.firstReader == currentThread) {
                    this.firstReaderHoldCount++;
                    return 1;
                } else {
                    HoldCounter holdCounter2 = this.cachedHoldCounter;
                    if (holdCounter2 == null || holdCounter2.tid != currentThread.getId()) {
                        holdCounter = this.readHolds.get();
                        this.cachedHoldCounter = holdCounter;
                    } else {
                        holdCounter = holdCounter2;
                        if (holdCounter2.count == 0) {
                            this.readHolds.set(holdCounter2);
                            holdCounter = holdCounter2;
                        }
                    }
                    holdCounter.count++;
                    return 1;
                }
            }
            return -1;
        }

        final boolean tryReadLock() {
            int state;
            int sharedCount;
            HoldCounter holdCounter;
            Thread currentThread = Thread.currentThread();
            do {
                state = getState();
                if (exclusiveCount(state) != 0 && getExclusiveOwnerThread() != currentThread) {
                    return false;
                }
                sharedCount = sharedCount(state);
                if (sharedCount == 65535) {
                    throw new Error("Maximum lock count exceeded");
                }
            } while (!compareAndSetState(state, 65536 + state));
            if (sharedCount == 0) {
                this.firstReader = currentThread;
                this.firstReaderHoldCount = 1;
                return true;
            } else if (this.firstReader == currentThread) {
                this.firstReaderHoldCount++;
                return true;
            } else {
                HoldCounter holdCounter2 = this.cachedHoldCounter;
                if (holdCounter2 == null || holdCounter2.tid != currentThread.getId()) {
                    holdCounter = this.readHolds.get();
                    this.cachedHoldCounter = holdCounter;
                } else {
                    holdCounter = holdCounter2;
                    if (holdCounter2.count == 0) {
                        this.readHolds.set(holdCounter2);
                        holdCounter = holdCounter2;
                    }
                }
                holdCounter.count++;
                return true;
            }
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryRelease(int i) {
            if (isHeldExclusively()) {
                int state = getState() - i;
                boolean z = exclusiveCount(state) == 0;
                if (z) {
                    setExclusiveOwnerThread(null);
                }
                setState(state);
                return z;
            }
            throw new IllegalMonitorStateException();
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
            if (r0.tid != r0.getId()) goto L27;
         */
        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected final boolean tryReleaseShared(int r6) {
            /*
                r5 = this;
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r10 = r0
                r0 = r5
                java.lang.Thread r0 = r0.firstReader
                r1 = r10
                if (r0 != r1) goto L41
                r0 = r5
                int r0 = r0.firstReaderHoldCount
                r1 = 1
                if (r0 != r1) goto L34
                r0 = r5
                r1 = 0
                r0.firstReader = r1
            L1b:
                r0 = r5
                int r0 = r0.getState()
                r6 = r0
                r0 = r6
                r1 = 65536(0x10000, float:9.18355E-41)
                int r0 = r0 - r1
                r7 = r0
                r0 = r5
                r1 = r6
                r2 = r7
                boolean r0 = r0.compareAndSetState(r1, r2)
                if (r0 == 0) goto L1b
                r0 = r7
                if (r0 != 0) goto L8f
                r0 = 1
                return r0
            L34:
                r0 = r5
                r1 = r5
                int r1 = r1.firstReaderHoldCount
                r2 = 1
                int r1 = r1 - r2
                r0.firstReaderHoldCount = r1
                goto L1b
            L41:
                r0 = r5
                java.util.concurrent.locks.ReentrantReadWriteLock$Sync$HoldCounter r0 = r0.cachedHoldCounter
                r9 = r0
                r0 = r9
                if (r0 == 0) goto L5d
                r0 = r9
                r8 = r0
                r0 = r9
                long r0 = r0.tid
                r1 = r10
                long r1 = r1.getId()
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L68
            L5d:
                r0 = r5
                java.util.concurrent.locks.ReentrantReadWriteLock$Sync$ThreadLocalHoldCounter r0 = r0.readHolds
                java.lang.Object r0 = r0.get()
                java.util.concurrent.locks.ReentrantReadWriteLock$Sync$HoldCounter r0 = (java.util.concurrent.locks.ReentrantReadWriteLock.Sync.HoldCounter) r0
                r8 = r0
            L68:
                r0 = r8
                int r0 = r0.count
                r6 = r0
                r0 = r6
                r1 = 1
                if (r0 > r1) goto L82
                r0 = r5
                java.util.concurrent.locks.ReentrantReadWriteLock$Sync$ThreadLocalHoldCounter r0 = r0.readHolds
                r0.remove()
                r0 = r6
                if (r0 > 0) goto L82
                r0 = r5
                java.lang.IllegalMonitorStateException r0 = r0.unmatchedUnlockException()
                throw r0
            L82:
                r0 = r8
                r1 = r8
                int r1 = r1.count
                r2 = 1
                int r1 = r1 - r2
                r0.count = r1
                goto L1b
            L8f:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.ReentrantReadWriteLock.Sync.tryReleaseShared(int):boolean");
        }

        final boolean tryWriteLock() {
            Thread currentThread = Thread.currentThread();
            int state = getState();
            if (state != 0) {
                int exclusiveCount = exclusiveCount(state);
                if (exclusiveCount == 0 || currentThread != getExclusiveOwnerThread()) {
                    return false;
                }
                if (exclusiveCount == 65535) {
                    throw new Error("Maximum lock count exceeded");
                }
            }
            if (compareAndSetState(state, state + 1)) {
                setExclusiveOwnerThread(currentThread);
                return true;
            }
            return false;
        }

        abstract boolean writerShouldBlock();
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.class */
    public static class WriteLock implements Lock, Serializable {
        private static final long serialVersionUID = -4992448646407690164L;
        private final Sync sync;

        /* JADX INFO: Access modifiers changed from: protected */
        public WriteLock(ReentrantReadWriteLock reentrantReadWriteLock) {
            this.sync = reentrantReadWriteLock.sync;
        }

        public int getHoldCount() {
            return this.sync.getWriteHoldCount();
        }

        public boolean isHeldByCurrentThread() {
            return this.sync.isHeldExclusively();
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
            this.sync.acquire(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            this.sync.acquireInterruptibly(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return this.sync.newCondition();
        }

        public String toString() {
            Thread owner = this.sync.getOwner();
            return super.toString() + (owner == null ? "[Unlocked]" : "[Locked by thread " + owner.getName() + "]");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return this.sync.tryWriteLock();
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.sync.tryAcquireNanos(1, timeUnit.toNanos(j));
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
            this.sync.release(1);
        }
    }

    public ReentrantReadWriteLock() {
        this(false);
    }

    public ReentrantReadWriteLock(boolean z) {
        this.sync = z ? new FairSync() : new NonfairSync();
        this.readerLock = new ReadLock(this);
        this.writerLock = new WriteLock(this);
    }

    protected Thread getOwner() {
        return this.sync.getOwner();
    }

    public final int getQueueLength() {
        return this.sync.getQueueLength();
    }

    protected Collection<Thread> getQueuedReaderThreads() {
        return this.sync.getSharedQueuedThreads();
    }

    protected Collection<Thread> getQueuedThreads() {
        return this.sync.getQueuedThreads();
    }

    protected Collection<Thread> getQueuedWriterThreads() {
        return this.sync.getExclusiveQueuedThreads();
    }

    public int getReadHoldCount() {
        return this.sync.getReadHoldCount();
    }

    public int getReadLockCount() {
        return this.sync.getReadLockCount();
    }

    public int getWaitQueueLength(Condition condition) {
        if (condition == null) {
            throw new NullPointerException();
        }
        if (condition instanceof AbstractQueuedSynchronizer.ConditionObject) {
            return this.sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject) condition);
        }
        throw new IllegalArgumentException("not owner");
    }

    protected Collection<Thread> getWaitingThreads(Condition condition) {
        if (condition == null) {
            throw new NullPointerException();
        }
        if (condition instanceof AbstractQueuedSynchronizer.ConditionObject) {
            return this.sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject) condition);
        }
        throw new IllegalArgumentException("not owner");
    }

    public int getWriteHoldCount() {
        return this.sync.getWriteHoldCount();
    }

    public final boolean hasQueuedThread(Thread thread) {
        return this.sync.isQueued(thread);
    }

    public final boolean hasQueuedThreads() {
        return this.sync.hasQueuedThreads();
    }

    public boolean hasWaiters(Condition condition) {
        if (condition == null) {
            throw new NullPointerException();
        }
        if (condition instanceof AbstractQueuedSynchronizer.ConditionObject) {
            return this.sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject) condition);
        }
        throw new IllegalArgumentException("not owner");
    }

    public final boolean isFair() {
        return this.sync instanceof FairSync;
    }

    public boolean isWriteLocked() {
        return this.sync.isWriteLocked();
    }

    public boolean isWriteLockedByCurrentThread() {
        return this.sync.isHeldExclusively();
    }

    @Override // java.util.concurrent.locks.ReadWriteLock
    public ReadLock readLock() {
        return this.readerLock;
    }

    public String toString() {
        int count = this.sync.getCount();
        int exclusiveCount = Sync.exclusiveCount(count);
        return super.toString() + "[Write locks = " + exclusiveCount + ", Read locks = " + Sync.sharedCount(count) + "]";
    }

    @Override // java.util.concurrent.locks.ReadWriteLock
    public WriteLock writeLock() {
        return this.writerLock;
    }
}
