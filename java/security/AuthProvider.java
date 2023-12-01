package java.security;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

/* loaded from: source-2895416-dex2jar.jar:java/security/AuthProvider.class */
public abstract class AuthProvider extends Provider {
    protected AuthProvider(String str, double d, String str2) {
        super(str, d, str2);
    }

    public abstract void login(Subject subject, CallbackHandler callbackHandler) throws LoginException;

    public abstract void logout() throws LoginException;

    public abstract void setCallbackHandler(CallbackHandler callbackHandler);
}
