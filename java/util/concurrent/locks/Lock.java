package java.util.concurrent.locks;

import java.util.concurrent.TimeUnit;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/Lock.class */
public interface Lock {
    void lock();

    void lockInterruptibly() throws InterruptedException;

    Condition newCondition();

    boolean tryLock();

    boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException;

    void unlock();
}
