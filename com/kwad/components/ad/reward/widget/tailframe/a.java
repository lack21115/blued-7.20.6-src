package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/widget/tailframe/a.class */
public abstract class a implements c {
    protected View AV;
    protected ImageView AW;
    private com.kwad.components.ad.widget.tailframe.appbar.a AX;
    private TailFrameBarH5View AY;
    private b AZ;
    private TextProgressBar Ba;
    private View Bb;
    private int Bc;
    private TextView dR;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private j qt;

    public a(int i) {
        this.Bc = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
        r9 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.view.View r7, final boolean r8) {
        /*
            r6 = this;
            r0 = r6
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.mAdTemplate
            boolean r0 = com.kwad.sdk.core.response.a.d.p(r0)
            r12 = r0
            r0 = 2
            r9 = r0
            r0 = 1
            r11 = r0
            r0 = r12
            if (r0 == 0) goto L47
            r0 = r8
            if (r0 == 0) goto L1d
            r0 = 1
            r10 = r0
            goto L22
        L1d:
            r0 = 153(0x99, float:2.14E-43)
            r10 = r0
        L22:
            r0 = r6
            com.kwad.components.ad.reward.j r0 = r0.qt
            r13 = r0
            r0 = r6
            android.view.View r0 = r0.AV
            android.content.Context r0 = r0.getContext()
            r14 = r0
            r0 = r7
            r1 = r6
            android.view.View r1 = r1.Bb
            if (r0 != r1) goto L3b
            r0 = 1
            r9 = r0
        L3b:
            r0 = r13
            r1 = 1
            r2 = r14
            r3 = r10
            r4 = r9
            r0.a(r1, r2, r3, r4)
            return
        L47:
            r0 = r6
            com.kwad.sdk.core.response.model.AdInfo r0 = r0.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.a.a.ax(r0)
            if (r0 == 0) goto L5e
            r0 = r7
            r1 = r6
            com.kwad.components.core.page.widget.TextProgressBar r1 = r1.Ba
            if (r0 != r1) goto L69
        L59:
            r0 = 1
            r9 = r0
            goto L69
        L5e:
            r0 = r7
            r1 = r6
            android.widget.TextView r1 = r1.dR
            if (r0 != r1) goto L69
            goto L59
        L69:
            com.kwad.components.core.d.b.a$a r0 = new com.kwad.components.core.d.b.a$a
            r1 = r0
            r2 = r7
            android.content.Context r2 = r2.getContext()
            r1.<init>(r2)
            r1 = r6
            com.kwad.sdk.core.response.model.AdTemplate r1 = r1.mAdTemplate
            com.kwad.components.core.d.b.a$a r0 = r0.I(r1)
            r1 = r6
            com.kwad.components.core.d.b.c r1 = r1.mApkDownloadHelper
            com.kwad.components.core.d.b.a$a r0 = r0.b(r1)
            r13 = r0
            r0 = r9
            r1 = 1
            if (r0 != r1) goto L8f
            r0 = 1
            r10 = r0
            goto L92
        L8f:
            r0 = 0
            r10 = r0
        L92:
            r0 = r13
            r1 = r10
            com.kwad.components.core.d.b.a$a r0 = r0.ao(r1)
            r1 = 1
            com.kwad.components.core.d.b.a$a r0 = r0.an(r1)
            r13 = r0
            r0 = r7
            r1 = r6
            com.kwad.components.core.page.widget.TextProgressBar r1 = r1.Ba
            if (r0 != r1) goto Laa
            goto Lad
        Laa:
            r0 = 0
            r11 = r0
        Lad:
            r0 = r13
            r1 = r11
            com.kwad.components.core.d.b.a$a r0 = r0.ao(r1)
            r1 = r9
            com.kwad.components.core.d.b.a$a r0 = r0.ap(r1)
            com.kwad.components.ad.reward.widget.tailframe.a$2 r1 = new com.kwad.components.ad.reward.widget.tailframe.a$2
            r2 = r1
            r3 = r6
            r4 = r8
            r2.<init>()
            com.kwad.components.core.d.b.a$a r0 = r0.a(r1)
            int r0 = com.kwad.components.core.d.b.a.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.widget.tailframe.a.b(android.view.View, boolean):void");
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.aw(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.aH(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.aw(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.T(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.bz(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.by(i), i);
            }
        });
    }

    private void ke() {
        this.AV.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    private void kg() {
        if (!com.kwad.sdk.core.response.a.a.ax(this.mAdInfo) && !d.p(this.mAdTemplate)) {
            this.AY.bindView(this.mAdTemplate);
            TextView h5OpenBtn = this.AY.getH5OpenBtn();
            this.dR = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.AY.setVisibility(0);
            new f(this.dR, this);
            return;
        }
        this.AX.bindView(this.mAdTemplate);
        this.AX.setVisibility(0);
        this.Ba = this.AX.getTextProgressBar();
        if (!d.p(this.mAdTemplate)) {
            this.Ba.setClickable(true);
            new f(this.Ba, this);
            bindDownloadListener();
            return;
        }
        View btnInstallContainer = this.AX.getBtnInstallContainer();
        this.Bb = btnInstallContainer;
        btnInstallContainer.setClickable(true);
        new f(this.Bb, this);
    }

    public void D(Context context) {
        View a2 = k.a(context, this.Bc, null, false);
        this.AV = a2;
        this.AW = (ImageView) a2.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.AV.findViewById(R.id.ksad_video_tf_logo);
        this.AX = (com.kwad.components.ad.widget.tailframe.appbar.a) this.AV.findViewById(R.id.ksad_video_app_tail_frame);
        this.AY = (TailFrameBarH5View) this.AV.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    public void a(AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        this.mReportExtData = jSONObject;
        this.AZ = bVar;
        this.mLogoView.S(this.mAdTemplate);
        kg();
        this.AV.setClickable(true);
        new f(this.AV, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public final void d(boolean z, boolean z2) {
        this.AY.e(z, z2);
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.AX;
        if (aVar != null) {
            aVar.ki();
            this.AX.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.AY;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.ki();
            this.AY.setVisibility(8);
        }
        ke();
    }

    public final void jJ() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.AX;
        if (aVar != null) {
            aVar.ki();
        }
        TailFrameBarH5View tailFrameBarH5View = this.AY;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.ki();
        }
    }

    public final View kf() {
        return this.AV;
    }

    public final void setCallerContext(j jVar) {
        this.qt = jVar;
    }
}
