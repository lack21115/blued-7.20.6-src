package com.tencent.beacon.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.android.internal.telephony.PhoneConstants;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.net.b.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/c/e.class */
public class e implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f34942a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f34943c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";

    private e() {
        Context c2 = c.d().c();
        this.b = c2;
        com.tencent.beacon.base.net.b.e.a(c2, this);
        E();
    }

    private void E() {
        this.f = F();
    }

    private String F() {
        String str;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) this.b.getSystemService(Context.CONNECTIVITY_SERVICE);
        } catch (Exception e) {
            com.tencent.beacon.base.util.c.a(e);
            str = "unknown";
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "unknown";
        }
        if (activeNetworkInfo.getType() == 1) {
            str = "wifi";
        } else {
            str = "unknown";
            if (activeNetworkInfo.getType() == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
                str = "unknown";
                if (telephonyManager != null) {
                    int networkType = telephonyManager.getNetworkType();
                    if (networkType != 20) {
                        switch (networkType) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                str = "2G";
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                str = "3G";
                                break;
                            case 13:
                                str = "4G";
                                break;
                            default:
                                StringBuilder sb = new StringBuilder();
                                sb.append("unknown_");
                                sb.append(telephonyManager.getNetworkType());
                                str = sb.toString();
                                break;
                        }
                    } else {
                        str = "5G";
                    }
                }
            }
        }
        com.tencent.beacon.base.util.c.a("[DeviceInfo] NetWork Type:" + str, new Object[0]);
        return str;
    }

    public static e l() {
        if (f34942a == null) {
            synchronized (e.class) {
                try {
                    if (f34942a == null) {
                        f34942a = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f34942a;
    }

    public String A() {
        return "";
    }

    public void B() {
        String string = com.tencent.beacon.a.d.a.a().getString("BEACON_ANDROID_ID_DENGTA", "");
        this.f34943c = string;
        if (TextUtils.isEmpty(string)) {
            this.f34943c = com.tencent.beacon.base.util.b.a();
            a.SharedPreferences$EditorC0895a edit = com.tencent.beacon.a.d.a.a().edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("BEACON_ANDROID_ID_DENGTA", this.f34943c);
            }
        }
    }

    public boolean C() {
        BufferedReader bufferedReader;
        boolean z;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).getInputStream(), Charset.defaultCharset()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        z = false;
                        break;
                    } else if (-1 != readLine.toLowerCase().indexOf("armv7")) {
                        z = true;
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.tencent.beacon.base.util.c.a(th);
                        com.tencent.beacon.base.util.b.a(bufferedReader);
                        return false;
                    } catch (Throwable th2) {
                        com.tencent.beacon.base.util.b.a(bufferedReader);
                        throw th2;
                    }
                }
            }
            com.tencent.beacon.base.util.b.a(bufferedReader);
            return z;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    public String D() {
        if (TextUtils.isEmpty(this.g)) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])) ? "Y" : "N";
                this.g = str;
                return str;
            } catch (Throwable th) {
                this.g = "N";
            }
        }
        return this.g;
    }

    public String a(Context context) {
        try {
            if (Integer.parseInt(Build.VERSION.SDK) < 9) {
                com.tencent.beacon.base.util.c.b("[audit] Api level < 9;return null!", new Object[0]);
                return "";
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append("[audit] get app_last_updated_time:");
            sb.append(String.valueOf(packageInfo.lastUpdateTime));
            com.tencent.beacon.base.util.c.a(sb.toString(), new Object[0]);
            return String.valueOf(packageInfo.lastUpdateTime);
        } catch (Throwable th) {
            com.tencent.beacon.base.util.c.a(th);
            com.tencent.beacon.base.util.c.b("[audit] get app_last_updated_time failed!", new Object[0]);
            return "";
        }
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void a() {
        E();
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void b() {
        E();
    }

    public boolean c() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public String d() {
        return this.f34943c;
    }

    public int e() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).getInputStream(), Charset.forName("UTF-8")));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            int parseInt = readLine != null ? Integer.parseInt(readLine.trim()) / 1000 : 0;
            com.tencent.beacon.base.util.b.a(bufferedReader);
            return parseInt;
        } catch (Throwable th2) {
            th = th2;
            try {
                com.tencent.beacon.base.util.c.a(th);
                com.tencent.beacon.base.util.b.a(bufferedReader);
                return 0;
            } catch (Throwable th3) {
                com.tencent.beacon.base.util.b.a(bufferedReader);
                throw th3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004d, code lost:
        r9 = r0.substring(r0.indexOf(":") + 1).trim();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String f() {
        /*
            r7 = this;
            java.lang.String r0 = ""
            r10 = r0
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L75
            r1 = 2
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L75
            r2 = r1
            r3 = 0
            java.lang.String r4 = "/system/bin/cat"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L75
            r2 = r1
            r3 = 1
            java.lang.String r4 = "/proc/cpuinfo"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L75
            java.lang.Process r0 = r0.exec(r1)     // Catch: java.lang.Throwable -> L75
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L75
            r9 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L75
            r1 = r0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L75
            r3 = r2
            r4 = r9
            java.lang.String r5 = "UTF-8"
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch: java.lang.Throwable -> L75
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L75
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L75
            r11 = r0
        L32:
            r0 = r11
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> L6e
            r12 = r0
            r0 = r10
            r9 = r0
            r0 = r12
            if (r0 == 0) goto L60
            r0 = r12
            java.lang.String r1 = "Processor"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L6e
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L32
            r0 = r12
            r1 = r12
            java.lang.String r2 = ":"
            int r1 = r1.indexOf(r2)     // Catch: java.lang.Throwable -> L6e
            r2 = 1
            int r1 = r1 + r2
            java.lang.String r0 = r0.substring(r1)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L6e
            r9 = r0
        L60:
            r0 = 1
            java.io.Closeable[] r0 = new java.io.Closeable[r0]
            r1 = r0
            r2 = 0
            r3 = r11
            r1[r2] = r3
            com.tencent.beacon.base.util.b.a(r0)
            r0 = r9
            return r0
        L6e:
            r10 = move-exception
            r0 = r11
            r9 = r0
            goto L78
        L75:
            r10 = move-exception
            r0 = 0
            r9 = r0
        L78:
            r0 = r10
            com.tencent.beacon.base.util.c.a(r0)     // Catch: java.lang.Throwable -> L8a
            r0 = 1
            java.io.Closeable[] r0 = new java.io.Closeable[r0]
            r1 = r0
            r2 = 0
            r3 = r9
            r1[r2] = r3
            com.tencent.beacon.base.util.b.a(r0)
            java.lang.String r0 = ""
            return r0
        L8a:
            r10 = move-exception
            r0 = 1
            java.io.Closeable[] r0 = new java.io.Closeable[r0]
            r1 = r0
            r2 = 0
            r3 = r9
            r1[r2] = r3
            com.tencent.beacon.base.util.b.a(r0)
            r0 = r10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.a.c.e.f():java.lang.String");
    }

    public String g() {
        return Locale.getDefault().getCountry();
    }

    public String h() {
        return Build.HARDWARE;
    }

    public DisplayMetrics i() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) this.b.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public long j() {
        ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        }
        return -1L;
    }

    public String k() {
        long j = j();
        if (j > 0) {
            return ((j / 1024) / 1024) + "";
        }
        return "0";
    }

    public boolean m() {
        return com.tencent.beacon.base.util.d.d();
    }

    public String n() {
        return Locale.getDefault().getLanguage();
    }

    public String o() {
        return Build.MANUFACTURER;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(9:(3:5|6|7)|16|17|18|19|20|21|22|23)|9|10|11|12|13|14|15) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:(3:5|6|7)|16|17|18|19|20|21|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a3, code lost:
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a4, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00aa, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ae, code lost:
        com.tencent.beacon.base.util.c.a("getNandInfo error", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b9, code lost:
        com.tencent.beacon.base.util.b.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0100, code lost:
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0106, code lost:
        com.tencent.beacon.base.util.c.a("getNandInfo error", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0111, code lost:
        com.tencent.beacon.base.util.b.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0149, code lost:
        com.tencent.beacon.base.util.b.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0155, code lost:
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x018b, code lost:
        r10 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String p() {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.a.c.e.p():java.lang.String");
    }

    public String q() {
        return this.f;
    }

    public int r() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new d(this));
            if (listFiles == null) {
                return 1;
            }
            return listFiles.length;
        } catch (Exception e) {
            com.tencent.beacon.base.util.c.b("[model] CPU Count: Failed.", new Object[0]);
            com.tencent.beacon.base.util.c.a(e);
            return 1;
        }
    }

    public String s() {
        if (TextUtils.isEmpty(this.d)) {
            String str = "Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK;
            this.d = str;
            com.tencent.beacon.base.util.c.a("[DeviceInfo] os version: %s", str);
            return this.d;
        }
        return this.d;
    }

    public String t() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                            fileReader.close();
                            return null;
                        } catch (Throwable th) {
                            com.tencent.beacon.base.util.c.b("[model] IO close error!", new Object[0]);
                            com.tencent.beacon.base.util.c.a(th);
                            return null;
                        }
                    }
                    String str = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) / 1024) + "";
                    try {
                        bufferedReader.close();
                        fileReader.close();
                        return str;
                    } catch (Throwable th2) {
                        com.tencent.beacon.base.util.c.b("[model] IO close error!", new Object[0]);
                        com.tencent.beacon.base.util.c.a(th2);
                        return str;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        com.tencent.beacon.base.util.c.b("[model] get free RAM error!", new Object[0]);
                        com.tencent.beacon.base.util.c.a(th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th4) {
                                com.tencent.beacon.base.util.c.b("[model] IO close error!", new Object[0]);
                                com.tencent.beacon.base.util.c.a(th4);
                                return null;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                            return null;
                        }
                        return null;
                    } catch (Throwable th5) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th6) {
                                com.tencent.beacon.base.util.c.b("[model] IO close error!", new Object[0]);
                                com.tencent.beacon.base.util.c.a(th6);
                                throw th5;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = null;
            }
        } catch (Throwable th8) {
            th = th8;
            bufferedReader = null;
            fileReader = null;
        }
    }

    public String u() {
        DisplayMetrics i = i();
        if (i == null) {
            return "";
        }
        return i.widthPixels + PhoneConstants.APN_TYPE_ALL + i.heightPixels;
    }

    public String v() {
        ArrayList<String> a2 = com.tencent.beacon.base.util.b.a(new String[]{"/system/bin/sh", "-c", "getprop ro.build.fingerprint"});
        return (a2 == null || a2.size() <= 0) ? "" : a2.get(0);
    }

    public String w() {
        if (TextUtils.isEmpty(this.e)) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            this.e = (((blockCount * blockSize) / 1024) / 1024) + "";
            com.tencent.beacon.base.util.c.a("[DeviceInfo] Rom Size:" + this.e, new Object[0]);
            return this.e;
        }
        return this.e;
    }

    public long x() {
        if (c()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((statFs.getBlockCount() * statFs.getBlockSize()) / 1024) / 1024;
            } catch (Throwable th) {
                com.tencent.beacon.base.util.c.a(th);
                return 0L;
            }
        }
        return 0L;
    }

    public int y() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) this.b.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            double d = displayMetrics.density;
            if (d - 0.75d <= 1.0E-6d) {
                return 120;
            }
            if (d - 1.5d <= 1.0E-6d) {
                return 240;
            }
            if (d - 2.0d <= 1.0E-6d) {
                return 320;
            }
            return d - 3.0d <= 1.0E-6d ? 480 : 160;
        }
        return 160;
    }

    public String z() {
        return "";
    }
}
