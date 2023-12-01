package c.t.m.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/u6.class */
public class u6 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4014a = false;
    public static Context b;

    /* renamed from: c  reason: collision with root package name */
    public static v6 f4015c;

    public static String a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        try {
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            do {
                if (!it.hasNext()) {
                    return "";
                }
                next = it.next();
            } while (next.pid != myPid);
            return next.processName;
        } catch (Exception e) {
            return "";
        }
    }

    public static void a(Context context, File file) {
        b = context;
        if (f4014a) {
            t6.a(context, file);
        }
    }

    public static void a(v6 v6Var) {
        f4015c = v6Var;
    }

    public static void a(String str, int i, String str2) {
        if (f4014a) {
            String str3 = System.currentTimeMillis() + ",p:" + a(b) + ",t:" + Thread.currentThread().getName() + "," + str2;
            if (f4015c != null) {
                new SimpleDateFormat("HH:mm:ss").format(new Date());
                f4015c.a(str, str2);
            }
            t6 a2 = t6.a();
            if (a2 != null) {
                a2.a(str, i, str3);
            }
        }
    }

    public static void a(String str, String str2) {
        a(str, 4, str2);
    }
}
