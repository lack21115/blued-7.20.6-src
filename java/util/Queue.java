package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/Queue.class */
public interface Queue<E> extends Collection<E> {
    @Override // java.util.Collection, java.util.Set
    boolean add(E e);

    E element();

    boolean offer(E e);

    E peek();

    E poll();

    E remove();
}
