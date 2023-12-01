package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap.class */
public class TreeMap<K, V> extends AbstractMap<K, V> implements SortedMap<K, V>, NavigableMap<K, V>, Cloneable, Serializable {
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() { // from class: java.util.TreeMap.1
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    private static final long serialVersionUID = 919286545866124006L;
    Comparator<? super K> comparator;
    private TreeMap<K, V>.EntrySet entrySet;
    private TreeMap<K, V>.KeySet keySet;
    int modCount;
    Node<K, V> root;
    int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: java.util.TreeMap$2  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$2.class */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$java$util$TreeMap$Bound = new int[Bound.values().length];
        static final /* synthetic */ int[] $SwitchMap$java$util$TreeMap$Relation;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0079 -> B:52:0x006a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007d -> B:44:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0081 -> B:40:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0085 -> B:54:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0089 -> B:48:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008d -> B:8:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0091 -> B:42:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0095 -> B:56:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$java$util$TreeMap$Bound[Bound.NO_BOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$util$TreeMap$Bound[Bound.INCLUSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$util$TreeMap$Bound[Bound.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SwitchMap$java$util$TreeMap$Relation = new int[Relation.values().length];
            try {
                $SwitchMap$java$util$TreeMap$Relation[Relation.LOWER.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$util$TreeMap$Relation[Relation.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$util$TreeMap$Relation[Relation.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$util$TreeMap$Relation[Relation.CEILING.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$java$util$TreeMap$Relation[Relation.HIGHER.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$java$util$TreeMap$Relation[Relation.CREATE.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$AscendingSubMap.class */
    static class AscendingSubMap<K, V> extends NavigableSubMap<K, V> {
        private static final long serialVersionUID = 912986545866124060L;

        AscendingSubMap(TreeMap<K, V> treeMap, K k, Bound bound, K k2, Bound bound2) {
            super(treeMap, k, bound, k2, bound2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$Bound.class */
    public enum Bound {
        INCLUSIVE { // from class: java.util.TreeMap.Bound.1
            @Override // java.util.TreeMap.Bound
            public String leftCap(Object obj) {
                return "[" + obj;
            }

            @Override // java.util.TreeMap.Bound
            public String rightCap(Object obj) {
                return obj + "]";
            }
        },
        EXCLUSIVE { // from class: java.util.TreeMap.Bound.2
            @Override // java.util.TreeMap.Bound
            public String leftCap(Object obj) {
                return "(" + obj;
            }

            @Override // java.util.TreeMap.Bound
            public String rightCap(Object obj) {
                return obj + ")";
            }
        },
        NO_BOUND { // from class: java.util.TreeMap.Bound.3
            @Override // java.util.TreeMap.Bound
            public String leftCap(Object obj) {
                return ".";
            }

            @Override // java.util.TreeMap.Bound
            public String rightCap(Object obj) {
                return ".";
            }
        };

        public abstract String leftCap(Object obj);

        public abstract String rightCap(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$BoundedMap.class */
    public final class BoundedMap extends AbstractMap<K, V> implements NavigableMap<K, V>, Serializable {
        private final transient boolean ascending;
        private transient TreeMap<K, V>.BoundedMap.BoundedEntrySet entrySet;
        private final transient K from;
        private final transient Bound fromBound;
        private transient TreeMap<K, V>.BoundedMap.BoundedKeySet keySet;
        private final transient K to;
        private final transient Bound toBound;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$BoundedMap$BoundedEntrySet.class */
        public final class BoundedEntrySet extends AbstractSet<Map.Entry<K, V>> {
            BoundedEntrySet() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry<?, ?> entry = (Map.Entry) obj;
                    return BoundedMap.this.isInBounds(entry.getKey()) && TreeMap.this.findByEntry(entry) != null;
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return BoundedMap.this.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                return new TreeMap<K, V>.BoundedMap.BoundedIterator<Map.Entry<K, V>>(BoundedMap.this.endpoint(true)) { // from class: java.util.TreeMap.BoundedMap.BoundedEntrySet.1
                    {
                        BoundedMap boundedMap = BoundedMap.this;
                    }

                    @Override // java.util.Iterator
                    public Map.Entry<K, V> next() {
                        return BoundedMap.this.ascending ? stepForward() : stepBackward();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return BoundedMap.this.isInBounds(entry.getKey()) && TreeMap.this.entrySet().remove(entry);
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return BoundedMap.this.size();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$BoundedMap$BoundedIterator.class */
        public abstract class BoundedIterator<T> extends TreeMap<K, V>.MapIterator<T> {
            protected BoundedIterator(Node<K, V> node) {
                super(node);
            }

            @Override // java.util.TreeMap.MapIterator
            protected Node<K, V> stepBackward() {
                Node<K, V> stepBackward = super.stepBackward();
                if (this.next != null && !BoundedMap.this.isInBounds(this.next.key, BoundedMap.this.fromBound, Bound.NO_BOUND)) {
                    this.next = null;
                }
                return stepBackward;
            }

            @Override // java.util.TreeMap.MapIterator
            protected Node<K, V> stepForward() {
                Node<K, V> stepForward = super.stepForward();
                if (this.next != null && !BoundedMap.this.isInBounds(this.next.key, Bound.NO_BOUND, BoundedMap.this.toBound)) {
                    this.next = null;
                }
                return stepForward;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$BoundedMap$BoundedKeySet.class */
        public final class BoundedKeySet extends AbstractSet<K> implements NavigableSet<K> {
            BoundedKeySet() {
            }

            @Override // java.util.NavigableSet
            public K ceiling(K k) {
                return (K) BoundedMap.this.ceilingKey(k);
            }

            @Override // java.util.SortedSet
            public Comparator<? super K> comparator() {
                return BoundedMap.this.comparator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return BoundedMap.this.isInBounds(obj) && TreeMap.this.findByObject(obj) != null;
            }

            @Override // java.util.NavigableSet
            public Iterator<K> descendingIterator() {
                return new TreeMap<K, V>.BoundedMap.BoundedIterator<K>(BoundedMap.this.endpoint(false)) { // from class: java.util.TreeMap.BoundedMap.BoundedKeySet.2
                    {
                        BoundedMap boundedMap = BoundedMap.this;
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return (BoundedMap.this.ascending ? stepBackward() : stepForward()).key;
                    }
                };
            }

            @Override // java.util.NavigableSet
            public NavigableSet<K> descendingSet() {
                return new BoundedMap(!BoundedMap.this.ascending, BoundedMap.this.from, BoundedMap.this.fromBound, BoundedMap.this.to, BoundedMap.this.toBound).navigableKeySet();
            }

            @Override // java.util.SortedSet
            public K first() {
                return (K) BoundedMap.this.firstKey();
            }

            @Override // java.util.NavigableSet
            public K floor(K k) {
                return (K) BoundedMap.this.floorKey(k);
            }

            @Override // java.util.NavigableSet
            public NavigableSet<K> headSet(K k, boolean z) {
                return BoundedMap.this.headMap(k, z).navigableKeySet();
            }

            @Override // java.util.NavigableSet
            public SortedSet<K> headSet(K k) {
                return BoundedMap.this.headMap((BoundedMap) k).navigableKeySet();
            }

            @Override // java.util.NavigableSet
            public K higher(K k) {
                return (K) BoundedMap.this.higherKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return BoundedMap.this.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<K> iterator() {
                return new TreeMap<K, V>.BoundedMap.BoundedIterator<K>(BoundedMap.this.endpoint(true)) { // from class: java.util.TreeMap.BoundedMap.BoundedKeySet.1
                    {
                        BoundedMap boundedMap = BoundedMap.this;
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return (BoundedMap.this.ascending ? stepForward() : stepBackward()).key;
                    }
                };
            }

            @Override // java.util.SortedSet
            public K last() {
                return (K) BoundedMap.this.lastKey();
            }

            @Override // java.util.NavigableSet
            public K lower(K k) {
                return (K) BoundedMap.this.lowerKey(k);
            }

            @Override // java.util.NavigableSet
            public K pollFirst() {
                Map.Entry<K, V> pollFirstEntry = BoundedMap.this.pollFirstEntry();
                if (pollFirstEntry != null) {
                    return pollFirstEntry.getKey();
                }
                return null;
            }

            @Override // java.util.NavigableSet
            public K pollLast() {
                Map.Entry<K, V> pollLastEntry = BoundedMap.this.pollLastEntry();
                if (pollLastEntry != null) {
                    return pollLastEntry.getKey();
                }
                return null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return BoundedMap.this.isInBounds(obj) && TreeMap.this.removeInternalByKey(obj) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return BoundedMap.this.size();
            }

            @Override // java.util.NavigableSet
            public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
                return BoundedMap.this.subMap((boolean) k, z, (boolean) k2, z2).navigableKeySet();
            }

            @Override // java.util.NavigableSet
            public SortedSet<K> subSet(K k, K k2) {
                return BoundedMap.this.subMap((Object) k, (Object) k2).navigableKeySet();
            }

            @Override // java.util.NavigableSet
            public NavigableSet<K> tailSet(K k, boolean z) {
                return BoundedMap.this.tailMap(k, z).navigableKeySet();
            }

            @Override // java.util.NavigableSet
            public SortedSet<K> tailSet(K k) {
                return BoundedMap.this.tailMap((BoundedMap) k).navigableKeySet();
            }
        }

        BoundedMap(boolean z, K k, Bound bound, K k2, Bound bound2) {
            if (bound == Bound.NO_BOUND || bound2 == Bound.NO_BOUND) {
                if (bound != Bound.NO_BOUND) {
                    TreeMap.this.comparator.compare(k, k);
                } else if (bound2 != Bound.NO_BOUND) {
                    TreeMap.this.comparator.compare(k2, k2);
                }
            } else if (TreeMap.this.comparator.compare(k, k2) > 0) {
                throw new IllegalArgumentException(k + " > " + k2);
            }
            this.ascending = z;
            this.from = k;
            this.fromBound = bound;
            this.to = k2;
            this.toBound = bound2;
        }

        private Node<K, V> bound(Node<K, V> node, Bound bound, Bound bound2) {
            if (node == null || !isInBounds(node.getKey(), bound, bound2)) {
                return null;
            }
            return node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node<K, V> endpoint(boolean z) {
            Node<K, V> find;
            Node<K, V> node = null;
            if (this.ascending == z) {
                switch (AnonymousClass2.$SwitchMap$java$util$TreeMap$Bound[this.fromBound.ordinal()]) {
                    case 1:
                        if (TreeMap.this.root != null) {
                            node = TreeMap.this.root.first();
                            break;
                        }
                        break;
                    case 2:
                        node = TreeMap.this.find(this.from, Relation.CEILING);
                        break;
                    case 3:
                        node = TreeMap.this.find(this.from, Relation.HIGHER);
                        break;
                    default:
                        throw new AssertionError();
                }
                return bound(node, Bound.NO_BOUND, this.toBound);
            }
            switch (AnonymousClass2.$SwitchMap$java$util$TreeMap$Bound[this.toBound.ordinal()]) {
                case 1:
                    if (TreeMap.this.root != null) {
                        find = TreeMap.this.root.last();
                        break;
                    } else {
                        find = null;
                        break;
                    }
                case 2:
                    find = TreeMap.this.find(this.to, Relation.FLOOR);
                    break;
                case 3:
                    find = TreeMap.this.find(this.to, Relation.LOWER);
                    break;
                default:
                    throw new AssertionError();
            }
            return bound(find, this.fromBound, Bound.NO_BOUND);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x00a5, code lost:
            if (r7 == java.util.TreeMap.Relation.HIGHER) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0041, code lost:
            if (r0 == java.util.TreeMap.Relation.FLOOR) goto L7;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.util.Map.Entry<K, V> findBounded(K r6, java.util.TreeMap.Relation r7) {
            /*
                Method dump skipped, instructions count: 286
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.TreeMap.BoundedMap.findBounded(java.lang.Object, java.util.TreeMap$Relation):java.util.Map$Entry");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isInBounds(Object obj) {
            return isInBounds(obj, this.fromBound, this.toBound);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isInBounds(K k, Bound bound, Bound bound2) {
            if (bound == Bound.INCLUSIVE) {
                if (TreeMap.this.comparator.compare(k, (K) this.from) < 0) {
                    return false;
                }
            } else if (bound == Bound.EXCLUSIVE && TreeMap.this.comparator.compare(k, (K) this.from) <= 0) {
                return false;
            }
            return bound2 == Bound.INCLUSIVE ? TreeMap.this.comparator.compare(k, (K) this.to) <= 0 : bound2 != Bound.EXCLUSIVE || TreeMap.this.comparator.compare(k, (K) this.to) < 0;
        }

        private IllegalArgumentException outOfBounds(Object obj, Bound bound, Bound bound2) {
            return new IllegalArgumentException(obj + " not in range " + bound.leftCap(this.from) + ".." + bound2.rightCap(this.to));
        }

        private NavigableMap<K, V> subMap(K k, Bound bound, K k2, Bound bound2) {
            K k3;
            K k4;
            K k5 = k;
            Bound bound3 = bound;
            K k6 = k2;
            Bound bound4 = bound2;
            if (!this.ascending) {
                bound4 = bound;
                k6 = k;
                bound3 = bound2;
                k5 = k2;
            }
            if (bound3 == Bound.NO_BOUND) {
                k3 = this.from;
                bound3 = this.fromBound;
            } else {
                Bound bound5 = bound3 == this.fromBound ? Bound.INCLUSIVE : this.fromBound;
                k3 = k5;
                if (!isInBounds(k5, bound5, this.toBound)) {
                    throw outOfBounds(k6, bound5, this.toBound);
                }
            }
            if (bound4 == Bound.NO_BOUND) {
                k4 = this.to;
                bound4 = this.toBound;
            } else {
                Bound bound6 = bound4 == this.toBound ? Bound.INCLUSIVE : this.toBound;
                k4 = k6;
                if (!isInBounds(k6, this.fromBound, bound6)) {
                    throw outOfBounds(k6, this.fromBound, bound6);
                }
            }
            return new BoundedMap(this.ascending, k3, bound3, k4, bound4);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return TreeMap.this.immutableCopy(findBounded(k, Relation.CEILING));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            Map.Entry<K, V> findBounded = findBounded(k, Relation.CEILING);
            if (findBounded != null) {
                return findBounded.getKey();
            }
            return null;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = TreeMap.this.comparator();
            return this.ascending ? comparator : Collections.reverseOrder(comparator);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return isInBounds(obj) && TreeMap.this.containsKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return new BoundedMap(!this.ascending, this.from, this.fromBound, this.to, this.toBound).navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return new BoundedMap(!this.ascending, this.from, this.fromBound, this.to, this.toBound);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            TreeMap<K, V>.BoundedMap.BoundedEntrySet boundedEntrySet = this.entrySet;
            if (boundedEntrySet != null) {
                return boundedEntrySet;
            }
            TreeMap<K, V>.BoundedMap.BoundedEntrySet boundedEntrySet2 = new BoundedEntrySet();
            this.entrySet = boundedEntrySet2;
            return boundedEntrySet2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return TreeMap.this.immutableCopy(endpoint(true));
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            Node<K, V> endpoint = endpoint(true);
            if (endpoint == null) {
                throw new NoSuchElementException();
            }
            return endpoint.getKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return TreeMap.this.immutableCopy(findBounded(k, Relation.FLOOR));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            Map.Entry<K, V> findBounded = findBounded(k, Relation.FLOOR);
            if (findBounded != null) {
                return findBounded.getKey();
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (isInBounds(obj)) {
                return (V) TreeMap.this.get(obj);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k) {
            return subMap((Bound) null, Bound.NO_BOUND, (Bound) k, Bound.EXCLUSIVE);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return subMap((Bound) null, Bound.NO_BOUND, (Bound) k, z ? Bound.INCLUSIVE : Bound.EXCLUSIVE);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
            return headMap((BoundedMap) obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return TreeMap.this.immutableCopy(findBounded(k, Relation.HIGHER));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            Map.Entry<K, V> findBounded = findBounded(k, Relation.HIGHER);
            if (findBounded != null) {
                return findBounded.getKey();
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return endpoint(true) == null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return TreeMap.this.immutableCopy(endpoint(false));
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            Node<K, V> endpoint = endpoint(false);
            if (endpoint == null) {
                throw new NoSuchElementException();
            }
            return endpoint.getKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return TreeMap.this.immutableCopy(findBounded(k, Relation.LOWER));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            Map.Entry<K, V> findBounded = findBounded(k, Relation.LOWER);
            if (findBounded != null) {
                return findBounded.getKey();
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            TreeMap<K, V>.BoundedMap.BoundedKeySet boundedKeySet = this.keySet;
            if (boundedKeySet != null) {
                return boundedKeySet;
            }
            TreeMap<K, V>.BoundedMap.BoundedKeySet boundedKeySet2 = new BoundedKeySet();
            this.keySet = boundedKeySet2;
            return boundedKeySet2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Node<K, V> endpoint = endpoint(true);
            if (endpoint != null) {
                TreeMap.this.removeInternal(endpoint);
            }
            return TreeMap.this.immutableCopy(endpoint);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Node<K, V> endpoint = endpoint(false);
            if (endpoint != null) {
                TreeMap.this.removeInternal(endpoint);
            }
            return TreeMap.this.immutableCopy(endpoint);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            if (isInBounds(k)) {
                return (V) TreeMap.this.putInternal(k, v);
            }
            throw outOfBounds(k, this.fromBound, this.toBound);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            if (isInBounds(obj)) {
                return (V) TreeMap.this.remove(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return TreeMap.count(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, K k2) {
            return subMap((Bound) k, Bound.INCLUSIVE, (Bound) k2, Bound.EXCLUSIVE);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return subMap((Bound) k, z ? Bound.INCLUSIVE : Bound.EXCLUSIVE, (Bound) k2, z2 ? Bound.INCLUSIVE : Bound.EXCLUSIVE);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k) {
            return subMap((Bound) k, Bound.INCLUSIVE, (Bound) null, Bound.NO_BOUND);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return subMap((Bound) k, z ? Bound.INCLUSIVE : Bound.EXCLUSIVE, (Bound) null, Bound.NO_BOUND);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
            return tailMap((BoundedMap) obj);
        }

        Object writeReplace() throws ObjectStreamException {
            return this.ascending ? new AscendingSubMap(TreeMap.this, this.from, this.fromBound, this.to, this.toBound) : new DescendingSubMap(TreeMap.this, this.from, this.fromBound, this.to, this.toBound);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$DescendingSubMap.class */
    static class DescendingSubMap<K, V> extends NavigableSubMap<K, V> {
        private static final long serialVersionUID = 912986545866120460L;
        Comparator<K> reverseComparator;

        DescendingSubMap(TreeMap<K, V> treeMap, K k, Bound bound, K k2, Bound bound2) {
            super(treeMap, k, bound, k2, bound2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$EntrySet.class */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && TreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new TreeMap<K, V>.MapIterator<Map.Entry<K, V>>(TreeMap.this.root == null ? null : TreeMap.this.root.first()) { // from class: java.util.TreeMap.EntrySet.1
                {
                    TreeMap treeMap = TreeMap.this;
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return stepForward();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Node<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = TreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                TreeMap.this.removeInternal(findByEntry);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return TreeMap.this.size;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$KeySet.class */
    class KeySet extends AbstractSet<K> implements NavigableSet<K> {
        KeySet() {
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return (K) TreeMap.this.ceilingKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TreeMap.this.clear();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return TreeMap.this.comparator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return TreeMap.this.containsKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return new TreeMap<K, V>.MapIterator<K>(TreeMap.this.root == null ? null : TreeMap.this.root.last()) { // from class: java.util.TreeMap.KeySet.2
                {
                    TreeMap treeMap = TreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return stepBackward().key;
                }
            };
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new BoundedMap(false, null, Bound.NO_BOUND, null, Bound.NO_BOUND).navigableKeySet();
        }

        @Override // java.util.SortedSet
        public K first() {
            return (K) TreeMap.this.firstKey();
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return (K) TreeMap.this.floorKey(k);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return TreeMap.this.headMap(k, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return TreeMap.this.headMap(k, false).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return (K) TreeMap.this.higherKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new TreeMap<K, V>.MapIterator<K>(TreeMap.this.root == null ? null : TreeMap.this.root.first()) { // from class: java.util.TreeMap.KeySet.1
                {
                    TreeMap treeMap = TreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return stepForward().key;
                }
            };
        }

        @Override // java.util.SortedSet
        public K last() {
            return (K) TreeMap.this.lastKey();
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return (K) TreeMap.this.lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            Map.Entry internalPollFirstEntry = TreeMap.this.internalPollFirstEntry();
            if (internalPollFirstEntry != null) {
                return (K) internalPollFirstEntry.getKey();
            }
            return null;
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            Map.Entry internalPollLastEntry = TreeMap.this.internalPollLastEntry();
            if (internalPollLastEntry != null) {
                return (K) internalPollLastEntry.getKey();
            }
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return TreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return TreeMap.this.size;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return TreeMap.this.subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return TreeMap.this.subMap(k, true, k2, false).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return TreeMap.this.tailMap(k, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return TreeMap.this.tailMap(k, true).navigableKeySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$MapIterator.class */
    public abstract class MapIterator<T> implements Iterator<T> {
        protected int expectedModCount;
        protected Node<K, V> last;
        protected Node<K, V> next;

        MapIterator(Node<K, V> node) {
            this.expectedModCount = TreeMap.this.modCount;
            this.next = node;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == null) {
                throw new IllegalStateException();
            }
            TreeMap.this.removeInternal(this.last);
            this.expectedModCount = TreeMap.this.modCount;
            this.last = null;
        }

        protected Node<K, V> stepBackward() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            if (TreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.last = this.next;
            this.next = this.next.prev();
            return this.last;
        }

        protected Node<K, V> stepForward() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            if (TreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.last = this.next;
            this.next = this.next.next();
            return this.last;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$NavigableSubMap.class */
    static abstract class NavigableSubMap<K, V> extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = -2102997345730753016L;
        boolean fromStart;
        Object hi;
        boolean hiInclusive;
        Object lo;
        boolean loInclusive;
        TreeMap<K, V> m;
        boolean toEnd;

        NavigableSubMap(TreeMap<K, V> treeMap, K k, Bound bound, K k2, Bound bound2) {
            this.m = treeMap;
            this.lo = k;
            this.hi = k2;
            this.fromStart = bound == Bound.NO_BOUND;
            this.toEnd = bound2 == Bound.NO_BOUND;
            this.loInclusive = bound == Bound.INCLUSIVE;
            this.hiInclusive = bound2 == Bound.INCLUSIVE;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
        }

        protected Object readResolve() throws ObjectStreamException {
            Bound bound = this.fromStart ? Bound.NO_BOUND : this.loInclusive ? Bound.INCLUSIVE : Bound.EXCLUSIVE;
            Bound bound2 = this.toEnd ? Bound.NO_BOUND : this.hiInclusive ? Bound.INCLUSIVE : Bound.EXCLUSIVE;
            boolean z = !(this instanceof DescendingSubMap);
            TreeMap<K, V> treeMap = this.m;
            treeMap.getClass();
            return new BoundedMap(z, this.lo, bound, this.hi, bound2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$Node.class */
    public static class Node<K, V> implements Map.Entry<K, V> {
        int height = 1;
        final K key;
        Node<K, V> left;
        Node<K, V> parent;
        Node<K, V> right;
        V value;

        Node(Node<K, V> node, K k) {
            this.parent = node;
            this.key = k;
        }

        Node<K, V> copy(Node<K, V> node) {
            Node<K, V> node2 = new Node<>(node, this.key);
            if (this.left != null) {
                node2.left = this.left.copy(node2);
            }
            if (this.right != null) {
                node2.right = this.right.copy(node2);
            }
            node2.value = this.value;
            node2.height = this.height;
            return node2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
            if (r0.getValue() != null) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
            if (r3.key.equals(r0.getKey()) != false) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
            if (r3.value.equals(r0.getValue()) == false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
            if (r0.getKey() == null) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r3.value != null) goto L12;
         */
        @Override // java.util.Map.Entry
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r0 = 0
                r6 = r0
                r0 = r6
                r5 = r0
                r0 = r4
                boolean r0 = r0 instanceof java.util.Map.Entry
                if (r0 == 0) goto L36
                r0 = r4
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                r4 = r0
                r0 = r3
                K r0 = r0.key
                if (r0 != 0) goto L38
                r0 = r6
                r5 = r0
                r0 = r4
                java.lang.Object r0 = r0.getKey()
                if (r0 != 0) goto L36
            L22:
                r0 = r3
                V r0 = r0.value
                if (r0 != 0) goto L4d
                r0 = r6
                r5 = r0
                r0 = r4
                java.lang.Object r0 = r0.getValue()
                if (r0 != 0) goto L36
            L34:
                r0 = 1
                r5 = r0
            L36:
                r0 = r5
                return r0
            L38:
                r0 = r6
                r5 = r0
                r0 = r3
                K r0 = r0.key
                r1 = r4
                java.lang.Object r1 = r1.getKey()
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L36
                goto L22
            L4d:
                r0 = r6
                r5 = r0
                r0 = r3
                V r0 = r0.value
                r1 = r4
                java.lang.Object r1 = r1.getValue()
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L36
                goto L34
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.TreeMap.Node.equals(java.lang.Object):boolean");
        }

        public Node<K, V> first() {
            Node<K, V> node = this;
            Node<K, V> node2 = node.left;
            while (true) {
                Node<K, V> node3 = node2;
                if (node3 == null) {
                    return node;
                }
                node = node3;
                node2 = node.left;
            }
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int i = 0;
            int hashCode = this.key == null ? 0 : this.key.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public Node<K, V> last() {
            Node<K, V> node = this;
            Node<K, V> node2 = node.right;
            while (true) {
                Node<K, V> node3 = node2;
                if (node3 == null) {
                    return node;
                }
                node = node3;
                node2 = node.right;
            }
        }

        Node<K, V> next() {
            Node<K, V> node;
            if (this.right != null) {
                node = this.right.first();
            } else {
                Node<K, V> node2 = this;
                Node<K, V> node3 = node2.parent;
                while (true) {
                    Node<K, V> node4 = node3;
                    if (node4 == null) {
                        return null;
                    }
                    node = node4;
                    if (node4.left == node2) {
                        break;
                    }
                    node2 = node4;
                    node3 = node4.parent;
                }
            }
            return node;
        }

        public Node<K, V> prev() {
            Node<K, V> node;
            if (this.left != null) {
                node = this.left.last();
            } else {
                Node<K, V> node2 = this;
                Node<K, V> node3 = node2.parent;
                while (true) {
                    Node<K, V> node4 = node3;
                    if (node4 == null) {
                        return null;
                    }
                    node = node4;
                    if (node4.right == node2) {
                        break;
                    }
                    node2 = node4;
                    node3 = node4.parent;
                }
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$Relation.class */
    public enum Relation {
        LOWER,
        FLOOR,
        EQUAL,
        CREATE,
        CEILING,
        HIGHER;

        Relation forOrder(boolean z) {
            if (z) {
                return this;
            }
            switch (AnonymousClass2.$SwitchMap$java$util$TreeMap$Relation[ordinal()]) {
                case 1:
                    return HIGHER;
                case 2:
                    return CEILING;
                case 3:
                    return EQUAL;
                case 4:
                    return FLOOR;
                case 5:
                    return LOWER;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/TreeMap$SubMap.class */
    class SubMap extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = -6520786458950516097L;
        Object fromKey;
        boolean fromStart;
        boolean toEnd;
        Object toKey;

        SubMap() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
        }

        protected Object readResolve() throws ObjectStreamException {
            return new BoundedMap(true, this.fromKey, this.fromStart ? Bound.NO_BOUND : Bound.INCLUSIVE, this.toKey, this.toEnd ? Bound.NO_BOUND : Bound.EXCLUSIVE);
        }
    }

    public TreeMap() {
        this.size = 0;
        this.modCount = 0;
        this.comparator = NATURAL_ORDER;
    }

    public TreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        if (comparator != null) {
            this.comparator = comparator;
        } else {
            this.comparator = NATURAL_ORDER;
        }
    }

    public TreeMap(Map<? extends K, ? extends V> map) {
        this();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putInternal(entry.getKey(), entry.getValue());
        }
    }

    public TreeMap(SortedMap<K, ? extends V> sortedMap) {
        this.size = 0;
        this.modCount = 0;
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator != null) {
            this.comparator = comparator;
        } else {
            this.comparator = NATURAL_ORDER;
        }
        for (Map.Entry<K, ? extends V> entry : sortedMap.entrySet()) {
            putInternal(entry.getKey(), entry.getValue());
        }
    }

    static int count(Iterator<?> it) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            it.next();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbstractMap.SimpleImmutableEntry<K, V> immutableCopy(Map.Entry<K, V> entry) {
        if (entry == null) {
            return null;
        }
        return new AbstractMap.SimpleImmutableEntry<>(entry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map.Entry<K, V> internalPollFirstEntry() {
        if (this.root == null) {
            return null;
        }
        Node<K, V> first = this.root.first();
        removeInternal(first);
        return first;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map.Entry<K, V> internalPollLastEntry() {
        if (this.root == null) {
            return null;
        }
        Node<K, V> last = this.root.last();
        removeInternal(last);
        return last;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.comparator = (Comparator) objectInputStream.readFields().get("comparator", (Object) null);
        if (this.comparator == null) {
            this.comparator = NATURAL_ORDER;
        }
        int readInt = objectInputStream.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            putInternal(objectInputStream.readObject(), objectInputStream.readObject());
            i = i2 + 1;
        }
    }

    private void rebalance(Node<K, V> node, boolean z) {
        while (node != null) {
            Node<K, V> node2 = node.left;
            Node<K, V> node3 = node.right;
            int i = node2 != null ? node2.height : 0;
            int i2 = node3 != null ? node3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                Node<K, V> node4 = node3.left;
                Node<K, V> node5 = node3.right;
                int i4 = (node4 != null ? node4.height : 0) - (node5 != null ? node5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    rotateLeft(node);
                } else {
                    rotateRight(node3);
                    rotateLeft(node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                Node<K, V> node6 = node2.left;
                Node<K, V> node7 = node2.right;
                int i5 = (node6 != null ? node6.height : 0) - (node7 != null ? node7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    rotateRight(node);
                } else {
                    rotateLeft(node2);
                    rotateRight(node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                node.height = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 == null) {
            this.root = node2;
        } else if (node3.left == node) {
            node3.left = node2;
        } else {
            node3.right = node2;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node3.left;
        Node<K, V> node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        node.height = Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
        int i = node.height;
        int i2 = 0;
        if (node5 != null) {
            i2 = node5.height;
        }
        node3.height = Math.max(i, i2) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node2.left;
        Node<K, V> node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        node.height = Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
        int i = node.height;
        int i2 = 0;
        if (node4 != null) {
            i2 = node4.height;
        }
        node2.height = Math.max(i, i2) + 1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.putFields().put("comparator", comparator());
        objectOutputStream.writeFields();
        objectOutputStream.writeInt(this.size);
        for (Map.Entry<K, V> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        return immutableCopy(find(k, Relation.CEILING));
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        Node<K, V> find = find(k, Relation.CEILING);
        if (find != null) {
            return find.getKey();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        Node<K, V> node = null;
        try {
            TreeMap treeMap = (TreeMap) super.clone();
            if (this.root != null) {
                node = this.root.copy(null);
            }
            treeMap.root = node;
            treeMap.entrySet = null;
            treeMap.keySet = null;
            return treeMap;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        if (this.comparator != NATURAL_ORDER) {
            return this.comparator;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return new BoundedMap(false, null, Bound.NO_BOUND, null, Bound.NO_BOUND).navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new BoundedMap(false, null, Bound.NO_BOUND, null, Bound.NO_BOUND);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        TreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        TreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    Node<K, V> find(K k, Relation relation) {
        Node<K, V> node;
        if (this.root != null) {
            Comparable comparable = this.comparator == NATURAL_ORDER ? (Comparable) k : null;
            Node<K, V> node2 = this.root;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(node2.key) : this.comparator.compare(k, (K) node2.key);
                if (compareTo == 0) {
                    switch (AnonymousClass2.$SwitchMap$java$util$TreeMap$Relation[relation.ordinal()]) {
                        case 1:
                            return node2.prev();
                        case 2:
                        case 3:
                        case 4:
                        case 6:
                            return node2;
                        case 5:
                            return node2.next();
                    }
                }
                Node<K, V> node3 = compareTo < 0 ? node2.left : node2.right;
                if (node3 == null) {
                    if (compareTo < 0) {
                        node = null;
                        switch (AnonymousClass2.$SwitchMap$java$util$TreeMap$Relation[relation.ordinal()]) {
                            case 1:
                            case 2:
                                return node2.prev();
                            case 4:
                            case 5:
                                return node2;
                            case 6:
                                Node<K, V> node4 = new Node<>(node2, k);
                                node2.left = node4;
                                this.size++;
                                this.modCount++;
                                rebalance(node2, true);
                                return node4;
                        }
                    }
                    node = null;
                    switch (AnonymousClass2.$SwitchMap$java$util$TreeMap$Relation[relation.ordinal()]) {
                        case 1:
                        case 2:
                            return node2;
                        case 4:
                        case 5:
                            return node2.next();
                        case 6:
                            Node<K, V> node5 = new Node<>(node2, k);
                            node2.right = node5;
                            this.size++;
                            this.modCount++;
                            rebalance(node2, true);
                            return node5;
                    }
                }
                node2 = node3;
            }
        } else if (this.comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        } else {
            node = null;
            if (relation == Relation.CREATE) {
                this.root = new Node<>(null, k);
                this.size = 1;
                this.modCount++;
                node = this.root;
            }
        }
        return node;
    }

    Node<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Node<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && libcore.util.Objects.equal(findByObject.value, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    Node<K, V> findByObject(Object obj) {
        return find(obj, Relation.EQUAL);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return immutableCopy(this.root == null ? null : this.root.first());
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        if (this.root == null) {
            throw new NoSuchElementException();
        }
        return this.root.first().getKey();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        return immutableCopy(find(k, Relation.FLOOR));
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        Node<K, V> find = find(k, Relation.FLOOR);
        if (find != null) {
            return find.getKey();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.getValue();
        }
        return null;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k, boolean z) {
        return new BoundedMap(true, null, Bound.NO_BOUND, k, z ? Bound.INCLUSIVE : Bound.EXCLUSIVE);
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K k) {
        return new BoundedMap(true, null, Bound.NO_BOUND, k, Bound.EXCLUSIVE);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        return immutableCopy(find(k, Relation.HIGHER));
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        Node<K, V> find = find(k, Relation.HIGHER);
        if (find != null) {
            return find.getKey();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        TreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        TreeMap<K, V>.KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return immutableCopy(this.root == null ? null : this.root.last());
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        if (this.root == null) {
            throw new NoSuchElementException();
        }
        return this.root.last().getKey();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        return immutableCopy(find(k, Relation.LOWER));
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        Node<K, V> find = find(k, Relation.LOWER);
        if (find != null) {
            return find.getKey();
        }
        return null;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        TreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        TreeMap<K, V>.KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return immutableCopy(internalPollFirstEntry());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return immutableCopy(internalPollLastEntry());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        return putInternal(k, v);
    }

    V putInternal(K k, V v) {
        Node<K, V> find = find(k, Relation.CREATE);
        V v2 = find.value;
        find.value = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    void removeInternal(Node<K, V> node) {
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node.parent;
        if (node2 == null || node3 == null) {
            if (node2 != null) {
                replaceInParent(node, node2);
                node.left = null;
            } else if (node3 != null) {
                replaceInParent(node, node3);
                node.right = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(node4, false);
            this.size--;
            this.modCount++;
            return;
        }
        Node<K, V> last = node2.height > node3.height ? node2.last() : node3.first();
        removeInternal(last);
        int i = 0;
        Node<K, V> node5 = node.left;
        if (node5 != null) {
            i = node5.height;
            last.left = node5;
            node5.parent = last;
            node.left = null;
        }
        int i2 = 0;
        Node<K, V> node6 = node.right;
        if (node6 != null) {
            i2 = node6.height;
            last.right = node6;
            node6.parent = last;
            node.right = null;
        }
        last.height = Math.max(i, i2) + 1;
        replaceInParent(node, last);
    }

    Node<K, V> removeInternalByKey(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        return new BoundedMap(true, k, z ? Bound.INCLUSIVE : Bound.EXCLUSIVE, k2, z2 ? Bound.INCLUSIVE : Bound.EXCLUSIVE);
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return new BoundedMap(true, k, Bound.INCLUSIVE, k2, Bound.EXCLUSIVE);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k, boolean z) {
        return new BoundedMap(true, k, z ? Bound.INCLUSIVE : Bound.EXCLUSIVE, null, Bound.NO_BOUND);
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K k) {
        return new BoundedMap(true, k, Bound.INCLUSIVE, null, Bound.NO_BOUND);
    }
}
