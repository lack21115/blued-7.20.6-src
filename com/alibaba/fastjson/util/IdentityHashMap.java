package com.alibaba.fastjson.util;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/util/IdentityHashMap.class */
public class IdentityHashMap<K, V> {
    private final Entry<K, V>[] buckets;
    private final int indexMask;

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/util/IdentityHashMap$Entry.class */
    public static final class Entry<K, V> {
        public final int hashCode;
        public final K key;
        public final Entry<K, V> next;
        public V value;

        public Entry(K k, V v, int i, Entry<K, V> entry) {
            this.key = k;
            this.value = v;
            this.next = entry;
            this.hashCode = i;
        }
    }

    public IdentityHashMap() {
        this(1024);
    }

    public IdentityHashMap(int i) {
        this.indexMask = i - 1;
        this.buckets = new Entry[i];
    }

    public final V get(K k) {
        Entry<K, V> entry = this.buckets[System.identityHashCode(k) & this.indexMask];
        while (true) {
            Entry<K, V> entry2 = entry;
            if (entry2 == null) {
                return null;
            }
            if (k == entry2.key) {
                return entry2.value;
            }
            entry = entry2.next;
        }
    }

    public boolean put(K k, V v) {
        int identityHashCode = System.identityHashCode(k);
        int i = this.indexMask & identityHashCode;
        Entry<K, V> entry = this.buckets[i];
        while (true) {
            Entry<K, V> entry2 = entry;
            if (entry2 == null) {
                this.buckets[i] = new Entry<>(k, v, identityHashCode, this.buckets[i]);
                return false;
            } else if (k == entry2.key) {
                entry2.value = v;
                return true;
            } else {
                entry = entry2.next;
            }
        }
    }
}
