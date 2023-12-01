package com.anythink.china.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.china.api.ChinaDeviceDataInfo;
import com.anythink.core.common.c.d;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/e.class */
public final class e {
    private Context a;

    public e(Context context) {
        this.a = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            this.a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String str = null;
        String str2 = null;
        try {
            Cursor query = this.a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{ChinaDeviceDataInfo.OAID}, null);
            if (query != null && !query.isClosed()) {
                query.moveToFirst();
                int columnIndex = query.getColumnIndex(d.a.d);
                if (columnIndex > 0) {
                    str = query.getString(columnIndex);
                }
            }
            String str3 = str;
            aVar.a(str, false);
            str2 = str;
            if (query != null) {
                str2 = str;
                try {
                    query.close();
                    str2 = str;
                } catch (Exception e) {
                    str2 = str;
                }
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
        if (TextUtils.isEmpty(str2)) {
            aVar.a();
        }
    }
}
