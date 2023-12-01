package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/Dictionary.class */
public abstract class Dictionary<K, V> {
    public abstract Enumeration<V> elements();

    public abstract V get(Object obj);

    public abstract boolean isEmpty();

    public abstract Enumeration<K> keys();

    public abstract V put(K k, V v);

    public abstract V remove(Object obj);

    public abstract int size();
}
