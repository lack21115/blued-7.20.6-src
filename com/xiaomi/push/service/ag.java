package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ic;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ag.class */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static a f41598a;

    /* renamed from: a  reason: collision with other field name */
    private static b f962a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ag$a.class */
    public interface a {
        Map<String, String> a(Context context, ic icVar);

        /* renamed from: a  reason: collision with other method in class */
        void m12105a(Context context, ic icVar);

        boolean a(Context context, ic icVar, boolean z);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ag$b.class */
    public interface b {
        void a(ic icVar);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m12106a(ic icVar);
    }

    public static Map<String, String> a(Context context, ic icVar) {
        a aVar = f41598a;
        if (aVar == null || icVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("pepa listener or container is null");
            return null;
        }
        return aVar.a(context, icVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m12103a(Context context, ic icVar) {
        a aVar = f41598a;
        if (aVar == null || icVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("handle msg wrong");
        } else {
            aVar.m12105a(context, icVar);
        }
    }

    public static void a(ic icVar) {
        b bVar = f962a;
        if (bVar == null || icVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("pepa clearMessage is null");
        } else {
            bVar.a(icVar);
        }
    }

    public static void a(String str) {
        b bVar = f962a;
        if (bVar == null || str == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("pepa clearMessage is null");
        } else {
            bVar.a(str);
        }
    }

    public static boolean a(Context context, ic icVar, boolean z) {
        a aVar = f41598a;
        if (aVar == null || icVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("pepa judement listener or container is null");
            return false;
        }
        return aVar.a(context, icVar, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m12104a(ic icVar) {
        b bVar = f962a;
        if (bVar == null || icVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("pepa handleReceiveMessage is null");
            return false;
        }
        return bVar.m12106a(icVar);
    }
}
