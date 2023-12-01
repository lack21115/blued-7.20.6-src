package java.security.cert;

import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertPath.class */
public abstract class CertPath implements Serializable {
    private static final long serialVersionUID = 6068470306649138683L;
    private final String type;

    /* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertPath$CertPathRep.class */
    protected static class CertPathRep implements Serializable {
        private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("type", String.class), new ObjectStreamField("data", byte[].class, true)};
        private static final long serialVersionUID = 3015633072427920915L;
        private final byte[] data;
        private final String type;

        protected CertPathRep(String str, byte[] bArr) {
            this.type = str;
            this.data = bArr;
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                return CertificateFactory.getInstance(this.type).generateCertPath(new ByteArrayInputStream(this.data));
            } catch (Throwable th) {
                throw new NotSerializableException("Could not resolve cert path: " + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CertPath(String str) {
        this.type = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CertPath) {
            CertPath certPath = (CertPath) obj;
            return getType().equals(certPath.getType()) && getCertificates().equals(certPath.getCertificates());
        }
        return false;
    }

    public abstract List<? extends Certificate> getCertificates();

    public abstract byte[] getEncoded() throws CertificateEncodingException;

    public abstract byte[] getEncoded(String str) throws CertificateEncodingException;

    public abstract Iterator<String> getEncodings();

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return (getType().hashCode() * 31) + getCertificates().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getType());
        sb.append(" Cert Path, len=");
        sb.append(getCertificates().size());
        sb.append(": [\n");
        int i = 1;
        for (Certificate certificate : getCertificates()) {
            sb.append("---------------certificate ");
            sb.append(i);
            sb.append("---------------\n");
            sb.append(certificate.toString());
            i++;
        }
        sb.append("\n]");
        return sb.toString();
    }

    protected Object writeReplace() throws ObjectStreamException {
        try {
            return new CertPathRep(getType(), getEncoded());
        } catch (CertificateEncodingException e) {
            throw new NotSerializableException("Could not create serialization object: " + e);
        }
    }
}
