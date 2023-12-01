package com.anythink.basead.handler;

import android.content.Context;
import com.anythink.basead.a.b;
import com.anythink.basead.c.d;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/handler/OfferClickHandler.class */
public class OfferClickHandler extends IOfferClickHandler {
    private static d a(i iVar) {
        return com.anythink.basead.a.d.a().a(iVar.d(), iVar.p());
    }

    @Override // com.anythink.core.api.IOfferClickHandler
    public boolean startDownloadApp(Context context, i iVar, j jVar, String str) {
        return b.a(context, jVar, iVar, com.anythink.basead.a.d.a().a(iVar.d(), iVar.p()), str, new com.anythink.basead.a.i());
    }
}
