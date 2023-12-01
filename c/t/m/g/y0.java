package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import c.t.m.g.v0;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/y0.class */
public class y0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f4063a;

    public y0(Context context) {
        this.f4063a = context;
    }

    public final String a(Cursor cursor) {
        String str = null;
        String str2 = null;
        if (cursor != null) {
            if (cursor.isClosed()) {
                return null;
            }
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex > 0) {
                str2 = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            str = str2;
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
                str = str2;
            }
        }
        return str;
    }

    public void a(v0.b bVar) {
        try {
            this.f4063a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Exception e) {
        }
        try {
            Cursor query = this.f4063a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            String a2 = a(query);
            boolean a3 = a();
            if (bVar != null) {
                bVar.a(a2, a3);
            }
            query.close();
        } catch (Throwable th) {
        }
    }

    public boolean a() {
        try {
            PackageManager packageManager = this.f4063a.getPackageManager();
            boolean z = false;
            if (packageManager != null) {
                z = false;
                if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                    z = true;
                }
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
