package com.anythink.expressad.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.out.j;
import com.anythink.expressad.video.bt.module.b.h;
import com.anythink.expressad.video.dynview.f.d;
import com.anythink.expressad.video.signal.a.c;
import com.anythink.expressad.video.signal.b;
import com.anythink.expressad.video.signal.container.AbstractJSContainer;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.widget.FeedBackButton;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.ao;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/AnythinkBTContainer.class */
public class AnythinkBTContainer extends AbstractJSContainer implements b {
    private static final String d = AnythinkBTContainer.class.getSimpleName();
    private Context A;
    private TextView B;
    private boolean C;
    private boolean D;
    private String E;
    private boolean F;
    private List<c> G;
    private List<com.anythink.expressad.videocommon.b.c> H;
    private com.anythink.expressad.video.bt.module.a.a I;
    private h J;
    private h K;
    private com.anythink.expressad.video.bt.module.a.b L;
    private String M;
    private String N;
    private boolean O;
    private int P;
    private boolean Q;
    private int R;
    private String S;
    private d T;

    /* renamed from: a  reason: collision with root package name */
    c f8314a;
    private int e;
    private int f;
    private FrameLayout g;
    private AnythinkBTLayout h;
    private WindVaneWebView i;
    private LayoutInflater j;

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTContainer$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/AnythinkBTContainer$2.class */
    final class AnonymousClass2 implements com.anythink.expressad.video.dynview.f.h {
        AnonymousClass2() {
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            c cVar;
            String str;
            if (AnythinkBTContainer.this.g == null || aVar.a() == null) {
                AnythinkBTContainer.this.a("nativeview is null");
                return;
            }
            AnythinkBTContainer.this.g.removeAllViews();
            AnythinkBTContainer.this.g.addView(aVar.a());
            AnythinkBTContainer anythinkBTContainer = AnythinkBTContainer.this;
            anythinkBTContainer.B = (TextView) anythinkBTContainer.findViewById(anythinkBTContainer.findID("anythink_choice_one_countdown_tv"));
            if (AnythinkBTContainer.this.I != null) {
                AnythinkBTContainer.this.I.a();
            }
            if (AnythinkBTContainer.this.G == null || AnythinkBTContainer.this.G.size() <= 0 || (cVar = (c) AnythinkBTContainer.this.G.get(0)) == null) {
                return;
            }
            String ai = cVar.ai();
            com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), AnythinkBTContainer.this.m);
            int M = a2 != null ? a2.M() : 1;
            if (cVar.n() == 1) {
                str = ai + "&to=1&cbt=" + cVar.az() + "&tmorl=" + M;
            } else {
                str = ai + "&to=0&cbt=" + cVar.az() + "&tmorl=" + M;
            }
            com.anythink.expressad.a.a.a(n.a().g(), cVar, AnythinkBTContainer.this.m, str, false, true, com.anythink.expressad.a.a.a.j);
            f.h.put(cVar.ai(), Long.valueOf(System.currentTimeMillis()));
            AnythinkBTContainer.this.a(cVar);
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            String str;
            if (bVar != null) {
                str = "errorCode:" + bVar.a() + "Msg:" + bVar.b();
            } else {
                str = "";
            }
            AnythinkBTContainer.this.a("nativeview is null".concat(String.valueOf(str)));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/AnythinkBTContainer$a.class */
    final class a extends c.a {
        private a() {
        }

