package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/aq.class */
public final class aq extends k {
    private static Map<String, String> i;

    /* renamed from: a  reason: collision with root package name */
    public long f21687a = 0;
    public byte b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f21688c = "";
    public String d = "";
    public String e = "";
    public Map<String, String> f = null;
    private String h = "";
    public boolean g = true;

    static {
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f21687a = iVar.a(this.f21687a, 0, true);
        this.b = iVar.a(this.b, 1, true);
        this.f21688c = iVar.b(2, false);
        this.d = iVar.b(3, false);
        this.e = iVar.b(4, false);
        this.f = (Map) iVar.a((i) i, 5, false);
        this.h = iVar.b(6, false);
        this.g = iVar.a(7, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f21687a, 0);
        jVar.a(this.b, 1);
        String str = this.f21688c;
        if (str != null) {
            jVar.a(str, 2);
        }
        String str2 = this.d;
        if (str2 != null) {
            jVar.a(str2, 3);
        }
        String str3 = this.e;
        if (str3 != null) {
            jVar.a(str3, 4);
        }
        Map<String, String> map = this.f;
        if (map != null) {
            jVar.a((Map) map, 5);
        }
        String str4 = this.h;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        jVar.a(this.g, 7);
    }
}
