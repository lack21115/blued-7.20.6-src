package java.security.cert;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/X509CRL.class */
public abstract class X509CRL extends CRL implements X509Extension {
    /* JADX INFO: Access modifiers changed from: protected */
    public X509CRL() {
        super("X.509");
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == this) {
            z = true;
        } else if (obj instanceof X509CRL) {
            try {
                return Arrays.equals(getEncoded(), ((X509CRL) obj).getEncoded());
            } catch (CRLException e) {
                return false;
            }
        }
        return z;
    }

    public abstract byte[] getEncoded() throws CRLException;

    public abstract Principal getIssuerDN();

    public X500Principal getIssuerX500Principal() {
        try {
            return ((X509CRL) CertificateFactory.getInstance("X.509").generateCRL(new ByteArrayInputStream(getEncoded()))).getIssuerX500Principal();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get X500Principal issuer", e);
        }
    }

    public abstract Date getNextUpdate();

    public abstract X509CRLEntry getRevokedCertificate(BigInteger bigInteger);

    public X509CRLEntry getRevokedCertificate(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            throw new NullPointerException("certificate == null");
        }
        return getRevokedCertificate(x509Certificate.getSerialNumber());
    }

    public abstract Set<? extends X509CRLEntry> getRevokedCertificates();

    public abstract String getSigAlgName();

    public abstract String getSigAlgOID();

    public abstract byte[] getSigAlgParams();

    public abstract byte[] getSignature();

    public abstract byte[] getTBSCertList() throws CRLException;

    public abstract Date getThisUpdate();

    public abstract int getVersion();

    public int hashCode() {
        int i;
        int i2 = 0;
        try {
            byte[] encoded = getEncoded();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= encoded.length) {
                    break;
                }
                i2 += encoded[i4] & 255;
                i3 = i4 + 1;
            }
        } catch (CRLException e) {
            i = 0;
        }
        return i;
    }

    public abstract void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public abstract void verify(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;
}
