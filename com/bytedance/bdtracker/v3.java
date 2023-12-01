package com.bytedance.bdtracker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.bdtracker.s3;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/v3.class */
public final class v3 implements s3 {

    /* renamed from: a  reason: collision with root package name */
    public static final f3<Boolean> f7722a = new a();

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/v3$a.class */
    public static final class a extends f3<Boolean> {
        @Override // com.bytedance.bdtracker.f3
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf("1".equals(v3.a("persist.sys.identifierid.supported", "0")));
        }
    }

    public static /* synthetic */ String a(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable th) {
            return str2;
        }
    }

    public static boolean a() {
        return f7722a.b(new Object[0]).booleanValue();
    }

    @Override // com.bytedance.bdtracker.s3
    public s3.a a(Context context) {
        Cursor cursor;
        Cursor cursor2;
        s3.a aVar = new s3.a();
        Uri parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        Cursor cursor3 = null;
        String str = null;
        if (parse != null) {
            try {
                cursor = context.getContentResolver().query(parse, null, null, null, null);
                str = null;
                cursor2 = cursor;
                if (cursor != null) {
                    str = null;
                    cursor2 = cursor;
                    cursor3 = cursor;
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                str = cursor.getString(cursor.getColumnIndex("value"));
                                cursor2 = cursor;
                            }
                        } catch (Throwable th) {
                            th = th;
                            j1.a(cursor3);
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor3 = cursor;
                        z2.a(e);
                        cursor2 = cursor;
                        str = null;
                        j1.a(cursor2);
                        aVar.f7699a = str;
                        return aVar;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                j1.a(cursor3);
                throw th;
            }
            j1.a(cursor2);
        }
        aVar.f7699a = str;
        return aVar;
    }

    @Override // com.bytedance.bdtracker.s3
    public boolean b(Context context) {
        return f7722a.b(new Object[0]).booleanValue();
    }
}
