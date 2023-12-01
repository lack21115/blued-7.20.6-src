package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ObjectCountHashMap.class */
public class ObjectCountHashMap<K> {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;
    transient long[] entries;
    transient Object[] keys;
    private transient float loadFactor;
    transient int modCount;
    transient int size;
    private transient int[] table;
    private transient int threshold;
    transient int[] values;

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ObjectCountHashMap$MapEntry.class */
    class MapEntry extends Multisets.AbstractEntry<K> {
        @NullableDecl
        final K key;
        int lastKnownIndex;

        MapEntry(int i) {
            this.key = (K) ObjectCountHashMap.this.keys[i];
            this.lastKnownIndex = i;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            updateLastKnownIndex();
            if (this.lastKnownIndex == -1) {
                return 0;
            }
            return ObjectCountHashMap.this.values[this.lastKnownIndex];
        }

        @Override // com.google.common.collect.Multiset.Entry
        public K getElement() {
            return this.key;
        }

        public int setCount(int i) {
            updateLastKnownIndex();
            if (this.lastKnownIndex == -1) {
                ObjectCountHashMap.this.put(this.key, i);
                return 0;
            }
            int i2 = ObjectCountHashMap.this.values[this.lastKnownIndex];
            ObjectCountHashMap.this.values[this.lastKnownIndex] = i;
            return i2;
        }

