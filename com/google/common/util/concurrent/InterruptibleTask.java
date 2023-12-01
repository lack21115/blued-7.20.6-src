package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/InterruptibleTask.class */
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable DONE = new DoNothingRunnable();
    private static final Runnable INTERRUPTING = new DoNothingRunnable();
    private static final Runnable PARKED = new DoNothingRunnable();

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/InterruptibleTask$DoNothingRunnable.class */
    static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    abstract void afterRanInterruptibly(@NullableDecl T t, @NullableDecl Throwable th);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void interruptTask() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, INTERRUPTING)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (getAndSet(DONE) == PARKED) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        T runInterruptibly;
        boolean z2;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z3 = !isDone();
            if (z3) {
                try {
                    runInterruptibly = runInterruptibly();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, DONE)) {
                        Runnable runnable = get();
                        boolean z4 = false;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (runnable != INTERRUPTING && runnable != PARKED) {
                                break;
                            }
                            int i3 = i2 + 1;
                            if (i3 > 1000) {
                                Runnable runnable2 = PARKED;
                                if (runnable != runnable2) {
                                    z = z4;
                                    if (!compareAndSet(INTERRUPTING, runnable2)) {
                                    }
                                }
                                boolean z5 = Thread.interrupted() || z4;
                                LockSupport.park(this);
                                z = z5;
                            } else {
                                Thread.yield();
                                z = z4;
                            }
                            runnable = get();
                            z4 = z;
                            i = i3;
                        }
                        if (z4) {
                            currentThread.interrupt();
                        }
                    }
                    if (z3) {
                        afterRanInterruptibly(null, th);
                        return;
                    }
                    return;
                }
            } else {
                runInterruptibly = null;
            }
            if (!compareAndSet(currentThread, DONE)) {
                Runnable runnable3 = get();
                boolean z6 = false;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (runnable3 != INTERRUPTING && runnable3 != PARKED) {
                        break;
                    }
                    int i6 = i5 + 1;
                    if (i6 > 1000) {
                        Runnable runnable4 = PARKED;
                        if (runnable3 != runnable4) {
                            z2 = z6;
                            if (!compareAndSet(INTERRUPTING, runnable4)) {
                            }
                        }
                        boolean z7 = Thread.interrupted() || z6;
                        LockSupport.park(this);
                        z2 = z7;
                    } else {
                        Thread.yield();
                        z2 = z6;
                    }
                    runnable3 = get();
                    z6 = z2;
                    i4 = i6;
                }
                if (z6) {
                    currentThread.interrupt();
                }
            }
            if (z3) {
                afterRanInterruptibly(runInterruptibly, null);
            }
        }
    }

    abstract T runInterruptibly() throws Exception;

    abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable == INTERRUPTING) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + toPendingString();
    }
}
