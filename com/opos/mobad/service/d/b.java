package com.opos.mobad.service.d;

import android.util.LruCache;
import com.opos.mobad.service.i.d;
import com.opos.mobad.service.j.e;
import com.opos.mobad.service.j.f;
import com.opos.mobad.service.j.g;
import com.opos.mobad.service.j.h;
import com.opos.mobad.service.j.i;
import java.util.LinkedList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/d/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f13642a;

    /* renamed from: c  reason: collision with root package name */
    private h f13643c = new h(15);
    private LruCache<String, com.opos.mobad.service.j.b<Integer>> b = new LruCache<>(50);

    private b() {
    }

    public static final b a() {
        b bVar;
        b bVar2 = f13642a;
        if (bVar2 == null) {
            synchronized (b.class) {
                try {
                    b bVar3 = f13642a;
                    bVar = bVar3;
                    if (bVar3 == null) {
                        bVar = new b();
                        f13642a = bVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return bVar;
        }
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        d.a().a(str, i);
    }

    private com.opos.mobad.service.j.b<Integer> b(final String str) {
        com.opos.mobad.service.j.b<Integer> bVar = this.b.get(str);
        com.opos.mobad.service.j.a aVar = bVar;
        if (bVar == null) {
            e eVar = new e();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(new i(com.anythink.expressad.foundation.g.a.bM));
            linkedList2.add(this.f13643c);
            linkedList.add(new g(new f(linkedList2)));
            final i iVar = new i(com.anythink.expressad.foundation.g.a.bM);
            linkedList.add(iVar);
            aVar = new com.opos.mobad.service.j.a(eVar, new f(linkedList), new com.opos.mobad.service.j.b<e>() { // from class: com.opos.mobad.service.d.b.1
                @Override // com.opos.mobad.service.j.b
                public void a(e eVar2) {
                    iVar.a(eVar2);
                    b.this.a(str, eVar2.b());
                }
            });
            this.b.put(str, aVar);
        }
        return aVar;
    }

    public void a(String str) {
        b(str).a(1);
    }
}
