package com.kwai.sodler.lib;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/j.class */
public class j implements com.kwai.sodler.lib.a.e {
    private final com.kwai.sodler.lib.ext.c aJN;
    private final com.kwai.sodler.lib.a.d aJX;
    private final com.kwai.sodler.lib.a.g aJY;
    private final com.kwai.sodler.lib.a.c aJZ;
    private final com.kwai.sodler.lib.a.b aKa;
    private final com.kwai.sodler.lib.ext.a aKb;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/j$a.class */
    public static abstract class a {
        final com.kwai.sodler.lib.a.e aKc;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kwai.sodler.lib.j$a$a  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/j$a$a.class */
        public static final class C0597a extends a {
            public C0597a(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void m(com.kwai.sodler.lib.a.f fVar) {
                this.aKc.Jr().e(fVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/j$a$b.class */
        public static final class b extends a {
            b(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void m(com.kwai.sodler.lib.a.f fVar) {
                this.aKc.Jo().f(fVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/j$a$c.class */
        public static final class c extends a {
            c(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void m(com.kwai.sodler.lib.a.f fVar) {
                this.aKc.Jp().i(fVar);
            }
        }

        public a(com.kwai.sodler.lib.a.e eVar) {
            this.aKc = eVar;
        }

        public static a a(com.kwai.sodler.lib.a.e eVar, int i) {
            return i != 1 ? i != 256 ? new b(eVar) : new C0597a(eVar) : new c(eVar);
        }

        public abstract void m(com.kwai.sodler.lib.a.f fVar);
    }

    public j(com.kwai.sodler.lib.a.d dVar, com.kwai.sodler.lib.a.g gVar, com.kwai.sodler.lib.a.c cVar, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.c cVar2, com.kwai.sodler.lib.ext.a aVar) {
        this.aJX = dVar;
        this.aJY = gVar;
        this.aJZ = cVar;
        this.aJN = cVar2;
        this.aKb = aVar;
        this.aKa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r3 == java.util.Collections.EMPTY_MAP) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map f(java.util.Map r3) {
        /*
            r0 = r3
            if (r0 == 0) goto Ld
            r0 = r3
            r4 = r0
            r0 = r3
            java.util.Map r1 = java.util.Collections.EMPTY_MAP
            if (r0 != r1) goto L15
        Ld:
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            r4 = r0
        L15:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.sodler.lib.j.f(java.util.Map):java.util.Map");
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c Jn() {
        return this.aJN;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d Jo() {
        return this.aJX;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g Jp() {
        return this.aJY;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c Jq() {
        return this.aJZ;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b Jr() {
        return this.aKa;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a Js() {
        return this.aKb;
    }

    public com.kwai.sodler.lib.a.f a(com.kwai.sodler.lib.a.f fVar, a aVar) {
        if (fVar.JA() == null) {
            fVar.a(this);
        }
        StringBuilder sb = new StringBuilder("request id = ");
        sb.append(fVar.getId());
        sb.append(", state log = ");
        sb.append(fVar.JB());
        aVar.m(fVar);
        return fVar;
    }
}
