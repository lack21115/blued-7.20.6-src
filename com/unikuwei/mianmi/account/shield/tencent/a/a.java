package com.unikuwei.mianmi.account.shield.tencent.a;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f27290a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String a() {
        String str;
        String str2 = "";
        try {
            String uuid = UUID.randomUUID().toString();
            str = "";
            if (!TextUtils.isEmpty(uuid)) {
                String replace = uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                str = replace;
                if (replace.length() >= 16) {
                    str2 = replace;
                    return replace.substring(0, 16);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            str = str2;
        }
        return str;
    }

    public static String a(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec("0000000000000000".getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(new String(b.b("QUVTL0NCQy9QS0NTNVBhZGRpbmc=")));
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(c.a(str)));
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
