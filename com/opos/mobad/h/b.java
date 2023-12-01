package com.opos.mobad.h;

import android.content.Context;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.model.data.AdData;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/b.class */
public abstract class b extends a {
    protected com.opos.mobad.ad.c.f i;
    protected int j;
    protected volatile String k;

    public b(Context context, String str, int i, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.c.f fVar) {
        super(context, str, dVar);
        this.j = i;
        this.i = fVar;
    }

    public b(Context context, String str, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.c.f fVar) {
        super(context, str, dVar);
        this.i = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(q qVar) {
        if (qVar != null) {
            try {
                com.opos.cmn.an.f.a.b("InterBaseNativeAd", "notifyOnAdFailed nativeAdError=" + qVar.toString());
                b().a(qVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterBaseNativeAd", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdData adData, List<com.opos.mobad.ad.c.d> list) {
        try {
            com.opos.cmn.an.f.a.b("InterBaseNativeAd", "notifyOnAdReady");
            if (adData == null || list == null) {
                return;
            }
            b().a(list);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterBaseNativeAd", "", (Throwable) e);
        }
    }

    public com.opos.mobad.ad.c.f b() {
        com.opos.mobad.ad.c.f fVar = this.i;
        return fVar != null ? fVar : com.opos.mobad.ad.c.f.b;
    }

    public m c() {
        com.opos.mobad.ad.c.f fVar = this.i;
        return (fVar == null || !(fVar instanceof m)) ? m.f25671c : (m) fVar;
    }
}
