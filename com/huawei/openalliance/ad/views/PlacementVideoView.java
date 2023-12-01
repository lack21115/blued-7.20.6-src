package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gq;
import com.huawei.hms.ads.gr;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.gt;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.hd;
import com.huawei.hms.ads.hr;
import com.huawei.hms.ads.hv;
import com.huawei.hms.ads.ih;
import com.huawei.hms.ads.jt;
import com.huawei.hms.ads.kg;
import com.huawei.hms.ads.lo;
import com.huawei.hms.ads.placement.R;
import com.huawei.openalliance.ad.inter.data.r;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PlacementVideoView.class */
public class PlacementVideoView extends PlacementMediaView implements hr, lo {
    private kg D;
    private VideoView L;

    /* renamed from: a  reason: collision with root package name */
    private boolean f9426a;
    private r b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9427c;
    private boolean d;
    private long e;
    private long f;
    private boolean g;
    private boolean h;
    private int i;
    private hd j;
    private ih k;
    private gn l;
    private gr m;
    private gs n;
    private go o;

    public PlacementVideoView(Context context) {
        super(context);
        this.d = true;
        this.k = new hv();
        this.l = new gn() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.1
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                if (ge.Code()) {
                    ge.Code(PlacementVideoView.this.getTAG(), "contentId: %s onBufferingStart", PlacementVideoView.this.I);
                }
                PlacementVideoView.this.j.V();
                PlacementVideoView.this.k.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                PlacementVideoView.this.k.c();
            }
        };
        this.m = new gr() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i, int i2) {
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
                if (ge.Code()) {
                    ge.Code(PlacementVideoView.this.getTAG(), "contentId: %s onMediaStart:  %s", PlacementVideoView.this.I, Integer.valueOf(i));
                }
                PlacementVideoView.this.g = true;
                PlacementVideoView.this.f = i;
                PlacementVideoView.this.e = System.currentTimeMillis();
                kg kgVar = PlacementVideoView.this.D;
                if (i > 0) {
                    kgVar.V();
                    return;
                }
                kgVar.Code();
                PlacementVideoView.this.D.Code(PlacementVideoView.this.j.B(), PlacementVideoView.this.j.Z(), PlacementVideoView.this.e);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PlacementVideoView", "onMediaStop");
                PlacementVideoView.this.Code(i, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PlacementVideoView", "onMediaPause");
                PlacementVideoView.this.Code(i, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PlacementVideoView", "onMediaCompletion");
                PlacementVideoView.this.Code(i, true);
            }
        };
        this.n = new gs() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.3
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("n");
                    PlacementVideoView.this.k.V(0.0f);
                }
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("y");
                    PlacementVideoView.this.k.V(1.0f);
                }
            }
        };
        this.o = new go() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.4
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
                PlacementVideoView.this.Code(i, false);
            }
        };
        Code(context);
    }

    public PlacementVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = true;
        this.k = new hv();
        this.l = new gn() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.1
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                if (ge.Code()) {
                    ge.Code(PlacementVideoView.this.getTAG(), "contentId: %s onBufferingStart", PlacementVideoView.this.I);
                }
                PlacementVideoView.this.j.V();
                PlacementVideoView.this.k.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                PlacementVideoView.this.k.c();
            }
        };
        this.m = new gr() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i, int i2) {
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
                if (ge.Code()) {
                    ge.Code(PlacementVideoView.this.getTAG(), "contentId: %s onMediaStart:  %s", PlacementVideoView.this.I, Integer.valueOf(i));
                }
                PlacementVideoView.this.g = true;
                PlacementVideoView.this.f = i;
                PlacementVideoView.this.e = System.currentTimeMillis();
                kg kgVar = PlacementVideoView.this.D;
                if (i > 0) {
                    kgVar.V();
                    return;
                }
                kgVar.Code();
                PlacementVideoView.this.D.Code(PlacementVideoView.this.j.B(), PlacementVideoView.this.j.Z(), PlacementVideoView.this.e);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PlacementVideoView", "onMediaStop");
                PlacementVideoView.this.Code(i, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PlacementVideoView", "onMediaPause");
                PlacementVideoView.this.Code(i, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PlacementVideoView", "onMediaCompletion");
                PlacementVideoView.this.Code(i, true);
            }
        };
        this.n = new gs() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.3
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("n");
                    PlacementVideoView.this.k.V(0.0f);
                }
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("y");
                    PlacementVideoView.this.k.V(1.0f);
                }
            }
        };
        this.o = new go() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.4
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
                PlacementVideoView.this.Code(i, false);
            }
        };
        Code(context);
    }

    public PlacementVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.k = new hv();
        this.l = new gn() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.1
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                if (ge.Code()) {
                    ge.Code(PlacementVideoView.this.getTAG(), "contentId: %s onBufferingStart", PlacementVideoView.this.I);
                }
                PlacementVideoView.this.j.V();
                PlacementVideoView.this.k.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i2) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                PlacementVideoView.this.k.c();
            }
        };
        this.m = new gr() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i2, int i22) {
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2) {
                if (ge.Code()) {
                    ge.Code(PlacementVideoView.this.getTAG(), "contentId: %s onMediaStart:  %s", PlacementVideoView.this.I, Integer.valueOf(i2));
                }
                PlacementVideoView.this.g = true;
                PlacementVideoView.this.f = i2;
                PlacementVideoView.this.e = System.currentTimeMillis();
                kg kgVar = PlacementVideoView.this.D;
                if (i2 > 0) {
                    kgVar.V();
                    return;
                }
                kgVar.Code();
                PlacementVideoView.this.D.Code(PlacementVideoView.this.j.B(), PlacementVideoView.this.j.Z(), PlacementVideoView.this.e);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i2) {
                ge.V("PlacementVideoView", "onMediaStop");
                PlacementVideoView.this.Code(i2, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i2) {
                ge.V("PlacementVideoView", "onMediaPause");
                PlacementVideoView.this.Code(i2, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i2) {
                ge.V("PlacementVideoView", "onMediaCompletion");
                PlacementVideoView.this.Code(i2, true);
            }
        };
        this.n = new gs() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.3
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("n");
                    PlacementVideoView.this.k.V(0.0f);
                }
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("y");
                    PlacementVideoView.this.k.V(1.0f);
                }
            }
        };
        this.o = new go() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.4
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2, int i22, int i3) {
                PlacementVideoView.this.Code(i2, false);
            }
        };
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        ge.V("PlacementVideoView", "onVideoEnd, videoComplete: %s", Boolean.valueOf(z));
        this.j.I();
        if (this.g) {
            this.g = false;
            setPreferStartPlayTime(i);
            if (z) {
                this.D.Code(this.e, System.currentTimeMillis(), this.f, i);
            } else {
                this.D.V(this.e, System.currentTimeMillis(), this.f, i);
            }
        }
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_placement_pure_video_view, this);
        this.D = new jt(context, this);
        this.j = new hd(getTAG());
        VideoView videoView = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.L = videoView;
        videoView.setScreenOnWhilePlaying(true);
        this.L.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.L.Code(this.m);
        this.L.Code(this.l);
        this.L.Code(this.o);
        this.L.Code(this.n);
        this.L.setMuteOnlyOnLostAudioFocus(true);
        this.L.setRemediate(true);
    }

    private void L() {
        if (this.Code == null) {
            return;
        }
        ge.V(getTAG(), "loadVideoInfo");
        r S = this.Code.S();
        if (S == null || !S.V()) {
            return;
        }
        this.b = S;
        Float f = S.f();
        if (f != null) {
            setRatio(f);
            this.L.setRatio(f);
        }
        this.L.setDefaultDuration((int) this.b.d());
        this.D.Code(this.b);
        this.f9427c = false;
        this.d = true;
    }

    private void V(boolean z, boolean z2) {
        String tag = getTAG();
        ge.V(tag, "doRealPlay, auto:" + z + ", isMute:" + z2);
        this.j.Code();
        if (z2) {
            this.L.b();
        } else {
            this.L.c();
        }
        if (!this.L.getCurrentState().Code(com.huawei.openalliance.ad.media.e.PLAYBACK_COMPLETED)) {
            this.L.setPreferStartPlayTime(this.i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.L.I(this.i, 1);
        } else {
            this.L.Code(this.i);
        }
        this.L.Code(z);
    }

    private void a() {
        ge.V(getTAG(), "resetVideoView");
        setPreferStartPlayTime(0);
        this.f9426a = false;
        this.f9427c = false;
        this.d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTAG() {
        return "PlacementVideoView_" + hashCode();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void B() {
        this.h = false;
        this.L.c();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void C() {
        this.L.L();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    void Code() {
        this.L.B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(int i) {
        Code(i, true);
        this.L.B();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(long j) {
        this.D.Code(j);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(gn gnVar) {
        this.L.Code(gnVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(go goVar) {
        this.L.Code(goVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(gs gsVar) {
        this.L.Code(gsVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(gt gtVar) {
        this.L.Code(gtVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(gu guVar) {
        this.L.Code(guVar);
    }

    public void Code(ih ihVar) {
        this.k = ihVar;
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(r rVar, boolean z) {
        ge.V(getTAG(), "onCheckVideoHashResult sucess: %s", Boolean.valueOf(z));
        if (!z || this.b == null || rVar == null) {
            return;
        }
        this.b = rVar;
        this.f9426a = true;
        String e = rVar.e();
        String str = e;
        if (TextUtils.isEmpty(e)) {
            str = rVar.Z();
        }
        this.V = str;
        this.L.setVideoFileUrl(str);
        this.L.setContentId(this.Code == null ? null : this.Code.D());
        if (this.f9427c) {
            ge.V(getTAG(), "play when hash check success");
            V(true, this.h);
        }
        if (this.d) {
            ge.V(getTAG(), "prefect when hash check success");
            this.L.e();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(String str) {
        this.D.Code(str);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(boolean z, boolean z2) {
        String tag = getTAG();
        ge.V(tag, "play, auto:" + z + ", isMute:" + z2);
        if (this.f9426a) {
            V(z, z2);
            return;
        }
        this.f9427c = true;
        this.h = z2;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public boolean F() {
        return this.L.a();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I() {
        this.h = true;
        this.L.b();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I(gu guVar) {
        this.L.I(guVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void S() {
        this.L.D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V() {
        if (this.L != null) {
            ge.V("PlacementVideoView", "release player");
            this.L.f();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V(gs gsVar) {
        this.L.V(gsVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.ls
    public void destroyView() {
        ge.V(getTAG(), "destroyView");
        this.L.destroyView();
        this.k.I();
    }

    public com.huawei.openalliance.ad.media.c getCurrentState() {
        return this.L.getCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public ImageView getLastFrame() {
        if (this.L != null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageBitmap(this.L.getSurfaceBitmap());
            return imageView;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public com.huawei.openalliance.ad.media.c getMediaState() {
        VideoView videoView = this.L;
        if (videoView != null) {
            return videoView.getMediaState();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.hr
    public View getOpenMeasureView() {
        return this;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.ls
    public void pauseView() {
        ge.V(getTAG(), "pauseView");
        this.L.pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.ls
    public void resumeView() {
        ge.V(getTAG(), "resumeView");
        this.L.resumeView();
        this.L.setNeedPauseOnSurfaceDestory(true);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setAudioFocusType(int i) {
        this.L.setAudioFocusType(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setMediaPlayerReleaseListener(gq gqVar) {
        VideoView videoView = this.L;
        if (videoView != null) {
            videoView.setMediaPlayerReleaseListener(gqVar);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        com.huawei.openalliance.ad.media.c currentState = this.L.getCurrentState();
        if (this.Code == hVar && currentState.V(com.huawei.openalliance.ad.media.e.IDLE) && currentState.V(com.huawei.openalliance.ad.media.e.ERROR)) {
            ge.V(getTAG(), "setPlacementVideoAd - has the same ad");
            return;
        }
        super.setPlacementAd(hVar);
        String tag = getTAG();
        StringBuilder sb = new StringBuilder();
        sb.append("set placement ad:");
        sb.append(hVar == null ? com.igexin.push.core.b.l : hVar.D());
        ge.V(tag, sb.toString());
        a();
        this.D.Code(this.Code);
        if (this.Code != null) {
            L();
        } else {
            this.b = null;
        }
    }

    public void setPreferStartPlayTime(int i) {
        this.i = i;
        this.L.setPreferStartPlayTime(i);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setSoundVolume(float f) {
        this.L.setSoundVolume(f);
    }
}
