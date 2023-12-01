package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/AbstractSequentialList.class */
public abstract class AbstractSequentialList<E> extends AbstractList<E> {
    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        listIterator(i).add(e);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        ListIterator<E> listIterator = listIterator(i);
        int nextIndex = listIterator.nextIndex();
        for (E e : collection) {
            listIterator.add(e);
        }
        return nextIndex != listIterator.nextIndex();
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        try {
            return listIterator(i).next();
        } catch (NoSuchElementException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract ListIterator<E> listIterator(int i);

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        try {
            ListIterator<E> listIterator = listIterator(i);
            E next = listIterator.next();
            listIterator.remove();
            return next;
        } catch (NoSuchElementException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        ListIterator<E> listIterator = listIterator(i);
        if (listIterator.hasNext()) {
            E next = listIterator.next();
            listIterator.set(e);
            return next;
        }
        throw new IndexOutOfBoundsException();
    }
}
