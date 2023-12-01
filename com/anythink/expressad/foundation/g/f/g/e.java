package com.anythink.expressad.foundation.g.f.g;

import android.text.TextUtils;
import com.anythink.expressad.foundation.h.w;
import com.huawei.openalliance.ad.constant.t;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/g/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5069a = e.class.getSimpleName();

    public static String a(List<com.anythink.expressad.foundation.g.f.c.c> list) {
        com.anythink.expressad.foundation.g.f.c.c b = b(list, "Content-Type");
        if (b == null) {
            return "UTF-8";
        }
        String b2 = b.b();
        if (TextUtils.isEmpty(b2)) {
            return "UTF-8";
        }
        String[] split = b2.split(t.aE);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return "UTF-8";
            }
            String[] split2 = split[i2].trim().split("=");
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
            i = i2 + 1;
        }
    }

    public static String a(List<com.anythink.expressad.foundation.g.f.c.c> list, String str) {
        com.anythink.expressad.foundation.g.f.c.c b = b(list, str);
        return b != null ? b.b() : "";
    }

    private static void a(com.anythink.expressad.foundation.g.f.h.b bVar, String str, String str2) {
        if (bVar != null) {
            try {
                if (w.a(str) || w.a(str2)) {
                    return;
                }
                bVar.a(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static com.anythink.expressad.foundation.g.f.c.c b(List<com.anythink.expressad.foundation.g.f.c.c> list, String str) {
        if (list == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            com.anythink.expressad.foundation.g.f.c.c cVar = list.get(i2);
            if (cVar != null && str.equals(cVar.a())) {
                return cVar;
            }
            i = i2 + 1;
        }
    }

    public static boolean b(List<com.anythink.expressad.foundation.g.f.c.c> list) {
        return TextUtils.equals(a(list, "Content-Encoding"), "gzip");
    }

    private static boolean c(List<com.anythink.expressad.foundation.g.f.c.c> list) {
        if (TextUtils.equals(a(list, "Accept-Ranges"), "bytes")) {
            return true;
        }
        String a2 = a(list, "Content-Range");
        return a2 != null && a2.startsWith("bytes");
    }
}
