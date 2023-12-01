package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ic;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/s.class */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static volatile s f27544a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f115a;

    private s(Context context) {
        this.f115a = context.getApplicationContext();
    }

    private static s a(Context context) {
        if (f27544a == null) {
            synchronized (s.class) {
                try {
                    if (f27544a == null) {
                        f27544a = new s(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27544a;
    }

    public static void a(Context context, ic icVar) {
        a(context).a(icVar, 0, true);
    }

    public static void a(Context context, ic icVar, boolean z) {
        a(context).a(icVar, 1, z);
    }

    private void a(ic icVar, int i, boolean z) {
        if (com.xiaomi.push.j.m8998a(this.f115a) || !com.xiaomi.push.j.m8997a() || icVar == null || icVar.f659a != hg.SendMessage || icVar.m8895a() == null || !z) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("click to start activity result:" + String.valueOf(i));
        Cif cif = new Cif(icVar.m8895a().m8845a(), false);
        cif.c(hq.SDK_START_ACTIVITY.f536a);
        cif.b(icVar.m8896a());
        cif.d(icVar.f666b);
        cif.f678a = new HashMap();
        cif.f678a.put("result", String.valueOf(i));
        ao.a(this.f115a).a(cif, hg.Notification, false, false, null, true, icVar.f666b, icVar.f662a, true, false);
    }

    public static void b(Context context, ic icVar, boolean z) {
        a(context).a(icVar, 2, z);
    }

    public static void c(Context context, ic icVar, boolean z) {
        a(context).a(icVar, 3, z);
    }

    public static void d(Context context, ic icVar, boolean z) {
        a(context).a(icVar, 4, z);
    }

    public static void e(Context context, ic icVar, boolean z) {
        s a2;
        int i;
        b m8407a = b.m8407a(context);
        if (TextUtils.isEmpty(m8407a.m8415c()) || TextUtils.isEmpty(m8407a.d())) {
            a2 = a(context);
            i = 6;
        } else {
            boolean m8419f = m8407a.m8419f();
            a2 = a(context);
            i = m8419f ? 7 : 5;
        }
        a2.a(icVar, i, z);
    }
}
