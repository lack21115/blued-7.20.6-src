package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.app.backup.FullBackup;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Process;
import android.util.Log;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/b.class */
public class b {
    static final /* synthetic */ boolean i = !b.class.desiredAssertionStatus();
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String q = null;
    private static String r = null;
    private static String s = null;
    private static String t = null;
    private static String u = null;
    private static String v = null;
    private static String w = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f26883a = false;
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f26884c = false;
    public static boolean d = false;
    public static final Object e = new Object();
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    private static boolean x = false;
    private static boolean y = false;
    private static volatile boolean z = false;
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static final Object G = new Object();
    private static String H = null;
    private static int I = 0;
    private static boolean J = false;
    private static boolean K = false;
    private static boolean L = true;
    private static RandomAccessFile M = null;
    private static boolean N = false;
    private static final Object O = new Object();
    private static String P = null;
    private static boolean Q = false;
    private static volatile Object[] R = null;
    private static Runnable S = new com.uc.crashsdk.a.e(101);
    private static boolean T = false;
    private static long U = 0;
    private static final Object V = new Object();
    private static long W = 0;
    private static boolean X = false;
    private static boolean Y = false;
    private static boolean Z = false;
    private static long aa = 0;
    private static final WeakHashMap<Activity, Integer> ab = new WeakHashMap<>();
    private static boolean ac = false;
    private static String ad = null;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static boolean ai = false;
    private static final Object aj = new Object();
    private static PendingIntent ak = null;

