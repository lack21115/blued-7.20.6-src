package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap.class */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    private static final long ABASE = 0;
    private static final int ASHIFT = 0;
    private static final long BASECOUNT = 0;
    private static final long CELLSBUSY = 0;
    private static final long CELLVALUE = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1879048193;
    static final int NCPU = 0;
    static final int RESERVED = -2147483647;
    static final int SEED_INCREMENT = 1640531527;
    private static final long SIZECTL = 0;
    private static final long TRANSFERINDEX = 0;
    private static final long TRANSFERORIGIN = 0;
    static final int TREEBIN = Integer.MIN_VALUE;
    static final int TREEIFY_THRESHOLD = 8;
    private static final Unsafe U = null;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final AtomicInteger counterHashCodeGenerator = null;
    private static final ObjectStreamField[] serialPersistentFields = null;
    private static final long serialVersionUID = 7249069246763182397L;
    static final ThreadLocal<CounterHashCode> threadCounterHashCode = null;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient CounterCell[] counterCells;
    private transient EntrySetView<K, V> entrySet;
    private transient KeySetView<K, V> keySet;
    private volatile transient Node<K, V>[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient Node<K, V>[] table;
    private volatile transient int transferIndex;
    private volatile transient int transferOrigin;
    private transient ValuesView<K, V> values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$BaseIterator.class */
    public static class BaseIterator<K, V> extends Traverser<K, V> {
        Node<K, V> lastReturned;
        final ConcurrentHashMap<K, V> map;

        BaseIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMap<K, V> concurrentHashMap) {
            super(nodeArr, i, i2, i3);
            this.map = concurrentHashMap;
            advance();
        }

        public final boolean hasMoreElements() {
            return this.next != null;
        }

        public final boolean hasNext() {
            return this.next != null;
        }

        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.lastReturned = null;
            this.map.replaceNode(node.key, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$CollectionView.class */
    public static abstract class CollectionView<K, V, E> implements Collection<E>, Serializable {
        private static final String oomeMsg = "Required array size too large";
        private static final long serialVersionUID = 7249069246763182397L;
        final ConcurrentHashMap<K, V> map;

        CollectionView(ConcurrentHashMap<K, V> concurrentHashMap) {
            this.map = concurrentHashMap;
        }

        @Override // java.util.Collection
        public final void clear() {
            this.map.clear();
        }

        @Override // java.util.Collection
        public abstract boolean contains(Object obj);

        /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
        @Override // java.util.Collection
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean containsAll(java.util.Collection<?> r4) {
            /*
                r3 = this;
                r0 = r4
                r1 = r3
                if (r0 == r1) goto L2a
                r0 = r4
                java.util.Iterator r0 = r0.iterator()
                r4 = r0
            Lc:
                r0 = r4
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L2a
                r0 = r4
                java.lang.Object r0 = r0.next()
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L28
                r0 = r3
                r1 = r5
                boolean r0 = r0.contains(r1)
                if (r0 != 0) goto Lc
            L28:
                r0 = 0
                return r0
            L2a:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.CollectionView.containsAll(java.util.Collection):boolean");
        }

        public ConcurrentHashMap<K, V> getMap() {
            return this.map;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public abstract Iterator<E> iterator();

        @Override // java.util.Collection
        public abstract boolean remove(Object obj);

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            boolean z = false;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            boolean z = false;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            long mappingCount = this.map.mappingCount();
            if (mappingCount > 2147483639) {
                throw new OutOfMemoryError(oomeMsg);
            }
            int i = (int) mappingCount;
            Object[] objArr = new Object[i];
            int i2 = 0;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                E next = it.next();
                int i3 = i;
                Object[] objArr2 = objArr;
                if (i2 == i) {
                    if (i >= ConcurrentHashMap.MAX_ARRAY_SIZE) {
                        throw new OutOfMemoryError(oomeMsg);
                    }
                    int i4 = i >= 1073741819 ? ConcurrentHashMap.MAX_ARRAY_SIZE : i + (i >>> 1) + 1;
                    objArr2 = Arrays.copyOf(objArr, i4);
                    i3 = i4;
                }
                objArr2[i2] = next;
                i2++;
                i = i3;
                objArr = objArr2;
            }
            return i2 == i ? objArr : Arrays.copyOf(objArr, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r0v45, types: [java.lang.Object[]] */
        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            long mappingCount = this.map.mappingCount();
            if (mappingCount > 2147483639) {
                throw new OutOfMemoryError(oomeMsg);
            }
            int i = (int) mappingCount;
            T[] tArr2 = tArr.length >= i ? tArr : (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            int length = tArr2.length;
            int i2 = 0;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                E next = it.next();
                int i3 = length;
                T[] tArr3 = tArr2;
                if (i2 == length) {
                    if (length >= ConcurrentHashMap.MAX_ARRAY_SIZE) {
                        throw new OutOfMemoryError(oomeMsg);
                    }
                    int i4 = length >= 1073741819 ? ConcurrentHashMap.MAX_ARRAY_SIZE : length + (length >>> 1) + 1;
                    tArr3 = Arrays.copyOf(tArr2, i4);
                    i3 = i4;
                }
                tArr3[i2] = next;
                i2++;
                length = i3;
                tArr2 = tArr3;
            }
            if (tArr == tArr2 && i2 < length) {
                tArr2[i2] = null;
            } else if (i2 != length) {
                return (T[]) Arrays.copyOf(tArr2, i2);
            }
            return tArr2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Iterator<E> it = iterator();
            if (it.hasNext()) {
                while (true) {
                    E next = it.next();
                    E e = next;
                    if (next == this) {
                        e = "(this Collection)";
                    }
                    sb.append(e);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(',').append(' ');
                }
            }
            return sb.append(']').toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$CounterCell.class */
    public static final class CounterCell {
        volatile long p0;
        volatile long p1;
        volatile long p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;
        volatile long q0;
        volatile long q1;
        volatile long q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        volatile long value;

        CounterCell(long j) {
            this.value = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$CounterHashCode.class */
    public static final class CounterHashCode {
        int code;

        CounterHashCode() {
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$EntryIterator.class */
    static final class EntryIterator<K, V> extends BaseIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        EntryIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMap<K, V> concurrentHashMap) {
            super(nodeArr, i, i2, i3, concurrentHashMap);
        }

        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            Node<K, V> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            K k = node.key;
            V v = node.val;
            this.lastReturned = node;
            advance();
            return new MapEntry(k, v, this.map);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$EntrySetView.class */
    static final class EntrySetView<K, V> extends CollectionView<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>>, Serializable {
        private static final long serialVersionUID = 2249069246763182397L;

        EntrySetView(ConcurrentHashMap<K, V> concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        public boolean add(Map.Entry<K, V> entry) {
            boolean z = false;
            if (this.map.putVal(entry.getKey(), entry.getValue(), false) == null) {
                z = true;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            boolean z = false;
            for (Map.Entry<K, V> entry : collection) {
                if (add((Map.Entry) entry)) {
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            V v;
            Object value;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (v = this.map.get(key)) == null || (value = entry.getValue()) == null) {
                return false;
            }
            return value == v || value.equals(v);
        }

        @Override // java.util.Collection
        public final boolean equals(Object obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                if (set != this) {
                    return containsAll(set) && set.containsAll(this);
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public final int hashCode() {
            int i = 0;
            int i2 = 0;
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    i = i2;
                    if (advance == null) {
                        break;
                    }
                    i2 += advance.hashCode();
                }
            }
            return i;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            ConcurrentHashMap<K, V> concurrentHashMap = this.map;
            Node<K, V>[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntryIterator(nodeArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.map.remove(key, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$ForwardingNode.class */
    public static final class ForwardingNode<K, V> extends Node<K, V> {
        final Node<K, V>[] nextTable;

        ForwardingNode(Node<K, V>[] nodeArr) {
            super(ConcurrentHashMap.MOVED, null, null, null);
            this.nextTable = nodeArr;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.Node
        Node<K, V> find(int i, Object obj) {
            int length;
            Node<K, V> node;
            K k;
            Node<K, V>[] nodeArr = this.nextTable;
            if (obj == null || nodeArr == null || (length = nodeArr.length) <= 0) {
                return null;
            }
            Node<K, V> tabAt = ConcurrentHashMap.tabAt(nodeArr, (length - 1) & i);
            if (tabAt != null) {
                do {
                    int i2 = tabAt.hash;
                    if (i2 == i && ((k = tabAt.key) == obj || (k != null && obj.equals(k)))) {
                        return tabAt;
                    }
                    if (i2 < 0) {
                        return tabAt.find(i, obj);
                    }
                    node = tabAt.next;
                    tabAt = node;
                } while (node != null);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$KeyIterator.class */
    public static final class KeyIterator<K, V> extends BaseIterator<K, V> implements Iterator<K>, Enumeration<K> {
        KeyIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMap<K, V> concurrentHashMap) {
            super(nodeArr, i, i2, i3, concurrentHashMap);
        }

        @Override // java.util.Iterator
        public final K next() {
            Node<K, V> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            K k = node.key;
            this.lastReturned = node;
            advance();
            return k;
        }

        @Override // java.util.Enumeration
        public final K nextElement() {
            return next();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$KeySetView.class */
    public static class KeySetView<K, V> extends CollectionView<K, V, K> implements Set<K>, Serializable {
        private static final long serialVersionUID = 7249069246763182397L;
        private final V value;

        KeySetView(ConcurrentHashMap<K, V> concurrentHashMap, V v) {
            super(concurrentHashMap);
            this.value = v;
        }

        @Override // java.util.Collection
        public boolean add(K k) {
            V v = this.value;
            if (v == null) {
                throw new UnsupportedOperationException();
            }
            return this.map.putVal(k, v, true) == null;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            boolean z = false;
            V v = this.value;
            if (v == null) {
                throw new UnsupportedOperationException();
            }
            for (K k : collection) {
                if (this.map.putVal(k, v, true) == null) {
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                if (set != this) {
                    return containsAll(set) && set.containsAll(this);
                }
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView
        public /* bridge */ /* synthetic */ ConcurrentHashMap getMap() {
            return super.getMap();
        }

        public V getMappedValue() {
            return this.value;
        }

        @Override // java.util.Collection
        public int hashCode() {
            int i = 0;
            Iterator<K> it = iterator();
            while (it.hasNext()) {
                i += it.next().hashCode();
            }
            return i;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            ConcurrentHashMap<K, V> concurrentHashMap = this.map;
            Node<K, V>[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeyIterator(nodeArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$MapEntry.class */
    public static final class MapEntry<K, V> implements Map.Entry<K, V> {
        final K key;
        final ConcurrentHashMap<K, V> map;
        V val;

        MapEntry(K k, V v, ConcurrentHashMap<K, V> concurrentHashMap) {
            this.key = k;
            this.val = v;
            this.map = concurrentHashMap;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
                return false;
            }
            if (key == this.key || key.equals(this.key)) {
                return value == this.val || value.equals(this.val);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (v == null) {
                throw new NullPointerException();
            }
            V v2 = this.val;
            this.val = v;
            this.map.put(this.key, v);
            return v2;
        }

        public String toString() {
            return this.key + "=" + this.val;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$Node.class */
    public static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        Node<K, V> next;
        volatile V val;

        Node(int i, K k, V v, Node<K, V> node) {
            this.hash = i;
            this.key = k;
            this.val = v;
            this.next = node;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
                return false;
            }
            if (key == this.key || key.equals(this.key)) {
                V v = this.val;
                return value == v || value.equals(v);
            }
            return false;
        }

        Node<K, V> find(int i, Object obj) {
            Node<K, V> node;
            K k;
            Node<K, V> node2 = this;
            if (obj != null) {
                do {
                    if (node2.hash == i && ((k = node2.key) == obj || (k != null && obj.equals(k)))) {
                        return node2;
                    }
                    node = node2.next;
                    node2 = node;
                } while (node != null);
                return null;
            }
            return null;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            return this.key + "=" + this.val;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$ReservationNode.class */
    static final class ReservationNode<K, V> extends Node<K, V> {
        ReservationNode() {
            super(ConcurrentHashMap.RESERVED, null, null, null);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.Node
        Node<K, V> find(int i, Object obj) {
            return null;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$Segment.class */
    static class Segment<K, V> extends ReentrantLock implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;

        Segment(float f) {
            this.loadFactor = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$Traverser.class */
    public static class Traverser<K, V> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int index;
        Node<K, V> next = null;
        Node<K, V>[] tab;

        Traverser(Node<K, V>[] nodeArr, int i, int i2, int i3) {
            this.tab = nodeArr;
            this.baseSize = i;
            this.index = i2;
            this.baseIndex = i2;
            this.baseLimit = i3;
        }

        final Node<K, V> advance() {
            Node<K, V>[] nodeArr;
            int length;
            int i;
            Node<K, V> node = this.next;
            Node<K, V> node2 = node;
            if (node != null) {
                node2 = node.next;
            }
            while (node2 == null) {
                if (this.baseIndex >= this.baseLimit || (nodeArr = this.tab) == null || (length = nodeArr.length) <= (i = this.index) || i < 0) {
                    this.next = null;
                    return null;
                }
                Node<K, V> tabAt = ConcurrentHashMap.tabAt(nodeArr, this.index);
                TreeNode<K, V> treeNode = tabAt;
                if (tabAt != null) {
                    treeNode = tabAt;
                    if (tabAt.hash < 0) {
                        if (tabAt instanceof ForwardingNode) {
                            this.tab = ((ForwardingNode) tabAt).nextTable;
                            node2 = null;
                        } else {
                            treeNode = tabAt instanceof TreeBin ? ((TreeBin) tabAt).first : null;
                        }
                    }
                }
                int i2 = this.index + this.baseSize;
                this.index = i2;
                node2 = treeNode;
                if (i2 >= length) {
                    int i3 = this.baseIndex + 1;
                    this.baseIndex = i3;
                    this.index = i3;
                    node2 = treeNode;
                }
            }
            this.next = node2;
            return node2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$TreeBin.class */
    public static final class TreeBin<K, V> extends Node<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final long LOCKSTATE;
        static final int READER = 4;
        private static final Unsafe U;
        static final int WAITER = 2;
        static final int WRITER = 1;
        volatile TreeNode<K, V> first;
        volatile int lockState;
        TreeNode<K, V> root;
        volatile Thread waiter;

        static {
            $assertionsDisabled = !ConcurrentHashMap.class.desiredAssertionStatus();
            try {
                U = Unsafe.getUnsafe();
                LOCKSTATE = U.objectFieldOffset(TreeBin.class.getDeclaredField("lockState"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        TreeBin(TreeNode<K, V> treeNode) {
            super(Integer.MIN_VALUE, null, null, null);
            TreeNode<K, V> treeNode2;
            int compareComparables;
            TreeNode<K, V> treeNode3;
            TreeNode<K, V> balanceInsertion;
            this.first = treeNode;
            TreeNode<K, V> treeNode4 = treeNode;
            TreeNode<K, V> treeNode5 = null;
            while (treeNode4 != null) {
                TreeNode<K, V> treeNode6 = (TreeNode) treeNode4.next;
                treeNode4.right = null;
                treeNode4.left = null;
                if (treeNode5 == null) {
                    treeNode4.parent = null;
                    treeNode4.red = false;
                    balanceInsertion = treeNode4;
                } else {
                    K k = treeNode4.key;
                    int i = treeNode4.hash;
                    Class<?> cls = null;
                    TreeNode<K, V> treeNode7 = treeNode5;
                    do {
                        treeNode2 = treeNode7;
                        int i2 = treeNode2.hash;
                        if (i2 > i) {
                            compareComparables = -1;
                        } else if (i2 < i) {
                            compareComparables = 1;
                        } else {
                            Class<?> cls2 = cls;
                            if (cls == null) {
                                cls = ConcurrentHashMap.comparableClassFor(k);
                                if (cls != null) {
                                    cls2 = cls;
                                } else {
                                    compareComparables = 0;
                                }
                            }
                            compareComparables = ConcurrentHashMap.compareComparables(cls2, k, treeNode2.key);
                            cls = cls2;
                        }
                        treeNode3 = compareComparables <= 0 ? treeNode2.left : treeNode2.right;
                        treeNode7 = treeNode3;
                    } while (treeNode3 != null);
                    treeNode4.parent = treeNode2;
                    if (compareComparables <= 0) {
                        treeNode2.left = treeNode4;
                    } else {
                        treeNode2.right = treeNode4;
                    }
                    balanceInsertion = balanceInsertion(treeNode5, treeNode4);
                }
                treeNode5 = balanceInsertion;
                treeNode4 = treeNode6;
            }
            this.root = treeNode5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00df, code lost:
            if (r0.red == false) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x01f1, code lost:
            if (r0.red == false) goto L47;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static <K, V> java.util.concurrent.ConcurrentHashMap.TreeNode<K, V> balanceDeletion(java.util.concurrent.ConcurrentHashMap.TreeNode<K, V> r3, java.util.concurrent.ConcurrentHashMap.TreeNode<K, V> r4) {
            /*
                Method dump skipped, instructions count: 611
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.TreeBin.balanceDeletion(java.util.concurrent.ConcurrentHashMap$TreeNode, java.util.concurrent.ConcurrentHashMap$TreeNode):java.util.concurrent.ConcurrentHashMap$TreeNode");
        }

        static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            treeNode2.red = true;
            while (true) {
                TreeNode<K, V> treeNode3 = treeNode2.parent;
                if (treeNode3 != null) {
                    if (!treeNode3.red) {
                        break;
                    }
                    TreeNode<K, V> treeNode4 = treeNode3.parent;
                    if (treeNode4 == null) {
                        break;
                    }
                    TreeNode<K, V> treeNode5 = treeNode4.left;
                    if (treeNode3 == treeNode5) {
                        TreeNode<K, V> treeNode6 = treeNode4.right;
                        if (treeNode6 == null || !treeNode6.red) {
                            TreeNode<K, V> treeNode7 = treeNode3;
                            TreeNode<K, V> treeNode8 = treeNode;
                            TreeNode<K, V> treeNode9 = treeNode2;
                            if (treeNode2 == treeNode3.right) {
                                treeNode9 = treeNode3;
                                treeNode8 = rotateLeft(treeNode, treeNode3);
                                treeNode7 = treeNode9.parent;
                                treeNode4 = treeNode7 == null ? null : treeNode7.parent;
                            }
                            treeNode = treeNode8;
                            treeNode2 = treeNode9;
                            if (treeNode7 != null) {
                                treeNode7.red = false;
                                treeNode = treeNode8;
                                treeNode2 = treeNode9;
                                if (treeNode4 != null) {
                                    treeNode4.red = true;
                                    treeNode = rotateRight(treeNode8, treeNode4);
                                    treeNode2 = treeNode9;
                                }
                            }
                        } else {
                            treeNode6.red = false;
                            treeNode3.red = false;
                            treeNode4.red = true;
                            treeNode2 = treeNode4;
                        }
                    } else if (treeNode5 == null || !treeNode5.red) {
                        TreeNode<K, V> treeNode10 = treeNode3;
                        TreeNode<K, V> treeNode11 = treeNode;
                        TreeNode<K, V> treeNode12 = treeNode2;
                        if (treeNode2 == treeNode3.left) {
                            treeNode12 = treeNode3;
                            treeNode11 = rotateRight(treeNode, treeNode3);
                            treeNode10 = treeNode12.parent;
                            treeNode4 = treeNode10 == null ? null : treeNode10.parent;
                        }
                        treeNode = treeNode11;
                        treeNode2 = treeNode12;
                        if (treeNode10 != null) {
                            treeNode10.red = false;
                            treeNode = treeNode11;
                            treeNode2 = treeNode12;
                            if (treeNode4 != null) {
                                treeNode4.red = true;
                                treeNode = rotateLeft(treeNode11, treeNode4);
                                treeNode2 = treeNode12;
                            }
                        }
                    } else {
                        treeNode5.red = false;
                        treeNode3.red = false;
                        treeNode4.red = true;
                        treeNode2 = treeNode4;
                    }
                } else {
                    treeNode2.red = false;
                    return treeNode2;
                }
            }
            return treeNode;
        }

        static <K, V> boolean checkInvariants(TreeNode<K, V> treeNode) {
            TreeNode<K, V> treeNode2 = treeNode.parent;
            TreeNode<K, V> treeNode3 = treeNode.left;
            TreeNode<K, V> treeNode4 = treeNode.right;
            TreeNode<K, V> treeNode5 = treeNode.prev;
            TreeNode treeNode6 = (TreeNode) treeNode.next;
            if (treeNode5 == null || treeNode5.next == treeNode) {
                if (treeNode6 == null || treeNode6.prev == treeNode) {
                    if (treeNode2 == null || treeNode == treeNode2.left || treeNode == treeNode2.right) {
                        if (treeNode3 == null || (treeNode3.parent == treeNode && treeNode3.hash <= treeNode.hash)) {
                            if (treeNode4 == null || (treeNode4.parent == treeNode && treeNode4.hash >= treeNode.hash)) {
                                if (treeNode.red && treeNode3 != null && treeNode3.red && treeNode4 != null && treeNode4.red) {
                                    return false;
                                }
                                if (treeNode3 == null || checkInvariants(treeNode3)) {
                                    return treeNode4 == null || checkInvariants(treeNode4);
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private final void contendedLock() {
            boolean z = false;
            while (true) {
                int i = this.lockState;
                if ((i & 1) == 0) {
                    if (U.compareAndSwapInt(this, LOCKSTATE, i, 1)) {
                        break;
                    }
                } else if ((i & 2) == 0) {
                    if (U.compareAndSwapInt(this, LOCKSTATE, i, i | 2)) {
                        z = true;
                        this.waiter = Thread.currentThread();
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.waiter = null;
            }
        }

        private final void lockRoot() {
            if (U.compareAndSwapInt(this, LOCKSTATE, 0, 1)) {
                return;
            }
            contendedLock();
        }

        static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3 = treeNode;
            if (treeNode2 != null) {
                TreeNode<K, V> treeNode4 = treeNode2.right;
                treeNode3 = treeNode;
                if (treeNode4 != null) {
                    TreeNode<K, V> treeNode5 = treeNode4.left;
                    treeNode2.right = treeNode5;
                    if (treeNode5 != null) {
                        treeNode5.parent = treeNode2;
                    }
                    TreeNode<K, V> treeNode6 = treeNode2.parent;
                    treeNode4.parent = treeNode6;
                    if (treeNode6 == null) {
                        treeNode = treeNode4;
                        treeNode4.red = false;
                    } else if (treeNode6.left == treeNode2) {
                        treeNode6.left = treeNode4;
                    } else {
                        treeNode6.right = treeNode4;
                    }
                    treeNode4.left = treeNode2;
                    treeNode2.parent = treeNode4;
                    treeNode3 = treeNode;
                }
            }
            return treeNode3;
        }

        static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3 = treeNode;
            if (treeNode2 != null) {
                TreeNode<K, V> treeNode4 = treeNode2.left;
                treeNode3 = treeNode;
                if (treeNode4 != null) {
                    TreeNode<K, V> treeNode5 = treeNode4.right;
                    treeNode2.left = treeNode5;
                    if (treeNode5 != null) {
                        treeNode5.parent = treeNode2;
                    }
                    TreeNode<K, V> treeNode6 = treeNode2.parent;
                    treeNode4.parent = treeNode6;
                    if (treeNode6 == null) {
                        treeNode = treeNode4;
                        treeNode4.red = false;
                    } else if (treeNode6.right == treeNode2) {
                        treeNode6.right = treeNode4;
                    } else {
                        treeNode6.left = treeNode4;
                    }
                    treeNode4.right = treeNode2;
                    treeNode2.parent = treeNode4;
                    treeNode3 = treeNode;
                }
            }
            return treeNode3;
        }

        private final void unlockRoot() {
            this.lockState = 0;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.Node
        final Node<K, V> find(int i, Object obj) {
            Node<K, V> node;
            Unsafe unsafe;
            long j;
            int i2;
            Thread thread;
            Unsafe unsafe2;
            long j2;
            int i3;
            Thread thread2;
            K k;
            if (obj != null) {
                Node<K, V> node2 = this.first;
                while (true) {
                    node = node2;
                    if (node == null) {
                        return null;
                    }
                    int i4 = this.lockState;
                    if ((i4 & 3) != 0) {
                        if (node.hash == i && ((k = node.key) == obj || (k != null && obj.equals(k)))) {
                            break;
                        }
                    } else if (U.compareAndSwapInt(this, LOCKSTATE, i4, i4 + 4)) {
                        try {
                            TreeNode<K, V> treeNode = this.root;
                            TreeNode<K, V> findTreeNode = treeNode == null ? null : treeNode.findTreeNode(i, obj, null);
                            do {
                                unsafe2 = U;
                                j2 = LOCKSTATE;
                                i3 = this.lockState;
                            } while (!unsafe2.compareAndSwapInt(this, j2, i3, i3 - 4));
                            if (i3 == 6 && (thread2 = this.waiter) != null) {
                                LockSupport.unpark(thread2);
                            }
                            return findTreeNode;
                        } catch (Throwable th) {
                            do {
                                unsafe = U;
                                j = LOCKSTATE;
                                i2 = this.lockState;
                            } while (!unsafe.compareAndSwapInt(this, j, i2, i2 - 4));
                            if (i2 == 6 && (thread = this.waiter) != null) {
                                LockSupport.unpark(thread);
                            }
                            throw th;
                        }
                    }
                    node2 = node.next;
                }
                return node;
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0104, code lost:
            if (r0 == 0) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0174, code lost:
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
            if (java.util.concurrent.ConcurrentHashMap.TreeBin.$assertionsDisabled != false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
            if (checkInvariants(r8.root) != false) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.concurrent.ConcurrentHashMap.TreeNode<K, V> putTreeVal(int r9, K r10, V r11) {
            /*
                Method dump skipped, instructions count: 374
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.TreeBin.putTreeVal(int, java.lang.Object, java.lang.Object):java.util.concurrent.ConcurrentHashMap$TreeNode");
        }

        final boolean removeTreeNode(TreeNode<K, V> treeNode) {
            TreeNode<K, V> treeNode2;
            TreeNode<K, V> treeNode3;
            TreeNode<K, V> treeNode4;
            TreeNode<K, V> treeNode5;
            TreeNode<K, V> treeNode6 = (TreeNode) treeNode.next;
            TreeNode<K, V> treeNode7 = treeNode.prev;
            if (treeNode7 == null) {
                this.first = treeNode6;
            } else {
                treeNode7.next = treeNode6;
            }
            if (treeNode6 != null) {
                treeNode6.prev = treeNode7;
            }
            if (this.first == null) {
                this.root = null;
                return true;
            }
            TreeNode<K, V> treeNode8 = this.root;
            if (treeNode8 == null || treeNode8.right == null || (treeNode2 = treeNode8.left) == null || treeNode2.left == null) {
                return true;
            }
            lockRoot();
            try {
                TreeNode<K, V> treeNode9 = treeNode.left;
                TreeNode<K, V> treeNode10 = treeNode.right;
                if (treeNode9 == null || treeNode10 == null) {
                    treeNode3 = treeNode9 != null ? treeNode9 : treeNode10 != null ? treeNode10 : treeNode;
                } else {
                    TreeNode<K, V> treeNode11 = treeNode10;
                    while (true) {
                        treeNode5 = treeNode11;
                        TreeNode<K, V> treeNode12 = treeNode5.left;
                        if (treeNode12 == null) {
                            break;
                        }
                        treeNode11 = treeNode12;
                    }
                    boolean z = treeNode5.red;
                    treeNode5.red = treeNode.red;
                    treeNode.red = z;
                    TreeNode<K, V> treeNode13 = treeNode5.right;
                    TreeNode<K, V> treeNode14 = treeNode.parent;
                    if (treeNode5 == treeNode10) {
                        treeNode.parent = treeNode5;
                        treeNode5.right = treeNode;
                    } else {
                        TreeNode<K, V> treeNode15 = treeNode5.parent;
                        treeNode.parent = treeNode15;
                        if (treeNode15 != null) {
                            if (treeNode5 == treeNode15.left) {
                                treeNode15.left = treeNode;
                            } else {
                                treeNode15.right = treeNode;
                            }
                        }
                        treeNode5.right = treeNode10;
                        if (treeNode10 != null) {
                            treeNode10.parent = treeNode5;
                        }
                    }
                    treeNode.left = null;
                    treeNode.right = treeNode13;
                    if (treeNode13 != null) {
                        treeNode13.parent = treeNode;
                    }
                    treeNode5.left = treeNode9;
                    if (treeNode9 != null) {
                        treeNode9.parent = treeNode5;
                    }
                    treeNode5.parent = treeNode14;
                    if (treeNode14 == null) {
                        treeNode8 = treeNode5;
                    } else if (treeNode == treeNode14.left) {
                        treeNode14.left = treeNode5;
                    } else {
                        treeNode14.right = treeNode5;
                    }
                    treeNode3 = treeNode13 != null ? treeNode13 : treeNode;
                }
                TreeNode<K, V> treeNode16 = treeNode8;
                if (treeNode3 != treeNode) {
                    TreeNode<K, V> treeNode17 = treeNode.parent;
                    treeNode3.parent = treeNode17;
                    if (treeNode17 == null) {
                        treeNode8 = treeNode3;
                    } else if (treeNode == treeNode17.left) {
                        treeNode17.left = treeNode3;
                    } else {
                        treeNode17.right = treeNode3;
                    }
                    treeNode.parent = null;
                    treeNode.right = null;
                    treeNode.left = null;
                    treeNode16 = treeNode8;
                }
                if (!treeNode.red) {
                    treeNode16 = balanceDeletion(treeNode16, treeNode3);
                }
                this.root = treeNode16;
                if (treeNode == treeNode3 && (treeNode4 = treeNode.parent) != null) {
                    if (treeNode == treeNode4.left) {
                        treeNode4.left = null;
                    } else if (treeNode == treeNode4.right) {
                        treeNode4.right = null;
                    }
                    treeNode.parent = null;
                }
                unlockRoot();
                if ($assertionsDisabled || checkInvariants(this.root)) {
                    return false;
                }
                throw new AssertionError();
            } catch (Throwable th) {
                unlockRoot();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$TreeNode.class */
    public static final class TreeNode<K, V> extends Node<K, V> {
        TreeNode<K, V> left;
        TreeNode<K, V> parent;
        TreeNode<K, V> prev;
        boolean red;
        TreeNode<K, V> right;

        TreeNode(int i, K k, V v, Node<K, V> node, TreeNode<K, V> treeNode) {
            super(i, k, v, node);
            this.parent = treeNode;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.Node
        Node<K, V> find(int i, Object obj) {
            return findTreeNode(i, obj, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
            if (r10 != null) goto L43;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.concurrent.ConcurrentHashMap.TreeNode<K, V> findTreeNode(int r6, java.lang.Object r7, java.lang.Class<?> r8) {
            /*
                Method dump skipped, instructions count: 215
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.TreeNode.findTreeNode(int, java.lang.Object, java.lang.Class):java.util.concurrent.ConcurrentHashMap$TreeNode");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$ValueIterator.class */
    public static final class ValueIterator<K, V> extends BaseIterator<K, V> implements Iterator<V>, Enumeration<V> {
        ValueIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMap<K, V> concurrentHashMap) {
            super(nodeArr, i, i2, i3, concurrentHashMap);
        }

        @Override // java.util.Iterator
        public final V next() {
            Node<K, V> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            V v = node.val;
            this.lastReturned = node;
            advance();
            return v;
        }

        @Override // java.util.Enumeration
        public final V nextElement() {
            return next();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentHashMap$ValuesView.class */
    static final class ValuesView<K, V> extends CollectionView<K, V, V> implements Collection<V>, Serializable {
        private static final long serialVersionUID = 2249069246763182397L;

        ValuesView(ConcurrentHashMap<K, V> concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection
        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean contains(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            ConcurrentHashMap<K, V> concurrentHashMap = this.map;
            Node<K, V>[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new ValueIterator(nodeArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean remove(Object obj) {
            if (obj != null) {
                Iterator<V> it = iterator();
                while (it.hasNext()) {
                    if (obj.equals(it.next())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    static {
        Runtime.getRuntime();
        throw new VerifyError("bad dex opcode");
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.sizeCtl = i >= 536870912 ? 1073741824 : tableSizeFor((i >>> 1) + i + 1);
    }

    public ConcurrentHashMap(int i, float f) {
        this(i, f, 1);
    }

    public ConcurrentHashMap(int i, float f, int i2) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        long j = (long) (1.0d + ((i < i2 ? i2 : i) / f));
        this.sizeCtl = j >= 1073741824 ? 1073741824 : tableSizeFor((int) j);
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0031, code lost:
        if (r0.compareAndSwapLong(r11, r0, r0, r0) == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addCount(long r12, int r14) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.addCount(long, int):void");
    }

    static final <K, V> boolean casTabAt(Node<K, V>[] nodeArr, int i, Node<K, V> node, Node<K, V> node2) {
        return U.compareAndSwapObject(nodeArr, (i << ASHIFT) + ABASE, node, node2);
    }

    static Class<?> comparableClassFor(Object obj) {
        Type[] actualTypeArguments;
        if (obj instanceof Comparable) {
            Class<?> cls = obj.getClass();
            if (cls != String.class) {
                Type[] genericInterfaces = cls.getGenericInterfaces();
                if (genericInterfaces == null) {
                    return null;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= genericInterfaces.length) {
                        return null;
                    }
                    Type type = genericInterfaces[i2];
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                            break;
                        }
                    }
                    i = i2 + 1;
                }
            }
            return cls;
        }
        return null;
    }

    static int compareComparables(Class<?> cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    private final void fullAddCount(long j, CounterHashCode counterHashCode, boolean z) {
        int i;
        int length;
        boolean z2;
        boolean z3;
        if (counterHashCode == null) {
            counterHashCode = new CounterHashCode();
            i = counterHashCodeGenerator.addAndGet(SEED_INCREMENT);
            if (i == 0) {
                i = 1;
            }
            counterHashCode.code = i;
            threadCounterHashCode.set(counterHashCode);
        } else {
            i = counterHashCode.code;
        }
        boolean z4 = false;
        int i2 = i;
        while (true) {
            CounterCell[] counterCellArr = this.counterCells;
            if (counterCellArr != null && (length = counterCellArr.length) > 0) {
                CounterCell counterCell = counterCellArr[(length - 1) & i2];
                if (counterCell == null) {
                    if (this.cellsBusy == 0) {
                        CounterCell counterCell2 = new CounterCell(j);
                        if (this.cellsBusy == 0 && U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                            try {
                                CounterCell[] counterCellArr2 = this.counterCells;
                                boolean z5 = false;
                                if (counterCellArr2 != null) {
                                    int length2 = counterCellArr2.length;
                                    z5 = false;
                                    if (length2 > 0) {
                                        int i3 = (length2 - 1) & i2;
                                        z5 = false;
                                        if (counterCellArr2[i3] == null) {
                                            counterCellArr2[i3] = counterCell2;
                                            z5 = true;
                                        }
                                    }
                                }
                                this.cellsBusy = 0;
                                if (z5) {
                                    break;
                                }
                            } finally {
                            }
                        }
                    }
                    z2 = false;
                    z3 = z;
                    int i4 = i2 ^ (i2 << 13);
                    int i5 = i4 ^ (i4 >>> 17);
                    i2 = i5 ^ (i5 << 5);
                    z4 = z2;
                    z = z3;
                } else {
                    if (z) {
                        Unsafe unsafe = U;
                        long j2 = CELLVALUE;
                        long j3 = counterCell.value;
                        if (unsafe.compareAndSwapLong(counterCell, j2, j3, j3 + j)) {
                            break;
                        } else if (this.counterCells != counterCellArr || length >= NCPU) {
                            z2 = false;
                            z3 = z;
                        } else if (z4) {
                            z2 = z4;
                            z3 = z;
                            if (this.cellsBusy == 0) {
                                z2 = z4;
                                z3 = z;
                                if (U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                                    try {
                                        if (this.counterCells == counterCellArr) {
                                            CounterCell[] counterCellArr3 = new CounterCell[length << 1];
                                            int i6 = 0;
                                            while (true) {
                                                int i7 = i6;
                                                if (i7 >= length) {
                                                    break;
                                                }
                                                counterCellArr3[i7] = counterCellArr[i7];
                                                i6 = i7 + 1;
                                            }
                                            this.counterCells = counterCellArr3;
                                        }
                                        this.cellsBusy = 0;
                                        z4 = false;
                                    } finally {
                                    }
                                }
                            }
                        } else {
                            z2 = true;
                            z3 = z;
                        }
                    } else {
                        z3 = true;
                        z2 = z4;
                    }
                    int i42 = i2 ^ (i2 << 13);
                    int i52 = i42 ^ (i42 >>> 17);
                    i2 = i52 ^ (i52 << 5);
                    z4 = z2;
                    z = z3;
                }
            } else if (this.cellsBusy == 0 && this.counterCells == counterCellArr && U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                boolean z6 = false;
                try {
                    if (this.counterCells == counterCellArr) {
                        CounterCell[] counterCellArr4 = new CounterCell[2];
                        counterCellArr4[i2 & 1] = new CounterCell(j);
                        this.counterCells = counterCellArr4;
                        z6 = true;
                    }
                    this.cellsBusy = 0;
                    if (z6) {
                        break;
                    }
                } finally {
                }
            } else {
                Unsafe unsafe2 = U;
                long j4 = BASECOUNT;
                long j5 = this.baseCount;
                if (unsafe2.compareAndSwapLong(this, j4, j5, j5 + j)) {
                    break;
                }
            }
        }
        counterHashCode.code = i2;
    }

    private final Node<K, V>[] initTable() {
        Node<K, V>[] nodeArr;
        int i;
        while (true) {
            Node<K, V>[] nodeArr2 = this.table;
            if (nodeArr2 != null) {
                nodeArr = nodeArr2;
                if (nodeArr2.length != 0) {
                    break;
                }
            }
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                Thread.yield();
            } else if (U.compareAndSwapInt(this, SIZECTL, i2, -1)) {
                try {
                    Node<K, V>[] nodeArr3 = this.table;
                    if (nodeArr3 != null) {
                        i = i2;
                        nodeArr = nodeArr3;
                        if (nodeArr3.length == 0) {
                        }
                        this.sizeCtl = i;
                    }
                    int i3 = i2 > 0 ? i2 : 16;
                    Node<K, V>[] nodeArr4 = new Node[i3];
                    nodeArr = nodeArr4;
                    this.table = nodeArr4;
                    i = i3 - (i3 >>> 2);
                    this.sizeCtl = i;
                } catch (Throwable th) {
                    this.sizeCtl = i2;
                    throw th;
                }
            }
        }
        return nodeArr;
    }

    public static <K> KeySetView<K, Boolean> newKeySet() {
        return new KeySetView<>(new ConcurrentHashMap(), Boolean.TRUE);
    }

    public static <K> KeySetView<K, Boolean> newKeySet(int i) {
        return new KeySetView<>(new ConcurrentHashMap(i), Boolean.TRUE);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int tableSizeFor;
        boolean z;
        long j;
        boolean z2;
        K k;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j2 = 0;
        Node<K, V> node = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            if (readObject == null || readObject2 == null) {
                break;
            }
            node = new Node<>(spread(readObject.hashCode()), readObject, readObject2, node);
            j2++;
        }
        if (j2 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j2 >= 536870912) {
            tableSizeFor = 1073741824;
        } else {
            int i = (int) j2;
            tableSizeFor = tableSizeFor((i >>> 1) + i + 1);
        }
        Node<K, V>[] nodeArr = new Node[tableSizeFor];
        long j3 = 0;
        Node<K, V> node2 = node;
        while (true) {
            Node<K, V> node3 = node2;
            if (node3 == null) {
                this.table = nodeArr;
                this.sizeCtl = tableSizeFor - (tableSizeFor >>> 2);
                this.baseCount = j3;
                return;
            }
            Node<K, V> node4 = node3.next;
            int i2 = node3.hash;
            int i3 = i2 & (tableSizeFor - 1);
            Node<K, V> tabAt = tabAt(nodeArr, i3);
            if (tabAt == null) {
                z2 = true;
                j = j3;
            } else {
                K k2 = node3.key;
                if (tabAt.hash < 0) {
                    j = j3;
                    if (((TreeBin) tabAt).putTreeVal(i2, k2, node3.val) == null) {
                        j = j3 + 1;
                    }
                    z2 = false;
                } else {
                    int i4 = 0;
                    Node<K, V> node5 = tabAt;
                    while (true) {
                        Node<K, V> node6 = node5;
                        z = true;
                        if (node6 == null) {
                            break;
                        } else if (node6.hash != i2 || ((k = node6.key) != k2 && (k == null || !k2.equals(k)))) {
                            i4++;
                            node5 = node6.next;
                        }
                    }
                    z = false;
                    j = j3;
                    z2 = z;
                    if (z) {
                        j = j3;
                        z2 = z;
                        if (i4 >= 8) {
                            z2 = false;
                            j = j3 + 1;
                            node3.next = tabAt;
                            TreeNode<K, V> treeNode = null;
                            TreeNode<K, V> treeNode2 = null;
                            Node<K, V> node7 = node3;
                            while (true) {
                                Node<K, V> node8 = node7;
                                if (node8 == null) {
                                    break;
                                }
                                TreeNode<K, V> treeNode3 = new TreeNode<>(node8.hash, node8.key, node8.val, null, null);
                                treeNode3.prev = treeNode2;
                                if (treeNode2 == null) {
                                    treeNode = treeNode3;
                                } else {
                                    treeNode2.next = treeNode3;
                                }
                                treeNode2 = treeNode3;
                                node7 = node8.next;
                            }
                            setTabAt(nodeArr, i3, new TreeBin(treeNode));
                        }
                    }
                }
            }
            j3 = j;
            if (z2) {
                j3 = j + 1;
                node3.next = tabAt;
                setTabAt(nodeArr, i3, node3);
            }
            node2 = node4;
        }
    }

    static final <K, V> void setTabAt(Node<K, V>[] nodeArr, int i, Node<K, V> node) {
        U.putOrderedObject(nodeArr, (i << ASHIFT) + ABASE, node);
    }

    static final int spread(int i) {
        return ((i >>> 16) ^ i) & Integer.MAX_VALUE;
    }

    static final <K, V> Node<K, V> tabAt(Node<K, V>[] nodeArr, int i) {
        return (Node) U.getObjectVolatile(nodeArr, (i << ASHIFT) + ABASE);
    }

    private static final int tableSizeFor(int i) {
        int i2;
        int i3 = i - 1;
        int i4 = i3 | (i3 >>> 1);
        int i5 = i4 | (i4 >>> 2);
        int i6 = i5 | (i5 >>> 4);
        int i7 = i6 | (i6 >>> 8);
        int i8 = i7 | (i7 >>> 16);
        if (i8 < 0) {
            i2 = 1;
        } else {
            i2 = 1073741824;
            if (i8 < 1073741824) {
                return i8 + 1;
            }
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void transfer(Node<K, V>[] nodeArr, Node<K, V>[] nodeArr2) {
        Unsafe unsafe;
        long j;
        int i;
        int i2;
        Node<K, V> node;
        TreeBin treeBin;
        Node<K, V> node2;
        Node<K, V> node3;
        TreeBin treeBin2;
        Node<K, V> node4;
        int length = nodeArr.length;
        int i3 = NCPU > 1 ? (length >>> 3) / NCPU : length;
        int i4 = i3;
        if (i3 < 16) {
            i4 = 16;
        }
        Node<K, V>[] nodeArr3 = nodeArr2;
        if (nodeArr2 == null) {
            try {
                Node<K, V>[] nodeArr4 = new Node[length << 1];
                this.nextTable = nodeArr4;
                this.transferOrigin = length;
                this.transferIndex = length;
                ForwardingNode forwardingNode = new ForwardingNode(nodeArr);
                int i5 = length;
                while (true) {
                    nodeArr3 = nodeArr4;
                    if (i5 <= 0) {
                        break;
                    }
                    int i6 = i5 > i4 ? i5 - i4 : 0;
                    int i7 = i6;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= i5) {
                            break;
                        }
                        nodeArr4[i8] = forwardingNode;
                        i7 = i8 + 1;
                    }
                    int i9 = length;
                    int i10 = i6;
                    while (true) {
                        int i11 = i9 + i10;
                        if (i11 < length + i5) {
                            nodeArr4[i11] = forwardingNode;
                            i9 = i11;
                            i10 = 1;
                        }
                    }
                    i5 = i6;
                    U.putOrderedInt(this, TRANSFERORIGIN, i6);
                }
            } catch (Throwable th) {
                this.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        }
        int length2 = nodeArr3.length;
        ForwardingNode forwardingNode2 = new ForwardingNode(nodeArr3);
        boolean z = true;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (z) {
                i12--;
                if (i12 >= i13) {
                    z = false;
                } else {
                    int i14 = this.transferIndex;
                    if (i14 <= this.transferOrigin) {
                        i12 = -1;
                        z = false;
                    } else {
                        Unsafe unsafe2 = U;
                        long j2 = TRANSFERINDEX;
                        int i15 = i14 > i4 ? i14 - i4 : 0;
                        if (unsafe2.compareAndSwapInt(this, j2, i14, i15)) {
                            i12 = i14 - 1;
                            z = false;
                            i13 = i15;
                        }
                    }
                }
            } else if (i12 < 0 || i12 >= length || i12 + length >= length2) {
                break;
            } else {
                Node<K, V> tabAt = tabAt(nodeArr, i12);
                if (tabAt != null) {
                    int i16 = tabAt.hash;
                    if (i16 == MOVED) {
                        z = true;
                    } else {
                        synchronized (tabAt) {
                            if (tabAt(nodeArr, i12) == tabAt) {
                                if (i16 >= 0) {
                                    int i17 = i16 & length;
                                    Node<K, V> node5 = tabAt;
                                    Node<K, V> node6 = tabAt.next;
                                    while (node6 != null) {
                                        int i18 = node6.hash & length;
                                        int i19 = i17;
                                        if (i18 != i17) {
                                            i19 = i18;
                                            node5 = node6;
                                        }
                                        node6 = node6.next;
                                        i17 = i19;
                                    }
                                    if (i17 == 0) {
                                        node3 = node5;
                                        node2 = null;
                                    } else {
                                        node2 = node5;
                                        node3 = null;
                                    }
                                    TreeBin treeBin3 = node3;
                                    Node<K, V> node7 = node2;
                                    TreeBin treeBin4 = treeBin3;
                                    for (Node<K, V> node8 = tabAt; node8 != node5; node8 = node8.next) {
                                        int i20 = node8.hash;
                                        K k = node8.key;
                                        V v = node8.val;
                                        if ((i20 & length) == 0) {
                                            Node node9 = new Node(i20, k, v, treeBin4);
                                            node4 = node7;
                                            treeBin2 = node9;
                                        } else {
                                            Node<K, V> node10 = new Node<>(i20, k, v, node7);
                                            treeBin2 = treeBin4;
                                            node4 = node10;
                                        }
                                        Node node11 = treeBin2;
                                        node7 = node4;
                                        treeBin4 = node11;
                                    }
                                    treeBin = treeBin4;
                                    node = node7;
                                } else if (tabAt instanceof TreeBin) {
                                    TreeBin treeBin5 = (TreeBin) tabAt;
                                    TreeNode<K, V> treeNode = null;
                                    TreeNode<K, V> treeNode2 = null;
                                    TreeNode<K, V> treeNode3 = null;
                                    TreeNode<K, V> treeNode4 = null;
                                    int i21 = 0;
                                    int i22 = 0;
                                    for (Node node12 = treeBin5.first; node12 != null; node12 = (Node<K, V>) node12.next) {
                                        int i23 = node12.hash;
                                        TreeNode<K, V> treeNode5 = new TreeNode<>(i23, node12.key, node12.val, null, null);
                                        if ((i23 & length) == 0) {
                                            treeNode5.prev = treeNode2;
                                            if (treeNode2 == null) {
                                                treeNode = treeNode5;
                                            } else {
                                                treeNode2.next = treeNode5;
                                            }
                                            i21++;
                                            treeNode2 = treeNode5;
                                        } else {
                                            treeNode5.prev = treeNode4;
                                            if (treeNode4 == null) {
                                                treeNode3 = treeNode5;
                                            } else {
                                                treeNode4.next = treeNode5;
                                            }
                                            i22++;
                                            treeNode4 = treeNode5;
                                        }
                                    }
                                    treeBin = i21 <= 6 ? untreeify(treeNode) : i22 != 0 ? new TreeBin(treeNode) : treeBin5;
                                    node = i22 <= 6 ? untreeify(treeNode3) : i21 != 0 ? new TreeBin(treeNode3) : treeBin5;
                                } else {
                                    node = null;
                                    treeBin = null;
                                }
                                setTabAt(nodeArr3, i12, treeBin);
                                setTabAt(nodeArr3, i12 + length, node);
                                setTabAt(nodeArr, i12, forwardingNode2);
                                z = true;
                            }
                        }
                    }
                } else if (casTabAt(nodeArr, i12, null, forwardingNode2)) {
                    setTabAt(nodeArr3, i12, null);
                    setTabAt(nodeArr3, i12 + length, null);
                    z = true;
                }
            }
        }
        do {
            unsafe = U;
            j = SIZECTL;
            i = this.sizeCtl;
            i2 = i + 1;
        } while (!unsafe.compareAndSwapInt(this, j, i, i2));
        if (i2 == -1) {
            this.nextTable = null;
            this.table = nodeArr3;
            this.sizeCtl = (length << 1) - (length >>> 1);
        }
    }

    private final void treeifyBin(Node<K, V>[] nodeArr, int i) {
        int i2;
        if (nodeArr != null) {
            if (nodeArr.length < 64) {
                if (nodeArr == this.table && (i2 = this.sizeCtl) >= 0 && U.compareAndSwapInt(this, SIZECTL, i2, -2)) {
                    transfer(nodeArr, null);
                    return;
                }
                return;
            }
            Node<K, V> tabAt = tabAt(nodeArr, i);
            if (tabAt != null) {
                synchronized (tabAt) {
                    if (tabAt(nodeArr, i) == tabAt) {
                        TreeNode<K, V> treeNode = null;
                        TreeNode<K, V> treeNode2 = null;
                        for (Node<K, V> node = tabAt; node != null; node = node.next) {
                            TreeNode<K, V> treeNode3 = new TreeNode<>(node.hash, node.key, node.val, null, null);
                            treeNode3.prev = treeNode2;
                            if (treeNode2 == null) {
                                treeNode = treeNode3;
                            } else {
                                treeNode2.next = treeNode3;
                            }
                            treeNode2 = treeNode3;
                        }
                        setTabAt(nodeArr, i, new TreeBin(treeNode));
                    }
                }
            }
        }
    }

    private final void tryPresize(int i) {
        int length;
        int tableSizeFor = i >= 536870912 ? 1073741824 : tableSizeFor((i >>> 1) + i + 1);
        while (true) {
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                return;
            }
            Node<K, V>[] nodeArr = this.table;
            if (nodeArr == null || (length = nodeArr.length) == 0) {
                int i3 = i2 > tableSizeFor ? i2 : tableSizeFor;
                if (U.compareAndSwapInt(this, SIZECTL, i2, -1)) {
                    int i4 = i2;
                    try {
                        if (this.table == nodeArr) {
                            this.table = new Node[i3];
                            i4 = i3 - (i3 >>> 2);
                        }
                        this.sizeCtl = i4;
                    } catch (Throwable th) {
                        this.sizeCtl = i2;
                        throw th;
                    }
                } else {
                    continue;
                }
            } else if (tableSizeFor <= i2 || length >= 1073741824) {
                return;
            } else {
                if (nodeArr == this.table && U.compareAndSwapInt(this, SIZECTL, i2, -2)) {
                    transfer(nodeArr, null);
                }
            }
        }
    }

    static <K, V> Node<K, V> untreeify(Node<K, V> node) {
        Node<K, V> node2 = null;
        Node<K, V> node3 = null;
        while (node != null) {
            Node<K, V> node4 = new Node<>(node.hash, node.key, node.val, null);
            if (node3 == null) {
                node2 = node4;
            } else {
                node3.next = node4;
            }
            node3 = node4;
            node = node.next;
        }
        return node2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            i = i3;
            if (i >= 16) {
                break;
            }
            i2++;
            i3 = i << 1;
        }
        Segment[] segmentArr = new Segment[16];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= segmentArr.length) {
                break;
            }
            segmentArr[i5] = new Segment(LOAD_FACTOR);
            i4 = i5 + 1;
        }
        objectOutputStream.putFields().put("segments", segmentArr);
        objectOutputStream.putFields().put("segmentShift", 32 - i2);
        objectOutputStream.putFields().put("segmentMask", i - 1);
        objectOutputStream.writeFields();
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                objectOutputStream.writeObject(advance.key);
                objectOutputStream.writeObject(advance.val);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:? -> B:46:0x00b7). Please submit an issue!!! */
    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        long j = 0;
        Node<K, V>[] nodeArr = this.table;
        int i = 0;
        while (nodeArr != null && i < nodeArr.length) {
            Node<K, V> tabAt = tabAt(nodeArr, i);
            if (tabAt == null) {
                i++;
            } else {
                int i2 = tabAt.hash;
                if (i2 == MOVED) {
                    nodeArr = helpTransfer(nodeArr, tabAt);
                    i = 0;
                } else {
                    synchronized (tabAt) {
                        try {
                            if (tabAt(nodeArr, i) == tabAt) {
                                for (TreeNode<K, V> treeNode = i2 >= 0 ? tabAt : tabAt instanceof TreeBin ? ((TreeBin) tabAt).first : null; treeNode != null; treeNode = treeNode.next) {
                                    j--;
                                }
                                int i3 = i + 1;
                                try {
                                    setTabAt(nodeArr, i, null);
                                    i = i3;
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                }
            }
        }
        if (j != 0) {
            addCount(j, -1);
        }
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
        r9 = true;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean containsValue(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            r10 = r0
            r0 = r8
            if (r0 != 0) goto Le
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            r1.<init>()
            throw r0
        Le:
            r0 = r7
            java.util.concurrent.ConcurrentHashMap$Node<K, V>[] r0 = r0.table
            r11 = r0
            r0 = r10
            r9 = r0
            r0 = r11
            if (r0 == 0) goto L58
            java.util.concurrent.ConcurrentHashMap$Traverser r0 = new java.util.concurrent.ConcurrentHashMap$Traverser
            r1 = r0
            r2 = r11
            r3 = r11
            int r3 = r3.length
            r4 = 0
            r5 = r11
            int r5 = r5.length
            r1.<init>(r2, r3, r4, r5)
            r11 = r0
        L2d:
            r0 = r11
            java.util.concurrent.ConcurrentHashMap$Node r0 = r0.advance()
            r12 = r0
            r0 = r10
            r9 = r0
            r0 = r12
            if (r0 == 0) goto L58
            r0 = r12
            V r0 = r0.val
            r12 = r0
            r0 = r12
            r1 = r8
            if (r0 == r1) goto L56
            r0 = r12
            if (r0 == 0) goto L2d
            r0 = r8
            r1 = r12
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L2d
        L56:
            r0 = 1
            r9 = r0
        L58:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.containsValue(java.lang.Object):boolean");
    }

    public Enumeration<V> elements() {
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        return new ValueIterator(nodeArr, length, 0, length, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySetView<K, V> entrySetView = this.entrySet;
        if (entrySetView != null) {
            return entrySetView;
        }
        EntrySetView<K, V> entrySetView2 = new EntrySetView<>(this);
        this.entrySet = entrySetView2;
        return entrySetView2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        V value;
        V v;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        while (true) {
            Node<K, V> advance = traverser.advance();
            if (advance == null) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (v = get(key)) == null) {
                        return false;
                    }
                    if (value != v && !value.equals(v)) {
                        return false;
                    }
                }
                return true;
            }
            V v2 = advance.val;
            Object obj2 = map.get(advance.key);
            if (obj2 == null) {
                return false;
            }
            if (obj2 != v2 && !obj2.equals(v2)) {
                return false;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0066, code lost:
        if (r5.equals(r0) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d5, code lost:
        return r0.val;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070 A[EDGE_INSN: B:38:0x0070->B:17:0x0070 ?: BREAK  , SYNTHETIC] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V get(java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int i = 0;
        int i2 = 0;
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                i = i2;
                if (advance == null) {
                    break;
                }
                i2 += advance.key.hashCode() ^ advance.val.hashCode();
            }
        }
        return i;
    }

    final Node<K, V>[] helpTransfer(Node<K, V>[] nodeArr, Node<K, V> node) {
        Node<K, V>[] nodeArr2;
        int i;
        if (!(node instanceof ForwardingNode) || (nodeArr2 = ((ForwardingNode) node).nextTable) == null) {
            return this.table;
        }
        if (nodeArr2 == this.nextTable && nodeArr == this.table && this.transferIndex > this.transferOrigin && (i = this.sizeCtl) < -1 && U.compareAndSwapInt(this, SIZECTL, i, i - 1)) {
            transfer(nodeArr, nodeArr2);
        }
        return nodeArr2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        KeySetView<K, V> keySetView = this.keySet;
        if (keySetView != null) {
            return keySetView;
        }
        KeySetView<K, V> keySetView2 = new KeySetView<>(this, null);
        this.keySet = keySetView2;
        return keySetView2;
    }

    public Set<K> keySet(V v) {
        if (v == null) {
            throw new NullPointerException();
        }
        return new KeySetView(this, v);
    }

    public Enumeration<K> keys() {
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        return new KeyIterator(nodeArr, length, 0, length, this);
    }

    public long mappingCount() {
        long sumCount = sumCount();
        long j = sumCount;
        if (sumCount < 0) {
            j = 0;
        }
        return j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        return putVal(k, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        tryPresize(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putVal(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        return putVal(k, v, true);
    }

    final V putVal(K k, V v, boolean z) {
        int length;
        int i;
        V v2;
        Node<K, V> node;
        if (k == null || v == null) {
            throw new NullPointerException();
        }
        int spread = spread(k.hashCode());
        int i2 = 0;
        Node<K, V>[] nodeArr = this.table;
        while (true) {
            if (nodeArr == null || (length = nodeArr.length) == 0) {
                nodeArr = initTable();
            } else {
                int i3 = (length - 1) & spread;
                Node<K, V> tabAt = tabAt(nodeArr, i3);
                if (tabAt != null) {
                    int i4 = tabAt.hash;
                    if (i4 == MOVED) {
                        nodeArr = helpTransfer(nodeArr, tabAt);
                    } else {
                        synchronized (tabAt) {
                            i = i2;
                            if (tabAt(nodeArr, i3) == tabAt) {
                                if (i4 >= 0) {
                                    i = 1;
                                    Node<K, V> node2 = tabAt;
                                    while (true) {
                                        node = node2;
                                        if (node.hash == spread) {
                                            K k2 = node.key;
                                            if (k2 == k || (k2 != null && k.equals(k2))) {
                                                break;
                                            }
                                        }
                                        node2 = node.next;
                                        if (node2 == null) {
                                            node.next = new Node<>(spread, k, v, null);
                                            v2 = null;
                                            break;
                                        }
                                        i++;
                                    }
                                    V v3 = node.val;
                                    v2 = v3;
                                    if (!z) {
                                        node.val = v;
                                        v2 = v3;
                                    }
                                } else {
                                    i = i2;
                                    if (tabAt instanceof TreeBin) {
                                        TreeNode<K, V> putTreeVal = ((TreeBin) tabAt).putTreeVal(spread, k, v);
                                        i = 2;
                                        if (putTreeVal != null) {
                                            v2 = putTreeVal.val;
                                            if (!z) {
                                                putTreeVal.val = v;
                                            }
                                            i = 2;
                                        }
                                    }
                                }
                            }
                            v2 = null;
                        }
                        i2 = i;
                        if (i != 0) {
                            if (i >= 8) {
                                treeifyBin(nodeArr, i3);
                            }
                            if (v2 != null) {
                                return v2;
                            }
                        }
                    }
                } else if (casTabAt(nodeArr, i3, null, new Node(spread, k, v, null))) {
                    i = i2;
                    break;
                }
            }
        }
        addCount(1L, i);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return replaceNode(obj, null, null);
    }

    @Override // java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return (obj2 == null || replaceNode(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException();
        }
        return replaceNode(k, v, null);
    }

    @Override // java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v2) {
        if (k == null || v == null || v2 == null) {
            throw new NullPointerException();
        }
        return replaceNode(k, v2, v) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
        if (r8.equals(r0) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x019b, code lost:
        if (r8.equals(r14) != false) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final V replaceNode(java.lang.Object r6, V r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.replaceNode(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long sumCount = sumCount();
        if (sumCount < 0) {
            return 0;
        }
        if (sumCount > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) sumCount;
    }

    final long sumCount() {
        CounterCell[] counterCellArr = this.counterCells;
        long j = this.baseCount;
        long j2 = j;
        if (counterCellArr != null) {
            int i = 0;
            while (true) {
                j2 = j;
                if (i >= counterCellArr.length) {
                    break;
                }
                CounterCell counterCell = counterCellArr[i];
                long j3 = j;
                if (counterCell != null) {
                    j3 = j + counterCell.value;
                }
                i++;
                j = j3;
            }
        }
        return j2;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Node<K, V> advance = traverser.advance();
        if (advance != null) {
            while (true) {
                K k = advance.key;
                V v = advance.val;
                K k2 = k;
                if (k == this) {
                    k2 = "(this Map)";
                }
                sb.append(k2);
                sb.append('=');
                V v2 = v;
                if (v == this) {
                    v2 = "(this Map)";
                }
                sb.append(v2);
                advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                sb.append(',').append(' ');
            }
        }
        return sb.append('}').toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        ValuesView<K, V> valuesView = this.values;
        if (valuesView != null) {
            return valuesView;
        }
        ValuesView<K, V> valuesView2 = new ValuesView<>(this);
        this.values = valuesView2;
        return valuesView2;
    }
}
