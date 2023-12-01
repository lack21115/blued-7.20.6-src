package com.uc.crashsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.uc.crashsdk.JNIBridge;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/a/g.class */
public class g {
    private static Context b;

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f40568a = !g.class.desiredAssertionStatus();

    /* renamed from: c  reason: collision with root package name */
    private static String f40569c = null;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static String g = null;
    private static boolean h = false;
    private static final Object i = new Object();
    private static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static Context a() {
        return b;
    }

    public static String a(File file, int i2, boolean z) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i2];
                int read = fileInputStream.read(bArr);
                fileInputStream2 = fileInputStream;
                if (read > 0) {
                    String str = new String(bArr, 0, read);
                    a(fileInputStream);
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (z) {
                    try {
                        a(th, false);
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        a(fileInputStream);
                        throw th2;
                    }
                }
                a(fileInputStream2);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        a(fileInputStream2);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0046, code lost:
        if (r4.toLowerCase().startsWith("http") != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r4
            r1.<init>(r2)
            boolean r0 = r0.exists()
            r7 = r0
            r0 = 0
            r9 = r0
            r0 = r9
            r8 = r0
            r0 = r7
            if (r0 == 0) goto L4c
            r0 = r4
            java.lang.String r0 = com.uc.crashsdk.a.b.a(r0)
            r8 = r0
            r0 = r8
            boolean r0 = a(r0)
            if (r0 == 0) goto L2c
            r0 = r9
            r8 = r0
            goto L4c
        L2c:
            r0 = r8
            r4 = r0
            r0 = r6
            if (r0 == 0) goto L49
            r0 = r8
            java.lang.String r0 = r0.trim()
            r4 = r0
            r0 = r9
            r8 = r0
            r0 = r4
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "http"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L4c
        L49:
            r0 = r4
            r8 = r0
        L4c:
            r0 = r8
            if (r0 != 0) goto L53
            r0 = r5
            return r0
        L53:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.g.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static String a(String[] strArr) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 512);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String trim = sb.toString().trim();
                        a(bufferedReader);
                        a(inputStreamReader);
                        return trim;
                    }
                    sb.append(readLine);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    a(th, false);
                    a(bufferedReader);
                    a(inputStreamReader);
                    return null;
                } catch (Throwable th3) {
                    a(bufferedReader);
                    a(inputStreamReader);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            inputStreamReader = null;
        }
    }

    public static ArrayList<String> a(File file, int i2) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i3 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        int i4 = i3 + 1;
                        i3 = i4;
                        if (i2 > 0) {
                            i3 = i4;
                            if (i4 >= i2) {
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            a(th, false);
                            a(fileReader);
                            a(bufferedReader);
                            return arrayList;
                        } catch (Throwable th2) {
                            a(fileReader);
                            a(bufferedReader);
                            throw th2;
                        }
                    }
                }
                a(fileReader);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
        }
        a(bufferedReader);
        return arrayList;
    }

    public static void a(int i2) {
        if (i2 == 800) {
            l();
        } else if (!f40568a) {
            throw new AssertionError();
        }
    }

    public static void a(Context context) {
        if (b != null) {
            a.b("mContext is existed");
        }
        b = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        f40569c = applicationInfo.dataDir;
        d = applicationInfo.sourceDir;
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            if (obj == null || !(obj instanceof String)) {
                return;
            }
            e = (String) obj;
        } catch (Throwable th) {
            a(th, false);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a(th, true);
            }
        }
    }

    public static void a(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        File file3 = file2;
        if (file2.isDirectory()) {
            file3 = new File(file2, file.getName());
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file3);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            a(fileInputStream2);
                            a(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public static void a(Throwable th) {
        a(th, false);
    }

    private static void a(Throwable th, boolean z) {
        if (!z) {
            try {
                if (!com.uc.crashsdk.g.O()) {
                    return;
                }
            } catch (Throwable th2) {
                return;
            }
        }
        th.printStackTrace();
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            int length = list.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                } else if (!a(new File(file, list[i3]))) {
                    return false;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return file.delete();
    }

    public static boolean a(File file, String str) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        } catch (Throwable th) {
            th = th;
            fileWriter = null;
        }
        try {
            fileWriter.write(str, 0, str.length());
            a(fileWriter);
            return true;
        } catch (Throwable th2) {
            th = th2;
            try {
                a(th, false);
                a(fileWriter);
                return false;
            } catch (Throwable th3) {
                a(fileWriter);
                throw th3;
            }
        }
    }

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            a(fileOutputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            try {
                a(th, false);
                a(fileOutputStream);
                return false;
            } catch (Throwable th3) {
                a(fileOutputStream);
                throw th3;
            }
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static String b() {
        return f40569c;
    }

    public static void b(File file) {
        a(file, "");
    }

    public static void b(Throwable th) {
        a(th, true);
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static long c(String str) {
        long j2 = 0;
        if (!a(str)) {
            try {
                j2 = Long.parseLong(str.trim());
                if (j2 < 0) {
                    return 0L;
                }
            } catch (NumberFormatException e2) {
                return 0L;
            }
        }
        return j2;
    }

    public static String c() {
        return d;
    }

    public static String c(File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return "";
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[256];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    String sb2 = sb.toString();
                    a(fileInputStream);
                    return sb2;
                }
                sb.append(new String(bArr, 0, read));
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                a(th, false);
                a(fileInputStream);
                return "";
            } catch (Throwable th3) {
                a(fileInputStream);
                throw th3;
            }
        }
    }

    public static String d() {
        String str = e;
        return str != null ? str : "";
    }

    public static String d(File file) {
        return a(file, 64, true);
    }

    public static String d(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length + 0) {
                    return sb.toString();
                }
                byte b2 = digest[i3];
                char c2 = j[(b2 & 240) >> 4];
                char c3 = j[b2 & 15];
                sb.append(c2);
                sb.append(c3);
                i2 = i3 + 1;
            }
        } catch (Exception e2) {
            a.a("crashsdk", "getMD5: ", e2);
            return null;
        }
    }

    public static boolean e() {
        if (g()) {
            return true;
        }
        return f();
    }

    public static byte[] e(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        if (file.exists()) {
            try {
                bArr = new byte[(int) file.length()];
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                fileInputStream.read(bArr);
                a(fileInputStream);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                try {
                    a(th, false);
                    a(fileInputStream);
                    return null;
                } catch (Throwable th3) {
                    a(fileInputStream);
                    throw th3;
                }
            }
        }
        return null;
    }

    public static boolean f() {
        return Build.TAGS != null && Build.TAGS.contains("test-keys");
    }

    public static boolean g() {
        int indexOf;
        String i2 = i();
        if (a(i2) || (indexOf = i2.indexOf(" root ")) <= 0) {
            return false;
        }
        String substring = i2.substring(0, indexOf);
        return substring.contains("x") || substring.contains("s");
    }

    public static String h() {
        l();
        return a(f) ? "" : f;
    }

    public static String i() {
        l();
        return a(g) ? "" : g;
    }

    public static void j() {
        f.a(0, new e(800), 15000L);
    }

    public static void k() {
        if (com.uc.crashsdk.b.d && h) {
            JNIBridge.set(123, f);
            JNIBridge.set(124, g);
        }
    }

    private static void l() {
        String trim;
        int indexOf;
        int indexOf2;
        if (h) {
            return;
        }
        synchronized (i) {
            if (h) {
                return;
            }
            String a2 = a(new String[]{com.anythink.expressad.foundation.d.d.t, "-c", "type su"});
            if (!a(a2) && (indexOf = (trim = a2.trim()).indexOf(32)) > 0 && trim.contains("/su") && (indexOf2 = trim.indexOf(47, indexOf + 1)) > 0) {
                String substring = trim.substring(indexOf2);
                f = substring;
                String a3 = a(new String[]{"ls", "-l", substring});
                if (!a(a3)) {
                    g = a3.trim();
                }
            }
            h = true;
            k();
        }
    }
}
