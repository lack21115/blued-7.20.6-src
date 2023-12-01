package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.MapEntry;

/* loaded from: source-2895416-dex2jar.jar:java/util/IdentityHashMap.class */
public class IdentityHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable, Cloneable {
    private static final int DEFAULT_MAX_SIZE = 21;
    private static final Object NULL_OBJECT = new Object();
    private static final int loadFactor = 7500;
    private static final long serialVersionUID = 8188218128353913216L;
    transient Object[] elementData;
    transient int modCount;
    int size;
    transient int threshold;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/IdentityHashMap$IdentityHashMapEntry.class */
    public static class IdentityHashMapEntry<K, V> extends MapEntry<K, V> {
        private final IdentityHashMap<K, V> map;

        IdentityHashMapEntry(IdentityHashMap<K, V> identityHashMap, K k, V v) {
            super(k, v);
            this.map = identityHashMap;
        }

        @Override // java.util.MapEntry
        public Object clone() {
            return super.clone();
        }

        @Override // java.util.MapEntry, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.key == entry.getKey() && this.value == entry.getValue();
            }
            return false;
        }

        @Override // java.util.MapEntry, java.util.Map.Entry
        public int hashCode() {
            return System.identityHashCode(this.key) ^ System.identityHashCode(this.value);
        }

        @Override // java.util.MapEntry, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) super.setValue(v);
            this.map.put(this.key, v);
            return v2;
        }

        @Override // java.util.MapEntry
        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/IdentityHashMap$IdentityHashMapEntrySet.class */
    public static class IdentityHashMapEntrySet<KT, VT> extends AbstractSet<Map.Entry<KT, VT>> {
        private final IdentityHashMap<KT, VT> associatedMap;

        public IdentityHashMapEntrySet(IdentityHashMap<KT, VT> identityHashMap) {
            this.associatedMap = identityHashMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.associatedMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            IdentityHashMapEntry entry;
            return (obj instanceof Map.Entry) && (entry = this.associatedMap.getEntry(((Map.Entry) obj).getKey())) != null && entry.equals(obj);
        }

        IdentityHashMap<KT, VT> hashMap() {
            return this.associatedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<KT, VT>> iterator() {
            return new IdentityHashMapIterator(new MapEntry.Type<Map.Entry<KT, VT>, KT, VT>() { // from class: java.util.IdentityHashMap.IdentityHashMapEntrySet.1
                @Override // java.util.MapEntry.Type
                public Map.Entry<KT, VT> get(MapEntry<KT, VT> mapEntry) {
                    return mapEntry;
                }
            }, this.associatedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                this.associatedMap.remove(((Map.Entry) obj).getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.associatedMap.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/IdentityHashMap$IdentityHashMapIterator.class */
    public static class IdentityHashMapIterator<E, KT, VT> implements Iterator<E> {
        final IdentityHashMap<KT, VT> associatedMap;
        int expectedModCount;
        final MapEntry.Type<E, KT, VT> type;
        private int position = 0;
        private int lastPosition = 0;
        boolean canRemove = false;

        IdentityHashMapIterator(MapEntry.Type<E, KT, VT> type, IdentityHashMap<KT, VT> identityHashMap) {
            this.associatedMap = identityHashMap;
            this.type = type;
            this.expectedModCount = identityHashMap.modCount;
        }

        void checkConcurrentMod() throws ConcurrentModificationException {
            if (this.expectedModCount != this.associatedMap.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.position < this.associatedMap.elementData.length) {
                if (this.associatedMap.elementData[this.position] != null) {
                    return true;
                }
                this.position += 2;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            checkConcurrentMod();
            if (hasNext()) {
                IdentityHashMapEntry entry = this.associatedMap.getEntry(this.position);
                this.lastPosition = this.position;
                this.position += 2;
                this.canRemove = true;
                return this.type.get(entry);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            checkConcurrentMod();
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            this.canRemove = false;
            this.associatedMap.remove(this.associatedMap.elementData[this.lastPosition]);
            this.position = this.lastPosition;
            this.expectedModCount++;
        }
    }

    public IdentityHashMap() {
        this(21);
    }

    public IdentityHashMap(int i) {
        this.modCount = 0;
        if (i < 0) {
            throw new IllegalArgumentException("maxSize < 0: " + i);
        }
        this.size = 0;
        this.threshold = getThreshold(i);
        this.elementData = newElementArray(computeElementArraySize());
    }

    public IdentityHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        putAllImpl(map);
    }

    private int computeElementArraySize() {
        int i = ((int) ((this.threshold * 10000) / 7500)) * 2;
        int i2 = i;
        if (i < 0) {
            i2 = -i;
        }
        return i2;
    }

    private void computeMaxSize() {
        this.threshold = (int) (((this.elementData.length / 2) * 7500) / 10000);
    }

    private int findIndex(Object obj, Object[] objArr) {
        int i;
        int length = objArr.length;
        int moduloHash = getModuloHash(obj, length);
        int i2 = moduloHash;
        while (true) {
            i = i2;
            if (i == ((moduloHash + length) - 2) % length || objArr[i] == obj || objArr[i] == null) {
                break;
            }
            i2 = (i + 2) % length;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IdentityHashMapEntry<K, V> getEntry(int i) {
        Object obj = this.elementData[i];
        Object obj2 = this.elementData[i + 1];
        Object obj3 = obj;
        if (obj == NULL_OBJECT) {
            obj3 = null;
        }
        Object obj4 = obj2;
        if (obj2 == NULL_OBJECT) {
            obj4 = null;
        }
        return new IdentityHashMapEntry<>(this, obj3, obj4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IdentityHashMapEntry<K, V> getEntry(Object obj) {
        Object obj2 = obj;
        if (obj == null) {
            obj2 = NULL_OBJECT;
        }
        int findIndex = findIndex(obj2, this.elementData);
        if (this.elementData[findIndex] == obj2) {
            return getEntry(findIndex);
        }
        return null;
    }

    private int getModuloHash(Object obj, int i) {
        return ((Collections.secondaryIdentityHash(obj) & Integer.MAX_VALUE) % (i / 2)) * 2;
    }

    private int getThreshold(int i) {
        if (i > 3) {
            return i;
        }
        return 3;
    }

    private V massageValue(Object obj) {
        Object obj2 = obj;
        if (obj == NULL_OBJECT) {
            obj2 = null;
        }
        return (V) obj2;
    }

    private Object[] newElementArray(int i) {
        return new Object[i];
    }

    private void putAllImpl(Map<? extends K, ? extends V> map) {
        if (map.entrySet() != null) {
            super.putAll(map);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        this.threshold = getThreshold(21);
        this.elementData = newElementArray(computeElementArraySize());
        int i = readInt;
        while (true) {
            i--;
            if (i < 0) {
                this.size = readInt;
                return;
            }
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void rehash() {
        int length = this.elementData.length * 2;
        int i = length;
        if (length == 0) {
            i = 1;
        }
        Object[] newElementArray = newElementArray(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.elementData.length) {
                this.elementData = newElementArray;
                computeMaxSize();
                return;
            }
            Object obj = this.elementData[i3];
            if (obj != null) {
                int findIndex = findIndex(obj, newElementArray);
                newElementArray[findIndex] = obj;
                newElementArray[findIndex + 1] = this.elementData[i3 + 1];
            }
            i2 = i3 + 2;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            MapEntry mapEntry = (MapEntry) it.next();
            objectOutputStream.writeObject(mapEntry.key);
            objectOutputStream.writeObject(mapEntry.value);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.size = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.elementData.length) {
                this.modCount++;
                return;
            } else {
                this.elementData[i2] = null;
                i = i2 + 1;
            }
        }
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        try {
            IdentityHashMap identityHashMap = (IdentityHashMap) super.clone();
            identityHashMap.elementData = newElementArray(this.elementData.length);
            System.arraycopy(this.elementData, 0, identityHashMap.elementData, 0, this.elementData.length);
            return identityHashMap;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Object obj2 = obj;
        if (obj == null) {
            obj2 = NULL_OBJECT;
        }
        return this.elementData[findIndex(obj2, this.elementData)] == obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Object obj2 = obj;
        if (obj == null) {
            obj2 = NULL_OBJECT;
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.elementData.length) {
                return false;
            }
            if (this.elementData[i2] == obj2) {
                return true;
            }
            i = i2 + 2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new IdentityHashMapEntrySet(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            z = true;
        } else {
            z = false;
            if (obj instanceof Map) {
                Map map = (Map) obj;
                z = false;
                if (size() == map.size()) {
                    return entrySet().equals(map.entrySet());
                }
            }
        }
        return z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Object obj2 = obj;
        if (obj == null) {
            obj2 = NULL_OBJECT;
        }
        int findIndex = findIndex(obj2, this.elementData);
        if (this.elementData[findIndex] == obj2) {
            return massageValue(this.elementData[findIndex + 1]);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new AbstractSet<K>() { // from class: java.util.IdentityHashMap.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    IdentityHashMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return IdentityHashMap.this.containsKey(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator<K> iterator() {
                    return new IdentityHashMapIterator(new MapEntry.Type<K, K, V>() { // from class: java.util.IdentityHashMap.1.1
                        @Override // java.util.MapEntry.Type
                        public K get(MapEntry<K, V> mapEntry) {
                            return mapEntry.key;
                        }
                    }, IdentityHashMap.this);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    if (IdentityHashMap.this.containsKey(obj)) {
                        IdentityHashMap.this.remove(obj);
                        return true;
                    }
                    return false;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return IdentityHashMap.this.size();
                }
            };
        }
        return this.keySet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        K k2 = k;
        if (k == null) {
            k2 = NULL_OBJECT;
        }
        V v2 = v;
        if (v == null) {
            v2 = NULL_OBJECT;
        }
        int findIndex = findIndex(k2, this.elementData);
        int i = findIndex;
        if (this.elementData[findIndex] != k2) {
            this.modCount++;
            int i2 = this.size + 1;
            this.size = i2;
            if (i2 > this.threshold) {
                rehash();
                findIndex = findIndex(k2, this.elementData);
            }
            this.elementData[findIndex] = k2;
            this.elementData[findIndex + 1] = null;
            i = findIndex;
        }
        Object obj = this.elementData[i + 1];
        this.elementData[i + 1] = v2;
        return massageValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Object obj2 = obj;
        if (obj == null) {
            obj2 = NULL_OBJECT;
        }
        int findIndex = findIndex(obj2, this.elementData);
        int i = findIndex;
        if (this.elementData[i] != obj2) {
            return null;
        }
        Object obj3 = this.elementData[i + 1];
        int length = this.elementData.length;
        while (true) {
            int i2 = (findIndex + 2) % length;
            Object obj4 = this.elementData[i2];
            if (obj4 == null) {
                this.size--;
                this.modCount++;
                this.elementData[i] = null;
                this.elementData[i + 1] = null;
                return massageValue(obj3);
            }
            int moduloHash = getModuloHash(obj4, length);
            boolean z = moduloHash > i;
            findIndex = i2;
            if (!(i2 < i ? z || moduloHash <= i2 : z && moduloHash <= i2)) {
                this.elementData[i] = obj4;
                this.elementData[i + 1] = this.elementData[i2 + 1];
                i = i2;
                findIndex = i2;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new AbstractCollection<V>() { // from class: java.util.IdentityHashMap.2
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    IdentityHashMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return IdentityHashMap.this.containsValue(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator<V> iterator() {
                    return new IdentityHashMapIterator(new MapEntry.Type<V, K, V>() { // from class: java.util.IdentityHashMap.2.1
                        @Override // java.util.MapEntry.Type
                        public V get(MapEntry<K, V> mapEntry) {
                            return mapEntry.value;
                        }
                    }, IdentityHashMap.this);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    Iterator<V> it = iterator();
                    while (it.hasNext()) {
                        if (obj == it.next()) {
                            it.remove();
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return IdentityHashMap.this.size();
                }
            };
        }
        return this.valuesCollection;
    }
}
