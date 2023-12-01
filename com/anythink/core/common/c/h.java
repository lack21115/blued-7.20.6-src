package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.e.p;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/h.class */
public class h extends com.anythink.core.common.c.a<p> {
    private static final String b = h.class.getName();
    private static volatile h c;
    private int d;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/h$a.class */
    public static final class a {
        public static final String a = "inspect_info";
        public static final String b = "inspect_id";
        public static final String c = "update_time";
        public static final String d = "CREATE TABLE IF NOT EXISTS inspect_info(inspect_id TEXT, update_time INTEGER )";
    }

    private h(b bVar) {
        super(bVar);
        this.d = 100;
    }

    public static h a(b bVar) {
        if (c == null) {
            synchronized (h.class) {
                try {
                    if (c == null) {
                        c = new h(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    private boolean b(String str) {
        synchronized (this) {
            if (str == null) {
                return false;
            }
            Cursor query = a().query(a.a, new String[]{a.b}, "inspect_id=?", new String[]{str}, null, null, null);
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

    public final long a(String str) {
        synchronized (this) {
            if (b() == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.b, str);
                contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
                if (b(str)) {
                    return b().update(a.a, contentValues, "inspect_id = ? ", new String[]{str});
                }
                return b().insert(a.a, null, contentValues);
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    public final void c() {
        long j;
        Cursor cursor;
        long j2;
        synchronized (this) {
            Cursor cursor2 = null;
            Cursor cursor3 = null;
            Cursor cursor4 = null;
            long j3 = -1;
            long j4 = -1;
            long j5 = -1;
            try {
                cursor = a().query(a.a, null, null, null, null, null, "update_time DESC", String.valueOf(this.d));
                j2 = -1;
                if (cursor != null) {
                    j2 = -1;
                    if (cursor.getCount() >= this.d) {
                        cursor.moveToLast();
                        j2 = cursor.getLong(cursor.getColumnIndex("update_time"));
                        cursor4 = cursor;
                        j3 = j2;
                        cursor2 = cursor;
                        j4 = j2;
                        cursor3 = cursor;
                        j5 = j2;
                        cursor.close();
                    }
                }
                j = j2;
            } catch (Exception e) {
                j = j3;
                if (cursor4 != null) {
                    cursor = cursor4;
                }
            } catch (OutOfMemoryError e2) {
                System.gc();
                j = j4;
                if (cursor2 != null) {
                    cursor = cursor2;
                    j3 = j4;
                }
            } catch (Throwable th) {
                j = j5;
                if (cursor3 != null) {
                    j = j5;
                    cursor = cursor3;
                }
            }
            if (cursor != null) {
                j3 = j2;
                j = j3;
                cursor.close();
            }
            if (j > 0) {
                try {
                    b().delete(a.a, "update_time<?", new String[]{String.valueOf(j)});
                } catch (Throwable th2) {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
        if (r13 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
        if (r13 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ca, code lost:
        if (r13 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d7, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.e.p> d() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.h.d():java.util.List");
    }
}
