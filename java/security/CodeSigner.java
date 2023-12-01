package java.security;

import java.io.Serializable;
import java.security.cert.CertPath;

/* loaded from: source-2895416-dex2jar.jar:java/security/CodeSigner.class */
public final class CodeSigner implements Serializable {
    private static final long serialVersionUID = 6819288105193937581L;
    private transient int hash;
    private CertPath signerCertPath;
    private Timestamp timestamp;

    public CodeSigner(CertPath certPath, Timestamp timestamp) {
        if (certPath == null) {
            throw new NullPointerException("signerCertPath == null");
        }
        this.signerCertPath = certPath;
        this.timestamp = timestamp;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CodeSigner) {
            CodeSigner codeSigner = (CodeSigner) obj;
            if (this.signerCertPath.equals(codeSigner.signerCertPath)) {
                return this.timestamp == null ? codeSigner.timestamp == null : this.timestamp.equals(codeSigner.timestamp);
            }
            return false;
        }
        return false;
    }

    public CertPath getSignerCertPath() {
        return this.signerCertPath;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        if (this.hash == 0) {
            this.hash = (this.timestamp == null ? 0 : this.timestamp.hashCode()) ^ this.signerCertPath.hashCode();
        }
        return this.hash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("CodeSigner [").append(this.signerCertPath.getCertificates().get(0));
        if (this.timestamp != null) {
            sb.append("; ").append(this.timestamp);
        }
        sb.append("]");
        return sb.toString();
    }
}
