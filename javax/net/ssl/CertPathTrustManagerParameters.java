package javax.net.ssl;

import java.security.cert.CertPathParameters;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/CertPathTrustManagerParameters.class */
public class CertPathTrustManagerParameters implements ManagerFactoryParameters {
    private final CertPathParameters param;

    public CertPathTrustManagerParameters(CertPathParameters certPathParameters) {
        this.param = (CertPathParameters) certPathParameters.clone();
    }

    public CertPathParameters getParameters() {
        return (CertPathParameters) this.param.clone();
    }
}
