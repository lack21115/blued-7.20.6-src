package android.os;

import android.util.Log;
import android.util.Printer;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/os/Looper.class */
public final class Looper {
    private static final String TAG = "Looper";
    private static Looper sMainLooper;
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    private Printer mLogging;
    final MessageQueue mQueue;
    final Thread mThread = Thread.currentThread();

    private Looper(boolean z) {
        this.mQueue = new MessageQueue(z);
    }

    public static Looper getMainLooper() {
        Looper looper;
        synchronized (Looper.class) {
            try {
                looper = sMainLooper;
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public static void loop() {
        Looper myLooper = myLooper();
        if (myLooper == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }
        MessageQueue messageQueue = myLooper.mQueue;
        Binder.clearCallingIdentity();
        long clearCallingIdentity = Binder.clearCallingIdentity();
        while (true) {
            Message next = messageQueue.next();
            if (next == null) {
                return;
            }
            Printer printer = myLooper.mLogging;
            if (printer != null) {
                printer.println(">>>>> Dispatching to " + next.target + " " + next.callback + ": " + next.what);
            }
            next.target.dispatchMessage(next);
            if (printer != null) {
                printer.println("<<<<< Finished to " + next.target + " " + next.callback);
            }
            long clearCallingIdentity2 = Binder.clearCallingIdentity();
            if (clearCallingIdentity != clearCallingIdentity2) {
                Log.wtf(TAG, "Thread identity changed from 0x" + Long.toHexString(clearCallingIdentity) + " to 0x" + Long.toHexString(clearCallingIdentity2) + " while dispatching to " + next.target.getClass().getName() + " " + next.callback + " what=" + next.what);
            }
            next.recycleUnchecked();
        }
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }

    public static void prepare() {
        prepare(true);
    }

    private static void prepare(boolean z) {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper(z));
    }

    public static void prepareMainLooper() {
        prepare(false);
        synchronized (Looper.class) {
            try {
                if (sMainLooper != null) {
                    throw new IllegalStateException("The main Looper has already been prepared.");
                }
                sMainLooper = myLooper();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void dump(Printer printer, String str) {
        printer.println(str + toString());
        this.mQueue.dump(printer, str + "  ");
    }

    public MessageQueue getQueue() {
        return this.mQueue;
    }

    public Thread getThread() {
        return this.mThread;
    }

    public boolean isCurrentThread() {
        return Thread.currentThread() == this.mThread;
    }

    public boolean isIdling() {
        return this.mQueue.isIdling();
    }

    public int postSyncBarrier() {
        return this.mQueue.enqueueSyncBarrier(SystemClock.uptimeMillis());
    }

    public void quit() {
        this.mQueue.quit(false);
    }

    public void quitSafely() {
        this.mQueue.quit(true);
    }

    public void removeSyncBarrier(int i) {
        this.mQueue.removeSyncBarrier(i);
    }

    public void setMessageLogging(Printer printer) {
        this.mLogging = printer;
    }

    public String toString() {
        return "Looper (" + this.mThread.getName() + ", tid " + this.mThread.getId() + ") {" + Integer.toHexString(System.identityHashCode(this)) + i.d;
    }
}
