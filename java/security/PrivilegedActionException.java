package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/PrivilegedActionException.class */
public class PrivilegedActionException extends Exception {
    private static final long serialVersionUID = 4724086851538908602L;

    public PrivilegedActionException(Exception exc) {
        super(exc);
    }

    public Exception getException() {
        return null;
    }
}
