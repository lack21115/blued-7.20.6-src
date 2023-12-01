package org.conscrypt;

import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/ChainStrengthAnalyzer.class */
public final class ChainStrengthAnalyzer {
    private static final int MIN_DSA_P_LEN_BITS = 1024;
    private static final int MIN_DSA_Q_LEN_BITS = 160;
    private static final int MIN_EC_FIELD_SIZE_BITS = 160;
    private static final int MIN_RSA_MODULUS_LEN_BITS = 1024;
    private static final String[] SIGNATURE_ALGORITHM_OID_BLACKLIST = {"1.2.840.113549.1.1.2", "1.2.840.113549.1.1.3", "1.2.840.113549.1.1.4", "1.2.840.113549.1.1.5", "1.2.840.10040.4.3", "1.2.840.10045.4.1"};

    public static final void check(List<X509Certificate> list) throws CertificateException {
        for (X509Certificate x509Certificate : list) {
            try {
                checkCert(x509Certificate);
            } catch (CertificateException e) {
                throw new CertificateException("Unacceptable certificate: " + x509Certificate.getSubjectX500Principal(), e);
            }
        }
    }

    public static final void check(X509Certificate[] x509CertificateArr) throws CertificateException {
        int length = x509CertificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            X509Certificate x509Certificate = x509CertificateArr[i2];
            try {
                checkCert(x509Certificate);
                i = i2 + 1;
            } catch (CertificateException e) {
                throw new CertificateException("Unacceptable certificate: " + x509Certificate.getSubjectX500Principal(), e);
            }
        }
    }

    public static final void checkCert(X509Certificate x509Certificate) throws CertificateException {
        checkKeyLength(x509Certificate);
        checkSignatureAlgorithm(x509Certificate);
    }

    private static void checkKeyLength(X509Certificate x509Certificate) throws CertificateException {
        PublicKey publicKey = x509Certificate.getPublicKey();
        if (publicKey instanceof RSAPublicKey) {
            if (((RSAPublicKey) publicKey).getModulus().bitLength() < 1024) {
                throw new CertificateException("RSA modulus is < 1024 bits");
            }
        } else if (publicKey instanceof ECPublicKey) {
            if (((ECPublicKey) publicKey).getParams().getCurve().getField().getFieldSize() < 160) {
                throw new CertificateException("EC key field size is < 160 bits");
            }
        } else if (!(publicKey instanceof DSAPublicKey)) {
            throw new CertificateException("Rejecting unknown key class " + publicKey.getClass().getName());
        } else {
            DSAPublicKey dSAPublicKey = (DSAPublicKey) publicKey;
            int bitLength = dSAPublicKey.getParams().getP().bitLength();
            int bitLength2 = dSAPublicKey.getParams().getQ().bitLength();
            if (bitLength < 1024 || bitLength2 < 160) {
                throw new CertificateException("DSA key length is < (1024, 160) bits");
            }
        }
    }

    private static void checkSignatureAlgorithm(X509Certificate x509Certificate) throws CertificateException {
        String sigAlgOID = x509Certificate.getSigAlgOID();
        String[] strArr = SIGNATURE_ALGORITHM_OID_BLACKLIST;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (sigAlgOID.equals(strArr[i2])) {
                throw new CertificateException("Signature uses an insecure hash function: " + sigAlgOID);
            }
            i = i2 + 1;
        }
    }
}
