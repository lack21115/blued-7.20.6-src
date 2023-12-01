package java.util;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/util/LinkedHashMap.class */
public class LinkedHashMap<K, V> extends HashMap<K, V> {
    private static final long serialVersionUID = 3801124242820219131L;
    private final boolean accessOrder;
    transient LinkedEntry<K, V> header;

    /* loaded from: source-2895416-dex2jar.jar:java/util/LinkedHashMap$EntryIterator.class */
    private final class EntryIterator extends LinkedHashMap<K, V>.LinkedHashIterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/LinkedHashMap$KeyIterator.class */
    private final class KeyIterator extends LinkedHashMap<K, V>.LinkedHashIterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public final K next() {
            return nextEntry().key;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/LinkedHashMap$LinkedEntry.class */
    public static class LinkedEntry<K, V> extends HashMap.HashMapEntry<K, V> {
        LinkedEntry<K, V> nxt;
        LinkedEntry<K, V> prv;

        LinkedEntry() {
            super(null, null, 0, null);
            this.prv = this;
            this.nxt = this;
        }

        LinkedEntry(K k, V v, int i, HashMap.HashMapEntry<K, V> hashMapEntry, LinkedEntry<K, V> linkedEntry, LinkedEntry<K, V> linkedEntry2) {
            super(k, v, i, hashMapEntry);
            this.nxt = linkedEntry;
            this.prv = linkedEntry2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/LinkedHashMap$LinkedHashIterator.class */
    public abstract class LinkedHashIterator<T> implements Iterator<T> {
        int expectedModCount;
        LinkedEntry<K, V> lastReturned;
        LinkedEntry<K, V> next;

        private LinkedHashIterator() {
            this.next = LinkedHashMap.this.header.nxt;
            this.lastReturned = null;
            this.expectedModCount = LinkedHashMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != LinkedHashMap.this.header;
        }

        final LinkedEntry<K, V> nextEntry() {
            if (LinkedHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkedEntry<K, V> linkedEntry = this.next;
            if (linkedEntry == LinkedHashMap.this.header) {
                throw new NoSuchElementException();
            }
            this.next = linkedEntry.nxt;
            this.lastReturned = linkedEntry;
            return linkedEntry;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (LinkedHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            LinkedHashMap.this.remove(this.lastReturned.key);
            this.lastReturned = null;
            this.expectedModCount = LinkedHashMap.this.modCount;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/LinkedHashMap$ValueIterator.class */
    private final class ValueIterator extends LinkedHashMap<K, V>.LinkedHashIterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public final V next() {
            return nextEntry().value;
        }
    }

    public LinkedHashMap() {
        init();
        this.accessOrder = false;
    }

    public LinkedHashMap(int i) {
        this(i, 0.75f);
    }

    public LinkedHashMap(int i, float f) {
        this(i, f, false);
    }

    public LinkedHashMap(int i, float f, boolean z) {
        super(i, f);
        init();
        this.accessOrder = z;
    }

    public LinkedHashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
    }

    private void makeTail(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.prv.nxt = linkedEntry.nxt;
        linkedEntry.nxt.prv = linkedEntry.prv;
        LinkedEntry<K, V> linkedEntry2 = this.header;
        LinkedEntry<K, V> linkedEntry3 = linkedEntry2.prv;
        linkedEntry.nxt = linkedEntry2;
        linkedEntry.prv = linkedEntry3;
        linkedEntry2.prv = linkedEntry;
        linkedEntry3.nxt = linkedEntry;
        this.modCount++;
    }

    @Override // java.util.HashMap
    void addNewEntry(K k, V v, int i, int i2) {
        LinkedEntry<K, V> linkedEntry = this.header;
        LinkedEntry<K, V> linkedEntry2 = linkedEntry.nxt;
        if (linkedEntry2 != linkedEntry && removeEldestEntry(linkedEntry2)) {
            remove(linkedEntry2.key);
        }
        LinkedEntry<K, V> linkedEntry3 = linkedEntry.prv;
        LinkedEntry<K, V> linkedEntry4 = new LinkedEntry<>(k, v, i, this.table[i2], linkedEntry, linkedEntry3);
        HashMap.HashMapEntry<K, V>[] hashMapEntryArr = this.table;
        linkedEntry.prv = linkedEntry4;
        linkedEntry3.nxt = linkedEntry4;
        hashMapEntryArr[i2] = linkedEntry4;
    }

    @Override // java.util.HashMap
    void addNewEntryForNullKey(V v) {
        LinkedEntry<K, V> linkedEntry = this.header;
        LinkedEntry<K, V> linkedEntry2 = linkedEntry.nxt;
        if (linkedEntry2 != linkedEntry && removeEldestEntry(linkedEntry2)) {
            remove(linkedEntry2.key);
        }
        LinkedEntry<K, V> linkedEntry3 = linkedEntry.prv;
        LinkedEntry<K, V> linkedEntry4 = new LinkedEntry<>(null, v, 0, null, linkedEntry, linkedEntry3);
        linkedEntry.prv = linkedEntry4;
        linkedEntry3.nxt = linkedEntry4;
        this.entryForNullKey = linkedEntry4;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        LinkedEntry<K, V> linkedEntry = this.header;
        LinkedEntry<K, V> linkedEntry2 = linkedEntry.nxt;
        while (true) {
            LinkedEntry<K, V> linkedEntry3 = linkedEntry2;
            if (linkedEntry3 == linkedEntry) {
                linkedEntry.prv = linkedEntry;
                linkedEntry.nxt = linkedEntry;
                return;
            }
            LinkedEntry<K, V> linkedEntry4 = linkedEntry3.nxt;
            linkedEntry3.prv = null;
            linkedEntry3.nxt = null;
            linkedEntry2 = linkedEntry4;
        }
    }

    @Override // java.util.HashMap
    HashMap.HashMapEntry<K, V> constructorNewEntry(K k, V v, int i, HashMap.HashMapEntry<K, V> hashMapEntry) {
        LinkedEntry<K, V> linkedEntry = this.header;
        LinkedEntry<K, V> linkedEntry2 = linkedEntry.prv;
        LinkedEntry<K, V> linkedEntry3 = new LinkedEntry<>(k, v, i, hashMapEntry, linkedEntry, linkedEntry2);
        linkedEntry.prv = linkedEntry3;
        linkedEntry2.nxt = linkedEntry3;
        return linkedEntry3;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            LinkedEntry<K, V> linkedEntry = this.header;
            LinkedEntry<K, V> linkedEntry2 = linkedEntry.nxt;
            while (true) {
                LinkedEntry<K, V> linkedEntry3 = linkedEntry2;
                if (linkedEntry3 == linkedEntry) {
                    return false;
                }
                if (linkedEntry3.value == null) {
                    return true;
                }
                linkedEntry2 = linkedEntry3.nxt;
            }
        } else {
            LinkedEntry<K, V> linkedEntry4 = this.header;
            LinkedEntry<K, V> linkedEntry5 = linkedEntry4.nxt;
            while (true) {
                LinkedEntry<K, V> linkedEntry6 = linkedEntry5;
                if (linkedEntry6 == linkedEntry4) {
                    return false;
                }
                if (obj.equals(linkedEntry6.value)) {
                    return true;
                }
                linkedEntry5 = linkedEntry6.nxt;
            }
        }
    }

    public Map.Entry<K, V> eldest() {
        LinkedEntry<K, V> linkedEntry = this.header.nxt;
        if (linkedEntry != this.header) {
            return linkedEntry;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        if (r4.accessOrder == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        makeTail((java.util.LinkedHashMap.LinkedEntry) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        return r7.value;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V get(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 != 0) goto L23
            r0 = r4
            java.util.HashMap$HashMapEntry<K, V> r0 = r0.entryForNullKey
            r5 = r0
            r0 = r5
            if (r0 != 0) goto Lf
        Ld:
            r0 = 0
            return r0
        Lf:
            r0 = r4
            boolean r0 = r0.accessOrder
            if (r0 == 0) goto L1e
            r0 = r4
            r1 = r5
            java.util.LinkedHashMap$LinkedEntry r1 = (java.util.LinkedHashMap.LinkedEntry) r1
            r0.makeTail(r1)
        L1e:
            r0 = r5
            V r0 = r0.value
            return r0
        L23:
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
        L36:
            r0 = r7
            if (r0 == 0) goto Ld
            r0 = r7
            K r0 = r0.key
            r8 = r0
            r0 = r8
            r1 = r5
            if (r0 == r1) goto L57
            r0 = r7
            int r0 = r0.hash
            r1 = r6
            if (r0 != r1) goto L6b
            r0 = r5
            r1 = r8
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
        L57:
            r0 = r4
            boolean r0 = r0.accessOrder
            if (r0 == 0) goto L66
            r0 = r4
            r1 = r7
            java.util.LinkedHashMap$LinkedEntry r1 = (java.util.LinkedHashMap.LinkedEntry) r1
            r0.makeTail(r1)
        L66:
            r0 = r7
            V r0 = r0.value
            return r0
        L6b:
            r0 = r7
            java.util.HashMap$HashMapEntry<K, V> r0 = r0.next
            r7 = r0
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.LinkedHashMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.HashMap
    void init() {
        this.header = new LinkedEntry<>();
    }

    @Override // java.util.HashMap
    Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new EntryIterator();
    }

    @Override // java.util.HashMap
    Iterator<K> newKeyIterator() {
        return new KeyIterator();
    }

    @Override // java.util.HashMap
    Iterator<V> newValueIterator() {
        return new ValueIterator();
    }

    @Override // java.util.HashMap
    void postRemove(HashMap.HashMapEntry<K, V> hashMapEntry) {
        LinkedEntry linkedEntry = (LinkedEntry) hashMapEntry;
        linkedEntry.prv.nxt = linkedEntry.nxt;
        linkedEntry.nxt.prv = linkedEntry.prv;
        linkedEntry.prv = null;
        linkedEntry.nxt = null;
    }

    @Override // java.util.HashMap
    void preModify(HashMap.HashMapEntry<K, V> hashMapEntry) {
        if (this.accessOrder) {
            makeTail((LinkedEntry) hashMapEntry);
        }
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return false;
    }
}
