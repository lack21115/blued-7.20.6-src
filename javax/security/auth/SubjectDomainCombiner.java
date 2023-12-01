package javax.security.auth;

import java.security.DomainCombiner;
import java.security.ProtectionDomain;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/SubjectDomainCombiner.class */
public class SubjectDomainCombiner implements DomainCombiner {
    public SubjectDomainCombiner(Subject subject) {
    }

    @Override // java.security.DomainCombiner
    public ProtectionDomain[] combine(ProtectionDomain[] protectionDomainArr, ProtectionDomain[] protectionDomainArr2) {
        return null;
    }

    public Subject getSubject() {
        return null;
    }
}
