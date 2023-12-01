package com.anythink.expressad.reward.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.module.AnythinkBTLayout;
import com.anythink.expressad.video.bt.module.AnythinkBTRootLayout;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.videocommon.b.i;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8083a = "RewardCampaignsResourceManager";
    private static Map<String, a> d;
    private static final int f = 100;
    private static final int g = 200;
    private static final int h = 101;
    private static final int i = 201;
    private static final int j = 102;
    private static final int k = 202;
    private static final int l = 103;
    private static final int m = 203;
    private static final int n = 104;
    private static final int o = 204;
    private static final int p = 105;
    private static final int q = 205;
    private static final int r = 0;
    private static final int s = 1;
    private final h b;

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, List<com.anythink.expressad.foundation.d.c>> f8084c;
    private boolean e;
    private volatile List<WindVaneWebView> t;

    /* renamed from: com.anythink.expressad.reward.a.c$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$3.class */
    final class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8089a;
        final /* synthetic */ WindVaneWebView b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f8090c;
        final /* synthetic */ List d;
        final /* synthetic */ String e;
        final /* synthetic */ com.anythink.expressad.videocommon.e.d f;
        final /* synthetic */ String g;

        AnonymousClass3(boolean z, WindVaneWebView windVaneWebView, com.anythink.expressad.foundation.d.c cVar, List list, String str, com.anythink.expressad.videocommon.e.d dVar, String str2) {
            this.f8089a = z;
            this.b = windVaneWebView;
            this.f8090c = cVar;
            this.d = list;
            this.e = str;
            this.f = dVar;
            this.g = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.a("RewardCampaignsResourceManager_test", "开始预加载播放模板 55");
            c.a(this.f8089a, this.b, this.f8090c.M().e(), this.f8090c, this.d, com.anythink.expressad.videocommon.b.i.a().c(this.f8090c.M().e()), this.e, this.f, this.g, c.this.e);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f8091a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        int f8092c;
        int d;
        String e;
        String f;
        int g;
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> h;
        CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> i;

        public a(boolean z, boolean z2, int i, int i2, String str, String str2, int i3, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            this.f8091a = z;
            this.b = z2;
            this.f8092c = i;
            this.d = i2;
            this.e = str;
            this.f = str2;
            this.g = i3;
            this.h = copyOnWriteArrayList;
            this.i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$b.class */
    static final class b extends com.anythink.expressad.atsignalcommon.a.a {
        private final Handler b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f8093c;
        private final boolean d;
        private final boolean e;
        private int f;
        private String g;
        private String h;
        private String i;
        private String j;
        private a.C0164a k;
        private com.anythink.expressad.foundation.d.c l;
        private CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> m;
        private com.anythink.expressad.videocommon.e.d n;
        private final j o;
        private boolean q;
        private boolean r;
        private boolean t;
        private long u;
        private int s = 0;
        private boolean p = false;

        public b(boolean z, Handler handler, Runnable runnable, boolean z2, boolean z3, int i, String str, String str2, String str3, String str4, a.C0164a c0164a, com.anythink.expressad.foundation.d.c cVar, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, com.anythink.expressad.videocommon.e.d dVar, j jVar, long j) {
            this.b = handler;
            this.f8093c = runnable;
            this.d = z2;
            this.e = z3;
            this.f = i;
            this.g = str;
            this.i = str2;
            this.h = str3;
            this.j = str4;
            this.k = c0164a;
            this.l = cVar;
            this.m = copyOnWriteArrayList;
            this.n = dVar;
            this.o = jVar;
            this.t = z;
            this.u = j;
            o.a("RewardCampaignsResourceManager_test", "开始预加载大模板");
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final String a(String str) {
            return com.anythink.expressad.videocommon.b.i.a().c(str);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:16|(3:20|21|(3:26|(4:28|29|30|31)(2:39|(1:44)(1:43))|32))|48|49|50|51|32) */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x01cd, code lost:
            r13 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x01d1, code lost:
            if (com.anythink.expressad.a.f6941a != false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x01d4, code lost:
            com.anythink.expressad.foundation.h.o.d(com.anythink.expressad.reward.a.c.f8083a, r13.getLocalizedMessage());
         */
        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(java.lang.Object r13, java.lang.String r14) {
            /*
                Method dump skipped, instructions count: 528
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.a.c.b.a(java.lang.Object, java.lang.String):void");
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final void a(String str, int i, int i2) {
            o.a("RVWindVaneWebView", "loadAds: unitID " + str + " type " + i + " adType " + i2);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            Runnable runnable;
            super.onPageFinished(webView, str);
            o.a("RewardCampaignsResourceManager_test", "onPageFinished");
            if (this.q) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.h);
            sb.append(BridgeUtil.UNDERLINE_STR);
            sb.append(this.g);
            if (!str.contains("wfr=1")) {
                o.a("RVWindVaneWebView", "CampaignTPLWindVaneWebviewClient templete preload wfr=1 不包含 ");
                com.anythink.expressad.videocommon.b.l a2 = com.anythink.expressad.videocommon.b.l.a();
                a2.c(this.h + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.g, true);
                Handler handler = this.b;
                if (handler != null && (runnable = this.f8093c) != null) {
                    handler.removeCallbacks(runnable);
                }
                a.C0164a c0164a = this.k;
                if (c0164a != null) {
                    c0164a.a(true);
                }
                if (this.o != null) {
                    o.a(c.f8083a, "CampaignTPLWindVaneWebviewClient rewardTemplatePreLoadListener.onPreLoadSuccess ");
                    this.o.a(this.j);
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.q = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            o.a("RewardCampaignsResourceManager_test", "onReceivedError： " + i + "  " + str);
            com.anythink.expressad.videocommon.b.l a2 = com.anythink.expressad.videocommon.b.l.a();
            a2.c(this.h + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.g, false);
            if (this.o != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.h);
                sb.append(BridgeUtil.UNDERLINE_STR);
                sb.append(this.g);
                a.C0164a c0164a = this.k;
                if (c0164a != null) {
                    c0164a.a(false);
                }
                this.o.a(this.j, str);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i) {
            Runnable runnable;
            o.a("RewardCampaignsResourceManager_test", "收到大模板 readyState 回调: ".concat(String.valueOf(i)));
            if (this.r) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.h);
            sb.append(BridgeUtil.UNDERLINE_STR);
            sb.append(this.g);
            o.a("test_pre_load_tpl", "CampaignTPLWindVaneWebviewClient 开始预加载大模板资源 readyState： " + i + " isCache: " + this.p);
            if (i == 1) {
                o.a("RVWindVaneWebView", "CampaignTPLWindVaneWebviewClient templete preload readyState state = ".concat(String.valueOf(i)));
                if (this.p) {
                    com.anythink.expressad.videocommon.a.e(this.h + BridgeUtil.UNDERLINE_STR + this.j);
                } else {
                    com.anythink.expressad.videocommon.a.d(this.h + BridgeUtil.UNDERLINE_STR + this.j);
                }
                o.a("test_pre_load_tpl", "添加大模板： " + this.h + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.g);
                com.anythink.expressad.videocommon.a.a(this.h + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.g, this.k, true, this.p);
                Handler handler = this.b;
                if (handler != null && (runnable = this.f8093c) != null) {
                    handler.removeCallbacks(runnable);
                }
                com.anythink.expressad.videocommon.b.l a2 = com.anythink.expressad.videocommon.b.l.a();
                a2.c(this.h + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.g, true);
                a.C0164a c0164a = this.k;
                if (c0164a != null) {
                    c0164a.a(true);
                }
                if (this.o != null) {
                    o.a("RVWindVaneWebView", "CampaignTPLWindVaneWebviewClient rewardTemplatePreLoadListener.onPreLoadSuccess ");
                    this.o.a(this.j);
                }
            } else {
                com.anythink.expressad.videocommon.b.l a3 = com.anythink.expressad.videocommon.b.l.a();
                a3.c(this.h + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.g, false);
                a.C0164a c0164a2 = this.k;
                if (c0164a2 != null) {
                    c0164a2.a(false);
                }
                j jVar = this.o;
                if (jVar != null) {
                    jVar.a(this.j, "state 2");
                }
            }
            this.r = true;
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$c.class */
    public interface InterfaceC0150c {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList);

        void a(String str, String str2, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$d.class */
    public static final class d implements i.b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f8094a = 497;
        public static final int b = 313;

        /* renamed from: c  reason: collision with root package name */
        public static final int f8095c = 859;
        private int e;
        private final String f;
        private final String g;
        private final String h;
        private com.anythink.expressad.foundation.d.c i;
        private i j;
        private Handler k;
        private List<com.anythink.expressad.foundation.d.c> l;
        private boolean d = false;
        private final long m = System.currentTimeMillis();

        public d(int i, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar, i iVar, Handler handler, List<com.anythink.expressad.foundation.d.c> list) {
            this.e = i;
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.i = cVar;
            this.j = iVar;
            this.k = handler;
            this.l = list;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            com.anythink.expressad.videocommon.b.l.a().b(str, true);
            int i = this.e;
            if (i == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString("unit_id", this.g);
                bundle.putString(com.anythink.expressad.a.y, this.f);
                bundle.putString("request_id", this.h);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.k.sendMessage(obtain);
            } else if (i == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString("unit_id", this.g);
                bundle2.putString(com.anythink.expressad.a.y, this.f);
                bundle2.putString("request_id", this.h);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.k.sendMessage(obtain2);
                if (this.d) {
                    System.currentTimeMillis();
                }
            } else if (i != 859) {
            } else {
                Message obtain3 = Message.obtain();
                obtain3.what = 105;
                Bundle bundle3 = new Bundle();
                bundle3.putString("unit_id", this.g);
                bundle3.putString(com.anythink.expressad.a.y, this.f);
                bundle3.putString("request_id", this.h);
                obtain3.setData(bundle3);
                this.k.sendMessage(obtain3);
                i iVar = this.j;
                if (iVar != null) {
                    iVar.a(this.f, this.g, this.h);
                }
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            com.anythink.expressad.videocommon.b.l.a().b(str, false);
            int i = this.e;
            if (i == 313) {
                Message obtain = Message.obtain();
                obtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString("unit_id", this.g);
                bundle.putString(com.anythink.expressad.a.y, this.f);
                bundle.putString("request_id", this.h);
                bundle.putString("url", str);
                bundle.putString("message", str2);
                obtain.setData(bundle);
                this.k.sendMessage(obtain);
            } else if (i == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString("unit_id", this.g);
                bundle2.putString(com.anythink.expressad.a.y, this.f);
                bundle2.putString("request_id", this.h);
                bundle2.putString("url", str);
                bundle2.putString("message", str2);
                obtain2.setData(bundle2);
                this.k.sendMessage(obtain2);
                if (this.d) {
                    System.currentTimeMillis();
                }
            } else if (i != 859) {
            } else {
                Message obtain3 = Message.obtain();
                obtain3.what = 205;
                Bundle bundle3 = new Bundle();
                bundle3.putString("unit_id", this.g);
                bundle3.putString(com.anythink.expressad.a.y, this.f);
                bundle3.putString("request_id", this.h);
                bundle3.putString("message", str2);
                obtain3.setData(bundle3);
                this.k.sendMessage(obtain3);
                i iVar = this.j;
                if (iVar != null) {
                    iVar.a(this.g, this.h);
                }
            }
        }

        public final void a(boolean z) {
            this.d = z;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$e.class */
    static final class e implements com.anythink.expressad.foundation.g.d.c {

        /* renamed from: a  reason: collision with root package name */
        public static final int f8096a = 0;
        public static final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        private Handler f8097c;
        private int d;
        private String e;
        private String f;
        private String g;
        private com.anythink.expressad.foundation.d.c h;

        public e(Handler handler, int i, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar) {
            this.f8097c = handler;
            this.d = i;
            this.f = str;
            this.e = str2;
            this.g = str3;
            this.h = cVar;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            com.anythink.expressad.videocommon.b.l.a();
            com.anythink.expressad.videocommon.b.l.c(str);
            Message obtain = Message.obtain();
            obtain.what = this.d == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString("unit_id", this.e);
            bundle.putString(com.anythink.expressad.a.y, this.f);
            bundle.putString("request_id", this.g);
            obtain.setData(bundle);
            this.f8097c.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            Message obtain = Message.obtain();
            obtain.what = this.d == 0 ? 202 : 204;
            Bundle bundle = new Bundle();
            bundle.putString("unit_id", this.e);
            bundle.putString(com.anythink.expressad.a.y, this.f);
            bundle.putString("request_id", this.g);
            obtain.setData(bundle);
            this.f8097c.sendMessage(obtain);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$f.class */
    static final class f implements com.anythink.expressad.videocommon.d.b {

        /* renamed from: a  reason: collision with root package name */
        private Handler f8098a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8099c;
        private final String d;

        public f(Handler handler, String str, String str2, String str3) {
            this.f8098a = handler;
            this.f8099c = str;
            this.b = str2;
            this.d = str3;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str) {
            o.d(c.f8083a, "Video 下载成功: " + this.d);
            com.anythink.expressad.videocommon.b.l.a().a(str, true);
            Message obtain = Message.obtain();
            obtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString("unit_id", this.b);
            bundle.putString(com.anythink.expressad.a.y, this.f8099c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str);
            obtain.setData(bundle);
            this.f8098a.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str, String str2) {
            o.d(c.f8083a, "Video 下载失败： " + str + " " + this.d);
            com.anythink.expressad.videocommon.b.l.a().a(str2, false);
            Message obtain = Message.obtain();
            obtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString("unit_id", this.b);
            bundle.putString(com.anythink.expressad.a.y, this.f8099c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str2);
            bundle.putString("message", str);
            obtain.setData(bundle);
            this.f8098a.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$g.class */
    public static final class g implements i.d {

        /* renamed from: a  reason: collision with root package name */
        public static final int f8100a = 497;
        public static final int b = 859;

        /* renamed from: c  reason: collision with root package name */
        public static final int f8101c = 313;
        public static final int d = 502;
        private Context f;
        private String g;
        private String h;
        private String i;
        private com.anythink.expressad.foundation.d.c j;
        private int k;
        private Handler l;
        private i m;
        private List<com.anythink.expressad.foundation.d.c> n;
        private boolean e = false;
        private long o = System.currentTimeMillis();

        public g(Context context, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar, int i, Handler handler, i iVar, List<com.anythink.expressad.foundation.d.c> list) {
            this.f = context;
            this.h = str;
            this.g = str2;
            this.i = str3;
            this.j = cVar;
            this.k = i;
            this.l = handler;
            this.m = iVar;
            this.n = list;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            com.anythink.expressad.videocommon.b.l.a().b(str, true);
            System.currentTimeMillis();
            int i = this.k;
            if (i == 313) {
                o.a(c.f8083a, "zip pause download success");
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString("unit_id", this.g);
                bundle.putString(com.anythink.expressad.a.y, this.h);
                bundle.putString("request_id", this.i);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.l.sendMessage(obtain);
            } else if (i == 497) {
                o.a(c.f8083a, "zip endcard download success");
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString("unit_id", this.g);
                bundle2.putString(com.anythink.expressad.a.y, this.h);
                bundle2.putString("request_id", this.i);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.l.sendMessage(obtain2);
                if (this.e) {
                }
            } else if (i != 859) {
            } else {
                o.a(c.f8083a, "zip template download success");
                Message obtain3 = Message.obtain();
                obtain3.what = 103;
                Bundle bundle3 = new Bundle();
                bundle3.putString("unit_id", this.g);
                bundle3.putString(com.anythink.expressad.a.y, this.h);
                bundle3.putString("request_id", this.i);
                obtain3.setData(bundle3);
                this.l.sendMessage(obtain3);
                i iVar = this.m;
                if (iVar != null) {
                    iVar.a(this.h, this.g, this.i);
                }
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            com.anythink.expressad.videocommon.b.l.a().b(str2, false);
            System.currentTimeMillis();
            int i = this.k;
            if (i == 313) {
                o.a(c.f8083a, "zip pause download failed");
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString("unit_id", this.g);
                bundle.putString(com.anythink.expressad.a.y, this.h);
                bundle.putString("request_id", this.i);
                bundle.putString("url", str2);
                bundle.putString("message", str);
                obtain.setData(bundle);
                this.l.sendMessage(obtain);
            } else if (i == 497) {
                o.a(c.f8083a, "zip endcard download failed:  ".concat(String.valueOf(str)));
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString("unit_id", this.g);
                bundle2.putString(com.anythink.expressad.a.y, this.h);
                bundle2.putString("request_id", this.i);
                bundle2.putString("url", str2);
                bundle2.putString("message", str);
                obtain2.setData(bundle2);
                this.l.sendMessage(obtain2);
                if (this.e) {
                }
            } else if (i != 859) {
            } else {
                o.a(c.f8083a, "zip template download failed");
                Message obtain3 = Message.obtain();
                obtain3.what = 203;
                Bundle bundle3 = new Bundle();
                bundle3.putString("unit_id", this.g);
                bundle3.putString(com.anythink.expressad.a.y, this.h);
                bundle3.putString("request_id", this.i);
                bundle3.putString("url", str2);
                bundle3.putString("message", str);
                obtain3.setData(bundle3);
                this.l.sendMessage(obtain3);
                i iVar = this.m;
                if (iVar != null) {
                    iVar.a(this.g, this.i);
                }
            }
        }

        public final void a(boolean z) {
            this.e = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$h.class */
    public static final class h extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private Context f8102a;
        private InterfaceC0150c b;

        /* renamed from: c  reason: collision with root package name */
        private ConcurrentHashMap<String, InterfaceC0150c> f8103c;
        private ConcurrentHashMap<String, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c>> d;

        public h(Looper looper) {
            super(looper);
            this.f8103c = new ConcurrentHashMap<>();
            this.d = new ConcurrentHashMap<>();
        }

        public final void a(Context context) {
            this.f8102a = context;
        }

        public final void a(String str, String str2, InterfaceC0150c interfaceC0150c) {
            ConcurrentHashMap<String, InterfaceC0150c> concurrentHashMap = this.f8103c;
            concurrentHashMap.put(str + BridgeUtil.UNDERLINE_STR + str2, interfaceC0150c);
        }

        public final void a(String str, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            this.d.put(str, copyOnWriteArrayList);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z;
            String str;
            Bundle data = message.getData();
            String string = data.getString(com.anythink.expressad.a.y);
            String string2 = data.getString("unit_id");
            String string3 = data.getString("request_id");
            String str2 = string2 + BridgeUtil.UNDERLINE_STR + string3;
            a aVar = (a) c.d.get(str2);
            InterfaceC0150c interfaceC0150c = this.f8103c.get(str2);
            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.d.get(str2);
            o.a(c.f8083a, "收到 Message，开始判断");
            int i = message.what;
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    break;
                default:
                    switch (i) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (aVar == null || interfaceC0150c == null) {
                                return;
                            }
                            String string4 = data.getString("message");
                            String str3 = string4;
                            if (string4 == null) {
                                str3 = "";
                            }
                            StringBuilder sb = new StringBuilder("resource download failed ");
                            sb.append(c.b(message.what));
                            sb.append(" ");
                            sb.append(str3);
                            com.anythink.expressad.foundation.d.c cVar = null;
                            if (aVar.h != null) {
                                cVar = null;
                                if (aVar.h.size() > 0) {
                                    cVar = aVar.h.get(0);
                                }
                            }
                            try {
                                try {
                                    if (!aVar.f8091a || aVar.i == null) {
                                        try {
                                            boolean a2 = com.anythink.expressad.videocommon.b.e.a().a(aVar.e, aVar.b, aVar.d, aVar.f8091a, aVar.f8092c, copyOnWriteArrayList);
                                            o.a(c.f8083a, " failed Campaign是否下载成功： （回调）".concat(String.valueOf(a2)));
                                            if (a2) {
                                                interfaceC0150c.a(string, string2, string3, aVar.h);
                                            } else {
                                                if (cVar != null && cVar.aB() != null && cVar.aB().size() > 0) {
                                                    int i2 = message.what;
                                                    if (i2 != 200) {
                                                        if (i2 != 201) {
                                                            if (i2 != 203) {
                                                                if (i2 == 205 && cVar.aB().contains(3)) {
                                                                    return;
                                                                }
                                                            } else if (cVar.aB().contains(1)) {
                                                                return;
                                                            }
                                                        } else if (cVar.aB().contains(2)) {
                                                            return;
                                                        }
                                                    } else if (cVar.aB().contains(0)) {
                                                        return;
                                                    }
                                                }
                                                interfaceC0150c.a(string2, string3, aVar.h);
                                            }
                                            this.f8103c.remove(str2);
                                            c.d.remove(str2);
                                            this.d.remove(str2);
                                            return;
                                        } catch (Exception e) {
                                            e = e;
                                            str = "resource download failed ";
                                            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = aVar.h;
                                            new StringBuilder(str).append(e.getMessage());
                                            interfaceC0150c.a(string2, string3, copyOnWriteArrayList2);
                                            return;
                                        }
                                    } else if (aVar.f8092c == 1) {
                                        if (cVar != null && cVar.aB() != null && cVar.aB().size() > 0) {
                                            int i3 = message.what;
                                            if (i3 != 200) {
                                                if (i3 != 201) {
                                                    if (i3 != 203) {
                                                        if (i3 == 205) {
                                                            if (cVar.aB().contains(3)) {
                                                                return;
                                                            }
                                                            if (aVar.h != null && aVar.h.size() > 0) {
                                                                com.anythink.expressad.foundation.d.c cVar2 = aVar.h.get(0);
                                                                if (cVar2.ar().equals(cVar2.I()) && cVar.aB().contains(2)) {
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    } else if (cVar.aB().contains(1)) {
                                                        return;
                                                    }
                                                } else if (cVar.aB().contains(2)) {
                                                    return;
                                                }
                                            } else if (cVar.aB().contains(0)) {
                                                return;
                                            }
                                        }
                                        interfaceC0150c.a(string2, string3, aVar.h);
                                        this.f8103c.remove(str2);
                                        c.d.remove(str2);
                                        this.d.remove(str2);
                                        return;
                                    } else {
                                        String string5 = data.getString("url");
                                        int i4 = message.what;
                                        if (i4 != 200) {
                                            if (i4 != 201) {
                                                if (i4 != 203) {
                                                    if (i4 == 205) {
                                                        if (cVar != null && cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(3)) {
                                                            o.b(c.f8083a, "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                            return;
                                                        }
                                                        aVar.i.clear();
                                                        c.d.remove(str2);
                                                        c.d.put(str2, aVar);
                                                    }
                                                } else if (cVar != null && cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(1)) {
                                                    o.b(c.f8083a, "Is TPL but download template fail but hit ignoreCheckRule");
                                                    return;
                                                } else {
                                                    int i5 = 0;
                                                    while (true) {
                                                        int i6 = i5;
                                                        if (i6 < aVar.i.size()) {
                                                            com.anythink.expressad.foundation.d.c cVar3 = aVar.i.get(i6);
                                                            if (cVar3.M() != null && cVar3.M().e().equals(string5)) {
                                                                aVar.i.remove(i6);
                                                            }
                                                            i5 = i6 + 1;
                                                        } else {
                                                            c.d.remove(str2);
                                                            c.d.put(str2, aVar);
                                                        }
                                                    }
                                                }
                                            } else if (cVar != null && cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(2)) {
                                                o.b(c.f8083a, "Is TPL but download endcard fail but hit ignoreCheckRule");
                                                return;
                                            } else {
                                                int i7 = 0;
                                                while (true) {
                                                    int i8 = i7;
                                                    if (i8 < aVar.i.size()) {
                                                        com.anythink.expressad.foundation.d.c cVar4 = aVar.i.get(i8);
                                                        if (cVar4.M() != null && cVar4.M().d().equals(string5)) {
                                                            aVar.i.remove(i8);
                                                        }
                                                        if (!TextUtils.isEmpty(cVar4.I()) && cVar4.I().equals(string5)) {
                                                            aVar.i.remove(i8);
                                                        }
                                                        i7 = i8 + 1;
                                                    } else {
                                                        c.d.remove(str2);
                                                        c.d.put(str2, aVar);
                                                    }
                                                }
                                            }
                                        } else if (cVar != null && cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(0)) {
                                            o.b(c.f8083a, "Is TPL but  video download fail but hit ignoreCheckRule");
                                            return;
                                        } else {
                                            int i9 = 0;
                                            while (true) {
                                                int i10 = i9;
                                                if (i10 < aVar.i.size()) {
                                                    if (aVar.i.get(i10).S().equals(string5)) {
                                                        aVar.i.remove(i10);
                                                    }
                                                    i9 = i10 + 1;
                                                } else {
                                                    c.d.remove(str2);
                                                    c.d.put(str2, aVar);
                                                }
                                            }
                                        }
                                        boolean a3 = com.anythink.expressad.videocommon.b.e.a().a(aVar.e, aVar.b, aVar.d, aVar.f8091a, aVar.f8092c, copyOnWriteArrayList);
                                        o.a(c.f8083a, " failed Campaign是否下载成功：(回调) ".concat(String.valueOf(a3)));
                                        if (a3) {
                                            interfaceC0150c.a(string, string2, string3, aVar.h);
                                            this.f8103c.remove(str2);
                                            c.d.remove(str2);
                                            this.d.remove(str2);
                                            return;
                                        } else if (aVar.i.size() == 0) {
                                            interfaceC0150c.a(string2, string3, aVar.h);
                                            this.f8103c.remove(str2);
                                            c.d.remove(str2);
                                            this.d.remove(str2);
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str = "resource download failed ";
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str = "resource download failed ";
                            }
                            break;
                        case 202:
                        case 204:
                            break;
                        default:
                            return;
                    }
            }
            if (aVar == null || interfaceC0150c == null) {
                return;
            }
            try {
                z = com.anythink.expressad.videocommon.b.e.a().a(aVar.e, aVar.b, aVar.d, aVar.f8091a, aVar.f8092c, copyOnWriteArrayList);
            } catch (Exception e4) {
                if (com.anythink.expressad.a.f6941a) {
                    o.d(c.f8083a, e4.getLocalizedMessage());
                }
                z = false;
            }
            o.a(c.f8083a, " success Campaign是否下载成功：(回调) ".concat(String.valueOf(z)));
            if (z) {
                interfaceC0150c.a(string, string2, string3, aVar.h);
                this.f8103c.remove(str2);
                c.d.remove(str2);
                this.d.remove(str2);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$i.class */
    public interface i {
        void a(String str, String str2);

        void a(String str, String str2, String str3);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$j.class */
    public interface j {
        void a(String str);

        void a(String str, String str2);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$k.class */
    static final class k extends com.anythink.expressad.atsignalcommon.a.b {

        /* renamed from: a  reason: collision with root package name */
        private Handler f8104a;
        private Runnable b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f8105c;
        private final boolean e;
        private String f;
        private final j g;
        private final WindVaneWebView h;
        private final String i;
        private final String j;
        private final String k;
        private final a.C0164a l;
        private final com.anythink.expressad.foundation.d.c m;
        private CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> n;
        private long o;
        private boolean p;
        private boolean q;
        private final Runnable r;
        private final Runnable s;

        public k(Handler handler, Runnable runnable, boolean z, boolean z2, final String str, final j jVar, WindVaneWebView windVaneWebView, final String str2, final String str3, final String str4, final a.C0164a c0164a, com.anythink.expressad.foundation.d.c cVar, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, long j) {
            this.f8104a = handler;
            this.b = runnable;
            this.f8105c = z;
            this.e = z2;
            this.f = str;
            this.g = jVar;
            this.h = windVaneWebView;
            this.i = str2;
            this.j = str4;
            this.k = str3;
            this.l = c0164a;
            this.m = cVar;
            this.n = copyOnWriteArrayList;
            this.o = j;
            this.s = new Runnable() { // from class: com.anythink.expressad.reward.a.c.k.1
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView a2;
                    a.C0164a c0164a2;
                    o.a("WindVaneWebView", "WebView onPageFinish timeout exception after 5s");
                    if (jVar != null && (c0164a2 = c0164a) != null) {
                        c0164a2.a(true);
                        com.anythink.expressad.videocommon.b.l a3 = com.anythink.expressad.videocommon.b.l.a();
                        a3.c(str4 + BridgeUtil.UNDERLINE_STR + str + BridgeUtil.UNDERLINE_STR + str2, true);
                        j jVar2 = jVar;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append(BridgeUtil.UNDERLINE_STR);
                        sb.append(str2);
                        jVar2.a(str);
                    }
                    a.C0164a c0164a3 = c0164a;
                    if (c0164a3 == null || (a2 = c0164a3.a()) == null) {
                        return;
                    }
                    try {
                        a2.release();
                    } catch (Exception e) {
                    }
                }
            };
            this.r = new Runnable() { // from class: com.anythink.expressad.reward.a.c.k.2
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView a2;
                    a.C0164a c0164a2;
                    o.a("WindVaneWebView", "WebView readyState timeout exception after 5s");
                    if (jVar != null && (c0164a2 = c0164a) != null) {
                        c0164a2.a(true);
                        com.anythink.expressad.videocommon.b.l a3 = com.anythink.expressad.videocommon.b.l.a();
                        a3.c(str4 + BridgeUtil.UNDERLINE_STR + str + BridgeUtil.UNDERLINE_STR + str2, true);
                        j jVar2 = jVar;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append(BridgeUtil.UNDERLINE_STR);
                        sb.append(str2);
                        jVar2.a(str);
                    }
                    a.C0164a c0164a3 = c0164a;
                    if (c0164a3 == null || (a2 = c0164a3.a()) == null) {
                        return;
                    }
                    try {
                        a2.release();
                    } catch (Exception e) {
                    }
                }
            };
            if (handler != null) {
                handler.postDelayed(this.s, 5000L);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.onPageFinished(webView, str);
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClient preLoadTemplate onPageFinished: ");
            Handler handler2 = this.f8104a;
            if (handler2 != null && (runnable2 = this.s) != null) {
                handler2.removeCallbacks(runnable2);
            }
            if (this.p) {
                return;
            }
            if (str.contains("wfr=1")) {
                Handler handler3 = this.f8104a;
                if (handler3 != null && (runnable = this.r) != null) {
                    handler3.postDelayed(runnable, 5000L);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(this.j);
                sb.append(BridgeUtil.UNDERLINE_STR);
                sb.append(this.i);
                com.anythink.expressad.videocommon.b.l a2 = com.anythink.expressad.videocommon.b.l.a();
                a2.c(this.j + BridgeUtil.UNDERLINE_STR + this.f + BridgeUtil.UNDERLINE_STR + this.i, true);
                Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.f8104a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                a.C0164a c0164a = this.l;
                if (c0164a != null) {
                    c0164a.a(true);
                }
                if (this.f8105c) {
                    if (this.m.A()) {
                        o.a("WindVaneWebView", "TempalteWindVaneWebviewClient Tempalte put templeteCache in bidIVCache ");
                        com.anythink.expressad.videocommon.a.a(287, this.m.aa(), this.l);
                    } else {
                        o.a("WindVaneWebView", "TempalteWindVaneWebviewClient Tempalte put templeteCache in iVCache ");
                        com.anythink.expressad.videocommon.a.b(287, this.m.aa(), this.l);
                    }
                } else if (this.m.A()) {
                    o.a("WindVaneWebView", "TempalteWindVaneWebviewClient Tempalte put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(94, this.m.aa(), this.l);
                } else {
                    o.a("WindVaneWebView", "TempalteWindVaneWebviewClient Tempalte put templeteCache in rVCache ");
                    com.anythink.expressad.videocommon.a.b(94, this.m.aa(), this.l);
                }
                j jVar = this.g;
                if (jVar != null) {
                    jVar.a(this.f);
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.p = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClient preLoadTemplate onReceivedError: ".concat(String.valueOf(str)));
            com.anythink.expressad.videocommon.b.l a2 = com.anythink.expressad.videocommon.b.l.a();
            a2.c(this.j + BridgeUtil.UNDERLINE_STR + this.f + BridgeUtil.UNDERLINE_STR + this.i, false);
            Handler handler = this.f8104a;
            if (handler != null) {
                if (this.r != null) {
                    handler.removeCallbacks(this.s);
                }
                Runnable runnable = this.r;
                if (runnable != null) {
                    this.f8104a.removeCallbacks(runnable);
                }
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(this.j);
                sb.append(BridgeUtil.UNDERLINE_STR);
                sb.append(this.i);
                if (this.l != null) {
                    this.l.a(false);
                }
                if (this.g != null) {
                    this.g.a(this.f, str);
                }
            } catch (Exception e) {
                if (com.anythink.expressad.a.f6941a) {
                    o.d("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            StringBuilder sb = new StringBuilder("TempalteWindVaneWebviewClient preLoadTemplate onReceivedSslError: ");
            sb.append(sslError == null ? "" : Integer.valueOf(sslError.getPrimaryError()));
            o.a("WindVaneWebView", sb.toString());
            com.anythink.expressad.videocommon.b.l a2 = com.anythink.expressad.videocommon.b.l.a();
            a2.c(this.j + BridgeUtil.UNDERLINE_STR + this.f + BridgeUtil.UNDERLINE_STR + this.i, false);
            Handler handler = this.f8104a;
            if (handler != null) {
                if (this.r != null) {
                    handler.removeCallbacks(this.s);
                }
                Runnable runnable = this.r;
                if (runnable != null) {
                    this.f8104a.removeCallbacks(runnable);
                }
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.j);
                sb2.append(BridgeUtil.UNDERLINE_STR);
                sb2.append(this.i);
                if (this.l != null) {
                    this.l.a(false);
                }
                if (this.g != null) {
                    this.g.a(this.f, sslError == null ? "" : Integer.toString(sslError.getPrimaryError()));
                }
            } catch (Exception e) {
                if (com.anythink.expressad.a.f6941a) {
                    o.d("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.readyState(webView, i);
            Handler handler2 = this.f8104a;
            if (handler2 != null && (runnable2 = this.r) != null) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.f8104a;
            if (handler3 != null && (runnable = this.s) != null) {
                handler3.removeCallbacks(runnable);
            }
            if (this.q) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.j);
            sb.append(BridgeUtil.UNDERLINE_STR);
            sb.append(this.i);
            if (i == 1) {
                o.a("WindVaneWebView", "TempalteWindVaneWebviewClient template 预加载成功 state ：".concat(String.valueOf(i)));
                Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.f8104a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                com.anythink.expressad.videocommon.b.l a2 = com.anythink.expressad.videocommon.b.l.a();
                a2.c(this.j + BridgeUtil.UNDERLINE_STR + this.f + BridgeUtil.UNDERLINE_STR + this.i, true);
                a.C0164a c0164a = this.l;
                if (c0164a != null) {
                    c0164a.a(true);
                }
                if (this.f8105c) {
                    if (this.e) {
                        o.a("WindVaneWebView", "put templeteCache in bidIVCache ");
                        com.anythink.expressad.videocommon.a.a(287, this.m.aa(), this.l);
                    } else {
                        o.a("WindVaneWebView", "put templeteCache in iVCache ");
                        com.anythink.expressad.videocommon.a.b(287, this.m.aa(), this.l);
                    }
                } else if (this.e) {
                    o.a("WindVaneWebView", "put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(94, this.m.aa(), this.l);
                } else {
                    o.a("WindVaneWebView", "put templeteCache in rVCache ");
                    com.anythink.expressad.videocommon.a.b(94, this.m.aa(), this.l);
                }
                j jVar = this.g;
                if (jVar != null) {
                    jVar.a(this.f);
                }
            } else {
                j jVar2 = this.g;
                if (jVar2 != null) {
                    jVar2.a(this.f, "state ".concat(String.valueOf(i)));
                }
            }
            this.q = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$l.class */
    public static final class l extends com.anythink.expressad.atsignalcommon.a.b {

        /* renamed from: a  reason: collision with root package name */
        private String f8110a;
        private final boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        private final WindVaneWebView f8111c;
        private final String e;
        private final String f;
        private final a.C0164a g;
        private final com.anythink.expressad.foundation.d.c h;
        private boolean i;
        private String j;
        private boolean k;
        private boolean l;

        public l(String str, WindVaneWebView windVaneWebView, String str2, String str3, a.C0164a c0164a, com.anythink.expressad.foundation.d.c cVar, boolean z, String str4) {
            this.f8111c = windVaneWebView;
            this.e = str2;
            this.f = str3;
            this.g = c0164a;
            this.h = cVar;
            this.f8110a = str;
            this.i = z;
            this.j = str4;
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClientForTPL init");
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClientForTPL preLoadTemplate onPageFinished: ");
            if (this.k) {
                return;
            }
            if (!str.contains("wfr=1")) {
                if (this.f8111c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f8110a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "");
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f8111c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        if (com.anythink.expressad.a.f6941a) {
                            o.d("WindVaneWebView", e.getLocalizedMessage());
                        }
                    }
                }
                com.anythink.expressad.videocommon.b.l.a().c(this.f + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.e, true);
                a.C0164a c0164a = this.g;
                if (c0164a != null) {
                    c0164a.a(true);
                }
                String str2 = this.f + BridgeUtil.UNDERLINE_STR + this.h.aZ() + BridgeUtil.UNDERLINE_STR + this.h.Z() + BridgeUtil.UNDERLINE_STR + this.e;
                if (this.b) {
                    if (this.h.A()) {
                        o.a("WindVaneWebView", "Tempalte put templeteCache in bidIVCache ");
                        com.anythink.expressad.videocommon.a.a(287, this.h.aa(), this.g);
                    } else {
                        o.a("WindVaneWebView", "Tempalte put templeteCache in iVCache ");
                        com.anythink.expressad.videocommon.a.a(str2, this.g, false, this.i);
                    }
                } else if (this.h.A()) {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(94, this.h.aa(), this.g);
                } else {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in rVCache ");
                    com.anythink.expressad.videocommon.a.a(str2, this.g, false, this.i);
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.k = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            o.a("WindVaneWebView", "TempalteWindVaneWebviewClientForTPL preLoadTemplate onReceivedError: ".concat(String.valueOf(str)));
            com.anythink.expressad.videocommon.b.l a2 = com.anythink.expressad.videocommon.b.l.a();
            a2.c(this.f + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.e, false);
            a.C0164a c0164a = this.g;
            if (c0164a != null) {
                c0164a.a(false);
            }
            if (this.f8111c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f8110a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f8111c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (com.anythink.expressad.a.f6941a) {
                        o.d("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i) {
            o.a("RewardCampaignsResourceManager_test", "收到大模板 播放模板 readyState 回调: ".concat(String.valueOf(i)));
            if (this.l) {
                return;
            }
            if (this.f8111c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f8110a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject2.put("error", "");
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.f8111c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (com.anythink.expressad.a.f6941a) {
                        o.d("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
            String str = this.f + BridgeUtil.UNDERLINE_STR + this.h.aZ() + BridgeUtil.UNDERLINE_STR + this.h.Z() + BridgeUtil.UNDERLINE_STR + this.e;
            if (i == 1) {
                com.anythink.expressad.videocommon.b.l.a().c(this.f + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.e, true);
                a.C0164a c0164a = this.g;
                if (c0164a != null) {
                    c0164a.a(true);
                }
                if (this.b) {
                    if (this.h.A()) {
                        o.a("WindVaneWebView", "Tempalte put templeteCache in bidIVCache ");
                        com.anythink.expressad.videocommon.a.a(str, this.g, false, this.i);
                    } else {
                        o.a("WindVaneWebView", "Tempalte put templeteCache in iVCache ");
                        com.anythink.expressad.videocommon.a.a(str, this.g, false, this.i);
                    }
                } else if (this.h.A()) {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in bidRVCache ");
                    com.anythink.expressad.videocommon.a.a(str, this.g, false, this.i);
                } else {
                    o.a("WindVaneWebView", "Tempalte put templeteCache in rVCache ");
                    com.anythink.expressad.videocommon.a.a(str, this.g, false, this.i);
                }
            } else {
                com.anythink.expressad.videocommon.b.l.a().c(this.f + BridgeUtil.UNDERLINE_STR + this.j + BridgeUtil.UNDERLINE_STR + this.e, false);
                a.C0164a c0164a2 = this.g;
                if (c0164a2 != null) {
                    c0164a2.a(false);
                }
            }
            this.l = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/a/c$m.class */
    public static final class m {

        /* renamed from: a  reason: collision with root package name */
        private static final c f8112a = new c((byte) 0);

        private m() {
        }
    }

    private c() {
        this.t = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        d = new HashMap();
        handlerThread.start();
        this.b = new h(handlerThread.getLooper());
        this.f8084c = new ConcurrentHashMap<>();
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public static c a() {
        return m.f8112a;
    }

    private void a(Context context, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar, String str4, i iVar, List<com.anythink.expressad.foundation.d.c> list) {
        if (TextUtils.isEmpty(str4) || cVar.H()) {
            return;
        }
        if (str4.contains(".zip") && str4.contains(com.anythink.expressad.videocommon.b.m.b)) {
            boolean isEmpty = TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(str4));
            try {
                g gVar = new g(context, str, str2, str3, cVar, 497, this.b, iVar, list);
                gVar.a(isEmpty);
                com.anythink.expressad.videocommon.b.i.a().b(str4, (i.a) gVar);
                return;
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f6941a) {
                    o.d(f8083a, e2.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean isEmpty2 = TextUtils.isEmpty(com.anythink.expressad.videocommon.b.j.a().b(str4));
        try {
            d dVar = new d(497, str, str2, str3, cVar, iVar, this.b, list);
            dVar.a(isEmpty2);
            com.anythink.expressad.videocommon.b.i.a().b(str4, dVar);
        } catch (Exception e3) {
            if (com.anythink.expressad.a.f6941a) {
                o.d(f8083a, e3.getLocalizedMessage());
            }
        }
    }

    static /* synthetic */ void a(c cVar, Context context, String str, String str2, String str3, com.anythink.expressad.foundation.d.c cVar2, String str4, i iVar, List list) {
        if (TextUtils.isEmpty(str4) || cVar2.H()) {
            return;
        }
        if (str4.contains(".zip") && str4.contains(com.anythink.expressad.videocommon.b.m.b)) {
            boolean isEmpty = TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(str4));
            try {
                g gVar = new g(context, str, str2, str3, cVar2, 497, cVar.b, iVar, list);
                gVar.a(isEmpty);
                com.anythink.expressad.videocommon.b.i.a().b(str4, (i.a) gVar);
                return;
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f6941a) {
                    o.d(f8083a, e2.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean isEmpty2 = TextUtils.isEmpty(com.anythink.expressad.videocommon.b.j.a().b(str4));
        try {
            d dVar = new d(497, str, str2, str3, cVar2, iVar, cVar.b, list);
            dVar.a(isEmpty2);
            com.anythink.expressad.videocommon.b.i.a().b(str4, dVar);
        } catch (Exception e3) {
            if (com.anythink.expressad.a.f6941a) {
                o.d(f8083a, e3.getLocalizedMessage());
            }
        }
    }

    private static /* synthetic */ void a(c cVar, boolean z, WindVaneWebView windVaneWebView, com.anythink.expressad.foundation.d.c cVar2, List list, com.anythink.expressad.videocommon.e.d dVar, String str, String str2, int i2) {
        if (windVaneWebView != null) {
            if (cVar2 == null || dVar == null || cVar2.M() == null || TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", "data is null");
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.f6941a) {
                        o.d(f8083a, e2.getLocalizedMessage());
                    }
                }
            } else if (!TextUtils.isEmpty(cVar2.M().e())) {
                if (TextUtils.isEmpty(cVar2.M().e()) || !cVar2.M().e().contains(com.anythink.expressad.foundation.d.c.d)) {
                    new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass3(z, windVaneWebView, cVar2, list, str, dVar, str2), i2 * 1000);
                } else {
                    o.a(f8083a, "getTeamplateUrl contains cmpt=1");
                }
            } else {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("id", str2);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("result", 1);
                    jSONObject4.put("error", "data is null");
                    jSONObject3.put("data", jSONObject4);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                } catch (Exception e3) {
                    if (com.anythink.expressad.a.f6941a) {
                        o.d(f8083a, e3.getLocalizedMessage());
                    }
                }
            }
        }
    }

    private void a(boolean z, WindVaneWebView windVaneWebView, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list, com.anythink.expressad.videocommon.e.d dVar, String str, String str2, int i2) {
        if (windVaneWebView != null) {
            if (cVar == null || dVar == null || cVar.M() == null || TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", "data is null");
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.f6941a) {
                        o.d(f8083a, e2.getLocalizedMessage());
                    }
                }
            } else if (!TextUtils.isEmpty(cVar.M().e())) {
                if (TextUtils.isEmpty(cVar.M().e()) || !cVar.M().e().contains(com.anythink.expressad.foundation.d.c.d)) {
                    new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass3(z, windVaneWebView, cVar, list, str, dVar, str2), i2 * 1000);
                } else {
                    o.a(f8083a, "getTeamplateUrl contains cmpt=1");
                }
            } else {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("id", str2);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("result", 1);
                    jSONObject4.put("error", "data is null");
                    jSONObject3.put("data", jSONObject4);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                } catch (Exception e3) {
                    if (com.anythink.expressad.a.f6941a) {
                        o.d(f8083a, e3.getLocalizedMessage());
                    }
                }
            }
        }
    }

    private static void a(boolean z, WindVaneWebView windVaneWebView, String str, int i2, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar, String str4, boolean z2) {
        com.anythink.expressad.video.signal.a.j jVar;
        String Z;
        try {
            a.C0164a c0164a = new a.C0164a();
            WindVaneWebView d2 = m.f8112a.d();
            WindVaneWebView windVaneWebView2 = d2;
            if (d2 == null) {
                windVaneWebView2 = new WindVaneWebView(n.a().g());
            }
            c0164a.a(windVaneWebView2);
            if (list == null || list.size() <= 0) {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
                Z = cVar.Z();
            } else {
                List<com.anythink.expressad.foundation.d.c> a2 = com.anythink.expressad.videocommon.b.e.a().a(str3);
                if (a2 != null && a2.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= list.size()) {
                            break;
                        }
                        com.anythink.expressad.foundation.d.c cVar2 = list.get(i4);
                        for (com.anythink.expressad.foundation.d.c cVar3 : a2) {
                            if (cVar3.aZ().equals(cVar2.aZ()) && cVar3.Z().equals(cVar2.Z())) {
                                cVar2.au();
                                list.set(i4, cVar2);
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, list);
                Z = list.get(0).Z();
            }
            jVar.a(i2);
            jVar.a(str3);
            jVar.c(str4);
            jVar.a(dVar);
            jVar.b(z);
            windVaneWebView2.setWebViewListener(new l(str4, windVaneWebView, str, str3, c0164a, cVar, z2, Z));
            windVaneWebView2.setObject(jVar);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(Z);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                o.d(f8083a, e2.getLocalizedMessage());
            }
        }
    }

    static /* synthetic */ void a(boolean z, WindVaneWebView windVaneWebView, String str, com.anythink.expressad.foundation.d.c cVar, List list, String str2, String str3, com.anythink.expressad.videocommon.e.d dVar, String str4, boolean z2) {
        com.anythink.expressad.video.signal.a.j jVar;
        String Z;
        try {
            a.C0164a c0164a = new a.C0164a();
            WindVaneWebView d2 = m.f8112a.d();
            WindVaneWebView windVaneWebView2 = d2;
            if (d2 == null) {
                windVaneWebView2 = new WindVaneWebView(n.a().g());
            }
            c0164a.a(windVaneWebView2);
            if (list == null || list.size() <= 0) {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
                Z = cVar.Z();
            } else {
                List<com.anythink.expressad.foundation.d.c> a2 = com.anythink.expressad.videocommon.b.e.a().a(str3);
                if (a2 != null && a2.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= list.size()) {
                            break;
                        }
                        com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) list.get(i3);
                        for (com.anythink.expressad.foundation.d.c cVar3 : a2) {
                            if (cVar3.aZ().equals(cVar2.aZ()) && cVar3.Z().equals(cVar2.Z())) {
                                cVar2.au();
                                list.set(i3, cVar2);
                            }
                        }
                        i2 = i3 + 1;
                    }
                }
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, list);
                Z = ((com.anythink.expressad.foundation.d.c) list.get(0)).Z();
            }
            jVar.a(0);
            jVar.a(str3);
            jVar.c(str4);
            jVar.a(dVar);
            jVar.b(z);
            windVaneWebView2.setWebViewListener(new l(str4, windVaneWebView, str, str3, c0164a, cVar, z2, Z));
            windVaneWebView2.setObject(jVar);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(Z);
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                o.d(f8083a, e2.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i2) {
        synchronized (c.class) {
            return i2 != 200 ? i2 != 201 ? i2 != 203 ? i2 != 205 ? "unknown" : "tpl" : "temp" : "zip/html" : "video";
        }
    }

    private static String c(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable th) {
            o.d(f8083a, "code to string is error");
            return "";
        }
    }

    private void c() {
        synchronized (this) {
        }
    }

    private WindVaneWebView d() {
        synchronized (this) {
        }
        return null;
    }

    public final void a(Context context, com.anythink.expressad.foundation.d.c cVar, final String str, final String str2, final String str3, final i iVar) {
        synchronized (this) {
            this.b.a(context);
            if (cVar != null) {
                String ar2 = cVar.ar();
                if (cVar.j()) {
                    com.anythink.expressad.videocommon.b.l.a().b(ar2, true);
                    Message obtain = Message.obtain();
                    obtain.what = 105;
                    Bundle bundle = new Bundle();
                    bundle.putString("unit_id", str2);
                    bundle.putString(com.anythink.expressad.a.y, str);
                    bundle.putString("request_id", str3);
                    bundle.putString("url", ar2);
                    obtain.setData(bundle);
                    this.b.sendMessage(obtain);
                    iVar.a(str, str2, str3);
                    return;
                }
            }
            if (cVar != null && !TextUtils.isEmpty(cVar.ar())) {
                try {
                    com.anythink.expressad.videocommon.b.i.a().b(cVar.ar(), (i.a) new i.d() { // from class: com.anythink.expressad.reward.a.c.2
                        @Override // com.anythink.expressad.videocommon.b.i.a
                        public final void a(String str4) {
                            try {
                                o.a(c.f8083a, "zip btl template download success");
                                com.anythink.expressad.videocommon.b.l.a().b(str4, true);
                                Message obtain2 = Message.obtain();
                                obtain2.what = 105;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("unit_id", str2);
                                bundle2.putString(com.anythink.expressad.a.y, str);
                                bundle2.putString("request_id", str3);
                                bundle2.putString("url", str4);
                                obtain2.setData(bundle2);
                                c.this.b.sendMessage(obtain2);
                                if (iVar != null) {
                                    iVar.a(str, str2, str3);
                                }
                            } catch (Exception e2) {
                                com.anythink.expressad.videocommon.b.l.a().b(str4, false);
                                Message obtain3 = Message.obtain();
                                obtain3.what = 205;
                                Bundle bundle3 = new Bundle();
                                bundle3.putString("unit_id", str2);
                                bundle3.putString(com.anythink.expressad.a.y, str);
                                bundle3.putString("request_id", str3);
                                bundle3.putString("url", str4);
                                obtain3.setData(bundle3);
                                c.this.b.sendMessage(obtain3);
                                i iVar2 = iVar;
                                if (iVar2 != null) {
                                    String str5 = str2;
                                    String str6 = str3;
                                    e2.getLocalizedMessage();
                                    iVar2.a(str5, str6);
                                }
                            }
                        }

                        @Override // com.anythink.expressad.videocommon.b.i.a
                        public final void a(String str4, String str5) {
                            o.a(c.f8083a, "zip btl template download failed");
                            try {
                                com.anythink.expressad.videocommon.b.l.a().b(str5, false);
                                Message obtain2 = Message.obtain();
                                obtain2.what = 205;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("unit_id", str2);
                                bundle2.putString(com.anythink.expressad.a.y, str);
                                bundle2.putString("request_id", str3);
                                bundle2.putString("url", str5);
                                bundle2.putString("message", str4);
                                obtain2.setData(bundle2);
                                c.this.b.sendMessage(obtain2);
                                if (iVar != null) {
                                    iVar.a(str2, str3);
                                }
                            } catch (Exception e2) {
                                com.anythink.expressad.videocommon.b.l.a().b(str5, false);
                                Message obtain3 = Message.obtain();
                                obtain3.what = 105;
                                Bundle bundle3 = new Bundle();
                                bundle3.putString("unit_id", str2);
                                bundle3.putString(com.anythink.expressad.a.y, str);
                                bundle3.putString("request_id", str3);
                                bundle3.putString("url", str5);
                                bundle3.putString("message", e2.getMessage());
                                obtain3.setData(bundle3);
                                c.this.b.sendMessage(obtain3);
                                i iVar2 = iVar;
                                if (iVar2 != null) {
                                    iVar2.a(str2, str3);
                                }
                                if (com.anythink.expressad.a.f6941a) {
                                    o.d(c.f8083a, e2.getLocalizedMessage());
                                }
                            }
                        }
                    });
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.f6941a) {
                        o.d(f8083a, e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final void a(final Context context, boolean z, int i2, boolean z2, final int i3, final String str, final String str2, final String str3, final CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, InterfaceC0150c interfaceC0150c, final i iVar) {
        synchronized (this) {
            String str4 = str2 + BridgeUtil.UNDERLINE_STR + str3;
            d.put(str4, new a(z, z2, i2, copyOnWriteArrayList.size(), str2, str3, i3, copyOnWriteArrayList));
            this.b.a(str2, str3, interfaceC0150c);
            this.b.a(context);
            this.b.a(str4, copyOnWriteArrayList);
            this.b.post(new Runnable() { // from class: com.anythink.expressad.reward.a.c.1
                /* JADX WARN: Removed duplicated region for block: B:107:0x03ea  */
                /* JADX WARN: Removed duplicated region for block: B:149:0x02e9 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:154:0x0074 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:51:0x01d1  */
                /* JADX WARN: Removed duplicated region for block: B:52:0x01f7  */
                /* JADX WARN: Removed duplicated region for block: B:57:0x0229  */
                /* JADX WARN: Removed duplicated region for block: B:62:0x024b  */
                /* JADX WARN: Removed duplicated region for block: B:70:0x029f  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        Method dump skipped, instructions count: 1150
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.a.c.AnonymousClass1.run():void");
                }
            });
        }
    }

    public final void a(boolean z, Handler handler, boolean z2, boolean z3, WindVaneWebView windVaneWebView, String str, int i2, com.anythink.expressad.foundation.d.c cVar, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, String str2, String str3, String str4, String str5, com.anythink.expressad.videocommon.e.d dVar, j jVar) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(BridgeUtil.UNDERLINE_STR);
            sb.append(str);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (t.e(str)) {
                    jVar.a(str5);
                    return;
                }
                a.C0164a c0164a = new a.C0164a();
                WindVaneWebView d2 = m.f8112a.d();
                if (d2 == null) {
                    try {
                        d2 = new WindVaneWebView(n.a().g());
                    } catch (Exception e2) {
                        c0164a.a(true);
                        com.anythink.expressad.videocommon.b.l a2 = com.anythink.expressad.videocommon.b.l.a();
                        a2.c(str4 + BridgeUtil.UNDERLINE_STR + str5 + BridgeUtil.UNDERLINE_STR + str, true);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str4);
                        sb2.append(BridgeUtil.UNDERLINE_STR);
                        sb2.append(str);
                        jVar.a(str5);
                        return;
                    } catch (Throwable th) {
                        c0164a.a(true);
                        com.anythink.expressad.videocommon.b.l a3 = com.anythink.expressad.videocommon.b.l.a();
                        a3.c(str4 + BridgeUtil.UNDERLINE_STR + str5 + BridgeUtil.UNDERLINE_STR + str, true);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str4);
                        sb3.append(BridgeUtil.UNDERLINE_STR);
                        sb3.append(str);
                        jVar.a(str5);
                        return;
                    }
                }
                c0164a.a(d2);
                com.anythink.expressad.video.signal.a.j jVar2 = (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, copyOnWriteArrayList);
                jVar2.a(i2);
                jVar2.a(str4);
                jVar2.a(dVar);
                jVar2.b(z);
                try {
                    d2.setWebViewListener(new k(handler, null, z2, z3, str5, jVar, windVaneWebView, str, str3, str4, c0164a, cVar, copyOnWriteArrayList, currentTimeMillis));
                    d2.setObject(jVar2);
                    d2.loadUrl(str2);
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    d2.setRid(str5);
                } catch (Exception e4) {
                    e = e4;
                    if (com.anythink.expressad.a.f6941a) {
                        o.d(f8083a, e.getLocalizedMessage());
                    }
                    jVar.a(str5, e.getLocalizedMessage());
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
    }

    public final void a(boolean z, Handler handler, boolean z2, boolean z3, String str, String str2, String str3, String str4, int i2, com.anythink.expressad.foundation.d.c cVar, CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, String str5, String str6, com.anythink.expressad.videocommon.e.d dVar, j jVar) {
        com.anythink.expressad.video.signal.a.j jVar2;
        synchronized (this) {
            this.e = false;
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(BridgeUtil.UNDERLINE_STR);
            sb.append(str4);
            this.e = false;
            if (t.e(str4)) {
                jVar.a(str);
                return;
            }
            try {
                o.a(f8083a, "开始预加载大模板资源");
                a.C0164a c0164a = new a.C0164a();
                WindVaneWebView d2 = m.f8112a.d();
                WindVaneWebView windVaneWebView = d2;
                if (d2 == null) {
                    windVaneWebView = new WindVaneWebView(n.a().g());
                }
                c0164a.a(windVaneWebView);
                com.anythink.expressad.video.bt.a.c.a();
                String b2 = com.anythink.expressad.video.bt.a.c.b();
                com.anythink.expressad.video.bt.a.c.a();
                String b3 = com.anythink.expressad.video.bt.a.c.b();
                c0164a.a(b3);
                o.a(f8083a, "preload BT wraper.setTag ".concat(String.valueOf(b3)));
                if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                    jVar2 = new com.anythink.expressad.video.signal.a.j(null, cVar);
                } else {
                    List<com.anythink.expressad.foundation.d.c> a2 = com.anythink.expressad.videocommon.b.e.a().a(str3);
                    if (a2 != null && a2.size() > 0) {
                        for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                            com.anythink.expressad.foundation.d.c cVar2 = copyOnWriteArrayList.get(i3);
                            for (com.anythink.expressad.foundation.d.c cVar3 : a2) {
                                if (cVar3.aZ().equals(cVar2.aZ()) && cVar3.Z().equals(cVar2.Z())) {
                                    o.a(f8083a, "设置 Campaign 的 isReady： true");
                                    cVar2.au();
                                    copyOnWriteArrayList.set(i3, cVar2);
                                }
                            }
                        }
                    }
                    jVar2 = new com.anythink.expressad.video.signal.a.j(null, cVar, copyOnWriteArrayList);
                }
                jVar2.a(i2);
                jVar2.a(str6);
                jVar2.c(b3);
                jVar2.d(b2);
                jVar2.p();
                jVar2.a(dVar);
                jVar2.b(z);
                try {
                    windVaneWebView.setWebViewListener(new b(z, handler, null, z2, z3, i2, str4, str2, str3, str, c0164a, cVar, copyOnWriteArrayList, dVar, jVar, currentTimeMillis));
                    windVaneWebView.setObject(jVar2);
                    windVaneWebView.loadUrl(str5);
                    try {
                        windVaneWebView.setRid(str);
                        AnythinkBTRootLayout anythinkBTRootLayout = new AnythinkBTRootLayout(n.a().g());
                        anythinkBTRootLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        anythinkBTRootLayout.setInstanceId(b2);
                        anythinkBTRootLayout.setUnitId(str3);
                        AnythinkBTLayout anythinkBTLayout = new AnythinkBTLayout(n.a().g());
                        anythinkBTLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        anythinkBTLayout.setInstanceId(b3);
                        anythinkBTLayout.setUnitId(str3);
                        anythinkBTLayout.setWebView(windVaneWebView);
                        LinkedHashMap<String, View> b4 = com.anythink.expressad.video.bt.a.c.a().b(str3, str);
                        b4.put(b3, anythinkBTLayout);
                        b4.put(b2, anythinkBTRootLayout);
                        anythinkBTRootLayout.addView(anythinkBTLayout, new FrameLayout.LayoutParams(-1, -1));
                    } catch (Exception e2) {
                        e = e2;
                        jVar.a(str, e.getMessage());
                        if (com.anythink.expressad.a.f6941a) {
                            o.d(f8083a, e.getLocalizedMessage());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
            }
        }
    }
}
