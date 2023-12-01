package com.amap.api.col.p0003sl;

import javax.xml.transform.OutputKeys;

@jb(a = "update_item")
/* renamed from: com.amap.api.col.3sl.bk  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bk.class */
public class bk {
    @jc(a = "localPath", b = 6)
    protected String h;
    @jc(a = "mCompleteCode", b = 2)
    protected int j;
    @jc(a = "mState", b = 2)
    public int l;
    @jc(a = "title", b = 6)
    protected String a = null;
    @jc(a = "url", b = 6)
    protected String b = null;
    @jc(a = "mAdcode", b = 6)
    protected String c = null;
    @jc(a = "fileName", b = 6)
    protected String d = null;
    @jc(a = OutputKeys.VERSION, b = 6)
    protected String e = "";
    @jc(a = "lLocalLength", b = 5)
    protected long f = 0;
    @jc(a = "lRemoteLength", b = 5)
    protected long g = 0;
    @jc(a = "isProvince", b = 2)
    protected int i = 0;
    @jc(a = "mCityCode", b = 6)
    protected String k = "";
    @jc(a = "mPinyin", b = 6)
    public String m = "";

    public static String e(String str) {
        return "mAdcode='" + str + "'";
    }

    public static String f(String str) {
        return "mPinyin='" + str + "'";
    }

    public final String c() {
        return this.a;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final String d() {
        return this.e;
    }

    public final void d(String str) {
        this.k = str;
    }

    public final String e() {
        return this.c;
    }

    public final String f() {
        return this.b;
    }

    public final int g() {
        return this.j;
    }

    public final String h() {
        return this.m;
    }
}
