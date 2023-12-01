package com.autonavi.aps.amapapi.restruct;

import android.app.backup.FullBackup;
import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiSsid;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.mq;
import com.umeng.analytics.pro.bh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/i.class */
public final class i {
    static long d;
    static long e;
    static long f;
    public static long g;
    static long h;
    private com.autonavi.aps.amapapi.c E;

    /* renamed from: a  reason: collision with root package name */
    WifiManager f9257a;
    Context i;
    h t;
    public static HashMap<String, Long> w = new HashMap<>(36);
    public static long x = 0;
    static int y = 0;
    public static long A = 0;
    ArrayList<mq> b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<mq> f9258c = new ArrayList<>();
    boolean j = false;
    StringBuilder k = null;
    boolean l = true;
    boolean m = true;
    boolean n = true;
    private volatile WifiInfo C = null;
    String o = null;
    TreeMap<Integer, mq> p = null;
    public boolean q = true;
    public boolean r = true;
    public boolean s = false;
    String u = "";
    long v = 0;
    ConnectivityManager z = null;
    private long D = 30000;
    volatile boolean B = false;

    public i(Context context, WifiManager wifiManager, Handler handler) {
        this.f9257a = wifiManager;
        this.i = context;
        h hVar = new h(context, "wifiAgee", handler);
        this.t = hVar;
        hVar.a();
    }

    private void A() {
        try {
            if (com.autonavi.aps.amapapi.utils.i.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.r = this.f9257a.isWifiEnabled();
            }
        } catch (Throwable th) {
        }
    }

    private boolean B() {
        this.q = v();
        A();
        if (this.q && this.l) {
            if (f == 0) {
                return true;
            }
            if (com.autonavi.aps.amapapi.utils.i.b() - f >= 4900 && com.autonavi.aps.amapapi.utils.i.b() - g >= com.igexin.push.config.c.j) {
                com.autonavi.aps.amapapi.utils.i.b();
                long j = g;
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean a(int i) {
        int i2;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e2) {
            com.autonavi.aps.amapapi.utils.b.a(e2, "Aps", "wifiSigFine");
            i2 = 20;
        }
        return i2 > 0;
    }

    public static boolean a(WifiInfo wifiInfo) {
        return (wifiInfo == null || TextUtils.isEmpty(wifiInfo.getSSID()) || !com.autonavi.aps.amapapi.utils.i.a(wifiInfo.getBSSID())) ? false : true;
    }

    public static long b() {
        return ((com.autonavi.aps.amapapi.utils.i.b() - x) / 1000) + 1;
    }

    private void d(boolean z) {
        ArrayList<mq> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (com.autonavi.aps.amapapi.utils.i.b() - g > 3600000) {
            g();
        }
        if (this.p == null) {
            this.p = new TreeMap<>(Collections.reverseOrder());
        }
        this.p.clear();
        if (this.s && z) {
            try {
                this.f9258c.clear();
            } catch (Throwable th) {
            }
        }
        int size = this.b.size();
        this.v = 0L;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            mq mqVar = this.b.get(i2);
            if (mqVar.h) {
                this.v = mqVar.f;
            }
            if (com.autonavi.aps.amapapi.utils.i.a(mqVar != null ? mq.a(mqVar.f5387a) : "") && (size <= 20 || a(mqVar.f5388c))) {
                if (this.s && z) {
                    this.f9258c.add(mqVar);
                }
                if (TextUtils.isEmpty(mqVar.b)) {
                    mqVar.b = "unkwn";
                } else if (!WifiSsid.NONE.equals(mqVar.b)) {
                    mqVar.b = String.valueOf(i2);
                }
                this.p.put(Integer.valueOf((mqVar.f5388c * 25) + i2), mqVar);
            }
            i = i2 + 1;
        }
        this.b.clear();
        for (mq mqVar2 : this.p.values()) {
            this.b.add(mqVar2);
        }
        this.p.clear();
    }

    public static String p() {
        return String.valueOf(com.autonavi.aps.amapapi.utils.i.b() - g);
    }

    private List<mq> r() {
        List<ScanResult> list;
        if (this.f9257a != null) {
            try {
                if (com.autonavi.aps.amapapi.utils.i.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    list = this.f9257a.getScanResults();
                } else {
                    com.autonavi.aps.amapapi.utils.b.a(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    list = null;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    if (list != null) {
                        for (ScanResult scanResult : list) {
                            hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                        }
                    }
                    if (w.isEmpty() || !w.equals(hashMap)) {
                        w = hashMap;
                        x = com.autonavi.aps.amapapi.utils.i.b();
                    }
                } else {
                    x = com.autonavi.aps.amapapi.utils.i.b();
                }
                this.o = null;
                ArrayList arrayList = new ArrayList();
                this.u = "";
                this.C = m();
                if (a(this.C)) {
                    this.u = this.C.getBSSID();
                }
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        ScanResult scanResult2 = list.get(i2);
                        mq mqVar = new mq(!TextUtils.isEmpty(this.u) && this.u.equals(scanResult2.BSSID));
                        mqVar.b = scanResult2.SSID;
                        mqVar.d = scanResult2.frequency;
                        mqVar.e = scanResult2.timestamp;
                        mqVar.f5387a = mq.a(scanResult2.BSSID);
                        mqVar.f5388c = (short) scanResult2.level;
                        if (Build.VERSION.SDK_INT >= 17) {
                            mqVar.g = (short) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                            if (mqVar.g < 0) {
                                mqVar.g = (short) 0;
                            }
                        }
                        mqVar.f = com.autonavi.aps.amapapi.utils.i.b();
                        arrayList.add(mqVar);
                        i = i2 + 1;
                    }
                }
                this.t.a((List) arrayList);
                return arrayList;
            } catch (SecurityException e2) {
                this.o = e2.getMessage();
                return null;
            } catch (Throwable th) {
                this.o = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getScanResults");
                return null;
            }
        }
        return null;
    }

