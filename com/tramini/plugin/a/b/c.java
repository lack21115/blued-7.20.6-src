package com.tramini.plugin.a.b;

import android.content.ContentValues;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/b/c.class */
public class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26803a = c.class.getSimpleName();
    private static c b;

    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/b/c$a.class */
    public static final class a {
    }

    private c(b bVar) {
        super(bVar);
    }

    public static c a(b bVar) {
        if (b == null) {
            b = new c(bVar);
        }
        return b;
    }

    @Override // com.tramini.plugin.a.b.e
    public final long a(com.tramini.plugin.a.c.d dVar) {
        synchronized (this) {
            if (b() == null || dVar == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", dVar.f26813a);
                contentValues.put("value", dVar.b);
                contentValues.put("time", Long.valueOf(dVar.f26814c));
                if (a(dVar.f26813a)) {
                    return b().update("il_all", contentValues, "id = ? ", new String[]{dVar.f26813a});
                }
                return b().insert("il_all", null, contentValues);
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0094, code lost:
        if (r10 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a7, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Set<com.tramini.plugin.a.c.d> c() {
        /*
            r9 = this;
            r0 = r9
            monitor-enter(r0)
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: java.lang.Throwable -> La9
            java.lang.String r1 = "il_all"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La9
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L8a
            r0 = r10
            int r0 = r0.getCount()     // Catch: java.lang.Throwable -> Lad
            if (r0 <= 0) goto L8a
            java.util.HashSet r0 = new java.util.HashSet     // Catch: java.lang.Throwable -> Lad
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lad
            r11 = r0
        L27:
            r0 = r10
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> Lad
            if (r0 == 0) goto L79
            com.tramini.plugin.a.c.d r0 = new com.tramini.plugin.a.c.d     // Catch: java.lang.Throwable -> Lad
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lad
            r12 = r0
            r0 = r12
            r1 = r10
            r2 = r10
            java.lang.String r3 = "id"
            int r2 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> Lad
            r0.f26813a = r1     // Catch: java.lang.Throwable -> Lad
            r0 = r12
            r1 = r10
            r2 = r10
            java.lang.String r3 = "value"
            int r2 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> Lad
            r0.b = r1     // Catch: java.lang.Throwable -> Lad
            r0 = r12
            r1 = r10
            r2 = r10
            java.lang.String r3 = "time"
            int r2 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lad
            long r1 = r1.getLong(r2)     // Catch: java.lang.Throwable -> Lad
            r0.f26814c = r1     // Catch: java.lang.Throwable -> Lad
            r0 = r11
            r1 = r12
            boolean r0 = r0.add(r1)     // Catch: java.lang.Throwable -> Lad
            goto L27
        L79:
            r0 = r10
            if (r0 == 0) goto L83
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> La0
        L83:
            r0 = r9
            monitor-exit(r0)
            r0 = r11
            return r0
        L87:
            goto L93
        L8a:
            r0 = r10
            if (r0 == 0) goto La5
            goto L97
        L91:
            r0 = 0
            r10 = r0
        L93:
            r0 = r10
            if (r0 == 0) goto La5
        L97:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> La0
            goto La5
        La0:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        La5:
            r0 = r9
            monitor-exit(r0)
            r0 = 0
            return r0
        La9:
            r10 = move-exception
            goto L91
        Lad:
            r11 = move-exception
            goto L87
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.b.c.c():java.util.Set");
    }

    public final long d() {
        synchronized (this) {
            if (b() == null) {
                return -1L;
            }
            try {
                return b().delete("il_all", null, null);
            } catch (Throwable th) {
                return -1L;
            }
        }
    }
}
