package com.igexin.push.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.base.util.io.IOUtils;
import com.igexin.push.core.ServiceManager;
import com.igexin.sdk.main.SdkInitSwitch;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static String f23654a;
    public static String b;

    /* renamed from: c  reason: collision with root package name */
    public static String f23655c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    private static final String i = "FileUtils";
    private static final Object j = new Object();
    private static String k;

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
        if (r0.canRead() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L7f
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L7f
            r7 = r0
            r0 = r7
            java.lang.String r1 = com.igexin.push.f.j.f     // Catch: java.lang.Exception -> L7f
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L7f
            r0 = r7
            r1 = r4
            java.lang.String r1 = com.igexin.assist.util.a.a(r1)     // Catch: java.lang.Exception -> L7f
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L7f
            r0 = r7
            java.lang.String r1 = ".bin"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L7f
            r0 = r7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L7f
            r4 = r0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L7b java.lang.Exception -> L7f
            r1 = r0
            r2 = r4
            r1.<init>(r2)     // Catch: java.lang.Exception -> L7b
            r7 = r0
            r0 = r7
            boolean r0 = r0.exists()     // Catch: java.lang.Exception -> L7b
            if (r0 == 0) goto L41
            r0 = r7
            boolean r0 = r0.canRead()     // Catch: java.lang.Exception -> L7b
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L87
        L41:
            r0 = r6
            r4 = r0
            android.content.Context r0 = com.igexin.push.core.e.l     // Catch: java.lang.Exception -> L7f
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L7f
            java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
            android.content.Context r2 = com.igexin.push.core.e.l     // Catch: java.lang.Exception -> L7f
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Exception -> L7f
            int r0 = r0.checkPermission(r1, r2)     // Catch: java.lang.Exception -> L7f
            if (r0 == 0) goto L87
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L7f
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L7f
            r4 = r0
            r0 = r4
            android.content.Context r1 = com.igexin.push.core.e.l     // Catch: java.lang.Exception -> L7f
            java.io.File r1 = r1.getCacheDir()     // Catch: java.lang.Exception -> L7f
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L7f
            r0 = r4
            java.lang.String r1 = "/ImgCache/"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L7f
            r0 = r4
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L7f
            com.igexin.push.f.j.f = r0     // Catch: java.lang.Exception -> L7f
            java.lang.String r0 = ""
            return r0
        L7b:
            r6 = move-exception
            goto L83
        L7f:
            r6 = move-exception
            java.lang.String r0 = ""
            r4 = r0
        L83:
            r0 = r6
            com.igexin.c.a.c.a.a(r0)
        L87:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.j.a(java.lang.String):java.lang.String");
    }

    public static void a() {
        try {
            i();
            if (i()) {
                File file = new File("/sdcard/libs");
                if (file.exists() && file.isFile()) {
                    com.igexin.c.a.c.a.a(i, "libs is file not directory, delete libs file +++++");
                    com.igexin.c.a.c.a.a("FileUtils|libs is file not directory, delete libs file ++++", new Object[0]);
                    file.delete();
                }
                if (!file.exists() && !file.mkdir()) {
                    com.igexin.c.a.c.a.a(i, "create libs directory failed ++++++++");
                    com.igexin.c.a.c.a.a("FileUtils|create libs directory failed ++++++", new Object[0]);
                }
            }
            String packageName = com.igexin.push.core.e.l.getPackageName();
            b = "/sdcard/libs/" + packageName + com.umeng.analytics.process.a.d;
            f23655c = "/sdcard/libs/com.igexin.sdk.deviceId.db";
            f23654a = "/sdcard/libs/" + packageName + ".properties";
            d = "/sdcard/libs/" + packageName + ".bin";
            e = com.igexin.push.core.e.l.getFilesDir().getPath() + BridgeUtil.SPLIT_MARK + packageName + ".properties";
            g = com.igexin.push.core.e.l.getFilesDir().getPath() + BridgeUtil.SPLIT_MARK + packageName + "-guard.properties";
            StringBuilder sb = new StringBuilder();
            sb.append(com.igexin.push.core.e.l.getFilesDir().getPath());
            sb.append("/init_c1.pid");
            h = sb.toString();
            f = com.igexin.push.core.e.l.getCacheDir() + "/ImgCache/";
            k = "/sdcard/libs/com.getui.sdk.deviceId.db";
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void a(byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!str.startsWith("/sdcard/libs") || i()) {
                    File file = new File(str);
                    if (a(file)) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file, false);
                        try {
                            fileOutputStream3.write(bArr);
                            try {
                                fileOutputStream3.close();
                            } catch (Exception e2) {
                                com.igexin.c.a.c.a.a(e2);
                            }
                        } catch (Exception e3) {
                            fileOutputStream = fileOutputStream3;
                            e = e3;
                            com.igexin.c.a.c.a.a(e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                    com.igexin.c.a.c.a.a(e4);
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream3;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Exception e5) {
                                    com.igexin.c.a.c.a.a(e5);
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(Context context) {
        return (new File(context.getFilesDir().getAbsolutePath(), com.igexin.push.core.d.d.f23484a).exists() || new SdkInitSwitch(context).isSwitchOn()) ? false : true;
    }

    private static boolean a(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return file.canWrite();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static String b(Context context) {
        return context.getExternalFilesDir("gtpush") + "/log/";
    }

    public static void b() {
        FileOutputStream fileOutputStream;
        Exception e2;
        if (!i()) {
            int i2 = Build.VERSION.SDK_INT;
            com.igexin.c.a.c.a.a("FileUtils | save session to file no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(b);
                if (!file.exists() && !file.createNewFile()) {
                    StringBuilder sb = new StringBuilder("FileUtils | create file : ");
                    sb.append(file.toString());
                    sb.append(" failed !!!");
                    com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                    return;
                }
                fileOutputStream = new FileOutputStream(b);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(com.igexin.push.config.c.w + n.c());
                    sb2.append(com.igexin.push.core.e.z);
                    sb2.append("|");
                    sb2.append(com.igexin.push.core.e.f23495a);
                    sb2.append("|");
                    sb2.append(com.igexin.push.core.e.A);
                    sb2.append("|");
                    ServiceManager.getInstance();
                    sb2.append(ServiceManager.d(com.igexin.push.core.e.l));
                    fileOutputStream.write(com.igexin.c.a.a.a.b(sb2.toString().getBytes(), com.igexin.push.core.e.M));
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        com.igexin.c.a.c.a.a(e3);
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    com.igexin.c.a.c.a.a(e2);
                    FileOutputStream fileOutputStream3 = fileOutputStream;
                    StringBuilder sb3 = new StringBuilder("FileUtils | ");
                    FileOutputStream fileOutputStream4 = fileOutputStream;
                    sb3.append(e2.toString());
                    FileOutputStream fileOutputStream5 = fileOutputStream;
                    com.igexin.c.a.c.a.a(sb3.toString(), new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            com.igexin.c.a.c.a.a(e6);
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                fileOutputStream = null;
                e2 = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean b(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return file.canRead();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static byte[] b(String str) {
        Closeable closeable;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream2;
        if (!new File(str).exists()) {
            com.igexin.c.a.c.a.a(i, "get data from file = " + str + " file not exist ######");
            com.igexin.c.a.c.a.a("FileUtils|get data from file = " + str + " file not exist ######", new Object[0]);
            return null;
        } else if (!b(new File(str))) {
            return null;
        } else {
            byte[] bArr2 = new byte[1024];
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    fileInputStream = null;
                }
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        } catch (Exception e3) {
                            e = e3;
                            inputStream = fileInputStream;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            com.igexin.c.a.c.a.a(e);
                            InputStream inputStream2 = inputStream;
                            StringBuilder sb = new StringBuilder("FileUtils|");
                            InputStream inputStream3 = inputStream;
                            sb.append(e.toString());
                            InputStream inputStream4 = inputStream;
                            com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                            bArr = null;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            IOUtils.safeClose(inputStream);
                            IOUtils.safeClose(byteArrayOutputStream2);
                            return bArr;
                        }
                    }
                    inputStream = fileInputStream;
                    bArr = byteArrayOutputStream2.toByteArray();
                } catch (Exception e4) {
                    e = e4;
                    inputStream = fileInputStream;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                    IOUtils.safeClose(fileInputStream);
                    IOUtils.safeClose(closeable);
                    throw th;
                }
                IOUtils.safeClose(inputStream);
                IOUtils.safeClose(byteArrayOutputStream2);
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        }
    }

    public static String c() {
        String str;
        Exception e2;
        byte[] b2;
        if (!m()) {
            int i2 = Build.VERSION.SDK_INT;
            com.igexin.c.a.c.a.a("FileUtils | read file cid no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return null;
        }
        try {
            b2 = b(b);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        }
        if (b2 == null) {
            com.igexin.c.a.c.a.a("FileUtils | read file cid id = null", new Object[0]);
            return null;
        }
        String[] split = new String(com.igexin.c.a.a.a.a(b2, com.igexin.push.core.e.M)).split("\\|");
        str = null;
        if (split.length > 2) {
            str = split[2];
            if (str != null) {
                try {
                    if (str.equals(com.igexin.push.core.b.l)) {
                        str = null;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    com.igexin.c.a.c.a.a(e2);
                    com.igexin.c.a.c.a.a("FileUtils|get cid from file cid = ".concat(String.valueOf(str)), new Object[0]);
                    return str;
                }
            }
        }
        com.igexin.c.a.c.a.a("FileUtils|get cid from file cid = ".concat(String.valueOf(str)), new Object[0]);
        return str;
    }

    private static String c(String str) {
        return d(str);
    }

    private static void c(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                File file2 = listFiles[i3];
                while (file2.exists()) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (!file2.delete()) {
                        c(file2);
                    }
                }
                i2 = i3 + 1;
            }
        }
        file.delete();
    }

    public static String d() {
        String str = null;
        if (!i()) {
            int i2 = Build.VERSION.SDK_INT;
            com.igexin.c.a.c.a.a("FileUtils | get device id from file no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return null;
        }
        try {
            com.igexin.c.a.c.a.a("FileUtils|get device id from file : " + f23655c, new Object[0]);
            byte[] b2 = b(f23655c);
            if (b2 == null) {
                com.igexin.c.a.c.a.a(i, "read file device id = null");
                com.igexin.c.a.c.a.a("FileUtils|read file device id = null", new Object[0]);
                return null;
            }
            String str2 = new String(b2, "utf-8");
            try {
                com.igexin.c.a.c.a.a("FileUtils|read file device id = ".concat(str2), new Object[0]);
                return str2;
            } catch (Exception e2) {
                str = str2;
                e = e2;
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("FileUtils|get device id from file : " + e.toString(), new Object[0]);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static String d(String str) {
        String str2;
        byte[] b2;
        try {
            b2 = b(str);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            str2 = "";
        }
        if (b2 == null) {
            com.igexin.c.a.c.a.a("FileUtils | read file info id = null", new Object[0]);
            return null;
        }
        String[] split = new String(com.igexin.c.a.a.a.a(b2, com.igexin.push.core.e.M)).split("\\|");
        str2 = "";
        if (split.length > 2) {
            String str3 = split[1];
            str2 = str3;
            if (str3 != null) {
                str2 = str3;
                if (str3.equals(com.igexin.push.core.b.l)) {
                    str2 = null;
                }
            }
        }
        com.igexin.c.a.c.a.a("FileUtils|get info from file info = ".concat(String.valueOf(str2)), new Object[0]);
        return str2;
    }

    public static long e() {
        byte[] b2;
        long j2 = 0;
        if (!m()) {
            int i2 = Build.VERSION.SDK_INT;
            com.igexin.c.a.c.a.a("FileUtils | get session from file no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return 0L;
        }
        try {
            b2 = b(b);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(i, e2.toString());
            com.igexin.c.a.c.a.a("FileUtils|" + e2.toString(), new Object[0]);
        }
        if (b2 == null) {
            com.igexin.c.a.c.a.a(i, "read session from file, not exist");
            com.igexin.c.a.c.a.a("FileUtils|read session from file, not exist", new Object[0]);
            return 0L;
        }
        String str = new String(com.igexin.c.a.a.a.a(b2, com.igexin.push.core.e.M));
        String substring = str.contains(com.igexin.push.core.b.l) ? str.substring(7) : str.substring(20);
        int indexOf = substring.indexOf("|");
        String str2 = substring;
        if (indexOf >= 0) {
            str2 = substring.substring(0, indexOf);
        }
        long parseLong = Long.parseLong(str2);
        if (parseLong != 0) {
            j2 = parseLong;
        }
        com.igexin.c.a.c.a.a("FileUtils|session : ".concat(String.valueOf(j2)), new Object[0]);
        return j2;
    }

    private static void e(String str) {
        OutputStream outputStream;
        if (!i()) {
            int i2 = Build.VERSION.SDK_INT;
            com.igexin.c.a.c.a.a("FileUtils | saveDeviceIdToNewFile no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save deviceId = " + str + " to " + k, new Object[0]);
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream2 = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    File file = new File(k);
                    if (!file.exists() && !file.createNewFile()) {
                        StringBuilder sb = new StringBuilder("FileUtils|create file ");
                        sb.append(file.toString());
                        sb.append(" failed");
                        com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                        com.igexin.c.a.b.g.a((Closeable) null);
                        writeLock.unlock();
                        return;
                    }
                    fileOutputStream = new FileOutputStream(k);
                    try {
                        fileOutputStream.write(com.igexin.c.b.a.b("V1|".concat(String.valueOf(str)).getBytes("utf-8")));
                    } catch (Exception e2) {
                        outputStream = fileOutputStream;
                        e = e2;
                        com.igexin.c.a.c.a.a(e);
                        OutputStream outputStream3 = outputStream;
                        StringBuilder sb2 = new StringBuilder("FileUtils|");
                        OutputStream outputStream4 = outputStream;
                        sb2.append(e.toString());
                        OutputStream outputStream5 = outputStream;
                        com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
                        com.igexin.c.a.b.g.a(outputStream);
                        writeLock.unlock();
                        return;
                    } catch (Throwable th) {
                        th = th;
                        outputStream2 = fileOutputStream;
                        com.igexin.c.a.b.g.a(outputStream2);
                        writeLock.unlock();
                        throw th;
                    }
                }
                com.igexin.c.a.b.g.a(fileOutputStream);
                writeLock.unlock();
            } catch (Exception e3) {
                e = e3;
                outputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void f() {
        Exception e2;
        if (com.igexin.push.core.e.H == null) {
            return;
        }
        if (!i()) {
            int i2 = Build.VERSION.SDK_INT;
            com.igexin.c.a.c.a.a("FileUtils | save device id to file no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save device id to file : " + f23655c, new Object[0]);
        FileOutputStream fileOutputStream = null;
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    File file = new File(f23655c);
                    if (!file.exists() && !file.createNewFile()) {
                        StringBuilder sb = new StringBuilder("FileUtils|create file : ");
                        sb.append(file.toString());
                        sb.append(" failed !!!");
                        com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                        writeLock.unlock();
                        return;
                    }
                    fileOutputStream = new FileOutputStream(f23655c);
                    try {
                        byte[] bytes = com.igexin.push.core.e.H.getBytes("utf-8");
                        new String(bytes, "utf-8");
                        fileOutputStream.write(bytes);
                    } catch (Exception e3) {
                        e2 = e3;
                        com.igexin.c.a.c.a.a(e2);
                        FileOutputStream fileOutputStream3 = fileOutputStream;
                        StringBuilder sb2 = new StringBuilder("FileUtils|");
                        FileOutputStream fileOutputStream4 = fileOutputStream;
                        sb2.append(e2.toString());
                        FileOutputStream fileOutputStream5 = fileOutputStream;
                        com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                com.igexin.c.a.c.a.a(e4);
                            }
                        }
                        writeLock.unlock();
                        return;
                    } catch (Throwable th) {
                        fileOutputStream2 = fileOutputStream;
                        th = th;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e5) {
                                com.igexin.c.a.c.a.a(e5);
                            }
                        }
                        writeLock.unlock();
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        com.igexin.c.a.c.a.a(e6);
                    }
                }
                writeLock.unlock();
            } catch (Exception e7) {
                fileOutputStream = null;
                e2 = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void f(String str) {
        try {
            com.igexin.push.core.e.f.a().a(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void g() {
        byte[] bytes = com.igexin.push.core.e.A.getBytes();
        byte[] bArr = new byte[bytes.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bytes.length) {
                com.igexin.push.core.d.d.a().a("c", Base64.encodeToString(bArr, 0));
                return;
            } else {
                bArr[i3] = (byte) (bytes[i3] ^ com.igexin.push.core.e.ad[i3]);
                i2 = i3 + 1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x01e9 A[Catch: all -> 0x027a, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x027a, blocks: (B:7:0x0050, B:11:0x0062, B:15:0x006b, B:18:0x0078, B:23:0x0088, B:25:0x008f, B:27:0x009b, B:29:0x00a8, B:31:0x00b5, B:33:0x00c2, B:35:0x00cf, B:37:0x00ef, B:39:0x00fd, B:40:0x0104, B:54:0x0145, B:85:0x01e9, B:86:0x0211, B:89:0x022e, B:79:0x01d6, B:82:0x01de, B:94:0x0260, B:97:0x0269, B:99:0x026f), top: B:112:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0211 A[Catch: all -> 0x027a, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x027a, blocks: (B:7:0x0050, B:11:0x0062, B:15:0x006b, B:18:0x0078, B:23:0x0088, B:25:0x008f, B:27:0x009b, B:29:0x00a8, B:31:0x00b5, B:33:0x00c2, B:35:0x00cf, B:37:0x00ef, B:39:0x00fd, B:40:0x0104, B:54:0x0145, B:85:0x01e9, B:86:0x0211, B:89:0x022e, B:79:0x01d6, B:82:0x01de, B:94:0x0260, B:97:0x0269, B:99:0x026f), top: B:112:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<org.json.JSONObject> h() {
        /*
            Method dump skipped, instructions count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.j.h():java.util.List");
    }

    public static boolean i() {
        try {
            return CommonUtil.hasPermission(com.igexin.push.core.e.l, "android.permission.WRITE_EXTERNAL_STORAGE", false);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static void j() {
        File[] listFiles;
        File file = new File(f);
        if (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.igexin.push.f.j.1

            /* renamed from: a  reason: collision with root package name */
            final long f23656a = System.currentTimeMillis();
            final long b = 604800000;

            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return this.f23656a - file2.lastModified() >= 604800000;
            }
        })) == null) {
            return;
        }
        int length = listFiles.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            listFiles[i3].delete();
            i2 = i3 + 1;
        }
    }

    public static void k() {
        File[] listFiles;
        if (!i()) {
            return;
        }
        File file = new File(GtcProvider.getSdcardPath() + "/Sdk/WebCache/");
        if (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.igexin.push.f.j.2

            /* renamed from: a  reason: collision with root package name */
            final long f23657a = System.currentTimeMillis();
            final long b = 604800000;

            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return this.f23657a - file2.lastModified() >= 604800000;
            }
        })) == null) {
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
            if (file2.exists()) {
                c(file2);
            }
            i2 = i3 + 1;
        }
    }

    public static void l() {
        Exception e2;
        if (!i()) {
            int i2 = Build.VERSION.SDK_INT;
            com.igexin.c.a.c.a.a("FileUtilsupdateDeviceId no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return;
        }
        String o = o();
        String str = com.igexin.push.core.e.H;
        com.igexin.c.a.c.a.a("FileUtils|read deviceId.db = " + o + "; CoreRuntimeInfo.deviceId = " + com.igexin.push.core.e.H, new Object[0]);
        if (o != null) {
            if (o.equals(com.igexin.push.core.e.H)) {
                return;
            }
            com.igexin.push.core.e.H = o;
            try {
                com.igexin.push.core.e.f.a().a(o);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        } else if (com.igexin.push.core.e.H == null) {
        } else {
            String str2 = com.igexin.push.core.e.H;
            if (!i()) {
                int i3 = Build.VERSION.SDK_INT;
                com.igexin.c.a.c.a.a("FileUtils | saveDeviceIdToNewFile no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
                return;
            }
            com.igexin.c.a.c.a.a("FileUtils|save deviceId = " + str2 + " to " + k, new Object[0]);
            ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
            FileOutputStream fileOutputStream = null;
            OutputStream outputStream = null;
            try {
                try {
                    if (writeLock.tryLock()) {
                        File file = new File(k);
                        if (!file.exists() && !file.createNewFile()) {
                            StringBuilder sb = new StringBuilder("FileUtils|create file ");
                            sb.append(file.toString());
                            sb.append(" failed");
                            com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                            com.igexin.c.a.b.g.a((Closeable) null);
                            writeLock.unlock();
                            return;
                        }
                        fileOutputStream = new FileOutputStream(k);
                        try {
                            fileOutputStream.write(com.igexin.c.b.a.b("V1|".concat(String.valueOf(str2)).getBytes("utf-8")));
                        } catch (Exception e3) {
                            e2 = e3;
                            com.igexin.c.a.c.a.a(e2);
                            FileOutputStream fileOutputStream2 = fileOutputStream;
                            StringBuilder sb2 = new StringBuilder("FileUtils|");
                            FileOutputStream fileOutputStream3 = fileOutputStream;
                            sb2.append(e2.toString());
                            FileOutputStream fileOutputStream4 = fileOutputStream;
                            com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
                            com.igexin.c.a.b.g.a(fileOutputStream);
                            writeLock.unlock();
                            return;
                        } catch (Throwable th2) {
                            outputStream = fileOutputStream;
                            th = th2;
                            com.igexin.c.a.b.g.a(outputStream);
                            writeLock.unlock();
                            throw th;
                        }
                    }
                    com.igexin.c.a.b.g.a(fileOutputStream);
                    writeLock.unlock();
                } catch (Exception e4) {
                    fileOutputStream = null;
                    e2 = e4;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    private static boolean m() {
        try {
            return CommonUtil.hasPermission(com.igexin.push.core.e.l, "android.permission.READ_EXTERNAL_STORAGE", false);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static String n() {
        String str;
        String[] strArr;
        try {
        } catch (Exception e2) {
            e = e2;
            str = null;
        }
        if (!m()) {
            int i2 = Build.VERSION.SDK_INT;
            com.igexin.c.a.c.a.a("FileUtils | get Activity From File no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return null;
        }
        byte[] b2 = b(b);
        if (b2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String b3 = com.igexin.c.b.a.b(com.igexin.push.core.b.ai);
        String b4 = com.igexin.c.b.a.b("");
        if (b3 != null && ((b3.equals(com.igexin.push.core.e.M) || com.igexin.push.core.e.M.equals(b4)) && !TextUtils.isEmpty(com.igexin.push.core.e.D))) {
            arrayList.add(com.igexin.c.b.a.b(com.igexin.push.core.e.D));
        }
        arrayList.add(com.igexin.push.core.e.M);
        arrayList.add(b4);
        arrayList.add(com.igexin.c.b.a.b("000000000000000"));
        arrayList.add(b3);
        String h2 = n.h();
        if (!TextUtils.isEmpty(h2)) {
            arrayList.add(com.igexin.c.b.a.b(h2));
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                strArr = null;
                break;
            }
            String str2 = new String(com.igexin.c.a.a.a.a(b2, (String) it.next()));
            if (Pattern.matches("[\\.:0-9a-zA-Z\\|]+", str2)) {
                strArr = str2.split("\\|");
                break;
            }
        }
        String str3 = null;
        if (strArr != null) {
            str3 = null;
            if (strArr.length > 3) {
                str = strArr[3];
                if (str != null) {
                    try {
                        if (str.equals(com.igexin.push.core.b.l)) {
                            return null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        com.igexin.c.a.c.a.a(e);
                        str3 = str;
                        return str3;
                    }
                }
                return str;
            }
        }
        return str3;
    }

    private static String o() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        ByteArrayOutputStream byteArrayOutputStream3;
        if (!m()) {
            int i2 = Build.VERSION.SDK_INT;
            com.igexin.c.a.c.a.a("FileUtils | getDeviceIdFromNewFile no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return null;
        }
        File file = new File(k);
        if (b(file) && file.exists()) {
            byte[] bArr = new byte[1024];
            try {
                fileInputStream = new FileInputStream(k);
            } catch (Exception e2) {
                e = e2;
                inputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
                fileInputStream = null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                while (true) {
                    InputStream inputStream2 = fileInputStream;
                    byteArrayOutputStream = byteArrayOutputStream4;
                    try {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream4.write(bArr, 0, read);
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = inputStream2;
                            com.igexin.c.a.b.g.a(fileInputStream);
                            com.igexin.c.a.b.g.a(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = fileInputStream;
                        byteArrayOutputStream2 = byteArrayOutputStream4;
                        inputStream2 = inputStream;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        str = null;
                        byteArrayOutputStream3 = byteArrayOutputStream2;
                        com.igexin.c.a.b.g.a(inputStream);
                        com.igexin.c.a.b.g.a(byteArrayOutputStream3);
                        return str;
                    }
                }
                String[] split = new String(com.igexin.c.b.a.c(byteArrayOutputStream4.toByteArray()), "utf-8").split("\\|");
                str = null;
                inputStream = fileInputStream;
                byteArrayOutputStream3 = byteArrayOutputStream4;
                if (split.length > 1) {
                    str = null;
                    inputStream = fileInputStream;
                    byteArrayOutputStream3 = byteArrayOutputStream4;
                    if (com.igexin.push.core.g.e.equals(split[0])) {
                        str = split[1];
                        byteArrayOutputStream3 = byteArrayOutputStream4;
                        inputStream = fileInputStream;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = fileInputStream;
                byteArrayOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                com.igexin.c.a.b.g.a(fileInputStream);
                com.igexin.c.a.b.g.a(byteArrayOutputStream);
                throw th;
            }
            com.igexin.c.a.b.g.a(inputStream);
            com.igexin.c.a.b.g.a(byteArrayOutputStream3);
            return str;
        }
        return null;
    }
}
