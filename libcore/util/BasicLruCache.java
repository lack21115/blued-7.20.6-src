package libcore.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:libcore/util/BasicLruCache.class */
public class BasicLruCache<K, V> {
    private final LinkedHashMap<K, V> map;
    private final int maxSize;

    public BasicLruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    private void trimToSize(int i) {
        while (this.map.size() > i) {
            Map.Entry<K, V> eldest = this.map.eldest();
            K key = eldest.getKey();
            V value = eldest.getValue();
            this.map.remove(key);
            entryEvicted(key, value);
        }
    }

    protected V create(K k) {
        return null;
    }

    protected void entryEvicted(K k, V v) {
    }

    public final void evictAll() {
        synchronized (this) {
            trimToSize(0);
        }
    }

    public final V get(K k) {
        V v;
        synchronized (this) {
            if (k == null) {
                throw new NullPointerException("key == null");
            }
            V v2 = this.map.get(k);
            if (v2 != null) {
                v = v2;
            } else {
                V create = create(k);
                if (create != null) {
                    this.map.put(k, create);
                    trimToSize(this.maxSize);
                }
                v = create;
            }
        }
        return v;
    }

    public final V put(K k, V v) {
        V put;
        synchronized (this) {
            if (k == null) {
                throw new NullPointerException("key == null");
            }
            if (v == null) {
                throw new NullPointerException("value == null");
            }
            put = this.map.put(k, v);
            trimToSize(this.maxSize);
        }
        return put;
    }

    public final V remove(K k) {
        V remove;
        synchronized (this) {
            if (k == null) {
                throw new NullPointerException("key == null");
            }
            remove = this.map.remove(k);
        }
        return remove;
    }

    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this) {
            linkedHashMap = new LinkedHashMap(this.map);
        }
        return linkedHashMap;
    }
}
