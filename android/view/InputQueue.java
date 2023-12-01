package android.view;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.LongSparseArray;
import android.util.Pools;
import dalvik.system.CloseGuard;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/view/InputQueue.class */
public final class InputQueue {
    private final LongSparseArray<ActiveInputEvent> mActiveEventArray = new LongSparseArray<>(20);
    private final Pools.Pool<ActiveInputEvent> mActiveInputEventPool = new Pools.SimplePool(20);
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private long mPtr = nativeInit(new WeakReference(this), Looper.myQueue());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/InputQueue$ActiveInputEvent.class */
    public final class ActiveInputEvent {
        public FinishedInputEventCallback mCallback;
        public Object mToken;

        private ActiveInputEvent() {
        }

        public void recycle() {
            this.mToken = null;
            this.mCallback = null;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/InputQueue$Callback.class */
    public interface Callback {
        void onInputQueueCreated(InputQueue inputQueue);

        void onInputQueueDestroyed(InputQueue inputQueue);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/InputQueue$FinishedInputEventCallback.class */
    public interface FinishedInputEventCallback {
        void onFinishedInputEvent(Object obj, boolean z);
    }

    public InputQueue() {
        this.mCloseGuard.open("dispose");
    }

    private void finishInputEvent(long j, boolean z) {
        int indexOfKey = this.mActiveEventArray.indexOfKey(j);
        if (indexOfKey >= 0) {
            ActiveInputEvent valueAt = this.mActiveEventArray.valueAt(indexOfKey);
            this.mActiveEventArray.removeAt(indexOfKey);
            valueAt.mCallback.onFinishedInputEvent(valueAt.mToken, z);
            recycleActiveInputEvent(valueAt);
        }
    }

    private static native void nativeDispose(long j);

    private static native long nativeInit(WeakReference<InputQueue> weakReference, MessageQueue messageQueue);

    private static native long nativeSendKeyEvent(long j, KeyEvent keyEvent, boolean z);

    private static native long nativeSendMotionEvent(long j, MotionEvent motionEvent);

    private ActiveInputEvent obtainActiveInputEvent(Object obj, FinishedInputEventCallback finishedInputEventCallback) {
        ActiveInputEvent acquire = this.mActiveInputEventPool.acquire();
        ActiveInputEvent activeInputEvent = acquire;
        if (acquire == null) {
            activeInputEvent = new ActiveInputEvent();
        }
        activeInputEvent.mToken = obj;
        activeInputEvent.mCallback = finishedInputEventCallback;
        return activeInputEvent;
    }

    private void recycleActiveInputEvent(ActiveInputEvent activeInputEvent) {
        activeInputEvent.recycle();
        this.mActiveInputEventPool.release(activeInputEvent);
    }

    public void dispose() {
        dispose(false);
    }

    public void dispose(boolean z) {
        if (this.mCloseGuard != null) {
            if (z) {
                this.mCloseGuard.warnIfOpen();
            }
            this.mCloseGuard.close();
        }
        if (this.mPtr != 0) {
            nativeDispose(this.mPtr);
            this.mPtr = 0L;
        }
    }

    protected void finalize() throws Throwable {
        try {
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    public long getNativePtr() {
        return this.mPtr;
    }

    public void sendInputEvent(InputEvent inputEvent, Object obj, boolean z, FinishedInputEventCallback finishedInputEventCallback) {
        this.mActiveEventArray.put(inputEvent instanceof KeyEvent ? nativeSendKeyEvent(this.mPtr, (KeyEvent) inputEvent, z) : nativeSendMotionEvent(this.mPtr, (MotionEvent) inputEvent), obtainActiveInputEvent(obj, finishedInputEventCallback));
    }
}
