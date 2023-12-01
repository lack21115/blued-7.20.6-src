package com.tencent.map.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.map.b.b;
import com.tencent.map.b.d;
import com.tencent.map.b.e;
import com.tencent.map.b.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/f.class */
public final class f implements b.a, d.c, e.c, g.c {
    private static boolean t = false;
    private static f u;

    /* renamed from: c  reason: collision with root package name */
    private e f23532c;
    private d d;
    private g e;
    private int k;
    private int l;
    private int m;

    /* renamed from: a  reason: collision with root package name */
    private long f23531a = 5000;
    private Context b = null;
    private int f = 1024;
    private int g = 4;
    private com.tencent.map.b.c h = null;
    private com.tencent.map.b.b i = null;
    private com.tencent.map.a.a.b j = null;
    private byte[] n = new byte[0];
    private byte[] o = new byte[0];
    private boolean p = false;
    private c q = null;
    private b r = null;
    private a s = null;
    private long v = -1;
    private e.b w = null;
    private d.b x = null;
    private g.b y = null;
    private com.tencent.map.a.a.d z = null;
    private com.tencent.map.a.a.d A = null;
    private int B = 0;
    private int C = 0;
    private int D = 1;
    private String E = "";
    private String F = "";
    private String G = "";
    private String H = "";
    private String I = "";
    private String J = "";
    private boolean K = false;
    private boolean L = false;
    private long M = 0;
    private Handler N = null;
    private Runnable O = new Runnable() { // from class: com.tencent.map.b.f.1
        @Override // java.lang.Runnable
        public final void run() {
            if (System.currentTimeMillis() - f.this.M < 8000) {
                return;
            }
            if (f.this.e.b() && f.this.e.c()) {
                f.this.e.a(0L);
            } else {
                f.this.d();
            }
        }
    };
    private final BroadcastReceiver P = new BroadcastReceiver() { // from class: com.tencent.map.b.f.2
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false) || f.this.q == null) {
                return;
            }
            f.this.q.sendEmptyMessage(256);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/f$a.class */
    public final class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private e.b f23535a;
        private d.b b;

        /* renamed from: c  reason: collision with root package name */
        private g.b f23536c;

        a(e.b bVar, d.b bVar2, g.b bVar3) {
            this.f23535a = null;
            this.b = null;
            this.f23536c = null;
            if (bVar != null) {
                this.f23535a = (e.b) bVar.clone();
            }
            if (bVar2 != null) {
                this.b = (d.b) bVar2.clone();
            }
            if (bVar3 != null) {
                this.f23536c = (g.b) bVar3.clone();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            if (!f.t) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) f.this.b.getSystemService("phone");
                    f.this.E = telephonyManager.getDeviceId();
                    f.this.F = telephonyManager.getSubscriberId();
                    f.this.G = telephonyManager.getLine1Number();
                    Pattern compile = Pattern.compile("[0-9a-zA-Z+-]*");
                    f.this.E = f.this.E == null ? "" : f.this.E;
                    if (compile.matcher(f.this.E).matches()) {
                        f.this.E = f.this.E == null ? "" : f.this.E;
                    } else {
                        f.this.E = "";
                    }
                    f.this.F = f.this.F == null ? "" : f.this.F;
                    if (compile.matcher(f.this.F).matches()) {
                        f.this.F = f.this.F == null ? "" : f.this.F;
                    } else {
                        f.this.F = "";
                    }
                    f.this.G = f.this.G == null ? "" : f.this.G;
                    if (compile.matcher(f.this.G).matches()) {
                        f.this.G = f.this.G == null ? "" : f.this.G;
                    } else {
                        f.this.G = "";
                    }
                } catch (Exception e) {
                }
                f.a(true);
                f fVar = f.this;
                fVar.E = fVar.E == null ? "" : f.this.E;
                f fVar2 = f.this;
                fVar2.F = fVar2.F == null ? "" : f.this.F;
                f fVar3 = f.this;
                fVar3.G = fVar3.G == null ? "" : f.this.G;
                f fVar4 = f.this;
                fVar4.I = j.a(fVar4.E == null ? "0123456789ABCDEF" : f.this.E);
            }
            String a2 = f.this.g == 4 ? i.a(this.f23536c) : "[]";
            String a3 = i.a(this.b, f.this.d.b());
            String a4 = i.a(f.this.E, f.this.F, f.this.G, f.this.H, f.this.K);
            e.b bVar = this.f23535a;
            String a5 = (bVar == null || !bVar.a()) ? "{}" : i.a(this.f23535a);
            f.this.q.sendMessage(f.this.q.obtainMessage(16, (("{\"version\":\"1.1.8\",\"address\":" + f.this.l) + ",\"source\":203,\"access_token\":\"" + f.this.I + "\",\"app_name\":\"" + f.this.J + "\",\"bearing\":1") + ",\"attribute\":" + a4 + ",\"location\":" + a5 + ",\"cells\":" + a3 + ",\"wifis\":" + a2 + "}"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/f$b.class */
    public final class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private String f23537a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f23538c = null;

        public b(String str) {
            this.f23537a = null;
            this.b = null;
            this.f23537a = str;
            StringBuilder sb = new StringBuilder();
            sb.append(f.this.D == 0 ? "http://lstest.map.soso.com/loc?c=1" : "http://lbs.map.qq.com/loc?c=1");
            sb.append("&mars=");
            sb.append(f.this.m);
            this.b = sb.toString();
        }

        private String a(byte[] bArr, String str) {
            f.this.M = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(new String(bArr, str));
                return stringBuffer.toString();
            } catch (Exception e) {
                return null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Message message = new Message();
            message.what = 8;
            try {
                byte[] a2 = j.a(this.f23537a.getBytes());
                f.this.p = true;
                n a3 = com.tencent.map.b.b.a(this.b, "SOSO MAP LBS SDK", a2);
                f.this.p = false;
                String a4 = a(j.b(a3.f23554a), a3.b);
                this.f23538c = a4;
                if (a4 != null) {
                    message.arg1 = 0;
                    message.obj = this.f23538c;
                } else {
                    message.arg1 = 1;
                }
            } catch (Exception e) {
                int i = 0;
                while (true) {
                    i++;
                    if (i > 3) {
                        break;
                    }
                    try {
                        sleep(1000L);
                        byte[] a5 = j.a(this.f23537a.getBytes());
                        f.this.p = true;
                        n a6 = com.tencent.map.b.b.a(this.b, "SOSO MAP LBS SDK", a5);
                        f.this.p = false;
                        String a7 = a(j.b(a6.f23554a), a6.b);
                        this.f23538c = a7;
                        if (a7 != null) {
                            message.arg1 = 0;
                            message.obj = this.f23538c;
                        } else {
                            message.arg1 = 1;
                        }
                    } catch (Exception e2) {
                    }
                }
                f.this.p = false;
                message.arg1 = 1;
            }
            f.j(f.this);
            f.this.q.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/f$c.class */
    public final class c extends Handler {
        public c() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 8) {
                if (message.arg1 == 0) {
                    f.this.a((String) message.obj);
                } else if (f.this.w == null || !f.this.w.a()) {
                    f.this.e();
                }
            } else if (i == 16) {
                if (message.obj != null) {
                    f.a(f.this, (String) message.obj);
                    f.a(f.this, (a) null);
                }
            } else if (i == 256) {
                if (f.this.B == 1) {
                    f.this.d();
                }
            } else {
                switch (i) {
                    case 1:
                        f.a(f.this, (e.b) message.obj);
                        return;
                    case 2:
                        f.a(f.this, (d.b) message.obj);
                        return;
                    case 3:
                        f.a(f.this, (g.b) message.obj);
                        return;
                    case 4:
                        f.a(f.this, message.arg1);
                        return;
                    case 5:
                        f.b(f.this, message.arg1);
                        return;
                    case 6:
                        f.a(f.this, (Location) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private f() {
        this.f23532c = null;
        this.d = null;
        this.e = null;
        this.f23532c = new e();
        this.d = new d();
        this.e = new g();
    }

    static /* synthetic */ a a(f fVar, a aVar) {
        fVar.s = null;
        return null;
    }

    public static f a() {
        f fVar;
        synchronized (f.class) {
            try {
                if (u == null) {
                    u = new f();
                }
                fVar = u;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    private static ArrayList<com.tencent.map.a.a.c> a(JSONArray jSONArray) throws Exception {
        int length = jSONArray.length();
        ArrayList<com.tencent.map.a.a.c> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            arrayList.add(new com.tencent.map.a.a.c(jSONObject.getString("name"), jSONObject.getString("addr"), jSONObject.getString("catalog"), jSONObject.getDouble("dist"), Double.parseDouble(jSONObject.getString("latitude")), Double.parseDouble(jSONObject.getString("longitude"))));
            i = i2 + 1;
        }
    }

    static /* synthetic */ void a(f fVar, int i) {
        if (i == 0) {
            fVar.w = null;
        }
        int i2 = i == 0 ? 1 : 2;
        fVar.f = i2;
        com.tencent.map.a.a.b bVar = fVar.j;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    static /* synthetic */ void a(f fVar, Location location) {
        com.tencent.map.a.a.b bVar;
        if (location == null || location.getLatitude() > 359.0d || location.getLongitude() > 359.0d) {
            e.b bVar2 = fVar.w;
            if (bVar2 == null || !bVar2.a()) {
                fVar.e();
            } else {
                fVar.b(true);
            }
        }
        com.tencent.map.a.a.d dVar = new com.tencent.map.a.a.d();
        fVar.z = dVar;
        dVar.z = 0;
        fVar.z.y = 0;
        fVar.z.b = i.a(location.getLatitude(), 6);
        fVar.z.f23508c = i.a(location.getLongitude(), 6);
        e.b bVar3 = fVar.w;
        if (bVar3 != null && bVar3.a()) {
            fVar.z.e = i.a(fVar.w.b().getAccuracy(), 1);
            fVar.z.d = i.a(fVar.w.b().getAltitude(), 1);
            fVar.z.f = i.a(fVar.w.b().getSpeed(), 1);
            fVar.z.g = i.a(fVar.w.b().getBearing(), 1);
            fVar.z.f23507a = 0;
        }
        fVar.z.x = true;
        int i = fVar.l;
        if (i != 0 && fVar.A != null && fVar.B == 0) {
            if ((i == 3 || i == 4) && fVar.l == fVar.A.z) {
                fVar.z.i = fVar.A.i;
                fVar.z.j = fVar.A.j;
                fVar.z.k = fVar.A.k;
                fVar.z.l = fVar.A.l;
                fVar.z.m = fVar.A.m;
                fVar.z.n = fVar.A.n;
                fVar.z.o = fVar.A.o;
                fVar.z.p = fVar.A.p;
                fVar.z.z = 3;
            }
            int i2 = fVar.l;
            if (i2 == 4 && i2 == fVar.A.z && fVar.A.w != null) {
                fVar.z.w = new ArrayList<>();
                Iterator<com.tencent.map.a.a.c> it = fVar.A.w.iterator();
                while (it.hasNext()) {
                    fVar.z.w.add(new com.tencent.map.a.a.c(it.next()));
                }
                fVar.z.z = 4;
            }
            int i3 = fVar.l;
            if (i3 == 7 && i3 == fVar.A.z) {
                fVar.z.z = 7;
                fVar.z.h = fVar.A.h;
                fVar.z.i = fVar.A.i;
                if (fVar.A.h == 0) {
                    fVar.z.j = fVar.A.j;
                    fVar.z.k = fVar.A.k;
                    fVar.z.l = fVar.A.l;
                    fVar.z.m = fVar.A.m;
                    fVar.z.n = fVar.A.n;
                    fVar.z.o = fVar.A.o;
                    fVar.z.p = fVar.A.p;
                } else {
                    fVar.z.q = fVar.A.q;
                    fVar.z.r = fVar.A.r;
                    fVar.z.s = fVar.A.s;
                    fVar.z.t = fVar.A.t;
                    fVar.z.u = fVar.A.u;
                    fVar.z.v = fVar.A.v;
                }
            }
        }
        if (fVar.B == 0 && fVar.A == null) {
            return;
        }
        int i4 = fVar.B;
        if (i4 != 0) {
            fVar.z.y = i4;
        }
        if (System.currentTimeMillis() - fVar.v < fVar.f23531a || (bVar = fVar.j) == null || fVar.k != 1) {
            return;
        }
        bVar.a(fVar.z);
        fVar.v = System.currentTimeMillis();
    }

    static /* synthetic */ void a(f fVar, d.b bVar) {
        fVar.x = bVar;
        g gVar = fVar.e;
        if (gVar != null && gVar.b() && fVar.e.c()) {
            fVar.e.a(0L);
            return;
        }
        if (fVar.C > 0 && !i.a(bVar.f23524a, bVar.b, bVar.f23525c, bVar.d, bVar.e)) {
            fVar.C--;
        }
        fVar.d();
    }

    static /* synthetic */ void a(f fVar, e.b bVar) {
        com.tencent.map.b.b bVar2;
        if (bVar != null) {
            fVar.w = bVar;
            if (fVar.k == 1 && bVar != null && bVar.a()) {
                int i = fVar.m;
                if (i == 0) {
                    fVar.b(false);
                } else if (i != 1 || (bVar2 = fVar.i) == null) {
                } else {
                    double latitude = fVar.w.b().getLatitude();
                    double longitude = fVar.w.b().getLongitude();
                    Context context = fVar.b;
                    bVar2.a(latitude, longitude, fVar);
                }
            }
        }
    }

    static /* synthetic */ void a(f fVar, g.b bVar) {
        if (bVar != null) {
            fVar.y = bVar;
            fVar.d();
        }
    }

    static /* synthetic */ void a(f fVar, String str) {
        d.b bVar;
        d.b bVar2;
        byte[] bArr;
        com.tencent.map.a.a.b bVar3;
        if (!i.c(str)) {
            int i = fVar.C;
            if (i > 0) {
                fVar.C = i - 1;
            } else if (fVar.k == 0 && (bVar3 = fVar.j) != null) {
                bVar3.a(null, -1);
            } else if (fVar.k != 1 || fVar.j == null) {
            } else {
                com.tencent.map.a.a.d dVar = new com.tencent.map.a.a.d();
                fVar.z = dVar;
                fVar.B = 3;
                dVar.y = 3;
                fVar.z.z = -1;
                fVar.j.a(fVar.z);
            }
        } else if (fVar.k == 0 && fVar.j != null) {
            try {
                bArr = str.getBytes();
            } catch (Exception e) {
                bArr = null;
            }
            fVar.j.a(bArr, 0);
        } else {
            com.tencent.map.b.c cVar = fVar.h;
            String b2 = (cVar == null || (bVar = fVar.x) == null || fVar.y == null) ? null : cVar.b(bVar.b, fVar.x.f23525c, fVar.x.d, fVar.x.e, fVar.y.a());
            if (b2 != null) {
                fVar.a(b2);
                return;
            }
            com.tencent.map.b.c cVar2 = fVar.h;
            if (cVar2 != null && (bVar2 = fVar.x) != null && fVar.y != null) {
                cVar2.a(bVar2.b, fVar.x.f23525c, fVar.x.d, fVar.x.e, fVar.y.a());
            }
            if (fVar.p) {
                return;
            }
            b bVar4 = fVar.r;
            if (bVar4 != null) {
                bVar4.interrupt();
            }
            fVar.r = null;
            b bVar5 = new b(str);
            fVar.r = bVar5;
            bVar5.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        double d;
        double d2;
        double d3;
        try {
            this.z = new com.tencent.map.a.a.d();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("location");
            this.z.f23507a = 1;
            this.z.b = i.a(jSONObject2.getDouble("latitude"), 6);
            this.z.f23508c = i.a(jSONObject2.getDouble("longitude"), 6);
            this.z.d = i.a(jSONObject2.getDouble("altitude"), 1);
            this.z.e = i.a(jSONObject2.getDouble("accuracy"), 1);
            this.z.x = this.m == 1;
            String string = jSONObject.getString("bearing");
            int i = -100;
            int parseInt = (string == null || string.split(",").length <= 1) ? 0 : Integer.parseInt(string.split(",")[1]);
            if (this.x != null) {
                i = this.x.f;
            }
            com.tencent.map.a.a.d dVar = this.z;
            double d4 = this.z.e;
            if (parseInt >= 6) {
                d3 = 40.0d;
            } else if (parseInt == 5) {
                d3 = 60.0d;
            } else if (parseInt == 4) {
                d3 = 70.0d;
            } else if (parseInt == 3) {
                d3 = 90.0d;
            } else if (parseInt == 2) {
                d3 = 110.0d;
            } else {
                if (i >= -72 && parseInt == 0) {
                    d = 0.45d;
                } else if (d4 <= 100.0d) {
                    d2 = ((d4 - 1.0d) / 10.0d) + 1.0d;
                    d3 = ((int) d2) * 10;
                } else {
                    d = (d4 <= 100.0d || d4 > 800.0d) ? 0.8d : 0.85d;
                }
                d2 = (d4 * d) / 10.0d;
                d3 = ((int) d2) * 10;
            }
            dVar.e = d3;
            this.z.z = 0;
            if ((this.l == 3 || this.l == 4) && this.m == 1) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("details").getJSONObject("subnation");
                this.z.a(jSONObject3.getString("name"));
                this.z.m = jSONObject3.getString("town");
                this.z.n = jSONObject3.getString("village");
                this.z.o = jSONObject3.getString("street");
                this.z.p = jSONObject3.getString("street_no");
                this.z.z = 3;
                this.z.h = 0;
            }
            if (this.l == 4 && this.m == 1) {
                this.z.w = a(jSONObject.getJSONObject("details").getJSONArray("poilist"));
                this.z.z = 4;
            }
            if (this.l == 7 && this.m == 1) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("details");
                int i2 = jSONObject4.getInt("stat");
                JSONObject jSONObject5 = jSONObject4.getJSONObject("subnation");
                if (i2 == 0) {
                    this.z.a(jSONObject5.getString("name"));
                    this.z.m = jSONObject5.getString("town");
                    this.z.n = jSONObject5.getString("village");
                    this.z.o = jSONObject5.getString("street");
                    this.z.p = jSONObject5.getString("street_no");
                } else if (i2 == 1) {
                    this.z.i = jSONObject5.getString("nation");
                    this.z.q = jSONObject5.getString("admin_level_1");
                    this.z.r = jSONObject5.getString("admin_level_2");
                    this.z.s = jSONObject5.getString("admin_level_3");
                    this.z.t = jSONObject5.getString("locality");
                    this.z.u = jSONObject5.getString("sublocality");
                    this.z.v = jSONObject5.getString("route");
                }
                this.z.h = i2;
                this.z.z = 7;
            }
            this.z.y = 0;
            this.A = new com.tencent.map.a.a.d(this.z);
            this.B = 0;
            if (this.h != null) {
                this.h.a(str);
            }
        } catch (Exception e) {
            com.tencent.map.a.a.d dVar2 = new com.tencent.map.a.a.d();
            this.z = dVar2;
            dVar2.z = -1;
            this.z.y = 2;
            this.B = 2;
        }
        if (this.j == null || this.k != 1) {
            return;
        }
        e.b bVar = this.w;
        if (bVar == null || !bVar.a()) {
            this.j.a(this.z);
            this.v = System.currentTimeMillis();
        }
    }

    static /* synthetic */ boolean a(boolean z) {
        t = true;
        return true;
    }

    static /* synthetic */ void b(f fVar, int i) {
        int i2 = 3;
        if (i == 3) {
            i2 = 4;
        }
        fVar.g = i2;
        com.tencent.map.a.a.b bVar = fVar.j;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    private void b(boolean z) {
        com.tencent.map.a.a.b bVar;
        e.b bVar2 = this.w;
        if (bVar2 == null || !bVar2.a()) {
            return;
        }
        Location b2 = this.w.b();
        com.tencent.map.a.a.d dVar = new com.tencent.map.a.a.d();
        this.z = dVar;
        dVar.b = i.a(b2.getLatitude(), 6);
        this.z.f23508c = i.a(b2.getLongitude(), 6);
        this.z.d = i.a(b2.getAltitude(), 1);
        this.z.e = i.a(b2.getAccuracy(), 1);
        this.z.f = i.a(b2.getSpeed(), 1);
        this.z.g = i.a(b2.getBearing(), 1);
        this.z.f23507a = 0;
        this.z.x = false;
        if (z) {
            this.z.y = 1;
        } else {
            this.z.y = 0;
        }
        this.z.z = 0;
        this.A = new com.tencent.map.a.a.d(this.z);
        this.B = 0;
        if (System.currentTimeMillis() - this.v < this.f23531a || (bVar = this.j) == null || this.k != 1) {
            return;
        }
        bVar.a(this.z);
        this.v = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.s != null) {
            return;
        }
        a aVar = new a(this.w, this.x, this.y);
        this.s = aVar;
        aVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.tencent.map.a.a.d dVar = new com.tencent.map.a.a.d();
        this.z = dVar;
        this.B = 1;
        dVar.y = 1;
        this.z.z = -1;
        this.z.f23507a = 1;
        com.tencent.map.a.a.b bVar = this.j;
        if (bVar == null || this.k != 1) {
            return;
        }
        bVar.a(this.z);
    }

    static /* synthetic */ void j(f fVar) {
    }

    @Override // com.tencent.map.b.b.a
    public final void a(double d, double d2) {
        synchronized (this.o) {
            Message obtainMessage = this.q.obtainMessage(6);
            Location location = new Location("Deflect");
            location.setLatitude(d);
            location.setLongitude(d2);
            obtainMessage.obj = location;
            this.q.sendMessage(obtainMessage);
        }
    }

    @Override // com.tencent.map.b.e.c
    public final void a(int i) {
        synchronized (this.o) {
            this.q.sendMessage(this.q.obtainMessage(4, i, 0));
        }
    }

    @Override // com.tencent.map.b.d.c
    public final void a(d.b bVar) {
        synchronized (this.o) {
            this.q.sendMessage(this.q.obtainMessage(2, bVar));
        }
    }

    @Override // com.tencent.map.b.e.c
    public final void a(e.b bVar) {
        synchronized (this.o) {
            this.q.sendMessage(this.q.obtainMessage(1, bVar));
        }
    }

    @Override // com.tencent.map.b.g.c
    public final void a(g.b bVar) {
        synchronized (this.o) {
            this.q.sendMessage(this.q.obtainMessage(3, bVar));
        }
    }

    public final boolean a(Context context, com.tencent.map.a.a.b bVar) {
        synchronized (this.n) {
            if (context == null || bVar == null) {
                return false;
            }
            if (i.a(this.J)) {
                this.q = new c();
                this.N = new Handler(Looper.getMainLooper());
                this.b = context;
                this.j = bVar;
                l.a().a(this.b.getApplicationContext());
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                        this.K = connectivityManager.getActiveNetworkInfo().isRoaming();
                    }
                    this.b.registerReceiver(this.P, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                }
                this.k = this.j.a();
                this.l = this.j.b();
                this.m = this.j.c();
                this.v = -1L;
                if (this.l == 7) {
                    this.l = 0;
                }
                this.L = false;
                this.D = 1;
                boolean a2 = this.f23532c.a(this, this.b);
                boolean a3 = this.d.a(this.b, this);
                boolean a4 = this.e.a(this.b, this, 1);
                this.h = com.tencent.map.b.c.a();
                this.i = com.tencent.map.b.b.a();
                this.w = null;
                this.x = null;
                this.y = null;
                this.z = null;
                this.A = null;
                this.B = 0;
                if (this.h != null) {
                    this.h.b();
                }
                this.C = 1;
                if (a2 && this.m == 0) {
                    return true;
                }
                return a3 || a4;
            }
            return false;
        }
    }

    public final boolean a(String str, String str2) {
        synchronized (this.n) {
            if (com.tencent.map.b.a.a().a(str, str2)) {
                this.J = str;
                return true;
            }
            return false;
        }
    }

    public final void b() {
        synchronized (this.n) {
            try {
                if (this.j != null) {
                    this.j = null;
                    this.N.removeCallbacks(this.O);
                    this.b.unregisterReceiver(this.P);
                    this.f23532c.a();
                    this.d.a();
                    this.e.a();
                }
            } catch (Exception e) {
            }
        }
    }

    @Override // com.tencent.map.b.g.c
    public final void b(int i) {
        synchronized (this.o) {
            this.q.sendMessage(this.q.obtainMessage(5, i, 0));
        }
    }
}
