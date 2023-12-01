package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.f;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/cache/a.class */
public final class a extends c<com.vivo.push.model.a> {
    public a(Context context) {
        super(context);
    }

    public static boolean a(int i) {
        return i != -1 ? (i & 1) != 0 : z.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    @Override // com.vivo.push.cache.c
    protected final String a() {
        return "com.vivo.pushservice.back_up";
    }

    @Override // com.vivo.push.cache.c
    public final List<com.vivo.push.model.a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.trim().split("@#");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String trim = split[i2].trim();
                String[] split2 = trim.trim().split(",");
                if (split2.length >= 2) {
                    try {
                        arrayList.add(new com.vivo.push.model.a(split2[0], trim.substring(split2[0].length() + 1)));
                    } catch (Exception e) {
                        p.d("AppConfigSettings", "str2Clients E: ".concat(String.valueOf(e)));
                    }
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public final int b() {
        com.vivo.push.model.a c2 = c("push_mode");
        if (c2 == null || TextUtils.isEmpty(c2.b())) {
            return -1;
        }
        try {
            return Integer.parseInt(c2.b());
        } catch (Exception e) {
            return -1;
        }
    }

    @Override // com.vivo.push.cache.c
    final String b(String str) {
        return new String(f.a(f.a(e()), f.a(f()), Base64.decode(str, 2)), "utf-8");
    }

    public final com.vivo.push.model.a c(String str) {
        synchronized (f27376a) {
            for (T t : this.b) {
                if (!TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                    return t;
                }
            }
            return null;
        }
    }
}
