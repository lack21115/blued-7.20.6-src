package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ga;
import com.amap.api.col.p0003sl.hp;
import com.anythink.expressad.foundation.d.l;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.fn  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fn.class */
public final class fn {

    /* renamed from: a  reason: collision with root package name */
    public static ia f4954a;
    private static fn b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f4955c;
    private a d;
    private HandlerThread e = new HandlerThread("manifestThread") { // from class: com.amap.api.col.3sl.fn.1
        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            ia a2 = fd.a(false);
            fn.c(fn.f4955c);
            hp.a(fn.f4955c, a2, "11K;001;184;185", new hp.a() { // from class: com.amap.api.col.3sl.fn.1.1
                @Override // com.amap.api.col.p0003sl.hp.a
                public final void a(hp.b bVar) {
                    a aVar;
                    JSONObject optJSONObject;
                    JSONObject optJSONObject2;
                    Message message = new Message();
                    if (bVar != null) {
                        try {
                            if (bVar.g != null) {
                                message.obj = new fo(bVar.g.b, bVar.g.f5086a);
                            }
                        } catch (Throwable th) {
                            try {
                                fe.a(th, "ManifestConfig", "run");
                                if (aVar != null) {
                                    return;
                                }
                                return;
                            } finally {
                                message.what = 3;
                                if (fn.this.d != null) {
                                    fn.this.d.sendMessage(message);
                                }
                            }
                        }
                    }
                    if (bVar != null && bVar.f != null && (optJSONObject2 = bVar.f.optJSONObject("184")) != null) {
                        fn.d(optJSONObject2);
                        gi.a(fn.f4955c, "amap_search", "cache_control", optJSONObject2.toString());
                    }
                    if (bVar != null && bVar.f != null && (optJSONObject = bVar.f.optJSONObject("185")) != null) {
                        fn.c(optJSONObject);
                        gi.a(fn.f4955c, "amap_search", "parm_control", optJSONObject.toString());
                    }
                    message.what = 3;
                    if (fn.this.d != null) {
                        fn.this.d.sendMessage(message);
                    }
                }
            });
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    /* renamed from: com.amap.api.col.3sl.fn$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fn$a.class */
    final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        String f4958a;

        public a(Looper looper) {
            super(looper);
            this.f4958a = "handleMessage";
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    fo foVar = (fo) message.obj;
                    fo foVar2 = foVar;
                    if (foVar == null) {
                        foVar2 = new fo(false, false);
                    }
                    iw.a(fn.f4955c, fd.a(foVar2.a()));
                    fn.f4954a = fd.a(foVar2.a());
                } catch (Throwable th) {
                    fe.a(th, "ManifestConfig", this.f4958a);
                }
            }
        }
    }

    private fn(Context context) {
        f4955c = context;
        f4954a = fd.a(false);
        try {
            b();
            this.d = new a(Looper.getMainLooper());
            this.e.start();
        } catch (Throwable th) {
            fe.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    public static fn a(Context context) {
        if (b == null) {
            b = new fn(context);
        }
        return b;
    }

    private static ga.a a(JSONObject jSONObject, boolean z, ga.a aVar) {
        ga.a aVar2;
        boolean z2;
        boolean optBoolean;
        boolean z3;
        ga.a aVar3 = null;
        if (jSONObject != null) {
            try {
                ga.a aVar4 = new ga.a();
                try {
                    if (z) {
                        String optString = jSONObject.optString("able");
                        if (aVar != null) {
                            z3 = false;
                            if (aVar.a()) {
                            }
                            optBoolean = hp.a(optString, z3);
                        }
                        z3 = true;
                        optBoolean = hp.a(optString, z3);
                    } else {
                        if (aVar != null) {
                            z2 = false;
                            if (aVar.a()) {
                            }
                            optBoolean = jSONObject.optBoolean("able", z2);
                        }
                        z2 = true;
                        optBoolean = jSONObject.optBoolean("able", z2);
                    }
                    int optInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.b() : 86400);
                    int optInt2 = jSONObject.optInt(l.d, aVar != null ? aVar.c() : 10);
                    double optDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.d() : 0.0d);
                    aVar4.a(optBoolean);
                    aVar4.a(optInt);
                    aVar4.a(optInt2);
                    aVar4.a(optDouble);
                    return aVar4;
                } catch (Throwable th) {
                    th = th;
                    aVar2 = aVar4;
                    th.printStackTrace();
                    aVar3 = aVar2;
                    return aVar3;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar2 = null;
            }
        }
        return aVar3;
    }

    private static void a(String str, JSONObject jSONObject, ga.a aVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            ga.a().a(str, a(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    private static void b() {
        fz.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            String str = (String) gi.b(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                d(new JSONObject(str));
            }
            String str2 = (String) gi.b(context, "amap_search", "parm_control", "");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            c(new JSONObject(str2));
        } catch (Throwable th) {
            fe.a(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean a2 = hp.a(jSONObject.optString("passAreaAble"), true);
                boolean a3 = hp.a(jSONObject.optString("truckAble"), true);
                boolean a4 = hp.a(jSONObject.optString("poiPageAble"), true);
                boolean a5 = hp.a(jSONObject.optString("rideAble"), true);
                boolean a6 = hp.a(jSONObject.optString("walkAble"), true);
                boolean a7 = hp.a(jSONObject.optString("passPointAble"), true);
                boolean a8 = hp.a(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", 1200);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                gd.a().a(a2);
                gd.a().c(optInt2);
                gd.a().i(optInt8);
                gd.a().j(optInt9);
                gd.a().b(a3);
                gd.a().g(optInt6);
                gd.a().c(a4);
                gd.a().f(optInt5);
                gd.a().a(optInt);
                gd.a().b(optInt10);
                gd.a().g(a8);
                gd.a().d(a5);
                gd.a().h(optInt7);
                gd.a().e(a6);
                gd.a().d(optInt3);
                gd.a().f(a7);
                gd.a().e(optInt4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    ga.a a2 = a(jSONObject, true, (ga.a) null);
                    ga.a().a(a2);
                    if (a2.a()) {
                        a("regeo", jSONObject, a2);
                        a("geo", jSONObject, a2);
                        a("placeText", jSONObject, a2);
                        a("placeAround", jSONObject, a2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
