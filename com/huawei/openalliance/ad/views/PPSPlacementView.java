package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.Intent;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gq;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.gt;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.ha;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.hv;
import com.huawei.hms.ads.ih;
import com.huawei.hms.ads.ir;
import com.huawei.hms.ads.is;
import com.huawei.hms.ads.jd;
import com.huawei.hms.ads.jf;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.jr;
import com.huawei.hms.ads.ke;
import com.huawei.hms.ads.kl;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.lg;
import com.huawei.hms.ads.ll;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.ls;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.bm;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.inter.data.r;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.o;
import com.huawei.openalliance.ad.utils.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSPlacementView.class */
public class PPSPlacementView extends AutoScaleSizeRelativeLayout implements gs, gu, ha, lg, ls {
    private boolean A;
    protected ih Code;
    private hb D;
    private boolean E;
    private ke F;
    private boolean G;
    private boolean H;
    protected ih I;
    private m J;
    private List<View> K;
    private List<p> L;
    private boolean M;
    private long N;
    private gq O;
    private int P;
    private boolean Q;
    private AudioManager R;
    private boolean S;
    private Object T;
    private bf U;
    protected ih V;
    private gt W;

    /* renamed from: a  reason: collision with root package name */
    private p f9416a;
    private Handler aa;
    private gu ab;
    private View.OnClickListener ac;
    private AudioManager.OnAudioFocusChangeListener ad;
    private p b;

    /* renamed from: c  reason: collision with root package name */
    private int f9417c;
    private a d;
    private List<View> e;
    private boolean f;
    private boolean g;
    private PlacementMediaView h;
    private PlacementMediaView i;
    private PlacementMediaView j;
    private gn k;
    private gs l;
    private go m;
    private lm n;
    private ll o;
    private int[] p;
    private PlacementMediaView q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private int x;
    private ImageView z;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSPlacementView$a.class */
    public interface a {
        void Code();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSPlacementView$b.class */
    static class b implements AudioManager.OnAudioFocusChangeListener {
        private WeakReference<PPSPlacementView> Code;

