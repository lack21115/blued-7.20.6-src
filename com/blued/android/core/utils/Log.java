package com.blued.android.core.utils;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
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

    /* renamed from: a  reason: collision with root package name */
    private static File f9732a;
    private static BufferedWriter b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f9733c;
    private static Context d;
    private static final String[] e = {"", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", "W", ExifInterface.LONGITUDE_EAST, "A"};

    private Log() {
    }

    private static int a(int i, String str, String str2) {
        if (f9733c) {
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
        if (f9732a == null) {
            throw new IllegalStateException("File path not initialized. Have you called Log.init() method?");
        }
    }

    public static void a(Context context, boolean z, File file) throws IOException {
        d = context;
        f9733c = z;
        if (z) {
            f9732a = file;
            b = new BufferedWriter(new FileWriter(f9732a, true));
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
