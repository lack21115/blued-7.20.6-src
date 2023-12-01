package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/PolicySpi.class */
public abstract class PolicySpi {
    protected PermissionCollection engineGetPermissions(CodeSource codeSource) {
        return Policy.UNSUPPORTED_EMPTY_COLLECTION;
    }

    protected PermissionCollection engineGetPermissions(ProtectionDomain protectionDomain) {
        return Policy.UNSUPPORTED_EMPTY_COLLECTION;
    }

    protected abstract boolean engineImplies(ProtectionDomain protectionDomain, Permission permission);

    protected void engineRefresh() {
    }
}
