package com.sina.weibo.sdk.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/Utility.class */
public class Utility {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";

    public static Boolean checkMyPermission(Context context, String str) {
        return Boolean.valueOf(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        String[] split = str.split("&");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bundle;
            }
            String[] split2 = split[i2].split("=");
            try {
                bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    public static String generateGUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generateUA(Context context) {
        return Build.MANUFACTURER + "-" + Build.MODEL + BridgeUtil.UNDERLINE_STR + Build.VERSION.RELEASE + BridgeUtil.UNDERLINE_STR + "weibosdk" + BridgeUtil.UNDERLINE_STR + WBConstants.WEIBO_SDK_VERSION_CODE + "_android";
    }

    public static String generateUAAid(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append("-");
        sb.append(Build.MODEL);
        sb.append("__");
        sb.append("weibosdk");
        sb.append("__");
        try {
            sb.append(WBConstants.WEIBO_SDK_VERSION_CODE.replaceAll("\\s+", BridgeUtil.UNDERLINE_STR));
        } catch (Exception e) {
            sb.append("unknown");
        }
        sb.append("__");
        sb.append("android");
        sb.append("__android");
        sb.append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    public static String getAid(Context context, String str) {
        AidTask.AidInfo aidSync = AidTask.getInstance(context).getAidSync(str);
        return aidSync != null ? aidSync.getAid() : "";
    }

    public static String getImei(Context context) {
        String deviceId = checkMyPermission(context, "android.permission.READ_PHONE_STATE").booleanValue() ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : "";
        return deviceId == null ? "" : deviceId;
    }

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= packageInfo.signatures.length) {
                    return null;
                }
                byte[] byteArray = packageInfo.signatures[i2].toByteArray();
                if (byteArray != null) {
                    return MD5.hexdigest(byteArray);
                }
                i = i2 + 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String getWifiMac(Context context) {
        String macAddress = checkMyPermission(context, "android.permission.ACCESS_WIFI_STATE").booleanValue() ? ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress() : "";
        return macAddress == null ? "" : macAddress;
    }

    public static boolean isChineseLocale(Context context) {
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            if (Locale.CHINA.equals(locale) || Locale.CHINESE.equals(locale) || Locale.SIMPLIFIED_CHINESE.equals(locale)) {
                return true;
            }
            return Locale.TAIWAN.equals(locale);
        } catch (Exception e) {
            return true;
        }
    }

    public static Boolean isWeiBoVersionSupportNewPay(Context context) {
        int i;
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        boolean z = false;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return false;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        int i2 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            i2 = i;
            if (next.serviceInfo != null) {
                i2 = i;
                if (next.serviceInfo.applicationInfo != null) {
                    if (TextUtils.isEmpty(next.serviceInfo.applicationInfo.packageName)) {
                        i2 = i;
                    } else {
                        try {
                            i2 = context.getPackageManager().getPackageInfo(next.serviceInfo.applicationInfo.packageName, 0).versionCode;
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                            i2 = i;
                        }
                    }
                }
            }
        }
        if (i >= 1920) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static void openWeiboActivity(Context context, String str, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.putExtra(WBConstants.Base.APP_PKG, context.getPackageName());
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            intent.putExtras(bundle);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }

    public static Bundle parseUri(String str) {
        try {
            return decodeUrl(new URI(str).getQuery());
        } catch (Exception e) {
            return new Bundle();
        }
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static String safeString(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        return str2;
    }

    public static void shareMessagetoWeibo(Context context, String str, Bundle bundle) {
        try {
            Intent intent = new Intent();
            String valueOf = String.valueOf(System.currentTimeMillis());
            intent.putExtra(WBConstants.TRAN, valueOf);
            HashMap hashMap = new HashMap();
            hashMap.put(WBConstants.ACTION_START_TIME, valueOf);
            try {
                WBAgent.onEvent(context, "message", hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            intent.setAction("android.intent.action.VIEW");
            intent.putExtra(WBConstants.Base.APP_PKG, context.getPackageName());
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            intent.putExtras(bundle);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
        }
    }
}
