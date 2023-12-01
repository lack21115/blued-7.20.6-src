package com.android.org.conscrypt;

import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/ChainStrengthAnalyzer.class */
public final class ChainStrengthAnalyzer {
    private static final int MIN_MODULUS = 1024;
    private static final String[] OID_BLACKLIST = {"1.2.840.113549.1.1.4"};

    public static final void check(X509Certificate[] x509CertificateArr) throws CertificateException {
        int length = x509CertificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            checkCert(x509CertificateArr[i2]);
            i = i2 + 1;
        }
    }

    private static final void checkCert(X509Certificate x509Certificate) throws CertificateException {
        checkModulusLength(x509Certificate);
        checkNotMD5(x509Certificate);
    }

    private static final void checkModulusLength(X509Certificate x509Certificate) throws CertificateException {
        PublicKey publicKey = x509Certificate.getPublicKey();
        if ((publicKey instanceof RSAPublicKey) && ((RSAPublicKey) publicKey).getModulus().bitLength() < 1024) {
            throw new CertificateException("Modulus is < 1024 bits");
        }
    }

    private static final void checkNotMD5(X509Certificate x509Certificate) throws CertificateException {
        String sigAlgOID = x509Certificate.getSigAlgOID();
        String[] strArr = OID_BLACKLIST;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (sigAlgOID.equals(strArr[i2])) {
                throw new CertificateException("Signature uses an insecure hash function");
            }
            i = i2 + 1;
        }
    }
}
