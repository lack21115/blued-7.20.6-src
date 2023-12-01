package com.blued.android.framework.view.stickylistheaders;

import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/DualHashMap.class */
class DualHashMap<TKey, TValue> {

    /* renamed from: a  reason: collision with root package name */
    HashMap<TKey, TValue> f10332a = new HashMap<>();
    HashMap<TValue, TKey> b = new HashMap<>();

    public TKey a(TValue tvalue) {
        return this.b.get(tvalue);
    }

    public void a(TKey tkey, TValue tvalue) {
        c(tkey);
        d(tvalue);
        this.f10332a.put(tkey, tvalue);
        this.b.put(tvalue, tkey);
    }

    public TValue b(TKey tkey) {
        return this.f10332a.get(tkey);
    }

    public void c(TKey tkey) {
        if (b(tkey) != null) {
            this.b.remove(b(tkey));
        }
        this.f10332a.remove(tkey);
    }

    public void d(TValue tvalue) {
        if (a(tvalue) != null) {
            this.f10332a.remove(a(tvalue));
        }
        this.b.remove(tvalue);
    }
}
