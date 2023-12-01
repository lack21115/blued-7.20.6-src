package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/StringBuilderPrinter.class */
public class StringBuilderPrinter implements Printer {
    private final StringBuilder mBuilder;

    public StringBuilderPrinter(StringBuilder sb) {
        this.mBuilder = sb;
    }

    @Override // android.util.Printer
    public void println(String str) {
        this.mBuilder.append(str);
        int length = str.length();
        if (length <= 0 || str.charAt(length - 1) != '\n') {
            this.mBuilder.append('\n');
        }
    }
}
