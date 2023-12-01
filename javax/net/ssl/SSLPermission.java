package javax.net.ssl;

import java.security.BasicPermission;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLPermission.class */
public final class SSLPermission extends BasicPermission {
    public SSLPermission(String str) {
        super("");
    }

    public SSLPermission(String str, String str2) {
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
