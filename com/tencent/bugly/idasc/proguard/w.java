package com.tencent.bugly.idasc.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/w.class */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35347a = false;
    private static w b;

    /* renamed from: c  reason: collision with root package name */
    private static x f35348c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/w$a.class */
    public final class a extends Thread {
        private int b = 4;

        /* renamed from: c  reason: collision with root package name */
        private v f35350c = null;
        private String d;
        private ContentValues e;
        private boolean f;
        private String[] g;
        private String h;
        private String[] i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String[] o;
        private int p;
        private String q;
        private byte[] r;

        public a() {
        }

        public final void a(int i, String str, byte[] bArr) {
            this.p = i;
            this.q = str;
            this.r = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.b) {
                case 1:
                    w.this.a(this.d, this.e, this.f35350c);
                    return;
                case 2:
                    w.this.a(this.d, this.n, this.o, this.f35350c);
                    return;
                case 3:
                    Cursor a2 = w.this.a(this.f, this.d, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f35350c);
                    if (a2 != null) {
                        a2.close();
                        return;
                    }
                    return;
                case 4:
                    w.this.a(this.p, this.q, this.r, this.f35350c);
                    return;
                case 5:
                    w.this.a(this.p, this.f35350c);
                    return;
                case 6:
                    w.this.a(this.p, this.q, this.f35350c);
                    return;
                default:
                    return;
            }
        }
    }

    private w(Context context, List<o> list) {
        f35348c = new x(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, String str2, String[] strArr, v vVar) {
        int i;
        synchronized (this) {
            int i2 = 0;
            SQLiteDatabase writableDatabase = f35348c.getWritableDatabase();
            if (writableDatabase != null) {
                i2 = writableDatabase.delete(str, str2, strArr);
            }
            if (vVar != null) {
            }
            i = i2;
            if (f35347a) {
                i = i2;
                if (writableDatabase != null) {
                    writableDatabase.close();
                    i = i2;
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, v vVar) {
        Cursor cursor;
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = f35348c.getWritableDatabase();
                cursor = null;
                if (writableDatabase != null) {
                    cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
                }
            } catch (Throwable th) {
                cursor = null;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                        cursor = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return cursor;
    }

    public static w a() {
        w wVar;
        synchronized (w.class) {
            try {
                wVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    public static w a(Context context, List<o> list) {
        w wVar;
        synchronized (w.class) {
            try {
                if (b == null) {
                    b = new w(context, list);
                }
                wVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    private static y a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f35353a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.b = cursor.getInt(cursor.getColumnIndex(com.umeng.analytics.pro.bl.e));
            yVar.f35354c = cursor.getString(cursor.getColumnIndex("_pc"));
            yVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            yVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str, v vVar) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        String str2;
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = f35348c.getWritableDatabase();
                boolean z2 = false;
                if (writableDatabase != null) {
                    try {
                        if (ap.b(str)) {
                            str2 = "_id = ".concat(String.valueOf(i));
                        } else {
                            str2 = "_id = " + i + " and _tp = \"" + str + "\"";
                        }
                        int delete = writableDatabase.delete("t_pf", str2, null);
                        al.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                        z2 = false;
                        if (delete > 0) {
                            z2 = true;
                        }
                    } catch (Throwable th) {
                        sQLiteDatabase = writableDatabase;
                        th = th;
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (vVar != null) {
                            Boolean bool = Boolean.FALSE;
                        }
                        z = false;
                        if (f35347a) {
                            z = false;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                                z = false;
                            }
                        }
                        return z;
                    }
                }
                if (vVar != null) {
                }
                z = z2;
                if (f35347a) {
                    z = z2;
                    if (writableDatabase != null) {
                        writableDatabase.close();
                        z = z2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = null;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str, byte[] bArr, v vVar) {
        boolean z;
        try {
            y yVar = new y();
            yVar.f35353a = i;
            yVar.f = str;
            yVar.e = System.currentTimeMillis();
            yVar.g = bArr;
            boolean b2 = b(yVar);
            z = b2;
            if (vVar != null) {
                return b2;
            }
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                z = false;
            } finally {
                if (vVar != null) {
                    Boolean bool = Boolean.FALSE;
                }
            }
        }
        return z;
    }

    private static y b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f35353a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f = cursor.getString(cursor.getColumnIndex(com.umeng.analytics.pro.bl.e));
            yVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private boolean b(y yVar) {
        ContentValues d;
        synchronized (this) {
            SQLiteDatabase writableDatabase = f35348c.getWritableDatabase();
            if (writableDatabase == null || (d = d(yVar)) == null) {
                if (f35347a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            long replace = writableDatabase.replace("t_pf", "_id", d);
            if (replace < 0) {
                if (f35347a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            al.c("[Database] insert %s success.", "t_pf");
            yVar.f35353a = replace;
            if (f35347a && writableDatabase != null) {
                writableDatabase.close();
            }
            return true;
        }
    }

    private static ContentValues c(y yVar) {
        if (yVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (yVar.f35353a > 0) {
                contentValues.put("_id", Long.valueOf(yVar.f35353a));
            }
            contentValues.put(com.umeng.analytics.pro.bl.e, Integer.valueOf(yVar.b));
            contentValues.put("_pc", yVar.f35354c);
            contentValues.put("_th", yVar.d);
            contentValues.put("_tm", Long.valueOf(yVar.e));
            if (yVar.g != null) {
                contentValues.put("_dt", yVar.g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0121, code lost:
        if (r12 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0124, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0158, code lost:
        if (r12 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.tencent.bugly.idasc.proguard.y> c(int r10) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.w.c(int):java.util.List");
    }

    private static ContentValues d(y yVar) {
        if (yVar == null || ap.b(yVar.f)) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (yVar.f35353a > 0) {
                contentValues.put("_id", Long.valueOf(yVar.f35353a));
            }
            contentValues.put(com.umeng.analytics.pro.bl.e, yVar.f);
            contentValues.put("_tm", Long.valueOf(yVar.e));
            if (yVar.g != null) {
                contentValues.put("_dt", yVar.g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final int a(String str, String str2) {
        return a(str, str2, (String[]) null, (v) null);
    }

    public final long a(String str, ContentValues contentValues, v vVar) {
        long j;
        synchronized (this) {
            SQLiteDatabase writableDatabase = f35348c.getWritableDatabase();
            long j2 = -1;
            if (writableDatabase != null) {
                j2 = -1;
                if (contentValues != null) {
                    j2 = writableDatabase.replace(str, "_id", contentValues);
                    if (j2 >= 0) {
                        al.c("[Database] insert %s success.", str);
                    } else {
                        al.d("[Database] replace %s error.", str);
                    }
                }
            }
            if (vVar != null) {
            }
            j = j2;
            if (f35347a) {
                j = j2;
                if (writableDatabase != null) {
                    writableDatabase.close();
                    j = j2;
                }
            }
        }
        return j;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        return a(str, strArr, str2, (String) null, (String) null);
    }

    public final Cursor a(String str, String[] strArr, String str2, String str3, String str4) {
        return a(false, str, strArr, str2, null, null, null, str3, str4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x011f A[Catch: all -> 0x0143, TryCatch #3 {, blocks: (B:4:0x0002, B:13:0x003d, B:14:0x0044, B:18:0x004f, B:37:0x00f9, B:38:0x0100, B:42:0x010b, B:53:0x0129, B:54:0x0130, B:58:0x013b, B:48:0x0117, B:50:0x011f), top: B:86:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0129 A[Catch: all -> 0x0168, TRY_ENTER, TryCatch #3 {, blocks: (B:4:0x0002, B:13:0x003d, B:14:0x0044, B:18:0x004f, B:37:0x00f9, B:38:0x0100, B:42:0x010b, B:53:0x0129, B:54:0x0130, B:58:0x013b, B:48:0x0117, B:50:0x011f), top: B:86:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.tencent.bugly.idasc.proguard.y> a(int r10) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.w.a(int):java.util.List");
    }

    public final Map<String, byte[]> a(int i, v vVar) {
        HashMap hashMap = null;
        HashMap hashMap2 = null;
        try {
            List<y> c2 = c(i);
            if (c2 != null) {
                HashMap hashMap3 = new HashMap();
                try {
                    for (y yVar : c2) {
                        byte[] bArr = yVar.g;
                        if (bArr != null) {
                            hashMap3.put(yVar.f, bArr);
                        }
                    }
                    return hashMap3;
                } catch (Throwable th) {
                    th = th;
                    hashMap2 = hashMap3;
                    hashMap = hashMap2;
                    if (!al.a(th)) {
                        th.printStackTrace();
                        hashMap = hashMap2;
                    }
                    return hashMap;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return hashMap;
    }

    public final void a(List<y> list) {
        synchronized (this) {
            if (list != null) {
                if (list.size() != 0) {
                    SQLiteDatabase writableDatabase = f35348c.getWritableDatabase();
                    if (writableDatabase != null) {
                        StringBuilder sb = new StringBuilder();
                        for (y yVar : list) {
                            sb.append(" or _id = ");
                            sb.append(yVar.f35353a);
                        }
                        String sb2 = sb.toString();
                        String str = sb2;
                        if (sb2.length() > 0) {
                            str = sb2.substring(4);
                        }
                        sb.setLength(0);
                        al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
                        if (f35347a) {
                            writableDatabase.close();
                        }
                    }
                }
            }
        }
    }

    public final boolean a(int i, String str, byte[] bArr, boolean z) {
        if (z) {
            return a(i, str, bArr, (v) null);
        }
        a aVar = new a();
        aVar.a(i, str, bArr);
        ak.a().a(aVar);
        return true;
    }

    public final boolean a(y yVar) {
        ContentValues c2;
        synchronized (this) {
            SQLiteDatabase writableDatabase = f35348c.getWritableDatabase();
            if (writableDatabase == null || (c2 = c(yVar)) == null) {
                if (f35347a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            long replace = writableDatabase.replace("t_lr", "_id", c2);
            if (replace < 0) {
                if (f35347a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            al.c("[Database] insert %s success.", "t_lr");
            yVar.f35353a = replace;
            if (f35347a && writableDatabase != null) {
                writableDatabase.close();
            }
            return true;
        }
    }

    public final void b(int i) {
        synchronized (this) {
            SQLiteDatabase writableDatabase = f35348c.getWritableDatabase();
            if (writableDatabase != null) {
                al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", i >= 0 ? "_tp = ".concat(String.valueOf(i)) : null, null)));
                if (f35347a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }
}
