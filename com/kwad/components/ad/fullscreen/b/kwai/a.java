package com.kwad.components.ad.fullscreen.b.kwai;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bm;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/b/kwai/a.class */
public final class a extends com.kwad.components.ad.reward.presenter.a implements bm.a {
    private TextView gI;
    private View gJ;
    private bm gK;
    private boolean gL;
    private long gM;
    private AdInfo mAdInfo;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.fullscreen.b.kwai.a.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", a.this.qt.mAdTemplate).equals(str)) {
                a.this.cc();
            }
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.a.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.gL) {
                return;
            }
            a.this.gK.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j) {
            super.onLivePlayProgress(j);
            if (j > 800) {
                a.this.gM = j;
                if (a.this.gM > 30000) {
                    a.this.gI.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.gJ.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.kwai.a.a(a.this.getContext(), 0.0f);
                    a.this.gJ.setLayoutParams(marginLayoutParams);
                }
                a.this.a(30000L, j);
                a.a(a.this, true);
            }
        }
    };
    private i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.fullscreen.b.kwai.a.3
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            a.this.a(j, j2);
            a.this.gM = j2;
        }
    };

    private void A(int i) {
        this.gI.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        A(Math.max((int) ((((float) (j - j2)) / 1000.0f) + 0.5f), 0));
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.gL = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc() {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        this.mAdInfo = cb;
        this.gI.setText(String.valueOf(com.kwad.sdk.core.response.a.a.F(cb)));
        this.gI.setVisibility(0);
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (this.qt.fW() || this.qt.fV()) {
                this.gK.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            long j = this.gM + 500;
            this.gM = j;
            if (j <= 30000) {
                a(30000L, j);
                this.gK.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.gI.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gJ.getLayoutParams();
            marginLayoutParams.leftMargin = com.kwad.sdk.c.kwai.a.a(getContext(), 0.0f);
            this.gJ.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.gK = new bm(this);
        if (com.kwad.components.ad.reward.j.c(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
            return;
        }
        cc();
        if (this.qt.oN.jF()) {
            A(30);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gI = (TextView) findViewById(R.id.ksad_video_count_down);
        this.gJ = findViewById(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.gL = false;
        this.gK.removeCallbacksAndMessages(null);
    }
}
