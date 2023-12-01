package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.e.x;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/j.class */
public class j extends com.anythink.core.common.c.a<x> {
    private static j c;
    private final String b;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/j$a.class */
    public static final class a {
        public static final String a = "offer_action_record";
        public static final String b = "adsource_id";
        public static final String c = "type";
        public static final String d = "unit_id";
        public static final String e = "click_count";
        public static final String f = "show_count";
        public static final String g = "expire_time";
        public static final String h = "CREATE TABLE IF NOT EXISTS offer_action_record(adsource_id TEXT ,type INTEGER ,unit_id TEXT ,click_count INTEGER ,show_count INTEGER ,expire_time INTEGER )";
    }

    private j(b bVar) {
        super(bVar);
        this.b = j.class.getName();
    }

    private long a(x xVar) {
        synchronized (this) {
            if (b() == null || xVar == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("type", Integer.valueOf(xVar.e()));
                contentValues.put("unit_id", xVar.a());
                contentValues.put(a.e, Integer.valueOf(xVar.d()));
                contentValues.put("show_count", Integer.valueOf(xVar.c()));
                contentValues.put(a.g, Long.valueOf(xVar.b()));
                return b().update(a.a, contentValues, "type = ? and unit_id = ?", new String[]{String.valueOf(xVar.e()), xVar.a()});
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    public static j a(b bVar) {
        if (c == null) {
            synchronized (j.class) {
                try {
                    if (c == null) {
                        c = new j(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a0, code lost:
        if (r12 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ac, code lost:
        if (r12 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c8, code lost:
        if (r12 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d5, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.anythink.core.common.e.x a(int r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.j.a(int, java.lang.String):com.anythink.core.common.e.x");
    }

    private long b(String str, int i, String str2) {
        synchronized (this) {
            if (b() == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("adsource_id", str);
                contentValues.put("type", Integer.valueOf(i));
                contentValues.put("unit_id", str2);
                x a2 = a(i, str2);
                if (a2 != null) {
                    contentValues.put(a.e, Integer.valueOf(a2.d()));
                    contentValues.put("show_count", Integer.valueOf(a2.c()));
                    contentValues.put(a.g, Long.valueOf(a2.b()));
                } else {
                    contentValues.put(a.e, (Integer) 0);
                    contentValues.put("show_count", (Integer) 0);
                    contentValues.put(a.g, (Integer) (-1));
                }
                return b().insert(a.a, null, contentValues);
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    private static String b(int i) {
        if (i > 0) {
            StringBuilder sb = new StringBuilder((i * 2) - 1);
            sb.append("?");
            for (int i2 = 1; i2 < i; i2++) {
                sb.append(",?");
            }
            return sb.toString();
        }
        throw new RuntimeException("No placeholders");
    }

    private boolean b(int i, String str) {
        Cursor query = a().query(a.a, null, "type = ? and unit_id = ?", new String[]{String.valueOf(i), str}, null, null, null);
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

    private boolean c(String str, int i, String str2) {
        Cursor query = a().query(a.a, null, "adsource_id = ? and type = ? and unit_id = ?", new String[]{str, String.valueOf(i), str2}, null, null, null);
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

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e8, code lost:
        if (r12 != null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.e.x> a(int r11) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.j.a(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b6, code lost:
        if (r10 != null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.e.x> a(java.util.List<java.lang.String> r10, int r11) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.j.a(java.util.List, int):java.util.List");
    }

    public final void a(int i, String str, int i2, int i3) {
        synchronized (this) {
            x a2 = a(i, str);
            if (a2 != null) {
                a2.b(a2.d() + i2);
                a2.a(a2.c() + i3);
                a(a2);
            }
        }
    }

    public final void a(int i, String str, long j) {
        synchronized (this) {
            x a2 = a(i, str);
            if (a2 != null) {
                a2.a(System.currentTimeMillis() + j);
                a(a2);
            }
        }
    }

    public final void a(String str, int i, String str2) {
        boolean z;
        synchronized (this) {
            Cursor query = a().query(a.a, null, "adsource_id = ? and type = ? and unit_id = ?", new String[]{str, String.valueOf(i), str2}, null, null, null);
            if (query == null || query.getCount() <= 0) {
                z = false;
                if (query != null) {
                    query.close();
                    z = false;
                }
            } else {
                query.close();
                z = true;
            }
            if (!z) {
                b(str, i, str2);
            }
        }
    }
}
