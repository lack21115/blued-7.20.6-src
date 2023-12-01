package com.blued.android.framework.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Environment;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import java.io.File;
import java.io.Reader;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/CommonTools.class */
public class CommonTools {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10076a = "blued" + File.separator + "patch";

    public static long a(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String a() {
        String b = b(f10076a);
        String str = b;
        if (TextUtils.isEmpty(b)) {
            str = c(f10076a);
        }
        return str;
    }

    public static void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(Activity activity) {
        return (activity == null || activity == null || activity.isFinishing()) ? false : true;
    }

    public static boolean a(Context context) {
        boolean z;
        ComponentName componentName;
        try {
            z = ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            String packageName = context.getPackageName();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                    try {
                        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                        if (!runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null && componentName.getPackageName().equals(packageName)) {
                            return true;
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static boolean a(Fragment fragment) {
        if (fragment == null || !fragment.isAdded()) {
            return false;
        }
        return a((Activity) fragment.getActivity());
    }

    public static String b(String str) {
        File file;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            file = Environment.getExternalStorageDirectory();
            Log.i("PTH", "downloadDirs parent:" + file);
        } else {
            file = null;
        }
        if (file != null) {
            File file2 = new File(file.getAbsolutePath() + File.separator + str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (file2.canRead() && file2.canWrite()) {
                return file2.getAbsolutePath();
            }
            Log.i("PTH", "sdCard can not read or write:");
            return null;
        }
        return null;
    }

    public static String c(String str) {
        File filesDir = AppInfo.d().getFilesDir();
        if (filesDir != null) {
            File file = new File(filesDir, str);
            if (file.exists() || file.mkdirs()) {
                return file.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x014b, code lost:
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015f, code lost:
        r0.append("filename from UrlConnection: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0173, code lost:
        r0.append(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017c, code lost:
        r10 = r9;
        r11 = r9;
        r12 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0186, code lost:
        android.util.Log.i("PTH", r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01db, code lost:
        if ("".equals(r9) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x021d, code lost:
        if ("".equals(r8) != false) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0214  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.utils.CommonTools.d(java.lang.String):java.lang.String");
    }

    public static long e(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception e) {
            return 0L;
        }
    }
}
