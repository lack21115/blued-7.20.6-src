package com.kwad.components.ad.draw.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a/b.class */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    private ImageView cr;
    private com.kwad.sdk.core.response.model.b cs;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.draw.a.b.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            if (b.this.cr.getVisibility() == 0) {
                b.this.cr.setVisibility(8);
            }
        }
    };
    private Runnable ct = new Runnable() { // from class: com.kwad.components.ad.draw.a.b.2
        @Override // java.lang.Runnable
        public final void run() {
            int width = b.this.getRootView().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.cr.getLayoutParams();
            int width2 = b.this.cs.getWidth();
            int height = b.this.cs.getHeight();
            if (width2 == 0 || height == 0 || height > width2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.cr.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((height / (width2 * 1.0f)) * width);
                b.this.cr.setLayoutParams(layoutParams);
                b.this.cr.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            b.this.cr.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.cr, b.this.cs.getUrl(), b.this.bW.mAdTemplate);
        }
    };

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.response.model.b bi = com.kwad.sdk.core.response.a.a.bi(com.kwad.sdk.core.response.a.d.cb(this.bW.mAdTemplate));
        this.cs = bi;
        if (TextUtils.isEmpty(bi.getUrl())) {
            return;
        }
        getRootView().post(this.ct);
        this.cr.setVisibility(0);
        this.bW.bX.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cr = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.ct);
        this.bW.bX.b(this.mVideoPlayStateListener);
    }
}
