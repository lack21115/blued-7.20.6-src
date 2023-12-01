package com.anythink.expressad.foundation.g.a;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/a/a.class */
public abstract class a<K, V> implements e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f7826a = "cache";
    private final Map<K, Reference<V>> b = Collections.synchronizedMap(new HashMap());

    @Override // com.anythink.expressad.foundation.g.a.e
    public final Collection<K> a() {
        HashSet hashSet;
        synchronized (this.b) {
            hashSet = new HashSet(this.b.keySet());
        }
        return hashSet;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public void a(K k) {
        this.b.remove(k);
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public boolean a(K k, V v) {
        this.b.put(k, c(v));
        return true;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final V b(K k) {
        Reference<V> reference = this.b.get(k);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public void b() {
        this.b.clear();
    }

    protected abstract Reference<V> c(V v);
}
