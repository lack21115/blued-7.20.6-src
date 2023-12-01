package javax.net.ssl;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLParameters.class */
public class SSLParameters {
    private String[] cipherSuites;
    private String endpointIdentificationAlgorithm;
    private boolean needClientAuth;
    private String[] protocols;
    private boolean wantClientAuth;

    public SSLParameters() {
    }

    public SSLParameters(String[] strArr) {
        setCipherSuites(strArr);
    }

    public SSLParameters(String[] strArr, String[] strArr2) {
        setCipherSuites(strArr);
        setProtocols(strArr2);
    }

    public String[] getCipherSuites() {
        if (this.cipherSuites == null) {
            return null;
        }
        return (String[]) this.cipherSuites.clone();
    }

    public boolean getNeedClientAuth() {
        return this.needClientAuth;
    }

    public String[] getProtocols() {
        if (this.protocols == null) {
            return null;
        }
        return (String[]) this.protocols.clone();
    }

    public boolean getWantClientAuth() {
        return this.wantClientAuth;
    }

    public void setCipherSuites(String[] strArr) {
        this.cipherSuites = strArr == null ? null : (String[]) strArr.clone();
    }

    public void setNeedClientAuth(boolean z) {
        this.needClientAuth = z;
        this.wantClientAuth = false;
    }

    public void setProtocols(String[] strArr) {
        this.protocols = strArr == null ? null : (String[]) strArr.clone();
    }

    public void setWantClientAuth(boolean z) {
        this.wantClientAuth = z;
        this.needClientAuth = false;
    }
}
