package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/h.class */
public class h {
    public static String a(List<String> list) {
        return TextUtils.join("!", list);
    }

    public static List<String> a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            File databasePath = context.getDatabasePath(e.b);
            if (databasePath != null && databasePath.exists()) {
                databasePath.delete();
            }
            f.a(context).a();
        } catch (Throwable th) {
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + " " + str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
        if (r9.isClosed() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.database.sqlite.SQLiteDatabase r9, java.lang.String r10, java.lang.String r11) {
        /*
            r0 = 0
            r15 = r0
            r0 = 0
            r16 = r0
            r0 = 0
            r14 = r0
            r0 = 0
            r17 = r0
            r0 = 0
            r18 = r0
            r0 = r9
            r1 = r10
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "LIMIT 0"
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L99
            r9 = r0
            r0 = r14
            r13 = r0
            r0 = r9
            if (r0 == 0) goto L3e
            r0 = r9
            r18 = r0
            r0 = r9
            r17 = r0
            r0 = r9
            r1 = r11
            int r0 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L99
            r12 = r0
            r0 = r14
            r13 = r0
            r0 = r12
            r1 = -1
            if (r0 == r1) goto L3e
            r0 = 1
            r13 = r0
        L3e:
            r0 = r13
            r14 = r0
            r0 = r9
            if (r0 == 0) goto L96
            r0 = r13
            r14 = r0
            r0 = r9
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto L96
        L53:
            r0 = r9
            r0.close()
            r0 = r13
            return r0
        L5c:
            r9 = move-exception
            r0 = r18
            if (r0 == 0) goto L73
            r0 = r18
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto L73
            r0 = r18
            r0.close()
        L73:
            r0 = r9
            throw r0
        L75:
            r0 = r16
            r14 = r0
            r0 = r17
            if (r0 == 0) goto L96
            r0 = r16
            r14 = r0
            r0 = r17
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto L96
            r0 = r15
            r13 = r0
            r0 = r17
            r9 = r0
            goto L53
        L96:
            r0 = r14
            return r0
        L99:
            r9 = move-exception
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
        if (r10 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r10, android.database.sqlite.SQLiteDatabase r11) {
        /*
            Method dump skipped, instructions count: 173
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static String b(Context context) {
        File databasePath = context.getDatabasePath(e.b);
        return databasePath.getParent() + File.separator;
    }

    public static List<String> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String c(Context context) {
        return b(context) + e.f27032a;
    }
}
