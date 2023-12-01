package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.amap.api.col.3sl.ji  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ji.class */
public final class ji {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, String> f5210a = new HashMap<>();

    public static String a(Context context, ia iaVar, String str) {
        if (iaVar == null || TextUtils.isEmpty(iaVar.a())) {
            return null;
        }
        String str2 = f5210a.get(iaVar.a() + str);
        if (TextUtils.isEmpty(str2)) {
            String str3 = str + iaVar.a();
            return (context == null || TextUtils.isEmpty(str3)) ? "" : ib.a(hm.b(ib.d(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(str3, ""))));
        }
        return str2;
    }

    public static void a(Context context, ia iaVar, String str, String str2) {
        if (iaVar == null || TextUtils.isEmpty(iaVar.a())) {
            return;
        }
        String str3 = str + iaVar.a();
        f5210a.put(iaVar.a() + str, str2);
        if (context == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") || TextUtils.isEmpty(str2)) {
            return;
        }
        String g = ib.g(hm.a(ib.a(str2)));
        SharedPreferences.Editor edit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        edit.putString(str3, g);
        edit.commit();
    }
}
