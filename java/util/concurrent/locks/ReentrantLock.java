package java.util.concurrent.locks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantLock.class */
public class ReentrantLock implements Lock, Serializable {
    private static final long serialVersionUID = 7373984872572414699L;
    private final Sync sync;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantLock$FairSync.class */
    static final class FairSync extends Sync {
        private static final long serialVersionUID = -3000897897090466540L;

        FairSync() {
        }

        @Override // java.util.concurrent.locks.ReentrantLock.Sync
        final void lock() {
            acquire(1);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryAcquire(int i) {
            Thread currentThread = Thread.currentThread();
            int state = getState();
            if (state == 0) {
                if (hasQueuedPredecessors() || !compareAndSetState(0, i)) {
                    return false;
                }
                setExclusiveOwnerThread(currentThread);
                return true;
            } else if (currentThread == getExclusiveOwnerThread()) {
                int i2 = state + i;
                if (i2 < 0) {
                    throw new Error("Maximum lock count exceeded");
                }
                setState(i2);
                return true;
            } else {
                return false;
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantLock$NonfairSync.class */
    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = 7316153563782823691L;

        NonfairSync() {
        }

        @Override // java.util.concurrent.locks.ReentrantLock.Sync
        final void lock() {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                acquire(1);
            }
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryAcquire(int i) {
            return nonfairTryAcquire(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReentrantLock$Sync.class */
    public static abstract class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -5179523762034025860L;

        Sync() {
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setState(0);
        }

        final int getHoldCount() {
            if (isHeldExclusively()) {
                return getState();
            }
            return 0;
        }

        final Thread getOwner() {
            if (getState() == 0) {
                return null;
            }
            return getExclusiveOwnerThread();
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        final boolean isLocked() {
            return getState() != 0;
        }

        abstract void lock();

        final AbstractQueuedSynchronizer.ConditionObject newCondition() {
            return new AbstractQueuedSynchronizer.ConditionObject();
        }

        final boolean nonfairTryAcquire(int i) {
            Thread currentThread = Thread.currentThread();
            int state = getState();
            if (state == 0) {
                if (compareAndSetState(0, i)) {
                    setExclusiveOwnerThread(currentThread);
                    return true;
                }
                return false;
            } else if (currentThread == getExclusiveOwnerThread()) {
                int i2 = state + i;
                if (i2 < 0) {
                    throw new Error("Maximum lock count exceeded");
                }
                setState(i2);
                return true;
            } else {
                return false;
            }
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryRelease(int i) {
            int state = getState() - i;
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new IllegalMonitorStateException();
            }
            boolean z = false;
            if (state == 0) {
                z = true;
                setExclusiveOwnerThread(null);
            }
            setState(state);
            return z;
        }
    }

    public ReentrantLock() {
        this.sync = new NonfairSync();
    }

    public ReentrantLock(boolean z) {
        this.sync = z ? new FairSync() : new NonfairSync();
    }

    public int getHoldCount() {
        return this.sync.getHoldCount();
    }

    protected Thread getOwner() {
        return this.sync.getOwner();
    }

    public final int getQueueLength() {
        return this.sync.getQueueLength();
    }

    protected Collection<Thread> getQueuedThreads() {
        return this.sync.getQueuedThreads();
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

    public boolean isHeldByCurrentThread() {
        return this.sync.isHeldExclusively();
    }

    public boolean isLocked() {
        return this.sync.isLocked();
    }

    @Override // java.util.concurrent.locks.Lock
    public void lock() {
        this.sync.lock();
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
        return this.sync.nonfairTryAcquire(1);
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
