package java.security.cert;

import java.util.Collection;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/PKIXCertPathChecker.class */
public abstract class PKIXCertPathChecker implements Cloneable {
    public abstract void check(Certificate certificate, Collection<String> collection) throws CertPathValidatorException;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public abstract Set<String> getSupportedExtensions();

    public abstract void init(boolean z) throws CertPathValidatorException;

    public abstract boolean isForwardCheckingSupported();
}
