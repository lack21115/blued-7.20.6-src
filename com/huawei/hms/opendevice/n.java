package com.huawei.hms.opendevice;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/n.class */
public final class n {
    public static String a(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            String str3 = str2;
            if (TextUtils.isEmpty(str2)) {
                str3 = "SHA-256";
            }
            MessageDigest messageDigest = MessageDigest.getInstance(str3);
            messageDigest.update(bytes);
            return HEX.encodeHexString(messageDigest.digest(), false);
        } catch (UnsupportedEncodingException e) {
            HMSLog.e("SHACoder", "trans failed .");
            return null;
        } catch (NoSuchAlgorithmException e2) {
            HMSLog.e("SHACoder", "encrypt failed .");
            return null;
        }
    }
}
