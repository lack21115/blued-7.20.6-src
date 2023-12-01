package com.tencent.qimei.o;

import android.content.Context;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/d.class */
public class d implements com.tencent.qimei.v.k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38369a = "d";
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public String f38370c;
    public com.tencent.qimei.x.b d;
    public com.tencent.qimei.g.c e;
    public String h;
    public a j;
    public String f = "0";
    public String g = "0";
    public com.tencent.qimei.j.f i = new com.tencent.qimei.j.f(new Object(), 100);
    public Runnable k = new com.tencent.qimei.o.a(this);
    public Runnable l = new b(this);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/d$a.class */
    public interface a {
    }

    public d(String str, Context context, a aVar, com.tencent.qimei.x.b bVar, com.tencent.qimei.g.c cVar) {
        this.f38370c = str;
        this.b = context;
        this.j = aVar;
        this.d = bVar;
        this.e = cVar;
    }

    public final void a() {
        com.tencent.qimei.k.a.b(f38369a, "oaidTask is running", new Object[0]);
        com.tencent.qimei.l.d a2 = com.tencent.qimei.l.d.a(this.f38370c);
        com.tencent.qimei.b.a.a().a(new com.tencent.qimei.l.a(a2, new c(this)));
        com.tencent.qimei.g.b.a().a(a2.b, a2);
    }

    public final void a(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            com.tencent.qimei.k.a.a(e);
        }
    }

    public void b() {
        com.tencent.qimei.k.a.b(f38369a, "HidBuilder task be notified", new Object[0]);
        j a2 = j.a(this.f38370c);
        if (a2.i == null) {
            com.tencent.qimei.k.a.a(j.f38376a, "context = null", new Object[0]);
            return;
        }
        a2.e = com.tencent.qimei.v.d.a(a2.f38377c).c();
        a2.d = com.tencent.qimei.v.d.a(a2.f38377c).k();
        a2.f = com.tencent.qimei.v.d.a(a2.f38377c).x();
        if (a2.d == 0 && a2.e == 0) {
            com.tencent.qimei.k.a.a(j.f38376a, "hid close", new Object[0]);
            return;
        }
        String str = j.f38376a;
        int i = a2.e;
        int i2 = a2.d;
        com.tencent.qimei.b.a.a().a(a2.f * 1000, new f(a2));
    }
}
