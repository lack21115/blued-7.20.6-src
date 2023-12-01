package c.t.m.g;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c1.class */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f3724a;

    public c1(Context context) {
        this.f3724a = context;
    }

    public String a() {
        String str = null;
        String str2 = null;
        try {
            Cursor query = this.f3724a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query != null) {
                str = null;
                if (query.moveToNext()) {
                    str = query.getString(query.getColumnIndex("value"));
                }
                str2 = str;
                query.close();
            }
            return str;
        } catch (Exception e) {
            return str2;
        }
    }
}
