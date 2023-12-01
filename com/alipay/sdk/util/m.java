package com.alipay.sdk.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/m.class */
public class m {
    private static final String a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        if (EnvUtils.isSandBox()) {
            return com.alipay.sdk.cons.a.b;
        }
        if (context == null) {
            return com.alipay.sdk.cons.a.a;
        }
        String str = com.alipay.sdk.cons.a.a;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = com.alipay.sdk.cons.a.a;
        }
        return str2;
    }

    private static String b(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
        String str = null;
        if (query != null) {
            str = null;
            if (query.getCount() > 0) {
                str = null;
                if (query.moveToFirst()) {
                    str = query.getString(query.getColumnIndex("url"));
                }
                query.close();
            }
        }
        return str;
    }
}
