package com.amap.api.col.p0003sl;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.amap.api.col.3sl.ii  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ii.class */
public final class ii {
    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(ib.c("EUlNB")).generatePublic(new X509EncodedKeySpec(ie.a(str)));
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e3) {
            throw new Exception("公钥非法");
        }
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(ib.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            return null;
        }
    }
}
