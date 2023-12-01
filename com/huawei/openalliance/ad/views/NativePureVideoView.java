package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gr;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.hd;
import com.huawei.hms.ads.jm;
import com.huawei.hms.ads.jz;
import com.huawei.hms.ads.la;
import com.huawei.hms.ads.lf;
import com.huawei.hms.ads.ls;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.bd;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/NativePureVideoView.class */
public class NativePureVideoView extends NativeMediaView implements la, ls {
    private static final String S = NativePureVideoView.class.getSimpleName();
    private VideoView D;
    private jz F;
    private ImageView L;

    /* renamed from: a  reason: collision with root package name */
    private boolean f23005a;
    private v b;

    /* renamed from: c  reason: collision with root package name */
    private k f23006c;
    private boolean d;
    private long e;
    private long f;
    private boolean g;
    private lf h;
    private hd i;
    private gn j;
    private gr k;
    private go l;
    private gs m;

    public NativePureVideoView(Context context) {
        super(context);
        this.g = false;
        this.j = new gn() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                if (ge.Code()) {
                    ge.Code(NativePureVideoView.S, "onBufferingStart");
                }
                NativePureVideoView.this.i.V();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
            }
        };
        this.k = new gr() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i, int i2) {
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
                if (ge.Code()) {
                    ge.Code(NativePureVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                NativePureVideoView.this.f();
                if (NativePureVideoView.this.g) {
                    return;
                }
                NativePureVideoView.this.g = true;
                NativePureVideoView.this.f = i;
                NativePureVideoView.this.e = System.currentTimeMillis();
                jz jzVar = NativePureVideoView.this.F;
                if (i > 0) {
                    jzVar.V();
                    return;
                }
                jzVar.Code();
                NativePureVideoView.this.F.Code(NativePureVideoView.this.i.B(), NativePureVideoView.this.i.Z(), NativePureVideoView.this.e);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativePureVideoView.this.Code(i, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, true);
            }
        };
        this.l = new go() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, false);
            }
        };
        this.m = new gs() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("n");
                }
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("y");
                }
            }
        };
        Code(context);
    }

    public NativePureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = false;
        this.j = new gn() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                if (ge.Code()) {
                    ge.Code(NativePureVideoView.S, "onBufferingStart");
                }
                NativePureVideoView.this.i.V();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
            }
        };
        this.k = new gr() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i, int i2) {
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
                if (ge.Code()) {
                    ge.Code(NativePureVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                NativePureVideoView.this.f();
                if (NativePureVideoView.this.g) {
                    return;
                }
                NativePureVideoView.this.g = true;
                NativePureVideoView.this.f = i;
                NativePureVideoView.this.e = System.currentTimeMillis();
                jz jzVar = NativePureVideoView.this.F;
                if (i > 0) {
                    jzVar.V();
                    return;
                }
                jzVar.Code();
                NativePureVideoView.this.F.Code(NativePureVideoView.this.i.B(), NativePureVideoView.this.i.Z(), NativePureVideoView.this.e);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativePureVideoView.this.Code(i, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, true);
            }
        };
        this.l = new go() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, false);
            }
        };
        this.m = new gs() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("n");
                }
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("y");
                }
            }
        };
        Code(context);
    }

    public NativePureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = false;
        this.j = new gn() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                if (ge.Code()) {
                    ge.Code(NativePureVideoView.S, "onBufferingStart");
                }
                NativePureVideoView.this.i.V();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i2) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
            }
        };
        this.k = new gr() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i2, int i22) {
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2) {
                if (ge.Code()) {
                    ge.Code(NativePureVideoView.S, "onMediaStart: %s", Integer.valueOf(i2));
                }
                NativePureVideoView.this.f();
                if (NativePureVideoView.this.g) {
                    return;
                }
                NativePureVideoView.this.g = true;
                NativePureVideoView.this.f = i2;
                NativePureVideoView.this.e = System.currentTimeMillis();
                jz jzVar = NativePureVideoView.this.F;
                if (i2 > 0) {
                    jzVar.V();
                    return;
                }
                jzVar.Code();
                NativePureVideoView.this.F.Code(NativePureVideoView.this.i.B(), NativePureVideoView.this.i.Z(), NativePureVideoView.this.e);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i2) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i2, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i2) {
                NativePureVideoView.this.Code(i2, false);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i2) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i2, true);
            }
        };
        this.l = new go() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2, int i22, int i3) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i2, false);
            }
        };
        this.m = new gs() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("n");
                }
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("y");
                }
            }
        };
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        this.i.I();
        if (this.g) {
            this.g = false;
            if (z) {
                this.F.Code(this.e, System.currentTimeMillis(), this.f, i);
            } else {
                this.F.V(this.e, System.currentTimeMillis(), this.f, i);
            }
        }
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_native_pure_video_view, this);
        this.F = new jm(context, this);
        this.i = new hd(getTAG());
        this.D = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.L = (ImageView) findViewById(R.id.hiad_iv_preview_video);
        this.D.setScreenOnWhilePlaying(true);
        this.D.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.D.Code(this.k);
        this.D.Code(this.j);
        this.D.Code(this.l);
        this.D.Code(this.m);
    }

    private void V(boolean z) {
        String str = S;
        ge.V(str, "doRealPlay, auto:" + z);
        this.i.Code();
        this.D.Code(z);
    }

    private void b() {
        List<k> Z;
        if (this.B == null || (Z = this.B.Z()) == null || Z.size() <= 0) {
            return;
        }
        k kVar = Z.get(0);
        this.f23006c = kVar;
        if (kVar != null) {
            if (au.B(kVar.Z())) {
                ge.V(S, "don't load preview image with http url");
                return;
            }
            if (this.f23006c.B() > 0) {
                setRatio(Float.valueOf((this.f23006c.C() * 1.0f) / this.f23006c.B()));
            }
            this.F.Code(this.f23006c);
        }
    }

    private void c() {
        if (this.B == null) {
            return;
        }
        v B = this.B.B();
        this.b = B;
        if (B != null) {
            Float g = B.g();
            Float f = g;
            if (g == null) {
                f = Float.valueOf(1.7777778f);
            }
            setRatio(f);
            this.D.setDefaultDuration(this.b.I());
            this.F.Code(this.b);
        }
    }

    private void d() {
        e();
        this.f23005a = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (ge.Code()) {
            ge.Code(S, "showPreviewView");
        }
        Animation animation = this.L.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        bd.Code((View) this.L, true);
        this.D.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (ge.Code()) {
            ge.Code(S, "hidePreviewView");
        }
        bd.Code(this.L, 8, 300, 300);
        this.D.setAlpha(1.0f);
    }

    private String getTAG() {
        return S + BridgeUtil.UNDERLINE_STR + hashCode();
    }

    @Override // com.huawei.hms.ads.la
    public void Code(long j) {
        this.F.Code(j);
    }

    @Override // com.huawei.hms.ads.la
    public void Code(k kVar, Drawable drawable) {
        k kVar2 = this.f23006c;
        if (kVar2 == null || kVar == null || !TextUtils.equals(kVar2.Z(), kVar.Z())) {
            return;
        }
        this.L.setImageDrawable(drawable);
    }

    @Override // com.huawei.hms.ads.la
    public void Code(v vVar, boolean z) {
        v vVar2;
        ge.V(S, "onCheckVideoHashResult sucess: %s", Boolean.valueOf(z));
        if (!z || (vVar2 = this.b) == null || vVar == null || !TextUtils.equals(vVar2.V(), vVar.V())) {
            return;
        }
        this.f23005a = true;
        this.D.setVideoFileUrl(vVar.V());
        if (this.d) {
            V(false);
        }
    }

    @Override // com.huawei.hms.ads.la
    public void Code(String str) {
        this.F.Code(str);
    }

    @Override // com.huawei.hms.ads.la
    public void S() {
        this.D.D();
    }

    @Override // com.huawei.hms.ads.ls
    public void destroyView() {
        this.D.destroyView();
    }

    public com.huawei.openalliance.ad.media.c getCurrentState() {
        return this.D.getCurrentState();
    }

    public ImageView getPreviewImageView() {
        return this.L;
    }

    @Override // com.huawei.hms.ads.ls
    public void pauseView() {
        this.D.pauseView();
    }

    @Override // com.huawei.hms.ads.ls
    public void resumeView() {
        this.V = false;
        this.D.resumeView();
        this.D.setNeedPauseOnSurfaceDestory(true);
        this.C.onGlobalLayout();
    }

    public void setAudioFocusType(int i) {
        this.D.setAudioFocusType(i);
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, com.huawei.hms.ads.la
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        com.huawei.openalliance.ad.media.c currentState = this.D.getCurrentState();
        if (this.B == gVar && currentState.V(com.huawei.openalliance.ad.media.e.IDLE) && currentState.V(com.huawei.openalliance.ad.media.e.ERROR)) {
            ge.V(S, "setNativeAd - has the same ad");
            return;
        }
        super.setNativeAd(gVar);
        d();
        this.F.Code(this.B);
        if (this.B == null) {
            this.b = null;
            return;
        }
        b();
        c();
    }

    @Override // com.huawei.hms.ads.la
    public void setPpsNativeView(lf lfVar) {
        this.h = lfVar;
    }

    public void setPreferStartPlayTime(int i) {
        this.D.setPreferStartPlayTime(i);
    }

    public void setStandalone(boolean z) {
        this.D.setStandalone(z);
    }
}
