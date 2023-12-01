package com.zx.a.I8b7;

import java.math.BigInteger;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/b0.class */
public class b0 implements X509TrustManager {
    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length != 2) {
            throw new CertificateException("ca chain is illegal");
        }
        X509Certificate f = a0.f();
        if (f == null) {
            throw new CertificateException("getCurEnvCA is null");
        }
        if (!new BigInteger(1, f.getPublicKey().getEncoded()).toString(16).equals(new BigInteger(1, x509CertificateArr[1].getPublicKey().getEncoded()).toString(16))) {
            throw new CertificateException("Trust anchor for certification illegal code: 10003");
        }
        try {
            x509CertificateArr[0].verify(f.getPublicKey());
            try {
                x509CertificateArr[0].checkValidity();
            } catch (Exception e) {
                throw new CertificateException("Trust anchor for certification illegal code: 10005");
            }
        } catch (Exception e2) {
            throw new CertificateException("Trust anchor for certification illegal code: 10004");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
