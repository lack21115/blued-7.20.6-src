package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/util/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9519a = "b";
    private static final int b = 5;

    public static X509Certificate a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e) {
                g.a(f9519a, "exception", e);
                return null;
            }
        }
        return null;
    }

    public static X509Certificate a(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e) {
            String str2 = f9519a;
            g.b(str2, "generateX509FromStr: CertificateException" + e.getMessage());
            return null;
        }
    }

    public static boolean a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        g.b(f9519a, "verify: subject name is error");
        return false;
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (b(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            g.b(f9519a, "verify: date not right");
            return false;
        } catch (InvalidKeyException e) {
            String str = f9519a;
            g.b(str, "verify: publickey InvalidKeyException " + e.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e2) {
            String str2 = f9519a;
            g.b(str2, "verify: publickey NoSuchAlgorithmException " + e2.getMessage());
            return false;
        } catch (NoSuchProviderException e3) {
            String str3 = f9519a;
            g.b(str3, "verify: publickey NoSuchProviderException " + e3.getMessage());
            return false;
        } catch (SignatureException e4) {
            String str4 = f9519a;
            g.b(str4, "verify: publickey SignatureException " + e4.getMessage());
            return false;
        } catch (CertificateException e5) {
            String str5 = f9519a;
            g.b(str5, "verify: publickey CertificateException " + e5.getMessage());
            return false;
        } catch (Exception e6) {
            String str6 = f9519a;
            g.b(str6, "verify: Exception " + e6.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i = 0;
        while (i < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (!issuerDN.equals(principal)) {
                    g.b(f9519a, "verify: principalIssuer not match");
                    return false;
                }
                x509CertificateArr[i].verify(x509CertificateArr[i - 1].getPublicKey());
            }
            i++;
            principal = subjectDN;
        }
        return a(x509Certificate, x509CertificateArr[0]) && b(x509CertificateArr) && a(x509Certificate) && a(x509CertificateArr);
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return !a(x509Certificate, x509CertificateArr) && !a(x509CertificateArr, x509crl) && a(x509CertificateArr[x509CertificateArr.length - 1], str) && b(x509CertificateArr);
    }

    public static boolean a(X509Certificate[] x509CertificateArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= x509CertificateArr.length - 1) {
                return true;
            }
            if (!a(x509CertificateArr[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean a(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        int length = x509CertificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            arrayList.add(x509CertificateArr[i2].getSerialNumber());
            i = i2 + 1;
        }
        if (x509crl != null) {
            try {
                Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
                if (revokedCertificates == null || revokedCertificates.isEmpty()) {
                    return true;
                }
                Iterator<? extends X509CRLEntry> it = revokedCertificates.iterator();
                do {
                    if (!it.hasNext()) {
                        return true;
                    }
                } while (!arrayList.contains(it.next().getSerialNumber()));
                g.b(f9519a, "verify: certificate revoked");
                return false;
            } catch (Exception e) {
                String str = f9519a;
                g.b(str, "verify: revoked verify exception : " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean b(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        int length = x509CertificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            try {
                x509CertificateArr[i2].checkValidity(date);
                i = i2 + 1;
            } catch (CertificateExpiredException e) {
                e = e;
                String str = f9519a;
                g.b(str, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (CertificateNotYetValidException e2) {
                e = e2;
                String str2 = f9519a;
                g.b(str2, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (Exception e3) {
                String str3 = f9519a;
                g.b(str3, "verifyCertificateDate : exception : " + e3.getMessage());
                return false;
            }
        }
    }
}
