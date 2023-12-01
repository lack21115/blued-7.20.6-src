package cn.com.chinatelecom.account.api;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import cn.com.chinatelecom.account.api.a.b;
import cn.com.chinatelecom.account.api.e.d;
import cn.com.chinatelecom.account.api.e.g;
import java.security.interfaces.RSAPublicKey;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/ClientUtils.class */
public final class ClientUtils {
    public static final int TYPE_SDK_API = 0;
    public static final int TYPE_SDK_BIO = 2;
    public static final int TYPE_SDK_HY = 1;
    private static final String TAG = ClientUtils.class.getSimpleName();
    private static int sdkType = 0;

    public static String enrdata(String str, String str2) {
        try {
            return b.a(str, (RSAPublicKey) b.a(str2));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getApiVersion() {
        return "3.0";
    }

    public static String getCurrentNetworkType(Context context) {
        return g.f(context);
    }

    public static boolean getHealthy(Context context) {
        try {
            return d.d(context);
        } catch (Throwable th) {
            String str = TAG;
            CtAuth.warn(str, "getHealthy error ：" + th.getMessage(), th);
            return false;
        }
    }

    public static boolean getMacData() {
        try {
            return d.c();
        } catch (Throwable th) {
            String str = TAG;
            CtAuth.warn(str, "getMacData error ：" + th.getMessage(), th);
            return false;
        }
    }

    public static String getMobileBrand() {
        return Build.BRAND;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static boolean getNetSafe(Context context) {
        try {
            return d.c(context);
        } catch (Throwable th) {
            String str = TAG;
            CtAuth.warn(str, "getNetSafe error ：" + th.getMessage(), th);
            return false;
        }
    }

    public static String getOnlineType(Context context) {
        return g.g(context);
    }

    public static String getOperatorType(Context context) {
        return g.h(context);
    }

    public static String getOs() {
        return getMobileBrand() + "-" + getModel() + "-A:" + Build.VERSION.RELEASE;
    }

    public static String getPID() {
        String str = "";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Thread.currentThread().getId());
            sb.append("");
            sb.append(Process.myPid());
            String sb2 = sb.toString();
            if (sb2.length() > 6) {
                str = sb2;
                return sb2.substring(0, 6);
            }
            return "ctacco";
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static int getSdkType() {
        return sdkType;
    }

    public static String getSdkVersion() {
        int i = sdkType;
        return i == 1 ? "SDK-HY-v3.8.10" : i == 2 ? "SDK-BIOM-v3.8.10" : "SDK-API-v3.8.10";
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (cn.com.chinatelecom.account.api.e.d.d() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean getTimePass(android.content.Context r4) {
        /*
            r0 = 0
            r5 = r0
            r0 = r4
            boolean r0 = cn.com.chinatelecom.account.api.e.d.b(r0)     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L11
            boolean r0 = cn.com.chinatelecom.account.api.e.d.d()     // Catch: java.lang.Throwable -> L15
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L13
        L11:
            r0 = 1
            r5 = r0
        L13:
            r0 = r5
            return r0
        L15:
            r4 = move-exception
            java.lang.String r0 = cn.com.chinatelecom.account.api.ClientUtils.TAG
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "getTimePass error ："
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r4
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r8
            java.lang.String r1 = r1.toString()
            r2 = r4
            cn.com.chinatelecom.account.api.CtAuth.warn(r0, r1, r2)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.chinatelecom.account.api.ClientUtils.getTimePass(android.content.Context):boolean");
    }

    public static long getTp() {
        return System.currentTimeMillis();
    }

    public static boolean isJY() {
        return true;
    }

    public static boolean objChange(Object obj, String str) {
        try {
            return d.a(obj, str);
        } catch (Throwable th) {
            String str2 = TAG;
            CtAuth.warn(str2, "objChange error ：" + th.getMessage(), th);
            return false;
        }
    }

    public static void setSdkType(int i) {
        sdkType = i;
    }

    public static String strBuf() {
        try {
            return d.b().toString();
        } catch (Throwable th) {
            String str = TAG;
            CtAuth.warn(str, "strBuf error ：" + th.getMessage(), th);
            return "";
        }
    }
}
