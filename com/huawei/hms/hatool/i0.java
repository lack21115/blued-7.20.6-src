package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/i0.class */
public class i0 {
    public static i0 b;

    /* renamed from: a  reason: collision with root package name */
    public Context f22749a;

    static {
        new HashMap();
    }

    public static i0 a() {
        return b();
    }

    public static i0 b() {
        i0 i0Var;
        synchronized (i0.class) {
            try {
                if (b == null) {
                    b = new i0();
                }
                i0Var = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i0Var;
    }

    public void a(Context context) {
        this.f22749a = context;
        b(context);
        i.c().b().h(f.a());
    }

    public void a(String str, int i) {
        if (this.f22749a == null) {
            z.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        z.c("hmsSdk", "onReport: Before calling runtaskhandler()");
        a(str, v0.a(i), b.g());
    }

    public void a(String str, int i, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis;
        if (2 == i) {
            j = v0.a("yyyy-MM-dd", currentTimeMillis);
        }
        p0.c().a(new k0(str2, jSONObject, str, v0.a(i), j));
    }

    public void a(String str, int i, String str2, JSONObject jSONObject, long j) {
        new x(str, v0.a(i), str2, jSONObject.toString(), j).a();
    }

    public void a(String str, String str2) {
        if (!c.a(str, str2)) {
            z.c("hmsSdk", "auto report is closed tag:" + str);
            return;
        }
        long j = c.j(str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j <= 30000) {
            z.f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        z.a("hmsSdk", "begin to call onReport!");
        c.a(str, str2, currentTimeMillis);
        a(str, str2, b.g());
    }

    public void a(String str, String str2, String str3) {
        Context context = this.f22749a;
        if (context == null) {
            z.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String a2 = h.a(context);
        if (c.e(str, str2) && !"WIFI".equals(a2)) {
            z.c("hmsSdk", "strNetworkType is :" + a2);
        } else if (TextUtils.isEmpty(a2) || "2G".equals(a2)) {
            z.e("hmsSdk", "The network is bad.");
        } else {
            p0.c().a(new l0(str, str2, str3));
        }
    }

    public final void b(Context context) {
        String str;
        String d = f.d(context);
        b.a(d);
        if (x0.b().a()) {
            String a2 = h0.a(context, "global_v2", "app_ver", "");
            h0.b(context, "global_v2", "app_ver", d);
            b.b(a2);
            if (!TextUtils.isEmpty(a2)) {
                if (a2.equals(d)) {
                    return;
                }
                z.c("hmsSdk", "the appVers are different!");
                a().a("", "alltype", a2);
                return;
            }
            str = "app ver is first save!";
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        z.c("hmsSdk", str);
    }
}
