package com.heytap.nearx.a.a.a;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/a/c.class */
final class c<T> extends AbstractList<T> implements Serializable, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    List<T> f8648a;
    private final List<T> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<T> list) {
        this.b = list;
        this.f8648a = list;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.f8648a);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        if (this.f8648a == this.b) {
            this.f8648a = new ArrayList(this.b);
        }
        this.f8648a.add(i, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f8648a.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i) {
        if (this.f8648a == this.b) {
            this.f8648a = new ArrayList(this.b);
        }
        return this.f8648a.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        if (this.f8648a == this.b) {
            this.f8648a = new ArrayList(this.b);
        }
        return this.f8648a.set(i, t);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f8648a.size();
    }
}
