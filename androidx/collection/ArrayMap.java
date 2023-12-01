package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/collection/ArrayMap.class */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: a  reason: collision with root package name */
    MapCollections<K, V> f1940a;

    public ArrayMap() {
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    private MapCollections<K, V> b() {
        if (this.f1940a == null) {
            this.f1940a = new MapCollections<K, V>() { // from class: androidx.collection.ArrayMap.1
                @Override // androidx.collection.MapCollections
                protected int a() {
                    return ArrayMap.this.h;
                }

                @Override // androidx.collection.MapCollections
                protected int a(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                @Override // androidx.collection.MapCollections
                protected Object a(int i, int i2) {
                    return ArrayMap.this.g[(i << 1) + i2];
                }

                @Override // androidx.collection.MapCollections
                protected V a(int i, V v) {
                    return ArrayMap.this.setValueAt(i, v);
                }

                @Override // androidx.collection.MapCollections
                protected void a(int i) {
                    ArrayMap.this.removeAt(i);
                }

                @Override // androidx.collection.MapCollections
                protected void a(K k, V v) {
                    ArrayMap.this.put(k, v);
                }

                @Override // androidx.collection.MapCollections
                protected int b(Object obj) {
                    return ArrayMap.this.a(obj);
                }

                @Override // androidx.collection.MapCollections
                protected Map<K, V> b() {
                    return ArrayMap.this;
                }

                @Override // androidx.collection.MapCollections
                protected void c() {
                    ArrayMap.this.clear();
                }
            };
        }
        return this.f1940a;
    }

    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().getKeySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().getValues();
    }
}
