package com.vivo.push.d;

import com.vivo.push.cache.ClientConfigManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/c.class */
public final class c extends com.vivo.push.l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f41105a).isDebug());
    }
}
