package com.blued.android.module.common.url;

import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.utils.CommonPreferences;
import java.net.URLEncoder;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/url/BluedHttpUrl.class */
public class BluedHttpUrl {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10844a = "https://m.blued.cn";
    private static String b = "https://argo.blued.cn";

    /* renamed from: c  reason: collision with root package name */
    private static String f10845c = "https://pay.blued.cn";
    private static String d = "https://sdk.blued.cn";
    private static String e = "https://health.blued.cn";
    private static String f = "h4.blued.cn";
    private static int g = 443;
    private static int h = 8080;
    private static String i = "blued.irisdt.cn";
    private static String j = "https://i.blued.cn";
    private static String k = "https://m.blued.cn";
    private static String l = "live-im.blued.cn";
    private static String m = "h8.blued.cn";

    public static String A() {
        return l;
    }

    public static String a() {
        return p() + "/login";
    }

    public static String a(int i2, String str, int i3, int i4) {
        return H5Url.a(39, Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public static String a(String str) {
        return H5Url.a(16, EncryptTool.b(str));
    }

    public static String a(String str, int i2) {
        String str2;
        try {
            str2 = AesCrypto.a(str);
        } catch (Exception e2) {
            str2 = "";
        }
        return H5Url.a(20, Integer.valueOf(i2), str2);
    }

    public static void a(int i2) {
        g = i2;
        x();
    }

    public static String b() {
        return n() + "/forgot/input.html?type=1";
    }

    public static String b(String str) {
        return H5Url.a(17, EncryptTool.b(str));
    }

    public static void b(int i2) {
        h = i2;
        x();
    }

    public static String c() {
        return n() + "/forgot/input.html?type=2";
    }

    public static String c(String str) {
        return H5Url.a(25, EncryptTool.b(str));
    }

    public static String d() {
        return n() + "/forgot/input.html?type=2&safe_email=1";
    }

    public static String d(String str) {
        try {
            return o() + "/blued/medicine/yzshare?youzan=" + URLEncoder.encode(str, "UTF-8");
        } catch (Exception e2) {
            return str;
        }
    }

    public static String e() {
        return k + "/msg/del_groupblocked.html";
    }

    public static void e(String str) {
        k = str;
        x();
    }

    public static String f() {
        return "https://m.blued.cn/security.html";
    }

    public static void f(String str) {
        e = str;
        x();
    }

    public static String g() {
        return "http://native.blued.cn?action=vip_center_local&tab=0&detail=mine_vip_center";
    }

    public static void g(String str) {
        j = str;
        x();
    }

    public static void h(String str) {
        b = str;
        x();
    }

    public static boolean h() {
        return b.equals("https://argo.blued.cn") || b.equals("https://pre-argo.blued.cn");
    }

    public static int i() {
        if (b.equals("https://argo.blued.cn")) {
            return 0;
        }
        if (b.equals("http://dev-argo.blued.cn")) {
            return 1;
        }
        return b.equals("https://pre-argo.blued.cn") ? 2 : 0;
    }

    public static void i(String str) {
        f10845c = str;
        x();
    }

    public static int j() {
        if (b.equals("http://dev-argo.blued.cn")) {
            return 1;
        }
        return b.equals("https://pre-argo.blued.cn") ? 2 : 0;
    }

    public static void j(String str) {
        d = str;
        x();
    }

    public static void k() {
        h("http://dev-argo.blued.cn");
        i("https://pay-test.blued.cn");
        j("https://sdk-test.blued.cn");
        k("140.143.221.114");
        a(8080);
        b(8080);
        f("https://healthtest.blued.cn");
        l("blued-test.irisdt.cn");
        g("http://test.i.blued.cn");
        e("http://m-test.blued.cn");
        m("live-im-test.blued.cn");
        n("im-test.irisgw.cn");
    }

    public static void k(String str) {
        f = str;
        x();
    }

    public static void l() {
        h("https://argo.blued.cn");
        i("https://pay.blued.cn");
        j("https://sdk.blued.cn");
        k("h4.blued.cn");
        a(443);
        b(8080);
        f("https://health.blued.cn");
        l("blued.irisdt.cn");
        g("https://i.blued.cn");
        e(f10844a);
        m("live-im.blued.cn");
        n("h8.blued.cn");
    }

    public static void l(String str) {
        i = str;
        x();
    }

    public static void m() {
        h("https://pre-argo.blued.cn");
        i("https://pre-pay.blued.cn");
        j("https://sdk.blued.cn");
        k("h4.blued.cn");
        a(443);
        b(8080);
        f("https://health.blued.cn");
        l("blued.irisdt.cn");
        g("https://i.blued.cn");
        e(f10844a);
        m("pre-live-im.blued.cn");
        n("h8.blued.cn");
    }

    public static void m(String str) {
        l = str;
        x();
    }

    public static String n() {
        return k;
    }

    public static void n(String str) {
        m = str;
        x();
    }

    public static String o() {
        return e;
    }

    public static String p() {
        return j;
    }

    public static String q() {
        return b;
    }

    public static String r() {
        return f10845c;
    }

    public static String s() {
        return d;
    }

    public static String t() {
        return f;
    }

    public static int u() {
        return g;
    }

    public static int v() {
        return h;
    }

    public static String w() {
        return i;
    }

    public static void x() {
        CommonPreferences.b(b);
        CommonPreferences.d(f10845c);
        CommonPreferences.f(d);
        CommonPreferences.h(f);
        CommonPreferences.b(g);
        CommonPreferences.d(h);
        CommonPreferences.j(e);
        CommonPreferences.l(i);
        CommonPreferences.n(j);
        CommonPreferences.p(k);
        CommonPreferences.r(l);
        CommonPreferences.t(m);
    }

    public static void y() {
        b = CommonPreferences.a(b);
        f10845c = CommonPreferences.c(f10845c);
        d = CommonPreferences.e(d);
        f = CommonPreferences.g(f);
        g = CommonPreferences.a(g);
        h = CommonPreferences.c(h);
        e = CommonPreferences.i(e);
        i = CommonPreferences.k(i);
        j = CommonPreferences.m(j);
        k = CommonPreferences.o(k);
        l = CommonPreferences.q(l);
        m = CommonPreferences.s(m);
    }

    public static String z() {
        return m;
    }
}
