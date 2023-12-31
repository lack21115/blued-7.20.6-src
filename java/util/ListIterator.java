package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/ListIterator.class */
public interface ListIterator<E> extends Iterator<E> {
    void add(E e);

    @Override // java.util.Iterator
    boolean hasNext();

    boolean hasPrevious();

    @Override // java.util.Iterator
    E next();

    int nextIndex();

    E previous();

    int previousIndex();

    @Override // java.util.Iterator
    void remove();

    void set(E e);
}
