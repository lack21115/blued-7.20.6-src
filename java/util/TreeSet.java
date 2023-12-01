package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/util/TreeSet.class */
public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {
    private static final long serialVersionUID = -2479143000061671589L;
    private transient NavigableMap<E, Object> backingMap;
    private transient NavigableSet<E> descendingSet;

    public TreeSet() {
        this.backingMap = new TreeMap();
    }

    public TreeSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    public TreeSet(Comparator<? super E> comparator) {
        this.backingMap = new TreeMap(comparator);
    }

    TreeSet(NavigableMap<E, Object> navigableMap) {
        this.backingMap = navigableMap;
    }

    public TreeSet(SortedSet<E> sortedSet) {
        this(sortedSet.comparator());
        for (E e : sortedSet) {
            add(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        TreeMap treeMap = new TreeMap((Comparator) objectInputStream.readObject());
        int readInt = objectInputStream.readInt();
        if (readInt > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                treeMap.put(objectInputStream.readObject(), Boolean.TRUE);
                i = i2 + 1;
            }
        }
        this.backingMap = treeMap;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.backingMap.comparator());
        int size = this.backingMap.size();
        objectOutputStream.writeInt(size);
        if (size > 0) {
            for (E e : this.backingMap.keySet()) {
                objectOutputStream.writeObject(e);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        return this.backingMap.put(e, Boolean.TRUE) == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return super.addAll(collection);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return this.backingMap.ceilingKey(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.backingMap.clear();
    }

    public Object clone() {
        try {
            TreeSet treeSet = (TreeSet) super.clone();
            if (this.backingMap instanceof TreeMap) {
                treeSet.backingMap = (NavigableMap) ((TreeMap) this.backingMap).clone();
                return treeSet;
            }
            treeSet.backingMap = new TreeMap((SortedMap) this.backingMap);
            return treeSet;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.backingMap.comparator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.backingMap.containsKey(obj);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        if (this.descendingSet != null) {
            return this.descendingSet;
        }
        TreeSet treeSet = new TreeSet(this.backingMap.descendingMap());
        this.descendingSet = treeSet;
        return treeSet;
    }

    @Override // java.util.SortedSet
    public E first() {
        return this.backingMap.firstKey();
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return this.backingMap.floorKey(e);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        Comparator<? super E> comparator = this.backingMap.comparator();
        if (comparator == null) {
            ((Comparable) e).compareTo(e);
        } else {
            comparator.compare(e, e);
        }
        return new TreeSet(this.backingMap.headMap(e, z));
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return headSet(e, false);
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return this.backingMap.higherKey(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.backingMap.keySet().iterator();
    }

    @Override // java.util.SortedSet
    public E last() {
        return this.backingMap.lastKey();
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return this.backingMap.lowerKey(e);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        Map.Entry<E, Object> pollFirstEntry = this.backingMap.pollFirstEntry();
        if (pollFirstEntry == null) {
            return null;
        }
        return pollFirstEntry.getKey();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        Map.Entry<E, Object> pollLastEntry = this.backingMap.pollLastEntry();
        if (pollLastEntry == null) {
            return null;
        }
        return pollLastEntry.getKey();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.backingMap.remove(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.backingMap.size();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        Comparator<? super E> comparator = this.backingMap.comparator();
        if ((comparator == null ? ((Comparable) e).compareTo(e2) : comparator.compare(e, e2)) <= 0) {
            return new TreeSet(this.backingMap.subMap(e, z, e2, z2));
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        Comparator<? super E> comparator = this.backingMap.comparator();
        if (comparator == null) {
            ((Comparable) e).compareTo(e);
        } else {
            comparator.compare(e, e);
        }
        return new TreeSet(this.backingMap.tailMap(e, z));
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return tailSet(e, true);
    }
}
