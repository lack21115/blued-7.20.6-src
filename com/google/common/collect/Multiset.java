package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/Multiset.class */
public interface Multiset<E> extends Collection<E> {

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/Multiset$Entry.class */
    public interface Entry<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    int add(@NullableDecl E e, int i);

    @Override // java.util.Collection, java.util.Set
    boolean add(E e);

    @Override // java.util.Collection, java.util.Set
    boolean contains(@NullableDecl Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean containsAll(Collection<?> collection);

    int count(@NullableDecl Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    @Override // java.util.Collection, java.util.Set
    boolean equals(@NullableDecl Object obj);

    @Override // java.util.Collection, java.util.Set
    int hashCode();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    int remove(@NullableDecl Object obj, int i);

    @Override // java.util.Collection, java.util.Set
    boolean remove(@NullableDecl Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection, java.util.Set
    boolean retainAll(Collection<?> collection);

    int setCount(E e, int i);

    boolean setCount(E e, int i, int i2);

    @Override // java.util.Collection, java.util.List
    int size();

    String toString();
}
