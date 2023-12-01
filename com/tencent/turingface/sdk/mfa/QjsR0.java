package com.tencent.turingface.sdk.mfa;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/QjsR0.class */
public final class QjsR0 extends ucT3w implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f26219a;
    public static Map<Integer, Integer> b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, String> f26220c;
    public static final /* synthetic */ boolean d = !QjsR0.class.desiredAssertionStatus();
    public long e = 0;
    public boolean f = true;
    public long g = 0;
    public Map<String, String> h = null;
    public Map<Integer, Integer> i = null;
    public long j = 0;
    public Map<String, String> k = null;

    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    static {
        HashMap hashMap = new HashMap();
        f26219a = hashMap;
        hashMap.put("", "");
        b = new HashMap();
        b.put(0, 0);
        HashMap hashMap2 = new HashMap();
        f26220c = hashMap2;
        hashMap2.put("", "");
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.e, 0);
        d5hoq.a(this.f ? (byte) 1 : (byte) 0, 1);
        d5hoq.a(this.g, 2);
        d5hoq.a((Map) this.h, 3);
        d5hoq.a((Map) this.i, 4);
        d5hoq.a(this.j, 5);
        Map<String, String> map = this.k;
        if (map != null) {
            d5hoq.a((Map) map, 6);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.e = nyvkz.a(this.e, 0, true);
        this.f = nyvkz.a(this.f, 1, true);
        this.g = nyvkz.a(this.g, 2, true);
        this.h = (Map) nyvkz.a((nyvKz) f26219a, 3, true);
        this.i = (Map) nyvkz.a((nyvKz) b, 4, true);
        this.j = nyvkz.a(this.j, 5, true);
        this.k = (Map) nyvkz.a((nyvKz) f26220c, 6, false);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (d) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        QjsR0 qjsR0 = (QjsR0) obj;
        boolean z = false;
        if (fi6GY.a(this.e, qjsR0.e)) {
            z = false;
            if (this.f == qjsR0.f) {
                z = false;
                if (fi6GY.a(this.g, qjsR0.g)) {
                    z = false;
                    if (this.h.equals(qjsR0.h)) {
                        z = false;
                        if (this.i.equals(qjsR0.i)) {
                            z = false;
                            if (fi6GY.a(this.j, qjsR0.j)) {
                                z = false;
                                if (this.k.equals(qjsR0.k)) {
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public final int hashCode() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
