package com.opos.mobad.ad.c;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/m.class */
public interface m extends f, com.opos.mobad.ad.f, com.opos.mobad.ad.h {

    /* renamed from: c  reason: collision with root package name */
    public static final m f11983c = new m() { // from class: com.opos.mobad.ad.c.m.1
        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.f
        public void a(String str) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onInstallCompleted pkgName=" + str);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdReady =", list);
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReward objects=");
            if (objArr == null) {
                objArr = com.igexin.push.core.b.l;
            }
            sb.append(objArr);
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.m
        public void b(Object... objArr) {
        }
    };

    void b(Object... objArr);
}
