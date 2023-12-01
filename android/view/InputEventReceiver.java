package android.view;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.util.SparseIntArray;
import dalvik.system.CloseGuard;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/view/InputEventReceiver.class */
public abstract class InputEventReceiver {
    private static final String TAG = "InputEventReceiver";
    private InputChannel mInputChannel;
    private MessageQueue mMessageQueue;
    private long mReceiverPtr;
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private final SparseIntArray mSeqMap = new SparseIntArray();

    /* loaded from: source-9557208-dex2jar.jar:android/view/InputEventReceiver$Factory.class */
    public interface Factory {
        InputEventReceiver createInputEventReceiver(InputChannel inputChannel, Looper looper);
    }

    public InputEventReceiver(InputChannel inputChannel, Looper looper) {
        if (inputChannel == null) {
            throw new IllegalArgumentException("inputChannel must not be null");
        }
        if (looper == null) {
            throw new IllegalArgumentException("looper must not be null");
        }
        this.mInputChannel = inputChannel;
        this.mMessageQueue = looper.getQueue();
        this.mReceiverPtr = nativeInit(new WeakReference(this), inputChannel, this.mMessageQueue);
        this.mCloseGuard.open("dispose");
    }

    private void dispatchBatchedInputEventPending() {
        onBatchedInputEventPending();
    }

    private void dispatchInputEvent(int i, InputEvent inputEvent) {
        this.mSeqMap.put(inputEvent.getSequenceNumber(), i);
        onInputEvent(inputEvent);
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
        this.mInputChannel = null;
        this.mMessageQueue = null;
    }

    private static native boolean nativeConsumeBatchedInputEvents(long j, long j2);

    private static native void nativeDispose(long j);

    private static native void nativeFinishInputEvent(long j, int i, boolean z);

    private static native long nativeInit(WeakReference<InputEventReceiver> weakReference, InputChannel inputChannel, MessageQueue messageQueue);

    public final boolean consumeBatchedInputEvents(long j) {
        if (this.mReceiverPtr == 0) {
            Log.w(TAG, "Attempted to consume batched input events but the input event receiver has already been disposed.");
            return false;
        }
        return nativeConsumeBatchedInputEvents(this.mReceiverPtr, j);
    }

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

    public final void finishInputEvent(InputEvent inputEvent, boolean z) {
        if (inputEvent == null) {
            throw new IllegalArgumentException("event must not be null");
        }
        if (this.mReceiverPtr == 0) {
            Log.w(TAG, "Attempted to finish an input event but the input event receiver has already been disposed.");
        } else {
            int indexOfKey = this.mSeqMap.indexOfKey(inputEvent.getSequenceNumber());
            if (indexOfKey < 0) {
                Log.w(TAG, "Attempted to finish an input event that is not in progress.");
            } else {
                int valueAt = this.mSeqMap.valueAt(indexOfKey);
                this.mSeqMap.removeAt(indexOfKey);
                nativeFinishInputEvent(this.mReceiverPtr, valueAt, z);
            }
        }
        inputEvent.recycleIfNeededAfterDispatch();
    }

    public void onBatchedInputEventPending() {
        consumeBatchedInputEvents(-1L);
    }

    public void onInputEvent(InputEvent inputEvent) {
        finishInputEvent(inputEvent, false);
    }
}