    private int s() {
        WifiManager wifiManager = this.f9257a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean t() {
        long b = com.autonavi.aps.amapapi.utils.i.b() - d;
        if (b < 4900) {
            return false;
        }
        if (!u() || b >= 9900) {
            if (y > 1) {
                long j = this.D;
                if (j == 30000) {
                    j = com.autonavi.aps.amapapi.utils.a.n() != -1 ? com.autonavi.aps.amapapi.utils.a.n() : 30000L;
                }
                if (Build.VERSION.SDK_INT >= 28 && b < j) {
                    return false;
                }
            }
            if (this.f9257a != null) {
                d = com.autonavi.aps.amapapi.utils.i.b();
                int i = y;
                if (i < 2) {
                    y = i + 1;
                }
                if (com.autonavi.aps.amapapi.utils.i.c(this.i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                    return this.f9257a.startScan();
                }
                com.autonavi.aps.amapapi.utils.b.a(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean u() {
        if (this.z == null) {
            this.z = (ConnectivityManager) com.autonavi.aps.amapapi.utils.i.a(this.i, Context.CONNECTIVITY_SERVICE);
        }
        return a(this.z);
    }

    private boolean v() {
        if (this.f9257a == null) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.i.g(this.i);
    }

    private void w() {
        if (B()) {
            long b = com.autonavi.aps.amapapi.utils.i.b();
            if (b - e >= 10000) {
                this.b.clear();
                h = g;
            }
            x();
            if (b - e >= 10000) {
                for (int i = 20; i > 0 && g == h; i--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    private void x() {
        if (B()) {
            try {
                if (t()) {
                    f = com.autonavi.aps.amapapi.utils.i.b();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void y() {
        if (h != g) {
            List<mq> list = null;
            try {
                list = r();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "updateScanResult");
            }
            h = g;
            if (list == null) {
                this.b.clear();
                return;
            }
            this.b.clear();
            this.b.addAll(list);
        }
    }

    private void z() {
        try {
            if (this.f9257a == null) {
                return;
            }
            int s = s();
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            if (s == 0 || s == 1 || s == 4) {
                g();
            }
        } catch (Throwable th) {
        }
    }

    public final ArrayList<mq> a() {
        if (this.s) {
            b(true);
            return this.f9258c;
        }
        return this.f9258c;
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.E = cVar;
    }

    public final void a(boolean z) {
        Context context = this.i;
        if (!com.autonavi.aps.amapapi.utils.a.m() || !this.n || this.f9257a == null || context == null || !z || com.autonavi.aps.amapapi.utils.i.c() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) com.autonavi.aps.amapapi.utils.e.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, Settings.Global.WIFI_SCAN_ALWAYS_AVAILABLE}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                com.autonavi.aps.amapapi.utils.e.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, Settings.Global.WIFI_SCAN_ALWAYS_AVAILABLE, 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public final void a(boolean z, boolean z2, boolean z3, long j) {
        this.l = z;
        this.m = z2;
        this.n = z3;
        if (j < 10000) {
            this.D = 10000L;
        } else {
            this.D = j;
        }
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        try {
            if (com.autonavi.aps.amapapi.utils.i.a(connectivityManager.getActiveNetworkInfo()) == 1) {
                return a(c());
            }
            return false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void b(boolean z) {
        if (z) {
            w();
        } else {
            x();
        }
        if (this.B) {
            this.B = false;
            z();
        }
        y();
        if (com.autonavi.aps.amapapi.utils.i.b() - g > 20000) {
            this.b.clear();
        }
        e = com.autonavi.aps.amapapi.utils.i.b();
        boolean z2 = false;
        if (this.b.isEmpty()) {
            g = com.autonavi.aps.amapapi.utils.i.b();
            List<mq> r = r();
            z2 = false;
            if (r != null) {
                this.b.addAll(r);
                z2 = true;
            }
        }
        d(z2);
    }

    public final WifiInfo c() {
        try {
            if (this.f9257a != null) {
                if (com.autonavi.aps.amapapi.utils.i.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    return this.f9257a.getConnectionInfo();
                }
                com.autonavi.aps.amapapi.utils.b.a(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
                return null;
            }
            return null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final void c(boolean z) {
        g();
        this.b.clear();
        this.t.a(z);
    }

    public final String d() {
        return this.o;
    }

    public final ArrayList<mq> e() {
        if (this.b == null) {
            return null;
        }
        ArrayList<mq> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void f() {
        try {
            this.s = true;
            List<mq> r = r();
            if (r != null) {
                this.b.clear();
                this.b.addAll(r);
            }
            d(true);
        } catch (Throwable th) {
        }
    }

    public final void g() {
        this.C = null;
        this.b.clear();
    }

    public final void h() {
        A = System.currentTimeMillis();
        com.autonavi.aps.amapapi.c cVar = this.E;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void i() {
        if (this.f9257a != null && com.autonavi.aps.amapapi.utils.i.b() - g > 4900) {
            g = com.autonavi.aps.amapapi.utils.i.b();
        }
    }

    public final void j() {
        if (this.f9257a == null) {
            return;
        }
        this.B = true;
    }

    public final boolean k() {
        return this.q;
    }

    public final boolean l() {
        return this.r;
    }

    public final WifiInfo m() {
        this.C = c();
        return this.C;
    }

    public final boolean n() {
        return this.j;
    }

    public final String o() {
        Object obj;
        StringBuilder sb = this.k;
        if (sb == null) {
            this.k = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.j = false;
        int size = this.b.size();
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < size) {
            String a2 = mq.a(this.b.get(i).f5387a);
            boolean z3 = z;
            if (!this.m) {
                z3 = z;
                if (!WifiSsid.NONE.equals(this.b.get(i).b)) {
                    z3 = true;
                }
            }
            if (TextUtils.isEmpty(this.u) || !this.u.equals(a2)) {
                obj = FullBackup.NO_BACKUP_TREE_TOKEN;
            } else {
                obj = bh.Q;
                z2 = true;
            }
            this.k.append(String.format(Locale.US, "#%s,%s", a2, obj));
            i++;
            z = z3;
        }
        if (this.b.size() == 0) {
            z = true;
        }
        if (!this.m && !z) {
            this.j = true;
        }
        if (!z2 && !TextUtils.isEmpty(this.u)) {
            StringBuilder sb2 = this.k;
            sb2.append("#");
            sb2.append(this.u);
            this.k.append(",access");
        }
        return this.k.toString();
    }

    public final long q() {
        return this.v;
    }
}
