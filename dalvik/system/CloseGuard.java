package dalvik.system;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/CloseGuard.class */
public final class CloseGuard {
    private Throwable allocationSite;
    private static final CloseGuard NOOP = new CloseGuard();
    private static volatile boolean ENABLED = true;
    private static volatile Reporter REPORTER = new DefaultReporter();

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/CloseGuard$DefaultReporter.class */
    private static final class DefaultReporter implements Reporter {
        private DefaultReporter() {
        }

        @Override // dalvik.system.CloseGuard.Reporter
        public void report(String str, Throwable th) {
            System.logW(str, th);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/CloseGuard$Reporter.class */
    public interface Reporter {
        void report(String str, Throwable th);
    }

    private CloseGuard() {
    }

    public static CloseGuard get() {
        return !ENABLED ? NOOP : new CloseGuard();
    }

    public static Reporter getReporter() {
        return REPORTER;
    }

    public static void setEnabled(boolean z) {
        ENABLED = z;
    }

    public static void setReporter(Reporter reporter) {
        if (reporter == null) {
            throw new NullPointerException("reporter == null");
        }
        REPORTER = reporter;
    }

    public void close() {
        this.allocationSite = null;
    }

    public void open(String str) {
        if (str == null) {
            throw new NullPointerException("closer == null");
        }
        if (this == NOOP || !ENABLED) {
            return;
        }
        this.allocationSite = new Throwable("Explicit termination method '" + str + "' not called");
    }

    public void warnIfOpen() {
        if (this.allocationSite == null || !ENABLED) {
            return;
        }
        REPORTER.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
    }
}
