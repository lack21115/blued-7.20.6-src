package com.anythink.basead.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.a.b.b;
import com.anythink.basead.a.f;
import com.anythink.basead.c.c;
import com.anythink.core.c.d;
import com.anythink.core.c.e;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/f/a/a.class */
public final class a {
    private static a a;
    private Context b;

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    private static boolean a(s sVar) {
        List<String> k = n.a().k();
        if (k != null) {
            for (String str : k) {
                if (TextUtils.equals(sVar.B(), str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final s a(String str, String str2) {
        d a2 = e.a(this.b).a(str);
        if (a2 == null) {
            return null;
        }
        return a2.e(str2);
    }

    public final void a(String str) {
        List<s> E;
        u D;
        d a2 = e.a(this.b).a(str);
        if (a2 == null || (E = a2.E()) == null || (D = a2.D()) == null) {
            return;
        }
        f.a();
        if (E == null) {
            return;
        }
        int size = E.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            j jVar = new j();
            jVar.m = D;
            f.a(str, true, E.get(i2), jVar, null);
            i = i2 + 1;
        }
    }

    public final void a(String str, s sVar, j jVar, b.InterfaceC0027b interfaceC0027b) {
        if (a(sVar)) {
            interfaceC0027b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.h, com.anythink.basead.c.f.G));
        } else if (b.a(this.b).b(sVar)) {
            interfaceC0027b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.e, com.anythink.basead.c.f.z));
        } else if (b.a(this.b).c(sVar)) {
            interfaceC0027b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f, com.anythink.basead.c.f.A));
        } else {
            f.a();
            f.a(str, sVar, jVar, interfaceC0027b);
        }
    }

    public final boolean a(s sVar, j jVar, boolean z) {
        if (this.b == null || sVar == null || a(sVar)) {
            return false;
        }
        if (z) {
            f.a();
            return f.a(sVar, jVar);
        } else if (b.a(this.b).b(sVar) || b.a(this.b).c(sVar)) {
            return false;
        } else {
            f.a();
            return f.a(sVar, jVar);
        }
    }

    public final String b(String str) {
        d a2 = e.a(this.b).a(str);
        if (a2 == null) {
            return "";
        }
        List<s> E = a2.E();
        ArrayList arrayList = new ArrayList();
        if (E == null || E.size() == 0) {
            return "";
        }
        int size = E.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            s sVar = E.get(i);
            f.a();
            if (f.a(sVar, a2.X(), a2.D())) {
                arrayList.add(b.a(this.b).d(sVar));
            } else {
                E.remove(i);
            }
            size = i;
        }
        if (arrayList.size() == 0) {
            return "";
        }
        Collections.sort(arrayList, new Comparator<c>() { // from class: com.anythink.basead.f.a.a.1
            private static int a(c cVar, c cVar2) {
                return Integer.valueOf(cVar.d).compareTo(Integer.valueOf(cVar2.d));
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(c cVar, c cVar2) {
                return Integer.valueOf(cVar.d).compareTo(Integer.valueOf(cVar2.d));
            }
        });
        return ((c) arrayList.get(0)).a;
    }
}
