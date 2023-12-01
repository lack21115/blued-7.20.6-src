package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.f;
import com.vivo.push.util.p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/cache/e.class */
public final class e extends c<com.vivo.push.model.a> {
    public e(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.c
    protected final String a() {
        return "com.vivo.pushservice.other";
    }

    @Override // com.vivo.push.cache.c
    public final List<com.vivo.push.model.a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.trim().split("@#");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            String trim = split[i2].trim();
            String[] split2 = trim.trim().split(",");
            if (split2.length >= 2) {
                try {
                    arrayList.add(new com.vivo.push.model.a(split2[0], trim.substring(split2[0].length() + 1)));
                } catch (Exception e) {
                    p.d("PushConfigSettings", "str2Clients E: ".concat(String.valueOf(e)));
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.vivo.push.cache.c
    final String b(String str) {
        return new String(f.a(f.a(e()), f.a(f()), Base64.decode(str, 2)), "utf-8");
    }

    public final String c(String str) {
        synchronized (f41067a) {
            for (com.vivo.push.model.a aVar : this.b) {
                if (!TextUtils.isEmpty(aVar.a()) && aVar.a().equals(str)) {
                    return aVar.b();
                }
            }
            return null;
        }
    }
}
