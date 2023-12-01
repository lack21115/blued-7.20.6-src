package com.bytedance.bdtracker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdtracker.s3;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/p3.class */
public final class p3 implements s3 {

    /* renamed from: a  reason: collision with root package name */
    public f3<Boolean> f7683a = new a(this);

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/p3$a.class */
    public class a extends f3<Boolean> {
        public a(p3 p3Var) {
        }

        @Override // com.bytedance.bdtracker.f3
        public Boolean a(Object[] objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception e) {
            }
            return false;
        }
    }

    @Override // com.bytedance.bdtracker.s3
    public s3.a a(Context context) {
        Cursor cursor;
        String string;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (query == null) {
                j1.a(query);
                return null;
            }
            try {
                s3.a aVar = new s3.a();
                if (!query.isClosed()) {
                    query.moveToFirst();
                    int columnIndex = query.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        string = query.getString(columnIndex);
                        aVar.f7699a = string;
                        j1.a(query);
                        return aVar;
                    }
                }
                string = null;
                aVar.f7699a = string;
                j1.a(query);
                return aVar;
            } catch (Throwable th) {
                cursor = query;
                th = th;
                try {
                    z2.a(th);
                    j1.a(cursor);
                    return null;
                } catch (Throwable th2) {
                    j1.a(cursor);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // com.bytedance.bdtracker.s3
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return this.f7683a.b(context).booleanValue();
    }
}
