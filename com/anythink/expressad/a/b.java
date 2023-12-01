package com.anythink.expressad.a;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/b.class */
public final class b {
    private static String a(String str) {
        return str;
    }

    private static String a(String str, List<String> list, String str2) {
        String str3 = str;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (true) {
                str3 = str;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    str = str.replaceAll(next, str2);
                }
            }
        }
        return str3;
    }
}
