package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/AllPermission.class */
public final class AllPermission extends Permission {
    public AllPermission() {
        super("");
    }

    public AllPermission(String str, String str2) {
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
