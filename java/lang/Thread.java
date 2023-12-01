package java.lang;

import dalvik.system.VMStack;
import java.lang.ThreadLocal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Thread.class */
public class Thread implements Runnable {
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 1;
    private static final int NANOS_PER_MILLI = 1000000;
    public static final int NORM_PRIORITY = 5;
    private static int count = 0;
    private static UncaughtExceptionHandler defaultUncaughtHandler;
    private ClassLoader contextClassLoader;
    volatile boolean daemon;
    volatile ThreadGroup group;
    private long id;
    ThreadLocal.Values inheritableValues;
    ThreadLocal.Values localValues;
    volatile String name;
    private volatile long nativePeer;
    private Object parkBlocker;
    volatile int priority;
    volatile long stackSize;
    Runnable target;
    private UncaughtExceptionHandler uncaughtHandler;
    private final List<Runnable> interruptActions = new ArrayList();
    boolean hasBeenStarted = false;
    private int parkState = 1;
    private final Object lock = new Object();

    /* loaded from: source-2895416-dex2jar.jar:java/lang/Thread$ParkState.class */
    private static class ParkState {
        private static final int PARKED = 3;
        private static final int PREEMPTIVELY_UNPARKED = 2;
        private static final int UNPARKED = 1;

        private ParkState() {
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/lang/Thread$State.class */
    public enum State {
        NEW,
        RUNNABLE,
        BLOCKED,
        WAITING,
        TIMED_WAITING,
        TERMINATED
    }

    /* loaded from: source-2895416-dex2jar.jar:java/lang/Thread$UncaughtExceptionHandler.class */
    public interface UncaughtExceptionHandler {
        void uncaughtException(Thread thread, Throwable th);
    }

    public Thread() {
        create(null, null, null, 0L);
    }

    public Thread(Runnable runnable) {
        create(null, runnable, null, 0L);
    }

    public Thread(Runnable runnable, String str) {
        if (str == null) {
            throw new NullPointerException("threadName == null");
        }
        create(null, runnable, str, 0L);
    }

    public Thread(String str) {
        if (str == null) {
            throw new NullPointerException("threadName == null");
        }
        create(null, null, str, 0L);
    }

    public Thread(ThreadGroup threadGroup, Runnable runnable) {
        create(threadGroup, runnable, null, 0L);
    }

    public Thread(ThreadGroup threadGroup, Runnable runnable, String str) {
        if (str == null) {
            throw new NullPointerException("threadName == null");
        }
        create(threadGroup, runnable, str, 0L);
    }

    public Thread(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        if (str == null) {
            throw new NullPointerException("threadName == null");
        }
        create(threadGroup, runnable, str, j);
    }

    public Thread(ThreadGroup threadGroup, String str) {
        if (str == null) {
            throw new NullPointerException("threadName == null");
        }
        create(threadGroup, null, str, 0L);
    }

    Thread(ThreadGroup threadGroup, String str, int i, boolean z) {
        synchronized (Thread.class) {
            try {
                int i2 = count + 1;
                count = i2;
                this.id = i2;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str == null) {
            this.name = "Thread-" + this.id;
        } else {
            this.name = str;
        }
        if (threadGroup == null) {
            throw new InternalError("group == null");
        }
        this.group = threadGroup;
        this.target = null;
        this.stackSize = 0L;
        this.priority = i;
        this.daemon = z;
        this.group.addThread(this);
    }

    public static int activeCount() {
        return currentThread().getThreadGroup().activeCount();
    }

    private void checkNotStarted() {
        if (this.hasBeenStarted) {
            throw new IllegalThreadStateException("Thread already started");
        }
    }

    private void create(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        Thread currentThread = currentThread();
        ThreadGroup threadGroup2 = threadGroup;
        if (threadGroup == null) {
            threadGroup2 = currentThread.getThreadGroup();
        }
        if (threadGroup2.isDestroyed()) {
            throw new IllegalThreadStateException("Group already destroyed");
        }
        this.group = threadGroup2;
        synchronized (Thread.class) {
            try {
                int i = count + 1;
                count = i;
                this.id = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str == null) {
            this.name = "Thread-" + this.id;
        } else {
            this.name = str;
        }
        this.target = runnable;
        this.stackSize = j;
        this.priority = currentThread.getPriority();
        this.contextClassLoader = currentThread.contextClassLoader;
        if (currentThread.inheritableValues != null) {
            this.inheritableValues = new ThreadLocal.Values(currentThread.inheritableValues);
        }
        this.group.addThread(this);
    }

    public static native Thread currentThread();

    public static void dumpStack() {
        new Throwable("stack dump").printStackTrace();
    }

    public static int enumerate(Thread[] threadArr) {
        return currentThread().getThreadGroup().enumerate(threadArr);
    }

    public static Map<Thread, StackTraceElement[]> getAllStackTraces() {
        HashMap hashMap = new HashMap();
        int activeCount = ThreadGroup.systemThreadGroup.activeCount();
        Thread[] threadArr = new Thread[(activeCount / 2) + activeCount];
        int enumerate = ThreadGroup.systemThreadGroup.enumerate(threadArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= enumerate) {
                return hashMap;
            }
            hashMap.put(threadArr[i2], threadArr[i2].getStackTrace());
            i = i2 + 1;
        }
    }

    public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return defaultUncaughtHandler;
    }

    public static boolean holdsLock(Object obj) {
        return currentThread().nativeHoldsLock(obj);
    }

    public static native boolean interrupted();

    private static native void nativeCreate(Thread thread, long j, boolean z);

    private native int nativeGetStatus(boolean z);

    private native boolean nativeHoldsLock(Object obj);

    private native void nativeInterrupt();

    private native void nativeSetName(String str);

    private native void nativeSetPriority(int i);

    public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        defaultUncaughtHandler = uncaughtExceptionHandler;
    }

