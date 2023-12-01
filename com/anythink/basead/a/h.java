package com.anythink.basead.a;

import android.content.Context;
import android.content.IntentFilter;
import com.anythink.core.common.m;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/h.class */
public class h {
    private static volatile h b;
    g a;
    private Context c;
    private ConcurrentHashMap<String, com.anythink.core.common.e.i> d = new ConcurrentHashMap<>();

    private h(Context context) {
        this.c = context;
    }

    public static h a(Context context) {
        if (b == null) {
            synchronized (h.class) {
                try {
                    if (b == null) {
                        b = new h(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private void b() {
        if (this.a != null) {
            m.a(this.c).a(this.a);
            this.a = null;
        }
    }

    public final void a() {
        if (this.c != null && this.a == null) {
            this.a = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.anythink.china.common.a.b);
            intentFilter.addAction(com.anythink.china.common.a.c);
            intentFilter.addAction(com.anythink.china.common.a.d);
            intentFilter.addAction(com.anythink.china.common.a.e);
            m.a(this.c).a(this.a, intentFilter);
        }
    }

    public final void a(String str, com.anythink.core.common.e.i iVar) {
        this.d.put(str, iVar);
    }

    public final void a(String str, String str2) {
        com.anythink.core.common.e.i iVar = this.d.get(str);
        if (iVar != null) {
            com.anythink.basead.c.i iVar2 = new com.anythink.basead.c.i("", "");
            iVar2.i = new com.anythink.basead.c.b();
            iVar2.i.a = str2;
            b.a(18, iVar, iVar2);
        }
    }

    public final void b(String str, String str2) {
        com.anythink.core.common.e.i iVar = this.d.get(str);
        if (iVar != null) {
            com.anythink.basead.c.i iVar2 = new com.anythink.basead.c.i("", "");
            iVar2.i = new com.anythink.basead.c.b();
            iVar2.i.a = str2;
            b.a(19, iVar, iVar2);
        }
    }

    public final void c(String str, String str2) {
        com.anythink.core.common.e.i iVar = this.d.get(str);
        if (iVar != null) {
            com.anythink.basead.c.i iVar2 = new com.anythink.basead.c.i("", "");
            iVar2.i = new com.anythink.basead.c.b();
            iVar2.i.a = str2;
            b.a(20, iVar, iVar2);
        }
    }

    public final void d(String str, String str2) {
        com.anythink.core.common.e.i remove = this.d.remove(str);
        if (remove != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i("", "");
            iVar.i = new com.anythink.basead.c.b();
            iVar.i.a = str2;
            b.a(21, remove, iVar);
        }
        if (this.d.size() != 0 || this.a == null) {
            return;
        }
        m.a(this.c).a(this.a);
        this.a = null;
    }
}
