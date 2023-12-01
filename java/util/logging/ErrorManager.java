package java.util.logging;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/ErrorManager.class */
public class ErrorManager {
    public static final int CLOSE_FAILURE = 3;
    private static final String[] FAILURES = {"GENERIC_FAILURE", "WRITE_FAILURE", "FLUSH_FAILURE", "CLOSE_FAILURE", "OPEN_FAILURE", "FORMAT_FAILURE"};
    public static final int FLUSH_FAILURE = 2;
    public static final int FORMAT_FAILURE = 5;
    public static final int GENERIC_FAILURE = 0;
    public static final int OPEN_FAILURE = 4;
    public static final int WRITE_FAILURE = 1;
    private boolean called;

    public void error(String str, Exception exc, int i) {
        synchronized (this) {
            if (this.called) {
                return;
            }
            this.called = true;
            System.err.println(getClass().getName() + ": " + FAILURES[i]);
            if (str != null) {
                System.err.println("Error message - " + str);
            }
            if (exc != null) {
                System.err.println("Exception - " + exc);
            }
        }
    }
}
