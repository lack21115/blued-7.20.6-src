package javax.security.cert;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.util.Date;

/* loaded from: source-2895416-dex2jar.jar:javax/security/cert/X509Certificate.class */
public abstract class X509Certificate extends Certificate {
    private static Constructor constructor;

    static {
        try {
            Class.forName(Security.getProperty("cert.provider.x509v1"));
            throw new VerifyError("bad dex opcode");
        } catch (Throwable th) {
        }
    }

    public static final X509Certificate getInstance(InputStream inputStream) throws CertificateException {
        if (inputStream == null) {
            throw new CertificateException("inStream == null");
        }
        if (constructor != null) {
            try {
                return (X509Certificate) constructor.newInstance(inputStream);
            } catch (Throwable th) {
                throw new CertificateException(th.getMessage());
            }
        }
        try {
            final java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
            return new X509Certificate() { // from class: javax.security.cert.X509Certificate.1
                @Override // javax.security.cert.X509Certificate
                public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
                    try {
                        java.security.cert.X509Certificate.this.checkValidity();
                    } catch (java.security.cert.CertificateExpiredException e) {
                        throw new CertificateExpiredException(e.getMessage());
                    } catch (java.security.cert.CertificateNotYetValidException e2) {
                        throw new CertificateNotYetValidException(e2.getMessage());
                    }
                }

                @Override // javax.security.cert.X509Certificate
                public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
                    try {
                        java.security.cert.X509Certificate.this.checkValidity(date);
                    } catch (java.security.cert.CertificateExpiredException e) {
                        throw new CertificateExpiredException(e.getMessage());
                    } catch (java.security.cert.CertificateNotYetValidException e2) {
                        throw new CertificateNotYetValidException(e2.getMessage());
                    }
                }

                @Override // javax.security.cert.Certificate
                public byte[] getEncoded() throws CertificateEncodingException {
                    try {
                        return java.security.cert.X509Certificate.this.getEncoded();
                    } catch (java.security.cert.CertificateEncodingException e) {
                        throw new CertificateEncodingException(e.getMessage());
                    }
                }

                @Override // javax.security.cert.X509Certificate
                public Principal getIssuerDN() {
                    return java.security.cert.X509Certificate.this.getIssuerDN();
                }

                @Override // javax.security.cert.X509Certificate
                public Date getNotAfter() {
                    return java.security.cert.X509Certificate.this.getNotAfter();
                }

                @Override // javax.security.cert.X509Certificate
                public Date getNotBefore() {
                    return java.security.cert.X509Certificate.this.getNotBefore();
                }

                @Override // javax.security.cert.Certificate
                public PublicKey getPublicKey() {
                    return java.security.cert.X509Certificate.this.getPublicKey();
                }

                @Override // javax.security.cert.X509Certificate
                public BigInteger getSerialNumber() {
                    return java.security.cert.X509Certificate.this.getSerialNumber();
                }

                @Override // javax.security.cert.X509Certificate
                public String getSigAlgName() {
                    return java.security.cert.X509Certificate.this.getSigAlgName();
                }

                @Override // javax.security.cert.X509Certificate
                public String getSigAlgOID() {
                    return java.security.cert.X509Certificate.this.getSigAlgOID();
                }

                @Override // javax.security.cert.X509Certificate
                public byte[] getSigAlgParams() {
                    return java.security.cert.X509Certificate.this.getSigAlgParams();
                }

                @Override // javax.security.cert.X509Certificate
                public Principal getSubjectDN() {
                    return java.security.cert.X509Certificate.this.getSubjectDN();
                }

                @Override // javax.security.cert.X509Certificate
                public int getVersion() {
                    return 2;
                }

                @Override // javax.security.cert.Certificate
                public String toString() {
                    return java.security.cert.X509Certificate.this.toString();
                }

                @Override // javax.security.cert.Certificate
                public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
                    try {
                        java.security.cert.X509Certificate.this.verify(publicKey);
                    } catch (java.security.cert.CertificateException e) {
                        throw new CertificateException(e.getMessage());
                    }
                }

                @Override // javax.security.cert.Certificate
                public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
                    try {
                        java.security.cert.X509Certificate.this.verify(publicKey, str);
                    } catch (java.security.cert.CertificateException e) {
                        throw new CertificateException(e.getMessage());
                    }
                }
            };
        } catch (java.security.cert.CertificateException e) {
            throw new CertificateException(e.getMessage());
        }
    }

    public static final X509Certificate getInstance(byte[] bArr) throws CertificateException {
        if (bArr == null) {
            throw new CertificateException("certData == null");
        }
        return getInstance(new ByteArrayInputStream(bArr));
    }

    public abstract void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException;

    public abstract void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException;

    public abstract Principal getIssuerDN();

    public abstract Date getNotAfter();

    public abstract Date getNotBefore();

    public abstract BigInteger getSerialNumber();

    public abstract String getSigAlgName();

    public abstract String getSigAlgOID();

    public abstract byte[] getSigAlgParams();

    public abstract Principal getSubjectDN();

    public abstract int getVersion();
}
