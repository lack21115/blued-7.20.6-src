package com.kwad.components.core.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSRelativeLayout;

@Deprecated
/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/a.class */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    protected boolean Qj;
    private boolean Qk;
    protected boolean Ql;
    private int Qm;
    private int Qn;
    private KSRelativeLayout Qo;
    private RelativeLayout Qp;
    private boolean Qq;
    private boolean Qr;
    private LinearLayout Qs;
    private LinearLayout Qt;
    private ImageView Qu;
    private ViewGroup Qv;
    private TextView Qw;
    private c Qx;
    private InterfaceC0364a Qy;
    private final com.kwad.sdk.core.download.kwai.a Qz;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    protected Context mContext;
    private ProgressBar nH;
    private boolean nK;
    protected ImageView nn;
    protected TextView no;
    private ImageView zr;
    private TextView zs;

    /* renamed from: com.kwad.components.core.video.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/a$a.class */
    public interface InterfaceC0364a {
        void a(int i, ac.a aVar);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/a$b.class */
    public interface b extends c {
        void onVideoPlayError(int i, int i2);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/a$c.class */
    public interface c {
        void bt();

        void d(long j);

        void onVideoPlayStart();

        void onVideoPlaying();
    }

    public a(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.Qk = true;
        this.Ql = false;
        this.Qr = false;
        this.Qz = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.aw(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.aH(a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.by(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.aG(com.kwad.sdk.core.response.a.a.aw(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.T(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.xw());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.Qw.setText(com.kwad.sdk.core.response.a.a.by(i));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        init();
    }

    private void aL(int i) {
        InterfaceC0364a interfaceC0364a = this.Qy;
        if (interfaceC0364a != null) {
            interfaceC0364a.a(i, this.Qo.getTouchCoords());
        }
    }

    private void init() {
        ImageView imageView;
        int i;
        k.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, this);
        this.Qo = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.Qp = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.no = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.nn = imageView2;
        imageView2.setOnClickListener(this);
        this.Qs = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.Qt = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.nH = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.Qu = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String url = com.kwad.sdk.core.response.a.a.bi(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.Qu;
            i = 8;
        } else {
            this.Qu.setImageDrawable(null);
            KSImageLoader.loadImage(this.Qu, url, this.mAdTemplate);
            imageView = this.Qu;
            i = 0;
        }
        imageView.setVisibility(i);
        this.no.setText(bg.I(com.kwad.sdk.core.response.a.a.F(this.mAdInfo) * 1000));
        pT();
    }

    private void pU() {
        ViewGroup viewGroup = this.Qv;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void pY() {
        this.Qp.setVisibility(8);
    }

    private void setTopBottomVisible(boolean z) {
        if (this.Qr) {
            return;
        }
        this.nH.setVisibility(z ? 0 : 8);
        this.Qq = z;
    }

    public final void aG(String str) {
        ((TextView) findViewById(R.id.ksad_app_download)).setText(str);
    }

    public final void aM(boolean z) {
        if (this.Qr) {
            return;
        }
        if (!z) {
            this.nH.setVisibility(8);
        } else if (this.Qq) {
            this.nH.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eU() {
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
            this.zr = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
            this.zs = (TextView) findViewById(R.id.ksad_app_name);
            this.Qw = (TextView) findViewById(R.id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.zr, com.kwad.sdk.core.response.a.d.cg(this.mAdTemplate), this.mAdTemplate, 12);
            this.zs.setText(com.kwad.sdk.core.response.a.a.bK(this.mAdInfo));
            this.Qw.setText(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo));
            this.Qv = linearLayout;
            this.zr.setOnClickListener(this);
            this.zs.setOnClickListener(this);
            this.Qw.setOnClickListener(this);
            com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.b(this.Qz);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
            TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
            this.Qw = textView;
            textView.setText(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo));
            this.Qw.setOnClickListener(this);
            this.Qv = linearLayout2;
        }
        this.Qv.setOnClickListener(this);
        this.Qv.setVisibility(0);
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void m(int i, int i2) {
        this.Qn = i2;
        this.Qm = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.nn) {
            this.Qj = true;
            this.Qk = true;
            pZ();
        } else if (view == this.zr) {
            aL(1);
        } else if (view == this.zs) {
            aL(2);
        } else if (view == this.Qw) {
            aL(3);
        } else {
            aL(4);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i) {
        com.kwad.sdk.core.d.b.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
        if (i == -1) {
            qj();
            setTopBottomVisible(false);
            this.Qs.setVisibility(8);
            this.Qt.setVisibility(0);
            c cVar = this.Qx;
            if (cVar instanceof f.a) {
                ((f.a) cVar).onVideoPlayError(this.Qm, this.Qn);
            }
            c cVar2 = this.Qx;
            if (cVar2 instanceof b) {
                ((b) cVar2).onVideoPlayError(this.Qm, this.Qn);
            }
            com.kwad.components.core.m.a.pb().b(this.mAdTemplate, this.Qm, this.Qn);
        } else if (i == 4) {
            c cVar3 = this.Qx;
            if (cVar3 != null) {
                cVar3.onVideoPlaying();
            }
            this.Qu.setVisibility(8);
        } else if (i == 9) {
            c cVar4 = this.Qx;
            if (cVar4 != null) {
                cVar4.bt();
            }
            qj();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.Qu, com.kwad.sdk.core.response.a.a.O(this.mAdInfo), this.mAdTemplate);
            this.Qu.setVisibility(0);
            eU();
        } else if (i == 1) {
            pY();
            this.Qs.setVisibility(8);
            this.Qt.setVisibility(8);
            this.nH.setVisibility(8);
            pU();
        } else if (i != 2) {
        } else {
            c cVar5 = this.Qx;
            if (cVar5 != null) {
                cVar5.onVideoPlayStart();
            }
            setTopBottomVisible(true);
            qi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pV() {
        this.Qs.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pW() {
        this.Qs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pX() {
        this.Qp.setVisibility(0);
        this.Qu.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pZ() {
        if (!this.anr.isIdle()) {
            if (this.anr.isPaused() || this.anr.yr()) {
                qa();
                this.anr.restart();
            }
        } else if (!ag.isNetworkConnected(this.mContext)) {
            pV();
        } else {
            pW();
            if (!this.Ql && ((!this.Qk || !ag.isWifiConnected(this.mContext)) && (!this.Qk || (!this.nK && !this.Qj)))) {
                pX();
                return;
            }
            qa();
            this.anr.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void qa() {
        this.anr.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qb() {
        this.anr.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void qc() {
        long currentPosition = this.anr.getCurrentPosition();
        long duration = this.anr.getDuration();
        this.nH.setSecondaryProgress(this.anr.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.nH.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        c cVar = this.Qx;
        if (cVar != null) {
            cVar.d(currentPosition);
        }
    }

    public final void qd() {
        this.Qr = true;
        this.nH.setVisibility(8);
    }

    public void release() {
        this.anr.release();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void reset() {
        qj();
        this.nH.setProgress(0);
        this.nH.setSecondaryProgress(0);
        pY();
        this.Qs.setVisibility(8);
        this.Qt.setVisibility(8);
        this.nH.setVisibility(8);
        this.Qu.setVisibility(8);
        this.Qp.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        pU();
    }

    public void setAdClickListener(InterfaceC0364a interfaceC0364a) {
        this.Qy = interfaceC0364a;
    }

    public void setCanControlPlay(boolean z) {
        this.Ql = z;
    }

    public void setDataAutoStart(boolean z) {
        this.Qk = z;
    }

    public void setDataFlowAutoStart(boolean z) {
        this.nK = z;
    }

    public void setVideoPlayCallback(c cVar) {
        this.Qx = cVar;
    }
}
