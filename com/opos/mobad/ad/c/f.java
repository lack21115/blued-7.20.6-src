package com.opos.mobad.ad.c;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/f.class */
public interface f {
    public static final f b = new f() { // from class: com.opos.mobad.ad.c.f.1
        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdReady =", list);
        }
    };

    void a(q qVar);

    void a(q qVar, d dVar);

    void a(List<d> list);
}
