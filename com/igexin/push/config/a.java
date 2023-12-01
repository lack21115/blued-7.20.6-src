package com.igexin.push.config;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/a.class */
public class a implements com.igexin.push.core.e.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23361a = a.class.getName();
    public static final int b = 63;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23362c = 65;
    public static final int d = 67;
    public static final int e = 68;
    public static final int f = 79;
    public static final int g = 82;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 15;
    private static final int l = 16;
    private static final int m = 24;
    private static final int n = 26;
    private static final int o = 28;
    private static final int p = 46;
    private static final int q = 47;
    private static final int r = 48;
    private static final int s = 49;
    private static final int t = 60;
    private static final int u = 61;
    private static final int v = 62;
    private static final int w = 69;
    private static final int x = 70;
    private static final int y = 74;
    private static volatile a z;

    /* renamed from: com.igexin.push.config.a$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/a$1.class */
    public final class AnonymousClass1 extends com.igexin.push.a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23363a;

        public AnonymousClass1(String str) {
            this.f23363a = str;
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            a.b(this.d, 63, this.f23363a);
        }
    }

    /* renamed from: com.igexin.push.config.a$3  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/a$3.class */
    public final class AnonymousClass3 extends com.igexin.push.a.d {
        public AnonymousClass3() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            a.b(this.d, 15, String.valueOf(d.e));
        }
    }

    /* renamed from: com.igexin.push.config.a$4  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/a$4.class */
    public final class AnonymousClass4 extends com.igexin.push.a.d {
        public AnonymousClass4() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            a.b(this.d, 16, String.valueOf(d.f));
        }
    }

    /* renamed from: com.igexin.push.config.a$5  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/a$5.class */
    public final class AnonymousClass5 extends com.igexin.push.a.d {
        public AnonymousClass5() {
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            a.b(this.d, 3, String.valueOf(d.d));
        }
    }

    /* renamed from: com.igexin.push.config.a$6  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/a$6.class */
    public final class AnonymousClass6 extends com.igexin.push.a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23368a;

        public AnonymousClass6(String str) {
            this.f23368a = str;
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            a.a(this.d, 26, com.igexin.c.a.a.a.b(this.f23368a.getBytes(), com.igexin.push.core.e.M));
        }
    }

    /* renamed from: com.igexin.push.config.a$7  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/a$7.class */
    public final class AnonymousClass7 extends com.igexin.push.a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23369a;

        public AnonymousClass7(String str) {
            this.f23369a = str;
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            a.a(this.d, 24, com.igexin.c.a.a.a.b(this.f23369a.getBytes(), com.igexin.push.core.e.M));
        }
    }

    /* renamed from: com.igexin.push.config.a$9  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/a$9.class */
    public final class AnonymousClass9 extends com.igexin.push.a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f23371a;

        public AnonymousClass9(boolean z) {
            this.f23371a = z;
        }

        @Override // com.igexin.push.a.d
        public final void a_() {
            a.b(this.d, 79, String.valueOf(this.f23371a));
        }
    }

    private a() {
    }

    public static a a() {
        if (z == null) {
            synchronized (a.class) {
                try {
                    if (z == null) {
                        z = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    private static void a(SQLiteDatabase sQLiteDatabase, int i2) {
        sQLiteDatabase.delete(com.igexin.push.core.b.U, "id = ?", new String[]{String.valueOf(i2)});
    }

    static /* synthetic */ void a(SQLiteDatabase sQLiteDatabase, int i2, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i2));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace(com.igexin.push.core.b.U, null, contentValues);
    }

    private void a(boolean z2) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass9(z2), true, false);
    }

    private boolean a(String str) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(str), false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(SQLiteDatabase sQLiteDatabase, int i2, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i2));
        contentValues.put("value", str);
        sQLiteDatabase.replace(com.igexin.push.core.b.U, null, contentValues);
    }

    private static void b(SQLiteDatabase sQLiteDatabase, int i2, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i2));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace(com.igexin.push.core.b.U, null, contentValues);
    }

    private void b(String str) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass6(str), true, false);
    }

    private void c() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass3(), false, true);
    }

    private void c(String str) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass7(str), true, false);
    }

    private void d() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass4(), false, true);
    }

    private void e() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass5(), false, true);
    }

    public final void a(final long j2) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.config.a.8
            @Override // com.igexin.push.a.d
            public final void a_() {
                com.igexin.push.core.e.aH = j2;
                a.b(this.d, 65, String.valueOf(j2));
            }
        }, true, false);
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    public final void b() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.config.a.2
            @Override // com.igexin.push.a.d
            public final void a_() {
                a.b(this.d, 1, String.valueOf(d.b));
                a.b(this.d, 2, String.valueOf(d.f23376c));
            }
        }, false, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x02f6, code lost:
        if (r10 == null) goto L8;
     */
    /* JADX WARN: Finally extract failed */
    @Override // com.igexin.push.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.database.sqlite.SQLiteDatabase r10) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.a.b(android.database.sqlite.SQLiteDatabase):void");
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, 1, String.valueOf(d.b));
        b(sQLiteDatabase, 2, String.valueOf(d.f23376c));
        b(sQLiteDatabase, 3, String.valueOf(d.d));
        b(sQLiteDatabase, 15, String.valueOf(d.e));
        b(sQLiteDatabase, 3, String.valueOf(d.d));
    }
}