        void updateLastKnownIndex() {
            int i = this.lastKnownIndex;
            if (i == -1 || i >= ObjectCountHashMap.this.size() || !Objects.equal(this.key, ObjectCountHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = ObjectCountHashMap.this.indexOf(this.key);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap() {
        init(3, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap(int i) {
        this(i, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap(int i, float f) {
        init(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap(ObjectCountHashMap<? extends K> objectCountHashMap) {
        init(objectCountHashMap.size(), 1.0f);
        int firstIndex = objectCountHashMap.firstIndex();
        while (true) {
            int i = firstIndex;
            if (i == -1) {
                return;
            }
            put(objectCountHashMap.getKey(i), objectCountHashMap.getValue(i));
            firstIndex = objectCountHashMap.nextIndex(i);
        }
    }

    public static <K> ObjectCountHashMap<K> create() {
        return new ObjectCountHashMap<>();
    }

    public static <K> ObjectCountHashMap<K> createWithExpectedSize(int i) {
        return new ObjectCountHashMap<>(i);
    }

    private static int getHash(long j) {
        return (int) (j >>> 32);
    }

    private static int getNext(long j) {
        return (int) j;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static long[] newEntries(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int remove(@NullableDecl Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.entries[i2]) == i && Objects.equal(obj, this.keys[i2])) {
                int i4 = this.values[i2];
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                moveLastEntry(i2);
                this.size--;
                this.modCount++;
                return i4;
            }
            int next = getNext(this.entries[i2]);
            if (next == -1) {
                return 0;
            }
            i3 = i2;
            i2 = next;
        }
    }

    private void resizeMeMaybe(int i) {
        int length = this.entries.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            int i2 = max;
            if (max < 0) {
                i2 = Integer.MAX_VALUE;
            }
            if (i2 != length) {
                resizeEntries(i2);
            }
        }
    }

    private void resizeTable(int i) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i2 = (int) (i * this.loadFactor);
        int[] newTable = newTable(i);
        long[] jArr = this.entries;
        int length = newTable.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.size) {
                this.threshold = i2 + 1;
                this.table = newTable;
                return;
            }
            int hash = getHash(jArr[i4]);
            int i5 = hash & (length - 1);
            int i6 = newTable[i5];
            newTable[i5] = i4;
            jArr[i4] = (hash << 32) | (i6 & 4294967295L);
            i3 = i4 + 1;
        }
    }

    private static long swapNext(long j, int i) {
        return (j & HASH_MASK) | (i & 4294967295L);
    }

    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, 0);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return indexOf(obj) != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureCapacity(int i) {
        if (i > this.entries.length) {
            resizeEntries(i);
        }
        if (i >= this.threshold) {
            resizeTable(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int firstIndex() {
        return this.size == 0 ? -1 : 0;
    }

    public int get(@NullableDecl Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        return this.values[indexOf];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Multiset.Entry<K> getEntry(int i) {
        Preconditions.checkElementIndex(i, this.size);
        return new MapEntry(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public K getKey(int i) {
        Preconditions.checkElementIndex(i, this.size);
        return (K) this.keys[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getValue(int i) {
        Preconditions.checkElementIndex(i, this.size);
        return this.values[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOf(@NullableDecl Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int i = this.table[hashTableMask() & smearedHash];
        while (true) {
            int i2 = i;
            if (i2 == -1) {
                return -1;
            }
            long j = this.entries[i2];
            if (getHash(j) == smearedHash && Objects.equal(obj, this.keys[i2])) {
                return i2;
            }
            i = getNext(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(int i, float f) {
        Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        boolean z = false;
        if (f > 0.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Illegal load factor");
        int closedTableSize = Hashing.closedTableSize(i, f);
        this.table = newTable(closedTableSize);
        this.loadFactor = f;
        this.keys = new Object[i];
        this.values = new int[i];
        this.entries = newEntries(i);
        this.threshold = Math.max(1, (int) (closedTableSize * f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertEntry(int i, @NullableDecl K k, int i2, int i3) {
        this.entries[i] = (i3 << 32) | 4294967295L;
        this.keys[i] = k;
        this.values[i] = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void moveLastEntry(int i) {
        int size = size() - 1;
        if (i >= size) {
            this.keys[i] = null;
            this.values[i] = 0;
            this.entries[i] = -1;
            return;
        }
        Object[] objArr = this.keys;
        objArr[i] = objArr[size];
        int[] iArr = this.values;
        iArr[i] = iArr[size];
        objArr[size] = null;
        iArr[size] = 0;
        long[] jArr = this.entries;
        long j = jArr[size];
        jArr[i] = j;
        jArr[size] = -1;
        int hash = getHash(j) & hashTableMask();
        int[] iArr2 = this.table;
        int i2 = iArr2[hash];
        int i3 = i2;
        if (i2 == size) {
            iArr2[hash] = i;
            return;
        }
        while (true) {
            long j2 = this.entries[i3];
            int next = getNext(j2);
            if (next == size) {
                this.entries[i3] = swapNext(j2, i);
                return;
            }
            i3 = next;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int nextIndex(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int nextIndexAfterRemove(int i, int i2) {
        return i - 1;
    }

    public int put(@NullableDecl K k, int i) {
        CollectPreconditions.checkPositive(i, "count");
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int smearedHash = Hashing.smearedHash(k);
        int hashTableMask = hashTableMask() & smearedHash;
        int i2 = this.size;
        int[] iArr2 = this.table;
        int i3 = iArr2[hashTableMask];
        int i4 = i3;
        if (i3 == -1) {
            iArr2[hashTableMask] = i2;
        } else {
            while (true) {
                long j = jArr[i4];
                if (getHash(j) == smearedHash && Objects.equal(k, objArr[i4])) {
                    int i5 = iArr[i4];
                    iArr[i4] = i;
                    return i5;
                }
                int next = getNext(j);
                if (next == -1) {
                    jArr[i4] = swapNext(j, i2);
                    break;
                }
                i4 = next;
            }
        }
        if (i2 != Integer.MAX_VALUE) {
            int i6 = i2 + 1;
            resizeMeMaybe(i6);
            insertEntry(i2, k, i, smearedHash);
            this.size = i6;
            if (i2 >= this.threshold) {
                resizeTable(this.table.length * 2);
            }
            this.modCount++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int remove(@NullableDecl Object obj) {
        return remove(obj, Hashing.smearedHash(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int removeEntry(int i) {
        return remove(this.keys[i], getHash(this.entries[i]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resizeEntries(int i) {
        this.keys = Arrays.copyOf(this.keys, i);
        this.values = Arrays.copyOf(this.values, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValue(int i, int i2) {
        Preconditions.checkElementIndex(i, this.size);
        this.values[i] = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return this.size;
    }
}
