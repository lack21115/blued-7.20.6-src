package java.security.cert;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.x509.InvalidityDate;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertificateRevokedException.class */
public class CertificateRevokedException extends CertificateException {
    private static final long serialVersionUID = 7839996631571608627L;
    private final X500Principal authority;
    private transient Map<String, Extension> extensions;
    private final CRLReason reason;
    private final Date revocationDate;

    public CertificateRevokedException(Date date, CRLReason cRLReason, X500Principal x500Principal, Map<String, Extension> map) {
        this.revocationDate = date;
        this.reason = cRLReason;
        this.authority = x500Principal;
        this.extensions = map;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        this.extensions = new HashMap(readInt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            String str = (String) objectInputStream.readObject();
            boolean readBoolean = objectInputStream.readBoolean();
            byte[] bArr = new byte[objectInputStream.readInt()];
            objectInputStream.read(bArr);
            this.extensions.put(str, new org.apache.harmony.security.x509.Extension(str, readBoolean, bArr));
            i = i2 + 1;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.extensions.size());
        for (Extension extension : this.extensions.values()) {
            objectOutputStream.writeObject(extension.getId());
            objectOutputStream.writeBoolean(extension.isCritical());
            byte[] value = extension.getValue();
            objectOutputStream.writeInt(value.length);
            objectOutputStream.write(value);
        }
    }

    public X500Principal getAuthorityName() {
        return this.authority;
    }

    public Map<String, Extension> getExtensions() {
        return Collections.unmodifiableMap(this.extensions);
    }

    public Date getInvalidityDate() {
        Extension extension;
        if (this.extensions == null || (extension = this.extensions.get("2.5.29.24")) == null) {
            return null;
        }
        try {
            return new InvalidityDate(extension.getValue()).getDate();
        } catch (IOException e) {
            return null;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer("Certificate was revoked");
        if (this.revocationDate != null) {
            stringBuffer.append(" on ").append(this.revocationDate.toString());
        }
        if (this.reason != null) {
            stringBuffer.append(" due to ").append(this.reason);
        }
        return stringBuffer.toString();
    }

    public Date getRevocationDate() {
        return (Date) this.revocationDate.clone();
    }

    public CRLReason getRevocationReason() {
        return this.reason;
    }
}