    public static void sleep(long j) throws InterruptedException {
        sleep(j, 0);
    }

    public static void sleep(long j, int i) throws InterruptedException {
        if (j < 0) {
            throw new IllegalArgumentException("millis < 0: " + j);
        }
        if (i < 0) {
            throw new IllegalArgumentException("nanos < 0: " + i);
        }
        if (i > 999999) {
            throw new IllegalArgumentException("nanos > 999999: " + i);
        }
        if (j == 0 && i == 0) {
            if (interrupted()) {
                throw new InterruptedException();
            }
            return;
        }
        long nanoTime = System.nanoTime();
        long j2 = (1000000 * j) + i;
        Object obj = currentThread().lock;
        synchronized (obj) {
            long j3 = j;
            long j4 = j2;
            while (true) {
                sleep(obj, j3, i);
                long nanoTime2 = System.nanoTime();
                long j5 = nanoTime2 - nanoTime;
                if (j5 < j4) {
                    j4 -= j5;
                    nanoTime = nanoTime2;
                    j3 = j4 / 1000000;
                    i = (int) (j4 % 1000000);
                }
            }
        }
    }

    private static native void sleep(Object obj, long j, int i);

    public static native void yield();

    public final void checkAccess() {
    }

    @Deprecated
    public int countStackFrames() {
        return getStackTrace().length;
    }

    @Deprecated
    public void destroy() {
        throw new UnsupportedOperationException();
    }

    public ClassLoader getContextClassLoader() {
        return this.contextClassLoader;
    }

    public long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPriority() {
        return this.priority;
    }

    public StackTraceElement[] getStackTrace() {
        StackTraceElement[] threadStackTrace = VMStack.getThreadStackTrace(this);
        return threadStackTrace != null ? threadStackTrace : EmptyArray.STACK_TRACE_ELEMENT;
    }

    public State getState() {
        return State.values()[nativeGetStatus(this.hasBeenStarted)];
    }

    public final ThreadGroup getThreadGroup() {
        if (getState() == State.TERMINATED) {
            return null;
        }
        return this.group;
    }

    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.uncaughtHandler != null ? this.uncaughtHandler : this.group;
    }

