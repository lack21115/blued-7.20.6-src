package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/Policy.class */
public abstract class Policy {
    public static final PermissionCollection UNSUPPORTED_EMPTY_COLLECTION = new AllPermissionCollection();

    /* loaded from: source-2895416-dex2jar.jar:java/security/Policy$Parameters.class */
    public interface Parameters {
    }

    public static Policy getInstance(String str, Parameters parameters) throws NoSuchAlgorithmException {
        return null;
    }

    public static Policy getInstance(String str, Parameters parameters, String str2) throws NoSuchProviderException, NoSuchAlgorithmException {
        return null;
    }

    public static Policy getInstance(String str, Parameters parameters, Provider provider) throws NoSuchAlgorithmException {
        return null;
    }

    public static Policy getPolicy() {
        return null;
    }

    public static void setPolicy(Policy policy) {
    }

    public Parameters getParameters() {
        return null;
    }

    public PermissionCollection getPermissions(CodeSource codeSource) {
        return null;
    }

    public PermissionCollection getPermissions(ProtectionDomain protectionDomain) {
        return null;
    }

    public Provider getProvider() {
        return null;
    }

    public String getType() {
        return null;
    }

    public boolean implies(ProtectionDomain protectionDomain, Permission permission) {
        return true;
    }

    public void refresh() {
    }
}
