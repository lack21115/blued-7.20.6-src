package java.security.cert;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/PKIXBuilderParameters.class */
public class PKIXBuilderParameters extends PKIXParameters {
    private int maxPathLength;

    public PKIXBuilderParameters(KeyStore keyStore, CertSelector certSelector) throws KeyStoreException, InvalidAlgorithmParameterException {
        super(keyStore);
        this.maxPathLength = 5;
        super.setTargetCertConstraints(certSelector);
    }

    public PKIXBuilderParameters(Set<TrustAnchor> set, CertSelector certSelector) throws InvalidAlgorithmParameterException {
        super(set);
        this.maxPathLength = 5;
        super.setTargetCertConstraints(certSelector);
    }

    public int getMaxPathLength() {
        return this.maxPathLength;
    }

    public void setMaxPathLength(int i) {
        if (i < -1) {
            throw new InvalidParameterException("maxPathLength < -1");
        }
        this.maxPathLength = i;
    }

    @Override // java.security.cert.PKIXParameters
    public String toString() {
        return "[\n" + super.toString() + " Max Path Length: " + this.maxPathLength + "\n]";
    }
}
