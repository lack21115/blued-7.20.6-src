package android.accounts;

/* loaded from: source-9557208-dex2jar.jar:android/accounts/OperationCanceledException.class */
public class OperationCanceledException extends AccountsException {
    public OperationCanceledException() {
    }

    public OperationCanceledException(String str) {
        super(str);
    }

    public OperationCanceledException(String str, Throwable th) {
        super(str, th);
    }

    public OperationCanceledException(Throwable th) {
        super(th);
    }
}