        /* synthetic */ a(AnythinkBTContainer anythinkBTContainer, byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(int i, String str) {
            super.a(i, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, String str) {
            super.a(cVar, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
            super.a(cVar, z);
            AnythinkBTContainer.this.K.a(cVar);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(j jVar, String str) {
            super.a(jVar, str);
            if (jVar == null || !(jVar instanceof com.anythink.expressad.foundation.d.c)) {
                return;
            }
            try {
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) jVar;
                String optString = new JSONObject(AnythinkBTContainer.this.getJSVideoModule().getCurrentProgress()).optString("progress", "");
                if (cVar.Q() == 3 && cVar.C() == 2 && optString.equals("1.0") && AnythinkBTContainer.this.l != null) {
                    if (AnythinkBTContainer.this.D) {
                        AnythinkBTContainer.this.onAdClose();
                    } else {
                        AnythinkBTContainer.this.l.finish();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void b() {
            super.b();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void b(j jVar, String str) {
            super.b(jVar, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void c() {
            super.c();
        }
    }

    public AnythinkBTContainer(Context context) {
        super(context);
        this.e = 0;
        this.f = 1;
        this.C = false;
        this.D = true;
        this.F = false;
        this.P = 1;
        init(context);
    }

    public AnythinkBTContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.f = 1;
        this.C = false;
        this.D = true;
        this.F = false;
        this.P = 1;
        init(context);
    }

    private void a(Context context) {
        if (this.T == null) {
            a("ChoiceOneCallback is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(com.anythink.expressad.video.dynview.a.a.D, this.T);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(context, this.G, new AnonymousClass2(), hashMap);
    }

    private boolean a(boolean z) {
        try {
            if (this.o == null) {
                return false;
            }
            int K = this.o.K();
            if (K != 1) {
                if (K == 2) {
                    return z && g();
                } else if (K != 3) {
                    return false;
                } else {
                    return g();
                }
            }
            return z;
        } catch (Throwable th) {
            o.b(d, "", th);
            return false;
        }
    }

    private WindVaneWebView b(String str) {
        a.C0164a a2 = com.anythink.expressad.videocommon.a.a(str);
        if (a2 != null) {
            this.E = a2.b();
            String str2 = d;
            o.a(str2, "get BT wraper.getTag = " + this.E);
            a2.a("");
            return a2.a();
        }
        return null;
    }

    private com.anythink.expressad.video.bt.module.a.b c() {
        if (this.L == null) {
            this.L = new com.anythink.expressad.video.bt.module.a.b() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTContainer.3
                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a() {
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(String str) {
                    if (AnythinkBTContainer.this.i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(com.anythink.expressad.a.y, AnythinkBTContainer.this.n);
                            jSONObject2.put("unitId", AnythinkBTContainer.this.m);
                            jSONObject.put("data", jSONObject2);
                            String str2 = AnythinkBTContainer.d;
                            o.a(str2, " BT Call H5 onAdShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            o.a(AnythinkBTContainer.d, e.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, "onSubPlayTemplateViewPlayStart", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(String str, com.anythink.expressad.foundation.d.c cVar) {
                    AnythinkBTContainer.this.f8314a = cVar;
                    if (AnythinkBTContainer.this.i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(com.anythink.expressad.a.y, AnythinkBTContainer.this.n);
                            jSONObject2.put("unitId", AnythinkBTContainer.this.m);
                            jSONObject.put("data", jSONObject2);
                            String str2 = AnythinkBTContainer.d;
                            o.a(str2, " BT Call H5 onVideoAdClicked " + jSONObject.toString());
                        } catch (JSONException e) {
                            o.a(AnythinkBTContainer.d, e.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, "onSubPlayTemplateViewClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(String str, String str2) {
                    if (AnythinkBTContainer.this.i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(com.anythink.expressad.a.y, AnythinkBTContainer.this.n);
                            jSONObject2.put("unitId", AnythinkBTContainer.this.m);
                            jSONObject2.put("error", str2);
                            jSONObject.put("data", jSONObject2);
                            String str3 = AnythinkBTContainer.d;
                            o.a(str3, " BT Call H5 onShowFail " + jSONObject.toString());
                        } catch (JSONException e) {
                            o.a(AnythinkBTContainer.d, e.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, "onSubPlayTemplateViewPlayFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(String str, boolean z, com.anythink.expressad.videocommon.c.c cVar) {
                    if (AnythinkBTContainer.this.i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            if (cVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("name", cVar.a());
                                jSONObject3.put("amount", cVar.b());
                                jSONObject2.put("reward", jSONObject3);
                            }
                            jSONObject2.put("isComplete", z);
                            jSONObject2.put("convert", z ? 1 : 2);
                            jSONObject.put("data", jSONObject2);
                            String str2 = AnythinkBTContainer.d;
                            o.a(str2, " BT Call H5 onAdClose " + jSONObject.toString());
                        } catch (JSONException e) {
                            o.a(AnythinkBTContainer.d, e.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, "onSubPlayTemplateViewCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, "onSubPlayTemplateViewDismissed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void a(boolean z, int i) {
                    AnythinkBTContainer.this.Q = z;
                    AnythinkBTContainer.this.R = i;
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void b(String str) {
                    if (AnythinkBTContainer.this.i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("convert", true);
                            jSONObject2.put(com.anythink.expressad.a.y, AnythinkBTContainer.this.n);
                            jSONObject2.put("unitId", AnythinkBTContainer.this.m);
                            jSONObject.put("data", jSONObject2);
                            String str2 = AnythinkBTContainer.d;
                            o.a(str2, " BT Call H5 onVideoComplete " + jSONObject.toString());
                        } catch (JSONException e) {
                            o.a(AnythinkBTContainer.d, e.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, "onSubPlayTemplateViewPlayCompleted", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.anythink.expressad.video.bt.module.a.b
                public final void c(String str) {
                    if (AnythinkBTContainer.this.i != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(com.anythink.expressad.a.y, AnythinkBTContainer.this.n);
                            jSONObject2.put("unitId", AnythinkBTContainer.this.m);
                            jSONObject.put("data", jSONObject2);
                            String str2 = AnythinkBTContainer.d;
                            o.a(str2, " BT Call H5 onEndcardShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            o.a(AnythinkBTContainer.d, e.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, "onSubPlayTemplateViewEndcardShowSuccess", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            };
        }
        return this.L;
    }

    private com.anythink.expressad.videocommon.b.c d(com.anythink.expressad.foundation.d.c cVar) {
        List<com.anythink.expressad.videocommon.b.c> list = this.H;
        if (list == null || cVar == null) {
            return null;
        }
        for (com.anythink.expressad.videocommon.b.c cVar2 : list) {
            if (cVar2.n().aZ().equals(cVar.aZ())) {
                o.a(d, "tempContainer task initSuccess");
                return cVar2;
            }
        }
        return null;
    }

    private static void d() {
    }

    private static boolean e() {
        return true;
    }

    private static int f() {
        return 1;
    }

    private boolean g() {
        boolean z = false;
        try {
            if (this.o == null) {
                return false;
            }
            double L = this.o.L();
            if (L == 1.0d) {
                return false;
            }
            if (new Random().nextDouble() > L) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            o.b(d, "", th);
            return false;
        }
    }

    protected final void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                List<String> e = cVar.e();
                if (e == null || e.size() <= 0) {
                    return;
                }
                for (String str : e) {
                    com.anythink.expressad.a.a.a(n.a().g(), cVar, this.m, str, true);
                }
            } catch (Throwable th) {
                o.d(d, th.getMessage());
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public final void a(String str) {
        h hVar = this.J;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    public void appendSubView(AnythinkBTContainer anythinkBTContainer, ATTempContainer aTTempContainer, JSONObject jSONObject) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                Context g = n.a().g();
                int optInt = jSONObject.optInt("left", com.anythink.expressad.video.bt.a.c.f8290a);
                int optInt2 = jSONObject.optInt(Constant.MAP_KEY_TOP, com.anythink.expressad.video.bt.a.c.f8290a);
                int optInt3 = jSONObject.optInt("right", com.anythink.expressad.video.bt.a.c.f8290a);
                int optInt4 = jSONObject.optInt("bottom", com.anythink.expressad.video.bt.a.c.f8290a);
                if (optInt != -999 && g != null) {
                    layoutParams.leftMargin = t.b(g, optInt);
                }
                if (optInt2 != -999 && g != null) {
                    layoutParams.topMargin = t.b(g, optInt2);
                }
                if (optInt3 != -999 && g != null) {
                    layoutParams.rightMargin = t.b(g, optInt3);
                }
                if (optInt4 != -999 && g != null) {
                    layoutParams.bottomMargin = t.b(g, optInt4);
                }
                int optInt5 = jSONObject.optInt("width");
                int optInt6 = jSONObject.optInt("height");
                if (optInt5 > 0) {
                    layoutParams.width = optInt5;
                }
                if (optInt6 > 0) {
                    layoutParams.height = optInt6;
                }
            }
            anythinkBTContainer.addView(aTTempContainer, layoutParams);
            aTTempContainer.setActivity(this.l);
            aTTempContainer.setMute(this.s);
            aTTempContainer.setBidCampaign(this.C);
            aTTempContainer.setIV(this.t);
            aTTempContainer.setBigOffer(this.D);
            aTTempContainer.setIVRewardEnable(this.v, this.w, this.x);
            aTTempContainer.setShowRewardListener(this.K);
            aTTempContainer.setCampaignDownLoadTask(d(aTTempContainer.getCampaign()));
            aTTempContainer.setAnythinkTempCallback(c());
            aTTempContainer.setH5Cbp(getJSCommon().e());
            aTTempContainer.setWebViewFront(getJSCommon().f());
            aTTempContainer.init(this.A);
            aTTempContainer.onCreate();
        } catch (Throwable th) {
            o.a(d, th.getMessage());
        }
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.i != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", this.e);
                jSONObject2.put("id", this.E);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.i, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a((WebView) this.i, "broadcast", this.E);
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.d
    public void click(int i, String str) {
    }

    public int findID(String str) {
        return i.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return i.a(getContext(), str, "layout");
    }

    @Override // com.anythink.expressad.video.signal.d
    public void handlerH5Exception(int i, String str) {
    }

    public void init(Context context) {
        this.A = context;
        this.j = LayoutInflater.from(context);
    }

    public boolean isNativeKilledCallback(com.anythink.expressad.foundation.d.c cVar) {
        if (getJSCommon().e() == 1 || cVar == null) {
            return false;
        }
        if (cVar.n() != 1) {
            if (cVar.A()) {
                cVar.m(0);
                return false;
            }
            int a2 = this.o.a();
            cVar.m(a2);
            return a2 == 1;
        } else if (this.o != null) {
            if (this.o.M() == 1) {
                cVar.m(1);
                return true;
            }
            cVar.m(0);
            return false;
        } else {
            return false;
        }
    }

    public void onAdClose() {
        if (this.l != null) {
            this.l.finish();
        }
    }

    public void onBackPressed() {
        try {
            LinkedHashMap<String, View> b = com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (View view : b.values()) {
                if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).onBackPressed();
                } else if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).onBackPressed();
                } else if (view instanceof AnythinkBTLayout) {
                    ((AnythinkBTLayout) view).onBackPressed();
                }
            }
        } catch (Throwable th) {
            o.a(d, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            LinkedHashMap<String, View> b = com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (View view : b.values()) {
                if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).onConfigurationChanged(configuration);
                } else if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).onConfigurationChanged(configuration);
                } else if (view instanceof AnythinkBTLayout) {
                    ((AnythinkBTLayout) view).onConfigurationChanged(configuration);
                }
            }
        } catch (Throwable th) {
            o.a(d, th.getMessage());
        }
    }

    public void onCreate() {
        String str;
        WindVaneWebView windVaneWebView;
        com.anythink.expressad.foundation.d.c cVar;
        RelativeLayout.LayoutParams layoutParams;
        try {
            int findLayout = findLayout("anythink_bt_container");
            if (findLayout < 0) {
                a("anythink_bt_container layout null");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) this.j.inflate(findLayout, this);
            this.g = frameLayout;
            if (frameLayout == null) {
                a("ViewIds null");
                return;
            }
            this.N = "";
            if (this.G == null || this.G.size() <= 0) {
                str = "";
            } else {
                com.anythink.expressad.foundation.d.c cVar2 = this.G.get(0);
                str = cVar2.ar();
                this.N = cVar2.Z();
            }
            a.C0164a a2 = com.anythink.expressad.videocommon.a.a(this.m + BridgeUtil.UNDERLINE_STR + this.N + BridgeUtil.UNDERLINE_STR + str);
            if (a2 != null) {
                this.E = a2.b();
                o.a(d, "get BT wraper.getTag = " + this.E);
                a2.a("");
                windVaneWebView = a2.a();
            } else {
                windVaneWebView = null;
            }
            this.i = windVaneWebView;
            com.anythink.expressad.videocommon.a.b(this.m + BridgeUtil.UNDERLINE_STR + this.N + BridgeUtil.UNDERLINE_STR + str);
            if (this.i == null) {
                if (this.G == null || this.G.size() <= 0 || (cVar = this.G.get(0)) == null || !cVar.j()) {
                    a("big template webview is null");
                    return;
                }
                Context context = this.A;
                if (this.T == null) {
                    a("ChoiceOneCallback is null");
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(com.anythink.expressad.video.dynview.a.a.D, this.T);
                com.anythink.expressad.video.dynview.b.a();
                com.anythink.expressad.video.dynview.b.a(context, this.G, new AnonymousClass2(), hashMap);
                return;
            }
            com.anythink.expressad.video.signal.factory.b bVar = new com.anythink.expressad.video.signal.factory.b(this.l, this, this.i);
            registerJsFactory(bVar);
            this.i.setApiManagerJSFactory(bVar);
            if (this.i.getParent() != null) {
                a("preload template webview is null or load error");
                return;
            }
            if (this.i.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                bVar.a((com.anythink.expressad.video.signal.a.j) this.i.getObject());
                if (this.i != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.anythink.expressad.foundation.g.a.ch, t.c(getContext()));
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", this.q.a());
                        jSONObject2.put("amount", this.q.b());
                        jSONObject2.put("id", this.r);
                        jSONObject.put(ao.q, this.p);
                        jSONObject.put("reward", jSONObject2);
                        jSONObject.put("playVideoMute", this.s);
                        jSONObject.put("extra", this.S);
                    } catch (JSONException e) {
                        o.a(d, e.getMessage());
                    } catch (Exception e2) {
                        o.a(d, e2.getMessage());
                    }
                    this.K = new com.anythink.expressad.video.bt.module.b.d(c(), "");
                    getJSNotifyProxy().a(jSONObject.toString());
                    getJSCommon().h();
                    getJSCommon().a(new a(this, (byte) 0));
                }
                ((com.anythink.expressad.video.signal.a.c) getJSCommon()).r.b();
            }
            this.i.setBackgroundColor(0);
            LinkedHashMap<String, View> b = com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N);
            if (b == null || !b.containsKey(this.E)) {
                a("big template webviewLayout is null");
                return;
            }
            View view = b.get(this.E);
            if (view instanceof AnythinkBTLayout) {
                AnythinkBTLayout anythinkBTLayout = (AnythinkBTLayout) view;
                this.h = anythinkBTLayout;
                anythinkBTLayout.addView(this.i, 0, new FrameLayout.LayoutParams(-1, -1));
                com.anythink.expressad.foundation.f.b.a().a(this.m + "_1", new com.anythink.expressad.foundation.f.a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTContainer.1
                    @Override // com.anythink.expressad.foundation.f.a
                    public final void a() {
                        String str2;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (n.a().g() != null) {
                                jSONObject3.put("status", 1);
                            }
                            str2 = jSONObject3.toString();
                        } catch (Throwable th) {
                            o.b(AnythinkBTContainer.d, th.getMessage(), th);
                            str2 = "";
                        }
                        String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, AbsFeedBackForH5.f7096a, encodeToString);
                    }

                    @Override // com.anythink.expressad.foundation.f.a
                    public final void b() {
                        String str2;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (n.a().g() != null) {
                                jSONObject3.put("status", 2);
                            }
                            str2 = jSONObject3.toString();
                        } catch (Throwable th) {
                            o.b(AnythinkBTContainer.d, th.getMessage(), th);
                            str2 = "";
                        }
                        String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, AbsFeedBackForH5.f7096a, encodeToString);
                    }

                    @Override // com.anythink.expressad.foundation.f.a
                    public final void c() {
                        String str2;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (n.a().g() != null) {
                                jSONObject3.put("status", 2);
                            }
                            str2 = jSONObject3.toString();
                        } catch (Throwable th) {
                            o.b(AnythinkBTContainer.d, th.getMessage(), th);
                            str2 = "";
                        }
                        String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) AnythinkBTContainer.this.i, AbsFeedBackForH5.f7096a, encodeToString);
                    }
                });
                com.anythink.expressad.foundation.f.b.a().c(this.m + "_2");
                FeedBackButton b2 = com.anythink.expressad.foundation.f.b.a().b(this.m + "_1");
                if (com.anythink.expressad.foundation.f.b.a().b() && b2 != null) {
                    try {
                        layoutParams = (RelativeLayout.LayoutParams) b2.getLayoutParams();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        layoutParams = null;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.f7817a, com.anythink.expressad.foundation.f.b.b);
                    }
                    layoutParams2.topMargin = t.b(n.a().g(), 10.0f);
                    layoutParams2.leftMargin = t.b(n.a().g(), 10.0f);
                    b2.setLayoutParams(layoutParams2);
                    ViewGroup viewGroup = (ViewGroup) b2.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b2);
                    }
                    this.h.addView(b2);
                }
                this.h.setTag(this.E);
                b.put(this.E, this.h);
                Iterator<View> it = b.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    View next = it.next();
                    if (next instanceof AnythinkBTRootLayout) {
                        AnythinkBTRootLayout anythinkBTRootLayout = (AnythinkBTRootLayout) next;
                        this.M = anythinkBTRootLayout.getInstanceId();
                        this.g.addView(anythinkBTRootLayout, new FrameLayout.LayoutParams(-1, -1));
                        break;
                    }
                }
                b.remove(this.M);
                b.put(this.M, this);
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.m, this.s);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.E, this.N);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.M, this.N);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.m + BridgeUtil.UNDERLINE_STR + this.N, this.l);
            if (this.G == null || this.G.size() <= 0) {
                return;
            }
            a(this.o, this.G.get(0));
        } catch (Throwable th) {
            a("onCreate exception ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.F) {
            return;
        }
        this.F = true;
        super.onDestroy();
        com.anythink.expressad.video.bt.a.c.a();
        com.anythink.expressad.video.bt.a.c.d(this.m + BridgeUtil.UNDERLINE_STR + this.N);
        try {
            if (this.i != null) {
                ViewGroup viewGroup = (ViewGroup) this.i.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.i.clearWebView();
                this.i.release();
            }
            if (this.L != null) {
                this.L = null;
            }
            if (this.I != null) {
                this.I = null;
            }
            if (this.A != null) {
                this.A = null;
            }
            if (this.G != null && this.G.size() > 0) {
                for (com.anythink.expressad.foundation.d.c cVar : this.G) {
                    if (cVar != null && cVar.M() != null) {
                        com.anythink.expressad.videocommon.a.b(this.m + BridgeUtil.UNDERLINE_STR + cVar.Z() + BridgeUtil.UNDERLINE_STR + cVar.M().e());
                    }
                }
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.f(this.E);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.g(this.m);
            com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N).remove(this.E);
            com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N).remove(this.M);
            com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N).clear();
        } catch (Throwable th) {
            o.a(d, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onPause() {
        com.anythink.expressad.foundation.d.c cVar;
        super.onPause();
        List<com.anythink.expressad.foundation.d.c> list = this.G;
        if (list != null && list.size() > 0 && (cVar = this.G.get(0)) != null && cVar.j()) {
            com.anythink.expressad.video.dynview.b.a.a();
        }
        try {
            LinkedHashMap<String, View> b = com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (View view : b.values()) {
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).onPause();
                }
            }
        } catch (Throwable th) {
            o.a(d, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onResume() {
        com.anythink.expressad.foundation.d.c cVar;
        super.onResume();
        List<com.anythink.expressad.foundation.d.c> list = this.G;
        if (list != null && list.size() > 0 && (cVar = this.G.get(0)) != null && cVar.j()) {
            com.anythink.expressad.video.dynview.b.a a2 = com.anythink.expressad.video.dynview.b.a.a();
            if (a2.f8352a != null) {
                a2.f8352a.a();
            }
        }
        if (com.anythink.expressad.foundation.f.b.f7818c) {
            return;
        }
        try {
            LinkedHashMap<String, View> b = com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (View view : b.values()) {
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).onResume();
                }
            }
        } catch (Throwable th) {
            o.a(d, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onStop() {
        com.anythink.expressad.foundation.d.c cVar;
        super.onStop();
        List<com.anythink.expressad.foundation.d.c> list = this.G;
        if (list != null && list.size() > 0 && (cVar = this.G.get(0)) != null && cVar.j()) {
            com.anythink.expressad.video.dynview.b.a a2 = com.anythink.expressad.video.dynview.b.a.a();
            if (a2.f8352a != null) {
                a2.f8352a.c();
            }
        }
        try {
            LinkedHashMap<String, View> b = com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (View view : b.values()) {
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).onStop();
                }
            }
        } catch (Throwable th) {
            o.a(d, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.b
    public void reactDeveloper(Object obj, String str) {
        if (this.I == null || TextUtils.isEmpty(str)) {
            a(obj, "listener is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt("hit");
            String optString = jSONObject.optString("unitId", getUnitId());
            jSONObject.optString(com.anythink.expressad.a.y, getPlacementId());
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.anythink.expressad.foundation.d.c cVar = this.G.get(0);
            boolean z = true;
            if (optInt == 1) {
                boolean optBoolean = optJSONObject.optBoolean("expired");
                if (cVar != null) {
                    if (optBoolean) {
                        cVar.e(1);
                    } else {
                        cVar.e(0);
                    }
                }
                this.O = isNativeKilledCallback(cVar);
            }
            switch (optInt) {
                case 1:
                    this.I.a();
                    break;
                case 2:
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("error");
                    String optString2 = optJSONObject2 != null ? optJSONObject2.optString("msg") : "";
                    String str2 = optString2;
                    if (TextUtils.isEmpty(optString2)) {
                        str2 = optJSONObject.optString("error");
                    }
                    if (!this.O && optInt2 != this.P) {
                        this.I.a(str2);
                        break;
                    }
                    break;
                case 3:
                    this.I.b();
                    break;
                case 4:
                    this.I.c();
                    break;
                case 5:
                    com.anythink.expressad.video.bt.module.a.a aVar = this.I;
                    com.anythink.expressad.foundation.d.c cVar2 = cVar;
                    if (this.f8314a != null) {
                        cVar2 = this.f8314a;
                    }
                    aVar.a(cVar2);
                    break;
                case 6:
                    if (optJSONObject.optInt("convert") != 1) {
                        z = false;
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("reward");
                    com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(optJSONObject.optJSONObject("campaign"));
                    com.anythink.expressad.videocommon.c.c a2 = com.anythink.expressad.videocommon.c.c.a(optJSONObject3);
                    com.anythink.expressad.videocommon.c.c cVar3 = a2;
                    if (a2 == null) {
                        cVar3 = this.q;
                    }
                    String optString3 = optJSONObject.optString("extra");
                    if (!TextUtils.isEmpty(optString3)) {
                        this.S = optString3;
                    }
                    if (!this.O && optInt2 != this.P) {
                        if (this.t && (this.v == com.anythink.expressad.foundation.g.a.cr || this.v == com.anythink.expressad.foundation.g.a.cs)) {
                            this.I.a(this.Q, this.R);
                        }
                        if (!z) {
                            cVar3.a(0);
                        }
                        this.I.a(z, cVar3);
                        o.a(d, "sendToServerRewardInfo");
                        if (!this.t && z) {
                            if (b == null) {
                                com.anythink.expressad.video.module.b.a.a(cVar, cVar3, optString, this.p, this.S);
                                break;
                            } else {
                                com.anythink.expressad.video.module.b.a.a(b, cVar3, optString, this.p, this.S);
                                break;
                            }
                        }
                    }
                    break;
            }
            a(obj);
        } catch (JSONException e) {
            a(obj, e.getMessage());
            o.a(d, e.getMessage());
        }
    }

    public void setBTContainerCallback(com.anythink.expressad.video.bt.module.a.a aVar) {
        this.I = aVar;
    }

    public void setCampaignDownLoadTasks(List<com.anythink.expressad.videocommon.b.c> list) {
        this.H = list;
    }

    public void setCampaigns(List<com.anythink.expressad.foundation.d.c> list) {
        this.G = list;
    }

    public void setChoiceOneCallback(d dVar) {
        this.T = dVar;
    }

    public void setDeveloperExtraData(String str) {
        this.S = str;
    }

    public void setJSFactory(com.anythink.expressad.video.signal.factory.b bVar) {
        this.z = bVar;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        try {
            String a2 = com.anythink.expressad.foundation.h.h.a(i, i2, i3, i4, i5);
            o.d(d, a2);
            if (this.i != null && (this.i.getObject() instanceof com.anythink.expressad.video.signal.a.j) && !TextUtils.isEmpty(a2)) {
                ((com.anythink.expressad.video.signal.a.j) this.i.getObject()).b(a2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.i, "oncutoutfetched", Base64.encodeToString(a2.getBytes(), 0));
            }
            if (this.G != null && this.G.size() > 0) {
                try {
                    if (this.G.get(0).j() && this.B != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.B.getLayoutParams();
                        layoutParams.setMargins(i2, i4, i3, i5);
                        this.B.setLayoutParams(layoutParams);
                    }
                } catch (Exception e) {
                    o.d(d, e.getMessage());
                }
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(i, i2, i3, i4, i5);
            LinkedHashMap<String, View> b = com.anythink.expressad.video.bt.a.c.a().b(this.m, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (View view : b.values()) {
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).setNotchPadding(i2, i3, i4, i5);
                }
                if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).setNotchPadding(i, i2, i3, i4, i5);
                }
                if ((view instanceof WindVaneWebView) && !TextUtils.isEmpty(a2)) {
                    com.anythink.expressad.atsignalcommon.windvane.j.a().a(view, "oncutoutfetched", Base64.encodeToString(a2.getBytes(), 0));
                }
            }
        } catch (Throwable th) {
            o.a(d, th.getMessage());
        }
    }

    public void setShowRewardVideoListener(h hVar) {
        this.J = hVar;
    }
}
