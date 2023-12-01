package com.huawei.openalliance.ad.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gp;
import com.huawei.hms.ads.gq;
import com.huawei.hms.ads.gr;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.gt;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.ls;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView.class */
public abstract class BaseVideoView extends AutoScaleSizeRelativeLayout implements TextureView.SurfaceTextureListener, ls {
    private static final String V = BaseVideoView.class.getSimpleName();
    private boolean A;
    private IMultiMediaPlayingManager B;
    private final Set<com.huawei.openalliance.ad.views.e> C;
    private gt Code;
    private final Set<gs> D;
    private boolean E;
    private final Set<gn> F;
    private boolean G;
    private boolean H;
    private int I;
    private f J;
    private String K;
    private final Set<go> L;
    private gr M;
    private gn N;
    private go O;
    private gs P;
    private gp Q;
    private d R;
    private final Set<gr> S;
    private a T;
    private b U;
    private e W;

    /* renamed from: a  reason: collision with root package name */
    private final Set<gp> f23003a;
    private c aa;
    private BroadcastReceiver ab;
    protected TextureView b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f23004c;
    protected boolean d;
    protected com.huawei.openalliance.ad.media.b e;
    protected com.huawei.openalliance.ad.media.b f;
    protected Surface g;
    protected SurfaceTexture h;
    protected boolean i;
    protected int j;
    protected boolean k;
    protected MediaPlayer.OnVideoSizeChangedListener l;
    protected int m;
    protected int n;
    protected i o;
    private final Set<gu> p;
    private final Set<gu> q;
    private final Set<gt> r;
    private boolean s;
    private boolean t;
    private boolean u;
    private String v;
    private String[] w;
    private int x;
    private SparseBooleanArray y;
    private g z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView$a.class */
    public static class a implements gn {
        private WeakReference<gn> Code;

        a(gn gnVar) {
            this.Code = new WeakReference<>(gnVar);
        }

        @Override // com.huawei.hms.ads.gn
        public void Code() {
            gn gnVar = this.Code.get();
            if (gnVar != null) {
                gnVar.Code();
            }
        }

        @Override // com.huawei.hms.ads.gn
        public void Code(int i) {
            gn gnVar = this.Code.get();
            if (gnVar != null) {
                gnVar.Code(i);
            }
        }

