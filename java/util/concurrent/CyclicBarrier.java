package java.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/CyclicBarrier.class */
public class CyclicBarrier {
    private final Runnable barrierCommand;
    private int count;
    private Generation generation;
    private final ReentrantLock lock;
    private final int parties;
    private final Condition trip;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/CyclicBarrier$Generation.class */
    public static class Generation {
        boolean broken;

        private Generation() {
            this.broken = false;
        }
    }

    public CyclicBarrier(int i) {
        this(i, null);
    }

    public CyclicBarrier(int i, Runnable runnable) {
        this.lock = new ReentrantLock();
        this.trip = this.lock.newCondition();
        this.generation = new Generation();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.parties = i;
        this.count = i;
        this.barrierCommand = runnable;
    }

    private void breakBarrier() {
        this.generation.broken = true;
        this.count = this.parties;
        this.trip.signalAll();
    }

    private int dowait(boolean z, long j) throws InterruptedException, BrokenBarrierException, TimeoutException {
        long j2;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Generation generation = this.generation;
            if (generation.broken) {
                throw new BrokenBarrierException();
            }
            if (Thread.interrupted()) {
                breakBarrier();
                throw new InterruptedException();
            }
            int i = this.count - 1;
            this.count = i;
            if (i == 0) {
                Runnable runnable = this.barrierCommand;
                if (runnable != null) {
                    runnable.run();
                }
                nextGeneration();
                if (1 == 0) {
                    breakBarrier();
                }
                reentrantLock.unlock();
                return 0;
            }
            while (true) {
                if (z) {
                    j2 = j;
                    if (j > 0) {
                        j2 = this.trip.awaitNanos(j);
                    }
                } else {
                    try {
                        this.trip.await();
                        j2 = j;
                    } catch (InterruptedException e) {
                        if (generation == this.generation && !generation.broken) {
                            breakBarrier();
                            throw e;
                        }
                        Thread.currentThread().interrupt();
                        j2 = j;
                    }
                }
                if (generation.broken) {
                    throw new BrokenBarrierException();
                }
                if (generation != this.generation) {
                    return i;
                }
                j = j2;
                if (z) {
                    j = j2;
                    if (j2 <= 0) {
                        breakBarrier();
                        throw new TimeoutException();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private void nextGeneration() {
        this.trip.signalAll();
        this.count = this.parties;
        this.generation = new Generation();
    }

    public int await() throws InterruptedException, BrokenBarrierException {
        try {
            return dowait(false, 0L);
        } catch (TimeoutException e) {
            throw new Error(e);
        }
    }

    public int await(long j, TimeUnit timeUnit) throws InterruptedException, BrokenBarrierException, TimeoutException {
        return dowait(true, timeUnit.toNanos(j));
    }

    public int getNumberWaiting() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.parties;
            int i2 = this.count;
            reentrantLock.unlock();
            return i - i2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public int getParties() {
        return this.parties;
    }

    public boolean isBroken() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.generation.broken;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void reset() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            breakBarrier();
            nextGeneration();
        } finally {
            reentrantLock.unlock();
        }
    }
}
