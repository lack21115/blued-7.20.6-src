package com.blued.android.framework.view.stickylistheaders;

import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/DualHashMap.class */
class DualHashMap<TKey, TValue> {
    HashMap<TKey, TValue> a = new HashMap<>();
    HashMap<TValue, TKey> b = new HashMap<>();

    public TKey a(TValue tvalue) {
        return this.b.get(tvalue);
    }

    public void a(TKey tkey, TValue tvalue) {
        c(tkey);
        d(tvalue);
        this.a.put(tkey, tvalue);
        this.b.put(tvalue, tkey);
    }

    public TValue b(TKey tkey) {
        return this.a.get(tkey);
    }

    public void c(TKey tkey) {
        if (b(tkey) != null) {
            this.b.remove(b(tkey));
        }
        this.a.remove(tkey);
    }

    public void d(TValue tvalue) {
        if (a(tvalue) != null) {
            this.a.remove(a(tvalue));
        }
        this.b.remove(tvalue);
    }
}
