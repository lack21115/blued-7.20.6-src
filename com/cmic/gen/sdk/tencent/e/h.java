package com.cmic.gen.sdk.tencent.e;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.gen.sdk.tencent.e.k;
import com.cmic.gen.sdk.tencent.e.n;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f21661a;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static long f21662c;

    private static int a(String str) {
        String b2;
        if (TextUtils.isEmpty(b)) {
            b2 = k.b("pre_sim_key", "");
            b = b2;
        } else {
            b2 = b;
        }
        if (TextUtils.isEmpty(b2)) {
            return 0;
        }
        return b2.equals(str) ? 1 : 2;
    }

    public static long a() {
        long a2;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(f21661a)) {
            String b2 = k.b("phonescripcache", "");
            a2 = k.a("phonescripstarttime", 0L);
            if (TextUtils.isEmpty(b2)) {
                j = 0;
                return Math.max(j / 1000, 0L);
            }
        } else {
            c.b("PhoneScripUtils", b + " " + f21662c);
            a2 = f21662c;
        }
        j = (a2 - currentTimeMillis) - 10000;
        return Math.max(j / 1000, 0L);
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f21661a)) {
            String b2 = k.b("phonescripcache", "");
            if (TextUtils.isEmpty(b2)) {
                c.a("PhoneScripUtils", com.igexin.push.core.b.l);
                return null;
            }
            f21662c = k.a("phonescripstarttime", 0L);
            b = k.b("pre_sim_key", "");
            String b3 = b.b(context, b2);
            f21661a = b3;
            return b3;
        }
        return f21661a;
    }

    public static void a(final Context context, final String str, long j, final String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j <= 0) {
            return;
        }
        c.b("PhoneScripUtils", "save phone scrip simKey = " + str2);
        f21661a = str;
        long j2 = j * 1000;
        f21662c = System.currentTimeMillis() + j2;
        c.b("sLifeTime", f21662c + "");
        b = str2;
        if (!"operator".equals(str3)) {
            n.a(new n.a() { // from class: com.cmic.gen.sdk.tencent.e.h.1
                @Override // com.cmic.gen.sdk.tencent.e.n.a
                protected void a() {
                    c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                    h.b(Context.this, str, h.f21662c, str2);
                }
            });
        } else if (j2 > 3600000) {
            f21662c = System.currentTimeMillis() + 3600000;
        } else {
            f21662c = System.currentTimeMillis() + j2;
        }
    }

    public static void a(boolean z, boolean z2) {
        k.a a2 = k.a();
        a2.a("phonescripstarttime");
        a2.a("phonescripcache");
        a2.a("pre_sim_key");
        if (z2) {
            a2.a();
        } else {
            a2.b();
        }
        if (z) {
            f21661a = null;
            b = null;
            f21662c = 0L;
        }
    }

    private static boolean a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        c.b("PhoneScripUtils", j + "");
        c.b("PhoneScripUtils", currentTimeMillis + "");
        return j - currentTimeMillis > 10000;
    }

    public static boolean a(com.cmic.gen.sdk.tencent.a aVar) {
        int a2 = a(aVar.b("scripKey"));
        aVar.a("imsiState", a2 + "");
        c.b("PhoneScripUtils", "simState = " + a2);
        if (k.a("phonescripversion", 0) != 1 && a2 != 0) {
            a(true, false);
            b.a();
            c.b("PhoneScripUtils", "phoneScriptVersion change");
            return false;
        } else if (a2 != 1) {
            if (a2 == 2) {
                a(true, false);
                return false;
            }
            return false;
        } else {
            return c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, long j, String str2) {
        String a2 = b.a(context, str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        k.a a3 = k.a();
        a3.a("phonescripcache", a2);
        a3.a("phonescripstarttime", j);
        a3.a("phonescripversion", 1);
        a3.a("pre_sim_key", str2);
        a3.b();
    }

    private static boolean c() {
        if (TextUtils.isEmpty(f21661a)) {
            return !TextUtils.isEmpty(k.b("phonescripcache", "")) && a(k.a("phonescripstarttime", 0L));
        }
        c.b("PhoneScripUtils", b + " " + f21662c);
        return a(f21662c);
    }
}
