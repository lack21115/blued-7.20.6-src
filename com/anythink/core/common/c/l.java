package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.e.ae;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/l.class */
public class l extends com.anythink.core.common.c.a<ae> {

    /* renamed from: c  reason: collision with root package name */
    private static volatile l f6597c;
    private final String b;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/l$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f6598a = "placement_ad_impression";
        public static final String b = "format";

        /* renamed from: c  reason: collision with root package name */
        public static final String f6599c = "placement_id";
        public static final String d = "adsource_id";
        public static final String e = "hour_time";
        public static final String f = "hour_imp";
        public static final String g = "date_time";
        public static final String h = "date_imp";
        public static final String i = "show_time";
        public static final String j = "CREATE TABLE IF NOT EXISTS placement_ad_impression(format INTEGER ,placement_id TEXT ,adsource_id TEXT ,hour_time TEXT ,hour_imp INTEGER ,date_time TEXT ,date_imp INTEGER , show_time INTEGER)";
    }

    private l(b bVar) {
        super(bVar);
        this.b = l.class.getName();
    }

    public static l a(b bVar) {
        if (f6597c == null) {
            synchronized (l.class) {
                try {
                    if (f6597c == null) {
                        f6597c = new l(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6597c;
    }

    private static ae a(Cursor cursor, String str, String str2) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        ae aeVar = new ae();
        aeVar.f = new ConcurrentHashMap<>();
        while (cursor.moveToNext()) {
            aeVar.f6622a = cursor.getInt(cursor.getColumnIndex("format"));
            aeVar.b = cursor.getString(cursor.getColumnIndex(a.f6599c));
            ae.a aVar = new ae.a();
            aVar.f6624a = cursor.getString(cursor.getColumnIndex("adsource_id"));
            aVar.b = cursor.getString(cursor.getColumnIndex(a.e));
            aVar.f6625c = cursor.getString(cursor.getColumnIndex(a.g));
            if (TextUtils.equals(aVar.b, str2)) {
                aVar.e = cursor.getInt(cursor.getColumnIndex(a.f));
            } else {
                aVar.e = 0;
            }
            aeVar.d += aVar.e;
            if (TextUtils.equals(aVar.f6625c, str)) {
                aVar.d = cursor.getInt(cursor.getColumnIndex(a.h));
            } else {
                aVar.d = 0;
            }
            aeVar.f6623c += aVar.d;
            aVar.f = cursor.getLong(cursor.getColumnIndex("show_time"));
            if (aVar.f >= aeVar.e) {
                aeVar.e = aVar.f;
            }
            aeVar.f.put(aVar.f6624a, aVar);
        }
        cursor.close();
        return aeVar;
    }

    private static ae.a b(Cursor cursor, String str, String str2) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        cursor.moveToNext();
        ae.a aVar = new ae.a();
        aVar.f6624a = cursor.getString(cursor.getColumnIndex("adsource_id"));
        aVar.b = cursor.getString(cursor.getColumnIndex(a.e));
        aVar.f6625c = cursor.getString(cursor.getColumnIndex(a.g));
        if (TextUtils.equals(aVar.b, str2)) {
            aVar.e = cursor.getInt(cursor.getColumnIndex(a.f));
        } else {
            aVar.e = 0;
        }
        if (TextUtils.equals(aVar.f6625c, str)) {
            aVar.d = cursor.getInt(cursor.getColumnIndex(a.h));
        } else {
            aVar.d = 0;
        }
        aVar.f = cursor.getLong(cursor.getColumnIndex("show_time"));
        return aVar;
    }

    private boolean b(String str) {
        Cursor query = a().query(a.f6598a, new String[]{"adsource_id"}, "adsource_id=?", new String[]{str}, "adsource_id", null, null);
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

    public final long a(int i, String str, ae.a aVar) {
        boolean z;
        synchronized (this) {
            if (b() == null || aVar == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("format", Integer.valueOf(i));
                contentValues.put(a.f6599c, str);
                contentValues.put("adsource_id", aVar.f6624a);
                contentValues.put(a.e, aVar.b);
                contentValues.put(a.f, Integer.valueOf(aVar.e));
                contentValues.put(a.g, aVar.f6625c);
                contentValues.put(a.h, Integer.valueOf(aVar.d));
                contentValues.put("show_time", Long.valueOf(aVar.f));
                Cursor query = a().query(a.f6598a, new String[]{"adsource_id"}, "adsource_id=?", new String[]{aVar.f6624a}, "adsource_id", null, null);
                if (query == null || query.getCount() <= 0) {
                    if (query != null) {
                        query.close();
                    }
                    z = false;
                } else {
                    query.close();
                    z = true;
                }
                if (z) {
                    return b().update(a.f6598a, contentValues, "adsource_id = ? ", new String[]{aVar.f6624a});
                }
                return b().insert(a.f6598a, null, contentValues);
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f0, code lost:
        if (r10 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fc, code lost:
        if (r10 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ff, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0118, code lost:
        if (r10 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0125, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.core.common.e.ae.a a(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.l.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.anythink.core.common.e.ae$a");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0187, code lost:
        if (r10 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0193, code lost:
        if (r10 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0196, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01af, code lost:
        if (r10 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01bc, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.core.common.e.ae a(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.l.a(java.lang.String, java.lang.String, java.lang.String):com.anythink.core.common.e.ae");
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x02ff, code lost:
        if (r13 != null) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, com.anythink.core.common.e.ae> a(int r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.l.a(int, java.lang.String, java.lang.String):java.util.Map");
    }

    public final void a(String str) {
        String str2;
        synchronized (this) {
            try {
                str2 = "date_time!='" + str + "'";
            } catch (Exception e) {
            }
            if (b() == null) {
                return;
            }
            b().delete(a.f6598a, str2, null);
        }
    }
}
