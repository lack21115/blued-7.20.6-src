package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/t.class */
public class t {
    private static t E;

    /* renamed from: a  reason: collision with root package name */
    public static final String f23863a = "k";
    public static final String b = "p";

    /* renamed from: c  reason: collision with root package name */
    public static final String f23864c = "v";
    public static final String d = "l";
    public static final String e = "i";
    public static final String f = "a";
    public static final String g = "s";
    public static final String h = "n";
    public static final String i = "u";
    public static final String j = "c";
    public static final String k = "r";
    public static final String l = "b";
    public static final String m = "m";
    public static final String n = "el";
    public static final String o = "ail";
    public static final String p = "aps";
    public static final String q = "dp";
    public static final String r = "pcn";
    public static final String s = "pst";
    public static final String t = "d";
    public static final String u = "at";
    public static final String v = "dm";
    public static final String w = "rm";
    public static final String x = "pc";
    public static final String y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;
    private int z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/t$a.class */
    class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, bh.p, null, t.this.z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable th) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i >= 3 || i2 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable th) {
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable th2) {
            }
        }
    }

    private t(Context context) {
        this.D = context.getApplicationContext();
        this.B = new a(context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.C = this.B.getWritableDatabase();
            }
        } catch (Throwable th) {
        }
    }

    public static t a(Context context) {
        t tVar;
        synchronized (t.class) {
            try {
                if (E == null) {
                    E = new t(context);
                }
                tVar = E;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public int a(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i3));
            SQLiteDatabase sQLiteDatabase = this.C;
            return sQLiteDatabase.update(bh.q, contentValues, "k=" + i2, null);
        } catch (Throwable th) {
            return 0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public long a(s sVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public s a(int i2) {
        s sVar;
        s sVar2;
        Cursor cursor = null;
        try {
            Cursor query = this.C.query(bh.q, null, "k=" + i2, null, null, null, null);
            sVar = null;
            if (query != null) {
                sVar = null;
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f23861a = i2;
                            sVar.b = query.getInt(query.getColumnIndex("n"));
                            sVar.f23862c = query.getString(query.getColumnIndex("p"));
                            sVar.e = query.getString(query.getColumnIndex("a"));
                            sVar.h = query.getString(query.getColumnIndex("l"));
                            sVar.d = query.getString(query.getColumnIndex("v"));
                            sVar.n = query.getString(query.getColumnIndex(q));
                            sVar.p = query.getInt(query.getColumnIndex(p));
                            sVar.o = query.getString(query.getColumnIndex(r));
                            sVar.q = query.getInt(query.getColumnIndex("at"));
                            sVar.s = query.getLong(query.getColumnIndex(s));
                            sVar.t = query.getInt(query.getColumnIndex("d"));
                            sVar.w = query.getInt(query.getColumnIndex(w));
                            sVar.j = query.getString(query.getColumnIndex("dm"));
                            sVar.x = query.getInt(query.getColumnIndex(x));
                            boolean z = true;
                            if (query.getInt(query.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                        } catch (Throwable th) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            sVar2 = sVar;
                            return sVar2;
                        }
                    }
                } catch (Throwable th2) {
                    sVar = null;
                }
            }
            sVar2 = sVar;
            if (query != null) {
                sVar2 = sVar;
                if (!query.isClosed()) {
                    query.close();
                    return sVar;
                }
            }
        } catch (Throwable th3) {
            sVar = null;
        }
        return sVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0113, code lost:
        if (r12.isClosed() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0125, code lost:
        if (r12.isClosed() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0128, code lost:
        r12.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.kuaishou.weapon.p0.s> a() {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.a():java.util.List");
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bh.q, "p=?", new String[]{str});
        } catch (Throwable th) {
        }
    }

    public s b(String str) {
        s sVar;
        s sVar2;
        Cursor cursor = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean z = true;
            Cursor query = this.C.query(bh.q, null, "p=?", new String[]{str}, null, null, null);
            sVar = null;
            if (query != null) {
                sVar = null;
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f23861a = query.getInt(query.getColumnIndex("k"));
                            sVar.b = query.getInt(query.getColumnIndex("n"));
                            sVar.f23862c = query.getString(query.getColumnIndex("p"));
                            sVar.e = query.getString(query.getColumnIndex("a"));
                            sVar.h = query.getString(query.getColumnIndex("l"));
                            sVar.d = query.getString(query.getColumnIndex("v"));
                            sVar.n = query.getString(query.getColumnIndex(q));
                            sVar.p = query.getInt(query.getColumnIndex(p));
                            sVar.o = query.getString(query.getColumnIndex(r));
                            sVar.q = query.getInt(query.getColumnIndex("at"));
                            sVar.s = query.getLong(query.getColumnIndex(s));
                            sVar.t = query.getInt(query.getColumnIndex("d"));
                            sVar.w = query.getInt(query.getColumnIndex(w));
                            sVar.j = query.getString(query.getColumnIndex("dm"));
                            sVar.x = query.getInt(query.getColumnIndex(x));
                            if (query.getInt(query.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                        } catch (Throwable th) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            sVar2 = sVar;
                            return sVar2;
                        }
                    }
                } catch (Throwable th2) {
                    sVar = null;
                }
            }
            sVar2 = sVar;
            if (query != null) {
                sVar2 = sVar;
                if (!query.isClosed()) {
                    query.close();
                    return sVar;
                }
            }
        } catch (Throwable th3) {
            sVar = null;
        }
        return sVar2;
    }

    public void b() {
        ArrayList<s> arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dm.a(sVar.e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r a2 = r.a();
            for (s sVar2 : arrayList) {
                if (a2 != null) {
                    a2.a(sVar2.e);
                }
                SQLiteDatabase sQLiteDatabase = this.C;
                sQLiteDatabase.delete(bh.q, "k=" + sVar2.f23861a, null);
                if (r.b != null && !r.b.contains(Integer.valueOf(sVar2.f23861a))) {
                    dm.c(this.D.getFilesDir().getCanonicalPath() + bh.j + sVar2.f23861a);
                }
                if (a2.b() != null && a2.b().get(sVar2.f23862c) != null) {
                    dm.c(this.D.getFileStreamPath(sVar2.f23862c).getAbsolutePath());
                }
            }
        } catch (Throwable th) {
        }
    }

    public void b(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i3));
            SQLiteDatabase sQLiteDatabase = this.C;
            sQLiteDatabase.update(bh.q, contentValues, "k=" + i2, null);
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006c, code lost:
        if (r15.isClosed() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(int r10) {
        /*
            r9 = this;
            r0 = 0
            r13 = r0
            r0 = 0
            r14 = r0
            r0 = 0
            r12 = r0
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.C     // Catch: java.lang.Throwable -> L98
            r15 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98
            r1 = r0
            java.lang.String r2 = "k="
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L98
            r16 = r0
            r0 = r16
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L98
            r0 = r16
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L98
            r16 = r0
            r0 = r15
            java.lang.String r1 = "wp"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L98
            r3 = r2
            r4 = 0
            java.lang.String r5 = "p"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L98
            r3 = r16
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L98
            r15 = r0
            r0 = r12
            r11 = r0
            r0 = r15
            if (r0 == 0) goto L5c
            r0 = r15
            int r0 = r0.getCount()     // Catch: java.lang.Throwable -> L9d
            r10 = r0
            r0 = r12
            r11 = r0
            r0 = r10
            if (r0 <= 0) goto L5c
            r0 = 1
            r11 = r0
            goto L5c
        L59:
            goto L7b
        L5c:
            r0 = r11
            r12 = r0
            r0 = r15
            if (r0 == 0) goto L96
            r0 = r11
            r12 = r0
            r0 = r15
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto L96
        L6f:
            r0 = r15
            r0.close()
            r0 = r11
            return r0
        L78:
            r0 = 0
            r15 = r0
        L7b:
            r0 = r14
            r12 = r0
            r0 = r15
            if (r0 == 0) goto L96
            r0 = r14
            r12 = r0
            r0 = r15
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto L96
            r0 = r13
            r11 = r0
            goto L6f
        L96:
            r0 = r12
            return r0
        L98:
            r15 = move-exception
            goto L78
        L9d:
            r16 = move-exception
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.b(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
        if (r14.isClosed() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c(int r10) {
        /*
            r9 = this;
            r0 = 0
            r12 = r0
            r0 = 0
            r13 = r0
            r0 = 0
            r11 = r0
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.C     // Catch: java.lang.Throwable -> La3
            r14 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3
            r1 = r0
            java.lang.String r2 = "k="
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La3
            r15 = r0
            r0 = r15
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La3
            r0 = r15
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La3
            r15 = r0
            r0 = r14
            java.lang.String r1 = "wp"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> La3
            r3 = r2
            r4 = 0
            java.lang.String r5 = "n"
            r3[r4] = r5     // Catch: java.lang.Throwable -> La3
            r3 = r15
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La3
            r14 = r0
            r0 = r11
            r10 = r0
            r0 = r14
            if (r0 == 0) goto L68
            r0 = r11
            r10 = r0
            r0 = r14
            boolean r0 = r0.moveToFirst()     // Catch: java.lang.Throwable -> La8
            if (r0 == 0) goto L68
            r0 = r14
            r1 = r14
            java.lang.String r2 = "n"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> La8
            int r0 = r0.getInt(r1)     // Catch: java.lang.Throwable -> La8
            r10 = r0
            goto L68
        L65:
            goto L87
        L68:
            r0 = r10
            r11 = r0
            r0 = r14
            if (r0 == 0) goto La1
            r0 = r10
            r11 = r0
            r0 = r14
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto La1
        L7b:
            r0 = r14
            r0.close()
            r0 = r10
            return r0
        L84:
            r0 = 0
            r14 = r0
        L87:
            r0 = r13
            r11 = r0
            r0 = r14
            if (r0 == 0) goto La1
            r0 = r13
            r11 = r0
            r0 = r14
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto La1
            r0 = r12
            r10 = r0
            goto L7b
        La1:
            r0 = r11
            return r0
        La3:
            r14 = move-exception
            goto L84
        La8:
            r15 = move-exception
            goto L65
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.c(int):int");
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update(bh.q, contentValues, "n=-1", null);
        } catch (Throwable th) {
        }
    }

    public void c(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(x, Integer.valueOf(i3));
            SQLiteDatabase sQLiteDatabase = this.C;
            sQLiteDatabase.update(bh.q, contentValues, "k=" + i2, null);
        } catch (Throwable th) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("u", (Integer) 0);
        try {
            this.C.update(bh.q, contentValues, "u=1", null);
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0082, code lost:
        if (r15.isClosed() == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r10) {
        /*
            r9 = this;
            r0 = 0
            r13 = r0
            r0 = 0
            r14 = r0
            r0 = 0
            r12 = r0
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.C     // Catch: java.lang.Throwable -> Lae
            r15 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            r1 = r0
            java.lang.String r2 = "k="
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lae
            r16 = r0
            r0 = r16
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lae
            r0 = r16
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lae
            r16 = r0
            r0 = r15
            java.lang.String r1 = "wp"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lae
            r3 = r2
            r4 = 0
            java.lang.String r5 = "s"
            r3[r4] = r5     // Catch: java.lang.Throwable -> Lae
            r3 = r16
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lae
            r15 = r0
            r0 = r12
            r11 = r0
            r0 = r15
            if (r0 == 0) goto L72
            r0 = r12
            r11 = r0
            r0 = r15
            boolean r0 = r0.moveToFirst()     // Catch: java.lang.Throwable -> Lb3
            if (r0 == 0) goto L72
            r0 = r15
            r1 = r15
            java.lang.String r2 = "s"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb3
            int r0 = r0.getInt(r1)     // Catch: java.lang.Throwable -> Lb3
            r10 = r0
            r0 = r12
            r11 = r0
            r0 = r10
            r1 = 1
            if (r0 != r1) goto L72
            r0 = 1
            r11 = r0
            goto L72
        L6f:
            goto L91
        L72:
            r0 = r11
            r12 = r0
            r0 = r15
            if (r0 == 0) goto Lac
            r0 = r11
            r12 = r0
            r0 = r15
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto Lac
        L85:
            r0 = r15
            r0.close()
            r0 = r11
            return r0
        L8e:
            r0 = 0
            r15 = r0
        L91:
            r0 = r14
            r12 = r0
            r0 = r15
            if (r0 == 0) goto Lac
            r0 = r14
            r12 = r0
            r0 = r15
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto Lac
            r0 = r13
            r11 = r0
            goto L85
        Lac:
            r0 = r12
            return r0
        Lae:
            r15 = move-exception
            goto L8e
        Lb3:
            r16 = move-exception
            goto L6f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.d(int):boolean");
    }
}
