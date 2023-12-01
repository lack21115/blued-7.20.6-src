package android.os;

import android.os.IMessenger;
import android.util.Log;
import android.util.Printer;

/* loaded from: source-9557208-dex2jar.jar:android/os/Handler.class */
public class Handler {
    private static final boolean FIND_POTENTIAL_LEAKS = false;
    private static final String TAG = "Handler";
    final boolean mAsynchronous;
    final Callback mCallback;
    final Looper mLooper;
    IMessenger mMessenger;
    final MessageQueue mQueue;

    /* loaded from: source-9557208-dex2jar.jar:android/os/Handler$BlockingRunnable.class */
    private static final class BlockingRunnable implements Runnable {
        private boolean mDone;
        private final Runnable mTask;

        public BlockingRunnable(Runnable runnable) {
            this.mTask = runnable;
        }

        public boolean postAndWait(Handler handler, long j) {
            if (handler.post(this)) {
                synchronized (this) {
                    if (j > 0) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        while (!this.mDone) {
                            long uptimeMillis2 = (uptimeMillis + j) - SystemClock.uptimeMillis();
                            if (uptimeMillis2 <= 0) {
                                return false;
                            }
                            try {
                                wait(uptimeMillis2);
                            } catch (InterruptedException e) {
                            }
                        }
                    } else {
                        while (!this.mDone) {
                            try {
                                wait();
                            } catch (InterruptedException e2) {
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mTask.run();
                synchronized (this) {
                    this.mDone = true;
                    notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.mDone = true;
                    notifyAll();
                    throw th;
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/Handler$Callback.class */
    public interface Callback {
        boolean handleMessage(Message message);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/Handler$MessengerImpl.class */
    private final class MessengerImpl extends IMessenger.Stub {
        private MessengerImpl() {
        }

        @Override // android.os.IMessenger
        public void send(Message message) {
            message.sendingUid = Binder.getCallingUid();
            Handler.this.sendMessage(message);
        }
    }

    public Handler() {
        this((Callback) null, false);
    }

    public Handler(Callback callback) {
        this(callback, false);
    }

    public Handler(Callback callback, boolean z) {
        this.mLooper = Looper.myLooper();
        if (this.mLooper == null) {
            throw new RuntimeException("Can't create handler inside thread that has not called Looper.prepare()");
        }
        this.mQueue = this.mLooper.mQueue;
        this.mCallback = callback;
        this.mAsynchronous = z;
    }

    public Handler(Looper looper) {
        this(looper, null, false);
    }

    public Handler(Looper looper, Callback callback) {
        this(looper, callback, false);
    }

    public Handler(Looper looper, Callback callback, boolean z) {
        this.mLooper = looper;
        this.mQueue = looper.mQueue;
        this.mCallback = callback;
        this.mAsynchronous = z;
    }

    public Handler(boolean z) {
        this((Callback) null, z);
    }

    private boolean enqueueMessage(MessageQueue messageQueue, Message message, long j) {
        message.target = this;
        if (this.mAsynchronous) {
            message.setAsynchronous(true);
        }
        return messageQueue.enqueueMessage(message, j);
    }

    private static Message getPostMessage(Runnable runnable) {
        Message obtain = Message.obtain();
        obtain.callback = runnable;
        return obtain;
    }

    private static Message getPostMessage(Runnable runnable, Object obj) {
        Message obtain = Message.obtain();
        obtain.obj = obj;
        obtain.callback = runnable;
        return obtain;
    }

    private static void handleCallback(Message message) {
        message.callback.run();
    }

    public void dispatchMessage(Message message) {
        if (message.callback != null) {
            handleCallback(message);
        } else if (this.mCallback == null || !this.mCallback.handleMessage(message)) {
            handleMessage(message);
        }
    }

    public final void dump(Printer printer, String str) {
        printer.println(str + this + " @ " + SystemClock.uptimeMillis());
        if (this.mLooper == null) {
            printer.println(str + "looper uninitialized");
        } else {
            this.mLooper.dump(printer, str + "  ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final IMessenger getIMessenger() {
        synchronized (this.mQueue) {
            if (this.mMessenger != null) {
                return this.mMessenger;
            }
            this.mMessenger = new MessengerImpl();
            return this.mMessenger;
        }
    }

    public final Looper getLooper() {
        return this.mLooper;
    }

    public String getMessageName(Message message) {
        return message.callback != null ? message.callback.getClass().getName() : "0x" + Integer.toHexString(message.what);
    }

    public void handleMessage(Message message) {
    }

    public final boolean hasCallbacks(Runnable runnable) {
        return this.mQueue.hasMessages(this, runnable, (Object) null);
    }

    public final boolean hasMessages(int i) {
        return this.mQueue.hasMessages(this, i, (Object) null);
    }

    public final boolean hasMessages(int i, Object obj) {
        return this.mQueue.hasMessages(this, i, obj);
    }

    public final Message obtainMessage() {
        return Message.obtain(this);
    }

    public final Message obtainMessage(int i) {
        return Message.obtain(this, i);
    }

    public final Message obtainMessage(int i, int i2, int i3) {
        return Message.obtain(this, i, i2, i3);
    }

    public final Message obtainMessage(int i, int i2, int i3, Object obj) {
        return Message.obtain(this, i, i2, i3, obj);
    }

    public final Message obtainMessage(int i, Object obj) {
        return Message.obtain(this, i, obj);
    }

    public final boolean post(Runnable runnable) {
        return sendMessageDelayed(getPostMessage(runnable), 0L);
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        return sendMessageAtFrontOfQueue(getPostMessage(runnable));
    }

    public final boolean postAtTime(Runnable runnable, long j) {
        return sendMessageAtTime(getPostMessage(runnable), j);
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j) {
        return sendMessageAtTime(getPostMessage(runnable, obj), j);
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return sendMessageDelayed(getPostMessage(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        this.mQueue.removeMessages(this, runnable, (Object) null);
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        this.mQueue.removeMessages(this, runnable, obj);
    }

    public final void removeCallbacksAndMessages(Object obj) {
        this.mQueue.removeCallbacksAndMessages(this, obj);
    }

    public final void removeMessages(int i) {
        this.mQueue.removeMessages(this, i, (Object) null);
    }

    public final void removeMessages(int i, Object obj) {
        this.mQueue.removeMessages(this, i, obj);
    }

    public final boolean runWithScissors(Runnable runnable, long j) {
        if (runnable == null) {
            throw new IllegalArgumentException("runnable must not be null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("timeout must be non-negative");
        }
        if (Looper.myLooper() == this.mLooper) {
            runnable.run();
            return true;
        }
        return new BlockingRunnable(runnable).postAndWait(this, j);
    }

    public final boolean sendEmptyMessage(int i) {
        return sendEmptyMessageDelayed(i, 0L);
    }

    public final boolean sendEmptyMessageAtTime(int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = i;
        return sendMessageAtTime(obtain, j);
    }

    public final boolean sendEmptyMessageDelayed(int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = i;
        return sendMessageDelayed(obtain, j);
    }

    public final boolean sendMessage(Message message) {
        return sendMessageDelayed(message, 0L);
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        MessageQueue messageQueue = this.mQueue;
        if (messageQueue == null) {
            RuntimeException runtimeException = new RuntimeException(this + " sendMessageAtTime() called with no mQueue");
            Log.w("Looper", runtimeException.getMessage(), runtimeException);
            return false;
        }
        return enqueueMessage(messageQueue, message, 0L);
    }

    public boolean sendMessageAtTime(Message message, long j) {
        MessageQueue messageQueue = this.mQueue;
        if (messageQueue == null) {
            RuntimeException runtimeException = new RuntimeException(this + " sendMessageAtTime() called with no mQueue");
            Log.w("Looper", runtimeException.getMessage(), runtimeException);
            return false;
        }
        return enqueueMessage(messageQueue, message, j);
    }

    public final boolean sendMessageDelayed(Message message, long j) {
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        return sendMessageAtTime(message, SystemClock.uptimeMillis() + j2);
    }

    public String toString() {
        return "Handler (" + getClass().getName() + ") {" + Integer.toHexString(System.identityHashCode(this)) + "}";
    }
}