        @Override // com.huawei.hms.ads.gn
        public void V() {
            gn gnVar = this.Code.get();
            if (gnVar != null) {
                gnVar.V();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView$b.class */
    public static class b implements go {
        private WeakReference<go> Code;

        b(go goVar) {
            this.Code = new WeakReference<>(goVar);
        }

        @Override // com.huawei.hms.ads.go
        public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
            go goVar = this.Code.get();
            if (goVar != null) {
                goVar.Code(bVar, i, i2, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView$c.class */
    public static class c implements gp {
        private WeakReference<gp> Code;

        c(gp gpVar) {
            this.Code = new WeakReference<>(gpVar);
        }

        @Override // com.huawei.hms.ads.gp
        public void Code(int i) {
            gp gpVar = this.Code.get();
            if (gpVar != null) {
                gpVar.Code(i);
            }
        }

        @Override // com.huawei.hms.ads.gp
        public void V(int i) {
            gp gpVar = this.Code.get();
            if (gpVar != null) {
                gpVar.V(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView$d.class */
    public static class d implements gr {
        private WeakReference<gr> Code;

        d(gr grVar) {
            this.Code = new WeakReference<>(grVar);
        }

        @Override // com.huawei.hms.ads.gr
        public void Code(int i, int i2) {
            gr grVar = this.Code.get();
            if (grVar != null) {
                grVar.Code(i, i2);
            }
        }

        @Override // com.huawei.hms.ads.gr
        public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
            ge.Code(BaseVideoView.V, "onMediaStart %s", Integer.valueOf(i));
            gr grVar = this.Code.get();
            if (grVar != null) {
                grVar.Code(bVar, i);
            }
        }

        @Override // com.huawei.hms.ads.gr
        public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
            ge.Code(BaseVideoView.V, "onMediaStop %s", Integer.valueOf(i));
            gr grVar = this.Code.get();
            if (grVar != null) {
                grVar.I(bVar, i);
            }
        }

        @Override // com.huawei.hms.ads.gr
        public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
            ge.Code(BaseVideoView.V, "onMediaPause %s", Integer.valueOf(i));
            gr grVar = this.Code.get();
            if (grVar != null) {
                grVar.V(bVar, i);
            }
        }

        @Override // com.huawei.hms.ads.gr
        public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
            ge.Code(BaseVideoView.V, "onMediaCompletion %s", Integer.valueOf(i));
            gr grVar = this.Code.get();
            if (grVar != null) {
                grVar.Z(bVar, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView$e.class */
    public static class e implements gs {
        private WeakReference<gs> Code;

        e(gs gsVar) {
            this.Code = new WeakReference<>(gsVar);
        }

        @Override // com.huawei.hms.ads.gs
        public void Code() {
            gs gsVar = this.Code.get();
            if (gsVar != null) {
                gsVar.Code();
            }
        }

        @Override // com.huawei.hms.ads.gs
        public void V() {
            gs gsVar = this.Code.get();
            if (gsVar != null) {
                gsVar.V();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView$f.class */
    public static class f implements gt {
        WeakReference<gt> Code;

        public f(gt gtVar) {
            this.Code = new WeakReference<>(gtVar);
        }

        @Override // com.huawei.hms.ads.gt
        public void Code() {
            gt gtVar = this.Code.get();
            if (gtVar != null) {
                gtVar.Code();
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView$g.class */
    public interface g {
        void I();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView$h.class */
    static class h implements MediaPlayer.OnVideoSizeChangedListener {
        private WeakReference<MediaPlayer.OnVideoSizeChangedListener> Code;

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.Code = new WeakReference<>(onVideoSizeChangedListener);
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.Code.get();
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(mediaPlayer, i, i2);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseVideoView$i.class */
    class i implements MediaPlayer.OnVideoSizeChangedListener {
        float Code = 0.0f;
        float V = 0.0f;

        i() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Code(int i, int i2) {
            ge.V(BaseVideoView.V, "video size changed - w: %d h: %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 || i2 == 0) {
                return;
            }
            BaseVideoView.this.m = i;
            BaseVideoView.this.n = i2;
            float f = (i * 1.0f) / i2;
            float abs = Math.abs(f - this.Code);
            if (ge.Code()) {
                ge.Code(BaseVideoView.V, "video ratio: %f oldRatio: %f diff: %f", Float.valueOf(f), Float.valueOf(this.Code), Float.valueOf(abs));
            }
            this.Code = f;
            if (BaseVideoView.this.E) {
                if (abs > 0.01f) {
                    BaseVideoView.this.setRatio(Float.valueOf(f));
                    BaseVideoView.this.requestLayout();
                    return;
                }
                return;
            }
            int width = BaseVideoView.this.getWidth();
            int height = BaseVideoView.this.getHeight();
            ge.V(BaseVideoView.V, "resizeVideo view width: %d height: %d", Integer.valueOf(width), Integer.valueOf(height));
            if (height == 0 || width == 0) {
                return;
            }
            float f2 = (width * 1.0f) / height;
            float abs2 = Math.abs(f2 - this.V);
            if (ge.Code()) {
                ge.Code(BaseVideoView.V, "view ratio: %f oldRatio: %f diff: %f", Float.valueOf(f2), Float.valueOf(this.V), Float.valueOf(abs2));
            }
            this.V = f2;
            if (abs2 > 0.01f) {
                BaseVideoView.this.Code(f, f2, width, height);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i, final int i2) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.Code(i, i2);
                }
            });
        }
    }

    public BaseVideoView(Context context) {
        super(context);
        this.Code = new gt() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                BaseVideoView.this.j();
            }
        };
        this.I = 0;
        this.C = new CopyOnWriteArraySet();
        this.S = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.L = new CopyOnWriteArraySet();
        this.f23003a = new CopyOnWriteArraySet();
        this.p = new CopyOnWriteArraySet();
        this.q = new CopyOnWriteArraySet();
        this.r = new CopyOnWriteArraySet();
        this.s = true;
        this.t = false;
        this.u = false;
        this.y = new SparseBooleanArray(3);
        this.A = false;
        this.j = 1;
        this.E = true;
        this.k = true;
        this.G = false;
        this.J = new f(this.Code);
        this.o = new i();
        this.M = new gr() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i2, int i3) {
                BaseVideoView.this.V(i2, i3);
                BaseVideoView.this.Code(i2, i3);
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2) {
                if (BaseVideoView.this.u) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.Code();
                BaseVideoView.this.I(i2);
                BaseVideoView.this.Code(bVar, i2);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i2) {
                BaseVideoView.this.n();
                BaseVideoView.this.B(i2);
                BaseVideoView.this.I(bVar, i2);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i2) {
                BaseVideoView.this.n();
                BaseVideoView.this.Z(i2);
                BaseVideoView.this.V(bVar, i2);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i2) {
                BaseVideoView.this.C(i2);
                if (BaseVideoView.this.C()) {
                    return;
                }
                BaseVideoView.this.n();
                BaseVideoView.this.Z(bVar, i2);
            }
        };
        this.N = new gn() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                BaseVideoView.this.h();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i2) {
                BaseVideoView.this.V(i2);
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                BaseVideoView.this.i();
            }
        };
        this.O = new go() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2, int i3, int i4) {
                BaseVideoView.this.n();
                BaseVideoView.this.Code(i2, i3, i4);
                BaseVideoView.this.Code(bVar, i2, i3, i4);
            }
        };
        this.P = new gs() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                BaseVideoView.this.G = true;
                BaseVideoView.this.l();
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                BaseVideoView.this.G = false;
                BaseVideoView.this.m();
            }
        };
        this.Q = new gp() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            @Override // com.huawei.hms.ads.gp
            public void Code(int i2) {
                BaseVideoView.this.S(i2);
            }

            @Override // com.huawei.hms.ads.gp
            public void V(int i2) {
                BaseVideoView.this.F(i2);
            }
        };
        this.R = new d(this.M);
        this.T = new a(this.N);
        this.U = new b(this.O);
        this.W = new e(this.P);
        this.aa = new c(this.Q);
        this.ab = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                ConnectivityManager connectivityManager;
                if (!TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction()) || (connectivityManager = (ConnectivityManager) context2.getSystemService(Context.CONNECTIVITY_SERVICE)) == null) {
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    BaseVideoView.this.k();
                } else {
                    BaseVideoView.this.V(ai.I(context2));
                }
            }
        };
        V(context);
    }

