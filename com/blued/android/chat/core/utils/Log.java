package com.blued.android.chat.core.utils;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.blued.android.chat.listener.ILogCallback;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/utils/Log.class */
public final class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String LOG_TIME_STAMP_FORMAT = "HH:mm:ss.SSS";
    private static final String[] PRIORITY_DISPLAY_STRINGS = {"", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", "W", ExifInterface.LONGITUDE_EAST, "A"};
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static BufferedWriter sBufferedFileWriter;
    private static Context sContext;
    private static ILogCallback sExternalLogger;
    private static File sLogFile;
    private static boolean sLogToFile;

    private Log() {
    }

    public static int d(String str, String str2) {
        return printlnInternal(3, str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return printlnInternal(3, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int e(String str, String str2) {
        return printlnInternal(6, str, str2);
    }

    public static int e(String str, String str2, Throwable th) {
        return printlnInternal(6, str, str2 + '\n' + getStackTraceString(th));
    }

    private static void ensurePathInitialized() {
        if (sLogFile == null) {
            throw new IllegalStateException("File path not initialized. Have you called Log.init() method?");
        }
    }

    private static String getDisplayForPriority(int i) {
        return PRIORITY_DISPLAY_STRINGS[i];
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        Throwable th2 = th;
        while (true) {
            Throwable th3 = th2;
            if (th3 == null) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                printWriter.flush();
                return stringWriter.toString();
            } else if (th3 instanceof UnknownHostException) {
                return "";
            } else {
                th2 = th3.getCause();
            }
        }
    }

    public static int i(String str, String str2) {
        return printlnInternal(4, str, str2);
    }

    public static int i(String str, String str2, Throwable th) {
        return printlnInternal(4, str, str2 + '\n' + getStackTraceString(th));
    }

    public static void init(Context context, ILogCallback iLogCallback) {
        sContext = context;
        sLogToFile = false;
        sExternalLogger = iLogCallback;
    }

    public static void init(Context context, boolean z, File file) throws IOException {
        sContext = context;
        sLogToFile = z;
        if (z) {
            sLogFile = file;
            sBufferedFileWriter = new BufferedWriter(new FileWriter(sLogFile, true));
        }
    }

    public static boolean isLoggable(String str, int i) {
        return android.util.Log.isLoggable(str, i);
    }

    public static int println(int i, String str, String str2) {
        return printlnInternal(i, str, str2);
    }

    private static int printlnInternal(int i, String str, String str2) {
        if (sLogToFile || sExternalLogger != null) {
            if (sLogToFile) {
                ensurePathInitialized();
            }
            StringBuilder sb = new StringBuilder(new SimpleDateFormat(LOG_TIME_STAMP_FORMAT).format(new Date()));
            sb.append("\t");
            sb.append(Thread.currentThread().getId());
            sb.append("\t");
            sb.append(getDisplayForPriority(i));
            sb.append("\t");
            sb.append(str);
            sb.append("\t");
            sb.append(str2);
            try {
                if (sExternalLogger != null) {
                    sExternalLogger.logger(sb.toString());
                } else if (sBufferedFileWriter != null) {
                    sBufferedFileWriter.write(sb.toString(), 0, sb.length());
                    sBufferedFileWriter.newLine();
                    sBufferedFileWriter.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return android.util.Log.println(i, str, str2);
    }

    public static int v(String str, String str2) {
        return printlnInternal(2, str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        return printlnInternal(2, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int w(String str, String str2) {
        return printlnInternal(5, str, str2);
    }

    public static int w(String str, String str2, Throwable th) {
        return printlnInternal(5, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int w(String str, Throwable th) {
        return printlnInternal(5, str, getStackTraceString(th));
    }
}
