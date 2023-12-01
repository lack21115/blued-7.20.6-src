package java.security;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/security/Permission.class */
public abstract class Permission implements Guard, Serializable {
    public Permission(String str) {
    }

    @Override // java.security.Guard
    public void checkGuard(Object obj) throws SecurityException {
    }

    public abstract String getActions();

    public final String getName() {
        return null;
    }

    public abstract boolean implies(Permission permission);

    public PermissionCollection newPermissionCollection() {
        return new AllPermissionCollection();
    }
}
