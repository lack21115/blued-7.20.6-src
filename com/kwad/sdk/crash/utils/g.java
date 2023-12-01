package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.s;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/g.class */
public final class g {
    private static final File atd = new File("/proc/self/fd");
    private static final File ate = new File("/proc/self/task");

    public static void A(File file) {
        if (file == null) {
            return;
        }
        try {
            q.O(file);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    private static int Ak() {
        File[] listFiles;
        ao.checkNotNull(atd);
        if (atd.exists() && atd.isDirectory() && (listFiles = atd.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    public static void B(File file) {
        BufferedWriter bufferedWriter;
        try {
            q.K(file);
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                    try {
                        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                            String b = b(entry.getValue());
                            String str = b;
                            if (b.isEmpty()) {
                                str = "(no managed stack frames)\n";
                            }
                            bufferedWriter.write(entry.getKey().getName());
                            bufferedWriter.newLine();
                            bufferedWriter.write(str);
                            bufferedWriter.newLine();
                        }
                        b.closeQuietly(bufferedWriter);
                    } catch (FileNotFoundException e) {
                        e = e;
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (IOException e2) {
                        e = e2;
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (Throwable th) {
                        bufferedWriter2 = bufferedWriter;
                        th = th;
                        b.closeQuietly(bufferedWriter2);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedWriter = null;
                } catch (IOException e4) {
                    e = e4;
                    bufferedWriter = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e5);
        }
    }

    public static void C(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object d = s.d(s.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.ch(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.ch(24)) {
                s.a(d, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, new String[0]);
            } else if (SystemUtil.ch(23)) {
                s.a(d, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, new String[0]);
            } else if (SystemUtil.ch(19)) {
                s.a(d, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.ch(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            s.a(d, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(com.kwad.sdk.crash.e.zy().getContext())});
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    private static String T(String str, String str2) {
        ao.eK(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    private static double X(long j) {
        return BigDecimal.valueOf(((float) (j >> 20)) / 1024.0f).setScale(2, 4).floatValue();
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return sb.substring(0);
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            sb.append("at ");
            sb.append(stackTraceElement);
            sb.append('\n');
            i2 = i3 + 1;
        }
    }

    public static void a(ExceptionMessage exceptionMessage, int i) {
        com.kwad.sdk.crash.h zE = com.kwad.sdk.crash.e.zy().zE();
        if (zE == null) {
            com.kwad.sdk.core.d.b.d("tag", "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = zE.mA().toString();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if ("Unknown".equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName)) {
                exceptionMessage.mProcessName = processName;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.e.zy().zF();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.e.zy().zC()));
        exceptionMessage.mBuildConfigInfo = bp(context);
        e(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = bo(context);
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = X(h.getTotalBytes(path));
            if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(1024L)) {
                diskInfo.mDataAvailableGB = X(h.getAvailableBytes(path));
            }
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = X(h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = X(h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, Context context) {
        List<String> list;
        String canonicalPath;
        SystemUtil.a EB = SystemUtil.EB();
        EB.aAS = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        EB.aAO = SystemUtil.EA();
        EB.aAR = Debug.getPss();
        memoryInfo.mTotalMB = (int) (EB.aAO / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.d.aqZ / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (EB.aAS / 1048576);
        memoryInfo.mVssMB = (int) (EB.aAP / 1024);
        memoryInfo.mRssMB = (int) (EB.aAQ / 1024);
        memoryInfo.mPssMB = (int) (EB.aAR / 1024);
        memoryInfo.mThreadsCount = EB.mThreadsCount;
        memoryInfo.mFdCount = Ak();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.cP(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = atd.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    File file = listFiles[i2];
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            list = memoryInfo.mFds;
                            canonicalPath = Os.readlink(file.getPath());
                        } else {
                            list = memoryInfo.mFds;
                            canonicalPath = file.getCanonicalPath();
                        }
                        list.add(canonicalPath);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                    }
                    i = i2 + 1;
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (EB.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
                private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] listFiles = ate.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file = listFiles[i2];
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.D(new File(file, "comm"));
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = T(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
            i = i2 + 1;
        }
    }

    public static void a(com.kwad.sdk.crash.report.e eVar, String str, File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String readLine;
        try {
            q.K(file);
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    BufferedReader bufferedReader4 = new BufferedReader(new FileReader(file));
                    if (eVar != null) {
                        do {
                            try {
                                readLine = bufferedReader4.readLine();
                                if (readLine == null) {
                                    break;
                                }
                            } catch (FileNotFoundException e) {
                                bufferedReader2 = bufferedReader4;
                                e = e;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader2);
                                return;
                            } catch (IOException e2) {
                                bufferedReader = bufferedReader4;
                                e = e2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader3 = bufferedReader4;
                                b.closeQuietly(bufferedReader3);
                                throw th;
                            }
                        } while (!readLine.isEmpty());
                    }
                    b.closeQuietly(bufferedReader4);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedReader2 = null;
                } catch (IOException e4) {
                    e = e4;
                    bufferedReader = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e5);
        }
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    private static void a(File file, CharSequence charSequence, Charset charset, boolean z) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    public static void a(File file, CharSequence charSequence, boolean z) {
        a(file, charSequence, Charset.defaultCharset(), true);
    }

    private static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                FileOutputStream a2 = q.a(file, z);
                h.a(str, a2, charset);
                fileOutputStream2 = a2;
                fileOutputStream = a2;
                a(a2);
                b.closeQuietly(a2);
            } catch (Exception e) {
                fileOutputStream2 = fileOutputStream;
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                b.closeQuietly(fileOutputStream);
            }
        } catch (Throwable th) {
            b.closeQuietly(fileOutputStream2);
            throw th;
        }
    }

    private static void a(Throwable th, ExceptionMessage exceptionMessage) {
        if (j(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
                return true;
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                return false;
            }
        }
        return true;
    }

    private static String b(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    private static void b(ExceptionMessage exceptionMessage, Context context) {
        String absolutePath;
        String packageName;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (com.kwad.sdk.crash.d.ara.matcher(absolutePath).matches() || com.kwad.sdk.crash.d.arb.matcher(absolutePath).matches()) {
            packageName = context.getPackageName();
        } else {
            Matcher matcher = com.kwad.sdk.crash.d.arc.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.d.ard.matcher(absolutePath);
            if (matcher.matches()) {
                packageName = matcher.group(1);
            } else if (!matcher2.matches()) {
                exceptionMessage.mVirtualApp = absolutePath;
                return;
            } else {
                packageName = matcher2.group(1);
            }
        }
        exceptionMessage.mVirtualApp = packageName;
    }

    public static void b(File file, File file2) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        try {
            q.K(file);
            q.K(file2);
            BufferedReader bufferedReader3 = null;
            BufferedWriter bufferedWriter = null;
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    bufferedWriter = null;
                    bufferedReader3 = bufferedReader;
                    try {
                        BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(file2, true));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                bufferedWriter3.write(readLine);
                                bufferedWriter3.newLine();
                            } catch (FileNotFoundException e) {
                                bufferedWriter2 = bufferedWriter3;
                                bufferedReader2 = bufferedReader;
                                e = e;
                                bufferedWriter = bufferedWriter2;
                                bufferedReader3 = bufferedReader2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter2);
                                bufferedReader = bufferedReader2;
                                b.closeQuietly(bufferedReader);
                            } catch (IOException e2) {
                                bufferedWriter2 = bufferedWriter3;
                                bufferedReader2 = bufferedReader;
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                bufferedReader3 = bufferedReader2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter2);
                                bufferedReader = bufferedReader2;
                                b.closeQuietly(bufferedReader);
                            } catch (Throwable th) {
                                bufferedWriter = bufferedWriter3;
                                th = th;
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        b.closeQuietly(bufferedWriter3);
                    } catch (FileNotFoundException e3) {
                        bufferedReader2 = bufferedReader;
                        e = e3;
                    } catch (IOException e4) {
                        bufferedReader2 = bufferedReader;
                        e = e4;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    bufferedReader2 = null;
                } catch (IOException e6) {
                    e = e6;
                    bufferedReader2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                b.closeQuietly(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader3;
            }
        } catch (IOException e7) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e7);
        }
    }

    private static void b(Throwable th, ExceptionMessage exceptionMessage) {
        String k = k(th);
        String str = k;
        if (th instanceof StackOverflowError) {
            str = dZ(k);
        }
        exceptionMessage.mCrashDetail = str.replaceAll("[\n\t]", "#");
    }

    public static void b(Throwable th, ExceptionMessage exceptionMessage, Context context) {
        if (th != null) {
            b(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th, exceptionMessage);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable, java.io.InputStream] */
    private static String bo(Context context) {
        Closeable closeable = null;
        Closeable closeable2 = null;
        Closeable closeable3 = null;
        try {
            try {
                try {
                    context = context.getResources().getAssets().open("apk.json");
                    closeable3 = context;
                    closeable = context;
                    closeable2 = context;
                    String string = new JSONObject(h.d(context)).getString("task_id");
                    b.closeQuietly((Closeable) context);
                    return string;
                } catch (IOException e) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                    b.closeQuietly(closeable);
                    return "";
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    b.closeQuietly(closeable3);
                    return "";
                }
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                b.closeQuietly(closeable2);
                return "";
            }
        } catch (Throwable th2) {
            b.closeQuietly((Closeable) context);
            throw th2;
        }
    }

    private static String bp(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: " + com.kwad.sdk.crash.e.zy().getSdkVersion() + "\n");
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb.append("DexPath: " + bq(context) + "\n");
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
        return sb.toString();
    }

    private static String bq(Context context) {
        String[] split;
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb2 = new StringBuilder("ClassLoader ");
            int i = 0;
            sb2.append(0);
            sb2.append(" : ");
            sb2.append(obj);
            while (true) {
                sb.append(sb2.toString());
                if (classLoader.getParent() == null) {
                    break;
                }
                classLoader = classLoader.getParent();
                i++;
                sb2 = new StringBuilder("\nClassLoader ");
                sb2.append(i);
                sb2.append(" : ");
                sb2.append(classLoader.toString());
            }
            if (obj != null) {
                if (obj.split("\"").length >= 2) {
                    sb.append("\n====path: " + split[1] + ", length: " + dY(split[1]));
                }
            }
        }
        return sb.toString();
    }

    public static String dW(String str) {
        String str2 = str;
        if (str.contains(".")) {
            str2 = str.substring(0, str.lastIndexOf(46));
        }
        return str2;
    }

    public static String dX(String str) {
        String str2 = str;
        if (str.contains("(")) {
            str2 = str;
            if (str.contains(")")) {
                str2 = str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41));
            }
        }
        return str2;
    }

    private static long dY(String str) {
        long j = -1;
        try {
            File file = new File(str);
            if (file.exists()) {
                j = file.length();
            }
            return j;
        } catch (Exception e) {
            return -1L;
        }
    }

    private static String dZ(String str) {
        HashSet hashSet = new HashSet();
        String[] split = str.split("\n");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            hashSet.add(split[i2]);
            i = i2 + 1;
        }
        ArrayList<String> arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            sb.append(str2);
            sb.append("\n");
        }
        return sb.substring(0);
    }

