package com.google.common.cache;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/cache/RemovalListener.class */
public interface RemovalListener<K, V> {
    void onRemoval(RemovalNotification<K, V> removalNotification);
}
