package com.tencent.cloud.huiyansdkface.normal.tools.secure;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/tools/secure/RSAEncrypt.class */
public class RSAEncrypt {
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    public static String byteArray2HexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString().toUpperCase();
            }
            sb.append(HEX_CHAR[(bArr[i2] & 240) >>> 4]);
            sb.append(HEX_CHAR[bArr[i2] & 15]);
            i = i2 + 1;
        }
    }

    public byte[] decrypt(byte[] bArr) throws Exception {
        if (this.privateKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.privateKey);
                return cipher.doFinal(bArr);
            } catch (InvalidKeyException e) {
                throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            } catch (BadPaddingException e3) {
                throw new RuntimeException(e3);
            } catch (IllegalBlockSizeException e4) {
                throw new RuntimeException(e4);
            } catch (NoSuchPaddingException e5) {
                throw new RuntimeException(e5);
            }
        }
        throw new Exception("解密私钥为空, 请设置");
    }

    public byte[] encrypt(byte[] bArr) throws Exception {
        if (this.publicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, this.publicKey);
                return cipher.doFinal(bArr);
            } catch (InvalidKeyException e) {
                throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            } catch (BadPaddingException e3) {
                throw new RuntimeException(e3);
            } catch (IllegalBlockSizeException e4) {
                throw new RuntimeException(e4);
            } catch (NoSuchPaddingException e5) {
                throw new RuntimeException(e5);
            }
        }
        throw new Exception("加密公钥为空, 请设置");
    }

    public void genKeyPair() {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            keyPairGenerator = null;
        }
        keyPairGenerator.initialize(2048, new SecureRandom());
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        this.privateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
        this.publicKey = (RSAPublicKey) generateKeyPair.getPublic();
    }

    public RSAPrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public RSAPublicKey getPublicKey() {
        return this.publicKey;
    }

    public void loadPrivateKey(InputStream inputStream) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    loadPrivateKey(sb.toString());
                    return;
                } else if (readLine.charAt(0) != '-') {
                    sb.append(readLine);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void loadPrivateKey(String str) throws Exception {
        try {
            this.privateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void loadPublicKey(InputStream inputStream) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    loadPublicKey(sb.toString());
                    return;
                } else if (readLine.charAt(0) != '-') {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void loadPublicKey(String str) throws Exception {
        try {
            this.publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void loadPublicKey(byte[] bArr) throws Exception {
        try {
            this.publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            throw new RuntimeException(e3);
        }
    }
}
