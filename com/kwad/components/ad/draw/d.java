package com.kwad.components.ad.draw;

import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/d.class */
public final class d {
    public static void loadDrawAd(KsScene ksScene, final KsLoadManager.DrawAdListener drawAdListener) {
        SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a2 = k.pP().a(covert, "loadDrawAd");
        covert.setAdStyle(6);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0357a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void a(AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                        arrayList.add(new c(adTemplate));
                    }
                }
                if (!arrayList.isEmpty()) {
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            KsAdLoadManager.ac().b(arrayList);
                            KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                        }
                    });
                    return;
                }
                onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg + "(无视频资源)" : adResultData.testErrorMsg);
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(final int i, final String str) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.DrawAdListener.this.onError(i, str);
                    }
                });
            }
        }).pj());
    }
}
