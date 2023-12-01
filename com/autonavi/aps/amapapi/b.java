package com.autonavi.aps.amapapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.iw;
import com.amap.api.col.p0003sl.kc;
import com.amap.api.col.p0003sl.mq;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.g;
import com.autonavi.aps.amapapi.restruct.i;
import com.autonavi.aps.amapapi.trans.f;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/b.class */
public final class b {
    static int C = -1;
    private static boolean M = false;
    boolean H;
    private Handler P;
    private g Q;
    private String R;
    private c T;
    public static String[] F = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public static String G = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static volatile boolean S = false;

    /* renamed from: a  reason: collision with root package name */
    Context f9222a = null;
    ConnectivityManager b = null;

    /* renamed from: c  reason: collision with root package name */
    i f9223c = null;
    e d = null;
    com.autonavi.aps.amapapi.storage.a e = null;
    com.autonavi.aps.amapapi.trans.e f = null;
    ArrayList<mq> g = new ArrayList<>();
    a h = null;
    AMapLocationClientOption i = new AMapLocationClientOption();
    com.autonavi.aps.amapapi.model.a j = null;
    long k = 0;
    private int K = 0;
    f l = null;
    boolean m = false;
    private String L = null;
    com.autonavi.aps.amapapi.trans.c n = null;
    StringBuilder o = new StringBuilder();
    boolean p = true;
    boolean q = true;
    AMapLocationClientOption.GeoLanguage r = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean s = true;
    boolean t = false;
    WifiInfo u = null;
    boolean v = true;
    private String N = null;
    StringBuilder w = null;
    boolean x = false;
    public boolean y = false;
    int z = 12;
    private boolean O = true;
    com.autonavi.aps.amapapi.restruct.b A = null;
    boolean B = false;
    com.autonavi.aps.amapapi.filters.a D = null;
    String E = null;
    IntentFilter I = null;
    LocationManager J = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.autonavi.aps.amapapi.b$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/b$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9224a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            f9224a = iArr;
            try {
                iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9224a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9224a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/b$a.class */
    public final class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (!action.equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                    if (!action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION) || b.this.f9223c == null) {
                        return;
                    }
                    b.this.f9223c.j();
                    return;
                }
                if (b.this.f9223c != null) {
                    b.this.f9223c.i();
                }
                try {
                    if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || b.this.f9223c == null) {
                        return;
                    }
                    b.this.f9223c.h();
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                com.autonavi.aps.amapapi.utils.b.a(th2, "Aps", "onReceive");
            }
        }
    }

    public b(boolean z) {
        this.H = false;
        this.H = z;
    }

    private static com.autonavi.aps.amapapi.model.a a(int i, String str) {
        com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
        aVar.setErrorCode(i);
        aVar.setLocationDetail(str);
        if (i == 15) {
            com.autonavi.aps.amapapi.utils.g.a((String) null, 2151);
        }
        return aVar;
    }

    private com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar, kc kcVar, com.autonavi.aps.amapapi.a aVar2) {
        if (kcVar != null) {
            try {
                if (kcVar.f5264a != null && kcVar.f5264a.length != 0) {
                    com.autonavi.aps.amapapi.trans.e eVar = new com.autonavi.aps.amapapi.trans.e();
                    String str = new String(kcVar.f5264a, "UTF-8");
                    if (str.contains("\"status\":\"0\"")) {
                        com.autonavi.aps.amapapi.model.a a2 = eVar.a(str, this.f9222a, kcVar, aVar2);
                        a2.h(this.w.toString());
                        return a2;
                    } else if (str.contains("</body></html>")) {
                        aVar.setErrorCode(5);
                        if (this.f9223c == null || !this.f9223c.a(this.b)) {
                            aVar2.f("#0502");
                            this.o.append("请求可能被劫持了#0502");
                            com.autonavi.aps.amapapi.utils.g.a((String) null, 2052);
                        } else {
                            aVar2.f("#0501");
                            this.o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                            com.autonavi.aps.amapapi.utils.g.a((String) null, 2051);
                        }
                        aVar.setLocationDetail(this.o.toString());
                        return aVar;
                    } else {
                        return null;
                    }
                }
            } catch (Throwable th) {
                aVar.setErrorCode(4);
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "checkResponseEntity");
                aVar2.f("#0403");
                StringBuilder sb = this.o;
                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                aVar.setLocationDetail(this.o.toString());
                return aVar;
            }
        }
        aVar.setErrorCode(4);
        this.o.append("网络异常,请求异常#0403");
        aVar2.f("#0403");
        aVar.h(this.w.toString());
        aVar.setLocationDetail(this.o.toString());
        if (kcVar != null) {
            com.autonavi.aps.amapapi.utils.g.a(kcVar.d, 2041);
        }
        return aVar;
    }

    private StringBuilder a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        sb.append(this.d.m());
        sb.append(this.f9223c.o());
        return sb;
    }

    private boolean a(long j) {
        if (!this.O) {
            this.O = true;
            return false;
        } else if (com.autonavi.aps.amapapi.utils.i.b() - j < 800) {
            long j2 = 0;
            if (com.autonavi.aps.amapapi.utils.i.a(this.j)) {
                j2 = com.autonavi.aps.amapapi.utils.i.a() - this.j.getTime();
            }
            return j2 <= 10000;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x01a8 A[Catch: all -> 0x0358, TryCatch #1 {all -> 0x0358, blocks: (B:11:0x0084, B:13:0x00bd, B:17:0x00cd, B:19:0x00d6, B:23:0x00e0, B:28:0x00ee, B:29:0x00f3, B:29:0x00f3, B:31:0x00f9, B:33:0x010b, B:37:0x0119, B:39:0x0137, B:41:0x013f, B:42:0x014f, B:45:0x016d, B:47:0x0175, B:49:0x017d, B:54:0x01a2, B:56:0x01a8, B:50:0x018d, B:52:0x019b), top: B:115:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a b(boolean r8, com.autonavi.aps.amapapi.a r9) {
        /*
            Method dump skipped, instructions count: 1275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.b(boolean, com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private void b(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(ib.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.m = true;
            }
        } catch (Throwable th) {
        }
    }

    private String c(com.autonavi.aps.amapapi.a aVar) {
        String str;
        int h = this.d.h();
        com.autonavi.aps.amapapi.restruct.d e = this.d.e();
        com.autonavi.aps.amapapi.restruct.d f = this.d.f();
        ArrayList<mq> arrayList = this.g;
        boolean z = arrayList == null || arrayList.isEmpty();
        if (e == null && f == null && z) {
            if (this.b == null) {
                this.b = (ConnectivityManager) com.autonavi.aps.amapapi.utils.i.a(this.f9222a, Context.CONNECTIVITY_SERVICE);
            }
            if (com.autonavi.aps.amapapi.utils.i.c() >= 31) {
                if (com.autonavi.aps.amapapi.utils.i.a(this.f9222a) && !this.f9223c.l()) {
                    this.z = 18;
                    this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2132);
                    aVar.f("#1802");
                    return "";
                }
            } else if (com.autonavi.aps.amapapi.utils.i.a(this.f9222a) && !this.f9223c.k()) {
                this.z = 18;
                this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2132);
                aVar.f("#1801");
                return "";
            }
            if (com.autonavi.aps.amapapi.utils.i.c() >= 28) {
                if (this.J == null) {
                    this.J = (LocationManager) this.f9222a.getApplicationContext().getSystemService("location");
                }
                if (!((Boolean) com.autonavi.aps.amapapi.utils.e.a(this.J, "isLocationEnabled", new Object[0])).booleanValue()) {
                    this.z = 12;
                    this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    aVar.f("#1206");
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                    return "";
                }
            }
            if (!com.autonavi.aps.amapapi.utils.i.e(this.f9222a)) {
                this.z = 12;
                this.o.append("定位权限被禁用,请授予应用定位权限#1201");
                aVar.f("#1201");
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                return "";
            } else if (com.autonavi.aps.amapapi.utils.i.c() >= 24 && com.autonavi.aps.amapapi.utils.i.c() < 28 && Settings.Secure.getInt(this.f9222a.getContentResolver(), Settings.Secure.LOCATION_MODE, 0) == 0) {
                this.z = 12;
                aVar.f("#1206");
                this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                return "";
            } else {
                String k = this.d.k();
                String d = this.f9223c.d();
                if (this.f9223c.a(this.b) && d != null) {
                    this.z = 12;
                    aVar.f("#1202");
                    this.o.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                    return "";
                } else if (k != null) {
                    this.z = 12;
                    if (this.f9223c.k()) {
                        aVar.f("#1205");
                        this.o.append("获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205");
                    } else {
                        aVar.f("#1204");
                        this.o.append("WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204");
                    }
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2121);
                    return "";
                } else if (!this.f9223c.k() && !this.d.n()) {
                    this.z = 19;
                    aVar.f("#1901");
                    this.o.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2133);
                    return "";
                } else {
                    if (this.f9223c.k()) {
                        aVar.f("#1302");
                        if (this.f9223c.c() != null) {
                            this.o.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
                            if (!com.autonavi.aps.amapapi.utils.i.f(this.f9222a)) {
                                this.o.append("或后台运行没有后台定位权限");
                            }
                            this.o.append("#1302");
                        } else {
                            this.o.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
                            if (!com.autonavi.aps.amapapi.utils.i.f(this.f9222a)) {
                                this.o.append("或后台运行没有后台定位权限");
                            }
                            this.o.append("#1302");
                        }
                    } else {
                        aVar.f("#1301");
                        this.o.append("获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301");
                    }
                    this.z = 13;
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2131);
                    return "";
                }
            }
        }
        WifiInfo m = this.f9223c.m();
        this.u = m;
        this.v = i.a(m);
        String str2 = "cgi";
        if (h == 0) {
            boolean z2 = !this.g.isEmpty() || this.v;
            boolean z3 = f != null;
            if (!z3) {
                if (this.v && this.g.isEmpty()) {
                    this.z = 2;
                    aVar.f("#0201");
                    this.o.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                    com.autonavi.aps.amapapi.utils.g.a((String) null, 2021);
                    return "";
                } else if (this.g.size() == 1) {
                    this.z = 2;
                    if (!this.v) {
                        aVar.f("#0202");
                        this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        com.autonavi.aps.amapapi.utils.g.a((String) null, 2022);
                        return "";
                    } else if (this.g.get(0).h) {
                        aVar.f("#0202");
                        this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        com.autonavi.aps.amapapi.utils.g.a((String) null, 2021);
                        return "";
                    }
                }
            }
            String format = String.format(Locale.US, "#%s#", "network");
            if (z3) {
                StringBuilder sb = new StringBuilder();
                sb.append(f.b());
                str2 = (!this.g.isEmpty() || this.v) ? "cgiwifi" : "cgiwifi";
                sb.append("network");
                sb.append("#");
                sb.append(str2);
                str = sb.toString();
            } else if (z2) {
                str = format + "wifi";
            } else {
                this.z = 2;
                if (this.f9223c.k()) {
                    aVar.f("#0204");
                    this.o.append("当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204");
                } else {
                    aVar.f("#0203");
                    this.o.append("当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203");
                }
                com.autonavi.aps.amapapi.utils.g.a((String) null, 2022);
                str = "";
            }
        } else if (h == 1) {
            str = "";
            if (e != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(e.f9246a);
                sb2.append("#");
                sb2.append(e.b);
                sb2.append("#");
                sb2.append(e.f9247c);
                sb2.append("#");
                sb2.append(e.d);
                sb2.append("#");
                sb2.append("network");
                sb2.append("#");
                sb2.append((!this.g.isEmpty() || this.v) ? "cgiwifi" : "cgiwifi");
                str = sb2.toString();
            }
        } else if (h != 2) {
            this.z = 11;
            com.autonavi.aps.amapapi.utils.g.a((String) null, 2111);
            aVar.f("#1101");
            this.o.append("get cgi failure#1101");
            str = "";
        } else {
            str = "";
            if (e != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(e.f9246a);
                sb3.append("#");
                sb3.append(e.b);
                sb3.append("#");
                sb3.append(e.h);
                sb3.append("#");
                sb3.append(e.i);
                sb3.append("#");
                sb3.append(e.j);
                sb3.append("#");
                sb3.append("network");
                sb3.append("#");
                sb3.append((!this.g.isEmpty() || this.v) ? "cgiwifi" : "cgiwifi");
                str = sb3.toString();
            }
        }
        String str3 = str;
        if (!TextUtils.isEmpty(str)) {
            String str4 = str;
            if (!str.startsWith("#")) {
                str4 = "#" + str;
            }
            str3 = com.autonavi.aps.amapapi.utils.i.e() + str4;
        }
        return str3;
    }

    private static void c(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar.getErrorCode() == 0 && aVar.getLocationType() == 0) {
            if ("-5".equals(aVar.d()) || "1".equals(aVar.d()) || "2".equals(aVar.d()) || "14".equals(aVar.d()) || "24".equals(aVar.d()) || "-1".equals(aVar.d())) {
                aVar.setLocationType(5);
            } else {
                aVar.setLocationType(6);
            }
        }
    }

    private void d(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    private void i() {
        if (this.n != null) {
            try {
                if (this.i == null) {
                    this.i = new AMapLocationClientOption();
                }
                this.n.a(this.i.getHttpTimeOut(), this.i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), j());
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int j() {
        /*
            r3 = this;
            r0 = r3
            com.amap.api.location.AMapLocationClientOption r0 = r0.i
            com.amap.api.location.AMapLocationClientOption$GeoLanguage r0 = r0.getGeoLanguage()
            r6 = r0
            r0 = 2
            r4 = r0
            r0 = r6
            if (r0 == 0) goto L31
            int[] r0 = com.autonavi.aps.amapapi.b.AnonymousClass1.f9224a
            r1 = r3
            com.amap.api.location.AMapLocationClientOption r1 = r1.i
            com.amap.api.location.AMapLocationClientOption$GeoLanguage r1 = r1.getGeoLanguage()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L31
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L2f
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L33
            goto L31
        L2f:
            r0 = 1
            return r0
        L31:
            r0 = 0
            r4 = r0
        L33:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.j():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
        if (r10 != r3.r) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.k():void");
    }

    private void l() {
        try {
            if (this.h == null) {
                this.h = new a();
            }
            if (this.I == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.I = intentFilter;
                intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
                this.I.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
            }
            this.f9222a.registerReceiver(this.h, this.I);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBroadcastListener");
        }
    }

    private byte[] m() throws Throwable {
        if (this.l == null) {
            this.l = new f();
        }
        if (this.i == null) {
            this.i = new AMapLocationClientOption();
        }
        this.l.a(this.f9222a, this.i.isNeedAddress(), this.i.isOffset(), this.d, this.f9223c, this.b, this.E, this.Q);
        return this.l.a();
    }

    private boolean n() {
        return this.k == 0 || com.autonavi.aps.amapapi.utils.i.b() - this.k > 20000;
    }

    private void o() {
        i iVar = this.f9223c;
        if (iVar == null) {
            return;
        }
        iVar.a(this.m);
    }

    private boolean p() {
        ArrayList<mq> e = this.f9223c.e();
        this.g = e;
        return e == null || e.size() <= 0;
    }

    private void q() {
        if (this.N != null) {
            this.N = null;
        }
        StringBuilder sb = this.w;
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    private void r() {
        try {
            if (this.e != null) {
                this.e.a();
            }
            d(null);
            this.O = false;
            if (this.D != null) {
                this.D.a();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "cleanCache");
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(double d, double d2) {
        try {
            String a2 = this.n.a(this.f9222a, d, d2);
            if (a2.contains("\"status\":\"1\"")) {
                com.autonavi.aps.amapapi.model.a a3 = this.f.a(a2);
                a3.setLatitude(d);
                a3.setLongitude(d2);
                return a3;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:20|(2:22|(1:24)(1:25))|26|27|(6:32|33|34|35|36|(2:38|39)(2:40|(2:42|43)(9:44|(1:46)(2:74|(1:76)(2:77|(1:79)))|47|48|(3:52|53|(1:55)(2:56|(1:58)(2:59|(1:61)(1:62))))|63|(2:65|(1:70)(1:69))|71|72)))|84|33|34|35|36|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e3, code lost:
        r16 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e5, code lost:
        com.autonavi.aps.amapapi.utils.b.a(r16, "Aps", "getLocation getCgiListParam");
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.a r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.a(com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        this.D.a(this.s);
        return this.D.a(aVar);
    }

    public final com.autonavi.aps.amapapi.model.a a(boolean z) {
        if (this.f9223c.n()) {
            return a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.N)) {
            return a(this.z, this.o.toString());
        }
        com.autonavi.aps.amapapi.model.a a2 = this.e.a(this.f9222a, this.N, this.w, true, z);
        if (com.autonavi.aps.amapapi.utils.i.a(a2)) {
            d(a2);
        }
        return a2;
    }

    public final com.autonavi.aps.amapapi.model.a a(boolean z, com.autonavi.aps.amapapi.a aVar) {
        if (z) {
            aVar.e("statics");
        } else {
            aVar.e("first");
        }
        if (this.f9222a == null) {
            aVar.f("#0101");
            this.o.append("context is null#0101");
            com.autonavi.aps.amapapi.utils.g.a((String) null, 2011);
            return a(1, this.o.toString());
        } else if (this.f9223c.n()) {
            aVar.f("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        } else {
            b();
            if (TextUtils.isEmpty(this.N)) {
                return a(this.z, this.o.toString());
            }
            com.autonavi.aps.amapapi.model.a b = b(z, aVar);
            if (com.autonavi.aps.amapapi.utils.i.a(b) && !S) {
                this.e.a(this.w.toString());
                this.e.a(this.d.e());
                d(b);
            }
            S = true;
            return b;
        }
    }

    public final void a() {
        e eVar = this.d;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void a(Context context) {
        try {
            if (this.f9222a != null) {
                return;
            }
            this.D = new com.autonavi.aps.amapapi.filters.a();
            Context applicationContext = context.getApplicationContext();
            this.f9222a = applicationContext;
            com.autonavi.aps.amapapi.utils.i.b(applicationContext);
            if (this.f9223c == null) {
                this.f9223c = new i(this.f9222a, (WifiManager) com.autonavi.aps.amapapi.utils.i.a(this.f9222a, "wifi"), this.P);
            }
            if (this.d == null) {
                this.d = new e(this.f9222a, this.P);
            }
            this.Q = new g(context, this.P);
            if (this.e == null) {
                this.e = new com.autonavi.aps.amapapi.storage.a();
            }
            if (this.f == null) {
                this.f = new com.autonavi.aps.amapapi.trans.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBase");
        }
    }

    public final void a(Handler handler) {
        this.P = handler;
    }

    public final void a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 0) {
            return;
        }
        com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
        fVar.f9252a = aMapLocation.getLocationType();
        fVar.d = aMapLocation.getTime();
        fVar.e = (int) aMapLocation.getAccuracy();
        fVar.b = aMapLocation.getLatitude();
        fVar.f9253c = aMapLocation.getLongitude();
        if (aMapLocation.getLocationType() == 1) {
            this.Q.a(fVar);
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.i = new AMapLocationClientOption();
        }
        i iVar = this.f9223c;
        if (iVar != null) {
            this.i.isWifiActiveScan();
            iVar.a(this.i.isWifiScan(), this.i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        i();
        com.autonavi.aps.amapapi.storage.a aVar = this.e;
        if (aVar != null) {
            aVar.a(this.i);
        }
        com.autonavi.aps.amapapi.trans.e eVar = this.f;
        if (eVar != null) {
            eVar.a(this.i);
        }
        k();
    }

    public final void a(com.autonavi.aps.amapapi.model.a aVar, int i) {
        if (aVar != null && aVar.getErrorCode() == 0) {
            com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
            fVar.d = aVar.getTime();
            fVar.e = (int) aVar.getAccuracy();
            fVar.b = aVar.getLatitude();
            fVar.f9253c = aVar.getLongitude();
            fVar.f9252a = i;
            fVar.g = Integer.parseInt(aVar.d());
            fVar.h = aVar.l();
            this.Q.b(fVar);
        }
    }

    public final void b() {
        this.n = com.autonavi.aps.amapapi.trans.c.a(this.f9222a);
        i();
        if (this.b == null) {
            this.b = (ConnectivityManager) com.autonavi.aps.amapapi.utils.i.a(this.f9222a, Context.CONNECTIVITY_SERVICE);
        }
        if (this.l == null) {
            this.l = new f();
        }
    }

    public final void b(com.autonavi.aps.amapapi.a aVar) {
        try {
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initFirstLocateParam");
        }
        if (this.x) {
            return;
        }
        q();
        if (this.t) {
            l();
        }
        this.f9223c.b(this.t);
        this.g = this.f9223c.e();
        this.d.a(true, p());
        String c2 = c(aVar);
        this.N = c2;
        if (!TextUtils.isEmpty(c2)) {
            this.w = a(this.w);
        }
        this.x = true;
    }

    public final void b(com.autonavi.aps.amapapi.model.a aVar) {
        if (com.autonavi.aps.amapapi.utils.i.a(aVar)) {
            this.e.a(this.N, this.w, aVar, this.f9222a, true);
        }
    }

    public final void c() {
        if (this.A == null) {
            this.A = new com.autonavi.aps.amapapi.restruct.b(this.f9222a);
        }
        l();
        this.f9223c.b(false);
        this.g = this.f9223c.e();
        this.d.a(false, p());
        this.e.a(this.f9222a);
        b(this.f9222a);
        this.y = true;
    }

    public final void d() {
        if (this.o.length() > 0) {
            StringBuilder sb = this.o;
            sb.delete(0, sb.length());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.e():void");
    }

    public final void f() {
        c cVar = this.T;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void g() {
        try {
            if (this.f9222a == null) {
                return;
            }
            if (this.T == null) {
                this.T = new c(this.f9222a);
            }
            this.T.a(this.d, this.f9223c, this.P);
        } catch (Throwable th) {
            iw.c(th, "as", "stc");
        }
    }

    public final void h() {
        c cVar = this.T;
        if (cVar != null) {
            cVar.a();
        }
    }
}
