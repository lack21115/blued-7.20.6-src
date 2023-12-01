package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.cdo.oaps.ad.OapsKey;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/e.class */
public class e implements Thread.UncaughtExceptionHandler {
    private static long b;
    private static String i;
    private final List<FileInputStream> e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f40579a = !e.class.desiredAssertionStatus();

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicBoolean f40580c = new AtomicBoolean(false);
    private static boolean d = false;
    private static long f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static String j = "";
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final ConditionVariable o = new ConditionVariable();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final Object r = new Object();
    private static final ArrayList<String> s = new ArrayList<>();
    private static int t = 0;
    private static String u = null;
    private static boolean v = false;
    private static String w = null;
    private static String x = null;
    private static final Object y = new Object();
    private static final Object z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = "?";
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c((byte) 0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(412);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;
    private static Runnable aa = new com.uc.crashsdk.a.e(407);
    private static final Object ab = new Object();
    private static volatile boolean ac = false;
    private static Object ad = new Object();
    private static ParcelFileDescriptor ae = null;
    private static boolean af = false;
    private static boolean ag = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/e$a.class */
    public static final class a extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final long f40581a;
        private final OutputStream b;

        /* renamed from: c  reason: collision with root package name */
        private int f40582c = 0;
        private int d = 0;
        private boolean e = false;

        a(long j, OutputStream outputStream) {
            this.f40581a = j;
            this.b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r8, int r9, int r10) {
            /*
                r7 = this;
                r0 = r7
                r1 = r7
                int r1 = r1.d
                r2 = r10
                int r1 = r1 + r2
                r0.d = r1
                r0 = r7
                boolean r0 = r0.e
                if (r0 == 0) goto L13
                r0 = 0
                return r0
            L13:
                int r0 = com.uc.crashsdk.g.A()
                r11 = r0
                r0 = r11
                if (r0 <= 0) goto L36
                r0 = r7
                int r0 = r0.f40582c
                r12 = r0
                r0 = r12
                r1 = r10
                int r0 = r0 + r1
                r1 = r11
                if (r0 <= r1) goto L36
                r0 = r11
                r1 = r12
                int r0 = r0 - r1
                r11 = r0
                goto L39
            L36:
                r0 = r10
                r11 = r0
            L39:
                r0 = r7
                r1 = r7
                int r1 = r1.f40582c
                r2 = r11
                int r1 = r1 + r2
                r0.f40582c = r1
                r0 = r7
                long r0 = r0.f40581a
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L5f
                r0 = r7
                java.lang.String r1 = new java.lang.String
                r2 = r1
                r3 = r8
                r4 = r9
                r5 = r11
                r2.<init>(r3, r4, r5)
                r0.b(r1)
                goto L6a
            L5f:
                r0 = r7
                java.io.OutputStream r0 = r0.b
                r1 = r8
                r2 = r9
                r3 = r11
                r0.write(r1, r2, r3)
            L6a:
                r0 = r11
                r1 = r10
                if (r0 >= r1) goto L75
                r0 = r7
                r1 = 1
                r0.e = r1
            L75:
                r0 = r11
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a.a(byte[], int, int):int");
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeClientWriteData(this.f40581a, str);
            }
        }

        final void a() {
            try {
                if (this.d - this.f40582c > 0) {
                    a("\n");
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.f40582c), Integer.valueOf(g.A()), Integer.valueOf(this.d - this.f40582c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        final void a(String str) {
            if (e.h && e.I()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.f40581a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            if (e.h && e.I()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.f40581a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.f40582c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            if (e.h && e.I() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable th) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            if (e.h && e.I()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy((Object) bArr, i, (Object) bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable th) {
                    }
                }
            }
            a(bArr, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/e$b.class */
    public static final class b implements Comparator<File> {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/e$c.class */
    public static final class c extends BroadcastReceiver {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!Intent.ACTION_BATTERY_CHANGED.equals(action)) {
                if (Intent.ACTION_BATTERY_LOW.equals(action) || Intent.ACTION_BATTERY_OKAY.equals(action)) {
                    boolean unused = e.K = Intent.ACTION_BATTERY_LOW.equals(action);
                    e.K();
                    return;
                } else if ("android.intent.action.ANR".equals(action)) {
                    try {
                        e.d(context);
                        return;
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                        return;
                    }
                } else {
                    return;
                }
            }
            int unused2 = e.C = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int unused3 = e.D = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int unused4 = e.E = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
            int unused5 = e.F = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);
            int unused6 = e.G = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            int unused7 = e.H = intent.getIntExtra("status", -1);
            int unused8 = e.I = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
            String unused9 = e.J = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
            if (e.J() >= 2) {
                e.K();
                e.L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/e$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        long f40583a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        int f40584c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private d() {
            this.f40583a = 0L;
            this.b = 0L;
            this.f40584c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    public e() {
        try {
            M();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void A() {
        if (g.q()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), 10000L);
        }
    }

    public static void B() {
        if (ac || com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(408), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(409), 7000L);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void D() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static ParcelFileDescriptor E() {
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (ad) {
            if (ae != null) {
                return ae;
            }
            int cmd = (int) JNIBridge.cmd(14);
            if (cmd == -1) {
                return null;
            }
            ParcelFileDescriptor adoptFd = ParcelFileDescriptor.adoptFd(cmd);
            ae = adoptFd;
            af = true;
            return adoptFd;
        }
    }

    public static boolean F() {
        return ag;
    }

    public static void G() {
        String X2 = g.X();
        File file = new File(X2);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + X2);
            return;
        }
        int length = listFiles.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            File file2 = listFiles[i3];
            if (file2.isFile() && file2.getName().contains("ucebu")) {
                a(false, false);
                return;
            }
            i2 = i3 + 1;
        }
    }

    static /* synthetic */ boolean I() {
        return O();
    }

    static /* synthetic */ int J() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    static /* synthetic */ void K() {
        StringBuilder Y2;
        if (com.uc.crashsdk.b.d && (Y2 = Y()) != null) {
            JNIBridge.set(125, Y2.toString());
        }
        L = true;
        Z();
    }

    static /* synthetic */ int L() {
        M = 0;
        return 0;
    }

    private void M() {
        int I2 = g.I();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= I2) {
                return;
            }
            try {
                this.e.add(new FileInputStream("/dev/null"));
                i2 = i3 + 1;
            } catch (Exception e) {
                com.uc.crashsdk.a.g.a(e);
                return;
            }
        }
    }

    private void N() {
        for (FileInputStream fileInputStream : this.e) {
            com.uc.crashsdk.a.g.a(fileInputStream);
        }
        this.e.clear();
    }

    private static boolean O() {
        if (g.P()) {
            return true;
        }
        return a();
    }

    private static String P() {
        return g.e() + BridgeUtil.UNDERLINE_STR;
    }

    private static String Q() {
        return com.uc.crashsdk.b.B() ? "fg" : OapsKey.KEY_BG;
    }

