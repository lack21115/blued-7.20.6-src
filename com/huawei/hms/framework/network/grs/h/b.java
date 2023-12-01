package com.huawei.hms.framework.network.grs.h;

import android.text.TextUtils;
import com.android.internal.telephony.PhoneConstants;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/h/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22721a = "b";
    private static final Pattern b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    public static String a(String str) {
        return a(str, "SHA-256");
    }

    private static String a(String str, String str2) {
        String str3;
        Object obj;
        try {
        } catch (UnsupportedEncodingException e) {
            str3 = f22721a;
            obj = "encrypt UnsupportedEncodingException";
        }
        try {
            return a(MessageDigest.getInstance(str2).digest(str.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e2) {
            str3 = f22721a;
            obj = "encrypt NoSuchAlgorithmException";
            Logger.w(str3, obj);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            i = i2 + 1;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 1;
        if (str.length() == 1) {
            return PhoneConstants.APN_TYPE_ALL;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < str.length()) {
            String str2 = str.charAt(i2) + "";
            int i3 = i;
            String str3 = str2;
            if (b.matcher(str2).matches()) {
                if (i % 2 == 0) {
                    str2 = PhoneConstants.APN_TYPE_ALL;
                }
                i3 = i + 1;
                str3 = str2;
            }
            stringBuffer.append(str3);
            i2++;
            i = i3;
        }
        return stringBuffer.toString();
    }
}
