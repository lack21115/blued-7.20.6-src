package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/c.class */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f9235a = new Object();
    private static int b = -1;

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
            File file = (File) cls.getDeclaredMethod("getCfgFile", String.class, Integer.TYPE).invoke(cls, "jars/hwpush.jar", Integer.valueOf(((Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls)).intValue()));
            if (file == null || !file.exists()) {
                return false;
            }
            HMSLog.d("CommFun", "get push cust File path success.");
            return true;
        } catch (ClassNotFoundException e) {
            HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
            return false;
        } catch (IllegalAccessException e2) {
            HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
            return false;
        } catch (IllegalArgumentException e3) {
            HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
            return false;
        } catch (NoSuchFieldException e4) {
            HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
            return false;
        } catch (NoSuchMethodException e5) {
            HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
            return false;
        } catch (SecurityException e6) {
            HMSLog.e("CommFun", "check cust exist push SecurityException.");
            return false;
        } catch (InvocationTargetException e7) {
            HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
            return false;
        }
    }

    private static boolean a(Context context) {
        HMSLog.d("CommFun", "existFrameworkPush:" + b);
        boolean z = false;
        try {
            File file = new File("/system/framework/hwpush.jar");
            if (!a()) {
                if (file.isFile()) {
                    HMSLog.d("CommFun", "push jarFile is exist");
                }
                return z;
            }
            HMSLog.d("CommFun", "push jarFile is exist");
            z = true;
            return z;
        } catch (Exception e) {
            HMSLog.e("CommFun", "get Apk version faild ,Exception e= " + e.toString());
            return false;
        }
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (jSONObject != null) {
            return TextUtils.isEmpty(str) && jSONObject2 == null;
        }
        return true;
    }

    public static long b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception e) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    public static boolean b() {
        return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    public static String c(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    public static boolean c() {
        return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    public static boolean d(Context context) {
        HMSLog.d("CommFun", "existFrameworkPush:" + b);
        synchronized (f9235a) {
            int i = b;
            boolean z = false;
            if (-1 != i) {
                if (1 == i) {
                    z = true;
                }
                return z;
            }
            if (a(context)) {
                b = 1;
            } else {
                b = 0;
            }
            boolean z2 = false;
            if (1 == b) {
                z2 = true;
            }
            return z2;
        }
    }
}
