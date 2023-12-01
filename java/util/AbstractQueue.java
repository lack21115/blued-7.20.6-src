package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/AbstractQueue.class */
public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {
    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        if (offer(e)) {
            return true;
        }
        throw new IllegalStateException("Queue full");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("c == null");
        }
        if (collection == this) {
            throw new IllegalArgumentException("c == this");
        }
        boolean z = false;
        for (E e : collection) {
            if (add(e)) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        do {
        } while (poll() != null);
    }

    public E element() {
        E peek = peek();
        if (peek != null) {
            return peek;
        }
        throw new NoSuchElementException();
    }

    public E remove() {
        E poll = poll();
        if (poll != null) {
            return poll;
        }
        throw new NoSuchElementException();
    }
}
