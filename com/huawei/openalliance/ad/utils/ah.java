package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ah.class */
public class ah {
    private static final String Code = "MetaDataUtils";

    public static Integer Code(Context context, String str, String str2) {
        try {
            Object I = I(context, str, str2);
            if (I != null) {
                return au.F(I.toString());
            }
            return null;
        } catch (Throwable th) {
            ge.I(Code, "getIntegerMetaData %s err: %s", str2, th.getClass().getSimpleName());
            return null;
        }
    }

    private static Object I(Context context, String str, String str2) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return null;
            }
            return applicationInfo.metaData.get(str2);
        } catch (Throwable th) {
            ge.I(Code, "getMetaData %d err: %s", str2, th.getClass().getSimpleName());
            return null;
        }
    }

    public static String V(Context context, String str, String str2) {
        try {
            Object I = I(context, str, str2);
            if (I != null) {
                return I.toString();
            }
            return null;
        } catch (Throwable th) {
            ge.I(Code, "getIntegerMetaData %s err: %s", str2, th.getClass().getSimpleName());
            return null;
        }
    }
}
