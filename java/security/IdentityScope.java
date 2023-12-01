package java.security;

import java.util.Enumeration;

@Deprecated
/* loaded from: source-2895416-dex2jar.jar:java/security/IdentityScope.class */
public abstract class IdentityScope extends Identity {
    private static final long serialVersionUID = -2337346281189773310L;
    private static IdentityScope systemScope;

    /* JADX INFO: Access modifiers changed from: protected */
    public IdentityScope() {
    }

    public IdentityScope(String str) {
        super(str);
    }

    public IdentityScope(String str, IdentityScope identityScope) throws KeyManagementException {
        super(str, identityScope);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:7:0x001d). Please submit an issue!!! */
    public static IdentityScope getSystemScope() {
        String property;
        if (systemScope == null && (property = Security.getProperty("system.scope")) != null) {
            try {
                systemScope = (IdentityScope) Class.forName(property).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return systemScope;
    }

    protected static void setSystemScope(IdentityScope identityScope) {
        systemScope = identityScope;
    }

    public abstract void addIdentity(Identity identity) throws KeyManagementException;

    public abstract Identity getIdentity(String str);

    public Identity getIdentity(Principal principal) {
        return getIdentity(principal.getName());
    }

    public abstract Identity getIdentity(PublicKey publicKey);

    public abstract Enumeration<Identity> identities();

    public abstract void removeIdentity(Identity identity) throws KeyManagementException;

    public abstract int size();

    @Override // java.security.Identity, java.security.Principal
    public String toString() {
        return super.toString() + "[" + size() + "]";
    }
}
