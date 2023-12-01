package com.heytap.baselib.utils;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/ImeiHelper.class */
public class ImeiHelper {
    private static String C_GET_IMEI = "colorGetImei";
    private static String cimei;
    private static boolean cimeiInited = false;
    private static String imeiBlowO;
    private static boolean imeiBlowOInited = false;
    private static volatile String imeiForO;
    private static volatile boolean imeiForOInited = false;
    private static String imeiForP;
    private static boolean imeiForPInited = false;

    ImeiHelper() {
    }

    static String getClassName() {
        return "android.telephony." + idIOUtil.decodeBase64("Q29sb3JPUw==") + "TelephonyManager";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IDResult getDeviceIdBelowO(Context context) {
        int i;
        if (imeiBlowOInited) {
            return new IDResult(imeiBlowO, Constant.RET_CODE_IMEI_CACHED);
        }
        int i2 = Constant.RET_CODE_IMEI_PERMISSION_DENIED;
        try {
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log("try get imei below O ...");
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                imeiBlowOInited = true;
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                imeiBlowO = deviceId;
                i = TextUtils.isEmpty(deviceId) ? Constant.RET_CODE_IMEI_GRANTED : Constant.RET_CODE_IMEI_SUCCESS;
            } else {
                i = i2;
                if (ClientIdEnvironment.debug) {
                    ClientIdEnvironment.log("permission is denied, cannot get imei");
                    i = i2;
                }
            }
        } catch (Exception e) {
            i = i2;
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log("get device id below AndroidO with exception is " + e.toString());
                i = i2;
            }
        }
        return new IDResult(imeiBlowO, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IDResult getImeiWhenO(Context context) {
        int i;
        if (imeiForOInited) {
            return new IDResult(imeiForO, Constant.RET_CODE_IMEI_CACHED);
        }
        int i2 = Constant.RET_CODE_IMEI_PERMISSION_DENIED;
        try {
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log("try get imei on AndroidO...");
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String str = null;
                try {
                    str = telephonyManager.getImei(0);
                } catch (Exception e) {
                }
                String str2 = str;
                if (TextUtils.isEmpty(str)) {
                    str2 = telephonyManager.getMeid(0);
                }
                imeiForOInited = true;
                imeiForO = str2;
                i = TextUtils.isEmpty(str2) ? Constant.RET_CODE_IMEI_GRANTED : Constant.RET_CODE_IMEI_SUCCESS;
            } else {
                i = i2;
                if (ClientIdEnvironment.debug) {
                    ClientIdEnvironment.log("permission is denied, cannot get imei");
                    i = i2;
                }
            }
        } catch (Exception e2) {
            i = i2;
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log("get imei on AndroidO with exception is: " + e2.toString());
                i = i2;
            }
        }
        return new IDResult(imeiForO, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IDResult getImeiWhenP(Context context) {
        int i;
        if (imeiForPInited) {
            return new IDResult(imeiForP, Constant.RET_CODE_IMEI_CACHED);
        }
        int i2 = Constant.RET_CODE_IMEI_PERMISSION_DENIED;
        try {
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log("try get imei on P...");
            }
            if (context.checkCallingOrSelfPermission(Manifest.permission.READ_PRIVILEGED_PHONE_STATE) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String str = null;
                try {
                    str = telephonyManager.getImei(0);
                } catch (Exception e) {
                }
                String str2 = str;
                if (TextUtils.isEmpty(str)) {
                    str2 = telephonyManager.getMeid(0);
                }
                imeiForPInited = true;
                imeiForP = str2;
                i = TextUtils.isEmpty(str2) ? Constant.RET_CODE_IMEI_GRANTED : Constant.RET_CODE_IMEI_SUCCESS;
            } else {
                i = i2;
                if (ClientIdEnvironment.debug) {
                    ClientIdEnvironment.log("permission is denied, cannot get imei");
                    i = i2;
                }
            }
        } catch (Exception e2) {
            i = i2;
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log("get imei on AndroidP with exception is: " + e2.toString());
                i = i2;
            }
        }
        return new IDResult(imeiForP, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isReadPhoneStateGranted(android.content.Context r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = r0
            r0 = 0
            r5 = r0
            r0 = r4
            r1 = 23
            if (r0 < r1) goto L18
            r0 = r3
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            int r0 = r0.checkSelfPermission(r1)
            if (r0 != 0) goto L25
            goto L23
        L18:
            r0 = r3
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            int r0 = com.heytap.baselib.appcompat.PermissionChecker.checkSelfPermission(r0, r1)
            if (r0 == 0) goto L23
            r0 = 0
            return r0
        L23:
            r0 = 1
            r5 = r0
        L25:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.baselib.utils.ImeiHelper.isReadPhoneStateGranted(android.content.Context):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IDResult reflectCImei(Context context) {
        int i;
        if (Build.VERSION.SDK_INT >= 30) {
            return new IDResult(null, Constant.RET_CODE_VERSION_ABOVE_Q);
        }
        if (cimeiInited) {
            return new IDResult(cimei, Constant.RET_CODE_IMEI_CACHED);
        }
        if (!isReadPhoneStateGranted(context)) {
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log("don't grant read phone state permission");
            }
            return new IDResult(null, Constant.RET_CODE_IMEI_PERMISSION_DENIED);
        }
        int i2 = Constant.RET_CODE_IMEI_GRANTED;
        try {
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log("try reflect imei...");
            }
            Class<?> cls = Class.forName(getClassName());
            Method method = cls.getMethod("getDefault", Context.class);
            cimeiInited = true;
            cimei = (String) cls.getMethod(C_GET_IMEI, Integer.TYPE).invoke(method.invoke(cls, context), 0);
            i = Constant.RET_CODE_IMEI_SUCCESS;
        } catch (Exception e) {
            i = i2;
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log("reflect ime with exception is: " + e.toString());
                i = i2;
            }
        }
        return new IDResult(cimei, i);
    }
}
