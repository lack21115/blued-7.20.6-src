package com.tencent.bugly.idasc.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/br.class */
public final class br extends m {
    static byte[] i;
    static Map<String, String> j;

    /* renamed from: a  reason: collision with root package name */
    public byte f35308a = 0;
    public int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f35309c = null;
    public String d = "";
    public long e = 0;
    public String f = "";
    public String g = "";
    public Map<String, String> h = null;

    static {
        i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f35308a = kVar.a(this.f35308a, 0, true);
        this.b = kVar.a(this.b, 1, true);
        this.f35309c = kVar.c(2, false);
        this.d = kVar.b(3, false);
        this.e = kVar.a(this.e, 4, false);
        this.f = kVar.b(5, false);
        this.g = kVar.b(6, false);
        this.h = (Map) kVar.a((k) j, 7, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f35308a, 0);
        lVar.a(this.b, 1);
        byte[] bArr = this.f35309c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
        String str = this.d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.e, 4);
        String str2 = this.f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        String str3 = this.g;
        if (str3 != null) {
            lVar.a(str3, 6);
        }
        Map<String, String> map = this.h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }
}
