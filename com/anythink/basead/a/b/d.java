package com.anythink.basead.a.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/d.class */
public class d {
    public static final String a = d.class.getSimpleName();
    private static volatile d b;
    private List<a> c = new CopyOnWriteArrayList();

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/d$a.class */
    public interface a {
        void a(String str, int i);

        void a(String str, com.anythink.basead.c.e eVar);
    }

    private d() {
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                try {
                    if (b == null) {
                        b = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public final void a(a aVar) {
        synchronized (this) {
            this.c.add(aVar);
        }
    }

    public final void a(String str, int i) {
        List<a> list = this.c;
        if (list != null) {
            for (a aVar : list) {
                aVar.a(str, i);
            }
        }
    }

    public final void a(String str, com.anythink.basead.c.e eVar) {
        List<a> list = this.c;
        if (list != null) {
            for (a aVar : list) {
                aVar.a(str, eVar);
            }
        }
    }

    public final void b(a aVar) {
        int i;
        synchronized (this) {
            int size = this.c.size();
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= size) {
                    i = -1;
                    break;
                } else if (aVar == this.c.get(i)) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            if (i != -1) {
                this.c.remove(i);
            }
        }
    }
}
