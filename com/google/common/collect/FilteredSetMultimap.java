package com.google.common.collect;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/FilteredSetMultimap.class */
interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {
    @Override // com.google.common.collect.FilteredMultimap
    SetMultimap<K, V> unfiltered();
}
