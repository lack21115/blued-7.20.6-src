package javax.security.auth;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/Destroyable.class */
public interface Destroyable {
    void destroy() throws DestroyFailedException;

    boolean isDestroyed();
}
