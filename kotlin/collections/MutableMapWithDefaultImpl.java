package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/MutableMapWithDefaultImpl.class */
final class MutableMapWithDefaultImpl<K, V> implements MutableMapWithDefault<K, V> {
    private final Map<K, V> a;

    public Map<K, V> a() {
        return this.a;
    }

    public int b() {
        return a().size();
    }

    public Set<K> c() {
        return a().keySet();
    }

    @Override // java.util.Map
    public void clear() {
        a().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return a().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return a().containsValue(obj);
    }

    public Collection<V> d() {
        return a().values();
    }

    public Set<Map.Entry<K, V>> e() {
        return a().entrySet();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return e();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return a().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return a().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return a().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return c();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        return a().put(k, v);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.e(from, "from");
        a().putAll(from);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return a().remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return b();
    }

    public String toString() {
        return a().toString();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return d();
    }
}
