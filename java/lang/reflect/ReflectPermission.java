package java.lang.reflect;

import java.security.BasicPermission;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/ReflectPermission.class */
public final class ReflectPermission extends BasicPermission {
    public ReflectPermission(String str) {
        super("");
    }

    public ReflectPermission(String str, String str2) {
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
