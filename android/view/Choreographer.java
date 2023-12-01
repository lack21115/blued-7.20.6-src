package android.view;

import android.hardware.display.DisplayManagerGlobal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import android.util.TimeUtils;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/view/Choreographer.class */
public final class Choreographer {
    public static final int CALLBACK_ANIMATION = 1;
    public static final int CALLBACK_INPUT = 0;
    private static final int CALLBACK_LAST = 2;
    public static final int CALLBACK_TRAVERSAL = 2;
    private static final boolean DEBUG = false;
    private static final long DEFAULT_FRAME_DELAY = 10;
    private static final int MSG_DO_FRAME = 0;
    private static final int MSG_DO_SCHEDULE_CALLBACK = 2;
    private static final int MSG_DO_SCHEDULE_VSYNC = 1;
    private static final String TAG = "Choreographer";
    private CallbackRecord mCallbackPool;
    private final CallbackQueue[] mCallbackQueues;
    private boolean mCallbacksRunning;
    private final FrameDisplayEventReceiver mDisplayEventReceiver;
    private long mFrameIntervalNanos;
    private boolean mFrameScheduled;
    private final FrameHandler mHandler;
    private long mLastFrameTimeNanos;
    private final Object mLock;
    private final Looper mLooper;
    private static volatile long sFrameDelay = 10;
    private static final ThreadLocal<Choreographer> sThreadInstance = new ThreadLocal<Choreographer>() { // from class: android.view.Choreographer.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Choreographer initialValue() {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                throw new IllegalStateException("The current thread must have a looper!");
            }
            return new Choreographer(myLooper);
        }
    };
    private static final boolean USE_VSYNC = SystemProperties.getBoolean("debug.choreographer.vsync", true);
    private static final boolean USE_FRAME_TIME = SystemProperties.getBoolean("debug.choreographer.frametime", true);
    private static final int SKIPPED_FRAME_WARNING_LIMIT = SystemProperties.getInt("debug.choreographer.skipwarning", 30);
    private static final Object FRAME_CALLBACK_TOKEN = new Object() { // from class: android.view.Choreographer.2
        public String toString() {
            return "FRAME_CALLBACK_TOKEN";
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/Choreographer$CallbackQueue.class */
    public final class CallbackQueue {
        private CallbackRecord mHead;

        private CallbackQueue() {
        }

        public void addCallbackLocked(long j, Object obj, Object obj2) {
            CallbackRecord obtainCallbackLocked = Choreographer.this.obtainCallbackLocked(j, obj, obj2);
            CallbackRecord callbackRecord = this.mHead;
            if (callbackRecord == null) {
                this.mHead = obtainCallbackLocked;
                return;
            }
            CallbackRecord callbackRecord2 = callbackRecord;
            if (j < callbackRecord.dueTime) {
                obtainCallbackLocked.next = callbackRecord;
                this.mHead = obtainCallbackLocked;
                return;
            }
            while (true) {
                if (callbackRecord2.next == null) {
                    break;
                } else if (j < callbackRecord2.next.dueTime) {
                    obtainCallbackLocked.next = callbackRecord2.next;
                    break;
                } else {
                    callbackRecord2 = callbackRecord2.next;
                }
            }
            callbackRecord2.next = obtainCallbackLocked;
        }

        public CallbackRecord extractDueCallbacksLocked(long j) {
            CallbackRecord callbackRecord;
            CallbackRecord callbackRecord2 = this.mHead;
            if (callbackRecord2 == null || callbackRecord2.dueTime > j) {
                return null;
            }
            CallbackRecord callbackRecord3 = callbackRecord2;
            CallbackRecord callbackRecord4 = callbackRecord3.next;
            while (true) {
                callbackRecord = callbackRecord4;
                if (callbackRecord == null) {
                    break;
                } else if (callbackRecord.dueTime > j) {
                    callbackRecord3.next = null;
                    break;
                } else {
                    callbackRecord3 = callbackRecord;
                    callbackRecord4 = callbackRecord.next;
                }
            }
            this.mHead = callbackRecord;
            return callbackRecord2;
        }

        public boolean hasDueCallbacksLocked(long j) {
            return this.mHead != null && this.mHead.dueTime <= j;
        }

        public void removeCallbacksLocked(Object obj, Object obj2) {
            CallbackRecord callbackRecord = null;
            CallbackRecord callbackRecord2 = this.mHead;
            while (true) {
                CallbackRecord callbackRecord3 = callbackRecord2;
                if (callbackRecord3 == null) {
                    return;
                }
                CallbackRecord callbackRecord4 = callbackRecord3.next;
                if ((obj == null || callbackRecord3.action == obj) && (obj2 == null || callbackRecord3.token == obj2)) {
                    if (callbackRecord != null) {
                        callbackRecord.next = callbackRecord4;
                    } else {
                        this.mHead = callbackRecord4;
                    }
                    Choreographer.this.recycleCallbackLocked(callbackRecord3);
                } else {
                    callbackRecord = callbackRecord3;
                }
                callbackRecord2 = callbackRecord4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/Choreographer$CallbackRecord.class */
    public static final class CallbackRecord {
        public Object action;
        public long dueTime;
        public CallbackRecord next;
        public Object token;

        private CallbackRecord() {
        }

        public void run(long j) {
            if (this.token == Choreographer.FRAME_CALLBACK_TOKEN) {
                ((FrameCallback) this.action).doFrame(j);
            } else {
                ((Runnable) this.action).run();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/Choreographer$FrameCallback.class */
    public interface FrameCallback {
        void doFrame(long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/Choreographer$FrameDisplayEventReceiver.class */
    public final class FrameDisplayEventReceiver extends DisplayEventReceiver implements Runnable {
        private int mFrame;
        private boolean mHavePendingVsync;
        private long mTimestampNanos;

        public FrameDisplayEventReceiver(Looper looper) {
            super(looper);
        }

        @Override // android.view.DisplayEventReceiver
        public void onVsync(long j, int i, int i2) {
            if (i != 0) {
                Log.d(Choreographer.TAG, "Received vsync from secondary display, but we don't support this case yet.  Choreographer needs a way to explicitly request vsync for a specific display to ensure it doesn't lose track of its scheduled vsync.");
                scheduleVsync();
                return;
            }
            long nanoTime = System.nanoTime();
            long j2 = j;
            if (j > nanoTime) {
                Log.w(Choreographer.TAG, "Frame time is " + (((float) (j - nanoTime)) * 1.0E-6f) + " ms in the future!  Check that graphics HAL is generating vsync timestamps using the correct timebase.");
                j2 = nanoTime;
            }
            if (this.mHavePendingVsync) {
                Log.w(Choreographer.TAG, "Already have a pending vsync event.  There should only be one at a time.");
            } else {
                this.mHavePendingVsync = true;
            }
            this.mTimestampNanos = j2;
            this.mFrame = i2;
            Message obtain = Message.obtain(Choreographer.this.mHandler, this);
            obtain.setAsynchronous(true);
            Choreographer.this.mHandler.sendMessageAtTime(obtain, j2 / 1000000);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mHavePendingVsync = false;
            Choreographer.this.doFrame(this.mTimestampNanos, this.mFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/Choreographer$FrameHandler.class */
    public final class FrameHandler extends Handler {
        public FrameHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    Choreographer.this.doFrame(System.nanoTime(), 0);
                    return;
                case 1:
                    Choreographer.this.doScheduleVsync();
                    return;
                case 2:
                    Choreographer.this.doScheduleCallback(message.arg1);
                    return;
                default:
                    return;
            }
        }
    }

    private Choreographer(Looper looper) {
        this.mLock = new Object();
        this.mLooper = looper;
        this.mHandler = new FrameHandler(looper);
        this.mDisplayEventReceiver = USE_VSYNC ? new FrameDisplayEventReceiver(looper) : null;
        this.mLastFrameTimeNanos = Long.MIN_VALUE;
        this.mFrameIntervalNanos = 1.0E9f / getRefreshRate();
        this.mCallbackQueues = new CallbackQueue[3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 2) {
                return;
            }
            this.mCallbackQueues[i2] = new CallbackQueue();
            i = i2 + 1;
        }
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static Choreographer getInstance() {
        return sThreadInstance.get();
    }

    private static float getRefreshRate() {
        return DisplayManagerGlobal.getInstance().getDisplayInfo(0).refreshRate;
    }

    private boolean isRunningOnLooperThreadLocked() {
        return Looper.myLooper() == this.mLooper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CallbackRecord obtainCallbackLocked(long j, Object obj, Object obj2) {
        CallbackRecord callbackRecord = this.mCallbackPool;
        if (callbackRecord == null) {
            callbackRecord = new CallbackRecord();
        } else {
            this.mCallbackPool = callbackRecord.next;
            callbackRecord.next = null;
        }
        callbackRecord.dueTime = j;
        callbackRecord.action = obj;
        callbackRecord.token = obj2;
        return callbackRecord;
    }

    private void postCallbackDelayedInternal(int i, Object obj, Object obj2, long j) {
        synchronized (this.mLock) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = uptimeMillis + j;
            this.mCallbackQueues[i].addCallbackLocked(j2, obj, obj2);
            if (j2 <= uptimeMillis) {
                scheduleFrameLocked(uptimeMillis);
            } else {
                Message obtainMessage = this.mHandler.obtainMessage(2, obj);
                obtainMessage.arg1 = i;
                obtainMessage.setAsynchronous(true);
                this.mHandler.sendMessageAtTime(obtainMessage, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recycleCallbackLocked(CallbackRecord callbackRecord) {
        callbackRecord.action = null;
        callbackRecord.token = null;
        callbackRecord.next = this.mCallbackPool;
        this.mCallbackPool = callbackRecord;
    }

    private void removeCallbacksInternal(int i, Object obj, Object obj2) {
        synchronized (this.mLock) {
            this.mCallbackQueues[i].removeCallbacksLocked(obj, obj2);
            if (obj != null && obj2 == null) {
                this.mHandler.removeMessages(2, obj);
            }
        }
    }

    private void scheduleFrameLocked(long j) {
        if (this.mFrameScheduled) {
            return;
        }
        this.mFrameScheduled = true;
        if (!USE_VSYNC) {
            long max = Math.max((this.mLastFrameTimeNanos / 1000000) + sFrameDelay, j);
            Message obtainMessage = this.mHandler.obtainMessage(0);
            obtainMessage.setAsynchronous(true);
            this.mHandler.sendMessageAtTime(obtainMessage, max);
        } else if (isRunningOnLooperThreadLocked()) {
            scheduleVsyncLocked();
        } else {
            Message obtainMessage2 = this.mHandler.obtainMessage(1);
            obtainMessage2.setAsynchronous(true);
            this.mHandler.sendMessageAtFrontOfQueue(obtainMessage2);
        }
    }

    private void scheduleVsyncLocked() {
        this.mDisplayEventReceiver.scheduleVsync();
    }

    public static void setFrameDelay(long j) {
        sFrameDelay = j;
    }

    public static long subtractFrameDelay(long j) {
        long j2 = sFrameDelay;
        if (j <= j2) {
            return 0L;
        }
        return j - j2;
    }

    void doCallbacks(int i, long j) {
        CallbackRecord callbackRecord;
        CallbackRecord callbackRecord2;
        synchronized (this.mLock) {
            CallbackRecord extractDueCallbacksLocked = this.mCallbackQueues[i].extractDueCallbacksLocked(SystemClock.uptimeMillis());
            if (extractDueCallbacksLocked == null) {
                return;
            }
            this.mCallbacksRunning = true;
            for (CallbackRecord callbackRecord3 = extractDueCallbacksLocked; callbackRecord3 != null; callbackRecord3 = callbackRecord3.next) {
                try {
                    callbackRecord3.run(j);
                } catch (Throwable th) {
                    synchronized (this.mLock) {
                        this.mCallbacksRunning = false;
                        do {
                            callbackRecord2 = extractDueCallbacksLocked.next;
                            recycleCallbackLocked(extractDueCallbacksLocked);
                            extractDueCallbacksLocked = callbackRecord2;
                        } while (callbackRecord2 != null);
                        throw th;
                    }
                }
            }
            synchronized (this.mLock) {
                this.mCallbacksRunning = false;
                do {
                    callbackRecord = extractDueCallbacksLocked.next;
                    recycleCallbackLocked(extractDueCallbacksLocked);
                    extractDueCallbacksLocked = callbackRecord;
                } while (callbackRecord != null);
            }
        }
    }

    void doFrame(long j, int i) {
        synchronized (this.mLock) {
            if (this.mFrameScheduled) {
                long nanoTime = System.nanoTime();
                long j2 = nanoTime - j;
                if (j2 >= this.mFrameIntervalNanos) {
                    long j3 = j2 / this.mFrameIntervalNanos;
                    if (j3 >= SKIPPED_FRAME_WARNING_LIMIT) {
                        Log.i(TAG, "Skipped " + j3 + " frames!  The application may be doing too much work on its main thread.");
                    }
                    j = nanoTime - (j2 % this.mFrameIntervalNanos);
                }
                if (j < this.mLastFrameTimeNanos) {
                    scheduleVsyncLocked();
                    return;
                }
                this.mFrameScheduled = false;
                this.mLastFrameTimeNanos = j;
                doCallbacks(0, j);
                doCallbacks(1, j);
                doCallbacks(2, j);
            }
        }
    }

    void doScheduleCallback(int i) {
        synchronized (this.mLock) {
            if (!this.mFrameScheduled) {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.mCallbackQueues[i].hasDueCallbacksLocked(uptimeMillis)) {
                    scheduleFrameLocked(uptimeMillis);
                }
            }
        }
    }

    void doScheduleVsync() {
        synchronized (this.mLock) {
            if (this.mFrameScheduled) {
                scheduleVsyncLocked();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(String str, PrintWriter printWriter) {
        String str2 = str + "  ";
        printWriter.print(str);
        printWriter.println("Choreographer:");
        printWriter.print(str2);
        printWriter.print("mFrameScheduled=");
        printWriter.println(this.mFrameScheduled);
        printWriter.print(str2);
        printWriter.print("mLastFrameTime=");
        printWriter.println(TimeUtils.formatUptime(this.mLastFrameTimeNanos / 1000000));
    }

    public long getFrameIntervalNanos() {
        return this.mFrameIntervalNanos;
    }

    public long getFrameTime() {
        return getFrameTimeNanos() / 1000000;
    }

    public long getFrameTimeNanos() {
        long nanoTime;
        synchronized (this.mLock) {
            if (!this.mCallbacksRunning) {
                throw new IllegalStateException("This method must only be called as part of a callback while a frame is in progress.");
            }
            nanoTime = USE_FRAME_TIME ? this.mLastFrameTimeNanos : System.nanoTime();
        }
        return nanoTime;
    }

    public void postCallback(int i, Runnable runnable, Object obj) {
        postCallbackDelayed(i, runnable, obj, 0L);
    }

    public void postCallbackDelayed(int i, Runnable runnable, Object obj, long j) {
        if (runnable == null) {
            throw new IllegalArgumentException("action must not be null");
        }
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("callbackType is invalid");
        }
        postCallbackDelayedInternal(i, runnable, obj, j);
    }

    public void postFrameCallback(FrameCallback frameCallback) {
        postFrameCallbackDelayed(frameCallback, 0L);
    }

    public void postFrameCallbackDelayed(FrameCallback frameCallback, long j) {
        if (frameCallback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        postCallbackDelayedInternal(1, frameCallback, FRAME_CALLBACK_TOKEN, j);
    }

    public void removeCallbacks(int i, Runnable runnable, Object obj) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("callbackType is invalid");
        }
        removeCallbacksInternal(i, runnable, obj);
    }

    public void removeFrameCallback(FrameCallback frameCallback) {
        if (frameCallback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        removeCallbacksInternal(1, frameCallback, FRAME_CALLBACK_TOKEN);
    }
}
