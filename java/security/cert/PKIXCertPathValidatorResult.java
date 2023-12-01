package java.security.cert;

import java.security.PublicKey;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/PKIXCertPathValidatorResult.class */
public class PKIXCertPathValidatorResult implements CertPathValidatorResult {
    private final PolicyNode policyTree;
    private final PublicKey subjectPublicKey;
    private final TrustAnchor trustAnchor;

    public PKIXCertPathValidatorResult(TrustAnchor trustAnchor, PolicyNode policyNode, PublicKey publicKey) {
        this.trustAnchor = trustAnchor;
        this.policyTree = policyNode;
        this.subjectPublicKey = publicKey;
        if (this.trustAnchor == null) {
            throw new NullPointerException("trustAnchor == null");
        }
        if (this.subjectPublicKey == null) {
            throw new NullPointerException("subjectPublicKey == null");
        }
    }

    @Override // java.security.cert.CertPathValidatorResult
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public PolicyNode getPolicyTree() {
        return this.policyTree;
    }

    public PublicKey getPublicKey() {
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() {
        return this.trustAnchor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(": [\n Trust Anchor: ");
        sb.append(this.trustAnchor.toString());
        sb.append("\n Policy Tree: ");
        sb.append(this.policyTree == null ? "no valid policy tree\n" : this.policyTree.toString());
        sb.append("\n Subject Public Key: ");
        sb.append(this.subjectPublicKey.toString());
        sb.append("\n]");
        return sb.toString();
    }
}
