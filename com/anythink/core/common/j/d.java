package com.anythink.core.common.j;

import android.content.Context;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.h;
import com.anythink.core.common.g.a.c;
import com.anythink.core.common.g.i;
import com.anythink.core.common.o;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/j/d.class */
public class d extends o<h> {
    private static volatile d f;

    private d(Context context) {
        super(context);
    }

    public static d a(Context context) {
        if (f == null) {
            synchronized (d.class) {
                try {
                    if (f == null) {
                        f = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    @Override // com.anythink.core.common.o
    public final void a(final List<h> list) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.d.1
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList = new ArrayList();
                for (h hVar : list) {
                    arrayList.add(hVar.a().toString());
                }
                com.anythink.core.c.a b = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                if (b == null) {
                    com.anythink.core.common.g.b bVar = new com.anythink.core.common.g.b(d.this.e, 0, arrayList);
                    bVar.p();
                    bVar.a(0, (i) null);
                } else if (b.u() != 1) {
                    com.anythink.core.common.g.b bVar2 = new com.anythink.core.common.g.b(d.this.e, b.u(), arrayList);
                    bVar2.p();
                    bVar2.a(0, (i) null);
                } else {
                    com.anythink.core.common.g.a.a aVar = new com.anythink.core.common.g.a.a(arrayList);
                    aVar.a(1, b.t());
                    aVar.a();
                    aVar.a((c.a) null);
                }
            }
        });
    }
}
