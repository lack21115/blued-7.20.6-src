package java.util.concurrent.locks;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/locks/ReadWriteLock.class */
public interface ReadWriteLock {
    Lock readLock();

    Lock writeLock();
}
