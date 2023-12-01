package com.tencent.bugly.proguard;

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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/y.class */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35416a = true;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static SimpleDateFormat f35417c;
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

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/y$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f35420a;
        private File b;

        /* renamed from: c  reason: collision with root package name */
        private String f35421c;
        private long d;
        private long e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f35421c = str;
            this.f35420a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                File file = new File(this.f35421c);
                this.b = file;
                if (file.exists() && !this.b.delete()) {
                    this.f35420a = false;
                    return false;
                } else if (this.b.createNewFile()) {
                    return true;
                } else {
                    this.f35420a = false;
                    return false;
                }
            } catch (Throwable th) {
                x.a(th);
                this.f35420a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2;
            byte[] bytes;
            if (this.f35420a) {
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
                    this.d += bytes.length;
                    this.f35420a = true;
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
                        x.a(th);
                        this.f35420a = false;
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
            f35417c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            x.b(th.getCause());
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        e.setLength(0);
        String str4 = str3;
        if (str3.length() > 30720) {
            str4 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f35417c;
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
        synchronized (y.class) {
            try {
                if (m || context == null || !f35416a) {
                    return;
                }
                try {
                    o = Executors.newSingleThreadExecutor();
                    f = new StringBuilder(0);
                    e = new StringBuilder(0);
                    k = context;
                    com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
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
        synchronized (y.class) {
            try {
                if (m && f35416a) {
                    try {
                        o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.y.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                y.c(String.this, str2, str3);
                            }
                        });
                    } catch (Exception e2) {
                        x.b(e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
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
        a(str, str2, str3 + '\n' + z.b(th));
    }

    public static byte[] a() {
        if (b) {
            if (f35416a) {
                return z.a((File) null, f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return b();
    }

    private static byte[] b() {
        if (f35416a) {
            StringBuilder sb = new StringBuilder();
            synchronized (q) {
                if (h != null && h.f35420a && h.b != null && h.b.length() > 0) {
                    sb.append(z.a(h.b, 30720, true));
                }
                if (f != null && f.length() > 0) {
                    sb.append(f.toString());
                }
            }
            return z.a((File) null, sb.toString(), "BuglyLog.txt");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, String str2, String str3) {
        synchronized (y.class) {
            try {
                if (b) {
                    d(str, str2, str3);
                } else {
                    e(str, str2, str3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void d(String str, String str2, String str3) {
        synchronized (y.class) {
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

    private static void e(String str, String str2, String str3) {
        synchronized (y.class) {
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
                    } else if (h.b == null || h.b.length() + f.length() > h.e) {
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
