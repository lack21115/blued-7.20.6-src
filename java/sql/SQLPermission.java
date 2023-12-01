package java.sql;

import java.io.Serializable;
import java.security.BasicPermission;
import java.security.Guard;
import java.security.Permission;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLPermission.class */
public final class SQLPermission extends BasicPermission implements Guard, Serializable {
    public SQLPermission(String str) {
        super("");
    }

    public SQLPermission(String str, String str2) {
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
