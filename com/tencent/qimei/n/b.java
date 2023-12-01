package com.tencent.qimei.n;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/n/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24664a = "b";

    public static void a(String str, String str2, String str3, String str4, String str5) {
        c a2 = i.a().a(e.REPORT_JS_VERSION.K, str2).a(e.REPORT_JS_BROWSER_TYPE.K, str3).a(e.REPORT_JS_H5ID.K, str4).a(e.REPORT_JS_UA.K, str5);
        a2.f24665a = str;
        a2.f24666c = "/bind";
        a2.a("j1");
        com.tencent.qimei.k.a.b(f24664a, "H5ID has been reported over,h5id = %s", str4);
    }
}
