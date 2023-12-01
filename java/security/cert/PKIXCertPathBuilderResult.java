package java.security.cert;

import java.security.PublicKey;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/PKIXCertPathBuilderResult.class */
public class PKIXCertPathBuilderResult extends PKIXCertPathValidatorResult implements CertPathBuilderResult {
    private final CertPath certPath;

    public PKIXCertPathBuilderResult(CertPath certPath, TrustAnchor trustAnchor, PolicyNode policyNode, PublicKey publicKey) {
        super(trustAnchor, policyNode, publicKey);
        if (certPath == null) {
            throw new NullPointerException("certPath == null");
        }
        this.certPath = certPath;
    }

    @Override // java.security.cert.CertPathBuilderResult
    public CertPath getCertPath() {
        return this.certPath;
    }

    @Override // java.security.cert.PKIXCertPathValidatorResult
    public String toString() {
        return super.toString() + "\n Certification Path: " + this.certPath.toString() + "\n]";
    }
}
