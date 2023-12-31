package java.security;

import java.io.Serializable;
import java.util.Enumeration;

/* loaded from: source-2895416-dex2jar.jar:java/security/PermissionCollection.class */
public abstract class PermissionCollection implements Serializable {
    public abstract void add(Permission permission);

    public abstract Enumeration<Permission> elements();

    public abstract boolean implies(Permission permission);

    public boolean isReadOnly() {
        return true;
    }

    public void setReadOnly() {
    }
}
