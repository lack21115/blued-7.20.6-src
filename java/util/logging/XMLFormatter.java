package java.util.logging;

import android.os.BatteryManager;
import com.baidu.mobads.sdk.internal.bq;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/XMLFormatter.class */
public class XMLFormatter extends Formatter {
    private static final String indent = "    ";

    private static void append(StringBuilder sb, int i, String str, Object obj) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                sb.append(SimpleComparison.LESS_THAN_OPERATION).append(str).append(SimpleComparison.GREATER_THAN_OPERATION);
                sb.append(obj);
                sb.append("</").append(str).append(SimpleComparison.GREATER_THAN_OPERATION);
                sb.append(System.lineSeparator());
                return;
            }
            sb.append(indent);
            i2 = i3 + 1;
        }
    }

    private void formatMessages(LogRecord logRecord, StringBuilder sb) {
        String str;
        ResourceBundle resourceBundle = logRecord.getResourceBundle();
        String message = logRecord.getMessage();
        if (resourceBundle == null || message == null) {
            if (message != null) {
                append(sb, 1, "message", message);
                return;
            } else {
                sb.append(indent).append("<message/>");
                return;
            }
        }
        try {
            str = resourceBundle.getString(message);
        } catch (Exception e) {
            str = null;
        }
        if (str == null) {
            append(sb, 1, "message", message);
            return;
        }
        append(sb, 1, "message", str);
        append(sb, 1, "key", message);
        append(sb, 1, "catalog", logRecord.getResourceBundleName());
    }

    private void formatThrowable(LogRecord logRecord, StringBuilder sb) {
        Throwable thrown = logRecord.getThrown();
        if (thrown == null) {
            return;
        }
        String lineSeparator = System.lineSeparator();
        sb.append(indent).append("<exception>").append(lineSeparator);
        append(sb, 2, "message", thrown.toString());
        StackTraceElement[] stackTrace = thrown.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append(indent).append("</exception>").append(lineSeparator);
                return;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            sb.append(indent).append(indent).append("<frame>").append(lineSeparator);
            append(sb, 3, "class", stackTraceElement.getClassName());
            append(sb, 3, "method", stackTraceElement.getMethodName());
            append(sb, 3, "line", Integer.valueOf(stackTraceElement.getLineNumber()));
            sb.append(indent).append(indent).append("</frame>").append(lineSeparator);
            i = i2 + 1;
        }
    }

    @Override // java.util.logging.Formatter
    public String format(LogRecord logRecord) {
        long millis = logRecord.getMillis();
        String format = MessageFormat.format("{0, date} {0, time}", new Date(millis));
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("<record>").append(lineSeparator);
        append(sb, 1, "date", format);
        append(sb, 1, "millis", Long.valueOf(millis));
        append(sb, 1, "sequence", Long.valueOf(logRecord.getSequenceNumber()));
        if (logRecord.getLoggerName() != null) {
            append(sb, 1, bq.f9354a, logRecord.getLoggerName());
        }
        append(sb, 1, BatteryManager.EXTRA_LEVEL, logRecord.getLevel().getName());
        if (logRecord.getSourceClassName() != null) {
            append(sb, 1, "class", logRecord.getSourceClassName());
        }
        if (logRecord.getSourceMethodName() != null) {
            append(sb, 1, "method", logRecord.getSourceMethodName());
        }
        append(sb, 1, "thread", Integer.valueOf(logRecord.getThreadID()));
        formatMessages(logRecord, sb);
        Object[] parameters = logRecord.getParameters();
        if (parameters != null) {
            int length = parameters.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(sb, 1, RemoteMessageConst.MessageBody.PARAM, parameters[i2]);
                i = i2 + 1;
            }
        }
        formatThrowable(logRecord, sb);
        sb.append("</record>").append(lineSeparator);
        return sb.toString();
    }

    @Override // java.util.logging.Formatter
    public String getHead(Handler handler) {
        String str = null;
        if (handler != null) {
            str = handler.getEncoding();
        }
        String str2 = str;
        if (str == null) {
            str2 = System.getProperty("file.encoding");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"").append(str2).append("\" standalone=\"no\"?>");
        sb.append(System.lineSeparator());
        sb.append("<!DOCTYPE log SYSTEM \"logger.dtd\">");
        sb.append(System.lineSeparator());
        sb.append("<log>");
        return sb.toString();
    }

    @Override // java.util.logging.Formatter
    public String getTail(Handler handler) {
        return "</log>";
    }
}
