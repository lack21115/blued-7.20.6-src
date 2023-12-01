package com.anythink.expressad.foundation.g.c;

import android.util.Log;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/c/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7842a = "AnythinkDirManager";
    private static d d;
    private f b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<a> f7843c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/c/d$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public com.anythink.expressad.foundation.g.c.a f7844a;
        public File b;

        public a(com.anythink.expressad.foundation.g.c.a aVar, File file) {
            this.f7844a = aVar;
            this.b = file;
        }
    }

    private d(f fVar) {
        this.b = fVar;
    }

    public static d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (d == null && com.anythink.expressad.foundation.b.a.b().d() != null) {
                    r.a(com.anythink.expressad.foundation.b.a.b().d());
                }
                if (d == null) {
                    Log.e(f7842a, "mDirectoryManager == null");
                }
                dVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public static File a(com.anythink.expressad.foundation.g.c.a aVar) {
        a next;
        try {
            if (a() == null || a().f7843c == null || a().f7843c.size() <= 0) {
                return null;
            }
            Iterator<a> it = a().f7843c.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (!next.f7844a.equals(aVar));
            return next.b;
        } catch (Throwable th) {
            o.b(f7842a, th.getMessage(), th);
            return null;
        }
    }

    public static void a(f fVar) {
        synchronized (d.class) {
            try {
                if (d == null) {
                    d = new d(fVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean a(e eVar) {
        File a2;
        String str;
        e c2 = eVar.c();
        if (c2 == null) {
            str = eVar.b();
        } else {
            if (a(c2.a()) == null) {
                return false;
            }
            str = a2.getAbsolutePath() + File.separator + eVar.b();
        }
        File file = new File(str);
        if (!file.exists() ? file.mkdirs() : true) {
            this.f7843c.add(new a(eVar.a(), file));
            List<e> d2 = eVar.d();
            if (d2 != null) {
                for (e eVar2 : d2) {
                    if (!a(eVar2)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public static String b(com.anythink.expressad.foundation.g.c.a aVar) {
        File a2 = a(aVar);
        if (a2 != null) {
            return a2.getAbsolutePath();
        }
        return null;
    }

    public final boolean b() {
        return a(this.b.b());
    }
}
