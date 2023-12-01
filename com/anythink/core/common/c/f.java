package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/f.class */
public class f extends com.anythink.core.common.c.a<com.anythink.core.common.a.f> {
    private static volatile f d;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final long f6578c;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f6579a = "dsp_offer_show_record";
        public static final String b = "dsp_id";

        /* renamed from: c  reason: collision with root package name */
        public static final String f6580c = "dsp_offer_id";
        public static final String d = "show_limit";
        public static final String e = "show_count";
        public static final String f = "create_time";
        public static final String g = "last_update_time";
        public static final String h = "CREATE TABLE IF NOT EXISTS dsp_offer_show_record(dsp_id TEXT ,dsp_offer_id TEXT ,show_limit INTEGER ,show_count INTEGER ,create_time INTEGER ,last_update_time INTEGER)";
    }

    private f(b bVar) {
        super(bVar);
        this.b = f.class.getName();
        this.f6578c = 86400000L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (r10 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
        if (r10 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (r10 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
        if (r10 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008b, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.anythink.core.common.a.f a(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = r9
            monitor-enter(r0)
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: java.lang.Exception -> L8d java.lang.OutOfMemoryError -> L91 java.lang.Throwable -> L95
            java.lang.String r1 = "dsp_offer_show_record"
            r2 = 0
            java.lang.String r3 = "dsp_id = ?  AND dsp_offer_id = ? "
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L8d java.lang.OutOfMemoryError -> L91 java.lang.Throwable -> L95
            r5 = r4
            r6 = 0
            r7 = r10
            r5[r6] = r7     // Catch: java.lang.Exception -> L8d java.lang.OutOfMemoryError -> L91 java.lang.Throwable -> L95
            r5 = r4
            r6 = 1
            r7 = r11
            r5[r6] = r7     // Catch: java.lang.Exception -> L8d java.lang.OutOfMemoryError -> L91 java.lang.Throwable -> L95
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L8d java.lang.OutOfMemoryError -> L91 java.lang.Throwable -> L95
            r10 = r0
            r0 = r9
            r1 = r10
            java.util.List r0 = r0.a(r1)     // Catch: java.lang.Exception -> L99 java.lang.OutOfMemoryError -> L9d java.lang.Throwable -> La1
            r11 = r0
            r0 = r11
            int r0 = r0.size()     // Catch: java.lang.Exception -> L99 java.lang.OutOfMemoryError -> L9d java.lang.Throwable -> La1
            if (r0 <= 0) goto L46
            r0 = r11
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L99 java.lang.OutOfMemoryError -> L9d java.lang.Throwable -> La1
            com.anythink.core.common.a.f r0 = (com.anythink.core.common.a.f) r0     // Catch: java.lang.Exception -> L99 java.lang.OutOfMemoryError -> L9d java.lang.Throwable -> La1
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L42
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L84
        L42:
            r0 = r9
            monitor-exit(r0)
            r0 = r11
            return r0
        L46:
            r0 = r10
            if (r0 == 0) goto L89
            goto L81
        L4d:
            goto L55
        L50:
            goto L7d
        L53:
            r0 = 0
            r10 = r0
        L55:
            r0 = r10
            if (r0 == 0) goto L89
        L59:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L84
            goto L89
        L62:
            r0 = 0
            r10 = r0
        L64:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L6e
            r0 = r10
            if (r0 == 0) goto L89
            goto L81
        L6e:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L79
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L84
        L79:
            r0 = r11
            throw r0     // Catch: java.lang.Throwable -> L84
        L7b:
            r0 = 0
            r10 = r0
        L7d:
            r0 = r10
            if (r0 == 0) goto L89
        L81:
            goto L59
        L84:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        L89:
            r0 = r9
            monitor-exit(r0)
            r0 = 0
            return r0
        L8d:
            r10 = move-exception
            goto L7b
        L91:
            r10 = move-exception
            goto L62
        L95:
            r10 = move-exception
            goto L53
        L99:
            r11 = move-exception
            goto L50
        L9d:
            r11 = move-exception
            goto L64
        La1:
            r11 = move-exception
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.f.a(java.lang.String, java.lang.String):com.anythink.core.common.a.f");
    }

    public static f a(b bVar) {
        if (d == null) {
            synchronized (f.class) {
                try {
                    if (d == null) {
                        d = new f(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    private List<com.anythink.core.common.a.f> a(Cursor cursor) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        try {
                            com.anythink.core.common.a.f fVar = new com.anythink.core.common.a.f();
                            fVar.a(cursor.getString(cursor.getColumnIndex("dsp_id")));
                            fVar.b(cursor.getString(cursor.getColumnIndex("dsp_offer_id")));
                            fVar.a(cursor.getInt(cursor.getColumnIndex(a.d)));
                            fVar.b(cursor.getInt(cursor.getColumnIndex("show_count")));
                            arrayList.add(fVar);
                        } catch (Throwable th) {
                        }
                    }
                    cursor.close();
                }
            }
        }
        return arrayList;
    }

    public final long a(com.anythink.core.common.a.f fVar) {
        synchronized (this) {
            if (b() == null) {
                return -1L;
            }
            if (fVar.c() <= 0) {
                return -1L;
            }
            if (a(fVar.a(), fVar.b()) != null) {
                StringBuilder sb = new StringBuilder("insertDspOfferShowRecord--had inserted...,dspid:");
                sb.append(fVar.a());
                sb.append(",dspOfferId:");
                sb.append(fVar.b());
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("dsp_id", fVar.a());
            contentValues.put("dsp_offer_id", fVar.b());
            contentValues.put(a.d, Integer.valueOf(fVar.c()));
            contentValues.put("show_count", (Integer) 0);
            contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
            StringBuilder sb2 = new StringBuilder("insertDspOfferShowRecord--insert dspid:");
            sb2.append(fVar.a());
            sb2.append(",dspOfferId:");
            sb2.append(fVar.b());
            return b().insert(a.f6579a, null, contentValues);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
        if (r12 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.a.d> a(int r11) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.f.a(int):java.util.List");
    }

    public final long b(com.anythink.core.common.a.f fVar) {
        synchronized (this) {
            if (b() == null) {
                return -1L;
            }
            if (fVar.c() <= 0) {
                return -1L;
            }
            com.anythink.core.common.a.f a2 = a(fVar.a(), fVar.b());
            if (a2 != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("dsp_id", fVar.a());
                    contentValues.put("dsp_offer_id", fVar.b());
                    contentValues.put(a.d, Integer.valueOf(fVar.c()));
                    contentValues.put("show_count", Integer.valueOf(a2.d() + 1));
                    contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
                    StringBuilder sb = new StringBuilder("updateDspOfferShowRecord--update dspid:");
                    sb.append(fVar.a());
                    sb.append(",dspOfferId:");
                    sb.append(fVar.b());
                    sb.append(",cur show count:");
                    sb.append(a2.d() + 1);
                    sb.append(",limit show cap:");
                    sb.append(fVar.c());
                    return b().update(a.f6579a, contentValues, "dsp_id = ? and dsp_offer_id = ? ", new String[]{fVar.a(), fVar.b()});
                } catch (Exception e) {
                }
            }
            return -1L;
        }
    }

    public final void c() {
        try {
            String str = "create_time < " + (System.currentTimeMillis() - 86400000);
            if (b() == null) {
                return;
            }
            b().delete(a.f6579a, str, null);
        } catch (Exception e) {
        }
    }
}
