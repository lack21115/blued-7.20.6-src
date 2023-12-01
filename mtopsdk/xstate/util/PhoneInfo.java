package mtopsdk.xstate.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.alipay.sdk.util.i;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.telephony.SmsConstants;
import com.android.internal.util.cm.QSConstants;
import mtopsdk.common.util.ConfigStoreManager;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/xstate/util/PhoneInfo.class */
public class PhoneInfo {
    private static ConfigStoreManager a = ConfigStoreManager.a();

    public static String a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", SmsConstants.FORMAT_UNKNOWN);
        } catch (Throwable th) {
            TBSdkLog.d("mtopsdk.PhoneInfo", "[getSerialNum]error ---" + th.toString());
            return null;
        }
    }

    public static String a(Context context) {
        try {
            String str = Build.VERSION.RELEASE;
            String str2 = Build.MANUFACTURER;
            String str3 = Build.MODEL;
            return "MTOPSDK/open_1.0.0 (Android" + i.b + str + i.b + str2 + i.b + str3 + ")";
        } catch (Throwable th) {
            TBSdkLog.d("mtopsdk.PhoneInfo", "[getPhoneBaseInfo] error ---" + th.toString());
            return "";
        }
    }

    public static String b(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            String deviceId = ((TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY)).getDeviceId();
            str = deviceId;
            if (deviceId != null) {
                str = deviceId;
                return deviceId.trim();
            }
        } catch (Throwable th) {
            TBSdkLog.d("mtopsdk.PhoneInfo", "[getOriginalImei]error ---" + th.toString());
        }
        return str;
    }

    public static String c(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY)).getSubscriberId();
            str = subscriberId;
            if (subscriberId != null) {
                str = subscriberId;
                return subscriberId.trim();
            }
        } catch (Throwable th) {
            TBSdkLog.d("mtopsdk.PhoneInfo", "[getOriginalImsi]error ---" + th.toString());
        }
        return str;
    }

    public static String d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            TBSdkLog.d("mtopsdk.PhoneInfo", "[getAndroidId]error ---" + th.toString());
            return null;
        }
    }

    public static String e(Context context) {
        String str;
        String a2;
        if (context == null) {
            return "";
        }
        try {
            a2 = a.a(context, "MtopConfigStore", "PHONE_INFO_STORE.", "mtopsdk_mac_address");
        } catch (Throwable th) {
            TBSdkLog.d("mtopsdk.PhoneInfo", "[getLocalMacAddress]error ---" + th.toString());
            str = "";
        }
        if (StringUtils.a(a2)) {
            return new String(Base64.decode(a2, 0));
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService(QSConstants.TILE_WIFI);
        String str2 = a2;
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            str2 = a2;
            if (connectionInfo != null) {
                str2 = connectionInfo.getMacAddress();
            }
        }
        String str3 = str2;
        str = str2;
        if (StringUtils.a(str2)) {
            String str4 = str2;
            a.a(context, "MtopConfigStore", "PHONE_INFO_STORE.", "mtopsdk_mac_address", Base64.encodeToString(str2.getBytes(), 0));
            return str2;
        }
        return str;
    }
}
