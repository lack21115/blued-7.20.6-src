package com.anythink.expressad.reward.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.d.r;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.reward.a.c;
import com.anythink.expressad.reward.a.e;
import com.anythink.expressad.reward.player.ATRewardVideoActivity;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.videocommon.b.i;
import com.anythink.expressad.videocommon.b.l;
import com.anythink.expressad.videocommon.b.m;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d.class */
public final class d implements com.anythink.expressad.reward.a.a {
    private static final int L = 8;
    private static final int M = 9;
    private static final int N = 16;
    private static final int O = 17;
    private static final int P = 5000;
    private static final int Q = 30000;

    /* renamed from: a  reason: collision with root package name */
    public static final String f8113a = "APP ALREADY INSTALLED";
    public static final String b = "Offer list is empty";
    public static final String d = "1";
    public static final String e = "1";
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 4;
    public static final int j = 5;
    public static final int k = 6;
    public static final int l = 7;
    private static final String u = "RewardMVVideoAdapter";
    private int A;
    private int B;
    private boolean C;
    private String D;
    private String E;
    private com.anythink.expressad.video.bt.module.b.h F;
    private volatile com.anythink.expressad.reward.a.b G;
    private Runnable H;
    private com.anythink.expressad.videocommon.e.d I;
    private boolean T;
    private boolean U;
    private int W;
    private int X;
    private int Y;
    private com.anythink.expressad.foundation.d.d Z;
    private CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> aa;
    private List<com.anythink.expressad.foundation.d.c> ag;
    private List<com.anythink.expressad.foundation.d.c> ah;
    private Context v;
    private String w;
    private String x;
    private int y;
    private int z;
    private boolean J = false;
    private boolean K = false;

    /* renamed from: c  reason: collision with root package name */
    public Object f8114c = new Object();
    private CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> R = new CopyOnWriteArrayList<>();
    private int S = 2;
    private String V = "";
    private boolean ab = false;
    public String m = "";
    public String n = "";
    private long ac = 0;
    private Handler ad = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.reward.a.d.1
        /* JADX WARN: Removed duplicated region for block: B:280:0x0391 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:293:0x023f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x028f  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x02cb  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r10) {
            /*
                Method dump skipped, instructions count: 2132
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.a.d.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    boolean o = false;
    private long ae = 0;
    volatile boolean p = false;
    volatile boolean q = false;
    volatile boolean r = false;
    volatile boolean s = false;
    volatile boolean t = false;
    private String af = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.reward.a.d$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$2.class */
    public final class AnonymousClass2 implements c.InterfaceC0150c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8116a;
        final /* synthetic */ com.anythink.expressad.foundation.d.c b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8117c;

        AnonymousClass2(boolean z, com.anythink.expressad.foundation.d.c cVar, int i) {
            this.f8116a = z;
            this.b = cVar;
            this.f8117c = i;
        }

