package skin.support.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: source-3503164-dex2jar.jar:skin/support/collection/ArrayMap.class */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: a  reason: collision with root package name */
    MapCollections<K, V> f44204a;

    private MapCollections<K, V> b() {
        if (this.f44204a == null) {
            this.f44204a = new MapCollections<K, V>() { // from class: skin.support.collection.ArrayMap.1
                @Override // skin.support.collection.MapCollections
                protected int a() {
                    return ArrayMap.this.h;
                }

                @Override // skin.support.collection.MapCollections
                protected int a(Object obj) {
                    return ArrayMap.this.a(obj);
                }

                @Override // skin.support.collection.MapCollections
                protected Object a(int i, int i2) {
                    return ArrayMap.this.g[(i << 1) + i2];
                }

                @Override // skin.support.collection.MapCollections
                protected V a(int i, V v) {
                    return ArrayMap.this.a(i, (int) v);
                }

                @Override // skin.support.collection.MapCollections
                protected void a(int i) {
                    ArrayMap.this.d(i);
                }

                @Override // skin.support.collection.MapCollections
                protected void a(K k, V v) {
                    ArrayMap.this.put(k, v);
                }

                @Override // skin.support.collection.MapCollections
                protected int b(Object obj) {
                    return ArrayMap.this.b(obj);
                }

                @Override // skin.support.collection.MapCollections
                protected Map<K, V> b() {
                    return ArrayMap.this;
                }

                @Override // skin.support.collection.MapCollections
                protected void c() {
                    ArrayMap.this.clear();
                }
            };
        }
        return this.f44204a;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }
}
