package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/List.class */
public interface List<E> extends Collection<E> {
    void add(int i, E e);

    @Override // java.util.Collection, java.util.Set
    boolean add(E e);

    boolean addAll(int i, Collection<? extends E> collection);

    @Override // java.util.Collection, java.util.Set
    boolean addAll(Collection<? extends E> collection);

    @Override // java.util.Collection, java.util.Set
    void clear();

    @Override // java.util.Collection, java.util.Set
    boolean contains(Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean containsAll(Collection<?> collection);

    @Override // java.util.Collection, java.util.Set
    boolean equals(Object obj);

    E get(int i);

    @Override // java.util.Collection, java.util.Set
    int hashCode();

    int indexOf(Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean isEmpty();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    int lastIndexOf(Object obj);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int i);

    E remove(int i);

    @Override // java.util.Collection, java.util.Set
    boolean remove(Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection, java.util.Set
    boolean retainAll(Collection<?> collection);

    E set(int i, E e);

    @Override // 
    int size();

    List<E> subList(int i, int i2);

    @Override // java.util.Collection, java.util.Set
    Object[] toArray();

    @Override // java.util.Collection, java.util.Set
    <T> T[] toArray(T[] tArr);
}
