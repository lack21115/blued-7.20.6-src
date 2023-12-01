package com.tencent.tendinsv.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tendinsv.a.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/a/e.class */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private f f38993a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38994c;

    public e(Context context) {
        this.f38993a = f.a(context);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        synchronized (this) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void a(com.tencent.tendinsv.tool.e eVar, long j, long j2, int i, SQLiteDatabase sQLiteDatabase) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("count", Integer.valueOf(eVar.v + 1));
            contentValues.put("costTime", Long.valueOf(eVar.o + j));
            contentValues.put(b.a.y, Long.valueOf(eVar.p + j2));
            sQLiteDatabase.update(f.b, contentValues, "id=?", new String[]{"" + i});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(String str, long j, long j2, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        try {
            try {
                try {
                    ArrayList arrayList = new ArrayList();
                    String valueOf = String.valueOf(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append("select * from login_behavior where sid = '");
                    sb.append(valueOf);
                    sb.append("'");
                    cursor = sQLiteDatabase.rawQuery(sb.toString(), null);
                    try {
                        if (cursor.moveToLast()) {
                            com.tencent.tendinsv.tool.e eVar = new com.tencent.tendinsv.tool.e();
                            eVar.f39051a = cursor.getString(cursor.getColumnIndex("DID"));
                            eVar.b = cursor.getString(cursor.getColumnIndex(b.a.o));
                            eVar.f39052c = cursor.getString(cursor.getColumnIndex(b.a.g));
                            eVar.d = cursor.getString(cursor.getColumnIndex(b.a.l));
                            eVar.e = cursor.getString(cursor.getColumnIndex(b.a.m));
                            eVar.f = cursor.getString(cursor.getColumnIndex("sdkVersion"));
                            eVar.g = cursor.getString(cursor.getColumnIndex("uuid"));
                            eVar.h = cursor.getString(cursor.getColumnIndex(b.a.q));
                            eVar.i = cursor.getString(cursor.getColumnIndex("network"));
                            eVar.j = cursor.getString(cursor.getColumnIndex(b.a.s));
                            eVar.k = cursor.getString(cursor.getColumnIndex(b.a.t));
                            eVar.l = cursor.getString(cursor.getColumnIndex(b.a.u));
                            eVar.m = cursor.getInt(cursor.getColumnIndex("method"));
                            eVar.n = cursor.getLong(cursor.getColumnIndex("beginTime"));
                            eVar.o = cursor.getLong(cursor.getColumnIndex("costTime"));
                            eVar.p = cursor.getLong(cursor.getColumnIndex(b.a.y));
                            eVar.q = cursor.getInt(cursor.getColumnIndex("status"));
                            eVar.r = cursor.getString(cursor.getColumnIndex(b.a.A));
                            eVar.s = cursor.getString(cursor.getColumnIndex(b.a.B));
                            eVar.t = cursor.getInt(cursor.getColumnIndex(b.a.C));
                            eVar.u = cursor.getString(cursor.getColumnIndex(b.a.D));
                            eVar.v = cursor.getInt(cursor.getColumnIndex("count"));
                            eVar.w = cursor.getString(cursor.getColumnIndex("sid"));
                            arrayList.add(eVar);
                            i = cursor.getInt(cursor.getColumnIndex("id"));
                        } else {
                            i = 0;
                        }
                        if (arrayList.size() > 0) {
                            a((com.tencent.tendinsv.tool.e) arrayList.get(0), j, j2, i, sQLiteDatabase);
                            this.f38994c = false;
                        } else {
                            this.f38994c = true;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor2 = cursor;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private SQLiteDatabase d() {
        SQLiteDatabase writableDatabase;
        synchronized (this) {
            writableDatabase = this.f38993a.getWritableDatabase();
        }
        return writableDatabase;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0197 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.tendinsv.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.tencent.tendinsv.tool.f> a() {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.a.e.a():java.util.List");
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x02f1: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:90:0x02f1 */
    @Override // com.tencent.tendinsv.a.d
    public List<com.tencent.tendinsv.tool.e> a(String str) {
        SQLiteDatabase sQLiteDatabase;
        AutoCloseable autoCloseable;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        try {
            try {
                sQLiteDatabase = d();
            } catch (Exception e) {
                e = e;
                cursor = null;
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = null;
                autoCloseable = null;
            }
            try {
                cursor = sQLiteDatabase.query(f.b, null, null, null, null, null, "id ASC", str);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                autoCloseable = null;
                if (autoCloseable != null) {
                    try {
                        autoCloseable.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                a(sQLiteDatabase);
                throw th;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    com.tencent.tendinsv.tool.e eVar = new com.tencent.tendinsv.tool.e();
                    eVar.f39051a = cursor.getString(cursor.getColumnIndex("DID"));
                    eVar.b = cursor.getString(cursor.getColumnIndex(b.a.o));
                    eVar.f39052c = cursor.getString(cursor.getColumnIndex(b.a.g));
                    eVar.d = cursor.getString(cursor.getColumnIndex(b.a.l));
                    eVar.e = cursor.getString(cursor.getColumnIndex(b.a.m));
                    eVar.f = cursor.getString(cursor.getColumnIndex("sdkVersion"));
                    eVar.g = cursor.getString(cursor.getColumnIndex("uuid"));
                    eVar.h = cursor.getString(cursor.getColumnIndex(b.a.q));
                    eVar.i = cursor.getString(cursor.getColumnIndex("network"));
                    eVar.j = cursor.getString(cursor.getColumnIndex(b.a.s));
                    eVar.k = cursor.getString(cursor.getColumnIndex(b.a.t));
                    eVar.l = cursor.getString(cursor.getColumnIndex(b.a.u));
                    eVar.m = cursor.getInt(cursor.getColumnIndex("method"));
                    eVar.n = cursor.getLong(cursor.getColumnIndex("beginTime"));
                    eVar.o = cursor.getLong(cursor.getColumnIndex("costTime"));
                    eVar.p = cursor.getLong(cursor.getColumnIndex(b.a.y));
                    eVar.q = cursor.getInt(cursor.getColumnIndex("status"));
                    eVar.r = cursor.getString(cursor.getColumnIndex(b.a.A));
                    eVar.s = cursor.getString(cursor.getColumnIndex(b.a.B));
                    eVar.t = cursor.getInt(cursor.getColumnIndex(b.a.C));
                    eVar.u = cursor.getString(cursor.getColumnIndex(b.a.D));
                    eVar.v = cursor.getInt(cursor.getColumnIndex("count"));
                    eVar.w = cursor.getString(cursor.getColumnIndex("sid"));
                    this.b = cursor.getInt(cursor.getColumnIndex("id"));
                    arrayList.add(eVar);
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                a(sQLiteDatabase);
                return arrayList;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                a(sQLiteDatabase);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = sQLiteDatabase2;
        }
    }

    public void a(long j) {
        SQLiteDatabase sQLiteDatabase = null;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                SQLiteDatabase d = d();
                sQLiteDatabase2 = d;
                sQLiteDatabase = d;
                d.delete(f.b, "id <= ?", new String[]{String.valueOf(j)});
                sQLiteDatabase = d;
            } catch (Exception e) {
                sQLiteDatabase2 = sQLiteDatabase;
                e.printStackTrace();
            }
            a(sQLiteDatabase);
        } catch (Throwable th) {
            a(sQLiteDatabase2);
            throw th;
        }
    }

    @Override // com.tencent.tendinsv.a.d
    public void a(com.tencent.tendinsv.tool.e eVar, boolean z) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = null;
        SQLiteDatabase sQLiteDatabase3 = null;
        if (eVar != null) {
            try {
                try {
                    sQLiteDatabase2 = d();
                    try {
                        this.f38994c = true;
                        if (z) {
                            a(eVar.w, eVar.o, eVar.o, sQLiteDatabase2);
                        }
                        if (this.f38994c || !z) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("DID", eVar.f39051a);
                            contentValues.put(b.a.o, eVar.b);
                            contentValues.put(b.a.g, eVar.f39052c);
                            contentValues.put(b.a.l, eVar.d);
                            contentValues.put(b.a.m, eVar.e);
                            contentValues.put("sdkVersion", eVar.f);
                            contentValues.put("uuid", eVar.g);
                            contentValues.put(b.a.q, eVar.h);
                            contentValues.put("network", eVar.i);
                            contentValues.put(b.a.s, eVar.j);
                            contentValues.put(b.a.t, eVar.k);
                            contentValues.put(b.a.u, eVar.l);
                            contentValues.put("method", Integer.valueOf(eVar.m));
                            contentValues.put("beginTime", Long.valueOf(eVar.n));
                            contentValues.put("costTime", Long.valueOf(eVar.o));
                            contentValues.put(b.a.y, Long.valueOf(eVar.p));
                            contentValues.put("status", Integer.valueOf(eVar.q));
                            contentValues.put(b.a.A, eVar.r);
                            contentValues.put(b.a.B, eVar.s);
                            contentValues.put(b.a.C, Integer.valueOf(eVar.t));
                            contentValues.put(b.a.D, eVar.u);
                            contentValues.put("count", Integer.valueOf(eVar.v));
                            contentValues.put("sid", eVar.w);
                            sQLiteDatabase2.insert(f.b, null, contentValues);
                        }
                    } catch (Exception e) {
                        sQLiteDatabase = sQLiteDatabase2;
                        e = e;
                        sQLiteDatabase3 = sQLiteDatabase;
                        e.printStackTrace();
                        sQLiteDatabase2 = sQLiteDatabase;
                        a(sQLiteDatabase2);
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase3 = sQLiteDatabase2;
                        a(sQLiteDatabase3);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
                sQLiteDatabase = null;
            }
        }
        a(sQLiteDatabase2);
    }

    @Override // com.tencent.tendinsv.a.d
    public void a(com.tencent.tendinsv.tool.f fVar) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        SQLiteDatabase sQLiteDatabase3;
        Cursor query;
        Cursor cursor = null;
        Cursor cursor2 = null;
        if (fVar != null) {
            try {
                sQLiteDatabase = d();
                cursor2 = null;
                SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase;
                try {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("DID", fVar.f39053a);
                        contentValues.put(b.a.f38990c, fVar.b);
                        contentValues.put("IMSI", fVar.f39054c);
                        contentValues.put(b.a.e, fVar.d);
                        contentValues.put(b.a.f, fVar.e);
                        contentValues.put(b.a.h, fVar.f);
                        contentValues.put("device", fVar.g);
                        contentValues.put(b.a.j, fVar.h);
                        contentValues.put("oaid", fVar.i);
                        query = sQLiteDatabase.query(f.f38995a, new String[]{"DID"}, "DID = ?", new String[]{fVar.f39053a}, null, null, null, null);
                        try {
                            if (query.getCount() == 0) {
                                sQLiteDatabase.insert(f.f38995a, null, contentValues);
                            }
                        } catch (Exception e) {
                            e = e;
                            cursor = query;
                            sQLiteDatabase2 = sQLiteDatabase;
                            cursor2 = cursor;
                            sQLiteDatabase4 = sQLiteDatabase2;
                            e.printStackTrace();
                            sQLiteDatabase3 = sQLiteDatabase2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                    sQLiteDatabase3 = sQLiteDatabase2;
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    sQLiteDatabase3 = sQLiteDatabase2;
                                    a(sQLiteDatabase3);
                                }
                            }
                            a(sQLiteDatabase3);
                        } catch (Throwable th) {
                            cursor2 = query;
                            th = th;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            a(sQLiteDatabase);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = sQLiteDatabase4;
                    }
                } catch (Exception e4) {
                    e = e4;
                    sQLiteDatabase2 = sQLiteDatabase;
                }
            } catch (Exception e5) {
                e = e5;
                sQLiteDatabase2 = null;
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
            }
        } else {
            sQLiteDatabase = null;
            query = null;
        }
        sQLiteDatabase3 = sQLiteDatabase;
        if (query != null) {
            try {
                query.close();
                sQLiteDatabase3 = sQLiteDatabase;
            } catch (Exception e6) {
                e = e6;
                sQLiteDatabase2 = sQLiteDatabase;
                e.printStackTrace();
                sQLiteDatabase3 = sQLiteDatabase2;
                a(sQLiteDatabase3);
            }
        }
        a(sQLiteDatabase3);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.tendinsv.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r6) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.a.e.a(int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long b() {
        /*
            r4 = this;
            r0 = 0
            r11 = r0
            r0 = 0
            r10 = r0
            r0 = 0
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r4
            android.database.sqlite.SQLiteDatabase r0 = r0.d()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L7c
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            r8 = r0
            r0 = r11
            r10 = r0
            r0 = r9
            java.lang.String r1 = "select count(*) from login_behavior"
            r2 = 0
            android.database.Cursor r0 = r0.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            r11 = r0
            r0 = r11
            r7 = r0
            r0 = r9
            r8 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            boolean r0 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            r0 = r11
            r7 = r0
            r0 = r9
            r8 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            r1 = 0
            long r0 = r0.getLong(r1)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            r5 = r0
            r0 = r11
            if (r0 == 0) goto L62
            r0 = r11
            r0.close()     // Catch: java.lang.Exception -> L5d
            goto L62
        L5d:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L62:
            r0 = r4
            r1 = r9
            r0.a(r1)
            r0 = r5
            return r0
        L6a:
            r9 = move-exception
            goto La9
        L6f:
            r11 = move-exception
            goto L81
        L74:
            r9 = move-exception
            r0 = 0
            r8 = r0
            goto La9
        L7c:
            r11 = move-exception
            r0 = 0
            r9 = r0
        L81:
            r0 = r10
            r7 = r0
            r0 = r9
            r8 = r0
            r0 = r11
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6a
            r0 = r10
            if (r0 == 0) goto La1
            r0 = r10
            r0.close()     // Catch: java.lang.Exception -> L9c
            goto La1
        L9c:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        La1:
            r0 = r4
            r1 = r9
            r0.a(r1)
            r0 = 0
            return r0
        La9:
            r0 = r7
            if (r0 == 0) goto Lbb
            r0 = r7
            r0.close()     // Catch: java.lang.Exception -> Lb6
            goto Lbb
        Lb6:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        Lbb:
            r0 = r4
            r1 = r8
            r0.a(r1)
            r0 = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.a.e.b():long");
    }

    public long c() {
        return this.b;
    }
}
