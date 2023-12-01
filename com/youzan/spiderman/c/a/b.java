package com.youzan.spiderman.c.a;

import com.google.gson.annotations.SerializedName;
import com.youzan.spiderman.c.b.c;
import com.youzan.spiderman.c.b.d;
import com.youzan.spiderman.c.b.e;
import com.youzan.spiderman.c.b.f;
import com.youzan.spiderman.c.b.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/a/b.class */
public class b {
    @SerializedName("config_entity")

    /* renamed from: a  reason: collision with root package name */
    private c f41741a;

    public static void a(c cVar) {
        if (cVar.a() == null) {
            cVar.a(b());
        }
        com.youzan.spiderman.c.b.b b = cVar.b();
        if (b == null) {
            cVar.a(c());
            return;
        }
        if (b.a() == null) {
            b.a(d());
        }
        if (b.b() == null) {
            b.a(e());
        }
        if (b.c() == null) {
            b.a(f());
        }
        if (b.d() == null) {
            b.a(g());
        }
    }

    private static com.youzan.spiderman.c.b.a b() {
        com.youzan.spiderman.c.b.a aVar = new com.youzan.spiderman.c.b.a();
        aVar.a(0L);
        aVar.b(0L);
        return aVar;
    }

    private static com.youzan.spiderman.c.b.b c() {
        com.youzan.spiderman.c.b.b bVar = new com.youzan.spiderman.c.b.b();
        bVar.a(d());
        bVar.a(e());
        bVar.a(f());
        bVar.a(g());
        return bVar;
    }

    private static e d() {
        e eVar = new e();
        eVar.a(true);
        eVar.b(null);
        eVar.a((List<String>) null);
        return eVar;
    }

    private static f e() {
        f fVar = new f();
        fVar.a(7200000L);
        fVar.a("wifi");
        return fVar;
    }

    private static g f() {
        g gVar = new g();
        gVar.a(false);
        gVar.a(new ArrayList());
        return gVar;
    }

    private static d g() {
        d dVar = new d();
        dVar.a(true);
        dVar.a("wifi");
        dVar.a(7200000L);
        dVar.b(43200000L);
        dVar.a(new ArrayList());
        return dVar;
    }

    public final c a() {
        c cVar = this.f41741a;
        if (cVar == null) {
            c cVar2 = new c();
            this.f41741a = cVar2;
            cVar2.a(c());
            this.f41741a.a(b());
        } else {
            a(cVar);
        }
        return this.f41741a;
    }

    public final void b(c cVar) {
        this.f41741a = cVar;
    }
}
