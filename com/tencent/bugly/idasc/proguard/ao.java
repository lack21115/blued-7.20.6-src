package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.os.Process;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ao.class */
public final class ao {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35242a = true;
    public static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static SimpleDateFormat f35243c;
    private static int d = 30720;
    private static StringBuilder e;
    private static StringBuilder f;
    private static boolean g = false;
    private static a h;
    private static String i;
    private static String j;
    private static Context k;
    private static String l;
    private static boolean m = false;
    private static boolean n = false;
    private static ExecutorService o;
    private static int p;
    private static final Object q = new Object();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ao$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f35248a;
        File b;

        /* renamed from: c  reason: collision with root package name */
        long f35249c = 30720;
        private String d;
        private long e;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.d = str;
            this.f35248a = a();
        }

        final boolean a() {
            try {
                File file = new File(this.d);
                this.b = file;
                if (file.exists() && !this.b.delete()) {
                    this.f35248a = false;
                    return false;
                } else if (this.b.createNewFile()) {
                    return true;
                } else {
                    this.f35248a = false;
                    return false;
                }
            } catch (Throwable th) {
                al.a(th);
                this.f35248a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2;
            byte[] bytes;
            if (this.f35248a) {
                try {
                    fileOutputStream2 = new FileOutputStream(this.b, true);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    fileOutputStream2.write(str.getBytes("UTF-8"));
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.e += bytes.length;
                    this.f35248a = true;
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e) {
                        return true;
                    }
                } catch (Throwable th2) {
                    fileOutputStream = fileOutputStream2;
                    th = th2;
                    try {
                        al.a(th);
                        this.f35248a = false;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (IOException e2) {
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
            return false;
        }
    }

    static {
        try {
            f35243c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            al.b(th.getCause());
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        e.setLength(0);
        String str4 = str3;
        if (str3.length() > 30720) {
            str4 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f35243c;
        String format = simpleDateFormat != null ? simpleDateFormat.format(date) : date.toString();
        StringBuilder sb = e;
        sb.append(format);
        sb.append(" ");
        sb.append(p);
        sb.append(" ");
        sb.append(j2);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str4);
        sb.append("\u0001\r\n");
        return e.toString();
    }

    public static void a(int i2) {
        synchronized (q) {
            d = i2;
            if (i2 < 0) {
                d = 0;
            } else if (i2 > 30720) {
                d = 30720;
            }
        }
    }

    public static void a(Context context) {
        synchronized (ao.class) {
            try {
                if (m || context == null || !b) {
                    return;
                }
                try {
                    o = Executors.newSingleThreadExecutor();
                    f = new StringBuilder(0);
                    e = new StringBuilder(0);
                    k = context;
                    aa a2 = aa.a(context);
                    i = a2.d;
                    a2.getClass();
                    j = "";
                    l = k.getFilesDir().getPath() + "/buglylog_" + i + BridgeUtil.UNDERLINE_STR + j + ".txt";
                    p = Process.myPid();
                } catch (Throwable th) {
                }
                m = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(final String str, final String str2, final String str3) {
        synchronized (ao.class) {
            try {
                if (m && b) {
                    if (n) {
                        o.execute(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ao.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ao.d(String.this, str2, str3);
                            }
                        });
                    } else {
                        o.execute(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ao.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                ao.e(String.this, str2, str3);
                            }
                        });
                    }
                }
            } catch (Exception e2) {
                al.b(e2);
            } finally {
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        String str3 = message;
        if (message == null) {
            str3 = "";
        }
        a(str, str2, str3 + '\n' + ap.b(th));
    }

    public static byte[] a() {
        if (f35242a) {
            if (b) {
                return ap.a(f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return c();
    }

    private static String b() {
        try {
            aa b2 = aa.b();
            if (b2 == null || b2.N == null) {
                return null;
            }
            return b2.N.getLogFromNative();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c() {
        if (b) {
            if (n) {
                al.a("[LogUtil] Get user log from native.", new Object[0]);
                String b2 = b();
                if (b2 != null) {
                    al.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(b2.length()));
                    return ap.a(b2, "BuglyNativeLog.txt");
                }
            }
            StringBuilder sb = new StringBuilder();
            synchronized (q) {
                if (h != null && h.f35248a && h.b != null && h.b.length() > 0) {
                    sb.append(ap.a(h.b, 30720, true));
                }
                if (f != null && f.length() > 0) {
                    sb.append(f.toString());
                }
            }
            return ap.a(sb.toString(), "BuglyLog.txt");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, String str2, String str3) {
        try {
            aa b2 = aa.b();
            if (b2 == null || b2.N == null) {
                return false;
            }
            return b2.N.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str, String str2, String str3) {
        synchronized (ao.class) {
            try {
                if (f35242a) {
                    f(str, str2, str3);
                } else {
                    g(str, str2, str3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void f(String str, String str2, String str3) {
        synchronized (ao.class) {
            try {
                String a2 = a(str, str2, str3, Process.myTid());
                synchronized (q) {
                    f.append(a2);
                    if (f.length() >= d) {
                        f = f.delete(0, f.indexOf("\u0001\r\n") + 1);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void g(String str, String str2, String str3) {
        synchronized (ao.class) {
            try {
                String a2 = a(str, str2, str3, Process.myTid());
                synchronized (q) {
                    try {
                        f.append(a2);
                    } catch (Throwable th) {
                    }
                    if (f.length() <= d) {
                        return;
                    }
                    if (g) {
                        return;
                    }
                    g = true;
                    if (h == null) {
                        h = new a(l);
                    } else if (h.b == null || h.b.length() + f.length() > h.f35249c) {
                        h.a();
                    }
                    if (h.a(f.toString())) {
                        f.setLength(0);
                        g = false;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
