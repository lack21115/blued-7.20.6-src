package com.soft.blued.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.listener.LocationHelperNew;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.gaode.GaoDeUtils;
import com.blued.android.module.common.utils.gaode.OnLocationListener;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Event;
import com.blued.das.authority.SystemAuthorityProtos;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.track.EventTrackSystemAuthority;
import com.soft.blued.ui.home.manager.WelcomeADManager;
import com.soft.blued.version.update.UpdateVersionFragment;
import com.soft.blued.version.update.UpdateVersionHelper;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.UUID;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/DeviceUtils.class */
public class DeviceUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34734a = DeviceUtils.class.getSimpleName();

    public static void a(Context context) {
        if (f()) {
            return;
        }
        Context context2 = context;
        if (context == null) {
            context2 = AppInfo.d();
        }
        int a2 = UpdateVersionHelper.a(context2);
        if (a2 != -1) {
            if (a2 != 8) {
                return;
            }
            UpdateVersionFragment.a(context2, "i_s_install_update");
        } else if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            MineHttpUtils.a(context2, "0", new BluedUIHttpResponse<BluedEntityA<DownloadBaseInfo>>() { // from class: com.soft.blued.utils.DeviceUtils.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public BluedEntityA<DownloadBaseInfo> parseData(String str) {
                    Logger.a(DeviceUtils.f34734a + "===update json", str);
                    return (BluedEntityA) super.parseData(str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<DownloadBaseInfo> bluedEntityA) {
                    if (bluedEntityA != null) {
                        try {
                            if (bluedEntityA.hasData()) {
                                DownloadBaseInfo downloadBaseInfo = bluedEntityA.data.get(0);
                                String str = downloadBaseInfo.type;
                                if (!TextUtils.isEmpty(downloadBaseInfo.version_code)) {
                                    BluedPreferences.I(downloadBaseInfo.version_code);
                                }
                                if (StringUtils.d(str) || !str.equals("0")) {
                                    if ((TextUtils.isEmpty(str) || !str.equals("1")) && !TextUtils.isEmpty(str) && str.equals("2")) {
                                        UpdateVersionFragment.a(AppInfo.d(), downloadBaseInfo, "i_s_strong_update");
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFailure(Throwable th, int i, String str) {
                    String str2 = DeviceUtils.f34734a;
                    Logger.a(str2, "===update responseCode json===" + str);
                    super.onFailure(th, i, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                }
            });
        }
    }

    public static void a(LocationHelperNew.LocationFinishListener locationFinishListener) {
        a(locationFinishListener, !BluedPreferences.m());
        BluedPreferences.l();
    }

    public static void a(final LocationHelperNew.LocationFinishListener locationFinishListener, boolean z) {
        if (!z || WelcomeADManager.a().c()) {
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.utils.DeviceUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    DeviceUtils.b(LocationHelperNew.LocationFinishListener.this);
                }
            });
            return;
        }
        EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.SYSTEM_AUTHORITY, SystemAuthorityProtos.Type.LOCATION, PermissionUtils.a("android.permission.ACCESS_FINE_LOCATION"));
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.utils.DeviceUtils.1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                DeviceUtils.b(LocationHelperNew.LocationFinishListener.this);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
                LocationHelperNew.LocationFinishListener locationFinishListener2 = LocationHelperNew.LocationFinishListener.this;
                if (locationFinishListener2 != null) {
                    locationFinishListener2.a(-1001);
                }
                BluedStatistics.c().a("LOCATION", 0L, -1001, null);
            }
        });
    }

    public static boolean a() {
        String language = BlueAppLocal.c().getLanguage();
        String country = BlueAppLocal.c().getCountry();
        return !StringUtils.d(language) && !StringUtils.d(country) && language.toLowerCase().equals(a.V) && country.toUpperCase().equals("CN");
    }

    public static int b() {
        return 720063;
    }

    public static void b(final LocationHelperNew.LocationFinishListener locationFinishListener) {
        Log.v("drb", "updateLocation");
        GaoDeUtils.a(new OnLocationListener() { // from class: com.soft.blued.utils.DeviceUtils.3
            @Override // com.blued.android.module.common.utils.gaode.OnLocationListener
            public void a(double d, double d2) {
                CommonPreferences.a(d, d2);
                Event c2 = BluedStatistics.c();
                c2.a("LOCATION_POSITION", 0L, 0, "nearby home longitude:" + d + " -- latitude:" + d2);
                Event c3 = BluedStatistics.c();
                c3.a("LOCATION", 0L, 0, "longitude:" + d + " -- latitude:" + d2);
                LocationHelperNew.LocationFinishListener locationFinishListener2 = LocationHelperNew.LocationFinishListener.this;
                if (locationFinishListener2 != null) {
                    locationFinishListener2.a();
                }
            }

            @Override // com.blued.android.module.common.utils.gaode.OnLocationListener
            public void a(int i) {
                LocationHelperNew.LocationFinishListener locationFinishListener2 = LocationHelperNew.LocationFinishListener.this;
                if (locationFinishListener2 != null) {
                    locationFinishListener2.a(i);
                    BluedStatistics.c().a("LOCATION", 0L, i, null);
                }
            }
        });
    }

    public static boolean b(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 18) {
                return true;
            }
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static String c() {
        return "7.20.6";
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (com.soft.blued.utils.BluedPreferences.aC() == 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d() {
        /*
            java.lang.String r0 = com.soft.blued.utils.BluedPreferences.eI()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Ld
            java.lang.String r0 = com.soft.blued.utils.BluedPreferences.eI()
            return r0
        Ld:
            java.lang.String r0 = ""
            r3 = r0
            android.content.Context r0 = com.blued.android.core.AppInfo.d()
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            r6 = r0
            r0 = 0
            r5 = r0
            boolean r0 = com.soft.blued.utils.BluedPreferences.aD()
            if (r0 != 0) goto L2f
            r0 = r3
            r4 = r0
            int r0 = com.soft.blued.utils.BluedPreferences.aC()
            r1 = 1
            if (r0 != r1) goto Ld8
        L2f:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L3f
            r0 = r6
            java.lang.String r0 = r0.getSimOperatorName()
            r3 = r0
            goto Ld2
        L3f:
            r0 = r6
            java.lang.String r0 = r0.getSubscriberId()     // Catch: java.lang.Throwable -> Lda
            r4 = r0
            goto L47
        L47:
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Ld2
            r0 = r4
            java.lang.String r1 = "46000"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto Lce
            r0 = r4
            java.lang.String r1 = "46002"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto Lce
            r0 = r4
            java.lang.String r1 = "46004"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto Lce
            r0 = r4
            java.lang.String r1 = "46007"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L79
            goto Lce
        L79:
            r0 = r4
            java.lang.String r1 = "46001"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto Lc7
            r0 = r4
            java.lang.String r1 = "46006"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto Lc7
            r0 = r4
            java.lang.String r1 = "46009"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L9a
            goto Lc7
        L9a:
            r0 = r4
            java.lang.String r1 = "46003"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto Lc0
            r0 = r4
            java.lang.String r1 = "46005"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto Lc0
            r0 = r4
            java.lang.String r1 = "46011"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto Lbb
            goto Lc0
        Lbb:
            r0 = r4
            r3 = r0
            goto Ld2
        Lc0:
            java.lang.String r0 = "中国电信"
            r3 = r0
            goto Ld2
        Lc7:
            java.lang.String r0 = "中国联通"
            r3 = r0
            goto Ld2
        Lce:
            java.lang.String r0 = "中国移动"
            r3 = r0
        Ld2:
            r0 = r3
            com.soft.blued.utils.BluedPreferences.an(r0)
            r0 = r3
            r4 = r0
        Ld8:
            r0 = r4
            return r0
        Lda:
            r4 = move-exception
            r0 = r5
            r4 = r0
            goto L47
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.utils.DeviceUtils.d():java.lang.String");
    }

    public static boolean e() {
        return "smartisan".equals(Build.MANUFACTURER);
    }

    public static boolean f() {
        return TextUtils.equals("a0300a", AppInfo.f9487c);
    }

    public static String g() {
        String str;
        if (TextUtils.isEmpty(AppInfo.d) && TextUtils.isEmpty(AppInfo.e)) {
            String a2 = BluedPreferences.c().a("uuid", (String) null);
            str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = UUID.randomUUID().toString().replaceAll("-", "");
                BluedPreferences.c().c().a("uuid", str).a();
            }
        } else {
            str = AppInfo.d + AppInfo.e;
        }
        try {
            String a3 = Md5.a(str, AesCrypto.b);
            return a3 + Md5.a(a3, AesCrypto.b);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String h() {
        String str;
        if (TextUtils.isEmpty(AppInfo.d) && TextUtils.isEmpty(AppInfo.e)) {
            String a2 = BluedPreferences.c().a("uuid", (String) null);
            str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = UUID.randomUUID().toString().replaceAll("-", "");
                BluedPreferences.c().c().a("uuid", str).a();
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            str = AppInfo.d + AppInfo.e;
        } else {
            String[] i = i();
            str = i[0] + i[1] + AppInfo.e;
        }
        try {
            String a3 = Md5.a(str, AesCrypto.b);
            return a3 + Md5.a(a3, AesCrypto.b);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String[] i() {
        String[] strArr = {"", ""};
        TelephonyManager telephonyManager = (TelephonyManager) AppInfo.d().getSystemService("phone");
        try {
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE);
            String str = (String) declaredMethod.invoke(telephonyManager, 0);
            String str2 = (String) declaredMethod.invoke(telephonyManager, 1);
            if (!TextUtils.isEmpty(str)) {
                strArr[0] = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                strArr[1] = str2;
            }
            return strArr;
        } catch (Exception e) {
            return strArr;
        }
    }

    public static String j() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String k() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Exception e) {
            Log.e("getIPv4Address", e.toString());
            return "";
        }
    }

    public static String l() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Exception e) {
            Log.e("getIPv6Address", e.toString());
            return "";
        }
    }
}
