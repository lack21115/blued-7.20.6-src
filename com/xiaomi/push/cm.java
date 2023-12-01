package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cm.class */
public class cm {

    /* renamed from: a  reason: collision with root package name */
    private static String f27620a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f208a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f208a = simpleDateFormat;
        f27620a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static hk a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hk hkVar = new hk();
        hkVar.d("category_push_stat");
        hkVar.a("push_sdk_stat_channel");
        hkVar.a(1L);
        hkVar.b(str);
        hkVar.a(true);
        hkVar.b(System.currentTimeMillis());
        hkVar.g(bv.a(context).m8508a());
        hkVar.e("com.xiaomi.xmsf");
        hkVar.f("");
        hkVar.c("push_stat");
        return hkVar;
    }
}
