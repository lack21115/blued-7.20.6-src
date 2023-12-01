package java.util.concurrent;

import com.anythink.core.common.c.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap.class */
public class ConcurrentSkipListMap<K, V> extends AbstractMap<K, V> implements ConcurrentNavigableMap<K, V>, Cloneable, Serializable {
    private static final int EQ = 1;
    private static final int GT = 0;
    private static final int LT = 2;
    private static final Unsafe UNSAFE;
    private static final long headOffset;
    private static final long serialVersionUID = -8627078645895051609L;
    private final Comparator<? super K> comparator;
    private transient ConcurrentNavigableMap<K, V> descendingMap;
    private transient EntrySet<K, V> entrySet;
    private volatile transient HeadIndex<K, V> head;
    private transient KeySet<K> keySet;
    private transient int randomSeed;
    private transient Values<V> values;
    private static final Random seedGenerator = new Random();
    private static final Object BASE_HEADER = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$ComparableUsingComparator.class */
    public static final class ComparableUsingComparator<K> implements Comparable<K> {
        final K actualKey;
        final Comparator<? super K> cmp;

        ComparableUsingComparator(K k, Comparator<? super K> comparator) {
            this.actualKey = k;
            this.cmp = comparator;
        }

        @Override // java.lang.Comparable
        public int compareTo(K k) {
            return this.cmp.compare((K) this.actualKey, k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$EntryIterator.class */
    public final class EntryIterator extends ConcurrentSkipListMap<K, V>.Iter<Map.Entry<K, V>> {
        EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Node<K, V> node = this.next;
            V v = this.nextValue;
            advance();
            return new AbstractMap.SimpleImmutableEntry(node.key, v);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$EntrySet.class */
    public static final class EntrySet<K1, V1> extends AbstractSet<Map.Entry<K1, V1>> {
        private final ConcurrentNavigableMap<K1, V1> m;

        EntrySet(ConcurrentNavigableMap<K1, V1> concurrentNavigableMap) {
            this.m = concurrentNavigableMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.m.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                V1 v1 = this.m.get(entry.getKey());
                return v1 != null && v1.equals(entry.getValue());
            }
            return false;
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

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K1, V1>> iterator() {
            return this.m instanceof ConcurrentSkipListMap ? ((ConcurrentSkipListMap) this.m).entryIterator() : ((SubMap) this.m).entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.m.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.m.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ConcurrentSkipListMap.toList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ConcurrentSkipListMap.toList(this).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$HeadIndex.class */
    public static final class HeadIndex<K, V> extends Index<K, V> {
        final int level;

        HeadIndex(Node<K, V> node, Index<K, V> index, Index<K, V> index2, int i) {
            super(node, index, index2);
            this.level = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$Index.class */
    public static class Index<K, V> {
        private static final Unsafe UNSAFE;
        private static final long rightOffset;
        final Index<K, V> down;
        final Node<K, V> node;
        volatile Index<K, V> right;

        static {
            try {
                UNSAFE = Unsafe.getUnsafe();
                rightOffset = UNSAFE.objectFieldOffset(Index.class.getDeclaredField("right"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        Index(Node<K, V> node, Index<K, V> index, Index<K, V> index2) {
            this.node = node;
            this.down = index;
            this.right = index2;
        }

        final boolean casRight(Index<K, V> index, Index<K, V> index2) {
            return UNSAFE.compareAndSwapObject(this, rightOffset, index, index2);
        }

        final boolean indexesDeletedNode() {
            return this.node.value == null;
        }

        final boolean link(Index<K, V> index, Index<K, V> index2) {
            Node<K, V> node = this.node;
            index2.right = index;
            return node.value != null && casRight(index, index2);
        }

        final boolean unlink(Index<K, V> index) {
            return !indexesDeletedNode() && casRight(index, index.right);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$Iter.class */
    public abstract class Iter<T> implements Iterator<T> {
        Node<K, V> lastReturned;
        Node<K, V> next;
        V nextValue;

        Iter() {
            while (true) {
                this.next = ConcurrentSkipListMap.this.findFirst();
                if (this.next == null) {
                    return;
                }
                V v = (V) this.next.value;
                if (v != null && v != this.next) {
                    this.nextValue = v;
                    return;
                }
            }
        }

        final void advance() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned = this.next;
            while (true) {
                this.next = this.next.next;
                if (this.next == null) {
                    return;
                }
                V v = (V) this.next.value;
                if (v != null && v != this.next) {
                    this.nextValue = v;
                    return;
                }
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Node<K, V> node = this.lastReturned;
            if (node == null) {
                throw new IllegalStateException();
            }
            ConcurrentSkipListMap.this.remove(node.key);
            this.lastReturned = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$KeyIterator.class */
    public final class KeyIterator extends ConcurrentSkipListMap<K, V>.Iter<K> {
        KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            Node<K, V> node = this.next;
            advance();
            return node.key;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$KeySet.class */
    public static final class KeySet<E> extends AbstractSet<E> implements NavigableSet<E> {
        private final ConcurrentNavigableMap<E, ?> m;

        KeySet(ConcurrentNavigableMap<E, ?> concurrentNavigableMap) {
            this.m = concurrentNavigableMap;
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return this.m.ceilingKey(e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.m.clear();
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
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new KeySet(this.m.descendingMap());
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
            return new KeySet(this.m.headMap((ConcurrentNavigableMap<E, ?>) e, z));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableSet, java.util.SortedSet
        public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
            return headSet((KeySet<E>) obj);
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
            return this.m instanceof ConcurrentSkipListMap ? ((ConcurrentSkipListMap) this.m).keyIterator() : ((SubMap) this.m).keyIterator();
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
            Map.Entry<E, ?> pollFirstEntry = this.m.pollFirstEntry();
            if (pollFirstEntry == null) {
                return null;
            }
            return pollFirstEntry.getKey();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            Map.Entry<E, ?> pollLastEntry = this.m.pollLastEntry();
            if (pollLastEntry == null) {
                return null;
            }
            return pollLastEntry.getKey();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return this.m.remove(obj) != null;
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
            return new KeySet(this.m.subMap((boolean) e, z, (boolean) e2, z2));
        }

        @Override // java.util.NavigableSet, java.util.SortedSet
        public NavigableSet<E> tailSet(E e) {
            return tailSet(e, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e, boolean z) {
            return new KeySet(this.m.tailMap((ConcurrentNavigableMap<E, ?>) e, z));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableSet, java.util.SortedSet
        public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
            return tailSet((KeySet<E>) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ConcurrentSkipListMap.toList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ConcurrentSkipListMap.toList(this).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$Node.class */
    public static final class Node<K, V> {
        private static final Unsafe UNSAFE;
        private static final long nextOffset;
        private static final long valueOffset;
        final K key;
        volatile Node<K, V> next;
        volatile Object value;

        static {
            try {
                UNSAFE = Unsafe.getUnsafe();
                valueOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField(d.a.d));
                nextOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        Node(K k, Object obj, Node<K, V> node) {
            this.key = k;
            this.value = obj;
            this.next = node;
        }

        Node(Node<K, V> node) {
            this.key = null;
            this.value = this;
            this.next = node;
        }

        boolean appendMarker(Node<K, V> node) {
            return casNext(node, new Node<>(node));
        }

        boolean casNext(Node<K, V> node, Node<K, V> node2) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, node, node2);
        }

        boolean casValue(Object obj, Object obj2) {
            return UNSAFE.compareAndSwapObject(this, valueOffset, obj, obj2);
        }

        AbstractMap.SimpleImmutableEntry<K, V> createSnapshot() {
            V validValue = getValidValue();
            if (validValue == null) {
                return null;
            }
            return new AbstractMap.SimpleImmutableEntry<>(this.key, validValue);
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
            if (r0 == java.util.concurrent.ConcurrentSkipListMap.BASE_HEADER) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V getValidValue() {
            /*
                r3 = this;
                r0 = r3
                java.lang.Object r0 = r0.value
                r5 = r0
                r0 = r5
                r1 = r3
                if (r0 == r1) goto L13
                r0 = r5
                r4 = r0
                r0 = r5
                java.lang.Object r1 = java.util.concurrent.ConcurrentSkipListMap.access$000()
                if (r0 != r1) goto L15
            L13:
                r0 = 0
                r4 = r0
            L15:
                r0 = r4
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.Node.getValidValue():java.lang.Object");
        }

        void helpDelete(Node<K, V> node, Node<K, V> node2) {
            if (node2 == this.next && this == node.next) {
                if (node2 == null || node2.value != node2) {
                    appendMarker(node2);
                } else {
                    node.casNext(this, node2.next);
                }
            }
        }

        boolean isBaseHeader() {
            return this.value == ConcurrentSkipListMap.BASE_HEADER;
        }

        boolean isMarker() {
            return this.value == this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$SubMap.class */
    public static final class SubMap<K, V> extends AbstractMap<K, V> implements ConcurrentNavigableMap<K, V>, Cloneable, Serializable {
        private static final long serialVersionUID = -7647078645895051609L;
        private transient Set<Map.Entry<K, V>> entrySetView;
        private final K hi;
        private final boolean hiInclusive;
        private final boolean isDescending;
        private transient KeySet<K> keySetView;
        private final K lo;
        private final boolean loInclusive;
        private final ConcurrentSkipListMap<K, V> m;
        private transient Collection<V> valuesView;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$SubMap$SubMapEntryIterator.class */
        public final class SubMapEntryIterator extends SubMap<K, V>.SubMapIter<Map.Entry<K, V>> {
            SubMapEntryIterator() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                Node<K, V> node = this.next;
                V v = this.nextValue;
                advance();
                return new AbstractMap.SimpleImmutableEntry(node.key, v);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$SubMap$SubMapIter.class */
        public abstract class SubMapIter<T> implements Iterator<T> {
            Node<K, V> lastReturned;
            Node<K, V> next;
            V nextValue;

            SubMapIter() {
                while (true) {
                    this.next = SubMap.this.isDescending ? SubMap.this.hiNode() : SubMap.this.loNode();
                    if (this.next == null) {
                        return;
                    }
                    V v = (V) this.next.value;
                    if (v != null && v != this.next) {
                        if (SubMap.this.inBounds(this.next.key)) {
                            this.nextValue = v;
                            return;
                        } else {
                            this.next = null;
                            return;
                        }
                    }
                }
            }

            private void ascend() {
                while (true) {
                    this.next = this.next.next;
                    if (this.next == null) {
                        return;
                    }
                    V v = (V) this.next.value;
                    if (v != null && v != this.next) {
                        if (SubMap.this.tooHigh(this.next.key)) {
                            this.next = null;
                            return;
                        } else {
                            this.nextValue = v;
                            return;
                        }
                    }
                }
            }

            private void descend() {
                while (true) {
                    this.next = SubMap.this.m.findNear(this.lastReturned.key, 2);
                    if (this.next == null) {
                        return;
                    }
                    V v = (V) this.next.value;
                    if (v != null && v != this.next) {
                        if (SubMap.this.tooLow(this.next.key)) {
                            this.next = null;
                            return;
                        } else {
                            this.nextValue = v;
                            return;
                        }
                    }
                }
            }

            final void advance() {
                if (this.next == null) {
                    throw new NoSuchElementException();
                }
                this.lastReturned = this.next;
                if (SubMap.this.isDescending) {
                    descend();
                } else {
                    ascend();
                }
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.next != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                Node<K, V> node = this.lastReturned;
                if (node == null) {
                    throw new IllegalStateException();
                }
                SubMap.this.m.remove(node.key);
                this.lastReturned = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$SubMap$SubMapKeyIterator.class */
        public final class SubMapKeyIterator extends SubMap<K, V>.SubMapIter<K> {
            SubMapKeyIterator() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                Node<K, V> node = this.next;
                advance();
                return node.key;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$SubMap$SubMapValueIterator.class */
        public final class SubMapValueIterator extends SubMap<K, V>.SubMapIter<V> {
            SubMapValueIterator() {
                super();
            }

            @Override // java.util.Iterator
            public V next() {
                V v = this.nextValue;
                advance();
                return v;
            }
        }

        SubMap(ConcurrentSkipListMap<K, V> concurrentSkipListMap, K k, boolean z, K k2, boolean z2, boolean z3) {
            if (k != null && k2 != null && concurrentSkipListMap.compare(k, k2) > 0) {
                throw new IllegalArgumentException("inconsistent range");
            }
            this.m = concurrentSkipListMap;
            this.lo = k;
            this.hi = k2;
            this.loInclusive = z;
            this.hiInclusive = z2;
            this.isDescending = z3;
        }

        private void checkKeyBounds(K k) throws IllegalArgumentException {
            if (k == null) {
                throw new NullPointerException();
            }
            if (!inBounds(k)) {
                throw new IllegalArgumentException("key out of range");
            }
        }

        private Map.Entry<K, V> getNearEntry(K k, int i) {
            K k2;
            V validValue;
            int i2 = i;
            if (this.isDescending) {
                i2 = (i & 2) == 0 ? i | 2 : i & (-3);
            }
            if (tooLow(k)) {
                if ((i2 & 2) != 0) {
                    return null;
                }
                return lowestEntry();
            } else if (tooHigh(k)) {
                if ((i2 & 2) != 0) {
                    return highestEntry();
                }
                return null;
            } else {
                do {
                    Node<K, V> findNear = this.m.findNear(k, i2);
                    if (findNear == null || !inBounds(findNear.key)) {
                        return null;
                    }
                    k2 = findNear.key;
                    validValue = findNear.getValidValue();
                } while (validValue == null);
                return new AbstractMap.SimpleImmutableEntry(k2, validValue);
            }
        }

        private K getNearKey(K k, int i) {
            Node<K, V> findNear;
            K k2;
            Node<K, V> hiNode;
            K k3;
            int i2 = i;
            if (this.isDescending) {
                i2 = (i & 2) == 0 ? i | 2 : i & (-3);
            }
            if (tooLow(k)) {
                if ((i2 & 2) != 0) {
                    return null;
                }
                Node<K, V> loNode = loNode();
                if (!isBeforeEnd(loNode)) {
                    return null;
                }
                k3 = loNode.key;
            } else if (!tooHigh(k)) {
                do {
                    findNear = this.m.findNear(k, i2);
                    if (findNear == null || !inBounds(findNear.key)) {
                        return null;
                    }
                    k2 = findNear.key;
                } while (findNear.getValidValue() == null);
                return k2;
            } else if ((i2 & 2) == 0 || (hiNode = hiNode()) == null) {
                return null;
            } else {
                K k4 = hiNode.key;
                k3 = k4;
                if (!inBounds(k4)) {
                    return null;
                }
            }
            return k3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node<K, V> hiNode() {
            return this.hi == null ? this.m.findLast() : this.hiInclusive ? this.m.findNear(this.hi, 3) : this.m.findNear(this.hi, 2);
        }

        private Map.Entry<K, V> highestEntry() {
            AbstractMap.SimpleImmutableEntry<K, V> createSnapshot;
            do {
                Node<K, V> hiNode = hiNode();
                if (hiNode == null || !inBounds(hiNode.key)) {
                    return null;
                }
                createSnapshot = hiNode.createSnapshot();
            } while (createSnapshot == null);
            return createSnapshot;
        }

        private K highestKey() {
            Node<K, V> hiNode = hiNode();
            if (hiNode != null) {
                K k = hiNode.key;
                if (inBounds(k)) {
                    return k;
                }
            }
            throw new NoSuchElementException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean inBounds(K k) {
            return (tooLow(k) || tooHigh(k)) ? false : true;
        }

        private boolean isBeforeEnd(Node<K, V> node) {
            K k;
            if (node == null) {
                return false;
            }
            if (this.hi == null || (k = node.key) == null) {
                return true;
            }
            int compare = this.m.compare(k, this.hi);
            if (compare <= 0) {
                return compare != 0 || this.hiInclusive;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node<K, V> loNode() {
            return this.lo == null ? this.m.findFirst() : this.loInclusive ? this.m.findNear(this.lo, 1) : this.m.findNear(this.lo, 0);
        }

        private Map.Entry<K, V> lowestEntry() {
            AbstractMap.SimpleImmutableEntry<K, V> createSnapshot;
            do {
                Node<K, V> loNode = loNode();
                if (!isBeforeEnd(loNode)) {
                    return null;
                }
                createSnapshot = loNode.createSnapshot();
            } while (createSnapshot == null);
            return createSnapshot;
        }

        private K lowestKey() {
            Node<K, V> loNode = loNode();
            if (isBeforeEnd(loNode)) {
                return loNode.key;
            }
            throw new NoSuchElementException();
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00a4, code lost:
            if (r16 != false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00e8, code lost:
            if (r15 != false) goto L33;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V> newSubMap(K r10, boolean r11, K r12, boolean r13) {
            /*
                Method dump skipped, instructions count: 245
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.SubMap.newSubMap(java.lang.Object, boolean, java.lang.Object, boolean):java.util.concurrent.ConcurrentSkipListMap$SubMap");
        }

        private Map.Entry<K, V> removeHighest() {
            K k;
            V doRemove;
            do {
                Node<K, V> hiNode = hiNode();
                if (hiNode == null) {
                    return null;
                }
                k = hiNode.key;
                if (!inBounds(k)) {
                    return null;
                }
                doRemove = this.m.doRemove(k, null);
            } while (doRemove == null);
            return new AbstractMap.SimpleImmutableEntry(k, doRemove);
        }

        private Map.Entry<K, V> removeLowest() {
            K k;
            V doRemove;
            do {
                Node<K, V> loNode = loNode();
                if (loNode == null) {
                    return null;
                }
                k = loNode.key;
                if (!inBounds(k)) {
                    return null;
                }
                doRemove = this.m.doRemove(k, null);
            } while (doRemove == null);
            return new AbstractMap.SimpleImmutableEntry(k, doRemove);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean tooHigh(K k) {
            if (this.hi != null) {
                int compare = this.m.compare(k, this.hi);
                if (compare <= 0) {
                    return compare == 0 && !this.hiInclusive;
                }
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean tooLow(K k) {
            if (this.lo != null) {
                int compare = this.m.compare(k, this.lo);
                if (compare >= 0) {
                    return compare == 0 && !this.loInclusive;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return getNearEntry(k, 1);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return getNearKey(k, 1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Node<K, V> loNode = loNode();
            while (true) {
                Node<K, V> node = loNode;
                if (!isBeforeEnd(node)) {
                    return;
                }
                if (node.getValidValue() != null) {
                    this.m.remove(node.key);
                }
                loNode = node.next;
            }
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.m.comparator();
            Comparator<? super K> comparator2 = comparator;
            if (this.isDescending) {
                comparator2 = Collections.reverseOrder(comparator);
            }
            return comparator2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (obj == 0) {
                throw new NullPointerException();
            }
            return inBounds(obj) && this.m.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            if (obj == null) {
                throw new NullPointerException();
            }
            Node<K, V> loNode = loNode();
            while (true) {
                Node<K, V> node = loNode;
                if (!isBeforeEnd(node)) {
                    return false;
                }
                V validValue = node.getValidValue();
                if (validValue != null && obj.equals(validValue)) {
                    return true;
                }
                loNode = node.next;
            }
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> descendingMap() {
            return new SubMap<>(this.m, this.lo, this.loInclusive, this.hi, this.hiInclusive, !this.isDescending);
        }

        Iterator<Map.Entry<K, V>> entryIterator() {
            return new SubMapEntryIterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.entrySetView;
            if (set != null) {
                return set;
            }
            EntrySet entrySet = new EntrySet(this);
            this.entrySetView = entrySet;
            return entrySet;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return this.isDescending ? highestEntry() : lowestEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return this.isDescending ? highestKey() : lowestKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return getNearEntry(k, 3);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return getNearKey(k, 3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (obj == 0) {
                throw new NullPointerException();
            }
            if (inBounds(obj)) {
                return this.m.get(obj);
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap headMap(Object obj, boolean z) {
            return headMap((SubMap<K, V>) obj, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableMap, java.util.SortedMap
        public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
            return headMap((SubMap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap, java.util.SortedMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap headMap(Object obj) {
            return headMap((SubMap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap headMap(Object obj, boolean z) {
            return headMap((SubMap<K, V>) obj, z);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap, java.util.SortedMap
        public SubMap<K, V> headMap(K k) {
            return headMap((SubMap<K, V>) k, false);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> headMap(K k, boolean z) {
            if (k == null) {
                throw new NullPointerException();
            }
            return newSubMap(null, false, k, z);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return getNearEntry(k, 0);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return getNearKey(k, 0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !isBeforeEnd(loNode());
        }

        Iterator<K> keyIterator() {
            return new SubMapKeyIterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public NavigableSet<K> keySet() {
            KeySet<K> keySet = this.keySetView;
            if (keySet != null) {
                return keySet;
            }
            KeySet<K> keySet2 = new KeySet<>(this);
            this.keySetView = keySet2;
            return keySet2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return this.isDescending ? lowestEntry() : highestEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return this.isDescending ? lowestKey() : highestKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return getNearEntry(k, 2);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return getNearKey(k, 2);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            KeySet<K> keySet = this.keySetView;
            if (keySet != null) {
                return keySet;
            }
            KeySet<K> keySet2 = new KeySet<>(this);
            this.keySetView = keySet2;
            return keySet2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return this.isDescending ? removeHighest() : removeLowest();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return this.isDescending ? removeLowest() : removeHighest();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            checkKeyBounds(k);
            return this.m.put(k, v);
        }

        @Override // java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K k, V v) {
            checkKeyBounds(k);
            return this.m.putIfAbsent(k, v);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            if (inBounds(obj)) {
                return this.m.remove(obj);
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentMap
        public boolean remove(Object obj, Object obj2) {
            return inBounds(obj) && this.m.remove(obj, obj2);
        }

        @Override // java.util.concurrent.ConcurrentMap
        public V replace(K k, V v) {
            checkKeyBounds(k);
            return this.m.replace(k, v);
        }

        @Override // java.util.concurrent.ConcurrentMap
        public boolean replace(K k, V v, V v2) {
            checkKeyBounds(k);
            return this.m.replace(k, v, v2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            long j = 0;
            Node<K, V> loNode = loNode();
            while (isBeforeEnd(loNode)) {
                long j2 = j;
                if (loNode.getValidValue() != null) {
                    j2 = j + 1;
                }
                loNode = loNode.next;
                j = j2;
            }
            if (j >= 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return subMap((boolean) obj, z, (boolean) obj2, z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return subMap((boolean) obj, z, (boolean) obj2, z2);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap, java.util.SortedMap
        public SubMap<K, V> subMap(K k, K k2) {
            return subMap((boolean) k, true, (boolean) k2, false);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            if (k == null || k2 == null) {
                throw new NullPointerException();
            }
            return newSubMap(k, z, k2, z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap tailMap(Object obj, boolean z) {
            return tailMap((SubMap<K, V>) obj, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableMap, java.util.SortedMap
        public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
            return tailMap((SubMap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap, java.util.SortedMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap tailMap(Object obj) {
            return tailMap((SubMap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap tailMap(Object obj, boolean z) {
            return tailMap((SubMap<K, V>) obj, z);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap, java.util.SortedMap
        public SubMap<K, V> tailMap(K k) {
            return tailMap((SubMap<K, V>) k, true);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> tailMap(K k, boolean z) {
            if (k == null) {
                throw new NullPointerException();
            }
            return newSubMap(k, z, null, false);
        }

        Iterator<V> valueIterator() {
            return new SubMapValueIterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.valuesView;
            if (collection != null) {
                return collection;
            }
            Values values = new Values(this);
            this.valuesView = values;
            return values;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$ValueIterator.class */
    public final class ValueIterator extends ConcurrentSkipListMap<K, V>.Iter<V> {
        ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            V v = this.nextValue;
            advance();
            return v;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentSkipListMap$Values.class */
    public static final class Values<E> extends AbstractCollection<E> {
        private final ConcurrentNavigableMap<?, E> m;

        Values(ConcurrentNavigableMap<?, E> concurrentNavigableMap) {
            this.m = concurrentNavigableMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.m.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.m.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return this.m instanceof ConcurrentSkipListMap ? ((ConcurrentSkipListMap) this.m).valueIterator() : ((SubMap) this.m).valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.m.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ConcurrentSkipListMap.toList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ConcurrentSkipListMap.toList(this).toArray(tArr);
        }
    }

    static {
        try {
            UNSAFE = Unsafe.getUnsafe();
            headOffset = UNSAFE.objectFieldOffset(ConcurrentSkipListMap.class.getDeclaredField("head"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ConcurrentSkipListMap() {
        this.comparator = null;
        initialize();
    }

    public ConcurrentSkipListMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
        initialize();
    }

    public ConcurrentSkipListMap(Map<? extends K, ? extends V> map) {
        this.comparator = null;
        initialize();
        putAll(map);
    }

    public ConcurrentSkipListMap(SortedMap<K, ? extends V> sortedMap) {
        this.comparator = sortedMap.comparator();
        initialize();
        buildFromSorted(sortedMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x001d, code lost:
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void addIndex(java.util.concurrent.ConcurrentSkipListMap.Index<K, V> r5, java.util.concurrent.ConcurrentSkipListMap.HeadIndex<K, V> r6, int r7) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.addIndex(java.util.concurrent.ConcurrentSkipListMap$Index, java.util.concurrent.ConcurrentSkipListMap$HeadIndex, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v64, types: [java.util.concurrent.ConcurrentSkipListMap$Index<K, V>] */
    private void buildFromSorted(SortedMap<K, ? extends V> sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException();
        }
        HeadIndex<K, V> headIndex = this.head;
        Node<K, V> node = headIndex.node;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > headIndex.level) {
                break;
            }
            arrayList.add(null);
            i = i2 + 1;
        }
        HeadIndex<K, V> headIndex2 = headIndex;
        int i3 = headIndex.level;
        while (true) {
            int i4 = i3;
            if (i4 <= 0) {
                break;
            }
            arrayList.set(i4, headIndex2);
            headIndex2 = headIndex2.down;
            i3 = i4 - 1;
        }
        HeadIndex<K, V> headIndex3 = headIndex;
        Node<K, V> node2 = node;
        for (Map.Entry<K, ? extends V> entry : sortedMap.entrySet()) {
            int randomLevel = randomLevel();
            int i5 = randomLevel;
            if (randomLevel > headIndex3.level) {
                i5 = headIndex3.level + 1;
            }
            K key = entry.getKey();
            V value = entry.getValue();
            if (key == null || value == null) {
                throw new NullPointerException();
            }
            Node<K, V> node3 = new Node<>(key, value, null);
            node2.next = node3;
            node2 = node3;
            if (i5 > 0) {
                Index<K, V> index = null;
                for (int i6 = 1; i6 <= i5; i6++) {
                    index = new Index<>(node3, index, null);
                    if (i6 > headIndex3.level) {
                        headIndex3 = new HeadIndex<>(headIndex3.node, headIndex3, index, i6);
                    }
                    if (i6 < arrayList.size()) {
                        ((Index) arrayList.get(i6)).right = index;
                        arrayList.set(i6, index);
                    } else {
                        arrayList.add(index);
                    }
                }
                node2 = node3;
            }
        }
        this.head = headIndex3;
    }

    private boolean casHead(HeadIndex<K, V> headIndex, HeadIndex<K, V> headIndex2) {
        return UNSAFE.compareAndSwapObject(this, headOffset, headIndex, headIndex2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void clearIndexToFirst() {
        loop0: while (true) {
            Index index = this.head;
            while (true) {
                Index<K, V> index2 = index.right;
                if (index2 == null || !index2.indexesDeletedNode() || index.unlink(index2)) {
                    Index index3 = (Index<K, V>) index.down;
                    index = index3;
                    if (index3 == null) {
                        break loop0;
                    }
                }
            }
        }
        if (this.head.right == null) {
            tryReduceLevel();
        }
    }

    private Comparable<? super K> comparable(Object obj) throws ClassCastException {
        if (obj == null) {
            throw new NullPointerException();
        }
        return this.comparator != null ? new ComparableUsingComparator(obj, this.comparator) : (Comparable) obj;
    }

    private V doGet(Object obj) {
        V v;
        Comparable<? super K> comparable = comparable(obj);
        do {
            Node<K, V> findNode = findNode(comparable);
            if (findNode == null) {
                return null;
            }
            v = (V) findNode.value;
        } while (v == null);
        return v;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0007, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private V doPut(K r7, V r8, boolean r9) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            java.lang.Comparable r0 = r0.comparable(r1)
            r14 = r0
        L7:
            r0 = r6
            r1 = r14
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r0.findPredecessor(r1)
            r12 = r0
            r0 = r12
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r11 = r0
        L16:
            r0 = r11
            if (r0 == 0) goto L88
            r0 = r11
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r13 = r0
            r0 = r11
            r1 = r12
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r1 = r1.next
            if (r0 != r1) goto L7
            r0 = r11
            java.lang.Object r0 = r0.value
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L44
            r0 = r11
            r1 = r12
            r2 = r13
            r0.helpDelete(r1, r2)
            goto L7
        L44:
            r0 = r15
            r1 = r11
            if (r0 == r1) goto L7
            r0 = r12
            java.lang.Object r0 = r0.value
            if (r0 == 0) goto L7
            r0 = r14
            r1 = r11
            K r1 = r1.key
            int r0 = r0.compareTo(r1)
            r10 = r0
            r0 = r10
            if (r0 <= 0) goto L71
            r0 = r11
            r12 = r0
            r0 = r13
            r11 = r0
            goto L16
        L71:
            r0 = r10
            if (r0 != 0) goto L88
            r0 = r9
            if (r0 != 0) goto L85
            r0 = r11
            r1 = r15
            r2 = r8
            boolean r0 = r0.casValue(r1, r2)
            if (r0 == 0) goto L7
        L85:
            r0 = r15
            return r0
        L88:
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = new java.util.concurrent.ConcurrentSkipListMap$Node
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r11
            r1.<init>(r2, r3, r4)
            r13 = r0
            r0 = r12
            r1 = r11
            r2 = r13
            boolean r0 = r0.casNext(r1, r2)
            if (r0 == 0) goto L7
            r0 = r6
            int r0 = r0.randomLevel()
            r10 = r0
            r0 = r10
            if (r0 <= 0) goto Lb4
            r0 = r6
            r1 = r13
            r2 = r10
            r0.insertIndex(r1, r2)
        Lb4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.doPut(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.concurrent.ConcurrentSkipListMap.Node<K, V> findNode(java.lang.Comparable<? super K> r5) {
        /*
            r4 = this;
        L0:
            r0 = r4
            r1 = r5
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r0.findPredecessor(r1)
            r8 = r0
            r0 = r8
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r7 = r0
        Ld:
            r0 = r7
            if (r0 != 0) goto L17
            r0 = 0
            r8 = r0
        L14:
            r0 = r8
            return r0
        L17:
            r0 = r7
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r9 = r0
            r0 = r7
            r1 = r8
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r1 = r1.next
            if (r0 != r1) goto L0
            r0 = r7
            java.lang.Object r0 = r0.value
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L3c
            r0 = r7
            r1 = r8
            r2 = r9
            r0.helpDelete(r1, r2)
            goto L0
        L3c:
            r0 = r10
            r1 = r7
            if (r0 == r1) goto L0
            r0 = r8
            java.lang.Object r0 = r0.value
            if (r0 == 0) goto L0
            r0 = r5
            r1 = r7
            K r1 = r1.key
            int r0 = r0.compareTo(r1)
            r6 = r0
            r0 = r7
            r8 = r0
            r0 = r6
            if (r0 == 0) goto L14
            r0 = r6
            if (r0 >= 0) goto L62
            r0 = 0
            return r0
        L62:
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.findNode(java.lang.Comparable):java.util.concurrent.ConcurrentSkipListMap$Node");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Node<K, V> findPredecessor(Comparable<? super K> comparable) {
        if (comparable == null) {
            throw new NullPointerException();
        }
        while (true) {
            Index index = this.head;
            Index index2 = index.right;
            while (true) {
                Index index3 = index2;
                if (index3 != null) {
                    Node<K, V> node = index3.node;
                    Object obj = (K) node.key;
                    if (node.value == null) {
                        if (index.unlink(index3)) {
                            index2 = index.right;
                        }
                    } else if (comparable.compareTo(obj) > 0) {
                        index = index3;
                        index2 = index3.right;
                    }
                }
                Index index4 = (Index<K, V>) index.down;
                if (index4 == null) {
                    return index.node;
                }
                index = index4;
                index2 = index4.right;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Node<K, V> findPredecessorOfLast() {
        Index index;
        Index index2;
        while (true) {
            Index index3 = this.head;
            while (true) {
                index = index3;
                index2 = index.right;
                if (index2 != null) {
                    if (index2.indexesDeletedNode()) {
                        break;
                    } else if (index2.node.next != null) {
                        index3 = index2;
                    }
                }
                Index index4 = (Index<K, V>) index.down;
                if (index4 == null) {
                    return index.node;
                }
                index3 = index4;
            }
            index.unlink(index2);
        }
    }

    private void insertIndex(Node<K, V> node, int i) {
        HeadIndex<K, V> headIndex;
        int i2;
        HeadIndex<K, V> headIndex2 = this.head;
        int i3 = headIndex2.level;
        if (i <= i3) {
            Index<K, V> index = null;
            for (int i4 = 1; i4 <= i; i4++) {
                index = new Index<>(node, index, null);
            }
            addIndex(index, headIndex2, i);
            return;
        }
        int i5 = i3 + 1;
        Index<K, V>[] indexArr = new Index[i5 + 1];
        Index<K, V> index2 = null;
        for (int i6 = 1; i6 <= i5; i6++) {
            index2 = new Index<>(node, index2, null);
            indexArr[i6] = index2;
        }
        while (true) {
            headIndex = this.head;
            int i7 = headIndex.level;
            if (i5 <= i7) {
                i2 = i5;
                break;
            }
            Node<K, V> node2 = headIndex.node;
            HeadIndex<K, V> headIndex3 = headIndex;
            for (int i8 = i7 + 1; i8 <= i5; i8++) {
                headIndex3 = new HeadIndex<>(node2, headIndex3, indexArr[i8], i8);
            }
            if (casHead(headIndex, headIndex3)) {
                i2 = i7;
                break;
            }
        }
        addIndex(indexArr[i2], headIndex, i2);
    }

    private int randomLevel() {
        int i;
        int i2 = this.randomSeed;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >>> 17);
        int i5 = i4 ^ (i4 << 5);
        this.randomSeed = i5;
        if (((-2147483647) & i5) == 0) {
            int i6 = 1;
            while (true) {
                int i7 = i5 >>> 1;
                i = i6;
                if ((i7 & 1) == 0) {
                    break;
                }
                i6++;
                i5 = i7;
            }
        } else {
            i = 0;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v57, types: [java.util.concurrent.ConcurrentSkipListMap$Index<K, V>] */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Node<K, V> node;
        HeadIndex<K, V> headIndex;
        objectInputStream.defaultReadObject();
        initialize();
        HeadIndex<K, V> headIndex2 = this.head;
        Node<K, V> node2 = headIndex2.node;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > headIndex2.level) {
                break;
            }
            arrayList.add(null);
            i = i2 + 1;
        }
        HeadIndex<K, V> headIndex3 = headIndex2;
        int i3 = headIndex2.level;
        while (true) {
            int i4 = i3;
            node = node2;
            headIndex = headIndex2;
            if (i4 <= 0) {
                break;
            }
            arrayList.set(i4, headIndex3);
            headIndex3 = headIndex3.down;
            i3 = i4 - 1;
        }
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                this.head = headIndex;
                return;
            }
            Object readObject2 = objectInputStream.readObject();
            if (readObject2 == null) {
                throw new NullPointerException();
            }
            int randomLevel = randomLevel();
            int i5 = randomLevel;
            if (randomLevel > headIndex.level) {
                i5 = headIndex.level + 1;
            }
            Node<K, V> node3 = new Node<>(readObject, readObject2, null);
            node.next = node3;
            node = node3;
            if (i5 > 0) {
                Index<K, V> index = null;
                for (int i6 = 1; i6 <= i5; i6++) {
                    index = new Index<>(node3, index, null);
                    if (i6 > headIndex.level) {
                        headIndex = new HeadIndex<>(headIndex.node, headIndex, index, i6);
                    }
                    if (i6 < arrayList.size()) {
                        ((Index) arrayList.get(i6)).right = index;
                        arrayList.set(i6, index);
                    } else {
                        arrayList.add(index);
                    }
                }
                node = node3;
            }
        }
    }

    static final <E> List<E> toList(Collection<E> collection) {
        ArrayList arrayList = new ArrayList();
        for (E e : collection) {
            arrayList.add(e);
        }
        return arrayList;
    }

    private void tryReduceLevel() {
        HeadIndex<K, V> headIndex;
        HeadIndex headIndex2;
        HeadIndex<K, V> headIndex3 = this.head;
        if (headIndex3.level <= 3 || (headIndex = (HeadIndex) headIndex3.down) == null || (headIndex2 = (HeadIndex) headIndex.down) == null || headIndex2.right != null || headIndex.right != null || headIndex3.right != null || !casHead(headIndex3, headIndex) || headIndex3.right == null) {
            return;
        }
        casHead(headIndex, headIndex3);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Node<K, V> findFirst = findFirst();
        while (true) {
            Node<K, V> node = findFirst;
            if (node == null) {
                objectOutputStream.writeObject(null);
                return;
            }
            V validValue = node.getValidValue();
            if (validValue != null) {
                objectOutputStream.writeObject(node.key);
                objectOutputStream.writeObject(validValue);
            }
            findFirst = node.next;
        }
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        return getNear(k, 1);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        Node<K, V> findNear = findNear(k, 1);
        if (findNear == null) {
            return null;
        }
        return findNear.key;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        initialize();
    }

    @Override // java.util.AbstractMap
    public ConcurrentSkipListMap<K, V> clone() {
        try {
            ConcurrentSkipListMap<K, V> concurrentSkipListMap = (ConcurrentSkipListMap) super.clone();
            concurrentSkipListMap.initialize();
            concurrentSkipListMap.buildFromSorted(this);
            return concurrentSkipListMap;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return this.comparator;
    }

    int compare(K k, K k2) throws ClassCastException {
        Comparator<? super K> comparator = this.comparator;
        return comparator != null ? comparator.compare(k, k2) : ((Comparable) k).compareTo(k2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return doGet(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        Node<K, V> findFirst = findFirst();
        while (true) {
            Node<K, V> node = findFirst;
            if (node == null) {
                return false;
            }
            V validValue = node.getValidValue();
            if (validValue != null && obj.equals(validValue)) {
                return true;
            }
            findFirst = node.next;
        }
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> descendingMap() {
        ConcurrentNavigableMap<K, V> concurrentNavigableMap = this.descendingMap;
        if (concurrentNavigableMap != null) {
            return concurrentNavigableMap;
        }
        SubMap subMap = new SubMap(this, null, false, null, false, true);
        this.descendingMap = subMap;
        return subMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final V doRemove(java.lang.Object r5, java.lang.Object r6) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            java.lang.Comparable r0 = r0.comparable(r1)
            r11 = r0
        L7:
            r0 = r4
            r1 = r11
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r0.findPredecessor(r1)
            r8 = r0
            r0 = r8
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r5 = r0
        L15:
            r0 = r5
            if (r0 != 0) goto L1d
            r0 = 0
            r5 = r0
        L1b:
            r0 = r5
            return r0
        L1d:
            r0 = r5
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r9 = r0
            r0 = r5
            r1 = r8
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r1 = r1.next
            if (r0 != r1) goto L7
            r0 = r5
            java.lang.Object r0 = r0.value
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L42
            r0 = r5
            r1 = r8
            r2 = r9
            r0.helpDelete(r1, r2)
            goto L7
        L42:
            r0 = r10
            r1 = r5
            if (r0 == r1) goto L7
            r0 = r8
            java.lang.Object r0 = r0.value
            if (r0 == 0) goto L7
            r0 = r11
            r1 = r5
            K r1 = r1.key
            int r0 = r0.compareTo(r1)
            r7 = r0
            r0 = r7
            if (r0 >= 0) goto L62
            r0 = 0
            return r0
        L62:
            r0 = r7
            if (r0 <= 0) goto L6f
            r0 = r5
            r8 = r0
            r0 = r9
            r5 = r0
            goto L15
        L6f:
            r0 = r6
            if (r0 == 0) goto L7e
            r0 = r6
            r1 = r10
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7e
            r0 = 0
            return r0
        L7e:
            r0 = r5
            r1 = r10
            r2 = 0
            boolean r0 = r0.casValue(r1, r2)
            if (r0 == 0) goto L7
            r0 = r5
            r1 = r9
            boolean r0 = r0.appendMarker(r1)
            if (r0 == 0) goto L9c
            r0 = r8
            r1 = r5
            r2 = r9
            boolean r0 = r0.casNext(r1, r2)
            if (r0 != 0) goto La6
        L9c:
            r0 = r4
            r1 = r11
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r0.findNode(r1)
            r0 = r10
            return r0
        La6:
            r0 = r4
            r1 = r11
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r0.findPredecessor(r1)
            r0 = r10
            r5 = r0
            r0 = r4
            java.util.concurrent.ConcurrentSkipListMap$HeadIndex<K, V> r0 = r0.head
            java.util.concurrent.ConcurrentSkipListMap$Index<K, V> r0 = r0.right
            if (r0 != 0) goto L1b
            r0 = r4
            r0.tryReduceLevel()
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.doRemove(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    Map.Entry<K, V> doRemoveFirstEntry() {
        while (true) {
            Node<K, V> node = this.head.node;
            Node<K, V> node2 = node.next;
            if (node2 == null) {
                return null;
            }
            Node<K, V> node3 = node2.next;
            if (node2 == node.next) {
                Object obj = node2.value;
                if (obj == null) {
                    node2.helpDelete(node, node3);
                } else if (node2.casValue(obj, null)) {
                    if (!node2.appendMarker(node3) || !node.casNext(node2, node3)) {
                        findFirst();
                    }
                    clearIndexToFirst();
                    return new AbstractMap.SimpleImmutableEntry(node2.key, obj);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0000, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.Map.Entry<K, V> doRemoveLastEntry() {
        /*
            r5 = this;
        L0:
            r0 = r5
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r0.findPredecessorOfLast()
            r8 = r0
            r0 = r8
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            r6 = r0
            r0 = r9
            if (r0 != 0) goto L26
            r0 = r8
            boolean r0 = r0.isBaseHeader()
            if (r0 == 0) goto L0
            r0 = 0
            return r0
        L1e:
            r0 = r8
            if (r0 == 0) goto L57
            r0 = r6
            r7 = r0
            r0 = r8
            r6 = r0
        L26:
            r0 = r6
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r8 = r0
            r0 = r6
            r1 = r7
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r1 = r1.next
            if (r0 != r1) goto L0
            r0 = r6
            java.lang.Object r0 = r0.value
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L47
            r0 = r6
            r1 = r7
            r2 = r8
            r0.helpDelete(r1, r2)
            goto L0
        L47:
            r0 = r9
            r1 = r6
            if (r0 == r1) goto L0
            r0 = r7
            java.lang.Object r0 = r0.value
            if (r0 != 0) goto L1e
            goto L0
        L57:
            r0 = r6
            r1 = r9
            r2 = 0
            boolean r0 = r0.casValue(r1, r2)
            if (r0 == 0) goto L0
            r0 = r6
            K r0 = r0.key
            r10 = r0
            r0 = r5
            r1 = r10
            java.lang.Comparable r0 = r0.comparable(r1)
            r11 = r0
            r0 = r6
            r1 = r8
            boolean r0 = r0.appendMarker(r1)
            if (r0 == 0) goto L80
            r0 = r7
            r1 = r6
            r2 = r8
            boolean r0 = r0.casNext(r1, r2)
            if (r0 != 0) goto L93
        L80:
            r0 = r5
            r1 = r11
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r0.findNode(r1)
        L87:
            java.util.AbstractMap$SimpleImmutableEntry r0 = new java.util.AbstractMap$SimpleImmutableEntry
            r1 = r0
            r2 = r10
            r3 = r9
            r1.<init>(r2, r3)
            return r0
        L93:
            r0 = r5
            r1 = r11
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r0.findPredecessor(r1)
            r0 = r5
            java.util.concurrent.ConcurrentSkipListMap$HeadIndex<K, V> r0 = r0.head
            java.util.concurrent.ConcurrentSkipListMap$Index<K, V> r0 = r0.right
            if (r0 != 0) goto L87
            r0 = r5
            r0.tryReduceLevel()
            goto L87
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.doRemoveLastEntry():java.util.Map$Entry");
    }

    Iterator<Map.Entry<K, V>> entryIterator() {
        return new EntryIterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySet<K, V> entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet<K, V> entrySet2 = new EntrySet<>(this);
        this.entrySet = entrySet2;
        return entrySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        K key;
        V value;
        Map.Entry<K, V> next;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            try {
                Iterator<Map.Entry<K, V>> it = entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
                        do {
                            if (!it2.hasNext()) {
                                return true;
                            }
                            Map.Entry<K, V> next2 = it2.next();
                            key = next2.getKey();
                            value = next2.getValue();
                            if (key == null || value == null) {
                                return false;
                            }
                        } while (value.equals(get(key)));
                        return false;
                    }
                    next = it.next();
                } while (next.getValue().equals(map.get(next.getKey())));
                return false;
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
        return false;
    }

    Node<K, V> findFirst() {
        Node<K, V> node;
        while (true) {
            Node<K, V> node2 = this.head.node;
            Node<K, V> node3 = node2.next;
            if (node3 != null) {
                node = node3;
                if (node3.value != null) {
                    break;
                }
                node3.helpDelete(node2, node3.next);
            } else {
                node = null;
                break;
            }
        }
        return node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    Node<K, V> findLast() {
        Node<K, V> node;
        Index index = this.head;
        loop0: while (true) {
            Index index2 = index;
            Index index3 = index2.right;
            if (index3 == null) {
                Index index4 = (Index<K, V>) index2.down;
                if (index4 != null) {
                    index = index4;
                } else {
                    node = index2.node;
                    Node<K, V> node2 = node.next;
                    while (true) {
                        Node<K, V> node3 = node2;
                        if (node3 != null) {
                            Node<K, V> node4 = node3.next;
                            if (node3 != node.next) {
                                break;
                            }
                            Object obj = node3.value;
                            if (obj != null) {
                                if (obj == node3 || node.value == null) {
                                    break;
                                }
                                node = node3;
                                node2 = node4;
                            } else {
                                node3.helpDelete(node, node4);
                                break;
                            }
                        } else {
                            break loop0;
                        }
                    }
                    index = this.head;
                }
            } else if (index3.indexesDeletedNode()) {
                index2.unlink(index3);
                index = this.head;
            } else {
                index = index3;
            }
        }
        Node<K, V> node5 = node;
        if (node.isBaseHeader()) {
            node5 = null;
        }
        return node5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r5.isBaseHeader() != false) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.concurrent.ConcurrentSkipListMap.Node<K, V> findNear(K r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            r9 = r0
            r0 = r4
            r1 = r5
            java.lang.Comparable r0 = r0.comparable(r1)
            r11 = r0
        La:
            r0 = r4
            r1 = r11
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r0.findPredecessor(r1)
            r5 = r0
            r0 = r5
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r8 = r0
        L17:
            r0 = r8
            if (r0 != 0) goto L32
            r0 = r6
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L2c
            r0 = r5
            r8 = r0
            r0 = r5
            boolean r0 = r0.isBaseHeader()
            if (r0 == 0) goto L2f
        L2c:
            r0 = 0
            r8 = r0
        L2f:
            r0 = r8
            return r0
        L32:
            r0 = r8
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r0.next
            r10 = r0
            r0 = r8
            r1 = r5
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r1 = r1.next
            if (r0 != r1) goto La
            r0 = r8
            java.lang.Object r0 = r0.value
            r12 = r0
            r0 = r12
            if (r0 != 0) goto L59
            r0 = r8
            r1 = r5
            r2 = r10
            r0.helpDelete(r1, r2)
            goto La
        L59:
            r0 = r12
            r1 = r8
            if (r0 == r1) goto La
            r0 = r5
            java.lang.Object r0 = r0.value
            if (r0 == 0) goto La
            r0 = r11
            r1 = r8
            K r1 = r1.key
            int r0 = r0.compareTo(r1)
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L7e
            r0 = r6
            r1 = 1
            r0 = r0 & r1
            if (r0 != 0) goto L88
        L7e:
            r0 = r7
            if (r0 >= 0) goto L8b
            r0 = r6
            r1 = 2
            r0 = r0 & r1
            if (r0 != 0) goto L8b
        L88:
            r0 = r8
            return r0
        L8b:
            r0 = r7
            if (r0 > 0) goto La4
            r0 = r6
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto La4
            r0 = r5
            boolean r0 = r0.isBaseHeader()
            if (r0 == 0) goto La1
            r0 = r9
            r5 = r0
        L9f:
            r0 = r5
            return r0
        La1:
            goto L9f
        La4:
            r0 = r8
            r5 = r0
            r0 = r10
            r8 = r0
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.findNear(java.lang.Object, int):java.util.concurrent.ConcurrentSkipListMap$Node");
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        AbstractMap.SimpleImmutableEntry<K, V> createSnapshot;
        do {
            Node<K, V> findFirst = findFirst();
            if (findFirst == null) {
                return null;
            }
            createSnapshot = findFirst.createSnapshot();
        } while (createSnapshot == null);
        return createSnapshot;
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Node<K, V> findFirst = findFirst();
        if (findFirst == null) {
            throw new NoSuchElementException();
        }
        return findFirst.key;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        return getNear(k, 3);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        Node<K, V> findNear = findNear(k, 3);
        if (findNear == null) {
            return null;
        }
        return findNear.key;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        return doGet(obj);
    }

    AbstractMap.SimpleImmutableEntry<K, V> getNear(K k, int i) {
        AbstractMap.SimpleImmutableEntry<K, V> createSnapshot;
        do {
            Node<K, V> findNear = findNear(k, i);
            if (findNear == null) {
                return null;
            }
            createSnapshot = findNear.createSnapshot();
        } while (createSnapshot == null);
        return createSnapshot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object obj, boolean z) {
        return headMap((ConcurrentSkipListMap<K, V>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap((ConcurrentSkipListMap<K, V>) obj);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap, java.util.SortedMap
    public ConcurrentNavigableMap<K, V> headMap(K k) {
        return headMap((ConcurrentSkipListMap<K, V>) k, false);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> headMap(K k, boolean z) {
        if (k == null) {
            throw new NullPointerException();
        }
        return new SubMap(this, null, false, k, z, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        return getNear(k, 0);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        Node<K, V> findNear = findNear(k, 0);
        if (findNear == null) {
            return null;
        }
        return findNear.key;
    }

    boolean inHalfOpenRange(K k, K k2, K k3) {
        if (k == null) {
            throw new NullPointerException();
        }
        if (k2 == null || compare(k, k2) >= 0) {
            return k3 == null || compare(k, k3) < 0;
        }
        return false;
    }

    boolean inOpenRange(K k, K k2, K k3) {
        if (k == null) {
            throw new NullPointerException();
        }
        if (k2 == null || compare(k, k2) >= 0) {
            return k3 == null || compare(k, k3) <= 0;
        }
        return false;
    }

    final void initialize() {
        this.keySet = null;
        this.entrySet = null;
        this.values = null;
        this.descendingMap = null;
        this.randomSeed = seedGenerator.nextInt() | 256;
        this.head = new HeadIndex<>(new Node(null, BASE_HEADER, null), null, null, 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return findFirst() == null;
    }

    Iterator<K> keyIterator() {
        return new KeyIterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public NavigableSet<K> keySet() {
        KeySet<K> keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        KeySet<K> keySet2 = new KeySet<>(this);
        this.keySet = keySet2;
        return keySet2;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        AbstractMap.SimpleImmutableEntry<K, V> createSnapshot;
        do {
            Node<K, V> findLast = findLast();
            if (findLast == null) {
                return null;
            }
            createSnapshot = findLast.createSnapshot();
        } while (createSnapshot == null);
        return createSnapshot;
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Node<K, V> findLast = findLast();
        if (findLast == null) {
            throw new NoSuchElementException();
        }
        return findLast.key;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        return getNear(k, 2);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        Node<K, V> findNear = findNear(k, 2);
        if (findNear == null) {
            return null;
        }
        return findNear.key;
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        KeySet<K> keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        KeySet<K> keySet2 = new KeySet<>(this);
        this.keySet = keySet2;
        return keySet2;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return doRemoveFirstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return doRemoveLastEntry();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (v == null) {
            throw new NullPointerException();
        }
        return doPut(k, v, false);
    }

    @Override // java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        if (v == null) {
            throw new NullPointerException();
        }
        return doPut(k, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return doRemove(obj, null);
    }

    @Override // java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return (obj2 == null || doRemove(obj, obj2) == null) ? false : true;
    }

    @Override // java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        if (v == null) {
            throw new NullPointerException();
        }
        Comparable<? super K> comparable = comparable(k);
        while (true) {
            Node<K, V> findNode = findNode(comparable);
            if (findNode == null) {
                return null;
            }
            V v2 = (V) findNode.value;
            if (v2 != null && findNode.casValue(v2, v)) {
                return v2;
            }
        }
    }

    @Override // java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v2) {
        if (v == null || v2 == null) {
            throw new NullPointerException();
        }
        Comparable<? super K> comparable = comparable(k);
        while (true) {
            Node<K, V> findNode = findNode(comparable);
            if (findNode == null) {
                return false;
            }
            Object obj = findNode.value;
            if (obj != null) {
                if (!v.equals(obj)) {
                    return false;
                }
                if (findNode.casValue(obj, v2)) {
                    return true;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j = 0;
        Node<K, V> findFirst = findFirst();
        while (findFirst != null) {
            long j2 = j;
            if (findFirst.getValidValue() != null) {
                j2 = j + 1;
            }
            findFirst = findFirst.next;
            j = j2;
        }
        if (j >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return subMap((boolean) obj, z, (boolean) obj2, z2);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ConcurrentNavigableMap<K, V> subMap(K k, K k2) {
        return subMap((boolean) k, true, (boolean) k2, false);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        if (k == null || k2 == null) {
            throw new NullPointerException();
        }
        return new SubMap(this, k, z, k2, z2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object obj, boolean z) {
        return tailMap((ConcurrentSkipListMap<K, V>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap((ConcurrentSkipListMap<K, V>) obj);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap, java.util.SortedMap
    public ConcurrentNavigableMap<K, V> tailMap(K k) {
        return tailMap((ConcurrentSkipListMap<K, V>) k, true);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> tailMap(K k, boolean z) {
        if (k == null) {
            throw new NullPointerException();
        }
        return new SubMap(this, k, z, null, false, false);
    }

    Iterator<V> valueIterator() {
        return new ValueIterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Values<V> values = this.values;
        if (values != null) {
            return values;
        }
        Values<V> values2 = new Values<>(this);
        this.values = values2;
        return values2;
    }
}
