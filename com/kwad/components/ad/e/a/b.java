package com.kwad.components.ad.e.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/a/b.class */
public final class b extends com.kwad.components.ad.e.kwai.a {
    private ImageView cr;
    private com.kwad.sdk.core.response.model.b cs;
    private Runnable ct = new Runnable() { // from class: com.kwad.components.ad.e.a.b.2
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.c.kwai.a.d(b.this.cr, b.this.cs.getWidth(), b.this.cs.getHeight());
            b.this.cr.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.cr, b.this.cs.getUrl(), b.this.ni.mAdTemplate);
        }
    };

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.response.model.b bi = com.kwad.sdk.core.response.a.a.bi(com.kwad.sdk.core.response.a.d.cb(this.ni.mAdTemplate));
        this.cs = bi;
        if (TextUtils.isEmpty(bi.getUrl())) {
            return;
        }
        getRootView().post(this.ct);
        this.cr.setVisibility(0);
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.b.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                if (b.this.cr.getVisibility() == 0) {
                    b.this.cr.setVisibility(8);
                }
            }
        };
        this.ni.nj.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cr = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.ct);
    }
}
