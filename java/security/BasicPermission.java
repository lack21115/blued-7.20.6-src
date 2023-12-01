package java.security;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/security/BasicPermission.class */
public abstract class BasicPermission extends Permission implements Serializable {
    public BasicPermission(String str) {
        super("");
    }

    public BasicPermission(String str, String str2) {
        super("");
    }

    @Override // java.security.Permission
    public String getActions() {
        return null;
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        return true;
    }
}
