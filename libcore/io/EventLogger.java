package libcore.io;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/EventLogger.class */
public final class EventLogger {
    private static volatile Reporter REPORTER = new DefaultReporter();

    /* loaded from: source-2895416-dex2jar.jar:libcore/io/EventLogger$DefaultReporter.class */
    private static final class DefaultReporter implements Reporter {
        private DefaultReporter() {
        }

        @Override // libcore.io.EventLogger.Reporter
        public void report(int i, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            int length = objArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    System.out.println(sb);
                    return;
                }
                Object obj = objArr[i3];
                sb.append(",");
                sb.append(obj.toString());
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:libcore/io/EventLogger$Reporter.class */
    public interface Reporter {
        void report(int i, Object... objArr);
    }

    public static Reporter getReporter() {
        return REPORTER;
    }

    public static void setReporter(Reporter reporter) {
        if (reporter == null) {
            throw new NullPointerException("reporter == null");
        }
        REPORTER = reporter;
    }

    public static void writeEvent(int i, Object... objArr) {
        getReporter().report(i, objArr);
    }
}
