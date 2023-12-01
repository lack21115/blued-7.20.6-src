package com.kwad.components.ad.interstitial.d;

import android.app.Activity;
import android.content.DialogInterface;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/d/a.class */
public final class a {
    public static boolean c(final c cVar) {
        Activity ownerActivity;
        if (cVar.hU == null || (ownerActivity = cVar.hU.getOwnerActivity()) == null || ownerActivity.isFinishing()) {
            return false;
        }
        AdInfo cb = d.cb(cVar.mAdTemplate);
        int cO = com.kwad.components.ad.interstitial.a.b.cO();
        int cP = com.kwad.components.ad.interstitial.a.b.cP();
        if (cO <= com.kwad.sdk.core.response.a.a.bS(cb) || cP >= com.kwad.sdk.core.response.a.a.bT(cb)) {
            return false;
        }
        if (com.kwad.sdk.core.response.a.a.bU(cb) == 2) {
            com.kwad.components.ad.interstitial.e.b.d(cVar);
            return true;
        } else if (com.kwad.sdk.core.response.a.a.bU(cb) == 1) {
            new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.a.a.bX(cb), new a.InterfaceC0362a() { // from class: com.kwad.components.ad.interstitial.d.a.1
                @Override // com.kwad.components.core.page.widget.a.InterfaceC0362a
                public final void a(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    com.kwad.sdk.core.report.a.c(c.this.mAdTemplate, (JSONObject) null, new i().bn(8));
                }

                @Override // com.kwad.components.core.page.widget.a.InterfaceC0362a
                public final void b(DialogInterface dialogInterface) {
                    c cVar2 = c.this;
                    cVar2.a(false, -1, cVar2.eN);
                    dialogInterface.dismiss();
                    com.kwad.sdk.core.report.a.a(c.this.mAdTemplate, new i().bl(151).bn(8));
                    c.this.hU.dismiss();
                }

                @Override // com.kwad.components.core.page.widget.a.InterfaceC0362a
                public final void c(DialogInterface dialogInterface) {
                }
            }).show();
            com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new i().bl(149).bn(8));
            return true;
        } else {
            return false;
        }
    }
}
