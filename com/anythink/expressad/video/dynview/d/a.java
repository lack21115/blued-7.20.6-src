package com.anythink.expressad.video.dynview.d;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/d/a.class */
public final class a<K, V> extends HashMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private ReferenceQueue<V> f8360a = new ReferenceQueue<>();
    private HashMap<K, a<K, V>.C0160a<K, V>> b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.dynview.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/d/a$a.class */
    public final class C0160a<K, V> extends SoftReference<V> {

        /* renamed from: a  reason: collision with root package name */
        K f8361a;

        public C0160a(K k, V v, ReferenceQueue referenceQueue) {
            super(v, referenceQueue);
            this.f8361a = k;
        }
    }

    private void a() {
        while (true) {
            C0160a c0160a = (C0160a) this.f8360a.poll();
            if (c0160a == null) {
                return;
            }
            this.b.remove(c0160a.f8361a);
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        a();
        return this.b.containsKey(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        a();
        a<K, V>.C0160a<K, V> c0160a = this.b.get(obj);
        if (c0160a == null) {
            return null;
        }
        return c0160a.get();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        a();
        a<K, V>.C0160a<K, V> put = this.b.put(k, new C0160a<>(k, v, this.f8360a));
        if (put == null) {
            return null;
        }
        return put.get();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        a();
        a<K, V>.C0160a<K, V> remove = this.b.remove(obj);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final int size() {
        a();
        return this.b.size();
    }
}
