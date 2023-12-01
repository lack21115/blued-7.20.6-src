package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ae.class */
public final class ae {
    private static String azV;
    private static boolean azW;

    public static String bY(Context context) {
        Cursor cursor;
        if (TextUtils.isEmpty(azV) && !azW && as.DR()) {
            Cursor cursor2 = null;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
                cursor2 = cursor;
                azV = i(cursor);
            } catch (Throwable th) {
                cursor = cursor2;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            azW = TextUtils.isEmpty(azV);
            return azV;
        }
        return azV;
    }

    private static String i(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.b.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("support");
        if (columnIndex <= 0 || cursor.getInt(columnIndex) != 0) {
            int columnIndex2 = cursor.getColumnIndex("detailStyle");
            return columnIndex2 > 0 ? cursor.getString(columnIndex2) : "";
        }
        return "";
    }
}
