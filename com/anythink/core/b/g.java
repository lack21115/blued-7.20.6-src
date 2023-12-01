package com.anythink.core.b;

import java.util.List;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/g.class */
public final class g extends e {
    public g(com.anythink.core.common.e.a aVar) {
        super(aVar);
    }

    @Override // com.anythink.core.b.e
    protected final void a(List<JSONObject> list, com.anythink.core.common.g.i iVar) {
        com.anythink.core.b.a.b bVar = new com.anythink.core.b.a.b();
        bVar.f = this.d.n.ar();
        com.anythink.core.b.a.a aVar = new com.anythink.core.b.a.a(this.n, this.m, this.l, list, 1);
        aVar.a(bVar);
        aVar.a(0, iVar);
    }

    @Override // com.anythink.core.b.e
    protected final String b() {
        return this.d.p;
    }
}
