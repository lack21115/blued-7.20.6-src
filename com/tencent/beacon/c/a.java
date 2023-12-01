package com.tencent.beacon.c;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.beacon.a.b.g;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.base.util.c;
import com.tencent.qmsp.sdk.u.U;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f21310a = false;
    private static String b = "load_so";

    /* renamed from: c  reason: collision with root package name */
    private static String f21311c = "load_so_version";
    private static String d = "beacon_so_beacon";

    private static int a(Context context) {
        return b(context).getInt(b, 0);
    }

    public static String a(Context context, int i, Activity activity, String str, int i2) {
        int a2;
        String a3;
        synchronized (a.class) {
            try {
                String a4 = b.a();
                if (c(context).equals(a4)) {
                    a2 = a(context);
                } else {
                    c.d("[audit] app update", new Object[0]);
                    a(context, a4);
                    a(context, 0);
                    a2 = 0;
                }
                c.a("[audit] last load so occur fetal error cnt: %s", Integer.valueOf(a2));
                if (a2 >= i2) {
                    g.e().a("502", "[audit] load so error count over max!");
                    c.b("[audit] !!!!!!!!!!LOADERROR!!!!!!!!!! ", new Object[0]);
                    a3 = "LOADERROR";
                } else {
                    try {
                        if (!f21310a) {
                            a(context, a2 + 1);
                            c.d("[audit] load libBeacon.so success", new Object[0]);
                            f21310a = true;
                        }
                        a3 = U.a(context, i, activity, str);
                    } catch (UnsatisfiedLinkError e) {
                        f21310a = true;
                        a3 = U.a(context, i, activity, str);
                    }
                    a(context, 0);
                }
                if (a3 == null || a3.isEmpty()) {
                    g.e().a("501", "[audit] audit run fail! result is empty!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a3;
    }

    private static void a(Context context, int i) {
        SharedPreferences.Editor edit = b(context).edit();
        if (com.tencent.beacon.base.util.b.a(edit)) {
            edit.putInt(b, i).apply();
        }
    }

    private static void a(Context context, String str) {
        SharedPreferences.Editor edit = b(context).edit();
        if (com.tencent.beacon.base.util.b.a(edit)) {
            edit.putString(f21311c, str).apply();
        }
    }

    private static void a(Context context, Throwable th) {
        c.b("[audit] libBeacon.so load failed!", new Object[0]);
        c.a(th);
        g.e().a("501", "[audit] libBeacon.so load failed!", th);
    }

    private static SharedPreferences b(Context context) {
        return context.getSharedPreferences(d, 0);
    }

    private static String c(Context context) {
        return b(context).getString(f21311c, "");
    }
}
