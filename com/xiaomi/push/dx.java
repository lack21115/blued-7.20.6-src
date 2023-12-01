package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dx.class */
public class dx {
    public static void a(Context context, String str, int i, String str2) {
        ai.a(context).a(new dy(context, str, i, str2));
    }

    private static void a(Context context, HashMap<String, String> hashMap) {
        ef m11710a = eb.a(context).m11710a();
        if (m11710a != null) {
            m11710a.a(context, hashMap);
        }
    }

    private static void b(Context context, HashMap<String, String> hashMap) {
        ef m11710a = eb.a(context).m11710a();
        if (m11710a != null) {
            m11710a.c(context, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, int i, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put("event_type", String.valueOf(i));
            hashMap.put("description", str2);
            int a2 = eb.a(context).a();
            if (a2 != 1) {
                if (a2 != 2) {
                    if (a2 == 3) {
                        a(context, hashMap);
                    }
                }
                c(context, hashMap);
            } else {
                a(context, hashMap);
            }
            b(context, hashMap);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private static void c(Context context, HashMap<String, String> hashMap) {
        ef m11710a = eb.a(context).m11710a();
        if (m11710a != null) {
            m11710a.b(context, hashMap);
        }
    }
}
