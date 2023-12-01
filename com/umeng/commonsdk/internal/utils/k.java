package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/k.class */
public class k {
    public static final String b = "_dsk_s";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27194c = "_thm_z";
    public static final String d = "_gdf_r";

    /* renamed from: a  reason: collision with root package name */
    public static final String f27193a = at.b().b(at.s);
    private static Object e = new Object();

    public static int a(String str, String str2) throws IOException {
        int i;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i = -1;
                break;
            } else if (readLine.contains(str2)) {
                i = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i;
        } catch (InterruptedException e2) {
            return -1;
        }
    }

    public static String a() {
        int i;
        try {
            i = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable th) {
            i = -1;
        }
        return i > 0 ? "thermal_zone" : i < 0 ? "noper" : "unknown";
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f27193a, 0);
            if (sharedPreferences != null) {
                JSONObject jSONObject = new JSONObject();
                synchronized (e) {
                    jSONObject.put(b, sharedPreferences.getString(b, ""));
                    jSONObject.put(f27194c, sharedPreferences.getString(f27194c, ""));
                    jSONObject.put(d, sharedPreferences.getString(d, ""));
                }
                return jSONObject.toString();
            }
            return null;
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static String b() {
        int i;
        try {
            i = a("ls /", "goldfish");
        } catch (Throwable th) {
            i = -1;
        }
        return i > 0 ? "goldfish" : i < 0 ? "noper" : "unknown";
    }

    public static void b(final Context context) {
        if (c(context)) {
            return;
        }
        final String[] strArr = {"unknown", "unknown", "unknown"};
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.k.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = k.c();
                    strArr[1] = k.a();
                    strArr[2] = k.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    k.b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f27193a, 0)) == null) {
            return;
        }
        synchronized (e) {
            sharedPreferences.edit().putString(b, strArr[0]).putString(f27194c, strArr[1]).putString(d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            r0 = 0
            r8 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L72
            r1 = r0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L72
            r3 = r2
            java.lang.String r4 = "/proc/diskstats"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L72
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L72
            r7 = r0
        L13:
            r0 = r7
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> L78
            r8 = r0
            java.lang.String r0 = "mtd"
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L57
            r0 = r8
            java.lang.String r1 = "mmcblk"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L32
            java.lang.String r0 = "mmcblk"
            r9 = r0
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
            goto L68
        L32:
            r0 = r8
            java.lang.String r1 = "sda"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L45
            java.lang.String r0 = "sda"
            r9 = r0
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
            goto L68
        L45:
            r0 = r8
            java.lang.String r1 = "mtd"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L78
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L13
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
            goto L68
        L57:
            java.lang.String r0 = "unknown"
            r9 = r0
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
            goto L68
        L61:
            java.lang.String r0 = "noper"
            r9 = r0
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
        L68:
            r0 = r8
            if (r0 == 0) goto L70
            r0 = r8
            r0.close()     // Catch: java.lang.Throwable -> L7c
        L70:
            r0 = r7
            return r0
        L72:
            r7 = move-exception
            r0 = r8
            r7 = r0
            goto L61
        L78:
            r8 = move-exception
            goto L61
        L7c:
            r8 = move-exception
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.k.c():java.lang.String");
    }

    public static boolean c(Context context) {
        boolean z = false;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f27193a, 0);
            z = false;
            if (sharedPreferences != null) {
                z = false;
                if (!TextUtils.isEmpty(sharedPreferences.getString(b, ""))) {
                    z = true;
                }
            }
        }
        return z;
    }
}
