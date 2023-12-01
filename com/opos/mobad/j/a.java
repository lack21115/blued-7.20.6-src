package com.opos.mobad.j;

import android.content.Context;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.l.h;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/j/a.class */
public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12571a = a.class.getSimpleName();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f12572c;
    private a.C0537a d;
    private int g;
    private com.opos.mobad.ad.d.b h;
    private a.InterfaceC0510a i;
    private int j;

    public a(Context context, String str, d dVar, com.opos.mobad.q.a.h hVar, com.opos.mobad.ad.d.b bVar) {
        super(bVar);
        this.b = context.getApplicationContext();
        this.f12572c = str;
        bVar = bVar == null ? com.opos.mobad.ad.d.b.f11990a : bVar;
        this.h = bVar;
        this.i = new b(context, str, bVar, dVar, hVar);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b(f12571a, "destroyAd");
        if (f.e()) {
            this.i.a();
            super.b();
        }
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        this.g = 0;
        this.j = 0;
        com.opos.mobad.model.b.a(this.b.getApplicationContext()).a(this.b, this.f12572c, 5, str, i, new b.a() { // from class: com.opos.mobad.j.a.1
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final a.C0537a c0537a) {
                a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.j.a.1.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        com.opos.cmn.an.f.a.b(a.f12571a, " call load succ");
                        a.this.d = c0537a;
                        a.this.g = i2;
                        return true;
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                if (adData != null) {
                    a.this.g = adData.c();
                }
                a.this.b(i2, str2);
            }
        });
        return true;
    }

    @Override // com.opos.mobad.l.h
    public boolean b(boolean z) {
        return this.i.a(this.d, this.j, new a.b() { // from class: com.opos.mobad.j.a.2
            @Override // com.opos.mobad.cmn.a.a.a.b
            public void a(int i, String str) {
                a.this.c(i, str);
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void d() {
                a.this.i_();
            }
        });
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.g;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        this.j = i;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.d) == null) ? super.f() : c0537a.b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.d) == null) ? super.g() : c0537a.b.Y();
    }
}
