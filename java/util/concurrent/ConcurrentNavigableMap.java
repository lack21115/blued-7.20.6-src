package java.util.concurrent;

import java.util.NavigableMap;
import java.util.NavigableSet;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentNavigableMap.class */
public interface ConcurrentNavigableMap<K, V> extends ConcurrentMap<K, V>, NavigableMap<K, V> {
    @Override // java.util.NavigableMap
    NavigableSet<K> descendingKeySet();

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> descendingMap();

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> headMap(K k);

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> headMap(K k, boolean z);

    @Override // java.util.Map
    NavigableSet<K> keySet();

    @Override // java.util.NavigableMap
    NavigableSet<K> navigableKeySet();

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> subMap(K k, K k2);

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2);

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> tailMap(K k);

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> tailMap(K k, boolean z);
}
