package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/Monitor.class */
public final class Monitor {
    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/Monitor$Guard.class */
    public static abstract class Guard {
        final Condition condition;
        final Monitor monitor;
        @NullableDecl
        Guard next;
        int waiterCount = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        public Guard(Monitor monitor) {
            this.monitor = (Monitor) Preconditions.checkNotNull(monitor, "monitor");
            this.condition = monitor.lock.newCondition();
        }

        public abstract boolean isSatisfied();
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean z) {
        this.activeGuards = null;
        this.fair = z;
        this.lock = new ReentrantLock(z);
    }

    private void await(Guard guard, boolean z) throws InterruptedException {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.await();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private boolean awaitNanos(Guard guard, long j, boolean z) throws InterruptedException {
        boolean z2;
        boolean z3 = true;
        while (j > 0) {
            boolean z4 = z3;
            if (z3) {
                if (z) {
                    z2 = z3;
                    try {
                        signalNextWaiter();
                    } finally {
                        if (!z2) {
                            endWaitingFor(guard);
                        }
                    }
                }
                boolean z5 = z3;
                beginWaitingFor(guard);
                z4 = false;
            }
            j = guard.condition.awaitNanos(j);
            boolean z6 = z4;
            z3 = z4;
            if (guard.isSatisfied()) {
                z2 = z4;
            }
        }
        if (z3) {
            return false;
        }
        endWaitingFor(guard);
        return false;
    }

    private void awaitUninterruptibly(Guard guard, boolean z) {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.awaitUninterruptibly();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private void beginWaitingFor(Guard guard) {
        int i = guard.waiterCount;
        guard.waiterCount = i + 1;
        if (i == 0) {
            guard.next = this.activeGuards;
            this.activeGuards = guard;
        }
    }

    private void endWaitingFor(Guard guard) {
        int i = guard.waiterCount - 1;
        guard.waiterCount = i;
        if (i == 0) {
            Guard guard2 = this.activeGuards;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.next;
            }
            if (guard3 == null) {
                this.activeGuards = guard2.next;
            } else {
                guard3.next = guard2.next;
            }
            guard2.next = null;
        }
    }

    private static long initNanoTime(long j) {
        if (j <= 0) {
            return 0L;
        }
        long nanoTime = System.nanoTime();
        long j2 = nanoTime;
        if (nanoTime == 0) {
            j2 = 1;
        }
        return j2;
    }

    private boolean isSatisfied(Guard guard) {
        try {
            return guard.isSatisfied();
        } catch (Throwable th) {
            signalAllWaiters();
            throw th;
        }
    }

    private static long remainingNanos(long j, long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 - (System.nanoTime() - j);
    }

    private void signalAllWaiters() {
        Guard guard = this.activeGuards;
        while (true) {
            Guard guard2 = guard;
            if (guard2 == null) {
                return;
            }
            guard2.condition.signalAll();
            guard = guard2.next;
        }
    }

    private void signalNextWaiter() {
        Guard guard = this.activeGuards;
        while (true) {
            Guard guard2 = guard;
            if (guard2 == null) {
                return;
            }
            if (isSatisfied(guard2)) {
                guard2.condition.signal();
                return;
            }
            guard = guard2.next;
        }
    }

    private static long toSafeNanos(long j, TimeUnit timeUnit) {
        return Longs.constrainToRange(timeUnit.toNanos(j), 0L, 6917529027641081853L);
    }

    public void enter() {
        this.lock.lock();
    }

    public boolean enter(long j, TimeUnit timeUnit) {
        boolean tryLock;
        long safeNanos = toSafeNanos(j, timeUnit);
        ReentrantLock reentrantLock = this.lock;
        if (!this.fair && reentrantLock.tryLock()) {
            return true;
        }
        boolean interrupted = Thread.interrupted();
        boolean z = interrupted;
        try {
            long nanoTime = System.nanoTime();
            long j2 = safeNanos;
            while (true) {
                z = interrupted;
                try {
                    tryLock = reentrantLock.tryLock(j2, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException e) {
                    try {
                        j2 = remainingNanos(nanoTime, safeNanos);
                        interrupted = true;
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                }
            }
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
            return tryLock;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean enterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    public boolean enterIf(Guard guard, long j, TimeUnit timeUnit) {
        if (guard.monitor == this) {
            if (enter(j, timeUnit)) {
                try {
                    boolean isSatisfied = guard.isSatisfied();
                    if (!isSatisfied) {
                    }
                    return isSatisfied;
                } finally {
                    this.lock.unlock();
                }
            }
            return false;
        }
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (reentrantLock.tryLock(j, timeUnit)) {
                try {
                    boolean isSatisfied = guard.isSatisfied();
                    if (!isSatisfied) {
                    }
                    return isSatisfied;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return false;
        }
        throw new IllegalMonitorStateException();
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public boolean enterInterruptibly(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.lock.tryLock(j, timeUnit);
    }

    public void enterWhen(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lockInterruptibly();
        try {
            if (guard.isSatisfied()) {
                return;
            }
            await(guard, isHeldByCurrentThread);
        } catch (Throwable th) {
            leave();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
        if (awaitNanos(r7, r11 == 0 ? r0 : remainingNanos(r11, r0), r0) != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008e A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean enterWhen(com.google.common.util.concurrent.Monitor.Guard r7, long r8, java.util.concurrent.TimeUnit r10) throws java.lang.InterruptedException {
        /*
            r6 = this;
            r0 = r8
            r1 = r10
            long r0 = toSafeNanos(r0, r1)
            r13 = r0
            r0 = r7
            com.google.common.util.concurrent.Monitor r0 = r0.monitor
            r1 = r6
            if (r0 != r1) goto Lb2
            r0 = r6
            java.util.concurrent.locks.ReentrantLock r0 = r0.lock
            r18 = r0
            r0 = r18
            boolean r0 = r0.isHeldByCurrentThread()
            r16 = r0
            r0 = r6
            boolean r0 = r0.fair
            r17 = r0
            r0 = 0
            r15 = r0
            r0 = r17
            if (r0 != 0) goto L47
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L3f
            r0 = r18
            boolean r0 = r0.tryLock()
            if (r0 == 0) goto L47
            r0 = 0
            r11 = r0
            goto L5b
        L3f:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r1 = r0
            r1.<init>()
            throw r0
        L47:
            r0 = r13
            long r0 = initNanoTime(r0)
            r11 = r0
            r0 = r18
            r1 = r8
            r2 = r10
            boolean r0 = r0.tryLock(r1, r2)
            if (r0 != 0) goto L5b
            r0 = 0
            return r0
        L5b:
            r0 = r7
            boolean r0 = r0.isSatisfied()     // Catch: java.lang.Throwable -> L96
            if (r0 != 0) goto L86
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L6f
            r0 = r13
            r8 = r0
            goto L77
        L6f:
            r0 = r11
            r1 = r13
            long r0 = remainingNanos(r0, r1)     // Catch: java.lang.Throwable -> L96
            r8 = r0
        L77:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r16
            boolean r0 = r0.awaitNanos(r1, r2, r3)     // Catch: java.lang.Throwable -> L96
            r17 = r0
            r0 = r17
            if (r0 == 0) goto L89
        L86:
            r0 = 1
            r15 = r0
        L89:
            r0 = r15
            if (r0 != 0) goto L93
            r0 = r18
            r0.unlock()
        L93:
            r0 = r15
            return r0
        L96:
            r7 = move-exception
            r0 = r16
            if (r0 != 0) goto Lab
            r0 = r6
            r0.signalNextWaiter()     // Catch: java.lang.Throwable -> La3
            goto Lab
        La3:
            r7 = move-exception
            r0 = r18
            r0.unlock()
            r0 = r7
            throw r0
        Lab:
            r0 = r18
            r0.unlock()
            r0 = r7
            throw r0
        Lb2:
            java.lang.IllegalMonitorStateException r0 = new java.lang.IllegalMonitorStateException
            r1 = r0
            r1.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhen(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public void enterWhenUninterruptibly(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        try {
            if (guard.isSatisfied()) {
                return;
            }
            awaitUninterruptibly(guard, isHeldByCurrentThread);
        } catch (Throwable th) {
            leave();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0072 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public int getWaitQueueLength(Guard guard) {
        if (guard.monitor == this) {
            this.lock.lock();
            try {
                return guard.waiterCount;
            } finally {
                this.lock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    public boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasWaiters(Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public boolean isFair() {
        return this.fair;
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public void leave() {
        ReentrantLock reentrantLock = this.lock;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                signalNextWaiter();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public boolean tryEnterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (reentrantLock.tryLock()) {
                try {
                    boolean isSatisfied = guard.isSatisfied();
                    if (!isSatisfied) {
                    }
                    return isSatisfied;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return false;
        }
        throw new IllegalMonitorStateException();
    }

    public void waitFor(Guard guard) throws InterruptedException {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return;
        }
        await(guard, true);
    }

    public boolean waitFor(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long safeNanos = toSafeNanos(j, timeUnit);
        if ((guard.monitor == this) && this.lock.isHeldByCurrentThread()) {
            if (guard.isSatisfied()) {
                return true;
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            return awaitNanos(guard, safeNanos, true);
        }
        throw new IllegalMonitorStateException();
    }

    public void waitForUninterruptibly(Guard guard) {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return;
        }
        awaitUninterruptibly(guard, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean waitForUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            r0 = r8
            r1 = r10
            long r0 = toSafeNanos(r0, r1)
            r12 = r0
            r0 = r7
            com.google.common.util.concurrent.Monitor r0 = r0.monitor
            r10 = r0
            r0 = 1
            r18 = r0
            r0 = r10
            r1 = r6
            if (r0 != r1) goto L1d
            r0 = 1
            r11 = r0
            goto L20
        L1d:
            r0 = 0
            r11 = r0
        L20:
            r0 = r11
            r1 = r6
            java.util.concurrent.locks.ReentrantLock r1 = r1.lock
            boolean r1 = r1.isHeldByCurrentThread()
            r0 = r0 & r1
            if (r0 == 0) goto L9a
            r0 = r7
            boolean r0 = r0.isSatisfied()
            if (r0 == 0) goto L36
            r0 = 1
            return r0
        L36:
            r0 = r12
            long r0 = initNanoTime(r0)
            r14 = r0
            boolean r0 = java.lang.Thread.interrupted()
            r16 = r0
            r0 = r12
            r8 = r0
            r0 = 1
            r17 = r0
        L48:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r17
            boolean r0 = r0.awaitNanos(r1, r2, r3)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> La2
            r17 = r0
            r0 = r16
            if (r0 == 0) goto L5d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L5d:
            r0 = r17
            return r0
        L60:
            r7 = move-exception
            goto L8d
        L64:
            r0 = r7
            boolean r0 = r0.isSatisfied()     // Catch: java.lang.Throwable -> L88
            r16 = r0
            r0 = r16
            if (r0 == 0) goto L77
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            r0 = 1
            return r0
        L77:
            r0 = r14
            r1 = r12
            long r0 = remainingNanos(r0, r1)     // Catch: java.lang.Throwable -> L88
            r8 = r0
            r0 = 1
            r16 = r0
            r0 = 0
            r17 = r0
            goto L48
        L88:
            r7 = move-exception
            r0 = r18
            r16 = r0
        L8d:
            r0 = r16
            if (r0 == 0) goto L98
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L98:
            r0 = r7
            throw r0
        L9a:
            java.lang.IllegalMonitorStateException r0 = new java.lang.IllegalMonitorStateException
            r1 = r0
            r1.<init>()
            throw r0
        La2:
            r10 = move-exception
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.waitForUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }
}
