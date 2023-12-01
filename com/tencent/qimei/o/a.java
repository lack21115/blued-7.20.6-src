package com.tencent.qimei.o;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f38366a;

    public a(d dVar) {
        this.f38366a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        String str;
        com.tencent.qimei.g.c cVar;
        String str2;
        Context context3;
        Context context4;
        String str3;
        com.tencent.qimei.x.b bVar;
        String str4;
        com.tencent.qimei.j.f fVar;
        e a2 = e.a();
        context = this.f38366a.b;
        a2.a(context);
        com.tencent.qimei.c.a.h();
        com.tencent.qimei.g.b a3 = com.tencent.qimei.g.b.a();
        context2 = this.f38366a.b;
        a3.a(context2);
        com.tencent.qimei.g.b a4 = com.tencent.qimei.g.b.a();
        str = this.f38366a.f38370c;
        cVar = this.f38366a.e;
        a4.a(str, cVar);
        str2 = this.f38366a.f38370c;
        j a5 = j.a(str2);
        context3 = this.f38366a.b;
        a5.i = context3;
        context4 = this.f38366a.b;
        str3 = this.f38366a.f38370c;
        bVar = this.f38366a.d;
        d dVar = this.f38366a;
        com.tencent.qimei.v.d.a(str3, bVar);
        com.tencent.qimei.b.a.a().a(new com.tencent.qimei.v.c(str3, context4, dVar));
        str4 = this.f38366a.f38370c;
        l a6 = l.a(str4);
        if (!a6.h) {
            a6.a();
            a6.h = true;
        }
        com.tencent.qimei.k.a.b(d.f38369a, "basicTask init finished,notify another task (oaid and collection)", new Object[0]);
        fVar = this.f38366a.i;
        fVar.a();
        this.f38366a.a();
    }
}
