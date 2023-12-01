package com.kwad.components.ad.draw.a;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a/a.class */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    private ComplianceTextView cq;

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cq.setVisibility(0);
        this.cq.setAdTemplate(this.bW.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cq = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
    }
}
