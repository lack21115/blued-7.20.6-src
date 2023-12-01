package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.e.af;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/d.class */
public class d extends com.anythink.core.common.c.a<af> {
    private static final String b = d.class.getName();
    private static volatile d c;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/d$a.class */
    public static final class a {
        public static final String a = "sdkconfig";
        public static final String b = "key";
        public static final String c = "type";
        public static final String d = "value";
        public static final String e = "lastupdatetime";
        public static final String f = "CREATE TABLE IF NOT EXISTS sdkconfig(key TEXT ,type TEXT ,lastupdatetime TEXT ,value TEXT )";
    }

    private d(b bVar) {
        super(bVar);
    }

    private long a(af afVar) {
        synchronized (this) {
            if (b() == null || afVar == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.b, afVar.b());
                contentValues.put("type", afVar.c());
                contentValues.put(a.d, afVar.d());
                contentValues.put(a.e, afVar.a());
                if (b(afVar.b(), afVar.a(), afVar.c())) {
                    return b().update(a.a, contentValues, "key = ? AND type = ? AND lastupdatetime = ?  ", new String[]{afVar.b(), afVar.c(), afVar.a()});
                }
                return b().insert(a.a, null, contentValues);
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    public static d a(b bVar) {
        if (c == null) {
            synchronized (d.class) {
                try {
                    if (c == null) {
                        c = new d(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    private List<af> a(Cursor cursor) {
        synchronized (this) {
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        af afVar = new af();
                        afVar.b(cursor.getString(cursor.getColumnIndex(a.b)));
                        afVar.c(cursor.getString(cursor.getColumnIndex("type")));
                        afVar.d(cursor.getString(cursor.getColumnIndex(a.d)));
                        afVar.a(cursor.getString(cursor.getColumnIndex(a.e)));
                        arrayList.add(afVar);
                    }
                    cursor.close();
                    return arrayList;
                }
            }
            return null;
        }
    }

    private void a(String str) {
        synchronized (this) {
            try {
                if (b() == null) {
                    return;
                }
                b().delete(a.a, "lastupdatetime< ? and type = ?", new String[]{str, af.a.a});
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r10 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r10 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        if (r10 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006c, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.anythink.core.common.e.af> b(java.lang.String r10) {
        /*
            r9 = this;
            r0 = r9
            monitor-enter(r0)
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: java.lang.Exception -> L6e java.lang.OutOfMemoryError -> L72 java.lang.Throwable -> L76
            java.lang.String r1 = "sdkconfig"
            r2 = 0
            java.lang.String r3 = "type = ?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L6e java.lang.OutOfMemoryError -> L72 java.lang.Throwable -> L76
            r5 = r4
            r6 = 0
            r7 = r10
            r5[r6] = r7     // Catch: java.lang.Exception -> L6e java.lang.OutOfMemoryError -> L72 java.lang.Throwable -> L76
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L6e java.lang.OutOfMemoryError -> L72 java.lang.Throwable -> L76
            r10 = r0
            r0 = r9
            r1 = r10
            java.util.List r0 = r0.a(r1)     // Catch: java.lang.Exception -> L7a java.lang.OutOfMemoryError -> L7e java.lang.Throwable -> L82
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L2a
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L65
        L2a:
            r0 = r9
            monitor-exit(r0)
            r0 = r11
            return r0
        L2e:
            goto L36
        L31:
            goto L5e
        L34:
            r0 = 0
            r10 = r0
        L36:
            r0 = r10
            if (r0 == 0) goto L6a
            goto L62
        L3d:
            r0 = 0
            r10 = r0
        L3f:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L4f
            r0 = r10
            if (r0 == 0) goto L6a
        L46:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L65
            goto L6a
        L4f:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L5a
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L65
        L5a:
            r0 = r11
            throw r0     // Catch: java.lang.Throwable -> L65
        L5c:
            r0 = 0
            r10 = r0
        L5e:
            r0 = r10
            if (r0 == 0) goto L6a
        L62:
            goto L46
        L65:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        L6a:
            r0 = r9
            monitor-exit(r0)
            r0 = 0
            return r0
        L6e:
            r10 = move-exception
            goto L5c
        L72:
            r10 = move-exception
            goto L3d
        L76:
            r10 = move-exception
            goto L34
        L7a:
            r11 = move-exception
            goto L31
        L7e:
            r11 = move-exception
            goto L3f
        L82:
            r11 = move-exception
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.d.b(java.lang.String):java.util.List");
    }

    private boolean b(String str, String str2) {
        synchronized (this) {
            Cursor query = a().query(a.a, new String[]{a.b}, "key=? AND type=?", new String[]{str, str2}, null, null, null);
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

    private boolean b(String str, String str2, String str3) {
        synchronized (this) {
            Cursor query = a().query(a.a, new String[]{a.b}, "key=? AND type=? AND lastupdatetime=?", new String[]{str, str3, str2}, null, null, null);
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

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0074, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.anythink.core.common.e.af> c(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            r0 = r9
            monitor-enter(r0)
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: java.lang.Exception -> L76 java.lang.OutOfMemoryError -> L7a java.lang.Throwable -> L7e
            java.lang.String r1 = "sdkconfig"
            r2 = 0
            java.lang.String r3 = "key = ? and type = ? and lastupdatetime = ?"
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L76 java.lang.OutOfMemoryError -> L7a java.lang.Throwable -> L7e
            r5 = r4
            r6 = 0
            r7 = r10
            r5[r6] = r7     // Catch: java.lang.Exception -> L76 java.lang.OutOfMemoryError -> L7a java.lang.Throwable -> L7e
            r5 = r4
            r6 = 1
            r7 = r12
            r5[r6] = r7     // Catch: java.lang.Exception -> L76 java.lang.OutOfMemoryError -> L7a java.lang.Throwable -> L7e
            r5 = r4
            r6 = 2
            r7 = r11
            r5[r6] = r7     // Catch: java.lang.Exception -> L76 java.lang.OutOfMemoryError -> L7a java.lang.Throwable -> L7e
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L76 java.lang.OutOfMemoryError -> L7a java.lang.Throwable -> L7e
            r10 = r0
            r0 = r9
            r1 = r10
            java.util.List r0 = r0.a(r1)     // Catch: java.lang.Exception -> L82 java.lang.OutOfMemoryError -> L86 java.lang.Throwable -> L8a
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L32
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L6d
        L32:
            r0 = r9
            monitor-exit(r0)
            r0 = r11
            return r0
        L36:
            goto L3e
        L39:
            goto L66
        L3c:
            r0 = 0
            r10 = r0
        L3e:
            r0 = r10
            if (r0 == 0) goto L72
            goto L6a
        L45:
            r0 = 0
            r10 = r0
        L47:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L57
            r0 = r10
            if (r0 == 0) goto L72
        L4e:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L6d
            goto L72
        L57:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L62
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L6d
        L62:
            r0 = r11
            throw r0     // Catch: java.lang.Throwable -> L6d
        L64:
            r0 = 0
            r10 = r0
        L66:
            r0 = r10
            if (r0 == 0) goto L72
        L6a:
            goto L4e
        L6d:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        L72:
            r0 = r9
            monitor-exit(r0)
            r0 = 0
            return r0
        L76:
            r10 = move-exception
            goto L64
        L7a:
            r10 = move-exception
            goto L45
        L7e:
            r10 = move-exception
            goto L3c
        L82:
            r11 = move-exception
            goto L39
        L86:
            r11 = move-exception
            goto L47
        L8a:
            r11 = move-exception
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.d.c(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    private void c(String str, String str2) {
        synchronized (this) {
            List<af> c2 = c(str, str2, af.a.a);
            if (c2 == null || c2.size() <= 0) {
                af afVar = new af();
                afVar.a(str2);
                afVar.d("1");
                afVar.c(af.a.a);
                afVar.b(str);
                a(afVar);
                return;
            }
            for (af afVar2 : c2) {
                StringBuilder sb = new StringBuilder();
                sb.append(Integer.parseInt(afVar2.d()) + 1);
                afVar2.d(sb.toString());
                a(afVar2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.anythink.core.common.e.af> d(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = r9
            monitor-enter(r0)
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            java.lang.String r1 = "sdkconfig"
            r2 = 0
            java.lang.String r3 = "key != ? and type = ?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            r5 = r4
            r6 = 0
            r7 = r10
            r5[r6] = r7     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            r5 = r4
            r6 = 1
            r7 = r11
            r5[r6] = r7     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            r10 = r0
            r0 = r9
            r1 = r10
            java.util.List r0 = r0.a(r1)     // Catch: java.lang.Exception -> L7e java.lang.OutOfMemoryError -> L82 java.lang.Throwable -> L86
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L2e
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L69
        L2e:
            r0 = r9
            monitor-exit(r0)
            r0 = r11
            return r0
        L32:
            goto L3a
        L35:
            goto L62
        L38:
            r0 = 0
            r10 = r0
        L3a:
            r0 = r10
            if (r0 == 0) goto L6e
            goto L66
        L41:
            r0 = 0
            r10 = r0
        L43:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L53
            r0 = r10
            if (r0 == 0) goto L6e
        L4a:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L69
            goto L6e
        L53:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L5e
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L69
        L5e:
            r0 = r11
            throw r0     // Catch: java.lang.Throwable -> L69
        L60:
            r0 = 0
            r10 = r0
        L62:
            r0 = r10
            if (r0 == 0) goto L6e
        L66:
            goto L4a
        L69:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        L6e:
            r0 = r9
            monitor-exit(r0)
            r0 = 0
            return r0
        L72:
            r10 = move-exception
            goto L60
        L76:
            r10 = move-exception
            goto L41
        L7a:
            r10 = move-exception
            goto L38
        L7e:
            r11 = move-exception
            goto L35
        L82:
            r11 = move-exception
            goto L43
        L86:
            r11 = move-exception
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.d.d(java.lang.String, java.lang.String):java.util.List");
    }

    public final long a(String str, String str2, String str3) {
        synchronized (this) {
            if (b() == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.b, str);
                contentValues.put("type", str3);
                contentValues.put(a.d, str2);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                contentValues.put(a.e, sb.toString());
                if (b(str, str3)) {
                    return b().update(a.a, contentValues, "key = ? AND type = ?", new String[]{str, str3});
                }
                return b().insert(a.a, null, contentValues);
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.e.af> a(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = r9
            monitor-enter(r0)
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            java.lang.String r1 = "sdkconfig"
            r2 = 0
            java.lang.String r3 = "key = ? and type = ?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            r5 = r4
            r6 = 0
            r7 = r10
            r5[r6] = r7     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            r5 = r4
            r6 = 1
            r7 = r11
            r5[r6] = r7     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L76 java.lang.Throwable -> L7a
            r10 = r0
            r0 = r9
            r1 = r10
            java.util.List r0 = r0.a(r1)     // Catch: java.lang.Exception -> L7e java.lang.OutOfMemoryError -> L82 java.lang.Throwable -> L86
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L2e
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L69
        L2e:
            r0 = r9
            monitor-exit(r0)
            r0 = r11
            return r0
        L32:
            goto L3a
        L35:
            goto L62
        L38:
            r0 = 0
            r10 = r0
        L3a:
            r0 = r10
            if (r0 == 0) goto L6e
            goto L66
        L41:
            r0 = 0
            r10 = r0
        L43:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L53
            r0 = r10
            if (r0 == 0) goto L6e
        L4a:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L69
            goto L6e
        L53:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L5e
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L69
        L5e:
            r0 = r11
            throw r0     // Catch: java.lang.Throwable -> L69
        L60:
            r0 = 0
            r10 = r0
        L62:
            r0 = r10
            if (r0 == 0) goto L6e
        L66:
            goto L4a
        L69:
            r10 = move-exception
            r0 = r9
            monitor-exit(r0)
            r0 = r10
            throw r0
        L6e:
            r0 = r9
            monitor-exit(r0)
            r0 = 0
            return r0
        L72:
            r10 = move-exception
            goto L60
        L76:
            r10 = move-exception
            goto L41
        L7a:
            r10 = move-exception
            goto L38
        L7e:
            r11 = move-exception
            goto L35
        L82:
            r11 = move-exception
            goto L43
        L86:
            r11 = move-exception
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.d.a(java.lang.String, java.lang.String):java.util.List");
    }
}
