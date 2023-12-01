package com.sdk.tencent.p;

import com.sdk.tencent.f.c;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/p/b.class */
public class b extends com.sdk.tencent.i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f14382a = 0;

    static {
        boolean z = c.b;
    }

    public static String a(String str, String str2) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) a.a(str2);
        if (com.sdk.tencent.n.b.a(str).booleanValue()) {
            throw new Exception("rsaAes key is null");
        }
        byte[] a2 = com.sdk.tencent.q.c.a(str);
        if (rSAPublicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, rSAPublicKey);
                return new String(cipher.doFinal(a2), Charset.defaultCharset()).trim();
            } catch (InvalidKeyException e) {
                throw new InvalidKeyException("解密公钥非法,请检查");
            } catch (NoSuchAlgorithmException e2) {
                throw new NoSuchAlgorithmException("无此解密算法");
            } catch (BadPaddingException e3) {
                throw new BadPaddingException("密文数据已损坏");
            } catch (IllegalBlockSizeException e4) {
                throw new IllegalBlockSizeException("密文长度非法");
            } catch (NoSuchPaddingException e5) {
                throw new NoSuchPaddingException("解密出错！不支持该填充机制");
            }
        }
        throw new Exception("解密公钥为空, 请设置");
    }
}
