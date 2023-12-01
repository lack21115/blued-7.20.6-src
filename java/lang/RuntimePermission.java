package java.lang;

import java.security.BasicPermission;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:java/lang/RuntimePermission.class */
public final class RuntimePermission extends BasicPermission {
    public RuntimePermission(String str) {
        super("");
    }

    public RuntimePermission(String str, String str2) {
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
