package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/SecurityPermission.class */
public final class SecurityPermission extends BasicPermission {
    public SecurityPermission(String str) {
        super("");
    }

    public SecurityPermission(String str, String str2) {
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
