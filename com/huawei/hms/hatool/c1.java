package com.huawei.hms.hatool;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/c1.class */
public class c1 extends f {
    public static String c() {
        String str;
        String str2 = "";
        try {
            String str3 = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
            try {
                z.c("hmsSdk", "getUDID success");
                return str3;
            } catch (AndroidRuntimeException e) {
                str2 = str3;
                str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                z.f("hmsSdk", str);
                return str2;
            } catch (ClassNotFoundException e2) {
                str2 = str3;
                str = "getUDID method invoke failed";
                z.f("hmsSdk", str);
                return str2;
            } catch (IllegalAccessException e3) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal AccessException";
                z.f("hmsSdk", str);
                return str2;
            } catch (IllegalArgumentException e4) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal ArgumentException";
                z.f("hmsSdk", str);
                return str2;
            } catch (NoSuchMethodException e5) {
                str2 = str3;
                str = "getUDID method invoke failed : NoSuchMethodException";
                z.f("hmsSdk", str);
                return str2;
            } catch (InvocationTargetException e6) {
                str2 = str3;
                str = "getUDID method invoke failed : InvocationTargetException";
                z.f("hmsSdk", str);
                return str2;
            }
        } catch (AndroidRuntimeException e7) {
        } catch (ClassNotFoundException e8) {
        } catch (IllegalAccessException e9) {
        } catch (IllegalArgumentException e10) {
        } catch (NoSuchMethodException e11) {
        } catch (InvocationTargetException e12) {
        }
    }

    public static Pair<String, String> e(Context context) {
        if (r0.a(context, "android.permission.READ_PHONE_STATE")) {
            z.f("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && telephonyManager.getSimState() == 5) {
            String networkOperator = telephonyManager.getNetworkOperator();
            return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, com.igexin.push.core.b.l)) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
        }
        return new Pair<>("", "");
    }
}
