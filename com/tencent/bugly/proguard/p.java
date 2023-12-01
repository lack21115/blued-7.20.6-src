package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.analytics.pro.bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/p.class */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static p f21705a;
    private static q b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f21706c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/p$a.class */
    public final class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private int f21707a;
        private o b;

        /* renamed from: c  reason: collision with root package name */
        private String f21708c;
        private ContentValues d;
        private boolean e;
        private String[] f;
        private String g;
        private String[] h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String[] n;
        private int o;
        private String p;
        private byte[] q;

        public a(int i, o oVar) {
            this.f21707a = i;
            this.b = oVar;
        }

        public final void a(int i, String str, byte[] bArr) {
            this.o = i;
            this.p = str;
            this.q = bArr;
        }

        public final void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.e = z;
            this.f21708c = str;
            this.f = strArr;
            this.g = str2;
            this.h = strArr2;
            this.i = str3;
            this.j = str4;
            this.k = str5;
            this.l = str6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f21707a) {
                case 1:
                    p.this.a(this.f21708c, this.d, this.b);
                    return;
                case 2:
                    p.this.a(this.f21708c, this.m, this.n, this.b);
                    return;
                case 3:
                    Cursor a2 = p.this.a(this.e, this.f21708c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
                    if (a2 != null) {
                        a2.close();
                        return;
                    }
                    return;
                case 4:
                    p.this.a(this.o, this.p, this.q, this.b);
                    return;
                case 5:
                    p.this.a(this.o, this.b);
                    return;
                case 6:
                    p.this.a(this.o, this.p, this.b);
                    return;
                default:
                    return;
            }
        }
    }

    private p(Context context, List<com.tencent.bugly.a> list) {
        b = new q(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r9 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.lang.String r6, java.lang.String r7, java.lang.String[] r8, com.tencent.bugly.proguard.o r9) {
        /*
            r5 = this;
            r0 = r5
            monitor-enter(r0)
            r0 = 0
            r12 = r0
            r0 = 0
            r11 = r0
            r0 = 0
            r10 = r0
            com.tencent.bugly.proguard.q r0 = com.tencent.bugly.proguard.p.b     // Catch: java.lang.Throwable -> L36
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L36
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L22
            r0 = r13
            r1 = r6
            r2 = r7
            r3 = r8
            int r0 = r0.delete(r1, r2, r3)     // Catch: java.lang.Throwable -> L36
            r10 = r0
        L22:
            r0 = r10
            r11 = r0
            r0 = r9
            if (r0 == 0) goto L4e
        L2b:
            r0 = r10
            r11 = r0
            goto L4e
        L32:
            r6 = move-exception
            goto L5b
        L36:
            r6 = move-exception
            r0 = r6
            boolean r0 = com.tencent.bugly.proguard.x.a(r0)     // Catch: java.lang.Throwable -> L53
            if (r0 != 0) goto L42
            r0 = r6
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L53
        L42:
            r0 = r9
            if (r0 == 0) goto L4e
            r0 = r12
            r10 = r0
            goto L2b
        L4e:
            r0 = r5
            monitor-exit(r0)
            r0 = r11
            return r0
        L53:
            r6 = move-exception
            r0 = r9
            if (r0 == 0) goto L59
        L59:
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L32
        L5b:
            r0 = r5
            monitor-exit(r0)
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(java.lang.String, java.lang.String, java.lang.String[], com.tencent.bugly.proguard.o):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r9 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r7, android.content.ContentValues r8, com.tencent.bugly.proguard.o r9) {
        /*
            r6 = this;
            r0 = r6
            monitor-enter(r0)
            r0 = 0
            r12 = r0
            com.tencent.bugly.proguard.q r0 = com.tencent.bugly.proguard.p.b     // Catch: java.lang.Throwable -> L62
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L62
            r16 = r0
            r0 = r12
            r10 = r0
            r0 = r16
            if (r0 == 0) goto L4f
            r0 = r12
            r10 = r0
            r0 = r8
            if (r0 == 0) goto L4f
            r0 = r16
            r1 = r7
            java.lang.String r2 = "_id"
            r3 = r8
            long r0 = r0.replace(r1, r2, r3)     // Catch: java.lang.Throwable -> L62
            r10 = r0
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L41
            java.lang.String r0 = "[Database] insert %s success."
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L62
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4     // Catch: java.lang.Throwable -> L62
            boolean r0 = com.tencent.bugly.proguard.x.c(r0, r1)     // Catch: java.lang.Throwable -> L62
            goto L4f
        L41:
            java.lang.String r0 = "[Database] replace %s error."
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L62
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4     // Catch: java.lang.Throwable -> L62
            boolean r0 = com.tencent.bugly.proguard.x.d(r0, r1)     // Catch: java.lang.Throwable -> L62
        L4f:
            r0 = r10
            r14 = r0
            r0 = r9
            if (r0 == 0) goto L7d
        L57:
            r0 = r10
            r14 = r0
            goto L7d
        L5e:
            r7 = move-exception
            goto L89
        L62:
            r7 = move-exception
            r0 = r7
            boolean r0 = com.tencent.bugly.proguard.x.a(r0)     // Catch: java.lang.Throwable -> L82
            if (r0 != 0) goto L6e
            r0 = r7
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L82
        L6e:
            r0 = r12
            r14 = r0
            r0 = r9
            if (r0 == 0) goto L7d
            r0 = r12
            r10 = r0
            goto L57
        L7d:
            r0 = r6
            monitor-exit(r0)
            r0 = r14
            return r0
        L82:
            r7 = move-exception
            r0 = r9
            if (r0 == 0) goto L87
        L87:
            r0 = r7
            throw r0     // Catch: java.lang.Throwable -> L5e
        L89:
            r0 = r6
            monitor-exit(r0)
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(java.lang.String, android.content.ContentValues, com.tencent.bugly.proguard.o):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, o oVar) {
        Cursor cursor;
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                cursor = null;
                if (writableDatabase != null) {
                    cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
                }
            } catch (Throwable th) {
                cursor = null;
                try {
                    if (!x.a(th)) {
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

    public static p a() {
        p pVar;
        synchronized (p.class) {
            try {
                pVar = f21705a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    public static p a(Context context, List<com.tencent.bugly.a> list) {
        p pVar;
        synchronized (p.class) {
            try {
                if (f21705a == null) {
                    f21705a = new p(context, list);
                }
                pVar = f21705a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    private static r a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.f21711a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.b = cursor.getInt(cursor.getColumnIndex(bl.e));
            rVar.f21712c = cursor.getString(cursor.getColumnIndex("_pc"));
            rVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            rVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, byte[]> a(int i, o oVar) {
        HashMap hashMap = null;
        HashMap hashMap2 = null;
        try {
            List<r> c2 = c(i);
            if (c2 != null) {
                HashMap hashMap3 = new HashMap();
                try {
                    for (r rVar : c2) {
                        byte[] bArr = rVar.g;
                        if (bArr != null) {
                            hashMap3.put(rVar.f, bArr);
                        }
                    }
                    return hashMap3;
                } catch (Throwable th) {
                    th = th;
                    hashMap2 = hashMap3;
                    hashMap = hashMap2;
                    if (!x.a(th)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a2, code lost:
        if (r9 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r7, java.lang.String r8, com.tencent.bugly.proguard.o r9) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(int, java.lang.String, com.tencent.bugly.proguard.o):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0038, code lost:
        if (r8 != null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r5, java.lang.String r6, byte[] r7, com.tencent.bugly.proguard.o r8) {
        /*
            r4 = this;
            r0 = 0
            r10 = r0
            r0 = 0
            r11 = r0
            com.tencent.bugly.proguard.r r0 = new com.tencent.bugly.proguard.r     // Catch: java.lang.Throwable -> L3e
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L3e
            r12 = r0
            r0 = r12
            r1 = r5
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L3e
            r0.f21711a = r1     // Catch: java.lang.Throwable -> L3e
            r0 = r12
            r1 = r6
            r0.f = r1     // Catch: java.lang.Throwable -> L3e
            r0 = r12
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3e
            r0.e = r1     // Catch: java.lang.Throwable -> L3e
            r0 = r12
            r1 = r7
            r0.g = r1     // Catch: java.lang.Throwable -> L3e
            r0 = r4
            r1 = r12
            boolean r0 = r0.b(r1)     // Catch: java.lang.Throwable -> L3e
            r9 = r0
            r0 = r9
            r10 = r0
            r0 = r8
            if (r0 == 0) goto L56
        L3b:
            r0 = r9
            return r0
        L3e:
            r6 = move-exception
            r0 = r6
            boolean r0 = com.tencent.bugly.proguard.x.a(r0)     // Catch: java.lang.Throwable -> L59
            if (r0 != 0) goto L4a
            r0 = r6
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L59
        L4a:
            r0 = r8
            if (r0 == 0) goto L56
            r0 = r11
            r9 = r0
            goto L3b
        L56:
            r0 = r10
            return r0
        L59:
            r6 = move-exception
            r0 = r8
            if (r0 == 0) goto L5f
        L5f:
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(int, java.lang.String, byte[], com.tencent.bugly.proguard.o):boolean");
    }

    private static r b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.f21711a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.f = cursor.getString(cursor.getColumnIndex(bl.e));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private boolean b(r rVar) {
        ContentValues d;
        synchronized (this) {
            if (rVar == null) {
                return false;
            }
            try {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase == null || (d = d(rVar)) == null) {
                    return false;
                }
                long replace = writableDatabase.replace("t_pf", "_id", d);
                if (replace >= 0) {
                    x.c("[Database] insert %s success.", "t_pf");
                    rVar.f21711a = replace;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    return false;
                } finally {
                }
            }
        }
    }

    private static ContentValues c(r rVar) {
        if (rVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (rVar.f21711a > 0) {
                contentValues.put("_id", Long.valueOf(rVar.f21711a));
            }
            contentValues.put(bl.e, Integer.valueOf(rVar.b));
            contentValues.put("_pc", rVar.f21712c);
            contentValues.put("_th", rVar.d);
            contentValues.put("_tm", Long.valueOf(rVar.e));
            if (rVar.g != null) {
                contentValues.put("_dt", rVar.g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private List<r> c(int i) {
        Cursor cursor;
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase != null) {
                    String str = "_id = " + i;
                    cursor = writableDatabase.query("t_pf", null, str, null, null, null, null);
                    if (cursor == null) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                    try {
                        StringBuilder sb = new StringBuilder();
                        ArrayList arrayList = new ArrayList();
                        while (cursor.moveToNext()) {
                            r b2 = b(cursor);
                            if (b2 != null) {
                                arrayList.add(b2);
                            } else {
                                String string = cursor.getString(cursor.getColumnIndex(bl.e));
                                sb.append(" or _tp");
                                sb.append(" = ");
                                sb.append(string);
                            }
                        }
                        if (sb.length() > 0) {
                            sb.append(" and _id");
                            sb.append(" = ");
                            sb.append(i);
                            x.d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            return null;
        }
    }

    private static ContentValues d(r rVar) {
        if (rVar == null || z.a(rVar.f)) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (rVar.f21711a > 0) {
                contentValues.put("_id", Long.valueOf(rVar.f21711a));
            }
            contentValues.put(bl.e, rVar.f);
            contentValues.put("_tm", Long.valueOf(rVar.e));
            if (rVar.g != null) {
                contentValues.put("_dt", rVar.g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final int a(String str, String str2, String[] strArr, o oVar, boolean z) {
        return a(str, str2, (String[]) null, (o) null);
    }

    public final long a(String str, ContentValues contentValues, o oVar, boolean z) {
        return a(str, contentValues, (o) null);
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, o oVar, boolean z) {
        return a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0116 A[Catch: all -> 0x012a, TryCatch #4 {, blocks: (B:4:0x0002, B:13:0x004b, B:32:0x0100, B:43:0x0120, B:38:0x010e, B:40:0x0116), top: B:68:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0120 A[Catch: all -> 0x013f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0002, B:13:0x004b, B:32:0x0100, B:43:0x0120, B:38:0x010e, B:40:0x0116), top: B:68:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.tencent.bugly.proguard.r> a(int r10) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(int):java.util.List");
    }

    public final Map<String, byte[]> a(int i, o oVar, boolean z) {
        return a(i, (o) null);
    }

    public final void a(List<r> list) {
        synchronized (this) {
            if (list != null) {
                if (list.size() != 0) {
                    SQLiteDatabase writableDatabase = b.getWritableDatabase();
                    if (writableDatabase != null) {
                        StringBuilder sb = new StringBuilder();
                        for (r rVar : list) {
                            sb.append(" or _id");
                            sb.append(" = ");
                            sb.append(rVar.f21711a);
                        }
                        String sb2 = sb.toString();
                        String str = sb2;
                        if (sb2.length() > 0) {
                            str = sb2.substring(4);
                        }
                        sb.setLength(0);
                        x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
                    }
                }
            }
        }
    }

    public final boolean a(int i, String str, byte[] bArr, o oVar, boolean z) {
        if (z) {
            return a(i, str, bArr, (o) null);
        }
        a aVar = new a(4, null);
        aVar.a(i, str, bArr);
        w.a().a(aVar);
        return true;
    }

    public final boolean a(r rVar) {
        ContentValues c2;
        synchronized (this) {
            if (rVar == null) {
                return false;
            }
            try {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase == null || (c2 = c(rVar)) == null) {
                    return false;
                }
                long replace = writableDatabase.replace("t_lr", "_id", c2);
                if (replace >= 0) {
                    x.c("[Database] insert %s success.", "t_lr");
                    rVar.f21711a = replace;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    return false;
                } finally {
                }
            }
        }
    }

    public final void b(int i) {
        String str;
        synchronized (this) {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                if (i >= 0) {
                    str = "_tp = " + i;
                } else {
                    str = null;
                }
                x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
            }
        }
    }
}
