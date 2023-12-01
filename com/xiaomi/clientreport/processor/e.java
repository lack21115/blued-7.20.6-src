package com.xiaomi.clientreport.processor;

import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.x;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/processor/e.class */
public class e {
    private static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] m8356a;
        if (perfClientReport == null || (m8356a = m8356a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = m8356a[0];
        perfClientReport.perfLatencies = m8356a[1];
        return perfClientReport;
    }

    private static PerfClientReport a(String str) {
        PerfClientReport perfClientReport;
        PerfClientReport perfClientReport2 = null;
        try {
            String[] m8357a = m8357a(str);
            perfClientReport = null;
            if (m8357a != null) {
                perfClientReport = null;
                if (m8357a.length >= 4) {
                    perfClientReport = null;
                    if (!TextUtils.isEmpty(m8357a[0])) {
                        perfClientReport = null;
                        if (!TextUtils.isEmpty(m8357a[1])) {
                            perfClientReport = null;
                            if (!TextUtils.isEmpty(m8357a[2])) {
                                perfClientReport = null;
                                if (!TextUtils.isEmpty(m8357a[3])) {
                                    PerfClientReport blankInstance = PerfClientReport.getBlankInstance();
                                    blankInstance.production = Integer.parseInt(m8357a[0]);
                                    blankInstance.clientInterfaceId = m8357a[1];
                                    blankInstance.reportType = Integer.parseInt(m8357a[2]);
                                    perfClientReport2 = blankInstance;
                                    blankInstance.code = Integer.parseInt(m8357a[3]);
                                    return blankInstance;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.c("parse per key error");
            perfClientReport = perfClientReport2;
        }
        return perfClientReport;
    }

    public static String a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static HashMap<String, String> m8355a(String str) {
        BufferedReader bufferedReader;
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(str));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                x.a(bufferedReader);
                                return hashMap;
                            }
                            String[] split = readLine.split("%%%");
                            if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                hashMap.put(split[0], split[1]);
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedReader2 = bufferedReader;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            x.a(bufferedReader);
                            return hashMap;
                        } catch (Throwable th) {
                            bufferedReader2 = bufferedReader;
                            th = th;
                            x.a(bufferedReader2);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
            }
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0149, code lost:
        if (r6 != null) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(android.content.Context r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.e.a(android.content.Context, java.lang.String):java.util.List");
    }

    private static void a(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Throwable th;
        BufferedWriter bufferedWriter2;
        BufferedWriter bufferedWriter3;
        BufferedWriter bufferedWriter4;
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedWriter4 = new BufferedWriter(new FileWriter(file));
            bufferedWriter3 = bufferedWriter4;
        } catch (Exception e) {
            e = e;
            bufferedWriter2 = null;
        } catch (Throwable th2) {
            bufferedWriter = null;
            th = th2;
            x.a(bufferedWriter);
            throw th;
        }
        try {
            try {
                for (String str2 : hashMap.keySet()) {
                    String str3 = hashMap.get(str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append("%%%");
                    sb.append(str3);
                    bufferedWriter4.write(sb.toString());
                    bufferedWriter4.newLine();
                }
                x.a(bufferedWriter4);
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter3;
                x.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e2) {
            bufferedWriter2 = bufferedWriter4;
            e = e2;
            bufferedWriter3 = bufferedWriter2;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            x.a(bufferedWriter2);
        }
    }

    public static void a(String str, com.xiaomi.clientreport.data.a[] aVarArr) {
        RandomAccessFile randomAccessFile;
        if (aVarArr == null || aVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = null;
        try {
            File file = new File(str + ".lock");
            x.m9172a(file);
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            fileLock = null;
            try {
                FileLock lock = randomAccessFile2.getChannel().lock();
                HashMap<String, String> m8355a = m8355a(str);
                int length = aVarArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    com.xiaomi.clientreport.data.a aVar = aVarArr[i2];
                    if (aVar != null) {
                        String a2 = a((PerfClientReport) aVar);
                        long j = ((PerfClientReport) aVar).perfCounts;
                        long j2 = ((PerfClientReport) aVar).perfLatencies;
                        if (!TextUtils.isEmpty(a2) && j > 0 && j2 >= 0) {
                            a(m8355a, a2, j, j2);
                        }
                    }
                    i = i2 + 1;
                }
                fileLock = lock;
                a(str, m8355a);
                if (lock != null && lock.isValid()) {
                    try {
                        lock.release();
                    } catch (IOException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                x.a(randomAccessFile2);
            } catch (Throwable th) {
                randomAccessFile = randomAccessFile2;
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("failed to write perf to file ");
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                    x.a(randomAccessFile);
                } catch (Throwable th2) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                        }
                    }
                    x.a(randomAccessFile);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            randomAccessFile = null;
        }
    }

    private static void a(HashMap<String, String> hashMap, String str, long j, long j2) {
        StringBuilder sb;
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            hashMap.put(str, j + "#" + j2);
            return;
        }
        long[] m8356a = m8356a(str2);
        if (m8356a == null || m8356a[0] <= 0 || m8356a[1] < 0) {
            sb = new StringBuilder();
        } else {
            j += m8356a[0];
            j2 += m8356a[1];
            sb = new StringBuilder();
        }
        sb.append(j);
        sb.append("#");
        sb.append(j2);
        hashMap.put(str, sb.toString());
    }

    /* renamed from: a  reason: collision with other method in class */
    protected static long[] m8356a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String[] m8357a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }
}
