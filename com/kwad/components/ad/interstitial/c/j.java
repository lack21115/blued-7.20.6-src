package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/j.class */
public final class j extends b implements com.kwad.sdk.widget.c {
    private List<Integer> cI;
    private KsAdVideoPlayConfig dZ;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private c jt;
    private KSFrameLayout ke;
    private KSFrameLayout kf;
    private com.kwad.components.core.video.f lp;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    protected Context mContext;
    private boolean mIsAudioEnable = false;
    private h ko = new h() { // from class: com.kwad.components.ad.interstitial.c.j.1
        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dA() {
            try {
                j.this.lp.pZ();
            } catch (Throwable th) {
            }
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dB() {
            try {
                j.this.lp.qb();
            } catch (Throwable th) {
            }
        }
    };
    private final a.InterfaceC0534a eS = new a.InterfaceC0534a() { // from class: com.kwad.components.ad.interstitial.c.j.4
        /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
        @Override // com.kwad.components.core.video.a.InterfaceC0534a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(int r6, com.kwad.sdk.utils.ac.a r7) {
            /*
                r5 = this;
                r0 = 2
                r9 = r0
                r0 = 0
                r11 = r0
                r0 = r6
                r1 = 1
                if (r0 == r1) goto L2c
                r0 = r6
                r1 = 2
                if (r0 == r1) goto L26
                r0 = r6
                r1 = 3
                if (r0 == r1) goto L1b
                r0 = 108(0x6c, float:1.51E-43)
                r6 = r0
                goto L2f
            L1b:
                r0 = 83
                r8 = r0
                r0 = 1
                r11 = r0
                r0 = 1
                r6 = r0
                goto L37
            L26:
                r0 = 82
                r6 = r0
                goto L2f
            L2c:
                r0 = 13
                r6 = r0
            L2f:
                r0 = 2
                r10 = r0
                r0 = r6
                r8 = r0
                r0 = r10
                r6 = r0
            L37:
                com.kwad.sdk.core.report.y$b r0 = new com.kwad.sdk.core.report.y$b
                r1 = r0
                r1.<init>()
                r12 = r0
                r0 = r12
                r1 = r7
                r0.jW = r1
                r0 = r12
                r1 = r8
                r0.jU = r1
                r0 = r5
                com.kwad.components.ad.interstitial.c.j r0 = com.kwad.components.ad.interstitial.c.j.this
                android.content.Context r0 = com.kwad.components.ad.interstitial.c.j.e(r0)
                boolean r0 = com.kwad.sdk.utils.ai.DL()
                if (r0 == 0) goto L60
                r0 = r9
                r8 = r0
                goto L62
            L60:
                r0 = 1
                r8 = r0
            L62:
                r0 = r12
                r1 = r8
                r0.ako = r1
                com.kwad.components.core.d.b.a$a r0 = new com.kwad.components.core.d.b.a$a
                r1 = r0
                r2 = r5
                com.kwad.components.ad.interstitial.c.j r2 = com.kwad.components.ad.interstitial.c.j.this
                android.content.Context r2 = com.kwad.components.ad.interstitial.c.j.h(r2)
                r1.<init>(r2)
                r1 = r5
                com.kwad.components.ad.interstitial.c.j r1 = com.kwad.components.ad.interstitial.c.j.this
                com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.interstitial.c.j.c(r1)
                com.kwad.components.core.d.b.a$a r0 = r0.I(r1)
                r1 = r5
                com.kwad.components.ad.interstitial.c.j r1 = com.kwad.components.ad.interstitial.c.j.this
                com.kwad.components.core.d.b.c r1 = com.kwad.components.ad.interstitial.c.j.g(r1)
                com.kwad.components.core.d.b.a$a r0 = r0.b(r1)
                r1 = r6
                com.kwad.components.core.d.b.a$a r0 = r0.ap(r1)
                r1 = r11
                com.kwad.components.core.d.b.a$a r0 = r0.ao(r1)
                r1 = 1
                com.kwad.components.core.d.b.a$a r0 = r0.aq(r1)
                r1 = r12
                com.kwad.components.core.d.b.a$a r0 = r0.a(r1)
                com.kwad.components.ad.interstitial.c.j$4$1 r1 = new com.kwad.components.ad.interstitial.c.j$4$1
                r2 = r1
                r3 = r5
                r2.<init>()
                com.kwad.components.core.d.b.a$a r0 = r0.a(r1)
                int r0 = com.kwad.components.core.d.b.a.a(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.c.j.AnonymousClass4.a(int, com.kwad.sdk.utils.ac$a):void");
        }
    };

    private c.b a(View view, boolean z) {
        return new c.b(view.getContext()).k(z).a(this.ke.getTouchCoords()).C(3).D(85);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cI.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private void eg() {
        ImageView imageView;
        int i;
        this.mIsAudioEnable = this.dZ.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.a.a.bi(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.eM;
            i = 8;
        } else {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            imageView = this.eM;
            i = 0;
        }
        imageView.setVisibility(i);
        int ux = com.kwad.sdk.core.config.d.ux();
        String E = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
        if (TextUtils.isEmpty(E)) {
            return;
        }
        if (ux < 0) {
            File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(E);
            E = (aX == null || !aX.exists()) ? null : aX.getAbsolutePath();
        } else if (ux != 0) {
            E = com.kwad.sdk.core.videocache.b.a.ba(this.mContext).cS(E);
        }
        if (TextUtils.isEmpty(E)) {
            return;
        }
        this.eN.a(new b.a(this.mAdTemplate).bs(E).bt(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).tR(), null);
        this.eN.setVideoSoundEnable(this.mIsAudioEnable);
        this.lp.setVideoPlayCallback(new f.a() { // from class: com.kwad.components.ad.interstitial.c.j.2
            private boolean cJ = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                com.kwad.sdk.core.report.a.av(j.this.mAdTemplate);
                if (!j.this.jt.jy && j.this.jt.hN != null) {
                    j.this.jt.hN.onVideoPlayEnd();
                }
                for (a.c cVar : j.this.jt.jF) {
                    cVar.bt();
                }
                j.this.jt.jH = true;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                j.this.c(j);
                for (a.c cVar : j.this.jt.jF) {
                    cVar.d(j);
                }
            }

            @Override // com.kwad.components.core.video.f.a
            public final void onVideoPlayError(int i2, int i3) {
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.a(j.this.mAdTemplate, i2, String.valueOf(i3));
                if (j.this.jt.hN != null) {
                    j.this.jt.hN.onVideoPlayError(i2, i3);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.report.a.h(j.this.mAdTemplate);
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.h(j.this.mAdTemplate);
                if (!j.this.jt.jy && j.this.jt.hN != null) {
                    j.this.jt.hN.onVideoPlayStart();
                }
                for (a.c cVar : j.this.jt.jF) {
                    cVar.onVideoPlayStart();
                }
                j.this.jt.jH = false;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (!this.cJ) {
                    this.cJ = true;
                    com.kwad.components.core.m.a.pb().a(j.this.mAdTemplate, System.currentTimeMillis(), 0);
                }
                for (a.c cVar : j.this.jt.jF) {
                    cVar.onVideoPlaying();
                }
            }
        });
        this.eN.setController(this.lp);
        this.kf.setClickable(true);
        new com.kwad.sdk.widget.f(this.kf.getContext(), this.kf, this);
        this.kf.addView(this.eN);
        this.jt.jD = new c.d() { // from class: com.kwad.components.ad.interstitial.c.j.3
            @Override // com.kwad.components.ad.interstitial.c.c.d
            public final void dh() {
                if (j.this.eN != null) {
                    j.this.eN.restart();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh() {
        if (!this.jt.jy && this.jt.hN != null) {
            this.jt.hN.onAdClicked();
        }
        this.jt.jw = true;
        if (this.jt.jy) {
            return;
        }
        this.jt.cr();
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.jt.a(a(view, true));
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        c cVar = (c) Bh();
        this.jt = cVar;
        this.dZ = cVar.dZ;
        AdTemplate adTemplate = this.jt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mAdInfo = cb;
        this.cI = com.kwad.sdk.core.response.a.a.bd(cb);
        com.kwad.sdk.core.video.videoview.a aVar = this.jt.eN;
        this.eN = aVar;
        aVar.setTag(this.cI);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.eN);
        this.lp = fVar;
        fVar.setDataFlowAutoStart(this.dZ.isDataFlowAutoStart());
        this.lp.setAdClickListener(this.eS);
        this.lp.qd();
        this.mApkDownloadHelper = this.jt.mApkDownloadHelper;
        eg();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.kf.setRadius(dimension, dimension, 0.0f, 0.0f);
        this.jt.a(this.ko);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.jt.a(a(view, false));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ke = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.kf = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.eM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.kf.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jt.jD = null;
        this.jt.b(this.ko);
    }
}