    public static boolean A() {
        return Y || !ad();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B() {
        return Y && !x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C() {
        com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(100));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void D() {
        String str;
        if (!d || (str = ad) == null) {
            return;
        }
        JNIBridge.set(129, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String E() {
        String str = ad;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public static boolean F() {
        if (!ae) {
            if (!com.uc.crashsdk.a.g.a(a.f26866a) && a.f26866a.equals(e.h())) {
                af = true;
                if (d) {
                    JNIBridge.set(2, true);
                }
            }
            ae = true;
        }
        return af;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void G() {
        ag = true;
        if (d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean H() {
        return ag;
    }

    public static int I() {
        boolean U2 = U();
        return t() ? U2 ? 3 : 6 : s() ? U2 ? 2 : 5 : U2 ? 4 : 1;
    }

    public static int J() {
        boolean V2 = V();
        boolean W2 = W();
        boolean X2 = X();
        if (t()) {
            if (V2) {
                return 12;
            }
            if (W2) {
                return 14;
            }
            return X2 ? 16 : 98;
        } else if (s()) {
            if (V2) {
                return 11;
            }
            if (W2) {
                return 13;
            }
            return X2 ? 15 : 97;
        } else {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void K() {
        if (d) {
            JNIBridge.nativeSet(27, I, "12", null);
            JNIBridge.set(30, L);
        }
    }

    public static boolean L() {
        if (!ai) {
            synchronized (aj) {
                if (!ai) {
                    ah = ae();
                    ai = true;
                }
            }
        }
        return ah;
    }

    public static void M() {
        if (e.F() || L() || ak != null || g.h() < 0) {
            return;
        }
        try {
            Context a2 = com.uc.crashsdk.a.g.a();
            Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(a2.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            ak = PendingIntent.getActivity(a2, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean N() {
        if (ak == null) {
            com.uc.crashsdk.a.a.b("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.a.a("crashsdk", "restarting ...");
            ((AlarmManager) com.uc.crashsdk.a.g.a().getSystemService("alarm")).set(1, System.currentTimeMillis() + 200, ak);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean O() {
        ac = true;
        return true;
    }

    private static String Q() {
        if (j == null) {
            j = d(com.anythink.expressad.foundation.g.a.ac);
        }
        return j;
    }

    private static String R() {
        if (l == null) {
            l = d("ctn");
        }
        return l;
    }

    private static String S() {
        if (m == null) {
            m = d("cta");
        }
        return m;
    }

    private static void T() {
        if (z || y) {
            return;
        }
        synchronized (G) {
            if (z) {
                return;
            }
            f(g.W());
            String p2 = p();
            File file = new File(b());
            File file2 = new File(R());
            A = FullBackup.DATA_TREE_TOKEN.equals(p2);
            B = "b".equals(p2);
            D = file.exists();
            boolean exists = file2.exists();
            E = exists;
            boolean z2 = D || exists;
            C = z2;
            if (!z2 && (A || B)) {
                boolean r2 = r();
                F = r2;
                C = r2;
            }
            if (z()) {
                Z();
            }
            z = true;
        }
    }

    private static boolean U() {
        T();
        return C;
    }

    private static boolean V() {
        T();
        return D;
    }

    private static boolean W() {
        T();
        return E;
    }

    private static boolean X() {
        T();
        return F;
    }

    private static void Y() {
        if (d) {
            JNIBridge.set(26, x);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0057 -> B:28:0x005b). Please submit an issue!!! */
    private static void Z() {
        if (!T) {
            T = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            try {
                new File(R()).delete();
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            try {
                if (d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(S()).delete();
                }
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
        }
        Object[] ab2 = ab();
        if (!ab2[0].equals(P) && R == null) {
            a(ab2);
            return;
        }
        Q = true;
        aa();
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        Class<?> cls2 = cls;
        if (cls == null) {
            cls2 = obj.getClass();
        }
        try {
            Field declaredField = cls2.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        String str = H;
        if (str != null) {
            return str;
        }
        String h2 = e.h();
        if (com.uc.crashsdk.a.g.a(h2)) {
            H = "LLUN";
        } else {
            int i2 = 0;
            String str2 = h2;
            if (h2.length() > 48) {
                int length = h2.length();
                str2 = h2.substring(0, 48);
                i2 = length - 48;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = str2.getBytes();
            int length2 = bytes.length;
            while (true) {
                int i3 = length2 - 1;
                if (i3 < 0) {
                    break;
                }
                byte b2 = bytes[i3];
                if (b2 == 46) {
                    sb.append('0');
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) ((b2 + 65) - 97));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 < 48 || b2 > 57) {
                    sb.append('2');
                } else {
                    sb.append((char) b2);
                }
                length2 = i3;
            }
            if (i2 > 0) {
                sb.append(String.valueOf(i2));
            }
            H = sb.toString();
        }
        return H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".st");
        if (i || lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            if (substring.length() <= 0) {
                return null;
            }
            return substring + ".stcb";
        }
        throw new AssertionError();
    }

    public static void a(int i2) {
        Object a2;
        int i3;
        boolean z2 = true;
        switch (i2) {
            case 100:
                Object ac2 = ac();
                if (ac2 == null || (a2 = a(ac2, (Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    boolean z3 = false;
                    boolean z4 = false;
                    for (Map.Entry entry : ((Map) a2).entrySet()) {
                        Object value = entry.getValue();
                        boolean z5 = z3;
                        if (value != null) {
                            Activity activity = (Activity) a(value, (Class<?>) null, "activity");
                            z5 = z3;
                            if (activity != null) {
                                boolean booleanValue = ((Boolean) a(value, (Class<?>) null, "paused")).booleanValue();
                                boolean booleanValue2 = ((Boolean) a(value, (Class<?>) null, "stopped")).booleanValue();
                                synchronized (ab) {
                                    if (booleanValue || booleanValue2) {
                                        i3 = 2;
                                    } else {
                                        i3 = 1;
                                        z3 = true;
                                    }
                                    ab.put(activity, Integer.valueOf(i3));
                                }
                                z5 = z3;
                            }
                        }
                        z4 = true;
                        z3 = z5;
                    }
                    if (z4) {
                        b(z3);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 101:
                try {
                    if (new File(Q()).exists()) {
                        z2 = false;
                    }
                    N = z2;
                    if (z2 || Q) {
                        a(ab());
                        Q = false;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                    return;
                }
            case 102:
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(103));
                return;
            case 103:
                try {
                    com.uc.crashsdk.a.g.a(new File(S()));
                    return;
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 104:
                h.d();
                f.a(102);
                if (F()) {
                    e.C();
                    return;
                }
                return;
            default:
                if (!i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    public static void a(boolean z2) {
        L = z2;
        if (d) {
            JNIBridge.set(30, z2);
        }
    }

    private static void a(Object[] objArr) {
        R = objArr;
        synchronized (O) {
            String str = (String) objArr[0];
            long longValue = ((Long) objArr[1]).longValue();
            if (longValue < U) {
                com.uc.crashsdk.a.a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(longValue), Long.valueOf(U)));
                return;
            }
            U = longValue;
            String Q2 = Q();
            if (d) {
                if (M != null) {
                    com.uc.crashsdk.a.g.a(M);
                    M = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(Q2, str, N);
                N = false;
                if (!nativeChangeState) {
                    com.uc.crashsdk.a.a.b("write state failed: " + str);
                }
            } else {
                if (M == null || N) {
                    if (M != null) {
                        com.uc.crashsdk.a.g.a(M);
                        M = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(Q2, "rw");
                        M = randomAccessFile;
                        randomAccessFile.seek(0L);
                        N = false;
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
                try {
                    M.write(str.getBytes());
                    M.seek(0L);
                } catch (Exception e3) {
                    com.uc.crashsdk.a.g.a(e3);
                }
            }
            P = str;
            R = null;
        }
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (g.L()) {
                C();
                return true;
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static boolean a(Object obj, String str, com.uc.crashsdk.a.e eVar) {
        FileChannel fileChannel;
        synchronized (obj) {
            boolean z2 = false;
            if (d) {
                int nativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (nativeOpenFile < 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                boolean nativeLockFile = JNIBridge.nativeLockFile(nativeOpenFile, true);
                z2 = eVar.a();
                if (nativeLockFile) {
                    JNIBridge.nativeLockFile(nativeOpenFile, false);
                }
                JNIBridge.nativeCloseFile(nativeOpenFile);
            } else {
                File file = new File(str);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
                FileChannel fileChannel2 = null;
                try {
                    try {
                        fileChannel2 = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        com.uc.crashsdk.a.g.a(fileChannel2);
                        throw th;
                    }
                } catch (Exception e3) {
                    try {
                        com.uc.crashsdk.a.g.a(e3);
                        fileChannel2 = null;
                    } catch (Exception e4) {
                        e = e4;
                        fileChannel = null;
                        fileChannel2 = fileChannel;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(fileChannel);
                        return z2;
                    }
                }
                FileLock fileLock = null;
                if (fileChannel2 != null) {
                    try {
                        try {
                            fileLock = fileChannel2.lock();
                        } catch (Throwable th2) {
                            th = th2;
                            com.uc.crashsdk.a.g.a(fileChannel2);
                            throw th;
                        }
                    } catch (Exception e5) {
                        z2 = false;
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                            fileLock = null;
                        } catch (Exception e6) {
                            e = e6;
                            fileChannel = fileChannel2;
                            fileChannel2 = fileChannel;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel);
                            return z2;
                        }
                    }
                }
                try {
                    boolean a2 = eVar.a();
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception e7) {
                            com.uc.crashsdk.a.g.a(e7);
                        }
                    }
                    com.uc.crashsdk.a.g.a(fileChannel2);
                    z2 = a2;
                } catch (Throwable th3) {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception e8) {
                            com.uc.crashsdk.a.g.a(e8);
                        }
                    }
                    throw th3;
                }
            }
            return z2;
        }
    }

    private static void aa() {
        if (!com.uc.crashsdk.a.f.b(S)) {
            com.uc.crashsdk.a.f.a(1, S);
            return;
        }
        Object[] objArr = R;
        if (objArr == null || !ab()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.f.a(S);
            com.uc.crashsdk.a.f.a(1, S);
        }
    }

    private static Object[] ab() {
        synchronized (V) {
            long j2 = W + 1;
            W = j2;
            if (x) {
                return new Object[]{"e", Long.valueOf(j2)};
            }
            if (B()) {
                return new Object[]{FullBackup.DATA_TREE_TOKEN, Long.valueOf(W)};
            }
            return new Object[]{"b", Long.valueOf(W)};
        }
    }

    private static Object ac() {
        Method declaredMethod;
        Object a2;
        Object a3 = a((Application) com.uc.crashsdk.a.g.a(), Application.class, "mLoadedApk");
        if (a3 == null || (a2 = a(a3, (Class<?>) null, "mActivityThread")) == null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                if (cls == null || (declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0])) == null) {
                    return null;
                }
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
                return null;
            }
        }
        return a2;
    }

    private static boolean ad() {
        String a2 = com.uc.crashsdk.a.g.a(new File("/proc/self/cgroup"), 512, false);
        if (com.uc.crashsdk.a.g.a(a2)) {
            return false;
        }
        return a2.contains("/bg_non_interactive") || a2.contains("/background");
    }

    private static boolean ae() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        int myUid = Process.myUid() % 100000;
        return myUid >= 99000 && myUid <= 99999;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        if (k == null) {
            k = d("ctj");
        }
        return k;
    }

    public static String b(String str) {
        return "debug.crs." + str;
    }

    public static void b(int i2) {
        I = i2;
        K();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
        if ((r0 - r6) > com.uc.crashsdk.g.h()) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r5) {
        /*
            java.lang.String r0 = "Restart APP"
            com.uc.crashsdk.a.a.a(r0)
            r0 = r5
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.String r0 = com.uc.crashsdk.b.p
            if (r0 != 0) goto L1a
            java.lang.String r0 = "rt"
            java.lang.String r0 = d(r0)
            com.uc.crashsdk.b.p = r0
        L1a:
            java.io.File r0 = new java.io.File
            r1 = r0
            java.lang.String r2 = com.uc.crashsdk.b.p
            r1.<init>(r2)
            r5 = r0
            r0 = -1
            r6 = r0
            r0 = r5
            java.lang.String r0 = com.uc.crashsdk.a.g.d(r0)     // Catch: java.lang.Throwable -> L36
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L36
            r8 = r0
            r0 = r8
            r6 = r0
            goto L3d
        L36:
            r12 = move-exception
            r0 = r12
            com.uc.crashsdk.a.g.a(r0)
        L3d:
            r0 = 0
            r11 = r0
            long r0 = java.lang.System.currentTimeMillis()
            r1 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r1
            r8 = r0
            r0 = r11
            r10 = r0
            int r0 = com.uc.crashsdk.g.h()
            if (r0 < 0) goto L7a
            r0 = r6
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L67
            r0 = r11
            r10 = r0
            r0 = r8
            r1 = r6
            long r0 = r0 - r1
            int r1 = com.uc.crashsdk.g.h()
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L7a
        L67:
            java.lang.String r0 = com.uc.crashsdk.g.W()
            boolean r0 = f(r0)
            r0 = r5
            r1 = r8
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r0 = com.uc.crashsdk.a.g.a(r0, r1)
            r0 = 1
            r10 = r0
        L7a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "lastTime: "
            r1.<init>(r2)
            r5 = r0
            r0 = r5
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r1 = ", currentTime: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r1 = ", needRestart: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r0 = r0.toString()
            com.uc.crashsdk.a.a.a(r0)
            r0 = r10
            if (r0 != 0) goto Lb5
            return
        Lb5:
            r0 = 1
            com.uc.crashsdk.d.a(r0)     // Catch: java.lang.Throwable -> Lbc
            goto Lc1
        Lbc:
            r5 = move-exception
            r0 = r5
            com.uc.crashsdk.a.g.a(r0)
        Lc1:
            boolean r0 = N()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.b.b(android.content.Context):void");
    }

    public static void b(boolean z2) {
        if (e.u()) {
            return;
        }
        if (z2 && x) {
            if (g.O()) {
                Log.v("crashsdk", "setForeground, reset sExited to false!!!");
            }
            x = false;
            Y();
        }
        boolean z3 = e.F() || L();
        long currentTimeMillis = System.currentTimeMillis();
        if (X && !Y && z2) {
            long j2 = aa;
            if (j2 != 0 && !z3 && currentTimeMillis - j2 > 1800000) {
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(104), 1000L);
            }
        }
        aa = currentTimeMillis;
        Y = z2;
        if (z2) {
            X = true;
        }
        if (d) {
            JNIBridge.nativeSetForeground(z2);
        }
        if (x || z3) {
            return;
        }
        T();
        Z();
        if (z2) {
            a.a(false);
            if (!Z) {
                e.B();
                Z = true;
            }
        }
        if (!N) {
            aa();
        }
        e.c(z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        if (n == null) {
            n = d("st");
        }
        return n;
    }

    public static boolean c(int i2) {
        return (i2 & I) != 0;
    }

    private static String d(String str) {
        return g.W() + a() + "." + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File[] d() {
        return e(".st");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e() {
        if (o == null) {
            o = d("stcb");
        }
        return o;
    }

    private static File[] e(String str) {
        if (!i && str.length() <= 0) {
            throw new AssertionError();
        }
        File[] listFiles = new File(g.W()).listFiles();
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = listFiles.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return (File[]) arrayList.toArray(new File[arrayList.size()]);
            }
            File file = listFiles[i3];
            if (file.getPath().endsWith(str)) {
                arrayList.add(file);
            }
            i2 = i3 + 1;
        }
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (file.delete()) {
            file.mkdirs();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File[] f() {
        return e(".stcb");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        if (v == null) {
            v = d("bati");
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        if (w == null) {
            w = d(Camera.Parameters.SCENE_MODE_HDR);
        }
        return w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i() {
        if (q == null) {
            q = g.W() + "up";
        }
        return q;
    }

    public static String j() {
        if (r == null) {
            r = g.W() + "authu";
        }
        return r;
    }

    public static String k() {
        if (s == null) {
            s = g.W() + "statu";
        }
        return s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l() {
        if (t == null) {
            t = g.W() + "poli";
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        if (u == null) {
            u = g.W() + "ver";
        }
        return u;
    }

    public static String n() {
        return g.W() + "bvu";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String o() {
        return g.W() + "fds";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p() {
        return com.uc.crashsdk.a.g.a(new File(Q()), 8, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q() {
        return y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r() {
        if (!J) {
            if (d) {
                K = JNIBridge.cmd(15) == 1;
            } else {
                K = new File(S()).exists();
            }
            J = true;
        }
        return K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s() {
        T();
        return A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t() {
        T();
        return B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return x;
    }

    public static void v() {
        boolean z2;
        f(g.W());
        y = true;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        File[] listFiles = new File(g.W()).listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                File file = listFiles[i3];
                String name = file.getName();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= 7) {
                        z2 = false;
                        break;
                    } else if (name.endsWith(new String[]{".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"}[i5])) {
                        z2 = true;
                        break;
                    } else {
                        i4 = i5 + 1;
                    }
                }
                boolean z3 = z2;
                if (!z2) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        z3 = z2;
                        if (i7 >= 4) {
                            break;
                        } else if (name.equals(new String[]{"up", "authu", "statu", "poli"}[i7])) {
                            z3 = true;
                            break;
                        } else {
                            i6 = i7 + 1;
                        }
                    }
                }
                if (z3) {
                    com.uc.crashsdk.a.a.a("crashsdk", "delete file: " + file.getPath());
                    com.uc.crashsdk.a.g.a(file);
                }
                i2 = i3 + 1;
            }
        }
        Z();
    }

    public static void w() {
        if (x) {
            return;
        }
        x = true;
        if (L() || e.u()) {
            return;
        }
        f(g.W());
        Y();
        Z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean x() {
        return f(g.W());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean y() {
        return f(g.X());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean z() {
        return X || !ad();
    }
}
