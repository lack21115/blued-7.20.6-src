package java.util;

import java.security.BasicPermission;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:java/util/PropertyPermission.class */
public final class PropertyPermission extends BasicPermission {
    public PropertyPermission(String str, String str2) {
        super("");
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
