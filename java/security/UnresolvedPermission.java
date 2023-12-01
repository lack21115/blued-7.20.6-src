package java.security;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/security/UnresolvedPermission.class */
public final class UnresolvedPermission extends Permission implements Serializable {
    public UnresolvedPermission(String str, String str2, String str3, java.security.cert.Certificate[] certificateArr) {
        super("");
    }

    @Override // java.security.Permission
    public String getActions() {
        return null;
    }

    public String getUnresolvedActions() {
        return null;
    }

    public java.security.cert.Certificate[] getUnresolvedCerts() {
        return null;
    }

    public String getUnresolvedName() {
        return null;
    }

    public String getUnresolvedType() {
        return null;
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        return true;
    }
}
