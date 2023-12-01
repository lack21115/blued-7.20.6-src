package java.util.concurrent.locks;

import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/LockSupport.class */
public class LockSupport {
    private static final long parkBlockerOffset;
    private static final Unsafe unsafe = Unsafe.getUnsafe();

    static {
        try {
            parkBlockerOffset = unsafe.objectFieldOffset(Thread.class.getDeclaredField("parkBlocker"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private LockSupport() {
    }

    public static Object getBlocker(Thread thread) {
        if (thread == null) {
            throw new NullPointerException();
        }
        return unsafe.getObjectVolatile(thread, parkBlockerOffset);
    }

    public static void park() {
        unsafe.park(false, 0L);
    }

    public static void park(Object obj) {
        Thread currentThread = Thread.currentThread();
        setBlocker(currentThread, obj);
        unsafe.park(false, 0L);
        setBlocker(currentThread, null);
    }

    public static void parkNanos(long j) {
        if (j > 0) {
            unsafe.park(false, j);
        }
    }

    public static void parkNanos(Object obj, long j) {
        if (j > 0) {
            Thread currentThread = Thread.currentThread();
            setBlocker(currentThread, obj);
            unsafe.park(false, j);
            setBlocker(currentThread, null);
        }
    }

    public static void parkUntil(long j) {
        unsafe.park(true, j);
    }

    public static void parkUntil(Object obj, long j) {
        Thread currentThread = Thread.currentThread();
        setBlocker(currentThread, obj);
        unsafe.park(true, j);
        setBlocker(currentThread, null);
    }

    private static void setBlocker(Thread thread, Object obj) {
        unsafe.putObject(thread, parkBlockerOffset, obj);
    }

    public static void unpark(Thread thread) {
        if (thread != null) {
            unsafe.unpark(thread);
        }
    }
}
