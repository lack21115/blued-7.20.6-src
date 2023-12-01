package java.io;

import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:java/io/FilePermission.class */
public final class FilePermission extends Permission implements Serializable {
    public FilePermission(String str, String str2) {
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
