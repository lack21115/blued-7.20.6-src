package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/AccessController.class */
public final class AccessController {
    private AccessController() {
    }

    public static void checkPermission(Permission permission) throws AccessControlException {
    }

    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return privilegedAction.run();
    }

    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction, AccessControlContext accessControlContext) {
        return privilegedAction.run();
    }

    public static <T> T doPrivileged(PrivilegedExceptionAction<T> privilegedExceptionAction) throws PrivilegedActionException {
        try {
            return privilegedExceptionAction.run();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new PrivilegedActionException(e2);
        }
    }

    public static <T> T doPrivileged(PrivilegedExceptionAction<T> privilegedExceptionAction, AccessControlContext accessControlContext) throws PrivilegedActionException {
        return (T) doPrivileged(privilegedExceptionAction);
    }

    public static <T> T doPrivilegedWithCombiner(PrivilegedAction<T> privilegedAction) {
        return privilegedAction.run();
    }

    public static <T> T doPrivilegedWithCombiner(PrivilegedExceptionAction<T> privilegedExceptionAction) throws PrivilegedActionException {
        return (T) doPrivileged(privilegedExceptionAction);
    }

    public static AccessControlContext getContext() {
        return new AccessControlContext(null);
    }
}
