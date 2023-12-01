package libcore.io;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/DropBox.class */
public final class DropBox {
    private static volatile Reporter REPORTER = new DefaultReporter();

    /* loaded from: source-2895416-dex2jar.jar:libcore/io/DropBox$DefaultReporter.class */
    private static final class DefaultReporter implements Reporter {
        private DefaultReporter() {
        }

        @Override // libcore.io.DropBox.Reporter
        public void addData(String str, byte[] bArr, int i) {
            System.out.println(str + ": " + Base64.encode(bArr));
        }

        @Override // libcore.io.DropBox.Reporter
        public void addText(String str, String str2) {
            System.out.println(str + ": " + str2);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:libcore/io/DropBox$Reporter.class */
    public interface Reporter {
        void addData(String str, byte[] bArr, int i);

        void addText(String str, String str2);
    }

    public static void addData(String str, byte[] bArr, int i) {
        getReporter().addData(str, bArr, i);
    }

    public static void addText(String str, String str2) {
        getReporter().addText(str, str2);
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
}
