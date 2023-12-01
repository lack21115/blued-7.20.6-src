package android.content;

/* loaded from: source-9557208-dex2jar.jar:android/content/OperationApplicationException.class */
public class OperationApplicationException extends Exception {
    private final int mNumSuccessfulYieldPoints;

    public OperationApplicationException() {
        this.mNumSuccessfulYieldPoints = 0;
    }

    public OperationApplicationException(int i) {
        this.mNumSuccessfulYieldPoints = i;
    }

    public OperationApplicationException(String str) {
        super(str);
        this.mNumSuccessfulYieldPoints = 0;
    }

    public OperationApplicationException(String str, int i) {
        super(str);
        this.mNumSuccessfulYieldPoints = i;
    }

    public OperationApplicationException(String str, Throwable th) {
        super(str, th);
        this.mNumSuccessfulYieldPoints = 0;
    }

    public OperationApplicationException(Throwable th) {
        super(th);
        this.mNumSuccessfulYieldPoints = 0;
    }

    public int getNumSuccessfulYieldPoints() {
        return this.mNumSuccessfulYieldPoints;
    }
}
