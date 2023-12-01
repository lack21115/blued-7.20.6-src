package cn.shuzilm.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.rtt.RangingRequest;
import android.net.wifi.rtt.RangingResult;
import android.net.wifi.rtt.RangingResultCallback;
import android.net.wifi.rtt.WifiRttManager;
import android.os.Build;
import android.view.Window;
import com.android.internal.content.NativeLibraryHelper;
import com.android.internal.util.cm.QSConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/dl.class */
public class dl {
    private static Context b;
    private static NsdManager c;
    private static LinkedList d = new LinkedList();
    private static JSONObject e = new JSONObject();
    private static JSONObject f = null;
    private static Timer g = null;
    private static int h = 0;
    private static int i = 0;
    private static String j = "";
    private static String k = "";
    private static String l = "";
    static int a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/dl$sd.class */
    public class sd extends TimerTask {
        NsdManager.DiscoveryListener a;
        NsdManager b;
        int c;
        String d;

        public sd(NsdManager nsdManager, NsdManager.DiscoveryListener discoveryListener, int i, String str) {
            this.a = discoveryListener;
            this.b = nsdManager;
            this.c = i;
            this.d = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            synchronized (this) {
                try {
                    dl.b(this.b, this.a);
                    if (this.c == 2) {
                        int length = dl.f.length();
                        if (dl.f != null && length > 0 && dl.e.length() + length < 4096) {
                            dl.e.put(this.d, dl.f);
                        }
                    }
                    if (dl.d != null && dl.d.size() > 0 && (str = (String) dl.d.poll()) != null) {
                        dl.c(str, 2);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(NsdManager nsdManager, NsdManager.DiscoveryListener discoveryListener) {
        try {
            nsdManager.stopServiceDiscovery(discoveryListener);
        } catch (Throwable th) {
        }
    }

    private static void b(String str, int i2) {
        try {
            NsdManager.RegistrationListener registrationListener = new NsdManager.RegistrationListener() { // from class: cn.shuzilm.core.dl.1
                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i3) {
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i3) {
                }
            };
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceName(str);
            nsdServiceInfo.setServiceType(l);
            nsdServiceInfo.setPort(i2);
            c.registerService(nsdServiceInfo, 1, registrationListener);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, final int i2) {
        synchronized (dl.class) {
            try {
                NsdManager.DiscoveryListener discoveryListener = new NsdManager.DiscoveryListener() { // from class: cn.shuzilm.core.dl.2
                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onDiscoveryStarted(String str2) {
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onDiscoveryStopped(String str2) {
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
                        String serviceName = nsdServiceInfo.getServiceName();
                        String serviceType = nsdServiceInfo.getServiceType();
                        int i3 = i2;
                        if (i3 == 1) {
                            dl.c(serviceName, serviceType);
                        } else if (i3 == 2) {
                            dl.d(serviceName, serviceType);
                        }
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onStartDiscoveryFailed(String str2, int i3) {
                        dl.b(dl.c, this);
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onStopDiscoveryFailed(String str2, int i3) {
                        dl.b(dl.c, this);
                    }
                };
                f = new JSONObject();
                c.discoverServices(str, 1, discoveryListener);
                if (g == null) {
                    g = new Timer();
                }
                g.schedule(new sd(c, discoveryListener, i2, str), 500L);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, String str2) {
        synchronized (dl.class) {
            try {
                if (str2.contains(".")) {
                    String str3 = str2.split("\\.")[0];
                    d.add(str + "." + str3 + ".");
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0039 -> B:12:0x0030). Please submit an issue!!! */
    public static void d(Context context, final String str) {
        Context applicationContext;
        if (a <= 0 && Build.VERSION.SDK_INT >= 21) {
            try {
                applicationContext = context.getApplicationContext();
                b = applicationContext;
            } catch (Exception e2) {
            }
            if (applicationContext == null) {
                return;
            }
            new Thread(new Runnable() { // from class: cn.shuzilm.core.dl.4
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00af -> B:18:0x0075). Please submit an issue!!! */
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (this) {
                        try {
                            dl.a++;
                            int e3 = dl.e();
                            if (y.a(dl.b) && dl.h <= 0) {
                                String unused = dl.j = (String.this == null || String.this.length() <= 10) ? "a60c" : String.this.substring(2, 10).replace(NativeLibraryHelper.CLEAR_ABI_OVERRIDE, "Z").replace(BridgeUtil.UNDERLINE_STR, "l");
                                String unused2 = dl.k = Integer.toHexString(dl.b.getPackageName().hashCode());
                                dl.e(dl.f("h#TYch\"hY#TjYe"));
                                dl.n();
                                dl.k();
                            }
                            try {
                                Thread.sleep(1200L);
                            } catch (Exception e4) {
                            }
                            if (dl.e.length() > 0) {
                                dl.e.put("wrs", "" + e3);
                                dl.l();
                            }
                        } catch (Throwable th) {
                        }
                    }
                }
            }).start();
            a++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        synchronized (dl.class) {
            try {
                if (str2.equals(l) && str != null && str.contains(NativeLibraryHelper.CLEAR_ABI_OVERRIDE)) {
                    String[] split = str.split(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
                    if (split.length >= 3) {
                        if ((split[1] + split[2]).equals(k + j)) {
                            i = 1;
                        }
                    }
                }
                f.put(String.valueOf(f.length()), str);
            } catch (Exception e2) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* synthetic */ int e() {
        return o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str) {
        try {
            l = f("TV^geaVn#TiXe#");
            if (e == null || e.length() > 0 || d == null || d.size() > 0) {
                return;
            }
            c = (NsdManager) b.getSystemService("servicediscovery");
            c("_service" + str + ".", 1);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return new String(bytes);
            }
            bytes[i3] = (byte) (bytes[i3] + 11);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() {
        try {
            if (h <= 0 && i == 0) {
                h = new Random().nextInt(Window.PROGRESS_SECONDARY_START) + 40000;
                String str = "z" + Long.toHexString(System.currentTimeMillis()) + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + k + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + j;
                b(str, h);
                e.put("sn", str);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        DUHelper.bm(b, e.toString());
    }

    private static String m() {
        String str = "";
        String str2 = str;
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return "";
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
            LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
            if (linkProperties == null) {
                return "";
            }
            String interfaceName = linkProperties.getInterfaceName();
            String str3 = str;
            if (interfaceName != null) {
                str3 = str;
                if (interfaceName.contains("wlan")) {
                    List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
                    int size = linkAddresses.size();
                    int i2 = 0;
                    while (true) {
                        str3 = str;
                        if (i2 >= size) {
                            break;
                        }
                        str2 = str;
                        String linkAddress = linkAddresses.get(i2).toString();
                        String str4 = str;
                        if (linkAddress != null) {
                            str4 = str;
                            if (linkAddress.contains(".")) {
                                str4 = str;
                                if (!linkAddress.contains(":")) {
                                    String str5 = str;
                                    str4 = linkAddress.substring(0, linkAddress.lastIndexOf(".") + 1);
                                }
                            }
                        }
                        i2++;
                        str = str4;
                    }
                }
            }
            return str3;
        } catch (Throwable th) {
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0 != "") goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void n() {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.shuzilm.core.dl.n():void");
    }

    private static int o() {
        int size;
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return -1;
            }
            PackageManager packageManager = b.getPackageManager();
            String packageName = b.getPackageName();
            int checkPermission = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName);
            int checkPermission2 = packageManager.checkPermission("android.permission.CHANGE_WIFI_STATE", packageName);
            int checkPermission3 = packageManager.checkPermission("android.permission.ACCESS_WIFI_STATE", packageName);
            if (checkPermission != 0 || checkPermission2 != 0 || checkPermission3 != 0) {
                return -2;
            }
            if (Build.VERSION.SDK_INT > 32 && packageManager.checkPermission("android.permission.NEARBY_WIFI_DEVICES", packageName) != 0) {
                return -2;
            }
            int maxPeers = RangingRequest.getMaxPeers();
            if (maxPeers <= 0) {
                return -1;
            }
            int i2 = maxPeers;
            if (maxPeers > 2) {
                i2 = maxPeers - 1;
            }
            WifiRttManager wifiRttManager = (WifiRttManager) b.getSystemService("wifirtt");
            if (!wifiRttManager.isAvailable() || !b.getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                return -3;
            }
            WifiManager wifiManager = (WifiManager) b.getSystemService(QSConstants.TILE_WIFI);
            if (wifiManager.getWifiState() != 3) {
                return -3;
            }
            RangingRequest.Builder builder = new RangingRequest.Builder();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults == null || (size = scanResults.size()) <= 0) {
                return -4;
            }
            int i3 = i2;
            if (size < i2) {
                i3 = size;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    wifiRttManager.startRanging(builder.build(), b.getMainExecutor(), new RangingResultCallback() { // from class: cn.shuzilm.core.dl.3
                        @Override // android.net.wifi.rtt.RangingResultCallback
                        public void onRangingFailure(int i6) {
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                JSONObject jSONObject = dl.e;
                                jSONObject.put("wr", currentTimeMillis + ";err_" + i6 + com.alipay.sdk.util.i.b);
                            } catch (Exception e2) {
                            }
                        }

                        @Override // android.net.wifi.rtt.RangingResultCallback
                        public void onRangingResults(List list) {
                            if (list == null) {
                                return;
                            }
                            try {
                                StringBuilder sb = new StringBuilder();
                                long currentTimeMillis = System.currentTimeMillis();
                                sb.append(currentTimeMillis + com.alipay.sdk.util.i.b);
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= list.size()) {
                                        dl.e.put("wr", sb.toString());
                                        return;
                                    }
                                    RangingResult rangingResult = (RangingResult) list.get(i7);
                                    if (rangingResult.getStatus() == 0) {
                                        try {
                                            Object invoke = rangingResult.getClass().getMethod(dl.f("\\ZiBVX6YYgZhh"), new Class[0]).invoke(rangingResult, new Object[0]);
                                            if (invoke != null) {
                                                sb.append(invoke.toString().replace(":", ""));
                                            }
                                        } catch (Throwable th) {
                                        }
                                        sb.append(",");
                                        int distanceMm = rangingResult.getDistanceMm();
                                        int rssi = rangingResult.getRssi();
                                        sb.append(distanceMm + "," + rssi);
                                        sb.append(com.alipay.sdk.util.i.b);
                                    }
                                    i6 = i7 + 1;
                                }
                            } catch (Throwable th2) {
                            }
                        }
                    });
                    return 0;
                }
                builder.addAccessPoint(scanResults.get(i5));
                i4 = i5 + 1;
            }
        } catch (Throwable th) {
            return 0;
        }
    }
}
