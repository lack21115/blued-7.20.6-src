package java.security;

import java.io.Serializable;
import java.util.Enumeration;

/* loaded from: source-2895416-dex2jar.jar:java/security/Permissions.class */
public final class Permissions extends PermissionCollection implements Serializable {
    @Override // java.security.PermissionCollection
    public void add(Permission permission) {
    }

    @Override // java.security.PermissionCollection
    public Enumeration<Permission> elements() {
        return null;
    }

    @Override // java.security.PermissionCollection
    public boolean implies(Permission permission) {
        return true;
    }
}
