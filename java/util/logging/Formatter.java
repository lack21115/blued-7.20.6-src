package java.util.logging;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/Formatter.class */
public abstract class Formatter {
    public abstract String format(LogRecord logRecord);

    public String formatMessage(LogRecord logRecord) {
        String message = logRecord.getMessage();
        ResourceBundle resourceBundle = logRecord.getResourceBundle();
        String str = message;
        if (resourceBundle != null) {
            try {
                str = resourceBundle.getString(message);
            } catch (Exception e) {
                str = logRecord.getMessage();
            }
        }
        String str2 = str;
        if (str != null) {
            Object[] parameters = logRecord.getParameters();
            str2 = str;
            if (str.indexOf("{0") >= 0) {
                str2 = str;
                if (parameters != null) {
                    str2 = str;
                    if (parameters.length > 0) {
                        try {
                            str2 = MessageFormat.format(str, parameters);
                        } catch (IllegalArgumentException e2) {
                            return logRecord.getMessage();
                        }
                    }
                }
            }
        }
        return str2;
    }

    public String getHead(Handler handler) {
        return "";
    }

    public String getTail(Handler handler) {
        return "";
    }
}
