package java.security;

@Deprecated
/* loaded from: source-2895416-dex2jar.jar:java/security/Signer.class */
public abstract class Signer extends Identity {
    private static final long serialVersionUID = -1763464102261361480L;
    private PrivateKey privateKey;

    protected Signer() {
    }

    public Signer(String str) {
        super(str);
    }

    public Signer(String str, IdentityScope identityScope) throws KeyManagementException {
        super(str, identityScope);
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public final void setKeyPair(KeyPair keyPair) throws InvalidParameterException, KeyException {
        if (keyPair == null) {
            throw new NullPointerException("pair == null");
        }
        if (keyPair.getPrivate() == null || keyPair.getPublic() == null) {
            throw new InvalidParameterException();
        }
        setPublicKey(keyPair.getPublic());
        this.privateKey = keyPair.getPrivate();
    }

    @Override // java.security.Identity, java.security.Principal
    public String toString() {
        String str = "[Signer]" + getName();
        String str2 = str;
        if (getScope() != null) {
            str2 = str + '[' + getScope().toString() + ']';
        }
        return str2;
    }
}
