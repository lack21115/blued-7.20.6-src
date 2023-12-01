package com.huawei.hms.hatool;

import android.content.Context;
import com.heytap.mcssdk.constant.IntentConstant;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/i1.class */
public final class i1 {
    public static i1 b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f9142c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Context f9143a;

    public static i1 a() {
        if (b == null) {
            b();
        }
        return b;
    }

    public static void b() {
        synchronized (i1.class) {
            try {
                if (b == null) {
                    b = new i1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Context context) {
        synchronized (f9142c) {
            if (this.f9143a != null) {
                z.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f9143a = context;
            i.c().b().a(this.f9143a);
            i.c().b().j(context.getPackageName());
            a1.a().a(context);
        }
    }

    public void a(String str) {
        z.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f9143a;
        if (context == null) {
            z.e("hmsSdk", "sdk is not init");
            return;
        }
        i.c().b().i(t0.a(IntentConstant.APP_ID, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
    }
}
