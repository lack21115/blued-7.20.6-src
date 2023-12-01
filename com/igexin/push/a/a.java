package com.igexin.push.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.c.a.b.e;
import com.igexin.c.a.d.f;
import com.igexin.push.core.d;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/a/a.class */
public class a extends f {
    public static final int b = -980948;
    public static final int g = -2147483639;

    /* renamed from: c  reason: collision with root package name */
    protected SQLiteDatabase f9679c;
    protected Cursor d;
    List<com.igexin.push.core.e.a> e;
    boolean f;
    private static final String h = a.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public static int f9678a = 0;

    public a() {
        super(1);
        this.e = new LinkedList();
    }

    private void b(boolean z) {
        this.f = z;
    }

    public final void a(com.igexin.push.core.e.a aVar) {
        this.e.add(aVar);
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        SQLiteDatabase writableDatabase = d.a.f9866a.i.getWritableDatabase();
        this.f9679c = writableDatabase;
        writableDatabase.setVersion(7);
        for (com.igexin.push.core.e.a aVar : this.e) {
            aVar.a(this.f9679c);
        }
        for (com.igexin.push.core.e.a aVar2 : this.e) {
            if (this.f) {
                aVar2.c(this.f9679c);
            } else {
                aVar2.b(this.f9679c);
            }
        }
        e.a().a(new c());
        e.a().b();
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2147483639;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        super.d();
        this.o = true;
        this.L = true;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
        Cursor cursor = this.d;
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
