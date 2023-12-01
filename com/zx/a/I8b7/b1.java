package com.zx.a.I8b7;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/b1.class */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    public URL f28413a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f28414c;
    public d1 d;
    public String e;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/b1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public URL f28415a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f28416c;
        public d1 d;
        public String e;

        public a() {
            this.b = "GET";
            this.f28416c = new HashMap();
            this.e = "";
        }

        public a(b1 b1Var) {
            this.f28415a = b1Var.f28413a;
            this.b = b1Var.b;
            this.d = b1Var.d;
            this.f28416c = b1Var.f28414c;
            this.e = b1Var.e;
        }

        public a a(String str) {
            if (str != null) {
                try {
                    this.f28415a = new URL(str);
                    return this;
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            throw new NullPointerException("url == null");
        }
    }

    public b1(a aVar) {
        this.f28413a = aVar.f28415a;
        this.b = aVar.b;
        HashMap hashMap = new HashMap();
        this.f28414c = hashMap;
        hashMap.putAll(aVar.f28416c);
        this.d = aVar.d;
        this.e = aVar.e;
    }
}
