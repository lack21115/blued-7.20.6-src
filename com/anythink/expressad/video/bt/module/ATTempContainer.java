package com.anythink.expressad.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.r;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.module.b.h;
import com.anythink.expressad.video.module.AnythinkContainerView;
import com.anythink.expressad.video.module.AnythinkVideoView;
import com.anythink.expressad.video.module.a.a.f;
import com.anythink.expressad.video.module.a.a.m;
import com.anythink.expressad.video.signal.a.c;
import com.anythink.expressad.video.signal.container.AbstractJSContainer;
import com.anythink.expressad.videocommon.a;
import com.huawei.openalliance.ad.constant.ao;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer.class */
public class ATTempContainer extends AbstractJSContainer {
    private static final String A = ATTempContainer.class.getSimpleName();
    private static final long aa = 5000;
    private static final long ab = 2000;
    private static final long ac = 100;
    private static final int ad = -1;
    private static final int ae = -2;
    private static final int af = -3;
    private static final int ag = -3;
    private static final int ah = -4;
    private static final int al = 250;
    protected static final int b = 0;
    private View B;
    private com.anythink.expressad.foundation.d.c C;
    private com.anythink.expressad.videocommon.b.c D;
    private h E;
    private com.anythink.expressad.video.bt.module.a.b F;
    private com.anythink.expressad.video.dynview.f.a G;
    private int H;
    private String I;
    private com.anythink.expressad.video.signal.factory.b J;
    private int K;
    private int L;
    private boolean M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private String S;
    private String T;
    private List<com.anythink.expressad.foundation.d.c> U;
    private int V;
    private LayoutInflater W;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f5457a;
    private int ai;
    private int aj;
    private int ak;
    private View am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;

