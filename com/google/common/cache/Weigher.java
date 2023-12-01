package com.google.common.cache;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/cache/Weigher.class */
public interface Weigher<K, V> {
    int weigh(K k, V v);
}
