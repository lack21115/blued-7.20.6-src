package android.util;

import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* loaded from: source-9557208-dex2jar.jar:android/util/TimedRemoteCaller.class */
public abstract class TimedRemoteCaller<T> {
    public static final long DEFAULT_CALL_TIMEOUT_MILLIS = 5000;
    private static final int UNDEFINED_SEQUENCE = -1;
    private final long mCallTimeoutMillis;
    private T mResult;
    private int mSequenceCounter;
    private final Object mLock = new Object();
    private int mReceivedSequence = -1;
    private int mAwaitedSequence = -1;

    public TimedRemoteCaller(long j) {
        this.mCallTimeoutMillis = j;
    }

    private boolean waitForResultTimedLocked(int i) {
        long uptimeMillis;
        long uptimeMillis2 = SystemClock.uptimeMillis();
        while (this.mReceivedSequence != i) {
            try {
                uptimeMillis = this.mCallTimeoutMillis - (SystemClock.uptimeMillis() - uptimeMillis2);
            } catch (InterruptedException e) {
            }
            if (uptimeMillis <= 0) {
                return false;
            }
            this.mLock.wait(uptimeMillis);
        }
        return true;
    }

    public final T getResultTimed(int i) throws TimeoutException {
        T t;
        synchronized (this.mLock) {
            if (!waitForResultTimedLocked(i)) {
                throw new TimeoutException("No reponse for sequence: " + i);
            }
            t = this.mResult;
            this.mResult = null;
        }
        return t;
    }

    public final int onBeforeRemoteCall() {
        int i;
        synchronized (this.mLock) {
            int i2 = this.mSequenceCounter;
            this.mSequenceCounter = i2 + 1;
            this.mAwaitedSequence = i2;
            i = this.mAwaitedSequence;
        }
        return i;
    }

    public final void onRemoteMethodResult(T t, int i) {
        synchronized (this.mLock) {
            if (i == this.mAwaitedSequence) {
                this.mReceivedSequence = i;
                this.mResult = t;
                this.mLock.notifyAll();
            }
        }
    }
}
