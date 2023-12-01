package com.tencent.liteav.base.system;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Debug;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.p;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/LiteavSystemInfo.class */
public class LiteavSystemInfo {
    private static final int APP_SYSTEM_METHOD_DEFAULT_GET_INTERVAL_MS = 1000;
    private static final String EXT_KEY_APP_NAME = "appName";
    private static final String EXT_KEY_APP_PACKAGE_NAME = "appPackageName";
    private static final String EXT_KEY_APP_VERSION = "appVersion";
    private static final String EXT_KEY_BUILD_BOARD = "buildBoard";
    private static final String EXT_KEY_BUILD_BRAND = "buildBrand";
    private static final String EXT_KEY_BUILD_HARDWARE = "buildHardware";
    private static final String EXT_KEY_BUILD_MANUFACTURER = "buildManufacturer";
    private static final String EXT_KEY_BUILD_MODEL = "buildModel";
    private static final String EXT_KEY_BUILD_VERSION = "buildVersion";
    private static final String EXT_KEY_BUILD_VERSION_INT = "buildVersionInt";
    private static final int GET_APP_MEMORY_INTERVAL_MS = 15000;
    private static final int NETWORK_TYPE_2G = 4;
    private static final int NETWORK_TYPE_3G = 3;
    private static final int NETWORK_TYPE_4G = 2;
    private static final int NETWORK_TYPE_5G = 6;
    private static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_WIFI = 1;
    private static final int NETWORK_TYPE_WIRED = 5;
    private static final String TAG = "LiteavBaseSystemInfo";
    private static volatile com.tencent.liteav.base.util.i sProcessStateOwner;
    private static final p<String> sModel = new p<>(g.a());
    private static final p<String> sBrand = new p<>(h.a());
    private static final p<String> sManufacturer = new p<>(i.a());
    private static final p<String> sHardware = new p<>(j.a());
    private static final p<String> sSystemOSVersion = new p<>(k.a());
    private static final p<Integer> sSystemOSVersionInt = new p<>(l.a());
    private static final p<String> sBoard = new p<>(m.a());
    private static final p<String> sAppPackageName = new p<>(n.a());
    private static final p<String> sAppName = new p<>(d.a());
    private static final p<String> sAppVersion = new p<>(e.a());
    private static final p<String> sUUID = new p<>(f.a());
    private static AtomicBoolean sIsGettingMemoryUsage = new AtomicBoolean(false);
    private static AtomicInteger sLastMemoryUsage = new AtomicInteger(0);
    private static final com.tencent.liteav.base.b.a sMemoryUsageThrottler = new com.tencent.liteav.base.b.a(15000);
    private static final Object sProcessStateOwnerLock = new Object();
    private static int sLastNetworkType = 0;
    private static final com.tencent.liteav.base.b.a sNetworkTypeThrottler = new com.tencent.liteav.base.b.a(1000);
    private static int sLastGateway = 0;
    private static final com.tencent.liteav.base.b.a sGatewayThrottler = new com.tencent.liteav.base.b.a(1000);

