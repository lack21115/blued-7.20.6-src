package com.alipay.security.mobile.module.http.model;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/http/model/c.class */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final int f4719c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final String f = "APPKEY_ERROR";
    public static final String g = "SUCCESS";
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p = "";

    public int a() {
        return this.f4718a ? com.alipay.security.mobile.module.a.a.a(this.h) ? 2 : 1 : f.equals(this.b) ? 3 : 2;
    }

    public boolean b() {
        return "1".equals(this.j);
    }

    public String c() {
        String str = this.k;
        String str2 = str;
        if (str == null) {
            str2 = "0";
        }
        return str2;
    }
}
