package java.util.concurrent;

import java.util.Deque;
import java.util.Iterator;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/BlockingDeque.class */
public interface BlockingDeque<E> extends BlockingQueue<E>, Deque<E> {
    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection, java.util.Set
    boolean add(E e);

    @Override // java.util.Deque
    void addFirst(E e);

    @Override // java.util.Deque
    void addLast(E e);

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, java.util.Set
    boolean contains(Object obj);

    @Override // java.util.Queue
    E element();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Deque
    boolean offerFirst(E e);

    boolean offerFirst(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Deque
    boolean offerLast(E e);

    boolean offerLast(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Queue
    E peek();

    @Override // java.util.Queue
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j, TimeUnit timeUnit) throws InterruptedException;

    E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException;

    E pollLast(long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Deque
    void push(E e);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e) throws InterruptedException;

    void putFirst(E e) throws InterruptedException;

    void putLast(E e) throws InterruptedException;

    @Override // java.util.Queue
    E remove();

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, java.util.Set
    boolean remove(Object obj);

    @Override // java.util.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // java.util.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection, java.util.List
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws InterruptedException;

    E takeFirst() throws InterruptedException;

    E takeLast() throws InterruptedException;
}
