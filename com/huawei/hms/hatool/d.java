package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f22736a = Charset.forName("UTF-8");

    public static Pair<byte[], String> a(String str) {
        if (str == null || str.length() < 32) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, 32);
        return new Pair<>(HexUtil.hexStr2ByteArray(substring), str.substring(32));
    }

    public static String a(String str, String str2) {
        Pair<byte[], String> a2 = a(str);
        return new String(AesCbc.decrypt(HexUtil.hexStr2ByteArray(a2.second), HexUtil.hexStr2ByteArray(str2), a2.first), f22736a);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
            if (hexStr2ByteArray.length >= 16) {
                return HexUtil.byteArray2HexStr(AesCbc.encrypt(bArr, hexStr2ByteArray));
            }
            str2 = "key length is not right";
        }
        z.b("AesCipher", str2);
        return "";
    }

    public static String b(String str, String str2) {
        return HexUtil.byteArray2HexStr(AesCbc.encrypt(str.getBytes(f22736a), HexUtil.hexStr2ByteArray(str2)));
    }
}