    private static byte[] R() {
        byte[] bArr;
        byte[] bArr2 = null;
        int i2 = 1024;
        while (true) {
            bArr = bArr2;
            if (bArr != null || i2 <= 0) {
                break;
            }
            try {
                bArr2 = new byte[i2];
            } catch (Throwable th) {
                int i3 = i2 / 2;
                bArr2 = bArr;
                i2 = i3;
                if (i3 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String S() {
        return (!com.uc.crashsdk.b.F() || d) ? LogType.JAVA_TYPE : "ucebujava";
    }

    private static void T() {
        String str;
        BufferedReader bufferedReader;
        FileReader fileReader;
        String str2;
        int i2;
        String str3 = "-";
        try {
            str = Build.HARDWARE;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            str = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 512);
                int i3 = 0;
                String str4 = str3;
                do {
                    try {
                        String readLine = bufferedReader2.readLine();
                        str3 = str4;
                        str2 = str;
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(":") + 1).trim();
                        } else {
                            str3 = str4;
                            str2 = str;
                            i2 = i3;
                            if (readLine.startsWith("Processor")) {
                                str4 = readLine.substring(readLine.indexOf(":") + 1).trim();
                            }
                            str4 = str3;
                            str = str2;
                            i3 = i2;
                        }
                        i2 = i3 + 1;
                        str3 = str4;
                        str2 = str;
                        str4 = str3;
                        str = str2;
                        i3 = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        str3 = str4;
                        bufferedReader = bufferedReader2;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            k = str;
                            l = str3;
                        } catch (Throwable th3) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th3;
                        }
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
                str = str2;
                bufferedReader = bufferedReader2;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        k = str;
        l = str3;
    }

    private static String U() {
        return g.W() + "bytes";
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT < 29;
    }

    private static void W() {
        if (O || com.uc.crashsdk.b.F() || com.uc.crashsdk.b.L()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    private static void X() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(414), 1000L);
    }

    private static StringBuilder Y() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append("\n");
            sb.append("scale: ");
            sb.append(D);
            sb.append("\n");
            switch (F) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append("\n");
            int i2 = G;
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append("\n");
            int i3 = H;
            String str3 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append("\n");
            sb.append("voltage: ");
            sb.append(E);
            sb.append("\n");
            sb.append("temperature: ");
            sb.append(I);
            sb.append("\n");
            sb.append("technology: ");
            sb.append(J);
            sb.append("\n");
            sb.append("battery low: ");
            sb.append(K);
            sb.append("\n");
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Z() {
        if (com.uc.crashsdk.b.f40575c && L && com.uc.crashsdk.a.f40558c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(OutputStream outputStream, String str, int i2) {
        int i3;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String a2 = com.uc.crashsdk.a.b.a(str);
            String str2 = a2;
            if (a2 == null) {
                str2 = "file: '" + str + "' not found or decode failed!";
            }
            int length = str2.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(str2.getBytes("UTF-8"), 0, i2);
                    outputStream.write("\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    a(th, outputStream);
                    i3 = i2;
                    a(outputStream);
                    return i3;
                }
            }
            i3 = i2;
            if (i2 < str2.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(str2.length() - i2)).getBytes("UTF-8"));
                i3 = i2;
            }
        } catch (Throwable th2) {
            th = th2;
            i2 = 0;
        }
        a(outputStream);
        return i3;
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(statFs, new Object[0]);
                if (invoke != null && (invoke instanceof Long)) {
                    return ((Long) invoke).longValue();
                }
            }
        } catch (Throwable th) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object invoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (invoke2 == null || !(invoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) invoke2).intValue();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return 0L;
        }
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable th) {
                int i3 = i2 / 2;
                i2 = i3;
                if (i3 < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i2) {
        try {
            String a2 = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            return com.uc.crashsdk.a.g.b(a2) ? l(a2) : "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    private static String a(File file) {
        String str;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable th) {
            str = null;
        }
        String str2 = str;
        if (com.uc.crashsdk.a.g.a(str)) {
            str2 = file.getPath();
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        int lastIndexOf;
        int indexOf;
        int i2;
        int indexOf2;
        File file;
        byte[] e;
        if (g.x() && (lastIndexOf = str.lastIndexOf(47)) > 0 && (indexOf = str.indexOf(95, lastIndexOf)) > lastIndexOf && (indexOf2 = str.indexOf(95, (i2 = indexOf + 1))) > indexOf) {
            String d2 = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(lastIndexOf + 1, indexOf) + str.substring(i2, indexOf2));
            if (d2 != null && (e = com.uc.crashsdk.a.g.e((file = new File(str)))) != null && e.length > 0) {
                byte[] bArr = null;
                try {
                    bArr = com.uc.crashsdk.a.c.b(e, d2.substring(0, 16).getBytes());
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                }
                if (bArr == null) {
                    return str;
                }
                String str2 = str + ".ec";
                File file2 = new File(str2 + ".tmp");
                if (com.uc.crashsdk.a.g.a(file2, bArr)) {
                    if (file2.renameTo(new File(str2))) {
                        file.delete();
                        return str2;
                    }
                    file2.delete();
                    return str;
                }
                return str;
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0076, code lost:
        if (r0.contains(r7) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:209:0x0662 A[Catch: all -> 0x0704, TryCatch #34 {all -> 0x0704, blocks: (B:171:0x04f6, B:176:0x0515, B:202:0x0635, B:207:0x065c, B:209:0x0662, B:215:0x0684, B:224:0x06ae, B:226:0x06b4, B:232:0x06d6, B:234:0x06db, B:181:0x053d, B:168:0x04ed, B:221:0x0698, B:236:0x06e5, B:211:0x0668, B:228:0x06ba, B:173:0x04fd, B:217:0x0689, B:204:0x0646), top: B:283:0x04ed }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x06b4 A[Catch: all -> 0x0704, TryCatch #34 {all -> 0x0704, blocks: (B:171:0x04f6, B:176:0x0515, B:202:0x0635, B:207:0x065c, B:209:0x0662, B:215:0x0684, B:224:0x06ae, B:226:0x06b4, B:232:0x06d6, B:234:0x06db, B:181:0x053d, B:168:0x04ed, B:221:0x0698, B:236:0x06e5, B:211:0x0668, B:228:0x06ba, B:173:0x04fd, B:217:0x0689, B:204:0x0646), top: B:283:0x04ed }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0737  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x074b  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0755 A[Catch: all -> 0x0769, TRY_LEAVE, TryCatch #20 {all -> 0x0769, blocks: (B:259:0x074f, B:261:0x0755, B:262:0x0760), top: B:306:0x074f }] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0798  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0547 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x051f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.Throwable r11, java.lang.String r12, long r13, boolean r15) {
        /*
            Method dump skipped, instructions count: 1949
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null) {
            i2 = 0;
            if (stackTraceElementArr.length > 0) {
                boolean z2 = str == null;
                int length = stackTraceElementArr.length;
                int i3 = 0;
                int i4 = 0;
                boolean z3 = z2;
                while (i3 < length) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i3];
                    int i5 = i4 + 1;
                    sb.append("  at ");
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                    boolean z4 = z3;
                    int i6 = i5;
                    if (!z3) {
                        z4 = z3;
                        i6 = i5;
                        if (stackTraceElement.getMethodName().contains(str)) {
                            sb.delete(0, sb.length());
                            z4 = true;
                            i6 = 0;
                        }
                    }
                    i3++;
                    z3 = z4;
                    i4 = i6;
                }
                i2 = i4;
            }
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case 401:
                JNIBridge.nativeCmd(10, com.uc.crashsdk.b.I() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.f40558c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Z();
                y();
                return;
            case 402:
                synchronized (Y) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.q()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.e()) {
                        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    } else if (!d(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                        return;
                    } else {
                        int nativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.o(), g.p());
                        if (nativeGenerateUnexpLog != 0) {
                            f.a(11);
                            if ((nativeGenerateUnexpLog & 4352) != 0) {
                                Z = 105;
                                i3 = 30;
                            } else if ((nativeGenerateUnexpLog & 8448) != 0) {
                                Z = 104;
                                i3 = 31;
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                                Z = 106;
                                i3 = 32;
                            } else {
                                if ((nativeGenerateUnexpLog & 1280) != 0) {
                                    Z = 103;
                                    f.a(10);
                                } else if ((nativeGenerateUnexpLog & 2304) != 0) {
                                    Z = 107;
                                    f.a(29);
                                } else {
                                    Z = 102;
                                }
                                a(true);
                            }
                            f.a(i3);
                            a(true);
                        }
                        synchronized (Y) {
                            X = null;
                        }
                        return;
                    }
                }
            case 403:
                ab();
                return;
            case 404:
            default:
                if (!f40579a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                L = false;
                StringBuilder Y2 = Y();
                String g2 = com.uc.crashsdk.b.g();
                if (Y2 != null) {
                    com.uc.crashsdk.a.g.a(new File(g2), Y2.toString());
                    return;
                }
                return;
            case 406:
                if (!f40579a && objArr == null) {
                    throw new AssertionError();
                }
                a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 408:
                synchronized (ab) {
                    if (!ac && g.Q() && com.uc.crashsdk.b.z()) {
                        com.uc.crashsdk.b.s();
                        h.f();
                        f.c();
                        if (com.uc.crashsdk.b.F()) {
                            C();
                        }
                        if (g.Q()) {
                            a(Calendar.getInstance());
                        }
                        ac = true;
                        return;
                    }
                    return;
                }
            case 409:
                d(false);
                return;
            case 410:
                a(false, true);
                return;
            case 411:
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(28, d(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, d(LogType.ANR_TYPE));
                    return;
                }
                return;
            case 412:
                if (!R && com.uc.crashsdk.b.B() && g.M()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                } else if (R) {
                    if (com.uc.crashsdk.b.B() && g.M()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                } else {
                    return;
                }
            case 413:
                JNIBridge.cmd(8);
                return;
            case 414:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i4 = N + 1;
                    N = i4;
                    if (i4 < 10) {
                        X();
                        return;
                    } else if (com.uc.crashsdk.b.d) {
                        JNIBridge.set(130, "(get failed)");
                        return;
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 415:
                if (!f40579a && objArr == null) {
                    throw new AssertionError();
                }
                long longValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= longValue) {
                    h.g();
                    f.a(100);
                    d(true);
                    f.a(true);
                    h.b();
                } else {
                    h.h();
                    h.i();
                    h.c();
                }
                a(calendar);
                break;
            case 416:
                break;
        }
        W();
    }

    public static void a(Context context) {
        try {
            if (V()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", n()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    private static void a(a aVar, String str, long j2) {
        String nativeDumpThreads;
        String str2;
        String str3 = null;
        if (com.uc.crashsdk.b.d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            nativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (ag || nativeDumpThreads == null || nativeDumpThreads.length() >= 512 || !nativeDumpThreads.startsWith(BridgeUtil.SPLIT_MARK) || nativeDumpThreads.indexOf(10) >= 0) {
                str2 = nativeDumpThreads;
            } else {
                if (!new File(nativeDumpThreads).exists()) {
                    str3 = "Can not found " + nativeDumpThreads;
                }
                String str4 = str3;
                str2 = nativeDumpThreads;
                nativeDumpThreads = str4;
            }
        } else {
            nativeDumpThreads = "Native not initialized, skip dump!";
            str2 = null;
        }
        if (nativeDumpThreads != null) {
            try {
                aVar.write(nativeDumpThreads.getBytes("UTF-8"));
                aVar.write("\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str2 != null && !ag) {
            b(aVar, str2, 1048576);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        int i3 = 0;
        h = false;
        try {
            Locale locale = Locale.US;
            int i4 = z2 ? 1 : 0;
            if (z3) {
                i3 = 1;
            }
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", str, str2, Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
        a(outputStream);
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04a9 A[Catch: all -> 0x067d, TRY_ENTER, TryCatch #4 {, blocks: (B:203:0x0672, B:205:0x0677, B:211:0x068f, B:4:0x0011, B:6:0x0018, B:8:0x0030, B:9:0x004f, B:11:0x005b, B:12:0x0077, B:17:0x00ad, B:19:0x00b5, B:20:0x00be, B:22:0x00d0, B:24:0x00e4, B:26:0x0106, B:27:0x010f, B:31:0x012b, B:34:0x0138, B:42:0x0163, B:45:0x0174, B:66:0x02ab, B:72:0x02eb, B:74:0x02f8, B:90:0x0342, B:91:0x0364, B:93:0x036e, B:97:0x0380, B:98:0x0389, B:100:0x03b5, B:101:0x03d3, B:102:0x03d6, B:105:0x03e9, B:107:0x03fa, B:109:0x041d, B:125:0x049b, B:129:0x04a9, B:133:0x04c2, B:137:0x04d0, B:139:0x04e2, B:145:0x0504, B:149:0x0515, B:151:0x0523, B:153:0x054b, B:155:0x0552, B:157:0x0568, B:159:0x0583, B:160:0x0586, B:167:0x05d3, B:158:0x0577, B:164:0x05bd, B:110:0x0423, B:112:0x0429, B:116:0x0436, B:118:0x0440, B:121:0x0469, B:123:0x0473, B:80:0x0317, B:84:0x032b, B:86:0x0333, B:63:0x029f, B:171:0x05ed, B:174:0x05fa, B:177:0x0606, B:180:0x0612, B:183:0x061c, B:186:0x0626, B:187:0x062e, B:190:0x0638, B:193:0x0644, B:196:0x0651, B:199:0x065c, B:200:0x0665), top: B:252:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0523 A[Catch: all -> 0x067d, TRY_LEAVE, TryCatch #4 {, blocks: (B:203:0x0672, B:205:0x0677, B:211:0x068f, B:4:0x0011, B:6:0x0018, B:8:0x0030, B:9:0x004f, B:11:0x005b, B:12:0x0077, B:17:0x00ad, B:19:0x00b5, B:20:0x00be, B:22:0x00d0, B:24:0x00e4, B:26:0x0106, B:27:0x010f, B:31:0x012b, B:34:0x0138, B:42:0x0163, B:45:0x0174, B:66:0x02ab, B:72:0x02eb, B:74:0x02f8, B:90:0x0342, B:91:0x0364, B:93:0x036e, B:97:0x0380, B:98:0x0389, B:100:0x03b5, B:101:0x03d3, B:102:0x03d6, B:105:0x03e9, B:107:0x03fa, B:109:0x041d, B:125:0x049b, B:129:0x04a9, B:133:0x04c2, B:137:0x04d0, B:139:0x04e2, B:145:0x0504, B:149:0x0515, B:151:0x0523, B:153:0x054b, B:155:0x0552, B:157:0x0568, B:159:0x0583, B:160:0x0586, B:167:0x05d3, B:158:0x0577, B:164:0x05bd, B:110:0x0423, B:112:0x0429, B:116:0x0436, B:118:0x0440, B:121:0x0469, B:123:0x0473, B:80:0x0317, B:84:0x032b, B:86:0x0333, B:63:0x029f, B:171:0x05ed, B:174:0x05fa, B:177:0x0606, B:180:0x0612, B:183:0x061c, B:186:0x0626, B:187:0x062e, B:190:0x0638, B:193:0x0644, B:196:0x0651, B:199:0x065c, B:200:0x0665), top: B:252:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x05d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0342 A[Catch: all -> 0x067d, TRY_ENTER, TRY_LEAVE, TryCatch #4 {, blocks: (B:203:0x0672, B:205:0x0677, B:211:0x068f, B:4:0x0011, B:6:0x0018, B:8:0x0030, B:9:0x004f, B:11:0x005b, B:12:0x0077, B:17:0x00ad, B:19:0x00b5, B:20:0x00be, B:22:0x00d0, B:24:0x00e4, B:26:0x0106, B:27:0x010f, B:31:0x012b, B:34:0x0138, B:42:0x0163, B:45:0x0174, B:66:0x02ab, B:72:0x02eb, B:74:0x02f8, B:90:0x0342, B:91:0x0364, B:93:0x036e, B:97:0x0380, B:98:0x0389, B:100:0x03b5, B:101:0x03d3, B:102:0x03d6, B:105:0x03e9, B:107:0x03fa, B:109:0x041d, B:125:0x049b, B:129:0x04a9, B:133:0x04c2, B:137:0x04d0, B:139:0x04e2, B:145:0x0504, B:149:0x0515, B:151:0x0523, B:153:0x054b, B:155:0x0552, B:157:0x0568, B:159:0x0583, B:160:0x0586, B:167:0x05d3, B:158:0x0577, B:164:0x05bd, B:110:0x0423, B:112:0x0429, B:116:0x0436, B:118:0x0440, B:121:0x0469, B:123:0x0473, B:80:0x0317, B:84:0x032b, B:86:0x0333, B:63:0x029f, B:171:0x05ed, B:174:0x05fa, B:177:0x0606, B:180:0x0612, B:183:0x061c, B:186:0x0626, B:187:0x062e, B:190:0x0638, B:193:0x0644, B:196:0x0651, B:199:0x065c, B:200:0x0665), top: B:252:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0364 A[Catch: all -> 0x067d, TRY_ENTER, TRY_LEAVE, TryCatch #4 {, blocks: (B:203:0x0672, B:205:0x0677, B:211:0x068f, B:4:0x0011, B:6:0x0018, B:8:0x0030, B:9:0x004f, B:11:0x005b, B:12:0x0077, B:17:0x00ad, B:19:0x00b5, B:20:0x00be, B:22:0x00d0, B:24:0x00e4, B:26:0x0106, B:27:0x010f, B:31:0x012b, B:34:0x0138, B:42:0x0163, B:45:0x0174, B:66:0x02ab, B:72:0x02eb, B:74:0x02f8, B:90:0x0342, B:91:0x0364, B:93:0x036e, B:97:0x0380, B:98:0x0389, B:100:0x03b5, B:101:0x03d3, B:102:0x03d6, B:105:0x03e9, B:107:0x03fa, B:109:0x041d, B:125:0x049b, B:129:0x04a9, B:133:0x04c2, B:137:0x04d0, B:139:0x04e2, B:145:0x0504, B:149:0x0515, B:151:0x0523, B:153:0x054b, B:155:0x0552, B:157:0x0568, B:159:0x0583, B:160:0x0586, B:167:0x05d3, B:158:0x0577, B:164:0x05bd, B:110:0x0423, B:112:0x0429, B:116:0x0436, B:118:0x0440, B:121:0x0469, B:123:0x0473, B:80:0x0317, B:84:0x032b, B:86:0x0333, B:63:0x029f, B:171:0x05ed, B:174:0x05fa, B:177:0x0606, B:180:0x0612, B:183:0x061c, B:186:0x0626, B:187:0x062e, B:190:0x0638, B:193:0x0644, B:196:0x0651, B:199:0x065c, B:200:0x0665), top: B:252:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 1834
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, boolean, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable th2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    private static void a(Calendar calendar) {
        if (g.S()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            long j3 = 3600000;
            if (j2 <= 3600000) {
                j3 = 1000 + j2;
            }
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(415, new Object[]{Long.valueOf(timeInMillis2)}), j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z2) {
        File[] listFiles;
        int i2;
        int i3;
        try {
            if (com.uc.crashsdk.b.y() && (listFiles = new File(g.X()).listFiles()) != null) {
                int l2 = g.l();
                int m2 = g.m();
                if (listFiles.length < Math.min(l2, m2)) {
                    return;
                }
                int i4 = 0;
                int i5 = 0;
                for (File file : listFiles) {
                    if (b(file)) {
                        i4++;
                    } else {
                        i5++;
                    }
                }
                int i6 = (!z2 || i4 < l2) ? 0 : (i4 - l2) + 1;
                int i7 = (z2 || i5 < m2) ? 0 : (i5 - m2) + 1;
                if (i6 == 0 && i7 == 0) {
                    return;
                }
                Arrays.sort(listFiles, new b((byte) 0));
                int length = listFiles.length;
                int i8 = i6;
                int i9 = i7;
                int i10 = 0;
                while (i10 < length) {
                    File file2 = listFiles[i10];
                    boolean b2 = b(file2);
                    if (!b2 || i8 <= 0) {
                        i2 = i8;
                        i3 = i9;
                        if (!b2) {
                            i2 = i8;
                            i3 = i9;
                            if (i9 > 0) {
                                com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                                file2.delete();
                                i3 = i9 - 1;
                                i2 = i8;
                            }
                        }
                    } else {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i2 = i8 - 1;
                        i3 = i9;
                    }
                    if (i2 == 0 && i3 == 0) {
                        break;
                    }
                    i10++;
                    i8 = i2;
                    i9 = i3;
                }
                f.a(16, i6 + i7);
                if (i6 > 0) {
                    f.a(22, i6);
                }
                if (i7 > 0) {
                    f.a(23, i7);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean a() {
        if (f == 0) {
            f = 2L;
            if (h(com.uc.crashsdk.b.b("logs")) == 1) {
                f = 1L;
            }
        }
        return f == 1;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (af) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        } else if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        } else {
            if (ae != null) {
                com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
            }
            ae = parcelFileDescriptor;
            int fd = parcelFileDescriptor.getFd();
            int nativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
            ag = nativeCmd != -1;
            return fd == -1 || nativeCmd != -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r6, long r7, java.lang.StringBuffer r9, java.lang.String r10, long r11, java.util.ArrayList<java.lang.String> r13, java.util.ArrayList<java.lang.String> r14, java.util.ArrayList<java.lang.String> r15, java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean z2;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        synchronized (p) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    com.uc.crashsdk.a.g.a(e);
                }
            }
            FileChannel fileChannel3 = null;
            z2 = false;
            try {
                try {
                    fileChannel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Throwable th) {
                    th = th;
                    com.uc.crashsdk.a.g.a(fileChannel3);
                    throw th;
                }
            } catch (Exception e2) {
                try {
                    com.uc.crashsdk.a.g.a(e2);
                    fileChannel = null;
                } catch (Exception e3) {
                    e = e3;
                    fileChannel = null;
                    com.uc.crashsdk.a.g.a(e);
                    fileChannel2 = fileChannel;
                    com.uc.crashsdk.a.g.a(fileChannel2);
                    return z2;
                }
            }
            FileLock fileLock = null;
            if (fileChannel != null) {
                try {
                    try {
                        fileLock = fileChannel.lock();
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel3 = fileChannel;
                        com.uc.crashsdk.a.g.a(fileChannel3);
                        throw th;
                    }
                } catch (Exception e4) {
                    z2 = false;
                    try {
                        com.uc.crashsdk.a.g.a(e4);
                        fileLock = null;
                    } catch (Exception e5) {
                        e = e5;
                        com.uc.crashsdk.a.g.a(e);
                        fileChannel2 = fileChannel;
                        com.uc.crashsdk.a.g.a(fileChannel2);
                        return z2;
                    }
                }
            }
            try {
                boolean a2 = eVar.a();
                fileChannel2 = fileChannel;
                z2 = a2;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        fileChannel2 = fileChannel;
                        z2 = a2;
                    } catch (Exception e6) {
                        com.uc.crashsdk.a.g.a(e6);
                        z2 = a2;
                        fileChannel2 = fileChannel;
                    }
                }
                com.uc.crashsdk.a.g.a(fileChannel2);
            } catch (Throwable th3) {
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Exception e7) {
                        com.uc.crashsdk.a.g.a(e7);
                    }
                }
                throw th3;
            }
        }
        return z2;
    }

    private static boolean a(String str, d dVar) {
        String a2 = com.uc.crashsdk.a.g.a(new File(str), 64, false);
        if (a2 == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a2);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    dVar.b = Long.parseLong(matcher.group(2));
                    dVar.f40584c = Integer.parseInt(matcher.group(3));
                    dVar.d = Integer.parseInt(matcher.group(4));
                    dVar.f40583a = parseLong;
                    return true;
                }
                return true;
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str, String str2, boolean z2) {
        if (o(str2)) {
            h.a(str, str2, true, z2);
            com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static boolean a(boolean z2, boolean z3) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private static boolean aa() {
        return com.uc.crashsdk.b.d && JNIBridge.nativeIsCrashing();
    }

    private static void ab() {
        int i2;
        String Y2 = g.Y();
        File file = new File(Y2);
        if (file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    Arrays.sort(listFiles, new b((byte) 0));
                    int length = listFiles.length - 150;
                    if (length < 0) {
                        length = 0;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int i3 = 0;
                    int i4 = 0;
                    boolean z2 = false;
                    while (true) {
                        i2 = i4;
                        if (i3 >= listFiles.length) {
                            break;
                        }
                        File file2 = listFiles[i3];
                        boolean z3 = i3 < length;
                        boolean z4 = z3;
                        if (!z3) {
                            z4 = z3;
                            if (currentTimeMillis - file2.lastModified() >= 432000000) {
                                z4 = true;
                            }
                        }
                        i2 = i4;
                        if (!z4) {
                            break;
                        }
                        file2.delete();
                        i4++;
                        i2 = i4;
                        if (0 >= 3) {
                            break;
                        }
                        i3++;
                        z2 = false;
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i2 + " logs in " + Y2);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        int i4;
        int i5;
        int i6;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] R2 = R();
                if (R2 == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    com.uc.crashsdk.a.g.a((Closeable) null);
                    return 0;
                }
                DataInputStream dataInputStream3 = new DataInputStream(new FileInputStream(file));
                int i7 = 0;
                int i8 = 0;
                loop0: while (true) {
                    boolean z2 = false;
                    while (true) {
                        i6 = i8;
                        dataInputStream = dataInputStream3;
                        try {
                            int read = dataInputStream3.read(R2);
                            i4 = i7;
                            i5 = i8;
                            dataInputStream2 = dataInputStream3;
                            if (read == -1) {
                                break loop0;
                            }
                            int i9 = i7 + read;
                            int i10 = i2 - i8;
                            if (read <= i10 + 32) {
                                i10 = read;
                            }
                            int i11 = i8;
                            if (i10 > 0) {
                                i11 = i8;
                                if (!z2) {
                                    outputStream.write(R2, 0, i10);
                                    i11 = i8 + i10;
                                }
                            }
                            i7 = i9;
                            i8 = i11;
                            if (!z2) {
                                if (i10 >= read) {
                                    i7 = i9;
                                    i8 = i11;
                                    if (i11 < i2) {
                                        break;
                                    }
                                }
                                z2 = true;
                                i7 = i9;
                                i8 = i11;
                            }
                        } catch (Throwable th) {
                            th = th;
                            i3 = i6;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(dataInputStream);
                                a(outputStream);
                                return i3;
                            } catch (Throwable th2) {
                                com.uc.crashsdk.a.g.a(dataInputStream);
                                throw th2;
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream2 = null;
                i4 = 0;
                i5 = 0;
            }
            if (i5 > 0) {
                outputStream.write("\n".getBytes("UTF-8"));
            }
            if (i5 < i4) {
                i6 = i5;
                dataInputStream = dataInputStream2;
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i5)).getBytes("UTF-8"));
            }
            com.uc.crashsdk.a.g.a(dataInputStream2);
            i3 = i5;
        } catch (Throwable th3) {
            th = th3;
            i3 = 0;
            dataInputStream = null;
        }
        a(outputStream);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b() {
        if (g == -1) {
            g = h(com.uc.crashsdk.b.b("local"));
        }
        return g;
    }

    private static String b(String str, boolean z2, boolean z3) {
        String str2 = str;
        if (z2) {
            try {
                str2 = m(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
                str2 = str;
            }
        }
        if (z3) {
            try {
                return a(str2);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        return str2;
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(410), i2 * 1000);
    }

    public static void b(Context context) {
        if (g.M()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
                intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
                intentFilter.addAction(Intent.ACTION_BATTERY_OKAY);
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    private static void b(a aVar) {
        h = false;
        try {
            aVar.write((s("LOG_END") + "\n").getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
        } finally {
            try {
                com.uc.crashsdk.a.g.a(bufferedReader);
                a(outputStream);
            } catch (Throwable th) {
            }
        }
        if (g.n() <= 0) {
            outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
            a(outputStream);
            com.uc.crashsdk.a.g.a((Closeable) null);
            return;
        }
        int n2 = g.n();
        BufferedReader a2 = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.d.f40716ar, "-b", "main", "-v", "threadtime", "-t", String.valueOf(n2)}).getInputStream()));
        if (a2 == null) {
            outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
            a(outputStream);
            com.uc.crashsdk.a.g.a(a2);
            return;
        }
        h = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String readLine = a2.readLine();
            if (readLine == null) {
                break;
            }
            int i4 = i2 + 1;
            i2 = i4;
            if (i3 < n2) {
                i2 = i4;
                if (!readLine.contains(" I auditd ")) {
                    i2 = i4;
                    if (!readLine.contains(" I liblog ")) {
                        outputStream.write(readLine.getBytes("UTF-8"));
                        outputStream.write("\n".getBytes("UTF-8"));
                        i3++;
                        i2 = i4;
                    }
                }
            }
        }
        outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
        h = true;
        bufferedReader = a2;
        com.uc.crashsdk.a.g.a(bufferedReader);
        a(outputStream);
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String str3;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()).getBytes("UTF-8"));
            Locale locale = Locale.US;
            String e = e();
            if (com.uc.crashsdk.a.g.a(l)) {
                T();
            }
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", e, l, f()).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            outputStream.write(String.format(Locale.US, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", a(new Date(b)), Long.valueOf(Runtime.getRuntime().maxMemory()), com.uc.crashsdk.a.g.d(), com.uc.crashsdk.b.B() ? "fg" : OapsKey.KEY_BG).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.T(), g.U(), g.V(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes("UTF-8"));
            String str4 = "0";
            if (com.uc.crashsdk.b.d) {
                str4 = JNIBridge.nativeGet(1, 0L, null);
                str3 = JNIBridge.nativeGet(2, 0L, null);
            } else {
                str3 = "";
            }
            outputStream.write(String.format(Locale.US, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.3.2.2", str4, "211215141717", str3, "release").getBytes("UTF-8"));
            if (str == null) {
                str = "";
            }
            int lastIndexOf = str.lastIndexOf(47);
            outputStream.write(("Report Name: " + str.substring(lastIndexOf + 1) + "\n").getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            outputStream.write(String.format("UUID: %s\n", ag ? s("UUID") : B).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String E2 = com.uc.crashsdk.b.E();
            String str5 = E2;
            if (com.uc.crashsdk.a.g.a(E2)) {
                str5 = "(none)";
            }
            outputStream.write(("Activity: " + str5 + "\n").getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (ag) {
                h = false;
                outputStream.write(s("HEADER").getBytes("UTF-8"));
                h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    public static void b(String str) {
        synchronized (y) {
            x = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + "\n");
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2, boolean z2) {
        h.a(str, str2, false, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z2) {
        try {
            boolean z3 = g.r() && com.uc.crashsdk.b.F() && !d;
            boolean z4 = z3;
            if (!z3) {
                z4 = g.s();
            }
            if (z4) {
                if (!z2) {
                    a(true, false);
                    return;
                }
                String k2 = k();
                if (com.uc.crashsdk.a.g.a(k2)) {
                    return;
                }
                j();
                a(k2, false, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (f40579a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            throw new AssertionError();
        } else if (i2 != 452) {
            if (f40579a) {
                return false;
            }
            throw new AssertionError();
        } else if (f40579a || objArr != null) {
            String str = (String) objArr[0];
            d dVar = (d) objArr[1];
            return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.f40583a), Long.valueOf(dVar.b), Integer.valueOf(dVar.f40584c), Integer.valueOf(dVar.d)).getBytes());
        } else {
            throw new AssertionError();
        }
    }

    private static boolean b(File file) {
        int indexOf;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf > 0 && (indexOf = name.indexOf(46, lastIndexOf)) > 0) {
            String substring = name.substring(lastIndexOf + 1, indexOf);
            return LogType.JAVA_TYPE.equals(substring) || "ucebujava".equals(substring) || LogType.NATIVE_TYPE.equals(substring) || "ucebujni".equals(substring) || LogType.UNEXP_TYPE.equals(substring) || LogType.ANR_TYPE.equals(substring);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        i = null;
    }

    private static void c(OutputStream outputStream) {
        if (com.uc.crashsdk.b.d) {
            String o2 = com.uc.crashsdk.b.o();
            h = false;
            if (1 == JNIBridge.cmd(17, o2)) {
                File file = new File(o2);
                try {
                    byte[] e = com.uc.crashsdk.a.g.e(file);
                    if (e != null) {
                        outputStream.write(e);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        int i2 = 900;
        File[] fileArr = null;
        try {
            int J2 = g.J();
            File[] listFiles = new File("/proc/self/fd").listFiles();
            if (listFiles != null) {
                outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(listFiles.length), Integer.valueOf(J2)).getBytes("UTF-8"));
                fileArr = listFiles;
                i2 = J2;
            } else {
                outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
                fileArr = listFiles;
                i2 = J2;
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        if (fileArr != null) {
            try {
                if (fileArr.length >= i2) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    int length = fileArr.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length) {
                            break;
                        }
                        File file2 = fileArr[i4];
                        sb.append(file2.getName());
                        sb.append(" -> ");
                        sb.append(file2.getCanonicalPath());
                        sb.append("\n");
                        i3 = i4 + 1;
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th4) {
                a(th4, outputStream);
            }
        }
        a(outputStream);
    }

    public static void c(String str) {
        synchronized (z) {
            String l2 = com.uc.crashsdk.b.l();
            com.uc.crashsdk.a.b.a(l2, str + "\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z2) {
        boolean z3;
        if (R) {
            z3 = true;
            if (z2) {
                if (!g.M()) {
                    z3 = true;
                }
                z3 = false;
            }
        } else {
            if (z2 && g.M()) {
                z3 = true;
            }
            z3 = false;
        }
        if (z3) {
            if (com.uc.crashsdk.a.f.b(S)) {
                com.uc.crashsdk.a.f.a(S);
            }
            com.uc.crashsdk.a.f.a(0, S, m.ag);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        String str = i;
        if (str != null) {
            return str;
        }
        String j2 = j(null);
        i = j2;
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(java.io.OutputStream r8) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.d(java.io.OutputStream):void");
    }

    public static void d(boolean z2) {
        f.d(false);
        if (z2) {
            f.a(com.uc.crashsdk.b.c(), false);
            h.i();
            return;
        }
        f.a();
        h.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        boolean z2;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == myPid) {
                O = true;
                if (O()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z2 = true;
            }
        }
        if (z2 || !com.uc.crashsdk.b.d) {
            return true;
        }
        W();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(String str) {
        if (ag) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static int e(boolean z2) {
        return f.a(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011b A[Catch: all -> 0x0163, TRY_ENTER, TryCatch #2 {all -> 0x0163, blocks: (B:40:0x00fa, B:42:0x011b), top: B:76:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017d A[Catch: all -> 0x0225, TryCatch #3 {all -> 0x0225, blocks: (B:51:0x0175, B:53:0x017d, B:55:0x0188, B:57:0x01ce, B:59:0x01d4, B:61:0x01de), top: B:78:0x0175 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d4 A[Catch: all -> 0x0225, TryCatch #3 {all -> 0x0225, blocks: (B:51:0x0175, B:53:0x017d, B:55:0x0188, B:57:0x01ce, B:59:0x01d4, B:61:0x01de), top: B:78:0x0175 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e() {
        /*
            Method dump skipped, instructions count: 571
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00af A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(java.io.OutputStream r8) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e(java.io.OutputStream):void");
    }

    public static boolean e(String str) {
        try {
            if (com.uc.crashsdk.a.g.b(str) && str.startsWith("lib") && str.endsWith(".so")) {
                System.loadLibrary(str.substring(3, str.length() - 3));
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static int f(boolean z2) {
        int b2 = z2 ? f.a(com.uc.crashsdk.b.c()) ? 1 : 0 : f.b();
        int b3 = f.b(z2);
        return b3 > b2 ? b3 : b2;
    }

    public static String f() {
        if (com.uc.crashsdk.a.g.a(k)) {
            T();
        }
        return k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder f(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    private static void f(OutputStream outputStream) {
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", ag ? s("LASTVER") : com.uc.crashsdk.a.m()).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            synchronized (s) {
                if (u != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", u).getBytes("UTF-8"));
                }
                if (t > 0 || s.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(t)).getBytes("UTF-8"));
                    Iterator<String> it = s.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "dumping all threads: %s\n", Boolean.valueOf(v)).getBytes("UTF-8"));
            if (w != null) {
                outputStream.write(String.format(Locale.US, "dumping threads: %s\n", w).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                sb.append("availMem:   ");
                sb.append(memoryInfo.availMem / 1024);
                sb.append(" kB\n");
                sb.append("threshold:  ");
                sb.append(memoryInfo.threshold / 1024);
                sb.append(" kB\n");
                sb.append("lowMemory:  ");
                sb.append(memoryInfo.lowMemory);
                sb.append("\n");
            }
            return sb.toString();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "";
        }
    }

    private static long h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String a2 = a(Process.myPid());
        m = a2;
        return a2;
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable th) {
            return "unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return d;
    }

    private static String j(String str) {
        String str2 = str;
        if (str == null) {
            long currentTimeMillis = System.currentTimeMillis();
            str2 = String.valueOf(currentTimeMillis) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", P(), g.T(), g.V(), i(Build.MODEL), i(Build.VERSION.RELEASE), str2);
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static String k() {
        String a2;
        String str = x;
        if (com.uc.crashsdk.a.g.a(str)) {
            synchronized (y) {
                a2 = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.i(), g.y(), true);
                x = a2;
            }
            return a2;
        }
        return str;
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), n(), Q(), str);
    }

    private static String l(String str) {
        if (com.uc.crashsdk.a.g.b(str)) {
            int indexOf = str.indexOf(0);
            String str2 = str;
            if (indexOf >= 0) {
                str2 = str.substring(0, indexOf);
            }
            return str2.trim();
        }
        return "";
    }

    public static void l() {
        synchronized (y) {
            x = null;
        }
    }

    private static String m(String str) {
        String a2 = com.uc.crashsdk.a.b.a(str, g.w(), g.v());
        if (!str.equals(a2)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a2;
    }

    public static void m() {
        if (ag) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(411), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n() {
        return a(new Date());
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
        if (r5.endsWith(r0) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (r5.indexOf(com.anythink.china.common.a.a.f, r5.lastIndexOf(95)) != r5.lastIndexOf(com.anythink.china.common.a.a.f)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r0 != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean[] n(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.n(java.lang.String):boolean[]");
    }

    public static void o() {
        b = System.currentTimeMillis();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(4:6|7|(3:10|(1:12)(23:13|14|15|(19:59|60|19|(1:58)(1:23)|24|25|26|(1:28)|29|30|31|32|33|34|35|36|37|38|39)(1:17)|18|19|(1:21)|58|24|25|26|(0)|29|30|31|32|33|34|35|36|37|38|39)|8)|64)|31|32|33|34|35|36|37|38|39) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:3|4|(4:6|7|(3:10|(1:12)(23:13|14|15|(19:59|60|19|(1:58)(1:23)|24|25|26|(1:28)|29|30|31|32|33|34|35|36|37|38|39)(1:17)|18|19|(1:21)|58|24|25|26|(0)|29|30|31|32|33|34|35|36|37|38|39)|8)|64)|65|26|(0)|29|30|31|32|33|34|35|36|37|38|39) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x014a, code lost:
        r18 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x014c, code lost:
        r9 = r17;
        r17 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0156, code lost:
        r18 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0160, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0161, code lost:
        r17 = null;
        r18 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0168, code lost:
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x016b, code lost:
        com.uc.crashsdk.a.g.a(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0172, code lost:
        com.uc.crashsdk.a.g.a(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x017b, code lost:
        com.uc.crashsdk.a.g.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0181, code lost:
        throw r17;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0102 A[Catch: all -> 0x0182, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0008, B:6:0x004f, B:8:0x0066, B:10:0x006f, B:12:0x007c, B:13:0x0085, B:16:0x009a, B:19:0x00b1, B:24:0x00c4, B:28:0x0102, B:35:0x0144, B:49:0x0177, B:52:0x017b, B:53:0x0181, B:47:0x0172, B:18:0x00a9), top: B:65:0x0008, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean o(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.o(java.lang.String):boolean");
    }

    public static void p() {
        String str;
        Throwable th;
        String str2;
        if (com.uc.crashsdk.a.g.a(B)) {
            String str3 = null;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(g.W());
                sb.append("unique");
                File file = new File(sb.toString());
                str = null;
                if (file.exists()) {
                    str = com.uc.crashsdk.a.g.a(file, 48, false);
                    try {
                        if (str != null) {
                            try {
                                str = str.length() != 36 ? null : str.replaceAll("[^0-9a-zA-Z-]", "-");
                            } catch (Exception e) {
                                com.uc.crashsdk.a.g.a(e);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.uc.crashsdk.a.g.a(th);
                        str2 = str;
                        B = str2;
                    }
                }
                String str4 = str;
                str2 = str;
                if (com.uc.crashsdk.a.g.a(str)) {
                    String str5 = str;
                    com.uc.crashsdk.b.G();
                    String str6 = str;
                    String uuid = UUID.randomUUID().toString();
                    str2 = uuid;
                    if (!com.uc.crashsdk.a.g.a(uuid)) {
                        str3 = uuid;
                        com.uc.crashsdk.a.g.a(file, uuid.getBytes());
                        str2 = uuid;
                    }
                }
            } catch (Throwable th3) {
                str = str3;
                th = th3;
            }
            B = str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6 A[Catch: all -> 0x0130, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0008, B:7:0x0014, B:8:0x0024, B:8:0x0024, B:9:0x0027, B:11:0x0032, B:13:0x0042, B:49:0x012d, B:39:0x00f8, B:43:0x010c, B:45:0x011d, B:14:0x0049, B:16:0x0055, B:17:0x0065, B:19:0x006f, B:21:0x0079, B:23:0x0083, B:28:0x0094, B:30:0x00a2, B:33:0x00b8, B:35:0x00c6, B:36:0x00d8, B:38:0x00e6), top: B:83:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean p(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.p(java.lang.String):boolean");
    }

    public static String q() {
        return B;
    }

    private static Map<String, Integer> q(String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split("\\|", 30);
        int length = split.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return hashMap;
            }
            String[] split2 = split[i3].split(":", 3);
            if (split2.length == 2) {
                String trim = split2[0].trim();
                if (!com.uc.crashsdk.a.g.a(trim)) {
                    int i4 = 1;
                    try {
                        i4 = Integer.parseInt(split2[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    hashMap.put(trim, Integer.valueOf(i4));
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void r() {
        O = false;
        if (!com.uc.crashsdk.b.B()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (V()) {
            return;
        }
        N = 0;
        X();
    }

    private static void r(String str) {
        if (g.q()) {
            try {
                ab();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(g.Y());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static String s(String str) {
        return String.format("$^%s^$", str);
    }

    public static void s() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    public static void t() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return f40580c.get() || aa();
    }

    public static Throwable v() {
        return U;
    }

    public static int w() {
        if (com.uc.crashsdk.b.I() == 5) {
            return Z;
        }
        return 100;
    }

    public static void x() {
        long o2 = g.o();
        if (o2 < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.I() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(401));
        if (z2) {
            com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(402);
            X = eVar;
            com.uc.crashsdk.a.f.a(0, eVar, o2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void y() {
        if (com.uc.crashsdk.b.f40575c && com.uc.crashsdk.a.f40558c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean z() {
        synchronized (Y) {
            if (X == null || W) {
                return false;
            }
            com.uc.crashsdk.a.f.a(X);
            X = null;
            return true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:163|(3:200|201|(17:205|206|207|166|(1:170)|171|172|173|174|175|(2:177|178)|179|(1:183)|184|(1:188)|190|(2:192|193)(1:194)))|165|166|(2:168|170)|171|172|173|174|175|(0)|179|(2:181|183)|184|(2:186|188)|190|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:217|(3:254|255|(17:259|260|261|220|(1:224)|225|226|228|229|230|(2:232|233)|234|(1:238)|239|(1:243)|245|(2:247|248)(1:249)))|219|220|(2:222|224)|225|226|228|229|230|(0)|234|(2:236|238)|239|(2:241|243)|245|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:77|(3:114|115|(17:119|120|121|80|(1:84)|85|86|88|89|90|(2:92|93)|94|(1:98)|99|(1:103)|105|(2:107|108)(1:109)))|79|80|(2:82|84)|85|86|88|89|90|(0)|94|(2:96|98)|99|(2:101|103)|105|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:449|(1:453)|454|(3:491|492|(17:496|497|498|457|(1:461)|462|463|464|465|466|(2:468|469)|470|(1:474)|475|(1:479)|481|(2:483|484)(1:485)))|456|457|(2:459|461)|462|463|464|465|466|(0)|470|(2:472|474)|475|(2:477|479)|481|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:11|12|(4:15|16|(1:18)|13)|72|19|(3:57|58|(17:62|63|64|22|(1:26)|27|28|30|31|32|(2:34|35)|36|(1:40)|41|(1:45)|47|(2:49|50)(1:52)))|21|22|(2:24|26)|27|28|30|31|32|(0)|36|(2:38|40)|41|(2:43|45)|47|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(22:387|388|389|390|(1:394)|395|(3:432|433|(17:437|438|439|398|(1:402)|403|404|406|407|408|(2:410|411)|412|(1:416)|417|(1:421)|423|(2:425|426)(1:427)))|397|398|(2:400|402)|403|404|406|407|408|(0)|412|(2:414|416)|417|(2:419|421)|423|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(22:571|572|(1:576)|577|(3:614|615|(19:619|620|621|580|(2:582|584)|585|586|588|589|590|(0)|594|(2:596|598)|599|(2:601|603)|605|(0)|608|609))|579|580|(0)|585|586|588|589|590|(0)|594|(0)|599|(0)|605|(0)|608|609) */
    /* JADX WARN: Can't wrap try/catch for region: R(23:508|509|(1:511)|513|514|(1:518)|519|(3:556|557|(17:561|562|563|522|(1:526)|527|528|529|530|531|(2:533|534)|535|(1:539)|540|(1:544)|546|(2:548|549)(1:550)))|521|522|(2:524|526)|527|528|529|530|531|(0)|535|(2:537|539)|540|(2:542|544)|546|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(24:507|508|509|(1:511)|513|514|(1:518)|519|(3:556|557|(17:561|562|563|522|(1:526)|527|528|529|530|531|(2:533|534)|535|(1:539)|540|(1:544)|546|(2:548|549)(1:550)))|521|522|(2:524|526)|527|528|529|530|531|(0)|535|(2:537|539)|540|(2:542|544)|546|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(32:(9:142|143|144|(2:146|147)|631|632|149|150|151)|153|(7:155|156|(1:158)(1:377)|159|160|161|(17:163|(3:200|201|(17:205|206|207|166|(1:170)|171|172|173|174|175|(2:177|178)|179|(1:183)|184|(1:188)|190|(2:192|193)(1:194)))|165|166|(2:168|170)|171|172|173|174|175|(0)|179|(2:181|183)|184|(2:186|188)|190|(0)(0))(2:215|(17:217|(3:254|255|(17:259|260|261|220|(1:224)|225|226|228|229|230|(2:232|233)|234|(1:238)|239|(1:243)|245|(2:247|248)(1:249)))|219|220|(2:222|224)|225|226|228|229|230|(0)|234|(2:236|238)|239|(2:241|243)|245|(0)(0))(1:269)))(6:378|(2:380|381)|382|(1:384)(1:506)|385|(22:387|388|389|390|(1:394)|395|(3:432|433|(17:437|438|439|398|(1:402)|403|404|406|407|408|(2:410|411)|412|(1:416)|417|(1:421)|423|(2:425|426)(1:427)))|397|398|(2:400|402)|403|404|406|407|408|(0)|412|(2:414|416)|417|(2:419|421)|423|(0)(0))(2:447|(19:449|(1:453)|454|(3:491|492|(17:496|497|498|457|(1:461)|462|463|464|465|466|(2:468|469)|470|(1:474)|475|(1:479)|481|(2:483|484)(1:485)))|456|457|(2:459|461)|462|463|464|465|466|(0)|470|(2:472|474)|475|(2:477|479)|481|(0)(0))))|270|271|272|273|274|275|276|277|(32:284|285|286|287|288|289|290|291|292|(3:294|295|296)|297|298|299|300|301|302|303|304|305|306|307|308|309|310|311|312|313|314|315|316|317|318)|319|320|(1:324)|325|(3:362|363|(17:367|368|369|328|(1:332)|333|334|336|337|338|(2:340|341)|342|(1:346)|347|(1:351)|353|(2:355|356)(1:357)))|327|328|(2:330|332)|333|334|336|337|338|(0)|342|(2:344|346)|347|(2:349|351)|353|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01db, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01dc, code lost:
        com.uc.crashsdk.a.g.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x027e, code lost:
        if (r0.equals("") != false) goto L631;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x03a3, code lost:
        r21 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x03a5, code lost:
        com.uc.crashsdk.a.g.a(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x03fc, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x03fd, code lost:
        com.uc.crashsdk.a.g.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x046e, code lost:
        r21 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0470, code lost:
        com.uc.crashsdk.a.g.a(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x04c7, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x04c8, code lost:
        com.uc.crashsdk.a.g.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0588, code lost:
        r21 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x058a, code lost:
        com.uc.crashsdk.a.g.a(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x05e1, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x05e2, code lost:
        com.uc.crashsdk.a.g.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x065a, code lost:
        r21 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x065c, code lost:
        com.uc.crashsdk.a.g.a(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x06b3, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x06b4, code lost:
        com.uc.crashsdk.a.g.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b1, code lost:
        r21 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b3, code lost:
        com.uc.crashsdk.a.g.a(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x0844, code lost:
        r21 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x0846, code lost:
        com.uc.crashsdk.a.g.a(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x089d, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x089e, code lost:
        com.uc.crashsdk.a.g.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x096c, code lost:
        r21 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x096e, code lost:
        com.uc.crashsdk.a.g.a(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x09c5, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x09c6, code lost:
        com.uc.crashsdk.a.g.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:0x0a39, code lost:
        r21 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x0a3b, code lost:
        com.uc.crashsdk.a.g.a(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0a92, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x0a93, code lost:
        com.uc.crashsdk.a.g.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010a, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010b, code lost:
        com.uc.crashsdk.a.g.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0182, code lost:
        r21 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0184, code lost:
        com.uc.crashsdk.a.g.a(r21);
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x030b A[Catch: all -> 0x032c, TRY_ENTER, TryCatch #16 {all -> 0x08b8, blocks: (B:153:0x0333, B:159:0x0350, B:202:0x0412, B:204:0x041b, B:251:0x04ed, B:252:0x04f6, B:254:0x04fc, B:144:0x030b, B:145:0x030e, B:147:0x0314, B:148:0x031b, B:154:0x0336), top: B:580:0x0308 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03d8 A[Catch: all -> 0x03fc, TRY_ENTER, TryCatch #18 {all -> 0x03fc, blocks: (B:181:0x03aa, B:182:0x03ae, B:182:0x03ae, B:186:0x03b6, B:188:0x03d8, B:190:0x03de, B:191:0x03e8, B:191:0x03e8, B:195:0x03f3), top: B:589:0x03aa }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04a3 A[Catch: all -> 0x04c7, TRY_ENTER, TryCatch #29 {all -> 0x04c7, blocks: (B:226:0x0475, B:227:0x0479, B:227:0x0479, B:231:0x0481, B:233:0x04a3, B:235:0x04a9, B:236:0x04b3, B:236:0x04b3, B:240:0x04be), top: B:608:0x0475 }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x05bd A[Catch: all -> 0x05e1, TRY_ENTER, TryCatch #48 {all -> 0x05e1, blocks: (B:288:0x058f, B:289:0x0593, B:289:0x0593, B:293:0x059b, B:295:0x05bd, B:297:0x05c3, B:298:0x05cd, B:298:0x05cd, B:302:0x05d8), top: B:642:0x058f }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x068f A[Catch: all -> 0x06b3, TRY_ENTER, TryCatch #11 {all -> 0x06b3, blocks: (B:338:0x0661, B:339:0x0665, B:339:0x0665, B:343:0x066d, B:345:0x068f, B:347:0x0695, B:348:0x069f, B:348:0x069f, B:352:0x06aa), top: B:578:0x0661 }] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0855  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0879 A[Catch: all -> 0x089d, TRY_ENTER, TryCatch #44 {all -> 0x089d, blocks: (B:439:0x084b, B:440:0x084f, B:440:0x084f, B:444:0x0857, B:446:0x0879, B:448:0x087f, B:449:0x0889, B:449:0x0889, B:453:0x0894), top: B:636:0x084b }] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x088f  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x095c  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x097d  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x09a1 A[Catch: all -> 0x09c5, TRY_ENTER, TryCatch #27 {all -> 0x09c5, blocks: (B:498:0x0973, B:499:0x0977, B:499:0x0977, B:503:0x097f, B:505:0x09a1, B:507:0x09a7, B:508:0x09b1, B:508:0x09b1, B:512:0x09bc), top: B:604:0x0973 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e6 A[Catch: all -> 0x010a, TRY_ENTER, TryCatch #32 {all -> 0x010a, blocks: (B:43:0x00b8, B:44:0x00bc, B:44:0x00bc, B:48:0x00c4, B:50:0x00e6, B:52:0x00ec, B:53:0x00f6, B:53:0x00f6, B:57:0x0101), top: B:614:0x00b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:510:0x09b7  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x09d4  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0a29  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0a4a  */
    /* JADX WARN: Removed duplicated region for block: B:554:0x0a6e A[Catch: all -> 0x0a92, TRY_ENTER, TryCatch #35 {all -> 0x0a92, blocks: (B:547:0x0a40, B:548:0x0a44, B:548:0x0a44, B:552:0x0a4c, B:554:0x0a6e, B:556:0x0a74, B:557:0x0a7e, B:557:0x0a7e, B:561:0x0a89), top: B:620:0x0a40 }] */
    /* JADX WARN: Removed duplicated region for block: B:559:0x0a84  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0aa1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:640:0x07fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:654:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:655:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:656:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:657:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:658:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:659:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:660:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:661:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b7 A[Catch: all -> 0x01db, TRY_ENTER, TryCatch #43 {all -> 0x01db, blocks: (B:90:0x0189, B:91:0x018d, B:91:0x018d, B:95:0x0195, B:97:0x01b7, B:99:0x01bd, B:100:0x01c7, B:100:0x01c7, B:104:0x01d2), top: B:634:0x0189 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Thread r8, java.lang.Throwable r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 2749
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }
}
