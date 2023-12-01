package com.kwad.components.ad.interstitial.c;

import android.view.OrientationEventListener;
import android.view.View;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/a.class */
public final class a extends b {
    private ComplianceTextView jo;
    private OrientationEventListener jp;
    private KsAutoCloseView jq;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final c cVar) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(cVar.hU.getContext()) { // from class: com.kwad.components.ad.interstitial.c.a.2
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i) {
                a.this.b(cVar);
            }
        };
        this.jp = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            this.jp.enable();
        } else {
            this.jp.disable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        h(this.jo);
        if (ai.DM()) {
            com.kwad.sdk.c.kwai.a.b(this.jq, 0, com.kwad.sdk.c.kwai.a.a(getContext(), 25.0f), 0, 0);
        } else {
            com.kwad.sdk.c.kwai.a.b(this.jq, 0, 0, 0, 0);
        }
        this.jo.setVisibility(0);
        this.jo.setAdTemplate(cVar.mAdTemplate);
    }

    private void h(View view) {
        int a2 = com.kwad.sdk.c.kwai.a.a(getContext(), 4.0f);
        int a3 = com.kwad.sdk.c.kwai.a.a(getContext(), 4.0f);
        com.kwad.sdk.c.kwai.a.b(view, a3, a2, a3, 0);
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        final c cVar = (c) Bh();
        cVar.a(new c.e() { // from class: com.kwad.components.ad.interstitial.c.a.1
            @Override // com.kwad.components.ad.interstitial.c.c.e
            public final void onError() {
                a.this.b(cVar);
                a.this.a(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jo = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.jq = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.jp;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }
}