    public void interrupt() {
        nativeInterrupt();
        synchronized (this.interruptActions) {
            int size = this.interruptActions.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.interruptActions.get(i).run();
                    size = i;
                }
            }
        }
    }

    public final boolean isAlive() {
        return this.nativePeer != 0;
    }

    public final boolean isDaemon() {
        return this.daemon;
    }

    public native boolean isInterrupted();

    public final void join() throws InterruptedException {
        synchronized (this.lock) {
            while (isAlive()) {
                this.lock.wait();
            }
        }
    }

    public final void join(long j) throws InterruptedException {
        join(j, 0);
    }

    public final void join(long j, int i) throws InterruptedException {
        if (j < 0 || i < 0 || i >= NANOS_PER_MILLI) {
            throw new IllegalArgumentException("bad timeout: millis=" + j + ",nanos=" + i);
        }
        if (((((long) i) | j) == 0) || ((j > ((Long.MAX_VALUE - ((long) i)) / 1000000) ? 1 : (j == ((Long.MAX_VALUE - ((long) i)) / 1000000) ? 0 : -1)) >= 0)) {
            join();
            return;
        }
        synchronized (this.lock) {
            if (isAlive()) {
                long j2 = i;
                long nanoTime = System.nanoTime();
                long j3 = j;
                while (true) {
                    this.lock.wait(j3, i);
                    if (!isAlive()) {
                        break;
                    }
                    long nanoTime2 = ((1000000 * j) + j2) - (System.nanoTime() - nanoTime);
                    if (nanoTime2 <= 0) {
                        break;
                    }
                    j3 = nanoTime2 / 1000000;
                    i = (int) (nanoTime2 - (1000000 * j3));
                }
            }
        }
    }

    public void parkFor(long j) {
        synchronized (this.lock) {
            switch (this.parkState) {
                case 1:
                    long j2 = j / 1000000;
                    this.parkState = 3;
                    try {
                        this.lock.wait(j2, (int) (j % 1000000));
                        if (this.parkState == 3) {
                            this.parkState = 1;
                            break;
                        }
                    } catch (InterruptedException e) {
                        interrupt();
                        if (this.parkState == 3) {
                            this.parkState = 1;
                            break;
                        }
                    }
                    break;
                case 2:
                    this.parkState = 1;
                    break;
                default:
                    throw new AssertionError("Attempt to repark");
            }
        }
    }

    public void parkUntil(long j) {
        synchronized (this.lock) {
            long currentTimeMillis = j - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                this.parkState = 1;
            } else {
                parkFor(1000000 * currentTimeMillis);
            }
        }
    }

    public final void popInterruptAction$(Runnable runnable) {
        synchronized (this.interruptActions) {
            Runnable remove = this.interruptActions.remove(this.interruptActions.size() - 1);
            if (runnable != remove) {
                throw new IllegalArgumentException("Expected " + runnable + " but was " + remove);
            }
        }
    }

    public final void pushInterruptAction$(Runnable runnable) {
        synchronized (this.interruptActions) {
            this.interruptActions.add(runnable);
        }
        if (runnable == null || !isInterrupted()) {
            return;
        }
        runnable.run();
    }

    @Deprecated
    public final void resume() {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.target != null) {
            this.target.run();
        }
    }

    public void setContextClassLoader(ClassLoader classLoader) {
        this.contextClassLoader = classLoader;
    }

    public final void setDaemon(boolean z) {
        checkNotStarted();
        if (this.nativePeer == 0) {
            this.daemon = z;
        }
    }

    public final void setName(String str) {
        if (str == null) {
            throw new NullPointerException("threadName == null");
        }
        synchronized (this) {
            this.name = str;
            if (isAlive()) {
                nativeSetName(str);
            }
        }
    }

    public final void setPriority(int i) {
        if (i < 1 || i > 10) {
            throw new IllegalArgumentException("Priority out of range: " + i);
        }
        int i2 = i;
        if (i > this.group.getMaxPriority()) {
            i2 = this.group.getMaxPriority();
        }
        synchronized (this) {
            this.priority = i2;
            if (isAlive()) {
                nativeSetPriority(i2);
            }
        }
    }

    public void setUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtHandler = uncaughtExceptionHandler;
    }

    public void start() {
        synchronized (this) {
            checkNotStarted();
            this.hasBeenStarted = true;
            nativeCreate(this, this.stackSize, this.daemon);
        }
    }

    @Deprecated
    public final void stop() {
        stop(new ThreadDeath());
    }

    @Deprecated
    public final void stop(Throwable th) {
        synchronized (this) {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    public final void suspend() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "Thread[" + this.name + "," + this.priority + "," + this.group.getName() + "]";
    }

    public void unpark() {
        synchronized (this.lock) {
            switch (this.parkState) {
                case 1:
                    this.parkState = 2;
                    break;
                case 2:
                    break;
                default:
                    this.parkState = 1;
                    this.lock.notifyAll();
                    break;
            }
        }
    }
}
