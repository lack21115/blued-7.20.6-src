package com.umeng.commonsdk.statistics.common;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.material.timepicker.TimeModel;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.tendinsv.utils.r;
import com.umeng.analytics.pro.y;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.youzan.androidsdk.tool.AppSigning;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/common/DeviceConfig.class */
public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    protected static final String LOG_TAG = DeviceConfig.class.getName();
    private static DeviceTypeEnum deviceTypeEnum = DeviceTypeEnum.DEFAULT;
    private static volatile String sWifiMac = "";
    private static volatile String sImei = "";
    private static volatile String sMeid = "";
    private static volatile String sImsi = "";
    private static volatile String sSerialNo = "";
    private static volatile String sAndroidID = "";
    private static volatile String sIDFA = "";
    private static volatile String sOAID = "";
    private static volatile String sSecondImei = "";
    private static volatile String sSimSerialNumber = "";
    private static volatile boolean hasReadImeiOrMeid = false;
    private static volatile boolean hasReadSimSerialNumber = false;
    private static volatile boolean hasReadIMEI2 = false;
    private static volatile boolean hasReadSerialNo = false;
    private static volatile boolean hasReadAndroidID = false;
    private static volatile boolean hasReadMac = false;
    private static volatile boolean hasReadImsi = false;
    private static volatile boolean hasReadOAID = false;
    private static volatile boolean hasReadIDFA = false;
    private static volatile String sAppName = "";
    private static volatile String sAppPkgName = "";
    private static volatile boolean hasReadOperator = false;
    private static volatile String sOperator = "";
    private static volatile boolean hasReadOperatorName = false;
    private static volatile String sOperatorName = "";
    private static volatile String sCustomAgt = "";

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2]);
            int length = hexString.length();
            String str = hexString;
            if (length == 1) {
                str = "0" + hexString;
            }
            String str2 = str;
            if (length > 2) {
                str2 = str.substring(length - 2, length);
            }
            sb.append(str2.toUpperCase(Locale.getDefault()));
            if (i2 < bArr.length - 1) {
                sb.append(':');
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
        if (r7.getPackageManager().checkPermission(r8, r7.getPackageName()) == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
        if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", java.lang.String.class).invoke(r7, r8)).intValue() == 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkPermission(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            r10 = r0
            r0 = r7
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L3d
            java.lang.String r0 = "android.content.Context"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = "checkSelfPermission"
            r2 = 1
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L50
            r3 = r2
            r4 = 0
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r3[r4] = r5     // Catch: java.lang.Throwable -> L50
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch: java.lang.Throwable -> L50
            r1 = r7
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L50
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5     // Catch: java.lang.Throwable -> L50
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L50
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L50
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L50
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L4e
            goto L4c
        L3d:
            r0 = r7
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r1 = r8
            r2 = r7
            java.lang.String r2 = r2.getPackageName()
            int r0 = r0.checkPermission(r1, r2)
            if (r0 != 0) goto L4e
        L4c:
            r0 = 1
            r10 = r0
        L4e:
            r0 = r10
            return r0
        L50:
            r7 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    public static String getAndroidId(Context context) {
        if (!UMConfigure.shouldCollectAid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "disallow read aid.");
            return null;
        } else if (TextUtils.isEmpty(sAndroidID)) {
            if (hasReadAndroidID) {
                return null;
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.i) && context != null) {
                try {
                    sAndroidID = Settings.Secure.getString(context.getContentResolver(), "android_id");
                } finally {
                    try {
                        hasReadAndroidID = true;
                    } catch (Throwable th) {
                    }
                }
                hasReadAndroidID = true;
            }
            return sAndroidID;
        } else {
            return sAndroidID;
        }
    }

    public static String getAppHashKey(Context context) {
        try {
            PackageInfo a2 = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (a2 != null) {
                Signature[] signatureArr = a2.signatures;
                if (signatureArr.length > 0) {
                    Signature signature = signatureArr[0];
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                    messageDigest.update(signature.toByteArray());
                    return Base64.encodeToString(messageDigest.digest(), 0).trim();
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo a2 = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            String str = null;
            if (a2 != null) {
                str = byte2HexFormatted(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(a2.signatures[0].toByteArray()))).getEncoded()));
            }
            return str;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getAppName(Context context) {
        if (TextUtils.isEmpty(sAppName)) {
            if (context == null) {
                return null;
            }
            try {
                PackageInfo a2 = com.umeng.commonsdk.utils.b.a().a(context, context.getPackageName(), 64);
                if (a2 != null) {
                    sAppName = a2.applicationInfo.loadLabel(context.getPackageManager()).toString();
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, th);
                }
            }
            return sAppName;
        }
        return sAppName;
    }

    public static String getAppSHA1Key(Context context) {
        try {
            PackageInfo a2 = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            String str = null;
            if (a2 != null) {
                str = byte2HexFormatted(MessageDigest.getInstance(AppSigning.SHA1).digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(a2.signatures[0].toByteArray()))).getEncoded()));
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String getApplicationLable(Context context) {
        return context == null ? "" : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    private static Properties getBuildProp() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                    return properties;
                } catch (Throwable th) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return properties;
                }
            } catch (Throwable th2) {
            }
        } catch (Throwable th3) {
            return properties;
        }
    }

    public static String getCPU() {
        String str;
        String str2 = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            str2 = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
            str = str2;
        } catch (FileNotFoundException e) {
            MLog.e(LOG_TAG, "Could not open file /proc/cpuinfo", e);
            str = str2;
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
    }

    public static String getCustomAgt() {
        if (TextUtils.isEmpty(sCustomAgt)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Dalvik/");
            sb.append(System.getProperty("java.vm.version"));
            sb.append(" (Linux; U; Android ");
            sb.append(")");
            sCustomAgt = sb.toString();
            return sCustomAgt;
        }
        return sCustomAgt;
    }

    public static String getDBencryptID(Context context) {
        return UMUtils.genId();
    }

    public static String getDeviceId(Context context) {
        return AnalyticsConstants.getDeviceType() == 2 ? getDeviceIdForBox(context) : getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdForBox(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                String str2 = "";
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                    String androidId = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    str2 = androidId;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str3 = LOG_TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("getDeviceId, ANDROID_ID: ");
                        sb.append(androidId);
                        MLog.i(str3, sb.toString());
                        str2 = androidId;
                    }
                }
                str = str2;
                if (TextUtils.isEmpty(str2)) {
                    String str4 = str2;
                    String macBySystemInterface = getMacBySystemInterface(context);
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str5 = LOG_TAG;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("getDeviceId, MAC: ");
                        sb2.append(macBySystemInterface);
                        MLog.i(str5, sb2.toString());
                    }
                    str = macBySystemInterface;
                    if (TextUtils.isEmpty(macBySystemInterface)) {
                        String serialNo = getSerialNo();
                        deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                        str = serialNo;
                        if (TextUtils.isEmpty(serialNo)) {
                            String imei = getIMEI(context);
                            deviceTypeEnum = DeviceTypeEnum.IMEI;
                            return imei;
                        }
                    }
                }
            } else if (Build.VERSION.SDK_INT == 23) {
                String str6 = "";
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                    String androidId2 = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    str6 = androidId2;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str7 = LOG_TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("getDeviceId, ANDROID_ID: ");
                        sb3.append(androidId2);
                        MLog.i(str7, sb3.toString());
                        str6 = androidId2;
                    }
                }
                str = str6;
                if (TextUtils.isEmpty(str6)) {
                    String str8 = str6;
                    String macByJavaAPI = getMacByJavaAPI();
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                    String str9 = macByJavaAPI;
                    if (TextUtils.isEmpty(macByJavaAPI)) {
                        if (AnalyticsConstants.CHECK_DEVICE) {
                            str9 = getMacShell();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                        } else {
                            str9 = getMacBySystemInterface(context);
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                        }
                    }
                    String str10 = str9;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str11 = str9;
                        String str12 = LOG_TAG;
                        String str13 = str9;
                        StringBuilder sb4 = new StringBuilder();
                        String str14 = str9;
                        sb4.append("getDeviceId, MAC: ");
                        String str15 = str9;
                        sb4.append(str9);
                        String str16 = str9;
                        MLog.i(str12, sb4.toString());
                    }
                    str = str9;
                    if (TextUtils.isEmpty(str9)) {
                        String str17 = str9;
                        String serialNo2 = getSerialNo();
                        deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                        str = serialNo2;
                        if (TextUtils.isEmpty(serialNo2)) {
                            String imei2 = getIMEI(context);
                            deviceTypeEnum = DeviceTypeEnum.IMEI;
                            return imei2;
                        }
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                str = oaid;
                if (TextUtils.isEmpty(oaid)) {
                    String idfa = getIdfa(context);
                    deviceTypeEnum = DeviceTypeEnum.IDFA;
                    str = idfa;
                    if (TextUtils.isEmpty(idfa)) {
                        String androidId3 = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        str = androidId3;
                        if (TextUtils.isEmpty(androidId3)) {
                            String serialNo3 = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            str = serialNo3;
                            if (TextUtils.isEmpty(serialNo3)) {
                                String macByJavaAPI2 = getMacByJavaAPI();
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                                str = macByJavaAPI2;
                                if (TextUtils.isEmpty(macByJavaAPI2)) {
                                    String macBySystemInterface2 = getMacBySystemInterface(context);
                                    deviceTypeEnum = DeviceTypeEnum.MAC;
                                    return macBySystemInterface2;
                                }
                            }
                        }
                    }
                }
            } else {
                String str18 = "";
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                    String androidId4 = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    str18 = androidId4;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str19 = LOG_TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getDeviceId: ANDROID_ID: ");
                        sb5.append(androidId4);
                        MLog.i(str19, sb5.toString());
                        str18 = androidId4;
                    }
                }
                str = str18;
                if (TextUtils.isEmpty(str18)) {
                    String str20 = str18;
                    String serialNo4 = getSerialNo();
                    deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                    str = serialNo4;
                    if (TextUtils.isEmpty(serialNo4)) {
                        String imei3 = getIMEI(context);
                        deviceTypeEnum = DeviceTypeEnum.IMEI;
                        str = imei3;
                        if (TextUtils.isEmpty(imei3)) {
                            String macByJavaAPI3 = getMacByJavaAPI();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            str = macByJavaAPI3;
                            if (TextUtils.isEmpty(macByJavaAPI3)) {
                                String macBySystemInterface3 = getMacBySystemInterface(context);
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                                str = macBySystemInterface3;
                                if (AnalyticsConstants.UM_DEBUG) {
                                    String str21 = LOG_TAG;
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("getDeviceId, MAC: ");
                                    sb6.append(macBySystemInterface3);
                                    MLog.i(str21, sb6.toString());
                                    str = macBySystemInterface3;
                                }
                            }
                        }
                    }
                }
            }
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String getDeviceIdForGeneral(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                String imei = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                str = imei;
                if (TextUtils.isEmpty(imei)) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.w(LOG_TAG, "No IMEI.");
                    }
                    String macBySystemInterface = getMacBySystemInterface(context);
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                    str = macBySystemInterface;
                    if (TextUtils.isEmpty(macBySystemInterface)) {
                        String str2 = macBySystemInterface;
                        if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                            String androidId = getAndroidId(context);
                            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                            str2 = androidId;
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str3 = LOG_TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("getDeviceId, ANDROID_ID: ");
                                sb.append(androidId);
                                MLog.i(str3, sb.toString());
                                str2 = androidId;
                            }
                        }
                        str = str2;
                        if (TextUtils.isEmpty(str2)) {
                            String str4 = str2;
                            String serialNo = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            return serialNo;
                        }
                    }
                }
            } else if (Build.VERSION.SDK_INT == 23) {
                String imei2 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                str = imei2;
                if (TextUtils.isEmpty(imei2)) {
                    String macByJavaAPI = getMacByJavaAPI();
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                    String str5 = macByJavaAPI;
                    if (TextUtils.isEmpty(macByJavaAPI)) {
                        if (AnalyticsConstants.CHECK_DEVICE) {
                            str5 = getMacShell();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                        } else {
                            str5 = getMacBySystemInterface(context);
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                        }
                    }
                    String str6 = str5;
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str7 = str5;
                        String str8 = LOG_TAG;
                        String str9 = str5;
                        StringBuilder sb2 = new StringBuilder();
                        String str10 = str5;
                        sb2.append("getDeviceId, MAC: ");
                        String str11 = str5;
                        sb2.append(str5);
                        String str12 = str5;
                        MLog.i(str8, sb2.toString());
                    }
                    str = str5;
                    if (TextUtils.isEmpty(str5)) {
                        String str13 = str5;
                        if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                            String str14 = str5;
                            String androidId2 = getAndroidId(context);
                            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                            str13 = androidId2;
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str15 = LOG_TAG;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("getDeviceId, ANDROID_ID: ");
                                sb3.append(androidId2);
                                MLog.i(str15, sb3.toString());
                                str13 = androidId2;
                            }
                        }
                        str = str13;
                        if (TextUtils.isEmpty(str13)) {
                            String str16 = str13;
                            String serialNo2 = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            return serialNo2;
                        }
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                str = oaid;
                if (TextUtils.isEmpty(oaid)) {
                    String idfa = getIdfa(context);
                    deviceTypeEnum = DeviceTypeEnum.IDFA;
                    str = idfa;
                    if (TextUtils.isEmpty(idfa)) {
                        String androidId3 = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        str = androidId3;
                        if (TextUtils.isEmpty(androidId3)) {
                            String serialNo3 = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            str = serialNo3;
                            if (TextUtils.isEmpty(serialNo3)) {
                                String macByJavaAPI2 = getMacByJavaAPI();
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                                str = macByJavaAPI2;
                                if (TextUtils.isEmpty(macByJavaAPI2)) {
                                    String macBySystemInterface2 = getMacBySystemInterface(context);
                                    deviceTypeEnum = DeviceTypeEnum.MAC;
                                    return macBySystemInterface2;
                                }
                            }
                        }
                    }
                }
            } else {
                String imei3 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                str = imei3;
                if (TextUtils.isEmpty(imei3)) {
                    String serialNo4 = getSerialNo();
                    deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                    str = serialNo4;
                    if (TextUtils.isEmpty(serialNo4)) {
                        String str17 = serialNo4;
                        if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                            String androidId4 = getAndroidId(context);
                            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                            str17 = androidId4;
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str18 = LOG_TAG;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("getDeviceId, ANDROID_ID: ");
                                sb4.append(androidId4);
                                MLog.i(str18, sb4.toString());
                                str17 = androidId4;
                            }
                        }
                        str = str17;
                        if (TextUtils.isEmpty(str17)) {
                            String str19 = str17;
                            String macByJavaAPI3 = getMacByJavaAPI();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            str = macByJavaAPI3;
                            if (TextUtils.isEmpty(macByJavaAPI3)) {
                                String macBySystemInterface3 = getMacBySystemInterface(context);
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                                str = macBySystemInterface3;
                                if (AnalyticsConstants.UM_DEBUG) {
                                    String str20 = LOG_TAG;
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("getDeviceId, MAC: ");
                                    sb5.append(macBySystemInterface3);
                                    MLog.i(str20, sb5.toString());
                                    str = macBySystemInterface3;
                                }
                            }
                        }
                    }
                }
            }
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String getDeviceIdType() {
        return deviceTypeEnum.getDeviceIdType();
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Throwable th) {
            return "Phone";
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                return String.valueOf(i2) + "*" + String.valueOf(i);
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    private static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null);
        } catch (Exception e) {
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    public static Activity getGlobleActivity(Context context) {
        Activity activity = null;
        Activity activity2 = null;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Iterator it = ((Map) declaredField.get(invoke)).values().iterator();
            while (true) {
                activity2 = activity;
                if (!it.hasNext()) {
                    return activity;
                }
                Activity activity3 = activity;
                Object next = it.next();
                Activity activity4 = activity;
                Class<?> cls2 = next.getClass();
                Activity activity5 = activity;
                Field declaredField2 = cls2.getDeclaredField("paused");
                Activity activity6 = activity;
                declaredField2.setAccessible(true);
                Activity activity7 = activity;
                if (!declaredField2.getBoolean(next)) {
                    Activity activity8 = activity;
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    Activity activity9 = activity;
                    declaredField3.setAccessible(true);
                    Activity activity10 = activity;
                    activity = (Activity) declaredField3.get(next);
                }
            }
        } catch (Throwable th) {
            return activity2;
        }
    }

    private static String getIMEI(Context context) {
        if (TextUtils.isEmpty(sImei)) {
            String str = "";
            if (hasReadImeiOrMeid) {
                return "";
            }
            String str2 = str;
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.g)) {
                if (context == null) {
                    return "";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                str2 = str;
                if (telephonyManager != null) {
                    str2 = str;
                    try {
                        if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                            String deviceId = telephonyManager.getDeviceId();
                            try {
                                if (AnalyticsConstants.UM_DEBUG) {
                                    String str3 = LOG_TAG;
                                    MLog.i(str3, "getDeviceId, IMEI: " + deviceId);
                                }
                                str2 = deviceId;
                            } catch (Throwable th) {
                                str = deviceId;
                                th = th;
                                str2 = str;
                                try {
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        MLog.w(LOG_TAG, "No IMEI.", th);
                                        str2 = str;
                                    }
                                    sImei = str2;
                                    return sImei;
                                } finally {
                                    hasReadImeiOrMeid = true;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            sImei = str2;
            return sImei;
        }
        return sImei;
    }

    public static String getIdfa(Context context) {
        if (TextUtils.isEmpty(sIDFA)) {
            if (hasReadIDFA) {
                return "";
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
                    sIDFA = a.a(context);
                }
            } catch (Throwable th) {
            }
            hasReadIDFA = true;
            return sIDFA;
        }
        return sIDFA;
    }

    public static String getImei(Context context) {
        if (TextUtils.isEmpty(sImei)) {
            if (hasReadImeiOrMeid) {
                return null;
            }
            String str = null;
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.g)) {
                    str = null;
                    if (context != null) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        str = null;
                        if (telephonyManager != null) {
                            str = null;
                            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                                str = telephonyManager.getDeviceId();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                str = null;
                try {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.w("No IMEI.", th);
                        str = null;
                    }
                } catch (Throwable th2) {
                    hasReadImeiOrMeid = true;
                    throw th2;
                }
            }
            hasReadImeiOrMeid = true;
            sImei = str;
            return str;
        }
        return sImei;
    }

    public static String getImeiNew(Context context) {
        String str;
        if (TextUtils.isEmpty(sImei)) {
            if (hasReadImeiOrMeid) {
                return null;
            }
            String str2 = null;
            String str3 = null;
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.g)) {
                    str2 = null;
                    if (context != null) {
                        str3 = null;
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        str2 = null;
                        if (telephonyManager != null) {
                            str2 = null;
                            str3 = null;
                            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    try {
                                        Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                                        method.setAccessible(true);
                                        str = (String) method.invoke(telephonyManager, new Object[0]);
                                    } catch (Throwable th) {
                                        str = null;
                                    }
                                    str2 = str;
                                    str3 = str;
                                    if (TextUtils.isEmpty(str)) {
                                        str3 = str;
                                        str2 = telephonyManager.getDeviceId();
                                    }
                                } else {
                                    str3 = null;
                                    str2 = telephonyManager.getDeviceId();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                str2 = str3;
                try {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.w("No IMEI.", th2);
                        str2 = str3;
                    }
                } catch (Throwable th3) {
                    hasReadImeiOrMeid = true;
                    throw th3;
                }
            }
            hasReadImeiOrMeid = true;
            sImei = str2;
            return str2;
        }
        return sImei;
    }

    public static String getImsi(Context context) {
        if (TextUtils.isEmpty(sImsi)) {
            String str = null;
            if (hasReadImsi || context == null) {
                return null;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.aj)) {
                str = null;
                try {
                    if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        str = null;
                        if (telephonyManager != null) {
                            str = telephonyManager.getSubscriberId();
                        }
                    }
                } catch (Throwable th) {
                    str = null;
                }
                hasReadImsi = true;
            }
            sImsi = str;
            return sImsi;
        }
        return sImsi;
    }

    private static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return Locale.getDefault();
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "fail to read user config locale");
            locale = null;
        }
        Locale locale2 = locale;
        if (locale == null) {
            locale2 = Locale.getDefault();
        }
        return locale2;
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = {"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    public static String getMCCMNC(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (getImsi(context) == null) {
                return null;
            }
            int i = context.getResources().getConfiguration().mcc;
            int i2 = context.getResources().getConfiguration().mnc;
            if (i != 0) {
                String valueOf = String.valueOf(i2);
                if (i2 < 10) {
                    valueOf = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2));
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(String.valueOf(i));
                stringBuffer.append(valueOf);
                return stringBuffer.toString();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getMac(Context context) {
        String str;
        String macBySystemInterface;
        String str2 = "";
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
            if (context == null) {
                return "";
            }
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    macBySystemInterface = getMacBySystemInterface(context);
                } else {
                    try {
                        if (Build.VERSION.SDK_INT == 23) {
                            String macByJavaAPI = getMacByJavaAPI();
                            str2 = macByJavaAPI;
                            if (TextUtils.isEmpty(macByJavaAPI)) {
                                if (AnalyticsConstants.CHECK_DEVICE) {
                                    str = macByJavaAPI;
                                    macBySystemInterface = getMacShell();
                                } else {
                                    str = macByJavaAPI;
                                    macBySystemInterface = getMacBySystemInterface(context);
                                }
                            }
                        } else {
                            String macByJavaAPI2 = getMacByJavaAPI();
                            str2 = macByJavaAPI2;
                            if (TextUtils.isEmpty(macByJavaAPI2)) {
                                str = macByJavaAPI2;
                                macBySystemInterface = getMacBySystemInterface(context);
                            }
                        }
                    } catch (Throwable th) {
                        str2 = str;
                    }
                }
                return macBySystemInterface;
            } catch (Throwable th2) {
                return "";
            }
        }
        return str2;
    }

    private static String getMacByJavaAPI() {
        if (TextUtils.isEmpty(sWifiMac)) {
            if (hasReadMac) {
                return "";
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        NetworkInterface nextElement = networkInterfaces.nextElement();
                        if ("wlan0".equals(nextElement.getName()) || "eth0".equals(nextElement.getName())) {
                            byte[] hardwareAddress = nextElement.getHardwareAddress();
                            if (hardwareAddress == null || hardwareAddress.length == 0) {
                                sWifiMac = "";
                            }
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= length) {
                                    break;
                                }
                                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                                i = i2 + 1;
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            sWifiMac = sb.toString().toLowerCase(Locale.getDefault());
                        }
                    }
                }
            } catch (Throwable th) {
            }
            hasReadMac = true;
            return sWifiMac;
        }
        return sWifiMac;
    }

    private static String getMacBySystemInterface(Context context) {
        if (TextUtils.isEmpty(sWifiMac)) {
            if (hasReadMac || context == null) {
                return "";
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                        }
                        sWifiMac = "";
                    } else if (wifiManager != null) {
                        sWifiMac = wifiManager.getConnectionInfo().getMacAddress();
                    } else {
                        sWifiMac = "";
                    }
                }
            } finally {
                try {
                    hasReadMac = true;
                    return sWifiMac;
                } catch (Throwable th) {
                }
            }
            hasReadMac = true;
            return sWifiMac;
        }
        return sWifiMac;
    }

    private static String getMacShell() {
        if (TextUtils.isEmpty(sWifiMac)) {
            if (hasReadMac) {
                return "";
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 3) {
                            break;
                        }
                        String reaMac = reaMac(new String[]{"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"}[i2]);
                        if (reaMac != null) {
                            sWifiMac = reaMac;
                        }
                        i = i2 + 1;
                    }
                }
            } catch (Throwable th) {
            }
            hasReadMac = true;
            return sWifiMac;
        }
        return sWifiMac;
    }

    public static String getMeid(Context context) {
        TelephonyManager telephonyManager;
        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return null;
        }
        String str = null;
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.ak)) {
            str = null;
            try {
                if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                    str = null;
                    if (telephonyManager != null) {
                        if (Build.VERSION.SDK_INT < 26) {
                            return getIMEI(context);
                        }
                        String meid = meid(context);
                        str = meid;
                        if (TextUtils.isEmpty(meid)) {
                            str = getIMEI(context);
                        }
                    }
                }
            } catch (Throwable th) {
                return null;
            }
        }
        return str;
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "Wi-Fi";
                return strArr;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "2G/3G";
                strArr[1] = networkInfo2.getSubtypeName();
            }
            return strArr;
        } catch (Throwable th) {
            return strArr;
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (TextUtils.isEmpty(sOperatorName)) {
            if (hasReadOperatorName || context == null) {
                return "";
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                    sOperatorName = telephonyManager.getNetworkOperatorName();
                }
            } catch (Throwable th) {
            }
            hasReadOperatorName = true;
            return sOperatorName;
        }
        return sOperatorName;
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception e) {
            return -100;
        }
    }

    public static String getOaid(Context context) {
        if (TextUtils.isEmpty(sOAID)) {
            if (hasReadOAID) {
                return "";
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.f27233a, 0);
                    if (sharedPreferences != null) {
                        sOAID = sharedPreferences.getString(h.b, "");
                    }
                } catch (Throwable th) {
                }
                hasReadOAID = true;
            }
            return sOAID;
        }
        return sOAID;
    }

    public static String getPackageName(Context context) {
        if (TextUtils.isEmpty(sAppPkgName)) {
            if (context == null) {
                return null;
            }
            sAppPkgName = context.getPackageName();
            return sAppPkgName;
        }
        return sAppPkgName;
    }

    public static String getRegisteredOperator(Context context) {
        if (TextUtils.isEmpty(sOperator)) {
            if (hasReadOperator || context == null) {
                return null;
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                    sOperator = telephonyManager.getNetworkOperator();
                }
            } catch (Throwable th) {
            }
            hasReadOperator = true;
            return sOperator;
        }
        return sOperator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0117, code lost:
        if (r8 == (-1)) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] getResolutionArray(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getResolutionArray(android.content.Context):int[]");
    }

    public static String getSecondSimIMEi(Context context) {
        return null;
    }

    public static String getSerial() {
        return getSerialNo();
    }

    private static String getSerialNo() {
        return "";
    }

    public static String getSid(Context context) {
        return y.a().d(context);
    }

    public static String getSimICCID(Context context) {
        if (TextUtils.isEmpty(sSimSerialNumber)) {
            if (hasReadSimSerialNumber) {
                return null;
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.an)) {
                if (context != null) {
                    try {
                        if (UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager == null) {
                                hasReadSimSerialNumber = true;
                                return null;
                            }
                            sSimSerialNumber = telephonyManager.getSimSerialNumber();
                        }
                    } catch (Throwable th) {
                    }
                }
                hasReadSimSerialNumber = true;
            }
            return sSimSerialNumber;
        }
        return sSimSerialNumber;
    }

    public static String getSubOSName(Context context) {
        String str;
        Properties buildProp = getBuildProp();
        try {
            str = buildProp.getProperty("ro.miui.ui.version.name");
        } catch (Throwable th) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            if (isFlyMe()) {
                return "Flyme";
            }
            if (isEmui(buildProp)) {
                return "Emui";
            }
            if (!TextUtils.isEmpty(getYunOSVersion(buildProp))) {
                return "YunOS";
            }
            return str;
        }
        return r.f25421a;
    }

    public static String getSubOSVersion(Context context) {
        String str;
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty("ro.miui.ui.version.name");
            str = property;
            if (TextUtils.isEmpty(property)) {
                try {
                    return isFlyMe() ? getFlymeVersion(buildProp) : isEmui(buildProp) ? getEmuiVersion(buildProp) : getYunOSVersion(buildProp);
                } catch (Throwable th) {
                    return property;
                }
            }
        } catch (Throwable th2) {
            str = null;
        }
        return str;
    }

    public static int getTimeZone(Context context) {
        if (context == null) {
            return 8;
        }
        try {
            Calendar calendar = Calendar.getInstance(getLocale(context));
            if (calendar != null) {
                return calendar.getTimeZone().getRawOffset() / BaseConstants.Time.HOUR;
            }
            return 8;
        } catch (Throwable th) {
            MLog.i(LOG_TAG, "error in getTimeZone", th);
            return 8;
        }
    }

    private static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return property;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean hasOpsPermission(Context context) {
        boolean z = false;
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.at)) {
            z = false;
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    z = false;
                    if (((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE)).checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, Process.myUid(), getPackageName(context)) == 0) {
                        z = true;
                    }
                } catch (Throwable th) {
                    return false;
                }
            }
        }
        return z;
    }

    public static boolean hasRequestPermission(Context context, String str) {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.at)) {
            return false;
        }
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (strArr[i2].equalsIgnoreCase(str)) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isChineseAera(Context context) {
        if (context == null) {
            return false;
        }
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "country", "");
            if (!TextUtils.isEmpty(imprintProperty)) {
                return imprintProperty.equals(AdvanceSetting.CLEAR_NOTIFICATION);
            } else if (getImsi(context) == null) {
                String str = getLocaleInfo(context)[0];
                return !TextUtils.isEmpty(str) && str.equalsIgnoreCase(AdvanceSetting.CLEAR_NOTIFICATION);
            } else {
                int i = context.getResources().getConfiguration().mcc;
                if (i == 460 || i == 461) {
                    return true;
                }
                if (i == 0) {
                    String str2 = getLocaleInfo(context)[0];
                    return !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(AdvanceSetting.CLEAR_NOTIFICATION);
                }
                return false;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean isEmui(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isHarmony(Context context) {
        try {
            return context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony");
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isSystemApp(Context context) {
        boolean z = false;
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.as)) {
            try {
                PackageInfo a2 = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 1048576);
                z = false;
                if (a2 != null) {
                    z = false;
                    if ((a2.applicationInfo.flags & 1) != 0) {
                        z = true;
                    }
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return z;
    }

    public static boolean isWiFiAvailable(Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    private static String meid(Context context) {
        String str;
        if (TextUtils.isEmpty(sMeid)) {
            if (hasReadImeiOrMeid || context == null) {
                return null;
            }
            try {
                Object invoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke(null, new Object[0]);
                str = null;
                if (invoke != null) {
                    str = null;
                    if (invoke instanceof String) {
                        str = (String) invoke;
                    }
                }
            } catch (Throwable th) {
                try {
                    ULog.e("meid:" + th.getMessage());
                    str = null;
                } catch (Throwable th2) {
                    hasReadImeiOrMeid = true;
                    throw th2;
                }
            }
            hasReadImeiOrMeid = true;
            sMeid = str;
            return sMeid;
        }
        return sMeid;
    }

    private static String reaMac(String str) {
        BufferedReader bufferedReader;
        try {
            FileReader fileReader = new FileReader(str);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 1024);
                try {
                    String readLine = bufferedReader2.readLine();
                    try {
                        fileReader.close();
                    } catch (Throwable th) {
                    }
                    bufferedReader2.close();
                    return readLine;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    try {
                        fileReader.close();
                    } catch (Throwable th3) {
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
        } catch (Throwable th6) {
            return null;
        }
    }

    private static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable th) {
            return -1;
        }
    }
}
