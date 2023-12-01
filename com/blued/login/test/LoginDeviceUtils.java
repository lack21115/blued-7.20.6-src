package com.blued.login.test;

import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.utils.CommonPreferences;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.UUID;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/test/LoginDeviceUtils.class */
public class LoginDeviceUtils {
    public static String a() {
        String str;
        if (TextUtils.isEmpty(AppInfo.d) && TextUtils.isEmpty(AppInfo.e)) {
            String a2 = CommonPreferences.a().a("uuid", (String) null);
            str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                CommonPreferences.a().c().a("uuid", str).a();
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

    public static String b() {
        String str;
        if (TextUtils.isEmpty(AppInfo.d) && TextUtils.isEmpty(AppInfo.e)) {
            String a2 = CommonPreferences.a().a("uuid", (String) null);
            str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                CommonPreferences.a().c().a("uuid", str).a();
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            str = AppInfo.d + AppInfo.e;
        } else {
            String[] c2 = c();
            str = c2[0] + c2[1] + AppInfo.e;
        }
        try {
            String a3 = Md5.a(str, AesCrypto.b);
            return a3 + Md5.a(a3, AesCrypto.b);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String[] c() {
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
}
