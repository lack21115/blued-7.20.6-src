package com.sobot.chat.core.channel;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/channel/LimitQueue.class */
public class LimitQueue<E> implements Queue<E> {
    private int limit;
    LinkedList<E> queue = new LinkedList<>();

    public LimitQueue(int i) {
        this.limit = i;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(E e) {
        return this.queue.add(e);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return this.queue.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.queue.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.queue.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.queue.containsAll(collection);
    }

    @Override // java.util.Queue
    public E element() {
        return this.queue.element();
    }

    public int getLimit() {
        return this.limit;
    }

    public Queue<E> getQueue() {
        return this.queue;
    }

    public int indexOf(E e) {
        return this.queue.indexOf(e);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.queue.size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.queue.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (this.queue.size() >= this.limit) {
            this.queue.poll();
        }
        return this.queue.offer(e);
    }

    @Override // java.util.Queue
    public E peek() {
        return this.queue.peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return this.queue.poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return this.queue.remove();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        return this.queue.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.queue.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.queue.retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return this.queue.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.queue.toArray();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.queue.toArray(tArr);
    }
}
