package com.tramini.plugin.a;

import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f26784a;

    private a() {
    }

    public static a a() {
        if (f26784a == null) {
            synchronized (a.class) {
                try {
                    if (f26784a == null) {
                        f26784a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f26784a;
    }

    private static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static String b() {
        com.tramini.plugin.b.a b = com.tramini.plugin.b.b.b(com.tramini.plugin.a.a.c.a().b());
        return b != null ? a(b.p(), "https://aa.birdgesdk.com/v1/d_api") : "https://aa.birdgesdk.com/v1/d_api";
    }

    public static String c() {
        com.tramini.plugin.b.a b = com.tramini.plugin.b.b.b(com.tramini.plugin.a.a.c.a().b());
        return b != null ? a(b.q(), "https://pitk.birdgesdk.com/v1/ptk") : "https://pitk.birdgesdk.com/v1/ptk";
    }
}
