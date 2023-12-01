package java.lang;

import dalvik.system.VMRuntime;
import java.lang.Thread;
import java.lang.ref.FinalizerReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Daemons.class */
public final class Daemons {
    private static final long MAX_FINALIZE_NANOS = 10000000000L;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/Daemons$Daemon.class */
    public static abstract class Daemon implements Runnable {
        private Thread thread;

        private Daemon() {
        }

        public StackTraceElement[] getStackTrace() {
            StackTraceElement[] stackTrace;
            synchronized (this) {
                stackTrace = this.thread != null ? this.thread.getStackTrace() : EmptyArray.STACK_TRACE_ELEMENT;
            }
            return stackTrace;
        }

        public void interrupt() {
            synchronized (this) {
                if (this.thread == null) {
                    throw new IllegalStateException("not running");
                }
                this.thread.interrupt();
            }
        }

        protected boolean isRunning() {
            boolean z;
            synchronized (this) {
                z = this.thread != null;
            }
            return z;
        }

        @Override // java.lang.Runnable
        public abstract void run();

        public void start() {
            synchronized (this) {
                if (this.thread != null) {
                    throw new IllegalStateException("already running");
                }
                this.thread = new Thread(ThreadGroup.systemThreadGroup, this, getClass().getSimpleName());
                this.thread.setDaemon(true);
                this.thread.start();
            }
        }

