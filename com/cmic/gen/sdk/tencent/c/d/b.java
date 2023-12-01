package com.cmic.gen.sdk.tencent.c.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/d/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f8043a;
    private Map<String, List<String>> b;

    /* renamed from: c  reason: collision with root package name */
    private String f8044c;

    public b(int i, Map<String, List<String>> map, String str) {
        this.f8043a = i;
        this.b = map;
        this.f8044c = str;
    }

    public int a() {
        return this.f8043a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.b;
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
        }
        return hashMap;
    }

    public String c() {
        String str = this.f8044c;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public boolean d() {
        int i = this.f8043a;
        return i == 302 || i == 301;
    }
}
