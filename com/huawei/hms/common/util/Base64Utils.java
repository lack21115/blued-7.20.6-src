package com.huawei.hms.common.util;

import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/util/Base64Utils.class */
public final class Base64Utils {
    public static byte[] decode(String str) {
        if (str != null) {
            try {
                return Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                HMSLog.e("Base64Utils", "decode failed : " + e.getMessage());
            }
        }
        return new byte[0];
    }

    public static byte[] decodeUrlSafe(String str) {
        if (str != null) {
            try {
                return Base64.decode(str, 10);
            } catch (IllegalArgumentException e) {
                HMSLog.e("Base64Utils", "decodeUrlSafe failed : " + e.getMessage());
            }
        }
        return new byte[0];
    }

    public static byte[] decodeUrlSafeNoPadding(String str) {
        if (str != null) {
            try {
                return Base64.decode(str, 11);
            } catch (IllegalArgumentException e) {
                HMSLog.e("Base64Utils", "decodeUrlSafeNoPadding failed : " + e.getMessage());
            }
        }
        return new byte[0];
    }

    public static String encode(byte[] bArr) {
        if (bArr != null) {
            return Base64.encodeToString(bArr, 0);
        }
        return null;
    }

    public static String encodeUrlSafe(byte[] bArr) {
        if (bArr != null) {
            return Base64.encodeToString(bArr, 10);
        }
        return null;
    }

    public static String encodeUrlSafeNoPadding(byte[] bArr) {
        if (bArr != null) {
            return Base64.encodeToString(bArr, 11);
        }
        return null;
    }
}
