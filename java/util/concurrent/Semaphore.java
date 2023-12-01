package java.util.concurrent;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Semaphore.class */
public class Semaphore implements Serializable {
    private static final long serialVersionUID = -3222578661600680210L;
    private final Sync sync;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Semaphore$FairSync.class */
    static final class FairSync extends Sync {
        private static final long serialVersionUID = 2014338818796000944L;

        FairSync(int i) {
            super(i);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected int tryAcquireShared(int i) {
            int i2;
            int state;
            int i3;
            do {
                if (hasQueuedPredecessors()) {
                    i2 = -1;
                } else {
                    state = getState();
                    i3 = state - i;
                    i2 = i3;
                    if (i3 >= 0) {
                    }
                }
                return i2;
            } while (!compareAndSetState(state, i3));
            return i3;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Semaphore$NonfairSync.class */
    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = -2694183684443567898L;

        NonfairSync(int i) {
            super(i);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected int tryAcquireShared(int i) {
            return nonfairTryAcquireShared(i);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Semaphore$Sync.class */
    static abstract class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 1192457210091910933L;

        Sync(int i) {
            setState(i);
        }

        final int drainPermits() {
            int state;
            do {
                state = getState();
                if (state == 0) {
                    break;
                }
            } while (!compareAndSetState(state, 0));
            return state;
        }

        final int getPermits() {
            return getState();
        }

        final int nonfairTryAcquireShared(int i) {
            int state;
            int i2;
            do {
                state = getState();
                i2 = state - i;
                if (i2 < 0) {
                    break;
                }
            } while (!compareAndSetState(state, i2));
            return i2;
        }

        final void reducePermits(int i) {
            int state;
            int i2;
            do {
                state = getState();
                i2 = state - i;
                if (i2 > state) {
                    throw new Error("Permit count underflow");
                }
            } while (!compareAndSetState(state, i2));
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryReleaseShared(int i) {
            int state;
            int i2;
            do {
                state = getState();
                i2 = state + i;
                if (i2 < state) {
                    throw new Error("Maximum permit count exceeded");
                }
            } while (!compareAndSetState(state, i2));
            return true;
        }
    }

    public Semaphore(int i) {
        this.sync = new NonfairSync(i);
    }

    public Semaphore(int i, boolean z) {
        this.sync = z ? new FairSync(i) : new NonfairSync(i);
    }

    public void acquire() throws InterruptedException {
        this.sync.acquireSharedInterruptibly(1);
    }

    public void acquire(int i) throws InterruptedException {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.acquireSharedInterruptibly(i);
    }

    public void acquireUninterruptibly() {
        this.sync.acquireShared(1);
    }

    public void acquireUninterruptibly(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.acquireShared(i);
    }

    public int availablePermits() {
        return this.sync.getPermits();
    }

    public int drainPermits() {
        return this.sync.drainPermits();
    }

    public final int getQueueLength() {
        return this.sync.getQueueLength();
    }

    protected Collection<Thread> getQueuedThreads() {
        return this.sync.getQueuedThreads();
    }

    public final boolean hasQueuedThreads() {
        return this.sync.hasQueuedThreads();
    }

    public boolean isFair() {
        return this.sync instanceof FairSync;
    }

    protected void reducePermits(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.reducePermits(i);
    }

    public void release() {
        this.sync.releaseShared(1);
    }

    public void release(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.releaseShared(i);
    }

    public String toString() {
        return super.toString() + "[Permits = " + this.sync.getPermits() + "]";
    }

    public boolean tryAcquire() {
        return this.sync.nonfairTryAcquireShared(1) >= 0;
    }

    public boolean tryAcquire(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        return this.sync.nonfairTryAcquireShared(i) >= 0;
    }

    public boolean tryAcquire(int i, long j, TimeUnit timeUnit) throws InterruptedException {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        return this.sync.tryAcquireSharedNanos(i, timeUnit.toNanos(j));
    }

    public boolean tryAcquire(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.sync.tryAcquireSharedNanos(1, timeUnit.toNanos(j));
    }
}
