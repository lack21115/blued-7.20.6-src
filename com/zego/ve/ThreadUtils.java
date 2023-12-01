package com.zego.ve;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/ThreadUtils.class */
public class ThreadUtils {

    /* renamed from: com.zego.ve.ThreadUtils$1Result  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/ThreadUtils$1Result.class */
    class C1Result {
        public V value;

        C1Result() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/ThreadUtils$BlockingOperation.class */
    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/ThreadUtils$ThreadChecker.class */
    public static class ThreadChecker {
        private Thread thread = Thread.currentThread();

        public void checkIsOnValidThread() {
            if (this.thread == null) {
                this.thread = Thread.currentThread();
            }
            if (Thread.currentThread() != this.thread) {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void detachThread() {
            this.thread = null;
        }
    }

    public static void awaitUninterruptibly(final CountDownLatch countDownLatch) {
        executeUninterruptibly(new BlockingOperation() { // from class: com.zego.ve.ThreadUtils.2
            @Override // com.zego.ve.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                CountDownLatch.this.await();
            }
        });
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = j;
        boolean z2 = false;
        while (true) {
            try {
                z = countDownLatch.await(j2, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException e) {
                z2 = true;
                long elapsedRealtime2 = j - (SystemClock.elapsedRealtime() - elapsedRealtime);
                j2 = elapsedRealtime2;
                if (elapsedRealtime2 <= 0) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return z;
    }

    public static void executeUninterruptibly(BlockingOperation blockingOperation) {
        boolean z;
        boolean z2 = false;
        while (true) {
            try {
                z = z2;
                blockingOperation.run();
                break;
            } catch (InterruptedException e) {
                z2 = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static <V> V invokeUninterruptibly(Handler handler, final Callable<V> callable) {
        final C1Result c1Result = new C1Result();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        handler.post(new Runnable() { // from class: com.zego.ve.ThreadUtils.3
            /* JADX WARN: Type inference failed for: r1v8, types: [V, java.lang.Object] */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1Result.this.value = callable.call();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    RuntimeException runtimeException = new RuntimeException("Callable threw exception: " + e);
                    runtimeException.setStackTrace(e.getStackTrace());
                    throw runtimeException;
                }
            }
        });
        awaitUninterruptibly(countDownLatch);
        return c1Result.value;
    }

    public static void invokeUninterruptibly(Handler handler, final Runnable runnable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        handler.post(new Runnable() { // from class: com.zego.ve.ThreadUtils.4
            @Override // java.lang.Runnable
            public void run() {
                Runnable.this.run();
                countDownLatch.countDown();
            }
        });
        awaitUninterruptibly(countDownLatch);
    }

    public static void joinUninterruptibly(final Thread thread) {
        executeUninterruptibly(new BlockingOperation() { // from class: com.zego.ve.ThreadUtils.1
            @Override // com.zego.ve.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                Thread.this.join();
            }
        });
    }

    public static boolean joinUninterruptibly(Thread thread, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = j;
        while (j2 > 0) {
            try {
                thread.join(j2);
                break;
            } catch (InterruptedException e) {
                j2 = j - (SystemClock.elapsedRealtime() - elapsedRealtime);
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return !thread.isAlive();
    }
}
