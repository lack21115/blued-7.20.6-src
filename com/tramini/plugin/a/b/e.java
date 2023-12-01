package com.tramini.plugin.a.b;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/b/e.class */
public class e extends com.tramini.plugin.a.b.a<com.tramini.plugin.a.c.d> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40496a = e.class.getSimpleName();
    private static e b;

    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/b/e$a.class */
    public static final class a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        super(bVar);
    }

    public static e b(b bVar) {
        if (b == null) {
            b = new e(bVar);
        }
        return b;
    }

    public long a(com.tramini.plugin.a.c.d dVar) {
        synchronized (this) {
            if (b() == null || dVar == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", dVar.f40504a);
                contentValues.put("value", dVar.b);
                contentValues.put("time", Long.valueOf(dVar.f40505c));
                if (a(dVar.f40504a)) {
                    return b().update("il", contentValues, "id = ? ", new String[]{dVar.f40504a});
                }
                return b().insert("il", null, contentValues);
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tramini.plugin.a.b.a
    public final boolean a(String str) {
        Cursor query = a().query("il", new String[]{"id"}, "id = ? ", new String[]{str}, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            return true;
        } else if (query != null) {
            query.close();
            return false;
        } else {
            return false;
        }
    }

    public final long b(com.tramini.plugin.a.c.d dVar) {
        synchronized (this) {
            if (b() == null || dVar == null) {
                return -1L;
            }
            try {
                return b().delete("il", "id= ?", new String[]{dVar.f40504a});
            } catch (Throwable th) {
                return -1L;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
        if (r10 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, com.tramini.plugin.a.c.d> e() {
        /*
            r9 = this;
            r0 = r9
            monitor-enter(r0)
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = "il"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lad
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L8e
            r0 = r10
            int r0 = r0.getCount()     // Catch: java.lang.Throwable -> Lb1
            if (r0 <= 0) goto L8e
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> Lb1
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lb1
            r11 = r0
        L27:
            r0 = r10
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> Lb1
            if (r0 == 0) goto L7d
            com.tramini.plugin.a.c.d r0 = new com.tramini.plugin.a.c.d     // Catch: java.lang.Throwable -> Lb1
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lb1
            r12 = r0
            r0 = r12
            r1 = r10
            r2 = r10
            java.lang.String r3 = "id"
            int r2 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> Lb1
            r0.f40504a = r1     // Catch: java.lang.Throwable -> Lb1
            r0 = r12
            r1 = r10
            r2 = r10
            java.lang.String r3 = "value"
            int r2 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> Lb1
            r0.b = r1     // Catch: java.lang.Throwable -> Lb1
            r0 = r12
            r1 = r10
            r2 = r10
            java.lang.String r3 = "time"
            int r2 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lb1
            long r1 = r1.getLong(r2)     // Catch: java.lang.Throwable -> Lb1
            r0.f40505c = r1     // Catch: java.lang.Throwable -> Lb1
            r0 = r11
            r1 = r12
            java.lang.String r1 = r1.f40504a     // Catch: java.lang.Throwable -> Lb1
            r2 = r12
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> Lb1
            goto L27
        L7d:
            r0 = r10
            if (r0 == 0) goto L87
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> La4
        L87:
            r0 = r9
            monitor-exit(r0)
            r0 = r11
            return r0
        L8b:
            goto L97
        L8e:
            r0 = r10
            if (r0 == 0) goto La9
            goto L9b
        L95:
            r0 = 0
            r10 = r0
        L97:
            r0 = r10
            if (r0 == 0) goto La9
        L9b:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> La4
            goto La9
        La4:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        La9:
            r0 = r9
            monitor-exit(r0)
            r0 = 0
            return r0
        Lad:
            r10 = move-exception
            goto L95
        Lb1:
            r11 = move-exception
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.b.e.e():java.util.Map");
    }
}
