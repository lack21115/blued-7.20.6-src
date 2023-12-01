package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/d.class */
public abstract class d {
    protected String mErrorMessage = "";
    protected e mUploader;

    private void a(ExceptionMessage exceptionMessage, List<File> list, CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "compressAndUpload");
        File zu = this.mUploader.zu();
        if (!zu.exists()) {
            zu.mkdir();
        }
        File file = new File(zu, exceptionMessage.mLogUUID + ".zip");
        StringBuilder sb = new StringBuilder("compressAndUpload zipFile=");
        sb.append(file.getPath());
        com.kwad.sdk.core.d.b.d("ExceptionCollector", sb.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            }
        }
        m.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() <= 0) {
            q.N(file);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", exceptionMessage.mLogUUID);
        new JSONObject(hashMap);
        b(file, countDownLatch);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(File file, ExceptionMessage exceptionMessage) {
        BufferedReader bufferedReader;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        ThreadInfo threadInfo = new ThreadInfo();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                memoryInfo.mJavaThreads = arrayList;
                                exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                return;
                            } else if (readLine.isEmpty()) {
                                arrayList.add(threadInfo);
                                threadInfo = new ThreadInfo();
                            } else {
                                if (!readLine.startsWith("at ") && !readLine.startsWith("(no ")) {
                                    threadInfo.mName = readLine;
                                }
                                if (threadInfo.mTrace != null) {
                                    readLine = threadInfo.mTrace + readLine;
                                }
                                threadInfo.mTrace = readLine;
                                threadInfo.mTrace += "#";
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (Throwable th) {
                        bufferedReader2 = bufferedReader;
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
        }
    }

    private static void b(File file, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    private static String dS(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.contains("-")) {
                str2 = str.substring(0, str.lastIndexOf(45));
            }
        }
        return str2;
    }

    protected abstract ExceptionMessage a(File file, File file2, File file3, String str);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    public final void a(File file, CountDownLatch countDownLatch) {
        File[] listFiles;
        String dW = com.kwad.sdk.crash.utils.g.dW(file.getPath());
        File file2 = new File(dW + ".msg");
        File file3 = new File(dW + com.anythink.china.common.a.a.f);
        File file4 = new File(dW + ".blog");
        File file5 = new File(dW + ".jtrace");
        File file6 = new File(dW + ".minfo");
        ArrayList<File> arrayList = new ArrayList();
        try {
            ExceptionMessage a2 = a(file, file2, file3, dW);
            if (a2 == null) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    for (File file7 : arrayList) {
                        q.delete(file7.getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    return;
                }
            }
            com.kwad.sdk.core.d.b.d("ExceptionCollector", "message.mCrashSource=" + a2.mCrashSource);
            if (a2.mCrashSource == 2) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    for (File file8 : arrayList) {
                        q.delete(file8.getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(a2, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", " java crash 不上传文件");
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    for (File file9 : arrayList) {
                        q.delete(file9.getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th3) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th3);
                    return;
                }
            }
            com.kwad.sdk.crash.utils.g.z(file4);
            ArrayList arrayList2 = new ArrayList();
            Collections.addAll(arrayList2, file3, file4);
            Iterator<File> it = arrayList2.iterator();
            while (it.hasNext()) {
                if (!it.next().exists()) {
                    it.remove();
                }
            }
            File file10 = new File(file.getParentFile().getParent(), "custom");
            if (file10.exists()) {
                for (File file11 : file10.listFiles()) {
                    if (!file11.isDirectory() && (file11.getName().startsWith(a2.mLogUUID) || file11.getName().startsWith(dS(a2.mLogUUID)))) {
                        arrayList.add(file11);
                    }
                }
                arrayList2.addAll(arrayList);
            }
            a(a2, arrayList2, countDownLatch);
            try {
                q.delete(file.getPath());
                q.delete(file3.getPath());
                q.delete(file4.getPath());
                q.delete(file2.getPath());
                q.delete(file5.getPath());
                q.delete(file6.getPath());
                for (File file12 : arrayList) {
                    q.delete(file12.getPath());
                }
                com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th4) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th5);
                com.kwad.sdk.crash.utils.g.k(th5);
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    for (File file13 : arrayList) {
                        q.delete(file13.getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th6);
                }
            } catch (Throwable th7) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    for (File file14 : arrayList) {
                        q.delete(file14.getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th8) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th8);
                }
                throw th7;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(File file, ExceptionMessage exceptionMessage) {
        BufferedReader bufferedReader;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                            return;
                        } else if (z || !readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                            if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                if (readLine.contains("dvm_lock_sample")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                        sb2 = new StringBuilder();
                                        sb2.append(readLine);
                                        sb2.append("\n");
                                    } else {
                                        sb2 = new StringBuilder();
                                        sb2.append(exceptionMessage.mLockInfo);
                                        sb2.append(readLine);
                                        sb2.append("\n");
                                    }
                                    exceptionMessage.mLockInfo = sb2.toString();
                                } else if (readLine.contains("Long monitor")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                        sb3 = new StringBuilder();
                                        sb3.append(readLine);
                                        sb3.append("\n");
                                    } else {
                                        sb3 = new StringBuilder();
                                        sb3.append(exceptionMessage.mMonitorInfo);
                                        sb3.append(readLine);
                                        sb3.append("\n");
                                    }
                                    exceptionMessage.mMonitorInfo = sb3.toString();
                                } else if (readLine.contains("Slow Looper")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                        sb4 = new StringBuilder();
                                        sb4.append(readLine);
                                        sb4.append("\n");
                                    } else {
                                        sb4 = new StringBuilder();
                                        sb4.append(exceptionMessage.mSlowLooper);
                                        sb4.append(readLine);
                                        sb4.append("\n");
                                    }
                                    exceptionMessage.mSlowLooper = sb4.toString();
                                } else if (readLine.contains("Slow Operation")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                        sb5 = new StringBuilder();
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    } else {
                                        sb5 = new StringBuilder();
                                        sb5.append(exceptionMessage.mSlowOperation);
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    }
                                    exceptionMessage.mSlowOperation = sb5.toString();
                                }
                            }
                            if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                sb = new StringBuilder();
                                sb.append(readLine);
                                sb.append("\n");
                            } else {
                                sb = new StringBuilder();
                                sb.append(exceptionMessage.mGCInfo);
                                sb.append(readLine);
                                sb.append("\n");
                            }
                            exceptionMessage.mGCInfo = sb.toString();
                        } else {
                            exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                            z = true;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        StringBuilder sb6 = new StringBuilder();
                        BufferedReader bufferedReader3 = bufferedReader;
                        sb6.append(this.mErrorMessage);
                        BufferedReader bufferedReader4 = bufferedReader;
                        sb6.append(e);
                        BufferedReader bufferedReader5 = bufferedReader;
                        sb6.append("\n");
                        BufferedReader bufferedReader6 = bufferedReader;
                        this.mErrorMessage = sb6.toString();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e2) {
                        e = e2;
                        StringBuilder sb7 = new StringBuilder();
                        BufferedReader bufferedReader7 = bufferedReader;
                        sb7.append(this.mErrorMessage);
                        BufferedReader bufferedReader8 = bufferedReader;
                        sb7.append(e);
                        BufferedReader bufferedReader9 = bufferedReader;
                        sb7.append("\n");
                        BufferedReader bufferedReader10 = bufferedReader;
                        this.mErrorMessage = sb7.toString();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        bufferedReader2 = bufferedReader;
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedReader = null;
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void x(File file) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
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
            a(listFiles[i2], (CountDownLatch) null);
            i = i2 + 1;
        }
    }
}
