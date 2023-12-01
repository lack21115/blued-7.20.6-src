package com.uc.crashsdk;

import android.util.SparseArray;
import com.anythink.expressad.video.module.a.a.m;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f40587a = !f.class.desiredAssertionStatus();
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final SparseArray<String> f40588c = new SparseArray<>();
    private static final Object d = new Object();
    private static boolean e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        File[] d2 = b.d();
        int i = 0;
        if (d2 != null) {
            int length = d2.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                i = i3;
                if (i2 >= length) {
                    break;
                }
                int i4 = i;
                if (a(d2[i2].getAbsolutePath(), false)) {
                    i4 = i + 1;
                }
                i2++;
                i3 = i4;
            }
        }
        return i;
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            return 0;
        }
        int indexOf2 = stringBuffer.indexOf("=", indexOf + str.length());
        if (indexOf2 < 0) {
            com.uc.crashsdk.a.a.b(str + " line not contain '='!");
            return 0;
        }
        int i = indexOf2 + 1;
        int indexOf3 = stringBuffer.indexOf("\n", i);
        int i2 = indexOf3;
        if (indexOf3 < 0) {
            i2 = stringBuffer.length();
        }
        try {
            int parseInt = Integer.parseInt(stringBuffer.substring(i, i2));
            if (parseInt < 0) {
                return 0;
            }
            return parseInt;
        } catch (NumberFormatException e2) {
            com.uc.crashsdk.a.g.a(e2);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(boolean z) {
        int i = 0;
        int i2 = 0;
        if (z) {
            return c(b.e()) ? 1 : 0;
        }
        File[] f = b.f();
        if (f != null) {
            int length = f.length;
            int i3 = 0;
            while (true) {
                i = i3;
                if (i2 >= length) {
                    break;
                }
                int i4 = i;
                if (c(f[i2].getAbsolutePath())) {
                    i4 = i + 1;
                }
                i2++;
                i3 = i4;
            }
        }
        return i;
    }

    private static String a(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        int indexOf = stringBuffer.indexOf("[");
        if (indexOf < 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: Can not found process name start!", null);
            return null;
        }
        int i = indexOf + 1;
        int indexOf2 = stringBuffer.indexOf("]", i);
        if (indexOf2 < 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: Can not found process name end!", null);
            return null;
        }
        String substring = stringBuffer.substring(i, indexOf2);
        if (substring.length() <= 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: process name is empty", null);
            return null;
        }
        return substring;
    }

    private static StringBuffer a(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        if (!file.exists()) {
            return null;
        }
        char[] d2 = d();
        if (d2 == null) {
            com.uc.crashsdk.a.a.a("crashsdk", "readCrashStatData alloc buffer failed!", null);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                fileReader = new FileReader(file);
                try {
                    int read = fileReader.read(d2);
                    if (read > 0) {
                        stringBuffer.append(d2, 0, read);
                    }
                    com.uc.crashsdk.a.g.a(fileReader);
                    return stringBuffer;
                } catch (Exception e2) {
                    e = e2;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileReader);
                    return stringBuffer;
                } catch (Throwable th) {
                    fileReader2 = fileReader;
                    th = th;
                    com.uc.crashsdk.a.g.a(fileReader2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i) {
        a(i, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int i2) {
        if (i2 != 0) {
            a(b.c(), new com.uc.crashsdk.a.e(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            return;
        }
        com.uc.crashsdk.a.a.b("Add stat for type " + i + " with count 0!");
    }

    private static void a(String str, HashMap<String, Integer> hashMap, String str2) {
        if (hashMap.size() <= 0) {
            return;
        }
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: processName is null", null);
        } else if (com.uc.crashsdk.a.g.a(str2)) {
            com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: callbackCacheFilePathName is null", null);
        } else {
            a(str2, new com.uc.crashsdk.a.e(754, new Object[]{str, hashMap, str2}));
        }
    }

    private static void a(StringBuffer stringBuffer, String str, int i) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            if (i > 0) {
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(i);
                stringBuffer.append("\n");
                return;
            }
            return;
        }
        int indexOf2 = stringBuffer.indexOf("\n", indexOf);
        int i2 = indexOf2;
        if (indexOf2 < 0) {
            i2 = stringBuffer.length();
        }
        stringBuffer.replace(indexOf, i2, str + "=" + String.valueOf(i));
    }

    public static boolean a(int i, Object[] objArr) {
        switch (i) {
            case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA /* 751 */:
                if (f40587a || objArr != null) {
                    return b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                }
                throw new AssertionError();
            case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA /* 752 */:
                if (f40587a || objArr != null) {
                    return b((String) objArr[0]);
                }
                throw new AssertionError();
            case 753:
                if (f40587a || objArr != null) {
                    File file = new File((String) objArr[0]);
                    if (file.exists()) {
                        file.delete();
                        return true;
                    }
                    return false;
                }
                throw new AssertionError();
            case 754:
                if (f40587a || objArr != null) {
                    b((String) objArr[0], (HashMap) objArr[1], (String) objArr[2]);
                    return true;
                }
                throw new AssertionError();
            case 755:
                if (f40587a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 756:
                if (f40587a || objArr != null) {
                    File file2 = new File((String) objArr[0]);
                    if (file2.exists()) {
                        file2.delete();
                        return true;
                    }
                    return false;
                }
                throw new AssertionError();
            default:
                return false;
        }
    }

    private static boolean a(File file, StringBuffer stringBuffer) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
                try {
                    String stringBuffer2 = stringBuffer.toString();
                    fileWriter.write(stringBuffer2, 0, stringBuffer2.length());
                    com.uc.crashsdk.a.g.a(fileWriter);
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileWriter2 = fileWriter;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileWriter);
                    return false;
                } catch (Throwable th) {
                    fileWriter2 = fileWriter;
                    th = th;
                    com.uc.crashsdk.a.g.a(fileWriter2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            fileWriter = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return a(str, new com.uc.crashsdk.a.e(753, new Object[]{str}));
    }

    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        return b.a(b, str, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str, boolean z) {
        if (h.a(z, "crash detail report")) {
            return false;
        }
        return a(str, new com.uc.crashsdk.a.e(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, new Object[]{str}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b() {
        File[] d2 = b.d();
        int i = 0;
        int i2 = 0;
        if (d2 != null) {
            int length = d2.length;
            int i3 = 0;
            while (true) {
                i = i3;
                if (i2 >= length) {
                    break;
                }
                int i4 = i;
                if (a(d2[i2].getAbsolutePath())) {
                    i4 = i + 1;
                }
                i2++;
                i3 = i4;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(boolean z) {
        int i = 0;
        int i2 = 0;
        if (z) {
            return e(b.e()) ? 1 : 0;
        }
        File[] f = b.f();
        if (f != null) {
            int length = f.length;
            int i3 = 0;
            while (true) {
                i = i3;
                if (i2 >= length) {
                    break;
                }
                int i4 = i;
                if (e(f[i2].getAbsolutePath())) {
                    i4 = i + 1;
                }
                i2++;
                i3 = i4;
            }
        }
        return i;
    }

    public static void b(int i) {
        if (i != 700) {
            return;
        }
        d(false);
    }

    private static void b(String str, HashMap<String, Integer> hashMap, String str2) {
        try {
            b.x();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuffer a2 = a(file);
            StringBuffer stringBuffer = a2;
            if (com.uc.crashsdk.a.g.a(a2)) {
                stringBuffer = a2;
                if (a2 == null) {
                    stringBuffer = new StringBuffer();
                }
                stringBuffer.append("[");
                stringBuffer.append(str);
                stringBuffer.append("]\n");
            }
            boolean z = false;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                int intValue = entry.getValue().intValue();
                if (intValue > 0) {
                    String key = entry.getKey();
                    a(stringBuffer, key, intValue + a(stringBuffer, key));
                    z = true;
                }
            }
            if (z) {
                a(file, stringBuffer);
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
    }

    private static boolean b(int i, int i2) {
        try {
            b.x();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            String c2 = c(i);
            if (c2 == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stat type not exists: " + i, null);
                return false;
            }
            File file = new File(b.c());
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuffer a2 = a(file);
            StringBuffer stringBuffer = a2;
            if (com.uc.crashsdk.a.g.a(a2)) {
                stringBuffer = a2;
                if (a2 == null) {
                    stringBuffer = new StringBuffer();
                }
                stringBuffer.append("[");
                stringBuffer.append(e.h());
                stringBuffer.append("]\n");
            }
            a(stringBuffer, c2, a(stringBuffer, c2) + i2);
            return a(file, stringBuffer);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return false;
        }
    }

    private static boolean b(String str) {
        boolean z;
        File file = new File(str);
        StringBuffer a2 = a(file);
        if (com.uc.crashsdk.a.g.a(a2)) {
            return false;
        }
        String a3 = a(a2);
        StringBuffer stringBuffer = null;
        if (a3 == null || a3.length() <= 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "reportCrashStatImpl: process name is invalid", null);
            return false;
        }
        SparseArray<String> e2 = e();
        HashMap hashMap = new HashMap();
        boolean O = g.O();
        if (O) {
            stringBuffer = new StringBuffer();
            stringBuffer.append("reportCrashStatImpl: processName: ");
            stringBuffer.append(a3 + "\n");
        }
        int i = 0;
        boolean z2 = false;
        while (true) {
            try {
                z = z2;
                if (i >= e2.size()) {
                    break;
                }
                int keyAt = e2.keyAt(i);
                String str2 = e2.get(keyAt);
                int a4 = a(a2, str2);
                boolean z3 = z;
                if (a4 > 0) {
                    if (O) {
                        stringBuffer.append("name: ");
                        stringBuffer.append(str2);
                        stringBuffer.append(", key: ");
                        stringBuffer.append(keyAt);
                        stringBuffer.append(", count: ");
                        stringBuffer.append(a4);
                        stringBuffer.append("\n");
                    }
                    h.a(a3, keyAt, a4);
                    hashMap.put(str2, Integer.valueOf(a4));
                    a(a2, str2, 0);
                    z3 = true;
                }
                i++;
                z2 = z3;
            } finally {
                if (z) {
                    a(file, a2);
                    if (hashMap.size() > 0) {
                        a(a3, hashMap, b.a(str));
                    }
                }
            }
        }
        if (O) {
            com.uc.crashsdk.a.a.a(stringBuffer.toString());
        }
        return true;
    }

    private static String c(int i) {
        String str;
        f();
        synchronized (f40588c) {
            str = f40588c.get(i);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(700), m.ag);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z) {
        if (g.Q() && !b.L()) {
            e.j();
            if (!h.e()) {
                h.a(z);
            }
            if (b.F()) {
                d(z);
                a(b.c(), z);
                h.b(z);
            }
        }
    }

    private static boolean c(String str) {
        if (!com.uc.crashsdk.a.g.a(str) && new File(str).exists()) {
            return a(str, new com.uc.crashsdk.a.e(755, new Object[]{str}));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e A[Catch: all -> 0x0070, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x000d, B:10:0x0014, B:12:0x0016, B:15:0x0021, B:18:0x0025, B:20:0x002b, B:22:0x0036, B:30:0x005e, B:32:0x0065, B:33:0x006e, B:23:0x003f, B:25:0x0045, B:27:0x0051), top: B:41:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(boolean r3) {
        /*
            boolean r0 = com.uc.crashsdk.f.e
            if (r0 == 0) goto L7
            return
        L7:
            java.lang.Object r0 = com.uc.crashsdk.f.d
            r5 = r0
            r0 = r5
            monitor-enter(r0)
            boolean r0 = com.uc.crashsdk.f.e     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L16
            r0 = r5
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L70
            return
        L16:
            r0 = r3
            java.lang.String r1 = "crash detail"
            boolean r0 = com.uc.crashsdk.a.h.a(r0, r1)     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L23
            r0 = r5
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L70
            return
        L23:
            r0 = 0
            r4 = r0
            boolean r0 = com.uc.crashsdk.b.s()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L3f
            r0 = 2
            r1 = 1
            a(r0, r1)     // Catch: java.lang.Throwable -> L70
            boolean r0 = com.uc.crashsdk.b.r()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L75
            r0 = 42
            r1 = 1
            a(r0, r1)     // Catch: java.lang.Throwable -> L70
            goto L75
        L3f:
            boolean r0 = com.uc.crashsdk.b.t()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L5a
            r0 = 101(0x65, float:1.42E-43)
            r1 = 1
            a(r0, r1)     // Catch: java.lang.Throwable -> L70
            boolean r0 = com.uc.crashsdk.b.r()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L75
            r0 = 43
            r1 = 1
            a(r0, r1)     // Catch: java.lang.Throwable -> L70
            goto L75
        L5a:
            r0 = r4
            if (r0 == 0) goto L63
            r0 = 1
            r1 = 1
            a(r0, r1)     // Catch: java.lang.Throwable -> L70
        L63:
            r0 = 100
            r1 = 1
            a(r0, r1)     // Catch: java.lang.Throwable -> L70
            r0 = 1
            com.uc.crashsdk.f.e = r0     // Catch: java.lang.Throwable -> L70
            r0 = r5
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L70
            return
        L70:
            r6 = move-exception
            r0 = r5
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L70
            r0 = r6
            throw r0
        L75:
            r0 = 1
            r4 = r0
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.d(boolean):void");
    }

    private static boolean d(String str) {
        boolean z;
        if (f40587a || str != null) {
            File file = new File(str);
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                return false;
            }
            String a3 = a(a2);
            StringBuffer stringBuffer = null;
            if (a3 == null || a3.length() <= 0) {
                com.uc.crashsdk.a.a.a("crashsdk", "notifyStatsDetailImpl: process name is invalid", null);
                return false;
            }
            SparseArray<String> e2 = e();
            boolean O = g.O();
            if (O) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("notifyStatsDetailImpl: processName: ");
                stringBuffer.append(a3 + "\n");
            }
            int i = 0;
            boolean z2 = false;
            while (true) {
                try {
                    z = z2;
                    if (i >= e2.size()) {
                        break;
                    }
                    int keyAt = e2.keyAt(i);
                    String str2 = e2.get(keyAt);
                    int a4 = a(a2, str2);
                    boolean z3 = z;
                    if (a4 > 0) {
                        if (O) {
                            stringBuffer.append("name: ");
                            stringBuffer.append(str2);
                            stringBuffer.append(", key: ");
                            stringBuffer.append(keyAt);
                            stringBuffer.append(", count: ");
                            stringBuffer.append(a4);
                            stringBuffer.append("\n");
                        }
                        d.a(a3, keyAt, a4);
                        a(a2, str2, 0);
                        z3 = true;
                    }
                    i++;
                    z2 = z3;
                } finally {
                    if (z) {
                        a(file, a2);
                    }
                }
            }
            if (O) {
                com.uc.crashsdk.a.a.a(stringBuffer.toString());
            }
            if (z) {
                d.a(a3, 1000000, 0);
            }
            return z;
        }
        throw new AssertionError();
    }

    private static char[] d() {
        char[] cArr;
        char[] cArr2 = null;
        int i = 1024;
        while (true) {
            cArr = cArr2;
            if (cArr != null || i <= 0) {
                break;
            }
            try {
                cArr2 = new char[i];
            } catch (Throwable th) {
                int i2 = i / 2;
                cArr2 = cArr;
                i = i2;
                if (i2 < 512) {
                    break;
                }
            }
        }
        return cArr;
    }

    private static SparseArray<String> e() {
        SparseArray<String> m1029clone;
        f();
        synchronized (f40588c) {
            m1029clone = f40588c.m1029clone();
        }
        return m1029clone;
    }

    private static boolean e(String str) {
        if (!com.uc.crashsdk.a.g.a(str) && new File(str).exists()) {
            return a(str, new com.uc.crashsdk.a.e(756, new Object[]{str}));
        }
        return false;
    }

    private static void f() {
        synchronized (f40588c) {
            if (f40588c.size() != 0) {
                return;
            }
            f40588c.put(100, "start_pv");
            f40588c.put(102, "start_hpv");
            f40588c.put(1, "all_all");
            f40588c.put(2, "all_fg");
            f40588c.put(101, "all_bg");
            f40588c.put(3, "java_fg");
            f40588c.put(4, "java_bg");
            f40588c.put(7, "native_fg");
            f40588c.put(8, "native_bg");
            f40588c.put(27, "native_anr_fg");
            f40588c.put(28, "native_anr_bg");
            f40588c.put(9, "native_ok");
            f40588c.put(10, "unexp_anr");
            f40588c.put(29, "unexp_lowmem");
            f40588c.put(30, "unexp_killed");
            f40588c.put(31, "unexp_exit");
            f40588c.put(32, "unexp_restart");
            f40588c.put(11, "unexp_fg");
            f40588c.put(12, "unexp_bg");
            f40588c.put(40, "anr_fg");
            f40588c.put(41, "anr_bg");
            f40588c.put(42, "anr_cr_fg");
            f40588c.put(43, "anr_cr_bg");
            f40588c.put(13, "log_up_succ");
            f40588c.put(14, "log_up_fail");
            f40588c.put(15, "log_empty");
            f40588c.put(200, "log_tmp");
            f40588c.put(16, "log_abd_all");
            f40588c.put(22, "log_abd_builtin");
            f40588c.put(23, "log_abd_custom");
            f40588c.put(17, "log_large");
            f40588c.put(18, "log_up_all");
            f40588c.put(19, "log_up_bytes");
            f40588c.put(20, "log_up_crash");
            f40588c.put(21, "log_up_custom");
            f40588c.put(24, "log_zipped");
            f40588c.put(201, "log_enced");
            f40588c.put(25, "log_renamed");
            f40588c.put(26, "log_safe_skip");
        }
    }
}
