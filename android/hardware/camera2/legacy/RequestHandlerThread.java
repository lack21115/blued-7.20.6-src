package android.hardware.camera2.legacy;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/RequestHandlerThread.class */
public class RequestHandlerThread extends HandlerThread {
    public static final int MSG_POKE_IDLE_HANDLER = -1;
    private Handler.Callback mCallback;
    private volatile Handler mHandler;
    private final ConditionVariable mIdle;
    private final MessageQueue.IdleHandler mIdleHandler;
    private final ConditionVariable mStarted;

    public RequestHandlerThread(String str, Handler.Callback callback) {
        super(str, 10);
        this.mStarted = new ConditionVariable(false);
        this.mIdle = new ConditionVariable(true);
        this.mIdleHandler = new MessageQueue.IdleHandler() { // from class: android.hardware.camera2.legacy.RequestHandlerThread.1
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                RequestHandlerThread.this.mIdle.open();
                return false;
            }
        };
        this.mCallback = callback;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public boolean hasAnyMessages(int[] iArr) {
        synchronized (this.mHandler.getLooper().getQueue()) {
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (this.mHandler.hasMessages(iArr[i2])) {
                    return true;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        this.mHandler = new Handler(getLooper(), this.mCallback);
        this.mStarted.open();
    }

    public void removeMessages(int[] iArr) {
        synchronized (this.mHandler.getLooper().getQueue()) {
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    this.mHandler.removeMessages(iArr[i2]);
                    i = i2 + 1;
                }
            }
        }
    }

    public Handler waitAndGetHandler() {
        waitUntilStarted();
        return getHandler();
    }

    public void waitUntilIdle() {
        Handler waitAndGetHandler = waitAndGetHandler();
        Looper looper = waitAndGetHandler.getLooper();
        if (looper.isIdling()) {
            return;
        }
        this.mIdle.close();
        looper.getQueue().addIdleHandler(this.mIdleHandler);
        waitAndGetHandler.sendEmptyMessage(-1);
        if (looper.isIdling()) {
            return;
        }
        this.mIdle.block();
    }

    public void waitUntilStarted() {
        this.mStarted.block();
    }
}
