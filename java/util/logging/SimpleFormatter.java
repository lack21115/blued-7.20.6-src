package java.util.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Date;
import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/SimpleFormatter.class */
public class SimpleFormatter extends Formatter {
    @Override // java.util.logging.Formatter
    public String format(LogRecord logRecord) {
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormat.format("{0, date} {0, time} ", new Date(logRecord.getMillis())));
        sb.append(logRecord.getSourceClassName()).append(" ");
        sb.append(logRecord.getSourceMethodName()).append(System.lineSeparator());
        sb.append(logRecord.getLevel().getName()).append(": ");
        sb.append(formatMessage(logRecord)).append(System.lineSeparator());
        if (logRecord.getThrown() != null) {
            sb.append("Throwable occurred: ");
            Throwable thrown = logRecord.getThrown();
            PrintWriter printWriter = null;
            try {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter2 = new PrintWriter(stringWriter);
                try {
                    thrown.printStackTrace(printWriter2);
                    sb.append(stringWriter.toString());
                    IoUtils.closeQuietly(printWriter2);
                } catch (Throwable th) {
                    printWriter = printWriter2;
                    th = th;
                    IoUtils.closeQuietly(printWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return sb.toString();
    }
}
