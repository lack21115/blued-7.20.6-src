package com.igexin.push.core.e;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.push.f.g;
import com.igexin.push.f.j;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f.class */
public class f implements a {
    private static final int A = 31;
    private static final int B = 22;
    private static final int C = 23;
    private static final int D = 51;
    private static final int E = 53;
    private static final int F = 54;
    private static final int G = 60;
    private static final int H = 61;
    private static final int I = 63;
    private static final int J = 64;
    private static final int K = 65;
    private static final int L = 66;
    private static volatile f M;

    /* renamed from: a  reason: collision with root package name */
    public static final String f9902a = f.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private static final int f9903c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 4;
    private static final int g = 6;
    private static final int h = 8;
    private static final int i = 12;
    private static final int j = 13;
    private static final int k = 14;
    private static final int l = 15;
    private static final int m = 16;
    private static final int n = 17;
    private static final int o = 18;
    private static final int p = 20;
    private static final int q = 21;
    private static final int r = 25;
    private static final int s = 32;
    private static final int t = 40;
    private static final int u = 46;
    private static final int v = 47;
    private static final int w = 48;
    private static final int x = 49;
    private static final int y = 50;
    private static final int z = 30;
    public boolean b;

    /* renamed from: com.igexin.push.core.e.f$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$1.class */
    public final class AnonymousClass1 extends com.igexin.push.a.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            f.this.c(this.d);
            j.b();
        }
    }

    /* renamed from: com.igexin.push.core.e.f$12  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$12.class */
    public final class AnonymousClass12 extends com.igexin.push.a.d {
        public AnonymousClass12() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            f.a();
            f.b(this.d, 8, String.valueOf(com.igexin.push.core.e.R));
        }
    }

    /* renamed from: com.igexin.push.core.e.f$13  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$13.class */
    public final class AnonymousClass13 extends com.igexin.push.a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9908a;

        public AnonymousClass13(String str) {
            this.f9908a = str;
        }

        @Override // com.igexin.push.a.d
        public final void a_() throws Exception {
            f.a();
            f.b(this.d, 3, this.f9908a);
        }
    }

    /* renamed from: com.igexin.push.core.e.f$19  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$19.class */
    public final class AnonymousClass19 extends com.igexin.push.a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9915a;
        final /* synthetic */ String b;

        public AnonymousClass19(String str, String str2) {
            this.f9915a = str;
            this.b = str2;
        }

        @Override // com.igexin.push.a.d
        public final void a_() throws Exception {
            if (!TextUtils.isEmpty(this.f9915a)) {
                f.a();
                f.b(this.d, 53, this.f9915a);
            }
            if (TextUtils.isEmpty(this.b)) {
                return;
            }
            f.a();
            f.b(this.d, 54, this.b);
        }
    }

    /* renamed from: com.igexin.push.core.e.f$20  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$20.class */
    public final class AnonymousClass20 extends com.igexin.push.a.d {
        public AnonymousClass20() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() throws Exception {
            f.a();
            f.b(this.d, 60, String.valueOf(com.igexin.push.core.e.f9889c));
        }
    }

    /* renamed from: com.igexin.push.core.e.f$24  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$24.class */
    public final class AnonymousClass24 extends com.igexin.push.a.d {
        public AnonymousClass24() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() throws Exception {
            f.a();
            f.b(this.d, 64, String.valueOf(com.igexin.push.core.e.ax));
        }
    }

    /* renamed from: com.igexin.push.core.e.f$26  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$26.class */
    public final class AnonymousClass26 extends com.igexin.push.a.d {
        public AnonymousClass26() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() throws Exception {
            f.a();
            f.a(this.d, 66, com.igexin.c.a.a.a.b(com.igexin.push.a.j.getBytes(), com.igexin.push.core.e.M));
        }
    }

    /* renamed from: com.igexin.push.core.e.f$27  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$27.class */
    public final class AnonymousClass27 extends com.igexin.push.a.d {
        public AnonymousClass27() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() throws Exception {
            f.a();
            f.e(this.d);
        }
    }

    /* renamed from: com.igexin.push.core.e.f$3  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$3.class */
    public final class AnonymousClass3 extends com.igexin.push.a.d {
        public AnonymousClass3() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            f.a();
            f.b(this.d, 13, com.igexin.push.core.e.V);
        }
    }

    /* renamed from: com.igexin.push.core.e.f$30  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$30.class */
    public final class AnonymousClass30 extends com.igexin.push.a.d {
        public AnonymousClass30() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            f.a();
            f.b(this.d, 51, com.igexin.push.core.e.C);
        }
    }

    /* renamed from: com.igexin.push.core.e.f$5  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/f$5.class */
    public final class AnonymousClass5 extends com.igexin.push.a.d {
        public AnonymousClass5() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            f.a();
            f.b(this.d, 16, String.valueOf(com.igexin.push.core.e.X));
        }
    }

    private f() {
    }

    public static f a() {
        if (M == null) {
            synchronized (f.class) {
                try {
                    if (M == null) {
                        M = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return M;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, int i2, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i2));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace(com.igexin.push.core.b.V, null, contentValues);
    }

    private boolean a(String str, String str2) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass19(str, str2), false, true);
    }

    private boolean a(String str, String str2, long j2) {
        com.igexin.push.core.e.z = j2;
        if (TextUtils.isEmpty(com.igexin.push.core.e.H)) {
            com.igexin.push.core.e.H = str2;
        }
        com.igexin.push.core.e.A = str;
        return c();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(android.database.sqlite.SQLiteDatabase r9, int r10) {
        /*
            r0 = 0
            r11 = r0
            java.lang.String r0 = "id="
            r1 = r10
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L62
            java.lang.String r0 = r0.concat(r1)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L62
            r12 = r0
            r0 = r9
            java.lang.String r1 = "runtime"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L62
            r3 = r2
            r4 = 0
            java.lang.String r5 = "value"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L62
            r3 = r12
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L62
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L57
            r0 = r9
            r11 = r0
            r0 = r9
            boolean r0 = r0.moveToFirst()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L77
            if (r0 == 0) goto L57
            r0 = r9
            r11 = r0
            r0 = r9
            r1 = r9
            java.lang.String r2 = "value"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L77
            byte[] r0 = r0.getBlob(r1)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L77
            java.lang.String r1 = com.igexin.push.core.e.M     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L77
            byte[] r0 = com.igexin.c.a.a.a.a(r0, r1)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L77
            r12 = r0
            r0 = r9
            if (r0 == 0) goto L51
            r0 = r9
            r0.close()
        L51:
            r0 = r12
            return r0
        L53:
            r12 = move-exception
            goto L65
        L57:
            r0 = r9
            if (r0 == 0) goto L75
            goto L6f
        L5e:
            r9 = move-exception
            goto L78
        L62:
            r12 = move-exception
            r0 = 0
            r9 = r0
        L65:
            r0 = r9
            r11 = r0
            r0 = r12
            com.igexin.c.a.c.a.a(r0)     // Catch: java.lang.Throwable -> L77
            r0 = r9
            if (r0 == 0) goto L75
        L6f:
            r0 = r9
            r0.close()
        L75:
            r0 = 0
            return r0
        L77:
            r9 = move-exception
        L78:
            r0 = r11
            if (r0 == 0) goto L82
            r0 = r11
            r0.close()
        L82:
            r0 = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.e.f.a(android.database.sqlite.SQLiteDatabase, int):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.database.sqlite.SQLiteDatabase r9, int r10) {
        /*
            r0 = 0
            r11 = r0
            java.lang.String r0 = "id="
            r1 = r10
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5c
            java.lang.String r0 = r0.concat(r1)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5c
            r12 = r0
            r0 = r9
            java.lang.String r1 = "runtime"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5c
            r3 = r2
            r4 = 0
            java.lang.String r5 = "value"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5c
            r3 = r12
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5c
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L51
            r0 = r9
            r11 = r0
            r0 = r9
            boolean r0 = r0.moveToFirst()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L71
            if (r0 == 0) goto L51
            r0 = r9
            r11 = r0
            r0 = r9
            r1 = r9
            java.lang.String r2 = "value"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L71
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L71
            r12 = r0
            r0 = r9
            if (r0 == 0) goto L4b
            r0 = r9
            r0.close()
        L4b:
            r0 = r12
            return r0
        L4d:
            r12 = move-exception
            goto L5f
        L51:
            r0 = r9
            if (r0 == 0) goto L6f
            goto L69
        L58:
            r9 = move-exception
            goto L72
        L5c:
            r12 = move-exception
            r0 = 0
            r9 = r0
        L5f:
            r0 = r9
            r11 = r0
            r0 = r12
            com.igexin.c.a.c.a.a(r0)     // Catch: java.lang.Throwable -> L71
            r0 = r9
            if (r0 == 0) goto L6f
        L69:
            r0 = r9
            r0.close()
        L6f:
            r0 = 0
            return r0
        L71:
            r9 = move-exception
        L72:
            r0 = r11
            if (r0 == 0) goto L7c
            r0 = r11
            r0.close()
        L7c:
            r0 = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.e.f.b(android.database.sqlite.SQLiteDatabase, int):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(SQLiteDatabase sQLiteDatabase, int i2, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i2));
        contentValues.put("value", str);
        sQLiteDatabase.replace(com.igexin.push.core.b.V, null, contentValues);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r0.length() <= 8) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.e.f.d():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
        if (r9 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(android.database.sqlite.SQLiteDatabase r9) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.e.f.d(android.database.sqlite.SQLiteDatabase):void");
    }

    static /* synthetic */ void e() {
        j.b();
        String d2 = j.d();
        if (d2 == null || d2.length() <= 5) {
            j.f();
        }
    }

    static /* synthetic */ void e(SQLiteDatabase sQLiteDatabase) {
        byte[] a2 = a(sQLiteDatabase, 66);
        if (a2 != null) {
            String str = new String(a2);
            if (TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.a(f9902a, "readRedirectAes null");
                return;
            }
            g.f10041c = str;
            String str2 = f9902a;
            com.igexin.c.a.c.a.b(str2, " readRedirectAes set success " + g.f10041c);
        }
    }

    private void f() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), false, true);
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        this.b = true;
        d(sQLiteDatabase);
        byte[] a2 = a(sQLiteDatabase, 1);
        if (a2 != null) {
            try {
                String str = new String(a2);
                com.igexin.push.core.e.z = str.equals(com.igexin.push.core.b.l) ? 0L : Long.parseLong(str);
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            com.igexin.c.a.c.a.a(f9902a + "|db version changed, save session = " + com.igexin.push.core.e.z, new Object[0]);
        }
        byte[] a3 = a(sQLiteDatabase, 20);
        if (a3 != null) {
            String str2 = new String(a3);
            String str3 = str2;
            if (str2.equals(com.igexin.push.core.b.l)) {
                str3 = null;
            }
            com.igexin.push.core.e.B = str3;
            com.igexin.push.core.e.A = str3;
            com.igexin.c.a.c.a.a(f9902a + "|db version changed, save cid = " + str3, new Object[0]);
        }
        String b = b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(b)) {
            String str4 = b;
            if (b.equals(com.igexin.push.core.b.l)) {
                str4 = null;
            }
            com.igexin.push.core.e.L = str4;
        }
        String str5 = com.igexin.push.core.e.L;
        String b2 = b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(b2)) {
            String str6 = b2;
            if (b2.equals(com.igexin.push.core.b.l)) {
                str6 = null;
            }
            com.igexin.push.core.e.H = str6;
        }
        String b3 = b(sQLiteDatabase, 46);
        if (!TextUtils.isEmpty(b3)) {
            String str7 = b3;
            if (b3.equals(com.igexin.push.core.b.l)) {
                str7 = null;
            }
            com.igexin.push.core.e.I = str7;
        }
        String b4 = b(sQLiteDatabase, 48);
        if (!TextUtils.isEmpty(b4)) {
            String str8 = b4;
            if (b4.equals(com.igexin.push.core.b.l)) {
                str8 = null;
            }
            com.igexin.push.core.e.K = str8;
        }
        String b5 = b(sQLiteDatabase, 51);
        if (TextUtils.isEmpty(b5)) {
            return;
        }
        if (b5.equals(com.igexin.push.core.b.l)) {
            b5 = null;
        }
        com.igexin.push.core.e.C = b5;
    }

    private boolean f(long j2) {
        if (j2 != com.igexin.push.core.e.R) {
            com.igexin.push.core.e.R = j2;
            return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass12(), false, true);
        }
        return false;
    }

    static /* synthetic */ byte[] f(String str) {
        return g.a(str.getBytes());
    }

    private static void g() {
        j.b();
        String d2 = j.d();
        if (d2 == null || d2.length() <= 5) {
            j.f();
        }
    }

    private static void g(SQLiteDatabase sQLiteDatabase) {
        String b = b(sQLiteDatabase, 2);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        String str = b;
        if (b.equals(com.igexin.push.core.b.l)) {
            str = null;
        }
        com.igexin.push.core.e.H = str;
    }

    private boolean g(long j2) {
        if (com.igexin.push.core.e.T != j2) {
            com.igexin.push.core.e.T = j2;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.33
                @Override // com.igexin.push.a.d
                public final void a_() {
                    f.a();
                    f.b(this.d, 12, String.valueOf(com.igexin.push.core.e.T));
                }
            }, false, true);
            return true;
        }
        return false;
    }

    private static byte[] g(String str) {
        return g.a(str.getBytes());
    }

    private static void h() {
        String str = com.igexin.push.core.e.A;
        com.igexin.c.a.c.a.a(f9902a + "| found a duplicate cid " + com.igexin.push.core.e.A, new Object[0]);
        com.igexin.push.core.e.L = null;
        d();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass13(com.igexin.push.core.e.L), false, true);
        a().b();
        com.igexin.push.core.e.r = 0;
        com.igexin.push.e.b.e.g().f10005a = SystemClock.elapsedRealtime();
    }

    private static void h(SQLiteDatabase sQLiteDatabase) {
        String b = b(sQLiteDatabase, 51);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        String str = b;
        if (b.equals(com.igexin.push.core.b.l)) {
            str = null;
        }
        com.igexin.push.core.e.C = str;
    }

    private boolean h(long j2) {
        if (com.igexin.push.core.e.X != j2) {
            com.igexin.push.core.e.X = j2;
            return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass5(), false, true);
        }
        return false;
    }

    private boolean h(String str) {
        com.igexin.push.core.e.C = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass30(), false, true);
    }

    private void i() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass24(), false, true);
    }

    private static void i(SQLiteDatabase sQLiteDatabase) {
        String b = b(sQLiteDatabase, 46);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        String str = b;
        if (b.equals(com.igexin.push.core.b.l)) {
            str = null;
        }
        com.igexin.push.core.e.I = str;
    }

    private boolean i(long j2) {
        if (com.igexin.push.core.e.U != j2) {
            com.igexin.push.core.e.U = j2;
            return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.14
                @Override // com.igexin.push.a.d
                public final void a_() {
                    f.a();
                    f.b(this.d, 32, String.valueOf(com.igexin.push.core.e.U));
                }
            }, false, true);
        }
        return false;
    }

    private boolean i(String str) {
        if (str.equals(com.igexin.push.core.e.V)) {
            return false;
        }
        com.igexin.push.core.e.V = str;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass3(), false, true);
        return true;
    }

    private void j() {
        if (TextUtils.isEmpty(g.f10041c)) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass26(), true, false);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass27(), true, false);
        }
    }

    private static void j(SQLiteDatabase sQLiteDatabase) {
        String b = b(sQLiteDatabase, 48);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        String str = b;
        if (b.equals(com.igexin.push.core.b.l)) {
            str = null;
        }
        com.igexin.push.core.e.K = str;
    }

    private boolean j(long j2) {
        if (com.igexin.push.core.e.f9889c != j2) {
            com.igexin.push.core.e.f9889c = j2;
            return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass20(), false, true);
        }
        return false;
    }

    private boolean j(String str) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass13(str), false, true);
    }

    private static void k(SQLiteDatabase sQLiteDatabase) {
        String b = b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(b)) {
            String str = b;
            if (b.equals(com.igexin.push.core.b.l)) {
                str = null;
            }
            com.igexin.push.core.e.L = str;
        }
        String str2 = com.igexin.push.core.e.L;
    }

    private static void l(SQLiteDatabase sQLiteDatabase) {
        byte[] a2 = a(sQLiteDatabase, 1);
        if (a2 != null) {
            try {
                String str = new String(a2);
                com.igexin.push.core.e.z = str.equals(com.igexin.push.core.b.l) ? 0L : Long.parseLong(str);
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            com.igexin.c.a.c.a.a(f9902a + "|db version changed, save session = " + com.igexin.push.core.e.z, new Object[0]);
        }
    }

    private static void m(SQLiteDatabase sQLiteDatabase) {
        byte[] a2 = a(sQLiteDatabase, 20);
        if (a2 != null) {
            String str = new String(a2);
            String str2 = str;
            if (str.equals(com.igexin.push.core.b.l)) {
                str2 = null;
            }
            com.igexin.push.core.e.B = str2;
            com.igexin.push.core.e.A = str2;
            com.igexin.c.a.c.a.a(f9902a + "|db version changed, save cid = " + str2, new Object[0]);
        }
    }

    private static void n(SQLiteDatabase sQLiteDatabase) {
        byte[] a2 = a(sQLiteDatabase, 66);
        if (a2 != null) {
            String str = new String(a2);
            if (TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.a(f9902a, "readRedirectAes null");
                return;
            }
            g.f10041c = str;
            String str2 = f9902a;
            com.igexin.c.a.c.a.b(str2, " readRedirectAes set success " + g.f10041c);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    public final void a(boolean z2) {
        com.igexin.push.core.e.W = z2;
        com.igexin.c.a.c.a.a(z2);
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.4
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.b(this.d, 15, String.valueOf(com.igexin.push.core.e.W));
            }
        }, false, true);
    }

    public final boolean a(int i2) {
        com.igexin.push.core.e.ab = i2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.7
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.b(this.d, 18, String.valueOf(com.igexin.push.core.e.ab));
            }
        }, false, true);
    }

    public final boolean a(long j2) {
        com.igexin.push.core.e.a(j2);
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.28
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.a(this.d, 1, g.a(String.valueOf(com.igexin.push.core.e.z).getBytes()));
                f.a();
                f.a(this.d, 20, f.f(com.igexin.push.core.e.A));
                j.b();
            }
        }, false, true);
    }

    public final boolean a(String str) {
        com.igexin.push.core.e.H = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.29
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.b(this.d, 2, com.igexin.push.core.e.H);
                String d2 = j.d();
                if (d2 == null || d2.length() <= 5) {
                    j.f();
                }
            }
        }, false, true);
    }

    public final boolean a(final String str, boolean z2) {
        com.igexin.c.a.b.e a2;
        com.igexin.push.a.d dVar;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = null;
        if (z2) {
            if (str.equals(com.igexin.push.core.e.f9888ar)) {
                return false;
            }
            if (!str.equals(com.igexin.push.core.b.l)) {
                str2 = str;
            }
            com.igexin.push.core.e.f9888ar = str2;
            a2 = com.igexin.c.a.b.e.a();
            dVar = new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.8
                @Override // com.igexin.push.a.d
                public final void a_() throws Exception {
                    f.a();
                    f.a(this.d, 31, f.f(str));
                }
            };
        } else if (str.equals(com.igexin.push.core.e.as)) {
            return false;
        } else {
            com.igexin.push.core.e.as = str.equals(com.igexin.push.core.b.l) ? null : str;
            a2 = com.igexin.c.a.b.e.a();
            dVar = new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.9
                @Override // com.igexin.push.a.d
                public final void a_() throws Exception {
                    f.a();
                    f.a(this.d, 30, f.f(str));
                }
            };
        }
        return a2.a((com.igexin.c.a.d.f) dVar, false, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:490:0x09cf, code lost:
        if (r15 == null) goto L535;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x0c2f  */
    @Override // com.igexin.push.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.database.sqlite.SQLiteDatabase r10) {
        /*
            Method dump skipped, instructions count: 3154
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.e.f.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public final boolean b() {
        com.igexin.push.core.e.z = 0L;
        com.igexin.push.core.e.A = com.igexin.push.core.b.l;
        d();
        return c();
    }

    public final boolean b(int i2) {
        if (com.igexin.push.core.e.aA != i2) {
            com.igexin.push.core.e.aA = i2;
            return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.16
                @Override // com.igexin.push.a.d
                public final void a_() {
                    f.a();
                    f.b(this.d, 47, String.valueOf(com.igexin.push.core.e.aA));
                }
            }, false, true);
        }
        return false;
    }

    public final boolean b(final long j2) {
        com.igexin.push.core.e.ao = j2;
        com.igexin.c.a.c.a.a(f9902a + "|save idc config failed time : " + j2, new Object[0]);
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.2
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.b(this.d, 21, String.valueOf(j2));
            }
        }, false, true);
    }

    public final boolean b(String str) {
        com.igexin.push.core.e.I = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.31
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.b(this.d, 46, com.igexin.push.core.e.I);
            }
        }, false, true);
    }

    public final boolean b(final String str, boolean z2) {
        com.igexin.c.a.b.e a2;
        com.igexin.push.a.d dVar;
        if (str == null) {
            return false;
        }
        String str2 = null;
        if (z2) {
            if (str.equals(com.igexin.push.core.e.ap)) {
                return false;
            }
            if (!str.equals(com.igexin.push.core.b.l)) {
                str2 = str;
            }
            com.igexin.push.core.e.ap = str2;
            a2 = com.igexin.c.a.b.e.a();
            dVar = new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.10
                @Override // com.igexin.push.a.d
                public final void a_() throws Exception {
                    f.a();
                    f.a(this.d, 23, f.f(str));
                }
            };
        } else if (str.equals(com.igexin.push.core.e.aq)) {
            return false;
        } else {
            com.igexin.push.core.e.aq = str.equals(com.igexin.push.core.b.l) ? null : str;
            a2 = com.igexin.c.a.b.e.a();
            dVar = new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.11
                @Override // com.igexin.push.a.d
                public final void a_() throws Exception {
                    f.a();
                    f.a(this.d, 22, f.f(str));
                }
            };
        }
        return a2.a((com.igexin.c.a.d.f) dVar, false, true);
    }

    public final boolean b(final boolean z2) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.17
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.b(this.d, 40, String.valueOf(z2));
            }
        }, false, true);
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
        byte[] b = com.igexin.c.a.a.a.b(String.valueOf(com.igexin.push.core.e.z).getBytes(), com.igexin.push.core.e.M);
        long j2 = com.igexin.push.core.e.z;
        a(sQLiteDatabase, 1, b);
        b(sQLiteDatabase, 4, String.valueOf(com.igexin.push.core.e.t));
        b(sQLiteDatabase, 8, String.valueOf(com.igexin.push.core.e.R));
        b(sQLiteDatabase, 32, String.valueOf(com.igexin.push.core.e.U));
        b(sQLiteDatabase, 3, com.igexin.push.core.e.L);
        b(sQLiteDatabase, 12, String.valueOf(com.igexin.push.core.e.T));
        a(sQLiteDatabase, 20, com.igexin.c.a.a.a.b(com.igexin.push.core.e.A.getBytes(), com.igexin.push.core.e.M));
        b(sQLiteDatabase, 2, com.igexin.push.core.e.H);
        a(sQLiteDatabase, 25, com.igexin.c.a.a.a.b(com.igexin.push.core.e.M.getBytes(), com.igexin.c.b.a.b(com.igexin.push.core.e.l.getPackageName())));
    }

    public final boolean c() {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.23
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.b(this.d, 2, com.igexin.push.core.e.H);
                f.a(this.d, 1, f.f(String.valueOf(com.igexin.push.core.e.z)));
                f.a(this.d, 20, f.f(com.igexin.push.core.e.A));
                f.b(this.d, 3, com.igexin.push.core.e.L);
                f.e();
            }
        }, false, true);
    }

    public final boolean c(long j2) {
        if (com.igexin.push.core.e.Q != j2) {
            com.igexin.push.core.e.Q = j2;
            return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.15
                @Override // com.igexin.push.a.d
                public final void a_() {
                    f.a();
                    f.b(this.d, 6, String.valueOf(com.igexin.push.core.e.Q));
                }
            }, false, true);
        }
        return false;
    }

    public final boolean c(String str) {
        com.igexin.push.core.e.K = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.32
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.b(this.d, 48, com.igexin.push.core.e.K);
            }
        }, false, true);
    }

    public final boolean c(final String str, final boolean z2) {
        if (str == null) {
            return false;
        }
        String str2 = str.equals(com.igexin.push.core.b.l) ? null : str;
        if (z2 && !TextUtils.equals(com.igexin.push.core.e.au, str)) {
            com.igexin.push.core.e.au = str2;
        } else if (z2 || TextUtils.equals(com.igexin.push.core.e.at, str)) {
            return false;
        } else {
            com.igexin.push.core.e.at = str2;
        }
        com.igexin.c.a.c.a.a(f9902a + "|saveLastRedirectCmList isMobile = " + z2 + ", lastRedirectCmList = " + str, new Object[0]);
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.18
            @Override // com.igexin.push.a.d
            public final void a_() throws Exception {
                f.a();
                f.a(this.d, z2 ? 50 : 49, f.f(str));
            }
        }, false, true);
    }

    public final boolean d(long j2) {
        if (com.igexin.push.core.e.aw != j2) {
            com.igexin.push.core.e.aw = j2;
            return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.22
                @Override // com.igexin.push.a.d
                public final void a_() throws Exception {
                    f.a();
                    f.b(this.d, 63, String.valueOf(com.igexin.push.core.e.aw));
                }
            }, false, true);
        }
        return false;
    }

    public final boolean d(String str) {
        if (str.equals(com.igexin.push.core.e.Z)) {
            return false;
        }
        com.igexin.push.core.e.Z = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.6
            @Override // com.igexin.push.a.d
            public final void a_() {
                f.a();
                f.b(this.d, 17, String.valueOf(com.igexin.push.core.e.Z));
            }
        }, false, true);
    }

    public final void e(long j2) {
        if (com.igexin.push.core.e.ay != j2) {
            com.igexin.push.core.e.ay = j2;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.25
                @Override // com.igexin.push.a.d
                public final void a_() throws Exception {
                    f.a();
                    f.b(this.d, 65, String.valueOf(com.igexin.push.core.e.ay));
                }
            }, false, true);
        }
    }

    public final boolean e(final String str) {
        com.igexin.push.core.e.d = str.equals(com.igexin.push.core.b.l) ? null : str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.f.21
            @Override // com.igexin.push.a.d
            public final void a_() throws Exception {
                f.a();
                f.a(this.d, 61, g.a(str.getBytes()));
            }
        }, false, true);
    }
}
