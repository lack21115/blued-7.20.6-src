package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/i.class */
public abstract class i extends e {
    private static long ka = 400;
    private com.kwad.components.ad.splashscreen.e.a Cv;
    private Vibrator eg;

    private void kV() {
        if (this.Cg != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.Cv;
            if (aVar == null) {
                this.Cv = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.i.1
                    @Override // com.kwad.components.ad.splashscreen.e.a
                    public final void ac(String str) {
                        i.this.ab(str);
                    }
                };
            } else {
                aVar.setAdTemplate(this.Cg.mAdTemplate);
            }
            com.kwad.components.core.d.b.c cVar = this.Cg.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Cv);
            }
        }
    }

    protected abstract void ab(String str);

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        if (this.Cg == null) {
            return;
        }
        kU();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        kR();
        kP();
        if (com.kwad.sdk.core.response.a.a.ax(cb)) {
            kV();
        }
        kQ();
        kS();
        kT();
    }

    protected abstract void initView();

    protected abstract void kP();

    protected abstract void kQ();

    protected abstract void kR();

    protected abstract void kS();

    protected abstract void kT();

    protected abstract void kU();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void kW() {
        Context context = getContext();
        if (context != null) {
            this.eg = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
        bi.a(getContext(), this.eg);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        bi.b(getContext(), this.eg);
    }
}
