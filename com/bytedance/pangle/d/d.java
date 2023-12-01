package com.bytedance.pangle.d;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/d/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f21372a;
    private static List<String> b = new CopyOnWriteArrayList();

    public static String a() {
        if (TextUtils.isEmpty(f21372a)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    String processName = Application.getProcessName();
                    if (!TextUtils.isEmpty(processName)) {
                        f21372a = processName;
                    }
                    return f21372a;
                }
            } catch (Throwable th) {
            }
            try {
                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
                if (!TextUtils.isEmpty((String) invokeStaticMethod)) {
                    f21372a = (String) invokeStaticMethod;
                }
                return f21372a;
            } catch (Exception e) {
                e.printStackTrace();
                String b2 = b();
                f21372a = b2;
                return b2;
            }
        }
        return f21372a;
    }

    public static String a(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(":")) ? "main" : str.split(":")[1];
    }

    public static boolean a(Context context) {
        String a2 = a();
        return (a2 == null || !a2.contains(":")) && a2 != null && a2.equals(context.getPackageName());
    }

    private static String b() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable th) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            if (ZeusLogger.isDebug()) {
                ZeusLogger.d("Process", "get processName = " + sb.toString());
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
                return sb2;
            } catch (Exception e) {
                return sb2;
            }
        } catch (Throwable th2) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    return null;
                } catch (Exception e2) {
                    return null;
                }
            }
            return null;
        }
    }
}
