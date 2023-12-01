package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/util/Collections.class */
public class Collections {
    private static final Iterator<?> EMPTY_ITERATOR = new Iterator<Object>() { // from class: java.util.Collections.1
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    };
    private static final Enumeration<?> EMPTY_ENUMERATION = new Enumeration<Object>() { // from class: java.util.Collections.2
        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException();
        }
    };
    public static final List EMPTY_LIST = new EmptyList();
    public static final Set EMPTY_SET = new EmptySet();
    public static final Map EMPTY_MAP = new EmptyMap();

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$AsLIFOQueue.class */
    private static class AsLIFOQueue<E> extends AbstractQueue<E> implements Serializable {
        private static final long serialVersionUID = 1802017725587941708L;
        private final Deque<E> q;

        AsLIFOQueue(Deque<E> deque) {
            this.q = deque;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            this.q.push(e);
            return true;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.q.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.q.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.q.containsAll(collection);
        }

        @Override // java.util.AbstractQueue, java.util.Queue
        public E element() {
            return this.q.getFirst();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.q.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return this.q.iterator();
        }

        @Override // java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(E e) {
            return this.q.offerFirst(e);
        }

        @Override // java.util.Queue
        public E peek() {
            return this.q.peekFirst();
        }

        @Override // java.util.Queue
        public E poll() {
            return this.q.pollFirst();
        }

        @Override // java.util.AbstractQueue, java.util.Queue
        public E remove() {
            return this.q.pop();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.q.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return this.q.removeAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return this.q.retainAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.q.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.q.toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.q.toArray(tArr);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.q.toString();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedCollection.class */
    private static class CheckedCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1578914078182001775L;

        /* renamed from: c  reason: collision with root package name */
        final Collection<E> f42263c;
        final Class<E> type;

        public CheckedCollection(Collection<E> collection, Class<E> cls) {
            if (collection == null) {
                throw new NullPointerException("c == null");
            }
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            this.f42263c = collection;
            this.type = cls;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public boolean add(E e) {
            return this.f42263c.add(Collections.checkType(e, this.type));
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            Object[] array = collection.toArray();
            int length = array.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return this.f42263c.addAll(Arrays.asList(array));
                }
                Collections.checkType(array[i2], this.type);
                i = i2 + 1;
            }
        }

        @Override // java.util.Collection, java.util.Set
        public void clear() {
            this.f42263c.clear();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f42263c.contains(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f42263c.containsAll(collection);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f42263c.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            Iterator<E> it = this.f42263c.iterator();
            CheckedListIterator checkedListIterator = it;
            if (it instanceof ListIterator) {
                checkedListIterator = new CheckedListIterator((ListIterator) it, this.type);
            }
            return checkedListIterator;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.f42263c.remove(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return this.f42263c.removeAll(collection);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return this.f42263c.retainAll(collection);
        }

        @Override // java.util.Collection, java.util.List
        public int size() {
            return this.f42263c.size();
        }

        @Override // java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.f42263c.toArray();
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.f42263c.toArray(tArr);
        }

        public String toString() {
            return this.f42263c.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedList.class */
    public static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
        private static final long serialVersionUID = 65247728283967356L;
        final List<E> l;

        public CheckedList(List<E> list, Class<E> cls) {
            super(list, cls);
            this.l = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public void add(int i, E e) {
            this.l.add(i, Collections.checkType(e, this.type));
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            Object[] array = collection.toArray();
            int length = array.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return this.l.addAll(i, Arrays.asList(array));
                }
                Collections.checkType(array[i3], this.type);
                i2 = i3 + 1;
            }
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this.l.equals(obj);
        }

        @Override // java.util.List
        public E get(int i) {
            return this.l.get(i);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.l.hashCode();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.l.indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.l.lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return new CheckedListIterator(this.l.listIterator(), this.type);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i) {
            return new CheckedListIterator(this.l.listIterator(i), this.type);
        }

        @Override // java.util.List
        public E remove(int i) {
            return this.l.remove(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public E set(int i, E e) {
            return (E) this.l.set(i, Collections.checkType(e, this.type));
        }

        @Override // java.util.List
        public List<E> subList(int i, int i2) {
            return Collections.checkedList(this.l.subList(i, i2), this.type);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedListIterator.class */
    private static class CheckedListIterator<E> implements ListIterator<E> {
        private final ListIterator<E> i;
        private final Class<E> type;

        public CheckedListIterator(ListIterator<E> listIterator, Class<E> cls) {
            this.i = listIterator;
            this.type = cls;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.ListIterator
        public void add(E e) {
            this.i.add(Collections.checkType(e, this.type));
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.i.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.i.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            return this.i.next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.i.nextIndex();
        }

        @Override // java.util.ListIterator
        public E previous() {
            return this.i.previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.i.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.i.remove();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.ListIterator
        public void set(E e) {
            this.i.set(Collections.checkType(e, this.type));
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedMap.class */
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = 5742860141034234728L;
        final Class<K> keyType;
        final Map<K, V> m;
        final Class<V> valueType;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedMap$CheckedEntry.class */
        public static class CheckedEntry<K, V> implements Map.Entry<K, V> {
            final Map.Entry<K, V> e;
            final Class<V> valueType;

            public CheckedEntry(Map.Entry<K, V> entry, Class<V> cls) {
                if (entry == null) {
                    throw new NullPointerException("e == null");
                }
                this.e = entry;
                this.valueType = cls;
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object obj) {
                return this.e.equals(obj);
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.e.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return this.e.getValue();
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.e.hashCode();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Map.Entry
            public V setValue(V v) {
                return (V) this.e.setValue(Collections.checkType(v, this.valueType));
            }
        }

        /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedMap$CheckedEntrySet.class */
        private static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            final Set<Map.Entry<K, V>> s;
            final Class<V> valueType;

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedMap$CheckedEntrySet$CheckedEntryIterator.class */
            public static class CheckedEntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
                Iterator<Map.Entry<K, V>> i;
                Class<V> valueType;

                public CheckedEntryIterator(Iterator<Map.Entry<K, V>> it, Class<V> cls) {
                    this.i = it;
                    this.valueType = cls;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.i.hasNext();
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return new CheckedEntry(this.i.next(), this.valueType);
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.i.remove();
                }
            }

            public CheckedEntrySet(Set<Map.Entry<K, V>> set, Class<V> cls) {
                this.s = set;
                this.valueType = cls;
            }

            @Override // java.util.Set
            public /* bridge */ /* synthetic */ boolean add(Object obj) {
                return add((Map.Entry) ((Map.Entry) obj));
            }

            public boolean add(Map.Entry<K, V> entry) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Set
            public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Set
            public void clear() {
                this.s.clear();
            }

            @Override // java.util.Set
            public boolean contains(Object obj) {
                return this.s.contains(obj);
            }

            @Override // java.util.Set
            public boolean containsAll(Collection<?> collection) {
                return this.s.containsAll(collection);
            }

            @Override // java.util.Set
            public boolean equals(Object obj) {
                return this.s.equals(obj);
            }

            @Override // java.util.Set
            public int hashCode() {
                return this.s.hashCode();
            }

            @Override // java.util.Set
            public boolean isEmpty() {
                return this.s.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                return new CheckedEntryIterator(this.s.iterator(), this.valueType);
            }

            @Override // java.util.Set
            public boolean remove(Object obj) {
                return this.s.remove(obj);
            }

            @Override // java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return this.s.removeAll(collection);
            }

            @Override // java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return this.s.retainAll(collection);
            }

            @Override // java.util.Set, java.util.Collection, java.util.List
            public int size() {
                return this.s.size();
            }

            @Override // java.util.Set
            public Object[] toArray() {
                int size = size();
                Object[] objArr = new Object[size];
                Iterator<Map.Entry<K, V>> it = iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        return objArr;
                    }
                    objArr[i2] = it.next();
                    i = i2 + 1;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.Object[]] */
            @Override // java.util.Set
            public <T> T[] toArray(T[] tArr) {
                int size = size();
                T[] tArr2 = tArr;
                if (tArr.length < size) {
                    tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
                }
                Iterator<Map.Entry<K, V>> it = iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    tArr2[i2] = it.next();
                    i = i2 + 1;
                }
                if (size < tArr2.length) {
                    tArr2[size] = null;
                }
                return tArr2;
            }
        }

        private CheckedMap(Map<K, V> map, Class<K> cls, Class<V> cls2) {
            if (map == null) {
                throw new NullPointerException("m == null");
            }
            if (cls == null) {
                throw new NullPointerException("keyType == null");
            }
            if (cls2 == null) {
                throw new NullPointerException("valueType == null");
            }
            this.m = map;
            this.keyType = cls;
            this.valueType = cls2;
        }

        @Override // java.util.Map
        public void clear() {
            this.m.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.m.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.m.containsValue(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new CheckedEntrySet(this.m.entrySet(), this.valueType);
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return this.m.equals(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.m.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return this.m.keySet();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public V put(K k, V v) {
            return (V) this.m.put(Collections.checkType(k, this.keyType), Collections.checkType(v, this.valueType));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            int size = map.size();
            if (size == 0) {
                return;
            }
            Map.Entry[] entryArr = new Map.Entry[size];
            Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                Map.Entry<? extends K, ? extends V> next = it.next();
                Collections.checkType(next.getKey(), this.keyType);
                Collections.checkType(next.getValue(), this.valueType);
                entryArr[i2] = next;
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    return;
                }
                this.m.put(entryArr[i4].getKey(), entryArr[i4].getValue());
                i3 = i4 + 1;
            }
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            return this.m.remove(obj);
        }

        @Override // java.util.Map
        public int size() {
            return this.m.size();
        }

        public String toString() {
            return this.m.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return this.m.values();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedRandomAccessList.class */
    public static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        private static final long serialVersionUID = 1638200125423088369L;

        public CheckedRandomAccessList(List<E> list, Class<E> cls) {
            super(list, cls);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedSet.class */
    private static class CheckedSet<E> extends CheckedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 4694047833775013803L;

        public CheckedSet(Set<E> set, Class<E> cls) {
            super(set, cls);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this.f42263c.equals(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f42263c.hashCode();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedSortedMap.class */
    private static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 1599671320688067438L;
        final SortedMap<K, V> sm;

        CheckedSortedMap(SortedMap<K, V> sortedMap, Class<K> cls, Class<V> cls2) {
            super(sortedMap, cls, cls2);
            this.sm = sortedMap;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sm.comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return this.sm.firstKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k) {
            return new CheckedSortedMap(this.sm.headMap(k), this.keyType, this.valueType);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return this.sm.lastKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return new CheckedSortedMap(this.sm.subMap(k, k2), this.keyType, this.valueType);
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k) {
            return new CheckedSortedMap(this.sm.tailMap(k), this.keyType, this.valueType);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CheckedSortedSet.class */
    private static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 1599911165492914959L;
        private final SortedSet<E> ss;

        public CheckedSortedSet(SortedSet<E> sortedSet, Class<E> cls) {
            super(sortedSet, cls);
            this.ss = sortedSet;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return this.ss.comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return this.ss.first();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e) {
            return new CheckedSortedSet(this.ss.headSet(e), this.type);
        }

        @Override // java.util.SortedSet
        public E last() {
            return this.ss.last();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e, E e2) {
            return new CheckedSortedSet(this.ss.subSet(e, e2), this.type);
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e) {
            return new CheckedSortedSet(this.ss.tailSet(e), this.type);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$CopiesList.class */
    private static final class CopiesList<E> extends AbstractList<E> implements Serializable {
        private static final long serialVersionUID = 2739099268398711800L;
        private final E element;
        private final int n;

        CopiesList(int i, E e) {
            if (i < 0) {
                throw new IllegalArgumentException("length < 0: " + i);
            }
            this.n = i;
            this.element = e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.element == null ? obj == null : this.element.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i < 0 || i >= this.n) {
                throw new IndexOutOfBoundsException();
            }
            return this.element;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.n;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$EmptyList.class */
    private static final class EmptyList extends AbstractList implements RandomAccess, Serializable {
        private static final long serialVersionUID = 8842843931221139166L;

        private EmptyList() {
        }

        private Object readResolve() {
            return Collections.EMPTY_LIST;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 0;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$EmptyMap.class */
    private static final class EmptyMap extends AbstractMap implements Serializable {
        private static final long serialVersionUID = 6428348081105594320L;

        private EmptyMap() {
        }

        private Object readResolve() {
            return Collections.EMPTY_MAP;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            return Collections.EMPTY_LIST;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$EmptySet.class */
    private static final class EmptySet extends AbstractSet implements Serializable {
        private static final long serialVersionUID = 1582296315990362920L;

        private EmptySet() {
        }

        private Object readResolve() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Collections.EMPTY_ITERATOR;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$ReverseComparator.class */
    public static final class ReverseComparator<T> implements Comparator<T>, Serializable {
        private static final ReverseComparator<Object> INSTANCE = new ReverseComparator<>();
        private static final long serialVersionUID = 7207038068494060240L;

        private ReverseComparator() {
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return ((Comparable) t2).compareTo(t);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$ReverseComparator2.class */
    private static final class ReverseComparator2<T> implements Comparator<T>, Serializable {
        private static final long serialVersionUID = 4374092139857L;
        private final Comparator<T> cmp;

        ReverseComparator2(Comparator<T> comparator) {
            this.cmp = comparator;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return this.cmp.compare(t2, t);
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return (obj instanceof ReverseComparator2) && ((ReverseComparator2) obj).cmp.equals(this.cmp);
        }

        public int hashCode() {
            return this.cmp.hashCode() ^ (-1);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SetFromMap.class */
    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 2454657854757543876L;
        private transient Set<E> backingSet;
        private final Map<E, Boolean> m;

        SetFromMap(Map<E, Boolean> map) {
            this.m = map;
            this.backingSet = map.keySet();
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.backingSet = this.m.keySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            return this.m.put(e, Boolean.TRUE) == null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.m.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.backingSet.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.backingSet.containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this.backingSet.equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.backingSet.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return this.backingSet.iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.m.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return this.backingSet.retainAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.m.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.backingSet.toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.backingSet.toArray(tArr);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.backingSet.toString();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SingletonList.class */
    private static final class SingletonList<E> extends AbstractList<E> implements Serializable {
        private static final long serialVersionUID = 3093736618740652951L;
        final E element;

        SingletonList(E e) {
            this.element = e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.element == null ? obj == null : this.element.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SingletonMap.class */
    public static final class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = -6979724477215052911L;
        final K k;
        final V v;

        SingletonMap(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.k == null ? obj == null : this.k.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.v == null ? obj == null : this.v.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new AbstractSet<Map.Entry<K, V>>() { // from class: java.util.Collections.SingletonMap.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    boolean z = false;
                    if (obj instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) obj;
                        z = false;
                        if (SingletonMap.this.containsKey(entry.getKey())) {
                            z = false;
                            if (SingletonMap.this.containsValue(entry.getValue())) {
                                z = true;
                            }
                        }
                    }
                    return z;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator<Map.Entry<K, V>> iterator() {
                    return new Iterator<Map.Entry<K, V>>() { // from class: java.util.Collections.SingletonMap.1.1
                        boolean hasNext = true;

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            return this.hasNext;
                        }

                        @Override // java.util.Iterator
                        public Map.Entry<K, V> next() {
                            if (this.hasNext) {
                                this.hasNext = false;
                                return new MapEntry<K, V>(SingletonMap.this.k, SingletonMap.this.v) { // from class: java.util.Collections.SingletonMap.1.1.1
                                    @Override // java.util.MapEntry, java.util.Map.Entry
                                    public V setValue(V v) {
                                        throw new UnsupportedOperationException();
                                    }
                                };
                            }
                            throw new NoSuchElementException();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            throw new UnsupportedOperationException();
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return 1;
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (containsKey(obj)) {
                return this.v;
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return 1;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SingletonSet.class */
    private static final class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 3193687207550431679L;
        final E element;

        SingletonSet(E e) {
            this.element = e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.element == null ? obj == null : this.element.equals(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return new Iterator<E>() { // from class: java.util.Collections.SingletonSet.1
                boolean hasNext = true;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.hasNext;
                }

                @Override // java.util.Iterator
                public E next() {
                    if (this.hasNext) {
                        this.hasNext = false;
                        return SingletonSet.this.element;
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 1;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SynchronizedCollection.class */
    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 3053995032091335093L;

        /* renamed from: c  reason: collision with root package name */
        final Collection<E> f42264c;
        final Object mutex;

        SynchronizedCollection(Collection<E> collection) {
            this.f42264c = collection;
            this.mutex = this;
        }

        SynchronizedCollection(Collection<E> collection, Object obj) {
            this.f42264c = collection;
            this.mutex = obj;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(E e) {
            boolean add;
            synchronized (this.mutex) {
                add = this.f42264c.add(e);
            }
            return add;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = this.f42264c.addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.Set
        public void clear() {
            synchronized (this.mutex) {
                this.f42264c.clear();
            }
        }

        @Override // java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = this.f42264c.contains(obj);
            }
            return contains;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = this.f42264c.containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = this.f42264c.isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            Iterator<E> it;
            synchronized (this.mutex) {
                it = this.f42264c.iterator();
            }
            return it;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = this.f42264c.remove(obj);
            }
            return remove;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = this.f42264c.removeAll(collection);
            }
            return removeAll;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = this.f42264c.retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection, java.util.List
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = this.f42264c.size();
            }
            return size;
        }

        @Override // java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = this.f42264c.toArray();
            }
            return array;
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) this.f42264c.toArray(tArr);
            }
            return tArr2;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.f42264c.toString();
            }
            return obj;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SynchronizedList.class */
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = -7754090372962971524L;
        final List<E> list;

        SynchronizedList(List<E> list) {
            super(list);
            this.list = list;
        }

        SynchronizedList(List<E> list, Object obj) {
            super(list, obj);
            this.list = list;
        }

        private Object readResolve() {
            SynchronizedRandomAccessList synchronizedRandomAccessList = this;
            if (this.list instanceof RandomAccess) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list, this.mutex);
            }
            return synchronizedRandomAccessList;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        @Override // java.util.List
        public void add(int i, E e) {
            synchronized (this.mutex) {
                this.list.add(i, e);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = this.list.addAll(i, collection);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = this.list.equals(obj);
            }
            return equals;
        }

        @Override // java.util.List
        public E get(int i) {
            E e;
            synchronized (this.mutex) {
                e = this.list.get(i);
            }
            return e;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int size;
            Object[] objArr;
            synchronized (this.mutex) {
                size = this.list.size();
                objArr = new Object[size];
                this.list.toArray(objArr);
            }
            if (obj != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        return -1;
                    }
                    if (obj.equals(objArr[i2])) {
                        return i2;
                    }
                    i = i2 + 1;
                }
            } else {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size) {
                        return -1;
                    }
                    if (objArr[i4] == null) {
                        return i4;
                    }
                    i3 = i4 + 1;
                }
            }
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int size;
            Object[] objArr;
            synchronized (this.mutex) {
                size = this.list.size();
                objArr = new Object[size];
                this.list.toArray(objArr);
            }
            if (obj != null) {
                while (true) {
                    size--;
                    if (size < 0) {
                        return -1;
                    }
                    if (obj.equals(objArr[size])) {
                        return size;
                    }
                }
            } else {
                while (true) {
                    size--;
                    if (size < 0) {
                        return -1;
                    }
                    if (objArr[size] == null) {
                        return size;
                    }
                }
            }
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            ListIterator<E> listIterator;
            synchronized (this.mutex) {
                listIterator = this.list.listIterator();
            }
            return listIterator;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i) {
            ListIterator<E> listIterator;
            synchronized (this.mutex) {
                listIterator = this.list.listIterator(i);
            }
            return listIterator;
        }

        @Override // java.util.List
        public E remove(int i) {
            E remove;
            synchronized (this.mutex) {
                remove = this.list.remove(i);
            }
            return remove;
        }

        @Override // java.util.List
        public E set(int i, E e) {
            E e2;
            synchronized (this.mutex) {
                e2 = this.list.set(i, e);
            }
            return e2;
        }

        @Override // java.util.List
        public List<E> subList(int i, int i2) {
            SynchronizedList synchronizedList;
            synchronized (this.mutex) {
                synchronizedList = new SynchronizedList(this.list.subList(i, i2), this.mutex);
            }
            return synchronizedList;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SynchronizedMap.class */
    static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = 1978198479659022715L;
        private final Map<K, V> m;
        final Object mutex;

        SynchronizedMap(Map<K, V> map) {
            this.m = map;
            this.mutex = this;
        }

        SynchronizedMap(Map<K, V> map, Object obj) {
            this.m = map;
            this.mutex = obj;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                this.m.clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = this.m.containsKey(obj);
            }
            return containsKey;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = this.m.containsValue(obj);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            SynchronizedSet synchronizedSet;
            synchronized (this.mutex) {
                synchronizedSet = new SynchronizedSet(this.m.entrySet(), this.mutex);
            }
            return synchronizedSet;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = this.m.equals(obj);
            }
            return equals;
        }

        @Override // java.util.Map
        public V get(Object obj) {
            V v;
            synchronized (this.mutex) {
                v = this.m.get(obj);
            }
            return v;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.m.hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = this.m.isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            SynchronizedSet synchronizedSet;
            synchronized (this.mutex) {
                synchronizedSet = new SynchronizedSet(this.m.keySet(), this.mutex);
            }
            return synchronizedSet;
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            V put;
            synchronized (this.mutex) {
                put = this.m.put(k, v);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                this.m.putAll(map);
            }
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = this.m.remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = this.m.size();
            }
            return size;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.m.toString();
            }
            return obj;
        }

        @Override // java.util.Map
        public Collection<V> values() {
            SynchronizedCollection synchronizedCollection;
            synchronized (this.mutex) {
                synchronizedCollection = new SynchronizedCollection(this.m.values(), this.mutex);
            }
            return synchronizedCollection;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SynchronizedRandomAccessList.class */
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 1530674583602358482L;

        SynchronizedRandomAccessList(List<E> list) {
            super(list);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SynchronizedRandomAccessList(List<E> list, Object obj) {
            super(list, obj);
        }

        private Object writeReplace() {
            return new SynchronizedList(this.list);
        }

        @Override // java.util.Collections.SynchronizedList, java.util.List
        public List<E> subList(int i, int i2) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.mutex) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(i, i2), this.mutex);
            }
            return synchronizedRandomAccessList;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SynchronizedSet.class */
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 487447009682186044L;

        SynchronizedSet(Set<E> set) {
            super(set);
        }

        SynchronizedSet(Set<E> set, Object obj) {
            super(set, obj);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = this.f42264c.equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.f42264c.hashCode();
            }
            return hashCode;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SynchronizedSortedMap.class */
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = -8798146769416483793L;
        private final SortedMap<K, V> sm;

        SynchronizedSortedMap(SortedMap<K, V> sortedMap) {
            super(sortedMap);
            this.sm = sortedMap;
        }

        SynchronizedSortedMap(SortedMap<K, V> sortedMap, Object obj) {
            super(sortedMap, obj);
            this.sm = sortedMap;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = this.sm.comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = this.sm.firstKey();
            }
            return firstKey;
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.headMap(k), this.mutex);
            }
            return synchronizedSortedMap;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = this.sm.lastKey();
            }
            return lastKey;
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k, K k2) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.subMap(k, k2), this.mutex);
            }
            return synchronizedSortedMap;
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.tailMap(k), this.mutex);
            }
            return synchronizedSortedMap;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$SynchronizedSortedSet.class */
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 8695801310862127406L;
        private final SortedSet<E> ss;

        SynchronizedSortedSet(SortedSet<E> sortedSet) {
            super(sortedSet);
            this.ss = sortedSet;
        }

        SynchronizedSortedSet(SortedSet<E> sortedSet, Object obj) {
            super(sortedSet, obj);
            this.ss = sortedSet;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = this.ss.comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = this.ss.first();
            }
            return first;
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.mutex) {
                synchronizedSortedSet = new SynchronizedSortedSet(this.ss.headSet(e), this.mutex);
            }
            return synchronizedSortedSet;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = this.ss.last();
            }
            return last;
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e, E e2) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.mutex) {
                synchronizedSortedSet = new SynchronizedSortedSet(this.ss.subSet(e, e2), this.mutex);
            }
            return synchronizedSortedSet;
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.mutex) {
                synchronizedSortedSet = new SynchronizedSortedSet(this.ss.tailSet(e), this.mutex);
            }
            return synchronizedSortedSet;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$UnmodifiableCollection.class */
    private static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1820017752578914078L;

        /* renamed from: c  reason: collision with root package name */
        final Collection<E> f42265c;

        UnmodifiableCollection(Collection<E> collection) {
            this.f42265c = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f42265c.contains(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f42265c.containsAll(collection);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f42265c.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return new Iterator<E>() { // from class: java.util.Collections.UnmodifiableCollection.1
                Iterator<E> iterator;

                {
                    this.iterator = UnmodifiableCollection.this.f42265c.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.iterator.hasNext();
                }

                @Override // java.util.Iterator
                public E next() {
                    return this.iterator.next();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.List
        public int size() {
            return this.f42265c.size();
        }

        @Override // java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.f42265c.toArray();
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.f42265c.toArray(tArr);
        }

        public String toString() {
            return this.f42265c.toString();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$UnmodifiableList.class */
    private static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        private static final long serialVersionUID = -283967356065247728L;
        final List<E> list;

        UnmodifiableList(List<E> list) {
            super(list);
            this.list = list;
        }

        private Object readResolve() {
            UnmodifiableRandomAccessList unmodifiableRandomAccessList = this;
            if (this.list instanceof RandomAccess) {
                unmodifiableRandomAccessList = new UnmodifiableRandomAccessList(this.list);
            }
            return unmodifiableRandomAccessList;
        }

        @Override // java.util.List
        public void add(int i, E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this.list.equals(obj);
        }

        @Override // java.util.List
        public E get(int i) {
            return this.list.get(i);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.list.hashCode();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.list.indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.list.lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(final int i) {
            return new ListIterator<E>() { // from class: java.util.Collections.UnmodifiableList.1
                ListIterator<E> iterator;

                {
                    this.iterator = UnmodifiableList.this.list.listIterator(i);
                }

                @Override // java.util.ListIterator
                public void add(E e) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return this.iterator.hasNext();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return this.iterator.hasPrevious();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public E next() {
                    return this.iterator.next();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.iterator.nextIndex();
                }

                @Override // java.util.ListIterator
                public E previous() {
                    return this.iterator.previous();
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.iterator.previousIndex();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.ListIterator
                public void set(E e) {
                    throw new UnsupportedOperationException();
                }
            };
        }

        @Override // java.util.List
        public E remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public E set(int i, E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public List<E> subList(int i, int i2) {
            return new UnmodifiableList(this.list.subList(i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$UnmodifiableMap.class */
    public static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = -1034234728574286014L;
        private final Map<K, V> m;

        /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$UnmodifiableMap$UnmodifiableEntrySet.class */
        private static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            private static final long serialVersionUID = 7854390611657943733L;

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableMapEntry.class */
            public static class UnmodifiableMapEntry<K, V> implements Map.Entry<K, V> {
                Map.Entry<K, V> mapEntry;

                UnmodifiableMapEntry(Map.Entry<K, V> entry) {
                    this.mapEntry = entry;
                }

                @Override // java.util.Map.Entry
                public boolean equals(Object obj) {
                    return this.mapEntry.equals(obj);
                }

                @Override // java.util.Map.Entry
                public K getKey() {
                    return this.mapEntry.getKey();
                }

                @Override // java.util.Map.Entry
                public V getValue() {
                    return this.mapEntry.getValue();
                }

                @Override // java.util.Map.Entry
                public int hashCode() {
                    return this.mapEntry.hashCode();
                }

                @Override // java.util.Map.Entry
                public V setValue(V v) {
                    throw new UnsupportedOperationException();
                }

                public String toString() {
                    return this.mapEntry.toString();
                }
            }

            UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
                super(set);
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                return new Iterator<Map.Entry<K, V>>() { // from class: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.1
                    Iterator<Map.Entry<K, V>> iterator;

                    {
                        this.iterator = UnmodifiableEntrySet.this.f42265c.iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iterator.hasNext();
                    }

                    @Override // java.util.Iterator
                    public Map.Entry<K, V> next() {
                        return new UnmodifiableMapEntry(this.iterator.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                int size = this.f42265c.size();
                Object[] objArr = new Object[size];
                Iterator<Map.Entry<K, V>> it = iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        return objArr;
                    }
                    objArr[i2] = it.next();
                    i = i2 + 1;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.Object[]] */
            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                int i;
                int i2;
                int size = this.f42265c.size();
                Iterator<Map.Entry<K, V>> it = iterator();
                if (size > tArr.length) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
                    i = 0;
                } else {
                    i = 0;
                }
                while (true) {
                    i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    tArr[i2] = it.next();
                    i = i2 + 1;
                }
                if (i2 < tArr.length) {
                    tArr[i2] = null;
                }
                return tArr;
            }
        }

        UnmodifiableMap(Map<K, V> map) {
            this.m = map;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.m.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.m.containsValue(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new UnmodifiableEntrySet(this.m.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return this.m.equals(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.m.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new UnmodifiableSet(this.m.keySet());
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public int size() {
            return this.m.size();
        }

        public String toString() {
            return this.m.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new UnmodifiableCollection(this.m.values());
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$UnmodifiableRandomAccessList.class */
    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        private static final long serialVersionUID = -2542308836966382001L;

        UnmodifiableRandomAccessList(List<E> list) {
            super(list);
        }

        private Object writeReplace() {
            return new UnmodifiableList(this.list);
        }

        @Override // java.util.Collections.UnmodifiableList, java.util.List
        public List<E> subList(int i, int i2) {
            return new UnmodifiableRandomAccessList(this.list.subList(i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$UnmodifiableSet.class */
    public static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
        private static final long serialVersionUID = -9215047833775013803L;

        UnmodifiableSet(Set<E> set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this.f42265c.equals(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f42265c.hashCode();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$UnmodifiableSortedMap.class */
    private static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = -8806743815996713206L;
        private final SortedMap<K, V> sm;

        UnmodifiableSortedMap(SortedMap<K, V> sortedMap) {
            super(sortedMap);
            this.sm = sortedMap;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sm.comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return this.sm.firstKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k) {
            return new UnmodifiableSortedMap(this.sm.headMap(k));
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return this.sm.lastKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return new UnmodifiableSortedMap(this.sm.subMap(k, k2));
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k) {
            return new UnmodifiableSortedMap(this.sm.tailMap(k));
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Collections$UnmodifiableSortedSet.class */
    private static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = -4929149591599911165L;
        private final SortedSet<E> ss;

        UnmodifiableSortedSet(SortedSet<E> sortedSet) {
            super(sortedSet);
            this.ss = sortedSet;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return this.ss.comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return this.ss.first();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e) {
            return new UnmodifiableSortedSet(this.ss.headSet(e));
        }

        @Override // java.util.SortedSet
        public E last() {
            return this.ss.last();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e, E e2) {
            return new UnmodifiableSortedSet(this.ss.subSet(e, e2));
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e) {
            return new UnmodifiableSortedSet(this.ss.tailSet(e));
        }
    }

    private Collections() {
    }

    @SafeVarargs
    public static <T> boolean addAll(Collection<? super T> collection, T... tArr) {
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= tArr.length) {
                return z;
            }
            z |= collection.add((Object) tArr[i2]);
            i = i2 + 1;
        }
    }

    public static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return new AsLIFOQueue(deque);
    }

    public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T t) {
        int i;
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        if (list.isEmpty()) {
            i = -1;
        } else if (!(list instanceof RandomAccess)) {
            ListIterator<? extends Comparable<? super T>> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                int i2 = -listIterator.next().compareTo(t);
                if (i2 <= 0) {
                    return i2 == 0 ? listIterator.previousIndex() : (-listIterator.previousIndex()) - 1;
                }
            }
            return (-list.size()) - 1;
        } else {
            int i3 = 0;
            int size = list.size();
            int i4 = size - 1;
            int i5 = -1;
            while (true) {
                int i6 = i5;
                if (i3 > i4) {
                    return (-size) - (i6 < 0 ? 1 : 2);
                }
                size = (i3 + i4) >>> 1;
                int i7 = -list.get(size).compareTo(t);
                if (i7 <= 0) {
                    i = size;
                    if (i7 == 0) {
                        break;
                    }
                    i4 = size - 1;
                    i5 = i7;
                } else {
                    i3 = size + 1;
                    i5 = i7;
                }
            }
        }
        return i;
    }

    public static <T> int binarySearch(List<? extends T> list, T t, Comparator<? super T> comparator) {
        int i;
        if (comparator == null) {
            i = binarySearch(list, t);
        } else if (!(list instanceof RandomAccess)) {
            ListIterator<? extends T> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                int i2 = -comparator.compare((T) listIterator.next(), t);
                if (i2 <= 0) {
                    return i2 == 0 ? listIterator.previousIndex() : (-listIterator.previousIndex()) - 1;
                }
            }
            return (-list.size()) - 1;
        } else {
            int i3 = 0;
            int size = list.size();
            int i4 = size - 1;
            int i5 = -1;
            while (true) {
                int i6 = i5;
                if (i3 > i4) {
                    return (-size) - (i6 < 0 ? 1 : 2);
                }
                size = (i3 + i4) >>> 1;
                int i7 = -comparator.compare((T) list.get(size), t);
                if (i7 <= 0) {
                    i = size;
                    if (i7 == 0) {
                        break;
                    }
                    i4 = size - 1;
                    i5 = i7;
                } else {
                    i3 = size + 1;
                    i5 = i7;
                }
            }
        }
        return i;
    }

    static <E> E checkType(E e, Class<? extends E> cls) {
        if (e == null || cls.isInstance(e)) {
            return e;
        }
        throw new ClassCastException("Attempt to insert element of type " + e.getClass() + " into collection of type " + cls);
    }

    public static <E> Collection<E> checkedCollection(Collection<E> collection, Class<E> cls) {
        return new CheckedCollection(collection, cls);
    }

    public static <E> List<E> checkedList(List<E> list, Class<E> cls) {
        return list instanceof RandomAccess ? new CheckedRandomAccessList(list, cls) : new CheckedList(list, cls);
    }

    public static <K, V> Map<K, V> checkedMap(Map<K, V> map, Class<K> cls, Class<V> cls2) {
        return new CheckedMap(map, cls, cls2);
    }

    public static <E> Set<E> checkedSet(Set<E> set, Class<E> cls) {
        return new CheckedSet(set, cls);
    }

    public static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> sortedMap, Class<K> cls, Class<V> cls2) {
        return new CheckedSortedMap(sortedMap, cls, cls2);
    }

    public static <E> SortedSet<E> checkedSortedSet(SortedSet<E> sortedSet, Class<E> cls) {
        return new CheckedSortedSet(sortedSet, cls);
    }

    public static <T> void copy(List<? super T> list, List<? extends T> list2) {
        if (list.size() < list2.size()) {
            throw new IndexOutOfBoundsException("destination.size() < source.size(): " + list.size() + " < " + list2.size());
        }
        Iterator<? extends T> it = list2.iterator();
        ListIterator<? super T> listIterator = list.listIterator();
        while (it.hasNext()) {
            try {
                listIterator.next();
                listIterator.set((T) it.next());
            } catch (NoSuchElementException e) {
                throw new IndexOutOfBoundsException("Source size " + list2.size() + " does not fit into destination");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r4.size() > r3.size()) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean disjoint(java.util.Collection<?> r3, java.util.Collection<?> r4) {
        /*
            r0 = r3
            boolean r0 = r0 instanceof java.util.Set
            if (r0 == 0) goto Le
            r0 = r4
            boolean r0 = r0 instanceof java.util.Set
            if (r0 == 0) goto L21
        Le:
            r0 = r3
            r6 = r0
            r0 = r4
            r5 = r0
            r0 = r4
            int r0 = r0.size()
            r1 = r3
            int r1 = r1.size()
            if (r0 <= r1) goto L25
        L21:
            r0 = r3
            r5 = r0
            r0 = r4
            r6 = r0
        L25:
            r0 = r6
            java.util.Iterator r0 = r0.iterator()
            r3 = r0
        L2c:
            r0 = r3
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L46
            r0 = r5
            r1 = r3
            java.lang.Object r1 = r1.next()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L2c
            r0 = 0
            return r0
        L46:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.disjoint(java.util.Collection, java.util.Collection):boolean");
    }

    public static <T> Enumeration<T> emptyEnumeration() {
        return (Enumeration<T>) EMPTY_ENUMERATION;
    }

    public static <T> Iterator<T> emptyIterator() {
        return (Iterator<T>) EMPTY_ITERATOR;
    }

    public static final <T> List<T> emptyList() {
        return EMPTY_LIST;
    }

    public static <T> ListIterator<T> emptyListIterator() {
        return emptyList().listIterator();
    }

    public static final <K, V> Map<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    public static final <T> Set<T> emptySet() {
        return EMPTY_SET;
    }

    public static <T> Enumeration<T> enumeration(final Collection<T> collection) {
        return new Enumeration<T>() { // from class: java.util.Collections.3
            Iterator<T> it;

            {
                this.it = Collection.this.iterator();
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.it.hasNext();
            }

            @Override // java.util.Enumeration
            public T nextElement() {
                return this.it.next();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void fill(List<? super T> list, T t) {
        ListIterator<? super T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(t);
        }
    }

    public static int frequency(Collection<?> collection, Object obj) {
        int i;
        if (collection == null) {
            throw new NullPointerException("c == null");
        }
        if (!collection.isEmpty()) {
            int i2 = 0;
            Iterator<?> it = collection.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (obj == null) {
                    if (next == null) {
                        i2++;
                    }
                } else if (obj.equals(next)) {
                    i2++;
                }
            }
        } else {
            i = 0;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        r6 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x003d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b9 A[EDGE_INSN: B:55:0x00b9->B:37:0x00b9 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOfSubList(java.util.List<?> r3, java.util.List<?> r4) {
        /*
            r0 = 0
            r5 = r0
            r0 = r3
            int r0 = r0.size()
            r8 = r0
            r0 = r4
            int r0 = r0.size()
            r9 = r0
            r0 = r9
            r1 = r8
            if (r0 <= r1) goto L1d
            r0 = -1
            r5 = r0
        L1b:
            r0 = r5
            return r0
        L1d:
            r0 = r9
            if (r0 == 0) goto L1b
            r0 = r4
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r10 = r0
            r0 = r3
            r1 = r10
            int r0 = r0.indexOf(r1)
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            r1 = -1
            if (r0 != r1) goto L41
            r0 = -1
            return r0
        L3d:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L41:
            r0 = r5
            r1 = r8
            if (r0 >= r1) goto Ld1
            r0 = r8
            r1 = r5
            int r0 = r0 - r1
            r1 = r9
            if (r0 < r1) goto Ld1
            r0 = r3
            r1 = r5
            java.util.ListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = r10
            if (r0 != 0) goto L96
            r0 = r11
            java.lang.Object r0 = r0.next()
            if (r0 != 0) goto L3d
        L68:
            r0 = r4
            r1 = 1
            java.util.ListIterator r0 = r0.listIterator(r1)
            r12 = r0
            r0 = 0
            r7 = r0
        L74:
            r0 = r7
            r6 = r0
            r0 = r12
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lb9
            r0 = r12
            java.lang.Object r0 = r0.next()
            r13 = r0
            r0 = r11
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto La8
            r0 = -1
            return r0
        L96:
            r0 = r10
            r1 = r11
            java.lang.Object r1 = r1.next()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3d
            goto L68
        La8:
            r0 = r13
            if (r0 != 0) goto Lbf
            r0 = r11
            java.lang.Object r0 = r0.next()
            if (r0 == 0) goto L74
        Lb7:
            r0 = 1
            r6 = r0
        Lb9:
            r0 = r6
            if (r0 != 0) goto L3d
            r0 = r5
            return r0
        Lbf:
            r0 = r13
            r1 = r11
            java.lang.Object r1 = r1.next()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L74
            goto Lb7
        Ld1:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.indexOfSubList(java.util.List, java.util.List):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:
        r7 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b2 A[EDGE_INSN: B:50:0x00b2->B:33:0x00b2 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int lastIndexOfSubList(java.util.List<?> r4, java.util.List<?> r5) {
        /*
            r0 = r5
            int r0 = r0.size()
            r9 = r0
            r0 = r4
            int r0 = r0.size()
            r6 = r0
            r0 = r9
            r1 = r6
            if (r0 <= r1) goto L19
            r0 = -1
            r6 = r0
        L17:
            r0 = r6
            return r0
        L19:
            r0 = r9
            if (r0 == 0) goto L17
            r0 = r5
            r1 = r9
            r2 = 1
            int r1 = r1 - r2
            java.lang.Object r0 = r0.get(r1)
            r10 = r0
            r0 = r4
            r1 = r10
            int r0 = r0.lastIndexOf(r1)
            r6 = r0
        L33:
            r0 = r6
            r1 = -1
            if (r0 <= r1) goto Ld0
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r1 = r9
            if (r0 < r1) goto Ld0
            r0 = r4
            r1 = r6
            r2 = 1
            int r1 = r1 + r2
            java.util.ListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = r10
            if (r0 != 0) goto L8b
            r0 = r11
            java.lang.Object r0 = r0.previous()
            if (r0 != 0) goto L9a
        L5a:
            r0 = r5
            r1 = r9
            r2 = 1
            int r1 = r1 - r2
            java.util.ListIterator r0 = r0.listIterator(r1)
            r12 = r0
            r0 = 0
            r8 = r0
        L69:
            r0 = r8
            r7 = r0
            r0 = r12
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto Lb2
            r0 = r12
            java.lang.Object r0 = r0.previous()
            r13 = r0
            r0 = r11
            boolean r0 = r0.hasPrevious()
            if (r0 != 0) goto La1
            r0 = -1
            return r0
        L8b:
            r0 = r10
            r1 = r11
            java.lang.Object r1 = r1.previous()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
        L9a:
            r0 = r6
            r1 = 1
            int r0 = r0 - r1
            r6 = r0
            goto L33
        La1:
            r0 = r13
            if (r0 != 0) goto Lbe
            r0 = r11
            java.lang.Object r0 = r0.previous()
            if (r0 == 0) goto L69
        Lb0:
            r0 = 1
            r7 = r0
        Lb2:
            r0 = r7
            if (r0 != 0) goto L9a
            r0 = r11
            int r0 = r0.nextIndex()
            return r0
        Lbe:
            r0 = r13
            r1 = r11
            java.lang.Object r1 = r1.previous()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L69
            goto Lb0
        Ld0:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.lastIndexOfSubList(java.util.List, java.util.List):int");
    }

    public static <T> ArrayList<T> list(Enumeration<T> enumeration) {
        ArrayList<T> arrayList = new ArrayList<>();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    public static <T extends Comparable<? super T>> T max(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T max(Collection<? extends T> collection, Comparator<? super T> comparator) {
        if (comparator == null) {
            return (T) max(collection);
        }
        Iterator<? extends T> it = collection.iterator();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare((Object) next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T extends Comparable<? super T>> T min(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T min(Collection<? extends T> collection, Comparator<? super T> comparator) {
        if (comparator == null) {
            return (T) min(collection);
        }
        Iterator<? extends T> it = collection.iterator();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare((Object) next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> nCopies(int i, T t) {
        return new CopiesList(i, t);
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        if (map.isEmpty()) {
            return new SetFromMap(map);
        }
        throw new IllegalArgumentException("map not empty");
    }

    public static <T> boolean replaceAll(List<T> list, T t, T t2) {
        boolean z = false;
        while (true) {
            int indexOf = list.indexOf(t);
            if (indexOf <= -1) {
                return z;
            }
            z = true;
            list.set(indexOf, t2);
        }
    }

    public static void reverse(List<?> list) {
        int size = list.size();
        ListIterator<?> listIterator = list.listIterator();
        ListIterator<?> listIterator2 = list.listIterator(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size / 2) {
                return;
            }
            Object next = listIterator.next();
            listIterator.set(listIterator2.previous());
            listIterator2.set(next);
            i = i2 + 1;
        }
    }

    public static <T> Comparator<T> reverseOrder() {
        return ReverseComparator.INSTANCE;
    }

    public static <T> Comparator<T> reverseOrder(Comparator<T> comparator) {
        return comparator == null ? reverseOrder() : comparator instanceof ReverseComparator2 ? ((ReverseComparator2) comparator).cmp : new ReverseComparator2(comparator);
    }

    public static void rotate(List<?> list, int i) {
        int size = list.size();
        if (size == 0) {
            return;
        }
        int i2 = i > 0 ? i % size : size - ((i % size) * (-1));
        if (i2 == 0 || i2 == size) {
            return;
        }
        if (!(list instanceof RandomAccess)) {
            int i3 = (size - i2) % size;
            List<?> subList = list.subList(0, i3);
            List<?> subList2 = list.subList(i3, size);
            reverse(subList);
            reverse(subList2);
            reverse(list);
            return;
        }
        Object obj = list.get(0);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            int i7 = (i4 + i2) % size;
            obj = list.set(i7, obj);
            int i8 = i5;
            i4 = i7;
            if (i7 == i5) {
                i8 = i5 + 1;
                i4 = i8;
                obj = list.get(i8);
            }
            i6++;
            i5 = i8;
        }
    }

    public static int roundUpToPowerOfTwo(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        return (i6 | (i6 >>> 16)) + 1;
    }

    private static int secondaryHash(int i) {
        int i2 = i + ((i << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return (i6 >>> 16) ^ i6;
    }

    public static int secondaryHash(Object obj) {
        return secondaryHash(obj.hashCode());
    }

    public static int secondaryIdentityHash(Object obj) {
        return secondaryHash(System.identityHashCode(obj));
    }

    public static void shuffle(List<?> list) {
        shuffle(list, new Random());
    }

    public static void shuffle(List<?> list, Random random) {
        if (!(list instanceof RandomAccess)) {
            Object[] array = list.toArray();
            int length = array.length;
            while (true) {
                int i = length - 1;
                if (i <= 0) {
                    break;
                }
                int nextInt = random.nextInt(i + 1);
                Object obj = array[i];
                array[i] = array[nextInt];
                array[nextInt] = obj;
                length = i;
            }
            int i2 = 0;
            ListIterator<?> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next();
                listIterator.set(array[i2]);
                i2++;
            }
            return;
        }
        int size = list.size();
        while (true) {
            int i3 = size - 1;
            if (i3 <= 0) {
                return;
            }
            int nextInt2 = random.nextInt(i3 + 1);
            list.set(nextInt2, list.set(i3, list.get(nextInt2)));
            size = i3;
        }
    }

    public static <E> Set<E> singleton(E e) {
        return new SingletonSet(e);
    }

    public static <E> List<E> singletonList(E e) {
        return new SingletonList(e);
    }

    public static <K, V> Map<K, V> singletonMap(K k, V v) {
        return new SingletonMap(k, v);
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        Object[] array = list.toArray();
        Arrays.sort(array);
        int i = 0;
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set((T) array[i]);
            i++;
        }
    }

    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        Object[] array = list.toArray(new Object[list.size()]);
        Arrays.sort(array, comparator);
        int i = 0;
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set((T) array[i]);
            i++;
        }
    }

    public static void swap(List<?> list, int i, int i2) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        int size = list.size();
        if (i < 0 || i >= size || i2 < 0 || i2 >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (i == i2) {
            return;
        }
        list.set(i2, list.set(i, list.get(i2)));
    }

    public static <T> Collection<T> synchronizedCollection(Collection<T> collection) {
        if (collection == null) {
            throw new NullPointerException("collection == null");
        }
        return new SynchronizedCollection(collection);
    }

    public static <T> List<T> synchronizedList(List<T> list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list) : new SynchronizedList(list);
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException("map == null");
        }
        return new SynchronizedMap(map);
    }

    public static <E> Set<E> synchronizedSet(Set<E> set) {
        if (set == null) {
            throw new NullPointerException("set == null");
        }
        return new SynchronizedSet(set);
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException("map == null");
        }
        return new SynchronizedSortedMap(sortedMap);
    }

    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> sortedSet) {
        if (sortedSet == null) {
            throw new NullPointerException("set == null");
        }
        return new SynchronizedSortedSet(sortedSet);
    }

    public static <E> Collection<E> unmodifiableCollection(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("collection == null");
        }
        return new UnmodifiableCollection(collection);
    }

    public static <E> List<E> unmodifiableList(List<? extends E> list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        return list instanceof RandomAccess ? new UnmodifiableRandomAccessList(list) : new UnmodifiableList(list);
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> map) {
        if (map == null) {
            throw new NullPointerException("map == null");
        }
        return new UnmodifiableMap(map);
    }

    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        if (set == null) {
            throw new NullPointerException("set == null");
        }
        return new UnmodifiableSet(set);
    }

    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException("map == null");
        }
        return new UnmodifiableSortedMap(sortedMap);
    }

    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> sortedSet) {
        if (sortedSet == null) {
            throw new NullPointerException("set == null");
        }
        return new UnmodifiableSortedSet(sortedSet);
    }
}
