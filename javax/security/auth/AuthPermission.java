package javax.security.auth;

import java.security.BasicPermission;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/AuthPermission.class */
public final class AuthPermission extends BasicPermission {
    public AuthPermission(String str) {
        super("");
    }

    public AuthPermission(String str, String str2) {
        super("", "");
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return null;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission permission) {
        return true;
    }
}
