package com.tencent.tendinsv.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/d.class */
public class d extends l {

    /* renamed from: c  reason: collision with root package name */
    private boolean f25311c;
    private boolean d;

    public d() {
        super("com.meizu.flyme.openidsdk", "");
        this.f25311c = false;
        this.d = false;
    }

    public boolean d(Context context) {
        if (super.b_(context)) {
            this.d = true;
        } else {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"support"}, null);
                if (query == null) {
                    return false;
                }
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("value");
                if (columnIndex >= 0) {
                    String string = query.getString(columnIndex);
                    if (TextUtils.isEmpty(string)) {
                        return false;
                    }
                    this.d = "0".equals(string);
                } else {
                    this.d = false;
                }
            } catch (Throwable th) {
                this.d = false;
                return false;
            }
        }
        this.f25311c = true;
        return this.d;
    }

    public String e(Context context) {
        a(new String[]{"oaid"});
        return super.b(context);
    }
}
