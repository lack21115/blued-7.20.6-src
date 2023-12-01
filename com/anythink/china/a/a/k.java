package com.anythink.china.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/k.class */
public final class k {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6237c = false;

    /* renamed from: a  reason: collision with root package name */
    String f6236a = null;

    public k(Context context) {
        this.b = context;
    }

    public final String a() {
        String str = null;
        String str2 = null;
        String str3 = null;
        try {
            Cursor query = this.b.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            str3 = null;
            if (query != null) {
                if (query.moveToNext()) {
                    str = query.getString(query.getColumnIndex("value"));
                }
                str2 = str;
                str3 = str;
                query.close();
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
        return str3;
    }
}