    public BaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Code = new gt() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                BaseVideoView.this.j();
            }
        };
        this.I = 0;
        this.C = new CopyOnWriteArraySet();
        this.S = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.L = new CopyOnWriteArraySet();
        this.f23003a = new CopyOnWriteArraySet();
        this.p = new CopyOnWriteArraySet();
        this.q = new CopyOnWriteArraySet();
        this.r = new CopyOnWriteArraySet();
        this.s = true;
        this.t = false;
        this.u = false;
        this.y = new SparseBooleanArray(3);
        this.A = false;
        this.j = 1;
        this.E = true;
        this.k = true;
        this.G = false;
        this.J = new f(this.Code);
        this.o = new i();
        this.M = new gr() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i2, int i3) {
                BaseVideoView.this.V(i2, i3);
                BaseVideoView.this.Code(i2, i3);
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2) {
                if (BaseVideoView.this.u) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.Code();
                BaseVideoView.this.I(i2);
                BaseVideoView.this.Code(bVar, i2);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i2) {
                BaseVideoView.this.n();
                BaseVideoView.this.B(i2);
                BaseVideoView.this.I(bVar, i2);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i2) {
                BaseVideoView.this.n();
                BaseVideoView.this.Z(i2);
                BaseVideoView.this.V(bVar, i2);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i2) {
                BaseVideoView.this.C(i2);
                if (BaseVideoView.this.C()) {
                    return;
                }
                BaseVideoView.this.n();
                BaseVideoView.this.Z(bVar, i2);
            }
        };
        this.N = new gn() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                BaseVideoView.this.h();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i2) {
                BaseVideoView.this.V(i2);
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                BaseVideoView.this.i();
            }
        };
        this.O = new go() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2, int i3, int i4) {
                BaseVideoView.this.n();
                BaseVideoView.this.Code(i2, i3, i4);
                BaseVideoView.this.Code(bVar, i2, i3, i4);
            }
        };
        this.P = new gs() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                BaseVideoView.this.G = true;
                BaseVideoView.this.l();
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                BaseVideoView.this.G = false;
                BaseVideoView.this.m();
            }
        };
        this.Q = new gp() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            @Override // com.huawei.hms.ads.gp
            public void Code(int i2) {
                BaseVideoView.this.S(i2);
            }

            @Override // com.huawei.hms.ads.gp
            public void V(int i2) {
                BaseVideoView.this.F(i2);
            }
        };
        this.R = new d(this.M);
        this.T = new a(this.N);
        this.U = new b(this.O);
        this.W = new e(this.P);
        this.aa = new c(this.Q);
        this.ab = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                ConnectivityManager connectivityManager;
                if (!TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction()) || (connectivityManager = (ConnectivityManager) context2.getSystemService(Context.CONNECTIVITY_SERVICE)) == null) {
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    BaseVideoView.this.k();
                } else {
                    BaseVideoView.this.V(ai.I(context2));
                }
            }
        };
        V(context);
    }

    public BaseVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Code = new gt() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                BaseVideoView.this.j();
            }
        };
        this.I = 0;
        this.C = new CopyOnWriteArraySet();
        this.S = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.L = new CopyOnWriteArraySet();
        this.f23003a = new CopyOnWriteArraySet();
        this.p = new CopyOnWriteArraySet();
        this.q = new CopyOnWriteArraySet();
        this.r = new CopyOnWriteArraySet();
        this.s = true;
        this.t = false;
        this.u = false;
        this.y = new SparseBooleanArray(3);
        this.A = false;
        this.j = 1;
        this.E = true;
        this.k = true;
        this.G = false;
        this.J = new f(this.Code);
        this.o = new i();
        this.M = new gr() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            @Override // com.huawei.hms.ads.gr
            public void Code(int i22, int i3) {
                BaseVideoView.this.V(i22, i3);
                BaseVideoView.this.Code(i22, i3);
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i22) {
                if (BaseVideoView.this.u) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.Code();
                BaseVideoView.this.I(i22);
                BaseVideoView.this.Code(bVar, i22);
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i22) {
                BaseVideoView.this.n();
                BaseVideoView.this.B(i22);
                BaseVideoView.this.I(bVar, i22);
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i22) {
                BaseVideoView.this.n();
                BaseVideoView.this.Z(i22);
                BaseVideoView.this.V(bVar, i22);
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i22) {
                BaseVideoView.this.C(i22);
                if (BaseVideoView.this.C()) {
                    return;
                }
                BaseVideoView.this.n();
                BaseVideoView.this.Z(bVar, i22);
            }
        };
        this.N = new gn() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                BaseVideoView.this.h();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i22) {
                BaseVideoView.this.V(i22);
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                BaseVideoView.this.i();
            }
        };
        this.O = new go() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i22, int i3, int i4) {
                BaseVideoView.this.n();
                BaseVideoView.this.Code(i22, i3, i4);
                BaseVideoView.this.Code(bVar, i22, i3, i4);
            }
        };
        this.P = new gs() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                BaseVideoView.this.G = true;
                BaseVideoView.this.l();
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                BaseVideoView.this.G = false;
                BaseVideoView.this.m();
            }
        };
        this.Q = new gp() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            @Override // com.huawei.hms.ads.gp
            public void Code(int i22) {
                BaseVideoView.this.S(i22);
            }

            @Override // com.huawei.hms.ads.gp
            public void V(int i22) {
                BaseVideoView.this.F(i22);
            }
        };
        this.R = new d(this.M);
        this.T = new a(this.N);
        this.U = new b(this.O);
        this.W = new e(this.P);
        this.aa = new c(this.Q);
        this.ab = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                ConnectivityManager connectivityManager;
                if (!TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction()) || (connectivityManager = (ConnectivityManager) context2.getSystemService(Context.CONNECTIVITY_SERVICE)) == null) {
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    BaseVideoView.this.k();
                } else {
                    BaseVideoView.this.V(ai.I(context2));
                }
            }
        };
        V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i2) {
        for (gu guVar : this.q) {
            guVar.I(getContentId(), getCurrentVideoUrl(), i2);
        }
        for (gu guVar2 : this.p) {
            guVar2.I(getContentId(), getCurrentVideoUrl(), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i2) {
        for (gu guVar : this.q) {
            guVar.Z(getContentId(), getCurrentVideoUrl(), i2);
        }
        for (gu guVar2 : this.p) {
            guVar2.Z(getContentId(), getCurrentVideoUrl(), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        String nextVideoUrl;
        int i2 = this.x + 1;
        if (!this.y.get(i2) || (nextVideoUrl = getNextVideoUrl()) == null) {
            ge.V(V, "no next player to switch, current: %d", Integer.valueOf(this.x));
            return false;
        }
        this.v = nextVideoUrl;
        this.f = Code(getNextPlayerAgent());
        if (!TextUtils.equals(nextVideoUrl, this.e.F())) {
            this.e.Z(nextVideoUrl);
        }
        if (this.G) {
            this.e.D();
        } else {
            this.e.L();
        }
        this.e.Code();
        this.x = i2;
        ge.V(V, "switch to next player [%d] and play", Integer.valueOf(i2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code() {
        String nextVideoUrl = getNextVideoUrl();
        if (nextVideoUrl == null) {
            ge.V(V, "no next video url need to prepare, current: %d", Integer.valueOf(this.x));
            return;
        }
        int i2 = this.x + 1;
        if (this.y.get(i2)) {
            ge.V(V, "player for url %d is already set", Integer.valueOf(i2));
            return;
        }
        ge.V(V, "prepare to set next player[%d]", Integer.valueOf(i2));
        com.huawei.openalliance.ad.media.b nextPlayerAgent = getNextPlayerAgent();
        nextPlayerAgent.Z(nextVideoUrl);
        nextPlayerAgent.V();
        this.y.put(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i2, int i3) {
        for (gr grVar : this.S) {
            grVar.Code(i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i2, int i3, int i4) {
        for (gu guVar : this.p) {
            guVar.Code(getContentId(), getCurrentVideoUrl(), i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(com.huawei.openalliance.ad.media.b bVar, int i2) {
        for (gr grVar : this.S) {
            grVar.Code(bVar, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(com.huawei.openalliance.ad.media.b bVar, int i2, int i3, int i4) {
        for (go goVar : this.L) {
            goVar.Code(bVar, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i2) {
        for (gp gpVar : this.f23003a) {
            gpVar.V(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i2) {
        for (gu guVar : this.q) {
            guVar.Code(getContentId(), getCurrentVideoUrl(), i2);
        }
        for (gu guVar2 : this.p) {
            guVar2.Code(getContentId(), getCurrentVideoUrl(), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(com.huawei.openalliance.ad.media.b bVar, int i2) {
        for (gr grVar : this.S) {
            grVar.I(bVar, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i2) {
        for (gp gpVar : this.f23003a) {
            gpVar.Code(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i2) {
        for (gn gnVar : this.F) {
            gnVar.Code(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i2, int i3) {
        for (gu guVar : this.q) {
            guVar.Code(getContentId(), getCurrentVideoUrl(), i2, i3);
        }
        for (gu guVar2 : this.p) {
            guVar2.Code(getContentId(), getCurrentVideoUrl(), i2, i3);
        }
    }

    private void V(Context context) {
        setBackgroundColor(-16777216);
        Code(context);
        this.B = HiAd.Code(context).V();
        setMediaPlayerAgent(new com.huawei.openalliance.ad.media.b(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(com.huawei.openalliance.ad.media.b bVar, int i2) {
        for (gr grVar : this.S) {
            grVar.V(bVar, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z) {
        if (ge.Code()) {
            ge.Code(V, "notifyNetworkConnectedOrChanged wifi: %s", Boolean.valueOf(z));
        }
        for (com.huawei.openalliance.ad.views.e eVar : this.C) {
            eVar.Code(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i2) {
        for (gu guVar : this.q) {
            guVar.V(getContentId(), getCurrentVideoUrl(), i2);
        }
        for (gu guVar2 : this.p) {
            guVar2.V(getContentId(), getCurrentVideoUrl(), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(com.huawei.openalliance.ad.media.b bVar, int i2) {
        for (gr grVar : this.S) {
            grVar.Z(bVar, i2);
        }
    }

    private String getCurrentVideoUrl() {
        if (this.x < getVideoFileUrlArrayLength()) {
            return this.w[this.x];
        }
        return null;
    }

    private com.huawei.openalliance.ad.media.b getNextPlayerAgent() {
        if (this.f == null) {
            com.huawei.openalliance.ad.media.b bVar = new com.huawei.openalliance.ad.media.b(getContext());
            this.f = bVar;
            bVar.c();
        }
        return this.f;
    }

    private String getNextVideoUrl() {
        int i2 = this.x + 1;
        if (i2 < getVideoFileUrlArrayLength()) {
            return this.w[i2];
        }
        return null;
    }

    private int getVideoFileUrlArrayLength() {
        String[] strArr = this.w;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        for (gn gnVar : this.F) {
            gnVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        for (gn gnVar : this.F) {
            gnVar.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        for (gt gtVar : this.r) {
            gtVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (ge.Code()) {
            ge.Code(V, "notifyNetworkDisconnected");
        }
        for (com.huawei.openalliance.ad.views.e eVar : this.C) {
            eVar.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        for (gs gsVar : this.D) {
            gsVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        for (gs gsVar : this.D) {
            gsVar.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.u) {
            setKeepScreenOn(false);
        }
    }

    public void B() {
        TextureView textureView = this.b;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            ViewParent parent = this.b.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.b);
            }
            TextureView textureView2 = new TextureView(getContext());
            this.b = textureView2;
            textureView2.setSurfaceTextureListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.b, layoutParams);
        }
    }

    protected com.huawei.openalliance.ad.media.b Code(com.huawei.openalliance.ad.media.b bVar) {
        if (bVar == null) {
            ge.I(V, "no agent to switch");
            return null;
        }
        com.huawei.openalliance.ad.media.b bVar2 = this.e;
        if (bVar2 != null) {
            bVar2.V(this.R);
            bVar2.V(this.T);
            bVar2.V(this.U);
            bVar2.V(this.W);
            bVar2.I(this.J);
            bVar2.V(this.aa);
            bVar2.Code((Surface) null);
        }
        bVar.Code(this.R);
        bVar.Code(this.T);
        bVar.Code(this.U);
        bVar.Code(this.W);
        bVar.V(this.J);
        bVar.Code(this.aa);
        bVar.Code(this.H);
        bVar.Z(this.I);
        Surface surface = this.g;
        if (surface != null) {
            bVar.Code(surface);
        }
        this.e = bVar;
        return bVar2;
    }

    public void Code(float f2) {
        ge.V(V, "unmute, volume: %s", Float.valueOf(f2));
        this.e.V(f2);
    }

    protected void Code(float f2, float f3, int i2, int i3) {
        Matrix matrix;
        float f4;
        float f5;
        float f6 = (i2 * 1.0f) / 2.0f;
        float f7 = (i3 * 1.0f) / 2.0f;
        int i4 = this.j;
        if (i4 == 1) {
            ge.V(V, "set video scale mode as fit");
            matrix = new Matrix();
            matrix.setScale(1.0f, 1.0f, f6, f7);
        } else if (i4 != 2) {
            return;
        } else {
            ge.V(V, "set video scale mode as fit with cropping");
            if (f3 < f2) {
                f5 = f2 / f3;
                f4 = 1.0f;
            } else {
                f4 = f3 / f2;
                f5 = 1.0f;
            }
            ge.Code(V, "calculateScaleMatrix scaleX: %s scaleY: %s pivotPointX: %s pivotPointY: %s", Float.valueOf(f5), Float.valueOf(f4), Float.valueOf(f6), Float.valueOf(f7));
            matrix = new Matrix();
            matrix.setScale(f5, f4, f6, f7);
        }
        this.b.setTransform(matrix);
    }

    public void Code(int i2) {
        this.e.Code(i2);
    }

    protected void Code(Context context) {
    }

    public void Code(gn gnVar) {
        if (gnVar == null) {
            return;
        }
        this.F.add(gnVar);
    }

    public void Code(go goVar) {
        if (goVar == null) {
            return;
        }
        this.L.add(goVar);
    }

    public void Code(gp gpVar) {
        if (gpVar == null) {
            return;
        }
        this.f23003a.add(gpVar);
    }

    public void Code(gq gqVar) {
        com.huawei.openalliance.ad.media.b bVar = this.e;
        if (bVar != null) {
            bVar.I(gqVar);
        }
    }

    public void Code(gr grVar) {
        if (grVar == null) {
            return;
        }
        this.S.add(grVar);
    }

    public void Code(gs gsVar) {
        if (gsVar == null) {
            return;
        }
        this.D.add(gsVar);
    }

    public void Code(gt gtVar) {
        if (gtVar == null) {
            return;
        }
        this.r.add(gtVar);
    }

    public void Code(gu guVar) {
        if (guVar != null) {
            this.p.add(guVar);
        }
    }

    public void Code(com.huawei.openalliance.ad.views.e eVar) {
        if (eVar == null) {
            return;
        }
        this.C.add(eVar);
    }

    public void Code(boolean z) {
        if (this.t) {
            ge.I(V, "play action is not performed - view paused");
            return;
        }
        ge.V(V, "play auto: %s surfaceAvailable: %s standalone: %s url: %s", Boolean.valueOf(z), Boolean.valueOf(this.d), Boolean.valueOf(this.s), bc.Code(this.v));
        if (!this.d) {
            this.f23004c = true;
            this.i = z;
            return;
        }
        Surface surface = this.g;
        if (surface != null) {
            this.e.Code(surface);
        }
        if (this.s) {
            this.e.Code();
        } else if (z) {
            this.B.Code(this.v, this.e);
        } else {
            this.B.V(this.v, this.e);
        }
    }

    public void D() {
        String str = V;
        ge.V(str, "stop standalone " + this.s);
        this.f23004c = false;
        if (this.s) {
            this.e.I();
        } else {
            this.B.I(this.v, this.e);
        }
    }

    public void F() {
        Code(false);
    }

    public void I(int i2, int i3) {
        this.e.Code(i2, i3);
    }

    public void I(gu guVar) {
        if (guVar != null) {
            this.q.add(guVar);
        }
    }

    public void L() {
        String str = V;
        ge.V(str, "pause standalone " + this.s);
        this.f23004c = false;
        if (this.s) {
            this.e.Z();
        } else {
            this.B.Z(this.v, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S() {
        ge.V(V, "resetVideoView");
        if (this.e.d() <= 1) {
            this.e.Code((Surface) null);
            this.e.b();
        }
        com.huawei.openalliance.ad.media.b bVar = this.f;
        if (bVar != null) {
            bVar.Code((Surface) null);
            this.f.b();
        }
        Surface surface = this.g;
        if (surface != null) {
            surface.release();
            this.g = null;
        }
        SurfaceTexture surfaceTexture = this.h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.h = null;
        this.f23004c = false;
    }

    public void V(gn gnVar) {
        if (gnVar == null) {
            return;
        }
        this.F.remove(gnVar);
    }

    public void V(go goVar) {
        if (goVar == null) {
            return;
        }
        this.L.remove(goVar);
    }

    public void V(gp gpVar) {
        if (gpVar == null) {
            return;
        }
        this.f23003a.remove(gpVar);
    }

    public void V(gr grVar) {
        if (grVar == null) {
            return;
        }
        this.S.remove(grVar);
    }

    public void V(gs gsVar) {
        if (gsVar == null) {
            return;
        }
        this.D.remove(gsVar);
    }

    public void V(gt gtVar) {
        if (gtVar == null) {
            return;
        }
        this.r.remove(gtVar);
    }

    public void V(gu guVar) {
        if (guVar != null) {
            this.p.remove(guVar);
        }
    }

    public void V(com.huawei.openalliance.ad.views.e eVar) {
        if (eVar == null) {
            return;
        }
        this.C.remove(eVar);
    }

    public void Z(gu guVar) {
        if (guVar != null) {
            this.q.remove(guVar);
        }
    }

    @Override // com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout
    public boolean Z() {
        return this.A;
    }

    public boolean a() {
        return this.e.S();
    }

    public void b() {
        ge.V(V, "mute");
        this.e.D();
    }

    public void c() {
        ge.V(V, "unmute");
        this.e.L();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        g gVar = this.z;
        if (gVar != null) {
            gVar.I();
        }
    }

    public void destroyView() {
        this.e.I(this.l);
        if (!this.s) {
            this.B.Code(this.e);
        }
        this.e.a();
        com.huawei.openalliance.ad.media.b bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void e() {
        this.e.V();
    }

    public void f() {
        com.huawei.openalliance.ad.media.b bVar = this.e;
        if (bVar != null) {
            bVar.a();
        }
    }

    public String getContentId() {
        return this.K;
    }

    public int getCurrentPosition() {
        return this.e.B();
    }

    public com.huawei.openalliance.ad.media.c getCurrentState() {
        return this.e.C();
    }

    public com.huawei.openalliance.ad.media.b getMediaPlayerAgent() {
        return this.e;
    }

    public com.huawei.openalliance.ad.media.c getMediaState() {
        com.huawei.openalliance.ad.media.b bVar = this.e;
        if (bVar == null) {
            return null;
        }
        return bVar.C();
    }

    public int getVideoHeight() {
        return this.n;
    }

    public int getVideoWidth() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 11 && !isHardwareAccelerated()) {
            ge.Z(V, "hardware acceleration is off");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        HiAd.Code(getContext()).Code(this.ab, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        String str;
        String str2;
        super.onDetachedFromWindow();
        try {
            HiAd.Code(getContext()).Code(this.ab);
        } catch (IllegalStateException e2) {
            str = V;
            str2 = "unregisterReceiver IllegalArgumentException";
            ge.I(str, str2);
        } catch (Exception e3) {
            str = V;
            str2 = "unregisterReceiver Exception";
            ge.I(str, str2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (ge.Code()) {
            ge.Code(V, "onSurfaceTextureSizeChanged width: %d height: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoView.this.o.Code(BaseVideoView.this.m, BaseVideoView.this.n);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.huawei.hms.ads.ls
    public void pauseView() {
        this.t = true;
        this.e.e();
    }

    @Override // com.huawei.hms.ads.ls
    public void resumeView() {
        this.t = false;
    }

    public void setAudioFocusType(int i2) {
        this.I = i2;
        this.e.Z(i2);
    }

    public void setAutoScaleResizeLayoutOnVideoSizeChange(boolean z) {
        this.E = z;
    }

    public void setContentId(String str) {
        this.K = str;
    }

    public void setDefaultDuration(int i2) {
        this.e.V(i2);
    }

    public void setMediaPlayerAgent(com.huawei.openalliance.ad.media.b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.c();
        com.huawei.openalliance.ad.media.b Code = Code(bVar);
        if (Code != null) {
            Code.a();
        }
    }

    public void setMediaPlayerReleaseListener(gq gqVar) {
        com.huawei.openalliance.ad.media.b bVar = this.e;
        if (bVar != null) {
            bVar.Code(gqVar);
        }
    }

    public void setMuteOnlyOnLostAudioFocus(boolean z) {
        this.H = z;
        this.e.Code(z);
    }

    public void setNeedPauseOnSurfaceDestory(boolean z) {
        this.k = z;
    }

    public void setPreferStartPlayTime(int i2) {
        this.e.I(i2);
    }

    public void setRemediate(boolean z) {
        this.A = z;
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.u = z;
        setKeepScreenOn(z && getCurrentState().Code(com.huawei.openalliance.ad.media.e.PLAYING));
    }

    public void setSoundVolume(float f2) {
        this.e.Code(f2);
    }

    public void setStandalone(boolean z) {
        this.s = z;
    }

    public void setSurfaceListener(g gVar) {
        this.z = gVar;
    }

    public void setVideoFileUrl(String str) {
        setVideoFileUrls(new String[]{str});
    }

    public void setVideoFileUrls(String[] strArr) {
        String[] strArr2 = strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : null;
        this.w = strArr2;
        this.x = 0;
        this.y.clear();
        if (strArr2 == null || strArr2.length <= 0) {
            this.v = null;
            ge.I(V, "setVideoFileUrls - url array is empty");
            return;
        }
        ge.V(V, "setVideoFileUrls - size: %d", Integer.valueOf(strArr2.length));
        String str = strArr2[this.x];
        this.v = str;
        this.e.Z(str);
    }

    public void setVideoScaleMode(int i2) {
        if (i2 == 1 || i2 == 2) {
            this.j = i2;
            return;
        }
        throw new IllegalArgumentException("Not supported video scale mode: " + i2);
    }
}
