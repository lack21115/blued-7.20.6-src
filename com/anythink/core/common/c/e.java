package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/e.class */
public class e extends com.anythink.core.common.c.a<com.anythink.core.common.a.e> {

    /* renamed from: c  reason: collision with root package name */
    private static volatile e f6575c;
    private final String b;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/e$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f6576a = "dsp_offer_install_record";
        public static final String b = "dsp_id";

        /* renamed from: c  reason: collision with root package name */
        public static final String f6577c = "dsp_offer_id";
        public static final String d = "package_name";
        public static final String e = "last_update_time";
        public static final String f = "CREATE TABLE IF NOT EXISTS dsp_offer_install_record(dsp_id TEXT ,dsp_offer_id TEXT ,package_name TEXT ,last_update_time INTEGER)";
    }

    private e(b bVar) {
        super(bVar);
        this.b = e.class.getName();
    }

    public static e a(b bVar) {
        if (f6575c == null) {
            synchronized (e.class) {
                try {
                    if (f6575c == null) {
                        f6575c = new e(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6575c;
    }

    private List<com.anythink.core.common.a.e> a(Cursor cursor) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        try {
                            com.anythink.core.common.a.e eVar = new com.anythink.core.common.a.e();
                            eVar.a(cursor.getString(cursor.getColumnIndex("dsp_id")));
                            eVar.b(cursor.getString(cursor.getColumnIndex("dsp_offer_id")));
                            eVar.c(cursor.getString(cursor.getColumnIndex("package_name")));
                            arrayList.add(eVar);
                        } catch (Throwable th) {
                        }
                    }
                    cursor.close();
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0089, code lost:
        if (r14 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = r9
            monitor-enter(r0)
            r0 = 0
            r13 = r0
            r0 = 0
            r15 = r0
            r0 = 0
            r16 = r0
            r0 = 0
            r14 = r0
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: java.lang.Exception -> L98 java.lang.OutOfMemoryError -> L9c java.lang.Throwable -> La0
            java.lang.String r1 = "dsp_offer_install_record"
            r2 = 0
            java.lang.String r3 = "dsp_id = ?  AND dsp_offer_id = ? "
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L98 java.lang.OutOfMemoryError -> L9c java.lang.Throwable -> La0
            r5 = r4
            r6 = 0
            r7 = r10
            r5[r6] = r7     // Catch: java.lang.Exception -> L98 java.lang.OutOfMemoryError -> L9c java.lang.Throwable -> La0
            r5 = r4
            r6 = 1
            r7 = r11
            r5[r6] = r7     // Catch: java.lang.Exception -> L98 java.lang.OutOfMemoryError -> L9c java.lang.Throwable -> La0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L98 java.lang.OutOfMemoryError -> L9c java.lang.Throwable -> La0
            r10 = r0
            r0 = r10
            r14 = r0
            r0 = r10
            r15 = r0
            r0 = r10
            r16 = r0
            r0 = r10
            int r0 = r0.getCount()     // Catch: java.lang.Exception -> L98 java.lang.OutOfMemoryError -> L9c java.lang.Throwable -> La0
            r12 = r0
            r0 = r12
            if (r0 <= 0) goto L41
            r0 = 1
            r13 = r0
        L41:
            r0 = r10
            if (r0 == 0) goto L4b
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L8f
        L4b:
            r0 = r9
            monitor-exit(r0)
            r0 = r13
            return r0
        L50:
            goto L56
        L53:
            goto L87
        L56:
            r0 = r16
            if (r0 == 0) goto L94
            r0 = r16
            r14 = r0
            goto L8c
        L62:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L78
            r0 = r15
            if (r0 == 0) goto L94
            r0 = r15
            r14 = r0
        L6e:
            r0 = r14
            r0.close()     // Catch: java.lang.Throwable -> L8f
            goto L94
        L78:
            r10 = move-exception
            r0 = r15
            if (r0 == 0) goto L85
            r0 = r15
            r0.close()     // Catch: java.lang.Throwable -> L8f
        L85:
            r0 = r10
            throw r0     // Catch: java.lang.Throwable -> L8f
        L87:
            r0 = r14
            if (r0 == 0) goto L94
        L8c:
            goto L6e
        L8f:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        L94:
            r0 = r9
            monitor-exit(r0)
            r0 = 0
            return r0
        L98:
            r10 = move-exception
            goto L53
        L9c:
            r10 = move-exception
            goto L62
        La0:
            r10 = move-exception
            goto L50
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.e.a(java.lang.String, java.lang.String):boolean");
    }

    public final long a(com.anythink.core.common.a.e eVar) {
        synchronized (this) {
            if (b() == null) {
                return -1L;
            }
            if (a(eVar.a(), eVar.b())) {
                StringBuilder sb = new StringBuilder("insertDspOfferInstallRecord--had inserted...,dspid:");
                sb.append(eVar.a());
                sb.append(",dspoferrId:");
                sb.append(eVar.b());
                sb.append(",packagename:");
                sb.append(eVar.c());
            } else {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("dsp_id", eVar.a());
                    contentValues.put("dsp_offer_id", eVar.b());
                    contentValues.put("package_name", eVar.c());
                    contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
                    StringBuilder sb2 = new StringBuilder("insertDspOfferInstallRecord--insert,dspid:");
                    sb2.append(eVar.a());
                    sb2.append(",dspoferrId:");
                    sb2.append(eVar.b());
                    sb2.append(",packagename:");
                    sb2.append(eVar.c());
                    return b().insert(a.f6576a, null, contentValues);
                } catch (Exception e) {
                }
            }
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        if (r12 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.a.d> a(int r11) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.e.a(int):java.util.List");
    }
}
