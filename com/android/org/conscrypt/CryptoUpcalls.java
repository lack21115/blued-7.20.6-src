package com.android.org.conscrypt;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/CryptoUpcalls.class */
public final class CryptoUpcalls {
    private static final String RSA_CRYPTO_ALGORITHM = "RSA/ECB/PKCS1Padding";

    private CryptoUpcalls() {
    }

    public static Provider getExternalProvider(String str) {
        Provider provider;
        Provider[] providers = Security.getProviders(str);
        int length = providers.length;
        int i = 0;
        while (true) {
            int i2 = i;
            provider = null;
            if (i2 >= length) {
                break;
            }
            provider = providers[i2];
            if (!provider.getClass().getClassLoader().equals(CryptoUpcalls.class.getClassLoader())) {
                break;
            }
            i = i2 + 1;
        }
        if (provider == null) {
            System.err.println("Could not find external provider for algorithm: " + str);
        }
        return provider;
    }

    public static byte[] rawCipherWithPrivateKey(PrivateKey privateKey, boolean z, byte[] bArr) {
        if (!(privateKey instanceof RSAPrivateKey)) {
            System.err.println("Unexpected key type: " + privateKey.toString());
            return null;
        }
        Provider externalProvider = getExternalProvider("Cipher.RSA/ECB/PKCS1Padding");
        if (externalProvider != null) {
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance(RSA_CRYPTO_ALGORITHM, externalProvider);
            } catch (NoSuchAlgorithmException e) {
            } catch (NoSuchPaddingException e2) {
            }
            if (cipher == null) {
                System.err.println("Unsupported private key algorithm: " + privateKey.getAlgorithm());
            }
            try {
                cipher.init(z ? 1 : 2, privateKey);
                return cipher.doFinal(bArr);
            } catch (Exception e3) {
                System.err.println("Exception while ciphering message with " + privateKey.getAlgorithm() + " private key:");
                e3.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] rawSignDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr) {
        String str;
        Signature signature;
        if (privateKey instanceof RSAPrivateKey) {
            str = "NONEwithRSA";
        } else if (privateKey instanceof DSAPrivateKey) {
            str = "NONEwithDSA";
        } else if (!(privateKey instanceof ECPrivateKey)) {
            throw new RuntimeException("Unexpected key type: " + privateKey.toString());
        } else {
            str = "NONEwithECDSA";
        }
        Provider externalProvider = getExternalProvider("Signature." + str);
        if (externalProvider == null) {
            return null;
        }
        try {
            signature = Signature.getInstance(str, externalProvider);
        } catch (NoSuchAlgorithmException e) {
            signature = null;
        }
        if (signature == null) {
            System.err.println("Unsupported private key algorithm: " + privateKey.getAlgorithm());
            return null;
        }
        try {
            signature.initSign(privateKey);
            signature.update(bArr);
            return signature.sign();
        } catch (Exception e2) {
            System.err.println("Exception while signing message with " + privateKey.getAlgorithm() + " private key:");
            e2.printStackTrace();
            return null;
        }
    }
}
