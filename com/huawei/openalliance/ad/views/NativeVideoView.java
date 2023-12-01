package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.br;
import com.huawei.hms.ads.fw;
import com.huawei.hms.ads.fx;
import com.huawei.hms.ads.fy;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gp;
import com.huawei.hms.ads.gr;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.hd;
import com.huawei.hms.ads.hr;
import com.huawei.hms.ads.hv;
import com.huawei.hms.ads.ih;
import com.huawei.hms.ads.jf;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.jm;
import com.huawei.hms.ads.jz;
import com.huawei.hms.ads.la;
import com.huawei.hms.ads.lf;
import com.huawei.hms.ads.ls;
import com.huawei.hms.ads.nativead.MediaContent;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.t;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.views.j;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/NativeVideoView.class */
public class NativeVideoView extends NativeMediaView implements hr, la, ls {
    private static final String S = NativeVideoView.class.getSimpleName();
    private a D;
    private ih F;
    private boolean L;

    /* renamed from: a  reason: collision with root package name */
    private j f9399a;
    private jz b;

    /* renamed from: c  reason: collision with root package name */
    private v f9400c;
    private k d;
    private boolean e;
    private int f;
    private boolean g;
    private long h;
    private NativeVideoControlPanel i;
    private VideoView j;
    private lf k;
    private MediaContent l;
    private long m;
    private long n;
    private boolean o;
    private hd p;
    private final gn q;
    private final gr r;
    private final go s;
    private gp t;
    private gs u;
    private j.a v;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/NativeVideoView$a.class */
    public interface a {
        void Code();

        void Code(boolean z);

        void Code(boolean z, int i);

        void I();

        void V();

        void V(boolean z, int i);

        void Z();
    }

