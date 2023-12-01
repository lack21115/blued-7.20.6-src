package java.security.cert;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CRL.class */
public abstract class CRL {
    private final String type;

    /* JADX INFO: Access modifiers changed from: protected */
    public CRL(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public abstract boolean isRevoked(Certificate certificate);

    public abstract String toString();
}
