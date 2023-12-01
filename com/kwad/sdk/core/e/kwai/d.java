package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/kwai/d.class */
public final class d {
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    private static String d(Cursor cursor) {
        String str;
        str = "";
        String str2 = str;
        if (cursor != null) {
            if (cursor.isClosed()) {
                return "";
            }
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            str = columnIndex > 0 ? cursor.getString(columnIndex) : "";
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            str2 = str;
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
                str2 = str;
            }
        }
        return str2;
    }

    public final String getOAID() {
        String str = null;
        try {
            Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            String d = d(query);
            new StringBuilder("getOAID oaid:").append(d);
            str = d;
            com.kwad.sdk.crash.utils.b.closeQuietly(query);
            return d;
        } catch (Exception e) {
            return str;
        }
    }
}
