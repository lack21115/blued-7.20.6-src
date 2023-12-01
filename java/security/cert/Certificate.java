package java.security.cert;

import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/Certificate.class */
public abstract class Certificate implements Serializable {
    private static final long serialVersionUID = -3585440601605666277L;
    private final String type;

    /* loaded from: source-2895416-dex2jar.jar:java/security/cert/Certificate$CertificateRep.class */
    protected static class CertificateRep implements Serializable {
        private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("type", String.class), new ObjectStreamField("data", byte[].class, true)};
        private static final long serialVersionUID = -8563758940495660020L;
        private final byte[] data;
        private final String type;

        protected CertificateRep(String str, byte[] bArr) {
            this.type = str;
            this.data = bArr;
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                return CertificateFactory.getInstance(this.type).generateCertificate(new ByteArrayInputStream(this.data));
            } catch (Throwable th) {
                throw new NotSerializableException("Could not resolve certificate: " + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Certificate(String str) {
        this.type = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Certificate) {
            try {
                return Arrays.equals(getEncoded(), ((Certificate) obj).getEncoded());
            } catch (CertificateEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public abstract byte[] getEncoded() throws CertificateEncodingException;

    public abstract PublicKey getPublicKey();

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        try {
            byte[] encoded = getEncoded();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= encoded.length) {
                    return i;
                }
                i += encoded[i3] * i3;
                i2 = i3 + 1;
            }
        } catch (CertificateEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract String toString();

    public abstract void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public abstract void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    protected Object writeReplace() throws ObjectStreamException {
        try {
            return new CertificateRep(getType(), getEncoded());
        } catch (CertificateEncodingException e) {
            throw new NotSerializableException("Could not create serialization object: " + e);
        }
    }
}
