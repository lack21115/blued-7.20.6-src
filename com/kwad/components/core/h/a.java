package com.kwad.components.core.h;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/h/a.class */
public final class a {
    private CopyOnWriteArrayList<b> JL = new CopyOnWriteArrayList<>();
    private volatile boolean JM;

    /* renamed from: com.kwad.components.core.h.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/h/a$a.class */
    static final class C0354a {
        private static final a JN = new a();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/h/a$b.class */
    public static final class b {
        private final c JO;
        public boolean JP;

        public b(c cVar) {
            this.JO = cVar;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/h/a$c.class */
    public interface c {
        void bs();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.JP;
    }

    public static a nC() {
        return C0354a.JN;
    }

    public final void a(b bVar) {
        if (this.JL.contains(bVar)) {
            return;
        }
        if (!this.JM) {
            this.JM = true;
            bVar.JP = true;
        }
        this.JL.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.JP) {
            bVar.JP = false;
            this.JM = false;
        }
        this.JL.remove(bVar);
        if (this.JL.size() == 0 || this.JM) {
            return;
        }
        this.JL.get(0).JP = true;
        this.JM = true;
        this.JL.get(0).JO.bs();
    }
}
