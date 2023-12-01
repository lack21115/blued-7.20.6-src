package com.anythink.core.common.e;

import com.anythink.core.api.ATAdInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/ad.class */
public final class ad {
    private com.anythink.core.common.f b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f6621c;
    private d d;
    private Map<String, String> e;
    private boolean f;
    private Map<String, String> h;
    private String g = "";

    /* renamed from: a  reason: collision with root package name */
    final Object f6620a = new Object();

    public final Object a() {
        return this.f6620a;
    }

    public final String a(String str) {
        if (this.e == null) {
            this.e = new ConcurrentHashMap(2);
        }
        return this.e.remove(str);
    }

    public final void a(ATAdInfo aTAdInfo) {
        if (aTAdInfo != null) {
            this.d = new d(aTAdInfo.getAdsourceId(), aTAdInfo.getShowId(), aTAdInfo.getNetworkFirmId());
        } else {
            this.d = null;
        }
    }

    public final void a(com.anythink.core.common.f fVar) {
        this.b = fVar;
    }

    public final void a(String str, Object obj) {
        if (this.f6621c == null) {
            this.f6621c = new ConcurrentHashMap(2);
        }
        this.f6621c.put(str, obj);
    }

    public final void a(String str, String str2) {
        if (this.e == null) {
            this.e = new ConcurrentHashMap(2);
        }
        this.e.put(str, str2);
    }

    public final void a(Map<String, Object> map) {
        this.f6621c = map;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final void a(Object[] objArr) {
        this.g = com.anythink.core.common.k.h.a(objArr);
    }

    public final com.anythink.core.common.f b() {
        return this.b;
    }

    public final String b(String str) {
        Map<String, String> map = this.h;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final void b(String str, String str2) {
        if (this.h == null) {
            this.h = new ConcurrentHashMap(2);
        }
        this.h.put(str, str2);
    }

    public final Map<String, Object> c() {
        return this.f6621c;
    }

    public final d d() {
        return this.d;
    }

    public final boolean e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }
}
