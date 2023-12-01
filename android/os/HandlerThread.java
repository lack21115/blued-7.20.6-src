package android.os;

/* loaded from: source-9557208-dex2jar.jar:android/os/HandlerThread.class */
public class HandlerThread extends Thread {
    Looper mLooper;
    int mPriority;
    int mTid;

    public HandlerThread(String str) {
        super(str);
        this.mTid = -1;
        this.mPriority = 0;
    }

    public HandlerThread(String str, int i) {
        super(str);
        this.mTid = -1;
        this.mPriority = i;
    }

    public Looper getLooper() {
        if (isAlive()) {
            synchronized (this) {
                while (isAlive() && this.mLooper == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            return this.mLooper;
        }
        return null;
    }

    public int getThreadId() {
        return this.mTid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLooperPrepared() {
    }

    public boolean quit() {
        Looper looper = getLooper();
        if (looper != null) {
            looper.quit();
            return true;
        }
        return false;
    }

    public boolean quitSafely() {
        Looper looper = getLooper();
        if (looper != null) {
            looper.quitSafely();
            return true;
        }
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.mTid = Process.myTid();
        Looper.prepare();
        synchronized (this) {
            this.mLooper = Looper.myLooper();
            notifyAll();
        }
        Process.setThreadPriority(this.mPriority);
        onLooperPrepared();
        Looper.loop();
        this.mTid = -1;
    }
}
