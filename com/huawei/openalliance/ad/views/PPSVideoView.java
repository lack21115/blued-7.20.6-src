package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gr;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.gt;
import com.huawei.hms.ads.ih;
import com.huawei.hms.ads.jq;
import com.huawei.hms.ads.kc;
import com.huawei.hms.ads.li;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.ab;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSVideoView.class */
public class PPSVideoView extends PPSBaseView<kc> implements li {
    private go A;
    private final gn E;
    private gs G;
    private VideoView b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f9423c;
    private boolean d;
    private boolean e;
    private VideoInfo f;
    private int g;
    private int h;
    private long i;
    private long j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private float v;
    private boolean w;
    private View.OnClickListener x;
    private gt y;
    private gr z;

    public PPSVideoView(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.d = true;
        this.e = true;
        this.g = 0;
        this.h = Integer.MAX_VALUE;
        this.k = false;
        this.l = false;
        this.m = 1;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = 0.0f;
        this.w = false;
        this.x = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PPSVideoView.this.Code(!view.isSelected());
            }
        };
        this.y = new gt() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.2
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                ge.Code("PPSVideoView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSVideoView.this.q));
                if (PPSVideoView.this.q) {
                    return;
                }
                PPSVideoView.this.q = true;
                if (PPSVideoView.this.b != null) {
                    PPSVideoView.this.b.setAlpha(1.0f);
                }
                PPSVideoView.this.Z();
                if (PPSVideoView.this.s) {
                    PPSVideoView.this.e = false;
                }
                PPSVideoView.this.c();
            }
        };
        this.z = new gr() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.3
            private void Code(int i5) {
                if (PPSVideoView.this.l) {
                    ge.V("PPSVideoView", "has reported play end event");
                    return;
                }
                PPSVideoView.this.l = true;
                ((kc) PPSVideoView.this.B).Code(PPSVideoView.this.i, v.Code(), PPSVideoView.this.j, i5);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void Code(int i5, boolean z) {
                if (PPSVideoView.this.k) {
                    PPSVideoView.this.k = false;
                    Code(i5);
                    ((kc) PPSVideoView.this.B).V();
                    ih ihVar = PPSVideoView.this.C;
                    if (z) {
                        ihVar.a();
                    } else {
                        ihVar.e();
                    }
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(int i5, int i6) {
                ge.Code("PPSVideoView", "onProgress, playTime: %d, alreadyNotified: %s", Integer.valueOf(i6), Boolean.valueOf(PPSVideoView.this.q));
                if (i6 > 0 && !PPSVideoView.this.q) {
                    PPSVideoView.this.q = true;
                    if (PPSVideoView.this.b != null) {
                        PPSVideoView.this.b.setAlpha(1.0f);
                    }
                    PPSVideoView.this.Z();
                    PPSVideoView.this.c();
                }
                if (PPSVideoView.this.b != null && PPSVideoView.this.b.getCurrentState().Code() && PPSVideoView.this.g > 0) {
                    int i7 = PPSVideoView.this.g - i6;
                    int i8 = i7;
                    if (i7 < 0) {
                        i8 = 0;
                    }
                    int max = Math.max(1, (int) Math.ceil((i8 * 1.0f) / 1000.0f));
                    ge.Code("PPSVideoView", "left seconds: %d", Integer.valueOf(max));
                    if (max < PPSVideoView.this.h) {
                        PPSVideoView.this.h = max;
                        PPSVideoView.this.I(max);
                    }
                }
                if (PPSVideoView.this.k) {
                    PPSVideoView.this.C.Code(i5);
                    if (PPSVideoView.this.B != 0) {
                        ((kc) PPSVideoView.this.B).Code(PPSVideoView.this.getContext(), i6, PPSVideoView.this.g);
                    }
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i5) {
                if (PPSVideoView.this.k) {
                    return;
                }
                PPSVideoView.this.d();
                PPSVideoView.this.k = true;
                PPSVideoView.this.j = i5;
                PPSVideoView.this.i = v.Code();
                PPSVideoView pPSVideoView = PPSVideoView.this;
                if (i5 > 0) {
                    pPSVideoView.C.f();
                } else if (pPSVideoView.f != null) {
                    PPSVideoView.this.C.Code(PPSVideoView.this.f.I(), PPSVideoView.this.d);
                }
                ((kc) PPSVideoView.this.B).Code(PPSVideoView.this.i);
                PPSVideoView.this.D.Code(PPSVideoView.this.i);
                ((kc) PPSVideoView.this.B).C();
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i5) {
                Code(i5, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, final int i5) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Code(i5, false);
                    }
                }, 1000L);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i5) {
                Code(i5, true);
                if (PPSVideoView.this.B != 0) {
                    long j = i5;
                    ((kc) PPSVideoView.this.B).Code(PPSVideoView.this.getContext(), j, j);
                }
            }
        };
        this.A = new go() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.4
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i5, int i6, int i7) {
                PPSVideoView.this.V(ab.Z);
                PPSVideoView.this.Code();
            }
        };
        this.E = new gn() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.5
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                PPSVideoView.this.C.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i5) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                PPSVideoView.this.C.c();
            }
        };
        this.G = new gs() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.6
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                PPSVideoView.this.setMuteButtonState(true);
                PPSVideoView.this.C.V(0.0f);
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                PPSVideoView.this.setMuteButtonState(false);
                PPSVideoView.this.C.V(1.0f);
            }
        };
        this.o = i2;
        this.n = i;
        this.p = i3;
        this.r = dt.Code(context).B();
        this.B = new jq(context, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        ge.V("PPSVideoView", "switchSound enableSound: " + z);
        VideoView videoView = this.b;
        if (videoView == null) {
            return;
        }
        if (z) {
            videoView.c();
        } else {
            videoView.b();
        }
        ((kc) this.B).Code(!z);
    }

    private void b() {
        if (this.b == null) {
            VideoView videoView = new VideoView(getContext());
            this.b = videoView;
            videoView.setScreenOnWhilePlaying(true);
            this.b.setStandalone(true);
            this.b.setAutoScaleResizeLayoutOnVideoSizeChange(false);
            this.b.setVideoScaleMode(2);
            this.b.setMuteOnlyOnLostAudioFocus(true);
            this.b.Code(this.y);
            this.b.Code(this.z);
            this.b.Code(this.A);
            this.b.Code(this.G);
            this.b.Code(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.b, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00fd, code lost:
        if (com.huawei.openalliance.ad.utils.l.S(getContext()) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0138, code lost:
        if (r6.S.D() != 1) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSVideoView.c():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.t || !this.u) {
            return;
        }
        float f = this.v;
        if (f > 0.0f) {
            this.b.setSoundVolume(f);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lj
    public boolean C() {
        return this.g > 0;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lj
    public void Code(int i, int i2) {
        super.Code(i, i2);
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.D();
        }
    }

    @Override // com.huawei.hms.ads.li
    public void Code(String str) {
        VideoInfo p = this.S.p();
        this.f = p;
        if (p != null) {
            if (TextUtils.equals("n", p.e()) || this.s) {
                this.e = false;
            }
            this.g = this.f.I();
            this.u = TextUtils.equals("y", this.f.C());
        }
        MetaData Z = this.S.Z();
        if (Z != null && Z.h() > 0) {
            this.g = (int) Z.h();
        }
        b();
        this.b.setAudioFocusType(this.m);
        this.b.setAlpha(0.0f);
        this.b.setVideoFileUrl(str);
        if (this.t || !this.u) {
            this.b.b();
        } else {
            this.b.c();
        }
        this.b.Code(true);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lj
    public void D() {
        super.D();
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.D();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lj
    public void F() {
        super.F();
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.D();
        }
    }

    public void L() {
        ge.V("PPSVideoView", "unMuteCustomized");
        this.w = true;
        VideoView videoView = this.b;
        if (videoView != null) {
            float f = this.v;
            if (f > 0.0f) {
                videoView.Code(f);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView
    protected void S() {
        pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoView videoView = this.b;
        if (videoView != null) {
            removeView(videoView);
            this.b.destroyView();
            this.b = null;
        }
        this.h = Integer.MAX_VALUE;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.ls
    public void pauseView() {
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.pauseView();
            this.b.L();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lj
    public void setAudioFocusType(int i) {
        this.m = i;
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.setAudioFocusType(i);
        }
    }

    public void setHideSoundIcon(boolean z) {
        this.s = z;
    }

    public void setIgnoreSoundCtrl(boolean z) {
        this.t = z;
    }

    public void setMuteButtonState(boolean z) {
        this.d = z;
        if (this.f9423c != null) {
            this.f9423c.setImageResource(ay.Code(z));
            this.f9423c.setSelected(!z);
            ay.Code(this.f9423c);
        }
    }

    public void setStartVol(float f) {
        this.v = f;
    }
}
