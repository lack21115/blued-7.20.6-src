package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable.class */
public class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>, Cloneable, Serializable {
    private static final int CHARS_PER_ENTRY = 15;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final int MINIMUM_CAPACITY = 4;
    private static final long serialVersionUID = 1421746759512286392L;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient Set<K> keySet;
    private transient int modCount;
    private transient int size;
    private transient HashtableEntry<K, V>[] table;
    private transient int threshold;
    private transient Collection<V> values;
    private static final Map.Entry[] EMPTY_TABLE = new HashtableEntry[2];
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("threshold", Integer.TYPE), new ObjectStreamField("loadFactor", Float.TYPE)};

    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$EntryIterator.class */
    private final class EntryIterator extends Hashtable<K, V>.HashIterator implements Iterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$EntrySet.class */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Hashtable.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return Hashtable.this.containsMapping(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (Hashtable.this) {
                containsAll = super.containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (Hashtable.this) {
                equals = super.equals(obj);
            }
            return equals;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return Hashtable.this.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return Hashtable.this.removeMapping(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (Hashtable.this) {
                removeAll = super.removeAll(collection);
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (Hashtable.this) {
                retainAll = super.retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Hashtable.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] array;
            synchronized (Hashtable.this) {
                array = super.toArray();
            }
            return array;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (Hashtable.this) {
                tArr2 = (T[]) super.toArray(tArr);
            }
            return tArr2;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String abstractSet;
            synchronized (Hashtable.this) {
                abstractSet = super.toString();
            }
            return abstractSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$HashIterator.class */
    public abstract class HashIterator {
        int expectedModCount;
        HashtableEntry<K, V> lastEntryReturned;
        HashtableEntry<K, V> nextEntry;
        int nextIndex;

        HashIterator() {
            HashtableEntry<K, V> hashtableEntry;
            this.expectedModCount = Hashtable.this.modCount;
            HashtableEntry<K, V>[] hashtableEntryArr = Hashtable.this.table;
            HashtableEntry<K, V> hashtableEntry2 = null;
            while (true) {
                hashtableEntry = hashtableEntry2;
                if (hashtableEntry != null || this.nextIndex >= hashtableEntryArr.length) {
                    break;
                }
                int i = this.nextIndex;
                this.nextIndex = i + 1;
                hashtableEntry2 = hashtableEntryArr[i];
            }
            this.nextEntry = hashtableEntry;
        }

        public boolean hasNext() {
            return this.nextEntry != null;
        }

        HashtableEntry<K, V> nextEntry() {
            HashtableEntry<K, V> hashtableEntry;
            if (Hashtable.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (this.nextEntry == null) {
                throw new NoSuchElementException();
            }
            HashtableEntry<K, V> hashtableEntry2 = this.nextEntry;
            HashtableEntry<K, V>[] hashtableEntryArr = Hashtable.this.table;
            HashtableEntry<K, V> hashtableEntry3 = hashtableEntry2.next;
            while (true) {
                hashtableEntry = hashtableEntry3;
                if (hashtableEntry != null || this.nextIndex >= hashtableEntryArr.length) {
                    break;
                }
                int i = this.nextIndex;
                this.nextIndex = i + 1;
                hashtableEntry3 = hashtableEntryArr[i];
            }
            this.nextEntry = hashtableEntry;
            this.lastEntryReturned = hashtableEntry2;
            return hashtableEntry2;
        }

        HashtableEntry<K, V> nextEntryNotFailFast() {
            HashtableEntry<K, V> hashtableEntry;
            if (this.nextEntry == null) {
                throw new NoSuchElementException();
            }
            HashtableEntry<K, V> hashtableEntry2 = this.nextEntry;
            HashtableEntry<K, V>[] hashtableEntryArr = Hashtable.this.table;
            HashtableEntry<K, V> hashtableEntry3 = hashtableEntry2.next;
            while (true) {
                hashtableEntry = hashtableEntry3;
                if (hashtableEntry != null || this.nextIndex >= hashtableEntryArr.length) {
                    break;
                }
                int i = this.nextIndex;
                this.nextIndex = i + 1;
                hashtableEntry3 = hashtableEntryArr[i];
            }
            this.nextEntry = hashtableEntry;
            this.lastEntryReturned = hashtableEntry2;
            return hashtableEntry2;
        }

        public void remove() {
            if (this.lastEntryReturned == null) {
                throw new IllegalStateException();
            }
            if (Hashtable.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            Hashtable.this.remove(this.lastEntryReturned.key);
            this.lastEntryReturned = null;
            this.expectedModCount = Hashtable.this.modCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$HashtableEntry.class */
    public static class HashtableEntry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        HashtableEntry<K, V> next;
        V value;

        HashtableEntry(K k, V v, int i, HashtableEntry<K, V> hashtableEntry) {
            this.key = k;
            this.value = v;
            this.hash = i;
            this.next = hashtableEntry;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.key.equals(entry.getKey()) && this.value.equals(entry.getValue());
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
            return this.key.hashCode() ^ this.value.hashCode();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            if (v == null) {
                throw new NullPointerException("value == null");
            }
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$KeyEnumeration.class */
    public final class KeyEnumeration extends Hashtable<K, V>.HashIterator implements Enumeration<K> {
        private KeyEnumeration() {
            super();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return hasNext();
        }

        @Override // java.util.Enumeration
        public K nextElement() {
            return nextEntryNotFailFast().key;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$KeyIterator.class */
    private final class KeyIterator extends Hashtable<K, V>.HashIterator implements Iterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().key;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$KeySet.class */
    public final class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Hashtable.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Hashtable.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (Hashtable.this) {
                containsAll = super.containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (Hashtable.this) {
                equals = super.equals(obj);
            }
            return equals;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (Hashtable.this) {
                hashCode = super.hashCode();
            }
            return hashCode;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z;
            synchronized (Hashtable.this) {
                int i = Hashtable.this.size;
                Hashtable.this.remove(obj);
                z = Hashtable.this.size != i;
            }
            return z;
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (Hashtable.this) {
                removeAll = super.removeAll(collection);
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (Hashtable.this) {
                retainAll = super.retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Hashtable.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] array;
            synchronized (Hashtable.this) {
                array = super.toArray();
            }
            return array;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (Hashtable.this) {
                tArr2 = (T[]) super.toArray(tArr);
            }
            return tArr2;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String abstractSet;
            synchronized (Hashtable.this) {
                abstractSet = super.toString();
            }
            return abstractSet;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$ValueEnumeration.class */
    private final class ValueEnumeration extends Hashtable<K, V>.HashIterator implements Enumeration<V> {
        private ValueEnumeration() {
            super();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return hasNext();
        }

        @Override // java.util.Enumeration
        public V nextElement() {
            return nextEntryNotFailFast().value;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$ValueIterator.class */
    private final class ValueIterator extends Hashtable<K, V>.HashIterator implements Iterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Hashtable$Values.class */
    public final class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Hashtable.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Hashtable.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (Hashtable.this) {
                containsAll = super.containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Hashtable.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] array;
            synchronized (Hashtable.this) {
                array = super.toArray();
            }
            return array;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (Hashtable.this) {
                tArr2 = (T[]) super.toArray(tArr);
            }
            return tArr2;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String abstractCollection;
            synchronized (Hashtable.this) {
                abstractCollection = super.toString();
            }
            return abstractCollection;
        }
    }

    public Hashtable() {
        this.table = (HashtableEntry[]) EMPTY_TABLE;
        this.threshold = -1;
    }

    public Hashtable(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Capacity: " + i);
        }
        if (i != 0) {
            makeTable(i < 4 ? 4 : i > 1073741824 ? 1073741824 : Collections.roundUpToPowerOfTwo(i));
            return;
        }
        this.table = (HashtableEntry[]) EMPTY_TABLE;
        this.threshold = -1;
    }

    public Hashtable(int i, float f) {
        this(i);
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Load factor: " + f);
        }
    }

    public Hashtable(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
    }

    private static int capacityForInitSize(int i) {
        int i2 = (i >> 1) + i;
        if (((-1073741824) & i2) == 0) {
            return i2;
        }
        return 1073741824;
    }

    private void constructorPut(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        if (v == null) {
            throw new NullPointerException("value == null");
        }
        int secondaryHash = Collections.secondaryHash(k);
        HashtableEntry<K, V>[] hashtableEntryArr = this.table;
        int length = secondaryHash & (hashtableEntryArr.length - 1);
        HashtableEntry<K, V> hashtableEntry = hashtableEntryArr[length];
        HashtableEntry<K, V> hashtableEntry2 = hashtableEntry;
        while (true) {
            HashtableEntry<K, V> hashtableEntry3 = hashtableEntry2;
            if (hashtableEntry3 == null) {
                hashtableEntryArr[length] = new HashtableEntry<>(k, v, secondaryHash, hashtableEntry);
                this.size++;
                return;
            } else if (hashtableEntry3.hash == secondaryHash && k.equals(hashtableEntry3.key)) {
                hashtableEntry3.value = v;
                return;
            } else {
                hashtableEntry2 = hashtableEntry3.next;
            }
        }
    }

    private void constructorPutAll(Map<? extends K, ? extends V> map) {
        if (this.table == EMPTY_TABLE) {
            doubleCapacity();
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            constructorPut(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        r9 = r10.value.equals(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean containsMapping(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            r0 = r5
            monitor-enter(r0)
            r0 = r6
            int r0 = java.util.Collections.secondaryHash(r0)     // Catch: java.lang.Throwable -> L53
            r8 = r0
            r0 = r5
            java.util.Hashtable$HashtableEntry<K, V>[] r0 = r0.table     // Catch: java.lang.Throwable -> L53
            r10 = r0
            r0 = r10
            r1 = r8
            r2 = r10
            int r2 = r2.length     // Catch: java.lang.Throwable -> L53
            r3 = 1
            int r2 = r2 - r3
            r1 = r1 & r2
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L53
            r10 = r0
        L19:
            r0 = r10
            if (r0 == 0) goto L4d
            r0 = r10
            int r0 = r0.hash     // Catch: java.lang.Throwable -> L53
            r1 = r8
            if (r0 != r1) goto L43
            r0 = r10
            K r0 = r0.key     // Catch: java.lang.Throwable -> L53
            r1 = r6
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L53
            if (r0 == 0) goto L43
            r0 = r10
            V r0 = r0.value     // Catch: java.lang.Throwable -> L53
            r1 = r7
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L53
            r9 = r0
        L3e:
            r0 = r5
            monitor-exit(r0)
            r0 = r9
            return r0
        L43:
            r0 = r10
            java.util.Hashtable$HashtableEntry<K, V> r0 = r0.next     // Catch: java.lang.Throwable -> L53
            r10 = r0
            goto L19
        L4d:
            r0 = 0
            r9 = r0
            goto L3e
        L53:
            r6 = move-exception
            r0 = r5
            monitor-exit(r0)
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Hashtable.containsMapping(java.lang.Object, java.lang.Object):boolean");
    }

    private HashtableEntry<K, V>[] doubleCapacity() {
        HashtableEntry<K, V>[] hashtableEntryArr;
        HashtableEntry<K, V>[] hashtableEntryArr2 = this.table;
        int length = hashtableEntryArr2.length;
        if (length == 1073741824) {
            hashtableEntryArr = hashtableEntryArr2;
        } else {
            HashtableEntry<K, V>[] makeTable = makeTable(length * 2);
            hashtableEntryArr = makeTable;
            if (this.size != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    hashtableEntryArr = makeTable;
                    if (i2 >= length) {
                        break;
                    }
                    HashtableEntry<K, V> hashtableEntry = hashtableEntryArr2[i2];
                    if (hashtableEntry != null) {
                        int i3 = hashtableEntry.hash & length;
                        HashtableEntry<K, V> hashtableEntry2 = null;
                        makeTable[i2 | i3] = hashtableEntry;
                        HashtableEntry<K, V> hashtableEntry3 = hashtableEntry.next;
                        while (hashtableEntry3 != null) {
                            int i4 = hashtableEntry3.hash & length;
                            HashtableEntry<K, V> hashtableEntry4 = hashtableEntry2;
                            int i5 = i3;
                            if (i4 != i3) {
                                if (hashtableEntry2 == null) {
                                    makeTable[i2 | i4] = hashtableEntry3;
                                } else {
                                    hashtableEntry2.next = hashtableEntry3;
                                }
                                i5 = i4;
                                hashtableEntry4 = hashtableEntry;
                            }
                            hashtableEntry = hashtableEntry3;
                            hashtableEntry3 = hashtableEntry3.next;
                            hashtableEntry2 = hashtableEntry4;
                            i3 = i5;
                        }
                        if (hashtableEntry2 != null) {
                            hashtableEntry2.next = null;
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        return hashtableEntryArr;
    }

    private void ensureCapacity(int i) {
        int roundUpToPowerOfTwo = Collections.roundUpToPowerOfTwo(capacityForInitSize(i));
        HashtableEntry<K, V>[] hashtableEntryArr = this.table;
        int length = hashtableEntryArr.length;
        if (roundUpToPowerOfTwo <= length) {
            return;
        }
        rehash();
        if (roundUpToPowerOfTwo == length * 2) {
            doubleCapacity();
            return;
        }
        HashtableEntry<K, V>[] makeTable = makeTable(roundUpToPowerOfTwo);
        if (this.size == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            HashtableEntry<K, V> hashtableEntry = hashtableEntryArr[i3];
            while (true) {
                HashtableEntry<K, V> hashtableEntry2 = hashtableEntry;
                if (hashtableEntry2 != null) {
                    HashtableEntry<K, V> hashtableEntry3 = hashtableEntry2.next;
                    int i4 = hashtableEntry2.hash & (roundUpToPowerOfTwo - 1);
                    HashtableEntry<K, V> hashtableEntry4 = makeTable[i4];
                    makeTable[i4] = hashtableEntry2;
                    hashtableEntry2.next = hashtableEntry4;
                    hashtableEntry = hashtableEntry3;
                }
            }
            i2 = i3 + 1;
        }
    }

    private HashtableEntry<K, V>[] makeTable(int i) {
        HashtableEntry<K, V>[] hashtableEntryArr = new HashtableEntry[i];
        this.table = hashtableEntryArr;
        this.threshold = (i >> 1) + (i >> 2);
        return hashtableEntryArr;
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
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
        if (r11.value.equals(r6) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r12 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
        r0[r0] = r11.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
        r4.modCount++;
        r4.size--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
        r12.next = r11.next;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean removeMapping(java.lang.Object r5, java.lang.Object r6) {
        /*
            r4 = this;
            r0 = 0
            r10 = r0
            r0 = r4
            monitor-enter(r0)
            r0 = r5
            int r0 = java.util.Collections.secondaryHash(r0)     // Catch: java.lang.Throwable -> L90
            r7 = r0
            r0 = r4
            java.util.Hashtable$HashtableEntry<K, V>[] r0 = r0.table     // Catch: java.lang.Throwable -> L90
            r13 = r0
            r0 = r7
            r1 = r13
            int r1 = r1.length     // Catch: java.lang.Throwable -> L90
            r2 = 1
            int r1 = r1 - r2
            r0 = r0 & r1
            r8 = r0
            r0 = r13
            r1 = r8
            r0 = r0[r1]
            r11 = r0
            r0 = 0
            r12 = r0
        L23:
            r0 = r10
            r9 = r0
            r0 = r11
            if (r0 == 0) goto L55
            r0 = r11
            int r0 = r0.hash     // Catch: java.lang.Throwable -> L90
            r1 = r7
            if (r0 != r1) goto L95
            r0 = r11
            K r0 = r0.key     // Catch: java.lang.Throwable -> L90
            r1 = r5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L90
            if (r0 == 0) goto L95
            r0 = r11
            V r0 = r0.value     // Catch: java.lang.Throwable -> L90
            r1 = r6
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L90
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L5a
            r0 = r10
            r9 = r0
        L55:
            r0 = r4
            monitor-exit(r0)
            r0 = r9
            return r0
        L5a:
            r0 = r12
            if (r0 != 0) goto L83
            r0 = r13
            r1 = r8
            r2 = r11
            java.util.Hashtable$HashtableEntry<K, V> r2 = r2.next     // Catch: java.lang.Throwable -> L90
            r0[r1] = r2     // Catch: java.lang.Throwable -> L90
        L69:
            r0 = r4
            r1 = r4
            int r1 = r1.modCount     // Catch: java.lang.Throwable -> L90
            r2 = 1
            int r1 = r1 + r2
            r0.modCount = r1     // Catch: java.lang.Throwable -> L90
            r0 = r4
            r1 = r4
            int r1 = r1.size     // Catch: java.lang.Throwable -> L90
            r2 = 1
            int r1 = r1 - r2
            r0.size = r1     // Catch: java.lang.Throwable -> L90
            r0 = 1
            r9 = r0
            goto L55
        L83:
            r0 = r12
            r1 = r11
            java.util.Hashtable$HashtableEntry<K, V> r1 = r1.next     // Catch: java.lang.Throwable -> L90
            r0.next = r1     // Catch: java.lang.Throwable -> L90
            goto L69
        L90:
            r5 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r5
            throw r0
        L95:
            r0 = r11
            r12 = r0
            r0 = r11
            java.util.Hashtable$HashtableEntry<K, V> r0 = r0.next     // Catch: java.lang.Throwable -> L90
            r11 = r0
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Hashtable.removeMapping(java.lang.Object, java.lang.Object):boolean");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this) {
            ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            putFields.put("threshold", (int) (this.table.length * 0.75f));
            putFields.put("loadFactor", 0.75f);
            objectOutputStream.writeFields();
            objectOutputStream.writeInt(this.table.length);
            objectOutputStream.writeInt(this.size);
            for (Map.Entry<K, V> entry : entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
        }
    }

    public void clear() {
        synchronized (this) {
            if (this.size != 0) {
                Arrays.fill(this.table, (Object) null);
                this.modCount++;
                this.size = 0;
            }
        }
    }

    public Object clone() {
        Hashtable hashtable;
        synchronized (this) {
            try {
                hashtable = (Hashtable) super.clone();
                hashtable.makeTable(this.table.length);
                hashtable.size = 0;
                hashtable.keySet = null;
                hashtable.entrySet = null;
                hashtable.values = null;
                hashtable.constructorPutAll(this);
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
        return hashtable;
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        boolean z;
        synchronized (this) {
            int secondaryHash = Collections.secondaryHash(obj);
            HashtableEntry<K, V>[] hashtableEntryArr = this.table;
            for (HashtableEntry<K, V> hashtableEntry = hashtableEntryArr[(hashtableEntryArr.length - 1) & secondaryHash]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
                K k = hashtableEntry.key;
                if (k == obj || (hashtableEntry.hash == secondaryHash && obj.equals(k))) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        boolean z;
        synchronized (this) {
            if (obj == null) {
                throw new NullPointerException("value == null");
            }
            HashtableEntry<K, V>[] hashtableEntryArr = this.table;
            int length = hashtableEntryArr.length;
            int i = 0;
            loop0: while (true) {
                int i2 = i;
                if (i2 >= length) {
                    z = false;
                    break;
                }
                for (HashtableEntry<K, V> hashtableEntry = hashtableEntryArr[i2]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
                    if (obj.equals(hashtableEntry.value)) {
                        z = true;
                        break loop0;
                    }
                }
                i = i2 + 1;
            }
        }
        return z;
    }

    @Override // java.util.Dictionary
    public Enumeration<V> elements() {
        ValueEnumeration valueEnumeration;
        synchronized (this) {
            valueEnumeration = new ValueEnumeration();
        }
        return valueEnumeration;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        EntrySet entrySet;
        synchronized (this) {
            entrySet = this.entrySet;
            if (entrySet == null) {
                entrySet = new EntrySet();
                this.entrySet = entrySet;
            }
        }
        return entrySet;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        boolean z;
        synchronized (this) {
            if (obj instanceof Map) {
                if (entrySet().equals(((Map) obj).entrySet())) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    @Override // java.util.Dictionary, java.util.Map
    public V get(Object obj) {
        V v;
        synchronized (this) {
            int secondaryHash = Collections.secondaryHash(obj);
            HashtableEntry<K, V>[] hashtableEntryArr = this.table;
            for (HashtableEntry<K, V> hashtableEntry = hashtableEntryArr[(hashtableEntryArr.length - 1) & secondaryHash]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
                K k = hashtableEntry.key;
                if (k == obj || (hashtableEntry.hash == secondaryHash && obj.equals(k))) {
                    v = hashtableEntry.value;
                    break;
                }
            }
            v = null;
        }
        return v;
    }

    @Override // java.util.Map
    public int hashCode() {
        int i;
        synchronized (this) {
            i = 0;
            for (Map.Entry<K, V> entry : entrySet()) {
                K key = entry.getKey();
                V value = entry.getValue();
                if (key != this && value != this) {
                    i += (value != null ? value.hashCode() : 0) ^ (key != null ? key.hashCode() : 0);
                }
            }
        }
        return i;
    }

    @Override // java.util.Dictionary, java.util.Map
    public boolean isEmpty() {
        boolean z;
        synchronized (this) {
            z = this.size == 0;
        }
        return z;
    }

    public Set<K> keySet() {
        KeySet keySet;
        synchronized (this) {
            keySet = this.keySet;
            if (keySet == null) {
                keySet = new KeySet();
                this.keySet = keySet;
            }
        }
        return keySet;
    }

    @Override // java.util.Dictionary
    public Enumeration<K> keys() {
        KeyEnumeration keyEnumeration;
        synchronized (this) {
            keyEnumeration = new KeyEnumeration();
        }
        return keyEnumeration;
    }

    @Override // java.util.Dictionary, java.util.Map
    public V put(K k, V v) {
        V v2;
        synchronized (this) {
            if (k == null) {
                throw new NullPointerException("key == null");
            }
            if (v == null) {
                throw new NullPointerException("value == null");
            }
            int secondaryHash = Collections.secondaryHash(k);
            HashtableEntry<K, V>[] hashtableEntryArr = this.table;
            int length = secondaryHash & (hashtableEntryArr.length - 1);
            HashtableEntry<K, V> hashtableEntry = hashtableEntryArr[length];
            HashtableEntry<K, V> hashtableEntry2 = hashtableEntry;
            while (true) {
                if (hashtableEntry2 == null) {
                    this.modCount++;
                    int i = this.size;
                    this.size = i + 1;
                    HashtableEntry<K, V>[] hashtableEntryArr2 = hashtableEntryArr;
                    if (i > this.threshold) {
                        rehash();
                        hashtableEntryArr2 = doubleCapacity();
                        length = secondaryHash & (hashtableEntryArr2.length - 1);
                        hashtableEntry = hashtableEntryArr2[length];
                    }
                    hashtableEntryArr2[length] = new HashtableEntry<>(k, v, secondaryHash, hashtableEntry);
                    v2 = null;
                } else if (hashtableEntry2.hash == secondaryHash && k.equals(hashtableEntry2.key)) {
                    v2 = hashtableEntry2.value;
                    hashtableEntry2.value = v;
                    break;
                } else {
                    hashtableEntry2 = hashtableEntry2.next;
                }
            }
        }
        return v2;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        synchronized (this) {
            ensureCapacity(map.size());
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    protected void rehash() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r9 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
        r0[r0] = r8.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        r4.modCount++;
        r4.size--;
        r5 = r8.value;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
        r9.next = r8.next;
     */
    @Override // java.util.Dictionary, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V remove(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = r4
            monitor-enter(r0)
            r0 = r5
            int r0 = java.util.Collections.secondaryHash(r0)     // Catch: java.lang.Throwable -> L71
            r6 = r0
            r0 = r4
            java.util.Hashtable$HashtableEntry<K, V>[] r0 = r0.table     // Catch: java.lang.Throwable -> L71
            r10 = r0
            r0 = r6
            r1 = r10
            int r1 = r1.length     // Catch: java.lang.Throwable -> L71
            r2 = 1
            int r1 = r1 - r2
            r0 = r0 & r1
            r7 = r0
            r0 = r10
            r1 = r7
            r0 = r0[r1]
            r8 = r0
            r0 = 0
            r9 = r0
        L1e:
            r0 = r8
            if (r0 == 0) goto L84
            r0 = r8
            int r0 = r0.hash     // Catch: java.lang.Throwable -> L71
            r1 = r6
            if (r0 != r1) goto L76
            r0 = r5
            r1 = r8
            K r1 = r1.key     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L76
            r0 = r9
            if (r0 != 0) goto L64
            r0 = r10
            r1 = r7
            r2 = r8
            java.util.Hashtable$HashtableEntry<K, V> r2 = r2.next     // Catch: java.lang.Throwable -> L71
            r0[r1] = r2     // Catch: java.lang.Throwable -> L71
        L46:
            r0 = r4
            r1 = r4
            int r1 = r1.modCount     // Catch: java.lang.Throwable -> L71
            r2 = 1
            int r1 = r1 + r2
            r0.modCount = r1     // Catch: java.lang.Throwable -> L71
            r0 = r4
            r1 = r4
            int r1 = r1.size     // Catch: java.lang.Throwable -> L71
            r2 = 1
            int r1 = r1 - r2
            r0.size = r1     // Catch: java.lang.Throwable -> L71
            r0 = r8
            V r0 = r0.value     // Catch: java.lang.Throwable -> L71
            r5 = r0
        L60:
            r0 = r4
            monitor-exit(r0)
            r0 = r5
            return r0
        L64:
            r0 = r9
            r1 = r8
            java.util.Hashtable$HashtableEntry<K, V> r1 = r1.next     // Catch: java.lang.Throwable -> L71
            r0.next = r1     // Catch: java.lang.Throwable -> L71
            goto L46
        L71:
            r5 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r5
            throw r0
        L76:
            r0 = r8
            r9 = r0
            r0 = r8
            java.util.Hashtable$HashtableEntry<K, V> r0 = r0.next     // Catch: java.lang.Throwable -> L71
            r8 = r0
            goto L1e
        L84:
            r0 = 0
            r5 = r0
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Hashtable.remove(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Dictionary, java.util.Map
    public int size() {
        int i;
        synchronized (this) {
            i = this.size;
        }
        return i;
    }

    public String toString() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder(this.size * 15);
            sb2.append('{');
            Iterator<Map.Entry<K, V>> it = entrySet().iterator();
            boolean hasNext = it.hasNext();
            while (hasNext) {
                Map.Entry<K, V> next = it.next();
                K key = next.getKey();
                sb2.append(key == this ? "(this Map)" : key.toString());
                sb2.append('=');
                V value = next.getValue();
                sb2.append(value == this ? "(this Map)" : value.toString());
                boolean hasNext2 = it.hasNext();
                hasNext = hasNext2;
                if (hasNext2) {
                    sb2.append(", ");
                    hasNext = hasNext2;
                }
            }
            sb2.append('}');
            sb = sb2.toString();
        }
        return sb;
    }

    public Collection<V> values() {
        Values values;
        synchronized (this) {
            values = this.values;
            if (values == null) {
                values = new Values();
                this.values = values;
            }
        }
        return values;
    }
}
