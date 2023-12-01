package android.view;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import dalvik.system.CloseGuard;

/* loaded from: source-9557208-dex2jar.jar:android/view/DisplayEventReceiver.class */
public abstract class DisplayEventReceiver {
    private static final String TAG = "DisplayEventReceiver";
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private MessageQueue mMessageQueue;
    private long mReceiverPtr;

    public DisplayEventReceiver(Looper looper) {
        if (looper == null) {
            throw new IllegalArgumentException("looper must not be null");
        }
        this.mMessageQueue = looper.getQueue();
        this.mReceiverPtr = nativeInit(this, this.mMessageQueue);
        this.mCloseGuard.open("dispose");
    }

    private void dispatchHotplug(long j, int i, boolean z) {
        onHotplug(j, i, z);
    }

    private void dispatchVsync(long j, int i, int i2) {
        onVsync(j, i, i2);
    }

    private void dispose(boolean z) {
        if (this.mCloseGuard != null) {
            if (z) {
                this.mCloseGuard.warnIfOpen();
            }
            this.mCloseGuard.close();
        }
        if (this.mReceiverPtr != 0) {
            nativeDispose(this.mReceiverPtr);
            this.mReceiverPtr = 0L;
        }
        this.mMessageQueue = null;
    }

    private static native void nativeDispose(long j);

    private static native long nativeInit(DisplayEventReceiver displayEventReceiver, MessageQueue messageQueue);

    private static native void nativeScheduleVsync(long j);

    public void dispose() {
        dispose(false);
    }

    protected void finalize() throws Throwable {
        try {
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    public void onHotplug(long j, int i, boolean z) {
    }

    public void onVsync(long j, int i, int i2) {
    }

    public void scheduleVsync() {
        if (this.mReceiverPtr == 0) {
            Log.w(TAG, "Attempted to schedule a vertical sync pulse but the display event receiver has already been disposed.");
        } else {
            nativeScheduleVsync(this.mReceiverPtr);
        }
    }
}
