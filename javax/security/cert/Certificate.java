package javax.security.cert;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:javax/security/cert/Certificate.class */
public abstract class Certificate {
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == this) {
            z = true;
        } else if (obj instanceof Certificate) {
            try {
                return Arrays.equals(getEncoded(), ((Certificate) obj).getEncoded());
            } catch (CertificateEncodingException e) {
                return false;
            }
        }
        return z;
    }

    public abstract byte[] getEncoded() throws CertificateEncodingException;

    public abstract PublicKey getPublicKey();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    public int hashCode() {
        byte b;
        byte b2 = 0;
        byte b3 = 0;
        try {
            byte[] encoded = getEncoded();
            int i = 0;
            while (true) {
                int i2 = i;
                b2 = b3;
                b = b3;
                if (i2 >= encoded.length) {
                    break;
                }
                b3 += encoded[i2];
                i = i2 + 1;
            }
        } catch (CertificateEncodingException e) {
            b = b2;
        }
        return b;
    }

    public abstract String toString();

    public abstract void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public abstract void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;
}
