package com.umeng.umcrash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.uc.crashsdk.export.CrashApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/umcrash/UMCrashUtils.class */
public class UMCrashUtils {
    private static final int DEF_CLOSE_RATE = 0;
    private static final int MAX_TRACE_RATE = 100;
    public static final String UNKNOW = "";

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
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umcrash.UMCrashUtils.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    public static String[] getActiveUser(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.utils.UMUtils");
        } catch (ClassNotFoundException e) {
            cls = null;
        }
        String[] strArr = null;
        if (cls != null) {
            try {
                method = cls.getMethod("getActiveUser", Context.class);
            } catch (NoSuchMethodException e2) {
                method = null;
            }
            strArr = null;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, context);
                    strArr = null;
                    if (invoke != null) {
                        strArr = (String[]) invoke;
                    }
                } catch (IllegalAccessException | InvocationTargetException e3) {
                    return null;
                }
            }
        }
        return strArr;
    }

    public static int getInnerConfig(Context context, String str, int i) {
        SharedPreferences sharedPreferences;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) != null) {
                    return sharedPreferences.getInt(str, i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i;
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (!checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) ? "" : telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean isHarmony(Context context) {
        try {
            return context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony");
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean random(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new Random().nextInt(100) <= i;
    }

    public static void saveInnerConfig(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || obj == null || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null || (edit = sharedPreferences.edit()) == null) {
                    return;
                }
                edit.putInt(str, Integer.parseInt(obj.toString()));
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setCommonTag(String str, String str2) {
        Class<?> cls;
        Method declaredMethod;
        try {
            Class<?> cls2 = Class.forName("com.umeng.commonsdk.UMConfigure");
            if (cls2 == null || (cls = Class.forName("com.umeng.commonsdk.UMConfigure$BS_TYPE")) == null || (declaredMethod = cls2.getDeclaredMethod("setModuleTag", cls, String.class, String.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            Enum[] enumArr = (Enum[]) cls.getEnumConstants();
            int length = enumArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Enum r0 = enumArr[i2];
                if (r0 != null) {
                    if (r0.name().equals("APM")) {
                        declaredMethod.invoke(cls2, r0, str, str2);
                    }
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setIntegrationTesingParams(String str) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_dk", str);
        }
        if (UMCrash.getReporter() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("um_dk", str);
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static void setPuidAndProvider(String str, String str2) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PUID, str);
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PROVIDER, str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(UMCrash.KEY_HEADER_PUID, str);
        hashMap.put(UMCrash.KEY_HEADER_PROVIDER, str2);
        if (UMCrash.getReporter() != null) {
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static String splitByByte(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        try {
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                String valueOf = String.valueOf(str.charAt(i3));
                i2 += valueOf.getBytes().length;
                if (i < i2) {
                    break;
                }
                stringBuffer.append(valueOf);
            }
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }
}
