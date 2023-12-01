package java.security;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Vector;
import libcore.util.Objects;

@Deprecated
/* loaded from: source-2895416-dex2jar.jar:java/security/Identity.class */
public abstract class Identity implements Principal, Serializable {
    private static final long serialVersionUID = 3609922007826600659L;
    private Vector<Certificate> certificates;
    private String info;
    private String name;
    private PublicKey publicKey;
    private IdentityScope scope;

    /* JADX INFO: Access modifiers changed from: protected */
    public Identity() {
        this.info = "no additional info";
    }

    public Identity(String str) {
        this.info = "no additional info";
        this.name = str;
    }

    public Identity(String str, IdentityScope identityScope) throws KeyManagementException {
        this(str);
        if (identityScope != null) {
            identityScope.addIdentity(this);
            this.scope = identityScope;
        }
    }

    private static boolean checkKeysEqual(PublicKey publicKey, PublicKey publicKey2) {
        boolean z = true;
        String format = publicKey.getFormat();
        if (publicKey2 != null) {
            String format2 = publicKey2.getFormat();
            boolean z2 = format2 != null;
            if (format == null) {
                z = false;
            }
            if (z ^ z2) {
                return false;
            }
            if (format == null || format.equals(format2)) {
                return Arrays.equals(publicKey.getEncoded(), publicKey2.getEncoded());
            }
            return false;
        }
        return false;
    }

    public void addCertificate(Certificate certificate) throws KeyManagementException {
        PublicKey publicKey = certificate.getPublicKey();
        if (this.publicKey == null) {
            this.publicKey = publicKey;
        } else if (!checkKeysEqual(this.publicKey, publicKey)) {
            throw new KeyManagementException("Cert's public key does not match Identity's public key");
        }
        if (this.certificates == null) {
            this.certificates = new Vector<>();
        }
        this.certificates.add(certificate);
    }

    public Certificate[] certificates() {
        if (this.certificates == null) {
            return new Certificate[0];
        }
        Certificate[] certificateArr = new Certificate[this.certificates.size()];
        this.certificates.copyInto(certificateArr);
        return certificateArr;
    }

    @Override // java.security.Principal
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Identity) {
            Identity identity = (Identity) obj;
            if (Objects.equal(this.name, identity.name) && Objects.equal(this.scope, identity.scope)) {
                return true;
            }
            return identityEquals(identity);
        }
        return false;
    }

    public String getInfo() {
        return this.info;
    }

    @Override // java.security.Principal
    public final String getName() {
        return this.name;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public final IdentityScope getScope() {
        return this.scope;
    }

    @Override // java.security.Principal
    public int hashCode() {
        int i = 0;
        if (this.name != null) {
            i = 0 + this.name.hashCode();
        }
        int i2 = i;
        if (this.scope != null) {
            i2 = i + this.scope.hashCode();
        }
        return i2;
    }

    protected boolean identityEquals(Identity identity) {
        if (this.name.equals(identity.name)) {
            return this.publicKey == null ? identity.publicKey == null : checkKeysEqual(this.publicKey, identity.publicKey);
        }
        return false;
    }

    public void removeCertificate(Certificate certificate) throws KeyManagementException {
        if (this.certificates != null) {
            if (!this.certificates.contains(certificate)) {
                throw new KeyManagementException("Certificate not found");
            }
            this.certificates.removeElement(certificate);
        }
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setPublicKey(PublicKey publicKey) throws KeyManagementException {
        Identity identity;
        if (this.scope != null && publicKey != null && (identity = this.scope.getIdentity(publicKey)) != null && identity != this) {
            throw new KeyManagementException("key already used in scope");
        }
        this.publicKey = publicKey;
        this.certificates = null;
    }

    @Override // java.security.Principal
    public String toString() {
        String str = this.name == null ? "" : this.name;
        String str2 = str;
        if (this.scope != null) {
            str2 = str + " [" + this.scope.getName() + "]";
        }
        return str2;
    }

    public String toString(boolean z) {
        String identity = toString();
        String str = identity;
        if (z) {
            str = identity + " " + this.info;
        }
        return str;
    }
}
