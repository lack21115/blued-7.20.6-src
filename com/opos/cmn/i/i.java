package com.opos.cmn.i;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/i.class */
public class i {
    public static boolean a(Context context, String[] strArr) {
        if (context == null || strArr == null || strArr.length <= 0) {
            return true;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            String str = strArr[i2];
            if (!com.opos.cmn.an.h.d.a.a(context, str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("don't have permission=");
                sb.append(str != null ? str : com.igexin.push.core.b.l);
                com.opos.cmn.an.f.a.c("PermissionUtils", sb.toString());
                return false;
            }
            i = i2 + 1;
        }
    }
}
