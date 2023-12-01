package java.util.concurrent;

import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentMap.class */
public interface ConcurrentMap<K, V> extends Map<K, V> {
    V putIfAbsent(K k, V v);

    boolean remove(Object obj, Object obj2);

    V replace(K k, V v);

    boolean replace(K k, V v, V v2);
}
