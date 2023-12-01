package com.kwad.components.ad.interstitial.aggregate;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.core.n.h;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/c.class */
public final class c {
    private volatile boolean iq;
    private m<com.kwad.components.core.n.a, AdResultData> ir;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/c$1.class */
    public final class AnonymousClass1 extends h {
        final /* synthetic */ SceneImpl el;
        final /* synthetic */ long hR;
        final /* synthetic */ b is;

        AnonymousClass1(SceneImpl sceneImpl, b bVar, long j) {
            this.el = sceneImpl;
            this.is = bVar;
            this.hR = j;
        }

        @Override // com.kwad.components.core.n.i
        public final void a(final AdResultData adResultData) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    final ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = AnonymousClass1.this.el;
                            }
                            arrayList.add(adTemplate);
                        }
                    }
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.is.onInterstitialAdLoad(arrayList);
                            c cVar = c.this;
                            c.a(adResultData, AnonymousClass1.this.hR);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.n.i
        public final void onError(final int i, final String str) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/c$a.class */
    public static final class a {
        private static c iy = new c((byte) 0);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/c$b.class */
    public interface b {
        void onInterstitialAdLoad(List<AdTemplate> list);
    }

    private c() {
        this.iq = false;
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private void a(com.kwad.components.core.n.kwai.b bVar, final h hVar) {
        com.kwad.components.core.k.a aVar = new com.kwad.components.core.k.a(bVar);
        this.ir = aVar;
        aVar.request(new p<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.aggregate.c.2
            private void b(AdResultData adResultData) {
                c.a(c.this, false);
                if (adResultData.isAdResultDataEmpty()) {
                    hVar.onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                } else {
                    hVar.a(adResultData);
                }
            }

            private void e(int i, String str) {
                c.a(c.this, false);
                hVar.onError(i, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(g gVar, int i, String str) {
                e(i, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(g gVar, BaseResultData baseResultData) {
                b((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.m.a.pb().c(adTemplate, elapsedRealtime - j);
    }

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.iq = false;
        return false;
    }

    public static c cA() {
        return a.iy;
    }

    public final void a(int i, int i2, SceneImpl sceneImpl, b bVar) {
        if (this.iq) {
            return;
        }
        SceneImpl m4840clone = sceneImpl.m4840clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m4840clone.setAdStyle(16);
        m4840clone.setAdNum(i2);
        a(new com.kwad.components.core.n.kwai.b(m4840clone), new AnonymousClass1(sceneImpl, bVar, elapsedRealtime));
    }

    public final void release() {
        m<com.kwad.components.core.n.a, AdResultData> mVar = this.ir;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
