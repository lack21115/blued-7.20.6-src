package com.tencent.tendinsv.tool;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.Camera;
import android.media.TtmlUtils;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.tendinsv.utils.j;
import com.tencent.tendinsv.utils.r;
import com.tencent.tendinsv.utils.t;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/g.class */
public class g {
    private static volatile g b;

    /* renamed from: c  reason: collision with root package name */
    private Context f25365c;
    private String d;
    private com.tencent.tendinsv.a.e e;
    private List<e> f;
    private List<f> g;
    private long l;
    private boolean h = false;
    private int i = 10000;
    private int j = 1;
    private ExecutorService k = Executors.newSingleThreadExecutor();
    private AtomicBoolean m = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    j.a f25364a = new j.a() { // from class: com.tencent.tendinsv.tool.g.1
        @Override // com.tencent.tendinsv.utils.j.a
        public void a(Activity activity) {
            try {
                g.this.k.execute(new Runnable() { // from class: com.tencent.tendinsv.tool.g.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.l = t.b(g.this.f25365c, t.u, 100L);
                        if (g.this.e == null || g.this.e.b() <= 0) {
                            return;
                        }
                        g.this.j = (int) Math.ceil(((float) g.this.e.b()) / ((float) g.this.l));
                        g.this.c();
                        g.this.h = false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private g() {
    }

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                try {
                    if (b == null) {
                        b = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z) {
        if (com.tencent.tendinsv.b.av) {
            try {
                if (this.e == null) {
                    this.e = new com.tencent.tendinsv.a.e(this.f25365c);
                }
                if (("4".equals(eVar.l) && 4 == eVar.m) || (("4".equals(eVar.l) && eVar.q == 0) || ("3".equals(eVar.l) && eVar.q == 0 && !"1031".equals(eVar.r)))) {
                    t.a(this.f25365c, "uuid", "");
                }
                f fVar = new f();
                fVar.b = "";
                fVar.f25363c = "";
                fVar.d = "";
                fVar.e = "";
                fVar.f = "2";
                fVar.g = Build.MODEL;
                fVar.h = Build.BRAND;
                fVar.i = t.b(this.f25365c, t.V, (String) null);
                fVar.f25362a = com.tencent.tendinsv.utils.a.a(fVar.i);
                eVar.f25360a = fVar.f25362a;
                t.a(this.f25365c, "DID", fVar.f25362a);
                eVar.w = com.tencent.tendinsv.utils.a.a(eVar.f25360a + eVar.b + eVar.f25361c + eVar.d + eVar.f + eVar.l + eVar.m + eVar.r + eVar.s + eVar.t + eVar.u);
                long b2 = t.b(this.f25365c, t.s, 1L);
                long j = b2;
                if (b2 == 1) {
                    t.a(this.f25365c, t.s, System.currentTimeMillis());
                    j = System.currentTimeMillis();
                }
                long b3 = t.b(this.f25365c, t.t, 600L);
                if (b3 == -1) {
                    return;
                }
                if (b3 == 0) {
                    a(fVar, eVar);
                    return;
                }
                this.e.a(fVar);
                this.e.a(eVar, z);
                if (("4".equals(eVar.l) && 4 == eVar.m) || (("4".equals(eVar.l) && eVar.q == 0) || 11 == eVar.m || System.currentTimeMillis() > j + (b3 * 1000))) {
                    this.l = t.b(this.f25365c, t.u, 100L);
                    if (this.e.b() > 0) {
                        this.j = (int) Math.ceil(((float) this.e.b()) / ((float) this.l));
                        c();
                        this.h = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(f fVar, e eVar) {
        try {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add(eVar);
            ArrayList arrayList2 = new ArrayList();
            this.g = arrayList2;
            arrayList2.add(fVar);
            JSONArray a2 = com.tencent.tendinsv.utils.a.a(this.f);
            JSONArray b2 = com.tencent.tendinsv.utils.a.b(this.g);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray("[\"DID\", \"telcom\", \"sdkMode\", \"osVersion\", \"romVersion\", \"sdkVersion\", \"uuid\", \"ip\", \"network\", \"dbm\",\"wifidbm\", \"processName\", \"method\", \"beginTime\", \"costTime\", \"stepTime\", \"status\", \"resCode\", \"resDesc\", \"innerCode\", \"innerDesc\", \"count\", \"sid\"]");
            JSONArray jSONArray2 = new JSONArray("[\"DID\", \"IMEI\", \"IMSI\", \"ICCID\", \"MAC\", \"appPlatform\", \"device\", \"deviceName\"]");
            jSONObject.put(TtmlUtils.TAG_BODY, a2);
            jSONObject.put("bodyTitle", jSONArray);
            jSONObject.put("header", b2);
            jSONObject.put("headerTitle", jSONArray2);
            if (a2 == null || b2 == null || a2.length() == 0 || b2.length() == 0) {
                return;
            }
            a(jSONObject.toString(), false, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final boolean z, String str2) {
        this.i = t.b(this.f25365c, t.M, 10000);
        String b2 = t.b(this.f25365c, "appId", "");
        if (!com.tencent.tendinsv.utils.d.b(b2)) {
            b2 = this.d;
        }
        String b3 = t.b(this.f25365c, t.N, "0MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJaqWkyQhbQ6EbYBFaxhfblDc3wmzSV27D/CncV6b1dG9DW/9rPqKLP9TvpcxA8OTgQR/WZ1YKwtcHJurR83spkCAwEAAQ==");
        String str3 = str2;
        if (com.tencent.tendinsv.utils.d.a(str2)) {
            str3 = com.tencent.tendinsv.utils.b.a();
        }
        String a2 = h.a(this.f25365c);
        String b4 = h.b(this.f25365c);
        if (com.tencent.tendinsv.utils.d.b(b2)) {
            final String str4 = str3;
            new com.tencent.tendinsv.d.b(com.tencent.tendinsv.b.C, this.f25365c).a(com.tencent.tendinsv.d.g.a().b(b2, str3, str, a2, b4), new com.tencent.tendinsv.d.a() { // from class: com.tencent.tendinsv.tool.g.3
                @Override // com.tencent.tendinsv.d.c
                public void a(int i, String str5) {
                    try {
                        if (!g.this.h) {
                            g.this.h = true;
                            g.this.a(str, z, str4);
                        } else if (z) {
                            g.this.d();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.tencent.tendinsv.d.a
                public void a(String str5) {
                    g gVar;
                    try {
                        if (com.tencent.tendinsv.utils.d.b(str5)) {
                            if (new JSONObject(str5).optInt("retCode") == 0) {
                                if (z) {
                                    g.this.e.a(g.this.e.c());
                                    g.g(g.this);
                                    if (g.this.j > 0) {
                                        g.this.c();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } else if (!z) {
                                return;
                            } else {
                                gVar = g.this;
                            }
                        } else if (!z) {
                            return;
                        } else {
                            gVar = g.this;
                        }
                        gVar.d();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        if (z) {
                            g.this.d();
                        }
                    }
                }
            }, true, b3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            t.a(this.f25365c, t.s, System.currentTimeMillis());
            this.f = new ArrayList();
            this.f.addAll(this.e.a(String.valueOf(t.b(this.f25365c, t.u, 100L))));
            ArrayList arrayList = new ArrayList();
            this.g = arrayList;
            arrayList.addAll(this.e.a());
            JSONArray a2 = com.tencent.tendinsv.utils.a.a(this.f);
            JSONArray b2 = com.tencent.tendinsv.utils.a.b(this.g);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray("[\"DID\", \"telcom\", \"sdkMode\", \"osVersion\", \"romVersion\", \"sdkVersion\", \"uuid\", \"ip\", \"network\", \"dbm\",\"wifidbm\", \"processName\", \"method\", \"beginTime\", \"costTime\",\"stepTime\", \"status\", \"resCode\", \"resDesc\", \"innerCode\", \"innerDesc\", \"count\", \"sid\"]");
            JSONArray jSONArray2 = new JSONArray("[\"DID\", \"IMEI\", \"IMSI\", \"ICCID\", \"MAC\", \"appPlatform\", \"device\", \"deviceName\"]");
            jSONObject.put(TtmlUtils.TAG_BODY, a2);
            jSONObject.put("bodyTitle", jSONArray);
            jSONObject.put("header", b2);
            jSONObject.put("headerTitle", jSONArray2);
            if (a2 == null || b2 == null || a2.length() == 0 || b2.length() == 0) {
                return;
            }
            a(jSONObject.toString(), true, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (this.e.a(this.i)) {
                this.e.a(String.valueOf((int) (this.i * 0.1d)));
                this.e.a(this.e.c());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ int g(g gVar) {
        int i = gVar.j;
        gVar.j = i - 1;
        return i;
    }

    public void a(final int i, final int i2, final String str, final String str2, final String str3, final int i3, final int i4, final int i5, final long j, final long j2, final long j3, final boolean z, final int i6) {
        this.k.execute(new Runnable() { // from class: com.tencent.tendinsv.tool.g.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e eVar = new e();
                    eVar.b = str3;
                    eVar.f25361c = com.tencent.tendinsv.b.ap;
                    eVar.d = Build.VERSION.RELEASE;
                    String i7 = r.i();
                    if (!com.tencent.tendinsv.utils.d.b(i7)) {
                        i7 = com.tencent.tendinsv.utils.e.c();
                    }
                    eVar.e = i7;
                    eVar.f = com.tencent.tendinsv.b.ao;
                    if (1 == i3) {
                        eVar.g = "";
                    } else {
                        eVar.g = t.b(g.this.f25365c, "uuid", "");
                    }
                    eVar.h = d.a().b();
                    eVar.i = k.a().b();
                    eVar.j = String.valueOf(k.a().d());
                    eVar.k = k.a().c();
                    eVar.l = String.valueOf(i3);
                    eVar.m = i4;
                    eVar.n = j;
                    eVar.o = j3;
                    eVar.p = j2;
                    eVar.q = i5;
                    eVar.r = String.valueOf(i);
                    eVar.s = com.tencent.tendinsv.utils.d.e(str);
                    eVar.t = i2;
                    eVar.u = str2;
                    eVar.v = i6;
                    if (!"check_error".equals(str2) && !"cache".equals(str2) && i != 1011) {
                        eVar.u = com.tencent.tendinsv.utils.d.e(str);
                        eVar.s = str2;
                    }
                    if (!"cache".equals(str2) && !"check_error".equals(str2) && (1 != i4 || i5 != 0 || i3 == 4)) {
                        g.a().a(eVar, z);
                        if (1 == i3 || g.this.m.getAndSet(true) || !com.tencent.tendinsv.b.av) {
                            return;
                        }
                        long b2 = t.b(g.this.f25365c, t.t, 600L);
                        if (b2 == -1 || b2 == 0) {
                            return;
                        }
                        long parseLong = Long.parseLong(t.b(g.this.f25365c, t.O, Camera.Parameters.VIDEO_HFR_4X));
                        if (parseLong > 0) {
                            HandlerThread handlerThread = new HandlerThread("HandlerThread");
                            handlerThread.start();
                            new Handler(handlerThread.getLooper()).postDelayed(new Runnable() { // from class: com.tencent.tendinsv.tool.g.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        g.this.l = t.b(g.this.f25365c, t.u, 100L);
                                        if (g.this.e == null || g.this.e.b() <= 0) {
                                            return;
                                        }
                                        g.this.j = (int) Math.ceil(((float) g.this.e.b()) / ((float) g.this.l));
                                        g.this.c();
                                        g.this.h = false;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, parseLong * 1000);
                            return;
                        }
                        return;
                    }
                    g.a().a(eVar, true);
                    if (1 == i3) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void a(Context context, String str) {
        this.f25365c = context;
        this.d = str;
    }

    public void b() {
        try {
            if (com.tencent.tendinsv.b.av && com.tencent.tendinsv.b.aB) {
                long b2 = t.b(this.f25365c, t.t, 600L);
                String b3 = t.b(this.f25365c, t.P, "1");
                if (b2 == -1 || b2 == 0 || !"1".equals(b3)) {
                    return;
                }
                com.tencent.tendinsv.utils.j.a().b((Application) this.f25365c, this.f25364a);
                com.tencent.tendinsv.utils.j.a().a((Application) this.f25365c, this.f25364a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
