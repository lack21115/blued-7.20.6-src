package com.xiaomi.push.service;

import com.xiaomi.push.Cif;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static a f27992a;

    /* renamed from: a  reason: collision with other field name */
    private static b f1009a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/i$a.class */
    public interface a {
        boolean a(Cif cif);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/i$b.class */
    public interface b {
    }

    public static void a(b bVar) {
        f1009a = bVar;
    }

    public static boolean a(Cif cif) {
        String str;
        if (f27992a == null || cif == null) {
            str = "rc params is null, not cpra";
        } else if (com.xiaomi.push.j.m8998a(com.xiaomi.push.r.m9016a())) {
            return f27992a.a(cif);
        } else {
            str = "rc app not permission to cpra";
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a(str);
        return false;
    }
}
