package com.squareup.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/MutableOnWriteList.class */
public final class MutableOnWriteList<T> extends AbstractMutableList<T> implements Serializable, RandomAccess {
    private final List<T> immutableList;
    private List<? extends T> mutableList;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableOnWriteList(List<? extends T> immutableList) {
        Intrinsics.e(immutableList, "immutableList");
        this.immutableList = immutableList;
        this.mutableList = immutableList;
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.mutableList);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        ((ArrayList) this.mutableList).add(i, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.mutableList.get(i);
    }

    public final List<T> getMutableList$wire_runtime() {
        return (List<? extends T>) this.mutableList;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.mutableList.size();
    }

    @Override // kotlin.collections.AbstractMutableList
    public T removeAt(int i) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        return (T) ((ArrayList) this.mutableList).remove(i);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        return (T) ((ArrayList) this.mutableList).set(i, t);
    }

    public final void setMutableList$wire_runtime(List<? extends T> list) {
        Intrinsics.e(list, "<set-?>");
        this.mutableList = list;
    }
}
