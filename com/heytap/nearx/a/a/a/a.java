package com.heytap.nearx.a.a.a;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/a/a.class */
public final class a<T> extends AbstractList<T> implements Serializable, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<T> f22255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<T> list) {
        this.f22255a = new ArrayList<>(list);
    }

    private Object writeReplace() throws ObjectStreamException {
        return Collections.unmodifiableList(this.f22255a);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f22255a.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f22255a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return this.f22255a.toArray();
    }
}
