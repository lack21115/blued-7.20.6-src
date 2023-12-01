package com.umeng.commonsdk.internal.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/d.class */
public class d {

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f27186a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public int f27187c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
    }

    /* JADX WARN: Removed duplicated region for block: B:220:0x02b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x028b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.umeng.commonsdk.internal.utils.d.a a() {
        /*
            Method dump skipped, instructions count: 766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.d.a():com.umeng.commonsdk.internal.utils.d$a");
    }

    public static String b() {
        String str = "";
        String str2 = str;
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (true) {
                String str3 = str;
                if (inputStream.read(bArr) == -1) {
                    break;
                }
                String str4 = str;
                StringBuilder sb = new StringBuilder();
                String str5 = str;
                sb.append(str);
                String str6 = str;
                sb.append(new String(bArr));
                String str7 = str;
                str = sb.toString();
            }
            str2 = str;
            inputStream.close();
        } catch (Exception e) {
            str = str2;
        }
        return str.trim();
    }

    public static String c() {
        String str = "";
        String str2 = str;
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (true) {
                String str3 = str;
                if (inputStream.read(bArr) == -1) {
                    break;
                }
                String str4 = str;
                StringBuilder sb = new StringBuilder();
                String str5 = str;
                sb.append(str);
                String str6 = str;
                sb.append(new String(bArr));
                String str7 = str;
                str = sb.toString();
            }
            str2 = str;
            inputStream.close();
        } catch (Exception e) {
            str = str2;
        }
        return str.trim();
    }

    public static String d() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                String trim = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                    return trim;
                } catch (Throwable th) {
                    return trim;
                }
            } catch (Exception e) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        return "";
                    } catch (Throwable th2) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
    }
}
