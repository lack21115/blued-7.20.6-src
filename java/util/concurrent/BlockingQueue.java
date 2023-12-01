package java.util.concurrent;

import java.util.Collection;
import java.util.Queue;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/BlockingQueue.class */
public interface BlockingQueue<E> extends Queue<E> {
    @Override // java.util.Queue, java.util.Collection, java.util.Set
    boolean add(E e);

    @Override // java.util.Collection, java.util.Set
    boolean contains(Object obj);

    int drainTo(Collection<? super E> collection);

    int drainTo(Collection<? super E> collection, int i);

    @Override // 
    boolean offer(E e);

    boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    E poll(long j, TimeUnit timeUnit) throws InterruptedException;

    void put(E e) throws InterruptedException;

    int remainingCapacity();

    @Override // java.util.Collection, java.util.Set
    boolean remove(Object obj);

    E take() throws InterruptedException;
}
