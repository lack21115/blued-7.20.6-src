package javax.security.auth.login;

import java.security.GeneralSecurityException;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/login/LoginException.class */
public class LoginException extends GeneralSecurityException {
    private static final long serialVersionUID = -4679091624035232488L;

    public LoginException() {
    }

    public LoginException(String str) {
        super(str);
    }
}
