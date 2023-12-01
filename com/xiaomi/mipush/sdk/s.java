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
    private static volatile s f41235a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f162a;

    private s(Context context) {
        this.f162a = context.getApplicationContext();
    }

    private static s a(Context context) {
        if (f41235a == null) {
            synchronized (s.class) {
                try {
                    if (f41235a == null) {
                        f41235a = new s(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41235a;
    }

    public static void a(Context context, ic icVar) {
        a(context).a(icVar, 0, true);
    }

    public static void a(Context context, ic icVar, boolean z) {
        a(context).a(icVar, 1, z);
    }

    private void a(ic icVar, int i, boolean z) {
        if (com.xiaomi.push.j.m12048a(this.f162a) || !com.xiaomi.push.j.m12047a() || icVar == null || icVar.f706a != hg.SendMessage || icVar.m11945a() == null || !z) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a("click to start activity result:" + String.valueOf(i));
        Cif cif = new Cif(icVar.m11945a().m11895a(), false);
        cif.c(hq.SDK_START_ACTIVITY.f583a);
        cif.b(icVar.m11946a());
        cif.d(icVar.f713b);
        cif.f725a = new HashMap();
        cif.f725a.put("result", String.valueOf(i));
        ao.a(this.f162a).a(cif, hg.Notification, false, false, null, true, icVar.f713b, icVar.f709a, true, false);
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
        b m11457a = b.m11457a(context);
        if (TextUtils.isEmpty(m11457a.m11465c()) || TextUtils.isEmpty(m11457a.d())) {
            a2 = a(context);
            i = 6;
        } else {
            boolean m11469f = m11457a.m11469f();
            a2 = a(context);
            i = m11469f ? 7 : 5;
        }
        a2.a(icVar, i, z);
    }
}
