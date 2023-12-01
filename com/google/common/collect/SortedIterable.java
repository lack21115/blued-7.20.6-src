package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/SortedIterable.class */
interface SortedIterable<T> extends Iterable<T> {
    Comparator<? super T> comparator();

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set, com.google.common.collect.SortedIterable, java.util.NavigableSet
    Iterator<T> iterator();
}
