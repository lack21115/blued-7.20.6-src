package java.util;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/MapEntry.class */
public class MapEntry<K, V> implements Map.Entry<K, V>, Cloneable {
    K key;
    V value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/MapEntry$Type.class */
    public interface Type<RT, KT, VT> {
        RT get(MapEntry<KT, VT> mapEntry);
    }

    MapEntry(K k) {
        this.key = k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (this.key == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.key.equals(entry.getKey())) {
                return false;
            }
            return this.value == null ? entry.getValue() == null : this.value.equals(entry.getValue());
        }
        return false;
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
