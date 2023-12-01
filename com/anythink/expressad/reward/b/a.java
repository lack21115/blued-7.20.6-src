package com.anythink.expressad.reward.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.anythink.core.common.a.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import com.anythink.expressad.foundation.h.m;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.v;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.video.bt.module.b.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/b/a.class */
public class a implements g {
    private static final int A = 9;
    private static final int E = 16;
    private static final int F = 18;
    private static final int G = 17;
    private static final int H = 1001001;
    private static final int I = 1001002;

    /* renamed from: a  reason: collision with root package name */
    public static final int f5315a = 1;
    public static String b;
    private static final String i = "RewardVideoController";
    private static final int j = 8;
    private static final int z = 8;
    private int B;
    private int C;
    private int D;
    private boolean N;
    private Queue<Integer> V;
    private String W;
    private List<com.anythink.expressad.foundation.d.c> af;
    private List<com.anythink.expressad.foundation.d.c> ag;
    private Context k;
    private int l;
    private com.anythink.expressad.reward.a.d m;
    private com.anythink.expressad.videocommon.e.d n;
    private com.anythink.expressad.videocommon.e.a o;
    private volatile com.anythink.expressad.videocommon.d.a p;
    private volatile c q;
    private String r;
    private String s;
    private volatile String t;
    private String u;
    private String v;
    private static Map<String, Integer> T = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d> f5316c = new HashMap();
    private static ConcurrentHashMap<String, String> U = new ConcurrentHashMap<>();
    private int w = 0;
    private int y = 2;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean O = false;
    private ArrayList<Integer> P = new ArrayList<>(7);
    private boolean Q = false;
    private volatile boolean R = false;
    private final Object S = new Object();
    private com.anythink.expressad.foundation.c.c X = null;
    private volatile boolean Y = true;
    private volatile boolean Z = false;
    private volatile boolean aa = false;
    private volatile boolean ab = false;
    private volatile boolean ac = false;
    private volatile boolean ad = false;
    private volatile boolean ae = false;
    volatile boolean d = false;
    volatile boolean e = false;
    volatile boolean f = false;
    volatile boolean g = false;
    volatile boolean h = false;
    private Handler x = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.reward.b.a.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 8) {
                if (a.this.af == null || a.this.af.size() <= 0) {
                    return;
                }
                boolean z2 = (a.this.ag == null || a.this.ag.size() <= 0) ? false : !TextUtils.isEmpty(((com.anythink.expressad.foundation.d.c) a.this.ag.get(0)).ar());
                int ap = ((com.anythink.expressad.foundation.d.c) a.this.af.get(0)).ap();
                if (a.this.m != null && a.this.m.a(a.this.af, z2, ap)) {
                    if (a.this.q == null || !a.this.N) {
                        return;
                    }
                    c.a(a.this.q, a.this.t, a.this.s);
                } else if (a.this.q == null || !a.this.N) {
                } else {
                    com.anythink.expressad.videocommon.a.c(a.this.s);
                    com.anythink.expressad.videocommon.a.b();
                    c.a(a.this.q, "load timeout");
                }
            } else if (i2 == 9) {
                if (a.this.p == null || !a.this.N) {
                    return;
                }
                Object obj = message.obj;
                Bundle data = message.getData();
                if (data != null && data.containsKey(com.anythink.expressad.a.y)) {
                    TextUtils.isEmpty(data.getString(com.anythink.expressad.a.y));
                }
                try {
                    if (a.this.K) {
                        a.b();
                    }
                    a.this.p.b();
                } catch (Exception e) {
                    if (com.anythink.expressad.a.f4103a) {
                        e.printStackTrace();
                    }
                }
            } else if (i2 != a.I) {
                switch (i2) {
                    case 16:
                    case 18:
                        if (a.this.p == null || !a.this.N) {
                            return;
                        }
                        Object obj2 = message.obj;
                        String obj3 = obj2 instanceof String ? obj2.toString() : "";
                        com.anythink.expressad.videocommon.a.c(a.this.s);
                        com.anythink.expressad.videocommon.a.b();
                        try {
                            if (a.this.K) {
                                a.b();
                            }
                            a.this.p.a(obj3);
                            return;
                        } catch (Exception e2) {
                            if (com.anythink.expressad.a.f4103a) {
                                e2.printStackTrace();
                                return;
                            }
                            return;
                        }
                    case 17:
                        if (a.this.p == null || !a.this.N) {
                            return;
                        }
                        Object obj4 = message.obj;
                        Bundle data2 = message.getData();
                        if (data2 != null && data2.containsKey(com.anythink.expressad.a.y)) {
                            TextUtils.isEmpty(data2.getString(com.anythink.expressad.a.y));
                        }
                        try {
                            if (a.this.K) {
                                a.b();
                            }
                            a.this.p.a();
                            return;
                        } catch (Exception e3) {
                            if (com.anythink.expressad.a.f4103a) {
                                e3.printStackTrace();
                                return;
                            }
                            return;
                        }
                    default:
                        return;
                }
            } else {
                int S = a.this.n != null ? a.this.n.S() : 0;
                if (a.this.m == null) {
                    if (a.this.q != null) {
                        o.a(a.i, "load timeout task called for onVideoLoadFail by mRewardMvVideoAdapter is null exception");
                    }
                } else if (a.this.m.c()) {
                    if (a.this.q != null) {
                        o.a(a.i, "load timeout task called for onVideoLoadSuccess by isReady exception");
                        try {
                            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f = a.this.m.f();
                            if (f != null) {
                                f.size();
                            }
                        } catch (Throwable th) {
                            o.d(a.i, th.getMessage());
                        }
                        c.b(a.this.q, a.this.t, a.this.s);
                    }
                } else if (!a.this.m.f(false)) {
                    if (!a.this.m.f(true)) {
                        if (a.this.q != null) {
                            o.a(a.i, "load timeout task called for onVideoLoadFail after " + S + " s");
                        }
                    } else if (!a.this.m.c()) {
                        if (a.this.q != null) {
                            o.a(a.i, "load timeout task called for onVideoLoadFail after " + S + " s");
                        }
                        a.this.m.e(true);
                    } else if (a.this.q != null) {
                        o.a(a.i, "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState");
                        a.this.m.d(true);
                        try {
                            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f2 = a.this.m.f();
                            if (f2 != null) {
                                f2.size();
                            }
                        } catch (Throwable th2) {
                            o.d(a.i, th2.getMessage());
                        }
                        c.b(a.this.q, a.this.t, a.this.s);
                    }
                } else if (a.this.m.c()) {
                    if (a.this.q != null) {
                        o.a(a.i, "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState exception");
                        a.this.m.d(false);
                        try {
                            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f3 = a.this.m.f();
                            if (f3 != null) {
                                f3.size();
                            }
                        } catch (Throwable th3) {
                            o.d(a.i, th3.getMessage());
                        }
                        c.b(a.this.q, a.this.t, a.this.s);
                    }
                } else {
                    a.this.m.e(false);
                    if (!a.this.m.f(true)) {
                        if (a.this.q != null) {
                            o.a(a.i, "load timeout task called for onVideoLoadFail after " + S + "s exception");
                        }
                    } else if (!a.this.m.c()) {
                        if (a.this.q != null) {
                            o.a(a.i, "load timeout task called for onVideoLoadFail after " + S + "s exception");
                        }
                        a.this.m.e(true);
                    } else if (a.this.q != null) {
                        o.a(a.i, "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState exception");
                        a.this.m.d(true);
                        try {
                            CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f4 = a.this.m.f();
                            if (f4 != null) {
                                f4.size();
                            }
                        } catch (Throwable th4) {
                            o.d(a.i, th4.getMessage());
                        }
                        c.b(a.this.q, a.this.t, a.this.s);
                    }
                }
            }
        }
    };

    /* renamed from: com.anythink.expressad.reward.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/b/a$a.class */
    public final class RunnableC0084a implements Runnable {
        private com.anythink.expressad.reward.a.a b;

        /* renamed from: c  reason: collision with root package name */
        private int f5319c = 1;
        private boolean d = true;

        public RunnableC0084a(com.anythink.expressad.reward.a.a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.d(a.i, "adSource=" + this.f5319c + " CommonCancelTimeTask mIsDevCall：" + this.d);
            a.this.b("v3 is timeout");
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/b/a$b.class */
    public final class b implements com.anythink.expressad.reward.a.b {
        private com.anythink.expressad.reward.a.a b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5321c = true;
        private Runnable d;

        public b(com.anythink.expressad.reward.a.a aVar) {
            this.b = aVar;
        }

        private Runnable c() {
            return this.d;
        }

        @Override // com.anythink.expressad.reward.a.b
        public final void a() {
            if (this.d != null) {
                a.this.x.removeCallbacks(this.d);
            }
            if (a.this.q != null) {
                c.a(a.this.q, a.this.t, a.this.s);
            }
        }

        public final void a(Runnable runnable) {
            this.d = runnable;
        }

        @Override // com.anythink.expressad.reward.a.b
        public final void a(String str) {
            if (this.d != null) {
                a.this.x.removeCallbacks(this.d);
            }
            com.anythink.expressad.reward.a.a aVar = this.b;
            if (aVar != null) {
                aVar.a(null);
                this.b = null;
            }
            if (a.this.q != null) {
                c.a(a.this.q, str);
            }
        }

        @Override // com.anythink.expressad.reward.a.b
        public final void b() {
            if (this.d != null) {
                a.this.x.removeCallbacks(this.d);
            }
            if (a.this.q != null) {
                c.c(a.this.q, a.this.t, a.this.s);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/b/a$c.class */
    public final class c {
        private static final String b = "RewardVideoController_Listener";
        private static final int d = 0;
        private static final int e = 1;
        private static final int f = 2;
        private static final int g = 3;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<com.anythink.expressad.videocommon.d.a> f5323c;
        private volatile AtomicInteger h;
        private Handler i;
        private String j;
        private List<com.anythink.expressad.foundation.d.c> k;
        private boolean l;

        private c(com.anythink.expressad.videocommon.d.a aVar, Handler handler, String str) {
            this.f5323c = new WeakReference<>(aVar);
            this.h = new AtomicInteger(0);
            this.i = handler;
            this.j = str;
        }

        /* synthetic */ c(a aVar, com.anythink.expressad.videocommon.d.a aVar2, Handler handler, String str, byte b2) {
            this(aVar2, handler, str);
        }

        private int a() {
            return this.h.get();
        }

        static /* synthetic */ int a(c cVar) {
            return cVar.h.get();
        }

        private void a(int i) {
            this.h.set(i);
        }

        private void a(com.anythink.expressad.foundation.d.c cVar) {
            com.anythink.expressad.videocommon.d.a aVar;
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.a(cVar);
        }

        static /* synthetic */ void a(c cVar, String str) {
            Handler handler = cVar.i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadFail，当前状态： " + cVar.h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.f5323c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.h.get() == 1 || cVar.h.get() == 3) && cVar.i != null) {
                a.s(a.this);
                if (!a.this.ae || str.contains("resource load timeout")) {
                    a.u(a.this);
                }
                if (a.this.ab) {
                    cVar.h.set(2);
                }
                if (!a.this.ac || !a.this.ad || a.this.ab) {
                    o.a(b, "收到 onVideoLoadFail，当前状态： " + cVar.h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str + " 无需响应");
                    return;
                }
                cVar.h.set(2);
                o.d(b, "收到 onVideoLoadFail，当前状态： " + cVar.h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str + " 响应");
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 16;
                cVar.i.sendMessage(obtain);
            }
        }

        static /* synthetic */ void a(c cVar, String str, String str2) {
            Handler handler = cVar.i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadSuccess，当前状态： " + cVar.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.f5323c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.h.get() == 1 || cVar.h.get() == 3) && cVar.i != null) {
                cVar.h.set(2);
                if (a.this.ab) {
                    o.a(b, "收到 onVideoLoadSuccess，当前状态： " + cVar.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 无需响应");
                    return;
                }
                o.d(b, "收到 onVideoLoadSuccess，当前状态： " + cVar.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 响应");
                a.q(a.this);
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                cVar.i.sendMessage(obtain);
            }
        }

        private void a(String str) {
            Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadFail，当前状态： " + this.h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                a.s(a.this);
                if (!a.this.ae || str.contains("resource load timeout")) {
                    a.u(a.this);
                }
                if (a.this.ab) {
                    this.h.set(2);
                }
                if (!a.this.ac || !a.this.ad || a.this.ab) {
                    o.a(b, "收到 onVideoLoadFail，当前状态： " + this.h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str + " 无需响应");
                    return;
                }
                this.h.set(2);
                o.d(b, "收到 onVideoLoadFail，当前状态： " + this.h.get() + " hasCalledVideoLoadFail: " + a.this.ac + " " + str + " 响应");
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 16;
                this.i.sendMessage(obtain);
            }
        }

        private void a(String str, String str2) {
            o.a(b, "收到 onCampaignLoadSuccess，当前状态： " + this.h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                if (a.this.aa) {
                    o.a(b, "收到 onCampaignLoadSuccess，当前状态： " + this.h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 无需响应");
                    return;
                }
                o.d(b, "收到 onCampaignLoadSuccess，当前状态： " + this.h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 响应");
                a.o(a.this);
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                this.i.sendMessage(obtain);
            }
        }

        private void a(List<com.anythink.expressad.foundation.d.c> list) {
            this.k = list;
        }

        private void a(boolean z) {
            this.l = z;
        }

        private void a(boolean z, String str, float f2) {
            com.anythink.expressad.videocommon.d.a aVar;
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            if (a.this.K) {
                a.b();
                a.this.a();
            }
            aVar.a(z, str, f2);
        }

        private void b() {
            com.anythink.expressad.videocommon.d.a aVar;
            a.l(a.this);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.c();
        }

        static /* synthetic */ void b(c cVar) {
            cVar.h.set(1);
        }

        static /* synthetic */ void b(c cVar, String str) {
            cVar.h.set(2);
            if (cVar.i != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                cVar.i.sendMessage(obtain);
            }
        }

        static /* synthetic */ void b(c cVar, String str, String str2) {
            Handler handler = cVar.i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadSuccessForCache，当前状态： " + cVar.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.f5323c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.h.get() == 1 || cVar.h.get() == 3) && cVar.i != null) {
                if (cVar.h.get() == 1) {
                    cVar.h.set(3);
                }
                if (a.this.ab) {
                    o.a(b, "收到 onVideoLoadSuccessForCache，当前状态： " + cVar.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 无需响应");
                    return;
                }
                o.d(b, "收到 onVideoLoadSuccessForCache，当前状态： " + cVar.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 响应");
                a.q(a.this);
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                cVar.i.sendMessage(obtain);
                if (a.this.ac) {
                    cVar.h.set(2);
                }
            }
        }

        private void b(String str) {
            this.h.set(2);
            if (this.i != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                this.i.sendMessage(obtain);
            }
        }

        private void b(String str, String str2) {
            o.a(b, "收到 onCampaignLoadSuccessForCache，当前状态： " + this.h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || weakReference.get() == null || this.i == null) {
                return;
            }
            if (a.this.aa) {
                o.a(b, "收到 onCampaignLoadSuccessForCache，当前状态： " + this.h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 无需响应");
                return;
            }
            o.d(b, "收到 onCampaignLoadSuccessForCache，当前状态： " + this.h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 响应");
            a.o(a.this);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString(com.anythink.expressad.a.y, str);
            bundle.putString("unit_id", str2);
            obtain.setData(bundle);
            obtain.obj = str2;
            obtain.what = 17;
            this.i.sendMessage(obtain);
        }

        private void c() {
            com.anythink.expressad.videocommon.d.a aVar;
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.f();
        }

        static /* synthetic */ void c(c cVar, String str, String str2) {
            o.a(b, "收到 onCampaignLoadSuccess，当前状态： " + cVar.h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.f5323c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.h.get() == 1 || cVar.h.get() == 3) && cVar.i != null) {
                if (a.this.aa) {
                    o.a(b, "收到 onCampaignLoadSuccess，当前状态： " + cVar.h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 无需响应");
                    return;
                }
                o.d(b, "收到 onCampaignLoadSuccess，当前状态： " + cVar.h.get() + " hasCalledCampaignLoadSuccess: " + a.this.aa + " 响应");
                a.o(a.this);
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                cVar.i.sendMessage(obtain);
            }
        }

        private void c(String str) {
            if (this.i != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                this.i.sendMessage(obtain);
            }
        }

        private void c(String str, String str2) {
            Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadSuccess，当前状态： " + this.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                this.h.set(2);
                if (a.this.ab) {
                    o.a(b, "收到 onVideoLoadSuccess，当前状态： " + this.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 无需响应");
                    return;
                }
                o.d(b, "收到 onVideoLoadSuccess，当前状态： " + this.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 响应");
                a.q(a.this);
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                this.i.sendMessage(obtain);
            }
        }

        private void d() {
            com.anythink.expressad.videocommon.d.a aVar;
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.d();
        }

        private void d(String str) {
            o.a(b, "收到 onVideoLoadFailForCache，当前状态： " + this.h.get() + " hasCalledVideoLoadFailedForCache: " + a.this.ad + " " + str);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                a.u(a.this);
                if (str.contains("resource load timeout")) {
                    a.s(a.this);
                }
                if (!a.this.ad || !a.this.ac || a.this.ab) {
                    o.a(b, "收到 onVideoLoadFailForCache，当前状态： " + this.h.get() + " hasCalledVideoLoadFailedForCache: " + a.this.ad + " " + str + " 无需响应");
                    return;
                }
                this.h.set(2);
                o.d(b, "收到 hasCalledVideoLoadFailedForCache，当前状态： " + this.h.get() + " hasCalledVideoLoadFailedForCache: " + a.this.ad + " " + str + " 响应");
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 16;
                this.i.sendMessage(obtain);
            }
        }

        private void d(String str, String str2) {
            Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(a.I);
            }
            o.a(b, "收到 onVideoLoadSuccessForCache，当前状态： " + this.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                if (this.h.get() == 1) {
                    this.h.set(3);
                }
                if (a.this.ab) {
                    o.a(b, "收到 onVideoLoadSuccessForCache，当前状态： " + this.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 无需响应");
                    return;
                }
                o.d(b, "收到 onVideoLoadSuccessForCache，当前状态： " + this.h.get() + " hasCalledVideoLoadSuccess: " + a.this.ab + " 响应");
                a.q(a.this);
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                this.i.sendMessage(obtain);
                if (a.this.ac) {
                    this.h.set(2);
                }
            }
        }

        private void e(String str) {
            com.anythink.expressad.videocommon.d.a aVar;
            a.l(a.this);
            WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.f5323c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/reward/b/a$d.class */
    public final class d implements h {
        private a b;

        /* renamed from: c  reason: collision with root package name */
        private int f5325c;
        private Handler d;
        private int e;

        /* synthetic */ d(a aVar, a aVar2, Handler handler) {
            this(aVar2, handler, (byte) 0);
        }

        private d(a aVar, Handler handler, byte b) {
            this.e = 0;
            this.b = aVar;
            this.f5325c = 1;
            this.d = handler;
        }

        private void d() {
            a.this.P.clear();
            this.b = null;
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a() {
            a.l(a.this);
            o.a(a.i, "=====================onAdShow=====================");
            try {
                if (this.b != null) {
                    this.b.Q = true;
                    if (this.b.m != null) {
                        this.b.m.n = "";
                    }
                    if (this.b.p != null) {
                        if (a.this.K) {
                            a.b();
                        }
                        this.b.p.c();
                        this.e = 2;
                    }
                }
            } catch (Throwable th) {
                if (com.anythink.expressad.a.f4103a) {
                    th.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            o.a(a.i, "=====================onVideoAdClicked=====================");
            try {
                if (this.b == null || this.b.p == null) {
                    return;
                }
                try {
                    if (a.this.K) {
                        a.b();
                    }
                    this.b.p.a(cVar);
                } catch (Exception e) {
                    if (com.anythink.expressad.a.f4103a) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f4103a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(String str) {
            a.l(a.this);
            o.a(a.i, "=====================onShowFail=====================");
            try {
                if (this.b != null) {
                    if (a.this.K) {
                        a.b();
                    }
                    this.b.Q = false;
                    if (this.b.p != null) {
                        try {
                            if (a.this.af != null) {
                                a.this.af.size();
                            }
                        } catch (Exception e) {
                        }
                        try {
                            this.b.p.b(str);
                        } catch (Exception e2) {
                            if (com.anythink.expressad.a.f4103a) {
                                e2.printStackTrace();
                            }
                        }
                        this.e = 4;
                    }
                }
            } catch (Exception e3) {
                this.e = 0;
                if (com.anythink.expressad.a.f4103a) {
                    e3.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(boolean z, int i) {
            o.a(a.i, "=====================onAdCloseWithIVReward=====================");
            o.a(a.i, "onAdCloseWithIVReward start");
            try {
                if (this.b == null || this.b.p == null) {
                    return;
                }
                this.b.Q = false;
                try {
                    com.anythink.expressad.videocommon.d.a unused = this.b.p;
                } catch (Exception e) {
                    if (com.anythink.expressad.a.f4103a) {
                        e.printStackTrace();
                    }
                }
                o.a(a.i, "onAdCloseWithIVReward callback");
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f4103a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(boolean z, com.anythink.expressad.videocommon.c.c cVar) {
            o.a(a.i, "=====================onAdClose=====================");
            try {
                if (this.b == null || this.b.p == null) {
                    return;
                }
                com.anythink.expressad.videocommon.c.c cVar2 = cVar;
                if (cVar == null) {
                    cVar2 = com.anythink.expressad.videocommon.c.c.b(this.b.v);
                }
                if (a.this.K) {
                    a.b();
                    a.this.a();
                }
                this.b.p.a(z, cVar2.a(), cVar2.b());
                this.e = 7;
                o.a(a.i, "onAdClose start release");
                this.b.Q = false;
                a.this.P.clear();
                this.b = null;
            } catch (Exception e) {
                if (com.anythink.expressad.a.f4103a) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void b() {
            o.a(a.i, "=====================onVideoComplete=====================");
            o.a(a.i, "onVideoComplete start");
            try {
                if (this.b == null || this.b.p == null) {
                    return;
                }
                try {
                    this.b.p.d();
                } catch (Exception e) {
                    if (com.anythink.expressad.a.f4103a) {
                        e.printStackTrace();
                    }
                }
                this.e = 5;
                o.a(a.i, "onEndcardShow callback");
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f4103a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void c() {
            o.a(a.i, "=====================onEndcardShow=====================");
            o.a(a.i, "onEndcardShow start");
            try {
                if (this.b == null || this.b.p == null) {
                    return;
                }
                try {
                    this.b.p.f();
                    com.anythink.expressad.foundation.f.b.a().b("_2", 2);
                } catch (Exception e) {
                    if (com.anythink.expressad.a.f4103a) {
                        e.printStackTrace();
                    }
                }
                this.e = 6;
                o.a(a.i, "onEndcardShow callback");
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f4103a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static int a(String str) {
        Integer num;
        try {
            if (!w.b(str) || T == null || !T.containsKey(str) || (num = T.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static List<com.anythink.expressad.foundation.d.c> a(String str, List<com.anythink.expressad.foundation.d.c> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (com.anythink.expressad.foundation.d.c cVar : list) {
                if (cVar != null && str.equals(cVar.B())) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    private void a(int i2, int i3, int i4) {
        this.B = i2;
        this.C = i3;
        if (i3 == com.anythink.expressad.foundation.g.a.cu) {
            this.D = i4 < 0 ? 5 : i4;
        }
        if (this.C == com.anythink.expressad.foundation.g.a.ct) {
            this.D = i4 < 0 ? 80 : i4;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i2 == com.anythink.expressad.foundation.g.a.cr ? 0 : 1);
            int i5 = 1;
            if (i3 == com.anythink.expressad.foundation.g.a.ct) {
                i5 = 0;
            }
            jSONObject.put("ivRewardPlayValueMode", i5);
            jSONObject.put("ivRewardPlayValue", i4);
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.b.e(this.s, jSONObject.toString());
        } catch (Exception e) {
            o.d(i, "setIVRewardEnable to SP was ERROR");
        }
    }

    private void a(Activity activity, String str, j jVar) {
        Map<String, Integer> i2;
        try {
            int intValue = (this.o == null || (i2 = this.o.i()) == null || !i2.containsKey("1")) ? 0 : i2.get("1").intValue();
            Context context = this.k;
            if (v.b(context, this.t + "_1", 0) != null) {
                Context context2 = this.k;
                this.l = ((Integer) v.b(context2, this.t + "_1", 0)).intValue();
            }
            if (this.m == null) {
                i();
            }
            if (this.m != null) {
                o.d(i, "controller 819");
                if (this.m.c()) {
                    if (this.l >= intValue && intValue > 0) {
                        this.R = false;
                        return;
                    }
                    o.b(i, "invoke adapter show isReady");
                    d dVar = new d(this, this, this.x);
                    f5316c.put(this.s, dVar);
                    this.m.a(activity, dVar, str, this.r, this.y, this.u, jVar);
                    return;
                }
            }
            this.R = false;
            if (this.p != null) {
                try {
                    this.p.b("can't show because load is failed");
                } catch (Exception e) {
                    if (com.anythink.expressad.a.f4103a) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f4103a) {
                o.d(i, e2.getLocalizedMessage());
            }
            if (this.p != null) {
                try {
                    this.p.b("show exception");
                } catch (Exception e3) {
                    if (com.anythink.expressad.a.f4103a) {
                        e2.printStackTrace();
                    }
                }
            }
            this.R = false;
        }
    }

    public static void a(String str, int i2) {
        try {
            if (T == null || !w.b(str)) {
                return;
            }
            T.put(str, Integer.valueOf(i2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            Context context = this.k;
            v.a(context, "Anythink_ConfirmTitle" + this.s, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            Context context2 = this.k;
            v.a(context2, "Anythink_ConfirmContent" + this.s, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            Context context3 = this.k;
            v.a(context3, "Anythink_CancelText" + this.s, str4.trim());
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        Context context4 = this.k;
        v.a(context4, "Anythink_ConfirmText" + this.s, str3.trim());
    }

    private static void a(boolean z2, boolean z3) {
        try {
            if (f5316c != null) {
                f5316c.clear();
            }
            if (z2) {
                if (z3) {
                    com.anythink.expressad.videocommon.a.a(287);
                } else {
                    com.anythink.expressad.videocommon.a.b(287);
                }
            } else if (z3) {
                com.anythink.expressad.videocommon.a.a(94);
            } else {
                com.anythink.expressad.videocommon.a.b(94);
            }
            com.anythink.expressad.videocommon.a.a();
            com.anythink.expressad.videocommon.a.b();
        } catch (Throwable th) {
            o.d(i, "destory failed");
        }
    }

    private static void a(boolean z2, boolean z3, String str) {
        try {
            if (f5316c != null) {
                f5316c.clear();
            }
            if (z2) {
                if (z3) {
                    com.anythink.expressad.videocommon.a.a(287);
                } else {
                    com.anythink.expressad.videocommon.a.b(287);
                }
            } else if (z3) {
                com.anythink.expressad.videocommon.a.a(94);
            } else {
                com.anythink.expressad.videocommon.a.b(94);
            }
            com.anythink.expressad.videocommon.a.c(str);
            com.anythink.expressad.videocommon.a.b();
        } catch (Throwable th) {
            o.d(i, "destory failed");
        }
    }

    private com.anythink.expressad.videocommon.c.b b(int i2) {
        com.anythink.expressad.videocommon.e.d dVar = this.n;
        com.anythink.expressad.videocommon.c.b bVar = null;
        com.anythink.expressad.videocommon.c.b bVar2 = null;
        if (dVar != null) {
            int size = dVar.I().size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                bVar = bVar2;
                if (i4 >= size) {
                    break;
                }
                if (this.n.I().get(i4).a() == i2) {
                    bVar2 = this.n.I().get(i4);
                }
                i3 = i4 + 1;
            }
        }
        return bVar;
    }

    static /* synthetic */ void b() {
    }

    private void b(com.anythink.expressad.foundation.d.d dVar) {
        try {
            c(dVar);
        } catch (Exception e) {
            try {
                b("load mv api error:" + e.getMessage());
            } catch (Exception e2) {
                b(com.anythink.expressad.foundation.g.b.b.b);
                if (com.anythink.expressad.a.f4103a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.q != null) {
            this.ad = true;
            c.a(this.q, str);
        }
    }

    private static void b(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (concurrentHashMap = U) == null || concurrentHashMap.containsKey(str)) {
            return;
        }
        U.put(str, str2);
    }

    private void b(boolean z2) {
        this.K = z2;
    }

    private static void c() {
    }

    private void c(com.anythink.expressad.foundation.d.d dVar) {
        try {
            o.a(i, "开始从 SOURCE_MBAPI 请求新的 offer: 8");
            if (this.m == null || !this.s.equals(this.m.e())) {
                com.anythink.expressad.reward.a.d dVar2 = new com.anythink.expressad.reward.a.d(this.k, this.t, this.s);
                this.m = dVar2;
                dVar2.a(this.J);
                this.m.b(this.K);
            }
            if (this.J) {
                this.m.a(this.B, this.C, this.D);
            }
            this.m.a(this.y);
            this.m.a(this.n);
            RunnableC0084a runnableC0084a = new RunnableC0084a(this.m);
            b bVar = new b(this.m);
            bVar.a(runnableC0084a);
            this.m.a(bVar);
            this.m.a(dVar);
        } catch (Exception e) {
            b(e.getMessage());
        }
    }

    private void c(boolean z2) {
        this.O = z2;
    }

    private String d() {
        com.anythink.expressad.reward.a.d dVar = this.m;
        return dVar != null ? dVar.c(this.Q) : "";
    }

    private static void e() {
        m.a();
    }

    private void f() {
        try {
            List<com.anythink.expressad.videocommon.c.b> I2 = this.n.I();
            if (I2 == null || I2.size() <= 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= I2.size()) {
                    return;
                }
                com.anythink.expressad.videocommon.c.b bVar = I2.get(i3);
                Context context = this.k;
                v.a(context, this.t + "_" + bVar.a(), 0);
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean g() {
        int i2;
        try {
            List<com.anythink.expressad.videocommon.c.b> I2 = this.n.I();
            if (this.o == null) {
                this.o = com.anythink.expressad.videocommon.e.c.a().b();
            }
            Map<String, Integer> i3 = this.o.i();
            if (I2 == null || I2.size() <= 0) {
                return true;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= I2.size()) {
                    return true;
                }
                com.anythink.expressad.videocommon.c.b bVar = I2.get(i5);
                StringBuilder sb = new StringBuilder();
                sb.append(bVar.a());
                if (i3.containsKey(sb.toString())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(bVar.a());
                    i2 = i3.get(sb2.toString()).intValue();
                } else {
                    i2 = 0;
                }
                Object b2 = v.b(this.k, this.t + "_" + bVar.a(), 0);
                if ((b2 != null ? ((Integer) b2).intValue() : 0) < i2) {
                    return false;
                }
                i4 = i5 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            o.d(i, e.getMessage());
            return true;
        }
    }

    private boolean h() {
        if (this.m == null) {
            i();
        }
        com.anythink.expressad.reward.a.d dVar = this.m;
        if (dVar != null) {
            return dVar.c();
        }
        return false;
    }

    private void i() {
        com.anythink.expressad.reward.a.d dVar = new com.anythink.expressad.reward.a.d(this.k, this.t, this.s);
        this.m = dVar;
        dVar.a(this.J);
        this.m.b(this.K);
        if (this.J) {
            this.m.a(this.B, this.C, this.D);
        }
        this.m.a(this.n);
    }

    private boolean j() {
        try {
            if (this.X == null) {
                this.X = com.anythink.expressad.foundation.c.c.a(n.a().g());
                return false;
            }
            return false;
        } catch (Throwable th) {
            o.d(i, "cap check error");
            return false;
        }
    }

    static /* synthetic */ boolean l(a aVar) {
        aVar.R = false;
        return false;
    }

    static /* synthetic */ boolean o(a aVar) {
        aVar.aa = true;
        return true;
    }

    static /* synthetic */ boolean q(a aVar) {
        aVar.ab = true;
        return true;
    }

    static /* synthetic */ boolean s(a aVar) {
        aVar.ac = true;
        return true;
    }

    static /* synthetic */ boolean u(a aVar) {
        aVar.ad = true;
        return true;
    }

    public final void a() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!this.Q || (concurrentHashMap = U) == null || concurrentHashMap.containsKey(d())) {
            return;
        }
        U.remove(d());
    }

    public final void a(int i2) {
        this.y = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.app.Activity r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, com.anythink.core.common.e.j r14) {
        /*
            Method dump skipped, instructions count: 813
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.reward.b.a.a(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, com.anythink.core.common.e.j):void");
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        if (dVar == null) {
            o.d(i, com.anythink.expressad.foundation.g.b.b.f);
            c.b(this.q, com.anythink.expressad.foundation.g.b.b.f);
            return;
        }
        if (this.q == null || c.a(this.q) != 3) {
            this.Y = true;
            c.b(this.q);
        } else {
            this.Y = false;
        }
        this.N = true;
        this.x.removeMessages(H);
        this.ab = false;
        this.aa = false;
        this.ac = false;
        this.ad = false;
        com.anythink.expressad.reward.a.c.a();
        try {
            this.n = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.s, this.J);
            if (!TextUtils.isEmpty(this.t)) {
                this.n.b(this.t);
            }
            int S = this.n.S() * 1000;
            if (this.x != null) {
                o.a(i, "start load timeout for " + S + " ms");
                this.x.sendEmptyMessageDelayed(I, (long) S);
            }
            this.V = this.n.Q();
            try {
                if (g()) {
                    o.a(i, "当前 cap 全满，清除所有的 cap");
                    f();
                }
            } catch (Exception e) {
                if (com.anythink.expressad.a.f4103a) {
                    e.printStackTrace();
                }
            }
            try {
                c(dVar);
            } catch (Exception e2) {
                try {
                    b("load mv api error:" + e2.getMessage());
                } catch (Exception e3) {
                    b(com.anythink.expressad.foundation.g.b.b.b);
                    if (com.anythink.expressad.a.f4103a) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (Exception e4) {
            if (this.q != null) {
                c.a(this.q, "load exception");
            }
            if (com.anythink.expressad.a.f4103a) {
                e4.printStackTrace();
            }
        }
    }

    public final void a(com.anythink.expressad.videocommon.d.a aVar) {
        this.p = aVar;
        this.q = new c(this, aVar, this.x, this.s, (byte) 0);
    }

    public final void a(String str, String str2) {
        try {
            this.k = n.a().g();
            this.s = str2;
            this.t = str;
            this.o = com.anythink.expressad.videocommon.e.c.a().b();
            m.b();
            com.anythink.expressad.videocommon.b.m.a().b();
            com.anythink.expressad.videocommon.b.j.a().b();
            com.anythink.expressad.videocommon.e.c.a().a(this.s, this.J);
            if (this.X == null) {
                this.X = com.anythink.expressad.foundation.c.c.a(n.a().g());
            }
        } catch (Throwable th) {
            o.b(i, th.getMessage(), th);
        }
    }

    public final void a(boolean z2) {
        this.J = z2;
    }

    public boolean isReady() {
        try {
            j();
            if (this.K) {
                return false;
            }
            if (this.m == null) {
                i();
            }
            if (this.m != null) {
                return this.m.c();
            }
            return false;
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f4103a) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
