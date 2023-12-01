package com.anythink.basead.a;

import android.content.Context;
import android.content.IntentFilter;
import com.anythink.core.common.m;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/h.class */
public class h {
    private static volatile h b;

    /* renamed from: a  reason: collision with root package name */
    g f5870a;

    /* renamed from: c  reason: collision with root package name */
    private Context f5871c;
    private ConcurrentHashMap<String, com.anythink.core.common.e.i> d = new ConcurrentHashMap<>();

    private h(Context context) {
        this.f5871c = context;
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
        if (this.f5870a != null) {
            m.a(this.f5871c).a(this.f5870a);
            this.f5870a = null;
        }
    }

    public final void a() {
        if (this.f5871c != null && this.f5870a == null) {
            this.f5870a = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.anythink.china.common.a.b);
            intentFilter.addAction(com.anythink.china.common.a.f6276c);
            intentFilter.addAction(com.anythink.china.common.a.d);
            intentFilter.addAction(com.anythink.china.common.a.e);
            m.a(this.f5871c).a(this.f5870a, intentFilter);
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
            iVar2.i.f5892a = str2;
            b.a(18, iVar, iVar2);
        }
    }

    public final void b(String str, String str2) {
        com.anythink.core.common.e.i iVar = this.d.get(str);
        if (iVar != null) {
            com.anythink.basead.c.i iVar2 = new com.anythink.basead.c.i("", "");
            iVar2.i = new com.anythink.basead.c.b();
            iVar2.i.f5892a = str2;
            b.a(19, iVar, iVar2);
        }
    }

    public final void c(String str, String str2) {
        com.anythink.core.common.e.i iVar = this.d.get(str);
        if (iVar != null) {
            com.anythink.basead.c.i iVar2 = new com.anythink.basead.c.i("", "");
            iVar2.i = new com.anythink.basead.c.b();
            iVar2.i.f5892a = str2;
            b.a(20, iVar, iVar2);
        }
    }

    public final void d(String str, String str2) {
        com.anythink.core.common.e.i remove = this.d.remove(str);
        if (remove != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i("", "");
            iVar.i = new com.anythink.basead.c.b();
            iVar.i.f5892a = str2;
            b.a(21, remove, iVar);
        }
        if (this.d.size() != 0 || this.f5870a == null) {
            return;
        }
        m.a(this.f5871c).a(this.f5870a);
        this.f5870a = null;
    }
}
