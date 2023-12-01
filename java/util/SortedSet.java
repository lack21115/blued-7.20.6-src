package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/SortedSet.class */
public interface SortedSet<E> extends Set<E> {
    Comparator<? super E> comparator();

    E first();

    SortedSet<E> headSet(E e);

    E last();

    SortedSet<E> subSet(E e, E e2);

    SortedSet<E> tailSet(E e);
}
