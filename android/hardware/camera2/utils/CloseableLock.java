package android.hardware.camera2.utils;

import android.util.Log;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/CloseableLock.class */
public class CloseableLock implements AutoCloseable {
    private static final boolean VERBOSE = false;
    private final String TAG;
    private volatile boolean mClosed;
    private final Condition mCondition;
    private boolean mExclusive;
    private final ReentrantLock mLock;
    private final ThreadLocal<Integer> mLockCount;
    private final String mName;
    private int mSharedLocks;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/CloseableLock$ScopedLock.class */
    public class ScopedLock implements AutoCloseable {
        private ScopedLock() {
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            CloseableLock.this.releaseLock();
        }
    }

    public CloseableLock() {
        this.TAG = "CloseableLock";
        this.mClosed = false;
        this.mExclusive = false;
        this.mSharedLocks = 0;
        this.mLock = new ReentrantLock();
        this.mCondition = this.mLock.newCondition();
        this.mLockCount = new ThreadLocal<Integer>() { // from class: android.hardware.camera2.utils.CloseableLock.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public Integer initialValue() {
                return 0;
            }
        };
        this.mName = "";
    }

    public CloseableLock(String str) {
        this.TAG = "CloseableLock";
        this.mClosed = false;
        this.mExclusive = false;
        this.mSharedLocks = 0;
        this.mLock = new ReentrantLock();
        this.mCondition = this.mLock.newCondition();
        this.mLockCount = new ThreadLocal<Integer>() { // from class: android.hardware.camera2.utils.CloseableLock.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public Integer initialValue() {
                return 0;
            }
        };
        this.mName = str;
    }

    private void log(String str) {
        Log.v("CloseableLock[" + this.mName + "]", str);
    }

    public ScopedLock acquireExclusiveLock() {
        try {
            this.mLock.lock();
            if (this.mClosed) {
                this.mLock.unlock();
                return null;
            }
            int intValue = this.mLockCount.get().intValue();
            if (this.mExclusive || intValue <= 0) {
                while (intValue == 0 && (this.mExclusive || this.mSharedLocks > 0)) {
                    this.mCondition.awaitUninterruptibly();
                    if (this.mClosed) {
                        this.mLock.unlock();
                        return null;
                    }
                }
                this.mExclusive = true;
                this.mLockCount.set(Integer.valueOf(this.mLockCount.get().intValue() + 1));
                this.mLock.unlock();
                return new ScopedLock();
            }
            throw new IllegalStateException("Cannot acquire exclusive lock while holding shared lock");
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public ScopedLock acquireLock() {
        try {
            this.mLock.lock();
            if (this.mClosed) {
                this.mLock.unlock();
                return null;
            }
            int intValue = this.mLockCount.get().intValue();
            if (!this.mExclusive || intValue <= 0) {
                while (this.mExclusive) {
                    this.mCondition.awaitUninterruptibly();
                    if (this.mClosed) {
                        this.mLock.unlock();
                        return null;
                    }
                }
                this.mSharedLocks++;
                this.mLockCount.set(Integer.valueOf(this.mLockCount.get().intValue() + 1));
                this.mLock.unlock();
                return new ScopedLock();
            }
            throw new IllegalStateException("Cannot acquire shared lock while holding exclusive lock");
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.mClosed || acquireExclusiveLock() == null) {
            return;
        }
        if (this.mLockCount.get().intValue() != 1) {
            throw new IllegalStateException("Cannot close while one or more acquired locks are being held by this thread; release all other locks first");
        }
        try {
            this.mLock.lock();
            this.mClosed = true;
            this.mExclusive = false;
            this.mSharedLocks = 0;
            this.mLockCount.remove();
            this.mCondition.signalAll();
        } finally {
            this.mLock.unlock();
        }
    }

    public void releaseLock() {
        if (this.mLockCount.get().intValue() <= 0) {
            throw new IllegalStateException("Cannot release lock that was not acquired by this thread");
        }
        try {
            this.mLock.lock();
            if (this.mClosed) {
                throw new IllegalStateException("Do not release after the lock has been closed");
            }
            if (!this.mExclusive) {
                this.mSharedLocks--;
            } else if (this.mSharedLocks != 0) {
                throw new AssertionError("Too many shared locks " + this.mSharedLocks);
            }
            int intValue = this.mLockCount.get().intValue() - 1;
            this.mLockCount.set(Integer.valueOf(intValue));
            if (intValue == 0 && this.mExclusive) {
                this.mExclusive = false;
                this.mCondition.signalAll();
            } else if (intValue == 0 && this.mSharedLocks == 0) {
                this.mCondition.signalAll();
            }
        } finally {
            this.mLock.unlock();
        }
    }
}
