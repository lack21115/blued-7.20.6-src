package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/l0.class */
public class l0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f24799a;

    public l0(Context context) {
        this.f24799a = context;
    }

    public String a(int i, String str) {
        Uri parse;
        if (i == 0) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i == 1) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i != 2) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        }
        Cursor query = this.f24799a.getContentResolver().query(parse, null, null, null, null);
        if (query == null) {
            c.b("return cursor is null,return");
            return null;
        }
        String str2 = null;
        if (query.moveToNext()) {
            str2 = query.getString(query.getColumnIndex("value"));
        }
        query.close();
        return str2;
    }
}
