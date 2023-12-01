package javax.security.auth;

import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/PrivateCredentialPermission.class */
public final class PrivateCredentialPermission extends Permission {
    public PrivateCredentialPermission(String str, String str2) {
        super("");
    }

    @Override // java.security.Permission
    public String getActions() {
        return null;
    }

    public String getCredentialClass() {
        return null;
    }

    public String[][] getPrincipals() {
        return null;
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        return true;
    }
}
