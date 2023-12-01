package com.opos.mobad.ad.c;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/o.class */
public interface o extends a<p> {

    /* renamed from: a  reason: collision with root package name */
    public static final o f11984a = new o() { // from class: com.opos.mobad.ad.c.o.1
        @Override // com.opos.mobad.ad.c.a
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdFailed ret=" + i + ",msg=" + str);
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdClick iNativeTempletAdView=");
            if (pVar == null) {
                pVar = com.igexin.push.core.b.l;
            }
            sb.append(pVar);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(q qVar, p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderFailed nativeAdError=");
            sb.append(qVar != null ? qVar.toString() : com.igexin.push.core.b.l);
            sb.append("iNativeTempletAdView=");
            if (pVar == null) {
                pVar = com.igexin.push.core.b.l;
            }
            sb.append(pVar);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(List<p> list) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdReady iNativeTempletAdViewList=", list);
        }

        @Override // com.opos.mobad.ad.c.o
        public void b(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdShow iNativeTempletAdView=");
            if (pVar == null) {
                pVar = com.igexin.push.core.b.l;
            }
            sb.append(pVar);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.o
        public void c(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdClose iNativeTempletAdView=");
            if (pVar == null) {
                pVar = com.igexin.push.core.b.l;
            }
            sb.append(pVar);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.o
        public void d(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderSuccess iNativeTempletAdView=");
            if (pVar == null) {
                pVar = com.igexin.push.core.b.l;
            }
            sb.append(pVar);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }
    };

    void a(p pVar);

    void a(q qVar, p pVar);

    void b(p pVar);

    void c(p pVar);

    void d(p pVar);
}
