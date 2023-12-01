package com.danlan.android.cognition;

import android.text.TextUtils;
import android.util.Base64;
import com.danlan.android.cognition.common.ByteTransformUtils;
import com.danlan.android.security.AesCryptor;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/Cryptor.class */
public class Cryptor {
    public static final String ENC_KEY = StringFog.decrypt("RRcWR0UXQBUXGh1BQEYVQhhBQkdHF0cRRxRHFENAHEUXQkZAREBGREJHRRcRGxAWRUISEBZHEhIWFRdBGBIQFREWEEUZEh0SFRQUR0URExNFRkcUREARQkBGRUAZEkIQGREUF0caQBgVQhEQExZAEkUXFRQVGkIXQhRBG0IXRhEYR0dBQhdHFxUbR0ARQBNHRRoWRhAWEERDQRYRFEISEhFBFRFEQBFDFBJFFxhHQUNCExQSGUYdRBhGQEBAR0ETQBsUFkIVFRARFkIWFkUUR0UTFRIQEhMQGBpFFxIXQEIRERAVEEJFFRcSRxdAQh0ZEBVFEkRBRxEUFBcUEUVCERgURkBHQEVDEhdHERcXHUQVQEJFEhNCQkNCHEcUGx0VQ0ASEUVBFUJCFhIbF0IVFkcRRxZAEB1HERdCGxlAEEIWEhAUERVAQBMSRkISExAWEUIcGxMRERgQQBwUGEAdRBkWQBARRRRH");
    public static final String DEC_KEY = StringFog.decrypt("EBATRxRHFRMYFB1BEEUSEhESRxoRGkJHFhITGxMbHBZCEkBBFhtFEBUWFBQVFUVAGBVCGxlAFBRCG0ESRBcVRBVAHRsYFxJAQkUcEkMTHBEXEB1HFEUREhcbFkASExcYR0AcEhhFERRDFxcaRRocFhVFHBRARUcVEBMTExAVHREURRZBFhoRERkSRRUTFEBFRBdCQBkaExVCGhZBGUJAFEVBHBQUEEdFERBBRxFBExlCRhBCRxZAFhEWExASEEUTR0cTE0JGRkcTRxFAREBHGEIRFxIYEhJHExUTQUUXEEIUFxcaFxsVEUBHEBBDQR1CQhtCRUUQQhESQEERRUUTExcTFBIXEBYYFRcQExQSQhQSFEYVRBBHF0BGR0JAFhZHGREVQhkVFUMQQRcXRBFFQBhCQUAREEIXERsTRUIaQkNCQRcSQhpCRRdCFhIURhVEEkFBERMUFRURRhEbEBcUQBdBHUISExcU");
    public static final String APPKEY = StringFog.decrypt("RUUUQQ==").toLowerCase();

    private static void appendHex(StringBuffer stringBuffer, byte b) {
        stringBuffer.append(StringFog.decrypt("ERIWEBUWEhYZGmVhYmdhZw==").charAt((b >> 4) & 15));
        stringBuffer.append(StringFog.decrypt("ERIWEBUWEhYZGmVhYmdhZw==").charAt(b & 15));
    }

    private static byte[] createIV() {
        Random random = new Random();
        byte[] bArr = new byte[16];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                return bArr;
            }
            bArr[i2] = (byte) (random.nextInt(256) - 128);
            i = i2 + 1;
        }
    }

    public static String decrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 2);
        String lowerCase = ByteTransformUtils.byte2HexStr(decode, 0, decode.length).toLowerCase();
        String str2 = APPKEY;
        String str3 = lowerCase;
        if (lowerCase.startsWith(str2)) {
            str3 = lowerCase.substring(str2.length());
        }
        int parseInt = Integer.parseInt(str2.substring(0, 1), 16);
        int i = parseInt + 32;
        String substring = str3.substring(parseInt, i);
        return new String(AesCryptor.aesDecryptByteArry(toByte(str3.substring(0, parseInt) + str3.substring(i)), DEC_KEY, ByteTransformUtils.hexStr2Bytes(substring)));
    }

    public static String decrypt2(String str) {
        String decrypt = StringFog.decrypt("GXVpSm1CFk9SVUplExZVRQ==");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(decrypt.getBytes(StandardCharsets.UTF_8), 0, decrypt.getBytes(StandardCharsets.UTF_8).length, StringFog.decrypt("YGZ3"));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{57, 48, 115, 100, 97, 102, 106, 107, 100, 107, 106, 100, 107, 106, 101, 107});
            Cipher cipher = Cipher.getInstance(StringFog.decrypt("YGZ3DGJhZw5xaGdwFHNFRUVKSkQ="));
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str, 2)), StringFog.decrypt("VFdCDhk="));
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str) {
        byte[] createIV = createIV();
        String hex = toHex(AesCryptor.aesEncryptByteArry(str.getBytes(StringFog.decrypt("VFdCDhk=")), ENC_KEY, createIV));
        String hex2 = toHex(createIV);
        String str2 = APPKEY;
        int parseInt = Integer.parseInt(str2.substring(0, 1), 16);
        return Base64.encodeToString(ByteTransformUtils.hexStr2Bytes(str2 + hex.substring(0, parseInt) + hex2 + hex.substring(parseInt)), 2);
    }

    public static String encrypt2(String str) {
        String decrypt = StringFog.decrypt("GXVpSm1CFk9SVUplExZVRQ==");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(decrypt.getBytes(StandardCharsets.UTF_8), 0, decrypt.getBytes(StandardCharsets.UTF_8).length, StringFog.decrypt("YGZ3"));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{57, 48, 115, 100, 97, 102, 106, 107, 100, 107, 106, 100, 107, 106, 101, 107});
            Cipher cipher = Cipher.getInstance(StringFog.decrypt("YGZ3DGJhZw5xaGdwFHNFRUVKSkQ="));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 2);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] toByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
            i = i2 + 1;
        }
    }

    public static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            appendHex(stringBuffer, bArr[i2]);
            i = i2 + 1;
        }
    }
}
