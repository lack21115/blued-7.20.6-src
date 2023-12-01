package com.anythink.basead.e;

import com.anythink.core.common.e.i;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/e/e.class */
public abstract class e implements a {

    /* renamed from: a  reason: collision with root package name */
    i f5983a;

    public e(i iVar) {
        this.f5983a = iVar;
    }

    private void a() {
        i iVar = this.f5983a;
        if (iVar instanceof com.anythink.core.common.e.g) {
            com.anythink.core.common.e.g gVar = (com.anythink.core.common.e.g) iVar;
            if (gVar.c() == 1) {
                com.anythink.core.common.a.b.a().b(gVar);
            }
        }
    }

    @Override // com.anythink.basead.e.a
    public void onAdShow() {
        i iVar = this.f5983a;
        if (iVar instanceof com.anythink.core.common.e.g) {
            com.anythink.core.common.e.g gVar = (com.anythink.core.common.e.g) iVar;
            if (gVar.c() == 1) {
                com.anythink.core.common.a.b.a().b(gVar);
            }
        }
    }
}
