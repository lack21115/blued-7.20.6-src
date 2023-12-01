package com.tencent.thumbplayer.utils;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/g.class */
public class g<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private Map<K, V> f39432a = new HashMap();

    public g<K, V> a(K k, V v) {
        this.f39432a.put(k, v);
        return this;
    }

    public Map<K, V> a() {
        return this.f39432a;
    }
}
