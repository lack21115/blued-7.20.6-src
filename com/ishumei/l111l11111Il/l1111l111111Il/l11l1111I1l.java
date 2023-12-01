package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l11l1111I1l.class */
public final class l11l1111I1l extends l111l1111lI1l {
    private Context l1111l111111Il;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l11l1111I1l(Context context) {
        this.l1111l111111Il = context;
    }

    @Override // com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        Uri parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        ContentResolver contentResolver = this.l1111l111111Il.getContentResolver();
        String str = "";
        if (contentResolver == null) {
            return "";
        }
        Cursor query = contentResolver.query(parse, null, null, null, null);
        if (query != null) {
            query.moveToNext();
            str = query.getString(query.getColumnIndex("value"));
            query.close();
        }
        return str;
    }
}
