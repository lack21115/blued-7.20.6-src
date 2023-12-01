package com.amap.api.col.p0003sl;

import android.content.Context;
import com.alipay.sdk.util.i;
import com.amap.api.services.core.AMapException;

/* renamed from: com.amap.api.col.3sl.gj  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gj.class */
public final class gj {

    /* renamed from: a  reason: collision with root package name */
    static kj f4993a;

    private static String a(AMapException aMapException) {
        if (aMapException != null) {
            if (aMapException.getErrorLevel() != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(aMapException.getErrorCode());
                return sb.toString();
            }
            int errorCode = aMapException.getErrorCode();
            if (errorCode == 0) {
                return "4";
            }
            int pow = (int) Math.pow(10.0d, Math.floor(Math.log10(errorCode)));
            return String.valueOf((errorCode % pow) + (pow * 4));
        }
        return null;
    }

    private static String a(String str, long j, boolean z) {
        try {
            return "{\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j + ",\"Success\":" + z + i.d;
        } catch (Throwable th) {
            fe.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    private static String a(String str, boolean z) {
        try {
            int indexOf = str.indexOf("?");
            int length = str.length();
            String str2 = "";
            String str3 = str;
            if (indexOf > 0) {
                str3 = str.substring(0, indexOf);
                int i = indexOf + 1;
                str2 = "";
                if (i < length) {
                    str2 = str.substring(i);
                }
            }
            return "{\"RequestPath\":\"" + str3 + "\",\"RequestParm\":\"" + str2 + "\",\"IsCacheRequest\":" + z + i.d;
        } catch (Throwable th) {
            fe.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static void a(Context context, String str, long j, boolean z) {
        try {
            String a2 = a(str, j, z);
            if (a2 == null || a2.length() <= 0) {
                return;
            }
            if (f4993a == null) {
                f4993a = new kj(context, "sea", "9.3.1", "O002");
            }
            f4993a.a(a2);
            kk.a(f4993a, context);
        } catch (Throwable th) {
            fe.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static void a(Context context, String str, boolean z) {
        try {
            String a2 = a(str, z);
            if (a2 == null || a2.length() <= 0) {
                return;
            }
            kj kjVar = new kj(context, "sea", "9.3.1", "O006");
            kjVar.a(a2);
            kk.a(kjVar, context);
        } catch (Throwable th) {
            fe.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static void a(String str, String str2, AMapException aMapException) {
        if (str != null) {
            String errorType = aMapException.getErrorType();
            String a2 = a(aMapException);
            if (a2 == null || a2.length() <= 0) {
                return;
            }
            iw.a(fd.a(true), str, errorType, str2, a2);
        }
    }
}
