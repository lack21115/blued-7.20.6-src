package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/b.class */
public class b {
    public static byte[] a(Bundle bundle, String str) {
        try {
            byte[] byteArray = bundle.getByteArray(str);
            byte[] bArr = byteArray;
            if (byteArray == null) {
                bArr = new byte[0];
            }
            return bArr;
        } catch (Exception e) {
            HMSLog.i("BundleUtil", "getByteArray exception" + e.getMessage());
            return new byte[0];
        }
    }

    public static String b(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            HMSLog.i("BundleUtil", "getString exception" + e.getMessage());
            return null;
        }
    }

    public static String c(Bundle bundle, String str) {
        try {
            String string = bundle.getString(str);
            return string == null ? "" : string;
        } catch (Exception e) {
            HMSLog.i("BundleUtil", "getString exception" + e.getMessage());
            return "";
        }
    }
}
