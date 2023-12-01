package com.opos.mobad.model.d;

import com.opos.mobad.l.o;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.data.AdData;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/b.class */
public abstract class b implements m {

    /* renamed from: a  reason: collision with root package name */
    private m.a f26406a;
    private com.opos.mobad.l.o b = new o.a(1).a(1, 2, 8).a(2, 3, 4, 8).a(3, 5, 8).a(4, 8).a(5, 6, 7, 8).a(6, 8).a(7, 8).a();

    public b(m.a aVar) {
        this.f26406a = aVar;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdData adData) {
        int a2 = this.b.a(4);
        if (a2 == 4) {
            m.a aVar = this.f26406a;
            if (aVar != null) {
                aVar.a(adData);
            }
        } else if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":4");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Callable<Boolean> callable) {
        int a2 = this.b.a(3, callable);
        if (a2 == 3) {
            m.a aVar = this.f26406a;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            return true;
        } else if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":3");
            return false;
        } else {
            return false;
        }
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(AdData adData) {
        int a2 = this.b.a(7);
        if (a2 == 7) {
            m.a aVar = this.f26406a;
            if (aVar != null) {
                aVar.c(adData);
            }
        } else if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":7");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AdData adData) {
        int a2 = this.b.a(6);
        if (a2 == 6) {
            m.a aVar = this.f26406a;
            if (aVar != null) {
                aVar.b(adData);
            }
        } else if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":7");
        }
    }

    protected abstract void e();

    public void f() {
        int a2 = this.b.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.model.d.b.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.e();
                return true;
            }
        });
        if (a2 != 2) {
            com.opos.cmn.an.f.a.b("ALoader", "error state:" + a2 + ":2");
        }
    }

    @Override // com.opos.mobad.model.d.m
    public void g() {
        int a2 = this.b.a(5);
        if (5 == a2) {
            a();
            return;
        }
        com.opos.cmn.an.f.a.b("ALoader", "error state:" + a2 + ":5");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        int a2 = this.b.a(2, 3);
        if (a2 == 3) {
            m.a aVar = this.f26406a;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            return true;
        } else if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":3");
            return false;
        } else {
            return false;
        }
    }

    public void i() {
        this.b.a(8, new Callable<Boolean>() { // from class: com.opos.mobad.model.d.b.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.b();
                return true;
            }
        });
    }

    public int j() {
        return this.b.a();
    }
}
