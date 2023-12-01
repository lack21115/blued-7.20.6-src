package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/n.class */
public class n {
    private static final com.opos.mobad.n.a a(Activity activity, AdItemData adItemData, MaterialData materialData, a.InterfaceC0538a interfaceC0538a) {
        com.opos.mobad.n.a iVar;
        int P = adItemData.P();
        Context applicationContext = activity.getApplicationContext();
        int b = materialData.b();
        if (b != 6) {
            switch (b) {
                case 214:
                    iVar = new h(activity, 214, interfaceC0538a);
                    break;
                case 215:
                    iVar = new g(activity, 215, interfaceC0538a);
                    break;
                case 216:
                    iVar = new f(activity, 216, interfaceC0538a);
                    break;
                case 217:
                    iVar = new e(activity, 217, interfaceC0538a);
                    break;
                case 218:
                    iVar = com.opos.mobad.n.f.j.a(applicationContext, 218, com.opos.mobad.r.a.d.a(P).a(applicationContext));
                    iVar.a(interfaceC0538a);
                    break;
                case 219:
                    iVar = com.opos.mobad.n.f.j.b(applicationContext, 219, com.opos.mobad.r.a.d.a(P).a(applicationContext));
                    iVar.a(interfaceC0538a);
                    break;
                default:
                    iVar = null;
                    break;
            }
        } else {
            iVar = new i(activity, 6, interfaceC0538a);
        }
        com.opos.mobad.n.a aVar = iVar;
        if (iVar == null) {
            aVar = a(activity, materialData, interfaceC0538a, P);
        }
        return new m(activity, adItemData, aVar);
    }

    public static final com.opos.mobad.n.a a(Activity activity, AdItemData adItemData, MaterialData materialData, a.InterfaceC0538a interfaceC0538a, com.opos.mobad.activity.webview.b bVar) {
        com.opos.mobad.n.a b = b(activity, adItemData, materialData, interfaceC0538a, bVar);
        com.opos.mobad.n.a aVar = b;
        if (b == null) {
            aVar = a(activity, adItemData, materialData, interfaceC0538a);
        }
        return aVar;
    }

    private static final com.opos.mobad.n.a a(Activity activity, MaterialData materialData, a.InterfaceC0538a interfaceC0538a, int i) {
        com.opos.mobad.n.a a2;
        int d = materialData.d();
        com.opos.mobad.n.a eVar = d != 2 ? d != 3 ? d != 6 ? d != 7 ? d != 8 ? null : new e(activity, 217, interfaceC0538a) : new f(activity, 216, interfaceC0538a) : new g(activity, 215, interfaceC0538a) : new h(activity, 214, interfaceC0538a) : new i(activity, 6, interfaceC0538a);
        com.opos.mobad.n.a aVar = eVar;
        if (eVar == null) {
            Context applicationContext = activity.getApplicationContext();
            int ae = materialData.ae();
            if (ae == 60) {
                a2 = com.opos.mobad.n.f.j.a(applicationContext, 218, com.opos.mobad.r.a.d.a(i).a(applicationContext));
            } else if (ae != 63) {
                return eVar;
            } else {
                a2 = com.opos.mobad.n.f.j.b(applicationContext, 219, com.opos.mobad.r.a.d.a(i).a(applicationContext));
            }
            a2.a(interfaceC0538a);
            aVar = a2;
        }
        return aVar;
    }

    private static final com.opos.mobad.n.a b(Activity activity, AdItemData adItemData, MaterialData materialData, a.InterfaceC0538a interfaceC0538a, com.opos.mobad.activity.webview.b bVar) {
        com.opos.mobad.n.a a2 = com.opos.mobad.o.e.b.a().a(activity.getApplicationContext(), materialData.b(), adItemData.P(), interfaceC0538a);
        if (a2 == null) {
            return null;
        }
        return com.opos.mobad.service.c.b.a().c(adItemData.i().get(0).b()) == 0 ? a2 : new k(activity, adItemData, bVar, a2);
    }
}
