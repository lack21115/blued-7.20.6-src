package java.util.concurrent;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/CopyOnWriteArraySet.class */
public class CopyOnWriteArraySet<E> extends AbstractSet<E> implements Serializable {
    private static final long serialVersionUID = 5457747651344034263L;
    private final CopyOnWriteArrayList<E> al = new CopyOnWriteArrayList<>();

    public CopyOnWriteArraySet() {
    }

    public CopyOnWriteArraySet(Collection<? extends E> collection) {
        this.al.addAllAbsent(collection);
    }

    private static boolean eq(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        return this.al.addIfAbsent(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return this.al.addAllAbsent(collection) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.al.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.al.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.al.containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection
    public boolean equals(Object obj) {
        boolean z;
        int i;
        int i2;
        int i3;
        if (obj == this) {
            z = true;
        } else {
            z = false;
            if (obj instanceof Set) {
                Iterator<E> it = ((Set) obj).iterator();
                Object[] array = this.al.getArray();
                int length = array.length;
                boolean[] zArr = new boolean[length];
                int i4 = 0;
                loop0: while (true) {
                    int i5 = i4;
                    if (!it.hasNext()) {
                        return i5 == length;
                    }
                    i = i5 + 1;
                    z = false;
                    if (i > length) {
                        break;
                    }
                    E next = it.next();
                    while (true) {
                        i3 = i2;
                        z = false;
                        if (i3 >= length) {
                            break loop0;
                        }
                        i2 = (zArr[i3] || !eq(next, array[i3])) ? i3 + 1 : 0;
                    }
                    zArr[i3] = true;
                    i4 = i;
                }
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.al.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.al.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.al.remove(obj);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.al.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.al.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.al.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return this.al.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.al.toArray(tArr);
    }
}
