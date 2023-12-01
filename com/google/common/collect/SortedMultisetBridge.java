package com.google.common.collect;

import java.util.SortedSet;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/SortedMultisetBridge.class */
interface SortedMultisetBridge<E> extends Multiset<E> {
    @Override // com.google.common.collect.Multiset
    SortedSet<E> elementSet();
}
