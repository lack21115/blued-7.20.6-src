package javax.security.auth.callback;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/callback/CallbackHandler.class */
public interface CallbackHandler {
    void handle(Callback[] callbackArr) throws IOException, UnsupportedCallbackException;
}
