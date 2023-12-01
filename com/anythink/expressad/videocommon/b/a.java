package com.anythink.expressad.videocommon.b;

import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f8724a;
    private final com.anythink.core.common.res.a.c b = com.anythink.core.common.res.a.c.a();

    private a() {
    }

    public static a a() {
        if (f8724a == null) {
            synchronized (a.class) {
                try {
                    if (f8724a == null) {
                        f8724a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8724a;
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : com.anythink.core.common.res.d.a(com.anythink.core.common.b.n.a().g()).b(4, com.anythink.core.common.k.f.a(str));
    }

    public static com.anythink.core.common.a.i b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.anythink.core.common.a.j.a().a(str);
    }
}
