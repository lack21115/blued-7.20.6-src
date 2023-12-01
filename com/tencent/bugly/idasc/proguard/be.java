package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/be.class */
public final class be {

    /* renamed from: a  reason: collision with root package name */
    private static List<File> f35291a = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.BufferedInputStream] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        String str2;
        String str3;
        String a2;
        if (context == null || str == null || nativeExceptionHandler == null) {
            al.e("get eup record file args error", new Object[0]);
            return null;
        }
        File file = new File(str, "rqd_record.eup");
        if (!file.exists()) {
            return null;
        }
        try {
            if (file.canRead()) {
                try {
                    bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException e) {
                    e = e;
                    bufferedInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    file = null;
                    if (file != null) {
                        try {
                            file.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    String a3 = a(bufferedInputStream2);
                    if (a3 != null && a3.equals("NATIVE_RQD_REPORT")) {
                        HashMap hashMap = new HashMap();
                        loop0: while (true) {
                            while (true) {
                                str3 = str2;
                                a2 = a(bufferedInputStream2);
                                if (a2 == null) {
                                    break loop0;
                                }
                                str2 = str3 == null ? a2 : null;
                            }
                            hashMap.put(str3, a2);
                        }
                        if (str3 != null) {
                            al.e("record not pair! drop! %s", str3);
                            try {
                                bufferedInputStream2.close();
                                return null;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return null;
                            }
                        }
                        CrashDetailBean a4 = a(context, hashMap, nativeExceptionHandler);
                        try {
                            bufferedInputStream2.close();
                            return a4;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return a4;
                        }
                    }
                    al.e("record read fail! %s", a3);
                    try {
                        bufferedInputStream2.close();
                        return null;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return null;
                    }
                } catch (IOException e6) {
                    e = e6;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return null;
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean a(android.content.Context r19, java.util.Map<java.lang.String, java.lang.String> r20, com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler r21) {
        /*
            Method dump skipped, instructions count: 993
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.be.a(android.content.Context, java.util.Map, com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean");
    }

    private static <KeyT, ValueT> ValueT a(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        try {
            ValueT valuet2 = map.get(keyt);
            if (valuet2 != null) {
                return valuet2;
            }
        } catch (Exception e) {
            al.a(e);
        }
        return valuet;
    }

    private static String a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                    if (read == -1) {
                        break;
                    } else if (read == 0) {
                        String str = new String(byteArrayOutputStream3.toByteArray(), "UTf-8");
                        byteArrayOutputStream3.close();
                        return str;
                    } else {
                        byteArrayOutputStream3.write(read);
                    }
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream3;
                    th = th;
                    try {
                        al.a(th);
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            byteArrayOutputStream2.close();
                            return null;
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        String str2 = str;
        if (split != null) {
            if (split.length == 0) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str3 = split[i2];
                if (!str3.contains("java.lang.Thread.getStackTrace(")) {
                    sb.append(str3);
                    sb.append("\n");
                }
                i = i2 + 1;
            }
            str2 = sb.toString();
        }
        return str2;
    }

    public static String a(String str, int i, String str2, boolean z) {
        BufferedReader bufferedReader;
        if (str == null || i <= 0) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        al.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
        f35291a.add(file);
        al.c("Add this record file to list for cleaning lastly.", new Object[0]);
        if (str2 == null) {
            return ap.a(new File(str), i, z);
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (Pattern.compile(str2 + "[ ]*:").matcher(readLine).find()) {
                            sb.append(readLine);
                            sb.append("\n");
                        }
                        if (i > 0 && sb.length() > i) {
                            if (z) {
                                sb.delete(i, sb.length());
                                break;
                            }
                            sb.delete(0, sb.length() - i);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            al.a(th);
                            sb.append("\n[error:" + th.toString() + "]");
                            String sb2 = sb.toString();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb2;
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e) {
                                    al.a(e);
                                }
                            }
                            throw th2;
                        }
                    }
                }
                String sb3 = sb.toString();
                bufferedReader.close();
                return sb3;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e2) {
            al.a(e2);
            return str2;
        }
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String b = b(str, str2);
        if (b != null && !b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(b);
        }
        String c2 = c(str, str2);
        if (c2 != null && !c2.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(c2);
        }
        return sb.toString();
    }

    private static Map<String, String> a(Map<String, String> map) {
        String str = map.get("key-value");
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("\n");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashMap;
            }
            String[] split2 = split[i2].split("=");
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
            i = i2 + 1;
        }
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            f35291a.add(new File(str, "rqd_record.eup"));
            f35291a.add(new File(str, "reg_record.txt"));
            f35291a.add(new File(str, "map_record.txt"));
            f35291a.add(new File(str, "backup_record.txt"));
            if (z) {
                c(str);
            }
        }
        List<File> list = f35291a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f35291a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                al.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    private static long b(Map<String, String> map) {
        String str = map.get("launchTime");
        if (str != null) {
            al.c("[Native record info] launchTime: %s", str);
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e) {
                if (al.a(e)) {
                    return -1L;
                }
                e.printStackTrace();
                return -1L;
            }
        }
        return -1L;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    private static String b(String str, String str2) {
        String substring;
        BufferedReader b = ap.b(str, "reg_record.txt");
        if (b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = b.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                int i = 18;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    String readLine2 = b.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    if (i2 % 4 == 0) {
                        if (i2 > 0) {
                            sb.append("\n");
                        }
                        substring = "  ";
                    } else {
                        if (readLine2.length() > 16) {
                            i = 28;
                        }
                        substring = "                ".substring(0, i - i3);
                    }
                    sb.append(substring);
                    i3 = readLine2.length();
                    sb.append(readLine2);
                    i2++;
                }
                sb.append("\n");
                String sb2 = sb.toString();
                if (b != null) {
                    try {
                        b.close();
                        return sb2;
                    } catch (Exception e) {
                        al.a(e);
                    }
                }
                return sb2;
            }
            if (b != null) {
                try {
                    b.close();
                    return null;
                } catch (Exception e2) {
                    al.a(e2);
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                al.a(th);
                if (b != null) {
                    try {
                        b.close();
                        return null;
                    } catch (Exception e3) {
                        al.a(e3);
                        return null;
                    }
                }
                return null;
            } catch (Throwable th2) {
                if (b != null) {
                    try {
                        b.close();
                    } catch (Exception e4) {
                        al.a(e4);
                    }
                }
                throw th2;
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader b = ap.b(str, "map_record.txt");
        if (b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = b.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = b.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(readLine2);
                    sb.append("\n");
                }
                String sb2 = sb.toString();
                if (b != null) {
                    try {
                        b.close();
                        return sb2;
                    } catch (Exception e) {
                        al.a(e);
                    }
                }
                return sb2;
            }
            if (b != null) {
                try {
                    b.close();
                    return null;
                } catch (Exception e2) {
                    al.a(e2);
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                al.a(th);
                if (b != null) {
                    try {
                        b.close();
                        return null;
                    } catch (Exception e3) {
                        al.a(e3);
                        return null;
                    }
                }
                return null;
            } catch (Throwable th2) {
                if (b != null) {
                    try {
                        b.close();
                    } catch (Exception e4) {
                        al.a(e4);
                    }
                }
                throw th2;
            }
        }
    }

    public static void c(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (!file.canRead() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return;
            }
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                File file2 = listFiles[i2];
                if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                    file2.delete();
                    al.c("Delete empty record file %s", file2.getAbsoluteFile());
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            al.a(th);
        }
    }

    private static Map<String, Integer> d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return hashMap;
                }
                String str2 = split[i2];
                String[] split2 = str2.split(":");
                if (split2.length != 2) {
                    al.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
                i = i2 + 1;
            }
        } catch (Exception e) {
            al.e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }
}
