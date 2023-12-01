package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import c.t.m.g.q5;
import c.t.m.g.t4;
import c.t.m.g.u4;
import com.baidu.mobads.sdk.internal.bw;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.fw;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.util.SoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p4.class */
public class p4 {
    public static SparseArray<String> c0;
    public static boolean d0;
    public static boolean e0;
    public static final TencentLocationListener f0;
    public u3 A;
    public List<TencentLocationListener> B;
    public List<TencentLocationListener> C;
    public List<e> D;
    public long I;
    public q5 M;
    public double N;
    public double O;
    public q5 P;
    public long R;
    public String T;
    public c e;
    public f f;
    public Handler g;
    public boolean h;
    public k4 i;
    public r4 j;
    public boolean k;
    public o4 l;
    public t4 m;
    public x4 n;
    public m4 o;
    public i4 p;
    public q4 q;
    public u4 r;
    public volatile int s;
    public boolean t;
    public v4 u;
    public a5 v;
    public g5 w;
    public g5 x;
    public b5 y;
    public final t3 z;

    /* renamed from: a  reason: collision with root package name */
    public String f3874a = "ReGeoCodingnKey";
    public String b = "default";

    /* renamed from: c  reason: collision with root package name */
    public int f3875c = -1;
    public int d = 1;
    public long E = 0;
    public volatile long F = 0;
    public int G = 0;
    public volatile int H = 0;
    public final Object J = new Object();
    public final TencentLocationRequest K = TencentLocationRequest.create();
    public long L = 0;
    public int Q = 404;
    public volatile d S = d.Stop;
    public c.t.m.g.b U = null;
    public s3 V = null;
    public boolean W = false;
    public boolean X = false;
    public int Y = 0;
    public final byte[] Z = new byte[0];
    public String a0 = "";
    public int b0 = -1;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p4$a.class */
    public static final class a implements TencentLocationListener {
        @Override // com.tencent.map.geolocation.TencentLocationListener
        public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        }

        @Override // com.tencent.map.geolocation.TencentLocationListener
        public void onStatusUpdate(String str, int i, String str2) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p4$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                p4.this.S = d.Daemon;
                p4.this.b(p4.this.z.g().getLooper());
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p4$c.class */
    public class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public long f3877a;
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3878c;
        public int d;
        public t4.c e;

        /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p4$c$a.class */
        public class a implements t4.c {
            public a() {
            }

            @Override // c.t.m.g.t4.c
            public void a(q5 q5Var, int i) {
                if (b6.b(p4.this.m)) {
                    p4.this.m.a();
                }
                String str = "onTxNlpLocationChanged: error= " + i + "," + q5Var;
                if (q5Var == null || q5Var == q5.q) {
                    p4.this.a(i, q5.q);
                    c.this.b(i);
                    return;
                }
                p4.this.a(0, q5Var);
                c.this.b(0);
            }
        }

        public c(Looper looper) {
            super(looper);
            this.d = 0;
            this.e = new a();
            this.f3877a = 0L;
            this.b = false;
            this.f3878c = false;
        }

        public final void a() {
            if (p4.this.A.h() == 0) {
                p4.this.A.b(System.currentTimeMillis() - p4.this.A.p());
            }
        }

