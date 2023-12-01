package com.soft.blued.ui.photo.camera.utils;

import com.soft.blued.utils.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/utils/HMACUtils.class */
public class HMACUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f19351a = HMACUtils.class.getSimpleName();

    public static String a(String str, String str2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            return a(mac.doFinal(str.getBytes()));
        } catch (Exception e) {
            Logger.b(f19351a, "Error sha256_HMAC == =========", e);
            return "";
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (bArr == null || i2 >= bArr.length) {
                break;
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
            i = i2 + 1;
        }
        return sb.toString().toLowerCase();
    }
}
