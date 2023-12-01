package com.zx.a.I8b7;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/b1.class */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    public URL f42104a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f42105c;
    public d1 d;
    public String e;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/b1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public URL f42106a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, String> f42107c;
        public d1 d;
        public String e;

        public a() {
            this.b = "GET";
            this.f42107c = new HashMap();
            this.e = "";
        }

        public a(b1 b1Var) {
            this.f42106a = b1Var.f42104a;
            this.b = b1Var.b;
            this.d = b1Var.d;
            this.f42107c = b1Var.f42105c;
            this.e = b1Var.e;
        }

        public a a(String str) {
            if (str != null) {
                try {
                    this.f42106a = new URL(str);
                    return this;
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            throw new NullPointerException("url == null");
        }
    }

    public b1(a aVar) {
        this.f42104a = aVar.f42106a;
        this.b = aVar.b;
        HashMap hashMap = new HashMap();
        this.f42105c = hashMap;
        hashMap.putAll(aVar.f42107c);
        this.d = aVar.d;
        this.e = aVar.e;
    }
}