        public final void a(int i) {
            boolean z = false;
            if (!h5.f3784a) {
                if (p4.this.Q == 0 && p4.this.M != null && System.currentTimeMillis() - p4.this.M.getTime() < 60000) {
                    b(0);
                    return;
                }
                p4.this.a(i, q5.q);
                b(i);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = p4.this.L;
            long currentTimeMillis2 = p4.this.M != null ? System.currentTimeMillis() - p4.this.M.getTime() : 0L;
            int unused = p4.this.Q;
            if (!b6.b(p4.this.m) || currentTimeMillis - j <= 30000) {
                return;
            }
            if (p4.this.Q == 404 || (p4.this.M != null && currentTimeMillis2 > 20000)) {
                p4.this.L = System.currentTimeMillis();
                t4 t4Var = p4.this.m;
                if (p4.this.d == 1) {
                    z = true;
                }
                t4Var.a(z);
                p4.this.m.a(this.e);
                p4.this.m.a(p4.this.T);
                p4.this.m.a(p4.this.d);
                p4.this.m.b(i);
                p4.this.m.c(p4.this.K.getRequestLevel());
                p4.this.m.b();
            }
        }

        public void b() {
            this.d = 0;
            removeCallbacksAndMessages(null);
        }

        public final void b(int i) {
            if (p4.this.C == null || p4.this.C.isEmpty()) {
                return;
            }
            p4.this.C.size();
            if (p4.this.Q != 0) {
                p4.this.a(q5.q, i, 3103);
                return;
            }
            p4 p4Var = p4.this;
            p4Var.a(p4Var.M, p4.this.Q, 3103);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (p4.this.J) {
                if (b6.b(p4.this.B) || p4.this.B.isEmpty() || p4.this.S != d.Normal) {
                    TencentLocationRequest tencentLocationRequest = p4.this.K;
                    int requestLevel = tencentLocationRequest.getRequestLevel();
                    long j = p4.this.F;
                    try {
                        int i = message.what;
                        if (i == 554) {
                            Bundle data = message.getData();
                            if (data != null) {
                                String string = data.getString("WIFIS");
                                if (TextUtils.isEmpty(string)) {
                                    return;
                                }
                                p4.this.r.a(string);
                            }
                        } else if (i == 555) {
                            p4.this.w = null;
                            s3.a("WIFI", "wifi clear req");
                            sendEmptyMessage(3999);
                        } else if (i == 3991) {
                            if (p4.this.X) {
                                return;
                            }
                            sendEmptyMessage(3999);
                            s3.a("P", "time out");
                        } else {
                            boolean z = false;
                            if (i == 3997) {
                                c5 j2 = p4.this.j();
                                String str = null;
                                if (j2 != null) {
                                    str = j2.a(requestLevel, p4.this.T, p4.this.z, false, false, false);
                                    z = !f6.a(str);
                                }
                                if (j2 == null || z) {
                                    a(2);
                                    return;
                                } else {
                                    p4.this.r.a(str, j2, p4.this.d);
                                    return;
                                }
                            }
                            if (i != 3999) {
                                if (i == 5997) {
                                    a(message.arg1);
                                    return;
                                } else if (i == 5999) {
                                    try {
                                        int i2 = message.arg1;
                                        int i3 = message.arg2;
                                        q5 q5Var = (q5) message.obj;
                                        p4.this.K.getRequestLevel();
                                        q5Var.getNationCode();
                                        String str2 = "nationcode, request bundle: " + p4.this.K.getExtras();
                                        if (p4.this.K.getRequestLevel() <= 0 || q5Var.getNationCode() != 0) {
                                            return;
                                        }
                                        String b = p4.this.z.b("https://apis.map.qq.com/ws/geocoder/v1/?location=" + q5Var.getLatitude() + "," + q5Var.getLongitude() + "&key=" + p4.this.b);
                                        if (b == null) {
                                            p4.this.a(1, q5.q);
                                            return;
                                        }
                                        JSONObject jSONObject = new JSONObject(b);
                                        p4.this.f3875c = jSONObject.optInt("status");
                                        p4.this.Y = jSONObject.getJSONObject("result").getJSONObject("ad_info").getInt("nation_code");
                                        int unused = p4.this.Y;
                                        p4.this.a(q5Var, i2, i3);
                                        return;
                                    } catch (Throwable th) {
                                        return;
                                    }
                                } else if (i != 7999) {
                                    if (i == 4998) {
                                        if (p4.this.A.h() == 0) {
                                            p4.this.A.b(-1L);
                                        }
                                        if (!p4.this.a(30000, 0)) {
                                            a(1);
                                        }
                                        p4.this.I = -1L;
                                        return;
                                    } else if (i != 4999) {
                                        switch (i) {
                                            case 11997:
                                            case 11998:
                                                if (p4.this.M != null) {
                                                    p4.this.a(p4.this.M);
                                                    p4.this.a(p4.this.M, p4.this.Q, 3101);
                                                    return;
                                                }
                                                return;
                                            case 11999:
                                                if (p4.this.M != null && tencentLocationRequest.getInterval() > 0) {
                                                    p4.this.a(p4.this.M);
                                                    p4.this.a(p4.this.M, p4.this.Q, 3101);
                                                    p4.this.M.toString();
                                                }
                                                if (j > 0) {
                                                    sendEmptyMessageDelayed(11999, j);
                                                    return;
                                                }
                                                return;
                                            default:
                                                return;
                                        }
                                    } else {
                                        a();
                                        removeMessages(4998);
                                        Pair pair = (Pair) message.obj;
                                        String obj = pair.first.toString();
                                        u4.b bVar = (u4.b) pair.second;
                                        p4.this.x = ((c5) bVar.d).a();
                                        String str3 = bVar.f;
                                        try {
                                            q5 a2 = new q5.b().a(obj).a(requestLevel).b("network").a();
                                            if (a2.isMockGps() == 1) {
                                                this.f3878c = true;
                                            }
                                            q5.d(a2);
                                            if (p4.this.U != null) {
                                                p4.this.U.a(a2.c(), p4.this.d, a2.getLatitude(), a2.getLongitude(), a2.getAccuracy());
                                            }
                                            p4.this.I = System.currentTimeMillis();
                                            boolean z2 = !TextUtils.isEmpty(a2.getIndoorBuildingId());
                                            if (z2 && p4.this.H == 1) {
                                                p4.this.H = 2;
                                                this.d = 0;
                                            }
                                            if (p4.this.H == 2) {
                                                if (z2) {
                                                    this.d = 0;
                                                } else {
                                                    this.d++;
                                                }
                                                if (this.d >= 5) {
                                                    p4.this.K.getInterval();
                                                    p4.this.H = 1;
                                                    this.d = 0;
                                                }
                                            }
                                            a2.c(e4.b().a(a2));
                                            p4.this.l();
                                            int unused2 = p4.this.H;
                                            if (!p4.this.l() || (z2 && p4.this.H > 0)) {
                                                q5.a(a2, z2);
                                                p4.this.a(0, a2);
                                                a2.toString();
                                            }
                                            if (p4.this.M != null) {
                                                q5.a(p4.this.M, a2);
                                            }
                                            b(0);
                                            p4.this.P = a2;
                                            if (p4.this.S == d.Normal) {
                                                try {
                                                    m0.h().e();
                                                } catch (Exception e) {
                                                }
                                            }
                                            r5.a(p4.this.z.f3944a);
                                            return;
                                        } catch (JSONException e2) {
                                            s3.a("LOC", "server location error.");
                                            s3.a("LOC", "request:" + str3);
                                            s3.a("LOC", "response:" + obj);
                                            a(404);
                                            return;
                                        }
                                    }
                                } else if (p4.this.b()) {
                                    return;
                                } else {
                                    long max = Math.max(p4.this.K.getInterval(), 4000L);
                                    if (p4.this.I == 0 || System.currentTimeMillis() - p4.this.I < max) {
                                        return;
                                    }
                                }
                            }
                            p4.this.X = true;
                            removeMessages(3999);
                            if (p4.this.S == d.Daemon || p4.this.W) {
                                long d = n0.b().d("up_daemon_delay");
                                long j3 = d;
                                if (d < com.igexin.push.config.c.l) {
                                    j3 = 120000;
                                }
                                System.currentTimeMillis();
                                long unused3 = p4.this.R;
                                if (System.currentTimeMillis() - p4.this.R < j3) {
                                    return;
                                }
                                p4.this.R = System.currentTimeMillis();
                            }
                            int i4 = p4.this.d;
                            c5 j4 = p4.this.j();
                            if (j4 == null) {
                                s3.a("LOC", "info is null.");
                                a(2);
                                return;
                            }
                            if (!j4.b() || System.currentTimeMillis() - this.f3877a <= 60000) {
                                this.b = false;
                            } else {
                                this.b = true;
                                this.f3878c = false;
                                this.f3877a = System.currentTimeMillis();
                            }
                            String a3 = j4.a(requestLevel, p4.this.T, p4.this.z, this.b, this.f3878c, p4.this.S == d.Daemon);
                            if (a3 == null || !f6.a(a3)) {
                                s3.a("LOC", "bad json " + a3);
                                a(2);
                            } else if (p4.this.S != d.Normal || !h5.a(tencentLocationRequest)) {
                                if (e4.a()) {
                                    return;
                                }
                                p4.this.r.a(a3, j4, i4);
                            } else {
                                q5 a4 = new q5.b().a((q5) null).a(requestLevel).a();
                                h5.a(a4, a3.getBytes("UTF-8"));
                                p4.this.a(a4);
                                p4.this.a(a4, 0, 3101);
                            }
                        }
                    } catch (Throwable th2) {
                        th2.toString();
                    }
                }
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p4$d.class */
    public enum d {
        Normal,
        Daemon,
        Single,
        Stop
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p4$e.class */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public TencentLocationListener f3882a;
        public long b;

        public e(p4 p4Var, TencentLocationListener tencentLocationListener, long j) {
            this.f3882a = tencentLocationListener;
            this.b = j;
        }

        public long a() {
            return this.b;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p4$f.class */
    public class f extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public double f3883a;
        public double b;

        public f(Looper looper) {
            super(looper);
            this.f3883a = 0.0d;
            this.b = 0.0d;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long currentTimeMillis;
            long k;
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            switch (message.what) {
                case 3101:
                case 3103:
                    int i = message.arg1;
                    q5 q5Var = q5.q;
                    if (i == 0) {
                        q5Var = (q5) message.obj;
                    } else {
                        s3.a("LOC", "callback:" + i);
                    }
                    if (q5Var == null) {
                        s3.a("LOC", "cbCode:" + i);
                        return;
                    }
                    if (h4.a(q5Var)) {
                        q5Var.a(TencentLocation.BEIDOU_PROVIDER);
                        q5Var.c(0);
                        q5Var.getProvider();
                        q5Var.getSourceProvider();
                    }
                    q5Var.getLatitude();
                    q5Var.getLongitude();
                    int i2 = message.what;
                    if (i2 == 3101) {
                        if (!p4.this.b(q5Var) && System.currentTimeMillis() - p4.this.A.p() < p4.this.K.getGpsFirstTimeOut()) {
                            q5Var.getProvider();
                            return;
                        }
                        p4.this.A.p();
                        if (p4.this.A.p() >= p4.this.A.k()) {
                            currentTimeMillis = System.currentTimeMillis();
                            k = p4.this.A.p();
                        } else {
                            currentTimeMillis = System.currentTimeMillis();
                            k = p4.this.A.k();
                        }
                        if (p4.this.K.getLocMode() == 12 && !q5Var.getProvider().equals("gps") && currentTimeMillis - k < 8000 && !p4.this.A.j().equals("network")) {
                            q5Var.getProvider();
                            return;
                        }
                        if (this.f3883a != q5Var.getLatitude() || this.b != q5Var.getLongitude()) {
                            try {
                                s3.a("LOC", String.format(Locale.ENGLISH, "callback:%d,%s,%.6f,%.6f,%.1f,%.2f,%.1f,%.1f,%s", Integer.valueOf(i), q5Var.getProvider().substring(0, 1), Double.valueOf(q5Var.getLatitude()), Double.valueOf(q5Var.getLongitude()), Double.valueOf(q5Var.getAltitude()), Float.valueOf(q5Var.getAccuracy()), Float.valueOf(q5Var.getBearing()), Float.valueOf(q5Var.getSpeed()), q5Var.getIndoorBuildingFloor()));
                            } catch (Exception e) {
                            }
                            this.f3883a = q5Var.getLatitude();
                            this.b = q5Var.getLongitude();
                        }
                        if (p4.this.B != null) {
                            String.format(Locale.ENGLISH, "continue callback:%d,%s,%.6f,%.6f,%.1f,%.2f,%.1f,%.1f,%s,%s,%d", Integer.valueOf(i), Character.valueOf(q5Var.getProvider().charAt(0)), Double.valueOf(q5Var.getLatitude()), Double.valueOf(q5Var.getLongitude()), Double.valueOf(q5Var.getAltitude()), Float.valueOf(q5Var.getAccuracy()), Float.valueOf(q5Var.getBearing()), Float.valueOf(q5Var.getSpeed()), q5Var.getIndoorBuildingFloor(), Character.valueOf(q5Var.getSourceProvider().charAt(0)), Integer.valueOf(q5Var.getFakeReason()));
                            for (TencentLocationListener tencentLocationListener : p4.this.B) {
                                if (tencentLocationListener != null) {
                                    p4.this.A.e(q5Var.getProvider());
                                    p4.this.A.c(System.currentTimeMillis());
                                    tencentLocationListener.onLocationChanged(q5Var, i, (String) p4.c0.get(i));
                                    c cVar = p4.this.e;
                                    if (cVar != null) {
                                        cVar.removeMessages(11997);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    } else if (i2 == 3103) {
                        String.format(Locale.ENGLISH, "continue callback:%d,%s,%.6f,%.6f,%.1f,%.2f,%.1f,%.1f,%s,%s,%d", Integer.valueOf(i), Character.valueOf(q5Var.getProvider().charAt(0)), Double.valueOf(q5Var.getLatitude()), Double.valueOf(q5Var.getLongitude()), Double.valueOf(q5Var.getAltitude()), Float.valueOf(q5Var.getAccuracy()), Float.valueOf(q5Var.getBearing()), Float.valueOf(q5Var.getSpeed()), q5Var.getIndoorBuildingFloor(), Character.valueOf(q5Var.getSourceProvider().charAt(0)), Integer.valueOf(q5Var.getFakeReason()));
                        if (p4.this.b(q5Var)) {
                            if (p4.this.C == null || p4.this.C.isEmpty()) {
                                return;
                            }
                            q5Var.getProvider();
                            for (TencentLocationListener tencentLocationListener2 : p4.this.C) {
                                if (tencentLocationListener2 != null) {
                                    tencentLocationListener2.onLocationChanged(q5Var, i, (String) p4.c0.get(i));
                                }
                            }
                            p4.this.p();
                            p4.this.C.size();
                            p4.this.D.size();
                            return;
                        }
                        q5Var.getProvider();
                        if (p4.this.D == null || p4.this.D.isEmpty()) {
                            return;
                        }
                        for (e eVar : p4.this.D) {
                            TencentLocationListener tencentLocationListener3 = eVar.f3882a;
                            if (tencentLocationListener3 != null && System.currentTimeMillis() - eVar.b > p4.this.K.getGpsFirstTimeOut()) {
                                p4.this.C.size();
                                p4.this.D.size();
                                tencentLocationListener3.onLocationChanged(q5Var, i, (String) p4.c0.get(i));
                                p4.this.a(tencentLocationListener3);
                                p4.this.C.size();
                                p4.this.D.size();
                            }
                        }
                        if (p4.this.D.isEmpty()) {
                            p4.this.p();
                            p4.this.C.size();
                            p4.this.D.size();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 3102:
                    String string = data.getString("name");
                    int i3 = data.getInt("status");
                    String string2 = data.getString("desc");
                    if (p4.this.B != null) {
                        for (TencentLocationListener tencentLocationListener4 : p4.this.B) {
                            if (tencentLocationListener4 != null) {
                                tencentLocationListener4.onStatusUpdate(string, i3, string2);
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        c0 = sparseArray;
        d0 = false;
        e0 = false;
        sparseArray.put(0, bw.k);
        c0.put(1, "ERROR_NETWORK");
        c0.put(2, "ERROR_NOCELL&WIFI_LOCATIONSWITCHOFF");
        c0.put(4, "DEFLECT_FAILED");
        c0.put(404, "ERROR_SERVER_NOT_LOCATION");
        m0.a(e6.a());
        f0 = new a();
    }

    public p4(t3 t3Var) {
        this.s = 0;
        this.z = t3Var;
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
                this.t = true;
                try {
                    System.loadLibrary("jnirtk");
                } catch (Throwable th) {
                    this.t = false;
                }
            } catch (Throwable th2) {
                this.s = 3;
                return;
            }
        }
        this.A = this.z.a();
        try {
            if (!TextUtils.isEmpty(TencentLocationManagerOptions.getExtraKey())) {
                this.A.d(TencentLocationManagerOptions.getExtraKey());
            } else if (!TextUtils.isEmpty(TencentLocationManagerOptions.getKey())) {
                this.A.d(TencentLocationManagerOptions.getKey());
            }
        } catch (Throwable th3) {
            th3.toString();
        }
        s3.a("7.4.9.official_1-220803");
        String a2 = a(this.A.i());
        this.T = a2;
        if (TextUtils.isEmpty(a2)) {
            this.s = 2;
            return;
        }
        this.z.b(this);
        this.u = new v4(10, 4);
        this.C = new CopyOnWriteArrayList();
        this.B = new CopyOnWriteArrayList();
        this.D = new CopyOnWriteArrayList();
        this.q = new q4(this.z);
        this.r = new u4(this.z);
        this.o = m4.a(t3Var.f3944a);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                this.p = new i4(this.z.f3944a);
            } catch (Exception e2) {
                this.p = null;
            }
        }
        boolean z = Build.VERSION.SDK_INT >= 18;
        this.k = z;
        if (z) {
            this.i = null;
            x4 g = g();
            this.n = g;
            r4 e3 = e();
            this.j = e3;
            o4 d2 = d();
            this.l = d2;
            t4 f2 = f();
            this.m = f2;
            this.h = b6.a(g, e3, d2, f2);
        } else {
            this.j = null;
            x4 g2 = g();
            this.n = g2;
            k4 c2 = c();
            this.i = c2;
            o4 d3 = d();
            this.l = d3;
            t4 f3 = f();
            this.m = f3;
            this.h = b6.a(g2, c2, d3, f3);
        }
        if (this.h) {
            this.s = 1;
            return;
        }
        try {
            m0.a(this.z.f3944a, "txsdk", "7.4.9.official_1");
            m0.a(this.T);
        } catch (Throwable th4) {
        }
    }

    public int a(int i, TencentLocationListener tencentLocationListener) {
        return g4.a(this.z).a(i, tencentLocationListener);
    }

    public int a(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (this.s != 0) {
            return this.s;
        }
        m();
        this.Q = 404;
        this.M = null;
        synchronized (this.J) {
            if (tencentLocationListener != null) {
                if (this.B != null) {
                    this.B.add(tencentLocationListener);
                }
            }
        }
        if (tencentLocationListener == f0) {
            List<e> list = this.D;
            if (list != null && !list.isEmpty()) {
                this.A.d(this.D.get(0).a());
            }
            if (this.S == d.Stop || this.S == d.Single) {
                this.S = d.Single;
                h6.d = true;
            }
        } else {
            this.S = d.Normal;
            h6.d = false;
        }
        Bundle extras = tencentLocationRequest.getExtras();
        if (extras == null || extras.getString("LOCATION_URL_IOT") == null || !extras.getString("LOCATION_URL_IOT").equals(fw.Code)) {
            d0 = false;
        } else {
            d0 = true;
        }
        TencentLocationRequest.copy(this.K, tencentLocationRequest);
        if (this.K.isIndoorLocationMode()) {
            this.H = 1;
        }
        if (this.K.getGnssSource() == 20 || this.K.getGnssSource() == 21) {
            this.G = this.K.getGnssSource();
        }
        u3 u3Var = this.A;
        if (u3Var != null) {
            u3Var.d(System.currentTimeMillis());
            this.A.p();
            if (this.A.d().equals(this.A.e())) {
                this.z.l();
            }
            this.A.g(tencentLocationRequest.getQQ());
            this.A.h(tencentLocationRequest.getSmallAppKey());
            this.A.a(tencentLocationRequest.getInterval(), this.K.isIndoorLocationMode());
        }
        this.F = this.K.getInterval();
        b(looper);
        this.K.toString();
        if (this.K.getLocMode() == 10 && this.K.isGpsFirst()) {
            this.e.sendEmptyMessageDelayed(11997, this.K.getGpsFirstTimeOut());
            this.e.sendEmptyMessageDelayed(3997, this.K.getGpsFirstTimeOut());
            return 0;
        } else if (this.K.getLocMode() == 12) {
            this.e.sendEmptyMessageDelayed(11997, 8000L);
            return 0;
        } else {
            return 0;
        }
    }

    public final String a(String str) {
        try {
            if (!str.contains(",")) {
                int fun_v = SoUtils.fun_v(str);
                this.t = false;
                return fun_v >= 0 ? Integer.toString(fun_v) : "";
            }
            String[] split = str.split(",");
            boolean z = (split == null || split.length <= 1 || split[0] == null || split[1] == null || SoUtils.fun_w(split[0], split[1]) <= 0) ? false : true;
            if (z) {
                e0 = true;
            } else {
                this.t = false;
                e0 = false;
            }
            return z ? split[0] : "";
        } catch (UnsatisfiedLinkError e2) {
            return null;
        }
    }

    public final void a(int i) {
        if (this.e == null) {
            this.e = new c(this.z.g().getLooper());
        }
        this.e.sendEmptyMessage(i);
    }

    public final void a(int i, int i2, int i3) {
        String str;
        String str2;
        String str3;
        String str4 = "gps";
        String str5 = "unknown";
        switch (i2) {
            case 12001:
                if (i3 == 0) {
                    str5 = "wifi disabled";
                } else if (i3 == 1) {
                    str5 = "wifi enabled";
                } else if (i3 == 5) {
                    str5 = "location service switch is off";
                }
                str = str5;
                str4 = "wifi";
                if (i3 != 5) {
                    str = str5;
                    str4 = "wifi";
                    if (h6.f3785a) {
                        str2 = "wifi";
                        i3 = 2;
                        str3 = "location permission denied";
                        break;
                    }
                }
                str3 = str;
                str2 = str4;
                break;
            case 12002:
                if (i3 == 0) {
                    str3 = "gps disabled";
                    str2 = str4;
                    break;
                } else {
                    if (i3 == 1) {
                        str3 = "gps enabled";
                        str2 = str4;
                        break;
                    }
                    str = str5;
                    str3 = str;
                    str2 = str4;
                    break;
                }
            case 12003:
                str3 = i3 == 1 ? "cell enabled" : i3 == 0 ? "cell disabled" : "unknown";
                str2 = "cell";
                if (v5.f3980a) {
                    str2 = "cell";
                    i3 = 2;
                    str3 = "location permission denied";
                    break;
                }
                break;
            case 12004:
                if (i3 == 3) {
                    str3 = "gps available";
                    str2 = str4;
                    break;
                } else {
                    if (i3 == 4) {
                        str3 = "gps unavailable";
                        str2 = str4;
                        break;
                    }
                    str = str5;
                    str3 = str;
                    str2 = str4;
                    break;
                }
            default:
                str3 = null;
                str2 = null;
                break;
        }
        if (i2 == 12004) {
            if (this.b0 != i3) {
                s3.a(str2, "s:" + i3);
            }
            this.b0 = i3;
        } else {
            s3.a(str2, "s:" + i3);
        }
        f fVar = this.f;
        if (fVar != null) {
            Message obtainMessage = fVar.obtainMessage(3102);
            Bundle data = obtainMessage.getData();
            Bundle bundle = data;
            if (data == null) {
                bundle = new Bundle();
            }
            bundle.clear();
            bundle.putString("name", str2);
            bundle.putInt("status", i3);
            bundle.putString("desc", str3);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public final void a(int i, long j) {
        if (this.e == null) {
            this.e = new c(this.z.g().getLooper());
        }
        this.e.removeMessages(i);
        this.e.sendEmptyMessageDelayed(i, j);
    }

    public final void a(int i, q5 q5Var) {
        if (q5Var == null) {
            return;
        }
        if (i == 0 && q5Var.getLatitude() != 0.0d && q5Var.getLongitude() != 0.0d) {
            q5.b(q5Var, (this.d == 1 && w5.a(q5Var.getLatitude(), q5Var.getLongitude())) ? 1 : 0);
        }
        if (b()) {
            if (q5Var.getAccuracy() < 5000.0f && q5Var.getAccuracy() > 0.0f) {
                this.u.a((TencentLocation) q5Var);
            }
            this.N = q5Var.getLatitude();
            this.O = q5Var.getLongitude();
            if (b6.b(this.B) && this.B.size() > 0) {
                s();
            }
        } else if (i == 0 && q5Var.getLatitude() != 0.0d && q5Var.getLongitude() != 0.0d && Math.abs(q5Var.getLatitude() - this.N) >= 1.0E-8d && Math.abs(q5Var.getLongitude() - this.O) >= 1.0E-8d) {
            if (!this.u.a(q5Var, this.z, this.l.g())) {
                String str = "discard " + q5Var;
                return;
            }
            this.N = q5Var.getLatitude();
            this.O = q5Var.getLongitude();
            if (q5Var.getAccuracy() < 5000.0f && q5Var.getAccuracy() > 0.0f) {
                this.u.a(q5Var);
                this.u.a((TencentLocation) q5Var);
            }
        }
        boolean z = false;
        if (this.Q != 0) {
            z = false;
            if (i == 0) {
                z = true;
            }
        }
        this.Q = i;
        this.M = q5Var;
        q5Var.toString();
        if (this.K.getInterval() == 0 && b6.b(this.B) && !this.B.isEmpty()) {
            c cVar = this.e;
            a(11998);
        } else if (z && b6.b(this.B) && !this.B.isEmpty()) {
            c cVar2 = this.e;
            a(11998);
        }
    }

    public final void a(Looper looper) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (b6.a(this.f) || this.f.getLooper() != looper) {
            this.f = new f(looper);
        }
        this.f.removeCallbacksAndMessages(null);
        Handler handler = this.g;
        if (handler == null || handler.getLooper() != Looper.getMainLooper()) {
            this.g = new Handler(Looper.getMainLooper());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009a, code lost:
        if ((java.lang.System.currentTimeMillis() - r9.I) <= r0) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(c.t.m.g.a5 r10) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.p4.a(c.t.m.g.a5):void");
    }

    public final void a(b5 b5Var) {
        double d2;
        double d3;
        if (b5Var.f3715a == l4.f3825a) {
            return;
        }
        this.y = b5Var;
        int requestLevel = this.K.getRequestLevel();
        q5 q5Var = this.P;
        Location location = new Location(b5Var.f3715a);
        Bundle extras = location.getExtras();
        if (extras != null) {
            d2 = extras.getDouble("lat");
            d3 = extras.getDouble("lng");
        } else {
            d2 = 0.0d;
            d3 = 0.0d;
        }
        if (d2 == 0.0d && d3 == 0.0d) {
            s3.a(OapsKey.KEY_GRADE, "defl error");
            return;
        }
        if (b()) {
            c cVar = this.e;
            a(3999);
        }
        int a2 = e4.b().a(b5Var);
        q5 a3 = new q5.b().a(q5Var).b("gps").a(requestLevel).a(location.getExtras()).a(new Location(b5Var.f3715a)).a();
        location.setLatitude(d2);
        location.setLongitude(d3);
        a3.b(location);
        a3.c(a2);
        a3.getLatitude();
        a3.getLongitude();
        b();
        if (this.H != 2) {
            a(0, a3);
            a(a3, 0, 3103);
            a3.getLatitude();
            a3.getLongitude();
        }
        a(12999, 12004, 3);
    }

    public final void a(g5 g5Var) {
        c cVar = this.e;
        g5 g5Var2 = this.x;
        boolean a2 = g5Var2 != null ? g5Var2.a(g5Var) : false;
        if (a2) {
            this.I = System.currentTimeMillis();
        }
        List<ScanResult> emptyList = g5Var == null ? Collections.emptyList() : g5Var.a();
        StringBuilder sb = new StringBuilder();
        sb.append("len:");
        sb.append(emptyList.size());
        sb.append(",sim:");
        sb.append(a2 ? "1" : "0");
        StringBuilder sb2 = new StringBuilder(sb.toString());
        for (int i = 0; i < Math.min(3, emptyList.size()); i++) {
            ScanResult scanResult = emptyList.get(i);
            sb2.append(',');
            sb2.append(scanResult.BSSID.replaceAll(":", ""));
            sb2.append('_');
            sb2.append(scanResult.level);
        }
        s3.a("WIFI", sb2.toString());
        if (this.w == null || this.H == 2 || g5Var == g5.d || this.I == -1 || g5Var.a().size() < 3 || !a2) {
            s3.a("WIFI", "wifi req");
            c cVar2 = this.e;
            a(3999);
        }
        this.w = g5Var;
    }

    public final void a(q5 q5Var) {
        if (q5Var != null) {
            if (this.o != null && this.K.isAllowDirection()) {
                q5Var.getExtra().putDouble("direction", this.o.a());
            }
            try {
                q5Var.getExtra().putAll(this.K.getExtras());
            } catch (Exception e2) {
            }
        }
    }

    public final void a(q5 q5Var, int i, int i2) {
        synchronized (this) {
            if (q5Var != null) {
                if (this.f != null) {
                    q5Var.getLatitude();
                    q5Var.getLongitude();
                    Bundle extras = this.K.getExtras();
                    if (this.Y != 0 && i == 0) {
                        q5Var.a(this.Y);
                        q5Var.getNationCode();
                    } else if (i == 0 && extras != null && extras.containsKey(this.f3874a) && w()) {
                        String string = extras.getString(this.f3874a, "default");
                        if (!"default".equals(string)) {
                            this.b = string;
                            c3.b(this.e, 5999, i, i2, q5Var);
                            return;
                        }
                    }
                    Message obtainMessage = this.f.obtainMessage(i2);
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = q5Var;
                    obtainMessage.sendToTarget();
                    if (this.f.getLooper() == null || this.f.getLooper().getThread() == null || !this.f.getLooper().getThread().isAlive()) {
                        s3.a("U", i + ",user thread is invalid");
                    }
                    return;
                }
            }
            s3.a("G", "user handler is null or loc is null");
        }
    }

    public void a(TencentLocationListener tencentLocationListener) {
        List<TencentLocationListener> list;
        synchronized (this.J) {
            if (this.B != null) {
                if (tencentLocationListener != null) {
                    this.B.remove(tencentLocationListener);
                } else {
                    this.B.clear();
                }
            }
            if (this.C != null && !this.C.isEmpty()) {
                if (tencentLocationListener != null) {
                    this.C.remove(tencentLocationListener);
                } else {
                    this.C.clear();
                }
            }
            if (this.D != null) {
                if (tencentLocationListener != null) {
                    Iterator<e> it = this.D.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        e next = it.next();
                        if (next.f3882a.equals(tencentLocationListener)) {
                            this.D.remove(next);
                            break;
                        }
                    }
                } else {
                    this.D.clear();
                }
            }
        }
        List<TencentLocationListener> list2 = this.C;
        if (list2 == null || !list2.isEmpty() || (list = this.B) == null || !list.isEmpty()) {
            return;
        }
        synchronized (this.Z) {
            o();
            try {
                if (this.e != null) {
                    this.e.b();
                    this.e = null;
                }
            } catch (Throwable th) {
            }
        }
        m();
        q();
    }

    public final boolean a(int i, int i2) {
        List<TencentLocationListener> list = this.C;
        if (list == null || list.isEmpty() || this.Q != 0 || this.M == null || this.A.p() == 0) {
            return false;
        }
        if (!"gps".equals(this.M.getProvider()) || System.currentTimeMillis() - this.M.getTime() > i) {
            return "network".equals(this.M.getProvider()) && System.currentTimeMillis() - this.M.getTime() <= ((long) i2);
        }
        return true;
    }

    public final boolean a(TencentLocationRequest tencentLocationRequest) {
        if ((tencentLocationRequest.isGpsFirst() && tencentLocationRequest.getLocMode() == 10) || tencentLocationRequest.getLocMode() == 12) {
            boolean z = false;
            if ("gps".equals(this.M.getProvider())) {
                z = false;
                if (System.currentTimeMillis() - this.M.getTime() <= 5000) {
                    z = true;
                }
            }
            return z;
        } else if (tencentLocationRequest.getLocMode() == 11) {
            boolean z2 = false;
            if ("network".equals(this.M.getProvider())) {
                z2 = false;
                if (System.currentTimeMillis() - this.M.getTime() <= 5000) {
                    z2 = true;
                }
            }
            return z2;
        } else {
            return true;
        }
    }

    public int b(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        List<e> list;
        List<TencentLocationListener> list2;
        if (this.s != 0) {
            return this.s;
        }
        if (tencentLocationListener != null && (list2 = this.C) != null) {
            list2.add(tencentLocationListener);
        }
        if (tencentLocationListener != null && (list = this.D) != null) {
            list.add(new e(this, tencentLocationListener, System.currentTimeMillis()));
        }
        if (System.currentTimeMillis() - this.E < 2000) {
            return 0;
        }
        this.E = System.currentTimeMillis();
        if (a(com.anythink.expressad.foundation.g.a.bM, 30000) && a(tencentLocationRequest)) {
            a(this.M, this.Q, 3103);
            return 0;
        } else if (this.S == d.Normal) {
            a(3997);
            c cVar = this.e;
            return 0;
        } else {
            if (tencentLocationRequest != null) {
                tencentLocationRequest.setSmallAppKey(tencentLocationRequest.getSmallAppKey()).setInterval(0L);
            } else {
                tencentLocationRequest = TencentLocationRequest.create().setInterval(0L);
                tencentLocationRequest.setAllowGPS(false);
            }
            return a(tencentLocationRequest, f0, looper);
        }
    }

    public void b(int i) {
        if (this.d == i) {
            return;
        }
        synchronized (this.J) {
            if (b6.b(this.B) && !this.B.isEmpty()) {
                throw new IllegalStateException("removeUpdates MUST called before set coordinate type!");
            }
        }
        this.d = i;
    }

    public void b(int i, TencentLocationListener tencentLocationListener) {
        g4.a(this.z).b(i, tencentLocationListener);
    }

    public final void b(Looper looper) {
        List<TencentLocationListener> list;
        if (this.S != d.Single || (list = this.C) == null || list.size() < 2) {
            synchronized (this.Z) {
                a(looper);
                o();
                t();
            }
        }
    }

    public final boolean b() {
        return this.Q == 404;
    }

    public final boolean b(q5 q5Var) {
        return (this.K.getLocMode() == 10 && this.K.isGpsFirst() && !q5Var.getProvider().equals("gps")) ? false : true;
    }

    public final k4 c() {
        if (this.z.i()) {
            return new k4(this.z);
        }
        return null;
    }

    public final o4 d() {
        if (this.z.h()) {
            return new o4(this.z, this.t);
        }
        return null;
    }

    public final r4 e() {
        if (this.z.i()) {
            return new r4(this.z);
        }
        return null;
    }

    public final t4 f() {
        if (this.z.h() && h5.f3784a) {
            return new t4(this.z);
        }
        return null;
    }

    public final x4 g() {
        if (this.z.j()) {
            return new x4(this.z);
        }
        return null;
    }

    public final c.t.m.g.c h() {
        try {
            u3 a2 = this.z.a();
            return new c.t.m.g.c(a2.c(), "7.4.9.official_1", a2.a());
        } catch (Throwable th) {
            return new c.t.m.g.c("unknown", "unknown", "unknown");
        }
    }

    public int i() {
        return this.d;
    }

    public final c5 j() {
        g5 g5Var = this.w;
        a5 a5Var = this.v;
        b5 b5Var = this.y;
        b5 b5Var2 = b5Var;
        if (b5Var != null) {
            b5Var2 = b5Var;
            if (!l()) {
                b5Var2 = null;
            }
        }
        a5 a5Var2 = a5Var;
        if (a5Var == null) {
            a5Var2 = a5.a(this.z);
        }
        g5 g5Var2 = g5Var;
        if (g5Var != null) {
            g5Var2 = g5Var;
            if (!g5Var.a(System.currentTimeMillis(), 60000L)) {
                g5Var2 = null;
            }
        }
        a5 a5Var3 = a5Var2;
        if (a5Var2 != null) {
            a5Var3 = a5Var2;
            if (b5Var2 != null) {
                a5Var3 = a5Var2;
                if (Build.VERSION.SDK_INT >= 12) {
                    int i = a5Var2.d;
                    long j = a5Var2.f;
                    Location location = b5Var2.f3715a;
                    Bundle bundle = new Bundle();
                    bundle.putString("cellkey", i + "" + j);
                    bundle.putParcelable("location", location);
                    v3 a2 = this.z.a("cell");
                    a5Var3 = a5Var2;
                    if (a2 != null) {
                        a5Var3 = a5Var2;
                        if (!a2.a(bundle)) {
                            a5Var3 = null;
                        }
                    }
                }
            }
        }
        i4 i4Var = this.p;
        List<z4> list = null;
        if (i4Var != null) {
            list = i4Var.a();
        }
        return new c5(g5Var2, a5Var3, b5Var2, list);
    }

    public TencentLocation k() {
        if (this.Q == 0) {
            a(this.M);
            return this.M;
        }
        return null;
    }

    public final boolean l() {
        o4 o4Var = this.l;
        boolean z = false;
        if (o4Var != null) {
            z = false;
            if (o4Var.g()) {
                z = false;
                if (this.l.f()) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final void m() {
        v3 a2;
        this.H = 0;
        this.w = null;
        this.v = null;
        this.y = null;
        this.P = null;
        this.I = 0L;
        c5.e = 0L;
        this.W = false;
        this.X = false;
        this.f3875c = -1;
        this.S = d.Stop;
        this.E = 0L;
        this.L = 0L;
        this.Y = 0;
        if (Build.VERSION.SDK_INT >= 12 && (a2 = this.z.a("cell")) != null) {
            a2.a();
        }
        u3 u3Var = this.A;
        if (u3Var != null) {
            u3Var.c("");
            this.A.a(0L);
            this.A.b(0L);
            this.A.d(0L);
            this.A.c(0L);
            this.A.e("");
        }
        e4.b().c();
    }

    public final int n() {
        x4 x4Var = this.n;
        int c2 = x4Var != null ? x4Var.c() : 1;
        if (c2 != 0) {
            this.w = null;
        }
        return c2;
    }

    public final void o() {
        v5.f3980a = false;
        if (b6.b(this.q)) {
            this.q.a();
        }
        if (b6.b(this.r)) {
            this.r.c();
        }
        if (b6.b(this.u)) {
            this.u.b();
        }
        if (b6.b(this.n)) {
            this.n.d();
        }
        if (this.k) {
            if (b6.b(this.j)) {
                this.j.b();
            }
        } else if (b6.b(this.i)) {
            this.i.f();
        }
        if (b6.b(this.l)) {
            this.l.l();
        }
        if (b6.b(this.m)) {
            this.m.a();
        }
        if (b6.b(this.o) && this.K.isAllowDirection()) {
            this.o.b();
        }
        if (b6.b(this.p)) {
            this.p.b();
        }
        c.t.m.g.b bVar = this.U;
        if (bVar != null) {
            bVar.f();
            this.U = null;
        }
        s3 s3Var = this.V;
        if (s3Var != null) {
            s3Var.c();
            this.V = null;
        }
        try {
            m0.h().c();
        } catch (Exception e2) {
        }
    }

    public void onCellInfoEvent(a5 a5Var) {
        a(a5Var);
        if (this.U != null) {
            c.t.m.g.d dVar = new c.t.m.g.d(a5Var.b, a5Var.f3702c, a5Var.d, a5Var.f, a5Var.e, a5Var.f3701a.ordinal());
            ArrayList arrayList = new ArrayList();
            arrayList.add(dVar);
            this.U.a(dVar, arrayList);
        }
    }

    public void onGpsInfoEvent(b5 b5Var) {
        a(b5Var);
        c.t.m.g.b bVar = this.U;
        if (bVar != null) {
            bVar.a(b5Var.f3715a);
        }
    }

    public void onNetworkEvent(Integer num) {
        a6.b(this.z.f3944a);
        int intValue = num.intValue();
        if (intValue == 0 || intValue != 1) {
            return;
        }
        a(7999, 1000L);
    }

    public void onStatusEvent(Message message) {
        a(message.what, message.arg1, message.arg2);
    }

    public void onWifiInfoEvent(g5 g5Var) {
        c cVar = this.e;
        a(g5Var);
        c.t.m.g.b bVar = this.U;
        if (bVar != null) {
            bVar.a(g5Var.a());
        }
    }

    public final void p() {
        this.E = 0L;
        if (this.S == d.Single) {
            a((TencentLocationListener) null);
        }
    }

    public final void q() {
        if (!n0.b().b("start_daemon")) {
            this.S = d.Stop;
            return;
        }
        if (this.S == d.Normal && h6.a(this.z).equalsIgnoreCase("{}")) {
            try {
                new Handler(this.z.g().getLooper()).postDelayed(new b(), 5000L);
                this.R = System.currentTimeMillis();
            } catch (Throwable th) {
            }
        } else {
            String str = "daemon not start! is wifi or running status=" + this.S;
        }
        this.S = d.Stop;
    }

    public boolean r() {
        this.H = 1;
        s3.a("LOC", "start indoor");
        return true;
    }

    public final void s() {
        if (this.K.getInterval() > 0) {
            a(11999, this.K.getInterval());
            this.K.getInterval();
        }
    }

    public final void t() {
        c cVar = this.e;
        if (cVar == null) {
            this.e = new c(this.z.g().getLooper());
        } else {
            cVar.b();
        }
        if (n0.b().b("deny_secret_info")) {
            q3.a(true);
        }
        boolean v = v();
        boolean z = false;
        boolean z2 = d.Daemon == this.S;
        c cVar2 = this.e;
        s3 h = s3.h();
        this.V = h;
        if (h != null && !z2) {
            boolean booleanValue = ((Boolean) s2.a("CONF_USER_DEBUGGABLE", Boolean.FALSE)).booleanValue();
            this.V.a(booleanValue);
            if (booleanValue) {
                this.V.e();
                s3.a("LOC", "request {interval: " + this.K.getInterval() + ", level: " + this.K.getRequestLevel() + ", gps: " + this.K.isAllowGPS() + ", direct: " + this.K.isAllowDirection() + "}");
            }
        }
        this.r.a(cVar2, z2);
        if (this.k) {
            if (v && b6.b(this.j) && b6.b(cVar2)) {
                this.j.a(cVar2, z2);
            }
        } else if (v && b6.b(this.i) && b6.b(cVar2)) {
            this.i.a(cVar2);
        }
        if (v && b6.b(this.n) && b6.b(cVar2)) {
            this.n.b(this.A.r());
            this.n.a(cVar2, this.f, this.g, z2);
        }
        if (b6.b(this.l) && this.K.isAllowGPS() && b6.b(cVar2)) {
            o4 o4Var = this.l;
            if (this.d == 1) {
                z = true;
            }
            o4Var.c(z);
            if (!this.t) {
                this.G = 20;
            }
            this.l.b(this.G);
            this.l.b(this.t);
            this.l.a(cVar2, this.f, this.g, z2);
        }
        if (!z2) {
            if (!n0.b().b("collect_bles")) {
                this.p = null;
            }
            if (b6.b(this.p) && b6.b(cVar2)) {
                this.p.a(cVar2);
            }
            if (b6.b(cVar2)) {
                this.q.b(cVar2);
            }
            if (b6.b(this.o) && this.K.isAllowDirection() && b6.b(cVar2)) {
                this.o.a(cVar2);
            }
        }
        if (cVar2 != null) {
            cVar2.sendEmptyMessageDelayed(3991, 10000L);
        }
        if (b6.b(cVar2)) {
            int c2 = n0.b().c("f_coll_item");
            if ((c2 == 1 || c2 == 2) && this.U == null) {
                this.U = new c.t.m.g.b(this.z.f3944a);
            } else {
                this.U = null;
            }
            if (this.U != null && cVar2 != null) {
                c.t.m.g.b.b();
                if (c2 == 2 || (c2 == 1 && !z2)) {
                    this.U.a(h());
                    this.U.a("D_UP_NET", n0.b().e("f_coll_up_net"));
                    this.U.a("D_UP_U_TRACK_INFO", Boolean.toString(true));
                    this.U.a(cVar2.getLooper());
                }
            }
        }
        s3.a("m", q3.f());
        c cVar3 = this.e;
    }

    public boolean u() {
        if (this.H > 0) {
            if (b6.b(this.n)) {
                this.n.b(this.A.r());
            }
            if (b6.b(Long.valueOf(this.F))) {
                this.F = this.K.getInterval();
            }
            this.H = 0;
        }
        s3.a("LOC", "stop indoor");
        return true;
    }

    public final boolean v() {
        Bundle extras = this.K.getExtras();
        boolean z = true;
        if (extras != null) {
            z = extras.getBoolean("use_network", true);
        }
        return z;
    }

    public final boolean w() {
        int i = this.f3875c;
        return (i < 110 || i > 199) && this.f3875c != 311;
    }
}
