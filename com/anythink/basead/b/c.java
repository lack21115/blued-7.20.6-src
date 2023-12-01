package com.anythink.basead.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/b/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f5879a;
    private Context b;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/b/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f5880a = "my_offer_cap_pacing";
        public static final String b = "offer_id";

        /* renamed from: c  reason: collision with root package name */
        public static final String f5881c = "offer_cap";
        public static final String d = "offer_pacing";
        public static final String e = "show_num";
        public static final String f = "show_time";
        public static final String g = "record_date";
        public static final String h = "CREATE TABLE IF NOT EXISTS my_offer_cap_pacing (offer_id TEXT,offer_cap INTEGER,offer_pacing INTEGER,show_num INTEGER,show_time INTEGER,record_date INTEGER )";
    }

    private c(Context context) {
        this.b = context;
    }

    public static c a(Context context) {
        if (f5879a == null) {
            f5879a = new c(context);
        }
        return f5879a;
    }

    private static com.anythink.basead.c.c a(Cursor cursor) {
        com.anythink.basead.c.c cVar = new com.anythink.basead.c.c();
        cVar.f5893a = cursor.getString(cursor.getColumnIndex("offer_id"));
        cVar.d = cursor.getInt(cursor.getColumnIndex(a.e));
        cVar.e = cursor.getLong(cursor.getColumnIndex("show_time"));
        cVar.f = cursor.getString(cursor.getColumnIndex(a.g));
        cVar.b = cursor.getInt(cursor.getColumnIndex(a.f5881c));
        cVar.f5894c = cursor.getLong(cursor.getColumnIndex(a.d));
        return cVar;
    }

    private boolean d(String str) {
        synchronized (this) {
            Cursor query = b.a(this.b).getReadableDatabase().query(a.f5880a, new String[]{"offer_id"}, "offer_id=?", new String[]{str}, null, null, null);
            if (query != null && query.getCount() > 0) {
                query.close();
                return true;
            }
            if (query != null) {
                query.close();
            }
            return false;
        }
    }

    public final long a(com.anythink.basead.c.c cVar) {
        synchronized (this) {
            synchronized (this) {
                if (cVar == null) {
                    return 0L;
                }
                try {
                    if (b.a(this.b).getWritableDatabase() == null) {
                        return -1L;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("offer_id", cVar.f5893a);
                    contentValues.put(a.e, Integer.valueOf(cVar.d));
                    contentValues.put("show_time", Long.valueOf(cVar.e));
                    contentValues.put(a.g, cVar.f);
                    contentValues.put(a.f5881c, Integer.valueOf(cVar.b));
                    contentValues.put(a.d, Long.valueOf(cVar.f5894c));
                    if (!d(cVar.f5893a)) {
                        return b.a(this.b).getWritableDatabase().insert(a.f5880a, null, contentValues);
                    }
                    return b.a(this.b).getWritableDatabase().update(a.f5880a, contentValues, "offer_id = '" + cVar.f5893a + "'", null);
                } catch (Exception e) {
                    e.printStackTrace();
                    return -1L;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        if (r10 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r10 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
        if (r10 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
        if (r10 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0092, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.basead.c.c a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = r9
            monitor-enter(r0)
            r0 = r9
            android.content.Context r0 = r0.b     // Catch: java.lang.Exception -> L94 java.lang.OutOfMemoryError -> L98 java.lang.Throwable -> L9c
            com.anythink.basead.b.b r0 = com.anythink.basead.b.b.a(r0)     // Catch: java.lang.Exception -> L94 java.lang.OutOfMemoryError -> L98 java.lang.Throwable -> L9c
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Exception -> L94 java.lang.OutOfMemoryError -> L98 java.lang.Throwable -> L9c
            java.lang.String r1 = "my_offer_cap_pacing"
            r2 = 0
            java.lang.String r3 = "offer_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L94 java.lang.OutOfMemoryError -> L98 java.lang.Throwable -> L9c
            r5 = r4
            r6 = 0
            r7 = r10
            r5[r6] = r7     // Catch: java.lang.Exception -> L94 java.lang.OutOfMemoryError -> L98 java.lang.Throwable -> L9c
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L94 java.lang.OutOfMemoryError -> L98 java.lang.Throwable -> L9c
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L53
            r0 = r10
            int r0 = r0.getCount()     // Catch: java.lang.Exception -> La0 java.lang.OutOfMemoryError -> La4 java.lang.Throwable -> La8
            if (r0 <= 0) goto L53
            r0 = r10
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Exception -> La0 java.lang.OutOfMemoryError -> La4 java.lang.Throwable -> La8
            r0 = r10
            com.anythink.basead.c.c r0 = a(r0)     // Catch: java.lang.Exception -> La0 java.lang.OutOfMemoryError -> La4 java.lang.Throwable -> La8
            r11 = r0
            r0 = r10
            r0.close()     // Catch: java.lang.Exception -> La0 java.lang.OutOfMemoryError -> La4 java.lang.Throwable -> La8
            r0 = r10
            if (r0 == 0) goto L49
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L8b
        L49:
            r0 = r9
            monitor-exit(r0)
            r0 = r11
            return r0
        L4d:
            goto L5c
        L50:
            goto L84
        L53:
            r0 = r10
            if (r0 == 0) goto L90
            goto L88
        L5a:
            r0 = 0
            r10 = r0
        L5c:
            r0 = r10
            if (r0 == 0) goto L90
        L60:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L8b
            goto L90
        L69:
            r0 = 0
            r10 = r0
        L6b:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L75
            r0 = r10
            if (r0 == 0) goto L90
            goto L88
        L75:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L80
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L8b
        L80:
            r0 = r11
            throw r0     // Catch: java.lang.Throwable -> L8b
        L82:
            r0 = 0
            r10 = r0
        L84:
            r0 = r10
            if (r0 == 0) goto L90
        L88:
            goto L60
        L8b:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        L90:
            r0 = r9
            monitor-exit(r0)
            r0 = 0
            return r0
        L94:
            r10 = move-exception
            goto L82
        L98:
            r10 = move-exception
            goto L69
        L9c:
            r10 = move-exception
            goto L5a
        La0:
            r11 = move-exception
            goto L50
        La4:
            r11 = move-exception
            goto L6b
        La8:
            r11 = move-exception
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.b.c.a(java.lang.String):com.anythink.basead.c.c");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (r10 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
        if (r10 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
        if (r10 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009d, code lost:
        if (r10 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00aa, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.basead.c.c> b(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 196
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.b.c.b(java.lang.String):java.util.List");
    }

    public final void c(String str) {
        String str2;
        synchronized (this) {
            synchronized (this) {
                try {
                    str2 = "record_date != '" + str + "'";
                } catch (Exception e) {
                }
                if (b.a(this.b).getWritableDatabase() == null) {
                    return;
                }
                b.a(this.b).getWritableDatabase().delete(a.f5880a, str2, null);
            }
        }
    }
}
