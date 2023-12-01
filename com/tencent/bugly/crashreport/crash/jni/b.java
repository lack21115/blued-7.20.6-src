package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fw;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.openalliance.ad.constant.ao;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import com.tencent.tendinsv.a.b;
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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/jni/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static List<File> f21493a = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.BufferedInputStream] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        String str2;
        String str3;
        String a2;
        if (context == null || str == null || nativeExceptionHandler == null) {
            x.e("get eup record file args error", new Object[0]);
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
                            x.e("record not pair! drop! %s", str3);
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
                    x.e("record read fail! %s", a3);
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

    private static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        HashMap hashMap;
        if (map == null) {
            return null;
        }
        if (com.tencent.bugly.crashreport.common.info.a.a(context) == null) {
            x.e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str2 = map.get("intStateStr");
        if (str2 == null || str2.trim().length() <= 0) {
            x.e("no intStateStr", new Object[0]);
            return null;
        }
        Map<String, Integer> d = d(str2);
        if (d == null) {
            x.e("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            d.get("sino").intValue();
            d.get("sud").intValue();
            String str3 = map.get("soVersion");
            if (TextUtils.isEmpty(str3)) {
                x.e("error format at version", new Object[0]);
                return null;
            }
            String str4 = map.get("errorAddr");
            if (str4 == null) {
                str4 = "unknown";
            }
            String str5 = map.get("codeMsg");
            String str6 = str5;
            if (str5 == null) {
                str6 = "unknown";
            }
            String str7 = map.get("tombPath");
            if (str7 == null) {
                str7 = "unknown";
            }
            String str8 = map.get("signalName");
            String str9 = str8;
            if (str8 == null) {
                str9 = "unknown";
            }
            map.get("errnoMsg");
            String str10 = map.get("stack");
            String str11 = str10;
            if (str10 == null) {
                str11 = "unknown";
            }
            String str12 = map.get("jstack");
            String str13 = str11;
            if (str12 != null) {
                str13 = str11 + "java:\n" + str12;
            }
            Integer num = d.get("sico");
            if (num == null || num.intValue() <= 0) {
                str = str6;
            } else {
                str9 = str9 + "(" + str6 + ")";
                str = "KERNEL";
            }
            String str14 = map.get("nativeLog");
            byte[] a2 = (str14 == null || str14.isEmpty()) ? null : z.a((File) null, str14, "BuglyNativeLog.txt");
            String str15 = map.get("sendingProcess");
            String str16 = str15;
            if (str15 == null) {
                str16 = "unknown";
            }
            Integer num2 = d.get("spd");
            String str17 = str16;
            if (num2 != null) {
                str17 = str16 + "(" + num2 + ")";
            }
            String str18 = map.get("threadName");
            String str19 = str18;
            if (str18 == null) {
                str19 = "unknown";
            }
            Integer num3 = d.get("et");
            String str20 = str19;
            if (num3 != null) {
                str20 = str19 + "(" + num3 + ")";
            }
            String str21 = map.get(b.a.u);
            if (str21 == null) {
                str21 = "unknown";
            }
            Integer num4 = d.get("ep");
            String str22 = str21;
            if (num4 != null) {
                str22 = str21 + "(" + num4 + ")";
            }
            String str23 = map.get("key-value");
            if (str23 != null) {
                HashMap hashMap2 = new HashMap();
                String[] split = str23.split("\n");
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String[] split2 = split[i2].split("=");
                    if (split2.length == 2) {
                        hashMap2.put(split2[0], split2[1]);
                    }
                    i = i2 + 1;
                }
                hashMap = hashMap2;
            } else {
                hashMap = null;
            }
            CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str22, str20, (d.get("etms").intValue() / 1000) + (d.get("ets").intValue() * 1000), str9, str4, a(str13), str, str17, str7, map.get("sysLogPath"), map.get("jniLogPath"), str3, a2, hashMap, false, false);
            if (packageCrashDatas != null) {
                String str24 = map.get(ao.q);
                if (str24 != null) {
                    x.c("[Native record info] userId: %s", str24);
                    packageCrashDatas.m = str24;
                }
                String str25 = map.get("sysLog");
                if (str25 != null) {
                    packageCrashDatas.w = str25;
                }
                String str26 = map.get(AttributionReporter.APP_VERSION);
                if (str26 != null) {
                    x.c("[Native record info] appVersion: %s", str26);
                    packageCrashDatas.f = str26;
                }
                String str27 = map.get("isAppForeground");
                if (str27 != null) {
                    x.c("[Native record info] isAppForeground: %s", str27);
                    packageCrashDatas.N = str27.equalsIgnoreCase(fw.Code);
                }
                String str28 = map.get("launchTime");
                if (str28 != null) {
                    x.c("[Native record info] launchTime: %s", str28);
                    try {
                        packageCrashDatas.M = Long.parseLong(str28);
                    } catch (NumberFormatException e) {
                        if (!x.a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                packageCrashDatas.z = null;
                packageCrashDatas.k = true;
            }
            return packageCrashDatas;
        } catch (Throwable th) {
            x.e("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    private static String a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        byteArrayOutputStream2.close();
                        return null;
                    } else if (read == 0) {
                        String str = new String(byteArrayOutputStream2.toByteArray(), "UTf-8");
                        byteArrayOutputStream2.close();
                        return str;
                    } else {
                        byteArrayOutputStream2.write(read);
                    }
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th;
                    try {
                        x.a(th);
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
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
        x.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
        f21493a.add(file);
        x.c("Add this record file to list for cleaning lastly.", new Object[0]);
        if (str2 == null) {
            return z.a(new File(str), i, z);
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
                            x.a(th);
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
                                    x.a(e);
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
            x.a(e2);
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

    public static void a(boolean z, String str) {
        if (str != null) {
            f21493a.add(new File(str, "rqd_record.eup"));
            f21493a.add(new File(str, "reg_record.txt"));
            f21493a.add(new File(str, "map_record.txt"));
            f21493a.add(new File(str, "backup_record.txt"));
            if (z) {
                c(str);
            }
        }
        List<File> list = f21493a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f21493a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                x.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
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
        BufferedReader a2 = z.a(str, "reg_record.txt");
        if (a2 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = a2.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                int i = 18;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    String readLine2 = a2.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    if (i2 % 4 == 0) {
                        if (i2 > 0) {
                            sb.append("\n");
                        }
                        sb.append("  ");
                    } else {
                        if (readLine2.length() > 16) {
                            i = 28;
                        }
                        sb.append("                ".substring(0, i - i3));
                    }
                    i3 = readLine2.length();
                    sb.append(readLine2);
                    i2++;
                }
                sb.append("\n");
                String sb2 = sb.toString();
                if (a2 != null) {
                    try {
                        a2.close();
                        return sb2;
                    } catch (Exception e) {
                        x.a(e);
                    }
                }
                return sb2;
            }
            if (a2 != null) {
                try {
                    a2.close();
                    return null;
                } catch (Exception e2) {
                    x.a(e2);
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                x.a(th);
                if (a2 != null) {
                    try {
                        a2.close();
                        return null;
                    } catch (Exception e3) {
                        x.a(e3);
                        return null;
                    }
                }
                return null;
            } catch (Throwable th2) {
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e4) {
                        x.a(e4);
                    }
                }
                throw th2;
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader a2 = z.a(str, "map_record.txt");
        if (a2 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = a2.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = a2.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(readLine2);
                    sb.append("\n");
                }
                String sb2 = sb.toString();
                if (a2 != null) {
                    try {
                        a2.close();
                        return sb2;
                    } catch (Exception e) {
                        x.a(e);
                    }
                }
                return sb2;
            }
            if (a2 != null) {
                try {
                    a2.close();
                    return null;
                } catch (Exception e2) {
                    x.a(e2);
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                x.a(th);
                if (a2 != null) {
                    try {
                        a2.close();
                        return null;
                    } catch (Exception e3) {
                        x.a(e3);
                        return null;
                    }
                }
                return null;
            } catch (Throwable th2) {
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e4) {
                        x.a(e4);
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
                    x.c("Delete empty record file %s", file2.getAbsoluteFile());
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            x.a(th);
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
                    x.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
                i = i2 + 1;
            }
        } catch (Exception e) {
            x.e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }
}
