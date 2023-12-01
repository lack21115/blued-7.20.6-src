package com.anythink.china.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f6226a;

    public e(Context context) {
        this.f6226a = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            this.f6226a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String str = null;
        String str2 = null;
        try {
            Cursor query = this.f6226a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (query != null && !query.isClosed()) {
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("value");
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
