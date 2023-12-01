package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static m f38862a;
    private static Context b;

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Context context) {
        if (f38862a == null) {
            synchronized (m.class) {
                try {
                    if (f38862a == null) {
                        f38862a = new m();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        b = context.getApplicationContext();
        return f38862a;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Properties e() {
        /*
            r6 = this;
            r0 = 0
            r7 = r0
            r0 = r6
            java.io.File r0 = r0.a()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L52
            r8 = r0
            java.util.Properties r0 = new java.util.Properties     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L52
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L52
            r10 = r0
            r0 = r8
            if (r0 == 0) goto L39
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L33 java.lang.Throwable -> L4c
            r1 = r0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L33 java.lang.Throwable -> L4c
            r3 = r2
            r4 = r8
            r3.<init>(r4)     // Catch: java.lang.Exception -> L33 java.lang.Throwable -> L4c
            r1.<init>(r2)     // Catch: java.lang.Exception -> L33 java.lang.Throwable -> L4c
            r7 = r0
            r0 = r7
            r9 = r0
            r0 = r10
            r1 = r7
            r0.load(r1)     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L72
            goto L39
        L2f:
            r8 = move-exception
            goto L59
        L33:
            r8 = move-exception
            r0 = 0
            r7 = r0
            goto L59
        L39:
            r0 = r7
            if (r0 == 0) goto L49
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L44
            r0 = r10
            return r0
        L44:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L49:
            r0 = r10
            return r0
        L4c:
            r7 = move-exception
            r0 = 0
            r9 = r0
            goto L73
        L52:
            r8 = move-exception
            r0 = 0
            r10 = r0
            r0 = r10
            r7 = r0
        L59:
            r0 = r7
            r9 = r0
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L72
            r0 = r7
            if (r0 == 0) goto L6f
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L6a
            r0 = r10
            return r0
        L6a:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L6f:
            r0 = r10
            return r0
        L72:
            r7 = move-exception
        L73:
            r0 = r9
            if (r0 == 0) goto L83
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L7e
            goto L83
        L7e:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        L83:
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.m.e():java.util.Properties");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a() {
        o.a();
        File file = new File(o.s(b), "tbscoreinstall.txt");
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        a("dexopt_retry_num", i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        a("copy_core_ver", i);
        a("copy_status", i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a("install_apk_path", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i) {
        a(str, String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    Properties e = e();
                    FileOutputStream fileOutputStream3 = null;
                    if (e != null) {
                        e.setProperty(str, str2);
                        File a2 = a();
                        fileOutputStream3 = null;
                        if (a2 != null) {
                            FileOutputStream fileOutputStream4 = new FileOutputStream(a2);
                            try {
                                e.store(fileOutputStream4, "update " + str + " and status!");
                                fileOutputStream3 = fileOutputStream4;
                            } catch (Exception e2) {
                                fileOutputStream = fileOutputStream4;
                                e = e2;
                                fileOutputStream2 = fileOutputStream;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream2 = fileOutputStream4;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    if (fileOutputStream3 != null) {
                        fileOutputStream3.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return c("install_core_ver");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(String str) {
        Properties e = e();
        if (e == null || e.getProperty(str) == null) {
            return -1;
        }
        return Integer.parseInt(e.getProperty(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        a("unzip_retry_num", i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, int i2) {
        a("tpatch_ver", i);
        a("tpatch_status", i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return b("install_status");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(String str) {
        Properties e = e();
        if (e == null || e.getProperty(str) == null) {
            return 0;
        }
        return Integer.parseInt(e.getProperty(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        a("incrupdate_status", i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, int i2) {
        a("install_core_ver", i);
        a("install_status", i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return b("incrupdate_status");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d(String str) {
        Properties e = e();
        if (e == null || e.getProperty(str) == null) {
            return null;
        }
        return e.getProperty(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        a("unlzma_status", i);
    }
}
