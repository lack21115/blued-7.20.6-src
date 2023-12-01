package com.opos.cmn.i;

import android.util.LruCache;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/c.class */
public class c<K, V> extends LruCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private a f11287a;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/c$a.class */
    public interface a<K, V> {
        void a(K k, V v);
    }

    public c(int i, a<K, V> aVar) {
        super(i);
        this.f11287a = aVar;
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z, K k, V v, V v2) {
        a aVar;
        if (!z || (aVar = this.f11287a) == null) {
            return;
        }
        aVar.a(k, v);
    }
}
