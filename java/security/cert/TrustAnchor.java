package java.security.cert;

import java.io.IOException;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.utils.Array;
import org.apache.harmony.security.x509.NameConstraints;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/TrustAnchor.class */
public class TrustAnchor {
    private final String caName;
    private final X500Principal caPrincipal;
    private final PublicKey caPublicKey;
    private final byte[] nameConstraints;
    private final X509Certificate trustedCert;

    public TrustAnchor(String str, PublicKey publicKey, byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("caName == null");
        }
        this.caName = str;
        if (publicKey == null) {
            throw new NullPointerException("caPublicKey == null");
        }
        this.caPublicKey = publicKey;
        if (bArr != null) {
            this.nameConstraints = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.nameConstraints, 0, this.nameConstraints.length);
            processNameConstraints();
        } else {
            this.nameConstraints = null;
        }
        this.trustedCert = null;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("caName.isEmpty()");
        }
        this.caPrincipal = new X500Principal(this.caName);
    }

    public TrustAnchor(X509Certificate x509Certificate, byte[] bArr) {
        if (x509Certificate == null) {
            throw new NullPointerException("trustedCert == null");
        }
        this.trustedCert = x509Certificate;
        if (bArr != null) {
            this.nameConstraints = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.nameConstraints, 0, this.nameConstraints.length);
            processNameConstraints();
        } else {
            this.nameConstraints = null;
        }
        this.caName = null;
        this.caPrincipal = null;
        this.caPublicKey = null;
    }

    public TrustAnchor(X500Principal x500Principal, PublicKey publicKey, byte[] bArr) {
        if (x500Principal == null) {
            throw new NullPointerException("caPrincipal == null");
        }
        this.caPrincipal = x500Principal;
        if (publicKey == null) {
            throw new NullPointerException("caPublicKey == null");
        }
        this.caPublicKey = publicKey;
        if (bArr != null) {
            this.nameConstraints = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.nameConstraints, 0, this.nameConstraints.length);
            processNameConstraints();
        } else {
            this.nameConstraints = null;
        }
        this.trustedCert = null;
        this.caName = x500Principal.getName();
    }

    private void processNameConstraints() {
        try {
            NameConstraints.ASN1.decode(this.nameConstraints);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public final X500Principal getCA() {
        return this.caPrincipal;
    }

    public final String getCAName() {
        return this.caName;
    }

    public final PublicKey getCAPublicKey() {
        return this.caPublicKey;
    }

    public final byte[] getNameConstraints() {
        if (this.nameConstraints == null) {
            return null;
        }
        byte[] bArr = new byte[this.nameConstraints.length];
        System.arraycopy(this.nameConstraints, 0, bArr, 0, this.nameConstraints.length);
        return bArr;
    }

    public final X509Certificate getTrustedCert() {
        return this.trustedCert;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrustAnchor: [\n");
        if (this.trustedCert != null) {
            sb.append("Trusted CA certificate: ");
            sb.append(this.trustedCert);
            sb.append("\n");
        }
        if (this.caPrincipal != null) {
            sb.append("Trusted CA Name: ");
            sb.append(this.caPrincipal);
            sb.append("\n");
        }
        if (this.caPublicKey != null) {
            sb.append("Trusted CA Public Key: ");
            sb.append(this.caPublicKey);
            sb.append("\n");
        }
        if (this.nameConstraints != null) {
            sb.append("Name Constraints:\n");
            sb.append(Array.toString(this.nameConstraints, "    "));
        }
        sb.append("\n]");
        return sb.toString();
    }
}
