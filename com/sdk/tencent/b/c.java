package com.sdk.tencent.b;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/b/c.class */
public class c<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f14329a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f14330c;
    public b<K, Long> d;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f14330c = i;
        this.f14329a = new LinkedHashMap<>(0, 0.75f, true);
        this.d = new b<>(0, 0.75f);
    }

    public final int a(K k, V v) {
        String str = (String) k;
        String str2 = (String) v;
        int length = str2 == null ? 0 : str2.length();
        if (length <= 0) {
            this.b = 0;
            for (Map.Entry<K, V> entry : this.f14329a.entrySet()) {
                int i = this.b;
                K key = entry.getKey();
                V value = entry.getValue();
                String str3 = (String) key;
                String str4 = (String) value;
                this.b = i + (str4 == null ? 0 : str4.length());
            }
        }
        return length;
    }

    public final void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.b <= i || this.f14329a.isEmpty()) {
                    break;
                }
                Map.Entry<K, V> next = this.f14329a.entrySet().iterator().next();
                K key = next.getKey();
                V value = next.getValue();
                this.f14329a.remove(key);
                this.d.a(key);
                this.b -= a(key, value);
            }
        }
    }
}
