package java.security;

import java.io.Serializable;
import java.security.cert.CertPath;
import java.util.Date;

/* loaded from: source-2895416-dex2jar.jar:java/security/Timestamp.class */
public final class Timestamp implements Serializable {
    private static final long serialVersionUID = -5502683707821851294L;
    private transient int hash;
    private CertPath signerCertPath;
    private Date timestamp;

    public Timestamp(Date date, CertPath certPath) {
        if (date == null) {
            throw new NullPointerException("timestamp == null");
        }
        if (certPath == null) {
            throw new NullPointerException("signerCertPath == null");
        }
        this.timestamp = new Date(date.getTime());
        this.signerCertPath = certPath;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Timestamp) {
            Timestamp timestamp = (Timestamp) obj;
            return this.timestamp.equals(timestamp.timestamp) && this.signerCertPath.equals(timestamp.signerCertPath);
        }
        return false;
    }

    public CertPath getSignerCertPath() {
        return this.signerCertPath;
    }

    public Date getTimestamp() {
        return (Date) this.timestamp.clone();
    }

    public int hashCode() {
        if (this.hash == 0) {
            this.hash = this.timestamp.hashCode() ^ this.signerCertPath.hashCode();
        }
        return this.hash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Timestamp [").append(this.timestamp).append(" certPath=");
        sb.append(this.signerCertPath.getCertificates().get(0)).append("]");
        return sb.toString();
    }
}
