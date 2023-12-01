package java.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/util/WeakHashMap.class */
public class WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_SIZE = 16;
    int elementCount;
    Entry<K, V>[] elementData;
    private final int loadFactor;
    volatile int modCount;
    private final ReferenceQueue<K> referenceQueue;
    private int threshold;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/WeakHashMap$Entry.class */
    public static final class Entry<K, V> extends WeakReference<K> implements Map.Entry<K, V> {
        final int hash;
        boolean isNull;
        Entry<K, V> next;
        V value;

        /* loaded from: source-2895416-dex2jar.jar:java/util/WeakHashMap$Entry$Type.class */
        interface Type<R, K, V> {
            R get(Map.Entry<K, V> entry);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Entry(K k, V v, ReferenceQueue<K> referenceQueue) {
            super(k, referenceQueue);
            int i = 0;
            this.isNull = k == null;
            this.hash = this.isNull ? i : Collections.secondaryHash(k);
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = super.get();
                if (obj2 == null) {
                    if (obj2 != entry.getKey()) {
                        return false;
                    }
                } else if (!obj2.equals(entry.getKey())) {
                    return false;
                }
                return this.value == null ? this.value == entry.getValue() : this.value.equals(entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) super.get();
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.value == null ? 0 : this.value.hashCode()) + this.hash;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            return super.get() + "=" + this.value;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/WeakHashMap$HashIterator.class */
    class HashIterator<R> implements Iterator<R> {
        private Entry<K, V> currentEntry;
        private int expectedModCount;
        private Entry<K, V> nextEntry;
        private K nextKey;
        private int position = 0;
        final Entry.Type<R, K, V> type;

        HashIterator(Entry.Type<R, K, V> type) {
            this.type = type;
            this.expectedModCount = WeakHashMap.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextEntry != null && (this.nextKey != null || this.nextEntry.isNull)) {
                return true;
            }
            while (true) {
                if (this.nextEntry == null) {
                    while (this.position < WeakHashMap.this.elementData.length) {
                        Entry<K, V>[] entryArr = WeakHashMap.this.elementData;
                        int i = this.position;
                        this.position = i + 1;
                        Entry<K, V> entry = entryArr[i];
                        this.nextEntry = entry;
                        if (entry != null) {
                            break;
                        }
                    }
                    if (this.nextEntry == null) {
                        return false;
                    }
                }
                this.nextKey = this.nextEntry.get();
                if (this.nextKey != null || this.nextEntry.isNull) {
                    return true;
                }
                this.nextEntry = this.nextEntry.next;
            }
        }

        @Override // java.util.Iterator
        public R next() {
            if (this.expectedModCount == WeakHashMap.this.modCount) {
                if (hasNext()) {
                    this.currentEntry = this.nextEntry;
                    this.nextEntry = this.currentEntry.next;
                    R r = this.type.get(this.currentEntry);
                    this.nextKey = null;
                    return r;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.expectedModCount != WeakHashMap.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.currentEntry == null) {
                throw new IllegalStateException();
            }
            WeakHashMap.this.removeEntry(this.currentEntry);
            this.currentEntry = null;
            this.expectedModCount++;
        }
    }

    public WeakHashMap() {
        this(16);
    }

    public WeakHashMap(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        this.elementCount = 0;
        this.elementData = newEntryArray(i == 0 ? 1 : i);
        this.loadFactor = 7500;
        computeMaxSize();
        this.referenceQueue = new ReferenceQueue<>();
    }

    public WeakHashMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        if (f <= 0.0f) {
            throw new IllegalArgumentException("loadFactor <= 0: " + f);
        }
        this.elementCount = 0;
        this.elementData = newEntryArray(i == 0 ? 1 : i);
        this.loadFactor = (int) (10000.0f * f);
        computeMaxSize();
        this.referenceQueue = new ReferenceQueue<>();
    }

    public WeakHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        putAllImpl(map);
    }

    private void computeMaxSize() {
        this.threshold = (int) ((this.elementData.length * this.loadFactor) / 10000);
    }

    private static <K, V> Entry<K, V>[] newEntryArray(int i) {
        return new Entry[i];
    }

    private void putAllImpl(Map<? extends K, ? extends V> map) {
        if (map.entrySet() != null) {
            super.putAll(map);
        }
    }

    private void rehash() {
        int length = this.elementData.length * 2;
        int i = length;
        if (length == 0) {
            i = 1;
        }
        Entry<K, V>[] newEntryArray = newEntryArray(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.elementData.length) {
                this.elementData = newEntryArray;
                computeMaxSize();
                return;
            }
            Entry<K, V> entry = this.elementData[i3];
            while (true) {
                Entry<K, V> entry2 = entry;
                if (entry2 != null) {
                    int i4 = entry2.isNull ? 0 : (entry2.hash & Integer.MAX_VALUE) % i;
                    Entry<K, V> entry3 = entry2.next;
                    entry2.next = newEntryArray[i4];
                    newEntryArray[i4] = entry2;
                    entry = entry3;
                }
            }
            i2 = i3 + 1;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (this.elementCount > 0) {
            this.elementCount = 0;
            Arrays.fill(this.elementData, (Object) null);
            this.modCount++;
            do {
            } while (this.referenceQueue.poll() != null);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return getEntry(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        poll();
        if (obj != null) {
            int length = this.elementData.length;
            while (true) {
                int i = length - 1;
                if (i < 0) {
                    return false;
                }
                Entry<K, V> entry = this.elementData[i];
                while (true) {
                    Entry<K, V> entry2 = entry;
                    length = i;
                    if (entry2 != null) {
                        if ((entry2.get() != null || entry2.isNull) && obj.equals(entry2.value)) {
                            return true;
                        }
                        entry = entry2.next;
                    }
                }
            }
        } else {
            int length2 = this.elementData.length;
            while (true) {
                int i2 = length2 - 1;
                if (i2 < 0) {
                    return false;
                }
                Entry<K, V> entry3 = this.elementData[i2];
                while (true) {
                    Entry<K, V> entry4 = entry3;
                    length2 = i2;
                    if (entry4 != null) {
                        if ((entry4.get() != null || entry4.isNull) && entry4.value == null) {
                            return true;
                        }
                        entry3 = entry4.next;
                    }
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        poll();
        return new AbstractSet<Map.Entry<K, V>>() { // from class: java.util.WeakHashMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                WeakHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                Entry<K, V> entry;
                if (!(obj instanceof Map.Entry) || (entry = WeakHashMap.this.getEntry(((Map.Entry) obj).getKey())) == null) {
                    return false;
                }
                if (entry.get() != null || entry.isNull) {
                    return obj.equals(entry);
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                return new HashIterator(new Entry.Type<Map.Entry<K, V>, K, V>() { // from class: java.util.WeakHashMap.1.1
                    @Override // java.util.WeakHashMap.Entry.Type
                    public Map.Entry<K, V> get(Map.Entry<K, V> entry) {
                        return entry;
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    WeakHashMap.this.remove(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return WeakHashMap.this.size();
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        V v;
        poll();
        if (obj == null) {
            Entry<K, V> entry = this.elementData[0];
            while (true) {
                Entry<K, V> entry2 = entry;
                v = null;
                if (entry2 == null) {
                    break;
                } else if (entry2.isNull) {
                    return entry2.value;
                } else {
                    entry = entry2.next;
                }
            }
        } else {
            Entry<K, V> entry3 = this.elementData[(Collections.secondaryHash(obj) & Integer.MAX_VALUE) % this.elementData.length];
            while (true) {
                Entry<K, V> entry4 = entry3;
                v = null;
                if (entry4 == null) {
                    break;
                } else if (obj.equals(entry4.get())) {
                    v = entry4.value;
                    break;
                } else {
                    entry3 = entry4.next;
                }
            }
        }
        return v;
    }

    Entry<K, V> getEntry(Object obj) {
        Entry<K, V> entry;
        poll();
        if (obj != null) {
            int secondaryHash = Collections.secondaryHash(obj);
            Entry<K, V> entry2 = this.elementData[(secondaryHash & Integer.MAX_VALUE) % this.elementData.length];
            while (true) {
                entry = entry2;
                if (entry == null) {
                    return null;
                }
                if (obj.equals(entry.get())) {
                    break;
                }
                entry2 = entry.next;
            }
        } else {
            Entry<K, V> entry3 = this.elementData[0];
            while (true) {
                Entry<K, V> entry4 = entry3;
                if (entry4 == null) {
                    return null;
                }
                entry = entry4;
                if (entry4.isNull) {
                    break;
                }
                entry3 = entry4.next;
            }
        }
        return entry;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        poll();
        if (this.keySet == null) {
            this.keySet = new AbstractSet<K>() { // from class: java.util.WeakHashMap.2
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    WeakHashMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return WeakHashMap.this.containsKey(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator<K> iterator() {
                    return new HashIterator(new Entry.Type<K, K, V>() { // from class: java.util.WeakHashMap.2.1
                        @Override // java.util.WeakHashMap.Entry.Type
                        public K get(Map.Entry<K, V> entry) {
                            return entry.getKey();
                        }
                    });
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    if (WeakHashMap.this.containsKey(obj)) {
                        WeakHashMap.this.remove(obj);
                        return true;
                    }
                    return false;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return WeakHashMap.this.size();
                }
            };
        }
        return this.keySet;
    }

    void poll() {
        while (true) {
            Entry<K, V> entry = (Entry) this.referenceQueue.poll();
            if (entry == null) {
                return;
            }
            removeEntry(entry);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Entry<K, V> entry;
        int i;
        poll();
        if (k == null) {
            Entry<K, V> entry2 = this.elementData[0];
            while (true) {
                Entry<K, V> entry3 = entry2;
                entry = entry3;
                i = 0;
                if (entry3 == null) {
                    break;
                }
                entry = entry3;
                i = 0;
                if (entry3.isNull) {
                    break;
                }
                entry2 = entry3.next;
            }
        } else {
            int secondaryHash = (Collections.secondaryHash(k) & Integer.MAX_VALUE) % this.elementData.length;
            Entry<K, V> entry4 = this.elementData[secondaryHash];
            while (true) {
                Entry<K, V> entry5 = entry4;
                entry = entry5;
                i = secondaryHash;
                if (entry5 == null) {
                    break;
                }
                entry = entry5;
                i = secondaryHash;
                if (k.equals(entry5.get())) {
                    break;
                }
                entry4 = entry5.next;
            }
        }
        if (entry != null) {
            V v2 = entry.value;
            entry.value = v;
            return v2;
        }
        this.modCount++;
        int i2 = this.elementCount + 1;
        this.elementCount = i2;
        if (i2 > this.threshold) {
            rehash();
            i = k == null ? 0 : (Collections.secondaryHash(k) & Integer.MAX_VALUE) % this.elementData.length;
        }
        Entry<K, V> entry6 = new Entry<>(k, v, this.referenceQueue);
        entry6.next = this.elementData[i];
        this.elementData[i] = entry6;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Entry<K, V> entry;
        int i;
        Entry<K, V> entry2;
        poll();
        Entry<K, V> entry3 = null;
        Entry<K, V> entry4 = null;
        if (obj == null) {
            Entry<K, V> entry5 = this.elementData[0];
            while (true) {
                Entry<K, V> entry6 = entry5;
                entry = entry6;
                i = 0;
                entry2 = entry3;
                if (entry6 == null) {
                    break;
                }
                entry = entry6;
                i = 0;
                entry2 = entry3;
                if (entry6.isNull) {
                    break;
                }
                entry3 = entry6;
                entry5 = entry6.next;
            }
        } else {
            int secondaryHash = (Collections.secondaryHash(obj) & Integer.MAX_VALUE) % this.elementData.length;
            Entry<K, V> entry7 = this.elementData[secondaryHash];
            while (true) {
                Entry<K, V> entry8 = entry7;
                entry = entry8;
                i = secondaryHash;
                entry2 = entry4;
                if (entry8 == null) {
                    break;
                }
                entry = entry8;
                i = secondaryHash;
                entry2 = entry4;
                if (obj.equals(entry8.get())) {
                    break;
                }
                entry4 = entry8;
                entry7 = entry8.next;
            }
        }
        if (entry != null) {
            this.modCount++;
            if (entry2 == null) {
                this.elementData[i] = entry.next;
            } else {
                entry2.next = entry.next;
            }
            this.elementCount--;
            return entry.value;
        }
        return null;
    }

    void removeEntry(Entry<K, V> entry) {
        Entry<K, V> entry2 = null;
        int length = (entry.hash & Integer.MAX_VALUE) % this.elementData.length;
        Entry<K, V> entry3 = this.elementData[length];
        while (true) {
            Entry<K, V> entry4 = entry3;
            if (entry4 == null) {
                return;
            }
            if (entry == entry4) {
                this.modCount++;
                if (entry2 == null) {
                    this.elementData[length] = entry4.next;
                } else {
                    entry2.next = entry4.next;
                }
                this.elementCount--;
                return;
            }
            entry2 = entry4;
            entry3 = entry4.next;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        poll();
        return this.elementCount;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        poll();
        if (this.valuesCollection == null) {
            this.valuesCollection = new AbstractCollection<V>() { // from class: java.util.WeakHashMap.3
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    WeakHashMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return WeakHashMap.this.containsValue(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator<V> iterator() {
                    return new HashIterator(new Entry.Type<V, K, V>() { // from class: java.util.WeakHashMap.3.1
                        @Override // java.util.WeakHashMap.Entry.Type
                        public V get(Map.Entry<K, V> entry) {
                            return entry.getValue();
                        }
                    });
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return WeakHashMap.this.size();
                }
            };
        }
        return this.valuesCollection;
    }
}
