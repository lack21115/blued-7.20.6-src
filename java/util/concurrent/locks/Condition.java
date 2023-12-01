package java.util.concurrent.locks;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/Condition.class */
public interface Condition {
    void await() throws InterruptedException;

    boolean await(long j, TimeUnit timeUnit) throws InterruptedException;

    long awaitNanos(long j) throws InterruptedException;

    void awaitUninterruptibly();

    boolean awaitUntil(Date date) throws InterruptedException;

    void signal();

    void signalAll();
}
