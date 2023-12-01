package java.util.concurrent;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListSet.class */
public class ConcurrentSkipListSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {
    private static final Unsafe UNSAFE;
    private static final long mapOffset;
    private static final long serialVersionUID = -2479143111061671589L;
    private final ConcurrentNavigableMap<E, Object> m;

    static {
        try {
            UNSAFE = Unsafe.getUnsafe();
            mapOffset = UNSAFE.objectFieldOffset(ConcurrentSkipListSet.class.getDeclaredField("m"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ConcurrentSkipListSet() {
        this.m = new ConcurrentSkipListMap();
    }

    public ConcurrentSkipListSet(Collection<? extends E> collection) {
        this.m = new ConcurrentSkipListMap();
        addAll(collection);
    }

    public ConcurrentSkipListSet(Comparator<? super E> comparator) {
        this.m = new ConcurrentSkipListMap(comparator);
    }

    public ConcurrentSkipListSet(SortedSet<E> sortedSet) {
        this.m = new ConcurrentSkipListMap(sortedSet.comparator());
        addAll(sortedSet);
    }

    ConcurrentSkipListSet(ConcurrentNavigableMap<E, Object> concurrentNavigableMap) {
        this.m = concurrentNavigableMap;
    }

    private void setMap(ConcurrentNavigableMap<E, Object> concurrentNavigableMap) {
        UNSAFE.putObjectVolatile(this, mapOffset, concurrentNavigableMap);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        return this.m.putIfAbsent(e, Boolean.TRUE) == null;
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return this.m.ceilingKey(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.m.clear();
    }

    public ConcurrentSkipListSet<E> clone() {
        try {
            ConcurrentSkipListSet<E> concurrentSkipListSet = (ConcurrentSkipListSet) super.clone();
            concurrentSkipListSet.setMap(new ConcurrentSkipListMap((SortedMap) this.m));
            return concurrentSkipListSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.m.comparator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.m.containsKey(obj);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return this.m.descendingKeySet().iterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return new ConcurrentSkipListSet(this.m.descendingMap());
    }

    @Override // java.util.AbstractSet, java.util.Collection
    public boolean equals(Object obj) {
        boolean z;
        boolean z2 = false;
        if (obj == this) {
            z2 = true;
        } else if (obj instanceof Set) {
            Collection<?> collection = (Collection) obj;
            try {
                if (containsAll(collection)) {
                    if (collection.containsAll(this)) {
                        z = true;
                        return z;
                    }
                }
                z = false;
                return z;
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
        return z2;
    }

    @Override // java.util.SortedSet
    public E first() {
        return this.m.firstKey();
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return this.m.floorKey(e);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public NavigableSet<E> headSet(E e) {
        return headSet(e, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return new ConcurrentSkipListSet(this.m.headMap((ConcurrentNavigableMap<E, Object>) e, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ConcurrentSkipListSet<E>) obj);
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return this.m.higherKey(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.m.navigableKeySet().iterator();
    }

    @Override // java.util.SortedSet
    public E last() {
        return this.m.lastKey();
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return this.m.lowerKey(e);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        Map.Entry<E, Object> pollFirstEntry = this.m.pollFirstEntry();
        if (pollFirstEntry == null) {
            return null;
        }
        return pollFirstEntry.getKey();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        Map.Entry<E, Object> pollLastEntry = this.m.pollLastEntry();
        if (pollLastEntry == null) {
            return null;
        }
        return pollLastEntry.getKey();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.m.remove(obj, Boolean.TRUE);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.m.size();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public NavigableSet<E> subSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return new ConcurrentSkipListSet(this.m.subMap((boolean) e, z, (boolean) e2, z2));
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public NavigableSet<E> tailSet(E e) {
        return tailSet(e, true);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return new ConcurrentSkipListSet(this.m.tailMap((ConcurrentNavigableMap<E, Object>) e, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ConcurrentSkipListSet<E>) obj);
    }
}
