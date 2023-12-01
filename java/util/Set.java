package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/Set.class */
public interface Set<E> extends Collection<E> {
    @Override // 
    boolean add(E e);

    @Override // 
    boolean addAll(Collection<? extends E> collection);

    @Override // 
    void clear();

    @Override // 
    boolean contains(Object obj);

    @Override // 
    boolean containsAll(Collection<?> collection);

    @Override // 
    boolean equals(Object obj);

    @Override // 
    int hashCode();

    @Override // 
    boolean isEmpty();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // 
    boolean remove(Object obj);

    @Override // 
    boolean removeAll(Collection<?> collection);

    @Override // 
    boolean retainAll(Collection<?> collection);

    @Override // java.util.Collection, java.util.List
    int size();

    @Override // 
    Object[] toArray();

    @Override // 
    <T> T[] toArray(T[] tArr);
}
