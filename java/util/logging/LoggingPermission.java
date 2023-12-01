package java.util.logging;

import java.io.Serializable;
import java.security.BasicPermission;
import java.security.Guard;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/LoggingPermission.class */
public final class LoggingPermission extends BasicPermission implements Guard, Serializable {
    public LoggingPermission(String str, String str2) {
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
