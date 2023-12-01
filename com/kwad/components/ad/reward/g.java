package com.kwad.components.ad.reward;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/g.class */
public final class g extends com.kwad.components.ad.i.b {
    private List<AdTemplate> oF;
    private boolean oG;
    private List<com.kwad.components.core.d.b.c> oH;
    private o.b oI;

    public g(List<AdTemplate> list, JSONObject jSONObject, o.b bVar) {
        super(jSONObject, null);
        this.oG = false;
        this.oH = new ArrayList();
        this.oF = list;
        this.oI = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (AdTemplate adTemplate : this.oF) {
            this.oH.add(new com.kwad.components.core.d.b.c(adTemplate));
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.d.b.c cVar, int i) {
        super.a(frameLayout, adBaseFrameLayout, this.oF, this.oH, i);
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.oF;
        com.kwad.components.core.webview.jshandler.o oVar = new com.kwad.components.core.webview.jshandler.o(new ArrayList(list.subList(1, list.size() - 1)));
        oVar.a(this.oI);
        aVar.a(oVar);
    }

    @Override // com.kwad.components.ad.i.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.oF);
    }

    @Override // com.kwad.components.ad.i.b
    public final boolean bE() {
        return this.oG ? this.GB : super.bE();
    }

    @Override // com.kwad.components.ad.i.b
    public final void fq() {
        super.fq();
        this.cS.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.g.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    @Override // com.kwad.components.ad.i.b
    public final boolean fr() {
        return false;
    }

    public final void fs() {
        if (this.mCardLifecycleHandler != null) {
            this.mCardLifecycleHandler.ra();
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void ft() {
        com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.i.b
    public final void fu() {
        com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card", l(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.i.b
    public final void fv() {
        com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card", l(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.i.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    @Override // com.kwad.components.ad.i.b
    public final String l(AdTemplate adTemplate) {
        List<AdTemplate> list = this.oF;
        if (list == null || list.size() < 2) {
            return super.l(adTemplate);
        }
        String aT = com.kwad.sdk.core.response.a.b.aT(this.oF.get(1));
        new StringBuilder("getUrl: ").append(aT);
        return aT;
    }

    public final void z(boolean z) {
        this.oG = z;
    }
}