    private static void e(ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.e.zy().zB();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.e.zy().getSdkVersion();
    }

    public static int getIndex(String str) {
        if (str.contains("-")) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    private static boolean j(Throwable th) {
        Throwable th2 = th;
        if (th == null) {
            return false;
        }
        while (th2.getCause() != null) {
            th2 = th2.getCause();
        }
        return th2 instanceof OutOfMemoryError;
    }

    public static String k(Throwable th) {
        StringWriter stringWriter;
        String th2 = th.toString();
        StringWriter stringWriter2 = null;
        try {
            try {
                StringWriter stringWriter3 = new StringWriter();
                try {
                    f.a(th, new PrintWriter(stringWriter3));
                    String stringWriter4 = stringWriter3.toString();
                    b.closeQuietly(stringWriter3);
                    return stringWriter4;
                } catch (Exception e) {
                    stringWriter = stringWriter3;
                    e = e;
                    stringWriter2 = stringWriter;
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                    b.closeQuietly(stringWriter);
                    return th2;
                } catch (Throwable th3) {
                    th = th3;
                    stringWriter2 = stringWriter3;
                    b.closeQuietly(stringWriter2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e2) {
            e = e2;
            stringWriter = null;
        }
    }

    public static void z(File file) {
        try {
            d.a(SystemUtil.ch(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", com.umeng.analytics.pro.d.f40716ar, "-b", CrashHianalyticsData.EVENT_ID_CRASH, "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", com.umeng.analytics.pro.d.f40716ar, "-d", "-f", file.getPath()}, 0);
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }
}
