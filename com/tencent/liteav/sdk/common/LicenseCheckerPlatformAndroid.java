package com.tencent.liteav.sdk.common;

import android.util.Base64;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@JNINamespace("liteav::license")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdk/common/LicenseCheckerPlatformAndroid.class */
public class LicenseCheckerPlatformAndroid {
    private static final String ALGORITHM_AES = "AES";
    private static final String ALGORITHM_AES_CBC_PKCS5PADDING = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM_RSA = "RSA";
    private static final String ALGORITHM_SHA256WITH_RSA = "SHA256WithRSA";
    private static final String TAG = "LicenseCheckerPlatformAndroid";

    public static String decryptLicense(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0 || bArr3 == null || bArr3.length == 0) {
            Log.w(TAG, "decryptLicense: invalid parameter.", new Object[0]);
            return "";
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(bArr, 0)));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getPackageFile(String str) {
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            try {
                InputStream open = ContextUtils.getApplicationContext().getAssets().open(str);
                byte[] bArr = new byte[open.available()];
                if (open.read(bArr) <= 0) {
                    if (open != null) {
                        try {
                            open.close();
                            return "";
                        } catch (IOException e) {
                            return "";
                        }
                    }
                    return "";
                }
                open.close();
                inputStream2 = open;
                inputStream = open;
                String str2 = new String(bArr);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e2) {
                        return str2;
                    }
                }
                return str2;
            } catch (IOException e3) {
                Log.w(TAG, "read asset file failed.", e3);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return "";
                    } catch (IOException e4) {
                        return "";
                    }
                }
                return "";
            }
        } catch (Throwable th) {
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    public static boolean verifyLicense(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0 || bArr3 == null || bArr3.length == 0) {
            Log.w(TAG, "verifyLicense: invalid parameter.", new Object[0]);
            return false;
        }
        try {
            PublicKey generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(bArr3, 0)));
            Signature signature = Signature.getInstance(ALGORITHM_SHA256WITH_RSA);
            signature.initVerify(generatePublic);
            signature.update(Base64.decode(bArr, 0));
            return signature.verify(Base64.decode(bArr2, 0));
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e) {
            e.printStackTrace();
            return false;
        }
    }
}
