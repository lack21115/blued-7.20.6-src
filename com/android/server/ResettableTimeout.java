package com.android.server;

import android.os.ConditionVariable;
import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:com/android/server/ResettableTimeout.class */
public abstract class ResettableTimeout {
    private ConditionVariable mLock = new ConditionVariable();
    private volatile long mOffAt;
    private volatile boolean mOffCalled;
    private Thread mThread;

    /* loaded from: source-4181928-dex2jar.jar:com/android/server/ResettableTimeout$T.class */
    private class T extends Thread {
        private T() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long uptimeMillis;
            ResettableTimeout.this.mLock.open();
            while (true) {
                synchronized (this) {
                    uptimeMillis = ResettableTimeout.this.mOffAt - SystemClock.uptimeMillis();
                    if (uptimeMillis <= 0) {
                        ResettableTimeout.this.mOffCalled = true;
                        ResettableTimeout.this.off();
                        ResettableTimeout.this.mThread = null;
                        return;
                    }
                }
                try {
                    sleep(uptimeMillis);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    ResettableTimeout() {
    }

    public void cancel() {
        synchronized (this) {
            this.mOffAt = 0L;
            if (this.mThread != null) {
                this.mThread.interrupt();
                this.mThread = null;
            }
            if (!this.mOffCalled) {
                this.mOffCalled = true;
                off();
            }
        }
    }

    public void go(long j) {
        boolean z;
        synchronized (this) {
            this.mOffAt = SystemClock.uptimeMillis() + j;
            if (this.mThread == null) {
                z = false;
                this.mLock.close();
                this.mThread = new T();
                this.mThread.start();
                this.mLock.block();
                this.mOffCalled = false;
            } else {
                z = true;
                this.mThread.interrupt();
            }
            on(z);
        }
    }

    public abstract void off();

    public abstract void on(boolean z);
}
