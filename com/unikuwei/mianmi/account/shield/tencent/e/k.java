package com.unikuwei.mianmi.account.shield.tencent.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/k.class */
public class k {
    public static String a(Context context) {
        String b = b(context, "auth02");
        String str = b;
        if (TextUtils.isEmpty(b)) {
            str = j.a(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") + System.currentTimeMillis());
            a(context, str);
        }
        return str;
    }

    public static void a(Context context, String str) {
        a(context, "auth02", str);
    }

    public static void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("cu_auth", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String b(Context context, String str) {
        try {
            return context.getSharedPreferences("cu_auth", 0).getString(str, "");
        } catch (Exception e) {
            a(context, str, "");
            return "";
        }
    }
}