    public NativeVideoView(Context context) {
        super(context);
        this.F = new hv();
        this.L = false;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.q = new gn() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                if (ge.Code()) {
                    ge.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                NativeVideoView.this.F.c();
            }
        };
        this.r = new gr() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i, int i2) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i);
                    if (NativeVideoView.this.b != null) {
                        NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), i2, NativeVideoView.this.f9400c == null ? 0L : NativeVideoView.this.f9400c.I());
                    }
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
                if (ge.Code()) {
                    ge.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.n = i;
                NativeVideoView.this.m = System.currentTimeMillis();
                NativeVideoView.this.i();
                ih ihVar = NativeVideoView.this.F;
                if (i > 0) {
                    ihVar.f();
                    NativeVideoView.this.b.V();
                    return;
                }
                if (ihVar != null && NativeVideoView.this.f9400c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.f9400c.I(), !"y".equals(NativeVideoView.this.f9400c.a()));
                }
                NativeVideoView.this.b.Code();
                NativeVideoView.this.b.Code(NativeVideoView.this.p.B(), NativeVideoView.this.p.Z(), NativeVideoView.this.m);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.j();
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.k();
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativeVideoView.this.Code(i, true);
                NativeVideoView.this.l();
                if (NativeVideoView.this.b != null) {
                    long j = i;
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j, j);
                }
            }
        };
        this.s = new go() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
                NativeVideoView.this.Code(i, false);
                if (NativeVideoView.this.I || ai.Z(NativeVideoView.this.getContext())) {
                    return;
                }
                Toast makeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        };
        this.t = new gp() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.hms.ads.gp
            public void Code(int i) {
                NativeVideoView.this.f9399a.I(i);
            }

            @Override // com.huawei.hms.ads.gp
            public void V(int i) {
            }
        };
        this.u = new gs() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                ge.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.f9400c != null) {
                    NativeVideoView.this.f9400c.Code("n");
                    if (NativeVideoView.this.o || !NativeVideoView.this.L) {
                        NativeVideoView.this.o = false;
                    } else {
                        NativeVideoView.this.b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f9399a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                ge.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.f9400c != null) {
                    NativeVideoView.this.o = false;
                    NativeVideoView.this.f9400c.Code("y");
                    NativeVideoView.this.b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f9399a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.v = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.k != null) {
                    NativeVideoView.this.k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z) {
                String str = NativeVideoView.S;
                ge.V(str, "doRealPlay, auto:" + z);
                NativeVideoView.this.p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z, int i) {
                NativeVideoView.this.Code(z, i);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z, int i) {
                NativeVideoView.this.V(z, i);
            }
        };
        Code(context);
    }

    public NativeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new hv();
        this.L = false;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.q = new gn() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                if (ge.Code()) {
                    ge.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                NativeVideoView.this.F.c();
            }
        };
        this.r = new gr() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i, int i2) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i);
                    if (NativeVideoView.this.b != null) {
                        NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), i2, NativeVideoView.this.f9400c == null ? 0L : NativeVideoView.this.f9400c.I());
                    }
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
                if (ge.Code()) {
                    ge.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.n = i;
                NativeVideoView.this.m = System.currentTimeMillis();
                NativeVideoView.this.i();
                ih ihVar = NativeVideoView.this.F;
                if (i > 0) {
                    ihVar.f();
                    NativeVideoView.this.b.V();
                    return;
                }
                if (ihVar != null && NativeVideoView.this.f9400c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.f9400c.I(), !"y".equals(NativeVideoView.this.f9400c.a()));
                }
                NativeVideoView.this.b.Code();
                NativeVideoView.this.b.Code(NativeVideoView.this.p.B(), NativeVideoView.this.p.Z(), NativeVideoView.this.m);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.j();
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.k();
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
                NativeVideoView.this.Code(i, true);
                NativeVideoView.this.l();
                if (NativeVideoView.this.b != null) {
                    long j = i;
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j, j);
                }
            }
        };
        this.s = new go() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
                NativeVideoView.this.Code(i, false);
                if (NativeVideoView.this.I || ai.Z(NativeVideoView.this.getContext())) {
                    return;
                }
                Toast makeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        };
        this.t = new gp() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.hms.ads.gp
            public void Code(int i) {
                NativeVideoView.this.f9399a.I(i);
            }

            @Override // com.huawei.hms.ads.gp
            public void V(int i) {
            }
        };
        this.u = new gs() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                ge.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.f9400c != null) {
                    NativeVideoView.this.f9400c.Code("n");
                    if (NativeVideoView.this.o || !NativeVideoView.this.L) {
                        NativeVideoView.this.o = false;
                    } else {
                        NativeVideoView.this.b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f9399a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                ge.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.f9400c != null) {
                    NativeVideoView.this.o = false;
                    NativeVideoView.this.f9400c.Code("y");
                    NativeVideoView.this.b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f9399a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.v = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.k != null) {
                    NativeVideoView.this.k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z) {
                String str = NativeVideoView.S;
                ge.V(str, "doRealPlay, auto:" + z);
                NativeVideoView.this.p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z, int i) {
                NativeVideoView.this.Code(z, i);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z, int i) {
                NativeVideoView.this.V(z, i);
            }
        };
        Code(context);
    }

    public NativeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = new hv();
        this.L = false;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.q = new gn() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                if (ge.Code()) {
                    ge.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i2) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                NativeVideoView.this.F.c();
            }
        };
        this.r = new gr() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i2, int i22) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i2);
                    if (NativeVideoView.this.b != null) {
                        NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), i22, NativeVideoView.this.f9400c == null ? 0L : NativeVideoView.this.f9400c.I());
                    }
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2) {
                if (ge.Code()) {
                    ge.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i2));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.n = i2;
                NativeVideoView.this.m = System.currentTimeMillis();
                NativeVideoView.this.i();
                ih ihVar = NativeVideoView.this.F;
                if (i2 > 0) {
                    ihVar.f();
                    NativeVideoView.this.b.V();
                    return;
                }
                if (ihVar != null && NativeVideoView.this.f9400c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.f9400c.I(), !"y".equals(NativeVideoView.this.f9400c.a()));
                }
                NativeVideoView.this.b.Code();
                NativeVideoView.this.b.Code(NativeVideoView.this.p.B(), NativeVideoView.this.p.Z(), NativeVideoView.this.m);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i2) {
                NativeVideoView.this.Code(i2, false);
                NativeVideoView.this.j();
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i2) {
                NativeVideoView.this.Code(i2, false);
                NativeVideoView.this.k();
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i2) {
                NativeVideoView.this.Code(i2, true);
                NativeVideoView.this.l();
                if (NativeVideoView.this.b != null) {
                    long j = i2;
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j, j);
                }
            }
        };
        this.s = new go() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2, int i22, int i3) {
                NativeVideoView.this.Code(i2, false);
                if (NativeVideoView.this.I || ai.Z(NativeVideoView.this.getContext())) {
                    return;
                }
                Toast makeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        };
        this.t = new gp() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.hms.ads.gp
            public void Code(int i2) {
                NativeVideoView.this.f9399a.I(i2);
            }

            @Override // com.huawei.hms.ads.gp
            public void V(int i2) {
            }
        };
        this.u = new gs() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                ge.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.f9400c != null) {
                    NativeVideoView.this.f9400c.Code("n");
                    if (NativeVideoView.this.o || !NativeVideoView.this.L) {
                        NativeVideoView.this.o = false;
                    } else {
                        NativeVideoView.this.b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f9399a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                ge.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.f9400c != null) {
                    NativeVideoView.this.o = false;
                    NativeVideoView.this.f9400c.Code("y");
                    NativeVideoView.this.b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f9399a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.v = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.k != null) {
                    NativeVideoView.this.k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z) {
                String str = NativeVideoView.S;
                ge.V(str, "doRealPlay, auto:" + z);
                NativeVideoView.this.p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z, int i2) {
                NativeVideoView.this.Code(z, i2);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z, int i2) {
                NativeVideoView.this.V(z, i2);
            }
        };
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        v vVar = this.f9400c;
        if (vVar != null) {
            vVar.Code(z ? 0 : i);
        }
        this.p.I();
        if (this.L) {
            this.L = false;
            if (z) {
                this.b.Code(this.m, System.currentTimeMillis(), this.n, i);
                this.F.a();
                return;
            }
            this.b.V(this.m, System.currentTimeMillis(), this.n, i);
            this.F.e();
        }
    }

    private void Code(Context context) {
        this.b = new jm(context, this);
        LayoutInflater.from(context).inflate(R.layout.hiad_native_video_view, this);
        this.j = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.i = (NativeVideoControlPanel) findViewById(R.id.hiad_native_video_ctrl_panel);
        this.j.setStandalone(false);
        this.j.setScreenOnWhilePlaying(true);
        this.j.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        j jVar = new j(this.j, this.i);
        this.f9399a = jVar;
        jVar.Code(this.v);
        this.j.Code(this.r);
        this.j.Code(this.q);
        this.j.Code(this.s);
        this.j.Code(this.u);
        this.j.Code(this.t);
        this.p = new hd(getTAG());
    }

    private void Code(MediaContent mediaContent) {
        this.f9399a.Code(mediaContent.getImage());
        if (mediaContent.getAspectRatio() > 0.0f) {
            setRatio(Float.valueOf(mediaContent.getAspectRatio()));
        }
    }

    private void Code(k kVar) {
        if (kVar.B() > 0) {
            setRatio(Float.valueOf((kVar.C() * 1.0f) / kVar.B()));
        }
        if (c()) {
            return;
        }
        this.b.Code(kVar);
    }

    private void Code(n nVar) {
        if (nVar.B() != null) {
            this.F.Code(jg.Code(0.0f, m(), jf.STANDALONE));
        }
    }

    private void Code(v vVar) {
        fw Code = fx.Code();
        if (Code == null || vVar == null) {
            return;
        }
        int Code2 = Code.Code();
        vVar.Code(Code2);
        String str = S;
        ge.V(str, "obtain progress from linked view " + Code2);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z, int i) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Code(z, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z, int i) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.V(z, i);
        }
    }

    private void b() {
        ge.V(S, "setInnerListener");
        this.j.Code(this.s);
        this.j.Code(this.u);
        this.f9399a.Z(!g());
    }

    private boolean c() {
        NativeAdConfiguration ad;
        if (this.B == null || (ad = this.B.ad()) == null) {
            return false;
        }
        return ad.isReturnUrlsForImages();
    }

    private void d() {
        if (this.B == null) {
            return;
        }
        this.f9400c = this.B.B();
        if (this.B.ad() != null) {
            VideoConfiguration videoConfiguration = this.B.ad().getVideoConfiguration();
            if (videoConfiguration != null) {
                Code(videoConfiguration.isStartMuted());
                setAudioFocusType(videoConfiguration.getAudioFocusType());
            } else {
                Code(true);
            }
        }
        if (this.f9400c == null) {
            this.f9399a.B();
            return;
        }
        this.f9399a.Code(this.j);
        this.f = this.B.aj();
        this.f9399a.Code(this.f9400c);
        Float g = this.f9400c.g();
        Float f = g;
        if (g == null) {
            f = Float.valueOf(1.7777778f);
        }
        setRatio(f);
        this.f9399a.B(this.f);
        this.f9399a.Z(!g());
        this.f9399a.V(getContinuePlayTime());
        this.f9399a.I(this.f9400c.I());
        this.f9399a.Z(this.f9400c.f());
        this.b.Code(this.f9400c);
        this.i.setNonWifiAlertMsg(this.f9400c.Z() > 0 ? getResources().getString(R.string.hiad_consume_data_to_play_video, au.Code(getContext(), this.f9400c.Z())) : getResources().getString(R.string.hiad_consume_data_to_play_video_no_data_size));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        if ((r4 instanceof com.huawei.hms.ads.br) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r3 = this;
            r0 = r3
            com.huawei.openalliance.ad.inter.data.n r0 = r0.B
            if (r0 != 0) goto L8
            return
        L8:
            r0 = r3
            com.huawei.hms.ads.nativead.MediaContent r0 = r0.l
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L2c
            r0 = r4
            android.graphics.drawable.Drawable r0 = r0.getImage()
            if (r0 == 0) goto L2c
            r0 = r3
            com.huawei.hms.ads.nativead.MediaContent r0 = r0.l
            r4 = r0
            r0 = r4
            boolean r0 = r0 instanceof com.huawei.hms.ads.br
            if (r0 != 0) goto L2c
        L26:
            r0 = r3
            r1 = r4
            r0.Code(r1)
            return
        L2c:
            r0 = r3
            com.huawei.openalliance.ad.inter.data.n r0 = r0.B
            java.util.List r0 = r0.Z()
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L96
            r0 = r4
            int r0 = r0.size()
            if (r0 <= 0) goto L96
            r0 = r4
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.huawei.openalliance.ad.inter.data.k r0 = (com.huawei.openalliance.ad.inter.data.k) r0
            r4 = r0
            r0 = r3
            r1 = r4
            r0.d = r1
            r0 = r4
            if (r0 == 0) goto L96
            r0 = r3
            com.huawei.hms.ads.nativead.MediaContent r0 = r0.l
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L8e
            r0 = r4
            android.graphics.drawable.Drawable r0 = r0.getImage()
            if (r0 == 0) goto L8e
            r0 = r3
            com.huawei.hms.ads.nativead.MediaContent r0 = r0.l
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r5
            boolean r0 = r0 instanceof com.huawei.hms.ads.br
            if (r0 == 0) goto L26
            r0 = r5
            com.huawei.hms.ads.br r0 = (com.huawei.hms.ads.br) r0
            r1 = r3
            com.huawei.openalliance.ad.inter.data.k r1 = r1.d
            java.lang.String r1 = r1.Z()
            boolean r0 = r0.Code(r1)
            if (r0 == 0) goto L8e
            r0 = r3
            com.huawei.hms.ads.nativead.MediaContent r0 = r0.l
            r4 = r0
            goto L26
        L8e:
            r0 = r3
            r1 = r3
            com.huawei.openalliance.ad.inter.data.k r1 = r1.d
            r0.Code(r1)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.NativeVideoView.e():void");
    }

    private void f() {
        this.e = false;
        this.f9399a.S(true);
    }

    private boolean g() {
        v vVar = this.f9400c;
        return vVar != null && TextUtils.equals(vVar.a(), "y");
    }

    private int getContinuePlayTime() {
        v vVar = this.f9400c;
        int i = 0;
        if (vVar == null) {
            ge.Code(S, "getContinuePlayTime other");
            return 0;
        }
        int L = vVar.L();
        if (L >= 5000) {
            i = L;
        }
        return i;
    }

    private String getTAG() {
        return S + "_" + hashCode();
    }

    private boolean h() {
        v vVar = this.f9400c;
        if (vVar == null) {
            return false;
        }
        if (vVar.L() >= this.f9400c.I()) {
            this.f9400c.Code(0);
            ge.V(S, "play progress bigger than video duration, skip autoPlay.");
            return false;
        }
        v vVar2 = this.f9400c;
        boolean z = false;
        if (vVar2 != null) {
            z = false;
            if (TextUtils.equals(vVar2.B(), "y")) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.I();
        }
    }

    private boolean m() {
        if (this.f9400c != null && ai.Z(getContext()) && h()) {
            if (this.f9400c.f() == 1) {
                return true;
            }
            return this.f9400c.f() == 0 && ai.I(getContext());
        }
        return false;
    }

    private void n() {
        fx.Code(null);
        fy.Code(getContext()).V();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    protected void B() {
        ge.V(S, "onViewShownBetweenFullAndPartial");
        this.f9399a.C(true);
        b();
    }

    public void C() {
        this.j.b();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    protected void Code() {
        super.Code();
        this.j.setNeedPauseOnSurfaceDestory(true);
    }

    @Override // com.huawei.hms.ads.la
    public void Code(long j) {
        this.b.Code(j);
    }

    public void Code(ih ihVar, n nVar) {
        this.F = ihVar;
        Code(nVar);
    }

    @Override // com.huawei.hms.ads.la
    public void Code(k kVar, Drawable drawable) {
        k kVar2 = this.d;
        if (kVar2 == null || kVar == null || !TextUtils.equals(kVar2.Z(), kVar.Z())) {
            return;
        }
        t tVar = new t(this.d, false);
        tVar.Code(drawable);
        this.l = new br(tVar);
        this.f9399a.Code(drawable);
    }

    @Override // com.huawei.hms.ads.la
    public void Code(v vVar, boolean z) {
        v vVar2;
        ge.V(S, "onCheckVideoResult: %s", Boolean.valueOf(z));
        if (!z || (vVar2 = this.f9400c) == null || vVar == null || !TextUtils.equals(vVar2.V(), vVar.V())) {
            return;
        }
        this.e = true;
        this.f9399a.Code(vVar.V());
        if (this.V) {
            this.f9399a.V(getContinuePlayTime());
            boolean h = h();
            ge.V(S, "onCheckVideoResult - full shown, autoPlay: %s", Boolean.valueOf(h));
            this.f9399a.I(h);
            if (m()) {
                long S2 = vVar.S() - (System.currentTimeMillis() - this.h);
                long j = S2;
                if (S2 < 0) {
                    j = 0;
                }
                this.f9399a.Code(j);
            }
        }
    }

    @Override // com.huawei.hms.ads.la
    public void Code(String str) {
        this.b.Code(str);
    }

    public void Code(boolean z) {
        String str = S;
        ge.V(str, "customToggleVideoMute, customMuteState is " + z);
        v vVar = this.f9400c;
        if (vVar != null) {
            vVar.Code(z ? "n" : "y");
        }
    }

    public void D() {
        this.f9399a.V(false);
    }

    public void F() {
        this.j.c();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    protected void I() {
        ge.V(S, "onViewPartialHidden");
        this.g = false;
        this.j.V(this.s);
        this.j.V(this.u);
        if (this.f9400c != null) {
            this.f9399a.C(false);
            this.f9399a.I(false);
            this.f9399a.C();
            this.f9399a.S();
        }
    }

    public void L() {
        this.f9399a.D();
    }

    @Override // com.huawei.hms.ads.la
    public void S() {
        this.f9399a.S();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    protected void V() {
        this.h = System.currentTimeMillis();
        this.f9399a.C(true);
        Code(this.f9400c);
        b();
        ge.V(S, "onViewFullShown hashCheckSuccess: %s", Boolean.valueOf(this.e));
        if (this.e) {
            boolean h = h();
            ge.V(S, "onViewFullShown autoplay: %s", Boolean.valueOf(h));
            this.f9399a.I(h);
            this.f9399a.V(getContinuePlayTime());
            if (m()) {
                this.f9399a.Code(this.f9400c.S());
            }
        }
    }

    @Override // com.huawei.hms.ads.ls
    public void destroyView() {
        this.j.destroyView();
        this.l = null;
        this.F.I();
    }

    public float getAspectRatio() {
        Float g;
        v vVar = this.f9400c;
        if (vVar == null || (g = vVar.g()) == null) {
            return 0.0f;
        }
        return g.floatValue();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    protected int getAutoPlayAreaPercentageThresshold() {
        v vVar = this.f9400c;
        return vVar != null ? vVar.c() : super.getAutoPlayAreaPercentageThresshold();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    protected int getHiddenAreaPercentageThreshhold() {
        v vVar = this.f9400c;
        return vVar != null ? Math.max(100 - vVar.d(), 0) : super.getHiddenAreaPercentageThreshhold();
    }

    public MediaContent getMediaContent() {
        return this.l;
    }

    @Override // com.huawei.hms.ads.hr
    public View getOpenMeasureView() {
        return this;
    }

    public ImageView getPreviewImageView() {
        return this.i.S();
    }

    public VideoView getVideoView() {
        return this.j;
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.F.I();
    }

    @Override // com.huawei.hms.ads.ls
    public void pauseView() {
        this.f9399a.L();
    }

    @Override // com.huawei.hms.ads.ls
    public void resumeView() {
        this.f9399a.a();
        ge.V(S, "resumeView");
        b();
        this.V = false;
        this.C.onGlobalLayout();
        this.j.setNeedPauseOnSurfaceDestory(true);
    }

    public void setAudioFocusType(int i) {
        this.j.setAudioFocusType(i);
    }

    public void setCoverClickListener(View.OnClickListener onClickListener) {
        this.f9399a.Code(onClickListener);
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.l = mediaContent;
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, com.huawei.hms.ads.la
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        String str = S;
        StringBuilder sb = new StringBuilder();
        sb.append("setNativeAd ");
        sb.append(gVar != null ? gVar.D() : com.igexin.push.core.b.l);
        ge.V(str, sb.toString());
        if (gVar == null) {
            this.l = null;
        }
        com.huawei.openalliance.ad.media.c currentState = this.j.getCurrentState();
        if (this.B == gVar && currentState.V(com.huawei.openalliance.ad.media.e.IDLE) && currentState.V(com.huawei.openalliance.ad.media.e.ERROR)) {
            ge.V(S, "setNativeAd - has the same ad");
            return;
        }
        super.setNativeAd(gVar);
        f();
        this.b.Code(this.B);
        if (this.B != null) {
            e();
            d();
            this.f9399a.C(false);
        } else {
            this.f9399a.Z(true);
            this.f9400c = null;
            this.l = null;
        }
        if (!h() || g()) {
            return;
        }
        this.o = true;
    }

    public void setNotShowDataUsageAlert(boolean z) {
        this.f9399a.F(z);
    }

    @Override // com.huawei.hms.ads.la
    public void setPpsNativeView(lf lfVar) {
        this.k = lfVar;
    }

    public void setVideoEventListener(a aVar) {
        this.D = aVar;
    }
}
