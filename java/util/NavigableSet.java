package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/NavigableSet.class */
public interface NavigableSet<E> extends SortedSet<E> {
    E ceiling(E e);

    Iterator<E> descendingIterator();

    NavigableSet<E> descendingSet();

    E floor(E e);

    NavigableSet<E> headSet(E e, boolean z);

    @Override // 
    SortedSet<E> headSet(E e);

    E higher(E e);

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    E lower(E e);

    E pollFirst();

    E pollLast();

    NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2);

    @Override // 
    SortedSet<E> subSet(E e, E e2);

    NavigableSet<E> tailSet(E e, boolean z);

    @Override // 
    SortedSet<E> tailSet(E e);
}
