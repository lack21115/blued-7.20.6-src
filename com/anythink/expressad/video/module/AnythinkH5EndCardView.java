package com.anythink.expressad.video.module;

import android.app.Activity;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.media.tv.TvContract;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.foundation.webview.BrowserView;
import com.anythink.expressad.video.signal.h;
import com.anythink.expressad.videocommon.b.i;
import com.anythink.expressad.widget.FeedBackButton;
import com.baidu.mobads.sdk.internal.bw;
import com.bytedance.applog.tracker.Tracker;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkH5EndCardView.class */
public class AnythinkH5EndCardView extends AnythinkBaseView implements IMraidJSBridge, com.anythink.expressad.video.signal.f, h {
    private static final String A = "anythink_reward_endcard_h5";
    private static final String B = "portrait";
    private static final String C = "landscape";
    private static final int D = 1;
    private static final int E = 2;
    private static final int F = 20;
    private static final int G = 15;
    private static final int Q = 100;
    protected static final String n = "orientation";
    protected static final String o = "webviewshow";
    private FeedBackButton H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private boolean M;
    private boolean N;
    private int O;
    private long P;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean aa;
    private boolean ab;
    private String ac;
    private com.anythink.expressad.video.signal.factory.b ad;
    private boolean ae;
    private boolean af;
    protected View p;
    protected RelativeLayout q;
    protected ImageView r;
    protected WindVaneWebView s;
    protected Handler t;
    protected String u;
    protected boolean v;
    protected boolean w;
    protected String x;
    Handler y;
    boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkH5EndCardView$5.class */
    public final class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView.this.H.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$6  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkH5EndCardView$6.class */
    public final class AnonymousClass6 implements com.anythink.expressad.foundation.f.a {
        AnonymousClass6() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
                str = "";
            }
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            j.a();
            j.a((WebView) AnythinkH5EndCardView.this.s, AbsFeedBackForH5.f7096a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
                str = "";
            }
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            j.a();
            j.a((WebView) AnythinkH5EndCardView.this.s, AbsFeedBackForH5.f7096a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
                str = "";
            }
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            j.a();
            j.a((WebView) AnythinkH5EndCardView.this.s, AbsFeedBackForH5.f7096a, encodeToString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkH5EndCardView$a.class */
    public final class a implements Runnable {
        private AnythinkH5EndCardView b;

        public a(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView == null || anythinkH5EndCardView.y == null) {
                return;
            }
            this.b.y.sendEmptyMessage(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkH5EndCardView$b.class */
    public final class b implements Runnable {
        private AnythinkH5EndCardView b;

        public b(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView == null || anythinkH5EndCardView.N) {
                return;
            }
            AnythinkH5EndCardView.d(this.b);
            this.b.v = false;
            AnythinkH5EndCardView.this.reportRenderResult("timeout", 5);
            this.b.e.a(127, "");
            o.a(AnythinkBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkH5EndCardView$c.class */
    public static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private AnythinkH5EndCardView f8460a;
        private int b;

        public c(AnythinkH5EndCardView anythinkH5EndCardView, int i) {
            this.f8460a = anythinkH5EndCardView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.f8460a;
            if (anythinkH5EndCardView == null || anythinkH5EndCardView.b == null) {
                return;
            }
            try {
                if (this.f8460a.M) {
                    o.b(AnythinkBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                    return;
                }
                AnythinkH5EndCardView.n(this.f8460a);
                if (w.b(this.f8460a.b.I())) {
                    this.f8460a.b.I().contains(".zip");
                }
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkH5EndCardView$d.class */
    public final class d implements Runnable {
        private AnythinkH5EndCardView b;

        public d(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView != null) {
                AnythinkH5EndCardView.e(anythinkH5EndCardView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkH5EndCardView$e.class */
    public final class e implements Runnable {
        private AnythinkH5EndCardView b;

        public e(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView != null) {
                AnythinkH5EndCardView.f(anythinkH5EndCardView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkH5EndCardView$f.class */
    public final class f implements Runnable {
        private AnythinkH5EndCardView b;

        public f(AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView != null) {
                if (!anythinkH5EndCardView.aa) {
                    AnythinkH5EndCardView.this.setCloseVisible(0);
                }
                AnythinkH5EndCardView.l(this.b);
            }
        }
    }

    public AnythinkH5EndCardView(Context context) {
        super(context);
        this.I = false;
        this.t = new Handler();
        this.v = false;
        this.w = false;
        this.J = false;
        this.K = 1;
        this.L = 1;
        this.M = false;
        this.N = false;
        this.O = 1;
        this.P = 0L;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = false;
        this.ab = false;
        this.ac = "";
        this.y = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.video.module.AnythinkH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (AnythinkH5EndCardView.this.R) {
                    AnythinkH5EndCardView.this.e.a(122, "");
                }
                AnythinkH5EndCardView.this.e.a(103, "");
            }
        };
        this.ae = false;
        this.af = false;
        this.z = false;
    }

    public AnythinkH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = false;
        this.t = new Handler();
        this.v = false;
        this.w = false;
        this.J = false;
        this.K = 1;
        this.L = 1;
        this.M = false;
        this.N = false;
        this.O = 1;
        this.P = 0L;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = false;
        this.ab = false;
        this.ac = "";
        this.y = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.video.module.AnythinkH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (AnythinkH5EndCardView.this.R) {
                    AnythinkH5EndCardView.this.e.a(122, "");
                }
                AnythinkH5EndCardView.this.e.a(103, "");
            }
        };
        this.ae = false;
        this.af = false;
        this.z = false;
    }

    private void a(long j, boolean z) {
        try {
            if (this.M) {
                o.b(AnythinkBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                return;
            }
            this.M = true;
            String str = "2";
            if (w.b(this.b.I())) {
                str = "2";
                if (this.b.I().contains(".zip")) {
                    str = "1";
                }
            }
            int i = 10;
            String str2 = "ready yes";
            if (z) {
                i = 12;
                str2 = "ready timeout";
            } else if (this.O == 2) {
                i = 11;
                str2 = "ready no";
            }
            o.b(AnythinkBaseView.TAG, "insertEndCardReadyState result:" + i + " endCardLoadTime:" + j + " endcardurl:" + this.b.I() + "  id:" + this.b.aZ() + "  unitid:" + this.x + "  reason:" + str2 + "  type:" + str);
        } catch (Throwable th) {
            o.b(AnythinkBaseView.TAG, th.getMessage(), th);
        }
    }

    static /* synthetic */ void a(AnythinkH5EndCardView anythinkH5EndCardView, long j) {
        try {
            if (anythinkH5EndCardView.M) {
                o.b(AnythinkBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                return;
            }
            anythinkH5EndCardView.M = true;
            String str = "2";
            if (w.b(anythinkH5EndCardView.b.I())) {
                str = "2";
                if (anythinkH5EndCardView.b.I().contains(".zip")) {
                    str = "1";
                }
            }
            int i = 10;
            String str2 = "ready yes";
            if (anythinkH5EndCardView.O == 2) {
                i = 11;
                str2 = "ready no";
            }
            o.b(AnythinkBaseView.TAG, "insertEndCardReadyState result:" + i + " endCardLoadTime:" + j + " endcardurl:" + anythinkH5EndCardView.b.I() + "  id:" + anythinkH5EndCardView.b.aZ() + "  unitid:" + anythinkH5EndCardView.x + "  reason:" + str2 + "  type:" + str);
        } catch (Throwable th) {
            o.b(AnythinkBaseView.TAG, th.getMessage(), th);
        }
    }

    private void a(String str) {
        try {
            String ad = this.b.ad();
            if (!TextUtils.isEmpty(str)) {
                this.b.p(str);
            }
            new com.anythink.expressad.a.a(getContext(), this.x);
            this.b.p(ad);
            this.e.a(126, "");
        } catch (Exception e2) {
            o.d(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    private boolean a(View view) {
        this.r = (ImageView) view.findViewById(findID("anythink_windwv_close"));
        this.q = (RelativeLayout) view.findViewById(findID("anythink_windwv_content_rl"));
        this.s = new WindVaneWebView(getContext());
        this.s.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.q.addView(this.s);
        return isNotNULL(this.r, this.s);
    }

    static /* synthetic */ boolean d(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.N = true;
        return true;
    }

    static /* synthetic */ boolean e(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.V = true;
        return true;
    }

    private void f() {
        int o2;
        try {
            this.P = System.currentTimeMillis();
            String I = this.b.I();
            com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.x);
            if (this.J && w.b(I)) {
                if (I.contains("wfr=1") || (a2 != null && a2.o() > 0)) {
                    o.d(AnythinkBaseView.TAG, "需要上报endcard加载时间");
                    if (I.contains("wfr=1")) {
                        String[] split = I.split("&");
                        if (split != null && split.length > 0) {
                            int length = split.length;
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= length) {
                                    break;
                                }
                                String str = split[i2];
                                if (w.b(str) && str.contains("to") && str.split("=") != null && str.split("=").length > 0) {
                                    o2 = t.a((Object) str.split("=")[1]);
                                    o.b(AnythinkBaseView.TAG, "从url获取的waitingtime:".concat(String.valueOf(o2)));
                                    break;
                                }
                                i = i2 + 1;
                            }
                        }
                        o2 = 20;
                    } else {
                        if (a2 != null && a2.o() > 0) {
                            o2 = a2.o();
                        }
                        o2 = 20;
                    }
                    if (o2 >= 0) {
                        excuteEndCardShowTask(o2);
                        o.b(AnythinkBaseView.TAG, "开启excuteEndCardShowTask:".concat(String.valueOf(o2)));
                        return;
                    }
                    excuteEndCardShowTask(20);
                    o.b(AnythinkBaseView.TAG, "开启excuteEndCardShowTask: 20s def");
                }
            }
        } catch (Throwable th) {
            o.b(AnythinkBaseView.TAG, th.getMessage(), th);
        }
    }

    static /* synthetic */ boolean f(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.W = true;
        return true;
    }

    private void g() {
        if (this.ae || this.T) {
            return;
        }
        this.ae = true;
        int i = this.K;
        if (i == 0) {
            this.V = true;
            return;
        }
        this.V = false;
        if (i >= 0) {
            this.t.postDelayed(new d(this), this.K * 1000);
        }
    }

    static /* synthetic */ void g(AnythinkH5EndCardView anythinkH5EndCardView) {
        WindVaneWebView windVaneWebView;
        WindVaneWebView windVaneWebView2;
        if (anythinkH5EndCardView.b == null || !anythinkH5EndCardView.b.H()) {
            return;
        }
        int i = anythinkH5EndCardView.getResources().getConfiguration().orientation;
        String str = i != 0 ? i != 1 ? i != 2 ? "undefined" : "landscape" : "portrait" : "undefined";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put(TvContract.Channels.COLUMN_LOCKED, "true");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CallMraidJS.f7085a, "Interstitial");
        hashMap.put("state", "default");
        hashMap.put(CallMraidJS.f7086c, "true");
        hashMap.put(CallMraidJS.d, jSONObject);
        if (anythinkH5EndCardView.getContext() instanceof Activity) {
            float e3 = k.e(anythinkH5EndCardView.getContext());
            float f2 = k.f(anythinkH5EndCardView.getContext());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) anythinkH5EndCardView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f3 = displayMetrics.widthPixels;
            float f4 = displayMetrics.heightPixels;
            CallMraidJS.getInstance().fireSetScreenSize(anythinkH5EndCardView.s, e3, f2);
            CallMraidJS.getInstance().fireSetMaxSize(anythinkH5EndCardView.s, f3, f4);
        }
        CallMraidJS.getInstance().fireSetDefaultPosition(anythinkH5EndCardView.s, windVaneWebView.getLeft(), anythinkH5EndCardView.s.getTop(), anythinkH5EndCardView.s.getWidth(), anythinkH5EndCardView.s.getHeight());
        CallMraidJS.getInstance().fireSetCurrentPosition(anythinkH5EndCardView.s, windVaneWebView2.getLeft(), anythinkH5EndCardView.s.getTop(), anythinkH5EndCardView.s.getWidth(), anythinkH5EndCardView.s.getHeight());
        CallMraidJS.getInstance().fireChangeEventForPropertys(anythinkH5EndCardView.s, hashMap);
        CallMraidJS.getInstance().fireAudioVolumeChange(anythinkH5EndCardView.s, MraidVolumeChangeReceiver.f7090a);
        CallMraidJS.getInstance().fireReadyEvent(anythinkH5EndCardView.s);
    }

    private void h() {
        if (this.af || this.T) {
            return;
        }
        this.af = true;
        int i = this.L;
        if (i == 0) {
            this.W = true;
            return;
        }
        this.W = false;
        if (i >= 0) {
            this.t.postDelayed(new e(this), this.L * 1000);
        }
    }

    private void i() {
        try {
            if (com.anythink.expressad.foundation.f.b.a().b()) {
                com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
                a2.c(this.x + "_1");
                com.anythink.expressad.foundation.f.b a3 = com.anythink.expressad.foundation.f.b.a();
                FeedBackButton b2 = a3.b(this.x + "_2");
                this.H = b2;
                if (b2 != null) {
                    ViewGroup viewGroup = (ViewGroup) b2.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.H);
                    }
                    this.q.addView(this.H);
                    this.q.postDelayed(new AnonymousClass5(), 200L);
                }
                this.b.l(this.x);
                com.anythink.expressad.foundation.f.b a4 = com.anythink.expressad.foundation.f.b.a();
                a4.a(this.x + "_2", this.b);
                com.anythink.expressad.foundation.f.b a5 = com.anythink.expressad.foundation.f.b.a();
                a5.a(this.x + "_2", new AnonymousClass6());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void i(AnythinkH5EndCardView anythinkH5EndCardView) {
        try {
            if (com.anythink.expressad.foundation.f.b.a().b()) {
                com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
                a2.c(anythinkH5EndCardView.x + "_1");
                com.anythink.expressad.foundation.f.b a3 = com.anythink.expressad.foundation.f.b.a();
                FeedBackButton b2 = a3.b(anythinkH5EndCardView.x + "_2");
                anythinkH5EndCardView.H = b2;
                if (b2 != null) {
                    ViewGroup viewGroup = (ViewGroup) b2.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(anythinkH5EndCardView.H);
                    }
                    anythinkH5EndCardView.q.addView(anythinkH5EndCardView.H);
                    anythinkH5EndCardView.q.postDelayed(new AnonymousClass5(), 200L);
                }
                anythinkH5EndCardView.b.l(anythinkH5EndCardView.x);
                com.anythink.expressad.foundation.f.b a4 = com.anythink.expressad.foundation.f.b.a();
                a4.a(anythinkH5EndCardView.x + "_2", anythinkH5EndCardView.b);
                com.anythink.expressad.foundation.f.b a5 = com.anythink.expressad.foundation.f.b.a();
                a5.a(anythinkH5EndCardView.x + "_2", new AnonymousClass6());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void j() {
        WindVaneWebView windVaneWebView;
        WindVaneWebView windVaneWebView2;
        if (this.b == null || !this.b.H()) {
            return;
        }
        int i = getResources().getConfiguration().orientation;
        String str = i != 0 ? i != 1 ? i != 2 ? "undefined" : "landscape" : "portrait" : "undefined";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put(TvContract.Channels.COLUMN_LOCKED, "true");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CallMraidJS.f7085a, "Interstitial");
        hashMap.put("state", "default");
        hashMap.put(CallMraidJS.f7086c, "true");
        hashMap.put(CallMraidJS.d, jSONObject);
        if (getContext() instanceof Activity) {
            float e3 = k.e(getContext());
            float f2 = k.f(getContext());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f3 = displayMetrics.widthPixels;
            float f4 = displayMetrics.heightPixels;
            CallMraidJS.getInstance().fireSetScreenSize(this.s, e3, f2);
            CallMraidJS.getInstance().fireSetMaxSize(this.s, f3, f4);
        }
        CallMraidJS.getInstance().fireSetDefaultPosition(this.s, windVaneWebView.getLeft(), this.s.getTop(), this.s.getWidth(), this.s.getHeight());
        CallMraidJS.getInstance().fireSetCurrentPosition(this.s, windVaneWebView2.getLeft(), this.s.getTop(), this.s.getWidth(), this.s.getHeight());
        CallMraidJS.getInstance().fireChangeEventForPropertys(this.s, hashMap);
        CallMraidJS.getInstance().fireAudioVolumeChange(this.s, MraidVolumeChangeReceiver.f7090a);
        CallMraidJS.getInstance().fireReadyEvent(this.s);
    }

    private static void k() {
    }

    static /* synthetic */ boolean l(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.S = true;
        return true;
    }

    static /* synthetic */ boolean n(AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.M = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        String P;
        if (this.b == null) {
            this.R = false;
            o.d(AnythinkBaseView.TAG, "getURL playable=false url为空");
            return null;
        }
        this.R = true;
        if (this.b.H()) {
            this.J = false;
            String G2 = this.b.G();
            if (TextUtils.isEmpty(G2)) {
                P = this.b.P();
                o.d(AnythinkBaseView.TAG, "getURL playable=false endscreenurl兜底:".concat(String.valueOf(P)));
            } else {
                File file = new File(G2);
                try {
                    if (file.exists() && file.isFile() && file.canRead()) {
                        o.b(AnythinkBaseView.TAG, "Mraid file ".concat(String.valueOf(G2)));
                        return "file:////".concat(String.valueOf(G2));
                    }
                    o.b(AnythinkBaseView.TAG, "Mraid file not found. Will use endcard url.");
                    return this.b.P();
                } catch (Throwable th) {
                    P = G2;
                    if (com.anythink.expressad.a.f6941a) {
                        th.printStackTrace();
                        return G2;
                    }
                }
            }
            return P;
        }
        String I = this.b.I();
        if (w.a(I)) {
            this.J = false;
            String P2 = this.b.P();
            o.d(AnythinkBaseView.TAG, "getURL playable=false endscreenurl兜底:".concat(String.valueOf(P2)));
            return P2;
        }
        this.J = true;
        String c2 = i.a().c(I);
        if (!TextUtils.isEmpty(c2)) {
            o.b(AnythinkBaseView.TAG, "getURL playable=true 资源不为空endcard地址:".concat(String.valueOf(c2)));
            return c2 + "&native_adtype=" + this.b.w();
        }
        try {
            String path = Uri.parse(I).getPath();
            if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                String P3 = this.b.P();
                if (TextUtils.isEmpty(P3)) {
                    return null;
                }
                this.J = false;
                excuteTask();
                return P3;
            }
        } catch (Throwable th2) {
            o.d(AnythinkBaseView.TAG, th2.getMessage());
        }
        o.b(AnythinkBaseView.TAG, "getURL playable=true endcard本地资源地址为空拿服务端地址:".concat(String.valueOf(I)));
        return I + "&native_adtype=" + this.b.w();
    }

    protected RelativeLayout.LayoutParams b() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public final void c() {
        super.c();
        if (this.f) {
            this.r.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkH5EndCardView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    AnythinkH5EndCardView.this.onCloseViewClick();
                }
            });
        }
    }

    public boolean canBackPress() {
        ImageView imageView = this.r;
        return imageView != null && imageView.getVisibility() == 0;
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        o.d("EndCard_MRAID", "close");
        try {
            onCloseViewClick();
        } catch (Exception e2) {
            o.d(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        if (this.f) {
            setMatchParent();
        }
    }

    public void excuteEndCardShowTask(int i) {
        this.t.postDelayed(new c(this, i), i * 1000);
    }

    public void excuteTask() {
        if (this.J || this.K < 0) {
            return;
        }
        this.t.postDelayed(new f(this), this.K * 1000);
    }

    public void executeEndCardShow(int i) {
        this.t.postDelayed(new b(this), i * 1000);
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(String str, boolean z) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public com.anythink.expressad.foundation.d.c getMraidCampaign() {
        return this.b;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void handlerPlayableException(String str) {
        o.d("========", "===========handlerPlayableException");
        if (this.w) {
            return;
        }
        this.w = true;
        this.v = false;
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        int findLayout = findLayout(A);
        if (findLayout >= 0) {
            View inflate = this.f8441c.inflate(findLayout, (ViewGroup) null);
            this.p = inflate;
            try {
                this.r = (ImageView) inflate.findViewById(findID("anythink_windwv_close"));
                this.q = (RelativeLayout) inflate.findViewById(findID("anythink_windwv_content_rl"));
                this.s = new WindVaneWebView(getContext());
                this.s.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.q.addView(this.s);
                this.f = isNotNULL(this.r, this.s);
            } catch (Exception e2) {
                this.f = false;
            }
            addView(this.p, b());
            c();
            e();
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(com.anythink.expressad.foundation.d.c cVar) {
    }

    public boolean isLoadSuccess() {
        return this.v;
    }

    public boolean isPlayable() {
        return this.J;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i) {
        if (i == 0) {
            this.T = true;
        } else if (i != 1) {
        } else {
            this.U = true;
        }
    }

    public void onBackPress() {
        if (this.S || ((this.T && this.U) || (!(this.T || !this.V || this.z) || (!this.T && this.W && this.z)))) {
            onCloseViewClick();
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.s == null) {
                this.e.a(103, "");
                this.e.a(119, "webview is null when closing webview");
                return;
            }
            j.a();
            j.a((WebView) this.s, "onSystemDestory", "");
            new Thread(new a(this)).start();
        } catch (Exception e2) {
            this.e.a(103, "");
            com.anythink.expressad.video.module.a.a aVar = this.e;
            aVar.a(119, "close webview exception" + e2.getMessage());
            o.a(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 || this.ab) {
            return;
        }
        this.ab = true;
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.b == null || !this.b.H()) {
            return;
        }
        if (z) {
            CallMraidJS.getInstance().fireSetIsViewable(this.s, "true");
        } else {
            CallMraidJS.getInstance().fireSetIsViewable(this.s, "false");
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(String str) {
        o.d("EndCard_MRAID", "open : ".concat(String.valueOf(str)));
        try {
            String ad = this.b.ad();
            if (!TextUtils.isEmpty(str)) {
                this.b.p(str);
            }
            new com.anythink.expressad.a.a(getContext(), this.x);
            this.b.p(ad);
            this.e.a(126, "");
        } catch (Exception e2) {
            try {
                o.d(AnythinkBaseView.TAG, e2.getMessage());
            } catch (Exception e3) {
                o.d(AnythinkBaseView.TAG, e3.getMessage());
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(Configuration configuration) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            j.a();
            j.a((WebView) this.s, "orientation", encodeToString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        int o2;
        this.ad = bVar;
        String a2 = a();
        if (!this.f || this.b == null || TextUtils.isEmpty(a2)) {
            reportRenderResult("PL URL IS NULL", 3);
            this.e.a(127, "");
            this.e.a(129, "");
        } else {
            this.P = System.currentTimeMillis();
            BrowserView.DownloadListener downloadListener = new BrowserView.DownloadListener(this.b);
            downloadListener.setTitle(this.b.bb());
            this.s.setDownloadListener(downloadListener);
            this.s.setCampaignId(this.b.aZ());
            setCloseVisible(8);
            this.s.setApiManagerJSFactory(bVar);
            if (this.b.H()) {
                this.s.setMraidObject(this);
            }
            this.s.setWebViewListener(new com.anythink.expressad.atsignalcommon.a.b() { // from class: com.anythink.expressad.video.module.AnythinkH5EndCardView.3
                @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                public final void loadingResourceStatus(WebView webView, int i) {
                    super.loadingResourceStatus(webView, i);
                    AnythinkH5EndCardView.this.O = i;
                    if (AnythinkH5EndCardView.this.N) {
                        return;
                    }
                    AnythinkH5EndCardView.d(AnythinkH5EndCardView.this);
                    if (i == 1) {
                        AnythinkH5EndCardView.this.reportRenderResult(bw.o, 4);
                        return;
                    }
                    AnythinkH5EndCardView.this.e.a(127, "");
                    AnythinkH5EndCardView.this.reportRenderResult(com.alipay.sdk.util.e.f4661a, 6);
                }

                @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                public final void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    o.d("========", "===========finish+".concat(String.valueOf(str)));
                    if (AnythinkH5EndCardView.this.w) {
                        return;
                    }
                    o.d("========", "===========finish  loadSuccess：" + AnythinkH5EndCardView.this.v);
                    AnythinkH5EndCardView.this.v = true;
                    o.a(AnythinkBaseView.TAG, "onPageFinished,url:".concat(String.valueOf(str)));
                    AnythinkH5EndCardView.this.e.a(100, "");
                    AnythinkH5EndCardView.this.e.a(120, "");
                }

                @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                public final void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    o.d("========", "===========onReceivedError");
                    if (AnythinkH5EndCardView.this.w) {
                        return;
                    }
                    o.a(AnythinkBaseView.TAG, "onReceivedError,url:".concat(String.valueOf(str2)));
                    com.anythink.expressad.video.module.a.a aVar = AnythinkH5EndCardView.this.e;
                    aVar.a(118, "onReceivedError " + i + str);
                    AnythinkH5EndCardView.this.reportRenderResult(str, 3);
                    AnythinkH5EndCardView.this.e.a(127, "");
                    AnythinkH5EndCardView.this.e.a(129, "");
                    AnythinkH5EndCardView.this.w = true;
                }

                @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                public final void readyState(WebView webView, int i) {
                    super.readyState(webView, i);
                    o.b("WindVaneWebView", "h5EncardView readyStatus:" + i + "- isError" + AnythinkH5EndCardView.this.w);
                    AnythinkH5EndCardView.this.O = i;
                    if (AnythinkH5EndCardView.this.w) {
                        return;
                    }
                    AnythinkH5EndCardView.a(AnythinkH5EndCardView.this, System.currentTimeMillis() - AnythinkH5EndCardView.this.P);
                }
            });
            if (TextUtils.isEmpty(this.b.G())) {
                try {
                    this.P = System.currentTimeMillis();
                    String I = this.b.I();
                    com.anythink.expressad.videocommon.e.d a3 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.x);
                    if (this.J && w.b(I) && (I.contains("wfr=1") || (a3 != null && a3.o() > 0))) {
                        o.d(AnythinkBaseView.TAG, "需要上报endcard加载时间");
                        if (I.contains("wfr=1")) {
                            String[] split = I.split("&");
                            if (split != null && split.length > 0) {
                                int length = split.length;
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= length) {
                                        break;
                                    }
                                    String str = split[i2];
                                    if (w.b(str) && str.contains("to") && str.split("=") != null && str.split("=").length > 0) {
                                        o2 = t.a((Object) str.split("=")[1]);
                                        o.b(AnythinkBaseView.TAG, "从url获取的waitingtime:".concat(String.valueOf(o2)));
                                        break;
                                    }
                                    i = i2 + 1;
                                }
                            }
                            o2 = 20;
                        } else {
                            if (a3 != null && a3.o() > 0) {
                                o2 = a3.o();
                            }
                            o2 = 20;
                        }
                        if (o2 >= 0) {
                            excuteEndCardShowTask(o2);
                            o.b(AnythinkBaseView.TAG, "开启excuteEndCardShowTask:".concat(String.valueOf(o2)));
                        } else {
                            excuteEndCardShowTask(20);
                            o.b(AnythinkBaseView.TAG, "开启excuteEndCardShowTask: 20s def");
                        }
                    }
                } catch (Throwable th) {
                    o.b(AnythinkBaseView.TAG, th.getMessage(), th);
                }
            }
            setHtmlSource(com.anythink.expressad.videocommon.b.j.a().b(a2));
            if (TextUtils.isEmpty(this.u)) {
                o.a(AnythinkBaseView.TAG, "load url:".concat(String.valueOf(a2)));
                this.s.loadUrl(a2);
            } else {
                o.a(AnythinkBaseView.TAG, "load html...");
                this.s.loadDataWithBaseURL(a2, this.u, ClipDescription.MIMETYPE_TEXT_HTML, "UTF-8", null);
            }
        }
        this.z = false;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void readyStatus(int i) {
    }

    public void release() {
        Handler handler = this.t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.t = null;
        }
        Handler handler2 = this.y;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.y = null;
        }
        this.q.removeAllViews();
        this.s.release();
        this.s = null;
    }

    public void reportRenderResult(String str, int i) {
    }

    public void setCloseDelayShowTime(int i) {
        this.K = i;
    }

    public void setCloseVisible(int i) {
        if (this.f) {
            this.r.setVisibility(i);
        }
    }

    public void setCloseVisibleForMraid(int i) {
        if (this.f) {
            this.aa = true;
            if (i == 4) {
                this.r.setImageDrawable(new ColorDrawable((int) Spanned.SPAN_PRIORITY));
            } else {
                this.r.setImageResource(findDrawable("anythink_reward_close"));
            }
            this.r.setVisibility(0);
        }
    }

    public void setError(boolean z) {
        this.w = z;
    }

    public void setHtmlSource(String str) {
        this.u = str;
    }

    public void setLoadPlayable(boolean z) {
        this.z = z;
    }

    public void setNotchValue(String str, int i, int i2, int i3, int i4) {
        if (this.b == null || this.b.f() == 2) {
            return;
        }
        this.ac = str;
        o.d(AnythinkBaseView.TAG, "NOTCH H5ENDCARD " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        int b2 = t.b(getContext(), 20.0f);
        int i5 = i3 + b2;
        layoutParams.setMargins(i + b2, i5, i2 + b2, i4 + b2);
        o.d(AnythinkBaseView.TAG, "NOTCH H5ENDCARD " + i5);
        this.r.setLayoutParams(layoutParams);
    }

    public void setPlayCloseBtnTm(int i) {
        this.L = i;
    }

    public void setUnitId(String str) {
        this.x = str;
    }

    public void startCounterEndCardShowTimer() {
        try {
            String I = this.b.I();
            int i = 15;
            if (w.b(I) && I.contains("wfl=1")) {
                String[] split = I.split("&");
                int i2 = 15;
                if (split != null) {
                    i2 = 15;
                    if (split.length > 0) {
                        int length = split.length;
                        int i3 = 0;
                        while (true) {
                            i2 = i;
                            if (i3 >= length) {
                                break;
                            }
                            String str = split[i3];
                            int i4 = i;
                            if (w.b(str)) {
                                i4 = i;
                                if (str.contains("timeout")) {
                                    i4 = i;
                                    if (str.split("=") != null) {
                                        i4 = i;
                                        if (str.split("=").length > 0) {
                                            i4 = t.a((Object) str.split("=")[1]);
                                            o.b(AnythinkBaseView.TAG, "从url获取的wfl timeout :".concat(String.valueOf(i4)));
                                        }
                                    }
                                }
                            }
                            i3++;
                            i = i4;
                        }
                    }
                }
                executeEndCardShow(i2);
            }
        } catch (Throwable th) {
            o.a(AnythinkBaseView.TAG, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i) {
        int i2;
        int visibility = this.r.getVisibility();
        if (i == 1) {
            this.S = true;
            i2 = 0;
        } else if (i != 2) {
            i2 = visibility;
        } else {
            this.S = false;
            if (this.z) {
                i2 = 8;
                if (!this.af) {
                    if (this.T) {
                        i2 = 8;
                    } else {
                        this.af = true;
                        int i3 = this.L;
                        if (i3 == 0) {
                            this.W = true;
                            i2 = 8;
                        } else {
                            this.W = false;
                            i2 = 8;
                            if (i3 >= 0) {
                                this.t.postDelayed(new e(this), this.L * 1000);
                                i2 = 8;
                            }
                        }
                    }
                }
            } else {
                i2 = 8;
                if (!this.ae) {
                    if (this.T) {
                        i2 = 8;
                    } else {
                        this.ae = true;
                        int i4 = this.K;
                        if (i4 == 0) {
                            this.V = true;
                            i2 = 8;
                        } else {
                            this.V = false;
                            i2 = 8;
                            if (i4 >= 0) {
                                this.t.postDelayed(new d(this), this.K * 1000);
                                i2 = 8;
                            }
                        }
                    }
                }
            }
        }
        setCloseVisible(i2);
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        o.d("EndCard_MRAID", "unload");
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z) {
        o.d("EndCard_MRAID", "useCustomClose : ".concat(String.valueOf(z)));
        try {
            setCloseVisibleForMraid(z ? 4 : 0);
        } catch (Exception e2) {
            o.d(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    public void volumeChange(double d2) {
        CallMraidJS.getInstance().fireAudioVolumeChange(this.s, d2);
    }

    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.s;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkH5EndCardView.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        o.a(AnythinkBaseView.TAG, AnythinkH5EndCardView.o);
                        int[] iArr = new int[2];
                        AnythinkH5EndCardView.this.s.getLocationOnScreen(iArr);
                        o.d(AnythinkBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                        JSONObject jSONObject = new JSONObject();
                        Context g = n.a().g();
                        if (g != null) {
                            jSONObject.put("startX", t.a(g, iArr[0]));
                            jSONObject.put("startY", t.a(g, iArr[1]));
                            jSONObject.put(com.anythink.expressad.foundation.g.a.ch, t.c(g));
                        }
                        String encodeToString = Base64.encodeToString(jSONObject.toString().toString().getBytes(), 2);
                        j.a();
                        j.a((WebView) AnythinkH5EndCardView.this.s, AnythinkH5EndCardView.o, encodeToString);
                        AnythinkH5EndCardView.this.e.a(109, "");
                        AnythinkH5EndCardView.g(AnythinkH5EndCardView.this);
                        AnythinkH5EndCardView.this.startCounterEndCardShowTimer();
                        j.a();
                        j.a((WebView) AnythinkH5EndCardView.this.s, "oncutoutfetched", Base64.encodeToString(AnythinkH5EndCardView.this.ac.getBytes(), 0));
                        AnythinkH5EndCardView.i(AnythinkH5EndCardView.this);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }
}
