package com.opos.cmn.biz.monitor.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f24646a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f24647c;
    private byte[] d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/b/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f24648a;
        private String b = "GET";

        /* renamed from: c  reason: collision with root package name */
        private Map<String, String> f24649c = new HashMap();
        private byte[] d = null;

        public a(String str) {
            this.f24648a = str;
        }

        public a a(Map<String, String> map) {
            this.f24649c = map;
            return this;
        }

        public b a() {
            return new b(this.f24648a, this.b, this.f24649c, this.d);
        }
    }

    private b(String str, String str2, Map<String, String> map, byte[] bArr) {
        this.f24646a = str;
        this.b = str2;
        this.f24647c = map;
        this.d = bArr;
    }

    public String a() {
        return this.f24646a;
    }

    public String b() {
        return this.b;
    }

    public Map<String, String> c() {
        return this.f24647c;
    }

    public byte[] d() {
        return this.d;
    }
}
