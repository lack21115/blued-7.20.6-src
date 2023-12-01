package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/SortedIterable.class */
interface SortedIterable<T> extends Iterable<T> {
    Comparator<? super T> comparator();

    @Override // java.lang.Iterable
    Iterator<T> iterator();
}