    /* renamed from: ar  reason: collision with root package name */
    private boolean f5458ar;
    private boolean as;
    private boolean at;
    private boolean au;
    private boolean av;
    private boolean aw;
    private MraidVolumeChangeReceiver ax;
    private Runnable ay;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f5459c;
    protected a d;
    protected WindVaneWebView e;
    protected AnythinkVideoView f;
    protected AnythinkContainerView g;
    protected Handler h;
    protected Runnable i;
    protected Runnable j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$5.class */
    public final class AnonymousClass5 implements com.anythink.expressad.foundation.f.a {
        AnonymousClass5() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            String str;
            ATTempContainer.this.onPause();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                o.b(ATTempContainer.A, th.getMessage(), th);
                str = "";
            }
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            j.a();
            j.a((WebView) ATTempContainer.this.e, AbsFeedBackForH5.f4258a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            String str;
            ATTempContainer.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                o.b(ATTempContainer.A, th.getMessage(), th);
                str = "";
            }
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            j.a();
            j.a((WebView) ATTempContainer.this.e, AbsFeedBackForH5.f4258a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            String str;
            ATTempContainer.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                o.b(ATTempContainer.A, th.getMessage(), th);
                str = "";
            }
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            j.a();
            j.a((WebView) ATTempContainer.this.e, AbsFeedBackForH5.f4258a, encodeToString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$6  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$6.class */
    public final class AnonymousClass6 implements MraidVolumeChangeReceiver.VolumeChangeListener {
        AnonymousClass6() {
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener
        public final void onVolumeChanged(double d) {
            o.d(ATTempContainer.A, "volume is : ".concat(String.valueOf(d)));
            try {
                if (!ATTempContainer.this.C.H() || ATTempContainer.this.g == null || ATTempContainer.this.g.getH5EndCardView() == null) {
                    return;
                }
                ATTempContainer.this.g.getH5EndCardView().volumeChange(d);
            } catch (Exception e) {
                o.d(ATTempContainer.A, e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$7  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$7.class */
    public final class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ATTempContainer.this.am.setBackgroundColor(0);
            ATTempContainer.this.am.setVisibility(0);
            ATTempContainer.this.am.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$8  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$8.class */
    public final class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ATTempContainer.this.am.setVisibility(8);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$a.class */
    public interface a {

        /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$a$a.class */
        public static class C0088a implements a {
            private static final String b = "ActivityErrorListener";

            /* renamed from: a  reason: collision with root package name */
            private boolean f5468a = false;

            @Override // com.anythink.expressad.video.bt.module.ATTempContainer.a
            public void a(String str) {
                o.d(b, str);
                this.f5468a = true;
            }

            @Override // com.anythink.expressad.video.bt.module.ATTempContainer.a
            public final boolean a() {
                return this.f5468a;
            }

            @Override // com.anythink.expressad.video.bt.module.ATTempContainer.a
            public final void b() {
                this.f5468a = true;
            }
        }

        void a(String str);

        boolean a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$b.class */
    public final class b extends f {
        private Activity V;
        private com.anythink.expressad.foundation.d.c W;

        public b(Activity activity, com.anythink.expressad.foundation.d.c cVar) {
            this.V = activity;
            this.W = cVar;
        }

        @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i, Object obj) {
            Context context = ATTempContainer.this.getContext();
            if (context != null && context != context.getApplicationContext()) {
                ATTempContainer.this.getJSCommon().a(context);
            }
            if (this.V != null) {
                ATTempContainer.this.getJSCommon().a(this.V);
            }
            ATTempContainer.m(ATTempContainer.this);
            if (i == 108) {
                ATTempContainer.this.getJSCommon().a(new c.b(ATTempContainer.this.getJSCommon(), new d(ATTempContainer.this, (byte) 0)));
                ATTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
            } else if (i == 113) {
                ATTempContainer.this.E.a(this.W);
            } else if (i == 117) {
                if (ATTempContainer.this.f != null) {
                    ATTempContainer.this.f.setVisible(4);
                }
                ATTempContainer.m(ATTempContainer.this);
                ATTempContainer.this.E.c();
            } else if (i != 126 && i != 128) {
                switch (i) {
                    case 103:
                    case 104:
                        ATTempContainer.k(ATTempContainer.this);
                        break;
                    case 105:
                        ATTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                        break;
                    case 106:
                        if (ATTempContainer.this.F != null) {
                            ATTempContainer.this.F.a(ATTempContainer.this.I, this.W);
                        } else {
                            ATTempContainer.this.E.a(this.W);
                        }
                        if (this.V != null && this.W != null) {
                            n.a().a(new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.b.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ATTempContainer.k(ATTempContainer.this);
                                }
                            }, 50L);
                            break;
                        }
                        break;
                }
            } else {
                ATTempContainer.this.E.a(this.W);
            }
            super.a(i, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$c.class */
    public final class c extends f {
        private c() {
        }

        /* synthetic */ c(ATTempContainer aTTempContainer, byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i, Object obj) {
            super.a(i, obj);
            try {
                String obj2 = obj instanceof JSONObject ? obj.toString() : (String) obj;
                if (ATTempContainer.this.t && !TextUtils.isEmpty(obj2)) {
                    JSONObject jSONObject = new JSONObject(obj2);
                    int optInt = jSONObject.optInt("type");
                    int optInt2 = jSONObject.optInt("complete");
                    if (optInt == 2) {
                        ATTempContainer.this.K = com.anythink.expressad.foundation.g.a.cx;
                    } else if (optInt != 3) {
                        ATTempContainer.this.K = com.anythink.expressad.foundation.g.a.cv;
                    } else {
                        ATTempContainer.this.K = com.anythink.expressad.foundation.g.a.cw;
                    }
                    ATTempContainer.this.L = optInt2;
                }
            } catch (Exception e) {
                o.d("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i == 120) {
                ATTempContainer.this.E.c();
            } else if (i == 126) {
                ATTempContainer.this.E.a(ATTempContainer.this.C);
            } else if (i == 127) {
                ATTempContainer.h(ATTempContainer.this);
                ATTempContainer.this.E.a();
                ATTempContainer.this.E.c();
                ATTempContainer.this.getJSContainerModule().showEndcard(100);
            } else {
                switch (i) {
                    case 100:
                        ATTempContainer.q(ATTempContainer.this);
                        ATTempContainer.this.h.postDelayed(ATTempContainer.this.ay, 250L);
                        ATTempContainer.this.E.a();
                        return;
                    case 101:
                    case 102:
                        ATTempContainer.this.getJSCommon().j();
                        return;
                    case 103:
                        ATTempContainer.h(ATTempContainer.this);
                        if (ATTempContainer.this.C.H()) {
                            ATTempContainer.k(ATTempContainer.this);
                            return;
                        } else {
                            ATTempContainer.this.getJSCommon().j();
                            return;
                        }
                    case 104:
                        ATTempContainer.k(ATTempContainer.this);
                        return;
                    case 105:
                        ATTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$d.class */
    public final class d extends c.a {
        private d() {
        }

        /* synthetic */ d(ATTempContainer aTTempContainer, byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(int i, String str) {
            super.a(i, str);
            ATTempContainer.this.defaultLoad(i, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, String str) {
            super.a(cVar, str);
            ATTempContainer.s(ATTempContainer.this);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
            super.a(cVar, z);
            ATTempContainer.this.E.a(cVar);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar, String str) {
            super.a(jVar, str);
            ATTempContainer.t(ATTempContainer.this);
            ATTempContainer.u(ATTempContainer.this);
            if (jVar == null || !(jVar instanceof com.anythink.expressad.foundation.d.c)) {
                return;
            }
            try {
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) jVar;
                String optString = new JSONObject(ATTempContainer.this.getJSVideoModule().getCurrentProgress()).optString("progress", "");
                if (cVar.Q() == 3 && cVar.C() == 2 && optString.equals("1.0") && ATTempContainer.this.l != null) {
                    if (ATTempContainer.this.y) {
                        ATTempContainer.k(ATTempContainer.this);
                    } else {
                        ATTempContainer.this.l.finish();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void b() {
            super.b();
            ATTempContainer.this.receiveSuccess();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar, String str) {
            super.b(jVar, str);
            ATTempContainer.u(ATTempContainer.this);
            ATTempContainer.t(ATTempContainer.this);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void c() {
            super.c();
            if (ATTempContainer.this.h != null) {
                ATTempContainer.this.h.removeCallbacks(ATTempContainer.this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/ATTempContainer$e.class */
    public final class e extends f {
        private e() {
        }

        /* synthetic */ e(ATTempContainer aTTempContainer, byte b) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x0192, code lost:
            if (r4.f5473a.C.l() != false) goto L57;
         */
        @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(int r5, java.lang.Object r6) {
            /*
                Method dump skipped, instructions count: 458
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.bt.module.ATTempContainer.e.a(int, java.lang.Object):void");
        }
    }

    public ATTempContainer(Context context) {
        super(context);
        this.H = 1;
        this.I = "";
        this.K = com.anythink.expressad.foundation.g.a.cv;
        this.M = false;
        this.S = "";
        this.U = new ArrayList();
        this.V = 0;
        this.f5457a = false;
        this.f5459c = false;
        this.d = new a.C0088a();
        this.h = new Handler();
        this.ai = 0;
        this.aj = 0;
        this.ak = 0;
        this.i = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.getActivityProxy().h() != 0) {
                    ATTempContainer.this.ai = -3;
                    return;
                }
                Log.d(ATTempContainer.A, "run: WebView load timeout");
                ATTempContainer.this.defaultLoad(-1, "WebView load timeout");
            }
        };
        this.j = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.getActivityProxy().h() == 0) {
                    ATTempContainer.this.defaultLoad(-3, "JS bridge connect timeout");
                } else {
                    ATTempContainer.this.ai = -4;
                }
            }
        };
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.f5458ar = false;
        this.as = false;
        this.at = false;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ay = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.3
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.am != null) {
                    ATTempContainer.this.am.setVisibility(8);
                }
            }
        };
        init(context);
    }

    public ATTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = 1;
        this.I = "";
        this.K = com.anythink.expressad.foundation.g.a.cv;
        this.M = false;
        this.S = "";
        this.U = new ArrayList();
        this.V = 0;
        this.f5457a = false;
        this.f5459c = false;
        this.d = new a.C0088a();
        this.h = new Handler();
        this.ai = 0;
        this.aj = 0;
        this.ak = 0;
        this.i = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.getActivityProxy().h() != 0) {
                    ATTempContainer.this.ai = -3;
                    return;
                }
                Log.d(ATTempContainer.A, "run: WebView load timeout");
                ATTempContainer.this.defaultLoad(-1, "WebView load timeout");
            }
        };
        this.j = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.getActivityProxy().h() == 0) {
                    ATTempContainer.this.defaultLoad(-3, "JS bridge connect timeout");
                } else {
                    ATTempContainer.this.ai = -4;
                }
            }
        };
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.f5458ar = false;
        this.as = false;
        this.at = false;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ay = new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.3
            @Override // java.lang.Runnable
            public final void run() {
                if (ATTempContainer.this.am != null) {
                    ATTempContainer.this.am.setVisibility(8);
                }
            }
        };
        init(context);
    }

    private int a(int i, int i2) {
        List<com.anythink.expressad.foundation.d.c> list;
        int i3;
        if (i >= 0 && (list = this.U) != null && list.size() != 0 && i2 > 1) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i3 = i5;
                if (i4 >= i2 - 1) {
                    break;
                }
                int i6 = i3;
                if (this.U.get(i4) != null) {
                    i6 = i3 + this.U.get(i4).bi();
                }
                i4++;
                i5 = i6;
            }
            int i7 = 0;
            if (i > i3) {
                i7 = i - i3;
            }
            return i7;
        }
        return i;
    }

    private void a(int i, String str) {
        try {
            r rVar = new r();
            rVar.h(r.i);
            rVar.c("code=" + i + ",desc=" + str);
            rVar.b((this.C == null || this.C.M() == null) ? "" : this.C.M().e());
            rVar.f(this.m);
            rVar.g(this.C != null ? this.C.aZ() : "");
            if (this.C != null && !TextUtils.isEmpty(this.C.Z())) {
                rVar.d(this.C.Z());
            }
            if (this.C != null && !TextUtils.isEmpty(this.C.aa())) {
                rVar.e(this.C.aa());
            }
            getContext();
            int a2 = k.a();
            rVar.c(a2);
            rVar.j(k.a(getContext(), a2));
            r.a(rVar);
            com.anythink.expressad.video.module.b.a.a();
        } catch (Throwable th) {
            o.b(A, th.getMessage(), th);
        }
    }

    private static RelativeLayout.LayoutParams c() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    private void d() {
        if (this.f5457a) {
            setMatchParent();
        }
    }

    private int e() {
        com.anythink.expressad.video.signal.a.j b2 = b(this.C);
        if (b2 != null) {
            return b2.c();
        }
        return 0;
    }

    private int f() {
        if (getJSCommon() != null) {
            return getJSCommon().n();
        }
        return 1;
    }

    private int g() {
        com.anythink.expressad.video.signal.a.j b2 = b(this.C);
        if (b2 != null) {
            return b2.b();
        }
        return 0;
    }

    private boolean h() {
        com.anythink.expressad.video.signal.a.j b2 = b(this.C);
        if (b2 != null) {
            return b2.a();
        }
        return false;
    }

    static /* synthetic */ boolean h(ATTempContainer aTTempContainer) {
        aTTempContainer.ao = true;
        return true;
    }

    private boolean i() {
        AnythinkVideoView anythinkVideoView = this.f;
        if (anythinkVideoView != null) {
            return anythinkVideoView.isShowingAlertView() || this.f.isInstallDialogShowing();
        }
        return false;
    }

    private void j() {
        int f;
        int e2;
        try {
            if (this.e != null) {
                int i = getResources().getConfiguration().orientation;
                if (h()) {
                    int g = t.g(getContext());
                    int h = t.h(getContext());
                    f = g;
                    e2 = h;
                    if (t.a(getContext())) {
                        int i2 = t.i(getContext());
                        if (i == 2) {
                            f = g + i2;
                            e2 = h;
                        } else {
                            e2 = h + i2;
                            f = g;
                        }
                    }
                } else {
                    f = t.f(getContext());
                    e2 = t.e(getContext());
                }
                int c2 = this.C.M().c();
                if (c(this.C) == 1) {
                    c2 = i;
                }
                getJSNotifyProxy().a(i, c2, f, e2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.anythink.expressad.foundation.g.a.ch, t.c(getContext()));
                try {
                    if (this.q != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", this.q.a());
                        jSONObject2.put("amount", this.q.b());
                        jSONObject2.put("id", this.r);
                        jSONObject.put(ao.q, this.p);
                        jSONObject.put("reward", jSONObject2);
                        jSONObject.put("playVideoMute", this.s);
                        jSONObject.put("extra", this.T);
                    }
                } catch (JSONException e3) {
                    o.a(A, e3.getMessage());
                } catch (Exception e4) {
                    o.a(A, e4.getMessage());
                }
                getJSNotifyProxy().a(jSONObject.toString());
                j.a();
                j.a((WebView) this.e, "oncutoutfetched", Base64.encodeToString(this.S.getBytes(), 0));
                getJSCommon().h();
                loadModuleDatas();
                this.h.postDelayed(this.i, 2000L);
            }
        } catch (Exception e5) {
            if (com.anythink.expressad.a.f4103a) {
                e5.printStackTrace();
            }
        }
    }

    private void k() {
        int i = this.ai;
        Runnable runnable = i == -3 ? this.i : i == -4 ? this.j : null;
        if (runnable != null) {
            runnable.run();
            this.ai = 0;
        }
    }

    static /* synthetic */ void k(ATTempContainer aTTempContainer) {
        try {
            if (aTTempContainer.F == null) {
                if (aTTempContainer.l != null) {
                    aTTempContainer.l.finish();
                    return;
                }
                return;
            }
            if (aTTempContainer.t && (aTTempContainer.v == com.anythink.expressad.foundation.g.a.cr || aTTempContainer.v == com.anythink.expressad.foundation.g.a.cs)) {
                com.anythink.expressad.video.bt.module.a.b bVar = aTTempContainer.F;
                boolean z = true;
                if (aTTempContainer.L != 1) {
                    z = false;
                }
                bVar.a(z, aTTempContainer.K);
            }
            aTTempContainer.F.a(aTTempContainer.I, aTTempContainer.ao, aTTempContainer.q);
        } catch (Exception e2) {
            if (aTTempContainer.l != null) {
                aTTempContainer.l.finish();
            }
        }
    }

    private boolean l() {
        this.e = findWindVaneWebView();
        AnythinkVideoView findAnythinkVideoView = findAnythinkVideoView();
        this.f = findAnythinkVideoView;
        findAnythinkVideoView.setVideoLayout(this.C);
        this.f.setIsIV(this.t);
        this.f.setUnitId(this.m);
        this.f.setCamPlayOrderCallback(this.G, this.U, this.H, this.V);
        if (this.y) {
            this.f.setNotchPadding(this.O, this.P, this.Q, this.R);
        }
        this.g = findAnythinkContainerView();
        if (this.y) {
            this.g.setNotchPadding(this.N, this.O, this.P, this.Q, this.R);
        }
        return (this.f == null || this.g == null || !initViews()) ? false : true;
    }

    private void m() {
        if (this.o == null) {
            this.o = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.m, this.t);
        }
    }

    static /* synthetic */ boolean m(ATTempContainer aTTempContainer) {
        aTTempContainer.au = true;
        return true;
    }

    private static void n() {
    }

    private void o() {
        try {
            if (this.F == null) {
                if (this.l != null) {
                    this.l.finish();
                    return;
                }
                return;
            }
            if (this.t && (this.v == com.anythink.expressad.foundation.g.a.cr || this.v == com.anythink.expressad.foundation.g.a.cs)) {
                com.anythink.expressad.video.bt.module.a.b bVar = this.F;
                boolean z = true;
                if (this.L != 1) {
                    z = false;
                }
                bVar.a(z, this.K);
            }
            this.F.a(this.I, this.ao, this.q);
        } catch (Exception e2) {
            if (this.l != null) {
                this.l.finish();
            }
        }
    }

    private static void p() {
    }

    private void q() {
        ViewGroup viewGroup;
        List<com.anythink.expressad.foundation.d.c> list;
        WindVaneWebView windVaneWebView = this.e;
        this.J = new com.anythink.expressad.video.signal.factory.b(this.l, windVaneWebView, this.f, this.g, this.C, new d(this, (byte) 0));
        com.anythink.expressad.foundation.d.c cVar = this.C;
        if (cVar != null && cVar.k() == 5 && (list = this.U) != null) {
            this.J.a(list);
        }
        registerJsFactory(this.J);
        com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
        a2.a(this.m + "_1", new AnonymousClass5());
        if (windVaneWebView == null) {
            o.a(A, "template webview is null");
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.B.findViewById(i.a(getContext(), "anythink_video_templete_webview_parent", "id"));
        windVaneWebView.setApiManagerJSFactory(this.J);
        if (windVaneWebView.getParent() != null) {
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        if (windVaneWebView.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
            this.J.a((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject());
            getJSCommon().a(this.s);
            getJSCommon().a(this.m);
            getJSCommon().a(this.o);
            getJSCommon().a(new d(this, (byte) 0));
            com.anythink.expressad.foundation.d.c cVar2 = this.C;
            if (cVar2 != null && (cVar2.H() || this.C.ay())) {
                MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new MraidVolumeChangeReceiver(getContext());
                this.ax = mraidVolumeChangeReceiver;
                mraidVolumeChangeReceiver.registerReceiver();
                this.ax.getCurrentVolume();
                this.ax.setVolumeChangeListener(new AnonymousClass6());
            }
            getJSContainerModule().readyStatus(((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r());
            j();
            ((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r.b();
            if (this.y) {
                getJSCommon().f(this.aj);
                getJSCommon().e(this.ak);
            }
        }
        if (getJSCommon().f() == 1 && (viewGroup = (ViewGroup) this.B.findViewById(i.a(getContext(), "anythink_video_templete_webview_parent", "id"))) != null) {
            ((ViewGroup) this.B).removeView(viewGroup);
            ((ViewGroup) this.B).addView(viewGroup, 1);
        }
        viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
    }

    static /* synthetic */ boolean q(ATTempContainer aTTempContainer) {
        aTTempContainer.av = true;
        return true;
    }

    private void r() {
        getJSCommon().a(this.s);
        getJSCommon().a(this.m);
        getJSCommon().a(this.o);
        getJSCommon().a(new d(this, (byte) 0));
        com.anythink.expressad.foundation.d.c cVar = this.C;
        if (cVar != null) {
            if (cVar.H() || this.C.ay()) {
                MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new MraidVolumeChangeReceiver(getContext());
                this.ax = mraidVolumeChangeReceiver;
                mraidVolumeChangeReceiver.registerReceiver();
                this.ax.getCurrentVolume();
                this.ax.setVolumeChangeListener(new AnonymousClass6());
            }
        }
    }

    private void s() {
        if (this.ao) {
            o.a(A, "sendToServerRewardInfo");
            com.anythink.expressad.video.module.b.a.a(this.C, this.q, this.m, this.p, this.T);
        }
    }

    static /* synthetic */ void s(ATTempContainer aTTempContainer) {
        if (aTTempContainer.isLoadSuccess()) {
            aTTempContainer.l.runOnUiThread(new AnonymousClass7());
        }
    }

    private void t() {
        boolean z = true;
        try {
            this.an = true;
            if (this.C != null && this.C.J() == 2) {
                this.ao = true;
            }
            if (this.E != null) {
                if (this.t && (this.v == com.anythink.expressad.foundation.g.a.cr || this.v == com.anythink.expressad.foundation.g.a.cs)) {
                    h hVar = this.E;
                    if (this.L != 1) {
                        z = false;
                    }
                    hVar.a(z, this.K);
                }
                if (!this.ao) {
                    this.q.a(0);
                }
                this.E.a(this.ao, this.q);
            }
            this.h.removeCallbacks(this.ay);
            if (((!this.t && !this.y) || (this.C != null && this.C.j())) && this.ao) {
                o.a(A, "sendToServerRewardInfo");
                com.anythink.expressad.video.module.b.a.a(this.C, this.q, this.m, this.p, this.T);
            }
            if (!this.y) {
                if (this.t) {
                    com.anythink.expressad.videocommon.a.b(287, this.C);
                } else {
                    com.anythink.expressad.videocommon.a.b(94, this.C);
                }
            }
            if (this.g != null) {
                this.g.release();
            }
        } catch (Throwable th) {
            o.b(A, th.getMessage(), th);
        }
    }

    static /* synthetic */ boolean t(ATTempContainer aTTempContainer) {
        aTTempContainer.as = true;
        return true;
    }

    private static int u() {
        int i = 5;
        try {
            com.anythink.expressad.videocommon.e.a b2 = com.anythink.expressad.videocommon.e.c.a().b();
            if (b2 == null) {
                com.anythink.expressad.videocommon.e.c.a();
                com.anythink.expressad.videocommon.e.c.c();
            }
            int i2 = 5;
            if (b2 != null) {
                i2 = (int) b2.g();
            }
            i = i2;
            o.b(A, "AnythinkBaseView buffetTimeout:".concat(String.valueOf(i2)));
            return i2;
        } catch (Throwable th) {
            th.printStackTrace();
            return i;
        }
    }

    static /* synthetic */ void u(ATTempContainer aTTempContainer) {
        if (aTTempContainer.isLoadSuccess()) {
            aTTempContainer.l.runOnUiThread(new AnonymousClass8());
        }
    }

    private void v() {
        if (isLoadSuccess()) {
            this.l.runOnUiThread(new AnonymousClass7());
        }
    }

    private void w() {
        if (isLoadSuccess()) {
            this.l.runOnUiThread(new AnonymousClass8());
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public final void a(String str) {
        h hVar = this.E;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    public boolean canBackPress() {
        AnythinkContainerView anythinkContainerView = this.g;
        return anythinkContainerView == null || anythinkContainerView.canBackPress();
    }

    public void defaultLoad(int i, String str) {
        superDefaultLoad(i, str);
        o.a(A, "hybrid load error ,start defaultLoad,desc:".concat(String.valueOf(str)));
        if (!isLoadSuccess()) {
            a(i, str);
            if (this.l != null) {
                this.l.finish();
            }
        } else if (this.C.J() == 2) {
            this.g.setCampaign(this.C);
            this.g.addOrderViewData(this.U);
            this.g.setUnitID(this.m);
            this.g.setCloseDelayTime(this.C.g() > -2 ? this.C.g() : this.o.p());
            this.g.setPlayCloseBtnTm(this.o.j());
            this.g.setNotifyListener(new com.anythink.expressad.video.module.a.a.h(this.C, this.D, this.q, b(), this.m, new c(this, (byte) 0), this.o.M(), this.y));
            this.g.preLoadData(this.J);
            this.g.showPlayableView();
        } else {
            a(i, str);
            this.am.setVisibility(8);
            loadModuleDatas();
            int f = this.o.f();
            int e2 = e();
            if (e2 != 0) {
                f = e2;
            }
            com.anythink.expressad.foundation.d.c cVar = this.C;
            if (cVar != null && cVar.j()) {
                this.f.setContainerViewOnNotifyListener(new b(this.l, this.C));
            }
            com.anythink.expressad.foundation.d.c cVar2 = this.C;
            int e3 = (cVar2 == null || cVar2.h() <= -2) ? this.o.e() : this.C.h();
            int i2 = e3;
            if (this.C.k() == 5) {
                int i3 = this.H;
                i2 = e3;
                if (i3 > 1) {
                    i2 = a(e3, i3);
                    this.C.a(i2);
                }
            }
            this.f.setVideoSkipTime(i2);
            AnythinkVideoView anythinkVideoView = this.f;
            anythinkVideoView.setNotifyListener(new m(anythinkVideoView, this.g, this.C, this.q, this.D, b(), this.m, f, i2, new e(this, (byte) 0), this.o.M(), this.y, this.o.U()));
            this.f.defaultShow();
            AnythinkContainerView anythinkContainerView = this.g;
            anythinkContainerView.setNotifyListener(new com.anythink.expressad.video.module.a.a.b(this.f, anythinkContainerView, this.C, this.q, this.D, b(), this.m, new b(this.l, this.C), this.o.M(), this.y));
            this.g.defaultShow();
        }
    }

    public AnythinkContainerView findAnythinkContainerView() {
        return (AnythinkContainerView) findViewById(findID("anythink_video_templete_container"));
    }

    public AnythinkVideoView findAnythinkVideoView() {
        return (AnythinkVideoView) findViewById(findID("anythink_video_templete_videoview"));
    }

    public int findID(String str) {
        return i.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return i.a(getContext(), str, "layout");
    }

    public WindVaneWebView findWindVaneWebView() {
        try {
            if (!this.y) {
                o.a(A, "当前非大模板");
                a.C0093a a2 = this.t ? com.anythink.expressad.videocommon.a.a(287, this.C) : com.anythink.expressad.videocommon.a.a(94, this.C);
                if (a2 == null || !a2.c()) {
                    return null;
                }
                if (this.t) {
                    com.anythink.expressad.videocommon.a.b(287, this.C);
                } else {
                    com.anythink.expressad.videocommon.a.b(94, this.C);
                }
                WindVaneWebView a3 = a2.a();
                if (this.f5458ar) {
                    a3.setWebViewTransparent();
                }
                return a3;
            }
            o.a(A, "当前大模板");
            if (this.C == null || this.C.M() == null) {
                return null;
            }
            o.a(A, "当前大模板，存在播放模板");
            a.C0093a a4 = com.anythink.expressad.videocommon.a.a(this.m + "_" + this.C.aZ() + "_" + this.C.Z() + "_" + this.C.M().e());
            if (a4 != null) {
                return a4.a();
            }
            return null;
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f4103a) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public com.anythink.expressad.foundation.d.c getCampaign() {
        return this.C;
    }

    public String getInstanceId() {
        return this.I;
    }

    public int getLayoutID() {
        return findLayout(this.f5458ar ? "anythink_reward_activity_video_templete_transparent" : "anythink_reward_activity_video_templete");
    }

    public void init(Context context) {
        this.W = LayoutInflater.from(context);
    }

    public boolean initViews() {
        View findViewById = findViewById(findID("anythink_video_templete_progressbar"));
        this.am = findViewById;
        return findViewById != null;
    }

    public boolean isLoadSuccess() {
        return this.f5459c;
    }

    public void loadModuleDatas() {
        com.anythink.expressad.video.signal.a.j b2 = b(this.C);
        int b3 = b2 != null ? b2.b() : 0;
        if (b3 != 0) {
            this.s = b3;
        }
        int f = this.o.f();
        int e2 = e();
        if (e2 != 0) {
            f = e2;
        }
        this.f.setSoundState(this.s);
        this.f.setCampaign(this.C);
        this.f.setPlayURL(this.D.r());
        com.anythink.expressad.foundation.d.c cVar = this.C;
        int e3 = (cVar == null || cVar.h() <= -2) ? this.o.e() : this.C.h();
        int i = e3;
        if (this.C.k() == 5) {
            int i2 = this.H;
            i = e3;
            if (i2 > 1) {
                i = a(e3, i2);
                this.C.a(i);
            }
        }
        this.f.setVideoSkipTime(i);
        this.f.setCloseAlert(this.o.k());
        this.f.setBufferTimeout(u());
        this.f.setNotifyListener(new com.anythink.expressad.video.module.a.a.n(this.J, this.C, this.q, this.D, b(), this.m, f, i, new e(this, (byte) 0), this.o.M(), this.y, this.o.U()));
        this.f.setShowingTransparent(this.f5458ar);
        if (this.t && (this.v == com.anythink.expressad.foundation.g.a.cr || this.v == com.anythink.expressad.foundation.g.a.cs)) {
            this.f.setIVRewardEnable(this.v, this.w, this.x);
            this.f.setDialogRole(getJSCommon() != null ? getJSCommon().n() : 1);
        }
        this.g.setCampaign(this.C);
        this.g.addOrderViewData(this.U);
        this.g.setUnitID(this.m);
        this.g.setCloseDelayTime(this.C.g() > -2 ? this.C.g() : this.o.p());
        this.g.setPlayCloseBtnTm(this.o.j());
        this.g.setVideoInteractiveType(this.o.h());
        this.g.setEndscreenType(this.o.r());
        this.g.setVideoSkipTime(i);
        this.g.setShowingTransparent(this.f5458ar);
        this.g.setJSFactory(this.J);
        if (this.C.J() == 2) {
            this.g.setNotifyListener(new com.anythink.expressad.video.module.a.a.h(this.C, this.D, this.q, b(), this.m, new c(this, (byte) 0), this.o.M(), this.y));
            this.g.preLoadData(this.J);
            this.g.showPlayableView();
        } else {
            this.g.setNotifyListener(new com.anythink.expressad.video.module.a.a.c(this.J, this.C, this.q, this.D, b(), this.m, new b(this.l, this.C), this.o.M(), this.y));
            this.g.preLoadData(this.J);
            this.f.preLoadData(this.J);
        }
        if (this.f5458ar) {
            this.g.setAnythinkClickMiniCardViewTransparent();
        }
    }

    public void notifyEvent(String str) {
        WindVaneWebView windVaneWebView = this.e;
        if (windVaneWebView != null) {
            String str2 = this.I;
            j.a();
            j.a((WebView) windVaneWebView, str, Base64.encodeToString(str2.getBytes(), 2));
        }
    }

    public void onBackPressed() {
        AnythinkContainerView anythinkContainerView;
        AnythinkContainerView anythinkContainerView2;
        AnythinkVideoView anythinkVideoView;
        AnythinkVideoView anythinkVideoView2;
        if (this.f5458ar && (anythinkVideoView2 = this.f) != null) {
            anythinkVideoView2.notifyVideoClose();
        } else if (this.at && (anythinkVideoView = this.f) != null) {
            if (!anythinkVideoView.isMiniCardShowing()) {
                this.f.onBackPress();
                return;
            }
            AnythinkContainerView anythinkContainerView3 = this.g;
            if (anythinkContainerView3 != null) {
                anythinkContainerView3.onMiniEndcardBackPress();
            }
        } else if (this.av && (anythinkContainerView2 = this.g) != null) {
            anythinkContainerView2.onPlayableBackPress();
        } else {
            if (this.au && (anythinkContainerView = this.g) != null) {
                anythinkContainerView.onEndcardBackPress();
            }
            if (getJSCommon().g()) {
                if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                    getActivityProxy().g();
                }
            } else if (!canBackPress()) {
                o.a(A, "onBackPressed can't excute");
            } else if (this.l == null || this.y || this.aw) {
            } else {
                this.aw = true;
                this.l.onBackPressed();
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        ViewGroup viewGroup;
        String str = A;
        o.a(str, "onCreate isBigOffer: " + this.y);
        if (this.o == null) {
            this.o = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.m, this.t);
        }
        this.aw = false;
        try {
            if (!this.y) {
                this.E = new com.anythink.expressad.video.bt.module.b.e(getContext(), this.t, this.o, this.C, this.E, b(), this.m);
            } else if (this.C == null || !this.C.j()) {
                this.E = new com.anythink.expressad.video.bt.module.b.d(this.F, this.I);
            } else {
                this.E = new com.anythink.expressad.video.bt.module.b.e(getContext(), this.t, this.o, this.C, this.E, b(), this.m);
            }
            registerErrorListener(new com.anythink.expressad.video.bt.module.b.f(this.E));
            a(this.o, this.C);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (layoutID <= 0) {
                a("layoutID not found");
                return;
            }
            View inflate = this.W.inflate(layoutID, (ViewGroup) null);
            this.B = inflate;
            addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
            if (this.f5457a) {
                setMatchParent();
            }
            this.e = findWindVaneWebView();
            AnythinkVideoView findAnythinkVideoView = findAnythinkVideoView();
            this.f = findAnythinkVideoView;
            findAnythinkVideoView.setVideoLayout(this.C);
            this.f.setIsIV(this.t);
            this.f.setUnitId(this.m);
            this.f.setCamPlayOrderCallback(this.G, this.U, this.H, this.V);
            if (this.y) {
                this.f.setNotchPadding(this.O, this.P, this.Q, this.R);
            }
            this.g = findAnythinkContainerView();
            if (this.y) {
                this.g.setNotchPadding(this.N, this.O, this.P, this.Q, this.R);
            }
            if (!((this.f == null || this.g == null || !initViews()) ? false : true)) {
                this.d.a(com.anythink.expressad.foundation.e.a.b);
                if (this.l != null) {
                    this.l.finish();
                    return;
                }
                return;
            }
            this.f5459c = true;
            WindVaneWebView windVaneWebView = this.e;
            this.J = new com.anythink.expressad.video.signal.factory.b(this.l, windVaneWebView, this.f, this.g, this.C, new d(this, (byte) 0));
            if (this.C != null && this.C.k() == 5 && this.U != null) {
                this.J.a(this.U);
            }
            registerJsFactory(this.J);
            com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
            a2.a(this.m + "_1", new AnonymousClass5());
            if (windVaneWebView == null) {
                o.a(A, "template webview is null");
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup) this.B.findViewById(i.a(getContext(), "anythink_video_templete_webview_parent", "id"));
            windVaneWebView.setApiManagerJSFactory(this.J);
            if (windVaneWebView.getParent() != null) {
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            if (windVaneWebView.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                this.J.a((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject());
                getJSCommon().a(this.s);
                getJSCommon().a(this.m);
                getJSCommon().a(this.o);
                getJSCommon().a(new d(this, (byte) 0));
                if (this.C != null && (this.C.H() || this.C.ay())) {
                    MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new MraidVolumeChangeReceiver(getContext());
                    this.ax = mraidVolumeChangeReceiver;
                    mraidVolumeChangeReceiver.registerReceiver();
                    this.ax.getCurrentVolume();
                    this.ax.setVolumeChangeListener(new AnonymousClass6());
                }
                getJSContainerModule().readyStatus(((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r());
                j();
                ((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r.b();
                if (this.y) {
                    getJSCommon().f(this.aj);
                    getJSCommon().e(this.ak);
                }
            }
            if (getJSCommon().f() == 1 && (viewGroup = (ViewGroup) this.B.findViewById(i.a(getContext(), "anythink_video_templete_webview_parent", "id"))) != null) {
                ((ViewGroup) this.B).removeView(viewGroup);
                ((ViewGroup) this.B).addView(viewGroup, 1);
            }
            viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th) {
            a("onCreate error".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.M) {
            return;
        }
        boolean z = true;
        this.M = true;
        super.onDestroy();
        try {
            if (this.f != null) {
                this.f.releasePlayer();
            }
            if (this.e != null) {
                ViewGroup viewGroup = (ViewGroup) this.e.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.e.clearWebView();
                this.e.release();
            }
            if (this.F != null) {
                this.F = null;
            }
            this.h.removeCallbacks(this.i);
            this.h.removeCallbacks(this.j);
            getJSCommon().k();
            if (this.t) {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.d.b.c(this.m);
            }
            if (!this.an) {
                this.an = true;
                if (this.C != null && this.C.J() == 2) {
                    this.ao = true;
                }
                if (this.E != null) {
                    if (this.t && (this.v == com.anythink.expressad.foundation.g.a.cr || this.v == com.anythink.expressad.foundation.g.a.cs)) {
                        h hVar = this.E;
                        if (this.L != 1) {
                            z = false;
                        }
                        hVar.a(z, this.K);
                    }
                    if (!this.ao) {
                        this.q.a(0);
                    }
                    this.E.a(this.ao, this.q);
                }
                this.h.removeCallbacks(this.ay);
                if (((!this.t && !this.y) || (this.C != null && this.C.j())) && this.ao) {
                    o.a(A, "sendToServerRewardInfo");
                    com.anythink.expressad.video.module.b.a.a(this.C, this.q, this.m, this.p, this.T);
                }
                if (!this.y) {
                    if (this.t) {
                        com.anythink.expressad.videocommon.a.b(287, this.C);
                    } else {
                        com.anythink.expressad.videocommon.a.b(94, this.C);
                    }
                }
                if (this.g != null) {
                    this.g.release();
                }
            }
            if (this.ax != null) {
                this.ax.unregisterReceiver();
            }
            if (!this.y) {
                if (isLoadSuccess()) {
                    this.h.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.bt.module.ATTempContainer.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (ATTempContainer.this.l != null) {
                                ATTempContainer.this.l.finish();
                            }
                        }
                    }, 100L);
                } else if (this.l != null) {
                    this.l.finish();
                }
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.f(this.I);
        } catch (Throwable th) {
            o.a(A, th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onPause() {
        super.onPause();
        this.ap = true;
        try {
            getJSVideoModule().videoOperate(2);
            if (this.g != null) {
                this.g.setOnPause();
            }
        } catch (Throwable th) {
            o.b(A, th.getMessage(), th);
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onResume() {
        super.onResume();
        int i = this.ai;
        Runnable runnable = i == -3 ? this.i : i == -4 ? this.j : null;
        if (runnable != null) {
            runnable.run();
            this.ai = 0;
        }
        try {
            if (this.f != null && !i() && !this.f.isMiniCardShowing() && !com.anythink.expressad.foundation.f.b.f4978c) {
                this.f.setCover(false);
            }
            if (this.g != null) {
                this.g.setOnResume();
            }
            if (this.ap && !i() && !com.anythink.expressad.foundation.f.b.f4978c) {
                getJSVideoModule().videoOperate(1);
            }
            if (this.l != null) {
                t.a(this.l.getWindow().getDecorView());
            }
            if (this.f5458ar && this.as && this.l != null) {
                this.l.finish();
            }
        } catch (Throwable th) {
            o.b(A, th.getMessage(), th);
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onStop() {
        super.onStop();
        AnythinkVideoView anythinkVideoView = this.f;
        if (anythinkVideoView != null) {
            anythinkVideoView.setCover(true);
        }
    }

    public void preload() {
    }

    public void receiveSuccess() {
        o.a(A, "receiveSuccess ,start hybrid");
        this.h.removeCallbacks(this.j);
        this.h.postDelayed(this.ay, 250L);
    }

    public void registerErrorListener(a aVar) {
        this.d = aVar;
    }

    public void setAnythinkTempCallback(com.anythink.expressad.video.bt.module.a.b bVar) {
        this.F = bVar;
    }

    public void setCamPlayOrderCallback(com.anythink.expressad.video.dynview.f.a aVar, int i) {
        this.G = aVar;
        this.H = i;
    }

    public void setCampOrderViewData(List<com.anythink.expressad.foundation.d.c> list, int i) {
        if (list != null) {
            this.U = list;
        }
        this.V = i;
    }

    public void setCampaign(com.anythink.expressad.foundation.d.c cVar) {
        this.C = cVar;
        if (cVar != null) {
            if (TextUtils.isEmpty(cVar.K()) && !TextUtils.isEmpty(this.m)) {
                cVar.l(this.m);
            }
            com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
            a2.a(cVar.K() + "_1", cVar);
        }
    }

    public void setCampaignDownLoadTask(com.anythink.expressad.videocommon.b.c cVar) {
        this.D = cVar;
    }

    public void setCampaignExpired(boolean z) {
        try {
            if (this.C != null) {
                if (!z) {
                    this.C.e(0);
                    if (this.C.A()) {
                        this.C.m(0);
                        return;
                    } else if (this.o != null) {
                        this.C.m(this.o.a());
                        return;
                    } else {
                        return;
                    }
                }
                this.C.e(1);
                if (this.u) {
                    this.C.m(0);
                } else if (this.o != null) {
                    if (this.o.M() == 1) {
                        this.C.m(1);
                    } else {
                        this.C.m(0);
                    }
                }
            }
        } catch (Exception e2) {
            o.d(A, e2.getMessage());
        }
    }

    public void setDeveloperExtraData(String str) {
        this.T = str;
    }

    public void setH5Cbp(int i) {
        this.ak = i;
    }

    public void setInstanceId(String str) {
        this.I = str;
    }

    public void setJSFactory(com.anythink.expressad.video.signal.factory.b bVar) {
        this.J = bVar;
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    public void setMediaPlayerUrl(String str) {
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        this.N = i;
        this.O = i2;
        this.P = i3;
        this.Q = i4;
        this.R = i5;
        String a2 = com.anythink.expressad.foundation.h.h.a(i, i2, i3, i4, i5);
        this.S = a2;
        o.d(A, a2);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.S)) {
            getJSCommon().b(this.S);
            if (this.e != null && !TextUtils.isEmpty(this.S)) {
                j.a();
                j.a((WebView) this.e, "oncutoutfetched", Base64.encodeToString(this.S.getBytes(), 0));
            }
        }
        AnythinkVideoView anythinkVideoView = this.f;
        if (anythinkVideoView != null) {
            anythinkVideoView.setNotchPadding(i2, i3, i4, i5);
        }
        AnythinkContainerView anythinkContainerView = this.g;
        if (anythinkContainerView != null) {
            anythinkContainerView.setNotchPadding(i, i2, i3, i4, i5);
        }
    }

    public void setShowRewardListener(h hVar) {
        this.E = hVar;
    }

    public void setShowingTransparent() {
        int a2;
        boolean h = h();
        this.f5458ar = h;
        if (h || (a2 = i.a(getContext(), "anythink_reward_theme", "style")) <= 1 || this.l == null) {
            return;
        }
        this.l.setTheme(a2);
    }

    public void setWebViewFront(int i) {
        this.aj = i;
    }

    public void superDefaultLoad(int i, String str) {
        String str2 = A;
        o.d(str2, "receiveError:" + i + ",descroption:" + str);
        this.h.removeCallbacks(this.i);
        this.h.removeCallbacks(this.j);
        this.d.b();
        WindVaneWebView windVaneWebView = this.e;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }
}
