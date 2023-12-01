package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/util/HashMap.class */
public class HashMap<K, V> extends AbstractMap<K, V> implements Cloneable, Serializable {
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final int MINIMUM_CAPACITY = 4;
    private static final long serialVersionUID = 362498820763181265L;
    transient HashMapEntry<K, V> entryForNullKey;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient Set<K> keySet;
    transient int modCount;
    transient int size;
    transient HashMapEntry<K, V>[] table;
    private transient int threshold;
    private transient Collection<V> values;
    private static final Map.Entry[] EMPTY_TABLE = new HashMapEntry[2];
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("loadFactor", Float.TYPE)};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/HashMap$EntryIterator.class */
    public final class EntryIterator extends HashMap<K, V>.HashIterator implements Iterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/HashMap$EntrySet.class */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            HashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return HashMap.this.containsMapping(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return HashMap.this.size == 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return HashMap.this.newEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return HashMap.this.removeMapping(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return HashMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/HashMap$HashIterator.class */
    public abstract class HashIterator {
        int expectedModCount;
        HashMapEntry<K, V> lastEntryReturned;
        HashMapEntry<K, V> nextEntry;
        int nextIndex;

        HashIterator() {
            HashMapEntry<K, V> hashMapEntry;
            this.nextEntry = HashMap.this.entryForNullKey;
            this.expectedModCount = HashMap.this.modCount;
            if (this.nextEntry == null) {
                HashMapEntry<K, V>[] hashMapEntryArr = HashMap.this.table;
                HashMapEntry<K, V> hashMapEntry2 = null;
                while (true) {
                    hashMapEntry = hashMapEntry2;
                    if (hashMapEntry != null || this.nextIndex >= hashMapEntryArr.length) {
                        break;
                    }
                    int i = this.nextIndex;
                    this.nextIndex = i + 1;
                    hashMapEntry2 = hashMapEntryArr[i];
                }
                this.nextEntry = hashMapEntry;
            }
        }

        public boolean hasNext() {
            return this.nextEntry != null;
        }

        HashMapEntry<K, V> nextEntry() {
            HashMapEntry<K, V> hashMapEntry;
            if (HashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (this.nextEntry == null) {
                throw new NoSuchElementException();
            }
            HashMapEntry<K, V> hashMapEntry2 = this.nextEntry;
            HashMapEntry<K, V>[] hashMapEntryArr = HashMap.this.table;
            HashMapEntry<K, V> hashMapEntry3 = hashMapEntry2.next;
            while (true) {
                hashMapEntry = hashMapEntry3;
                if (hashMapEntry != null || this.nextIndex >= hashMapEntryArr.length) {
                    break;
                }
                int i = this.nextIndex;
                this.nextIndex = i + 1;
                hashMapEntry3 = hashMapEntryArr[i];
            }
            this.nextEntry = hashMapEntry;
            this.lastEntryReturned = hashMapEntry2;
            return hashMapEntry2;
        }

        public void remove() {
            if (this.lastEntryReturned == null) {
                throw new IllegalStateException();
            }
            if (HashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            HashMap.this.remove(this.lastEntryReturned.key);
            this.lastEntryReturned = null;
            this.expectedModCount = HashMap.this.modCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/HashMap$HashMapEntry.class */
    public static class HashMapEntry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        HashMapEntry<K, V> next;
        V value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HashMapEntry(K k, V v, int i, HashMapEntry<K, V> hashMapEntry) {
            this.key = k;
            this.value = v;
            this.hash = i;
            this.next = hashMapEntry;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return libcore.util.Objects.equal(entry.getKey(), this.key) && libcore.util.Objects.equal(entry.getValue(), this.value);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int i = 0;
            int hashCode = this.key == null ? 0 : this.key.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/HashMap$KeyIterator.class */
    public final class KeyIterator extends HashMap<K, V>.HashIterator implements Iterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().key;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/HashMap$KeySet.class */
    public final class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            HashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return HashMap.this.size == 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return HashMap.this.newKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i = HashMap.this.size;
            HashMap.this.remove(obj);
            return HashMap.this.size != i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return HashMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/HashMap$ValueIterator.class */
    public final class ValueIterator extends HashMap<K, V>.HashIterator implements Iterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().value;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/HashMap$Values.class */
    private final class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            HashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return HashMap.this.size == 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return HashMap.this.newValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return HashMap.this.size;
        }
    }

    public HashMap() {
        this.table = (HashMapEntry[]) EMPTY_TABLE;
        this.threshold = -1;
    }

    public HashMap(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Capacity: " + i);
        }
        if (i != 0) {
            makeTable(i < 4 ? 4 : i > 1073741824 ? 1073741824 : Collections.roundUpToPowerOfTwo(i));
            return;
        }
        this.table = (HashMapEntry[]) EMPTY_TABLE;
        this.threshold = -1;
    }

    public HashMap(int i, float f) {
        this(i);
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Load factor: " + f);
        }
    }

    public HashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int capacityForInitSize(int i) {
        int i2 = (i >> 1) + i;
        if (((-1073741824) & i2) == 0) {
            return i2;
        }
        return 1073741824;
    }

    private void constructorPut(K k, V v) {
        if (k == null) {
            HashMapEntry<K, V> hashMapEntry = this.entryForNullKey;
            if (hashMapEntry != null) {
                hashMapEntry.value = v;
                return;
            }
            this.entryForNullKey = constructorNewEntry(null, v, 0, null);
            this.size++;
            return;
        }
        int secondaryHash = Collections.secondaryHash(k);
        HashMapEntry<K, V>[] hashMapEntryArr = this.table;
        int length = secondaryHash & (hashMapEntryArr.length - 1);
        HashMapEntry<K, V> hashMapEntry2 = hashMapEntryArr[length];
        HashMapEntry<K, V> hashMapEntry3 = hashMapEntry2;
        while (true) {
            HashMapEntry<K, V> hashMapEntry4 = hashMapEntry3;
            if (hashMapEntry4 == null) {
                hashMapEntryArr[length] = constructorNewEntry(k, v, secondaryHash, hashMapEntry2);
                this.size++;
                return;
            } else if (hashMapEntry4.hash == secondaryHash && k.equals(hashMapEntry4.key)) {
                hashMapEntry4.value = v;
                return;
            } else {
                hashMapEntry3 = hashMapEntry4.next;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2) {
        boolean z;
        if (obj != null) {
            int secondaryHash = Collections.secondaryHash(obj);
            HashMapEntry<K, V>[] hashMapEntryArr = this.table;
            HashMapEntry<K, V> hashMapEntry = hashMapEntryArr[secondaryHash & (hashMapEntryArr.length - 1)];
            while (true) {
                HashMapEntry<K, V> hashMapEntry2 = hashMapEntry;
                z = false;
                if (hashMapEntry2 == null) {
                    break;
                } else if (hashMapEntry2.hash == secondaryHash && obj.equals(hashMapEntry2.key)) {
                    return libcore.util.Objects.equal(obj2, hashMapEntry2.value);
                } else {
                    hashMapEntry = hashMapEntry2.next;
                }
            }
        } else {
            HashMapEntry<K, V> hashMapEntry3 = this.entryForNullKey;
            z = false;
            if (hashMapEntry3 != null) {
                z = false;
                if (libcore.util.Objects.equal(obj2, hashMapEntry3.value)) {
                    z = true;
                }
            }
        }
        return z;
    }

    private HashMapEntry<K, V>[] doubleCapacity() {
        HashMapEntry<K, V>[] hashMapEntryArr;
        HashMapEntry<K, V>[] hashMapEntryArr2 = this.table;
        int length = hashMapEntryArr2.length;
        if (length == 1073741824) {
            hashMapEntryArr = hashMapEntryArr2;
        } else {
            HashMapEntry<K, V>[] makeTable = makeTable(length * 2);
            hashMapEntryArr = makeTable;
            if (this.size != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    hashMapEntryArr = makeTable;
                    if (i2 >= length) {
                        break;
                    }
                    HashMapEntry<K, V> hashMapEntry = hashMapEntryArr2[i2];
                    if (hashMapEntry != null) {
                        int i3 = hashMapEntry.hash & length;
                        HashMapEntry<K, V> hashMapEntry2 = null;
                        makeTable[i2 | i3] = hashMapEntry;
                        HashMapEntry<K, V> hashMapEntry3 = hashMapEntry.next;
                        while (hashMapEntry3 != null) {
                            int i4 = hashMapEntry3.hash & length;
                            HashMapEntry<K, V> hashMapEntry4 = hashMapEntry2;
                            int i5 = i3;
                            if (i4 != i3) {
                                if (hashMapEntry2 == null) {
                                    makeTable[i2 | i4] = hashMapEntry3;
                                } else {
                                    hashMapEntry2.next = hashMapEntry3;
                                }
                                i5 = i4;
                                hashMapEntry4 = hashMapEntry;
                            }
                            hashMapEntry = hashMapEntry3;
                            hashMapEntry3 = hashMapEntry3.next;
                            hashMapEntry2 = hashMapEntry4;
                            i3 = i5;
                        }
                        if (hashMapEntry2 != null) {
                            hashMapEntry2.next = null;
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        return hashMapEntryArr;
    }

    private void ensureCapacity(int i) {
        int roundUpToPowerOfTwo = Collections.roundUpToPowerOfTwo(capacityForInitSize(i));
        HashMapEntry<K, V>[] hashMapEntryArr = this.table;
        int length = hashMapEntryArr.length;
        if (roundUpToPowerOfTwo <= length) {
            return;
        }
        if (roundUpToPowerOfTwo == length * 2) {
            doubleCapacity();
            return;
        }
        HashMapEntry<K, V>[] makeTable = makeTable(roundUpToPowerOfTwo);
        if (this.size == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            HashMapEntry<K, V> hashMapEntry = hashMapEntryArr[i3];
            while (true) {
                HashMapEntry<K, V> hashMapEntry2 = hashMapEntry;
                if (hashMapEntry2 != null) {
                    HashMapEntry<K, V> hashMapEntry3 = hashMapEntry2.next;
                    int i4 = hashMapEntry2.hash & (roundUpToPowerOfTwo - 1);
                    HashMapEntry<K, V> hashMapEntry4 = makeTable[i4];
                    makeTable[i4] = hashMapEntry2;
                    hashMapEntry2.next = hashMapEntry4;
                    hashMapEntry = hashMapEntry3;
                }
            }
            i2 = i3 + 1;
        }
    }

    private HashMapEntry<K, V>[] makeTable(int i) {
        HashMapEntry<K, V>[] hashMapEntryArr = new HashMapEntry[i];
        this.table = hashMapEntryArr;
        this.threshold = (i >> 1) + (i >> 2);
        return hashMapEntryArr;
    }

    private V putValueForNullKey(V v) {
        HashMapEntry<K, V> hashMapEntry = this.entryForNullKey;
        if (hashMapEntry == null) {
            addNewEntryForNullKey(v);
            this.size++;
            this.modCount++;
            return null;
        }
        preModify(hashMapEntry);
        V v2 = hashMapEntry.value;
        hashMapEntry.value = v;
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Capacity: " + readInt);
        }
        makeTable(readInt < 4 ? 4 : readInt > 1073741824 ? 1073741824 : Collections.roundUpToPowerOfTwo(readInt));
        int readInt2 = objectInputStream.readInt();
        if (readInt2 < 0) {
            throw new InvalidObjectException("Size: " + readInt2);
        }
        init();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt2) {
                return;
            }
            constructorPut(objectInputStream.readObject(), objectInputStream.readObject());
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2) {
        if (obj == null) {
            HashMapEntry<K, V> hashMapEntry = this.entryForNullKey;
            if (hashMapEntry == null || !libcore.util.Objects.equal(obj2, hashMapEntry.value)) {
                return false;
            }
            this.entryForNullKey = null;
            this.modCount++;
            this.size--;
            postRemove(hashMapEntry);
            return true;
        }
        int secondaryHash = Collections.secondaryHash(obj);
        HashMapEntry<K, V>[] hashMapEntryArr = this.table;
        int length = secondaryHash & (hashMapEntryArr.length - 1);
        HashMapEntry<K, V> hashMapEntry2 = null;
        for (HashMapEntry<K, V> hashMapEntry3 = hashMapEntryArr[length]; hashMapEntry3 != null; hashMapEntry3 = hashMapEntry3.next) {
            if (hashMapEntry3.hash == secondaryHash && obj.equals(hashMapEntry3.key)) {
                if (libcore.util.Objects.equal(obj2, hashMapEntry3.value)) {
                    if (hashMapEntry2 == null) {
                        hashMapEntryArr[length] = hashMapEntry3.next;
                    } else {
                        hashMapEntry2.next = hashMapEntry3.next;
                    }
                    this.modCount++;
                    this.size--;
                    postRemove(hashMapEntry3);
                    return true;
                }
                return false;
            }
            hashMapEntry2 = hashMapEntry3;
        }
        return false;
    }

    private V removeNullKey() {
        HashMapEntry<K, V> hashMapEntry = this.entryForNullKey;
        if (hashMapEntry == null) {
            return null;
        }
        this.entryForNullKey = null;
        this.modCount++;
        this.size--;
        postRemove(hashMapEntry);
        return hashMapEntry.value;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.putFields().put("loadFactor", 0.75f);
        objectOutputStream.writeFields();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.size);
        for (Map.Entry<K, V> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    void addNewEntry(K k, V v, int i, int i2) {
        this.table[i2] = new HashMapEntry<>(k, v, i, this.table[i2]);
    }

    void addNewEntryForNullKey(V v) {
        this.entryForNullKey = new HashMapEntry<>(null, v, 0, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            Arrays.fill(this.table, (Object) null);
            this.entryForNullKey = null;
            this.modCount++;
            this.size = 0;
        }
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        try {
            HashMap hashMap = (HashMap) super.clone();
            hashMap.makeTable(this.table.length);
            hashMap.entryForNullKey = null;
            hashMap.size = 0;
            hashMap.keySet = null;
            hashMap.entrySet = null;
            hashMap.values = null;
            hashMap.init();
            hashMap.constructorPutAll(this);
            return hashMap;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    HashMapEntry<K, V> constructorNewEntry(K k, V v, int i, HashMapEntry<K, V> hashMapEntry) {
        return new HashMapEntry<>(k, v, i, hashMapEntry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void constructorPutAll(Map<? extends K, ? extends V> map) {
        if (this.table == EMPTY_TABLE) {
            doubleCapacity();
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            constructorPut(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return this.entryForNullKey != null;
        }
        int secondaryHash = Collections.secondaryHash(obj);
        HashMapEntry<K, V>[] hashMapEntryArr = this.table;
        HashMapEntry<K, V> hashMapEntry = hashMapEntryArr[(hashMapEntryArr.length - 1) & secondaryHash];
        while (true) {
            HashMapEntry<K, V> hashMapEntry2 = hashMapEntry;
            if (hashMapEntry2 == null) {
                return false;
            }
            K k = hashMapEntry2.key;
            if (k == obj) {
                return true;
            }
            if (hashMapEntry2.hash == secondaryHash && obj.equals(k)) {
                return true;
            }
            hashMapEntry = hashMapEntry2.next;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        HashMapEntry<K, V>[] hashMapEntryArr = this.table;
        int length = hashMapEntryArr.length;
        if (obj == null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return this.entryForNullKey != null && this.entryForNullKey.value == null;
                }
                HashMapEntry<K, V> hashMapEntry = hashMapEntryArr[i2];
                while (true) {
                    HashMapEntry<K, V> hashMapEntry2 = hashMapEntry;
                    if (hashMapEntry2 != null) {
                        if (hashMapEntry2.value == null) {
                            return true;
                        }
                        hashMapEntry = hashMapEntry2.next;
                    }
                }
                i = i2 + 1;
            }
        } else {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    return this.entryForNullKey != null && obj.equals(this.entryForNullKey.value);
                }
                HashMapEntry<K, V> hashMapEntry3 = hashMapEntryArr[i4];
                while (true) {
                    HashMapEntry<K, V> hashMapEntry4 = hashMapEntry3;
                    if (hashMapEntry4 != null) {
                        if (obj.equals(hashMapEntry4.value)) {
                            return true;
                        }
                        hashMapEntry3 = hashMapEntry4.next;
                    }
                }
                i3 = i4 + 1;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        return r7.value;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V get(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 != 0) goto L14
            r0 = r4
            java.util.HashMap$HashMapEntry<K, V> r0 = r0.entryForNullKey
            r5 = r0
            r0 = r5
            if (r0 != 0) goto Lf
        Ld:
            r0 = 0
            return r0
        Lf:
            r0 = r5
            V r0 = r0.value
            return r0
        L14:
            r0 = r5
            int r0 = java.util.Collections.secondaryHash(r0)
            r6 = r0
            r0 = r4
            java.util.HashMap$HashMapEntry<K, V>[] r0 = r0.table
            r7 = r0
            r0 = r7
            r1 = r7
            int r1 = r1.length
            r2 = 1
            int r1 = r1 - r2
            r2 = r6
            r1 = r1 & r2
            r0 = r0[r1]
            r7 = r0
        L27:
            r0 = r7
            if (r0 == 0) goto Ld
            r0 = r7
            K r0 = r0.key
            r8 = r0
            r0 = r8
            r1 = r5
            if (r0 == r1) goto L48
            r0 = r7
            int r0 = r0.hash
            r1 = r6
            if (r0 != r1) goto L4d
            r0 = r5
            r1 = r8
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4d
        L48:
            r0 = r7
            V r0 = r0.value
            return r0
        L4d:
            r0 = r7
            java.util.HashMap$HashMapEntry<K, V> r0 = r0.next
            r7 = r0
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.get(java.lang.Object):java.lang.Object");
    }

    void init() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new EntryIterator();
    }

    Iterator<K> newKeyIterator() {
        return new KeyIterator();
    }

    Iterator<V> newValueIterator() {
        return new ValueIterator();
    }

    void postRemove(HashMapEntry<K, V> hashMapEntry) {
    }

    void preModify(HashMapEntry<K, V> hashMapEntry) {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            return putValueForNullKey(v);
        }
        int secondaryHash = Collections.secondaryHash(k);
        HashMapEntry<K, V>[] hashMapEntryArr = this.table;
        int length = secondaryHash & (hashMapEntryArr.length - 1);
        HashMapEntry<K, V> hashMapEntry = hashMapEntryArr[length];
        while (true) {
            HashMapEntry<K, V> hashMapEntry2 = hashMapEntry;
            if (hashMapEntry2 == null) {
                this.modCount++;
                int i = this.size;
                this.size = i + 1;
                if (i > this.threshold) {
                    length = secondaryHash & (doubleCapacity().length - 1);
                }
                addNewEntry(k, v, secondaryHash, length);
                return null;
            } else if (hashMapEntry2.hash == secondaryHash && k.equals(hashMapEntry2.key)) {
                preModify(hashMapEntry2);
                V v2 = hashMapEntry2.value;
                hashMapEntry2.value = v;
                return v2;
            } else {
                hashMapEntry = hashMapEntry2.next;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size());
        super.putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return removeNullKey();
        }
        int secondaryHash = Collections.secondaryHash(obj);
        HashMapEntry<K, V>[] hashMapEntryArr = this.table;
        int length = secondaryHash & (hashMapEntryArr.length - 1);
        HashMapEntry<K, V> hashMapEntry = null;
        for (HashMapEntry<K, V> hashMapEntry2 = hashMapEntryArr[length]; hashMapEntry2 != null; hashMapEntry2 = hashMapEntry2.next) {
            if (hashMapEntry2.hash == secondaryHash && obj.equals(hashMapEntry2.key)) {
                if (hashMapEntry == null) {
                    hashMapEntryArr[length] = hashMapEntry2.next;
                } else {
                    hashMapEntry.next = hashMapEntry2.next;
                }
                this.modCount++;
                this.size--;
                postRemove(hashMapEntry2);
                return hashMapEntry2.value;
            }
            hashMapEntry = hashMapEntry2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }
}
