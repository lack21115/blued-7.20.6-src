package java.util.concurrent;

import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/FutureTask.class */
public class FutureTask<V> implements RunnableFuture<V> {
    private static final int CANCELLED = 4;
    private static final int COMPLETING = 1;
    private static final int EXCEPTIONAL = 3;
    private static final int INTERRUPTED = 6;
    private static final int INTERRUPTING = 5;
    private static final int NEW = 0;
    private static final int NORMAL = 2;
    private static final Unsafe UNSAFE;
    private static final long runnerOffset;
    private static final long stateOffset;
    private static final long waitersOffset;
    private Callable<V> callable;
    private Object outcome;
    private volatile Thread runner;
    private volatile int state;
    private volatile WaitNode waiters;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/FutureTask$WaitNode.class */
    public static final class WaitNode {
        volatile WaitNode next;
        volatile Thread thread = Thread.currentThread();

        WaitNode() {
        }
    }

    static {
        try {
            UNSAFE = Unsafe.getUnsafe();
            stateOffset = UNSAFE.objectFieldOffset(FutureTask.class.getDeclaredField("state"));
            runnerOffset = UNSAFE.objectFieldOffset(FutureTask.class.getDeclaredField("runner"));
            waitersOffset = UNSAFE.objectFieldOffset(FutureTask.class.getDeclaredField("waiters"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public FutureTask(Runnable runnable, V v) {
        this.callable = Executors.callable(runnable, v);
        this.state = 0;
    }

    public FutureTask(Callable<V> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        this.callable = callable;
        this.state = 0;
    }

    private int awaitDone(boolean z, long j) throws InterruptedException {
        long nanoTime = z ? System.nanoTime() + j : 0L;
        WaitNode waitNode = null;
        boolean z2 = false;
        while (!Thread.interrupted()) {
            int i = this.state;
            if (i > 1) {
                if (waitNode != null) {
                    waitNode.thread = null;
                }
                return i;
            } else if (i == 1) {
                Thread.yield();
            } else if (waitNode == null) {
                waitNode = new WaitNode();
            } else if (!z2) {
                Unsafe unsafe = UNSAFE;
                long j2 = waitersOffset;
                WaitNode waitNode2 = this.waiters;
                waitNode.next = waitNode2;
                z2 = unsafe.compareAndSwapObject(this, j2, waitNode2, waitNode);
            } else if (z) {
                long nanoTime2 = nanoTime - System.nanoTime();
                if (nanoTime2 <= 0) {
                    removeWaiter(waitNode);
                    return this.state;
                }
                LockSupport.parkNanos(this, nanoTime2);
            } else {
                LockSupport.park(this);
            }
        }
        removeWaiter(waitNode);
        throw new InterruptedException();
    }

    private void finishCompletion() {
        while (true) {
            WaitNode waitNode = this.waiters;
            if (waitNode == null) {
                break;
            } else if (UNSAFE.compareAndSwapObject(this, waitersOffset, waitNode, null)) {
                while (true) {
                    Thread thread = waitNode.thread;
                    if (thread != null) {
                        waitNode.thread = null;
                        LockSupport.unpark(thread);
                    }
                    WaitNode waitNode2 = waitNode.next;
                    if (waitNode2 == null) {
                        break;
                    }
                    waitNode.next = null;
                    waitNode = waitNode2;
                }
            }
        }
        done();
        this.callable = null;
    }

    private void handlePossibleCancellationInterrupt(int i) {
        if (i == 5) {
            while (this.state == 5) {
                Thread.yield();
            }
        }
    }

    private void removeWaiter(WaitNode waitNode) {
        WaitNode waitNode2;
        if (waitNode != null) {
            waitNode.thread = null;
            while (true) {
                WaitNode waitNode3 = null;
                WaitNode waitNode4 = this.waiters;
                while (waitNode4 != null) {
                    WaitNode waitNode5 = waitNode4.next;
                    if (waitNode4.thread != null) {
                        waitNode2 = waitNode4;
                    } else if (waitNode3 != null) {
                        waitNode3.next = waitNode5;
                        waitNode2 = waitNode3;
                        if (waitNode3.thread == null) {
                            break;
                        }
                    } else {
                        waitNode2 = waitNode3;
                        if (!UNSAFE.compareAndSwapObject(this, waitersOffset, waitNode4, waitNode5)) {
                            break;
                        }
                    }
                    waitNode4 = waitNode5;
                    waitNode3 = waitNode2;
                }
                return;
            }
        }
    }

    private V report(int i) throws ExecutionException {
        V v = (V) this.outcome;
        if (i == 2) {
            return v;
        }
        if (i >= 4) {
            throw new CancellationException();
        }
        throw new ExecutionException((Throwable) v);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (this.state == 0) {
            if (UNSAFE.compareAndSwapInt(this, stateOffset, 0, z ? 5 : 4)) {
                if (z) {
                    try {
                        Thread thread = this.runner;
                        if (thread != null) {
                            thread.interrupt();
                        }
                        UNSAFE.putOrderedInt(this, stateOffset, 6);
                    } catch (Throwable th) {
                        finishCompletion();
                        throw th;
                    }
                }
                finishCompletion();
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void done() {
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        int i = this.state;
        int i2 = i;
        if (i <= 1) {
            i2 = awaitDone(false, 0L);
        }
        return report(i2);
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (timeUnit == null) {
            throw new NullPointerException();
        }
        int i = this.state;
        int i2 = i;
        if (i <= 1) {
            int awaitDone = awaitDone(true, timeUnit.toNanos(j));
            i2 = awaitDone;
            if (awaitDone <= 1) {
                throw new TimeoutException();
            }
        }
        return report(i2);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.state >= 4;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.state != 0;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        if (this.state == 0 && UNSAFE.compareAndSwapObject(this, runnerOffset, null, Thread.currentThread())) {
            try {
                Callable<V> callable = this.callable;
                if (callable != null && this.state == 0) {
                    V call = callable.call();
                    if (1 != 0) {
                        set(call);
                    }
                }
            } finally {
                this.runner = null;
                int i = this.state;
                if (i >= 5) {
                    handlePossibleCancellationInterrupt(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean runAndReset() {
        if (this.state == 0 && UNSAFE.compareAndSwapObject(this, runnerOffset, null, Thread.currentThread())) {
            int i = this.state;
            try {
                Callable<V> callable = this.callable;
                boolean z = false;
                if (callable != null) {
                    z = false;
                    if (i == 0) {
                        callable.call();
                        z = true;
                    }
                }
                return z && this.state == 0;
            } finally {
                this.runner = null;
                int i2 = this.state;
                if (i2 >= 5) {
                    handlePossibleCancellationInterrupt(i2);
                }
            }
        }
        return false;
    }

    protected void set(V v) {
        if (UNSAFE.compareAndSwapInt(this, stateOffset, 0, 1)) {
            this.outcome = v;
            UNSAFE.putOrderedInt(this, stateOffset, 2);
            finishCompletion();
        }
    }

    protected void setException(Throwable th) {
        if (UNSAFE.compareAndSwapInt(this, stateOffset, 0, 1)) {
            this.outcome = th;
            UNSAFE.putOrderedInt(this, stateOffset, 3);
            finishCompletion();
        }
    }
}
