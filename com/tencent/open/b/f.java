package com.tencent.open.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.utils.Global;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/b/f.class */
public class f extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    protected static final String[] f38248a = {"key"};
    protected static f b;

    public f(Context context) {
        super(context, "sdk_report.db", null, 2);
    }

    public static f a() {
        f fVar;
        synchronized (f.class) {
            try {
                if (b == null) {
                    b = new f(Global.getContext());
                }
                fVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0175, code lost:
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0102, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x012a, code lost:
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0134, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cf A[Catch: all -> 0x00e6, Exception -> 0x00f0, TRY_ENTER, TryCatch #14 {Exception -> 0x00f0, all -> 0x00e6, blocks: (B:19:0x004e, B:21:0x0057, B:22:0x005e, B:22:0x005e, B:23:0x0061, B:24:0x0075, B:29:0x0089, B:31:0x008e, B:55:0x00cf, B:57:0x00d9, B:39:0x00ae, B:41:0x00b5, B:43:0x00b9, B:48:0x00c0, B:50:0x00c6), top: B:133:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f9 A[Catch: all -> 0x014b, TRY_ENTER, TRY_LEAVE, TryCatch #8 {, blocks: (B:4:0x0002, B:10:0x001c, B:66:0x00f9, B:67:0x0102, B:85:0x0139, B:88:0x0144, B:90:0x014a, B:75:0x0122), top: B:122:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.io.Serializable> a(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.f.a(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f7, code lost:
        if (r0 != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00fa, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0114, code lost:
        if (r0 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x011c, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r6, java.util.List<java.io.Serializable> r7) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.f.a(java.lang.String, java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r8
            monitor-enter(r0)
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L57
            r10 = r0
            r0 = r10
            if (r0 == 0) goto Le
            r0 = r8
            monitor-exit(r0)
            return
        Le:
            r0 = r8
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L57
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L1a
            r0 = r8
            monitor-exit(r0)
            return
        L1a:
            r0 = r11
            java.lang.String r1 = "via_cgi_report"
            java.lang.String r2 = "type = ?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3a
            r4 = r3
            r5 = 0
            r6 = r9
            r4[r5] = r6     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3a
            int r0 = r0.delete(r1, r2, r3)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3a
            r0 = r11
            if (r0 == 0) goto L4a
        L2f:
            r0 = r11
            r0.close()     // Catch: java.lang.Throwable -> L57
            goto L4a
        L36:
            r9 = move-exception
            goto L4d
        L3a:
            r9 = move-exception
            java.lang.String r0 = "openSDK_LOG.ReportDatabaseHelper"
            java.lang.String r1 = "clearReportItem has exception."
            r2 = r9
            com.tencent.open.a.f.b(r0, r1, r2)     // Catch: java.lang.Throwable -> L36
            r0 = r11
            if (r0 == 0) goto L4a
            goto L2f
        L4a:
            r0 = r8
            monitor-exit(r0)
            return
        L4d:
            r0 = r11
            if (r0 == 0) goto L55
            r0 = r11
            r0.close()     // Catch: java.lang.Throwable -> L57
        L55:
            r0 = r9
            throw r0     // Catch: java.lang.Throwable -> L57
        L57:
            r9 = move-exception
            r0 = r8
            monitor-exit(r0)
            r0 = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.f.b(java.lang.String):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }
}
