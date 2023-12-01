package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/kwai/h.class */
public final class h {
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str;
        Cursor cursor;
        Cursor cursor2 = null;
        String str2 = "";
        Cursor cursor3 = null;
        try {
            Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            str = "";
            cursor = query;
            if (query != null) {
                str = "";
                cursor = query;
                if (query.moveToNext()) {
                    str = query.getString(query.getColumnIndex("value"));
                    cursor2 = query;
                    str2 = str;
                    cursor3 = query;
                    new StringBuilder("getOAID oaid:").append(str);
                    cursor = query;
                }
            }
        } catch (Exception e) {
            str = str2;
            cursor = cursor3;
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return str;
    }
}
