package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/a/h.class */
public final class h extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    private ViewGroup nB;
    private TextView nC;

    /* JADX INFO: Access modifiers changed from: private */
    public void eU() {
        this.nC.setText(com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(this.ni.mAdTemplate)));
        this.nB.setOnClickListener(this);
        this.nB.setVisibility(0);
    }

    private void eW() {
        com.kwad.components.core.d.b.a.a(new a.C0519a(this.nB.getContext()).I(this.ni.mAdTemplate).ap(2).a(new a.b() { // from class: com.kwad.components.ad.e.a.h.2
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(h.this.ni.mAdTemplate, 2, h.this.ni.nd.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.ni.mR.l(this.nB);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.h.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                h.this.eU();
            }
        };
        this.ni.nj.a(this.mVideoPlayStateListener);
        this.nB.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        eW();
        notifyAdClick();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nB = (ViewGroup) findViewById(R.id.ksad_video_complete_h5_container);
        this.nC = (TextView) findViewById(R.id.ksad_h5_open);
    }
}