    public static int getAppBackgroundState() {
        int i;
        synchronized (LiteavSystemInfo.class) {
            try {
                if (sProcessStateOwner == null) {
                    synchronized (sProcessStateOwnerLock) {
                        if (sProcessStateOwner == null) {
                            sProcessStateOwner = new com.tencent.liteav.base.util.i(ContextUtils.getApplicationContext());
                        }
                    }
                }
                i = sProcessStateOwner.f36331a ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public static int getAppMemoryUsage() {
        int i;
        synchronized (LiteavSystemInfo.class) {
            try {
                if (sMemoryUsageThrottler.a()) {
                    getAppMemoryUsageFromSystem();
                }
                i = sLastMemoryUsage.get();
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private static void getAppMemoryUsageFromSystem() {
        if (sIsGettingMemoryUsage.get()) {
            return;
        }
        sIsGettingMemoryUsage.set(true);
        AsyncTask.execute(c.a());
    }

    public static String getAppName() {
        return sAppName.a();
    }

    public static String getAppPackageName() {
        return sAppPackageName.a();
    }

    public static String getAppVersion() {
        return sAppVersion.a();
    }

    public static String getBoard() {
        return sBoard.a();
    }

    public static String getBrand() {
        return sBrand.a();
    }

    public static String getDeviceUuid() {
        return sUUID.a();
    }

    public static int getGateway() {
        int i;
        synchronized (LiteavSystemInfo.class) {
            try {
                if (sGatewayThrottler.a()) {
                    sLastGateway = getGatewayFromSystem();
                }
                i = sLastGateway;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private static int getGatewayFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        try {
            return ((WifiManager) applicationContext.getSystemService("wifi")).getDhcpInfo().gateway;
        } catch (Throwable th) {
            Log.e(TAG, "getGateway error " + th.getMessage(), new Object[0]);
            return 0;
        }
    }

    public static String getHardware() {
        return sHardware.a();
    }

    public static String getManufacturer() {
        return sManufacturer.a();
    }

    public static String getModel() {
        return sModel.a();
    }

    public static int getNetworkType() {
        int i;
        synchronized (LiteavSystemInfo.class) {
            try {
                if (sNetworkTypeThrottler.a()) {
                    sLastNetworkType = getNetworkTypeFromSystem();
                }
                i = sLastNetworkType;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private static int getNetworkTypeFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        NetworkInfo networkInfo = null;
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            Log.e(TAG, "getNetworkType error occurred.", e);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 9) {
                return 5;
            }
            if (networkInfo.getType() == 1) {
                return 1;
            }
            if (networkInfo.getType() == 0) {
                try {
                    int networkType = telephonyManager.getNetworkType();
                    switch (networkType) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 4;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 2;
                        default:
                            return (getSystemOSVersionInt() < 29 || networkType != 20) ? 2 : 6;
                    }
                } catch (Exception e2) {
                    Log.e(TAG, "getNetworkType error occurred.", e2);
                    return 2;
                }
            }
            return 0;
        }
        return 0;
    }

    public static String getSystemOSVersion() {
        return sSystemOSVersion.a();
    }

    public static int getSystemOSVersionInt() {
        return sSystemOSVersionInt.a().intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getAppMemoryUsageFromSystem$8() {
        int i;
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            i = memoryInfo.getTotalPss();
        } catch (Exception e) {
            Log.e(TAG, "Get App memory usage failed." + e.getMessage(), new Object[0]);
            i = 0;
        }
        sLastMemoryUsage.set(i / 1024);
        sIsGettingMemoryUsage.set(false);
    }

    public static boolean setExtID(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -911706486:
                if (str.equals(EXT_KEY_BUILD_VERSION)) {
                    z = true;
                    break;
                }
                break;
            case -794136500:
                if (str.equals("appName")) {
                    z = true;
                    break;
                }
                break;
            case -589756065:
                if (str.equals(EXT_KEY_BUILD_MANUFACTURER)) {
                    z = true;
                    break;
                }
                break;
            case -497349352:
                if (str.equals(EXT_KEY_BUILD_BOARD)) {
                    z = true;
                    break;
                }
                break;
            case -497260103:
                if (str.equals(EXT_KEY_BUILD_BRAND)) {
                    z = true;
                    break;
                }
                break;
            case -487188133:
                if (str.equals(EXT_KEY_BUILD_MODEL)) {
                    z = false;
                    break;
                }
                break;
            case -441921776:
                if (str.equals(EXT_KEY_APP_PACKAGE_NAME)) {
                    z = true;
                    break;
                }
                break;
            case -391134602:
                if (str.equals(EXT_KEY_BUILD_HARDWARE)) {
                    z = true;
                    break;
                }
                break;
            case 725329157:
                if (str.equals(EXT_KEY_BUILD_VERSION_INT)) {
                    z = true;
                    break;
                }
                break;
            case 1484112759:
                if (str.equals("appVersion")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                sModel.a(str2);
                return true;
            case true:
                sBrand.a(str2);
                return true;
            case true:
                sManufacturer.a(str2);
                return true;
            case true:
                sHardware.a(str2);
                return true;
            case true:
                sSystemOSVersion.a(str2);
                return true;
            case true:
                try {
                    sSystemOSVersionInt.a(Integer.valueOf(Integer.parseInt(str2)));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            case true:
                sBoard.a(str2);
                return true;
            case true:
                sAppName.a(str2);
                return true;
            case true:
                sAppPackageName.a(str2);
                return true;
            case true:
                sAppVersion.a(str2);
                return true;
            default:
                return false;
        }
    }
}
