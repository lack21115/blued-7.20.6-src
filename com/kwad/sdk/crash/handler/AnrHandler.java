package com.kwad.sdk.crash.handler;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.util.Printer;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/handler/AnrHandler.class */
public final class AnrHandler extends b {
    private static final String ANR_HAPPENED_BEGIN = "------ ANR Happened Begin ------\n";
    private static final String DEFAULT_TRACE_ROOT = "/data/anr/";
    private static final long GET_REASON_INTERVAL = 500;
    private static final long PARSE_TRACE_INTERVAL = 10000;
    private static final String TAG = "AnrHandler";
    private static final long TRY_TIMES = 20;
    private static long sLastTime;
    private FileObserver mTraceFileObserver;
    private static final int MY_PID = Process.myPid();
    private static final Pattern PID_PATTERN = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
    private static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.ch(21);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/handler/AnrHandler$a.class */
    public static final class a {
        private static final AnrHandler arr = new AnrHandler();
    }

    private AnrHandler() {
    }

    private static void dumpAnr(String str, int i) {
        synchronized (AnrHandler.class) {
            try {
                com.kwad.sdk.core.d.b.d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i);
                AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
                File file = getInstance().mLogDir;
                boolean z = true;
                if (!file.exists()) {
                    z = true;
                    if (!file.mkdirs()) {
                        com.kwad.sdk.core.d.b.d(TAG, "ANR dumpAnr create dir failed.");
                        StringBuilder sb = new StringBuilder();
                        sb.append(anrExceptionMessage.mErrorMessage);
                        sb.append("create ");
                        sb.append(file.getPath());
                        sb.append(" failed!\n");
                        anrExceptionMessage.mErrorMessage = sb.toString();
                        z = false;
                    }
                }
                if (str != null && z) {
                    StringBuilder sb2 = new StringBuilder();
                    boolean z2 = z;
                    getInstance();
                    boolean z3 = z;
                    sb2.append(FILE_NAME_BASE);
                    boolean z4 = z;
                    sb2.append("-");
                    boolean z5 = z;
                    sb2.append(i);
                    boolean z6 = z;
                    sb2.append(".dump");
                    boolean z7 = z;
                    File file2 = new File(file, sb2.toString());
                    boolean z8 = z;
                    q.d(new File(str), file2);
                    boolean z9 = z;
                    StringBuilder sb3 = new StringBuilder();
                    boolean z10 = z;
                    getInstance();
                    boolean z11 = z;
                    sb3.append(FILE_NAME_BASE);
                    boolean z12 = z;
                    sb3.append("-");
                    boolean z13 = z;
                    sb3.append(i);
                    boolean z14 = z;
                    sb3.append(com.anythink.china.common.a.a.f);
                    boolean z15 = z;
                    g.z(new File(file, sb3.toString()));
                }
                boolean z16 = z;
                g.b(null, anrExceptionMessage, e.zy().getContext());
                boolean z17 = z;
                g.a(anrExceptionMessage, 3);
                boolean z18 = z;
                if (getInstance().mExceptionListener != null) {
                    boolean z19 = z;
                    getInstance().mExceptionListener.a(getInstance().getCrashType(), anrExceptionMessage);
                }
                dumpAnrReason(str, i, anrExceptionMessage, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void dumpAnrReason(String str, int i, AnrExceptionMessage anrExceptionMessage, boolean z) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR dumpAnrReason tracePath=" + str + " index=" + i + " dirReady=" + z);
        com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
        try {
            File file = getInstance().mLogDir;
            final StringBuilder sb = new StringBuilder();
            Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.2
                @Override // android.util.Printer
                public final void println(String str2) {
                    StringBuilder sb2 = StringBuilder.this;
                    sb2.append(str2);
                    sb2.append("\n");
                }
            }, "");
            anrExceptionMessage.mMessageQueueDetail = sb.substring(0, sb.length() - 1);
            String jSONObject = anrExceptionMessage.toJson().toString();
            StringBuilder sb2 = new StringBuilder();
            getInstance();
            sb2.append(FILE_NAME_BASE);
            sb2.append("-");
            sb2.append(i);
            sb2.append(".dump");
            File file2 = new File(file, sb2.toString());
            if (z) {
                StringBuilder sb3 = new StringBuilder();
                getInstance();
                sb3.append(FILE_NAME_BASE);
                sb3.append("-");
                sb3.append(i);
                sb3.append(".msg");
                File file3 = new File(file, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(FILE_NAME_BASE);
                sb4.append("-");
                sb4.append(i);
                sb4.append(".minfo");
                File file4 = new File(file, sb4.toString());
                g.a(file3, jSONObject);
                getInstance().backupLogFiles(file);
                if (uploader != null) {
                    new StringBuilder(ANR_HAPPENED_BEGIN).append(anrExceptionMessage);
                }
                g.a(uploader, TAG, file2);
                getInstance().uploadRemainingExceptions();
                g.C(file4);
            } else if (uploader != null) {
                if (str != null) {
                    uploader.a(anrExceptionMessage, null);
                }
                new StringBuilder(ANR_HAPPENED_BEGIN).append(anrExceptionMessage);
            }
            StringBuilder sb5 = new StringBuilder();
            getInstance();
            sb5.append(FILE_NAME_BASE);
            sb5.append("-");
            sb5.append(i);
            sb5.append(".anr");
            getAnrReason(str, new File(file, sb5.toString()));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            if (uploader != null) {
                g.k(th);
            }
        }
    }

    private static void getAnrReason(String str, final File file) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR getAnrReason");
        if (str == null) {
            com.kwad.sdk.utils.g.schedule(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getAnrReasonInner(null, File.this);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } else {
            getAnrReasonInner(str, file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getAnrReasonInner(String str, File file) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo;
        com.kwad.sdk.core.d.b.d(TAG, "ANR getAnrReasonInner");
        com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
        if (str != null) {
            try {
                long lastModified = new File(str).lastModified();
                if (Math.abs(lastModified - sLastTime) < 10000) {
                    return;
                }
                sLastTime = lastModified;
            } catch (Throwable th) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) e.zy().getContext().getSystemService("activity");
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 = null;
        if (activityManager == null) {
            return;
        }
        int i = 0;
        while (true) {
            processErrorStateInfo = processErrorStateInfo2;
            if (i >= 20) {
                break;
            }
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo3 = processErrorStateInfo2;
            if (processesInErrorState != null) {
                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                do {
                    processErrorStateInfo3 = processErrorStateInfo2;
                    if (!it.hasNext()) {
                        break;
                    }
                    processErrorStateInfo3 = it.next();
                } while (processErrorStateInfo3.condition != 2);
            }
            processErrorStateInfo = processErrorStateInfo3;
            if (processErrorStateInfo3 != null) {
                break;
            }
            Thread.sleep(500L);
            i++;
            processErrorStateInfo2 = processErrorStateInfo3;
        }
        if (processErrorStateInfo == null) {
            return;
        }
        if (processErrorStateInfo.pid != MY_PID) {
            if (uploader != null) {
                new StringBuilder("other process anr:\n").append(processErrorStateInfo.shortMsg);
                return;
            }
            return;
        }
        AnrReason anrReason = new AnrReason();
        anrReason.mTag = processErrorStateInfo.tag;
        anrReason.mShortMsg = processErrorStateInfo.shortMsg;
        anrReason.mLongMsg = processErrorStateInfo.longMsg;
        g.a(file, anrReason.toJson().toString());
    }

    public static AnrHandler getInstance() {
        return a.arr;
    }

    public static native void install(String str, int i);

    public static void onCallFromNative(int i) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR onCallFromNative index=" + i);
        dumpAnr(null, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceFileWritten(String str) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            dumpAnr(str, this.mIndex.getAndIncrement());
        }
    }

    private boolean parseTraceFile(String str) {
        BufferedReader bufferedReader;
        int i;
        boolean z = false;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        i = -1;
                        if (readLine != null) {
                            if (PID_PATTERN.matcher(readLine).matches()) {
                                i = Integer.parseInt(readLine.split("\\s")[2]);
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (FileNotFoundException e) {
                        bufferedReader2 = bufferedReader;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (IOException e2) {
                        bufferedReader2 = bufferedReader;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (Throwable th) {
                        bufferedReader2 = bufferedReader;
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        throw th;
                    }
                }
                if (i == MY_PID) {
                    z = true;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException | IOException e3) {
            bufferedReader = null;
        }
    }

    private void watchTraceFile() {
        com.kwad.sdk.core.d.b.d(TAG, "ANR watchTraceFile");
        FileObserver fileObserver = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
                }
            }
        };
        this.mTraceFileObserver = fileObserver;
        try {
            fileObserver.startWatching();
        } catch (Throwable th) {
            getInstance().getUploader();
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 3;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.b.zi()) {
            com.kwad.sdk.core.d.b.d(TAG, "ANR init");
            this.mLogDir = file;
            if (!this.mLogDir.exists()) {
                this.mLogDir.mkdirs();
            }
            File file2 = new File(this.mLogDir, FILE_NAME_BASE);
            if (!DUMP_FROM_SIG_QUIT) {
                watchTraceFile();
                return;
            }
            try {
                install(file2.getPath(), Build.VERSION.SDK_INT);
            } catch (Throwable th) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(getUploader());
        int length = fileArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            bVar.a(fileArr[i2], countDownLatch);
            i = i2 + 1;
        }
    }
}
