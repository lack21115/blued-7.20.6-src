package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ForwardingSortedMap.class */
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ForwardingSortedMap$StandardKeySet.class */
    public class StandardKeySet extends Maps.SortedKeySet<K, V> {
        public StandardKeySet() {
            super(ForwardingSortedMap.this);
        }
    }

    private int unsafeCompare(Object obj, Object obj2) {
        Comparator<? super K> comparator = comparator();
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K k) {
        return delegate().headMap(k);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap
    protected boolean standardContainsKey(@NullableDecl Object obj) {
        boolean z = false;
        try {
            if (unsafeCompare(tailMap(obj).firstKey(), obj) == 0) {
                z = true;
            }
            return z;
        } catch (ClassCastException | NullPointerException | NoSuchElementException e) {
            return false;
        }
    }

    protected SortedMap<K, V> standardSubMap(K k, K k2) {
        Preconditions.checkArgument(unsafeCompare(k, k2) <= 0, "fromKey must be <= toKey");
        return tailMap(k).headMap(k2);
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return delegate().subMap(k, k2);
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K k) {
        return delegate().tailMap(k);
    }
}
