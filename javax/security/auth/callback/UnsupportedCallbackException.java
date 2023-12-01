package javax.security.auth.callback;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/callback/UnsupportedCallbackException.class */
public class UnsupportedCallbackException extends Exception {
    private static final long serialVersionUID = -6873556327655666839L;
    private Callback callback;

    public UnsupportedCallbackException(Callback callback) {
        this.callback = callback;
    }

    public UnsupportedCallbackException(Callback callback, String str) {
        super(str);
        this.callback = callback;
    }

    public Callback getCallback() {
        return this.callback;
    }
}
