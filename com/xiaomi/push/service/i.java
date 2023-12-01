package com.xiaomi.push.service;

import com.xiaomi.push.Cif;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static a f41683a;

    /* renamed from: a  reason: collision with other field name */
    private static b f1056a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/i$a.class */
    public interface a {
        boolean a(Cif cif);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/i$b.class */
    public interface b {
    }

    public static void a(b bVar) {
        f1056a = bVar;
    }

    public static boolean a(Cif cif) {
        String str;
        if (f41683a == null || cif == null) {
            str = "rc params is null, not cpra";
        } else if (com.xiaomi.push.j.m12048a(com.xiaomi.push.r.m12066a())) {
            return f41683a.a(cif);
        } else {
            str = "rc app not permission to cpra";
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a(str);
        return false;
    }
}
