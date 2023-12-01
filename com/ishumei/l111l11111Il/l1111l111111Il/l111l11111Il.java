package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l111l11111Il.class */
public final class l111l11111Il extends l111l1111lI1l {
    private Context l1111l111111Il;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l111l11111Il(Context context) {
        this.l1111l111111Il = context;
    }

    @Override // com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        String str = "";
        try {
            Cursor query = this.l1111l111111Il.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (query != null) {
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("value");
                str = columnIndex > 0 ? query.getString(columnIndex) : "";
                query.close();
            }
            return str;
        } catch (Throwable th) {
            return "";
        }
    }
}
