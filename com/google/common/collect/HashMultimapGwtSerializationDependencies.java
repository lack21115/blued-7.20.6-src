package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/HashMultimapGwtSerializationDependencies.class */
abstract class HashMultimapGwtSerializationDependencies<K, V> extends AbstractSetMultimap<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMultimapGwtSerializationDependencies(Map<K, Collection<V>> map) {
        super(map);
    }
}
