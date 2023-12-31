package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/SortedMap.class */
public interface SortedMap<K, V> extends Map<K, V> {
    Comparator<? super K> comparator();

    K firstKey();

    SortedMap<K, V> headMap(K k);

    K lastKey();

    SortedMap<K, V> subMap(K k, K k2);

    SortedMap<K, V> tailMap(K k);
}