        public void stop() {
            Thread thread;
            synchronized (this) {
                thread = this.thread;
                this.thread = null;
            }
            if (thread == null) {
                throw new IllegalStateException("not running");
            }
            thread.interrupt();
            while (true) {
                try {
                    thread.join();
                    return;
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/Daemons$FinalizerDaemon.class */
    public static class FinalizerDaemon extends Daemon {
        private static final FinalizerDaemon INSTANCE = new FinalizerDaemon();
        private volatile Object finalizingObject;
        private volatile long finalizingStartedNanos;
        private final ReferenceQueue<Object> queue;

        private FinalizerDaemon() {
            super();
            this.queue = FinalizerReference.queue;
        }

        @FindBugsSuppressWarnings({"FI_EXPLICIT_INVOCATION"})
        private void doFinalize(FinalizerReference<?> finalizerReference) {
            FinalizerReference.remove(finalizerReference);
            Object obj = finalizerReference.get();
            finalizerReference.clear();
            try {
                this.finalizingStartedNanos = System.nanoTime();
                this.finalizingObject = obj;
                synchronized (FinalizerWatchdogDaemon.INSTANCE) {
                    FinalizerWatchdogDaemon.INSTANCE.notify();
                }
                obj.finalize();
            } catch (Throwable th) {
                try {
                    System.logE("Uncaught exception thrown by finalizer", th);
                } finally {
                    this.finalizingObject = null;
                }
            }
        }

        @Override // java.lang.Daemons.Daemon, java.lang.Runnable
        public void run() {
            while (isRunning()) {
                try {
                    doFinalize((FinalizerReference) this.queue.remove());
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/Daemons$FinalizerWatchdogDaemon.class */
    public static class FinalizerWatchdogDaemon extends Daemon {
        private static final FinalizerWatchdogDaemon INSTANCE = new FinalizerWatchdogDaemon();

        private FinalizerWatchdogDaemon() {
            super();
        }

        private static void finalizerTimedOut(Object obj) {
            String str = obj.getClass().getName() + ".finalize() timed out after 10 seconds";
            TimeoutException timeoutException = new TimeoutException(str);
            timeoutException.setStackTrace(FinalizerDaemon.INSTANCE.getStackTrace());
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler == null) {
                System.logE(str, timeoutException);
                System.exit(2);
            }
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), timeoutException);
        }

        private void sleepFor(long j, long j2) {
            while (true) {
                long nanoTime = (j2 - (System.nanoTime() - j)) / 1000000;
                if (nanoTime <= 0) {
                    return;
                }
                try {
                    Thread.sleep(nanoTime);
                } catch (InterruptedException e) {
                    if (!isRunning()) {
                        return;
                    }
                }
            }
        }

        private boolean waitForFinalization() {
            long j = FinalizerDaemon.INSTANCE.finalizingStartedNanos;
            sleepFor(j, Daemons.MAX_FINALIZE_NANOS);
            return FinalizerDaemon.INSTANCE.finalizingObject == null || FinalizerDaemon.INSTANCE.finalizingStartedNanos != j;
        }

        private boolean waitForObject() {
            while (FinalizerDaemon.INSTANCE.finalizingObject == null) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // java.lang.Daemons.Daemon, java.lang.Runnable
        public void run() {
            Object obj;
            while (isRunning()) {
                if (waitForObject() && !waitForFinalization() && !VMRuntime.getRuntime().isDebuggerActive() && (obj = FinalizerDaemon.INSTANCE.finalizingObject) != null) {
                    finalizerTimedOut(obj);
                    return;
                }
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/lang/Daemons$GCDaemon.class */
    private static class GCDaemon extends Daemon {
        private static final GCDaemon INSTANCE = new GCDaemon();
        private static final AtomicBoolean atomicBoolean = new AtomicBoolean();

        private GCDaemon() {
            super();
        }

        public void requestGC() {
            if (atomicBoolean.getAndSet(true)) {
                return;
            }
            synchronized (this) {
                notify();
            }
            atomicBoolean.set(false);
        }

        @Override // java.lang.Daemons.Daemon, java.lang.Runnable
        public void run() {
            while (isRunning()) {
                try {
                    synchronized (this) {
                        wait();
                    }
                    VMRuntime.getRuntime().concurrentGC();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/lang/Daemons$HeapTrimmerDaemon.class */
    private static class HeapTrimmerDaemon extends Daemon {
        private static final HeapTrimmerDaemon INSTANCE = new HeapTrimmerDaemon();

        private HeapTrimmerDaemon() {
            super();
        }

        @Override // java.lang.Daemons.Daemon, java.lang.Runnable
        public void run() {
            while (isRunning()) {
                try {
                    synchronized (this) {
                        wait();
                    }
                    VMRuntime.getRuntime().trimHeap();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/lang/Daemons$ReferenceQueueDaemon.class */
    private static class ReferenceQueueDaemon extends Daemon {
        private static final ReferenceQueueDaemon INSTANCE = new ReferenceQueueDaemon();

        private ReferenceQueueDaemon() {
            super();
        }

        private void enqueue(Reference<?> reference) {
            Reference<?> reference2;
            Reference<?> reference3;
            while (reference != null) {
                if (reference == reference.pendingNext) {
                    reference.pendingNext = null;
                    reference3 = null;
                    reference2 = reference;
                } else {
                    reference2 = reference.pendingNext;
                    reference.pendingNext = reference2.pendingNext;
                    reference2.pendingNext = null;
                    reference3 = reference;
                }
                reference2.enqueueInternal();
                reference = reference3;
            }
        }

        @Override // java.lang.Daemons.Daemon, java.lang.Runnable
        public void run() {
            Reference<?> reference;
            while (isRunning()) {
                try {
                    synchronized (ReferenceQueue.class) {
                        while (ReferenceQueue.unenqueued == null) {
                            ReferenceQueue.class.wait();
                        }
                        reference = ReferenceQueue.unenqueued;
                        ReferenceQueue.unenqueued = null;
                    }
                    enqueue(reference);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void requestGC() {
        GCDaemon.INSTANCE.requestGC();
    }

    public static void requestHeapTrim() {
        synchronized (HeapTrimmerDaemon.INSTANCE) {
            HeapTrimmerDaemon.INSTANCE.notify();
        }
    }

    public static void start() {
        ReferenceQueueDaemon.INSTANCE.start();
        FinalizerDaemon.INSTANCE.start();
        FinalizerWatchdogDaemon.INSTANCE.start();
        HeapTrimmerDaemon.INSTANCE.start();
        GCDaemon.INSTANCE.start();
    }

    public static void stop() {
        ReferenceQueueDaemon.INSTANCE.stop();
        FinalizerDaemon.INSTANCE.stop();
        FinalizerWatchdogDaemon.INSTANCE.stop();
        HeapTrimmerDaemon.INSTANCE.stop();
        GCDaemon.INSTANCE.stop();
    }
}
