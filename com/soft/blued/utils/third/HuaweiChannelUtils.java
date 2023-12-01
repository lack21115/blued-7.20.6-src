package com.soft.blued.utils.third;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/HuaweiChannelUtils.class */
public class HuaweiChannelUtils {
    public static String a(Context context) {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(parse, null, null, new String[]{"com.soft.blued"}, null);
            String str = null;
            if (query != null) {
                try {
                    query.moveToFirst();
                    Log.i("HuaweiChannelUtils", "packageName=com.soft.blued");
                    if (query.getColumnCount() > 4) {
                        Log.i("HuaweiChannelUtils", "referrer=" + query.getString(0));
                        Log.i("HuaweiChannelUtils", "enter appgallery time=" + query.getString(1));
                        Log.i("HuaweiChannelUtils", "donwload time=" + query.getString(2));
                        Log.i("HuaweiChannelUtils", "track id=" + query.getString(4));
                        str = query.getString(4);
                    } else if (query.getColumnCount() > 2) {
                        str = query.getString(0);
                        Log.i("HuaweiChannelUtils", "referrer=" + query.getString(0));
                        Log.i("HuaweiChannelUtils", "enter appgallery time=" + query.getString(1));
                        Log.i("HuaweiChannelUtils", "donwload time=" + query.getString(2));
                    } else {
                        Log.e("HuaweiChannelUtils", "appgallery not support");
                        str = null;
                    }
                } catch (Throwable th) {
                    cursor = query;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            TextUtils.isEmpty(str);
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
