package com.blued.android.core.utils;

import android.content.Context;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/Log.class */
public final class Log {
    private static File a;
    private static BufferedWriter b;
    private static boolean c;
    private static Context d;
    private static final String[] e = {"", "", "V", "D", "I", "W", "E", "A"};

    private Log() {
    }

    private static int a(int i, String str, String str2) {
        if (c) {
            a();
            StringBuilder sb = new StringBuilder(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
            sb.append("\t");
            sb.append(Thread.currentThread().getId());
            sb.append("\t");
            sb.append(a(i));
            sb.append("\t");
            sb.append(str);
            sb.append("\t");
            sb.append(str2);
            try {
                if (b != null) {
                    b.write(sb.toString(), 0, sb.length());
                    b.newLine();
                    b.flush();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return android.util.Log.println(i, str, str2);
    }

    public static int a(String str, String str2) {
        return a(2, str, str2);
    }

    public static int a(String str, String str2, Throwable th) {
        return a(6, str, str2 + '\n' + a(th));
    }

    private static String a(int i) {
        return e[i];
    }

    public static String a(Throwable th) {
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

    private static void a() {
        if (a == null) {
            throw new IllegalStateException("File path not initialized. Have you called Log.init() method?");
        }
    }

    public static void a(Context context, boolean z, File file) throws IOException {
        d = context;
        c = z;
        if (z) {
            a = file;
            b = new BufferedWriter(new FileWriter(a, true));
        }
    }

    public static int b(String str, String str2) {
        return a(3, str, str2);
    }

    public static int c(String str, String str2) {
        return a(4, str, str2);
    }

    public static int d(String str, String str2) {
        return a(5, str, str2);
    }

    public static int e(String str, String str2) {
        return a(6, str, str2);
    }
}
