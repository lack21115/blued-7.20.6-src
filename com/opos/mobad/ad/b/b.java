package com.opos.mobad.ad.b;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.opos.mobad.ad.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/b/b.class */
public interface b extends i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f25669a = new b() { // from class: com.opos.mobad.ad.b.b.1
        @Override // com.opos.mobad.ad.b.a
        public void a() {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdFailed code:" + i + ", msg:" + str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", IAdInterListener.AdCommandType.AD_CLICK);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdShow");
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdClose");
        }
    };
}
