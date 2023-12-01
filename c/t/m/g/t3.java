package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t3.class */
public class t3 {
    public static HandlerThread n;
    public static volatile t3 o;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3944a;
    public final u3 b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f3945c;
    public final HashMap<String, v3> d;
    public final PackageManager e;
    public final TelephonyManager f;
    public final WifiManager g;
    public final LocationManager h;
    public final i5 i;
    public CountDownLatch j;
    public String k;
    public t5 l;
    public List<z6> m;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t3$a.class */
    public class a implements ThreadFactory {
        public a(t3 t3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "network_request_pool");
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t3$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t3.this.m();
            t3.this.j.countDown();
        }
    }

    public t3(Context context) {
        this.f3944a = context;
        this.e = context.getPackageManager();
        this.f = (TelephonyManager) context.getSystemService("phone");
        this.g = (WifiManager) context.getSystemService("wifi");
        this.h = (LocationManager) context.getSystemService("location");
        this.l = new u5(context);
        this.i = new s4(context, g6.a(context.getPackageName()));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f3945c = threadPoolExecutor;
        HandlerThread handlerThread = new HandlerThread("GeoLocationService");
        n = handlerThread;
        handlerThread.start();
        HashMap<String, v3> hashMap = new HashMap<>();
        this.d = hashMap;
        if (Build.VERSION.SDK_INT >= 12) {
            hashMap.put("cell", new w3("cell"));
        }
        this.b = new u3();
        try {
            this.b.d(b(context));
        } catch (Exception e) {
        }
        d6.a(context.getApplicationContext());
        l();
    }

    public static t3 a(Context context) {
        if (o == null) {
            synchronized (t3.class) {
                try {
                    if (o == null) {
                        o = new t3(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return o;
    }

    public static String b(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            return bundle != null ? bundle.containsKey("TencentGeoLocationSDK") ? bundle.getString("TencentGeoLocationSDK") : bundle.containsKey("TencentMapSDK") ? bundle.getString("TencentMapSDK") : "" : "";
        } catch (Exception e) {
            return "";
        }
    }

    public Bundle a(String str, byte[] bArr, boolean z) throws IOException {
        System.currentTimeMillis();
        Bundle a2 = this.i.a(str, bArr);
        System.currentTimeMillis();
        a2.getString("req_key");
        byte[] b2 = z ? g6.b(a2.getByteArray("data_bytes")) : a2.getByteArray("data_bytes");
        String str2 = b2 != null ? new String(b2, a2.getString("data_charset")) : "{}";
        a2.remove("data_charset");
        a2.remove("data_bytes");
        a2.putString("result", str2);
        return a2;
    }

    public u3 a() {
        return this.b;
    }

    public v3 a(String str) {
        return this.d.get(str);
    }

    public void a(Object obj) {
        synchronized (this) {
            boolean z = obj instanceof g5;
            if (obj == null) {
                return;
            }
            List<z6> list = this.m;
            if (list != null) {
                for (z6 z6Var : list) {
                    if (z6Var.a(obj)) {
                        try {
                            z6Var.a().invoke(z6Var.b(), obj);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    public LocationManager b() {
        return this.h;
    }

    public String b(String str) {
        return this.i.a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
        throw new java.lang.IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.t3.b(java.lang.Object):void");
    }

    public t5 c() {
        return this.l;
    }

    public TelephonyManager d() {
        return this.f;
    }

    public ExecutorService e() {
        return this.f3945c;
    }

    public WifiManager f() {
        return this.g;
    }

    public HandlerThread g() {
        HandlerThread handlerThread;
        synchronized (t3.class) {
            try {
                if (n == null || n.getLooper() == null || !n.isAlive()) {
                    HandlerThread handlerThread2 = new HandlerThread("GeoLocationService");
                    n = handlerThread2;
                    handlerThread2.start();
                }
                handlerThread = n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handlerThread;
    }

    public boolean h() {
        return this.h != null;
    }

    public boolean i() {
        return this.f != null;
    }

    public boolean j() {
        return this.g != null;
    }

    public final void k() {
        u3 u3Var = this.b;
        PackageInfo n2 = n();
        u3Var.b(n2.versionCode);
        u3Var.j(n2.versionName);
        CharSequence loadLabel = this.f3944a.getApplicationInfo().loadLabel(this.e);
        u3Var.a(loadLabel != null ? loadLabel.toString() : "unknown");
        try {
            TelephonyManager d = d();
            if (d != null) {
                this.k = c6.a(q3.h(), c6.f3731a).toUpperCase(Locale.ENGLISH);
                String a2 = c6.a(q3.j(), c6.b);
                u3Var.a(d.getPhoneType());
                u3Var.b(this.k);
                u3Var.i(a2);
            }
        } catch (Throwable th) {
        }
        u3Var.f(c6.a(q3.l().replaceAll(":", "").toUpperCase(Locale.ENGLISH), c6.f3732c));
        PackageManager packageManager = this.e;
        boolean hasSystemFeature = packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
        boolean hasSystemFeature2 = packageManager.hasSystemFeature(PackageManager.FEATURE_WIFI);
        boolean hasSystemFeature3 = packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
        u3Var.b(hasSystemFeature);
        u3Var.c(hasSystemFeature2);
        u3Var.a(hasSystemFeature3);
    }

    public void l() {
        this.j = new CountDownLatch(1);
        new Thread(new b()).start();
    }

    public void m() {
        try {
            k();
        } catch (Throwable th) {
        }
    }

    public final PackageInfo n() {
        try {
            return this.e.getPackageInfo(this.f3944a.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            return new PackageInfo();
        }
    }
}
