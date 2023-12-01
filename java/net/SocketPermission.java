package java.net;

import java.io.Serializable;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:java/net/SocketPermission.class */
public final class SocketPermission extends Permission implements Serializable {
    public SocketPermission(String str, String str2) {
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
