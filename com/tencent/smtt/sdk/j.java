package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f25165a = CookieManager.LOGTAG;
    static File b;

    public static File a(Context context) {
        if (b == null && context != null) {
            b = new File(context.getDir("webview", 0), "Cookies");
        }
        if (b == null) {
            b = new File("/data/data/" + context.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
        }
        return b;
    }

    private static String a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        int count = rawQuery.getCount();
        int columnCount = rawQuery.getColumnCount();
        StringBuilder sb = new StringBuilder();
        sb.append("raws:" + count + ",columns:" + columnCount + "\n");
        if (count <= 0 || !rawQuery.moveToFirst()) {
            return sb.toString();
        }
        do {
            sb.append("\n");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= columnCount) {
                    break;
                }
                try {
                    sb.append(rawQuery.getString(i2));
                    sb.append(",");
                } catch (Exception e) {
                }
                i = i2 + 1;
            }
            sb.append("\n");
        } while (rawQuery.moveToNext());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
        if (r4.isOpen() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        if (r4.isOpen() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
        r4.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.String> a(android.database.sqlite.SQLiteDatabase r4) {
        /*
            r0 = 0
            r6 = r0
            r0 = r4
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r4
            java.lang.String r1 = "select * from sqlite_master where type='table'"
            r2 = 0
            android.database.Cursor r0 = r0.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> L8d
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r7
            boolean r0 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L8d
            if (r0 == 0) goto L59
        L24:
            r0 = r7
            r6 = r0
            r0 = r7
            r1 = 1
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L8d
            r9 = r0
            r0 = r7
            r6 = r0
            r0 = r7
            r1 = 4
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L8d
            r0 = r7
            r6 = r0
            r0 = r8
            r1 = r9
            boolean r0 = r0.add(r1)     // Catch: java.lang.Throwable -> L8d
            r0 = r7
            r6 = r0
            r0 = r4
            r1 = r9
            java.lang.String r0 = a(r0, r1)     // Catch: java.lang.Throwable -> L8d
            r0 = r7
            r6 = r0
            r0 = r7
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L8d
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L24
        L59:
            r0 = r7
            if (r0 == 0) goto L63
            r0 = r7
            r0.close()
        L63:
            r0 = r4
            if (r0 == 0) goto L8a
            r0 = r4
            boolean r0 = r0.isOpen()
            if (r0 == 0) goto L8a
            goto L86
        L71:
            r0 = r6
            if (r0 == 0) goto L7b
            r0 = r6
            r0.close()
        L7b:
            r0 = r4
            if (r0 == 0) goto L8a
            r0 = r4
            boolean r0 = r0.isOpen()
            if (r0 == 0) goto L8a
        L86:
            r0 = r4
            r0.close()
        L8a:
            r0 = r8
            return r0
        L8d:
            r7 = move-exception
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.j.a(android.database.sqlite.SQLiteDatabase):java.util.ArrayList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0281, code lost:
        if (r11 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017a, code lost:
        if (r0.isOpen() != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017d, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01c5, code lost:
        if (r0.isOpen() != false) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, com.tencent.smtt.sdk.CookieManager.a r6, java.lang.String r7, boolean r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 647
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.j.a(android.content.Context, com.tencent.smtt.sdk.CookieManager$a, java.lang.String, boolean, boolean):void");
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        FileUtil.a(a(context), false);
        return true;
    }

    public static SQLiteDatabase c(Context context) {
        File a2;
        SQLiteDatabase sQLiteDatabase;
        if (context == null || (a2 = a(context)) == null) {
            return null;
        }
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(a2.getAbsolutePath(), null, 0);
        } catch (Exception e) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            TbsLog.i(f25165a, "dbPath is not exist!");
        }
        return sQLiteDatabase;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0082, code lost:
        r5 = java.lang.Integer.parseInt(r0.getString(1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.j.d(android.content.Context):int");
    }
}