        public b(PPSPlacementView pPSPlacementView) {
            this.Code = new WeakReference<>(pPSPlacementView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Code(PPSPlacementView pPSPlacementView) {
            V(pPSPlacementView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I(PPSPlacementView pPSPlacementView) {
            ge.V("PPSPlacementView", "handleAudioFocusGain.");
            if (!pPSPlacementView.Q || pPSPlacementView.q == null) {
                return;
            }
            pPSPlacementView.q.B();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V(PPSPlacementView pPSPlacementView) {
            ge.V("PPSPlacementView", "handleAudioFocusLossTransientCanDuck soundMuted: " + pPSPlacementView.r);
            if (pPSPlacementView.r || pPSPlacementView.q == null) {
                return;
            }
            pPSPlacementView.q.I();
            pPSPlacementView.Q = true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.b.1
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView pPSPlacementView = (PPSPlacementView) b.this.Code.get();
                    if (pPSPlacementView == null) {
                        return;
                    }
                    ge.V("PPSPlacementView", "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(pPSPlacementView.P));
                    int i2 = i;
                    if (i2 == -3) {
                        b.this.V(pPSPlacementView);
                    } else if (i2 == -2 || i2 == -1) {
                        b.this.Code(pPSPlacementView);
                    } else if (i2 == 1 || i2 == 2) {
                        b.this.I(pPSPlacementView);
                    }
                    pPSPlacementView.P = i;
                }
            });
        }
    }

    public PPSPlacementView(Context context) {
        super(context);
        this.S = true;
        this.Code = new hv();
        this.V = new hv();
        this.I = new hv();
        this.L = new ArrayList(4);
        this.f9417c = 0;
        this.f = false;
        this.g = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = false;
        this.w = false;
        this.x = -1;
        this.z = null;
        this.A = false;
        this.E = false;
        this.G = false;
        this.H = false;
        this.P = 0;
        this.Q = false;
        this.U = new bf();
        this.W = new gt() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                ge.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.E || PPSPlacementView.this.n == null) {
                    return;
                }
                PPSPlacementView.this.E = false;
                PPSPlacementView.this.G = true;
                ge.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.t));
                PPSPlacementView.this.n.Code(PPSPlacementView.this.t);
                PPSPlacementView.this.l();
            }
        };
        this.aa = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i;
                p currentAd = PPSPlacementView.this.getCurrentAd();
                r currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String str = "";
                String D = currentAd != null ? currentAd.D() : "";
                if (currentMediaFile != null) {
                    str = currentMediaFile.Z();
                    i = (int) currentMediaFile.d();
                } else {
                    i = 0;
                }
                ge.V("PPSPlacementView", "callback timeout: %s", D);
                if (PPSPlacementView.this.q != null) {
                    ge.V("PPSPlacementView", "notify Error");
                    PPSPlacementView.this.B(D, str, i);
                    return true;
                }
                return true;
            }
        });
        this.ab = new gu() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.16
            @Override // com.huawei.hms.ads.gu
            public void Code(String str, String str2, int i) {
                PPSPlacementView pPSPlacementView;
                ih ihVar;
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.M = false;
                if (PPSPlacementView.this.q instanceof PlacementVideoView) {
                    boolean V = PPSPlacementView.this.U.V(bf.a.SINGLE_INST);
                    if (i > 0) {
                        (V ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).f();
                        return;
                    }
                    if (V) {
                        pPSPlacementView = PPSPlacementView.this;
                        ihVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.U.V(bf.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        ihVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        ihVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(ihVar);
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(String str, String str2, int i, int i2) {
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.M && (PPSPlacementView.this.q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).Code(i);
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(String str, String str2, int i, int i2, int i3) {
            }

            @Override // com.huawei.hms.ads.gu
            public void I(String str, String str2, int i) {
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    ge.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                } else if (PPSPlacementView.this.M) {
                } else {
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void V(String str, String str2, int i) {
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).e();
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void Z(String str, String str2, int i) {
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    ge.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                } else if (PPSPlacementView.this.M) {
                } else {
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }
        };
        this.ac = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.ad = new b(this);
        Code(context);
    }

    public PPSPlacementView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = true;
        this.Code = new hv();
        this.V = new hv();
        this.I = new hv();
        this.L = new ArrayList(4);
        this.f9417c = 0;
        this.f = false;
        this.g = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = false;
        this.w = false;
        this.x = -1;
        this.z = null;
        this.A = false;
        this.E = false;
        this.G = false;
        this.H = false;
        this.P = 0;
        this.Q = false;
        this.U = new bf();
        this.W = new gt() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                ge.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.E || PPSPlacementView.this.n == null) {
                    return;
                }
                PPSPlacementView.this.E = false;
                PPSPlacementView.this.G = true;
                ge.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.t));
                PPSPlacementView.this.n.Code(PPSPlacementView.this.t);
                PPSPlacementView.this.l();
            }
        };
        this.aa = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i;
                p currentAd = PPSPlacementView.this.getCurrentAd();
                r currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String str = "";
                String D = currentAd != null ? currentAd.D() : "";
                if (currentMediaFile != null) {
                    str = currentMediaFile.Z();
                    i = (int) currentMediaFile.d();
                } else {
                    i = 0;
                }
                ge.V("PPSPlacementView", "callback timeout: %s", D);
                if (PPSPlacementView.this.q != null) {
                    ge.V("PPSPlacementView", "notify Error");
                    PPSPlacementView.this.B(D, str, i);
                    return true;
                }
                return true;
            }
        });
        this.ab = new gu() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.16
            @Override // com.huawei.hms.ads.gu
            public void Code(String str, String str2, int i) {
                PPSPlacementView pPSPlacementView;
                ih ihVar;
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.M = false;
                if (PPSPlacementView.this.q instanceof PlacementVideoView) {
                    boolean V = PPSPlacementView.this.U.V(bf.a.SINGLE_INST);
                    if (i > 0) {
                        (V ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).f();
                        return;
                    }
                    if (V) {
                        pPSPlacementView = PPSPlacementView.this;
                        ihVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.U.V(bf.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        ihVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        ihVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(ihVar);
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(String str, String str2, int i, int i2) {
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.M && (PPSPlacementView.this.q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).Code(i);
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(String str, String str2, int i, int i2, int i3) {
            }

            @Override // com.huawei.hms.ads.gu
            public void I(String str, String str2, int i) {
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    ge.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                } else if (PPSPlacementView.this.M) {
                } else {
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void V(String str, String str2, int i) {
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).e();
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void Z(String str, String str2, int i) {
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    ge.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                } else if (PPSPlacementView.this.M) {
                } else {
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }
        };
        this.ac = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.ad = new b(this);
        Code(context);
    }

    public PPSPlacementView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.S = true;
        this.Code = new hv();
        this.V = new hv();
        this.I = new hv();
        this.L = new ArrayList(4);
        this.f9417c = 0;
        this.f = false;
        this.g = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = false;
        this.w = false;
        this.x = -1;
        this.z = null;
        this.A = false;
        this.E = false;
        this.G = false;
        this.H = false;
        this.P = 0;
        this.Q = false;
        this.U = new bf();
        this.W = new gt() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                ge.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.E || PPSPlacementView.this.n == null) {
                    return;
                }
                PPSPlacementView.this.E = false;
                PPSPlacementView.this.G = true;
                ge.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.t));
                PPSPlacementView.this.n.Code(PPSPlacementView.this.t);
                PPSPlacementView.this.l();
            }
        };
        this.aa = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i2;
                p currentAd = PPSPlacementView.this.getCurrentAd();
                r currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String str = "";
                String D = currentAd != null ? currentAd.D() : "";
                if (currentMediaFile != null) {
                    str = currentMediaFile.Z();
                    i2 = (int) currentMediaFile.d();
                } else {
                    i2 = 0;
                }
                ge.V("PPSPlacementView", "callback timeout: %s", D);
                if (PPSPlacementView.this.q != null) {
                    ge.V("PPSPlacementView", "notify Error");
                    PPSPlacementView.this.B(D, str, i2);
                    return true;
                }
                return true;
            }
        });
        this.ab = new gu() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.16
            @Override // com.huawei.hms.ads.gu
            public void Code(String str, String str2, int i2) {
                PPSPlacementView pPSPlacementView;
                ih ihVar;
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.M = false;
                if (PPSPlacementView.this.q instanceof PlacementVideoView) {
                    boolean V = PPSPlacementView.this.U.V(bf.a.SINGLE_INST);
                    if (i2 > 0) {
                        (V ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).f();
                        return;
                    }
                    if (V) {
                        pPSPlacementView = PPSPlacementView.this;
                        ihVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.U.V(bf.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        ihVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        ihVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(ihVar);
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(String str, String str2, int i2, int i22) {
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.M && (PPSPlacementView.this.q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).Code(i2);
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(String str, String str2, int i2, int i22, int i3) {
            }

            @Override // com.huawei.hms.ads.gu
            public void I(String str, String str2, int i2) {
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    ge.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                } else if (PPSPlacementView.this.M) {
                } else {
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void V(String str, String str2, int i2) {
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).e();
                }
            }

            @Override // com.huawei.hms.ads.gu
            public void Z(String str, String str2, int i2) {
                if (ge.Code()) {
                    ge.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    ge.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                } else if (PPSPlacementView.this.M) {
                } else {
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }
        };
        this.ac = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.ad = new b(this);
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final String str, final String str2, final int i) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.15
            @Override // java.lang.Runnable
            public void run() {
                PPSPlacementView.this.Code(str, str2, i, -1, -1);
            }
        });
    }

    private ih Code(bf bfVar) {
        if (bfVar.V(bf.a.SINGLE_INST)) {
            this.I.I();
            hv hvVar = new hv();
            this.I = hvVar;
            return hvVar;
        } else if (bfVar.V(bf.a.MAIN_VIEW)) {
            this.Code.I();
            hv hvVar2 = new hv();
            this.Code = hvVar2;
            return hvVar2;
        } else {
            this.V.I();
            hv hvVar3 = new hv();
            this.V = hvVar3;
            return hvVar3;
        }
    }

    private PlacementMediaView Code(p pVar) {
        if (pVar == null) {
            ge.I("PPSPlacementView", "create media view with null ad");
            return null;
        }
        ge.Code("PPSPlacementView", "create media view for content:%s", pVar.D());
        if (pVar.V()) {
            ge.V("PPSPlacementView", "create video view");
            return new PlacementVideoView(getContext());
        } else if (pVar.I()) {
            ge.V("PPSPlacementView", "create image view");
            return new PlacementImageView(getContext());
        } else {
            ge.V("PPSPlacementView", "return image view for default");
            return new PlacementImageView(getContext());
        }
    }

    private void Code(int i) {
        int i2;
        if (this.s && (i2 = this.t) >= 0) {
            this.u = i - i2;
            this.s = false;
        }
        this.t = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(long j) {
        if (this.H) {
            return;
        }
        this.H = true;
        ge.V("PPSPlacementView", "timeout, submit: %s", Long.valueOf(j));
        this.aa.sendEmptyMessageDelayed(1001, j);
    }

    private void Code(Context context) {
        bf bfVar;
        bf.a aVar;
        setBackgroundColor(-16777216);
        setUseRatioInMatchParentMode(false);
        this.F = new jr(context, this);
        this.D = new hb(this, this);
        this.R = (AudioManager) context.getSystemService("audio");
        if (fk.Code(context).aj()) {
            bfVar = this.U;
            aVar = bf.a.SINGLE_INST;
        } else {
            bfVar = this.U;
            aVar = bf.a.MAIN_VIEW;
        }
        bfVar.Code(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(ih ihVar) {
        if (ihVar == null || getCurrentAd() == null || getCurrentAd().S() == null) {
            return;
        }
        ge.V("PPSPlacementView", "om start");
        ihVar.Code((float) getCurrentAd().S().d(), !"y".equals(getCurrentAd().S().S()));
    }

    private void Code(ih ihVar, PlacementMediaView placementMediaView) {
        if (placementMediaView instanceof PlacementVideoView) {
            ihVar.Code(jg.Code(0.0f, true, jf.STANDALONE));
            ((PlacementVideoView) placementMediaView).Code(ihVar);
        } else if (placementMediaView instanceof PlacementImageView) {
            ihVar.L();
        }
    }

    private void Code(bf bfVar, com.huawei.openalliance.ad.inter.data.d dVar, PlacementMediaView placementMediaView) {
        if (dVar instanceof p) {
            AdContentData l = ((p) dVar).l();
            ih Code = Code(bfVar);
            Code.Code(getContext(), l, placementMediaView, true);
            Z(Code);
            Code.Z();
            Code(Code, placementMediaView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(PlacementMediaView placementMediaView) {
        if (placementMediaView == null) {
            ge.I("PPSPlacementView", "show ad with null media view");
            return;
        }
        this.u = -1;
        ge.Code("PPSPlacementView", "showAd:%s", Integer.valueOf(this.f9417c));
        this.q = placementMediaView;
        placementMediaView.setAlpha(1.0f);
        placementMediaView.Code(true, this.r);
        if (!isShown()) {
            ge.I("PPSPlacementView", "view not visible, pause.");
            pauseView();
        }
        Code(placementMediaView.getDuration() * 2);
    }

    private void Code(final PlacementMediaView placementMediaView, boolean z) {
        if (placementMediaView != null) {
            com.huawei.openalliance.ad.inter.data.h placementAd = placementMediaView.getPlacementAd();
            ge.V("PPSPlacementView", "unloadMediaView, contentId: %s, remove: %s", placementAd != null ? placementAd.D() : null, Boolean.valueOf(z));
            placementMediaView.S();
            placementMediaView.setPlacementAd(null);
            final ViewParent parent = placementMediaView.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                return;
            }
            placementMediaView.setAlpha(0.0f);
            if (z) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.19
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewParent viewParent = parent;
                        if (viewParent != null) {
                            ((ViewGroup) viewParent).removeView(placementMediaView);
                        }
                    }
                });
            }
        }
    }

    private void Code(Long l, Integer num, Integer num2) {
        p currentAd = getCurrentAd();
        if (currentAd == null || currentAd.Q()) {
            return;
        }
        currentAd.Z(true);
        this.F.Code(au.Code(Long.valueOf(this.N)));
        this.F.Code(this.N);
        this.F.Code(l.longValue(), num.intValue(), num2);
        I(this.U.V(bf.a.SINGLE_INST) ? this.I : this.U.V(bf.a.MAIN_VIEW) ? this.Code : this.V);
    }

    private boolean Code(PlacementMediaView placementMediaView, p pVar) {
        if ((placementMediaView instanceof PlacementVideoView) && pVar.V()) {
            return true;
        }
        return (placementMediaView instanceof PlacementImageView) && pVar.I();
    }

    private void I(long j, int i) {
        p currentAd = getCurrentAd();
        if (currentAd == null || this.f || j <= currentAd.r()) {
            return;
        }
        this.f = true;
        Code(Long.valueOf(j), Integer.valueOf(i), (Integer) null);
    }

    private void I(ih ihVar) {
        if (ihVar != null) {
            ihVar.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List<com.huawei.openalliance.ad.inter.data.h> list) {
        r S;
        r S2;
        if (aa.Code(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        this.L.clear();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            com.huawei.openalliance.ad.inter.data.h hVar = (com.huawei.openalliance.ad.inter.data.h) arrayList.get(i2);
            if ((hVar instanceof p) && (S2 = hVar.S()) != null) {
                String Z = S2.Z();
                if (2 == S2.c() || (Z != null && Z.startsWith(bm.CONTENT.toString()))) {
                    this.L.add((p) hVar);
                } else {
                    ge.V("PPSPlacementView", "has no cache, discard " + hVar.D());
                }
            }
            i = i2 + 1;
        }
        int size2 = this.L.size();
        this.p = new int[size2];
        if (aa.Code(this.L)) {
            return;
        }
        Collections.sort(this.L);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                return;
            }
            p pVar = this.L.get(i4);
            int d = (pVar == null || (S = pVar.S()) == null) ? 0 : (int) S.d();
            int[] iArr = this.p;
            if (i4 == 0) {
                iArr[i4] = d;
            } else {
                iArr[i4] = d + iArr[i4 - 1];
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.v) {
            return;
        }
        this.v = true;
        this.F.V();
    }

    private PlacementMediaView V(PlacementMediaView placementMediaView, p pVar) {
        if (pVar == null) {
            return null;
        }
        boolean z = true;
        ge.Code("PPSPlacementView", "init media view for content:%s", pVar.D());
        if (Code(placementMediaView, pVar)) {
            Code(placementMediaView, false);
        } else {
            Code(placementMediaView, true);
            placementMediaView = null;
        }
        if (placementMediaView == null) {
            placementMediaView = Code(pVar);
        } else {
            z = false;
        }
        if (placementMediaView != null) {
            ge.V("PPSPlacementView", "meida view created");
            placementMediaView.Code((gu) this);
            gn gnVar = this.k;
            if (gnVar != null) {
                placementMediaView.Code(gnVar);
            }
            gt gtVar = this.W;
            if (gtVar != null) {
                placementMediaView.Code(gtVar);
            }
            gs gsVar = this.l;
            if (gsVar != null) {
                placementMediaView.Code(gsVar);
            }
            placementMediaView.Code((gs) this);
            go goVar = this.m;
            if (goVar != null) {
                placementMediaView.Code(goVar);
            }
            gu guVar = this.ab;
            if (guVar != null) {
                placementMediaView.I(guVar);
            }
            if (z) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                addView(placementMediaView, layoutParams);
            }
            placementMediaView.setAlpha(0.0f);
            placementMediaView.setPlacementAd(pVar);
            placementMediaView.setAudioFocusType(2);
        }
        return placementMediaView;
    }

    private void V(ih ihVar) {
        if (ihVar != null) {
            ihVar.Code(jd.CLICK);
        }
    }

    private void V(boolean z) {
        if (this.f9417c < this.L.size() - 1) {
            h();
            if (z) {
                return;
            }
            g();
        }
    }

    private void Z(ih ihVar) {
        List<View> list;
        is V = ihVar.V();
        if (V == null || (list = this.K) == null || list.size() <= 0) {
            return;
        }
        for (View view : this.K) {
            V.Code(view, ir.OTHER, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        bf bfVar;
        p pVar;
        PlacementMediaView placementMediaView;
        ge.Code("PPSPlacementView", "initPlacementView, singlePlayerInst: %s", Boolean.valueOf(this.U.V(bf.a.SINGLE_INST)));
        this.D.V(this.f9416a.r(), this.f9416a.s());
        this.F.Code(this.f9416a);
        if (this.U.V(bf.a.SINGLE_INST)) {
            PlacementMediaView V = V(this.j, this.f9416a);
            this.j = V;
            V.setMediaPlayerReleaseListener(this.O);
            bfVar = new bf(bf.a.SINGLE_INST);
            pVar = this.f9416a;
            placementMediaView = this.j;
        } else {
            this.h = V(this.h, this.f9416a);
            Code(new bf(bf.a.MAIN_VIEW), this.f9416a, this.h);
            this.i = V(this.i, this.b);
            bfVar = new bf(bf.a.BACKUP_VIEW);
            pVar = this.b;
            placementMediaView = this.i;
        }
        Code(bfVar, pVar, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String valueOf = String.valueOf(this.N);
        this.F.Code(valueOf);
        this.F.Code(this.N);
        PlacementMediaView placementMediaView = this.j;
        if (placementMediaView != null) {
            placementMediaView.Code(valueOf);
            this.j.Code(this.N);
        }
        PlacementMediaView placementMediaView2 = this.h;
        if (placementMediaView2 != null) {
            placementMediaView2.Code(valueOf);
            this.h.Code(this.N);
        }
        PlacementMediaView placementMediaView3 = this.i;
        if (placementMediaView3 != null) {
            placementMediaView3.Code(valueOf);
            this.i.Code(this.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.S) {
            o.V();
            this.S = false;
            ge.V("PPSPlacementView", "onClick");
            Code((Integer) 1);
            this.F.Code(this.J);
            this.J = null;
            V(this.U.V(bf.a.SINGLE_INST) ? this.I : this.U.V(bf.a.MAIN_VIEW) ? this.Code : this.V);
            a aVar = this.d;
            if (aVar != null) {
                aVar.Code();
            }
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView.this.S = true;
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.e = arrayList;
        V(arrayList);
    }

    private boolean f() {
        return this.f9417c == this.L.size() - 1;
    }

    private void g() {
        bf bfVar;
        p pVar;
        PlacementMediaView placementMediaView;
        this.f9417c++;
        ge.V("PPSPlacementView", "load " + this.f9417c + " ad");
        if (getNextAd() == null || this.U.V(bf.a.SINGLE_INST)) {
            return;
        }
        if (Math.abs(this.h.getAlpha() - 1.0f) < 0.01f) {
            p nextAd = getNextAd();
            this.b = nextAd;
            this.i = V(this.i, nextAd);
            bfVar = new bf(bf.a.BACKUP_VIEW);
            pVar = this.b;
            placementMediaView = this.i;
        } else {
            p nextAd2 = getNextAd();
            this.f9416a = nextAd2;
            this.h = V(this.h, nextAd2);
            bfVar = new bf(bf.a.MAIN_VIEW);
            pVar = this.f9416a;
            placementMediaView = this.h;
        }
        Code(bfVar, pVar, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p getCurrentAd() {
        if (this.f9417c < this.L.size()) {
            return this.L.get(this.f9417c);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getCurrentAdDuration() {
        r S;
        p currentAd = getCurrentAd();
        if (currentAd == null || (S = currentAd.S()) == null) {
            return 0L;
        }
        return S.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentContentId() {
        p currentAd = getCurrentAd();
        if (currentAd == null) {
            return null;
        }
        return currentAd.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r getCurrentMediaFile() {
        if (getCurrentAd() != null) {
            return getCurrentAd().S();
        }
        return null;
    }

    private com.huawei.openalliance.ad.media.c getCurrentMediaState() {
        PlacementMediaView placementMediaView = this.q;
        if (placementMediaView == null) {
            return null;
        }
        return placementMediaView.getMediaState();
    }

    private int getCurrentPlayTime() {
        int i = this.f9417c;
        if (i < 1) {
            return 0;
        }
        return this.p[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p getNextAd() {
        if (this.f9417c < this.L.size() - 1) {
            return this.L.get(this.f9417c + 1);
        }
        return null;
    }

    private void h() {
        PlacementMediaView placementMediaView;
        p nextAd = getNextAd();
        if (nextAd != null) {
            this.D.V(nextAd.r(), nextAd.s());
        }
        this.F.Code(nextAd);
        this.F.Z();
        if (this.U.V(bf.a.SINGLE_INST)) {
            this.j = V(this.j, nextAd);
            Code(new bf(bf.a.SINGLE_INST), nextAd, this.j);
            Code(this.j);
        } else {
            if (Math.abs(this.h.getAlpha() - 1.0f) < 0.01f) {
                this.U.Code(bf.a.BACKUP_VIEW);
                Code(this.i);
                placementMediaView = this.h;
            } else {
                this.U.Code(bf.a.MAIN_VIEW);
                Code(this.h);
                placementMediaView = this.i;
            }
            Code(placementMediaView, false);
        }
        this.D.b();
        ge.V("PPSPlacementView", "show " + this.f9417c + " ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.H = false;
        ge.V("PPSPlacementView", "timeout, cancel.");
        this.aa.removeMessages(1001);
    }

    private void j() {
        if (this.z == null) {
            return;
        }
        try {
            ge.V("PPSPlacementView", "showLastFrame");
            this.A = false;
            this.z.setVisibility(0);
            this.z.setScaleType(ImageView.ScaleType.FIT_CENTER);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.z, layoutParams);
        } catch (Throwable th) {
            ge.I("PPSPlacementView", "showLastFrame error.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.14
            @Override // java.lang.Runnable
            public void run() {
                if (PPSPlacementView.this.z == null) {
                    return;
                }
                try {
                    ge.V("PPSPlacementView", "hide last frame.");
                    PPSPlacementView.this.z.setVisibility(8);
                    PPSPlacementView.this.removeView(PPSPlacementView.this.z);
                    PPSPlacementView.this.z = null;
                    PPSPlacementView.this.A = true;
                } catch (Throwable th) {
                    ge.I("PPSPlacementView", "hideLastFrame error.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String str;
        if (!n()) {
            ge.I("PPSPlacementView", "audio focus is not needed");
            return;
        }
        try {
            ge.V("PPSPlacementView", "requestAudioFocus");
            if (Build.VERSION.SDK_INT < 26) {
                this.R.requestAudioFocus(this.ad, 3, 2);
                return;
            }
            AudioFocusRequest build = new AudioFocusRequest.Builder(2).setOnAudioFocusChangeListener(this.ad).build();
            this.T = build;
            this.R.requestAudioFocus(build);
        } catch (IllegalStateException e) {
            str = "requestAudioFocus IllegalStateException";
            ge.I("PPSPlacementView", str);
        } catch (Exception e2) {
            str = "requestAudioFocus " + e2.getClass().getSimpleName();
            ge.I("PPSPlacementView", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        String str;
        try {
            try {
                ge.V("PPSPlacementView", "abandonAudioFocus");
                if (Build.VERSION.SDK_INT < 26) {
                    this.R.abandonAudioFocus(this.ad);
                } else {
                    if (this.T instanceof AudioFocusRequest) {
                        this.R.abandonAudioFocusRequest((AudioFocusRequest) this.T);
                    }
                    this.T = null;
                }
            } catch (IllegalStateException e) {
                str = "abandonAudioFocus IllegalStateException";
                ge.I("PPSPlacementView", str);
            } catch (Exception e2) {
                str = "abandonAudioFocus " + e2.getClass().getSimpleName();
                ge.I("PPSPlacementView", str);
            }
        } finally {
            this.Q = false;
            this.P = 0;
        }
    }

    private boolean n() {
        ge.V("PPSPlacementView", "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.x), Boolean.valueOf(this.r));
        int i = this.x;
        if (i == 0) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        return (i == 1 && this.r) ? false : true;
    }

    public void C() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.6
            @Override // java.lang.Runnable
            public void run() {
                ge.V("PPSPlacementView", "muteSound");
                PPSPlacementView.this.r = true;
                if (PPSPlacementView.this.x == 1) {
                    PPSPlacementView.this.m();
                }
                boolean z = false;
                if (PPSPlacementView.this.h != null) {
                    PPSPlacementView.this.h.I();
                    z = true;
                }
                if (PPSPlacementView.this.i != null) {
                    PPSPlacementView.this.i.I();
                    z = true;
                }
                if (PPSPlacementView.this.j != null) {
                    PPSPlacementView.this.j.I();
                    z = true;
                }
                if (z) {
                    PPSPlacementView.this.F.Code(PPSPlacementView.this.r);
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.gs
    public void Code() {
        ge.V("PPSPlacementView", "onMute");
        this.r = true;
    }

    @Override // com.huawei.hms.ads.ha
    public void Code(long j, int i) {
        I(this.u, i);
    }

    public void Code(gs gsVar) {
        if (gsVar == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.h;
        if (placementMediaView != null) {
            placementMediaView.Code(gsVar);
        } else {
            this.l = gsVar;
        }
    }

    public void Code(ll llVar) {
        if (llVar == null) {
            return;
        }
        this.o = llVar;
    }

    public void Code(lm lmVar) {
        if (lmVar == null) {
            return;
        }
        this.n = lmVar;
    }

    public void Code(Integer num) {
        Code(Long.valueOf(System.currentTimeMillis() - this.D.Z()), Integer.valueOf(this.D.I()), num);
    }

    @Override // com.huawei.hms.ads.gu
    public void Code(String str, String str2, int i) {
        ge.V("PPSPlacementView", "onSegmentMediaStart, contentId: %s, url: %s", str, bc.Code(str2));
        this.s = true;
        this.t = i;
        PlacementMediaView placementMediaView = this.q;
        if (placementMediaView != null) {
            placementMediaView.setAlpha(1.0f);
        }
        if (this.n != null && this.f9417c == 0) {
            ge.V("PPSPlacementView", "need notify media start.");
            this.E = true;
        }
        if (this.o == null || this.q == null) {
            return;
        }
        ge.V("PPSPlacementView", "mediaChange callback.");
        this.o.Code(this.q.getPlacementAd());
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cc, code lost:
        if (r11 <= 0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    @Override // com.huawei.hms.ads.gu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Code(java.lang.String r8, java.lang.String r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSPlacementView.Code(java.lang.String, java.lang.String, int, int):void");
    }

    @Override // com.huawei.hms.ads.gu
    public void Code(String str, String str2, int i, int i2, int i3) {
        PlacementMediaView placementMediaView;
        r S;
        ge.V("PPSPlacementView", "onSegmentMediaError, contentId: %s, url: %s", str, bc.Code(str2));
        String currentContentId = getCurrentContentId();
        if (str != null && !str.equalsIgnoreCase(currentContentId)) {
            ge.V("PPSPlacementView", "onError, contentId not match, currentConentId: %s", currentContentId);
            return;
        }
        k();
        i();
        ge.I("PPSPlacementView", "onSegmentMediaError:" + bc.Code(str2) + ", playTime:" + i + ",errorCode:" + i2 + ",extra:" + i3);
        Code(i);
        if (this.n != null) {
            int currentPlayTime = getCurrentPlayTime() + i;
            ge.V("PPSPlacementView", "mediaError callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.n.Code(currentPlayTime, i2, i3);
        }
        if (!this.G) {
            ge.V("PPSPlacementView", "error before start callback.");
            this.E = true;
        }
        this.D.c();
        this.q.Code(i);
        p currentAd = getCurrentAd();
        if (currentAd != null && (S = currentAd.S()) != null) {
            this.F.Code(S.Z(), i2, i3, currentAd);
        }
        boolean f = f();
        V(f);
        if (this.n == null || !f || this.p.length <= 0) {
            return;
        }
        ge.V("PPSPlacementView", "last ad play error");
        lm lmVar = this.n;
        int[] iArr = this.p;
        lmVar.Z(iArr[iArr.length - 1]);
        if (!this.U.V(bf.a.SINGLE_INST) || (placementMediaView = this.j) == null) {
            return;
        }
        placementMediaView.V();
    }

    public void Code(final List<com.huawei.openalliance.ad.inter.data.h> list) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder();
                sb.append("register:");
                List list2 = list;
                sb.append(list2 == null ? 0 : list2.size());
                ge.V("PPSPlacementView", sb.toString());
                PPSPlacementView.this.I(list);
                if (aa.Code(list) || aa.Code(PPSPlacementView.this.L)) {
                    return;
                }
                PPSPlacementView.this.f9417c = 0;
                PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                pPSPlacementView.f9416a = pPSPlacementView.getCurrentAd();
                PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                pPSPlacementView2.b = pPSPlacementView2.getNextAd();
                PPSPlacementView.this.a();
                PPSPlacementView.this.e();
                PlacementMediaView placementMediaView = PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.j : PPSPlacementView.this.h;
                PPSPlacementView.this.b();
                PPSPlacementView.this.Code(placementMediaView);
                if (PPSPlacementView.this.w) {
                    PPSPlacementView.this.L();
                }
            }
        });
    }

    public void D() {
        this.n = null;
    }

    public void F() {
        this.o = null;
    }

    @Override // com.huawei.hms.ads.ha
    public void I() {
        this.w = true;
        this.f = false;
        this.g = false;
        long Code = v.Code();
        this.N = Code;
        ge.Code("PPSPlacementView", "onViewPhysicalShowStart: %s", Long.valueOf(Code));
        p currentAd = getCurrentAd();
        if (currentAd != null) {
            currentAd.Z(false);
        }
        b();
        if (this.f9416a != null) {
            L();
            (this.U.V(bf.a.SINGLE_INST) ? this.I : this.U.V(bf.a.MAIN_VIEW) ? this.Code : this.V).L();
        }
    }

    @Override // com.huawei.hms.ads.gu
    public void I(String str, String str2, int i) {
        ge.V("PPSPlacementView", "onSegmentMediaStop, contentId: %s, url: %s", str, bc.Code(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            Code(i);
        }
        if (this.n == null || !str.equalsIgnoreCase(getCurrentContentId())) {
            ge.V("PPSPlacementView", "skip mediaStop callback, listener null ? %s, currentContentId: %s", Boolean.valueOf(this.n == null), getCurrentContentId());
            return;
        }
        int currentPlayTime = getCurrentPlayTime() + i;
        ge.V("PPSPlacementView", "mediaStop callback, playedTime: %s", Integer.valueOf(currentPlayTime));
        this.n.I(currentPlayTime);
    }

    public void S() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.8
            @Override // java.lang.Runnable
            public void run() {
                ge.V("PPSPlacementView", "unmuteSound");
                boolean z = false;
                PPSPlacementView.this.r = false;
                if (PPSPlacementView.this.x == 1) {
                    PPSPlacementView.this.l();
                }
                if (PPSPlacementView.this.h != null) {
                    PPSPlacementView.this.h.B();
                    z = true;
                }
                if (PPSPlacementView.this.i != null) {
                    PPSPlacementView.this.i.B();
                    z = true;
                }
                if (PPSPlacementView.this.j != null) {
                    PPSPlacementView.this.j.B();
                    z = true;
                }
                if (z) {
                    PPSPlacementView.this.F.Code(PPSPlacementView.this.r);
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.gs
    public void V() {
        ge.V("PPSPlacementView", "onUnmute");
        this.r = false;
    }

    @Override // com.huawei.hms.ads.ha
    public void V(long j, int i) {
        if (!this.g) {
            this.g = true;
            this.F.Code(j, i);
        }
        this.w = false;
        this.v = false;
    }

    public void V(gs gsVar) {
        if (gsVar == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.h;
        if (placementMediaView != null) {
            placementMediaView.V(gsVar);
        } else {
            this.l = null;
        }
    }

    @Override // com.huawei.hms.ads.gu
    public void V(String str, String str2, int i) {
        ge.V("PPSPlacementView", "onSegmentMediaPause:" + bc.Code(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            Code(i);
        }
        if (this.n != null) {
            int currentPlayTime = getCurrentPlayTime() + i;
            ge.V("PPSPlacementView", "mediaPause callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.n.V(currentPlayTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof PlacementVideoView) {
                ((PlacementVideoView) view).setOnClickListener(this.ac);
            } else {
                view.setOnClickListener(this.ac);
            }
        }
    }

    @Override // com.huawei.hms.ads.gu
    public void Z(String str, String str2, int i) {
        PlacementMediaView placementMediaView;
        String currentContentId = getCurrentContentId();
        if (str != null && !str.equalsIgnoreCase(currentContentId)) {
            ge.V("PPSPlacementView", "onCompletion, %s not match current contentId: %s.", str, currentContentId);
            return;
        }
        boolean f = f();
        if (!f) {
            PlacementMediaView placementMediaView2 = this.q;
            if (placementMediaView2 instanceof PlacementVideoView) {
                this.z = placementMediaView2.getLastFrame();
                j();
            }
        }
        i();
        ge.V("PPSPlacementView", "onSegmentMediaCompletion, contentId: %s, url: %s", str, bc.Code(str2));
        Code(i);
        this.D.c();
        this.q.Code(i);
        V(f);
        if (this.n != null && f) {
            int currentPlayTime = getCurrentPlayTime() + i;
            ge.V("PPSPlacementView", "mediaCompletion callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.n.Z(currentPlayTime);
            if (this.U.V(bf.a.SINGLE_INST) && (placementMediaView = this.j) != null) {
                placementMediaView.V();
            }
        }
        ke keVar = this.F;
        if (keVar != null) {
            long j = i;
            keVar.Code(getContext(), j, j);
        }
    }

    @Override // com.huawei.hms.ads.ha
    public void a_() {
        this.t = -1;
        this.s = false;
    }

    @Override // com.huawei.hms.ads.ls
    public void destroyView() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.11
            @Override // java.lang.Runnable
            public void run() {
                ge.V("PPSPlacementView", "destroyView");
                if (PPSPlacementView.this.q != null) {
                    PPSPlacementView.this.q.S();
                    PPSPlacementView.this.q.destroyView();
                }
                PPSPlacementView.this.F();
                PPSPlacementView.this.D();
                PPSPlacementView.this.i();
                PPSPlacementView.this.Code.I();
                PPSPlacementView.this.V.I();
                PPSPlacementView.this.I.I();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (ky.Code(motionEvent) == 0) {
                this.J = ky.Code(this, motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            ge.I("PPSPlacementView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public void hideAdvertiserInfoDialog() {
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), bb.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    public boolean isPlaying() {
        PlacementMediaView placementMediaView = this.q;
        if (placementMediaView != null) {
            return placementMediaView.F();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ge.Code("PPSPlacementView", "onAttachedToWindow");
        this.D.D();
        kl.Code(getContext()).V(getContext());
    }

    public void onClose() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.2
            @Override // java.lang.Runnable
            public void run() {
                ge.V("PPSPlacementView", "onClose");
                PPSPlacementView.this.F.Code();
                (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).d();
                PPSPlacementView.this.Code.I();
                PPSPlacementView.this.V.I();
                PPSPlacementView.this.I.I();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ge.V("PPSPlacementView", "onDetechedFromWindow");
        this.D.L();
        this.Code.I();
        this.V.I();
        this.I.I();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.D.a();
    }

    public void pause() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.4
            @Override // java.lang.Runnable
            public void run() {
                ge.V("PPSPlacementView", com.anythink.expressad.foundation.d.c.cb);
                if (PPSPlacementView.this.q != null) {
                    PPSPlacementView.this.q.C();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.ls
    public void pauseView() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.10
            @Override // java.lang.Runnable
            public void run() {
                ge.V("PPSPlacementView", "pauseView");
                if (PPSPlacementView.this.q != null) {
                    PPSPlacementView.this.q.pauseView();
                    PPSPlacementView.this.q.C();
                    PPSPlacementView.this.i();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.ls
    public void resumeView() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.9
            @Override // java.lang.Runnable
            public void run() {
                ge.V("PPSPlacementView", "resumeView");
                if (PPSPlacementView.this.q != null) {
                    PPSPlacementView.this.q.resumeView();
                    PPSPlacementView.this.q.Code(true, PPSPlacementView.this.r);
                    PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                    pPSPlacementView.Code(pPSPlacementView.getCurrentAdDuration() * 2);
                }
            }
        });
    }

    public void setAudioFocusType(int i) {
        this.x = i;
    }

    public void setMediaPlayerReleaseListener(gq gqVar) {
        if (gqVar == null) {
            return;
        }
        this.O = gqVar;
    }

    public void setOnPlacementAdClickListener(a aVar) {
        this.d = aVar;
    }

    public void setOverlays(List<View> list) {
        this.K = list;
    }

    public void setSoundVolume(final float f) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.7
            @Override // java.lang.Runnable
            public void run() {
                ge.V("PPSPlacementView", "set sound volume: %s", Float.valueOf(f));
                if (PPSPlacementView.this.q != null) {
                    PPSPlacementView.this.q.setSoundVolume(f);
                    (PPSPlacementView.this.U.V(bf.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bf.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).V(f);
                }
            }
        });
    }

    public void showAdvertiserInfoDialog(View view, boolean z) {
        if (view == null) {
            ge.I("PPSPlacementView", "anchorView is null");
        }
        try {
            p currentAd = getCurrentAd();
            if (currentAd == null) {
                ge.I("PPSPlacementView", "adInfo is null");
                return;
            }
            AdContentData l = currentAd.l();
            if (aa.Code(l.aG())) {
                ge.I("PPSPlacementView", "advertiser Info is null");
            } else {
                ComplianceActivity.Code(getContext(), view, l, z);
            }
        } catch (Throwable th) {
            ge.I("PPSPlacementView", "showAdvertiserInfoDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    public void stop() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.5
            @Override // java.lang.Runnable
            public void run() {
                ge.V("PPSPlacementView", "stop");
                if (PPSPlacementView.this.q != null) {
                    PPSPlacementView.this.q.S();
                }
            }
        });
    }
}
