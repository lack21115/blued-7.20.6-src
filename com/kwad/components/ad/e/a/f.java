package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/a/f.class */
public final class f extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    private ImageView dJ;
    private TextView dK;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ViewGroup nv;
    private TextView nw;
    private KsAppDownloadListener nx = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.e.a.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.nw.setText(com.kwad.sdk.core.response.a.a.aw(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.nw.setText(com.kwad.sdk.core.response.a.a.aH(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.nw.setText(com.kwad.sdk.core.response.a.a.aw(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.nw.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
        }
    };

    private void J(int i) {
        com.kwad.components.core.d.b.a.a(new a.C0519a(this.nv.getContext()).I(this.mAdTemplate).ap(i).b(this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.ad.e.a.f.3
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(f.this.mAdTemplate, 2, f.this.ni.nd.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eU() {
        KSImageLoader.loadAppIcon(this.dJ, com.kwad.sdk.core.response.a.a.bM(this.mAdInfo), this.mAdTemplate, 12);
        this.dK.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
        this.nw.setText(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo));
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.nx);
        }
        this.nv.setOnClickListener(this);
        this.nv.setVisibility(0);
    }

    private void notifyAdClick() {
        this.ni.mR.l(this.nv);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdTemplate adTemplate = this.ni.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mApkDownloadHelper = this.ni.mApkDownloadHelper;
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.f.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                try {
                    f.this.eU();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    com.kwad.components.core.c.a.b(th);
                }
            }
        };
        this.ni.nj.a(this.mVideoPlayStateListener);
        this.nv.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.nv) {
            J(2);
            notifyAdClick();
        } else if (view == this.nw) {
            J(1);
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nv = (ViewGroup) findViewById(R.id.ksad_video_complete_app_container);
        this.dJ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dK = (TextView) findViewById(R.id.ksad_app_name);
        this.nw = (TextView) findViewById(R.id.ksad_app_download);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.nx);
        }
    }
}
