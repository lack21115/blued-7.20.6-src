package java.io;

import java.security.BasicPermission;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:java/io/SerializablePermission.class */
public final class SerializablePermission extends BasicPermission {
    public SerializablePermission(String str) {
        super("");
    }

    public SerializablePermission(String str, String str2) {
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
