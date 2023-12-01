package com.tencent.turingface.sdk.mfa;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/fa2Ik.class */
public final class fa2Ik extends ucT3w {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Integer, byte[]> f39950a = new HashMap();
    public static ShGzN b;

    /* renamed from: c  reason: collision with root package name */
    public static DX7Nf f39951c;
    public static y8N3A d;
    public static Map<Integer, String> e;
    public static Map<Integer, String> f;
    public long g = 0;
    public Map<Integer, byte[]> h = null;
    public int i = 0;
    public ShGzN j = null;
    public DX7Nf k = null;
    public y8N3A l = null;
    public Map<Integer, String> m = null;
    public Map<Integer, String> n = null;

    static {
        f39950a.put(0, new byte[]{0});
        b = new ShGzN();
        f39951c = new DX7Nf();
        d = new y8N3A();
        e = new HashMap();
        e.put(0, "");
        f = new HashMap();
        f.put(0, "");
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.g, 0);
        d5hoq.a((Map) this.h, 1);
        d5hoq.a(this.i, 2);
        d5hoq.a((ucT3w) this.j, 3);
        d5hoq.a((ucT3w) this.k, 4);
        y8N3A y8n3a = this.l;
        if (y8n3a != null) {
            d5hoq.a((ucT3w) y8n3a, 5);
        }
        Map<Integer, String> map = this.m;
        if (map != null) {
            d5hoq.a((Map) map, 6);
        }
        Map<Integer, String> map2 = this.n;
        if (map2 != null) {
            d5hoq.a((Map) map2, 7);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.g = nyvkz.a(this.g, 0, true);
        this.h = (Map) nyvkz.a((nyvKz) f39950a, 1, true);
        this.i = nyvkz.a(this.i, 2, true);
        this.j = (ShGzN) nyvkz.a((ucT3w) b, 3, true);
        this.k = (DX7Nf) nyvkz.a((ucT3w) f39951c, 4, true);
        this.l = (y8N3A) nyvkz.a((ucT3w) d, 5, false);
        this.m = (Map) nyvkz.a((nyvKz) e, 6, false);
        this.n = (Map) nyvkz.a((nyvKz) f, 7, false);
    }
}
