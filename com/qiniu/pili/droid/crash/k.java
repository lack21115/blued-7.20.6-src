package com.qiniu.pili.droid.crash;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/k.class */
public class k {
    private static int a(int i) {
        return (i & (-65536)) >> 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return Build.BRAND + " " + Build.PRODUCT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        try {
            return str.substring(str.lastIndexOf("Caused by") + 11).substring(0, str.indexOf(":"));
        } catch (Exception e) {
            return "unknow";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            while (th != null) {
                th.printStackTrace(printWriter);
                th = th.getCause();
            }
            String obj = stringWriter.toString();
            printWriter.close();
            return obj;
        } catch (Exception e) {
            return "unknow";
        }
    }

    private static void a(int i, StringBuilder sb, String str, int i2, char c2) {
        BufferedReader bufferedReader;
        if (i2 <= 0) {
            return;
        }
        boolean z = Build.VERSION.SDK_INT >= 24;
        String num = Integer.toString(i);
        String str2 = " " + num + " ";
        ArrayList arrayList = new ArrayList();
        arrayList.add("/system/bin/logcat");
        arrayList.add("-b");
        arrayList.add(str);
        arrayList.add("-d");
        arrayList.add("-v");
        arrayList.add("threadtime");
        arrayList.add("-t");
        if (!z) {
            i2 = (int) (i2 * 1.2d);
        }
        arrayList.add(Integer.toString(i2));
        if (z) {
            arrayList.add("--pid");
            arrayList.add(num);
        }
        arrayList.add("*:" + c2);
        Object[] array = arrayList.toArray();
        sb.append("--------- tail end of log ");
        sb.append(str);
        sb.append(" (");
        sb.append(TextUtils.join(" ", array));
        sb.append(")\n");
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[0]).command(arrayList).start().getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            bufferedReader.close();
                            return;
                        } else if (z || readLine.contains(str2)) {
                            sb.append(readLine);
                            sb.append("\n");
                        }
                    } catch (Exception e) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (IOException e4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).processName.equals(f(context));
        } catch (PackageManager.NameNotFoundException e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        return Build.VERSION.SDK_INT >= 21 ? TextUtils.join(",", Build.SUPPORTED_ABIS) : "unknow";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        try {
            String substring = str.substring(str.indexOf("com.qiniu.pili.droid.shortvideo"));
            return substring.substring(0, substring.indexOf(")") + 1);
        } catch (Exception e) {
            return "unknow";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        a(myPid, sb, "main", 50, 'D');
        a(myPid, sb, "system", 50, 'W');
        a(myPid, sb, com.umeng.analytics.pro.d.f40716ar, 50, 'I');
        sb.append("\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        String str = string;
        if (string == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("plcrash", 0);
            String string2 = sharedPreferences.getString("deviceId", null);
            str = string2;
            if (string2 == null) {
                str = UUID.randomUUID().toString().replaceAll("-", "");
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("deviceId", str);
                edit.apply();
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        if (str == null) {
            return "unknow";
        }
        try {
            String substring = str.substring(str.indexOf(":"));
            return substring.substring(0, substring.indexOf("."));
        } catch (Exception e) {
            return "unknow";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        return deviceConfigurationInfo.reqGlEsVersion != 0 ? String.valueOf(a(deviceConfigurationInfo.reqGlEsVersion)) : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "unknow";
        }
    }

    private static String f(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                do {
                    if (!it.hasNext()) {
                        return "unknow";
                    }
                    next = it.next();
                } while (next.pid != myPid);
                return next.processName;
            }
            return "unknow";
        } catch (Exception e) {
            return "unknow";
        }
    }
}
