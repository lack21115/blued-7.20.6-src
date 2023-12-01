package java.security.cert;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/LDAPCertStoreParameters.class */
public class LDAPCertStoreParameters implements CertStoreParameters {
    private static final int DEFAULT_LDAP_PORT = 389;
    private static final String DEFAULT_LDAP_SERVER_NAME = "localhost";
    private final int port;
    private final String serverName;

    public LDAPCertStoreParameters() {
        this.serverName = DEFAULT_LDAP_SERVER_NAME;
        this.port = DEFAULT_LDAP_PORT;
    }

    public LDAPCertStoreParameters(String str) {
        if (str == null) {
            throw new NullPointerException("serverName == null");
        }
        this.port = DEFAULT_LDAP_PORT;
        this.serverName = str;
    }

    public LDAPCertStoreParameters(String str, int i) {
        if (str == null) {
            throw new NullPointerException("serverName == null");
        }
        this.port = i;
        this.serverName = str;
    }

    @Override // java.security.cert.CertStoreParameters
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public int getPort() {
        return this.port;
    }

    public String getServerName() {
        return this.serverName;
    }

    public String toString() {
        return "LDAPCertStoreParameters: [\n serverName: " + getServerName() + "\n port: " + getPort() + "\n]";
    }
}