        @Override // com.anythink.expressad.reward.a.c.InterfaceC0150c
        public final void a(final String str, final String str2, final String str3, final CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            o.a(d.u, "Campaign 下载成功： " + copyOnWriteArrayList.size());
            d.this.p = true;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.size();
            }
            if (this.f8116a) {
                o.a(d.u, "Campaign 下载成功： 大模板");
                if (!d.this.q || d.this.r || d.this.ad == null) {
                    o.a(d.u, "Campaign 下载成功： 大模板，大模板下载不成功： isCampaignTPLDownloadSuccess： " + d.this.q + "  isCampaignTPLProLoad： " + d.this.r);
                    return;
                }
                o.a(d.u, "Campaign 下载成功： 大模板，大模板下载成功，开始预加载大模板");
                synchronized (d.this.f8114c) {
                    if (d.this.r) {
                        return;
                    }
                    d.this.r = true;
                    o.a("test_pre_load_tpl", "Campaign 下载成功，大模板下载成功，开始预加载大模板");
                    d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.2.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.anythink.expressad.reward.a.c cVar = c.m.f8112a;
                            boolean z = d.this.ab;
                            Handler handler = d.this.ad;
                            boolean z2 = d.this.T;
                            boolean z3 = d.this.U;
                            String str4 = str3;
                            AnonymousClass2.this.b.aa();
                            cVar.a(z, handler, z2, z3, str4, d.this.x, str2, AnonymousClass2.this.b.ar(), d.this.S, AnonymousClass2.this.b, d.this.aa, com.anythink.expressad.videocommon.b.i.a().c(AnonymousClass2.this.b.ar()), str2, d.this.I, new c.j() { // from class: com.anythink.expressad.reward.a.d.2.2.1
                                @Override // com.anythink.expressad.reward.a.c.j
                                public final void a(String str5) {
                                    try {
                                        o.a("HBOPTIMIZE", "模板加载成功 requestId ".concat(String.valueOf(str5)));
                                    } catch (Exception e) {
                                    }
                                    o.a(d.u, "Campaign 下载成功： 大模板预加载成功");
                                    if (!d.this.a(d.this.aa, AnonymousClass2.this.f8116a, AnonymousClass2.this.f8117c)) {
                                        o.a(d.u, "Campaign 下载成功： 大模板预加载成功,isReady false");
                                        List unused = d.this.ag;
                                        boolean unused2 = d.this.U;
                                        if (d.this.ad != null) {
                                            d.this.ad.removeMessages(5);
                                        }
                                        if (d.this.G == null || d.this.t) {
                                            return;
                                        }
                                        d.this.t = true;
                                        TextUtils.isEmpty(d.this.w);
                                        d.this.G.a("errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                        o.a(d.u, "Campaign 下载成功： 大模板预加载成功,isReady false onVideoLoadFail");
                                        return;
                                    }
                                    o.a(d.u, "Campaign 下载成功： 大模板预加载成功,isReady true");
                                    String str6 = d.this.w;
                                    List list = d.this.ah;
                                    boolean unused3 = d.this.U;
                                    d.a(str6, list);
                                    if (d.this.ad != null) {
                                        d.this.ad.removeMessages(5);
                                    }
                                    if (d.this.G == null || d.this.s) {
                                        return;
                                    }
                                    d.this.s = true;
                                    TextUtils.isEmpty(d.this.w);
                                    d.this.G.a();
                                    o.a(d.u, "Campaign 下载成功： 大模板预加载成功,isReady true onVideoLoadSuccess");
                                }

                                @Override // com.anythink.expressad.reward.a.c.j
                                public final void a(String str5, String str6) {
                                    o.a(d.u, "Campaign 下载成功： 大模板预加载失败");
                                    o.d("HBOPTIMIZE", "模板加载失败 requestId ".concat(String.valueOf(str5)));
                                    if (AnonymousClass2.this.b.aB() != null && AnonymousClass2.this.b.aB().size() > 0 && AnonymousClass2.this.b.aB().contains(3)) {
                                        o.b(d.u, "template download fail but hit ignoreCheckRule");
                                        return;
                                    }
                                    List unused = d.this.ag;
                                    boolean unused2 = d.this.U;
                                    if (d.this.ad != null) {
                                        d.this.ad.removeMessages(5);
                                    }
                                    if (d.this.G == null || d.this.t) {
                                        return;
                                    }
                                    d.this.t = true;
                                    d.this.G.a("errorCode: 3303 errorMessage: tpl temp preload failed: ".concat(String.valueOf(str6)));
                                    o.a(d.u, "Campaign 下载成功： 大模板预加载失败 onVideoLoadFail");
                                }
                            });
                        }
                    });
                    return;
                }
            }
            o.a(d.u, "Campaign 下载成功： 非大模板");
            Iterator<com.anythink.expressad.foundation.d.c> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                final com.anythink.expressad.foundation.d.c next = it.next();
                if (next == null || next.M() == null || TextUtils.isEmpty(next.M().e()) || next.M().e().contains(com.anythink.expressad.foundation.d.c.d) || d.this.ad == null) {
                    o.a(d.u, "Campaign 下载成功： 非大模板，不存在播放模板");
                    d dVar = d.this;
                    if (dVar.a(dVar.aa, this.f8116a, this.f8117c)) {
                        o.a(d.u, "Campaign 下载成功： 非大模板，不存在播放模板,isReay true");
                        o.a("HBOPTIMIZE", "模板加载成功 requestId " + copyOnWriteArrayList.get(0).Z());
                        String str4 = d.this.w;
                        List list = d.this.ah;
                        boolean unused = d.this.U;
                        d.a(str4, list);
                        if (d.this.ad != null) {
                            d.this.ad.removeMessages(5);
                        }
                        if (d.this.G != null && !d.this.s) {
                            d.this.s = true;
                            TextUtils.isEmpty(d.this.w);
                            d.this.G.a();
                            o.a(d.u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay true onVideoLoadSuccess");
                        }
                    } else {
                        o.a(d.u, "Campaign 下载成功： 非大模板，不存在播放模板,isReay false");
                        o.d("HBOPTIMIZE", "模板加载失败 requestId " + copyOnWriteArrayList.get(0).Z());
                        List unused2 = d.this.ag;
                        boolean unused3 = d.this.U;
                        if (d.this.ad != null) {
                            d.this.ad.removeMessages(5);
                        }
                        if (d.this.G != null && !d.this.t) {
                            d.this.t = true;
                            if (!TextUtils.isEmpty(d.this.w) && next != null && !TextUtils.isEmpty(next.aa())) {
                                next.aa();
                            }
                            d.this.G.a("errorCode: 3503 errorMessage: have no temp but isReady false");
                            o.a(d.u, "Campaign 下载成功： 非大模板，不存在播放模板,isReay false onVideoLoadFail");
                        }
                    }
                } else {
                    o.a(d.u, "Campaign 下载成功： 非大模板，开始预加载播放模板");
                    d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.anythink.expressad.reward.a.c cVar = c.m.f8112a;
                            boolean z = d.this.ab;
                            Handler handler = d.this.ad;
                            boolean z2 = d.this.T;
                            boolean z3 = d.this.U;
                            String e = next.M().e();
                            int i = d.this.S;
                            com.anythink.expressad.foundation.d.c cVar2 = AnonymousClass2.this.b;
                            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = d.this.aa;
                            String c2 = com.anythink.expressad.videocommon.b.i.a().c(next.M().e());
                            String str5 = str;
                            String str6 = str2;
                            String str7 = str3;
                            next.aa();
                            cVar.a(z, handler, z2, z3, (WindVaneWebView) null, e, i, cVar2, copyOnWriteArrayList2, c2, str5, str6, str7, d.this.I, new c.j() { // from class: com.anythink.expressad.reward.a.d.2.1.1
                                @Override // com.anythink.expressad.reward.a.c.j
                                public final void a(String str8) {
                                    o.a(d.u, "Campaign 下载成功： 非大模板，播放模板预加载成功");
                                    o.a("HBOPTIMIZE", "模板加载成功 requestId ".concat(String.valueOf(str8)));
                                    if (!d.this.a(d.this.aa, AnonymousClass2.this.f8116a, AnonymousClass2.this.f8117c)) {
                                        o.a(d.u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay false");
                                        List unused4 = d.this.ag;
                                        boolean unused5 = d.this.U;
                                        if (d.this.ad != null) {
                                            d.this.ad.removeMessages(5);
                                        }
                                        if (d.this.G == null || d.this.t) {
                                            return;
                                        }
                                        d.this.t = true;
                                        TextUtils.isEmpty(d.this.w);
                                        d.this.G.a("errorCode: 3502 errorMessage: temp preload success but isReady false");
                                        o.a(d.u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay false onVideoLoadFail");
                                        return;
                                    }
                                    String str9 = d.this.w;
                                    List list2 = d.this.ah;
                                    boolean unused6 = d.this.U;
                                    d.a(str9, list2);
                                    o.a(d.u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay true");
                                    if (d.this.ad != null) {
                                        d.this.ad.removeMessages(5);
                                    }
                                    if (d.this.G == null || d.this.s) {
                                        return;
                                    }
                                    d.this.s = true;
                                    TextUtils.isEmpty(d.this.w);
                                    o.a(d.u, "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay true onVideoLoadSuccess");
                                    d.this.G.a();
                                }

                                @Override // com.anythink.expressad.reward.a.c.j
                                public final void a(String str8, String str9) {
                                    o.a(d.u, "Campaign 下载失败： 非大模板，播放模板预加载失败");
                                    o.d("HBOPTIMIZE", "模板加载失败 requestId ".concat(String.valueOf(str8)));
                                    if (AnonymousClass2.this.b.aB() != null && AnonymousClass2.this.b.aB().size() > 0 && AnonymousClass2.this.b.aB().contains(1)) {
                                        o.b(d.u, "template preload fail but hit ignoreCheckRule");
                                        return;
                                    }
                                    List unused4 = d.this.ag;
                                    boolean unused5 = d.this.U;
                                    if (d.this.ad != null) {
                                        d.this.ad.removeMessages(5);
                                    }
                                    if (d.this.G == null || d.this.t) {
                                        return;
                                    }
                                    d.this.t = true;
                                    TextUtils.isEmpty(d.this.w);
                                    d.this.G.a("errorCode: 3301 errorMessage: temp preload failed: ".concat(String.valueOf(str9)));
                                    o.a(d.u, "Campaign 下载失败： 非大模板，播放模板预加载失败 onVideoLoadFail");
                                }
                            });
                        }
                    });
                }
            }
        }

        @Override // com.anythink.expressad.reward.a.c.InterfaceC0150c
        public final void a(final String str, String str2, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            o.a(d.u, "Campaign 下载失败： " + copyOnWriteArrayList.size());
            o.d("HBOPTIMIZE", "模板加载失败 requestId ".concat(String.valueOf(str2)));
            d.this.p = false;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.size();
            }
            if (d.this.G == null || d.this.ad == null) {
                return;
            }
            d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.2.3
                @Override // java.lang.Runnable
                public final void run() {
                    List unused = d.this.ag;
                    boolean unused2 = d.this.U;
                    if (d.this.ad != null) {
                        d.this.ad.removeMessages(5);
                    }
                    if (d.this.t || d.this.G == null) {
                        return;
                    }
                    d.this.t = true;
                    TextUtils.isEmpty(d.this.w);
                    d.this.G.a("errorCode: 3201 errorMessage: campaign resource download failed");
                    o.a(d.u, "Campaign 下载失败：onVideoLoadFail");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.reward.a.d$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$4.class */
    public final class AnonymousClass4 implements c.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f8129a;
        final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8130c;

        AnonymousClass4(com.anythink.expressad.foundation.d.c cVar, boolean z, int i) {
            this.f8129a = cVar;
            this.b = z;
            this.f8130c = i;
        }

        @Override // com.anythink.expressad.reward.a.c.i
        public final void a(String str, String str2) {
            o.a(d.u, "大模板业务，大模板下载失败");
            o.d("HBOPTIMIZE", "模板加载成功 requestId ".concat(String.valueOf(str2)));
            if (d.this.ag.get(0) != null) {
                d.this.ag.size();
            }
            if (this.f8129a.aB() != null && this.f8129a.aB().size() > 0) {
                if (this.f8129a.aB().contains(3)) {
                    o.b(d.u, "tpl download fail but hit ignoreCheckRule");
                    return;
                } else if (this.f8129a.ar().equals(this.f8129a.I()) && this.f8129a.aB().contains(2)) {
                    o.b(d.u, "endcard download fail but hit ignoreCheckRule at 3203");
                    return;
                }
            }
            d.this.q = false;
            List unused = d.this.ag;
            boolean unused2 = d.this.U;
            if (d.this.ad != null) {
                d.this.ad.removeMessages(5);
            }
            if (d.this.G == null || d.this.t) {
                return;
            }
            d.this.t = true;
            d.this.G.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
            o.a(d.u, "大模板业务，大模板下载失败 onVideoLoadFail");
        }

        @Override // com.anythink.expressad.reward.a.c.i
        public final void a(final String str, final String str2, final String str3) {
            o.a(d.u, "大模板业务，大模板下载成功");
            d.this.q = true;
            if (!d.this.p || d.this.r || d.this.ad == null) {
                o.a(d.u, "大模板业务，大模板下载成功，Campaign 下载不成功，isCampaignsDownloadSuccess： " + d.this.p + "  isCampaignTPLProLoad： " + d.this.r);
                return;
            }
            o.a(d.u, "大模板业务，大模板下载成功，Campaign 下载成功，开始预加载大模板");
            o.a("test_pre_load_tpl", "大模板下载成功，Campaign 下载成功，开始预加载大模板");
            synchronized (d.this.f8114c) {
                if (d.this.r) {
                    return;
                }
                d.this.r = true;
                d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.anythink.expressad.reward.a.c cVar = c.m.f8112a;
                        boolean z = d.this.ab;
                        Handler handler = d.this.ad;
                        boolean z2 = d.this.T;
                        boolean z3 = d.this.U;
                        String str4 = str3;
                        AnonymousClass4.this.f8129a.aa();
                        cVar.a(z, handler, z2, z3, str4, str, str2, AnonymousClass4.this.f8129a.ar(), d.this.S, AnonymousClass4.this.f8129a, d.this.aa, com.anythink.expressad.videocommon.b.i.a().c(AnonymousClass4.this.f8129a.ar()), str2, d.this.I, new c.j() { // from class: com.anythink.expressad.reward.a.d.4.1.1
                            @Override // com.anythink.expressad.reward.a.c.j
                            public final void a(String str5) {
                                o.a("HBOPTIMIZE", "模板加载成功 requestId ".concat(String.valueOf(str5)));
                                if (!d.this.a(d.this.aa, AnonymousClass4.this.b, AnonymousClass4.this.f8130c)) {
                                    o.a(d.u, "大模板业务，大模板预加载成功，isReady false");
                                    List unused = d.this.ag;
                                    boolean unused2 = d.this.U;
                                    if (d.this.ad != null) {
                                        d.this.ad.removeMessages(5);
                                    }
                                    if (d.this.G == null || d.this.t) {
                                        return;
                                    }
                                    d.this.t = true;
                                    d.this.G.a("errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                    o.a(d.u, "大模板业务，大模板预加载成功 isReady false  onVideoLoadFail");
                                    return;
                                }
                                o.a(d.u, "大模板业务，大模板预加载成功，isReady true");
                                String str6 = d.this.w;
                                List unused3 = d.this.ag;
                                List list = d.this.ah;
                                boolean unused4 = d.this.U;
                                d.a(str6, list);
                                if (d.this.ad != null) {
                                    d.this.ad.removeMessages(5);
                                }
                                if (d.this.G == null || d.this.s) {
                                    return;
                                }
                                d.this.s = true;
                                TextUtils.isEmpty(d.this.w);
                                d.this.G.a();
                                o.a(d.u, "大模板业务，大模板预加载成功，isReady true onVideoLoadSuccess");
                            }

                            @Override // com.anythink.expressad.reward.a.c.j
                            public final void a(String str5, String str6) {
                                o.a(d.u, "大模板业务，大模板预加载失败");
                                o.d("HBOPTIMIZE", "模板加载失败 requestId ".concat(String.valueOf(str5)));
                                List unused = d.this.ag;
                                boolean unused2 = d.this.U;
                                if (d.this.ad != null) {
                                    d.this.ad.removeMessages(5);
                                }
                                if (d.this.G == null || d.this.t) {
                                    return;
                                }
                                d.this.t = true;
                                d.this.G.a("errorCode: 3303 errorMessage: tpl temp preload failed: ".concat(String.valueOf(str6)));
                                o.a(d.u, "大模板业务，大模板预加载失败 onVideoLoadFail");
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.reward.a.d$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$5.class */
    public final class AnonymousClass5 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.d f8134a;

        AnonymousClass5(com.anythink.expressad.foundation.d.d dVar) {
            this.f8134a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.b(d.u, "在子线程处理业务逻辑 开始");
            com.anythink.expressad.foundation.d.d dVar = this.f8134a;
            if (dVar != null && dVar.J != null && this.f8134a.J.size() > 0) {
                d.a(d.this, this.f8134a.J);
            }
            o.b(d.u, "在子线程处理业务逻辑 完成");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$a.class */
    public static final class a extends com.anythink.expressad.atsignalcommon.a.a {
        private d b;

        /* renamed from: c  reason: collision with root package name */
        private String f8135c;
        private String d;
        private a.C0164a e;
        private com.anythink.expressad.foundation.d.c f;
        private boolean g;
        private boolean h;
        private g i;
        private Handler j;

        public a(String str, String str2, a.C0164a c0164a, com.anythink.expressad.foundation.d.c cVar, d dVar, g gVar, Handler handler) {
            this.f8135c = str;
            this.d = str2;
            this.e = c0164a;
            if (dVar != null) {
                this.b = dVar;
            }
            this.f = cVar;
            this.i = gVar;
            this.j = handler;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final String a(String str) {
            return com.anythink.expressad.videocommon.b.i.a().c(str);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final void a(String str, int i, int i2) {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.g) {
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.g = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            try {
                o.d("RVWindVaneWebView", "CampaignTPL TempalteWindVaneWebviewClient tempalte load failed");
                if (this.b != null) {
                    synchronized (this.b) {
                        o.d("RVWindVaneWebView", "CampaignTPL TempalteWindVaneWebviewClient tempalte load callback failed");
                        d.a(this.b, str, str2);
                        this.b = null;
                    }
                }
            } catch (Throwable th) {
                o.b("RVWindVaneWebView", th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i) {
            Handler handler;
            if (this.h) {
                return;
            }
            g gVar = this.i;
            if (gVar != null && (handler = this.j) != null) {
                handler.removeCallbacks(gVar);
            }
            o.a("RVWindVaneWebView", "CampaignTPL templete preload readyState state = ".concat(String.valueOf(i)));
            l.a().c(this.f8135c, true);
            StringBuilder sb = new StringBuilder();
            sb.append(this.d);
            sb.append(BridgeUtil.UNDERLINE_STR);
            sb.append(this.f8135c);
            a.C0164a c0164a = this.e;
            if (c0164a != null) {
                c0164a.a(true);
            }
            this.h = true;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$b.class */
    static final class b implements com.anythink.expressad.videocommon.d.b {

        /* renamed from: a  reason: collision with root package name */
        private d f8136a;
        private com.anythink.expressad.foundation.d.c b;

        public b(d dVar, com.anythink.expressad.foundation.d.c cVar) {
            this.f8136a = dVar;
            this.b = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str) {
            try {
                l.a().a(str, true);
                o.d(d.u, "CommonVideoDownloadListener VIDEO SUCCESS");
                if (this.f8136a != null) {
                    synchronized (this.f8136a) {
                        o.d(d.u, "adapter 1613");
                        if (this.f8136a != null && this.f8136a.c()) {
                            o.d(d.u, "CommonVideoDownloadListener VIDEO SUCCESS callback success");
                            if (this.f8136a.ad != null) {
                                Message obtain = Message.obtain();
                                o.a(d.u, "WHAT_ON_RES_LOAD_SUCCESS CommonVideoDownloadListener");
                                obtain.what = 6;
                                obtain.obj = this.b;
                                this.f8136a.ad.sendMessage(obtain);
                                this.f8136a.ad.removeMessages(5);
                                this.f8136a = null;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                o.b(d.u, th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str, String str2) {
            try {
                if (this.f8136a != null) {
                    synchronized (this.f8136a) {
                        o.d(d.u, "CommonVideoDownloadListener VIDEO failed");
                        d.a(this.f8136a, str, str2);
                        this.f8136a = null;
                    }
                }
            } catch (Throwable th) {
                o.b(d.u, th.getMessage(), th);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$c.class */
    static final class c implements com.anythink.expressad.foundation.g.d.c {

        /* renamed from: a  reason: collision with root package name */
        private d f8137a;
        private com.anythink.expressad.foundation.d.c b;

        /* renamed from: c  reason: collision with root package name */
        private String f8138c;

        public c(d dVar, com.anythink.expressad.foundation.d.c cVar, String str) {
            this.f8137a = dVar;
            this.b = cVar;
            this.f8138c = str;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.d$d  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$d.class */
    static final class C0154d implements i.b {

        /* renamed from: a  reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f8139a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private com.anythink.expressad.videocommon.e.d f8140c;
        private d d;

        public C0154d(d dVar, com.anythink.expressad.foundation.d.c cVar, String str, com.anythink.expressad.videocommon.e.d dVar2) {
            this.f8139a = cVar;
            this.b = str;
            this.f8140c = dVar2;
            this.d = dVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            d dVar = this.d;
            if (dVar != null) {
                dVar.a(this.f8139a, str, this.b, this.f8140c);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            d dVar = this.d;
            if (dVar != null) {
                d.a(dVar, "TemplateUrl source download failed", str);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$e.class */
    static final class e implements com.anythink.expressad.foundation.g.d.c {

        /* renamed from: a  reason: collision with root package name */
        private d f8141a;
        private com.anythink.expressad.foundation.d.c b;

        /* renamed from: c  reason: collision with root package name */
        private String f8142c;

        public e(d dVar, com.anythink.expressad.foundation.d.c cVar, String str) {
            this.f8141a = dVar;
            this.b = cVar;
            this.f8142c = str;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            try {
                l.a();
                l.c(str);
                o.d(d.u, "DownTemplateImgCommonImageLoaderListener IMAGE SUCCESS".concat(String.valueOf(str)));
                if (this.f8141a != null) {
                    synchronized (this.f8141a) {
                        o.d(d.u, "adapter 1433");
                        if (this.f8141a.c() && this.f8141a.ad != null) {
                            Message obtain = Message.obtain();
                            o.a(d.u, "WHAT_ON_RES_LOAD_SUCCESS DownTemplateImgCommonImageLoaderListener");
                            obtain.what = 6;
                            obtain.obj = this.b;
                            this.f8141a.ad.sendMessage(obtain);
                            this.f8141a.ad.removeMessages(5);
                            this.f8141a = null;
                        }
                    }
                }
            } catch (Throwable th) {
                o.b(d.u, th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            try {
                if (this.f8141a != null) {
                    synchronized (this.f8141a) {
                        o.d(d.u, "DownTemplateImgCommonImageLoaderListener IMAGE failed");
                        d.a(this.f8141a, str, str2);
                        this.f8141a = null;
                    }
                }
            } catch (Throwable th) {
                o.b(d.u, th.getMessage(), th);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$f.class */
    static final class f implements i.b {

        /* renamed from: a  reason: collision with root package name */
        private d f8143a;
        private com.anythink.expressad.foundation.d.c b;

        /* renamed from: c  reason: collision with root package name */
        private long f8144c = System.currentTimeMillis();
        private String d;
        private boolean e;

        public f(d dVar, com.anythink.expressad.foundation.d.c cVar, String str, boolean z) {
            this.e = true;
            this.d = str;
            this.f8143a = dVar;
            this.b = cVar;
            this.e = z;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            try {
                if (this.f8143a.ad != null) {
                    o.d(d.u, "H5SourceDownloadListener 源码下载成功 cid:" + this.b.aZ() + "  url:" + str);
                    this.f8143a.ad.removeMessages(5);
                    Message obtain = Message.obtain();
                    obtain.what = 8;
                    obtain.obj = this.b;
                    this.f8143a.ad.sendMessage(obtain);
                }
            } catch (Throwable th) {
                o.b(d.u, th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            try {
                o.d(d.u, "H5SourceDownloadListener 源码下载失败 cid:" + this.b.aZ() + "  url:" + str);
                if (this.f8143a != null) {
                    d.a(this.f8143a, "H5 code resource download failed ", str);
                }
            } catch (Throwable th) {
                o.b(d.u, th.getMessage(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$g.class */
    public final class g implements Runnable {
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f8146c;
        private String d;
        private String e;
        private com.anythink.expressad.videocommon.e.d f;
        private int g;
        private d h;

        public g(String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar, int i, d dVar2) {
            this.b = str;
            this.f8146c = cVar;
            this.d = str2;
            this.e = str3;
            this.f = dVar;
            this.g = i;
            this.h = dVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o.b(d.u, "retry load tpl url = " + this.d);
                a.C0164a c0164a = new a.C0164a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(n.a().g());
                c0164a.a(windVaneWebView);
                com.anythink.expressad.video.bt.a.c.a();
                String b = com.anythink.expressad.video.bt.a.c.b();
                c0164a.a(b);
                com.anythink.expressad.video.signal.a.j jVar = (d.this.Z.J == null || d.this.Z.J.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, this.f8146c) : new com.anythink.expressad.video.signal.a.j(null, this.f8146c, d.this.Z.J);
                jVar.a(this.g);
                jVar.a(this.e);
                jVar.c(b);
                jVar.a(this.f);
                jVar.b(d.this.ab);
                windVaneWebView.setWebViewListener(new a(this.d, this.b, c0164a, this.f8146c, this.h, null, null));
                windVaneWebView.setObject(jVar);
                windVaneWebView.loadUrl(this.d);
            } catch (Exception e) {
                if (com.anythink.expressad.a.f6941a) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                o.a(d.u, th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$h.class */
    public final class h implements Runnable {
        private WindVaneWebView b;

        /* renamed from: c  reason: collision with root package name */
        private String f8148c;
        private com.anythink.expressad.foundation.d.c d;
        private List<com.anythink.expressad.foundation.d.c> e;
        private String f;
        private String g;
        private com.anythink.expressad.videocommon.e.d h;
        private int i;
        private d j;

        public h(WindVaneWebView windVaneWebView, String str, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar, int i, d dVar2) {
            this.b = windVaneWebView;
            this.f8148c = str;
            this.d = cVar;
            this.e = list;
            this.f = str2;
            this.g = str3;
            this.h = dVar;
            this.i = i;
            this.j = dVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o.b(d.u, "retry load template url = " + this.f);
                a.C0164a c0164a = new a.C0164a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(n.a().g());
                c0164a.a(windVaneWebView);
                com.anythink.expressad.video.signal.a.j jVar = (this.e == null || this.e.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, this.d) : new com.anythink.expressad.video.signal.a.j(null, this.d, this.e);
                jVar.a(this.i);
                jVar.a(this.g);
                jVar.a(this.h);
                jVar.b(d.this.ab);
                windVaneWebView.setWebViewListener(new j(this.b, this.f, this.f8148c, c0164a, this.d, this.j, null, null));
                windVaneWebView.setObject(jVar);
                windVaneWebView.loadUrl(this.f);
            } catch (Exception e) {
                if (com.anythink.expressad.a.f6941a) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                o.a(d.u, th.getMessage());
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$i.class */
    static final class i implements i.d {

        /* renamed from: a  reason: collision with root package name */
        public static final int f8149a = 497;
        public static final int b = 859;

        /* renamed from: c  reason: collision with root package name */
        public static final int f8150c = 313;
        public static final int d = 502;
        private com.anythink.expressad.foundation.d.c e;
        private d f;
        private long g = System.currentTimeMillis();
        private String h;
        private int i;
        private com.anythink.expressad.videocommon.e.d j;
        private boolean k;

        public i(com.anythink.expressad.foundation.d.c cVar, d dVar, String str, int i, com.anythink.expressad.videocommon.e.d dVar2, boolean z) {
            this.i = 0;
            this.k = true;
            this.h = str;
            this.e = cVar;
            this.i = i;
            this.j = dVar2;
            this.f = dVar;
            this.k = z;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            Context context;
            try {
                l.a().b(str, true);
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.g;
                if (this.i == 497) {
                    if (this.k) {
                        r rVar = new r(r.k, 14, String.valueOf(currentTimeMillis - j), str, this.e.aZ(), this.h, "", "1");
                        rVar.d(this.e.Z());
                        rVar.e(this.e.aa());
                        rVar.g(this.e.aZ());
                        rVar.b(this.e.f());
                        if (this.e.w() == 287) {
                            rVar.a("3");
                        } else if (this.e.w() == 94) {
                            rVar.a("1");
                        }
                    }
                } else if (this.i == 859) {
                    o.a(d.u, "模板资源下载成功");
                    r rVar2 = new r();
                    rVar2.h(r.m);
                    if (this.f != null) {
                        if (TextUtils.isEmpty(this.e.ar())) {
                            this.f.a(this.e, str, this.h, this.j);
                        }
                        Context context2 = this.f.v;
                        if (context2 != null) {
                            context2.getApplicationContext();
                            rVar2.c(k.a());
                        }
                    }
                    rVar2.d(1);
                    if (this.e != null) {
                        rVar2.g(this.e.aZ());
                        rVar2.d(this.e.Z());
                        rVar2.e(this.e.aa());
                    }
                    rVar2.b(str);
                    rVar2.i("");
                    rVar2.f(this.h);
                } else if (this.i == 502) {
                    o.a(d.u, "大模板下载成功");
                    r rVar3 = new r();
                    rVar3.h(r.m);
                    if (this.f != null && (context = this.f.v) != null) {
                        context.getApplicationContext();
                        rVar3.c(k.a());
                    }
                    rVar3.d(1);
                    if (this.e != null) {
                        rVar3.g(this.e.aZ());
                        rVar3.d(this.e.Z());
                        rVar3.e(this.e.aa());
                    }
                    rVar3.b(str);
                    rVar3.i("");
                    rVar3.f(this.h);
                } else if (this.i == 313) {
                    return;
                }
                o.d(d.u, "RewardZipDownloadListener ZIP SUCCESS:".concat(String.valueOf(str)));
                if (this.f != null) {
                    synchronized (this.f) {
                        o.d(d.u, "adapter 1286");
                        if (this.f.c() && this.f.ad != null) {
                            o.a(d.u, "WHAT_ON_RES_LOAD_SUCCESS RewardZipDownloadListener");
                            this.f.ad.sendEmptyMessage(6);
                            this.f.ad.removeMessages(5);
                            this.f = null;
                        }
                    }
                }
            } catch (Throwable th) {
                o.b(d.u, th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            Context context;
            o.d(d.u, "RewardZipDownloadListener ZIP failed:".concat(String.valueOf(str2)));
            try {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.g;
                if (this.i == 497) {
                    if (this.k) {
                        r rVar = new r(r.k, 3, String.valueOf(currentTimeMillis - j), str2, this.e.aZ(), this.h, "zip download failed", "1");
                        rVar.d(this.e.Z());
                        rVar.e(this.e.aa());
                        rVar.g(this.e.aZ());
                        rVar.b(this.e.f());
                        if (this.e.w() == 287) {
                            rVar.a("3");
                        } else if (this.e.w() == 94) {
                            rVar.a("1");
                        }
                    }
                } else if (this.i == 859) {
                    r rVar2 = new r();
                    rVar2.h(r.m);
                    if (this.f != null && (context = this.f.v) != null) {
                        context.getApplicationContext();
                        rVar2.c(k.a());
                    }
                    rVar2.d(3);
                    if (this.e != null) {
                        rVar2.g(this.e.aZ());
                        rVar2.d(this.e.Z());
                        rVar2.e(this.e.aa());
                    }
                    rVar2.b(str2);
                    rVar2.i(str);
                    rVar2.f(this.h);
                } else if (this.i == 313) {
                    return;
                }
                if (this.f != null) {
                    o.d(d.u, "RewardZipDownloadListener ZIP failed:".concat(String.valueOf(str2)));
                    d.a(this.f, str, str2);
                }
            } catch (Exception e) {
                try {
                    if (this.f != null) {
                        this.f.b("clear error info failed");
                    }
                } catch (Throwable th) {
                    o.b(d.u, th.getMessage(), th);
                }
                o.b(d.u, e.getMessage(), e);
            }
            if (this.f != null) {
                this.f = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/d$j.class */
    public static final class j extends com.anythink.expressad.atsignalcommon.a.b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f8151a = 0;
        public static final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        private d f8152c;
        private WindVaneWebView e;
        private String f;
        private String g;
        private a.C0164a h;
        private com.anythink.expressad.foundation.d.c i;
        private boolean j;
        private boolean k;
        private h l;
        private Handler m;

        public j(WindVaneWebView windVaneWebView, String str, String str2, a.C0164a c0164a, com.anythink.expressad.foundation.d.c cVar, d dVar, h hVar, Handler handler) {
            this.e = windVaneWebView;
            this.f = str;
            this.g = str2;
            this.h = c0164a;
            if (dVar != null) {
                this.f8152c = dVar;
            }
            this.i = cVar;
            this.l = hVar;
            this.m = handler;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.j) {
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.j = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            try {
                o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load failed");
                if (this.f8152c != null) {
                    synchronized (this.f8152c) {
                        o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load callback failed");
                        d.a(this.f8152c, str, str2);
                        this.f8152c = null;
                    }
                }
            } catch (Throwable th) {
                o.b("WindVaneWebView", th.getMessage(), th);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i) {
            Handler handler;
            if (this.k) {
                return;
            }
            h hVar = this.l;
            if (hVar != null && (handler = this.m) != null) {
                handler.removeCallbacks(hVar);
            }
            String str = this.g + BridgeUtil.UNDERLINE_STR + this.f;
            a.C0164a c0164a = this.h;
            if (c0164a != null) {
                c0164a.a(true);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 1);
                jSONObject.put("id", str);
                jSONObject.put("unitid", this.g);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            o.a("WindVaneWebView", "Tempalte templete preload readyState state = ".concat(String.valueOf(i)));
            l.a().c(this.f, true);
            d dVar = this.f8152c;
            if (dVar == null || !dVar.T) {
                if (this.i.A()) {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(94, this.i.aa(), this.h);
                } else {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in rVCache ");
                }
            } else if (this.i.A()) {
                o.a("WindVaneWebView", "Tempalte put templeteCache in bidIVCache ");
                com.anythink.expressad.videocommon.a.a(287, this.i.aa(), this.h);
            } else {
                o.a("WindVaneWebView", "Tempalte put templeteCache in iVCache ");
            }
            try {
                o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load SUCCESS ");
                if (this.f8152c != null) {
                    synchronized (this.f8152c) {
                        o.d("WindVaneWebView", "Tempalte adapter 341");
                        if (this.f8152c != null && this.f8152c.c()) {
                            o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load  callback success");
                            if (this.f8152c.ad != null) {
                                Message obtain = Message.obtain();
                                obtain.what = 6;
                                o.a("WindVaneWebView", "WHAT_ON_RES_LOAD_SUCCESS Template");
                                obtain.obj = this.i;
                                this.f8152c.ad.sendMessage(obtain);
                                this.f8152c.ad.removeMessages(5);
                                this.f8152c = null;
                            }
                        }
                    }
                } else {
                    o.d("WindVaneWebView", "Tempalte TempalteWindVaneWebviewClient tempalte load SUCCESS  mRewardMVVideoAdapter is null");
                }
            } catch (Throwable th) {
                o.b("WindVaneWebView", th.getMessage(), th);
            }
            this.k = true;
        }
    }

    public d(Context context, String str, String str2) {
        try {
            this.v = context.getApplicationContext();
            this.w = str2;
            this.x = str;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(WindVaneWebView windVaneWebView, String str, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            a.C0164a c0164a = new a.C0164a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(n.a().g());
            c0164a.a(windVaneWebView2);
            com.anythink.expressad.video.signal.a.j jVar = (list == null || list.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, list);
            jVar.a(this.S);
            jVar.a(str3);
            jVar.a(dVar);
            jVar.b(this.ab);
            h hVar = new h(windVaneWebView, str3, cVar, list, str2, str3, dVar, this.S, this);
            windVaneWebView2.setWebViewListener(new j(windVaneWebView, str, str3, c0164a, cVar, this, hVar, this.ad));
            windVaneWebView2.setObject(jVar);
            windVaneWebView2.loadUrl(str2);
            this.ad.postDelayed(hVar, 5000L);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            o.a(u, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.expressad.foundation.d.c cVar, String str, String str2, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String c2 = com.anythink.expressad.videocommon.b.i.a().c(str);
            Message obtain = Message.obtain();
            obtain.what = 16;
            obtain.obj = new Object[]{cVar, c2, str2, dVar, str};
            if (this.ad != null) {
                this.ad.sendMessage(obtain);
            }
        } catch (Exception e2) {
        }
    }

    static /* synthetic */ void a(d dVar, WindVaneWebView windVaneWebView, String str, com.anythink.expressad.foundation.d.c cVar, List list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar2) {
        try {
            a.C0164a c0164a = new a.C0164a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(n.a().g());
            c0164a.a(windVaneWebView2);
            com.anythink.expressad.video.signal.a.j jVar = (list == null || list.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, list);
            jVar.a(dVar.S);
            jVar.a(str3);
            jVar.a(dVar2);
            jVar.b(dVar.ab);
            h hVar = new h(windVaneWebView, str3, cVar, list, str2, str3, dVar2, dVar.S, dVar);
            windVaneWebView2.setWebViewListener(new j(windVaneWebView, str, str3, c0164a, cVar, dVar, hVar, dVar.ad));
            windVaneWebView2.setObject(jVar);
            windVaneWebView2.loadUrl(str2);
            dVar.ad.postDelayed(hVar, 5000L);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            o.a(u, th.getMessage());
        }
    }

    static /* synthetic */ void a(d dVar, String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar2) {
        try {
            a.C0164a c0164a = new a.C0164a();
            WindVaneWebView windVaneWebView = new WindVaneWebView(n.a().g());
            c0164a.a(windVaneWebView);
            com.anythink.expressad.video.bt.a.c.a();
            String b2 = com.anythink.expressad.video.bt.a.c.b();
            c0164a.a(b2);
            com.anythink.expressad.video.signal.a.j jVar = (dVar.Z == null || dVar.Z.J == null || dVar.Z.J.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, dVar.Z.J);
            jVar.a(dVar.S);
            jVar.a(str3);
            jVar.c(b2);
            jVar.a(dVar2);
            jVar.b(dVar.ab);
            g gVar = new g(str3, cVar, str2, str3, dVar2, dVar.S, dVar);
            windVaneWebView.setWebViewListener(new a(str, str3, c0164a, cVar, dVar, gVar, dVar.ad));
            windVaneWebView.setObject(jVar);
            windVaneWebView.loadUrl(str2);
            dVar.ad.postDelayed(gVar, 5000L);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            o.a(u, th.getMessage());
        }
    }

    static /* synthetic */ void a(d dVar, String str, String str2) {
        try {
            o.d(u, "====delCampaignFromDownLoadCampaignListByUrld");
            if (dVar.R == null || TextUtils.isEmpty(str2)) {
                if (dVar.G != null) {
                    if (dVar.ad != null) {
                        dVar.ad.removeMessages(5);
                    }
                    o.d(u, "====del campaign and callback failed");
                    dVar.b(str);
                    dVar.G.a(str);
                    return;
                }
                return;
            }
            Iterator<com.anythink.expressad.foundation.d.c> it = dVar.R.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.anythink.expressad.foundation.d.c next = it.next();
                if (next != null) {
                    String S = next.S();
                    if (!TextUtils.isEmpty(S) && str2.equals(S)) {
                        dVar.R.remove(next);
                        break;
                    }
                    String I = next.I();
                    if (!TextUtils.isEmpty(I) && str2.equals(I)) {
                        dVar.R.remove(next);
                        break;
                    }
                    c.C0143c M2 = next.M();
                    if (M2 != null) {
                        List<c.C0143c.a> f2 = M2.f();
                        if (f2 != null) {
                            Iterator<c.C0143c.a> it2 = f2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                c.C0143c.a next2 = it2.next();
                                if (next2 != null && next2.b != null && next2.b.contains(str2)) {
                                    dVar.R.remove(next);
                                    break;
                                }
                            }
                        }
                        String e2 = M2.e();
                        if (!TextUtils.isEmpty(e2) && str2.equals(e2)) {
                            dVar.R.remove(next);
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (dVar.G == null || dVar.R == null || dVar.R.size() != 0) {
                return;
            }
            if (dVar.ad != null) {
                dVar.ad.removeMessages(5);
            }
            o.d(u, "====del campaign and callback failed");
            dVar.b(str);
            dVar.G.a(str);
        } catch (Throwable th) {
            o.b(u, th.getMessage(), th);
            try {
                if (dVar.G != null) {
                    if (dVar.ad != null) {
                        dVar.ad.removeMessages(5);
                    }
                    o.d(u, "====del campaign and callback failed");
                    dVar.b(str);
                }
            } catch (Throwable th2) {
                o.b(u, th2.getMessage(), th2);
            }
        }
    }

    static /* synthetic */ void a(d dVar, List list) {
        boolean z;
        o.b(u, "onload 开始 更新本机已安装广告列表");
        if (dVar.v == null || list == null || list.size() == 0) {
            o.b(u, "onload 列表为空 不做更新本机已安装广告列表");
            return;
        }
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (i2 >= list.size()) {
                break;
            }
            com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) list.get(i2);
            boolean z3 = z;
            if (cVar != null) {
                z3 = z;
                if (t.a(dVar.v, cVar.ba())) {
                    z3 = true;
                }
            }
            i2++;
            z2 = z3;
        }
        if (z) {
            o.b(u, "更新安装列表");
        }
    }

    private void a(Runnable runnable) {
        this.H = runnable;
    }

    private void a(String str) {
        this.V = str;
    }

    private void a(String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            a.C0164a c0164a = new a.C0164a();
            WindVaneWebView windVaneWebView = new WindVaneWebView(n.a().g());
            c0164a.a(windVaneWebView);
            com.anythink.expressad.video.bt.a.c.a();
            String b2 = com.anythink.expressad.video.bt.a.c.b();
            c0164a.a(b2);
            com.anythink.expressad.video.signal.a.j jVar = (this.Z == null || this.Z.J == null || this.Z.J.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, this.Z.J);
            jVar.a(this.S);
            jVar.a(str3);
            jVar.c(b2);
            jVar.a(dVar);
            jVar.b(this.ab);
            g gVar = new g(str3, cVar, str2, str3, dVar, this.S, this);
            windVaneWebView.setWebViewListener(new a(str, str3, c0164a, cVar, this, gVar, this.ad));
            windVaneWebView.setObject(jVar);
            windVaneWebView.loadUrl(str2);
            this.ad.postDelayed(gVar, 5000L);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            o.a(u, th.getMessage());
        }
    }

    private void a(String str, String str2) {
        try {
            o.d(u, "====delCampaignFromDownLoadCampaignListByUrld");
            if (this.R == null || TextUtils.isEmpty(str2)) {
                if (this.G != null) {
                    if (this.ad != null) {
                        this.ad.removeMessages(5);
                    }
                    o.d(u, "====del campaign and callback failed");
                    b(str);
                    this.G.a(str);
                    return;
                }
                return;
            }
            Iterator<com.anythink.expressad.foundation.d.c> it = this.R.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.anythink.expressad.foundation.d.c next = it.next();
                if (next != null) {
                    String S = next.S();
                    if (!TextUtils.isEmpty(S) && str2.equals(S)) {
                        this.R.remove(next);
                        break;
                    }
                    String I = next.I();
                    if (!TextUtils.isEmpty(I) && str2.equals(I)) {
                        this.R.remove(next);
                        break;
                    }
                    c.C0143c M2 = next.M();
                    if (M2 != null) {
                        List<c.C0143c.a> f2 = M2.f();
                        if (f2 != null) {
                            Iterator<c.C0143c.a> it2 = f2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                c.C0143c.a next2 = it2.next();
                                if (next2 != null && next2.b != null && next2.b.contains(str2)) {
                                    this.R.remove(next);
                                    break;
                                }
                            }
                        }
                        String e2 = M2.e();
                        if (!TextUtils.isEmpty(e2) && str2.equals(e2)) {
                            this.R.remove(next);
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (this.G == null || this.R == null || this.R.size() != 0) {
                return;
            }
            if (this.ad != null) {
                this.ad.removeMessages(5);
            }
            o.d(u, "====del campaign and callback failed");
            b(str);
            this.G.a(str);
        } catch (Throwable th) {
            o.b(u, th.getMessage(), th);
            try {
                if (this.G != null) {
                    if (this.ad != null) {
                        this.ad.removeMessages(5);
                    }
                    o.d(u, "====del campaign and callback failed");
                    b(str);
                }
            } catch (Throwable th2) {
                o.b(u, th2.getMessage(), th2);
            }
        }
    }

    static /* synthetic */ void a(String str, List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        o.a("test_isReay_db", "标记缓存数据 ： " + list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) it.next();
            if (cVar.M() != null && !TextUtils.isEmpty(cVar.M().e())) {
                com.anythink.expressad.videocommon.a.b(str + BridgeUtil.UNDERLINE_STR + cVar.aZ() + BridgeUtil.UNDERLINE_STR + cVar.Z() + BridgeUtil.UNDERLINE_STR + cVar.M().e());
                com.anythink.expressad.videocommon.a.b(cVar.w(), cVar);
            }
        }
    }

    private void a(List<com.anythink.expressad.foundation.d.c> list) {
        boolean z;
        o.b(u, "onload 开始 更新本机已安装广告列表");
        if (this.v == null || list == null || list.size() == 0) {
            o.b(u, "onload 列表为空 不做更新本机已安装广告列表");
            return;
        }
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (i2 >= list.size()) {
                break;
            }
            com.anythink.expressad.foundation.d.c cVar = list.get(i2);
            boolean z3 = z;
            if (cVar != null) {
                z3 = z;
                if (t.a(this.v, cVar.ba())) {
                    z3 = true;
                }
            }
            i2++;
            z2 = z3;
        }
        if (z) {
            o.b(u, "更新安装列表");
        }
    }

    private void a(List<com.anythink.expressad.foundation.d.c> list, com.anythink.expressad.videocommon.e.d dVar) {
        if (list != null) {
            try {
                Iterator<com.anythink.expressad.foundation.d.c> it = list.iterator();
                while (it.hasNext()) {
                    com.anythink.expressad.foundation.d.c next = it.next();
                    boolean z = true;
                    boolean z2 = next != null;
                    if (next.M() == null) {
                        z = false;
                    }
                    if ((z & z2) && !TextUtils.isEmpty(next.M().e())) {
                        a(next, next.M().e(), this.w, dVar);
                    }
                    if (next != null && !TextUtils.isEmpty(next.ar())) {
                        a(next, next.ar(), this.w, dVar);
                    }
                }
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f6941a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        try {
            if (com.anythink.expressad.videocommon.a.a.a() != null) {
                com.anythink.expressad.videocommon.a.a.a();
                return com.anythink.expressad.videocommon.a.a.a(cVar);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar, String str, String str2, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            if (TextUtils.isEmpty(str) || !str.contains("zip") || this.ad == null) {
                return;
            }
            String c2 = com.anythink.expressad.videocommon.b.i.a().c(str);
            o.a(u, "寻找到的大模板： ".concat(String.valueOf(c2)));
            Message obtain = Message.obtain();
            obtain.what = 17;
            obtain.obj = new Object[]{cVar, c2, str2, dVar, str};
            this.ad.sendMessage(obtain);
        } catch (Exception e2) {
        }
    }

    private void b(com.anythink.expressad.foundation.d.d dVar) {
        try {
            this.Z = dVar;
            o.b(u, "onLoadCompaginSuccess 数据刚请求回来");
            o.b("HBOPTIMIZE", "V3 数据刚请求回来 requestId " + this.Z.f());
            if (this.Z != null && this.Z.J != null) {
                this.Z.J.size();
            }
            c(this.Z);
            this.m = this.Z.f();
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                e2.printStackTrace();
            }
            o.b(u, "onLoadCompaginSuccess 数据刚请求失败");
            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.clear();
            }
            List<com.anythink.expressad.foundation.d.c> list = this.ag;
            if (list != null) {
                list.clear();
            }
            this.p = false;
            this.q = false;
            synchronized (this.f8114c) {
                if (this.r) {
                    this.r = false;
                }
                this.t = false;
                this.s = false;
                b("exception after load success");
                r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.ad != null) {
            if (TextUtils.isEmpty(str)) {
                this.ad.sendEmptyMessage(4);
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = str;
            if (str.contains("exception")) {
                this.ad.sendMessageAtFrontOfQueue(obtain);
            } else {
                this.ad.sendMessage(obtain);
            }
        }
    }

    private static void b(String str, List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        o.a("test_isReay_db", "标记缓存数据 ： " + list.size());
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar.M() != null && !TextUtils.isEmpty(cVar.M().e())) {
                com.anythink.expressad.videocommon.a.b(str + BridgeUtil.UNDERLINE_STR + cVar.aZ() + BridgeUtil.UNDERLINE_STR + cVar.Z() + BridgeUtil.UNDERLINE_STR + cVar.M().e());
                com.anythink.expressad.videocommon.a.b(cVar.w(), cVar);
            }
        }
    }

    private void b(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar != null) {
                if (!TextUtils.isEmpty(cVar.P())) {
                    com.anythink.expressad.videocommon.b.i.a().b(cVar.P());
                }
                if (cVar.M() != null) {
                    c.C0143c M2 = cVar.M();
                    if (!TextUtils.isEmpty(M2.d())) {
                        if (M2.d().contains(".zip")) {
                            o.a(u, "下载 paused url zip");
                            com.anythink.expressad.videocommon.b.i.a().b(M2.d(), (i.a) new i(cVar, this, this.w, 313, this.I, false));
                        } else {
                            o.a(u, "下载 paused url h5");
                            com.anythink.expressad.videocommon.b.i.a().b(M2.d(), (i.a) null);
                        }
                    }
                    if (!TextUtils.isEmpty(M2.e()) && !M2.e().contains(com.anythink.expressad.foundation.d.c.d)) {
                        if (M2.e().contains(".zip")) {
                            o.a(u, "下载 template zip");
                            com.anythink.expressad.videocommon.b.i.a().b(M2.e(), (i.a) new i(cVar, this, this.w, 859, this.I, false));
                        } else {
                            o.a(u, "下载 template h5");
                            com.anythink.expressad.videocommon.b.i.a().b(M2.e(), new C0154d(this, cVar, this.w, this.I));
                        }
                    }
                }
            }
        }
    }

    private boolean b(com.anythink.expressad.foundation.d.c cVar) {
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        Iterator<com.anythink.expressad.foundation.d.c> it = this.aa.iterator();
        while (it.hasNext()) {
            if (it.next().aZ().equals(cVar.aZ())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(List<com.anythink.expressad.foundation.d.c> list, boolean z, int i2) {
        if (list == null || list.size() <= 0) {
            o.a("RewardVideoController", "数据为空");
            return false;
        }
        com.anythink.expressad.foundation.d.c cVar = list.get(0);
        if (com.anythink.expressad.videocommon.b.e.a().b(this.w, this.U, list.size(), z, i2, list)) {
            if (z) {
                if (cVar.j()) {
                    return true;
                }
                if (cVar.aB() != null && cVar.aB().size() > 0) {
                    if (cVar.aB().contains(3)) {
                        o.b(u, "Is not check big template download status");
                        return true;
                    } else if (cVar.ar().equals(cVar.I()) && cVar.aB().contains(2)) {
                        o.b(u, "Is not check big template ENDCARD download status");
                        return true;
                    }
                }
                l a2 = l.a();
                if (a2.d(this.w + BridgeUtil.UNDERLINE_STR + cVar.Z() + BridgeUtil.UNDERLINE_STR + cVar.ar())) {
                    o.a("RewardVideoController", "大模板业务，开始检查大模板预加载情况，大模板预加载成功");
                    return true;
                }
                return false;
            } else if (cVar == null || !cVar.j()) {
                if (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(1)) {
                    o.b(u, "Is not check template download status");
                    return true;
                } else if (cVar.M() == null || TextUtils.isEmpty(cVar.M().e())) {
                    o.a("RewardVideoController", "非大模板 没有 template");
                    return true;
                } else {
                    l a3 = l.a();
                    if (a3.d(this.w + BridgeUtil.UNDERLINE_STR + cVar.Z() + BridgeUtil.UNDERLINE_STR + cVar.M().e())) {
                        o.a("RewardVideoController", "非大模板业务，存在播放模板，播放模板预加载成功");
                        return true;
                    }
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private void c(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.P())) {
            com.anythink.expressad.videocommon.b.i.a().b(cVar.P());
        }
        if (cVar.M() != null) {
            c.C0143c M2 = cVar.M();
            if (!TextUtils.isEmpty(M2.d())) {
                if (M2.d().contains(".zip")) {
                    o.a(u, "下载 paused url zip");
                    com.anythink.expressad.videocommon.b.i.a().b(M2.d(), (i.a) new i(cVar, this, this.w, 313, this.I, false));
                } else {
                    o.a(u, "下载 paused url h5");
                    com.anythink.expressad.videocommon.b.i.a().b(M2.d(), (i.a) null);
                }
            }
            if (TextUtils.isEmpty(M2.e()) || M2.e().contains(com.anythink.expressad.foundation.d.c.d)) {
                return;
            }
            if (M2.e().contains(".zip")) {
                o.a(u, "下载 template zip");
                com.anythink.expressad.videocommon.b.i.a().b(M2.e(), (i.a) new i(cVar, this, this.w, 859, this.I, false));
                return;
            }
            o.a(u, "下载 template h5");
            com.anythink.expressad.videocommon.b.i.a().b(M2.e(), new C0154d(this, cVar, this.w, this.I));
        }
    }

    private void c(com.anythink.expressad.foundation.d.d dVar) {
        this.Z = dVar;
        o.a(u, "Campaign 请求成功： " + dVar.J.size() + " 条");
        this.aa = d(dVar);
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(dVar));
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            o.b(u, "onload load失败 返回的compaign 没有带视频素材");
            if (TextUtils.isEmpty(this.af)) {
                this.af = b;
            }
            b(this.af);
            return;
        }
        o.b(u, "onload load成功 size:" + this.aa.size());
        Handler handler = this.ad;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
        if (dVar != null) {
            String c2 = dVar.c();
            if (w.b(c2)) {
                o.b(u, "onload sessionId:".concat(String.valueOf(c2)));
                com.anythink.expressad.reward.b.a.b = c2;
            }
        }
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = this.aa;
        if (copyOnWriteArrayList2 != null) {
            try {
                if (copyOnWriteArrayList2.size() > 0) {
                    this.y += copyOnWriteArrayList2.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.I == null || this.y > this.I.D()) {
            o.b(u, "onload 重置offset为0");
            this.y = 0;
        }
        o.b(u, "onload 算出 下次的offset是:" + this.y);
        if (w.b(this.w)) {
            com.anythink.expressad.reward.b.a.a(this.w, this.y);
        }
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList3 = this.aa;
        if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
            o.b(u, "#######onload 把广告存在本地 size:" + this.aa.size());
        }
        final com.anythink.expressad.foundation.d.c cVar = this.aa.get(0);
        final boolean z = !TextUtils.isEmpty(cVar.ar());
        final int ap = cVar.ap();
        this.p = false;
        this.q = false;
        synchronized (this.f8114c) {
            if (this.r) {
                this.r = false;
            }
        }
        this.t = false;
        this.s = false;
        c.m.f8112a.a(this.v, z, ap, this.U, this.T ? 287 : 94, this.x, this.w, cVar.Z(), this.aa, new AnonymousClass2(z, cVar, ap), new c.i() { // from class: com.anythink.expressad.reward.a.d.3
            @Override // com.anythink.expressad.reward.a.c.i
            public final void a(final String str, String str2) {
                o.a(d.u, "template 下载失败： ");
                if (!z && d.this.G != null && d.this.ad != null) {
                    o.a(d.u, "播放模板下载失败，非大模板");
                    if (cVar.aB() == null || cVar.aB().size() <= 0 || !cVar.aB().contains(1)) {
                        d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                List unused = d.this.ag;
                                boolean unused2 = d.this.U;
                                if (d.this.ad != null) {
                                    d.this.ad.removeMessages(5);
                                }
                                if (d.this.t || d.this.G == null) {
                                    return;
                                }
                                d.this.t = true;
                                d.this.G.a("errorCode: 3202 errorMessage: temp resource download failed");
                                o.a(d.u, "播放模板下载失败，非大模板 onVideoLoadFail");
                            }
                        });
                    } else {
                        o.b(d.u, "template download fail but hit ignoreCheckRule");
                    }
                } else if (ap == 1) {
                    if (cVar.aB() != null && cVar.aB().size() > 0) {
                        if (cVar.aB().contains(3)) {
                            o.b(d.u, "tpl download fail but hit ignoreCheckRule");
                            return;
                        } else if (cVar.ar().equals(cVar.I()) && cVar.aB().contains(2)) {
                            o.b(d.u, "endcard download fail but hit ignoreCheckRule at 3203");
                            return;
                        }
                    }
                    if (d.this.G == null || d.this.ad == null) {
                        return;
                    }
                    d.this.ad.post(new Runnable() { // from class: com.anythink.expressad.reward.a.d.3.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            List unused = d.this.ag;
                            boolean unused2 = d.this.U;
                            if (d.this.ad != null) {
                                d.this.ad.removeMessages(5);
                            }
                            if (d.this.t || d.this.G == null) {
                                return;
                            }
                            d.this.t = true;
                            d.this.G.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                            o.a(d.u, "播放模板下载失败，大模板，nscpt 1 onVideoLoadFail");
                        }
                    });
                }
            }

            @Override // com.anythink.expressad.reward.a.c.i
            public final void a(String str, String str2, String str3) {
                o.a(d.u, "template 下载成功： ");
            }
        });
        if (z) {
            c.m.f8112a.a(this.v, cVar, this.x, this.w, cVar.Z(), new AnonymousClass4(cVar, z, ap));
        }
    }

    private static void c(String str) {
        if (w.b(str)) {
            o.b(u, "onload sessionId:".concat(String.valueOf(str)));
            com.anythink.expressad.reward.b.a.b = str;
        }
    }

    private void c(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            String I = cVar.I();
            if (!TextUtils.isEmpty(I) && !cVar.H()) {
                if (I.contains(".zip") && I.contains(m.b)) {
                    o.a(u, "下载 endcard zip");
                    com.anythink.expressad.videocommon.b.i.a().b(I, (i.a) new i(cVar, this, this.w, 497, this.I, TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(I))));
                } else {
                    o.a(u, "下载 endcard h5");
                    com.anythink.expressad.videocommon.b.i.a().b(I, new f(this, cVar, this.w, TextUtils.isEmpty(com.anythink.expressad.videocommon.b.j.a().b(I))));
                }
            }
        }
    }

    private CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> d(com.anythink.expressad.foundation.d.d dVar) {
        boolean z;
        FileOutputStream fileOutputStream;
        File file;
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            if (this.I != null) {
                this.I.A();
            }
            if (dVar != null && dVar.J != null && dVar.J.size() > 0) {
                ArrayList<com.anythink.expressad.foundation.d.c> arrayList = dVar.J;
                this.ag = arrayList;
                if (dVar != null && dVar.J != null && dVar.J.size() > 0) {
                    ArrayList<com.anythink.expressad.foundation.d.c> arrayList2 = dVar.J;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= arrayList2.size()) {
                            break;
                        }
                        com.anythink.expressad.foundation.d.c cVar = arrayList2.get(i3);
                        cVar.l(this.w);
                        arrayList2.set(i3, cVar);
                        i2 = i3 + 1;
                    }
                }
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= arrayList.size() || i5 >= Integer.MAX_VALUE) {
                        break;
                    }
                    com.anythink.expressad.foundation.d.c cVar2 = arrayList.get(i5);
                    if (cVar2.H()) {
                        if (!TextUtils.isEmpty(cVar2.G().trim())) {
                            if (cVar2.w() != 287 && cVar2.w() != 94) {
                                cVar2.w();
                            }
                            FileOutputStream fileOutputStream2 = null;
                            try {
                                try {
                                    String b2 = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
                                    String a2 = p.a(cVar2.G());
                                    String str = a2;
                                    if (TextUtils.isEmpty(a2)) {
                                        str = String.valueOf(System.currentTimeMillis());
                                    }
                                    File file2 = new File(b2, str.concat(".html"));
                                    fileOutputStream = new FileOutputStream(file2);
                                    try {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("<script>");
                                        com.anythink.expressad.d.b.a.a();
                                        sb.append(com.anythink.expressad.d.b.a.b());
                                        sb.append("</script>");
                                        sb.append(cVar2.G());
                                        fileOutputStream.write(sb.toString().getBytes());
                                        fileOutputStream.flush();
                                        cVar2.j(file2.getAbsolutePath());
                                        fileOutputStream.close();
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        FileOutputStream fileOutputStream3 = fileOutputStream;
                                        cVar2.j("");
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        file = new File(cVar2.G());
                                        if (file.exists()) {
                                        }
                                        b("mraid resource write fail");
                                        i4 = i5 + 1;
                                    } catch (Throwable th) {
                                        fileOutputStream2 = fileOutputStream;
                                        th = th;
                                        if (fileOutputStream2 != null) {
                                            fileOutputStream2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    fileOutputStream = null;
                                }
                                file = new File(cVar2.G());
                                if (file.exists() || !file.isFile() || !file.canRead()) {
                                    b("mraid resource write fail");
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        i4 = i5 + 1;
                    }
                    if (cVar2 != null && cVar2.O() != 99) {
                        if (e(cVar2)) {
                            if (w.a(cVar2.I()) && TextUtils.isEmpty(cVar2.G())) {
                                z = false;
                            }
                            z = true;
                        } else {
                            if (w.a(cVar2.S())) {
                                z = false;
                            }
                            z = true;
                        }
                        if (z) {
                            if (t.a(cVar2)) {
                                cVar2.i(t.a(this.v, cVar2.ba()) ? 1 : 2);
                            }
                            if (cVar2.ae() != 1 && t.a(this.v, cVar2.ba())) {
                                if (t.a(cVar2)) {
                                    copyOnWriteArrayList.add(cVar2);
                                } else {
                                    this.af = f8113a;
                                }
                            }
                            copyOnWriteArrayList.add(cVar2);
                        } else {
                            this.af = "No video campaign";
                        }
                    }
                    i4 = i5 + 1;
                }
                o.b(u, "onload 返回有以下带有视频素材的compaign：" + copyOnWriteArrayList.size());
                return copyOnWriteArrayList;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    private void d(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.ar())) {
            return;
        }
        String ar2 = cVar.ar();
        com.anythink.expressad.videocommon.b.i.a().b(ar2, (i.a) new i(cVar, this, this.w, 502, this.I, TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(ar2))));
    }

    private void d(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (!TextUtils.isEmpty(cVar.bd())) {
                com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.bd(), new c(this, cVar, this.w));
            }
            if (!TextUtils.isEmpty(cVar.be())) {
                com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new c(this, cVar, this.w));
            }
        }
    }

    private void e(com.anythink.expressad.foundation.d.d dVar) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(dVar));
    }

    private void e(List<com.anythink.expressad.foundation.d.c> list) {
        List<c.C0143c.a> f2;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (com.anythink.expressad.foundation.d.c cVar : list) {
                        if (cVar.M() != null && cVar.M().f() != null && (f2 = cVar.M().f()) != null) {
                            for (c.C0143c.a aVar : f2) {
                                if (aVar != null && aVar.b != null) {
                                    for (String str : aVar.b) {
                                        if (w.b(str)) {
                                            com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new e(this, cVar, this.w));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                if (com.anythink.expressad.a.f6941a) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static boolean e(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                return cVar.J() == 2;
            } catch (Throwable th) {
                if (com.anythink.expressad.a.f6941a) {
                    th.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    private void f(List<com.anythink.expressad.foundation.d.c> list) {
        try {
            o.b(u, "===准备下载");
            if (list == null || list.size() <= 0) {
                o.b(u, "onload 不用下载视频素材 size为0");
                return;
            }
            o.b(u, "onload 开始下载视频素材 size:" + list.size());
            this.R.clear();
            this.R.addAll(list);
            l.a().a(list);
            if (com.anythink.expressad.videocommon.b.e.a() != null) {
                com.anythink.expressad.videocommon.b.e.a().a(this.w, list, 94, new b(this, list.get(0)));
                com.anythink.expressad.videocommon.b.e.a().d(this.w);
            }
        } catch (Exception e2) {
            o.b(u, e2.getMessage(), e2);
        }
    }

    private void g() {
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.R;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        this.R.clear();
    }

    private void g(List<com.anythink.expressad.foundation.d.c> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.y += list.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (this.I == null || this.y > this.I.D()) {
            o.b(u, "onload 重置offset为0");
            this.y = 0;
        }
        o.b(u, "onload 算出 下次的offset是:" + this.y);
        if (w.b(this.w)) {
            com.anythink.expressad.reward.b.a.a(this.w, this.y);
        }
    }

    private int h() {
        return this.S;
    }

    private void h(List<com.anythink.expressad.foundation.d.c> list) {
        this.ah = list;
    }

    private static void i() {
    }

    private static void j() {
    }

    private void k() {
        Handler handler = this.ad;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    private static void l() {
    }

    private static void m() {
    }

    private static void n() {
    }

    private static void o() {
    }

    private static void p() {
    }

    private int q() {
        try {
            int a2 = w.b(this.w) ? com.anythink.expressad.reward.b.a.a(this.w) : 0;
            if (this.I != null) {
                if (a2 > this.I.D()) {
                    return 0;
                }
                return a2;
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void r() {
        try {
            if (w.b(this.w)) {
                com.anythink.expressad.reward.b.a.a(this.w, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String s() {
        try {
            return w.b(com.anythink.expressad.reward.b.a.b) ? com.anythink.expressad.reward.b.a.b : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String t() {
        return "";
    }

    private static void u() {
        try {
            if (com.anythink.expressad.foundation.g.a.f.h == null || com.anythink.expressad.foundation.g.a.f.h.size() <= 0) {
                return;
            }
            com.anythink.expressad.foundation.g.a.f.h.clear();
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                e2.printStackTrace();
            }
        }
    }

    private static void v() {
    }

    private static /* synthetic */ void w() {
    }

    private static /* synthetic */ void x() {
    }

    public final void a(int i2) {
        this.S = i2;
    }

    public final void a(int i2, int i3, int i4) {
        this.W = i2;
        this.X = i3;
        this.Y = i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [android.content.Context] */
    public final void a(Activity activity, com.anythink.expressad.video.bt.module.b.h hVar, String str, String str2, int i2, String str3, com.anythink.core.common.e.j jVar) {
        boolean z;
        try {
            this.F = hVar;
            o.b(u, "show 进来");
            if (this.v != null && !w.a(this.w)) {
                ?? r0 = this.v;
                if (activity == null || activity.isFinishing()) {
                    Log.i("anythink_BaseAdActivity", "Activity is null");
                    activity = r0;
                }
                o.b(u, "show isReady true 打开播放器页面");
                Intent intent = new Intent(activity, ATRewardVideoActivity.class);
                if (!(activity instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.putExtra(ATRewardVideoActivity.f8166a, this.w);
                intent.putExtra(com.anythink.expressad.a.y, this.x);
                intent.putExtra(ATRewardVideoActivity.f8167c, str);
                intent.putExtra(ATRewardVideoActivity.d, i2);
                intent.putExtra(ATRewardVideoActivity.e, this.T);
                intent.putExtra(ATRewardVideoActivity.f, this.U);
                intent.putExtra(ATRewardVideoActivity.l, str3);
                intent.putExtra(ATRewardVideoActivity.m, jVar);
                List<com.anythink.expressad.foundation.d.c> a2 = com.anythink.expressad.videocommon.b.e.a().a(this.w);
                StringBuilder sb = new StringBuilder("当前展示的Offer requestId");
                sb.append(a2.get(0).Z());
                o.d("HBOPTIMIZE", sb.toString());
                if (a2 == null || a2.size() <= 0) {
                    o.a(u, "可以 show 的数据： 0");
                    z = false;
                    if (this.F != null) {
                        this.F.a("load failed");
                        return;
                    }
                } else {
                    o.a(u, "可以 show 的数据： " + a2.size());
                    com.anythink.expressad.foundation.d.c cVar = a2.get(0);
                    if (cVar != null) {
                        this.n = cVar.Z();
                    }
                    z = false;
                    if (cVar != null) {
                        z = false;
                        if (!TextUtils.isEmpty(cVar.ar())) {
                            z = true;
                        }
                    }
                }
                intent.putExtra(ATRewardVideoActivity.g, z);
                if (this.T) {
                    intent.putExtra(ATRewardVideoActivity.i, this.W);
                    intent.putExtra(ATRewardVideoActivity.j, this.X);
                    intent.putExtra(ATRewardVideoActivity.k, this.Y);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.putExtra(ATRewardVideoActivity.b, str2);
                }
                e.a.f8154a.a(this.x, this.w, this.I);
                activity.startActivity(intent);
                return;
            }
            if (this.F != null) {
                this.F.a("context or unitid is null");
            }
            o.b(u, "show context munitid null");
        } catch (Exception e2) {
            e2.printStackTrace();
            com.anythink.expressad.video.bt.module.b.h hVar2 = this.F;
            if (hVar2 != null) {
                hVar2.a("show failed, exception is " + e2.getMessage());
            }
        }
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        this.z = 1;
        this.B = 8;
        this.C = true;
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        List<com.anythink.expressad.foundation.d.c> list = this.ag;
        if (list != null) {
            list.clear();
        }
        this.p = false;
        this.q = false;
        synchronized (this.f8114c) {
            if (this.r) {
                this.r = false;
            }
        }
        this.t = false;
        this.s = false;
        if (this.v == null) {
            b("Context is null");
        } else if (w.a(this.w)) {
            b("UnitId is null");
        } else if (this.I == null) {
            b("RewardUnitSetting is null");
        } else {
            try {
                if (com.anythink.expressad.foundation.g.a.f.h != null && com.anythink.expressad.foundation.g.a.f.h.size() > 0) {
                    com.anythink.expressad.foundation.g.a.f.h.clear();
                }
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f6941a) {
                    e2.printStackTrace();
                }
            }
            o.b(u, "load 开始清除过期数据");
            try {
                this.Z = dVar;
                o.b(u, "onLoadCompaginSuccess 数据刚请求回来");
                o.b("HBOPTIMIZE", "V3 数据刚请求回来 requestId " + this.Z.f());
                if (this.Z != null && this.Z.J != null) {
                    this.Z.J.size();
                }
                c(this.Z);
                this.m = this.Z.f();
            } catch (Exception e3) {
                if (com.anythink.expressad.a.f6941a) {
                    e3.printStackTrace();
                }
                o.b(u, "onLoadCompaginSuccess 数据刚请求失败");
                CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = this.aa;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.clear();
                }
                List<com.anythink.expressad.foundation.d.c> list2 = this.ag;
                if (list2 != null) {
                    list2.clear();
                }
                this.p = false;
                this.q = false;
                synchronized (this.f8114c) {
                    if (this.r) {
                        this.r = false;
                    }
                    this.t = false;
                    this.s = false;
                    b("exception after load success");
                    r();
                }
            }
        }
    }

    @Override // com.anythink.expressad.reward.a.a
    public final void a(com.anythink.expressad.reward.a.b bVar) {
        if (bVar != null) {
            o.b(u, "======set listener is not null");
        } else {
            o.b(u, "======set listener is  null");
        }
        this.G = bVar;
    }

    public final void a(com.anythink.expressad.videocommon.e.d dVar) {
        try {
            this.I = dVar;
            if (dVar == null || dVar.V() * 1000 == com.anythink.expressad.foundation.g.a.cq) {
                return;
            }
            com.anythink.expressad.foundation.g.a.cq = this.I.V() * 1000;
        } catch (Throwable th) {
            o.b(u, th.getMessage(), th);
        }
    }

    public final void a(boolean z) {
        this.T = z;
    }

    @Override // com.anythink.expressad.reward.a.a
    public final boolean a() {
        return false;
    }

    public final boolean a(List<com.anythink.expressad.foundation.d.c> list, boolean z, int i2) {
        return b(list, z, i2);
    }

    @Override // com.anythink.expressad.reward.a.a
    public final void b() {
    }

    public final void b(boolean z) {
        this.U = z;
    }

    public final String c(boolean z) {
        List<com.anythink.expressad.foundation.d.c> a2;
        com.anythink.expressad.foundation.d.c cVar;
        if (z) {
            if (TextUtils.isEmpty(this.n) && (a2 = com.anythink.expressad.videocommon.b.e.a().a(this.w)) != null && a2.size() > 0 && (cVar = a2.get(0)) != null) {
                this.n = cVar.Z();
            }
            return this.n;
        }
        return this.m;
    }

    @Override // com.anythink.expressad.reward.a.a
    public final boolean c() {
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return false;
        }
        com.anythink.expressad.foundation.d.c cVar = this.aa.get(0);
        return b(this.aa, !TextUtils.isEmpty(cVar.ar()), cVar.ap());
    }

    @Override // com.anythink.expressad.reward.a.a
    public final void d() {
    }

    public final void d(boolean z) {
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList;
        if (z || (copyOnWriteArrayList = this.aa) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        com.anythink.expressad.videocommon.a.a.a();
    }

    public final String e() {
        return this.w;
    }

    public final void e(boolean z) {
        if (z) {
            List<com.anythink.expressad.foundation.d.c> list = this.ah;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (com.anythink.expressad.foundation.d.c cVar : this.ah) {
                if (cVar != null) {
                    cVar.l(0);
                    if (cVar.M() != null && !TextUtils.isEmpty(cVar.M().e())) {
                        l a2 = l.a();
                        a2.c(this.w + BridgeUtil.UNDERLINE_STR + cVar.Z() + BridgeUtil.UNDERLINE_STR + cVar.M().e(), false);
                    }
                }
            }
            return;
        }
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<com.anythink.expressad.foundation.d.c> it = this.aa.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.d.c next = it.next();
            if (next != null) {
                next.l(0);
                if (next.M() != null && !TextUtils.isEmpty(next.M().e())) {
                    l a3 = l.a();
                    a3.c(this.w + BridgeUtil.UNDERLINE_STR + next.Z() + BridgeUtil.UNDERLINE_STR + next.M().e(), false);
                }
            }
        }
    }

    public final CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f() {
        return this.aa;
    }

    public final boolean f(boolean z) {
        if (z) {
            List<com.anythink.expressad.foundation.d.c> list = this.ah;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (com.anythink.expressad.foundation.d.c cVar : this.ah) {
                if (cVar != null) {
                    cVar.l(1);
                    if (cVar.M() != null && !TextUtils.isEmpty(cVar.M().e())) {
                        l a2 = l.a();
                        a2.c(this.w + BridgeUtil.UNDERLINE_STR + cVar.Z() + BridgeUtil.UNDERLINE_STR + cVar.M().e(), true);
                    }
                }
            }
            return true;
        }
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        Iterator<com.anythink.expressad.foundation.d.c> it = this.aa.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.d.c next = it.next();
            if (next != null) {
                next.l(1);
                if (next.M() != null && !TextUtils.isEmpty(next.M().e())) {
                    l a3 = l.a();
                    a3.c(this.w + BridgeUtil.UNDERLINE_STR + next.Z() + BridgeUtil.UNDERLINE_STR + next.M().e(), true);
                }
            }
        }
        return true;
    }
}
