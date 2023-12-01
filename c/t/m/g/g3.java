package c.t.m.g;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g3.class */
public class g3 {
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
                String stringWriter2 = stringWriter.toString();
                String str = stringWriter2;
                if (stringWriter2.contains("\n")) {
                    str = stringWriter2.replaceAll("\n", "");
                }
                return str;
            } else if (th3 instanceof UnknownHostException) {
                return "";
            } else {
                th2 = th3.getCause();
            }
        }
    }

    public static void a(int i, String str, String str2) {
        a(str, 3, str2, null);
        if (w1.b() != null) {
            w1.b().a(i, str, str2);
        }
    }

    public static void a(String str, int i, String str2, Throwable th) {
        if (w1.d()) {
            if (th != null) {
                str2 = str2 + ". exception: " + Log.getStackTraceString(th);
            }
            Log.println(i, str, str2);
        }
    }

    public static void a(String str, String str2) {
        a(1006, str, str2);
    }

    public static final boolean a() {
        return w1.d() || w1.c() != null;
    }

    public static void b(String str, String str2) {
        a(1004, str, str2);
    }
}
