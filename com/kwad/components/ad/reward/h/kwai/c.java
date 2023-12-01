package com.kwad.components.ad.reward.h.kwai;

import android.text.TextUtils;
import com.kwad.components.ad.reward.b.f;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.sdk.components.l;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/kwai/c.class */
public final class c extends com.kwad.components.core.webview.a.b.c implements e {
    private a xg;

    public final void a(com.kwad.components.ad.reward.b.b bVar) {
        a aVar = this.xg;
        if (aVar != null) {
            aVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.a.b.a
    public final h hN() {
        a aVar = (a) this.Vr;
        this.xg = aVar;
        return new d(aVar.jd(), this.xg.mPlayedDuration, getContext());
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
        super.onAdClicked(aVar);
        a aVar2 = this.xg;
        if (aVar2 == null || aVar2.jd() == null) {
            return;
        }
        this.xg.jd().mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.h.kwai.c.1
            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                com.kwad.sdk.core.d.b.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.gT());
                c.this.a(bVar2);
            }
        }));
        lVar.c(new com.kwad.components.core.webview.jshandler.e(new i() { // from class: com.kwad.components.ad.reward.h.kwai.c.2
            @Override // com.kwad.components.core.webview.jshandler.i
            public final void a(com.kwad.components.core.webview.jshandler.e eVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    eVar.a(com.kwad.components.ad.reward.b.a.gQ().gR());
                    com.kwad.components.ad.reward.b.a.gQ().a(eVar);
                }
            }
        }));
    }
}
