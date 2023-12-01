package com.android.internal.logging;

import android.util.Log;
import com.android.internal.util.FastPrintWriter;
import dalvik.system.DalvikLogHandler;
import dalvik.system.DalvikLogging;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/logging/AndroidHandler.class */
public class AndroidHandler extends Handler implements DalvikLogHandler {
    private static final Formatter THE_FORMATTER = new Formatter() { // from class: com.android.internal.logging.AndroidHandler.1
        @Override // java.util.logging.Formatter
        public String format(LogRecord logRecord) {
            Throwable thrown = logRecord.getThrown();
            if (thrown != null) {
                StringWriter stringWriter = new StringWriter();
                FastPrintWriter fastPrintWriter = new FastPrintWriter((Writer) stringWriter, false, 256);
                stringWriter.write(logRecord.getMessage());
                stringWriter.write("\n");
                thrown.printStackTrace(fastPrintWriter);
                fastPrintWriter.flush();
                return stringWriter.toString();
            }
            return logRecord.getMessage();
        }
    };

    public AndroidHandler() {
        setFormatter(THE_FORMATTER);
    }

    static int getAndroidLevel(Level level) {
        int intValue = level.intValue();
        if (intValue >= 1000) {
            return 6;
        }
        if (intValue >= 900) {
            return 5;
        }
        return intValue >= 800 ? 4 : 3;
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        int androidLevel = getAndroidLevel(logRecord.getLevel());
        String loggerNameToTag = DalvikLogging.loggerNameToTag(logRecord.getLoggerName());
        if (Log.isLoggable(loggerNameToTag, androidLevel)) {
            try {
                Log.println(androidLevel, loggerNameToTag, getFormatter().format(logRecord));
            } catch (RuntimeException e) {
                Log.e("AndroidHandler", "Error logging message.", e);
            }
        }
    }

    @Override // dalvik.system.DalvikLogHandler
    public void publish(Logger logger, String str, Level level, String str2) {
        int androidLevel = getAndroidLevel(level);
        if (Log.isLoggable(str, androidLevel)) {
            try {
                Log.println(androidLevel, str, str2);
            } catch (RuntimeException e) {
                Log.e("AndroidHandler", "Error logging message.", e);
            }
        }
    }
}
