package com.opos.mobad.ad.e;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.opos.mobad.ad.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/e/c.class */
public interface c extends i.a {
    public static final c b = new c() { // from class: com.opos.mobad.ad.e.c.1
        @Override // com.opos.mobad.ad.b.a
        public void a() {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdFailed code:" + i + ",msg:" + str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            com.opos.cmn.an.f.a.b("ISplashAdListener", IAdInterListener.AdCommandType.AD_CLICK);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdShow " + str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdClose");
        }
    };
}
